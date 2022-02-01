package com.tencent.mobileqq.qqlive.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper;
import com.tencent.mobileqq.qqlive.prepare.GameListAdapter;
import com.tencent.mobileqq.qqlive.prepare.IGameListView;
import com.tencent.mobileqq.qqlive.prepare.PrepareDTHelper;
import com.tencent.mobileqq.qqlive.prepare.PrepareFragmentViewModel;
import com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.Map;

public class GameListDialog
  extends BaseDialog<PrepareFragmentViewModel>
  implements View.OnClickListener, IGameListView
{
  private RecyclerView b;
  private LifeCycleAndViewModelStoreOwner c;
  private View d;
  private Context e;
  
  public GameListDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    a(paramContext, paramBoolean);
    b();
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    this.e = paramContext;
    this.d = LayoutInflater.from(paramContext).inflate(2131627987, null);
    this.b = ((RecyclerView)this.d.findViewById(2131442404));
    ((ImageView)this.d.findViewById(2131442376)).setOnClickListener(this);
    if (getWindow() != null)
    {
      paramContext = getWindow();
      paramContext.setWindowAnimations(2131953329);
      paramContext.setGravity(80);
      paramContext.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.width = -1;
      paramContext.setAttributes(localLayoutParams);
      paramContext.addContentView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!paramBoolean)
    {
      setCanceledOnTouchOutside(false);
      setCancelable(false);
      setOnKeyListener(new GameListDialog.1(this));
    }
  }
  
  private void b()
  {
    c();
    d();
    e();
  }
  
  private void c()
  {
    this.c = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)this.e);
    this.a = ((BaseViewModel)ViewModelProviderHelper.a(this.c, PrepareFragmentViewModel.k).get(PrepareFragmentViewModel.class));
    IQQLiveSDK localIQQLiveSDK = QQLiveSDKHelper.a(null);
    QQLiveGamePrepareViewBinderHelper.a(getContext(), this.c, (PrepareFragmentViewModel)this.a, this, PrepareDTHelper.a((PrepareFragmentViewModel)this.a, localIQQLiveSDK));
  }
  
  private void d()
  {
    ((PrepareFragmentViewModel)this.a).a(false);
  }
  
  private void e()
  {
    if (this.d != null)
    {
      Map localMap = f();
      ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.d, "pg_qqlive_gamelive_start", localMap);
      ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("pgin", this.d, localMap);
      ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.b, true, null, "em_qqlive_content_choice_panel", localMap);
    }
  }
  
  private Map<String, String> f()
  {
    Object localObject = QQLiveSDKHelper.a(null);
    localObject = PrepareDTHelper.a((PrepareFragmentViewModel)this.a, (IQQLiveSDK)localObject);
    ((Map)localObject).put("pgid", "pg_qqlive_gamelive_start");
    return localObject;
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  public void a(GameListAdapter paramGameListAdapter)
  {
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(this.e, 4);
    this.b.setLayoutManager(localGridLayoutManager);
    this.b.setAdapter(paramGameListAdapter);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442376) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.GameListDialog
 * JD-Core Version:    0.7.0.1
 */