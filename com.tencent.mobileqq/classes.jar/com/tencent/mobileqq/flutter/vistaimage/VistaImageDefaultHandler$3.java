package com.tencent.mobileqq.flutter.vistaimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import rx.functions.Func1;

class VistaImageDefaultHandler$3
  implements Func1<String, Drawable>
{
  VistaImageDefaultHandler$3(VistaImageDefaultHandler paramVistaImageDefaultHandler, String paramString) {}
  
  public Drawable a(String paramString)
  {
    try
    {
      paramString = BaseApplication.getContext();
      int i = paramString.getResources().getIdentifier(this.a, "drawable", paramString.getPackageName());
      if (Build.VERSION.SDK_INT < 22) {
        return paramString.getResources().getDrawable(i);
      }
      paramString = paramString.getResources().getDrawable(i, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadDrawable] load drawable failed, ");
      localStringBuilder.append(this.a);
      QLog.w("VistaImageDefaultHandler", 1, localStringBuilder.toString(), paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageDefaultHandler.3
 * JD-Core Version:    0.7.0.1
 */