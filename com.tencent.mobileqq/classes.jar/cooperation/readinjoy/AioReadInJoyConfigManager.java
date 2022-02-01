package cooperation.readinjoy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class AioReadInJoyConfigManager
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4).getInt("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4).edit();
    paramQQAppInterface.putInt("hot_shortvideo_multi_video_support_799", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4).edit().putInt("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION" + paramQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.readinjoy.AioReadInJoyConfigManager
 * JD-Core Version:    0.7.0.1
 */