package com.tencent.timi.game.liveroom.impl.live.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/HorInputBoxView;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIv", "Landroid/widget/ImageView;", "inputEt", "Landroid/widget/EditText;", "sendTv", "Landroid/widget/TextView;", "bindReport", "", "roomId", "", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "doBeforeSend", "view", "Landroid/view/View;", "expose", "end", "", "getContentLimit", "getEmojiBtn", "getInputEditText", "getLayoutId", "getSendBtn", "layoutInflated", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HorInputBoxView
  extends TimiBaseInputView
{
  private EditText a;
  private ImageView c;
  private TextView d;
  
  @JvmOverloads
  public HorInputBoxView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public HorInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public HorInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = ((EditText)findViewById(2131435831));
    this.c = ((ImageView)findViewById(2131432439));
    this.d = ((TextView)findViewById(2131445618));
    Object localObject = this.a;
    if (localObject != null) {
      ((EditText)localObject).setEditableFactory(getEmojiEditableFactory());
    }
    localObject = getFuncLayout();
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundColor(Color.parseColor("#0B0820"));
    }
    a((TimiBaseInputView.StateChangedListener)new HorInputBoxView.layoutInflated.1(this));
    localObject = this.a;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new HorInputBoxView.layoutInflated.2(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new HorInputBoxView.layoutInflated.3(this));
    }
    localObject = this.a;
    if (localObject != null) {
      ((EditText)localObject).setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(40), (InputFilter)new HorInputBoxView.layoutInflated.4() });
    }
    localObject = this.a;
    if (localObject != null)
    {
      VideoReport.setElementId((Object)localObject, "em_qqlive_inputpanel_box");
      VideoReport.setLogicParent((View)this.a, (View)this.d);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
  }
  
  public final void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo);
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (paramLiveRoomExtraInfo != null)
    {
      localILiveReportService.a(this, "pg_qqlive_audience", (Map)paramLiveRoomExtraInfo);
      paramLiveRoomExtraInfo = this.d;
      if (paramLiveRoomExtraInfo != null)
      {
        ILiveReportService.DefaultImpls.b((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)paramLiveRoomExtraInfo, false, "send", "em_qqlive_send_message", null, 18, null);
        VideoReport.setEventDynamicParams(paramLiveRoomExtraInfo, (IDynamicParams)new HorInputBoxView.bindReport..inlined.apply.lambda.1(this));
      }
      paramLiveRoomExtraInfo = this.c;
      if (paramLiveRoomExtraInfo != null) {
        ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)paramLiveRoomExtraInfo, false, null, "em_qqlive_emoji_entrance", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar") }), 6, null);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  protected void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    paramView = (Object)paramView;
    localILiveReportService.a("clck", paramView, (Map)new LinkedHashMap());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("dt_submit", paramView, MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("dt_submit_way", "2"), TuplesKt.to("dt_submit_type", "SEND") }));
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = getSendBtn();
    if (localObject != null)
    {
      ImageView localImageView = getEmojiBtn();
      if (localImageView != null)
      {
        if (paramBoolean)
        {
          localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
          if (localObject != null)
          {
            localILiveReportService.a("imp_end", (Object)localObject, (Map)new LinkedHashMap());
            localObject = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
            if (localImageView != null)
            {
              ((ILiveReportService)localObject).a("imp_end", (Object)localImageView, (Map)new LinkedHashMap());
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        if (localObject != null)
        {
          localILiveReportService.a("imp", (Object)localObject, (Map)new LinkedHashMap());
          localObject = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
          if (localImageView != null)
          {
            ((ILiveReportService)localObject).a("imp", (Object)localImageView, (Map)new LinkedHashMap());
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
    }
  }
  
  public int getContentLimit()
  {
    return 40;
  }
  
  @Nullable
  public ImageView getEmojiBtn()
  {
    return this.c;
  }
  
  @Nullable
  public EditText getInputEditText()
  {
    return this.a;
  }
  
  public int getLayoutId()
  {
    return 2131629430;
  }
  
  @Nullable
  public TextView getSendBtn()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorInputBoxView
 * JD-Core Version:    0.7.0.1
 */