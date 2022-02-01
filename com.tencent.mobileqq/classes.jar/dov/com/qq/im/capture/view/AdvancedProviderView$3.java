package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.shortvideo.QIMBeautyManager;
import java.util.List;

class AdvancedProviderView$3
  implements View.OnClickListener
{
  AdvancedProviderView$3(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = QIMBeautyManager.a().a();
    if (localList.size() > 0) {
      WeishiGuideUtils.a(this.a.a, localList.get(0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView.3
 * JD-Core Version:    0.7.0.1
 */