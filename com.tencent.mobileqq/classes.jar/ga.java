import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ga
  implements EIPCResultCallback
{
  ga(fz paramfz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      fz.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ga
 * JD-Core Version:    0.7.0.1
 */