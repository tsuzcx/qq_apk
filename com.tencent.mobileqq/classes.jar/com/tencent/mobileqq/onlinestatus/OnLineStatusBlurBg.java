package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if ((paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (paramOnLineStatusBlurBgListener == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusBlurBg", 4, "startBlurBg activity or listener is empty");
      }
      return;
    }
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      i = 1;
      if (Build.VERSION.SDK_INT > 20) {
        break label90;
      }
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (int i = paramBlurBgItem.c;; i = paramBlurBgItem.jdField_a_of_type_Int)
    {
      paramOnLineStatusBlurBgListener.a(false, null, i);
      return;
      i = 0;
      break;
    }
    label90:
    if (i != 0) {}
    String str;
    for (i = paramBlurBgItem.c;; i = paramBlurBgItem.b)
    {
      str = paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivityName() + "_" + i;
      if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      paramOnLineStatusBlurBgListener.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnLineStatusBlurBgListener);
    a(paramBlurBgItem, MultiAIOStarter.a(paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), MultiAIOStarter.a(paramBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg
 * JD-Core Version:    0.7.0.1
 */