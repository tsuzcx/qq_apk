package com.tencent.plato.sdk.render;

import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.ColorUtils;
import com.tencent.plato.sdk.widget.CustomTextView;

public class PTextView
  extends PView
{
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    this.view = new CustomTextView(paramIPlatoRuntime.getContext());
    this.id = paramElementItem.getElementId();
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    super.setStyles(paramIReadableMap);
    if (this.view == null) {
      return;
    }
    CustomTextView localCustomTextView = (CustomTextView)this.view;
    localCustomTextView.setText(paramIReadableMap.getString("text", ""));
    localCustomTextView.setTextSize(paramIReadableMap.getInt("fontSize", 12));
    int i = paramIReadableMap.getInt("maxLines", -1);
    String str = paramIReadableMap.getString("ellipsize", "");
    if (i >= 0) {
      localCustomTextView.setMaxLines(i);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (str.equals("start")) {
        localCustomTextView.setEllipsize(TextUtils.TruncateAt.START);
      }
    }
    else
    {
      label106:
      if (!paramIReadableMap.getBoolean("bold", false)) {
        break label201;
      }
      localCustomTextView.setTypeface(null, 1);
    }
    for (;;)
    {
      paramIReadableMap = paramIReadableMap.getString("color", "#404040");
      if (TextUtils.isEmpty(paramIReadableMap)) {
        break;
      }
      localCustomTextView.setTextColor(ColorUtils.parseColor(paramIReadableMap));
      return;
      if (str.equals("end"))
      {
        localCustomTextView.setEllipsize(TextUtils.TruncateAt.END);
        break label106;
      }
      if (str.equals("middle"))
      {
        localCustomTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        break label106;
      }
      localCustomTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
      break label106;
      label201:
      localCustomTextView.setTypeface(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PTextView
 * JD-Core Version:    0.7.0.1
 */