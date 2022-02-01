package com.tencent.timi.game.liveroom.impl.live.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/HorBottomControllerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "forbidExpose", "", "getForbidExpose", "()Z", "setForbidExpose", "(Z)V", "horState", "isAnchor", "isDanmakuEnable", "liveMsgEven", "Lcom/tencent/timi/game/liveroom/impl/live/widget/ILiveMsgEven;", "getLiveMsgEven", "()Lcom/tencent/timi/game/liveroom/impl/live/widget/ILiveMsgEven;", "setLiveMsgEven", "(Lcom/tencent/timi/game/liveroom/impl/live/widget/ILiveMsgEven;)V", "bindReport", "", "roomId", "", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "forceExposure", "isEnd", "getInputState", "hideKeyboard", "onAttachedToWindow", "onDetachedFromWindow", "onHorUI", "onKeyboardHide", "onVerUI", "seDanmakuEnable", "setIsAnchor", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HorBottomControllerView
  extends FrameLayout
{
  @Nullable
  private ILiveMsgEven a;
  private Activity b;
  private boolean c;
  private boolean d;
  private int e = 1;
  private boolean f = true;
  private HashMap g;
  
  @JvmOverloads
  public HorBottomControllerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public HorBottomControllerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public HorBottomControllerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629440, (ViewGroup)this);
    ((TextView)a(2131435815)).setOnClickListener((View.OnClickListener)new HorBottomControllerView.1(this));
    ((HorInputBoxView)a(2131435126)).a((TimiBaseInputView.StateChangedListener)new HorBottomControllerView.2(this));
  }
  
  private final void b(boolean paramBoolean)
  {
    String str;
    if (!paramBoolean) {
      str = "imp";
    } else {
      str = "imp_end";
    }
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    ImageView localImageView = (ImageView)a(2131431574);
    if (localImageView != null)
    {
      localILiveReportService.a(str, (Object)localImageView, (Map)new LinkedHashMap());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
  }
  
  public View a(int paramInt)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    HorInputBoxView localHorInputBoxView = (HorInputBoxView)a(2131435126);
    if (localHorInputBoxView != null) {
      localHorInputBoxView.setState(1);
    }
  }
  
  public final void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    Object localObject1 = TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo);
    Object localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (localObject1 != null)
    {
      ((ILiveReportService)localObject2).a(this, "pg_qqlive_audience", (Map)localObject1);
      ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)this, false, null, "em_qqlive_bottom_bar", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("qqlive_screen_orientation", "1") }), 6, null);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (TextView)a(2131435815);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "inputPlaceHolder");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_inputbar", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") }), 6, null);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (ImageView)a(2131431574);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "danmuIconHor");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_barrage_settings", null, 22, null);
      VideoReport.setEventDynamicParams((ImageView)a(2131431574), (IDynamicParams)new HorBottomControllerView.bindReport.1(this));
      ((HorInputBoxView)a(2131435126)).a(paramLong, paramLiveRoomExtraInfo);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void b()
  {
    HorInputBoxView localHorInputBoxView = (HorInputBoxView)a(2131435126);
    if (localHorInputBoxView != null) {
      localHorInputBoxView.setVisibility(8);
    }
    b(true);
  }
  
  public final void c()
  {
    b(false);
  }
  
  public final boolean getForbidExpose()
  {
    return this.f;
  }
  
  public final int getInputState()
  {
    return ((HorInputBoxView)a(2131435126)).getCurState();
  }
  
  @Nullable
  public final ILiveMsgEven getLiveMsgEven()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b = CommonExKt.a((View)this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b = ((Activity)null);
  }
  
  public final void setForbidExpose(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void setIsAnchor(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void setLiveMsgEven(@Nullable ILiveMsgEven paramILiveMsgEven)
  {
    this.a = paramILiveMsgEven;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorBottomControllerView
 * JD-Core Version:    0.7.0.1
 */