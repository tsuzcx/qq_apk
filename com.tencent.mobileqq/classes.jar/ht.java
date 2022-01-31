import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ht
  implements EIPCResultCallback
{
  ht(hs paramhs) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      hs.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ht
 * JD-Core Version:    0.7.0.1
 */