import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gd
  implements EIPCResultCallback
{
  gd(gb paramgb) {}
  
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
        gb.b(this.a);
        this.a.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = gb.a(this.a, false);
      continue;
      bool1 = gb.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     gd
 * JD-Core Version:    0.7.0.1
 */