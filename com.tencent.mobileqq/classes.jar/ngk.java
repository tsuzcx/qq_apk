import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import mqq.util.WeakReference;

class ngk
  implements blvp
{
  final WeakReference<ngg> a;
  
  ngk(ngg paramngg)
  {
    this.a = new WeakReference(paramngg);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onAEResDownloadResult, package[" + paramAEResInfo.index + "], isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
    }
    paramAEResInfo = (ngg)this.a.get();
    if (paramAEResInfo != null) {
      paramAEResInfo.a(1, paramBoolean, paramString);
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel())
    {
      float f = 0.0F;
      if (paramLong2 != 0L) {
        f = (float)paramLong1 / (float)paramLong2;
      }
      QLog.i("AVGameServerIPCModule", 4, "onAEProgressUpdate, [" + f + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngk
 * JD-Core Version:    0.7.0.1
 */