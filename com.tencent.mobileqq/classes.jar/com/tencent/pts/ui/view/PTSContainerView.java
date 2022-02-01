package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSContainerView
  extends FrameLayout
  implements IView
{
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
    this.mRoundedCorner.drawBorder(paramCanvas);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSContainerView
 * JD-Core Version:    0.7.0.1
 */