package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildAttachContainerController
  extends GuildMainViewLifeCycle
{
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 5;
  private static int h = 250;
  private static int i = 0;
  private static int j = 1;
  private static int k = 2;
  private int l = b;
  private FrameLayout m;
  private List<GuildBaseContainer> n = new ArrayList();
  private AbsGestureListener o = new GuildAttachContainerController.1(this);
  
  public GuildAttachContainerController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
    m();
  }
  
  private GuildBaseContainer a(int paramInt)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)localIterator.next();
      if (localGuildBaseContainer.i() == paramInt) {
        return localGuildBaseContainer;
      }
    }
    return null;
  }
  
  private void a(NotifyData paramNotifyData)
  {
    if (paramNotifyData.a() == 3)
    {
      DragFrameLayout localDragFrameLayout = this.a.h();
      if (paramNotifyData.b() == 0)
      {
        localDragFrameLayout.setImportantForAccessibility(4);
        return;
      }
      if (paramNotifyData.b() == 1000) {
        localDragFrameLayout.setImportantForAccessibility(0);
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showByAnim in = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, localStringBuilder.toString());
    }
    this.a.f().b(paramBoolean);
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showByPos in = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    this.a.f().a(paramBoolean);
    FrameLayout localFrameLayout = this.m;
    if (paramBoolean) {
      localObject = null;
    } else {
      localObject = localFrameLayout.getContext().getDrawable(2130840769);
    }
    localFrameLayout.setBackground((Drawable)localObject);
  }
  
  private void m()
  {
    this.n.add(new GuildChatFrameController(this.a));
    this.n.add(new GuildNoticeFrameController(this.a));
    this.n.add(new GuildClientFrameController(this.a));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openGuildAttachContainer frameType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == this.l)
    {
      localObject = a(paramInt);
      if ((localObject != null) && (!((GuildBaseContainer)localObject).b(paramObject))) {
        return;
      }
    }
    this.l = paramInt;
    Object localObject = this.n.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)((Iterator)localObject).next();
      if (localGuildBaseContainer.i() == paramInt) {
        localGuildBaseContainer.a(paramObject);
      } else {
        localGuildBaseContainer.j();
      }
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof FrameLayout))
    {
      this.m = ((FrameLayout)paramView);
      this.m.setTranslationX(GuildChatFrameGestureUtil.a(this.a.b()));
      paramView = this.n.iterator();
      while (paramView.hasNext()) {
        ((GuildBaseContainer)paramView.next()).a(this.m);
      }
      return;
    }
    QLog.e("GuildAttachContainerController", 2, "initView view error !");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume tabChange = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.n.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GuildBaseContainer)((Iterator)localObject).next()).a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onStart");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAfterAccountChanged isSwitchAccount = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.n.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GuildBaseContainer)((Iterator)localObject).next()).b(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onPause");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).c();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((FrameLayout)localObject).setVisibility(0);
      return;
    }
    ((FrameLayout)localObject).setVisibility(8);
    a(b, null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onStop");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).d();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildAttachContainerInOrOut in = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, localStringBuilder.toString());
    }
    g(paramBoolean);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onDestroy");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).e();
    }
    this.a.f().b(this.o);
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildAttachContainerInOrOutByAnim in = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildAttachContainerController", 2, localStringBuilder.toString());
    }
    f(paramBoolean);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onCreate");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).f();
    }
    this.a.f().a(this.o);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAttachContainerController", 2, "onBeforeAccountChanged");
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).g();
    }
  }
  
  public boolean h()
  {
    Object localObject = this.n.iterator();
    boolean bool = false;
    while (((Iterator)localObject).hasNext()) {
      if (((GuildBaseContainer)((Iterator)localObject).next()).h()) {
        bool = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackPressed result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    if ((!bool) && (i()))
    {
      f(true);
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackPressed end result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("GuildAttachContainerController", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean i()
  {
    return this.m.getTranslationX() == GuildChatFrameGestureUtil.a();
  }
  
  public int j()
  {
    return (int)(this.m.getTranslationX() * 1000.0F / GuildChatFrameGestureUtil.a(this.m.getContext()));
  }
  
  public GuildNoticeFrameController k()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)localIterator.next();
      if ((localGuildBaseContainer instanceof GuildNoticeFrameController)) {
        return (GuildNoticeFrameController)localGuildBaseContainer;
      }
    }
    return null;
  }
  
  public int l()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController
 * JD-Core Version:    0.7.0.1
 */