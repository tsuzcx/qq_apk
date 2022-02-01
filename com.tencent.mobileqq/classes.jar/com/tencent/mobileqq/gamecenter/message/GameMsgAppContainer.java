package com.tencent.mobileqq.gamecenter.message;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppContainer
{
  public Context a;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  public GameMsgChatPie a;
  public BaseActivity a;
  public QQAppInterface a;
  private GameMsgAppFragment jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GameMsgAppContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, GameMsgChatPie paramGameMsgChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new GameMsgAppContainer.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie = paramGameMsgChatPie;
    this.jdField_a_of_type_AndroidViewView = new FrameLayout(paramBaseActivity);
    paramQQAppInterface = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setId(2131367459);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
    this.jdField_a_of_type_AndroidViewView.addOnAttachStateChangeListener(new GameMsgAppContainer.1(this));
  }
  
  private String a(String paramString)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie;
    Object localObject1 = paramString;
    if (localObject2 != null)
    {
      if (paramString == null) {
        return paramString;
      }
      localObject1 = ((GameMsgChatPie)localObject2).a();
      String str = "";
      if (localObject1 != null) {
        localObject1 = ((SessionInfo)localObject1).a;
      } else {
        localObject1 = "";
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.b();
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a();
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((GameDetailInfo)localObject2).c;
        localObject2 = ((GameDetailInfo)localObject2).a;
      }
      else
      {
        localObject2 = "";
        localObject3 = localObject2;
      }
      if (localObject4 != null) {
        str = ((GameDetailInfo)localObject4).a;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("from=aio");
      ((StringBuilder)localObject4).append("&gameId=");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("&fromRoleId=");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("&toRoleId=");
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("&sessionId=");
      ((StringBuilder)localObject4).append((String)localObject1);
      if (paramString.contains("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append(localObject4);
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(localObject4);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  private void e()
  {
    Object localObject2 = (IGameMsgManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    Object localObject1 = ((IGameMsgManagerService)localObject2).getAioHippyBundleName();
    String str = a(((IGameMsgManagerService)localObject2).getAioHippyParameters());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject2 = new OpenHippyInfo();
    ((OpenHippyInfo)localObject2).bundleName = ((String)localObject1);
    ((OpenHippyInfo)localObject2).url = str;
    ((OpenHippyInfo)localObject2).processName = "main";
    ((OpenHippyInfo)localObject2).isDisablePreload = true;
    ((OpenHippyInfo)localObject2).from = "aio";
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBundle("params", ((OpenHippyInfo)localObject2).toBundle());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment = new GameMsgAppFragment();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setArguments((Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setPageAppeared(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject1).replace(2131367459, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment);
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
    GameMsgAppFragment localGameMsgAppFragment = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment;
    if (localGameMsgAppFragment != null)
    {
      localGameMsgAppFragment.setPageAppeared(true);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.onResume();
    }
  }
  
  public void c()
  {
    GameMsgAppFragment localGameMsgAppFragment = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment;
    if (localGameMsgAppFragment != null)
    {
      localGameMsgAppFragment.onPause();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment.setPageAppeared(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgAppContainer", 2, "onDestroy");
    }
    GameMsgAppFragment localGameMsgAppFragment = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppFragment;
    if (localGameMsgAppFragment != null) {
      localGameMsgAppFragment.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer
 * JD-Core Version:    0.7.0.1
 */