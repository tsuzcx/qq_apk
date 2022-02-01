import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gh
  implements EIPCResultCallback
{
  gh(gg paramgg) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      gg.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gh
 * JD-Core Version:    0.7.0.1
 */