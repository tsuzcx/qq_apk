import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;

public class rxc
  implements View.OnClickListener
{
  public rxc(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a, this.a.a(), (ViewGroup)ReadinjoyTabFrame.a(this.a));
    if (BaseApplicationImpl.sProcessId != 9) {
      bkny.a(BaseApplicationImpl.getContext());
    }
    ors.c("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rxc
 * JD-Core Version:    0.7.0.1
 */