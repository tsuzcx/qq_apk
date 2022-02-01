import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class nti
{
  public static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(35, 3);
    a.put(11, 2);
    a.put(8, 1);
    a.put(37, 4);
    a.put(52, 5);
  }
  
  public static int a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    if (paramRedDotInfo1 == null)
    {
      if (paramRedDotInfo2 == null) {
        return 0;
      }
      return -1;
    }
    if (paramRedDotInfo2 == null) {
      return 1;
    }
    return a.get(paramRedDotInfo1.uint32_appid.get()) - a.get(paramRedDotInfo2.uint32_appid.get());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 35) || (paramInt == 11) || (paramInt == 37);
  }
  
  public static boolean a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    boolean bool = true;
    int i = paramRedDotInfo.uint32_appid.get();
    if (i == 35)
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRedDotInfo)) {
        try
        {
          long l = new JSONObject(paramRedDotInfo).optLong("image_red_display_780", 1L);
          if (l == 0L) {
            bool = false;
          }
          return bool;
        }
        catch (JSONException paramRedDotInfo)
        {
          ykq.c("TroopRedTouchConfigure", "isStoryDisplayRedDot() APPID_STORY_IMG: Error parse json: ", paramRedDotInfo);
          return true;
        }
      }
      ykq.b("TroopRedTouchConfigure", "isStoryDisplayRedDot() APPID_STORY_IMG: str_custom_buffer is null");
      return true;
    }
    return b(i);
  }
  
  public static boolean b(int paramInt)
  {
    return (a(paramInt)) || (paramInt == 52);
  }
  
  public static boolean c(int paramInt)
  {
    return (d(paramInt)) || (e(paramInt)) || (f(paramInt)) || (g(paramInt)) || (h(paramInt)) || (paramInt == 40) || (paramInt == 39) || (paramInt == 41) || (paramInt == 42) || (paramInt == 58) || (paramInt == 56) || (paramInt == 57) || (paramInt == 59) || (paramInt == 60) || (paramInt == 61) || (paramInt == 65) || (paramInt == 63) || (paramInt == 53) || (paramInt == 54);
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 25;
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt == 23) || (paramInt == 26);
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt == 24) || (paramInt == 27);
  }
  
  public static boolean g(int paramInt)
  {
    return paramInt == 38;
  }
  
  public static boolean h(int paramInt)
  {
    return paramInt == 70;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nti
 * JD-Core Version:    0.7.0.1
 */