package dov.com.qq.im;

import ajjy;
import android.app.Activity;
import bbmy;
import bhcw;
import com.tencent.common.app.BaseApplicationImpl;

public class AEPituCameraUnit$8
  implements Runnable
{
  public AEPituCameraUnit$8(bhcw parambhcw, int paramInt) {}
  
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
        bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131624242), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131624243), 0).a();
      this.this$0.o();
      return;
    }
    bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131624241), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */