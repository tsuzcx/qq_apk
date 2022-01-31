package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import bdcz;
import bdfx;
import bdml;
import bdnw;
import bduv;
import java.lang.ref.WeakReference;

public class AppBrandPageContainer$3$1
  implements Runnable
{
  public AppBrandPageContainer$3$1(bduv parambduv, bdfx parambdfx) {}
  
  public void run()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bdfx != null) && (this.jdField_a_of_type_Bdfx.c(this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString)))
    {
      localObject = (AppBrandPageContainer)this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        if (!"navigateTo".equals(this.jdField_a_of_type_Bduv.b)) {
          break label69;
        }
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString);
      }
    }
    label69:
    do
    {
      do
      {
        do
        {
          return;
          if ("redirectTo".equals(this.jdField_a_of_type_Bduv.b))
          {
            ((AppBrandPageContainer)localObject).c(this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString);
            return;
          }
          if ("appLaunch".equals(this.jdField_a_of_type_Bduv.b))
          {
            ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString, "appLaunch");
            return;
          }
        } while (!"reLaunch".equals(this.jdField_a_of_type_Bduv.b));
        ((AppBrandPageContainer)localObject).a(this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString, "reLaunch");
        return;
        bdnw.d("AppBrandPageContainer", "Page not found." + this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangString);
      } while ((this.jdField_a_of_type_Bdfx == null) || (this.jdField_a_of_type_Bdfx.a == null));
      localObject = this.jdField_a_of_type_Bdfx.a.jdField_a_of_type_JavaLangString;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Bdfx.c((String)localObject)))
      {
        ((AppBrandPageContainer)this.jdField_a_of_type_Bduv.jdField_a_of_type_JavaLangRefWeakReference.get()).a((String)localObject, "appLaunch");
        return;
      }
    } while ((AppBrandPageContainer.a(this.jdField_a_of_type_Bduv.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer) == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bduv.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a() == null) || (AppBrandPageContainer.a(this.jdField_a_of_type_Bduv.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().isFinishing()));
    AppBrandPageContainer.a(this.jdField_a_of_type_Bduv.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer).a().moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.3.1
 * JD-Core Version:    0.7.0.1
 */