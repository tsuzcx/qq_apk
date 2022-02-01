package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VipWZRYTemplateHelper
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ProfileCardTemplateUtil.a());
    localStringBuilder.append("wzryTemplate/");
    return localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 0)
    {
      if ("cardWZ.zip".equals(paramString1))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(a());
        paramQQAppInterface.append("xydata.json");
        paramQQAppInterface = paramQQAppInterface.toString();
        VipWZRYTemplateConfig.a(paramQQAppInterface);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("onDownloadComplete, parseConfig ");
          paramString1.append(paramQQAppInterface);
          QLog.d("VipWZRYTemplateHelper", 2, paramString1.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onDownloadComplete failed, errorCode = ");
      paramQQAppInterface.append(paramInt);
      QLog.d("VipWZRYTemplateHelper", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(CallBacker paramCallBacker)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasQuickUpdateService.class, "");
    localIVasQuickUpdateService.addCallBacker(paramCallBacker);
    localIVasQuickUpdateService.downloadItem(15L, "cardWZ.zip", "ProfileCard");
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) || (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC);
  }
  
  public static boolean a(String paramString)
  {
    if ("cardWZ.zip".equals(paramString))
    {
      String str = a();
      paramString = new File(str, "xydata.json");
      if (VipWZRYTemplateConfig.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig == null) {
        VipWZRYTemplateConfig.a(paramString.getAbsolutePath());
      }
      if (VipWZRYTemplateConfig.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig != null)
      {
        paramString = new File(str, "logo.png");
        Object localObject1 = new File(str, "bgImage.jpg");
        Object localObject2 = new File(str, "shimmer_mask.png");
        File localFile1 = new File(str, "logo_bg.png");
        File localFile2 = new File(str, "font_chs.tff");
        File localFile3 = new File(str, "font_num.tff");
        File localFile4 = new File(str, "addIcon.png");
        boolean bool1;
        if ((paramString.exists()) && (((File)localObject1).exists()) && (((File)localObject2).exists()) && (localFile1.exists()) && (localFile2.exists()) && (localFile3.exists()) && (localFile4.exists())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject2 = VipWZRYTemplateConfig.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig;
        if (((VipWZRYTemplateConfig)localObject2).jdField_a_of_type_AndroidUtilSparseArray != null)
        {
          int i = 0;
          for (boolean bool2 = bool1; i < ((VipWZRYTemplateConfig)localObject2).jdField_a_of_type_AndroidUtilSparseArray.size(); bool2 = bool1)
          {
            paramString = (VipWZRYTemplateConfig.WZRYHonorItem)((VipWZRYTemplateConfig)localObject2).jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
            bool1 = bool2;
            if (paramString.a != null)
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramString.a.a))
              {
                localObject1 = paramString.a.a;
                paramString = (String)localObject1;
                if (((String)localObject1).contains("/")) {
                  paramString = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/"));
                }
                paramString = new File(str, paramString);
                if ((bool2) && (paramString.exists())) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            i += 1;
          }
          return bool2;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipWZRYTemplateHelper
 * JD-Core Version:    0.7.0.1
 */