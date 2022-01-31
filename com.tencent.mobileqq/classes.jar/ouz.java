import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class ouz
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  ouz(ouy paramouy) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label146;
      }
      VideoEnvironment.a("TroopMemberApiService", "短视频插件下载失败[" + paramInt + "]", null);
      ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
      ShortVideoErrorReport.a(2, paramInt);
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
    }
    for (;;)
    {
      VideoEnvironment.a("TroopMemberApiService", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      this.a.jdField_a_of_type_Ouo.a.a(94, this.a.jdField_a_of_type_AndroidOsBundle);
      this.a.jdField_a_of_type_Ouo.a.b = false;
      return;
      label146:
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", -2);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void y_()
  {
    this.a.jdField_a_of_type_Ouo.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouz
 * JD-Core Version:    0.7.0.1
 */