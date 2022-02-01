import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class oot
  implements AdapterView.OnItemClickListener
{
  public oot(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a.doOnBackPressed();
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof oov))
    {
      paramAdapterView = (oov)paramAdapterView;
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.jdField_a_of_type_JavaLangString);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.jdField_a_of_type_Long, paramAdapterView.b, "0X800953C", paramAdapterView.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oot
 * JD-Core Version:    0.7.0.1
 */