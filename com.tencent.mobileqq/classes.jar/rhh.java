import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;

public class rhh
  implements View.OnClickListener
{
  public rhh(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.a.a(), (ViewGroup)ReadinjoyTabFrame.a(this.a));
    if (BaseApplicationImpl.sProcessId != 9) {
      bihv.a(BaseApplicationImpl.getContext());
    }
    onh.c("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rhh
 * JD-Core Version:    0.7.0.1
 */