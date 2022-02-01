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
    if (ReadInJoyNoteCardUtil.a(RIJShakeManager.a(this.a).a().A(), str) < ScripCmsInfo.o)
    {
      ((ReadInJoyXListView)RIJShakeManager.a(this.a).a().v().d()).d(6);
      return;
    }
    QQToast.makeText(RIJShakeManager.a(this.a).a().A(), 0, RIJShakeManager.a(this.a).a().A().getString(2131915546), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJShakeManager.1
 * JD-Core Version:    0.7.0.1
 */