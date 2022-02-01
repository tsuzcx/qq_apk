package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class TroopFeedsCenterLogic$1
  implements Animation.AnimationListener
{
  TroopFeedsCenterLogic$1(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Object localObject1 = this.a;
    ((TroopFeedsCenterLogic)localObject1).i = false;
    ((TroopFeedsCenterLogic)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    Object localObject2 = this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
    localObject1 = Integer.valueOf(123322);
    if (localObject2 == paramAnimation)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
        TroopFeedsCenterLogic.a(this.a);
        this.a.notifyObservers(localObject1);
        this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.d(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if (this.a.e)
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131697612), 1).b(((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 5.0F));
          return;
        }
        localObject1 = (TroopAioADManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_AD_MANAGER);
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          TroopAioTopADInfo localTroopAioTopADInfo = ((TroopAioADManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          if (localTroopAioTopADInfo != null)
          {
            if (TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
              paramAnimation = localTroopAioTopADInfo.backgroundUrl;
            } else {
              paramAnimation = localTroopAioTopADInfo.jumpUrl;
            }
            Object localObject3 = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), paramAnimation);
            if (localObject3 != null)
            {
              ((JumpAction)localObject3).a();
            }
            else if (paramAnimation.startsWith("http"))
            {
              localObject3 = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", URLUtil.guessUrl(paramAnimation));
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject3);
            }
            paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localTroopAioTopADInfo.adId);
            localStringBuilder.append("");
            ReportController.b(paramAnimation, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, (String)localObject3, localStringBuilder.toString(), "", "");
          }
          ((TroopAioADManager)localObject1).a((String)localObject2);
          this.a.d = false;
        }
      }
    }
    else if (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null))
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
        TroopFeedsCenterLogic.b(this.a);
        this.a.notifyObservers(localObject1);
        if ((this.a.c) && (this.a.jdField_a_of_type_AndroidViewView != null) && ((this.a.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView))) {
          if (this.a.d)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b();
          }
          else if (this.a.f)
          {
            ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a();
            this.a.f = false;
          }
          else
          {
            paramAnimation = this.a;
            paramAnimation.c = false;
            ((TroopAioFeedsCenterView)paramAnimation.jdField_a_of_type_AndroidViewView).a(true);
          }
        }
      }
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        this.a.jdField_a_of_type_AndroidViewView.requestFocus();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic.1
 * JD-Core Version:    0.7.0.1
 */