package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;

class AETemplateInfoFragment$3
  implements View.OnClickListener
{
  AETemplateInfoFragment$3(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onClick(View paramView)
  {
    AECameraLauncher.a(this.this$0.getActivity(), 1024, AECameraEntry.I.a(), null);
    AETemplateInfoFragment.access$200(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.3
 * JD-Core Version:    0.7.0.1
 */