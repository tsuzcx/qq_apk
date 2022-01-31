package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.Frame;
import com.tencent.ttpic.model.CameraActItem;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CaptureActItem;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FrameSourceItem;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SingleScoreActItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StarActItem;
import com.tencent.ttpic.model.TotalScoreActItem;
import com.tencent.ttpic.model.VideoActItem;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.ActUtil.FRAME_SOURCE_TYPE;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActFilters
{
  private static final String TAG = ActFilters.class.getSimpleName();
  private static Comparator<CanvasItem> actItemComparator = new Comparator()
  {
    public int compare(CanvasItem paramAnonymousCanvasItem1, CanvasItem paramAnonymousCanvasItem2)
    {
      return paramAnonymousCanvasItem1.zIndex - paramAnonymousCanvasItem2.zIndex;
    }
  };
  private String dataPath;
  private long duration;
  private FaceExpression faceExpression;
  private long lastUpdateIndex = 9223372036854775807L;
  private Frame mCanvasFrame = new Frame();
  private FrameBaseFilter mCopyFilter = new FrameBaseFilter();
  private AudioUtils.Player mPlayer;
  private FrameVideoFilter mVideoFilter = new FrameVideoFilter();
  private Map<Integer, FrameSourceItem> sourceItems;
  private long startUpdateTime = -1L;
  
  public ActFilters(FaceExpression paramFaceExpression, String paramString)
  {
    this.faceExpression = paramFaceExpression;
    this.duration = (Math.max(paramFaceExpression.frameDuration * paramFaceExpression.frames, 1.0D));
    this.dataPath = paramString;
    initFrameSourceItems(paramFaceExpression);
  }
  
  private void createAudioPlayer()
  {
    String str = this.dataPath + File.separator + "expression" + File.separator + this.faceExpression.audioID;
    if ((!TextUtils.isEmpty(str)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = AudioUtils.createPlayer(VideoGlobalContext.getContext(), str, false);
    }
  }
  
  private List<CanvasItem> getCanvasItems(List<CanvasItem> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {}
    for (;;)
    {
      return localArrayList;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CanvasItem localCanvasItem = (CanvasItem)paramList.next();
        if ((localCanvasItem.startTime <= paramLong) && (paramLong <= localCanvasItem.endTime)) {
          localArrayList.add(localCanvasItem);
        }
      }
    }
  }
  
  private void initFrameSourceItems(FaceExpression paramFaceExpression)
  {
    if (paramFaceExpression.canvasSize == null) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    if (paramFaceExpression.canvasSize.width * paramFaceExpression.canvasSize.height <= 0) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    this.sourceItems = new HashMap();
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAMERA.value), new CameraActItem(this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.VIDEO.value), new VideoActItem(this.dataPath + File.separator + "expression" + File.separator + paramFaceExpression.videoID, this.mVideoFilter));
    CaptureActItem localCaptureActItem = new CaptureActItem(paramFaceExpression.expressionList, this.dataPath, paramFaceExpression.scoreImageID, this.mCopyFilter);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAPTURE.value), localCaptureActItem);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.STAR_IMAGE.value), new StarActItem(paramFaceExpression.expressionList, this.dataPath, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.TOTAL_SCORE.value), new TotalScoreActItem(localCaptureActItem, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.SINGEL_SCORE.value), new SingleScoreActItem(localCaptureActItem, this.mCopyFilter));
  }
  
  private boolean needResize(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return (Float.compare(paramArrayOfFloat1[0], -1.0F) != 0) || (Float.compare(paramArrayOfFloat1[1], -1.0F) != 0) || (Float.compare(paramArrayOfFloat2[0], 0.0F) != 0) || (Float.compare(paramArrayOfFloat2[1], 0.0F) != 0);
  }
  
  private void render(long paramLong)
  {
    List localList = getCanvasItems(this.faceExpression.canvasItemList, paramLong);
    Collections.sort(localList, actItemComparator);
    int i = 0;
    while (i < localList.size())
    {
      CanvasItem localCanvasItem = (CanvasItem)localList.get(i);
      FrameSourceItem localFrameSourceItem = (FrameSourceItem)this.sourceItems.get(Integer.valueOf(localCanvasItem.type));
      if (((localFrameSourceItem instanceof StarActItem)) || ((!(localFrameSourceItem instanceof SingleScoreActItem)) && ((localFrameSourceItem instanceof StarActItem)))) {}
      localFrameSourceItem.draw(this.mCanvasFrame, localCanvasItem, paramLong);
      i += 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    this.mCopyFilter.ApplyGLSLFilter();
    this.mVideoFilter.ApplyGLSLFilter();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).init();
    }
    this.mCanvasFrame.bindFrame(-1, this.faceExpression.canvasSize.width, this.faceExpression.canvasSize.height, 0.0D);
  }
  
  public void clear()
  {
    this.mCopyFilter.clearGLSLSelf();
    this.mVideoFilter.clearGLSLSelf();
    this.mCanvasFrame.clear();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).clear();
    }
  }
  
  public void destroyAudio()
  {
    AudioUtils.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public Map<Integer, FrameSourceItem> getSourceItems()
  {
    return this.sourceItems;
  }
  
  public void reset(long paramLong)
  {
    this.startUpdateTime = paramLong;
    this.lastUpdateIndex = 9223372036854775807L;
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).reset();
    }
    createAudioPlayer();
    AudioUtils.startPlayer(this.mPlayer, true);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mCopyFilter.setRenderMode(paramInt);
    this.mVideoFilter.setRenderMode(paramInt);
  }
  
  public void setSourceItems(Map<Integer, FrameSourceItem> paramMap)
  {
    this.sourceItems = paramMap;
  }
  
  public Frame updateAndRender(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    if (this.startUpdateTime == -1L) {
      this.startUpdateTime = paramLong;
    }
    if (VideoPrefsUtil.getMaterialMute()) {
      destroyAudio();
    }
    int i;
    for (;;)
    {
      int j = (int)((paramLong - this.startUpdateTime) % this.duration / this.faceExpression.frameDuration);
      i = j;
      if (j < this.lastUpdateIndex)
      {
        reset(paramLong);
        i = 0;
      }
      this.lastUpdateIndex = i;
      Iterator localIterator = this.sourceItems.values().iterator();
      while (localIterator.hasNext()) {
        ((FrameSourceItem)localIterator.next()).update(paramFrame, i, paramList, paramList1, paramDouble, paramInt);
      }
      if (this.mPlayer == null)
      {
        createAudioPlayer();
        AudioUtils.seekPlayer(this.mPlayer, (int)((paramLong - this.startUpdateTime) % this.duration));
      }
    }
    this.mCanvasFrame.bindFrame(-1, this.mCanvasFrame.width, this.mCanvasFrame.height, 0.0D);
    render(i);
    paramList = ActUtil.calPositions(new Rect(0, 0, paramFrame.width, paramFrame.height), this.mCanvasFrame.width, this.mCanvasFrame.height, paramFrame.width, paramFrame.height, this.faceExpression.canvasResizeMode);
    paramList1 = ActUtil.calTexCords(new Rect(0, 0, paramFrame.width, paramFrame.height), this.mCanvasFrame.width, this.mCanvasFrame.height, this.faceExpression.canvasResizeMode);
    if (needResize(paramList, paramList1))
    {
      BenchUtil.benchStart(TAG + "[resize]");
      this.mCopyFilter.setPositions(paramList);
      this.mCopyFilter.setTexCords(paramList1);
      this.mCopyFilter.RenderProcess(this.mCanvasFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      BenchUtil.benchEnd(TAG + "[resize]");
      return paramFrame;
    }
    return this.mCanvasFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ActFilters
 * JD-Core Version:    0.7.0.1
 */