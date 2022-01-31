import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class oke
  implements CompoundButton.OnCheckedChangeListener
{
  public oke(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySelfFragment.a(this.a).b(paramBoolean);
    if (paramBoolean)
    {
      bbmy.a(this.a.a.getContext(), this.a.a.getContext().getResources().getString(2131633866), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
      ndn.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", obz.c(), false);
      return;
    }
    ndn.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", obz.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */