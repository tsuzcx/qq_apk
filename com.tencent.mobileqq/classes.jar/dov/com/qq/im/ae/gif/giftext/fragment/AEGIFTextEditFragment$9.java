package dov.com.qq.im.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFTextEditFragment$9
  implements View.OnClickListener
{
  AEGIFTextEditFragment$9(AEGIFTextEditFragment paramAEGIFTextEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEGIFTextEditFragment.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.9
 * JD-Core Version:    0.7.0.1
 */