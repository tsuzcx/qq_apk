package com.tencent.tkd.weibo.tweetTopic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.tkd.weibo.R.drawable;
import com.tencent.tkd.weibo.R.id;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.framework.BasePopupView;
import com.tencent.tkd.weibo.framework.mvp.BaseListView;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView;
import com.tencent.tkd.weibo.tweetTopic.recentTopic.RecentTopicLayout;
import com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel;
import com.tencent.tkd.weibo.utils.DisplayUtils;
import com.tencent.tkd.weibo.utils.DrawableClickHelper.OnDrawableListener;
import com.tencent.tkd.weibo.utils.DrawableClickHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView;", "Lcom/tencent/tkd/weibo/framework/BasePopupView;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Landroid/view/View$OnClickListener;", "parentView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/ViewGroup;Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelView", "Landroid/widget/TextView;", "contentContainer", "Landroid/widget/RelativeLayout;", "hotTopicListView", "Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView;", "isSoftInputShowing", "", "recentTopicContainer", "Landroid/widget/LinearLayout;", "recentTopicLayout", "Lcom/tencent/tkd/weibo/tweetTopic/recentTopic/RecentTopicLayout;", "searchResultView", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListView;", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "searchTopicAdapter", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "searchTopicModel", "Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "searchTopicPresenter", "Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView$SearchTopicPresenter;", "searchTopicView", "Landroid/widget/EditText;", "getDrawableLeft", "Landroid/graphics/drawable/Drawable;", "initColor", "", "initSearchResultView", "initSearchTopicView", "initTopicList", "initView", "loadRecentTopic", "onClick", "v", "Landroid/view/View;", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "setTextClearClickListener", "Companion", "SearchTopicPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class TweetTopicView
  extends BasePopupView<EditObject>
  implements View.OnClickListener
{
  public static final TweetTopicView.Companion a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private BaseListView<TweetTopicItem> jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView;
  private TopicListAdapter jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter;
  private TweetTopicView.SearchTopicPresenter jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$SearchTopicPresenter;
  private HotTopicListView jdField_a_of_type_ComTencentTkdWeiboTweetTopicHotTopicHotTopicListView;
  private RecentTopicLayout jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
  private SearchTopicListModel jdField_a_of_type_ComTencentTkdWeiboTweetTopicSearchTopicSearchTopicListModel;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView$Companion = new TweetTopicView.Companion(null);
  }
  
  private final Drawable a()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(R.drawable.g);
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = localDisplayUtils.a(localContext, 11.0F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((Drawable)localObject).setBounds(0, 0, i, localDisplayUtils.a(localContext, 11.0F));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…(context, 11f))\n        }");
    return localObject;
  }
  
  private final void a()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
    }
    DrawableClickHelperKt.a(localEditText, (DrawableClickHelper.OnDrawableListener)new TweetTopicView.setTextClearClickListener.1(this));
  }
  
  public void onClick(@Nullable View paramView)
  {
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = R.id.j;
      if (paramView != null) {
        break label26;
      }
    }
    label26:
    while (paramView.intValue() != i)
    {
      return;
      paramView = null;
      break;
    }
    a(null);
  }
  
  public boolean onKeyDown(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    int i = 0;
    if ((paramInt == 4) || (paramInt == 111))
    {
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
        if (paramInt == 0) {}
      }
      else
      {
        paramKeyEvent = this.jdField_a_of_type_AndroidWidgetEditText;
        if (paramKeyEvent == null) {
          Intrinsics.throwUninitializedPropertyAccessException("searchTopicView");
        }
        paramKeyEvent.setText((CharSequence)"");
      }
      for (;;)
      {
        return true;
        a(null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView
 * JD-Core Version:    0.7.0.1
 */