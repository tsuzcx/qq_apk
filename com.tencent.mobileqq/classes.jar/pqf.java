import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pqf
  implements CompoundButton.OnCheckedChangeListener
{
  public pqf(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySelfFragment.a(this.a).b(paramBoolean);
    if (paramBoolean)
    {
      QQToast.a(this.a.a.getContext(), this.a.a.getContext().getResources().getString(2131698472), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
      oat.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", pha.e(), false);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      oat.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", pha.e(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqf
 * JD-Core Version:    0.7.0.1
 */