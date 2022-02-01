package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.ITaskManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.onPendentClickListener;

class ConversationHongBaoV2$18
  implements ARMapHongBaoListView.onPendentClickListener
{
  ConversationHongBaoV2$18(ConversationHongBaoV2 paramConversationHongBaoV2, String paramString, ARMapHongBaoListView paramARMapHongBaoListView, ITaskManager paramITaskManager, BaseActivityData paramBaseActivityData, int paramInt) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNormalActivityPendant onPendentClick jumpUrl = " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a())
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskManager.a();
      ((UserData)localObject1).hasClickedHolder = true;
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "  点击后 [showNormalActivityPendant] userData.hasClickedHolder =  " + ((UserData)localObject1).hasClickedHolder);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e());
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.pendantData;
    Object localObject2;
    if ((localObject1 != null) && (((PendantData)localObject1).clickType == 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if ((!this.jdField_a_of_type_JavaLangString.startsWith("http")) && (!this.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label257;
      }
      localObject2 = new Intent(ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", this.jdField_a_of_type_JavaLangString);
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).startActivity((Intent)localObject2);
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a.a();
      if ((localObject1 != null) && (((PendantData)localObject1).clickType == 1) && (localObject2 != null)) {
        ((MiniAppPullInterface)localObject2).showMicroAppEntry();
      }
      return;
      label257:
      if ((ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2) instanceof BaseActivity))
      {
        localObject2 = JumpParser.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a.a, ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), this.jdField_a_of_type_JavaLangString);
        if (localObject2 != null) {
          ((JumpAction)localObject2).a();
        } else {
          ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).startActivity(new Intent(ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_JavaLangString)));
        }
      }
      else
      {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).startActivity(new Intent(ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_JavaLangString)));
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNormalActivityPendant onPendentCloseBtnClick fCloseType = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.g(false);
    if (this.jdField_a_of_type_Int == 1)
    {
      ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e();
    }
    ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.18
 * JD-Core Version:    0.7.0.1
 */