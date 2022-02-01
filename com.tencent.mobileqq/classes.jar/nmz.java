import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class nmz
  implements nhq
{
  final WeakReference<nmy> a;
  
  nmz(nmy paramnmy)
  {
    this.a = new WeakReference(paramnmy);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule_GameRC", 2, "GameResultCallback onReslut, playId[" + paramString1 + "], fileType[" + paramInt + "], url[" + paramString2 + "]");
    }
    nmy localnmy = (nmy)this.a.get();
    if (localnmy == null) {
      return;
    }
    localnmy.a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmz
 * JD-Core Version:    0.7.0.1
 */