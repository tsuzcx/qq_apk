package com.tencent.mobileqq.qqgift.mvvm.business;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGiftPanelViewBinder$1
  implements Observer<SingleEventWrapper<List<List<GiftServiceData>>>>
{
  QQGiftPanelViewBinder$1(QQGiftPanelViewBinder paramQQGiftPanelViewBinder, IQQGiftPanelView paramIQQGiftPanelView) {}
  
  public void a(SingleEventWrapper<List<List<GiftServiceData>>> paramSingleEventWrapper)
  {
    paramSingleEventWrapper = (List)paramSingleEventWrapper.a();
    if (paramSingleEventWrapper != null)
    {
      boolean bool = paramSingleEventWrapper.isEmpty();
      this.a.a(bool);
      if (!bool)
      {
        QQGiftPanelViewBinder.a(this.b).a(paramSingleEventWrapper);
        QQGiftPanelViewBinder.a(this.b).notifyDataSetChanged();
      }
      this.a.a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[bindPanelView] onGiftData change,size:");
        localStringBuilder.append(paramSingleEventWrapper.size());
        QLog.i("GiftPanelViewBinder", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewBinder.1
 * JD-Core Version:    0.7.0.1
 */