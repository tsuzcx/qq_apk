import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gg
  implements EIPCResultCallback
{
  gg(gf paramgf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      gf.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gg
 * JD-Core Version:    0.7.0.1
 */