package cooperation.vip.qqbanner.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import java.lang.ref.WeakReference;

class VasADBannerResDownloadManager$VasBannerDownloadListener
  implements Downloader.DownloadListener
{
  private volatile int jdField_a_of_type_Int;
  private VasADBannerConfigInfo jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerConfigInfo;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile int b;
  private int c;
  
  public VasADBannerResDownloadManager$VasBannerDownloadListener(VasADBannerResDownloadManager paramVasADBannerResDownloadManager, QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerConfigInfo = paramVasADBannerConfigInfo;
    this.c = paramInt;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download fail url = ");
      paramDownloadResult.append(paramString);
      QLog.i("VasADBannerResDownloadManager", 2, paramDownloadResult.toString());
    }
    this.b += 1;
    VasADBannerResDownloadManager.a(this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager, this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerConfigInfo, paramString, false);
    paramString = new StringBuilder();
    paramString.append("onDownloadFailed mLoadSuccessTimes = ");
    paramString.append(this.jdField_a_of_type_Int);
    paramString.append(" mDownTotalSize = ");
    paramString.append(this.c);
    QLog.e("VasADBannerResDownloadManager", 1, paramString.toString());
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.b + this.jdField_a_of_type_Int == this.c) {
      VasADBannerResDownloadManager.a(this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("banner resources download success url = ");
      paramDownloadResult.append(paramString);
      QLog.i("VasADBannerResDownloadManager", 2, paramDownloadResult.toString());
    }
    this.jdField_a_of_type_Int += 1;
    VasADBannerResDownloadManager.a(this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager, this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerConfigInfo, paramString, true);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("onDownloadSucceed mLoadSuccessTimes = ");
    paramDownloadResult.append(this.jdField_a_of_type_Int);
    paramDownloadResult.append(" mDownTotalSize = ");
    paramDownloadResult.append(this.c);
    QLog.e("VasADBannerResDownloadManager", 1, paramDownloadResult.toString());
    if ((this.jdField_a_of_type_Int == this.c) && (!this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerConfigInfo.b())) {
      VasADBannerResDownloadManager.b(this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager.VasBannerDownloadListener
 * JD-Core Version:    0.7.0.1
 */