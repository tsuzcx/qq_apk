package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;

public class ArkHeaderView
  extends ArkAppView
  implements IHeaderView
{
  private String c;
  private ArkAppContainer d;
  private String e;
  
  public ArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    ArkAppContainer localArkAppContainer = this.d;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(1);
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.d = new ArkAppContainer();
    paramString = new SessionInfo();
    paramString.b = "2747277822";
    this.d.a(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramContext.getResources().getDisplayMetrics().scaledDensity, paramString);
    paramInt = AIOUtils.b(350.0F, paramContext.getResources());
    int i = ArkAppCenterUtil.d;
    this.d.setMaxSize(i, paramInt);
    this.d.setFixSize(i, paramInt);
    setClipRadius(5.0F);
    a(this.d, null);
    setVisibility(0);
    try
    {
      this.c = paramQQGameMsgInfo.gameAppId;
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      paramContext = new StringBuilder();
      paramContext.append("parse meta error =");
      paramContext.append(paramQQGameMsgInfo.toString());
      QLog.e("ArkHeaderView", 1, paramContext.toString());
    }
  }
  
  public void b()
  {
    ArkAppContainer localArkAppContainer = this.d;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(0);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    ArkAppContainer localArkAppContainer = this.d;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
  }
  
  public String getAppName()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ArkHeaderView
 * JD-Core Version:    0.7.0.1
 */