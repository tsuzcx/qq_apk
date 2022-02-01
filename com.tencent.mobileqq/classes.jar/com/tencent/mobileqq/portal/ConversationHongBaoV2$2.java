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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "tryCountdown mState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b(-1L);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.s();
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      ConversationHongBaoV2 localConversationHongBaoV2 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      localConversationHongBaoV2.jdField_e_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int > ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2)) {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll scrollX = " + paramInt1 + ",scrollY = " + paramInt2 + ",nScrollY = " + i + ",mCountDownRedBannerHeight = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int + ",mResume = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int)
    {
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.n) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != 4))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
      return;
      if (i <= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f) {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.r();
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        continue;
        if (i <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
          continue;
          if (i <= this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int)
          {
            ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
            ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(255);
            ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
            if (QLog.isColorLevel()) {
              QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY <= mCountDownRedBannerHeight, mProgressViewRed  set to visible, alpha to 255");
            }
            FrameHelperActivity.b(true);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
            }
            FrameHelperActivity.b(false);
            paramInt1 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int * 2;
            if (-paramInt2 <= paramInt1)
            {
              paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int * 255.0F);
              if (QLog.isColorLevel()) {
                QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll 2*mCountDownRedBannerHeight >= nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
              }
              ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(paramInt1);
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
              break;
              if (QLog.isColorLevel()) {
                QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  alpha to 0 (missing)");
              }
              ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2).setAlpha(0);
            }
          }
        }
      }
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f;
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onTouchDown, " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
    try
    {
      int i = -paramHongBaoListView.getScrollY();
      if ((paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 4)) && (i > ViewUtils.b(1.0F))) {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      }
      return;
    }
    catch (Throwable paramHongBaoListView)
    {
      QLog.e("2021_UI_ConversationHongBaoV2", 1, "onTouchMoving", paramHongBaoListView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTitle direct = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onHongBaoPendantClick mState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
    }
    ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
    ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
    ConversationHongBaoV2 localConversationHongBaoV2 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 3) {}
    for (boolean bool = true;; bool = false)
    {
      localConversationHongBaoV2.f(bool);
      return;
    }
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onTouchRelease, mState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int);
    }
    int i = paramHongBaoListView.getScrollY();
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b = 0;
    if (-i >= this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2)
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
    switch (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int)
    {
    default: 
      if ((-i < this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (-i > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b = 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      }
      if ((-i < this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.n)) {
        a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable, 2000L);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onTouchRelease mState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int + ",pullState = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b != 0)
        {
          paramHongBaoListView = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.b != 2) {
            break label517;
          }
        }
      }
      break;
    }
    label517:
    for (long l = 200L;; l = 2500L)
    {
      paramHongBaoListView.sendEmptyMessageDelayed(1005, l);
      return;
      if ((-i >= this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) || (-i <= 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hideTitle direct = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c(paramBoolean);
  }
  
  public void c()
  {
    boolean bool = false;
    BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localBaseActivityData.pendantData != null) {}
    for (int i = localBaseActivityData.pendantData.closeType;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onHongBaoPendantCloseIconClick mSate = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int + ",closeType = " + i);
      }
      ConversationHongBaoV2 localConversationHongBaoV2 = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 3) {
        bool = true;
      }
      localConversationHongBaoV2.g(bool);
      ConversationHongBaoV2.c(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
      switch (i)
      {
      }
      for (;;)
      {
        ConversationHongBaoV2.d(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
        return;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
        ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(localBaseActivityData);
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
      }
    }
  }
  
  public void d()
  {
    boolean bool = true;
    Object localObject;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int == 4)
    {
      ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      ((ConversationHongBaoV2)localObject).jdField_e_of_type_Int += 1;
      l1 = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int != 1) {
        break label150;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int, ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), true);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long = l1;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int > ConversationHongBaoV2.b(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2)) {
        ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2, this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int);
      }
      if (!ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2)) {
        break label322;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int);
    }
    label150:
    label197:
    while (!QLog.isColorLevel())
    {
      return;
      long l2 = l1 - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long = l1;
      int i;
      String str;
      if (l2 > 600L)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
        i = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_e_of_type_Int;
        str = ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2);
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_d_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Long <= 500L) {
          break label317;
        }
      }
      for (;;)
      {
        ((FormalView)localObject).a(i, str, bool);
        ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(0);
        break;
        if (l2 > 400L)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
          break label197;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(3);
        break label197;
        bool = false;
      }
    }
    label317:
    label322:
    QLog.d("2021_UI_ConversationHongBaoV2", 2, "tryGrab not allowGrabHongbao");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.2
 * JD-Core Version:    0.7.0.1
 */