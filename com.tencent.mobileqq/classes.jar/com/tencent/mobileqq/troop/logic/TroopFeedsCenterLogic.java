package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopFeedsCenterLogic
  extends Observable
  implements Observer
{
  protected int a;
  public View a;
  protected Animation.AnimationListener a;
  protected TranslateAnimation a;
  protected ImageView a;
  protected RelativeLayout a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected TroopInfoManager a;
  protected TroopAioTips a;
  protected TroopFeedsDataManager a;
  QQCustomDialog a;
  protected String a;
  protected WeakReference<BaseActivity> a;
  protected boolean a;
  protected TranslateAnimation b;
  protected ImageView b;
  protected RelativeLayout b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  protected boolean f = false;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean k = false;
  
  public TroopFeedsCenterLogic(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, TroopAioTips paramTroopAioTips, boolean paramBoolean, Observer paramObserver)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new TroopFeedsCenterLogic.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
    this.j = paramBoolean;
    this.k = paramQQAppInterface.getHotChatMng(true).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramBaseActivity.getResources().getDimensionPixelSize(2131299212);
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    if (paramBaseActivity != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramBaseActivity.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      label216:
      break label216;
    }
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append("NumberFormatException, mSessionInfo.curFriendUin:");
      paramBaseActivity.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.e("TroopFeedsCenterLogic", 2, paramBaseActivity.toString());
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    if (paramBoolean)
    {
      if (a()) {
        return;
      }
      Object localObject2;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(0);
          return;
        }
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((BaseActivity)localObject1).findViewById(2131369258));
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mRightTitleLayout == null,");
          ((StringBuilder)localObject2).append(localObject1.getClass().getName());
          QLog.w("TroopFeedsCenterLogic", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      int m = AIOUtils.b(10.0F, ((BaseActivity)localObject1).getResources());
      int n = AIOUtils.b(8.0F, ((BaseActivity)localObject1).getResources());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(((BaseActivity)localObject1).getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850766);
      localObject1 = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131369211);
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131369211);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, n, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
    }
  }
  
  public int a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    TroopAioTips localTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localTroopAioTips != null) {
      localTroopAioTips.d = false;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      localObject = AnimationUtils.loadInterpolator(((BaseActivity)localObject).getActivity(), 17432582);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int * -1);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    if (!this.i) {
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatAnnounceDialog(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsCenterLogic.troop.notification_center", 2, "destory");
    }
    e(false);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && ((localObject instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)localObject).c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        ((RelativeLayout)localObject).removeView(localView);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localObject != null) {
      ((TroopAioTips)localObject).d = false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if (localObject != null)
    {
      ((TroopFeedsDataManager)localObject).deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
      }
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    deleteObservers();
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    a();
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    this.g = paramBoolean;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.g) {
        this.d = false;
      }
      this.c = true;
      d(false);
      ((ITroopRedDotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
      this.jdField_a_of_type_JavaLangString = "1";
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = "0";
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localObject2 != null) {
      ((TroopAioTips)localObject2).d = true;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      localObject2 = AnimationUtils.loadInterpolator(((BaseActivity)localObject1).getActivity(), 17432582);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Int * -1, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject2);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillEnabled(true);
    }
    localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 == null)
    {
      localObject2 = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      this.jdField_a_of_type_AndroidViewView = new TroopAioFeedsCenterView(localQQAppInterface, (Context)localObject1, localSessionInfo, ((TroopGagMgr)localObject2).a(localSessionInfo.jdField_a_of_type_JavaLangString), this);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setId(2131379149);
      localObject2 = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((BaseActivity)localObject1).getResources().getDimensionPixelSize(2131299168);
      int m = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
      while (m >= 0)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(m);
        if ((localObject1 instanceof TroopAioFeedsCenterView))
        {
          ((TroopAioFeedsCenterView)localObject1).c();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
        }
        m -= 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
      this.c = true;
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      if (this.c) {
        ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
      }
    }
    else if (((View)localObject2).getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      if (this.c) {
        ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
      }
    }
    if (!this.c)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
      if ((localObject1 != null) && (((TroopFeedsDataManager)localObject1).a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
      {
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      if (!paramBoolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    this.h = true;
  }
  
  public void d(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.c = true;
      if (!a())
      {
        this.jdField_a_of_type_Boolean = true;
        e(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localBaseActivity.getString(2131697229));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    e(false);
    this.jdField_b_of_type_Boolean = false;
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localBaseActivity.getString(2131697228));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localBaseActivity.getString(2131697227));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() == 104)
      {
        this.c = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new TroopFeedsCenterLogic.2(this));
        return;
      }
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103))
      {
        if (((paramObservable.intValue() == 1008) || (paramObservable.intValue() == 1009)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
        {
          paramObject = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(0);
          if ((paramObject.type != 5) && (paramObject.type != 19)) {
            return;
          }
          if (paramObservable.intValue() == 1009)
          {
            d(false);
            ((ITroopRedDotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
          }
        }
      }
      else
      {
        if (this.h)
        {
          paramObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
          if ((paramObject != null) && (paramObject.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
          {
            if (!this.g) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            }
          }
          else if (!this.g) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          } else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          }
        }
        if (paramObservable.intValue() == 103) {
          this.c = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic
 * JD-Core Version:    0.7.0.1
 */