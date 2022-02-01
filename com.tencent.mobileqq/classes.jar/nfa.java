import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class nfa
  implements nas
{
  final WeakReference<nez> a;
  
  nfa(nez paramnez)
  {
    this.a = new WeakReference(paramnez);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule_GameRC", 2, "GameResultCallback onReslut, playId[" + paramString1 + "], fileType[" + paramInt + "], url[" + paramString2 + "]");
    }
    nez localnez = (nez)this.a.get();
    if (localnez == null) {
      return;
    }
    localnez.a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfa
 * JD-Core Version:    0.7.0.1
 */