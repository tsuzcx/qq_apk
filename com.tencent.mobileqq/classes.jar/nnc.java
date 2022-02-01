import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class nnc
  implements bnkw
{
  final WeakReference<nmy> a;
  
  nnc(nmy paramnmy)
  {
    this.a = new WeakReference(paramnmy);
  }
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onAEResDownloadResult, package[" + parambnkt.a + "], isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
    }
    parambnkt = (nmy)this.a.get();
    if (parambnkt != null) {
      parambnkt.a(1, paramBoolean, paramString);
    }
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2)
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
 * Qualified Name:     nnc
 * JD-Core Version:    0.7.0.1
 */