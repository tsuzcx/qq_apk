package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.mic.api.IMicDataObserver;
import com.tencent.timi.game.mic.api.MicDataListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.chat.TeamInputViewKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/input/ExpandHallInputBoxView;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "Lcom/tencent/timi/game/mic/api/IMicDataObserver;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiBtn", "Landroid/widget/ImageView;", "inputEditText", "Landroid/widget/EditText;", "inputLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "isMicCardEnable", "", "()Z", "isMicMutableObserver", "Landroidx/lifecycle/Observer;", "isMicMuteLD", "Landroidx/lifecycle/LiveData;", "isSpeakerMutableObserver", "isSpeakerMuteLD", "micBtn", "micDataListener", "Lcom/tencent/timi/game/mic/api/MicDataListener;", "onSpeakingNum", "profileBtn", "Landroid/view/View;", "reportHelper", "Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "getReportHelper", "()Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "roomId", "", "sendBtn", "Landroid/widget/TextView;", "sendDisableDrawable", "Landroid/graphics/drawable/Drawable;", "sendDisabledTextColor", "sendEnableDrawable", "sendEnabledTextColor", "speakerBtn", "bindMicSpeakerReport", "", "bindRoom", "changeMicSwitch", "doAudioOp", "Lcom/tencent/timi/game/room/api/wrapper/IRoomAudioService;", "getEmojiBtn", "getFuncBtn", "getInputEditText", "getLayoutId", "getSendBtn", "layoutInflated", "onAudioMemberMicLevelChanged", "memberMicLevelList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "onDetachedFromWindow", "onRefreshSpeakingPosInfoList", "dataList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "refreshMicSpeakerUI", "micVisible", "refreshSpeakingPosInfo", "updateBtnState", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallInputBoxView
  extends TimiBaseInputView
  implements IMicDataObserver
{
  public static final ExpandHallInputBoxView.Companion a = new ExpandHallInputBoxView.Companion(null);
  private EditText c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ConstraintLayout h;
  private View i;
  private Drawable j;
  private Drawable k;
  private final int l = Color.parseColor("#FFFFFF");
  private final int m = Color.parseColor("#D1D1D1");
  private long n;
  private LiveData<Boolean> o;
  private LiveData<Boolean> p;
  private final Observer<Boolean> q = (Observer)new ExpandHallInputBoxView.isMicMutableObserver.1(this);
  private final Observer<Boolean> r = (Observer)new ExpandHallInputBoxView.isSpeakerMutableObserver.1(this);
  private int s;
  private final MicDataListener t = new MicDataListener((IMicDataObserver)this);
  
  @JvmOverloads
  public ExpandHallInputBoxView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ExpandHallInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ExpandHallInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isMicCardEnable: ");
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append("; onSpeakingNum: ");
    ((StringBuilder)localObject).append(this.s);
    Logger.c("ExpandHallInputBoxView", ((StringBuilder)localObject).toString());
    boolean bool = c();
    int i1 = 0;
    if (bool)
    {
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.g;
      if (localObject != null)
      {
        if (!paramBoolean) {
          i1 = 8;
        }
        ((ImageView)localObject).setVisibility(i1);
      }
    }
    else if (this.s > 0)
    {
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.g;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.g;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
  }
  
  private final IRoomAudioService b(long paramLong)
  {
    IRoomAudioService localIRoomAudioService = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localIRoomAudioService, "ServiceCenter.getService…ass.java).audioOp(roomId)");
    return localIRoomAudioService;
  }
  
  private final void b(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Object localObject1 = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
    long l1 = ((ILoginCoreService)localObject1).a();
    localObject1 = (Iterable)paramList;
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i1;
    while (((Iterator)localObject2).hasNext())
    {
      paramList = ((Iterator)localObject2).next();
      if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList).uid.get() == l1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        break label89;
      }
    }
    paramList = null;
    label89:
    boolean bool;
    if ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2).uid.get() > 0L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        paramList.add(localObject2);
      }
    }
    this.s = ((List)paramList).size();
  }
  
  private final boolean c()
  {
    IExpandHall localIExpandHall = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    return (localIExpandHall != null) && (localIExpandHall.j() == true);
  }
  
  private final void d()
  {
    Logger.c("ExpandHallInputBoxView", "bindMicSpeakerReport invoke");
    HallReportHelper localHallReportHelper = getReportHelper();
    if (localHallReportHelper != null)
    {
      ImageView localImageView = this.g;
      if (localImageView != null)
      {
        IReportService.DefaultImpls.c((IReportService)ServiceCenter.a(IReportService.class), (View)localImageView, false, null, localHallReportHelper.q(), null, 22, null);
        VideoReport.setEventDynamicParams(localImageView, (IDynamicParams)new ExpandHallInputBoxView.bindMicSpeakerReport..inlined.apply.lambda.1(this, localHallReportHelper));
      }
      localImageView = this.f;
      if (localImageView != null)
      {
        IReportService.DefaultImpls.c((IReportService)ServiceCenter.a(IReportService.class), (View)localImageView, false, null, localHallReportHelper.r(), null, 22, null);
        VideoReport.setEventDynamicParams(localImageView, (IDynamicParams)new ExpandHallInputBoxView.bindMicSpeakerReport..inlined.apply.lambda.2(this, localHallReportHelper));
      }
    }
  }
  
  private final HallReportHelper getReportHelper()
  {
    IExpandHall localIExpandHall = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localIExpandHall != null) {
      return localIExpandHall.e();
    }
    return null;
  }
  
  private final void k()
  {
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l1 = ((ILoginCoreService)localObject).a();
    boolean bool = b(this.n).a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMicSucceed micEnable:");
    ((StringBuilder)localObject).append(bool);
    Logger.b("ExpandHallInputBoxView", ((StringBuilder)localObject).toString());
    int i1;
    if (bool) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.n).a(l1, i1, (IResultListener)new ExpandHallInputBoxView.changeMicSwitch.1());
  }
  
  public void a()
  {
    this.c = ((EditText)findViewById(2131435831));
    this.d = ((TextView)findViewById(2131445618));
    this.i = findViewById(2131440711);
    this.e = ((ImageView)findViewById(2131432439));
    this.f = ((ImageView)findViewById(2131446206));
    this.g = ((ImageView)findViewById(2131438169));
    this.h = ((ConstraintLayout)findViewById(2131435814));
    Object localObject1 = this.c;
    if (localObject1 != null) {
      ViewExKt.a((View)localObject1, LayoutExKt.b(18), new int[] { Color.parseColor("#F7F7F7") });
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((EditText)localObject1).post((Runnable)new ExpandHallInputBoxView.layoutInflated.1(this));
    }
    localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ViewExKt.a((View)localObject1, LayoutExKt.b(18), new int[] { Color.parseColor("#F5A300") });
    } else {
      localObject1 = null;
    }
    this.j = ((Drawable)localObject1);
    TextView localTextView = this.d;
    localObject1 = localObject2;
    if (localTextView != null) {
      localObject1 = ViewExKt.a((View)localTextView, LayoutExKt.b(18), new int[] { Color.parseColor("#F7F7F7") });
    }
    this.k = ((Drawable)localObject1);
    b();
    localObject1 = this.e;
    if (localObject1 != null) {
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new ExpandHallInputBoxView.layoutInflated.2(this));
    }
    localObject1 = ResUtils.c(2131917691);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ResUtils.getString(R.string.try_send_something)");
    TimiBaseInputView.a(this, 0.0F, 0, (String)localObject1, 3, null);
    localObject1 = this.c;
    if (localObject1 != null) {
      ((EditText)localObject1).addTextChangedListener((TextWatcher)new ExpandHallInputBoxView.layoutInflated.3(this));
    }
    a((TimiBaseInputView.StateChangedListener)new ExpandHallInputBoxView.layoutInflated.4(this));
  }
  
  public final void a(long paramLong)
  {
    this.n = paramLong;
    if (!c())
    {
      a(false);
      return;
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(paramLong).a((YoloRoomInterface.YoloRoomMediaEnvCheckCallback)new ExpandHallInputBoxView.bindRoom.1(this, paramLong));
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…ass.java).getData(roomId)");
    localObject = ((IRoomGetDataService)localObject).h();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "memberList");
    b((List)localObject);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(paramLong).a((YoloRoomInterface.YoloRoomCommonListener)this.t);
    d();
  }
  
  public void a(@NotNull List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    b(paramList);
  }
  
  public void a(@NotNull ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "memberMicLevelList");
  }
  
  public final void b()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((EditText)localObject).getEditableText();
    } else {
      localObject = null;
    }
    localObject = (CharSequence)localObject;
    boolean bool;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    if (getCurrentState() != 1)
    {
      localObject = this.i;
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(12));
      }
      localObject = this.d;
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(12));
      }
    }
    else
    {
      localObject = this.i;
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(16));
      }
      localObject = this.d;
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(16));
      }
    }
    localObject = this.i;
    if (localObject != null) {
      ViewExKt.a((View)localObject, bool);
    }
    localObject = this.d;
    if (localObject != null) {
      ViewExKt.a((View)localObject, bool ^ true);
    }
    if (bool)
    {
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setBackgroundDrawable(this.k);
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.m);
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setBackgroundDrawable(this.j);
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.l);
      }
    }
  }
  
  @Nullable
  public ImageView getEmojiBtn()
  {
    return this.e;
  }
  
  @Nullable
  public final View getFuncBtn()
  {
    return this.i;
  }
  
  @Nullable
  public EditText getInputEditText()
  {
    return this.c;
  }
  
  public int getLayoutId()
  {
    return 2131629432;
  }
  
  @Nullable
  public TextView getSendBtn()
  {
    return this.d;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    LiveData localLiveData = this.o;
    if (localLiveData != null) {
      localLiveData.removeObserver(this.q);
    }
    localLiveData = this.p;
    if (localLiveData != null) {
      localLiveData.removeObserver(this.r);
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.n).b((YoloRoomInterface.YoloRoomCommonListener)this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView
 * JD-Core Version:    0.7.0.1
 */