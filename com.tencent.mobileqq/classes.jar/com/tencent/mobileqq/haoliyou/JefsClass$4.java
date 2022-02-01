package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import com.tencent.mobileqq.bigbrother.DownloadListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

class JefsClass$4
  implements DownloadListener
{
  JefsClass$4(JefsClass paramJefsClass, Runnable paramRunnable, WeakReference paramWeakReference, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((!paramBoolean1) || ((paramBoolean2) && (this.jdField_a_of_type_JavaLangRunnable != null)))
    {
      JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    paramString1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramString1 = "";; paramString1 = this.jdField_a_of_type_JavaLangString)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramString1, "");
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangRunnable != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.4
 * JD-Core Version:    0.7.0.1
 */