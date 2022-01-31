package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSTextView
  extends TextView
  implements IView<PTSNodeText>
{
  private PTSNodeText mNode;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
  
  public PTSTextView(PTSNodeText paramPTSNodeText)
  {
    super(paramPTSNodeText.getContext());
    this.mNode = paramPTSNodeText;
    this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.mNode);
    setTextSize(16.0F);
    setLineSpacing(PTSValueConvertUtil.dp2px(3.2F), 1.0F);
    setTextColor(-16777216);
    setIncludeFontPadding(false);
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public PTSNodeText getNode()
  {
    return this.mNode;
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSTextView
 * JD-Core Version:    0.7.0.1
 */