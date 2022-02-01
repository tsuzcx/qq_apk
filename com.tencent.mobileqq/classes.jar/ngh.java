import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ngh
  implements nbt
{
  final WeakReference<ngg> a;
  
  ngh(ngg paramngg)
  {
    this.a = new WeakReference(paramngg);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule_GameRC", 2, "GameResultCallback onReslut, playId[" + paramString1 + "], fileType[" + paramInt + "], url[" + paramString2 + "]");
    }
    ngg localngg = (ngg)this.a.get();
    if (localngg == null) {
      return;
    }
    localngg.a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngh
 * JD-Core Version:    0.7.0.1
 */