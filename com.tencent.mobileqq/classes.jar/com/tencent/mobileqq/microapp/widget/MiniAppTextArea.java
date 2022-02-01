package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.EditText;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;

public class MiniAppTextArea
  extends EditText
{
  public MiniAppTextArea(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt, JSONObject paramJSONObject, WebviewContainer paramWebviewContainer)
  {
    setBackgroundDrawable(null);
    setSingleLine(false);
    setHorizontallyScrolling(false);
    setInputType(131073);
    setFocusable(true);
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("style");
    if (paramJSONObject.optBoolean("disabled")) {
      setInputType(0);
    }
    if (paramJSONObject.optBoolean("hidden")) {
      setVisibility(8);
    }
    if (paramJSONObject.optBoolean("confirm")) {
      setImeOptions(6);
    }
    int i = paramJSONObject.optInt("maxLength");
    if (i != -1) {
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
    }
    String str = paramJSONObject.optString("placeholder");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("placeholderStyle");
    if (!StringUtil.a(str))
    {
      setHint(str);
      setHintTextColor(Color.parseColor(localJSONObject2.optString("color")));
    }
    if ("left".equals(localJSONObject1.optString("textAlign"))) {
      setGravity(3);
    }
    addTextChangedListener(new c(this, localJSONObject2, localJSONObject1, paramInt, paramWebviewContainer, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.MiniAppTextArea
 * JD-Core Version:    0.7.0.1
 */