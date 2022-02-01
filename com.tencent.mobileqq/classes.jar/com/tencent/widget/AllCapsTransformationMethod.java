package com.tencent.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class AllCapsTransformationMethod
  implements TransformationMethod2
{
  private static final String TAG = "AllCapsTransformationMethod";
  private boolean mEnabled;
  private Locale mLocale;
  
  public AllCapsTransformationMethod(Context paramContext)
  {
    this.mLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (this.mEnabled)
    {
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.mLocale);
      }
      return null;
    }
    QLog.w("AllCapsTransformationMethod", 2, "Caller did not enable length changes; not transforming text");
    return paramCharSequence;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
  
  public void setLengthChangesAllowed(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AllCapsTransformationMethod
 * JD-Core Version:    0.7.0.1
 */