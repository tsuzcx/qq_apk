import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class gi
  implements EIPCResultCallback
{
  gi(gg paramgg) {}
  
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
        gg.b(this.a);
        this.a.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = gg.a(this.a, false);
      continue;
      bool1 = gg.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gi
 * JD-Core Version:    0.7.0.1
 */