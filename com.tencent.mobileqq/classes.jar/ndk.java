import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ndk
  implements bnpw
{
  final WeakReference<ndg> a;
  
  ndk(ndg paramndg)
  {
    this.a = new WeakReference(paramndg);
  }
  
  public void a(bnpt parambnpt, long paramLong1, long paramLong2)
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
  
  public void a(bnpt parambnpt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onAEResDownloadResult, package[" + parambnpt.a + "], isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
    }
    parambnpt = (ndg)this.a.get();
    if (parambnpt != null) {
      parambnpt.a(1, paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndk
 * JD-Core Version:    0.7.0.1
 */