package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.autoreply.AutoReplyServlet;
import com.tencent.mobileqq.onlinestatus.music.LyricStateListener;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi.PaiYiPaiCallback;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusTranslateUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class OnlineStatusAIOPopUpWindow
  extends PopupWindow
  implements View.OnClickListener, LyricStateListener, IOnlineStatusAIOTempApi.PaiYiPaiCallback, OnlineStatusController.PanelTouchListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private IAccountPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
  private OnlineStatusLyricView jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView;
  private OnlineStatusController jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private BusinessObserver jdField_b_of_type_ComTencentMobileqqAppBusinessObserver;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public OnlineStatusAIOPopUpWindow(AppInterface paramAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, true, true);
    this.jdField_b_of_type_ComTencentMobileqqAppBusinessObserver = ((IOnlineStatusAIOTempApi)QRoute.api(IOnlineStatusAIOTempApi.class)).getPaiYiPaiObserver(paramAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new OnlineStatusAIOPopUpWindow.1(this, paramAppInterface);
  }
  
  public static OnlineStatusAIOPopUpWindow a(AppInterface paramAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    paramAppInterface = new OnlineStatusAIOPopUpWindow(paramAppInterface, paramActivity, paramBaseSessionInfo, LayoutInflater.from(paramActivity).inflate(2131561500, null), paramInt1, paramInt2);
    paramAppInterface.c();
    paramAppInterface.d();
    return paramAppInterface;
  }
  
  private void a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setOutlineProvider(new OnlineStatusAIOPopUpWindow.4(this));
    }
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView = paramTextView.getPaint();
    paramTextView.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView.setStrokeWidth(1.0F);
  }
  
  private void k()
  {
    this.jdField_a_of_type_MqqAppAppRuntime$Status = OnlineStatusTranslateUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    l();
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
    if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) != 0) || ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.strTermDesc)) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.strTermDesc.contains("TIM")))))
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
      boolean bool1 = true;
      localObject = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uExtOnlineStatus, bool2 ^ true);
      if ((OnlineStatusUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) != 4) || (((OnlineStatusItem)localObject).a <= 0L) || (localObject == null)) {
        bool1 = false;
      }
      String str = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.d, 1, (OnlineStatusItem)localObject, Boolean.valueOf(bool1));
      if ((!TextUtils.isEmpty(str)) && (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a)))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).showOnlineStatusDrawable(this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_c_of_type_AndroidWidgetTextView, false, (OnlineStatusItem)localObject, 5);
      }
      a((OnlineStatusItem)localObject, str);
    }
  }
  
  private void m()
  {
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
    OnlineStatusItem localOnlineStatusItem = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uExtOnlineStatus, bool ^ true);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel((QBaseActivity)this.jdField_a_of_type_AndroidAppActivity, 2);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(localOnlineStatusItem);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(new OnlineStatusAIOPopUpWindow.3(this));
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.a()) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (isShowing())
    {
      IAccountPanel localIAccountPanel = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
      if ((localIAccountPanel != null) && (localIAccountPanel.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131693119, 0).a();
    }
  }
  
  protected void a(OnlineStatusItem paramOnlineStatusItem, String paramString)
  {
    if ((paramOnlineStatusItem.a != 1030L) && (paramOnlineStatusItem.a != 1040L) && (paramOnlineStatusItem.a != 1028L))
    {
      if (OnlineStatusTranslateUtils.a(this.jdField_a_of_type_MqqAppAppRuntime$Status))
      {
        f();
        return;
      }
      this.d.setVisibility(8);
      return;
    }
    if (paramOnlineStatusItem.a == 1030L)
    {
      e();
      g();
      return;
    }
    if (paramOnlineStatusItem.a == 1028L)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId)) {
        e();
      }
      a(paramString);
      return;
    }
    if (paramOnlineStatusItem.a == 1040L)
    {
      e();
      h();
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setText(paramString);
    ((OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName())).a(this.jdField_a_of_type_ComTencentMobileqqDataFriends);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setFriendSession(this.jdField_a_of_type_ComTencentMobileqqDataFriends, paramString);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setLyricStateListener(this);
    this.d.setVisibility(8);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QQTheme.a();
    int i;
    if (paramBoolean2) {
      i = 2130839424;
    } else {
      i = 2130839422;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (bool) {
      i = 2130839421;
    }
    ((View)localObject).setBackgroundResource(i);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    String str = "#FFFFFF";
    if (bool) {}
    while (paramBoolean1)
    {
      localObject = "#FFFFFF";
      break;
    }
    localObject = "#03081A";
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (bool) {}
    while (paramBoolean1)
    {
      localObject = "#FFFFFF";
      break;
    }
    localObject = "#03081A";
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localTextView = this.e;
    if (bool) {
      localObject = str;
    } else if (paramBoolean1) {
      localObject = str;
    } else {
      localObject = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localObject = this.jdField_b_of_type_AndroidViewView;
    int j = 2130846338;
    if (bool) {
      i = 2130846338;
    } else {
      i = 2130846337;
    }
    ((View)localObject).setBackgroundResource(i);
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (bool) {
      i = j;
    } else {
      i = 2130846337;
    }
    ((View)localObject).setBackgroundResource(i);
    ViewCompat.setElevation(this.jdField_b_of_type_AndroidViewView, ViewUtils.a(4.0F));
    a(this.jdField_b_of_type_AndroidViewView);
    ViewCompat.setElevation(this.jdField_c_of_type_AndroidViewView, ViewUtils.a(4.0F));
    a(this.jdField_c_of_type_AndroidViewView);
    a(this.e);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    a(this.jdField_c_of_type_AndroidWidgetTextView);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setVisibility(8);
  }
  
  protected void c()
  {
    View localView = getContentView();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController = ((OnlineStatusController)localView.findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368829));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368850));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131368843);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368840));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131368839);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368833));
    this.d = ((TextView)localView.findViewById(2131368834));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131379076));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView = ((OnlineStatusLyricView)localView.findViewById(2131368835));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131372104);
    this.e = ((TextView)localView.findViewById(2131368830));
    Object localObject = ((IQQAvatarCompatibleService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, (byte)3, 100, false, (byte)1, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
    this.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.setVisibility(8);
    localObject = new StringBuilder(HardCodeUtil.a(2131694679));
    ((StringBuilder)localObject).append(OnlineStatusTranslateUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.gender));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    localView.findViewById(2131370156).setOnClickListener(this);
    localView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController.setAtPanelTouchListener(this);
    a(false, false);
  }
  
  protected void d()
  {
    k();
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView.d();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppBusinessObserver);
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  protected void e()
  {
    Drawable localDrawable;
    if (QQTheme.a()) {
      localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841521);
    } else {
      localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839269);
    }
    Object localObject = MobileQQ.sMobileQQ;
    int i = Utils.a(20.0F, MobileQQ.getContext().getResources());
    localDrawable.setBounds(0, 0, i, i);
    localObject = this.jdField_c_of_type_AndroidWidgetTextView.getCompoundDrawables();
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(localObject[0], localObject[1], localDrawable, localObject[3]);
  }
  
  protected void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      AutoReplyServlet.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, new OnlineStatusAIOPopUpWindow.2(this));
    }
  }
  
  protected void g()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.weatherDecs == null) {
      str = "";
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqDataFriends.weatherDecs;
    }
    if (!StringUtil.a(str))
    {
      this.d.setVisibility(0);
      this.d.setText(str);
      return;
    }
    this.d.setVisibility(8);
  }
  
  protected void h()
  {
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.constellationLuckyColor))
    {
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131693869));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataFriends.constellationLuckyColor);
      int i = 0;
      while (i < 4)
      {
        ((StringBuilder)localObject).append(" ");
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.constellationLuckyNumber))
    {
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131693870));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataFriends.constellationLuckyNumber);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (!StringUtil.a((String)localObject))
    {
      this.d.setVisibility(0);
      this.d.setText((CharSequence)localObject);
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController.scrollTo(0, 0);
    Animation localAnimation = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    if ((localAnimation != null) && (!localAnimation.hasEnded())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772011);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewOnlineStatusController.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void j() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131379076)
    {
      dismiss();
    }
    else if (i == 2131372104)
    {
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).handleAIOSubTitleClicked(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, paramView);
    }
    else
    {
      String str = "";
      if (i == 2131368843)
      {
        m();
        if (this.d.getText() != null) {
          str = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
        }
        ReportHelperKt.a("0X800BBDE", 0, "0", str);
      }
      else if (i == 2131368839)
      {
        if (AppNetConnInfo.isNetSupport())
        {
          ((IOnlineStatusAIOTempApi)QRoute.api(IOnlineStatusAIOTempApi.class)).sendPaiYiPaiReq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          new DoubleTapEffect(this.jdField_a_of_type_AndroidWidgetImageView).a();
          if (this.d.getText() != null) {
            str = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
          }
          ReportHelperKt.a("0X800BBDC", 0, "0", str);
        }
        else
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131694424, 0).a();
        }
      }
      else if (i != 2131370156)
      {
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppBusinessObserver);
    paramView = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (paramView != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramView.getAttributes();
      localLayoutParams.alpha = 0.5F;
      paramView.setAttributes(localLayoutParams);
    }
    if (this.d.getText() != null) {
      paramView = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
    } else {
      paramView = "";
    }
    ReportHelperKt.a("0X800BBDB", 0, "0", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow
 * JD-Core Version:    0.7.0.1
 */