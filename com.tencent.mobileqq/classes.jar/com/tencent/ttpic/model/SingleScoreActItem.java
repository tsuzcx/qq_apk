package com.tencent.ttpic.model;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.model.Rect;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;

public class SingleScoreActItem
  extends FrameSourceItem
{
  private static final String TAG = SingleScoreActItem.class.getSimpleName();
  private SizeI bitSize = new SizeI(130, 170);
  protected CaptureActItem captureActItem;
  
  public SingleScoreActItem(CaptureActItem paramCaptureActItem, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    this.captureActItem = paramCaptureActItem;
  }
  
  private List<Integer> getBitList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt > 0)
    {
      localArrayList.add(0, Integer.valueOf(paramInt % 10));
      paramInt /= 10;
    }
    if (localArrayList.isEmpty()) {
      localArrayList.add(Integer.valueOf(0));
    }
    return localArrayList;
  }
  
  private void updateNumPosition(BaseFilter paramBaseFilter, CanvasItem paramCanvasItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = paramCanvasItem.itemRect.height * 1.0F / this.bitSize.height;
    int i = (int)(this.bitSize.width * f);
    int j = (int)(f * this.bitSize.height);
    int k = (paramCanvasItem.itemRect.width - paramInt2 * i) / 2;
    paramInt2 = paramCanvasItem.itemRect.y + j;
    paramInt1 = paramCanvasItem.itemRect.x + i * paramInt1 + k;
    paramBaseFilter.setPositions(AlgoUtils.calPositions(paramInt1, paramInt2, i + paramInt1, paramInt2 - j, paramInt3, paramInt4));
  }
  
  public void clear() {}
  
  public void draw(Frame paramFrame, CanvasItem paramCanvasItem, long paramLong)
  {
    BenchUtil.benchStart(getClass().getSimpleName() + "[draw]");
    List localList = getBitList(getScore(paramCanvasItem));
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)localList.get(i)).intValue();
      BenchUtil.benchStart(getClass().getSimpleName() + "[draw] updatePosition");
      updateNumPosition(this.filter, paramCanvasItem, i, j, paramFrame.width, paramFrame.height);
      BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] updatePosition");
      BenchUtil.benchStart(getClass().getSimpleName() + "[draw] renderTexture");
      this.filter.OnDrawFrameGLSL();
      this.filter.renderTexture(getScoreTexture(paramCanvasItem)[k], paramFrame.width, paramFrame.height);
      BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] renderTexture");
      i += 1;
    }
    BenchUtil.benchEnd(getClass().getSimpleName() + "[draw]");
  }
  
  public int getOrigHeight(int paramInt)
  {
    return -1;
  }
  
  public int getOrigWidth(int paramInt)
  {
    return -1;
  }
  
  protected int getScore(CanvasItem paramCanvasItem)
  {
    return this.captureActItem.getScore(paramCanvasItem);
  }
  
  protected int[] getScoreTexture(CanvasItem paramCanvasItem)
  {
    return this.captureActItem.getScoreTexture(paramCanvasItem);
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return -1;
  }
  
  public void init() {}
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.SingleScoreActItem
 * JD-Core Version:    0.7.0.1
 */