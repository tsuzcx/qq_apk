package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor.RichTitleConfBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.music.LyricStateListener;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AioFriendTitleHelper
  implements ILifeCycleHelper, LyricStateListener
{
  public static int a = 259200;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AioFriendTitleHelper.3(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewFlipper jdField_a_of_type_AndroidWidgetViewFlipper;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  public AioFriendTitleHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private Friends a()
  {
    return ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  private void a(RichStatus paramRichStatus)
  {
    if (paramRichStatus != null)
    {
      String str = paramRichStatus.getPlainText();
      long l1 = paramRichStatus.time;
      long l2 = NetConnInfoCenter.getServerTime();
      paramRichStatus = RichTitleConfProcessor.a();
      if (paramRichStatus != null)
      {
        jdField_a_of_type_Int = (int)(paramRichStatus.a * 60.0D * 60.0D);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("needShowRichSubTitle-> richTitleConfBean.c2c_time_interval = ");
          localStringBuilder.append(paramRichStatus.a);
          QLog.d("AioFriendTitleHelper", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramRichStatus = new StringBuilder();
        paramRichStatus.append("needShowRichSubTitle-> c = ");
        paramRichStatus.append(l2);
        paramRichStatus.append(" time = ");
        paramRichStatus.append(l1);
        paramRichStatus.append(" needShow =");
        boolean bool;
        if (l2 - l1 < jdField_a_of_type_Int) {
          bool = true;
        } else {
          bool = false;
        }
        paramRichStatus.append(bool);
        QLog.d("AioFriendTitleHelper", 2, paramRichStatus.toString());
      }
      if (l2 - l1 < jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Boolean = (TextUtils.isEmpty(str) ^ true);
        a(str);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A66A", "0X800A66A", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
      this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
    }
    if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
    }
    if (paramBoolean2) {
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_AndroidWidgetTextView, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioFriendTitleHelper", 2, new Object[] { "resetSubTitleText, ", paramString });
    }
  }
  
  private void f()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) && (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())))
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 1 startFlipping all Visibility");
        }
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
      if (!this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.startFlipping();
      }
    }
    else
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) && (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView))
      {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        return;
      }
      if ((TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) && (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_b_of_type_AndroidWidgetTextView)) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
    }
  }
  
  public void a()
  {
    b(null);
  }
  
  public void a(ViewFlipper paramViewFlipper, TextView paramTextView1, TextView paramTextView2)
  {
    this.jdField_a_of_type_AndroidWidgetViewFlipper = paramViewFlipper;
    this.jdField_a_of_type_AndroidWidgetViewFlipper.setOutAnimation(null);
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    e();
    d();
    paramViewFlipper = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((paramViewFlipper instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)paramViewFlipper).setLyricStateListener(this);
    }
  }
  
  protected void a(String paramString)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (this.jdField_a_of_type_AndroidWidgetViewFlipper != null) && (localTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(paramString, 3, 12));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b("");
    }
  }
  
  public boolean a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView instanceof OnlineStatusLyricView)) {
      return ((OnlineStatusLyricView)localTextView).a();
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowRichSubTitle, onShowSubTitleText() isShowInputStatus =  ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" statusText = ");
      localStringBuilder.append(paramString);
      QLog.i("AioFriendTitleHelper", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AioFriendTitleHelper.2(this, paramBoolean, paramString));
    return true;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.C) && (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (c())
    {
      a(false, false, "isListenTogetherTime");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a(false, true, "isInputting");
      return;
    }
    if (b())
    {
      a(true, true, "isStatusOffline");
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.C)
    {
      a(true, true, "mChatPie.setSubTitleVisible");
      return;
    }
    if (a())
    {
      a(false, false, "isPlayLyric");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle");
      }
      f();
    }
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_AndroidWidgetTextView, true);
  }
  
  public boolean b()
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localObject == null)
    {
      ThreadManager.post(new AioFriendTitleHelper.4(this), 8, null, true);
      return false;
    }
    int i = OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needShowRichSubTitle, isStatusOffline() -> status = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("AioFriendTitleHelper", 2, ((StringBuilder)localObject).toString());
    }
    return i == 0;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetViewFlipper;
    if (localObject != null)
    {
      if (((ViewFlipper)localObject).getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setText("");
      if (QLog.isColorLevel()) {
        QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> destroy()");
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)localObject).d();
    }
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    int j = 0;
    if (localObject == null) {
      return false;
    }
    localObject = (C2CListenTogetherPanel)((BaseChatPie)localObject).a(32);
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((C2CListenTogetherPanel)localObject).c()) {
        i = 1;
      }
    }
    if (i != 0) {
      return true;
    }
    return ((TogetherControlHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(43)).c();
  }
  
  protected void d()
  {
    RichStatus localRichStatus = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    if ((localRichStatus != null) && (!localRichStatus.isEmpty()))
    {
      a(localRichStatus);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AioFriendTitleHelper.1(this));
  }
  
  public void e()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetViewFlipper == null) {
        return;
      }
      localTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
    }
  }
  
  public String getTag()
  {
    return "AioFriendTitleHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 11)
        {
          if (paramInt != 15) {
            return;
          }
          c();
          return;
        }
        ViewFlipper localViewFlipper = this.jdField_a_of_type_AndroidWidgetViewFlipper;
        if ((localViewFlipper != null) && (localViewFlipper.isFlipping())) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
        }
      }
      else
      {
        b("");
      }
    }
    else {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQqViewFlipper, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper
 * JD-Core Version:    0.7.0.1
 */