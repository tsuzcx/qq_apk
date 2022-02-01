package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LpReport_ShuoshuoBehavior_dc02478
  implements LpReportInfo
{
  public static final int BEHAVIOR_TYPE_FONT = 1;
  public static final int BEHAVIOR_TYPE_LOC = 4;
  public static final int BEHAVIOR_TYPE_PIC = 2;
  public static final int BEHAVIOR_TYPE_TAG = 3;
  public static final int SHUOSHUO_CANCEL = 16;
  public static final int SHUOSHUO_RECOMMEND_SHOW = 32;
  public static final int SHUOSHUO_TYPE_FONT = 8;
  public static final int SHUOSHUO_TYPE_LOC = 1;
  public static final int SHUOSHUO_TYPE_ORIGINAL = 0;
  public static final int SHUOSHUO_TYPE_PIC = 4;
  public static final int SHUOSHUO_TYPE_TAG = 2;
  private static String TAG = "LpReport_ShuoshuoBehavior_dc02478";
  public String behavior_type;
  public String client_time;
  public int exif_pic_size;
  public int font_length;
  public String guess_expose_time;
  public String left_time;
  public int pic_size;
  public String qua;
  public int shuoshuo_type;
  public String stay_time;
  public long uin;
  public String version;
  public int video_size;
  
  public LpReport_ShuoshuoBehavior_dc02478(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4)
  {
    this.behavior_type = paramString1;
    this.shuoshuo_type = paramInt1;
    this.font_length = paramInt2;
    this.pic_size = paramInt3;
    this.exif_pic_size = paramInt4;
    this.video_size = paramInt5;
    this.stay_time = paramString2;
    this.left_time = paramString3;
    this.guess_expose_time = paramString4;
  }
  
  public String getSimpleInfo()
  {
    return TAG;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    long l = this.uin;
    String str;
    if (l <= 1000L) {
      str = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();
    } else {
      str = String.valueOf(l);
    }
    localHashMap.put("uin", str);
    if (TextUtils.isEmpty(this.version)) {
      str = "8.8.17";
    } else {
      str = this.version;
    }
    LpReportUtils.safePut(localHashMap, "version", str);
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    if (TextUtils.isEmpty(this.client_time)) {
      str = String.valueOf(System.currentTimeMillis());
    } else {
      str = this.client_time;
    }
    localHashMap.put("client_time", str);
    LpReportUtils.safePut(localHashMap, "behavior_type", this.behavior_type);
    LpReportUtils.safePut(localHashMap, "shuoshuo_type", this.shuoshuo_type);
    LpReportUtils.safePut(localHashMap, "font_length", this.font_length);
    LpReportUtils.safePut(localHashMap, "pic_size", this.pic_size);
    LpReportUtils.safePut(localHashMap, "exif_pic_size", this.exif_pic_size);
    LpReportUtils.safePut(localHashMap, "video_size", this.video_size);
    LpReportUtils.safePut(localHashMap, "stay_time", this.stay_time);
    LpReportUtils.safePut(localHashMap, "left_time", this.left_time);
    LpReportUtils.safePut(localHashMap, "guess_expose_time", this.guess_expose_time);
    return localHashMap;
  }
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    try
    {
      Field[] arrayOfField = getClass().getDeclaredFields();
      int i = 0;
      while (i < arrayOfField.length)
      {
        localStringBuilder.append(arrayOfField[i].getName());
        Object localObject = arrayOfField[i].get(this);
        if (localObject != null)
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localObject);
          localStringBuilder.append("\n");
        }
        else
        {
          localStringBuilder.append(":null \n");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_ShuoshuoBehavior_dc02478
 * JD-Core Version:    0.7.0.1
 */