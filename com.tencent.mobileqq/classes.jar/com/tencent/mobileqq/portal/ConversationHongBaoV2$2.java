package com.tencent.mobileqq.portal;

import android.os.Handler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;
import mqq.app.AppRuntime;

class ConversationHongBaoV2$2
  implements HongBaoListViewListener
{
  private int jdField_a_of_type_Int = 0;
  
  ConversationHongBaoV2$2(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryCountdown mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b(-1L);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.s();
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int > ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
        ConversationHongBaoV2.a((ConversationHongBaoV2)localObject, ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Boolean) {
      b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int != 0) && (paramInt2 == 0)) {
      a(false);
    }
    this.jdField_a_of_type_Int = paramInt2;
    int i = -paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" [dddd] onOverScroll scrollX = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",scrollY = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",nScrollY = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",mCountDownRedBannerHeight = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c) {
      return;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int;
    if (paramInt1 != 3)
    {
      if (paramInt1 != 4)
      {
        if ((paramInt1 == 5) && (i <= 0))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f) {
            this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.r();
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        }
      }
      else if (i <= this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int)
      {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(255);
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY <= mCountDownRedBannerHeight, mProgressViewRed  set to visible, alpha to 255");
        }
        FrameHelperActivity.a(true);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
        }
        FrameHelperActivity.a(false);
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int * 2;
        if (i <= paramInt1)
        {
          paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int * 255.0F);
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll 2*mCountDownRedBannerHeight >= nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
          }
          ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(paramInt1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  alpha to 0 (missing)");
          }
          ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
      }
    }
    else if (i <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.n) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != 4))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
      return;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int;
    if (paramInt1 != 2)
    {
      if (paramInt1 != 5) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      paramHongBaoListView = new StringBuilder();
      paramHongBaoListView.append("onTouchDown, ");
      paramHongBaoListView.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramHongBaoListView.toString());
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
    try
    {
      int i = -paramHongBaoListView.getScrollY();
      if ((paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 4)) && (i > ViewUtils.b(1.0F)))
      {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
        return;
      }
    }
    catch (Throwable paramHongBaoListView)
    {
      QLog.e("2021_UI_ConversationHongBaoV2", 1, "onTouchMoving", paramHongBaoListView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTitle direct = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHongBaoPendantClick mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
    ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    boolean bool;
    if (((ConversationHongBaoV2)localObject).jdField_a_of_type_Int == 3) {
      bool = true;
    } else {
      bool = false;
    }
    ((ConversationHongBaoV2)localObject).f(bool);
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchRelease, mState = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    int i = paramHongBaoListView.getScrollY();
    paramHongBaoListView = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    paramHongBaoListView.b = 0;
    i = -i;
    if (i >= paramHongBaoListView.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 2) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Long > 500L))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Long = System.currentTimeMillis();
        ConversationHongBaoV2.e(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 5) {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b = 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != 4)
    {
      if ((i < this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (i > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b = 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      }
    }
    else if ((i < this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (i > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
    }
    if ((i < this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.n)) {
      a(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable, 2000L);
    if (QLog.isColorLevel())
    {
      paramHongBaoListView = new StringBuilder();
      paramHongBaoListView.append("onTouchRelease mState = ");
      paramHongBaoListView.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      paramHongBaoListView.append(",pullState = ");
      paramHongBaoListView.append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramHongBaoListView.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b != 0)
      {
        paramHongBaoListView = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler;
        long l;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b == 2) {
          l = 200L;
        } else {
          l = 2500L;
        }
        paramHongBaoListView.sendEmptyMessageDelayed(1005, l);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideTitle direct = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c(paramBoolean);
  }
  
  public void c()
  {
    BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    Object localObject = localBaseActivityData.pendantData;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = localBaseActivityData.pendantData.closeType;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHongBaoPendantCloseIconClick mSate = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",closeType = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (((ConversationHongBaoV2)localObject).jdField_a_of_type_Int == 3) {
      bool = true;
    }
    ((ConversationHongBaoV2)localObject).g(bool);
    ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if (i == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
          ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(localBaseActivityData);
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
      }
    }
    ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 4)
    {
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      int i = ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int;
      boolean bool = true;
      ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int = (i + 1);
      long l1 = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int, ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), true);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long = l1;
      }
      else
      {
        long l2 = l1 - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long;
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
        ((ConversationHongBaoV2)localObject).jdField_d_of_type_Long = l1;
        if (l2 > 600L)
        {
          ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int = 1;
          ((ConversationHongBaoV2)localObject).jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
        }
        else if (l2 > 400L)
        {
          ((ConversationHongBaoV2)localObject).jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
        }
        else
        {
          ((ConversationHongBaoV2)localObject).jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(3);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
        i = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int;
        String str = ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Long <= 500L) {
          bool = false;
        }
        ((FormalView)localObject).a(i, str, bool);
        ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int > ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
        ConversationHongBaoV2.a((ConversationHongBaoV2)localObject, ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int);
      }
      if (ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "tryGrab not allowGrabHongbao");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.2
 * JD-Core Version:    0.7.0.1
 */