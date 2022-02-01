package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOBrowserPresenter$2
  implements Runnable
{
  AIOBrowserPresenter$2(AIOBrowserPresenter paramAIOBrowserPresenter, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if ((this.a != this.b.a) && (!this.c))
    {
      if (this.this$0.b.c(this.a) == null)
      {
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRevokeMsg seq:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", selectItem seq:");
        localStringBuilder.append(this.b.a);
        ((IBrowserLog)localObject).i("AIOGalleryPresenter", 2, localStringBuilder.toString());
        return;
      }
      int i = this.this$0.c(this.b.a);
      if ((i >= 0) && (i < this.this$0.b.getCount()))
      {
        this.this$0.b.setSelectedIndex(i);
        this.this$0.a.notifyImageModelDataChanged();
      }
    }
    else
    {
      localObject = this.this$0.a.c();
      if ((localObject instanceof AIOBrowserBaseView)) {
        ((AIOBrowserBaseView)localObject).a(this.a);
      }
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).buildMessageRevokeUI((Activity)this.this$0.a.mContext, this.this$0.a.mRoot);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */