package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import bgho;
import bgjw;
import bhbg;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;

public class AppBrandPageContainer$3$1
  implements Runnable
{
  public AppBrandPageContainer$3$1(bhbg parambhbg, bgjw parambgjw) {}
  
  public void run()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bgjw != null) && (this.jdField_a_of_type_Bgjw.c(this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString)))
    {
      localObject = (AppBrandPageContainer)this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        if (!"navigateTo".equals(this.jdField_a_of_type_Bhbg.b)) {
          break label70;
        }
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString, -1);
      }
    }
    label70:
    do
    {
      do
      {
        do
        {
          return;
          if ("redirectTo".equals(this.jdField_a_of_type_Bhbg.b))
          {
            ((AppBrandPageContainer)localObject).b(this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString, -1);
            return;
          }
          if ("appLaunch".equals(this.jdField_a_of_type_Bhbg.b))
          {
            ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString, "appLaunch");
            return;
          }
        } while (!"reLaunch".equals(this.jdField_a_of_type_Bhbg.b));
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString, "reLaunch");
        return;
        QMLog.e("minisdk-start-AppBrandPageContainer", "Page not found." + this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangString);
      } while ((this.jdField_a_of_type_Bgjw == null) || (this.jdField_a_of_type_Bgjw.a == null));
      localObject = this.jdField_a_of_type_Bgjw.a.entryPagePath;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Bgjw.c((String)localObject)))
      {
        ((AppBrandPageContainer)this.jdField_a_of_type_Bhbg.jdField_a_of_type_JavaLangRefWeakReference.get()).a((String)localObject, "appLaunch");
        return;
      }
    } while ((AppBrandPageContainer.a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer) == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a() == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().isFinishing()));
    AppBrandPageContainer.a(this.jdField_a_of_type_Bhbg.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.3.1
 * JD-Core Version:    0.7.0.1
 */