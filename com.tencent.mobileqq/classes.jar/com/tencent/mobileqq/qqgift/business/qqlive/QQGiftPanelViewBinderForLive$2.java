package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGiftPanelViewBinderForLive$2
  implements Observer<SingleEventWrapper<List<List<GiftServiceData>>>>
{
  QQGiftPanelViewBinderForLive$2(QQGiftPanelViewBinderForLive paramQQGiftPanelViewBinderForLive, IQQGiftPanelView paramIQQGiftPanelView) {}
  
  public void a(SingleEventWrapper<List<List<GiftServiceData>>> paramSingleEventWrapper)
  {
    paramSingleEventWrapper = (List)paramSingleEventWrapper.a();
    if (paramSingleEventWrapper != null)
    {
      boolean bool = paramSingleEventWrapper.isEmpty();
      this.a.a(bool);
      if (!bool)
      {
        QQGiftPanelViewBinderForLive.a(this.b).a(paramSingleEventWrapper);
        QQGiftPanelViewBinderForLive.a(this.b).notifyDataSetChanged();
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
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive.2
 * JD-Core Version:    0.7.0.1
 */