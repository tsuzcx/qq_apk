package dov.com.qq.im.ae;

import ajyc;
import android.app.Activity;
import bcpw;
import biim;
import com.tencent.common.app.BaseApplicationImpl;

public class AEPituCameraUnit$13
  implements Runnable
{
  public AEPituCameraUnit$13(biim parambiim, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
    case 101: 
    case 104: 
      Activity localActivity;
      do
      {
        return;
        bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131689784), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131689785), 0).a();
      this.this$0.q();
      return;
    }
    bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131689783), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */