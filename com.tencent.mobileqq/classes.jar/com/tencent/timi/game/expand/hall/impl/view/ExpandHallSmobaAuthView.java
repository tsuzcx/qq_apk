package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.Logger;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "reporterHelper", "Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/timi/game/expand/hall/api/HallReportHelper;)V", "authCallback", "com/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView$authCallback$1", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView$authCallback$1;", "authInfoObserver", "Landroidx/lifecycle/Observer;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "cancelSucceed", "", "mAuthFlag", "mCheckChangedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOnBackListener", "Landroid/view/View$OnClickListener;", "mOnCloseListener", "mOwner", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mReportHelper", "mState", "mState$annotations", "()V", "bindValue", "", "owner", "cancelConfirm", "doAgreeAuthTask", "doAgreeAuthTaskOld", "doCancelAuthTask", "dialogInterface", "Landroid/content/DialogInterface;", "getOnBackListener", "getState", "handleSmobaAuthInfo", "value", "hide", "hideAnim", "hideSelf", "init", "setOnBackListener", "listener", "setOnCloseListener", "show", "showAnim", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallSmobaAuthView
  extends FrameLayout
{
  public static final ExpandHallSmobaAuthView.Companion a = new ExpandHallSmobaAuthView.Companion(null);
  private int b = 2;
  private View.OnClickListener c;
  private View.OnClickListener d;
  private boolean e;
  private final HallReportHelper f;
  private QBaseActivity g;
  private final CompoundButton.OnCheckedChangeListener h;
  private final Observer<GameDataServerOuterClass.GetSmobaAuthInfoRsp> i;
  private final ExpandHallSmobaAuthView.authCallback.1 j;
  private boolean k;
  private HashMap l;
  
  @JvmOverloads
  public ExpandHallSmobaAuthView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, null, 14, null);
  }
  
  @JvmOverloads
  public ExpandHallSmobaAuthView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, null, 12, null);
  }
  
  @JvmOverloads
  public ExpandHallSmobaAuthView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, null, 8, null);
  }
  
  @JvmOverloads
  public ExpandHallSmobaAuthView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, @NotNull HallReportHelper paramHallReportHelper)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramHallReportHelper;
    this.h = ((CompoundButton.OnCheckedChangeListener)new ExpandHallSmobaAuthView.mCheckChangedListener.1(this));
    this.i = ((Observer)new ExpandHallSmobaAuthView.authInfoObserver.1(this));
    this.j = new ExpandHallSmobaAuthView.authCallback.1(this, paramContext);
    View.inflate(paramContext, 2131629520, (ViewGroup)this);
    setBackgroundResource(2131168376);
    ((ImageView)a(2131429212)).setOnClickListener((View.OnClickListener)new ExpandHallSmobaAuthView.1(this));
    paramContext = this.f;
    paramAttributeSet = (ImageView)a(2131430812);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "closeIconIgv");
    paramContext.a((View)paramAttributeSet, this.f.i());
    ((ImageView)a(2131430812)).setOnClickListener((View.OnClickListener)new ExpandHallSmobaAuthView.2(this));
    setOnClickListener((View.OnClickListener)new ExpandHallSmobaAuthView.3(this));
    ((LinearLayout)a(2131431333)).setOnClickListener((View.OnClickListener)ExpandHallSmobaAuthView.4.a);
  }
  
  private final void a(DialogInterface paramDialogInterface)
  {
    LoadingUtils.a.a(paramDialogInterface);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).e((IUserSmobaInfoService.Callback)new ExpandHallSmobaAuthView.doCancelAuthTask.1(this, paramDialogInterface));
  }
  
  private final void a(GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    if (paramGetSmobaAuthInfoRsp != null)
    {
      localObject = paramGetSmobaAuthInfoRsp.is_auth;
      if (localObject != null)
      {
        bool = ((PBBoolField)localObject).get();
        break label23;
      }
    }
    boolean bool = false;
    label23:
    this.e = bool;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleSmobaAuthInfo value:");
    ((StringBuilder)localObject).append(paramGetSmobaAuthInfoRsp);
    ((StringBuilder)localObject).append(", mAuthFlag:");
    ((StringBuilder)localObject).append(this.e);
    Logger.a("ExpandHallSmobaAuthView_", ((StringBuilder)localObject).toString());
    ((Switch)a(2131446672)).setOnCheckedChangeListener(null);
    localObject = (Switch)a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "switchBtn");
    ((Switch)localObject).setChecked(this.e);
    ((Switch)a(2131446672)).setOnCheckedChangeListener(this.h);
    if (paramGetSmobaAuthInfoRsp != null)
    {
      localObject = new StringBuffer();
      paramGetSmobaAuthInfoRsp = paramGetSmobaAuthInfoRsp.auth_desc.get().iterator();
      while (paramGetSmobaAuthInfoRsp.hasNext())
      {
        ((StringBuffer)localObject).append((String)paramGetSmobaAuthInfoRsp.next());
        ((StringBuffer)localObject).append("\n\n");
      }
      paramGetSmobaAuthInfoRsp = (TextView)a(2131428879);
      Intrinsics.checkExpressionValueIsNotNull(paramGetSmobaAuthInfoRsp, "authDescTxv");
      paramGetSmobaAuthInfoRsp.setText((CharSequence)((StringBuffer)localObject).toString());
    }
  }
  
  private final void b(QBaseActivity paramQBaseActivity)
  {
    LiveData localLiveData = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c();
    localLiveData.observe((LifecycleOwner)paramQBaseActivity, this.i);
    a((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localLiveData.getValue());
  }
  
  private final void c()
  {
    ExpandHallSmobaAuthView.doAgreeAuthTask.cb.1 local1 = new ExpandHallSmobaAuthView.doAgreeAuthTask.cb.1(this);
    IUserSmobaInfoService localIUserSmobaInfoService = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "TimiGameActivityManager.getTopQActivity()");
    localIUserSmobaInfoService.a(localQBaseActivity, true, (IUserSmobaInfoService.AuthToGetSmobaInfoCallback)local1, null);
  }
  
  private final void d()
  {
    this.k = false;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    new CommonDialog.Builder(localContext).c("取消后将无法参与展示王者战绩及王者组队游戏，是否取消").d("晚点再说").a((DialogInterface.OnClickListener)new ExpandHallSmobaAuthView.cancelConfirm.commonDialog.1(this)).e("狠心取消").d(false).b((DialogInterface.OnClickListener)new ExpandHallSmobaAuthView.cancelConfirm.commonDialog.2(this)).b(true).a((DialogInterface.OnDismissListener)new ExpandHallSmobaAuthView.cancelConfirm.commonDialog.3(this)).a().show();
  }
  
  private final void e()
  {
    setVisibility(0);
    post((Runnable)new ExpandHallSmobaAuthView.showAnim.1(this));
  }
  
  private final void f()
  {
    post((Runnable)new ExpandHallSmobaAuthView.hideAnim.1(this));
  }
  
  private final void g()
  {
    setVisibility(8);
    this.b = 2;
  }
  
  public View a(int paramInt)
  {
    if (this.l == null) {
      this.l = new HashMap();
    }
    View localView2 = (View)this.l.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.l.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    if (this.b == 1) {
      return;
    }
    this.b = 1;
    e();
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "owner");
    this.g = paramQBaseActivity;
    b(paramQBaseActivity);
  }
  
  public final void b()
  {
    if (this.b == 2) {
      return;
    }
    this.b = 2;
    f();
  }
  
  @Nullable
  public final View.OnClickListener getOnBackListener()
  {
    return this.c;
  }
  
  public final int getState()
  {
    return this.b;
  }
  
  public final void setOnBackListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.c = paramOnClickListener;
  }
  
  public final void setOnCloseListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.d = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView
 * JD-Core Version:    0.7.0.1
 */