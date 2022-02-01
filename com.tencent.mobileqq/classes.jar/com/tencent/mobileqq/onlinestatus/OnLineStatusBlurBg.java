package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.DecorViewHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class OnLineStatusBlurBg
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<OnLineStatusBlurBg.OnLineStatusBlurBgListener> jdField_a_of_type_MqqUtilWeakReference;
  
  private void a(@NonNull OnLineStatusBlurBg.BlurBgItem paramBlurBgItem, Bitmap paramBitmap, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManagerV2.postImmediately(new OnLineStatusBlurBg.1(this, paramBlurBgItem, paramBitmap, paramInt1, paramInt2, paramString), null, false);
  }
  
  public void a(@NonNull OnLineStatusBlurBg.BlurBgItem paramBlurBgItem, OnLineStatusBlurBg.OnLineStatusBlurBgListener paramOnLineStatusBlurBgListener)
  {
    if ((paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (paramOnLineStatusBlurBgListener != null))
    {
      int i;
      if ((!"1103".equals(QQTheme.a())) && (!"2920".equals(QQTheme.a()))) {
        i = 0;
      } else {
        i = 1;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        if (i != 0) {
          i = paramBlurBgItem.c;
        } else {
          i = paramBlurBgItem.jdField_a_of_type_Int;
        }
        paramOnLineStatusBlurBgListener.a(false, null, i);
        return;
      }
      if (i != 0) {
        i = paramBlurBgItem.c;
      } else {
        i = paramBlurBgItem.b;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getActivityName());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        paramOnLineStatusBlurBgListener.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
        return;
      }
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnLineStatusBlurBgListener);
      a(paramBlurBgItem, DecorViewHelper.a(paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), DecorViewHelper.a(paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), (String)localObject, i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusBlurBg", 4, "startBlurBg activity or listener is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg
 * JD-Core Version:    0.7.0.1
 */