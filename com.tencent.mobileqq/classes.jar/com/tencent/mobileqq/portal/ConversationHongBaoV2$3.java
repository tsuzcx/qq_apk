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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CountDownTimer onFinish pullState = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_b_of_type_Int);
    ((StringBuilder)localObject1).append(",totalGrabCountForShare = ");
    ((StringBuilder)localObject1).append(ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
    ((StringBuilder)localObject1).append(",maxComboCountForShare = ");
    ((StringBuilder)localObject1).append(ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
    ((StringBuilder)localObject1).append(",mResume");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c);
    QLog.d("2021_UI_ConversationHongBaoV2", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject2).d();
    ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, 0L);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g((BaseActivityData)localObject3);
    localObject1 = ((SpringFestivalEntryManager)localObject2).a();
    if ((localObject1 != null) && (((EntryConfigBean)localObject1).commonData != null)) {
      localObject1 = ((EntryConfigBean)localObject1).commonData.getShareWordings(ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
    } else {
      localObject1 = null;
    }
    int i = ((SpringFestivalEntryManager)localObject2).a().getShareForbidden();
    localObject2 = ((BaseActivityData)localObject3).getId();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      new ConversationHongBaoV2.ShowSharePageTask((ConversationHongBaoV2)localObject3, (List)localObject1, ConversationHongBaoV2.a((ConversationHongBaoV2)localObject3), (String)localObject2, ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), i).a();
    }
    else
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      ConversationHongBaoV2.a((ConversationHongBaoV2)localObject3, new ConversationHongBaoV2.ShowSharePageTask((ConversationHongBaoV2)localObject3, (List)localObject1, ConversationHongBaoV2.a((ConversationHongBaoV2)localObject3), (String)localObject2, ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), i));
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.t();
    ConversationHongBaoV2.f(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
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
    if (paramLong > 2000L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
      return;
    }
    if (paramLong > 1000L) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.3
 * JD-Core Version:    0.7.0.1
 */