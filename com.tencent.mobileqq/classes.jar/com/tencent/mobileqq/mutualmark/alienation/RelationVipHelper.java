package com.tencent.mobileqq.mutualmark.alienation;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.RelationVipGrayBean;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class RelationVipHelper
{
  private static RelationVipHelper a;
  
  public static RelationVipHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RelationVipHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MutualMarkConfProcessor.a().f);
    ((StringBuilder)localObject).append("/vas/");
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (paramInt == 0) {
        return localObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("_");
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    RelationVipGrayBean localRelationVipGrayBean = (RelationVipGrayBean)QConfigManager.a().a(490);
    if ((localRelationVipGrayBean != null) && (localRelationVipGrayBean.jdField_a_of_type_JavaUtilHashMap != null)) {
      return (String)localRelationVipGrayBean.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt == 0) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      String str1 = paramString.substring(0, i + 1);
      if (str1.length() < 4) {
        return paramString;
      }
      Object localObject = str1.substring(str1.length() - 4, str1.length() - 3);
      String str2 = str1.substring(str1.length() - 3, str1.length() - 2);
      if ((((String)localObject).equals(String.valueOf(paramInt))) && (str2.equals("_"))) {
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("_");
      if (paramBoolean) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(paramString.substring(i));
      str1 = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("originUrl:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" appendUrl:");
        ((StringBuilder)localObject).append(str1);
        QLog.d("appendVasUrl", 2, ((StringBuilder)localObject).toString());
      }
      return str1;
    }
    return paramString;
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new RelationVipHelper.1(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = AIOUtils.b(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, RelationVipGrayBean paramRelationVipGrayBean)
  {
    if ((paramRelationVipGrayBean != null) && (!TextUtils.isEmpty(paramRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
    {
      int i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
      if ((paramMutualMarkForDisplayInfo.h > 0L) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 6L))
      {
        if (TextUtils.isEmpty(paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString)) {
          paramQQAppInterface = paramMutualMarkForDisplayInfo.c;
        } else {
          paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
        }
        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = a(paramQQAppInterface, i, true);
      }
      else if ((i > 0) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long > 0L))
      {
        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = a(5L, i, paramMutualMarkForDisplayInfo.jdField_b_of_type_Long, true);
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("iconApngUrl:");
        paramQQAppInterface.append(paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.append(" sub_level:");
        paramQQAppInterface.append(paramMutualMarkForDisplayInfo.h);
        paramQQAppInterface.append(" level:");
        paramQQAppInterface.append(paramMutualMarkForDisplayInfo.jdField_b_of_type_Long);
        QLog.d("RelationVipHelper", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo)
  {
    if ((paramQQAppInterface != null) && (paramMutualMarkForDisplayInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      RelationVipGrayBean localRelationVipGrayBean = (RelationVipGrayBean)QConfigManager.a().a(490);
      int i = (int)paramMutualMarkForDisplayInfo.a;
      if (i != 1)
      {
        String str = "svip";
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 12) {
                if (i != 26) {
                  if (i != 19) {
                    if (i == 20) {}
                  }
                }
              }
              for (;;)
              {
                return;
                if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L)
                {
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
                }
                else if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L)
                {
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
                }
                else if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 3L)
                {
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
                  continue;
                  i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
                  if ((i == 1) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
                  }
                  else if ((i == 2) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
                  }
                  else if ((i == 3) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
                  }
                  else if ((i == 4) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
                    continue;
                    if (localRelationVipGrayBean != null)
                    {
                      TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString);
                      continue;
                      if ((localRelationVipGrayBean != null) && (!TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
                      {
                        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                        if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L)
                        {
                          if (i == 2)
                          {
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                          }
                          else if (i == 1)
                          {
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                          }
                        }
                        else if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L) {
                          if (i == 2)
                          {
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                          }
                          else if (i == 1)
                          {
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            a(paramQQAppInterface, paramString, paramMutualMarkForDisplayInfo, localRelationVipGrayBean);
            return;
          }
          if ((localRelationVipGrayBean != null) && (!TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
          {
            i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
            if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 0L) && (i > 0))
            {
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
              paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
              if (i != 1) {
                str = "union_vip";
              }
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
              return;
            }
            if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
            {
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
              paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
              if (i != 1) {
                str = "union_vip";
              }
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
              return;
            }
            if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L) && (i > 0))
            {
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
              paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
              if (i != 1) {
                str = "union_vip";
              }
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
            }
          }
        }
        else if ((localRelationVipGrayBean != null) && (!TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
        {
          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
          if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
            paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
            if (i != 1) {
              str = "union_vip";
            }
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
            return;
          }
          if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
            paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
            if (i != 1) {
              str = "union_vip";
            }
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
            return;
          }
          if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L) && (i > 0))
          {
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
            paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
            if (i != 1) {
              str = "union_vip";
            }
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.replace("{vip}", str);
          }
        }
      }
      else if ((localRelationVipGrayBean != null) && (!TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
      {
        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
        if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 0L) && (i > 0))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
          return;
        }
        if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
          return;
        }
        if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L) && (i > 0))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    RelationVipGrayBean localRelationVipGrayBean = (RelationVipGrayBean)QConfigManager.a().a(490);
    return (localRelationVipGrayBean != null) && (localRelationVipGrayBean.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper
 * JD-Core Version:    0.7.0.1
 */