package dov.com.qq.im.ae.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TabLayout$1
  implements View.OnClickListener
{
  TabLayout$1(TabLayout paramTabLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout.1
 * JD-Core Version:    0.7.0.1
 */