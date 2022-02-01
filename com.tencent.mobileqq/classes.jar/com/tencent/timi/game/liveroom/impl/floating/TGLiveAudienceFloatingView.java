package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.float_window.BusFloatManager;
import com.tencent.timi.game.float_window.BusFloatManager.Companion;
import com.tencent.timi.game.float_window.FloatingAnimateInfo;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.float_window.IFloatView.DefaultImpls;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NetEventManager;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/floating/TGLiveAudienceFloatingView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/float_window/IFloatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "audienceRoom", "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "getAudienceRoom", "()Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "setAudienceRoom", "(Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;)V", "liveRoomService", "Lcom/tencent/timi/game/component/qqlive/api/ITgLiveRoomService;", "loadVideoTimeOutTask", "Ljava/lang/Runnable;", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxWidth", "getMaxWidth", "setMaxWidth", "netInfoHandler", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "resumeIntent", "Landroid/content/Intent;", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "roomPlayerListener", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "getRoomPlayerListener", "()Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "setRoomPlayerListener", "(Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;)V", "roomStatusListener", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "getRoomStatusListener", "()Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "setRoomStatusListener", "(Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;)V", "surfaceCallback", "Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "getSurfaceCallback", "()Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;)V", "check4G", "", "checkWifiStatus", "containsView", "", "viewGroup", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "getFloatingConfigParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "getView", "init", "onAttachFloat", "onBackground", "onDetachFloat", "onForground", "onHide", "onShow", "setLiveViewRoundCorners", "roundCorners", "", "setResumeIntent", "show4G", "show", "FloatingVideoOutlineProvider", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAudienceFloatingView
  extends FrameLayout
  implements IFloatView
{
  private final String a = "TGLiveFloatManager";
  private ITgLiveRoomService b;
  private Intent c;
  private long d;
  @Nullable
  private IAudienceRoom e;
  @Nullable
  private LiveRoomStatusListener f;
  private int g;
  private int h;
  private INetInfoHandler i;
  private Runnable j;
  @NotNull
  private ITPPlayerVideoView.IVideoSurfaceCallback k;
  @NotNull
  private AudienceRoomPlayerListener l;
  private HashMap m;
  
  @JvmOverloads
  public TGLiveAudienceFloatingView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TGLiveAudienceFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TGLiveAudienceFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "ServiceCenter.getService…eRoomService::class.java)");
    this.b = ((ITgLiveRoomService)paramAttributeSet);
    this.g = CommonExKt.a(176);
    this.h = CommonExKt.a(99);
    this.j = ((Runnable)new TGLiveAudienceFloatingView.loadVideoTimeOutTask.1(this));
    LayoutInflater.from(getContext()).inflate(2131629447, (ViewGroup)this);
    ((ImageView)a(2131430807)).setOnClickListener((View.OnClickListener)new TGLiveAudienceFloatingView.1(this));
    a(2131430771).setOnClickListener((View.OnClickListener)new TGLiveAudienceFloatingView.2(this));
    ((TextView)a(2131444737)).setOnClickListener((View.OnClickListener)new TGLiveAudienceFloatingView.3(this));
    ((TextView)a(2131449208)).setOnClickListener((View.OnClickListener)new TGLiveAudienceFloatingView.4(this, paramContext));
    paramContext = (TextView)a(2131437625);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "loadingText");
    paramContext.setVisibility(4);
    this.i = ((INetInfoHandler)new TGLiveAudienceFloatingView.5(this));
    this.f = ((LiveRoomStatusListener)new TGLiveAudienceFloatingView.6(this));
    this.k = ((ITPPlayerVideoView.IVideoSurfaceCallback)new TGLiveAudienceFloatingView.surfaceCallback.1(this));
    this.l = ((AudienceRoomPlayerListener)new TGLiveAudienceFloatingView.roomPlayerListener.1(this));
  }
  
  private final void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider((ViewOutlineProvider)new TGLiveAudienceFloatingView.FloatingVideoOutlineProvider(paramFloat));
      paramView.setClipToOutline(true);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLinearLayout = (LinearLayout)a(2131437610);
      Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "load_failed");
      localLinearLayout.setVisibility(8);
      localLinearLayout = (LinearLayout)a(2131449207);
      Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "use_4g");
      localLinearLayout.setVisibility(0);
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)a(2131449207);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "use_4g");
    localLinearLayout.setVisibility(8);
  }
  
  private final boolean a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramViewGroup != null)
    {
      if (paramView == null) {
        return false;
      }
      int i1 = paramViewGroup.getChildCount();
      int n = 0;
      while (n < i1)
      {
        if (Intrinsics.areEqual(paramViewGroup.getChildAt(n), paramView)) {
          return true;
        }
        n += 1;
      }
    }
    return false;
  }
  
  private final void g()
  {
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.check4G.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.m == null) {
      this.m = new HashMap();
    }
    View localView2 = (View)this.m.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.m.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public IFloatView a(long paramLong)
  {
    this.d = paramLong;
    return (IFloatView)this;
  }
  
  @NotNull
  public final IFloatView a(@Nullable Intent paramIntent)
  {
    this.c = paramIntent;
    return (IFloatView)this;
  }
  
  public void a()
  {
    Logger.a(this.a, "floating onShow");
    Object localObject1 = this.b;
    QQLiveCurRoomInfo localQQLiveCurRoomInfo = null;
    if (localObject1 != null)
    {
      localObject1 = ((ITgLiveRoomService)localObject1).b();
      if (localObject1 != null)
      {
        localObject1 = ((ITPPlayerVideoView)localObject1).getDisplayViewRect();
        break label53;
      }
    }
    localObject1 = null;
    label53:
    Object localObject2 = this.b.b();
    if (localObject2 != null) {
      ((ITPPlayerVideoView)localObject2).addSurfaceCallback(this.k);
    }
    localObject2 = this.b.b();
    if (localObject2 != null)
    {
      localObject2 = ((ITPPlayerVideoView)localObject2).getCurrentDisplayView();
      if (localObject2 != null)
      {
        ((View)localObject2).setKeepScreenOn(true);
        if (localObject1 != null)
        {
          int i2 = this.g;
          int i3 = this.h;
          int i1 = i2;
          int n = i3;
          if (((Rect)localObject1).width() != 0)
          {
            i1 = i2;
            n = i3;
            if (((Rect)localObject1).height() != 0)
            {
              i1 = i2;
              n = i3;
              if (((Rect)localObject1).width() > ((Rect)localObject1).height())
              {
                n = this.h;
                i1 = (int)(n * ((Rect)localObject1).width() / ((Rect)localObject1).height());
              }
            }
          }
          BusFloatManager.a.a().a(String.valueOf(this.d), i1, n);
          if (!a((FrameLayout)a(2131449453), (View)localObject2))
          {
            localObject1 = ((View)localObject2).getParent();
            if (!(localObject1 instanceof ViewGroup)) {
              localObject1 = localQQLiveCurRoomInfo;
            }
            localObject1 = (ViewGroup)localObject1;
            if (localObject1 != null) {
              ((ViewGroup)localObject1).removeView((View)localObject2);
            }
            ((FrameLayout)a(2131449453)).addView((View)localObject2, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          g();
        }
        a((View)localObject2, CommonExKt.b(9));
      }
    }
    a((View)this, CommonExKt.b(9));
    localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    localObject1 = ((ITgLiveRoomService)localObject1).d();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "sdk");
      localQQLiveCurRoomInfo = ((IQQLiveSDK)localObject1).getCurRoomInfo();
      if (localQQLiveCurRoomInfo != null)
      {
        localQQLiveCurRoomInfo.isFloatWindow = true;
        ((IQQLiveSDK)localObject1).recordCurRoomInfo(localQQLiveCurRoomInfo);
      }
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      localObject1 = (LinearLayout)a(2131437610);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "load_failed");
      ((LinearLayout)localObject1).setVisibility(0);
    }
    NetEventManager.a().a(this.i);
  }
  
  public void b()
  {
    Logger.a(this.a, "floating onHide");
    Object localObject = this.b.b();
    if (localObject != null)
    {
      localObject = ((ITPPlayerVideoView)localObject).getCurrentDisplayView();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {
        ((View)localObject).setClipToOutline(false);
      }
    }
    localObject = this.b.b();
    if (localObject != null) {
      ((ITPPlayerVideoView)localObject).removeSurfaceCallback(this.k);
    }
    localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sdk");
      QQLiveCurRoomInfo localQQLiveCurRoomInfo = ((IQQLiveSDK)localObject).getCurRoomInfo();
      if (localQQLiveCurRoomInfo != null)
      {
        localQQLiveCurRoomInfo.isFloatWindow = false;
        ((IQQLiveSDK)localObject).recordCurRoomInfo(localQQLiveCurRoomInfo);
      }
    }
    NetEventManager.a().b(this.i);
    removeCallbacks(this.j);
  }
  
  public void c()
  {
    Logger.a(this.a, "floating onAttachFloat");
    Object localObject = this.b.b();
    if (localObject != null) {
      ((ITPPlayerVideoView)localObject).addSurfaceCallback(this.k);
    }
    ILiveRoom localILiveRoom = this.b.b(0L);
    localObject = localILiveRoom;
    if (!(localILiveRoom instanceof ILiveTPPlayerRoom)) {
      localObject = null;
    }
    localObject = (ILiveTPPlayerRoom)localObject;
    if (localObject != null) {
      ((ILiveTPPlayerRoom)localObject).registerRoomPlayerListener(this.l);
    }
    this.e = this.b.e(this.d);
    localObject = this.e;
    if (localObject != null) {
      ((IAudienceRoom)localObject).registerRoomStatusListener(this.f);
    }
    localObject = this.b.b();
    if (localObject != null) {
      ((ITPPlayerVideoView)localObject).getDisplayViewRect();
    }
    localObject = getParent();
    if ((localObject != null) && ((localObject instanceof View))) {
      a((View)localObject, CommonExKt.b(9));
    }
  }
  
  public void d()
  {
    Logger.a(this.a, "floating onDetachFloat");
    NetEventManager.a().b(this.i);
    Object localObject = this.b.b();
    if (localObject != null) {
      ((ITPPlayerVideoView)localObject).removeSurfaceCallback(this.k);
    }
    ILiveRoom localILiveRoom = this.b.b(0L);
    localObject = localILiveRoom;
    if (!(localILiveRoom instanceof ILiveTPPlayerRoom)) {
      localObject = null;
    }
    localObject = (ILiveTPPlayerRoom)localObject;
    if (localObject != null) {
      ((ILiveTPPlayerRoom)localObject).unRegisterRoomPlayerListener(this.l);
    }
    localObject = this.e;
    if (localObject != null) {
      ((IAudienceRoom)localObject).unRegisterRoomStatusListener(this.f);
    }
    removeCallbacks(this.j);
  }
  
  public void e() {}
  
  public void f() {}
  
  @NotNull
  public FloatingAnimateInfo getAnimateInfo()
  {
    return IFloatView.DefaultImpls.a(this);
  }
  
  @Nullable
  public final IAudienceRoom getAudienceRoom()
  {
    return this.e;
  }
  
  @NotNull
  public FloatingConfigParams getFloatingConfigParams()
  {
    return new FloatingConfigParams.FloatingBuilder().a(CommonExKt.a(176), CommonExKt.a(99)).b(CommonExKt.a(12)).a();
  }
  
  public final int getMaxHeight()
  {
    return this.h;
  }
  
  public final int getMaxWidth()
  {
    return this.g;
  }
  
  public final long getRoomId()
  {
    return this.d;
  }
  
  @NotNull
  public final AudienceRoomPlayerListener getRoomPlayerListener()
  {
    return this.l;
  }
  
  @Nullable
  public final LiveRoomStatusListener getRoomStatusListener()
  {
    return this.f;
  }
  
  @NotNull
  public final ITPPlayerVideoView.IVideoSurfaceCallback getSurfaceCallback()
  {
    return this.k;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  public final void setAudienceRoom(@Nullable IAudienceRoom paramIAudienceRoom)
  {
    this.e = paramIAudienceRoom;
  }
  
  public final void setMaxHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void setRoomPlayerListener(@NotNull AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAudienceRoomPlayerListener, "<set-?>");
    this.l = paramAudienceRoomPlayerListener;
  }
  
  public final void setRoomStatusListener(@Nullable LiveRoomStatusListener paramLiveRoomStatusListener)
  {
    this.f = paramLiveRoomStatusListener;
  }
  
  public final void setSurfaceCallback(@NotNull ITPPlayerVideoView.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoSurfaceCallback, "<set-?>");
    this.k = paramIVideoSurfaceCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView
 * JD-Core Version:    0.7.0.1
 */