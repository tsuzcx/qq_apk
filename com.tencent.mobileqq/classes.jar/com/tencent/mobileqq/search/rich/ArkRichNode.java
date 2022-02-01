package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ArkRichNode
  extends RichNodeBase
  implements IArkNodeViewEvent
{
  private static ArkAppCallBackHandler e = new ArkAppCallBackHandler();
  private ArkNodeConfig c;
  private ArkNodeContainer d;
  private int f = 0;
  
  public ArkRichNode(ArkNodeConfig paramArkNodeConfig)
  {
    this.c = paramArkNodeConfig;
    if ((this.c != null) && (QLog.isColorLevel()))
    {
      paramArkNodeConfig = new StringBuilder();
      paramArkNodeConfig.append("id:");
      paramArkNodeConfig.append(this.c.b());
      paramArkNodeConfig.append(" appname:");
      paramArkNodeConfig.append(this.c.c());
      paramArkNodeConfig.append(" viewname:");
      paramArkNodeConfig.append(this.c.e());
      paramArkNodeConfig.append(" miniversion:");
      paramArkNodeConfig.append(this.c.d());
      paramArkNodeConfig.append(" path：");
      paramArkNodeConfig.append(this.c.a());
      QLog.d("ArkRichNode", 2, paramArkNodeConfig.toString());
    }
  }
  
  private boolean l()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      bool1 = bool2;
      if ("com.tencent.weather".equals(this.c.b))
      {
        bool1 = bool2;
        if (this.b.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public IRichNodeView a(Context paramContext)
  {
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    ArkNodeView localArkNodeView = new ArkNodeView(this, paramContext);
    if (l())
    {
      localArkNodeView.k().setVisibility(8);
      return localArkNodeView;
    }
    localArkNodeView.a(this);
    localArkNodeView.b(paramContext);
    e.a(this);
    this.d = new ArkNodeContainer(e);
    String str = j();
    this.d.a(this.c, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.d.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.d.setMaxSize(i, -1);
    this.d.setMinSize(i, -1);
    localArkNodeView.a(this.d);
    this.d.activateView(true);
    return localArkNodeView;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    k();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetTalkBackText:");
      localStringBuilder.append(paramString);
      QLog.d("ArkRichNode", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    IRichNodeView localIRichNodeView = h();
    if (localIRichNodeView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramString = localIRichNodeView.h();
    if (paramString != null) {
      paramString.setContentDescription(localStringBuilder);
    }
    if ((localIRichNodeView instanceof ArkNodeView))
    {
      paramString = ((ArkNodeView)localIRichNodeView).k();
      if ((paramString instanceof ArkAppView)) {
        ((ArkAppView)paramString).setContentDescription(localStringBuilder);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyEvent, key:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramString2);
      QLog.d("ArkRichNode", 2, localStringBuilder.toString());
    }
    b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    super.a(paramString1, paramString2, paramString3);
    paramString1 = this.d;
    if (paramString1 != null) {
      paramString1.updateMetaData(j());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArkNodeContainer localArkNodeContainer = this.d;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.activateView(paramBoolean);
    }
  }
  
  public ArkNodeContainer b()
  {
    return this.d;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    Object localObject = e;
    if (localObject != null) {
      ((ArkAppCallBackHandler)localObject).b(this);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ArkNodeContainer)localObject).doOnEvent(2);
      this.d.a();
      this.d = null;
    }
    this.c = null;
  }
  
  public int d()
  {
    return 2;
  }
  
  public void e()
  {
    super.e();
    ArkNodeContainer localArkNodeContainer = this.d;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.doOnEvent(0);
    }
  }
  
  public void f()
  {
    super.f();
    ArkNodeContainer localArkNodeContainer = this.d;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkRichNode
 * JD-Core Version:    0.7.0.1
 */