package com.tencent.tkd.weibo.tweetTopic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.Companion;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.widget.RecentTopicLayout;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.component.R.drawable;
import com.tencent.tkd.weibo.component.R.id;
import com.tencent.tkd.weibo.component.R.layout;
import com.tencent.tkd.weibo.component.R.string;
import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.BasePopupView;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import com.tencent.tkd.weibo.framework.mvp.BaseListView;
import com.tencent.tkd.weibo.framework.mvp.ListPresenter;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView.HotTopicListPresenter;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel;
import com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel;
import com.tencent.tkd.weibo.utils.DrawableClickHelper.OnDrawableListener;
import com.tencent.tkd.weibo.utils.DrawableClickHelperKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView;", "Lcom/tencent/tkd/weibo/framework/BasePopupView;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Landroid/view/View$OnClickListener;", "parentView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/ViewGroup;Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "allowCreateNewTopic", "getAllowCreateNewTopic", "()Z", "setAllowCreateNewTopic", "(Z)V", "cancelView", "Landroid/widget/TextView;", "contentContainer", "Landroid/widget/RelativeLayout;", "countLimit", "", "hotTopicListView", "Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView;", "isSoftInputShowing", "recentTopicContainer", "Landroid/widget/LinearLayout;", "recentTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/RecentTopicLayout;", "searchResultView", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "searchTopicAdapter", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "searchTopicModel", "Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "searchTopicPresenter", "Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView$SearchTopicPresenter;", "searchTopicView", "Landroid/widget/EditText;", "getDrawableLeft", "Landroid/graphics/drawable/Drawable;", "initColor", "", "initSearchResultView", "initSearchTopicView", "initTopicList", "initView", "loadRecentTopic", "onClick", "v", "Landroid/view/View;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "setTextClearClickListener", "Companion", "SearchTopicPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class TweetTopicView
  extends BasePopupView<EditObject>
  implements View.OnClickListener
{
  public static final TweetTopicView.Companion a;
  private final int jdField_a_of_type_Int = 12;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecentTopicLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetRecentTopicLayout;
  private BaseListView<TweetTopicItem> jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView;
  private TopicListAdapter jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter;
  private TweetTopicView.SearchTopicPresenter jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$SearchTopicPresenter;
  private HotTopicListView jdField_a_of_type_ComTencentTkdWeiboTweetTopicHotTopicHotTopicListView;
  private SearchTopicListModel jdField_a_of_type_ComTencentTkdWeiboTweetTopicSearchTopicSearchTopicListModel;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$Companion = new TweetTopicView.Companion(null);
  }
  
  public TweetTopicView(@NotNull ViewGroup paramViewGroup, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramViewGroup, paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.f, (ViewGroup)this, true);
    b();
    a();
  }
  
  private final Drawable a()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(R.drawable.d);
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = localDisplayUtils.a(localContext, 11.0F);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…margin, margin)\n        }");
    return localObject;
  }
  
  private final void a()
  {
    DataTransferManager.a.a((Function5)new TweetTopicView.loadRecentTopic.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(Context paramContext)
  {
    Object localObject1 = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.rl_content_container)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    localObject1 = paramContext.getResources().getString(R.string.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "hotTopicTitle");
    localObject1 = new HotTopicListView(paramContext, new HotTopicListView.HotTopicListPresenter(new TweetHotTopicListModel((String)localObject1)));
    ((HotTopicListView)localObject1).setItemSelectCallback((Function1)new TweetTopicView.initTopicList..inlined.apply.lambda.1(this, paramContext));
    ((HotTopicListView)localObject1).setOnTouchScrollListener((Function0)new TweetTopicView.initTopicList..inlined.apply.lambda.2(this, paramContext));
    this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicHotTopicHotTopicListView = ((HotTopicListView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    }
    HotTopicListView localHotTopicListView = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicHotTopicHotTopicListView;
    if (localHotTopicListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hotTopicListView");
    }
    ((RelativeLayout)localObject2).addView((View)localHotTopicListView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    localObject1 = new RecentTopicLayout(paramContext, null);
    ((RecentTopicLayout)localObject1).setStyle(2);
    localObject2 = paramContext.getResources().getString(R.string.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…onent_recent_topic_title)");
    ((RecentTopicLayout)localObject1).setTitle((String)localObject2);
    ((RecentTopicLayout)localObject1).setOnItemClickListener((Function1)new TweetTopicView.initTopicList..inlined.apply.lambda.3(this, paramContext));
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRecentTopicLayout = ((RecentTopicLayout)localObject1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, 24, 0, 36);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicContainer");
    }
    localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRecentTopicLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicHotTopicHotTopicListView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hotTopicListView");
    }
    paramContext = (ListView)paramContext.a(R.id.g);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicContainer");
    }
    paramContext.addHeaderView((View)localObject1, null, false);
    paramContext = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRecentTopicLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    paramContext.setVisibility(8);
  }
  
  private final void b()
  {
    Object localObject = findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.tv_cancel)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cancelView");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    c();
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    b((Context)localObject);
    e();
    localObject = KeyBoardChangeListener.a;
    Context localContext = getContext();
    if (localContext != null)
    {
      ((KeyBoardChangeListener.Companion)localObject).a((Activity)localContext).a((KeyBoardChangeListener.KeyboardListener)new TweetTopicView.initView..inlined.apply.lambda.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicSearchTopicSearchTopicListModel = new SearchTopicListModel(false, 1, null);
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicSearchTopicSearchTopicListModel;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicModel");
    }
    this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$SearchTopicPresenter = new TweetTopicView.SearchTopicPresenter((SearchTopicListModel)localObject);
    this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter = new TopicListAdapter(paramContext);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicAdapter");
    }
    ((TopicListAdapter)localObject).a(true);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$SearchTopicPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicPresenter");
    }
    localObject = new TweetTopicView.initSearchResultView.1(this, paramContext, paramContext, (ListPresenter)localObject);
    ((TweetTopicView.initSearchResultView.1)localObject).setBackgroundColor(a(UiComponentSdkKt.a().a()));
    ((TweetTopicView.initSearchResultView.1)localObject).setItemSelectCallback((Function1)new TweetTopicView.initSearchResultView..inlined.apply.lambda.1(this, paramContext));
    ((TweetTopicView.initSearchResultView.1)localObject).setOnClickListener((View.OnClickListener)TweetTopicView.initSearchResultView.2.2.a);
    ((TweetTopicView.initSearchResultView.1)localObject).setOnTouchScrollListener((Function0)new TweetTopicView.initSearchResultView..inlined.apply.lambda.2(this, paramContext));
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView = ((BaseListView)localObject);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    }
    BaseListView localBaseListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView;
    if (localBaseListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    ((RelativeLayout)localObject).addView((View)localBaseListView, (ViewGroup.LayoutParams)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    paramContext.setVisibility(8);
  }
  
  private final void c()
  {
    Object localObject = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.et_search_bar)");
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setBackgroundResource(UiComponentSdkKt.a().f());
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setCompoundDrawables(a(), null, null, null);
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).addTextChangedListener((TextWatcher)new TweetTopicView.initSearchTopicView.1(this));
    localObject = (InputFilter)new InputFilter.LengthFilter(this.jdField_a_of_type_Int);
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    localEditText.setFilters(new InputFilter[] { localObject });
    d();
  }
  
  private final void d()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    DrawableClickHelperKt.a(localEditText, (DrawableClickHelper.OnDrawableListener)new TweetTopicView.setTextClearClickListener.1(this));
  }
  
  private final void e()
  {
    setBackgroundColor(a(UiComponentSdkKt.a().a()));
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cancelView");
    }
    ((TextView)localObject).setTextColor(a(UiComponentSdkKt.a().b()));
    ((TextView)a(R.id.k)).setTextColor(a(UiComponentSdkKt.a().b()));
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setTextColor(a(UiComponentSdkKt.a().b()));
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    int i = R.id.l;
    if (paramView == null) {
      return;
    }
    if (paramView.intValue() == i) {
      a(null);
    }
  }
  
  public boolean onKeyDown(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    int i = 0;
    if ((paramInt != 4) && (paramInt != 111)) {
      return false;
    }
    paramKeyEvent = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView;
    if (paramKeyEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    if (paramKeyEvent.getVisibility() != 0)
    {
      paramKeyEvent = this.jdField_a_of_type_AndroidWidgetEditText;
      if (paramKeyEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
      }
      paramKeyEvent = paramKeyEvent.getText();
      Intrinsics.checkExpressionValueIsNotNull(paramKeyEvent, "searchTopicView.text");
      paramInt = i;
      if (((CharSequence)paramKeyEvent).length() > 0) {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        a(null);
        return true;
      }
    }
    paramKeyEvent = this.jdField_a_of_type_AndroidWidgetEditText;
    if (paramKeyEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    paramKeyEvent.setText((CharSequence)"");
    return true;
  }
  
  public final void setAllowCreateNewTopic(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicSearchTopicSearchTopicListModel;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicModel");
    }
    ((SearchTopicListModel)localObject).b(paramBoolean);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicAdapter");
    }
    ((TopicListAdapter)localObject).b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView
 * JD-Core Version:    0.7.0.1
 */