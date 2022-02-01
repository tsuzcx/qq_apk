package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJMultiVideoConfigSp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import java.util.Map;

public class MultiVideoConfigHandler
  extends SimpleConfigHandler
{
  public static final int a()
  {
    return ((Integer)RIJSPUtils.b("seriestype_feeds_press", Integer.valueOf(0))).intValue();
  }
  
  public static final boolean a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEnterMultiMode() videoFrom=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("seriestype_video_from=");
      localStringBuilder.append((String)RIJSPUtils.b("seriestype_video_from", "null"));
      localStringBuilder.append("seriestype_video_type=");
      localStringBuilder.append(RIJSPUtils.b("seriestype_video_type", Integer.valueOf(-1)));
      QLog.d("MultiVideoConfigHandler", 2, localStringBuilder.toString());
    }
    PublicAccountReportUtils.a(null, null, "0X800B3A0", "0X800B3A0", 0, 0, null, null, null, "", false);
    if (ViolaVideoFeedsConfigHandler.a(paramInt))
    {
      paramInt = HardwareUtil.judgeDeviceLevel(BaseApplication.getContext());
      if ((paramInt <= 1) && (ViolaVideoFeedsConfigHandler.a()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isEnterMultiMode jumptoNative deviceLevel:");
        localStringBuilder.append(paramInt);
        QLog.d("MultiVideoConfigHandler", 2, localStringBuilder.toString());
        PublicAccountReportUtils.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      PublicAccountReportUtils.a(null, null, "0X800B38C", "0X800B38D", 0, 0, null, null, null, "", false);
      return true;
    }
    return RIJMultiVideoConfigSp.b(paramInt, "\\|", "seriestype_video_from");
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 >= paramInt3) && ("1".equals(Aladdin.getConfig(434).getString("is_enter_video_account", "0"))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt1);
      if (localStringBuilder.toString().equals(Aladdin.getConfig(434).getString("video_from_type", "-100"))) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public static final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    boolean bool1 = QLog.isColorLevel();
    Integer localInteger = Integer.valueOf(0);
    if (bool1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEnterMultiMode() videoFrom=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", videoWidth=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", videoHeight=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", duration=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("seriestype_video_from=");
      localStringBuilder.append((String)RIJSPUtils.b("seriestype_video_from", "null"));
      localStringBuilder.append("seriestype_video_type=");
      localStringBuilder.append(RIJSPUtils.b("seriestype_video_type", Integer.valueOf(-1)));
      localStringBuilder.append("small_video_max_width_height_ratio=");
      localStringBuilder.append(RIJSPUtils.b("small_video_max_width_height_ratio", Float.valueOf(0.0F)));
      localStringBuilder.append("small_video_max_duration=");
      localStringBuilder.append(RIJSPUtils.b("small_video_max_duration", localInteger));
      QLog.d("MultiVideoConfigHandler", 2, localStringBuilder.toString());
    }
    PublicAccountReportUtils.a(null, null, "0X800B3A0", "0X800B3A0", 0, 0, null, null, null, "", false);
    boolean bool2 = a(paramInt1, paramInt2, paramInt3);
    bool1 = true;
    if (bool2) {
      return true;
    }
    if (ViolaVideoFeedsConfigHandler.a(paramInt1))
    {
      paramInt1 = HardwareUtil.judgeDeviceLevel(BaseApplication.getContext());
      if ((paramInt1 <= 1) && (ViolaVideoFeedsConfigHandler.a()))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("isEnterMultiMode jumptoNative deviceLevel:");
        paramBundle.append(paramInt1);
        QLog.d("MultiVideoConfigHandler", 2, paramBundle.toString());
        PublicAccountReportUtils.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      if ((paramBundle != null) && (paramBundle.getString("video_feeds_force_native", "0").equals("1")))
      {
        QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode jumptoNative because video_feeds_force_native");
        PublicAccountReportUtils.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      PublicAccountReportUtils.a(null, null, "0X800B38D", "0X800B38D", 0, 0, null, null, null, "", false);
      return true;
    }
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      if (paramInt4 <= 0) {
        return false;
      }
      int i = ((Integer)RIJSPUtils.b("seriestype_video_type", localInteger)).intValue();
      if (RIJMultiVideoConfigSp.b(paramInt1, "\\|", "seriestype_video_from"))
      {
        if (i == 2) {
          break label431;
        }
        if (i == b(paramInt2, paramInt3, paramInt4)) {
          return true;
        }
      }
      bool1 = false;
      label431:
      return bool1;
    }
    return false;
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = ((Float)RIJSPUtils.b("small_video_max_width_height_ratio", Float.valueOf(0.75F))).floatValue();
    int i = ((Integer)RIJSPUtils.b("small_video_max_duration", Integer.valueOf(60))).intValue();
    if ((paramInt1 / paramInt2 <= f) && (paramInt3 <= i)) {
      return 1;
    }
    return 0;
  }
  
  public static String b()
  {
    return (String)RIJSPUtils.b("seriestype_top_bar_title", "推荐视频");
  }
  
  public static float c()
  {
    return ((Float)RIJSPUtils.b("seriestype_feeds_covered_light", Float.valueOf(0.8F))).floatValue();
  }
  
  public static boolean d()
  {
    boolean bool = ((Boolean)RIJSPUtils.b("viola_enable", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isViolaEnable: ");
      localStringBuilder.append(bool);
      QLog.d("MultiVideoConfigHandler", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("MultiVideoConfigHandler", 2, ((StringBuilder)localObject).toString());
    Map localMap = AladdinParseUtils.a(paramString);
    localObject = (String)localMap.get("seriestype_video_from");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    i = 3;
    f2 = 0.75F;
    k = 60;
    f3 = 0.8F;
    try
    {
      localObject = (String)localMap.get("seriestype_feeds_press");
      if (localObject != null) {
        paramInt1 = Integer.parseInt((String)localObject);
      }
    }
    catch (Exception localException1)
    {
      label117:
      break label117;
    }
    paramInt1 = 0;
    try
    {
      localObject = (String)localMap.get("seriestype_feeds_covered_time");
      paramInt2 = i;
      if (localObject != null) {
        paramInt2 = Integer.parseInt((String)localObject);
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label176:
        paramInt2 = i;
      }
    }
    try
    {
      localObject = (String)localMap.get("seriestype_video_type");
      if (localObject != null) {
        i = Integer.parseInt((String)localObject);
      }
    }
    catch (Exception localException3)
    {
      break label176;
    }
    i = 0;
    try
    {
      localObject = (String)localMap.get("small_video_max_width_height_ratio");
      f1 = f2;
      if (localObject != null) {
        f1 = Float.parseFloat((String)localObject);
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        label239:
        String str;
        label269:
        float f1 = f2;
      }
    }
    try
    {
      localObject = (String)localMap.get("small_video_max_duration");
      j = k;
      if (localObject != null) {
        j = Integer.parseInt((String)localObject);
      }
    }
    catch (Exception localException5)
    {
      j = k;
      break label239;
    }
    try
    {
      localObject = (String)localMap.get("seriestype_feeds_covered_light");
      f2 = f3;
      if (localObject != null) {
        f2 = Float.parseFloat((String)localObject);
      }
    }
    catch (Exception localException6)
    {
      f2 = f3;
      break label269;
    }
    str = (String)localMap.get("seriestype_top_bar_title");
    localObject = str;
    if (str == null) {
      localObject = "推荐视频";
    }
    try
    {
      str = (String)localMap.get("viola_enable");
      if (str != null)
      {
        k = Integer.parseInt(str);
        if (k == 1) {
          bool = true;
        }
      }
    }
    catch (Exception localException7)
    {
      boolean bool;
      label334:
      break label334;
    }
    bool = false;
    RIJSPUtils.a("seriestype_top_bar_title", localObject);
    RIJSPUtils.a("seriestype_video_from", paramString);
    RIJSPUtils.a("seriestype_feeds_press", Integer.valueOf(paramInt1));
    RIJSPUtils.a("seriestype_feeds_covered_time", Integer.valueOf(paramInt2));
    RIJSPUtils.a("seriestype_video_type", Integer.valueOf(i));
    RIJSPUtils.a("small_video_max_width_height_ratio", Float.valueOf(f1));
    RIJSPUtils.a("small_video_max_duration", Integer.valueOf(j));
    RIJSPUtils.a("seriestype_feeds_covered_light", Float.valueOf(f2));
    RIJSPUtils.a("viola_enable", Boolean.valueOf(bool));
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    Integer localInteger = Integer.valueOf(0);
    RIJSPUtils.a("seriestype_feeds_press", localInteger);
    RIJSPUtils.a("seriestype_feeds_covered_time", Integer.valueOf(3));
    RIJSPUtils.a("seriestype_video_from", "");
    RIJSPUtils.a("seriestype_video_type", localInteger);
    RIJSPUtils.a("small_video_max_width_height_ratio", Double.valueOf(0.75D));
    RIJSPUtils.a("small_video_max_duration", Integer.valueOf(60));
    RIJSPUtils.a("seriestype_feeds_covered_light", Float.valueOf(0.8F));
    RIJSPUtils.a("seriestype_top_bar_title", "推荐视频");
    RIJSPUtils.a("viola_enable", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler
 * JD-Core Version:    0.7.0.1
 */