package com.tencent.mobileqq.troop.logic;

import aixy;
import aixz;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.widget.HotChatAnnounceDialog;
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
  public TranslateAnimation a;
  protected ImageView a;
  protected RelativeLayout a;
  public SessionInfo a;
  public QQAppInterface a;
  protected TroopInfoManager a;
  public TroopAioTips a;
  public TroopFeedsDataManager a;
  HotChatAnnounceDialog a;
  protected String a;
  public WeakReference a;
  protected boolean a;
  public TranslateAnimation b;
  public ImageView b;
  protected RelativeLayout b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  protected boolean g;
  protected boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  
  public TroopFeedsCenterLogic(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, TroopAioTips paramTroopAioTips, boolean paramBoolean, Observer paramObserver)
  {
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aixy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
    this.j = paramBoolean;
    this.k = paramQQAppInterface.a(true).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramFragmentActivity.getResources().getDimensionPixelSize(2131558959);
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(36));
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
      if (paramObserver != null) {
        addObserver(paramObserver);
      }
      return;
    }
    catch (NumberFormatException paramFragmentActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopFeedsCenterLogic", 2, "NumberFormatException, mSessionInfo.curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break;
          }
        } while (a());
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((BaseActivity)localObject).findViewById(2131363228));
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TroopFeedsCenterLogic", 2, "mRightTitleLayout == null," + localObject.getClass().getName());
      return;
      int m = AIOUtils.a(10.0F, ((FragmentActivity)localObject).getResources());
      int n = AIOUtils.a(8.0F, ((FragmentActivity)localObject).getResources());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(((BaseActivity)localObject).getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845923);
      localObject = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131363979);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131363979);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, n, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    } while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView.getHeight();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
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
    } while (this.i);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog = new HotChatAnnounceDialog(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.show();
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
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsCenterLogic.troop.notification_center", 2, "destory");
    }
    e(false);
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36));
      }
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.dismiss();
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
    Object localObject1 = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
      TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
    }
    Object localObject2;
    for (this.jdField_a_of_type_JavaLangString = "1";; this.jdField_a_of_type_JavaLangString = "0")
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = true;
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
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break label492;
      }
      localObject2 = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      this.jdField_a_of_type_AndroidViewView = new TroopAioFeedsCenterView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((TroopGagMgr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setId(2131361993);
      localObject2 = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((FragmentActivity)localObject1).getResources().getDimensionPixelSize(2131558448);
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
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
    this.c = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    if (this.c) {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
    }
    while (!this.c) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
      {
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          return;
          label492:
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(4);
            this.jdField_a_of_type_AndroidViewView.requestLayout();
            this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
            if (this.c) {
              ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
            }
          }
        }
        else
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", this.jdField_a_of_type_JavaLangString, "");
        }
      }
      else
      {
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
    }
    this.h = true;
  }
  
  public void d(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFragmentActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.c = true;
      if (!a())
      {
        this.jdField_a_of_type_Boolean = true;
        e(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131429878));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    e(false);
    this.jdField_b_of_type_Boolean = false;
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131429879));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131429877));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() != 104) {
        break label42;
      }
      this.c = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new aixz(this));
    }
    label42:
    label196:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103)) {
            break;
          }
          if (this.h)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= 0)) {
              break label196;
            }
            if (this.g) {
              break label157;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          }
          while (paramObservable.intValue() == 103)
          {
            this.c = true;
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            continue;
            if (!this.g) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            }
          }
        }
      } while (((paramObservable.intValue() != 1008) && (paramObservable.intValue() != 1009)) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= 0));
      paramObject = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(0);
    } while (((paramObject.type != 5) && (paramObject.type != 19)) || (paramObservable.intValue() != 1009));
    label157:
    d(false);
    TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic
 * JD-Core Version:    0.7.0.1
 */