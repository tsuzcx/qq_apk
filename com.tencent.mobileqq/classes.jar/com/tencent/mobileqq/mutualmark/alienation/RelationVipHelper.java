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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new RelationVipHelper();
      }
      return a;
    }
    finally {}
  }
  
  public static String a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    String str = MutualMarkConfProcessor.a().f + "/vas/";
    if ((TextUtils.isEmpty(str)) || (paramInt == 0)) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(str).append(paramInt).append("_").append(paramLong1).append("_").append(paramLong2).append("_");
    if (paramBoolean) {}
    for (str = "1";; str = "0") {
      return str + ".png";
    }
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
    if ((TextUtils.isEmpty(paramString)) || (paramInt == 0)) {}
    int i;
    do
    {
      do
      {
        return paramString;
        i = paramString.lastIndexOf("/");
        str = paramString.substring(0, i + 1);
      } while (str.length() < 4);
      localObject1 = str.substring(str.length() - 4, str.length() - 3);
      localObject2 = str.substring(str.length() - 3, str.length() - 2);
    } while ((((String)localObject1).equals(String.valueOf(paramInt))) && (((String)localObject2).equals("_")));
    Object localObject1 = new StringBuilder();
    Object localObject2 = ((StringBuilder)localObject1).append(str).append(paramInt).append("_");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      ((StringBuilder)localObject2).append(str).append(paramString.substring(i));
      str = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("appendVasUrl", 2, "originUrl:" + paramString + " appendUrl:" + str);
      }
      return str;
    }
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new RelationVipHelper.1(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = AIOUtils.a(21.0F, paramResources);
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
    int i;
    if ((paramRelationVipGrayBean != null) && (!TextUtils.isEmpty(paramRelationVipGrayBean.jdField_b_of_type_JavaLangString)))
    {
      i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
      if ((paramMutualMarkForDisplayInfo.h <= 0L) || (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 6L)) {
        break label145;
      }
      if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString)) {
        break label137;
      }
      paramQQAppInterface = paramMutualMarkForDisplayInfo.c;
    }
    for (paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = a(paramQQAppInterface, i, true);; paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = a(5L, i, paramMutualMarkForDisplayInfo.jdField_b_of_type_Long, true)) {
      label137:
      label145:
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("RelationVipHelper", 2, "iconApngUrl:" + paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString + " sub_level:" + paramMutualMarkForDisplayInfo.h + " level:" + paramMutualMarkForDisplayInfo.jdField_b_of_type_Long);
        }
        return;
        paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
        break;
      } while ((i <= 0) || (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long <= 0L));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo)
  {
    if ((paramQQAppInterface == null) || (paramMutualMarkForDisplayInfo == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      int i;
      do
      {
        RelationVipGrayBean localRelationVipGrayBean;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localRelationVipGrayBean = (RelationVipGrayBean)QConfigManager.a().a(490);
                              switch ((int)paramMutualMarkForDisplayInfo.a)
                              {
                              default: 
                                return;
                              }
                            } while ((localRelationVipGrayBean == null) || (TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)));
                            i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                            if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 0L) || (i <= 0)) {
                              break;
                            }
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                            return;
                            a(paramQQAppInterface, paramString, paramMutualMarkForDisplayInfo, localRelationVipGrayBean);
                            return;
                          } while ((localRelationVipGrayBean == null) || (TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)));
                          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                          if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 1L) {
                            break;
                          }
                          if (i == 2)
                          {
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                            return;
                          }
                        } while (i != 1);
                        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                        return;
                      } while (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 2L);
                      if (i == 2)
                      {
                        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                        return;
                      }
                    } while (i != 1);
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                    return;
                    if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
                    {
                      paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
                      paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                      return;
                    }
                  } while ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 2L) || (i <= 0));
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                  return;
                } while ((localRelationVipGrayBean == null) || (TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)));
                i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
                if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 0L) && (i > 0))
                {
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
                  paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
                  if (i == 1) {}
                  for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                    return;
                  }
                }
                if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
                {
                  paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
                  paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
                  if (i == 1) {}
                  for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                  {
                    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                    return;
                  }
                }
              } while ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 2L) || (i <= 0));
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
              paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
              if (i == 1) {}
              for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
              {
                paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                return;
              }
            } while ((localRelationVipGrayBean == null) || (TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)));
            return;
          } while ((localRelationVipGrayBean == null) || (TextUtils.isEmpty(localRelationVipGrayBean.jdField_b_of_type_JavaLangString)));
          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
            paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
            paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 2L) || (i <= 0));
        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = localRelationVipGrayBean.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
        paramString = paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L))
        {
          paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 1L));
      paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 1L)
      {
        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long == 2L)
      {
        paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramMutualMarkForDisplayInfo.jdField_b_of_type_Long != 3L);
    paramMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
  
  public boolean a()
  {
    RelationVipGrayBean localRelationVipGrayBean = (RelationVipGrayBean)QConfigManager.a().a(490);
    return (localRelationVipGrayBean != null) && (localRelationVipGrayBean.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper
 * JD-Core Version:    0.7.0.1
 */