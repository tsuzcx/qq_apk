package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyListItemLifeCycle;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class NoteCardProteusItem$1
  implements IReadInJoyListItemLifeCycle
{
  NoteCardProteusItem$1(NoteCardProteusItem paramNoteCardProteusItem, ReadInJoyLottieView paramReadInJoyLottieView, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    NoteCardProteusItem.a(this.d, true);
    if (NoteCardProteusItem.a(this.d) != null) {
      NoteCardProteusItem.a(this.d).a();
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyLottieView)localObject).a();
    }
    localObject = this.b.k().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i;
    if ((NoteCardProteusItem.b(this.d)) && (ReadInJoyNoteCardUtil.a() != 0))
    {
      i = ReadInJoyNoteCardUtil.b(this.c.getContext(), str);
      int k = ReadInJoyNoteCardUtil.c(this.c.getContext(), str);
      if ((i < ReadInJoyNoteCardUtil.e()) && (k < ReadInJoyNoteCardUtil.f()))
      {
        ((ScripCmsInfo)localObject).j = 2;
        ReadInJoyNoteCardUtil.a(this.c.getContext(), str, i + 1);
        ReadInJoyNoteCardUtil.b(this.c.getContext(), str, k + 1);
      }
    }
    if ((ReadInJoyNoteCardUtil.a() == 1) && (ReadInJoyNoteCardUtil.b(this.c.getContext(), str) > 0))
    {
      localObject = this.c.getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i != 0) {
        ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.1.1(this), 1000L);
      }
    }
    NoteCardProteusItem.b(this.d, false);
    localObject = this.b.k();
    if (localObject != null)
    {
      ((AbsBaseArticleInfo)localObject).invalidateProteusTemplateBean();
      ReadInJoyLogicEngineEventDispatcher.a().c();
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    NoteCardProteusItem.a(this.d, false);
    ReadInJoyLottieView localReadInJoyLottieView = this.a;
    if (localReadInJoyLottieView != null) {
      localReadInJoyLottieView.b();
    }
    NoteCardProteusItem.e(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */