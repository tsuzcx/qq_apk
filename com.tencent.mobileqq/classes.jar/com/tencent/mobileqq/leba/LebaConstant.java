package com.tencent.mobileqq.leba;

import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LebaConstant
{
  public static final String a;
  public static HashMap<Long, String> b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=");
    localStringBuilder.append(Base64Util.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0));
    a = localStringBuilder.toString();
    b = new HashMap();
    b.put(Long.valueOf(1047L), "biz_src_qqmusic");
    b.put(Long.valueOf(5362L), "biz_src_zz_dianjing");
    b.put(Long.valueOf(1113L), "biz_src_zz_bodong");
    b.put(Long.valueOf(3053L), "biz_src_zf_dongtai_qianbao");
    b.put(Long.valueOf(763L), "biz_src_zf_dongtai_qianbao");
    b.put(Long.valueOf(883L), "biz_src_zf_dongtai_qianbao");
    b.put(Long.valueOf(4559L), "biz_src_zf_sport");
    b.put(Long.valueOf(826L), "biz_src_feeds_buluo");
    b.put(Long.valueOf(489L), "biz_src_zf_games");
    b.put(Long.valueOf(879L), "biz_src_hdsp_dtzbj");
    b.put(Long.valueOf(769L), "biz_src_jc_neirong");
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
      if (!paramRedTouch.c()) {
        return 0;
      }
      List localList = paramRedTouch.getRedTypeInfo();
      if (localList != null)
      {
        if (localList.isEmpty()) {
          return 0;
        }
        int i = paramRedTouch.getOuterRedType();
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
  
  public static boolean a()
  {
    boolean bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    return (((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQCircleEnter(bool)) && (!QQTheme.isNowSimpleUI()) && (!bool);
  }
  
  public static int b()
  {
    if (a()) {
      return 2;
    }
    return 1;
  }
  
  public static int b(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return 0;
    }
    if ((paramRedTouch.M != null) && (paramRedTouch.M.getVisibility() == 0)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaConstant
 * JD-Core Version:    0.7.0.1
 */