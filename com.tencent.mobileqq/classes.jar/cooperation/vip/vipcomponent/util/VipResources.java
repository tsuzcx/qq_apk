package cooperation.vip.vipcomponent.util;

import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.HashMap;
import java.util.Map;

public class VipResources
{
  public static final HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(2), "qzone_ys_haohua");
    a.put(Integer.valueOf(3), "qzone_ys_haohua_guan");
    a.put(Integer.valueOf(4), "qzone_ys_huangzuan_guan");
    a.put(Integer.valueOf(5), "qzone_ys_huangzuan_guan_gq");
    a.put(Integer.valueOf(6), "qzone_ys_huangzuan_gq");
    a.put(Integer.valueOf(7), "qzone_annualvip_icon");
    a.put(Integer.valueOf(8), "qzone_annualvip_gray");
    a.put(Integer.valueOf(9), "qzone_ys_huangzuan_gq_nianfei_level1");
    a.put(Integer.valueOf(10), "qzone_ys_huangzuan_gq_nianfei_level2");
    a.put(Integer.valueOf(11), "qzone_ys_huangzuan_gq_nianfei_level3");
    a.put(Integer.valueOf(12), "qzone_ys_huangzuan_gq_nianfei_level4");
    a.put(Integer.valueOf(13), "qzone_ys_huangzuan_gq_nianfei_level5");
    a.put(Integer.valueOf(14), "qzone_ys_huangzuan_gq_nianfei_level6");
    a.put(Integer.valueOf(15), "qzone_ys_huangzuan_gq_nianfei_level7");
    a.put(Integer.valueOf(16), "qzone_ys_huangzuan_gq_nianfei_level8");
    a.put(Integer.valueOf(17), "qzone_ys_huangzuan_gq_nianfei_level9");
    a.put(Integer.valueOf(18), "qzone_ys_huangzuan_gq_level1");
    a.put(Integer.valueOf(19), "qzone_ys_huangzuan_gq_level2");
    a.put(Integer.valueOf(20), "qzone_ys_huangzuan_gq_level3");
    a.put(Integer.valueOf(21), "qzone_ys_huangzuan_gq_level4");
    a.put(Integer.valueOf(22), "qzone_ys_huangzuan_gq_level5");
    a.put(Integer.valueOf(23), "qzone_ys_huangzuan_gq_level6");
    a.put(Integer.valueOf(24), "qzone_ys_huangzuan_gq_level7");
    a.put(Integer.valueOf(25), "qzone_ys_huangzuan_gq_level8");
    a.put(Integer.valueOf(26), "qzone_ys_huangzuan_gq_level9");
    a.put(Integer.valueOf(27), "qzone_ys_nianfei_level1");
    a.put(Integer.valueOf(28), "qzone_ys_nianfei_level2");
    a.put(Integer.valueOf(29), "qzone_ys_nianfei_level3");
    a.put(Integer.valueOf(30), "qzone_ys_nianfei_level4");
    a.put(Integer.valueOf(31), "qzone_ys_nianfei_level5");
    a.put(Integer.valueOf(32), "qzone_ys_nianfei_level6");
    a.put(Integer.valueOf(33), "qzone_ys_nianfei_level7");
    a.put(Integer.valueOf(34), "qzone_ys_nianfei_level8");
    a.put(Integer.valueOf(35), "qzone_ys_nianfei_level9");
    a.put(Integer.valueOf(36), "qzone_ys_huangzuan_level1");
    a.put(Integer.valueOf(37), "qzone_ys_huangzuan_level2");
    a.put(Integer.valueOf(38), "qzone_ys_huangzuan_level3");
    a.put(Integer.valueOf(39), "qzone_ys_huangzuan_level4");
    a.put(Integer.valueOf(40), "qzone_ys_huangzuan_level5");
    a.put(Integer.valueOf(41), "qzone_ys_huangzuan_level6");
    a.put(Integer.valueOf(42), "qzone_ys_huangzuan_level7");
    a.put(Integer.valueOf(43), "qzone_ys_huangzuan_level8");
    a.put(Integer.valueOf(44), "qzone_ys_huangzuan_level9");
    a.put(Integer.valueOf(46), "qzone_icon_star_vip_king");
    a.put(Integer.valueOf(47), "qzone_icon_star_vip_king_gray");
    a.put(Integer.valueOf(48), "qzone_icon_star_vip_gray");
    a.put(Integer.valueOf(49), "qz_icon_star_vip_high");
    a.put(Integer.valueOf(50), "qz_icon_star_vip_high_gray");
    a.put(Integer.valueOf(51), "qz_icon_star_vip_high_king");
    a.put(Integer.valueOf(52), "qz_icon_star_vip_high_king_gray");
    a.put(Integer.valueOf(53), "qzone_icon_star_vip_lv1_year");
    a.put(Integer.valueOf(54), "qzone_icon_star_vip_lv2_year");
    a.put(Integer.valueOf(55), "qzone_icon_star_vip_lv3_year");
    a.put(Integer.valueOf(56), "qzone_icon_star_vip_lv4_year");
    a.put(Integer.valueOf(57), "qzone_icon_star_vip_lv5_year");
    a.put(Integer.valueOf(58), "qzone_icon_star_vip_lv6_year");
    a.put(Integer.valueOf(59), "qzone_icon_star_vip_lv7_year");
    a.put(Integer.valueOf(60), "qzone_icon_star_vip_lv8_year");
    a.put(Integer.valueOf(61), "qzone_icon_star_vip_lv1_normal");
    a.put(Integer.valueOf(62), "qzone_icon_star_vip_lv2_normal");
    a.put(Integer.valueOf(63), "qzone_icon_star_vip_lv3_normal");
    a.put(Integer.valueOf(64), "qzone_icon_star_vip_lv4_normal");
    a.put(Integer.valueOf(65), "qzone_icon_star_vip_lv5_normal");
    a.put(Integer.valueOf(66), "qzone_icon_star_vip_lv6_normal");
    a.put(Integer.valueOf(67), "qzone_icon_star_vip_lv7_normal");
    a.put(Integer.valueOf(68), "qzone_icon_star_vip_lv8_normal");
    a.put(Integer.valueOf(69), "qzone_icon_star_vip_lv1_year_gray");
    a.put(Integer.valueOf(70), "qzone_icon_star_vip_lv2_year_gray");
    a.put(Integer.valueOf(71), "qzone_icon_star_vip_lv3_year_gray");
    a.put(Integer.valueOf(72), "qzone_icon_star_vip_lv4_year_gray");
    a.put(Integer.valueOf(73), "qzone_icon_star_vip_lv5_year_gray");
    a.put(Integer.valueOf(74), "qzone_icon_star_vip_lv6_year_gray");
    a.put(Integer.valueOf(75), "qzone_icon_star_vip_lv7_year_gray");
    a.put(Integer.valueOf(76), "qzone_icon_star_vip_lv8_year_gray");
    a.put(Integer.valueOf(77), "qzone_icon_star_vip_lv1_gray");
    a.put(Integer.valueOf(78), "qzone_icon_star_vip_lv2_gray");
    a.put(Integer.valueOf(79), "qzone_icon_star_vip_lv3_gray");
    a.put(Integer.valueOf(80), "qzone_icon_star_vip_lv4_gray");
    a.put(Integer.valueOf(81), "qzone_icon_star_vip_lv5_gray");
    a.put(Integer.valueOf(82), "qzone_icon_star_vip_lv6_gray");
    a.put(Integer.valueOf(83), "qzone_icon_star_vip_lv7_gray");
    a.put(Integer.valueOf(84), "qzone_icon_star_vip_lv8_gray");
    a.put(Integer.valueOf(85), "qzone_widget_vip_nianpai_lv1");
    a.put(Integer.valueOf(86), "qzone_widget_vip_nianpai_lv2");
    a.put(Integer.valueOf(87), "qzone_widget_vip_nianpai_lv3");
    a.put(Integer.valueOf(88), "qzone_widget_vip_nianpai_lv4");
    a.put(Integer.valueOf(89), "qzone_widget_vip_nianpai_lv5");
    a.put(Integer.valueOf(90), "qzone_widget_vip_nianpai_lv6");
    a.put(Integer.valueOf(91), "qzone_widget_vip_nianpai_lv7");
    a.put(Integer.valueOf(92), "qzone_widget_vip_nianpai_lv8");
    a.put(Integer.valueOf(93), "qzone_widget_vip_nianpai_lv9");
    a.put(Integer.valueOf(94), "qzone_widget_vip_lv1");
    a.put(Integer.valueOf(95), "qzone_widget_vip_lv2");
    a.put(Integer.valueOf(96), "qzone_widget_vip_lv3");
    a.put(Integer.valueOf(97), "qzone_widget_vip_lv4");
    a.put(Integer.valueOf(98), "qzone_widget_vip_lv5");
    a.put(Integer.valueOf(99), "qzone_widget_vip_lv6");
    a.put(Integer.valueOf(100), "qzone_widget_vip_lv7");
    a.put(Integer.valueOf(101), "qzone_widget_vip_lv8");
    a.put(Integer.valueOf(102), "qzone_widget_vip_lv9");
    a.put(Integer.valueOf(103), "qzone_icon_star_vip_sidai_year_lv1");
    a.put(Integer.valueOf(104), "qzone_icon_star_vip_sidai_year_lv2");
    a.put(Integer.valueOf(105), "qzone_icon_star_vip_sidai_year_lv3");
    a.put(Integer.valueOf(106), "qzone_icon_star_vip_sidai_year_lv4");
    a.put(Integer.valueOf(107), "qzone_icon_star_vip_sidai_year_lv5");
    a.put(Integer.valueOf(108), "qzone_icon_star_vip_sidai_year_lv6");
    a.put(Integer.valueOf(109), "qzone_icon_star_vip_sidai_year_lv7");
    a.put(Integer.valueOf(110), "qzone_icon_star_vip_sidai_year_lv8");
    a.put(Integer.valueOf(111), "qzone_icon_star_vip_sidai_lv1");
    a.put(Integer.valueOf(112), "qzone_icon_star_vip_sidai_lv2");
    a.put(Integer.valueOf(113), "qzone_icon_star_vip_sidai_lv3");
    a.put(Integer.valueOf(114), "qzone_icon_star_vip_sidai_lv4");
    a.put(Integer.valueOf(115), "qzone_icon_star_vip_sidai_lv5");
    a.put(Integer.valueOf(116), "qzone_icon_star_vip_sidai_lv6");
    a.put(Integer.valueOf(117), "qzone_icon_star_vip_sidai_lv7");
    a.put(Integer.valueOf(118), "qzone_icon_star_vip_sidai_lv8");
    a.put(Integer.valueOf(119), "qzone_icon_lv9_winds");
    a.put(Integer.valueOf(120), "qzone_icon_lv9_winds_gray");
    a.put(Integer.valueOf(121), "qzone_icon_lv9_guan");
    a.put(Integer.valueOf(122), "qzone_icon_lv9_guan_gray");
  }
  
  public static Drawable a(int paramInt1, int paramInt2, ZipResLoadListener paramZipResLoadListener)
  {
    if (a.containsKey(Integer.valueOf(paramInt1))) {
      return ZipResDownloadManager.a().c("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone_vip_icon/qzone_yellow_icon_v8.zip", paramInt2, (String)a.get(Integer.valueOf(paramInt1)), paramZipResLoadListener);
    }
    if (paramInt1 != 1) {
      return null;
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130851282);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3, ZipResLoadListener paramZipResLoadListener)
  {
    return a(paramString, paramInt1, paramInt2, paramInt3, paramZipResLoadListener, 0);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3, ZipResLoadListener paramZipResLoadListener, int paramInt4)
  {
    if (paramInt4 != 0)
    {
      if (paramInt4 == 1) {
        ZipResDownloadManager.a().c(paramString, paramInt1, "border", paramZipResLoadListener);
      }
    }
    else {
      switch (paramInt3)
      {
      default: 
        break;
      case 7: 
        ZipResDownloadManager localZipResDownloadManager = ZipResDownloadManager.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bottom_lv");
        localStringBuilder.append(paramInt2);
        return localZipResDownloadManager.c(paramString, paramInt1, localStringBuilder.toString(), paramZipResLoadListener);
      case 5: 
      case 6: 
      case 8: 
        return ZipResDownloadManager.a().c(paramString, paramInt1, "right", paramZipResLoadListener);
      case 4: 
        return ZipResDownloadManager.a().c(paramString, paramInt1, "head", paramZipResLoadListener);
      }
    }
    return null;
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, ZipResLoadListener paramZipResLoadListener)
  {
    String str = a(paramInt1, paramInt3, paramBoolean, paramInt4);
    if (!TextUtils.isEmpty(str)) {
      return ZipResDownloadManager.a().a(paramString, paramInt2, str, true, paramZipResLoadListener);
    }
    return null;
  }
  
  public static QQUnionIconInfo a(int paramInt1, int paramInt2)
  {
    String str = null;
    if (paramInt2 <= 0) {
      return null;
    }
    QQUnionIconInfo localQQUnionIconInfo = new QQUnionIconInfo();
    int i = -1;
    switch (paramInt1)
    {
    default: 
      paramInt2 = -1;
      paramInt1 = i;
      break;
    case 7: 
      str = QzoneConfig.getInstance().getConfig("H5Url", "union_vip_widget_url", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/widget/LV{level}.png").replace("{level}", String.valueOf(paramInt2));
      paramInt1 = 49;
      paramInt2 = 50;
      break;
    case 5: 
    case 6: 
    case 8: 
      str = QzoneConfig.getInstance().getConfig("H5Url", "union_vip_feed_icon_url", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/feedaz/lv{level}.zip").replace("{level}", String.valueOf(paramInt2));
      paramInt1 = 94;
      paramInt2 = 44;
      break;
    case 4: 
      str = QzoneConfig.getInstance().getConfig("H5Url", "union_vip_head_icon_url", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/headaz/lv{level}.zip").replace("{level}", String.valueOf(paramInt2));
      paramInt1 = 52;
      paramInt2 = 54;
    }
    localQQUnionIconInfo.mIconUrl = str;
    localQQUnionIconInfo.mIconWidth = paramInt1;
    localQQUnionIconInfo.mIconHeight = paramInt2;
    return localQQUnionIconInfo;
  }
  
  public static QQUnionIconInfo a(int paramInt1, int paramInt2, Map<String, QQUnionIconInfo> paramMap)
  {
    if (paramMap != null) {
      switch (paramInt1)
      {
      default: 
        break;
      case 7: 
        paramMap = (QQUnionIconInfo)paramMap.get("widget_icon");
        break;
      case 5: 
      case 6: 
      case 8: 
        paramMap = (QQUnionIconInfo)paramMap.get("feed_icon");
        break;
      case 4: 
        paramMap = (QQUnionIconInfo)paramMap.get("head_icon");
        break;
      }
    }
    paramMap = null;
    Object localObject;
    if ((paramMap != null) && (!TextUtils.isEmpty(paramMap.mIconUrl)) && (paramMap.mIconWidth > 0))
    {
      localObject = paramMap;
      if (paramMap.mIconHeight > 0) {}
    }
    else
    {
      paramMap = new StringBuilder();
      paramMap.append("current getQQUnionVipUrl = null use default location = ");
      paramMap.append(paramInt1);
      QZLog.i("QQUnionVip", 1, paramMap.toString());
      localObject = a(paramInt1, paramInt2);
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUnionIconInfo)localObject).mIconUrl)) && (((QQUnionIconInfo)localObject).mIconUrl.contains("{platform}"))) {
      ((QQUnionIconInfo)localObject).mIconUrl = ((QQUnionIconInfo)localObject).mIconUrl.replace("{platform}", "az");
    }
    return localObject;
  }
  
  public static QQUnionIconInfo a(int paramInt, UserClientShowInfo paramUserClientShowInfo)
  {
    if (paramUserClientShowInfo == null) {
      return null;
    }
    return a(paramInt, paramUserClientShowInfo.iLevel, QQUnionIconInfo.convertToQQUnionIconMap(paramUserClientShowInfo.mapIconInfo));
  }
  
  public static String a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    Object localObject1;
    switch (paramInt3)
    {
    default: 
      return "";
    case 5: 
    case 6: 
    case 8: 
      if (paramInt1 == 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append("svip_feed_lv");
        ((StringBuilder)localObject1).append(paramInt2);
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("vip_feed_lv");
      ((StringBuilder)localObject1).append(paramInt2);
      return ((StringBuilder)localObject1).toString();
    }
    if (paramInt1 == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("svip_widget_lv");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("vip_widget_lv");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (paramBoolean)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("nian");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ZipResDownloadManager.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.VipResources
 * JD-Core Version:    0.7.0.1
 */