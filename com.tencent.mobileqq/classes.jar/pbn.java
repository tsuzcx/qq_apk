import android.os.Bundle;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import java.util.Map;

public class pbn
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static float a()
  {
    return ((Float)bnrf.a("seriestype_feeds_covered_light", Float.valueOf(0.8F))).floatValue();
  }
  
  public static final int a()
  {
    return ((Integer)bnrf.a("seriestype_feeds_press", Integer.valueOf(0))).intValue();
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = ((Float)bnrf.a("small_video_max_width_height_ratio", Float.valueOf(0.75F))).floatValue();
    int i = ((Integer)bnrf.a("small_video_max_duration", Integer.valueOf(60))).intValue();
    if ((paramInt1 / paramInt2 <= f) && (paramInt3 <= i)) {
      return 1;
    }
    return 0;
  }
  
  public static String a()
  {
    return (String)bnrf.a("seriestype_top_bar_title", "推荐视频");
  }
  
  public static boolean a()
  {
    boolean bool = ((Boolean)bnrf.a("viola_enable", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoConfigHandler", 2, "isViolaEnable: " + bool);
    }
    return bool;
  }
  
  public static final boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode() videoFrom=" + paramInt + "seriestype_video_from=" + (String)bnrf.a("seriestype_video_from", "null") + "seriestype_video_type=" + bnrf.a("seriestype_video_type", Integer.valueOf(-1)));
    }
    ocd.a(null, null, "0X800B3A0", "0X800B3A0", 0, 0, null, null, null, "", false);
    if (pcf.a(paramInt))
    {
      paramInt = HardwareUtil.judgeDeviceLevel(BaseApplication.getContext());
      if (paramInt <= 1)
      {
        QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode jumptoNative deviceLevel:" + paramInt);
        ocd.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      ocd.a(null, null, "0X800B38C", "0X800B38D", 0, 0, null, null, null, "", false);
      return true;
    }
    return bnrf.b(paramInt, "\\|", "seriestype_video_from");
  }
  
  public static final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public static final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode() videoFrom=" + paramInt1 + ", videoWidth=" + paramInt2 + ", videoHeight=" + paramInt3 + ", duration=" + paramInt4 + "seriestype_video_from=" + (String)bnrf.a("seriestype_video_from", "null") + "seriestype_video_type=" + bnrf.a("seriestype_video_type", Integer.valueOf(-1)) + "small_video_max_width_height_ratio=" + bnrf.a("small_video_max_width_height_ratio", Float.valueOf(0.0F)) + "small_video_max_duration=" + bnrf.a("small_video_max_duration", Integer.valueOf(0)));
    }
    ocd.a(null, null, "0X800B3A0", "0X800B3A0", 0, 0, null, null, null, "", false);
    if (pcf.a(paramInt1))
    {
      paramInt1 = HardwareUtil.judgeDeviceLevel(BaseApplication.getContext());
      if (paramInt1 <= 1)
      {
        QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode jumptoNative deviceLevel:" + paramInt1);
        ocd.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      if ((paramBundle != null) && (paramBundle.getString("video_feeds_force_native", "0").equals("1")))
      {
        QLog.d("MultiVideoConfigHandler", 2, "isEnterMultiMode jumptoNative because video_feeds_force_native");
        ocd.a(null, null, "0X800B38C", "0X800B38C", 0, 0, null, null, null, "", false);
        return false;
      }
      ocd.a(null, null, "0X800B38C", "0X800B38D", 0, 0, null, null, null, "", false);
      return true;
    }
    if ((paramInt2 <= 0) || (paramInt3 <= 0) || (paramInt4 <= 0)) {
      return false;
    }
    int i = ((Integer)bnrf.a("seriestype_video_type", Integer.valueOf(0))).intValue();
    return (bnrf.b(paramInt1, "\\|", "seriestype_video_from")) && ((i == 2) || (i == a(paramInt2, paramInt3, paramInt4)));
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("MultiVideoConfigHandler", 2, "[onReceiveConfig] " + paramString);
    Object localObject = pan.a(paramString);
    paramString = (String)((Map)localObject).get("seriestype_video_from");
    if (paramString == null) {
      paramString = "";
    }
    int k;
    float f3;
    label444:
    label451:
    label457:
    label464:
    label469:
    label474:
    for (;;)
    {
      float f2 = 0.75F;
      k = 60;
      f3 = 0.8F;
      try
      {
        str = (String)((Map)localObject).get("seriestype_feeds_press");
        if (str == null) {
          break label474;
        }
        paramInt1 = Integer.parseInt(str);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          String str;
          paramInt2 = 0;
          continue;
          paramInt1 = 0;
        }
      }
      paramInt2 = paramInt1;
      try
      {
        str = (String)((Map)localObject).get("seriestype_feeds_covered_time");
        if (str == null) {
          break label469;
        }
        paramInt1 = Integer.parseInt(str);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i = 3;
          continue;
          paramInt1 = 3;
        }
      }
      i = paramInt1;
      try
      {
        str = (String)((Map)localObject).get("seriestype_video_type");
        if (str == null) {
          break label464;
        }
        paramInt1 = Integer.parseInt(str);
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          label238:
          int j = 0;
          continue;
          paramInt1 = 0;
        }
      }
      j = paramInt1;
      try
      {
        str = (String)((Map)localObject).get("small_video_max_width_height_ratio");
        if (str == null) {
          break label457;
        }
        f1 = Float.parseFloat(str);
      }
      catch (Exception localException6)
      {
        for (;;)
        {
          continue;
          continue;
          float f1 = 0.8F;
          continue;
          paramInt1 = 60;
          continue;
          f1 = 0.75F;
        }
      }
      f2 = f1;
      try
      {
        str = (String)((Map)localObject).get("small_video_max_duration");
        if (str == null) {
          break label451;
        }
        paramInt1 = Integer.parseInt(str);
      }
      catch (Exception localException5)
      {
        for (;;)
        {
          paramInt1 = k;
        }
      }
      try
      {
        str = (String)((Map)localObject).get("seriestype_feeds_covered_light");
        if (str == null) {
          break label444;
        }
        f1 = Float.parseFloat(str);
      }
      catch (Exception localException4)
      {
        f1 = f3;
        break label238;
      }
      str = (String)((Map)localObject).get("seriestype_top_bar_title");
      if (str == null)
      {
        str = "推荐视频";
        try
        {
          localObject = (String)((Map)localObject).get("viola_enable");
          bool1 = bool2;
          if (localObject != null)
          {
            k = Integer.parseInt((String)localObject);
            bool1 = bool2;
            if (k == 1) {
              bool1 = true;
            }
          }
        }
        catch (Exception localException7)
        {
          for (;;)
          {
            boolean bool1 = bool2;
          }
        }
        bnrf.a("seriestype_top_bar_title", str);
        bnrf.a("seriestype_video_from", paramString);
        bnrf.a("seriestype_feeds_press", Integer.valueOf(paramInt2));
        bnrf.a("seriestype_feeds_covered_time", Integer.valueOf(i));
        bnrf.a("seriestype_video_type", Integer.valueOf(j));
        bnrf.a("small_video_max_width_height_ratio", Float.valueOf(f2));
        bnrf.a("small_video_max_duration", Integer.valueOf(paramInt1));
        bnrf.a("seriestype_feeds_covered_light", Float.valueOf(f1));
        bnrf.a("viola_enable", Boolean.valueOf(bool1));
        return true;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bnrf.a("seriestype_feeds_press", Integer.valueOf(0));
    bnrf.a("seriestype_feeds_covered_time", Integer.valueOf(3));
    bnrf.a("seriestype_video_from", "");
    bnrf.a("seriestype_video_type", Integer.valueOf(0));
    bnrf.a("small_video_max_width_height_ratio", Double.valueOf(0.75D));
    bnrf.a("small_video_max_duration", Integer.valueOf(60));
    bnrf.a("seriestype_feeds_covered_light", Float.valueOf(0.8F));
    bnrf.a("seriestype_top_bar_title", "推荐视频");
    bnrf.a("viola_enable", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbn
 * JD-Core Version:    0.7.0.1
 */