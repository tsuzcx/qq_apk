package com.tencent.mobileqq.qrscan.activity;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class QRCardActivity$NumberSpan
  extends URLSpan
{
  public QRCardActivity$NumberSpan(QRCardActivity paramQRCardActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    String str = getURL();
    if (!TextUtils.isEmpty(str))
    {
      if (Pattern.compile("\\d{5,}").matcher(str).matches())
      {
        QRCardActivity.a(this.a, paramView.getContext(), 3, str, null);
        return;
      }
      if (Pattern.compile(QRCardActivity.E).matcher(str).matches()) {
        this.a.a(str);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.NumberSpan
 * JD-Core Version:    0.7.0.1
 */