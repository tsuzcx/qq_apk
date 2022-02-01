import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ndh
  implements mzp
{
  final WeakReference<ndg> a;
  
  ndh(ndg paramndg)
  {
    this.a = new WeakReference(paramndg);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule_GameRC", 2, "GameResultCallback onReslut, playId[" + paramString1 + "], fileType[" + paramInt + "], url[" + paramString2 + "]");
    }
    ndg localndg = (ndg)this.a.get();
    if (localndg == null) {
      return;
    }
    localndg.a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndh
 * JD-Core Version:    0.7.0.1
 */