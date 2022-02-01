package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionListProvider;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;

class ReadInJoyCommentComponentFragment$7
  implements XPanelContainer.PanelCallback
{
  ReadInJoyCommentComponentFragment$7(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 24) && (this.a.A != null))
    {
      boolean bool;
      if (paramInt2 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.a.A.a(bool);
    }
    else if ((paramInt2 == 24) && (this.a.A != null))
    {
      this.a.A.g();
    }
    if (paramInt2 == 1)
    {
      ReadInJoyCommentComponentFragment.a(this.a, 1);
      return;
    }
    if (paramInt2 == 3)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
      ReadInJoyCommentComponentFragment.a(this.a, 2);
      return;
    }
    if (paramInt2 == 0)
    {
      ReadInJoyCommentComponentFragment.a(this.a, 0);
      return;
    }
    if (paramInt2 == 24) {
      ReadInJoyCommentComponentFragment.a(this.a, 3);
    }
  }
  
  public View b(int paramInt)
  {
    Object localObject;
    if (paramInt == 3)
    {
      if (this.a.z == null)
      {
        localObject = ((IEmoticonMainPanelService)ReadInJoyCommentComponentFragment.b(this.a).app.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(ReadInJoyCommentComponentFragment.b(this.a), 1008).setCallBack(ReadInJoyCommentComponentFragment.e(this.a)).setOnlySysAndEmoji(true).setEmoticonListProvider(new RIJEmotionListProvider()).setHideAllSettingTabs(true);
        RIJEmotionCacheManager.a((IEmoticonMainPanelService.PanelBuilder)localObject, ((IEmoticonMainPanelService.PanelBuilder)localObject).getEmoticonMainPanelApp(), ReadInJoyCommentComponentFragment.b(this.a), ReadInJoyCommentComponentFragment.e(this.a));
        this.a.z = ((IEmoticonMainPanelService.PanelBuilder)localObject).create();
      }
      return this.a.z.getView();
    }
    if (paramInt == 24)
    {
      if (this.a.A == null)
      {
        localObject = this.a;
        ((ReadInJoyCommentComponentFragment)localObject).A = ((PublicAccountHotPicPanel)View.inflate(ReadInJoyCommentComponentFragment.b((ReadInJoyCommentComponentFragment)localObject), 2131625633, null));
        this.a.A.a(ReadInJoyCommentComponentFragment.b(this.a).app, ReadInJoyCommentComponentFragment.b(this.a), null, this.a.y);
        this.a.A.setPublicAccountGifListener(ReadInJoyCommentComponentFragment.f(this.a));
      }
      return this.a.A;
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  public void v()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.a.y.getCurrentPanelView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.7
 * JD-Core Version:    0.7.0.1
 */