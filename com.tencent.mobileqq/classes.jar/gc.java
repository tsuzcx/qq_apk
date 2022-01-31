import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gc
  implements EIPCResultCallback
{
  gc(gb paramgb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      gb.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     gc
 * JD-Core Version:    0.7.0.1
 */