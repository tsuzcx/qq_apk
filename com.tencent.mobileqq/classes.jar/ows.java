import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class ows
  implements ShortVideoResourceStatus.ISVConfig
{
  ows(owi paramowi, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", "短视频配置解压失败[" + paramInt2 + "]", null);
        ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
        ShortVideoErrorReport.a(1, paramInt2);
        this.jdField_a_of_type_Owi.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", "配置下载成功,插件资源下载中...", null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new owt(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", "短视频配置校验失败[" + paramInt1 + "]", null);
      ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", "短视频配置下载失败[" + paramInt2 + "]", null);
    ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
    ShortVideoErrorReport.a(1, paramInt2);
    this.jdField_a_of_type_Owi.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ows
 * JD-Core Version:    0.7.0.1
 */