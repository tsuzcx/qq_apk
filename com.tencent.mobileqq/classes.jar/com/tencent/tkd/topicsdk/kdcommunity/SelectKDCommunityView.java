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
  public static final SelectKDCommunityView.Companion a;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final GridView jdField_a_of_type_AndroidWidgetGridView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final KDCommunityAdapter jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityAdapter;
  @NotNull
  private final KDCommunityContract.IPresenter jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function1<? super CommunityInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private final RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkKdcommunitySelectKDCommunityView$Companion = new SelectKDCommunityView.Companion(null);
  }
  
  public SelectKDCommunityView(@NotNull Activity paramActivity, @NotNull String paramString, @NotNull KDCommunityContract.IPresenter paramIPresenter)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter = paramIPresenter;
    LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(R.layout.L, (ViewGroup)this, true);
    paramActivity = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.contentLayout)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity);
    paramActivity = findViewById(R.id.aM);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.titleView)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity);
    paramActivity = findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.communityGridView)");
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramActivity);
    paramActivity = findViewById(R.id.ai);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.loadingLayout)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity);
    paramActivity = findViewById(R.id.C);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.failedLayout)");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity);
    paramActivity = findViewById(R.id.ay);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.retryView)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramActivity);
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityAdapter = new KDCommunityAdapter((Context)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener((AdapterView.OnItemClickListener)new SelectKDCommunityView.1(this));
  }
  
  @NotNull
  public final KDCommunityContract.IPresenter a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter;
  }
  
  @Nullable
  public final Function1<CommunityInfo, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a(@NotNull List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "communityList");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityAdapter.a(paramList);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)new SelectKDCommunityView.showError.1(this));
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter.a(this);
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter.b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentTkdTopicsdkKdcommunityKDCommunityContract$IPresenter.a();
  }
  
  public final void setOnSelectCallback(@Nullable Function1<? super CommunityInfo, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView
 * JD-Core Version:    0.7.0.1
 */