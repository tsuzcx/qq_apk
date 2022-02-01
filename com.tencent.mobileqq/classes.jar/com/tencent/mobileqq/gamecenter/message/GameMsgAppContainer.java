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
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppContainer
{
  private View a;
  public QQAppInterface b;
  public BaseActivity c;
  public Context d;
  public GameMsgChatPie e;
  protected View.OnClickListener f = new GameMsgAppContainer.2(this);
  private boolean g = false;
  private GameMsgAppFragment h;
  
  public GameMsgAppContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, GameMsgChatPie paramGameMsgChatPie)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseActivity;
    this.d = paramContext;
    this.e = paramGameMsgChatPie;
    this.a = new FrameLayout(paramBaseActivity);
    paramQQAppInterface = new ViewGroup.LayoutParams(-1, -1);
    this.a.setId(2131433965);
    this.a.setLayoutParams(paramQQAppInterface);
    this.a.addOnAttachStateChangeListener(new GameMsgAppContainer.1(this));
  }
  
  private String a(String paramString)
  {
    Object localObject2 = this.e;
    Object localObject1 = paramString;
    if (localObject2 != null)
    {
      if (paramString == null) {
        return paramString;
      }
      localObject1 = ((GameMsgChatPie)localObject2).aE();
      String str = "";
      if (localObject1 != null) {
        localObject1 = ((SessionInfo)localObject1).b;
      } else {
        localObject1 = "";
      }
      localObject2 = this.e.bC();
      Object localObject4 = this.e.bB();
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
  
  private void g()
  {
    Object localObject2 = (IGameMsgManagerService)this.b.getRuntimeService(IGameMsgManagerService.class, "");
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
    this.h = new GameMsgAppFragment();
    this.h.setArguments((Bundle)localObject1);
    this.h.setPageAppeared(false);
    this.h.a(this.f);
    localObject1 = this.c.getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject1).replace(2131433965, this.h);
    ((FragmentTransaction)localObject1).commit();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c()
  {
    GameMsgAppFragment localGameMsgAppFragment = this.h;
    if (localGameMsgAppFragment != null)
    {
      localGameMsgAppFragment.setPageAppeared(true);
      this.h.onResume();
    }
  }
  
  public void d()
  {
    GameMsgAppFragment localGameMsgAppFragment = this.h;
    if (localGameMsgAppFragment != null)
    {
      localGameMsgAppFragment.onPause();
      this.h.setPageAppeared(false);
    }
  }
  
  public boolean e()
  {
    a(true);
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgAppContainer", 2, "onDestroy");
    }
    GameMsgAppFragment localGameMsgAppFragment = this.h;
    if (localGameMsgAppFragment != null) {
      localGameMsgAppFragment.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer
 * JD-Core Version:    0.7.0.1
 */