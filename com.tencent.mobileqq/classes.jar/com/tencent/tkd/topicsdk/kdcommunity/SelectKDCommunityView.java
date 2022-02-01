package com.tencent.tkd.topicsdk.kdcommunity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/SelectKDCommunityView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IView;", "context", "Landroid/app/Activity;", "selectedCommunityId", "", "presenter", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IPresenter;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityAdapter;", "communityGridView", "Landroid/widget/GridView;", "contentLayout", "getContext", "()Landroid/app/Activity;", "failedLayout", "Landroid/widget/RelativeLayout;", "loadingLayout", "onSelectCallback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Lkotlin/ParameterName;", "name", "communityInfo", "", "getOnSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IPresenter;", "retryView", "Landroid/widget/TextView;", "getSelectedCommunityId", "()Ljava/lang/String;", "titleView", "hideError", "onAttachedToWindow", "onDetachedFromWindow", "showCommunityList", "communityList", "", "showError", "showTitle", "startLoading", "stopLoading", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectKDCommunityView
  extends LinearLayout
  implements KDCommunityContract.IView
{
  public static final SelectKDCommunityView.Companion a = new SelectKDCommunityView.Companion(null);
  private final LinearLayout b;
  private final TextView c;
  private final GridView d;
  private final RelativeLayout e;
  private final RelativeLayout f;
  private final TextView g;
  private final KDCommunityAdapter h;
  @Nullable
  private Function1<? super CommunityInfo, Unit> i;
  @NotNull
  private final Activity j;
  @NotNull
  private final String k;
  @NotNull
  private final KDCommunityContract.IPresenter l;
  
  public SelectKDCommunityView(@NotNull Activity paramActivity, @NotNull String paramString, @NotNull KDCommunityContract.IPresenter paramIPresenter)
  {
    super((Context)paramActivity);
    this.j = paramActivity;
    this.k = paramString;
    this.l = paramIPresenter;
    LayoutInflater.from((Context)this.j).inflate(R.layout.H, (ViewGroup)this, true);
    paramActivity = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.contentLayout)");
    this.b = ((LinearLayout)paramActivity);
    paramActivity = findViewById(R.id.ao);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.titleView)");
    this.c = ((TextView)paramActivity);
    paramActivity = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.communityGridView)");
    this.d = ((GridView)paramActivity);
    paramActivity = findViewById(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.loadingLayout)");
    this.e = ((RelativeLayout)paramActivity);
    paramActivity = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.failedLayout)");
    this.f = ((RelativeLayout)paramActivity);
    paramActivity = findViewById(R.id.ab);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.retryView)");
    this.g = ((TextView)paramActivity);
    this.h = new KDCommunityAdapter((Context)this.j, this.k);
    this.d.setAdapter((ListAdapter)this.h);
    this.d.setOnItemClickListener((AdapterView.OnItemClickListener)new SelectKDCommunityView.1(this));
  }
  
  public void a()
  {
    this.e.setVisibility(0);
  }
  
  public void a(@NotNull List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "communityList");
    this.b.setVisibility(0);
    this.d.setVisibility(0);
    this.h.a(paramList);
  }
  
  public void b()
  {
    this.e.setVisibility(8);
  }
  
  public void c()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void d()
  {
    this.f.setVisibility(0);
    this.g.setOnClickListener((View.OnClickListener)new SelectKDCommunityView.showError.1(this));
  }
  
  public void e()
  {
    this.f.setVisibility(8);
  }
  
  @NotNull
  public final Activity getContext()
  {
    return this.j;
  }
  
  @Nullable
  public final Function1<CommunityInfo, Unit> getOnSelectCallback()
  {
    return this.i;
  }
  
  @NotNull
  public final KDCommunityContract.IPresenter getPresenter()
  {
    return this.l;
  }
  
  @NotNull
  public final String getSelectedCommunityId()
  {
    return this.k;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.l.a(this);
    this.l.b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.l.a();
  }
  
  public final void setOnSelectCallback(@Nullable Function1<? super CommunityInfo, Unit> paramFunction1)
  {
    this.i = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView
 * JD-Core Version:    0.7.0.1
 */