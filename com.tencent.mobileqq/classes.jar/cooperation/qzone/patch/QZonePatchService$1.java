package cooperation.qzone.patch;

import com.tencent.mobileqq.app.HardCodeUtil;

class QZonePatchService$1
  implements Runnable
{
  QZonePatchService$1(QZonePatchService paramQZonePatchService, String paramString1, String paramString2) {}
  
  public void run()
  {
    QZonePatchService.log(HardCodeUtil.a(2131712022));
    QZonePatchService.log(HardCodeUtil.a(2131712023));
    QZonePatchService.access$000();
    QZonePatchService.access$100(this.val$patchMd5, this.val$patchUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.patch.QZonePatchService.1
 * JD-Core Version:    0.7.0.1
 */