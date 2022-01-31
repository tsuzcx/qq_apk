package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSBoringView
  extends View
  implements IView<PTSNodeView>
{
  private PTSNodeView mNode;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
  
  public PTSBoringView(PTSNodeView paramPTSNodeView)
  {
    super(paramPTSNodeView.getContext());
    this.mNode = paramPTSNodeView;
    this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.mNode);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public PTSNodeView getNode()
  {
    return this.mNode;
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSBoringView
 * JD-Core Version:    0.7.0.1
 */