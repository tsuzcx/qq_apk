package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WeiShiGuideView
  implements View.OnClickListener
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b, this.jdField_a_of_type_JavaLangString);
    }
    for (String str = "clk_open";; str = "clk_download")
    {
      StoryReportor.a("weishi_share", str, 0, 0, new String[0]);
      break;
      QQToast.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131716729), 0).a();
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.WeiShiGuideView
 * JD-Core Version:    0.7.0.1
 */