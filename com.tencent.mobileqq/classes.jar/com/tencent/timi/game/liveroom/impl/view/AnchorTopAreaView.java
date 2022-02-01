package com.tencent.timi.game.liveroom.impl.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorFansService;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorFansGroupCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.ad.TimiTianshuAdManager;
import com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorTopAreaView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorUid", "", "bindActivity", "Landroid/app/Activity;", "getBindActivity", "()Landroid/app/Activity;", "setBindActivity", "(Landroid/app/Activity;)V", "fansGroupCallback", "com/tencent/timi/game/liveroom/impl/view/AnchorTopAreaView$fansGroupCallback$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorTopAreaView$fansGroupCallback$1;", "funDataMap", "", "", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "funRequestAnchorUid", "isDetachedFromWindow", "", "isLandscape", "mHintView", "Landroid/view/View;", "mIsAnchor", "mListener", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorTopAreaView$Listener;", "mRoomId", "bindElementId", "", "checkFunEntryShow", "createHintViewIfNeed", "fetchOperationData", "initAnchorInfo", "onDetachedFromWindow", "onEnterRoom", "roomId", "isAnchor", "onExitRoom", "onOrientationChange", "onPageIn", "onPageOut", "onPreload", "videoUrl", "", "refresh", "reportFansGroup", "setListener", "l", "setLiveRoomInfo", "info", "Lcom/tencent/mobileqq/qqlive/api/anchor/room/IQQLiveAnchorRoom;", "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "showCollapseHint", "Companion", "Listener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopAreaView
  extends FrameLayout
  implements IRoomWidget
{
  public static final AnchorTopAreaView.Companion a = new AnchorTopAreaView.Companion(null);
  @Nullable
  private Activity b;
  private AnchorTopAreaView.Listener c;
  private long d;
  private boolean e;
  private long f;
  private View g;
  private boolean h;
  private long i;
  private Map<Long, List<QQLiveAnchorFansGroupItem>> j = (Map)new LinkedHashMap();
  private boolean k;
  private final AnchorTopAreaView.fansGroupCallback.1 l;
  private HashMap m;
  
  @JvmOverloads
  public AnchorTopAreaView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorTopAreaView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorTopAreaView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629416, (ViewGroup)this);
    ((ImageView)a(2131430923)).setOnClickListener((View.OnClickListener)new AnchorTopAreaView.1(this));
    paramContext = (FrameLayout)a(2131433919);
    if (paramContext != null) {
      ViewExKt.a((View)paramContext, LayoutExKt.b(11), new int[] { -16777216 });
    }
    paramContext = (FrameLayout)a(2131433919);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new AnchorTopAreaView.2(this));
    }
    ThreadManagerV2.excute((Runnable)new AnchorTopAreaView.3(this), 128, null, false);
    a();
    this.l = new AnchorTopAreaView.fansGroupCallback.1(this);
  }
  
  private final void a()
  {
    Object localObject = new HashMap();
    if (!this.e)
    {
      Map localMap = (Map)localObject;
      if (this.k) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localMap.put("qqlive_screen_orientation", localObject);
      localObject = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      ImageView localImageView = (ImageView)a(2131430923);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "collapseIgv");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject, (View)localImageView, false, null, "em_qqlive_room_mini", localMap, 6, null);
    }
  }
  
  private final void b()
  {
    if (this.e)
    {
      ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      FrameLayout localFrameLayout = (FrameLayout)a(2131433919);
      Intrinsics.checkExpressionValueIsNotNull(localFrameLayout, "funGroupEntranceView");
      localILiveReportService.a((View)localFrameLayout, true, null, "em_qqlive_fangroup_entrance", (Map)new LinkedHashMap());
    }
  }
  
  private final void c()
  {
    Object localObject1 = getParent();
    if (localObject1 != null)
    {
      Object localObject2 = (ViewGroup)localObject1;
      localObject1 = this.g;
      if (localObject1 != null) {
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      d();
      localObject1 = this.g;
      if (localObject1 != null)
      {
        Object localObject3 = new Rect();
        ((ImageView)a(2131430923)).getGlobalVisibleRect((Rect)localObject3);
        int n = ((Rect)localObject3).bottom;
        int i1 = LayoutExKt.b(3);
        ((ViewGroup)localObject2).addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
        ((View)localObject1).setOnClickListener((View.OnClickListener)new AnchorTopAreaView.showCollapseHint.2((ViewGroup)localObject2, (View)localObject1));
        ((TextView)((View)localObject1).findViewById(2131430924)).setOnClickListener((View.OnClickListener)new AnchorTopAreaView.showCollapseHint.3(this, (ViewGroup)localObject2, (View)localObject1));
        ((TextView)((View)localObject1).findViewById(2131432550)).setOnClickListener((View.OnClickListener)new AnchorTopAreaView.showCollapseHint.4(this, (ViewGroup)localObject2, (View)localObject1));
        localObject3 = new HashMap();
        localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        Object localObject4 = (TextView)((View)localObject1).findViewById(2131430924);
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "hintView.collapseTxv");
        localObject4 = (View)localObject4;
        localObject3 = (Map)localObject3;
        ILiveReportService.DefaultImpls.a((ILiveReportService)localObject2, (View)localObject4, false, null, "em_qqlive_room_mini", (Map)localObject3, 6, null);
        localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        localObject4 = (TextView)((View)localObject1).findViewById(2131432550);
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "hintView.endLiveTxv");
        ILiveReportService.DefaultImpls.a((ILiveReportService)localObject2, (View)localObject4, false, null, "em_qqlive_living_end", (Map)localObject3, 6, null);
        post((Runnable)new AnchorTopAreaView.showCollapseHint.5(this, (View)localObject1, n + i1));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void d()
  {
    if (this.g == null) {
      this.g = View.inflate(getContext(), 2131629404, null);
    }
  }
  
  private final void d(long paramLong)
  {
    this.f = paramLong;
    e();
    this.j.clear();
  }
  
  private final void e()
  {
    Object localObject = (FrameLayout)a(2131433919);
    if (localObject != null) {
      ViewExKt.a((View)localObject, this.e);
    }
    this.i = this.f;
    localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getAnchorFansService();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveAnchorFansService)localObject).getAnchorFansGroupList(this.f, (IQQLiveAnchorFansGroupCallback)this.l);
    }
  }
  
  private final void f()
  {
    Logger.a("AnchorOperationContainer_", "fetchOperationData start");
    TimiTianshuAdManager.a.a((TianShuGetAdvCallback)new AnchorTopAreaView.fetchOperationData.1(this), (List)TimiTianshuAdManager.a.c());
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
  
  public void a(long paramLong)
  {
    ((AnchorTopHeadView)a(2131447706)).a(paramLong);
  }
  
  public void a(long paramLong, @Nullable String paramString)
  {
    ((AnchorTopHeadView)a(2131447706)).a(paramLong, paramString);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ((AnchorTopHeadView)a(2131447706)).a(paramLong, paramBoolean);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom roomId:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", isAnchor:");
    ((StringBuilder)localObject).append(paramBoolean);
    Logger.a("AnchorTopAreaView_", 1, ((StringBuilder)localObject).toString());
    this.d = paramLong;
    this.e = paramBoolean;
    TextView localTextView = (TextView)a(2131428307);
    if (localTextView != null)
    {
      if (this.e) {
        localObject = "我的粉丝群";
      } else {
        localObject = "加粉丝群";
      }
      localTextView.setText((CharSequence)localObject);
    }
    b();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    a();
    ((AnchorTopHeadView)a(2131447706)).a(paramBoolean);
  }
  
  public void b(long paramLong)
  {
    ((AnchorTopHeadView)a(2131447706)).b(paramLong);
  }
  
  public void c(long paramLong)
  {
    ((AnchorTopHeadView)a(2131447706)).c(paramLong);
  }
  
  @Nullable
  public final Activity getBindActivity()
  {
    return this.b;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.h = true;
  }
  
  public final void setBindActivity(@Nullable Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public final void setListener(@NotNull AnchorTopAreaView.Listener paramListener)
  {
    Intrinsics.checkParameterIsNotNull(paramListener, "l");
    this.c = paramListener;
  }
  
  public final void setLiveRoomInfo(@Nullable IQQLiveAnchorRoom paramIQQLiveAnchorRoom)
  {
    if (paramIQQLiveAnchorRoom != null)
    {
      paramIQQLiveAnchorRoom = paramIQQLiveAnchorRoom.getAnchorRoomInfo();
      if (paramIQQLiveAnchorRoom != null)
      {
        paramIQQLiveAnchorRoom = paramIQQLiveAnchorRoom.userDta;
        if (paramIQQLiveAnchorRoom != null)
        {
          l1 = paramIQQLiveAnchorRoom.getAnchorUid();
          break label34;
        }
      }
    }
    long l1 = 0L;
    label34:
    d(l1);
  }
  
  public final void setLiveRoomInfo(@Nullable IAudienceRoom paramIAudienceRoom)
  {
    if (paramIAudienceRoom != null)
    {
      paramIAudienceRoom = paramIAudienceRoom.getRoomLiveInfo();
      if (paramIAudienceRoom != null)
      {
        paramIAudienceRoom = paramIAudienceRoom.anchorInfo;
        if (paramIAudienceRoom != null)
        {
          l1 = paramIAudienceRoom.getAnchorUid();
          break label34;
        }
      }
    }
    long l1 = 0L;
    label34:
    d(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView
 * JD-Core Version:    0.7.0.1
 */