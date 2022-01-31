package com.tencent.pts.ui.vnode;

import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.view.PTSTextView;
import com.tencent.pts.utils.PTSValueConvertUtil;

public class PTSNodeText
  extends PTSNodeVirtual<PTSTextView>
{
  private final String STYLE_ITALIC = "italic";
  private final String WEIGHT_BOLD = "bold";
  private final String WEIGHT_LIGHTER = "lighter";
  private final String WEIGHT_NORMAL = "normal";
  
  private PTSNodeText(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public void bindExtra(PTSNodeInfo paramPTSNodeInfo)
  {
    super.bindExtra(paramPTSNodeInfo);
    PTSTextView localPTSTextView = (PTSTextView)getView();
    if (TextUtils.isEmpty(paramPTSNodeInfo.getContent())) {}
    for (paramPTSNodeInfo = "";; paramPTSNodeInfo = paramPTSNodeInfo.getContent().trim())
    {
      localPTSTextView.setText(paramPTSNodeInfo);
      return;
    }
  }
  
  public PTSTextView initView()
  {
    return new PTSTextView(this);
  }
  
  public void resetAll()
  {
    PTSTextView localPTSTextView = (PTSTextView)getView();
    localPTSTextView.setText("");
    localPTSTextView.setTextSize(16.0F);
    localPTSTextView.setTypeface(null, 0);
    localPTSTextView.setMaxLines(2147483647);
    localPTSTextView.setLineSpacing(PTSValueConvertUtil.dp2px(3.2F), 1.0F);
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    if (super.setStyle(paramString, paramObject)) {}
    do
    {
      return true;
      if ("font-size".equalsIgnoreCase(paramString))
      {
        ((PTSTextView)getView()).setTextSize(0, PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getFontSize()));
        return true;
      }
      if ("color".equalsIgnoreCase(paramString))
      {
        ((PTSTextView)getView()).setTextColor(PTSValueConvertUtil.getColor(paramObject));
        return true;
      }
      if (!"font-style".equalsIgnoreCase(paramString)) {
        break;
      }
    } while (!"italic".equals(PTSValueConvertUtil.getString(paramObject)));
    ((PTSTextView)getView()).setTypeface(null, 2);
    return true;
    if ("font-weight".equalsIgnoreCase(paramString))
    {
      paramString = PTSValueConvertUtil.getString(paramObject);
      paramObject = ((PTSTextView)getView()).getPaint();
      paramObject.setStyle(Paint.Style.FILL_AND_STROKE);
      if ("bold".equalsIgnoreCase(paramString))
      {
        paramObject.setStrokeWidth(1.5F);
        return true;
      }
      if (("lighter".equalsIgnoreCase(paramString)) || ("normal".equalsIgnoreCase(paramString)))
      {
        paramObject.setStrokeWidth(0.0F);
        return true;
      }
      paramObject.setStrokeWidth(0.0F);
      return true;
    }
    int i;
    if ("-webkit-line-clamp".equalsIgnoreCase(paramString))
    {
      i = PTSValueConvertUtil.getInt(paramObject);
      if (i > 0) {
        break label276;
      }
      i = 1;
    }
    label276:
    for (;;)
    {
      ((PTSTextView)getView()).setMaxLines(i);
      ((PTSTextView)getView()).setEllipsize(TextUtils.TruncateAt.END);
      return true;
      if ("line-height".equalsIgnoreCase(paramString))
      {
        float f = PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getLineSpacing());
        ((PTSTextView)getView()).setLineSpacing(f, 1.0F);
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeText
 * JD-Core Version:    0.7.0.1
 */