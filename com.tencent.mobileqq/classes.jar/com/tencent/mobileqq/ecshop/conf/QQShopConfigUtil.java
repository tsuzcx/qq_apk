package com.tencent.mobileqq.ecshop.conf;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/conf/QQShopConfigUtil;", "", "()V", "MIN_TAB_CHILDEVIEW_CNT", "", "QQ_SHOP_PA_TAB_ID", "TAG", "", "mNativePageIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabConfIsValid", "", "tabConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;", "verifyTabConfBean", "ecshopConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopConfigUtil
{
  public static final QQShopConfigUtil a;
  private static final ArrayList<Integer> a;
  
  static
  {
    QQShopConfigUtil localQQShopConfigUtil = new QQShopConfigUtil();
    jdField_a_of_type_ComTencentMobileqqEcshopConfQQShopConfigUtil = localQQShopConfigUtil;
    jdField_a_of_type_JavaUtilArrayList = (ArrayList)new QQShopConfigUtil.mNativePageIds.1(localQQShopConfigUtil);
  }
  
  private final boolean a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    if (AppSetting.a(paramTabConfBean.g) < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfigVerifyUtil", 2, "current qq version not support this tab item");
      }
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 1) && (!jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramTabConfBean.jdField_a_of_type_Int))))
    {
      QLog.i("ConfigVerifyUtil", 2, "native tab item illegal!");
      return false;
    }
    if (paramTabConfBean.jdField_b_of_type_Int == 0)
    {
      if (!StringUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString))
      {
        str = paramTabConfBean.jdField_b_of_type_JavaLangString;
        Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.jumpUrl");
        if (StringsKt.startsWith$default(str, "http", false, 2, null))
        {
          str = paramTabConfBean.jdField_b_of_type_JavaLangString;
          Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.jumpUrl");
          if (StringsKt.startsWith$default(str, "https", false, 2, null)) {
            break label133;
          }
        }
      }
      QLog.i("ConfigVerifyUtil", 2, "web tab item illegal!");
      return false;
    }
    label133:
    if ((paramTabConfBean.jdField_b_of_type_Int == 2) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramTabConfBean.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("ConfigVerifyUtil", 2, "miniapp tab item illegal!");
      return false;
    }
    String str = paramTabConfBean.e;
    Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorNormal");
    if (StringsKt.startsWith$default(str, "#", false, 2, null))
    {
      str = paramTabConfBean.f;
      Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorSelected");
      if (StringsKt.startsWith$default(str, "#", false, 2, null))
      {
        if (!StringUtil.a(paramTabConfBean.jdField_a_of_type_JavaLangString))
        {
          paramTabConfBean = paramTabConfBean.jdField_a_of_type_JavaLangString;
          Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "tabConfBean.name");
          if (paramTabConfBean != null)
          {
            int i;
            if (((CharSequence)StringsKt.trim((CharSequence)paramTabConfBean).toString()).length() == 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              return true;
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
          }
        }
        QLog.i("ConfigVerifyUtil", 2, "tab item name illegal!");
        return false;
      }
    }
    QLog.i("ConfigVerifyUtil", 2, "tab item color hex illegal!");
    return false;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull EcshopConfBean paramEcshopConfBean)
  {
    Intrinsics.checkParameterIsNotNull(paramEcshopConfBean, "ecshopConfBean");
    Object localObject = paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ecshopConfBean.tabConfs");
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EcshopConfBean.TabConfBean localTabConfBean = (EcshopConfBean.TabConfBean)((Iterator)localObject).next();
      try
      {
        QQShopConfigUtil localQQShopConfigUtil = jdField_a_of_type_ComTencentMobileqqEcshopConfQQShopConfigUtil;
        Intrinsics.checkExpressionValueIsNotNull(localTabConfBean, "tabConfBean");
        if (localQQShopConfigUtil.a(localTabConfBean)) {
          localArrayList.add(localTabConfBean);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("verify tabConfBean is wrong tabId = ");
        localStringBuilder.append(localTabConfBean.jdField_a_of_type_Int);
        QLog.e("ConfigVerifyUtil", 1, localStringBuilder.toString(), (Throwable)localException);
      }
    }
    if (localArrayList.size() < 2)
    {
      QLog.i("ConfigVerifyUtil", 2, "[initView] config is empty!");
      return false;
    }
    paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.conf.QQShopConfigUtil
 * JD-Core Version:    0.7.0.1
 */