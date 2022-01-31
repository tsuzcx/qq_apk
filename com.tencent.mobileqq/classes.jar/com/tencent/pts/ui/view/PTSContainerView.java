package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSContainerView
  extends FrameLayout
  implements IView<PTSNodeContainer>
{
  private PTSNodeContainer mNode;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
  
  public PTSContainerView(PTSNodeContainer paramPTSNodeContainer)
  {
    super(paramPTSNodeContainer.getContext());
    this.mNode = paramPTSNodeContainer;
    this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.mNode);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public PTSNodeContainer getNode()
  {
    return this.mNode;
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSContainerView
 * JD-Core Version:    0.7.0.1
 */