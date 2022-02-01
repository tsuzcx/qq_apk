package com.tencent.tkd.weibo.tweetTopic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.component.R.color;
import com.tencent.tkd.weibo.component.R.drawable;
import com.tencent.tkd.weibo.component.R.layout;
import com.tencent.tkd.weibo.component.R.string;
import com.tencent.tkd.weibo.framework.ImageLoader;
import com.tencent.tkd.weibo.framework.ImageLoader.Companion;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import com.tencent.tkd.weibo.framework.mvp.BaseListAdapter;
import com.tencent.tkd.weibo.utils.FormatUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "needHighLightKeyword", "", "getNeedHighLightKeyword", "()Z", "setNeedHighLightKeyword", "(Z)V", "showCreateOperation", "getShowCreateOperation", "setShowCreateOperation", "bindDivider", "", "currentItem", "holder", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TopicViewHolder;", "bindOperationText", "bindTitleViewHolder", "position", "", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TitleViewHolder;", "bindTopicDiscussText", "bindTopicIcon", "bindTopicName", "bindTopicViewHolder", "getItemViewType", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isNewTweetTopic", "item", "isTitleItem", "Companion", "TitleViewHolder", "TopicViewHolder", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter
  extends BaseListAdapter<TweetTopicItem>
{
  public static final TopicListAdapter.Companion a;
  private final Context jdField_a_of_type_AndroidContentContext;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboTweetTopicTopicListAdapter$Companion = new TopicListAdapter.Companion(null);
  }
  
  public TopicListAdapter(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(int paramInt, TopicListAdapter.TitleViewHolder paramTitleViewHolder)
  {
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)getItem(paramInt);
    paramTitleViewHolder.a().setText((CharSequence)localTweetTopicItem.c());
  }
  
  private final void a(int paramInt, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)getItem(paramInt);
    a(localTweetTopicItem, paramTopicViewHolder);
    b(localTweetTopicItem, paramTopicViewHolder);
    c(localTweetTopicItem, paramTopicViewHolder);
    d(localTweetTopicItem, paramTopicViewHolder);
    e(localTweetTopicItem, paramTopicViewHolder);
  }
  
  private final void a(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    ImageLoader localImageLoader = ImageLoader.Companion.a(ImageLoader.a, this.jdField_a_of_type_AndroidContentContext, null, 2, null).a(48, 48).a().a(6);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(R.drawable.e);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…p_icon_tweet_topic_cover)");
    localImageLoader.a(localDrawable).a(paramTopicViewHolder.a()).a(paramTweetTopicItem.b());
  }
  
  private final boolean a(TweetTopicItem paramTweetTopicItem)
  {
    return Intrinsics.areEqual(paramTweetTopicItem.a(), "title");
  }
  
  private final void b(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    Object localObject = (CharSequence)paramTweetTopicItem.c();
    int j = StringsKt.indexOf$default((CharSequence)localObject, this.jdField_a_of_type_JavaLangString, 0, false, 6, null);
    int i;
    if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (this.jdField_a_of_type_Boolean) && (j != -1))
    {
      paramTweetTopicItem = new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.h));
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).setSpan(paramTweetTopicItem, j, this.jdField_a_of_type_JavaLangString.length() + j, 33);
      paramTopicViewHolder.a().setText((CharSequence)localObject);
    }
    else
    {
      paramTopicViewHolder.a().setText((CharSequence)localObject);
    }
    paramTopicViewHolder.a().setTypeface(Typeface.defaultFromStyle(1));
    paramTopicViewHolder.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(UiComponentSdkKt.a().b()));
  }
  
  private final boolean b(TweetTopicItem paramTweetTopicItem)
  {
    int i;
    if (((CharSequence)paramTweetTopicItem.a()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((CharSequence)paramTweetTopicItem.b()).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  private final void c(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if (paramTweetTopicItem.a() <= 0L)
    {
      paramTopicViewHolder.b().setVisibility(8);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FormatUtils.a.a(paramTweetTopicItem.a()));
    ((StringBuilder)localObject).append('人');
    localObject = ((StringBuilder)localObject).toString();
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.c));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramTweetTopicItem.d());
    paramTweetTopicItem = new SpannableStringBuilder((CharSequence)localStringBuilder.toString());
    paramTweetTopicItem.setSpan(localForegroundColorSpan, 0, ((String)localObject).length(), 33);
    paramTopicViewHolder.b().setVisibility(0);
    paramTopicViewHolder.b().setText((CharSequence)paramTweetTopicItem);
  }
  
  private final void d(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if ((this.b) && (b(paramTweetTopicItem)))
    {
      paramTopicViewHolder.c().setVisibility(0);
      paramTopicViewHolder.c().setText(R.string.a);
      return;
    }
    paramTopicViewHolder.c().setVisibility(8);
  }
  
  private final void e(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if ((this.b) && (b(paramTweetTopicItem)))
    {
      paramTopicViewHolder.a().setVisibility(8);
      return;
    }
    paramTopicViewHolder.a().setVisibility(0);
    paramTopicViewHolder.a().setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(UiComponentSdkKt.a().c()));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)getItem(paramInt);
    if (a(localTweetTopicItem)) {
      return -1;
    }
    if (b(localTweetTopicItem)) {
      return 1;
    }
    return 2;
  }
  
  @SuppressLint({"ViewHolder"})
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == -1)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(R.layout.c, paramViewGroup, false);
      if (paramView != null)
      {
        paramView = (ViewGroup)paramView;
        a(paramInt, new TopicListAdapter.TitleViewHolder(paramView));
        return (View)paramView;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(R.layout.d, paramViewGroup, false);
    if (paramView != null)
    {
      paramView = (ViewGroup)paramView;
      a(paramInt, new TopicListAdapter.TopicViewHolder(paramView));
      return (View)paramView;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */