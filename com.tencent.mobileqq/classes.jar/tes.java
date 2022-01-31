import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;

public class tes
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private RockDownloadListener jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  
  public tes(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private RockDownloadListener a(RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener = new RockDownloadPresenter.1(this, paramRockDownloadListenerWrapper);
    }
    return this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  public RockDownloadInfo a()
  {
    int i = tee.a().e();
    String str2 = tee.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a();
    }
    return new RockDownloadInfo("biz_src_jc_gzh_weishi", "weishi_gzh", "com.tencent.weishi", str1, i);
  }
  
  public void a(Activity paramActivity, RockDownloadInfo paramRockDownloadInfo, int paramInt, WSDownloadParams paramWSDownloadParams, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if ((paramActivity != null) && (paramInt == 3)) {
      tet.a(paramActivity);
    }
    if (tfa.c())
    {
      tlo.d("RockDownloader", "已有正在下载的任务，不响应");
      return;
    }
    paramActivity = paramWSDownloadParams;
    if (paramWSDownloadParams == null) {
      paramActivity = new WSDownloadParams();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramActivity;
    tju.a(paramActivity, 1);
    WSPublicAccReport.getInstance().reportDownload(paramActivity.mEventId, paramInt, 1, 1, 0);
    if (paramInt == 1)
    {
      anvz.a(paramRockDownloadInfo, a(paramRockDownloadListenerWrapper));
      tlo.d("RockDownloader", "执行预下载Rock下载 " + paramRockDownloadInfo.toString());
      return;
    }
    tlv.a(paramActivity.mScheme);
    anvz.a(paramRockDownloadInfo, a(paramRockDownloadListenerWrapper));
    tlo.d("RockDownloader", "执行可call起安装Rock下载 " + paramRockDownloadInfo.toString());
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo)
  {
    boolean bool = anvz.a(paramRockDownloadInfo);
    if (bool)
    {
      tlo.b("RockDownloader", "rockdownload deleteSuccess");
      return bool;
    }
    if (paramRockDownloadInfo.realVersionCode == 333)
    {
      tlo.b("RockDownloader", "rockdownload 模拟 deleteFail");
      return bool;
    }
    tlo.b("RockDownloader", "rockdownload deleteFail");
    return bool;
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    boolean bool = anvz.b(paramRockDownloadInfo);
    int i = tfa.b();
    if (bool)
    {
      tlo.d("RockDownloader", "rockdownload installSuccess,eventType = " + i);
      tju.a(paramInt, 1);
      WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 2, 1, 1);
      return bool;
    }
    tlo.d("RockDownloader", "rockdownload installFail,eventType = " + i);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tes
 * JD-Core Version:    0.7.0.1
 */