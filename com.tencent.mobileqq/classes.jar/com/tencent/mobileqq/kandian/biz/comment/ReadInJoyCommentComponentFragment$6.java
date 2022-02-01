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

class ReadInJoyCommentComponentFragment$6
  implements XPanelContainer.PanelCallback
{
  ReadInJoyCommentComponentFragment$6(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public View a(int paramInt)
  {
    Object localObject;
    if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel == null)
      {
        localObject = ((IEmoticonMainPanelService)ReadInJoyCommentComponentFragment.a(this.a).app.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(ReadInJoyCommentComponentFragment.a(this.a), 1008).setCallBack(ReadInJoyCommentComponentFragment.a(this.a)).setOnlySysAndEmoji(true).setEmoticonListProvider(new RIJEmotionListProvider()).setHideAllSettingTabs(true);
        RIJEmotionCacheManager.a((IEmoticonMainPanelService.PanelBuilder)localObject, ((IEmoticonMainPanelService.PanelBuilder)localObject).getEmoticonMainPanelApp(), ReadInJoyCommentComponentFragment.a(this.a), ReadInJoyCommentComponentFragment.a(this.a));
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = ((IEmoticonMainPanelService.PanelBuilder)localObject).create();
      }
      return this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView();
    }
    if (paramInt == 24)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)
      {
        localObject = this.a;
        ((ReadInJoyCommentComponentFragment)localObject).jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel = ((PublicAccountHotPicPanel)View.inflate(ReadInJoyCommentComponentFragment.a((ReadInJoyCommentComponentFragment)localObject), 2131559604, null));
        this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(ReadInJoyCommentComponentFragment.a(this.a).app, ReadInJoyCommentComponentFragment.a(this.a), null, this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer);
        this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(ReadInJoyCommentComponentFragment.a(this.a));
      }
      return this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 24) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null))
    {
      boolean bool;
      if (paramInt2 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(bool);
    }
    else if ((paramInt2 == 24) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.f();
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
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void s()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.6
 * JD-Core Version:    0.7.0.1
 */