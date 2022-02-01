package cooperation.qzone.report.lp;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

class MachineLearingSmartReport$1
  implements ModuleDownloadListener
{
  MachineLearingSmartReport$1(MachineLearingSmartReport paramMachineLearingSmartReport, String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadCanceled " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString)
  {
    MachineLearingSmartReport.access$100(this.this$0, 10, "Module onDownloadFailed " + paramString);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadProgress " + paramString + ",progress=" + Float.toString(paramFloat));
    }
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadSucceed " + paramString);
    }
    MachineLearingSmartReport.access$000(this.this$0, this.val$moudleId, this.val$mainClassName, this.val$moduleMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.MachineLearingSmartReport.1
 * JD-Core Version:    0.7.0.1
 */