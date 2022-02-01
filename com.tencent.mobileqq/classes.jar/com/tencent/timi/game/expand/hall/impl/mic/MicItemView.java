package com.tencent.timi.game.expand.hall.impl.mic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.team.MicWaveViewLottie;
import com.tencent.timi.game.ui.ILifeCycleView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/mic/MicItemView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/ui/ILifeCycleView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPos", "mRoomId", "", "mSpeakingPosInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "mSpeakingPosInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "autoOpenMic", "", "destroy", "playWaveAnimation", "refreshData", "roomId", "position", "speakingPosInfo", "speakingPosInfoList", "", "refreshUI", "selfOnMic", "", "showEmptyMicUI", "showNormalUserEmptyMicUI", "showOnMicUI", "showWhiteListUserEmptyMicUI", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicItemView
  extends FrameLayout
  implements ILifeCycleView
{
  public static final MicItemView.Companion a = new MicItemView.Companion(null);
  private static final int f = CommonExKt.a(54);
  private YoloRoomOuterClass.YoloRoomSpeakingPosInfo b;
  private final ArrayList<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> c = new ArrayList();
  private int d;
  private long e;
  private HashMap g;
  
  @JvmOverloads
  public MicItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public MicItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public MicItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629521, (ViewGroup)this);
    f();
  }
  
  private final void d()
  {
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = this.b;
    if (localYoloRoomSpeakingPosInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    if (localYoloRoomSpeakingPosInfo.uid.get() == 0L)
    {
      f();
      return;
    }
    e();
  }
  
  private final void e()
  {
    Object localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject1 != null) {
      localObject1 = ((IExpandHall)localObject1).e();
    } else {
      localObject1 = null;
    }
    Object localObject2 = (TextView)a(2131439553);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "onMicHintTxv");
    ((TextView)localObject2).setVisibility(4);
    localObject2 = (ImageView)a(2131449224);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "userAvatarEmptyHintView");
    ((ImageView)localObject2).setVisibility(4);
    localObject2 = new CommonOuterClass.QQUserId();
    Object localObject3 = ((CommonOuterClass.QQUserId)localObject2).uid;
    Object localObject4 = this.b;
    if (localObject4 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    ((PBUInt64Field)localObject3).set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject4).uid.get());
    localObject3 = ((CommonOuterClass.QQUserId)localObject2).user_from;
    localObject4 = this.b;
    if (localObject4 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    ((PBInt32Field)localObject3).set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject4).user_from.get());
    localObject3 = ((CommonOuterClass.QQUserId)localObject2).guild_id;
    localObject4 = this.b;
    if (localObject4 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    ((PBUInt64Field)localObject3).set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject4).guild_id.get());
    localObject3 = (AvatarRoundImageView)a(2131449225);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "userAvatarView");
    int i = 0;
    ((AvatarRoundImageView)localObject3).setVisibility(0);
    ((AvatarRoundImageView)a(2131449225)).setUserId((CommonOuterClass.QQUserId)localObject2);
    ((AvatarRoundImageView)a(2131449225)).setOnClickListener((View.OnClickListener)new MicItemView.showOnMicUI.1((CommonOuterClass.QQUserId)localObject2));
    if (localObject1 != null)
    {
      localObject3 = (IReportService)ServiceCenter.a(IReportService.class);
      localObject4 = (AvatarRoundImageView)a(2131449225);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "userAvatarView");
      ((IReportService)localObject3).a(localObject4, ((HallReportHelper)localObject1).a());
      localObject3 = (Map)((HallReportHelper)localObject1).s();
      localObject4 = this.b;
      if (localObject4 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
      }
      ((Map)localObject3).put("yes_to_uid", String.valueOf(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject4).uid.get()));
      localObject4 = (IReportService)ServiceCenter.a(IReportService.class);
      AvatarRoundImageView localAvatarRoundImageView = (AvatarRoundImageView)a(2131449225);
      Intrinsics.checkExpressionValueIsNotNull(localAvatarRoundImageView, "userAvatarView");
      IReportService.DefaultImpls.a((IReportService)localObject4, (View)localAvatarRoundImageView, false, null, ((HallReportHelper)localObject1).o(), (Map)localObject3, 6, null);
    }
    localObject1 = (AvatarTextView)a(2131449231);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "userNickNameTxv");
    ((AvatarTextView)localObject1).setVisibility(0);
    ((AvatarTextView)a(2131449231)).setUserId((CommonOuterClass.QQUserId)localObject2);
    localObject1 = (AvatarSpeakingMicImageView)a(2131438167);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "micSwitchHintView");
    ((AvatarSpeakingMicImageView)localObject1).setVisibility(0);
    localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    boolean bool;
    if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("micEnableInInfo ");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(", uin:");
    localObject3 = this.b;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    ((StringBuilder)localObject1).append(MobileQQ.getShortUinStr(String.valueOf(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject3).uid.get())));
    Logger.b("MicItemView_", ((StringBuilder)localObject1).toString());
    ((AvatarSpeakingMicImageView)a(2131438167)).e();
    ((AvatarSpeakingMicImageView)a(2131438167)).setData((CommonOuterClass.QQUserId)localObject2, bool);
    ((MicWaveViewLottie)a(2131438168)).setUserId((CommonOuterClass.QQUserId)localObject2);
    localObject1 = (MicWaveViewLottie)a(2131438168);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "micWaveView");
    localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2).voice_switch.get() != 1) {
      i = 8;
    }
    ((MicWaveViewLottie)localObject1).setVisibility(i);
  }
  
  private final void f()
  {
    Object localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject1 == null)
    {
      Logger.c("MicItemView_", "showEmptyMicUI currentHall is null!");
      return;
    }
    Object localObject2 = (MicWaveViewLottie)a(2131438168);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "micWaveView");
    ((MicWaveViewLottie)localObject2).setVisibility(4);
    localObject2 = (AvatarSpeakingMicImageView)a(2131438167);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "micSwitchHintView");
    ((AvatarSpeakingMicImageView)localObject2).setVisibility(4);
    localObject2 = (AvatarTextView)a(2131449231);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "userNickNameTxv");
    ((AvatarTextView)localObject2).setVisibility(4);
    localObject2 = (AvatarRoundImageView)a(2131449225);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "userAvatarView");
    ((AvatarRoundImageView)localObject2).setVisibility(4);
    localObject2 = (ImageView)a(2131449224);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "userAvatarEmptyHintView");
    ((ImageView)localObject2).setVisibility(0);
    if (((IExpandHall)localObject1).k()) {
      g();
    } else {
      h();
    }
    localObject1 = ((IExpandHall)localObject1).e();
    localObject2 = (IReportService)ServiceCenter.a(IReportService.class);
    ImageView localImageView = (ImageView)a(2131449224);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "userAvatarEmptyHintView");
    ((IReportService)localObject2).a(localImageView, ((HallReportHelper)localObject1).a());
    localObject2 = (IReportService)ServiceCenter.a(IReportService.class);
    localImageView = (ImageView)a(2131449224);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "userAvatarEmptyHintView");
    IReportService.DefaultImpls.a((IReportService)localObject2, (View)localImageView, false, null, ((HallReportHelper)localObject1).p(), (Map)((HallReportHelper)localObject1).s(), 6, null);
  }
  
  private final void g()
  {
    TextView localTextView = (TextView)a(2131439553);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "onMicHintTxv");
    localTextView.setVisibility(0);
    ((ImageView)a(2131449224)).setImageResource(2130853196);
    ((ImageView)a(2131449224)).setOnClickListener((View.OnClickListener)new MicItemView.showWhiteListUserEmptyMicUI.1(this));
  }
  
  private final void h()
  {
    TextView localTextView = (TextView)a(2131439553);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "onMicHintTxv");
    localTextView.setVisibility(4);
    ((ImageView)a(2131449224)).setImageResource(2130853174);
    ((ImageView)a(2131449224)).setOnClickListener((View.OnClickListener)new MicItemView.showNormalUserEmptyMicUI.1(this));
  }
  
  private final boolean i()
  {
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((Iterator)localObject).next()).uid.get() == l) {
        return true;
      }
    }
    return false;
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
    ((MicWaveViewLottie)a(2131438168)).e();
  }
  
  public final void a(long paramLong, int paramInt, @NotNull YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @NotNull List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramYoloRoomSpeakingPosInfo, "speakingPosInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "speakingPosInfoList");
    this.b = paramYoloRoomSpeakingPosInfo;
    this.c.clear();
    this.c.addAll((Collection)paramList);
    this.e = paramLong;
    this.d = paramInt;
    d();
  }
  
  public void b()
  {
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSpeakingPosInfo");
    }
    if (l != ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).uid.get()) {
      return;
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.e).a((IResultListener)new MicItemView.destroy.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView
 * JD-Core Version:    0.7.0.1
 */