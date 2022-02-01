package com.tencent.mobileqq.guild.mainframe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.Logger.ILog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame;", "Lcom/tencent/mobileqq/app/Frame;", "Lcom/tencent/mobileqq/guild/mainframe/IGuildMainFrame;", "mainFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "delegateFragment", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "fragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "ensureFragmentViewExist", "", "fillData", "isSwitchAccount", "", "getGuildAttachContainerController", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildAttachContainerController;", "kotlin.jvm.PlatformType", "getGuildChatFrameGestureManager", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildChatFrameGestureManager;", "getHelper", "", "channelSelectHelper", "", "getMainViewContext", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainViewContext;", "getTitleView", "Landroid/view/View;", "guildAttachContainerInOrOut", "in", "isPlayAnim", "handleJumpAction", "extra", "Landroid/os/Bundle;", "message", "Lkotlin/Lazy;", "", "method", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeAccountChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "onPause", "onPostThemeChanged", "height", "onResume", "tabChanged", "onStart", "onStop", "setTabHeight", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildFragmentDelegateFrame
  extends Frame
  implements IGuildMainFrame
{
  public static final GuildFragmentDelegateFrame.Companion a = new GuildFragmentDelegateFrame.Companion(null);
  private final FragmentManager b;
  private final GuildMainFragment c;
  private FragmentContainerView d;
  private final FrameFragment e;
  
  public GuildFragmentDelegateFrame(@NotNull FrameFragment paramFrameFragment)
  {
    this.f = new GuildMainFrameDelegate(paramFrameFragment);
    this.e = paramFrameFragment;
    paramFrameFragment = this.e.getChildFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(paramFrameFragment, "mainFragment.childFragmentManager");
    this.b = paramFrameFragment;
    this.b.beginTransaction().add(GuildMainFragment.class, new Bundle(), "GuildMainFragment").commitNow();
    paramFrameFragment = this.b.findFragmentByTag("GuildMainFragment");
    if (paramFrameFragment != null)
    {
      this.c = ((GuildMainFragment)paramFrameFragment);
      paramFrameFragment = Logger.a;
      if (QLog.isColorLevel())
      {
        paramFrameFragment = paramFrameFragment.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MainFragment ");
        localStringBuilder.append(System.identityHashCode(this.e));
        localStringBuilder.append('/');
        localStringBuilder.append(System.identityHashCode(this.b));
        localStringBuilder.append(' ');
        localStringBuilder.append((String)a("init").getValue());
        paramFrameFragment.a("GuildFragmentDelegateFrame", 2, localStringBuilder.toString());
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.GuildMainFragment");
  }
  
  private final Lazy<String> a(String paramString)
  {
    return GuildDebugUtils.a.a((Fragment)this.c, "GuildFragmentDelegateFrame", paramString);
  }
  
  private final void o()
  {
    FragmentContainerView localFragmentContainerView = this.d;
    if (localFragmentContainerView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
    }
    if (localFragmentContainerView.indexOfChild(this.c.getView()) < 0)
    {
      localFragmentContainerView = this.d;
      if (localFragmentContainerView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
      }
      localFragmentContainerView.addView(this.c.getView());
    }
  }
  
  @SuppressLint({"InflateParams"})
  @NotNull
  public View a(@NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onCreateView()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131625042, null);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…e_replacement_main, null)");
    localObject2 = paramLayoutInflater.findViewById(2131434605);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "rootView.findViewById(R.…_fragment_container_view)");
    this.d = ((FragmentContainerView)localObject2);
    o();
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    return paramLayoutInflater;
  }
  
  public Object a(int paramInt)
  {
    return this.f.a(paramInt);
  }
  
  protected void a()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onCreate()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.a();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onActivityResult()");
    Object localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.a(paramInt1, paramInt2, paramIntent);
    paramIntent = Unit.INSTANCE;
    paramIntent = Logger.a;
    if (QLog.isColorLevel())
    {
      paramIntent = paramIntent.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject2).append(" end...");
      paramIntent.a("VASH_DEBUG", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    super.a(paramConfiguration);
  }
  
  public void a(Bundle paramBundle)
  {
    this.f.a(paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResume(");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(')');
    localObject1 = a(((StringBuilder)localObject1).toString());
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    GuildFragmentDelegateFrameKt.a(this.e, this.c);
    this.c.a(paramBoolean);
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f.a(paramBoolean1, paramBoolean2);
  }
  
  public void b(int paramInt)
  {
    this.f.b(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fillData(");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(')');
    localObject1 = a(((StringBuilder)localObject1).toString());
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.b(paramBoolean);
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void bQ_()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onPause()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    GuildFragmentDelegateFrameKt.b(this.e, this.c);
    this.c.c();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  protected void bS_()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onStart()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.b();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onStop()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.d();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt)
  {
    this.f.c(paramInt);
  }
  
  public GuildMainViewContext cw_()
  {
    return this.f.cw_();
  }
  
  protected void d()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onDestroy()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.f();
    localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
    }
    ((FragmentContainerView)localObject2).removeAllViews();
    if (!this.e.isDetached()) {
      this.e.getChildFragmentManager().beginTransaction().remove((Fragment)this.c).commitAllowingStateLoss();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public boolean h()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onBackPressed()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    boolean bool;
    if ((!this.c.i()) && (!super.h())) {
      bool = false;
    } else {
      bool = true;
    }
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  protected void k()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = a("onBeforeAccountChanged()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    this.c.h();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public GuildAttachContainerController m()
  {
    return this.f.m();
  }
  
  public GuildChatFrameGestureManager n()
  {
    return this.f.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame
 * JD-Core Version:    0.7.0.1
 */