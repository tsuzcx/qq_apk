package com.tencent.mobileqq.kandian.biz.framework;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class RIJShakeManager$1
  extends ShakeListener
{
  RIJShakeManager$1(RIJShakeManager paramRIJShakeManager) {}
  
  protected void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ReadInJoyNoteCardUtil.a(RIJShakeManager.a(this.a).a().a(), str) < ScripCmsInfo.d)
    {
      ((ReadInJoyXListView)RIJShakeManager.a(this.a).a().a().a()).c(6);
      return;
    }
    QQToast.a(RIJShakeManager.a(this.a).a().a(), 0, RIJShakeManager.a(this.a).a().a().getString(2131718069), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJShakeManager.1
 * JD-Core Version:    0.7.0.1
 */