package com.tencent.ttpic.videoshelf.model.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.libpag.PagUtil;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import com.tencent.view.FilterContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

public class PagVideoShelfProcessor
  implements SurfaceTexture.OnFrameAvailableListener, IVideoShelfProcessor
{
  private static final int MAX_FRAME_PER = 25;
  public static final String PAG_CONTENT_OBJ = "PagVideoShelfProcessor_1";
  public static final String PAG_FILE_DURATION = "PagVideoShelfProcessor_3";
  public static final String PAG_FILE_PATH = "PagVideoShelfProcessor_0";
  public static final String PAG_IMG_LIST = "PagVideoShelfProcessor_4";
  public static final String PAG_RENDER_OBJ = "PagVideoShelfProcessor_2";
  private static final float PER_FRAME_GAP = 40000.0F;
  private static final String TAG = "PagVideoShelfProcessor";
  private BaseFilter copyFilter = new SurfaceTextureFilter();
  private int mDrawCount = 0;
  private long mDuration = 0L;
  private FilterContext mFilterContext;
  private float mFrameGap;
  private int mGetFpsCount = 0;
  private double mLastFlushProgress = -1.0D;
  private boolean mNeedUpdateFrame = false;
  private Frame mOutFrame;
  private PAGFile mPagFile;
  private String mPagFilePath;
  private PAGRenderer mPagRenderer;
  private PAGSurface mPagSurface;
  private int mParsedTxtID;
  private double mProgress = 0.0D;
  private HashMap<String, int[]> mReplaceImgs;
  private SurfaceTexture mSurfaceTexture;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public PagVideoShelfProcessor()
  {
    if (PagUtil.isSupportPagForVideo()) {
      return;
    }
    throw new PagNotSupportSystemException("PagVideoShelfProcessor");
  }
  
  private long getDuration()
  {
    if (this.mDuration == 0L)
    {
      Object localObject = this.mPagFile;
      if (localObject != null)
      {
        this.mDuration = ((PAGFile)localObject).duration();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("duration:");
        ((StringBuilder)localObject).append(this.mDuration);
        TTPTLogger.i("PagVideoShelfProcessor", ((StringBuilder)localObject).toString());
        long l = this.mDuration;
        float f;
        if (l > 0L) {
          f = 40000.0F / (float)l;
        } else {
          f = 0.0F;
        }
        this.mFrameGap = f;
      }
    }
    return this.mDuration;
  }
  
  private void parseImageText(List<NodeGroup> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
        while (localIterator2.hasNext())
        {
          NodeItem localNodeItem = (NodeItem)localIterator2.next();
          if (localNodeItem.type == 1) {
            paramList = localNodeItem.bitmap;
          } else {
            paramList = localNodeItem.cropBitmap;
          }
          replacesImg(paramList, localNodeItem.indexLayerForPag);
        }
      }
    }
  }
  
  private void proceeHashMapSetting(HashMap<String, int[]> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.mPagRenderer == null)
    {
      this.mReplaceImgs = paramHashMap;
      return;
    }
    this.mReplaceImgs = paramHashMap;
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      Bitmap localBitmap = BitmapUtils.decodeSampledBitmapFromFile((String)localEntry.getKey(), 1080, 1080);
      replacesImg(localBitmap, (int[])localEntry.getValue());
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
  
  private void replacesImg(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    try
    {
      if ((this.mPagRenderer != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramArrayOfInt != null))
      {
        paramBitmap = PAGImage.FromBitmap(paramBitmap);
        paramBitmap.setScaleMode(3);
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          if (k < this.mPagFile.numImages()) {
            this.mPagRenderer.replaceImage(k, paramBitmap);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void clear()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clear:");
    ((StringBuilder)localObject).append(this.mProgress);
    TTPTLogger.i("PagVideoShelfProcessor", ((StringBuilder)localObject).toString());
    this.mFilterContext = null;
    localObject = this.mPagRenderer;
    if (localObject != null) {
      ((PAGRenderer)localObject).setSurface(null);
    }
    localObject = this.mPagSurface;
    if (localObject != null) {
      ((PAGSurface)localObject).freeCache();
    }
    localObject = this.mSurfaceTexture;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    this.mParsedTxtID = 0;
    localObject = this.copyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSL();
    }
    this.mProgress = 0.0D;
    this.mLastFlushProgress = -1.0D;
    this.mNeedUpdateFrame = false;
    this.mDrawCount = 0;
    this.mGetFpsCount = 0;
  }
  
  public Frame draw()
  {
    if (this.mPagRenderer == null) {
      return null;
    }
    if (this.mNeedUpdateFrame)
    {
      this.mOutFrame = this.copyFilter.RenderProcess(this.mParsedTxtID, this.mVideoWidth, this.mVideoHeight);
      GLES20.glFinish();
      this.mNeedUpdateFrame = false;
      this.mDrawCount += 1;
      return this.mOutFrame;
    }
    return null;
  }
  
  public long getCurFrameTimeStamp()
  {
    double d1 = this.mProgress;
    double d2 = this.mDuration;
    Double.isNaN(d2);
    return (d1 * d2 * 0.001D);
  }
  
  public int getProgress()
  {
    int i = (int)(this.mProgress * 100.0D);
    if (i > 1) {
      return i;
    }
    return 1;
  }
  
  public void init(int[] paramArrayOfInt, List<VideoFrameItem> paramList, List<NodeGroup> paramList1)
  {
    TTPTLogger.i("PagVideoShelfProcessor", "init.");
    this.mParsedTxtID = paramArrayOfInt[0];
    this.copyFilter.apply();
    this.mSurfaceTexture = new SurfaceTexture(this.mParsedTxtID);
    this.mSurfaceTexture.setDefaultBufferSize(this.mVideoWidth, this.mVideoHeight);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mPagSurface = PAGSurface.FromSurfaceTexture(this.mSurfaceTexture);
    this.mPagRenderer.setSurface(this.mPagSurface);
    this.mPagRenderer.setMaxFrameRate(25.0F);
    parseImageText(paramList1);
    proceeHashMapSetting(this.mReplaceImgs);
    if (this.mPagFile != null)
    {
      this.mDuration = getDuration();
      this.mPagRenderer.setFile(this.mPagFile);
      this.mPagRenderer.setProgress(0.0D);
    }
  }
  
  public int isPrepareInit()
  {
    this.mPagFile = PAGFile.Load(this.mPagFilePath);
    PAGFile localPAGFile = this.mPagFile;
    if (localPAGFile != null)
    {
      int i = localPAGFile.tagLevel();
      localPAGFile = this.mPagFile;
      if (i > PAGFile.MaxSupportedTagLevel()) {
        return 2;
      }
      this.mPagRenderer = new PAGRenderer();
      if (AEOfflineConfig.isNeedSoftDecode()) {
        PagUtil.useSoftDecode();
      }
      return 0;
    }
    return 1;
  }
  
  public boolean makeCurrent()
  {
    FilterContext localFilterContext = this.mFilterContext;
    if (localFilterContext != null)
    {
      localFilterContext.usecurruntContext();
      return true;
    }
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (makeCurrent())
    {
      paramSurfaceTexture = this.mSurfaceTexture;
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.updateTexImage();
        this.mNeedUpdateFrame = true;
      }
    }
  }
  
  public int parseFrame()
  {
    if ((!this.mNeedUpdateFrame) && (this.mDrawCount == this.mGetFpsCount) && (this.mProgress > this.mLastFlushProgress))
    {
      boolean bool = this.mPagRenderer.flush();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseFrame:flush:");
      localStringBuilder.append(this.mProgress);
      Log.i("PagVideoShelfProcessor", localStringBuilder.toString());
      if (!bool) {
        this.mNeedUpdateFrame = true;
      }
      this.mLastFlushProgress = this.mProgress;
    }
    return 0;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    int i = paramString.hashCode();
    if (i != -1549738368)
    {
      switch (i)
      {
      default: 
        break;
      case -148748542: 
        if (!paramString.equals("PagVideoShelfProcessor_4")) {
          break;
        }
        i = 5;
        break;
      case -148748543: 
        if (!paramString.equals("PagVideoShelfProcessor_3")) {
          break;
        }
        i = 4;
        break;
      case -148748544: 
        if (!paramString.equals("PagVideoShelfProcessor_2")) {
          break;
        }
        i = 3;
        break;
      case -148748545: 
        if (!paramString.equals("PagVideoShelfProcessor_1")) {
          break;
        }
        i = 2;
        break;
      case -148748546: 
        if (!paramString.equals("PagVideoShelfProcessor_0")) {
          break;
        }
        i = 0;
        break;
      }
    }
    else if (paramString.equals("outVideoWidthHeight"))
    {
      i = 1;
      break label149;
    }
    i = -1;
    label149:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              if (paramObject == null) {
                return;
              }
              if ((paramObject instanceof HashMap))
              {
                paramString = (HashMap)paramObject;
                if (paramString == null) {
                  return;
                }
                proceeHashMapSetting(paramString);
              }
            }
            else if ((paramObject != null) && ((paramObject instanceof Long)))
            {
              this.mDuration = ((Long)paramObject).longValue();
              long l = this.mDuration;
              float f;
              if (l > 0L) {
                f = 40000.0F / (float)l;
              } else {
                f = 0.0F;
              }
              this.mFrameGap = f;
            }
          }
          else if ((paramObject != null) && ((paramObject instanceof PAGRenderer)))
          {
            this.mPagRenderer = ((PAGRenderer)paramObject);
            if (AEOfflineConfig.isNeedSoftDecode()) {
              PagUtil.useSoftDecode();
            }
            paramString = this.mPagSurface;
            if (paramString != null) {
              this.mPagRenderer.setSurface(paramString);
            }
            this.mProgress = this.mPagRenderer.getProgress();
          }
        }
        else if ((paramObject != null) && ((paramObject instanceof FilterContext))) {
          this.mFilterContext = ((FilterContext)paramObject);
        }
      }
      else if ((paramObject != null) && ((paramObject instanceof int[])))
      {
        paramString = (int[])paramObject;
        this.mVideoWidth = paramString[0];
        this.mVideoHeight = paramString[1];
      }
    }
    else if ((paramObject instanceof String)) {
      this.mPagFilePath = ((String)paramObject);
    }
  }
  
  public boolean updateFrameCursor()
  {
    if (!this.mNeedUpdateFrame)
    {
      int i = this.mDrawCount;
      int j = this.mGetFpsCount;
      if (i > j)
      {
        double d1 = this.mProgress;
        if (d1 < 1.0D)
        {
          double d2 = this.mFrameGap;
          Double.isNaN(d2);
          this.mProgress = (d1 + d2);
          this.mGetFpsCount = (j + 1);
          Object localObject = this.mOutFrame;
          if (localObject != null) {
            ((Frame)localObject).unlock();
          }
          localObject = this.mPagRenderer;
          if (localObject != null)
          {
            d1 = this.mProgress;
            if (d1 <= 1.0D)
            {
              ((PAGRenderer)localObject).setProgress(d1);
              return true;
            }
          }
        }
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor
 * JD-Core Version:    0.7.0.1
 */