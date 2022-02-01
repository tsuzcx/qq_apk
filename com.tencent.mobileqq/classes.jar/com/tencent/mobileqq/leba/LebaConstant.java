package com.tencent.mobileqq.leba;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaConstant
{
  public static final String a;
  public static HashMap<Long, String> a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=");
    localStringBuilder.append(Base64Util.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(1047L), "biz_src_qqmusic");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(5362L), "biz_src_zz_dianjing");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(1113L), "biz_src_zz_bodong");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(3053L), "biz_src_zf_dongtai_qianbao");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(763L), "biz_src_zf_dongtai_qianbao");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(883L), "biz_src_zf_dongtai_qianbao");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(4559L), "biz_src_zf_sport");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(826L), "biz_src_feeds_buluo");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(489L), "biz_src_zf_games");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(879L), "biz_src_hdsp_dtzbj");
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(769L), "biz_src_jc_neirong");
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    return 2;
  }
  
  public static int a(RedTouch paramRedTouch)
  {
    if (paramRedTouch != null)
    {
      if (!paramRedTouch.a()) {
        return 0;
      }
      List localList = paramRedTouch.a();
      if (localList != null)
      {
        if (localList.isEmpty()) {
          return 0;
        }
        int i = paramRedTouch.a();
        if (i == 16) {
          return 9;
        }
        if (i == 17) {
          return 10;
        }
        paramRedTouch = localList.iterator();
        do
        {
          if (!paramRedTouch.hasNext()) {
            break;
          }
          i = ((BusinessInfoCheckUpdate.RedTypeInfo)paramRedTouch.next()).red_type.get();
          if (i == 0) {
            return 1;
          }
          if (i == 5) {
            return 2;
          }
        } while (i != 11);
        return 3;
      }
    }
    return 0;
  }
  
  public static void a(ImageView paramImageView, AppRuntime paramAppRuntime)
  {
    a(paramImageView, ThemeUtil.isNowThemeIsNight(paramAppRuntime, false, null));
  }
  
  public static void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = ThemeUtil.NIGHTMODE_MASKCOLOR;
    } else {
      i = 0;
    }
    paramImageView.setColorFilter(i);
  }
  
  public static int b(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return 0;
    }
    if ((paramRedTouch.a != null) && (paramRedTouch.a.getVisibility() == 0)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaConstant
 * JD-Core Version:    0.7.0.1
 */