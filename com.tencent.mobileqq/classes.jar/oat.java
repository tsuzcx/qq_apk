import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class oat
{
  private static int a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getExtValue pos->" + paramInt + " , VideoAdInfo:" + paramVideoAdInfo);
    }
    int i;
    if (paramVideoAdInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = b(paramVideoAdInfo.v, paramInt);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "getExtValue pos->" + paramInt + " , value:" + j);
    return j;
  }
  
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isWebBottomAutoPlay->BannerVideoAdData:" + paramProteusBannerVideoItemData);
    }
    int i;
    if (paramProteusBannerVideoItemData == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = a(paramProteusBannerVideoItemData.v, 3);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "isWebBottomAutoPlay->value:" + j);
    return j;
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isFeedsAutoPlay->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    int i;
    if (paramAdvertisementInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = b(paramAdvertisementInfo.mAdExtInfo, 2);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "isFeedsAutoPlay->value:" + j);
    return j;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchInt(" + paramInt + ")->switchStr:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {}
    do
    {
      return -1;
      try
      {
        paramInt = Integer.parseInt(paramString.substring(paramInt - 1, paramInt));
        return paramInt;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    paramString.printStackTrace();
    return -1;
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchFromExtra(" + paramInt + ")->extraData:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      for (;;)
      {
        return -1;
        try
        {
          paramString2 = new JSONObject(paramString2);
          if (paramString2.has(paramString1))
          {
            paramString1 = paramString2.optString(paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchFromExtra(" + paramInt + ")->switchs:" + paramString1);
            }
            paramInt = a(paramString1, paramInt);
            return paramInt;
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return -1;
  }
  
  public static <T> T a(String paramString1, String paramString2, T paramT)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramT != null)) {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has(paramString2))
        {
          if ((paramT instanceof String)) {
            return paramString1.optString(paramString2, (String)paramT);
          }
          if ((paramT instanceof Integer)) {
            return Integer.valueOf(paramString1.optInt(paramString2, ((Integer)paramT).intValue()));
          }
          if ((paramT instanceof Double))
          {
            double d = paramString1.optDouble(paramString2, ((Double)paramT).doubleValue());
            return Double.valueOf(d);
          }
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
      }
    }
    return paramT;
  }
  
  public static boolean a()
  {
    return Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 1;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isADVideoDownloadProgress->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 8);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isVideoFeedsAdButtonNewStyle->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isServerRspReport->AdvertisementInfo:" + paramAdvertisementInfo + " adInfo = " + paramVideoAdInfo);
    }
    if ((paramAdvertisementInfo == null) && (paramVideoAdInfo == null)) {
      return false;
    }
    int i = -1;
    if (paramAdvertisementInfo != null) {
      i = b(paramAdvertisementInfo.mAdExtInfo, 6);
    }
    if (paramVideoAdInfo != null) {
      i = b(paramVideoAdInfo.v, 6);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isServerRspReport->value:" + i);
    }
    if (i == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData, Context paramContext, int paramInt)
  {
    if (((paramInt == 1) && (paramAdvertisementInfo == null)) || ((paramInt == 2) && (paramProteusBannerVideoItemData == null)) || ((paramAdvertisementInfo == null) && (paramProteusBannerVideoItemData == null))) {
      return false;
    }
    if (paramInt == 1) {}
    for (paramInt = a(paramAdvertisementInfo);; paramInt = a(paramProteusBannerVideoItemData))
    {
      paramAdvertisementInfo = onk.b();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdSwitchUtil", 2, " isADVideoAutoPlayFlag adFlag = " + paramInt + " kandianVideoAutoPlaySetting = " + paramAdvertisementInfo);
      }
      if (!onk.d.equals(paramAdvertisementInfo)) {
        break label109;
      }
      return false;
      if (paramInt != 2) {
        break;
      }
    }
    return false;
    label109:
    if (onk.b.equals(paramAdvertisementInfo))
    {
      if (paramInt == 0) {
        return false;
      }
      if ((paramInt == 1) && (paramContext != null) && (qku.a(paramContext))) {
        return true;
      }
      if ((paramInt == 2) && (paramContext != null) && (bbev.g(paramContext))) {
        return true;
      }
    }
    if (onk.c.equals(paramAdvertisementInfo))
    {
      if (paramInt == 0) {
        return false;
      }
      if ((paramInt == 1) && (paramContext != null) && (qku.a(paramContext))) {
        return true;
      }
      if ((paramInt == 2) && (paramContext != null) && (qku.a(paramContext))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isNewExposureProtocol->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null) {
      i = a(paramAdData.v, 7);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(AdData paramAdData, boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isNewClickOrNegativeProtocol->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null)
    {
      if (!paramBoolean) {
        i = a(paramAdData.v, 13);
      }
    }
    else {
      if (i != 1) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      i = a(paramAdData.v, 14);
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i = b(paramString, 21);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isMobileAutoDownloadForBtn->value:" + i);
    }
    return i == 1;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getFeedsAdStyle->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {}
    int i;
    do
    {
      return 0;
      i = b(paramAdvertisementInfo.mAdExtInfo, 4);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdSwitchUtil", 2, "getFeedsAdStyle->value:" + i);
      }
    } while (i == -1);
    return i;
  }
  
  private static int b(String paramString, int paramInt)
  {
    return a("ad_switchs", paramString, paramInt);
  }
  
  public static boolean b(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 2;
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 10);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->AdData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.v, 10);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getVideoClickZoneSwitch->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {}
    int i;
    do
    {
      return 0;
      i = b(paramAdvertisementInfo.mAdExtInfo, 19);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdSwitchUtil", 2, "getVideoClickZoneSwitch->value:" + i);
      }
    } while (i == -1);
    return i;
  }
  
  public static boolean c(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 5) == 1;
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAdjustAdExposure->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 17);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_SWITCH->extValue:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->AdData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.v, 16);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean d(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 8) == 1;
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 15);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean d(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.v, 15);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean e(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 11);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_CIRCLE->extValue:" + i);
    }
    return i == 1;
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponent->AdData:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 18);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponent->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean e(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponentForDetail->AdData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.v, 18);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponentForDetail->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean f(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 12);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_SWITCH->extValue:" + i);
    }
    return i == 1;
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 16);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean g(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 20) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oat
 * JD-Core Version:    0.7.0.1
 */