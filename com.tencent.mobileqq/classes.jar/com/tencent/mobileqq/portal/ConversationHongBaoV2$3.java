package com.tencent.mobileqq.portal;

import android.os.CountDownTimer;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class ConversationHongBaoV2$3
  extends CountDownTimer
{
  ConversationHongBaoV2$3(ConversationHongBaoV2 paramConversationHongBaoV2, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    QLog.d("2021_UI_ConversationHongBaoV2", 1, "CountDownTimer onFinish pullState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_b_of_type_Int + ",totalGrabCountForShare = " + ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2) + ",maxComboCountForShare = " + ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2) + ",mResume" + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c);
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    localSpringFestivalEntryManager.d();
    ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, 0L);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
    BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
    EntryConfigBean localEntryConfigBean = localSpringFestivalEntryManager.a();
    String str = null;
    Object localObject = str;
    if (localEntryConfigBean != null)
    {
      localObject = str;
      if (localEntryConfigBean.commonData != null) {
        localObject = localEntryConfigBean.commonData.getShareWordings(ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
      }
    }
    int i = localSpringFestivalEntryManager.a().getShareForbidden();
    str = localBaseActivityData.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c) {
      new ConversationHongBaoV2.ShowSharePageTask(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, (List)localObject, ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), str, ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), i).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.t();
      ConversationHongBaoV2.f(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      return;
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, new ConversationHongBaoV2.ShowSharePageTask(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, (List)localObject, ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), str, ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), i));
    }
  }
  
  public void onTick(long paramLong)
  {
    long l = System.currentTimeMillis();
    ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, paramLong);
    if (l - ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2) > 1000L)
    {
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, l);
      ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, paramLong);
    }
    if (ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramLong);
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).a(paramLong, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangStringBuilder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramLong);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramLong, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_b_of_type_JavaLangStringBuilder);
    }
    paramLong = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d;
    if (paramLong > 2000L) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
    }
    while (paramLong <= 1000L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.3
 * JD-Core Version:    0.7.0.1
 */