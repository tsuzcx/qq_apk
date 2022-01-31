package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import begz;
import bejy;
import bequ;
import besl;
import bfbd;
import java.lang.ref.WeakReference;

public class AppBrandPageContainer$3$1
  implements Runnable
{
  public AppBrandPageContainer$3$1(bfbd parambfbd, bejy parambejy) {}
  
  public void run()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bejy != null) && (this.jdField_a_of_type_Bejy.c(this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString)))
    {
      localObject = (AppBrandPageContainer)this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        if (!"navigateTo".equals(this.jdField_a_of_type_Bfbd.b)) {
          break label70;
        }
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString, -1);
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
          if ("redirectTo".equals(this.jdField_a_of_type_Bfbd.b))
          {
            ((AppBrandPageContainer)localObject).b(this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString, -1);
            return;
          }
          if ("appLaunch".equals(this.jdField_a_of_type_Bfbd.b))
          {
            ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString, "appLaunch");
            return;
          }
        } while (!"reLaunch".equals(this.jdField_a_of_type_Bfbd.b));
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString, "reLaunch");
        return;
        besl.d("AppBrandPageContainer", "Page not found." + this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangString);
      } while ((this.jdField_a_of_type_Bejy == null) || (this.jdField_a_of_type_Bejy.a == null));
      localObject = this.jdField_a_of_type_Bejy.a.jdField_a_of_type_JavaLangString;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Bejy.c((String)localObject)))
      {
        ((AppBrandPageContainer)this.jdField_a_of_type_Bfbd.jdField_a_of_type_JavaLangRefWeakReference.get()).a((String)localObject, "appLaunch");
        return;
      }
    } while ((AppBrandPageContainer.a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer) == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a() == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().isFinishing()));
    AppBrandPageContainer.a(this.jdField_a_of_type_Bfbd.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.3.1
 * JD-Core Version:    0.7.0.1
 */