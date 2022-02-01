package com.tencent.mobileqq.kandian.biz.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/ReadInJoyUgcSearchTopicFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "mEmptyViewWithWording", "Landroid/view/View;", "mFrom", "", "mListView", "Landroid/widget/ListView;", "mListViewWrapper", "mObserver", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "mPendingSearchKeyword", "", "mSearchEditText", "Landroid/widget/EditText;", "mSearchResultAdapter", "Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter;", "mSearchTextWatcher", "Landroid/text/TextWatcher;", "finishWithResult", "", "topicInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "hideKeyboard", "initCancelButton", "root", "initListView", "initRootView", "view", "initSearchBox", "initWindowStyleAndAnimation", "activity", "Landroid/app/Activity;", "isWrapContent", "", "onClearSearchBox", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onFinish", "onItemClick", "parent", "Landroid/widget/AdapterView;", "position", "id", "", "onResume", "onSearchResultRetrieved", "topicInfoList", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyUgcSearchTopicFragment
  extends QPublicBaseFragment
  implements AdapterView.OnItemClickListener
{
  public static final ReadInJoyUgcSearchTopicFragment.Companion a = new ReadInJoyUgcSearchTopicFragment.Companion(null);
  private ListView b;
  private View c;
  private EditText d;
  private View e;
  private ReadInJoyTopicListAdapter f;
  private int g;
  private String h = "";
  private final ReadInJoyObserver i = (ReadInJoyObserver)new ReadInJoyUgcSearchTopicFragment.mObserver.1(this);
  private final TextWatcher j = (TextWatcher)new ReadInJoyUgcSearchTopicFragment.mSearchTextWatcher.1(this);
  
  private final void a()
  {
    Object localObject = getQBaseActivity().getSystemService("input_method");
    if (localObject != null)
    {
      localObject = (InputMethodManager)localObject;
      ListView localListView = this.b;
      if (localListView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
      }
      ((InputMethodManager)localObject).hideSoftInputFromWindow(localListView.getWindowToken(), 0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
  }
  
  private final void a(View paramView)
  {
    paramView.setOnClickListener((View.OnClickListener)new ReadInJoyUgcSearchTopicFragment.initRootView.1(this));
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", (Parcelable)paramTopicInfo);
    getQBaseActivity().setResult(-1, localIntent);
    getQBaseActivity().finish();
    getQBaseActivity().overridePendingTransition(0, 0);
  }
  
  private final void a(List<TopicInfo> paramList)
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListViewWrapper");
    }
    ((View)localObject).setVisibility(0);
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
      }
      ((ListView)localObject).setVisibility(0);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyViewWithWording");
      }
      ((View)localObject).setVisibility(4);
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
      }
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      ((ReadInJoyTopicListAdapter)localObject).a(TopicInfoExFunctionKt.a(paramList, (Context)localQBaseActivity), this.h);
      ReadInJoyUtils.a(this.g, paramList, "0");
      return;
    }
    paramList = this.e;
    if (paramList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mEmptyViewWithWording");
    }
    paramList.setVisibility(0);
    paramList = this.b;
    if (paramList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramList.setVisibility(4);
  }
  
  private final void b()
  {
    EditText localEditText = this.d;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
    }
    localEditText.setText((CharSequence)"");
  }
  
  private final void b(View paramView)
  {
    paramView.findViewById(2131430135).setOnClickListener((View.OnClickListener)new ReadInJoyUgcSearchTopicFragment.initCancelButton.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void c(View paramView)
  {
    Object localObject = paramView.findViewById(2131437339);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root.findViewById(R.id.listview_search_result)");
    this.b = ((ListView)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    ((ListView)localObject).getLayoutParams().height = -1;
    localObject = paramView.findViewById(2131437319);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root.findViewById(R.id.list_view_wrapper)");
    this.c = ((View)localObject);
    paramView = paramView.findViewById(2131432530);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.empty_view)");
    this.e = paramView;
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramView.setOnItemClickListener((AdapterView.OnItemClickListener)this);
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramView.setOnTouchListener((View.OnTouchListener)new ReadInJoyUgcSearchTopicFragment.initListView.1(this));
    paramView = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "qBaseActivity");
    this.f = new ReadInJoyTopicListAdapter((Context)paramView);
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    localObject = LayoutInflater.from((Context)getQBaseActivity());
    ListView localListView = this.b;
    if (localListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramView.addFooterView(((LayoutInflater)localObject).inflate(2131626344, (ViewGroup)localListView, false), null, false);
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramView.setDivider((Drawable)null);
    paramView = this.b;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    }
    paramView.setAdapter((ListAdapter)localObject);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void d(View paramView)
  {
    paramView = paramView.findViewById(2131446823);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.tag_search_box)");
    this.d = ((EditText)paramView);
    paramView = this.d;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
    }
    paramView.setHint(2131915500);
    paramView = this.d;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
    }
    paramView.setOnTouchListener((View.OnTouchListener)new ReadInJoyUgcSearchTopicFragment.initSearchBox.1(this));
    paramView = this.d;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
    }
    paramView.addTextChangedListener(this.j);
    paramView = this.d;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
    }
    paramView.requestFocus();
  }
  
  public void initWindowStyleAndAnimation(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    paramActivity.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772090, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.i);
    paramLayoutInflater = paramLayoutInflater.inflate(2131626350, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view");
    d(paramLayoutInflater);
    c(paramLayoutInflater);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.g = paramViewGroup.getInt("searchTopicFrom");
    }
    RIJDtReportHelper.a(RIJDtReportHelper.a, (Activity)getQBaseActivity(), null, 2, null);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.i);
    super.onDestroyView();
  }
  
  public void onFinish()
  {
    getQBaseActivity().overridePendingTransition(0, 2130772093);
    super.onFinish();
  }
  
  public void onItemClick(@Nullable AdapterView<?> paramAdapterView, @NotNull View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramAdapterView = this.b;
    if (paramAdapterView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mListView");
    }
    paramInt -= paramAdapterView.getHeaderViewsCount();
    if (paramInt >= 0)
    {
      paramAdapterView = this.f;
      if (paramAdapterView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
      }
      if (paramInt >= paramAdapterView.getCount()) {
        return;
      }
      paramAdapterView = this.f;
      if (paramAdapterView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
      }
      paramAdapterView = paramAdapterView.a(paramInt);
      if (!Intrinsics.areEqual(paramAdapterView.a(), "description"))
      {
        if (Intrinsics.areEqual(paramAdapterView.a(), "title")) {
          return;
        }
        a(TopicInfoExFunctionKt.a(paramAdapterView));
        ReadInJoyUtils.a("0X800980A", this.g, Long.parseLong(paramAdapterView.a()), "0");
        RIJDeliverUGCReportUtil.a(paramAdapterView.a(), "1");
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a((QPublicBaseFragment)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment
 * JD-Core Version:    0.7.0.1
 */