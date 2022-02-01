import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofl
  implements View.OnClickListener
{
  public ofl(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Ofa != null) {
      this.a.jdField_a_of_type_Ofa.b(this.a.getActivity(), this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    }
    try
    {
      this.a.jdField_a_of_type_Ofa.a.a(134248548, null, null, null, null, 0L, false);
      label57:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofl
 * JD-Core Version:    0.7.0.1
 */