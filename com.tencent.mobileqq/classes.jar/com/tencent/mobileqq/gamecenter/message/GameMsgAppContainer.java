package com.tencent.mobileqq.gamecenter.message;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppContainer
{
  public Context a;
  public FragmentActivity a;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  public GameMsgChatPie a;
  public QQAppInterface a;
  private GameMsgAppFragment jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GameMsgAppContainer(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, GameMsgChatPie paramGameMsgChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new GameMsgAppContainer.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie = paramGameMsgChatPie;
    this.jdField_a_of_type_AndroidViewView = new FrameLayout(paramFragmentActivity);
    paramQQAppInterface = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setId(2131367706);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
    this.jdField_a_of_type_AndroidViewView.addOnAttachStateChangeListener(new GameMsgAppContainer.1(this));
  }
  
  private String a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie == null) || (paramString == null)) {
      return paramString;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a();
    String str1 = "";
    if (localObject1 != null) {
      str1 = ((SessionInfo)localObject1).a;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.b();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a();
    String str2 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      str2 = ((GameDetailInfo)localObject2).d;
      localObject1 = ((GameDetailInfo)localObject2).b;
    }
    localObject2 = "";
    if (localObject3 != null) {
      localObject2 = ((GameDetailInfo)localObject3).b;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("from=aio");
    ((StringBuilder)localObject3).append("&gameId=").append(str2);
    ((StringBuilder)localObject3).append("&fromRoleId=").append((String)localObject1);
    ((StringBuilder)localObject3).append("&toRoleId=").append((String)localObject2);
    ((StringBuilder)localObject3).append("&sessionId=").append(str1);
    if (paramString.contains("?")) {
      return paramString + "&" + localObject3;
    }
    return paramString + "?" + localObject3;
  }
  
  private void e()
  {
    Object localObject2 = (GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    Object localObject1 = ((GameMsgManager)localObject2).e();
    String str = a(((GameMsgManager)localObject2).f());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject2 = new HippyAccessHelper.OpenHippyInfo();
    ((HippyAccessHelper.OpenHippyInfo)localObject2).bundleName = ((String)localObject1);
    ((HippyAccessHelper.OpenHippyInfo)localObject2).url = str;
    ((HippyAccessHelper.OpenHippyInfo)localObject2).isInToolProcess = false;
    ((HippyAccessHelper.OpenHippyInfo)localObject2).isDisablePreload = true;
    ((HippyAccessHelper.OpenHippyInfo)localObject2).from = "aio";
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBundle("params", ((HippyAccessHelper.OpenHippyInfo)localObject2).toBundle());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment = new GameMsgAppFragment();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setArguments((Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setPageAppeared(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject1).replace(2131367706, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment);
    ((FragmentTransaction)localObject1).commit();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    a(true);
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setPageAppeared(true);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.onResume();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.onPause();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setPageAppeared(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgAppContainer", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer
 * JD-Core Version:    0.7.0.1
 */