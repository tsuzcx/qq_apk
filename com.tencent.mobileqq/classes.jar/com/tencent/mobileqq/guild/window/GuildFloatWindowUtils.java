package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen;
import com.tencent.mobileqq.guild.audio.widget.QQGuildAudioChanelFloatingWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createGuildLiveFloatViewWrapper", "Landroid/view/View;", "context", "Landroid/content/Context;", "liveView", "quitAudioFloatWindow", "", "quitLiveFloatWindow", "removeChildViewParent", "childView", "showGuildAudioFloatWindow", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "showDefault", "showGuildLiveFloatWindow", "customView", "orientation", "", "qqguild-impl_release"}, k=2, mv={1, 1, 16})
@JvmName(name="GuildFloatWindowUtils")
public final class GuildFloatWindowUtils
{
  @NotNull
  public static final View a(@NotNull Context paramContext, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new FrameLayout(paramContext);
    paramContext.setId(2131434627);
    paramContext.setBackgroundColor(-16777216);
    if (paramView != null)
    {
      a(paramView);
      paramView.setId(2131434670);
      paramContext.addView(paramView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    return (View)paramContext;
  }
  
  public static final void a()
  {
    GuildFloatWindowManager localGuildFloatWindowManager = GuildFloatWindowManager.a;
    String str = QQGuildAudioChanelFloatingWrapper.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "QQGuildAudioChanelFloatingWrapper::class.java.name");
    localGuildFloatWindowManager.a(str);
  }
  
  public static final void a(@Nullable View paramView)
  {
    if (paramView != null) {
      try
      {
        Object localObject = paramView.getParent();
        if (localObject != null)
        {
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(paramView);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      catch (ClassCastException paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public static final boolean a(@Nullable View paramView, @NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    float f = 'Ó';
    int k = ViewUtils.dip2px(f);
    int i = MathKt.roundToInt(k / 1.777778F);
    int j;
    if (paramInt == 1)
    {
      j = ViewUtils.dip2px(f);
      paramInt = 2;
    }
    else
    {
      paramInt = 1;
      j = i;
      i = k;
    }
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(paramInt).setCustomSize(i, j).setCanMove(true).setCanZoom(true).build();
    localFloatingScreenParams.setScreenLonger(RangesKt.coerceAtLeast(i, j));
    Intrinsics.checkExpressionValueIsNotNull(localFloatingScreenParams, "floatParams");
    localFloatingScreenParams.setShapeType(paramInt);
    Object localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "floatContext");
    paramView = a((Context)localObject, paramView);
    localObject = GuildFloatWindowManager.a;
    String str = GuildLiveChannelFloatWrapper.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "GuildLiveChannelFloatWrapper::class.java.name");
    return ((GuildFloatWindowManager)localObject).a(paramView, str, localFloatingScreenParams, paramIGProGuildInfo, paramIGProChannelInfo);
  }
  
  public static final boolean a(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Object localObject1 = MobileQQ.sMobileQQ;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "MobileQQ.sMobileQQ");
    localObject1 = ((MobileQQ)localObject1).getApplicationContext();
    Object localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
    int i = ViewUtils.dip2px(94.0F);
    int j = ViewUtils.dip2px(94.0F);
    Object localObject3 = new AudioSmallScreen((Context)localObject1, (BaseQQAppInterface)localObject2);
    localObject1 = new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCustomSize(i, j).setCanMove(true).setCanZoom(false).build();
    localObject2 = GuildFloatWindowManager.a;
    localObject3 = (View)localObject3;
    String str = QQGuildAudioChanelFloatingWrapper.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "QQGuildAudioChanelFloatingWrapper::class.java.name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "floatParams");
    return ((GuildFloatWindowManager)localObject2).a((View)localObject3, str, (FloatingScreenParams)localObject1, paramIGProGuildInfo, paramIGProChannelInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.GuildFloatWindowUtils
 * JD-Core Version:    0.7.0.1
 */