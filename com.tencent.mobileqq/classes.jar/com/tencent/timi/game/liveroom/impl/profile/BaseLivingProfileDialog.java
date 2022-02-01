package com.tencent.timi.game.liveroom.impl.profile;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.api.ProfileOperateType;
import com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog;
import com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog.ItemClickListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.BaseCommonDialog;
import com.tencent.timi.game.ui.widget.IDialogLoading;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.utils.DrawableUtil;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/BaseLivingProfileDialog;", "Lcom/tencent/timi/game/ui/widget/BaseCommonDialog;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/timi/game/ui/widget/IDialogLoading;", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "dialogContext", "Landroid/content/Context;", "blurBackgroundView", "Landroid/view/View;", "roomId", "", "reprotInfo", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;Landroid/content/Context;Landroid/view/View;JLcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;)V", "TAG", "", "getBlurBackgroundView", "()Landroid/view/View;", "setBlurBackgroundView", "(Landroid/view/View;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "(Landroid/content/Context;)V", "isDismiss", "", "()Z", "setDismiss", "(Z)V", "itemClickListener", "Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "myUserId", "operateDialog", "Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog;", "reportReasonList", "", "getReprotInfo", "()Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "setReprotInfo", "(Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;)V", "getRoomId", "()J", "setRoomId", "(J)V", "acquireBgView", "acquireContentView", "acquireLeftButton", "Landroid/widget/TextView;", "acquireReportModuleMap", "", "acquireRightButton", "acquireRightFrame", "dismiss", "", "doReport", "hideLeftButton", "hideLoadingView", "initDialog", "initView", "isSelf", "onClick", "v", "onDetachedFromWindow", "onLeftButtonClick", "onRightButtonClick", "openOperateDialog", "type", "", "list", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "report", "setData", "setOperateContent", "leftTextRes", "rightTextRes", "setOperateListener", "listener", "showLoadingView", "loadingTextResId", "text", "showOperateView", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseLivingProfileDialog
  extends BaseCommonDialog
  implements View.OnClickListener, IDialogLoading
{
  private final String a = "BaseLivingProfileDialog";
  private ProfileOperateDialog.ItemClickListener b;
  private ProfileOperateDialog c;
  private boolean d;
  private final List<String> f = CollectionsKt.listOf(new String[] { "发布色情/违法信息", "存在欺诈骗钱行为", "冒充他人", "侵犯未成年人权益", "帐号可能被盗了", "存在其他违法行为" });
  @NotNull
  private LiveUserInfo g;
  @NotNull
  private Context h;
  @Nullable
  private LivingProfileReportInfo i;
  @Nullable
  private View j;
  private long k;
  private long l;
  
  public BaseLivingProfileDialog(@NotNull LiveUserInfo paramLiveUserInfo, @NotNull Context paramContext, @Nullable View paramView, long paramLong, @Nullable LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    super(paramContext);
    this.g = paramLiveUserInfo;
    this.h = paramContext;
    this.j = paramView;
    this.k = paramLong;
    this.i = paramLivingProfileReportInfo;
    this.l = LivingOperateHelper.a.a();
    t();
    s();
  }
  
  private final void s()
  {
    Object localObject1 = this.i;
    if (localObject1 != null)
    {
      Object localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      Object localObject3 = (FrameLayout)findViewById(2131431881);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "dialogView");
      ((ILiveReportService)localObject2).a(localObject3, ((LivingProfileReportInfo)localObject1).a(), ((LivingProfileReportInfo)localObject1).e());
      localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject3 = (RelativeLayout)findViewById(2131431338);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "contentView");
      ((ILiveReportService)localObject2).a((View)localObject3, true, null, ((LivingProfileReportInfo)localObject1).b(), ((LivingProfileReportInfo)localObject1).c());
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (TimiRoundImageView)findViewById(2131434941);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "headerIcon");
      ((ILiveReportService)localObject1).a((View)localObject2, true, null, "em_qqlive_inf_picnick", g());
      if (!f())
      {
        localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        localObject2 = (TextView)findViewById(2131444660);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "reportButton");
        ((ILiveReportService)localObject1).a((View)localObject2, true, null, "em_qqlive_report", g());
      }
    }
  }
  
  private final void t()
  {
    setContentView(View.inflate(this.h, 2131629454, null));
    Object localObject = (RelativeLayout)findViewById(2131431338);
    if (localObject != null) {
      ViewExKt.a((View)localObject, LayoutExKt.b(6), new int[] { Color.parseColor("#F3101016") });
    }
    localObject = (TextView)findViewById(2131444660);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = (ImageView)findViewById(2131430808);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = (TextView)findViewById(2131444660);
    if (localObject != null) {
      ViewExKt.a((View)localObject, true ^ f());
    }
    i();
    u();
  }
  
  private final void u()
  {
    String str = this.g.headUrl;
    if (TextUtils.isEmpty((CharSequence)str))
    {
      ((TimiRoundImageView)findViewById(2131434941)).setImageResource(2130853132);
    }
    else
    {
      localObject = DrawableUtil.a.a(ViewUtils.dpToPx(86.0F), (TimiRoundImageView)findViewById(2131434941), 2130853132);
      DrawableUtil.a.a(str, (TimiRoundImageView)findViewById(2131434941), (URLDrawable.URLDrawableOptions)localObject);
    }
    str = this.g.nick;
    if (str == null) {
      str = "";
    }
    Object localObject = (TextView)findViewById(2131449230);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "userNameText");
    ((TextView)localObject).setText((CharSequence)str);
  }
  
  private final void v()
  {
    Object localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    localObject1 = ((ITgLiveRoomService)localObject1).d();
    if (localObject1 != null) {
      localObject1 = ((IQQLiveSDK)localObject1).getReportModule();
    } else {
      localObject1 = null;
    }
    Object localObject3;
    if (localObject1 == null)
    {
      localObject2 = this.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("doReport module error ");
      ((StringBuilder)localObject3).append(localObject1);
      Logger.c((String)localObject2, ((StringBuilder)localObject3).toString());
    }
    localObject1 = (List)new ArrayList();
    Object localObject2 = (Iterable)this.f;
    int m = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (m < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      ((List)localObject1).add(new AdminReason(m, (String)localObject3));
      m += 1;
    }
    a(ProfileOperateType.a.c(), (List)localObject1);
  }
  
  protected final void a(int paramInt, @Nullable List<? extends AdminReason> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = this.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      this.c = new ProfileOperateDialog(paramInt, paramList, (Context)localObject, this.j);
      paramList = this.c;
      if (paramList != null) {
        paramList.a(this.b);
      }
      paramList = this.c;
      if (paramList != null) {
        paramList.show();
      }
      return;
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forbiddenSpeech error ");
    localStringBuilder.append(paramList);
    Logger.c((String)localObject, localStringBuilder.toString());
  }
  
  public final void a(@NotNull ProfileOperateDialog.ItemClickListener paramItemClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramItemClickListener, "listener");
    this.b = paramItemClickListener;
    ProfileOperateDialog localProfileOperateDialog = this.c;
    if (localProfileOperateDialog != null) {
      localProfileOperateDialog.a(paramItemClickListener);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    int m;
    if (((CharSequence)paramString).length() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      paramString = (TimiGamePageLoadingView)findViewById(2131437626);
      String str = this.e.getString(2131917232);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…ame_loading_hint_default)");
      paramString.setHintText(str);
    }
    else
    {
      ((TimiGamePageLoadingView)findViewById(2131437626)).setHintText(paramString);
    }
    ((TimiGamePageLoadingView)findViewById(2131437626)).a();
  }
  
  protected final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "leftTextRes");
    Intrinsics.checkParameterIsNotNull(paramString2, "rightTextRes");
    ((MediumBoldTextView)findViewById(2131437069)).setText((CharSequence)paramString1);
    ((MediumBoldTextView)findViewById(2131444787)).setText((CharSequence)paramString2);
  }
  
  protected final boolean a()
  {
    return this.d;
  }
  
  @NotNull
  protected final LiveUserInfo b()
  {
    return this.g;
  }
  
  @NotNull
  protected final Context c()
  {
    return this.h;
  }
  
  @Nullable
  protected final LivingProfileReportInfo d()
  {
    return this.i;
  }
  
  public void dismiss()
  {
    this.d = true;
    super.dismiss();
  }
  
  protected final long e()
  {
    return this.k;
  }
  
  protected final boolean f()
  {
    return this.g.uid == this.l;
  }
  
  @NotNull
  protected final Map<String, String> g()
  {
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("zengzhi_moduleid", "em_qqlive_inf_module");
    return localMap;
  }
  
  @NotNull
  protected final TextView h()
  {
    MediumBoldTextView localMediumBoldTextView = (MediumBoldTextView)findViewById(2131437069);
    Intrinsics.checkExpressionValueIsNotNull(localMediumBoldTextView, "leftButton");
    return (TextView)localMediumBoldTextView;
  }
  
  public abstract void i();
  
  protected final void j()
  {
    Object localObject = findViewById(2131432017);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dividerView");
    ViewExKt.a((View)localObject, true);
    localObject = (LinearLayout)findViewById(2131439616);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "operateLinear");
    ViewExKt.a((View)localObject, true);
    localObject = (MediumBoldTextView)findViewById(2131437069);
    View.OnClickListener localOnClickListener = (View.OnClickListener)this;
    ((MediumBoldTextView)localObject).setOnClickListener(localOnClickListener);
    ((FrameLayout)findViewById(2131444789)).setOnClickListener(localOnClickListener);
  }
  
  @NotNull
  protected final TextView k()
  {
    MediumBoldTextView localMediumBoldTextView = (MediumBoldTextView)findViewById(2131444787);
    Intrinsics.checkExpressionValueIsNotNull(localMediumBoldTextView, "rightButton");
    return (TextView)localMediumBoldTextView;
  }
  
  @NotNull
  protected final View l()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131444789);
    Intrinsics.checkExpressionValueIsNotNull(localFrameLayout, "rightFrame");
    return (View)localFrameLayout;
  }
  
  protected final void m()
  {
    Object localObject = (MediumBoldTextView)findViewById(2131437069);
    if (localObject != null) {
      ViewExKt.a((View)localObject, false);
    }
    localObject = findViewById(2131440682);
    if (localObject != null) {
      ViewExKt.a((View)localObject, false);
    }
  }
  
  public void n() {}
  
  public void o() {}
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int m = paramView.getId();
      if (m == 2131444660)
      {
        v();
        dismiss();
      }
      else if (m == 2131430808)
      {
        dismiss();
      }
      else if (m == 2131437069)
      {
        n();
      }
      else if (m == 2131444789)
      {
        o();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  @NotNull
  public View p()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "contentView");
    return (View)localRelativeLayout;
  }
  
  @NotNull
  public View q()
  {
    View localView = findViewById(2131429401);
    Intrinsics.checkExpressionValueIsNotNull(localView, "bgView");
    return localView;
  }
  
  public void r()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = (TimiGamePageLoadingView)findViewById(2131437626);
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.BaseLivingProfileDialog
 * JD-Core Version:    0.7.0.1
 */