import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.Frame;

public class tbd
  extends tbo
{
  public tbd(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    Frame localFrame = MainFragment.a(this.a);
    if ((localFrame instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localFrame).l();
    }
    ReadInJoyLogicEngine.a().a(0);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbd
 * JD-Core Version:    0.7.0.1
 */