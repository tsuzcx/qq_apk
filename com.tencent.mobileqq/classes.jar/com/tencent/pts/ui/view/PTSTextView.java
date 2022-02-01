package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSTextView
  extends TextView
  implements IView
{
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSTextView(PTSNodeText paramPTSNodeText)
  {
    super(paramPTSNodeText.getContext());
    setTextSize(16.0F);
    setTextColor(-16777216);
    setIncludeFontPadding(false);
    setEllipsize(TextUtils.TruncateAt.END);
    getPaint().setAntiAlias(true);
    setGravity(16);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSTextView
 * JD-Core Version:    0.7.0.1
 */