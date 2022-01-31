import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gb
  implements EIPCResultCallback
{
  gb(fz paramfz) {}
  
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
        fz.b(this.a);
        this.a.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = fz.a(this.a, false);
      continue;
      bool1 = fz.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     gb
 * JD-Core Version:    0.7.0.1
 */