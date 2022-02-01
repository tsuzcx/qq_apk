package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.widget.RecentTopicLayout;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/ReadInJoyTopicSelectionFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "()V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter;", "mFrom", "", "mSearchBox", "Landroid/view/View;", "observer", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "observer$annotations", "getObserver", "()Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "setObserver", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;)V", "recentTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/RecentTopicLayout;", "doOnCreateView", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "finishWithResult", "topicInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "getContentLayoutId", "initAndShowRecentTopicLayout", "listView", "Lcom/tencent/widget/ListView;", "initSearchBox", "initTitleBar", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onListViewItemClick", "position", "onPause", "onResume", "startSearch", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTopicSelectionFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  public static final ReadInJoyTopicSelectionFragment.Companion a = new ReadInJoyTopicSelectionFragment.Companion(null);
  private View b;
  private ReadInJoyTopicListAdapter c;
  private RecentTopicLayout d;
  private int e;
  @NotNull
  private ReadInJoyObserver f = (ReadInJoyObserver)new ReadInJoyTopicSelectionFragment.observer.1(this);
  
  private final void a(int paramInt, ListView paramListView)
  {
    paramInt -= paramListView.getHeaderViewsCount();
    if (paramInt >= 0)
    {
      paramListView = this.c;
      if (paramListView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
      }
      if (paramInt >= paramListView.getCount()) {
        return;
      }
      paramListView = this.c;
      if (paramListView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
      }
      paramListView = paramListView.a(paramInt);
      if (!Intrinsics.areEqual(paramListView.a(), "description"))
      {
        if (Intrinsics.areEqual(paramListView.a(), "title")) {
          return;
        }
        a(TopicInfoExFunctionKt.a(paramListView));
        paramListView = paramListView.a();
        ReadInJoyUtils.a("0X800980A", this.e, Long.parseLong(paramListView), "0");
        RIJDeliverUGCReportUtil.a(paramListView, "0");
      }
    }
  }
  
  private final void a(LayoutInflater paramLayoutInflater)
  {
    Object localObject = this.t.findViewById(2131446823);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mContentView.findViewById(R.id.tag_search_box)");
    this.b = ((View)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchBox");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    this.c = new ReadInJoyTopicListAdapter((Context)localObject);
    localObject = this.t.findViewById(2131437330);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mContentView.findViewById(R.id.listview)");
    localObject = (ListView)localObject;
    a((ListView)localObject);
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new ReadInJoyTopicSelectionFragment.initViews.1(this, (ListView)localObject));
    ((ListView)localObject).addFooterView(paramLayoutInflater.inflate(2131626344, (ViewGroup)localObject, false));
    paramLayoutInflater = this.c;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("adapter");
    }
    ((ListView)localObject).setAdapter((ListAdapter)paramLayoutInflater);
    ReadInJoyLogicEngine.a().g(null);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", (Parcelable)paramTopicInfo);
    getQBaseActivity().setResult(-1, localIntent);
    onBackEvent();
  }
  
  private final void a(ListView paramListView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    Object localObject1 = this.t;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContentView");
    localObject1 = ((View)localObject1).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContentView.context");
    this.d = new RecentTopicLayout((Context)localObject1, null);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    ((RecentTopicLayout)localObject1).setStyle(2);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    Object localObject2 = getString(2131915484);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "getString(R.string.readinjoy_recent_topic)");
    ((RecentTopicLayout)localObject1).setTitle((String)localObject2);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    ((RecentTopicLayout)localObject1).setOnItemClickListener((Function1)new ReadInJoyTopicSelectionFragment.initAndShowRecentTopicLayout.1(this));
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, 24, 0, 36);
    localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    ((RecentTopicLayout)localObject1).setVisibility(8);
    paramListView.addHeaderView((View)localLinearLayout);
  }
  
  private final void b()
  {
    View localView = this.b;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchBox");
    }
    localView.setVisibility(0);
  }
  
  private final void c()
  {
    this.p.changeBg(true);
    a((CharSequence)getString(2131915419));
    this.h.setText(2131887440);
    Utils.a((QPublicBaseFragment)this);
  }
  
  private final void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.e);
    localIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a((Activity)getQBaseActivity(), localIntent, QPublicTransFragmentActivity.class, ReadInJoyUgcSearchTopicFragment.class, 1000);
  }
  
  protected int a()
  {
    return 2131626343;
  }
  
  protected void a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {
      this.e = paramLayoutInflater.getInt("searchTopicFrom");
    }
    RIJDtReportHelper.a(RIJDtReportHelper.a, (Activity)getQBaseActivity(), null, 2, null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "data.getParcelableExtra(EXTRA_SELECTED_TOPIC)");
      a((TopicInfo)paramIntent);
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (paramView.getId() != 2131446823) {
      return;
    }
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchBox");
    }
    paramView.setVisibility(8);
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.f);
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    b();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyTopicSelectionFragment
 * JD-Core Version:    0.7.0.1
 */