package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public abstract class FrameSourceItem
{
  private static final String TAG = "FrameSourceItem";
  protected BaseFilter filter;
  
  public FrameSourceItem(BaseFilter paramBaseFilter)
  {
    this.filter = paramBaseFilter;
  }
  
  public abstract void clear();
  
  public void draw(Frame paramFrame, CanvasItem paramCanvasItem, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("[draw]");
    BenchUtil.benchStart(((StringBuilder)localObject).toString());
    int i = getTexture(paramCanvasItem, paramLong);
    localObject = AlgoUtils.calPositions(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramFrame.width, paramFrame.height, paramCanvasItem.itemResizeMode);
    paramCanvasItem = AlgoUtils.calTexCords(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramCanvasItem.itemResizeMode);
    this.filter.setPositions((float[])localObject);
    this.filter.setTexCords(paramCanvasItem);
    paramCanvasItem = new StringBuilder();
    paramCanvasItem.append(this.filter.getClass().getSimpleName());
    paramCanvasItem.append("[draw]");
    BenchUtil.benchStart(paramCanvasItem.toString());
    this.filter.OnDrawFrameGLSL();
    this.filter.renderTexture(i, paramFrame.width, paramFrame.height);
    paramFrame = new StringBuilder();
    paramFrame.append(this.filter.getClass().getSimpleName());
    paramFrame.append("[draw]");
    BenchUtil.benchEnd(paramFrame.toString());
    paramFrame = new StringBuilder();
    paramFrame.append(getClass().getSimpleName());
    paramFrame.append("[draw]");
    BenchUtil.benchEnd(paramFrame.toString());
  }
  
  public abstract int getOrigHeight(int paramInt);
  
  public abstract int getOrigWidth(int paramInt);
  
  public abstract int getTexture(CanvasItem paramCanvasItem, long paramLong);
  
  public abstract void init();
  
  public abstract void reset();
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.FrameSourceItem
 * JD-Core Version:    0.7.0.1
 */