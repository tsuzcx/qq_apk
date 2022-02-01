package com.tencent.tkd.weibo.tweetTopic;

import android.annotation.SuppressLint;
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
import com.tencent.tkd.topicsdk.mvp.BaseListView;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
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
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView.HotTopicListPresenter;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel;
import com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel;
import com.tencent.tkd.weibo.utils.DrawableClickHelper.OnDrawableListener;
import com.tencent.tkd.weibo.utils.DrawableClickHelperKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView;", "Lcom/tencent/tkd/weibo/framework/BasePopupView;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Landroid/view/View$OnClickListener;", "parentView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/ViewGroup;Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "allowCreateNewTopic", "getAllowCreateNewTopic", "()Z", "setAllowCreateNewTopic", "(Z)V", "cancelView", "Landroid/widget/TextView;", "contentContainer", "Landroid/widget/RelativeLayout;", "countLimit", "", "hotTopicListView", "Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView;", "needShowTopicCoverImg", "getNeedShowTopicCoverImg", "setNeedShowTopicCoverImg", "recentTopicContainer", "Landroid/widget/LinearLayout;", "recentTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/RecentTopicLayout;", "searchResultView", "Lcom/tencent/tkd/topicsdk/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "searchTopicAdapter", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "searchTopicModel", "Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "searchTopicPresenter", "Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView$SearchTopicPresenter;", "searchTopicView", "Landroid/widget/EditText;", "getDrawableLeft", "Landroid/graphics/drawable/Drawable;", "initColor", "", "initSearchResultView", "initSearchTopicView", "initTopicList", "initView", "loadRecentTopic", "onClick", "v", "Landroid/view/View;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "setTextClearClickListener", "Companion", "SearchTopicPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class TweetTopicView
  extends BasePopupView<EditObject>
  implements View.OnClickListener
{
  public static final TweetTopicView.Companion a = new TweetTopicView.Companion(null);
  private boolean c;
  private boolean d;
  private TextView e;
  private RelativeLayout f;
  private EditText g;
  private HotTopicListView h;
  private LinearLayout i;
  private RecentTopicLayout j;
  private BaseListView<TweetTopicItem> k;
  private SearchTopicListModel l;
  private TweetTopicView.SearchTopicPresenter m;
  private TopicListAdapter n;
  private final int o = 12;
  private HashMap p;
  
  public TweetTopicView(@NotNull ViewGroup paramViewGroup, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramViewGroup, paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.e, (ViewGroup)this, true);
    b();
    a();
  }
  
  private final void a()
  {
    DataTransferManager.a.a((Function5)new TweetTopicView.loadRecentTopic.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(Context paramContext)
  {
    Object localObject1 = findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.rl_content_container)");
    this.f = ((RelativeLayout)localObject1);
    localObject1 = paramContext.getResources().getString(R.string.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "hotTopicTitle");
    localObject1 = new HotTopicListView(paramContext, new HotTopicListView.HotTopicListPresenter(new TweetHotTopicListModel((String)localObject1)));
    ((HotTopicListView)localObject1).setNeedShowTopicCoverImg(this.c);
    ((HotTopicListView)localObject1).setItemSelectCallback((Function1)new TweetTopicView.initTopicList..inlined.apply.lambda.1(this));
    this.h = ((HotTopicListView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject2 = this.f;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    }
    HotTopicListView localHotTopicListView = this.h;
    if (localHotTopicListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hotTopicListView");
    }
    ((RelativeLayout)localObject2).addView((View)localHotTopicListView, (ViewGroup.LayoutParams)localObject1);
    this.i = new LinearLayout(paramContext);
    localObject1 = new RecentTopicLayout(paramContext, null);
    ((RecentTopicLayout)localObject1).setStyle(2);
    localObject2 = paramContext.getResources().getString(R.string.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…onent_recent_topic_title)");
    ((RecentTopicLayout)localObject1).setTitle((String)localObject2);
    ((RecentTopicLayout)localObject1).setOnItemClickListener((Function1)new TweetTopicView.initTopicList..inlined.apply.lambda.2(this, paramContext));
    this.j = ((RecentTopicLayout)localObject1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, 24, 0, 36);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicContainer");
    }
    localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)paramContext);
    paramContext = this.h;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hotTopicListView");
    }
    paramContext = paramContext.getListview();
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicContainer");
    }
    paramContext.addHeaderView((View)localObject1, null, false);
    paramContext = this.j;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    paramContext.setVisibility(8);
  }
  
  private final void b()
  {
    Object localObject = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.tv_cancel)");
    this.e = ((TextView)localObject);
    localObject = this.e;
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
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void b(Context paramContext)
  {
    this.l = new SearchTopicListModel(false, 1, null);
    Object localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicModel");
    }
    this.m = new TweetTopicView.SearchTopicPresenter((SearchTopicListModel)localObject);
    this.n = new TopicListAdapter(paramContext);
    localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicAdapter");
    }
    ((TopicListAdapter)localObject).a(true);
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicPresenter");
    }
    paramContext = new TweetTopicView.initSearchResultView.1(this, paramContext, paramContext, (ListPresenter)localObject);
    paramContext.setBackgroundColor(b(UiComponentSdkKt.a().a()));
    paramContext.setItemSelectCallback((Function1)new TweetTopicView.initSearchResultView..inlined.apply.lambda.1(this));
    paramContext.setOnClickListener((View.OnClickListener)TweetTopicView.initSearchResultView.2.2.a);
    this.k = ((BaseListView)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    }
    BaseListView localBaseListView = this.k;
    if (localBaseListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    ((RelativeLayout)localObject).addView((View)localBaseListView, (ViewGroup.LayoutParams)paramContext);
    paramContext = this.k;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    paramContext.setVisibility(8);
  }
  
  private final void c()
  {
    Object localObject = findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.et_search_bar)");
    this.g = ((EditText)localObject);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setBackgroundResource(UiComponentSdkKt.a().f());
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setCompoundDrawables(getDrawableLeft(), null, null, null);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).addTextChangedListener((TextWatcher)new TweetTopicView.initSearchTopicView.1(this));
    localObject = (InputFilter)new InputFilter.LengthFilter(this.o);
    EditText localEditText = this.g;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    localEditText.setFilters(new InputFilter[] { localObject });
    d();
  }
  
  private final void d()
  {
    EditText localEditText = this.g;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    DrawableClickHelperKt.a(localEditText, (DrawableClickHelper.OnDrawableListener)new TweetTopicView.setTextClearClickListener.1(this));
  }
  
  private final void e()
  {
    setBackgroundColor(b(UiComponentSdkKt.a().a()));
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cancelView");
    }
    ((TextView)localObject).setTextColor(b(UiComponentSdkKt.a().b()));
    ((TextView)a(R.id.g)).setTextColor(b(UiComponentSdkKt.a().b()));
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    ((EditText)localObject).setTextColor(b(UiComponentSdkKt.a().b()));
  }
  
  private final Drawable getDrawableLeft()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(R.drawable.d);
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = localDisplayUtils.a(localContext, 11.0F);
    ((Drawable)localObject).setBounds(0, 0, i1, i1);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…margin, margin)\n        }");
    return localObject;
  }
  
  public View a(int paramInt)
  {
    if (this.p == null) {
      this.p = new HashMap();
    }
    View localView2 = (View)this.p.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.p.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final boolean getAllowCreateNewTopic()
  {
    return this.d;
  }
  
  public final boolean getNeedShowTopicCoverImg()
  {
    return this.c;
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    int i1 = R.id.h;
    if (paramView == null) {
      return;
    }
    if (paramView.intValue() == i1) {
      a(null);
    }
  }
  
  public boolean onKeyDown(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    int i1 = 0;
    if ((paramInt != 4) && (paramInt != 111)) {
      return false;
    }
    paramKeyEvent = this.k;
    if (paramKeyEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    }
    if (paramKeyEvent.getVisibility() != 0)
    {
      paramKeyEvent = this.g;
      if (paramKeyEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
      }
      paramKeyEvent = paramKeyEvent.getText();
      Intrinsics.checkExpressionValueIsNotNull(paramKeyEvent, "searchTopicView.text");
      paramInt = i1;
      if (((CharSequence)paramKeyEvent).length() > 0) {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        a(null);
        return true;
      }
    }
    paramKeyEvent = this.g;
    if (paramKeyEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    paramKeyEvent.setText((CharSequence)"");
    return true;
  }
  
  public final void setAllowCreateNewTopic(boolean paramBoolean)
  {
    this.d = paramBoolean;
    Object localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicModel");
    }
    ((SearchTopicListModel)localObject).b(paramBoolean);
    localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicAdapter");
    }
    ((TopicListAdapter)localObject).b(paramBoolean);
  }
  
  public final void setNeedShowTopicCoverImg(boolean paramBoolean)
  {
    this.c = paramBoolean;
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hotTopicListView");
    }
    ((HotTopicListView)localObject).setNeedShowTopicCoverImg(paramBoolean);
    localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicAdapter");
    }
    ((TopicListAdapter)localObject).c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView
 * JD-Core Version:    0.7.0.1
 */