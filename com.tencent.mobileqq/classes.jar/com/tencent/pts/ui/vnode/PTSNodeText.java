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
    int j = 0;
    if (super.setStyle(paramString, paramObject)) {}
    label76:
    do
    {
      return true;
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return false;
          if (!paramString.equals("font-size")) {
            break label76;
          }
          i = 0;
          continue;
          if (!paramString.equals("color")) {
            break label76;
          }
          i = 1;
          continue;
          if (!paramString.equals("font-style")) {
            break label76;
          }
          i = 2;
          continue;
          if (!paramString.equals("font-weight")) {
            break label76;
          }
          i = 3;
          continue;
          if (!paramString.equals("-webkit-line-clamp")) {
            break label76;
          }
          i = 4;
          continue;
          if (!paramString.equals("line-height")) {
            break label76;
          }
          i = 5;
        }
      }
      ((PTSTextView)getView()).setTextSize(0, PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getFontSize()));
      return true;
      ((PTSTextView)getView()).setTextColor(PTSValueConvertUtil.getColor(paramObject));
      return true;
    } while (!"italic".equals(PTSValueConvertUtil.getString(paramObject)));
    ((PTSTextView)getView()).setTypeface(null, 2);
    return true;
    paramString = PTSValueConvertUtil.getString(paramObject);
    paramObject = ((PTSTextView)getView()).getPaint();
    paramObject.setStyle(Paint.Style.FILL_AND_STROKE);
    switch (paramString.hashCode())
    {
    default: 
      label340:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramObject.setStrokeWidth(0.0F);
        return true;
        if (!paramString.equals("bold")) {
          break label340;
        }
        i = j;
        continue;
        if (!paramString.equals("lighter")) {
          break label340;
        }
        i = 1;
        continue;
        if (!paramString.equals("normal")) {
          break label340;
        }
        i = 2;
      }
    }
    paramObject.setStrokeWidth(1.5F);
    return true;
    int i = PTSValueConvertUtil.getInt(paramObject);
    if (i <= 0) {
      i = 1;
    }
    for (;;)
    {
      ((PTSTextView)getView()).setMaxLines(i);
      ((PTSTextView)getView()).setEllipsize(TextUtils.TruncateAt.END);
      return true;
      float f = PTSValueConvertUtil.dp2px(getNodeInfo().getStyle().getLineSpacing());
      ((PTSTextView)getView()).setLineSpacing(f, 1.0F);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeText
 * JD-Core Version:    0.7.0.1
 */