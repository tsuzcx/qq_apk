import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class nfd
  implements bori
{
  final WeakReference<nez> a;
  
  nfd(nez paramnez)
  {
    this.a = new WeakReference(paramnez);
  }
  
  public void a(borf paramborf, long paramLong1, long paramLong2)
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
  
  public void a(borf paramborf, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onAEResDownloadResult, package[" + paramborf.a + "], isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
    }
    paramborf = (nez)this.a.get();
    if (paramborf != null) {
      paramborf.a(1, paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfd
 * JD-Core Version:    0.7.0.1
 */