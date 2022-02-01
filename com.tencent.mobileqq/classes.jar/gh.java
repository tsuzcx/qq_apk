import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gh
  implements EIPCResultCallback
{
  gh(gf paramgf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramEIPCResult.data.getInt("font_type"))
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1)
      {
        gf.b(this.a);
        this.a.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = gf.a(this.a, false);
      continue;
      bool1 = gf.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gh
 * JD-Core Version:    0.7.0.1
 */