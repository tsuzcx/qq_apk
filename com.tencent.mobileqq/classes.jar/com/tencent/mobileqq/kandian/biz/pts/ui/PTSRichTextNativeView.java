package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;

public class PTSRichTextNativeView
  extends TextView
  implements IView
{
  private TruncateAttr truncateAttr;
  
  public PTSRichTextNativeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSRichTextNativeView(PTSNodeRichText paramPTSNodeRichText)
  {
    super(paramPTSNodeRichText.getContext());
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    TruncateAttr localTruncateAttr = this.truncateAttr;
    if (localTruncateAttr != null)
    {
      RichTextUtils.addEllipsis2Text(this, localTruncateAttr);
      RichTextUtils.adjustImageSpan(this, this.truncateAttr);
    }
  }
  
  public void setTruncateAttr(TruncateAttr paramTruncateAttr)
  {
    this.truncateAttr = paramTruncateAttr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSRichTextNativeView
 * JD-Core Version:    0.7.0.1
 */