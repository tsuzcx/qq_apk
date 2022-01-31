package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import bayf;
import bayk;
import com.tencent.mobileqq.app.QQAppInterface;

public final class NearbyVideoUtils$3
  implements Runnable
{
  public NearbyVideoUtils$3(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      bayk localbayk = new bayk();
      localbayk.a = true;
      localbayk.i = this.jdField_a_of_type_JavaLangString;
      localbayk.b = 64;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtils.3
 * JD-Core Version:    0.7.0.1
 */