package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.shortvideo.QIMBeautyManager;
import java.util.List;

class AdvancedProviderView$4
  implements View.OnClickListener
{
  AdvancedProviderView$4(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = QIMBeautyManager.a().a();
    if (localList.size() > 1) {
      WeishiGuideUtils.a(this.a.a, localList.get(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView.4
 * JD-Core Version:    0.7.0.1
 */