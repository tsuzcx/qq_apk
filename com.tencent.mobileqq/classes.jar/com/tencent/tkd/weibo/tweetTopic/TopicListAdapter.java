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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.FormatUtils;
import com.tencent.tkd.topicsdk.mvp.BaseListAdapter;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.component.R.color;
import com.tencent.tkd.weibo.component.R.drawable;
import com.tencent.tkd.weibo.component.R.layout;
import com.tencent.tkd.weibo.component.R.string;
import com.tencent.tkd.weibo.framework.ImageLoader;
import com.tencent.tkd.weibo.framework.ImageLoader.Companion;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "needHighLightKeyword", "", "getNeedHighLightKeyword", "()Z", "setNeedHighLightKeyword", "(Z)V", "showCreateOperation", "getShowCreateOperation", "setShowCreateOperation", "showTopicCoverImage", "getShowTopicCoverImage", "setShowTopicCoverImage", "bindDivider", "", "currentItem", "holder", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TopicViewHolder;", "bindOperationText", "bindTitleViewHolder", "position", "", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TitleViewHolder;", "bindTopicDiscussText", "bindTopicIcon", "bindTopicName", "bindTopicViewHolder", "getItemViewType", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isDescItem", "item", "isNewTweetTopic", "isTitleItem", "Companion", "TitleViewHolder", "TopicViewHolder", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter
  extends BaseListAdapter<TweetTopicItem>
{
  public static final TopicListAdapter.Companion b = new TopicListAdapter.Companion(null);
  @NotNull
  private String c;
  private boolean d;
  private boolean e;
  private boolean f;
  private final Context g;
  
  public TopicListAdapter(@NotNull Context paramContext)
  {
    this.g = paramContext;
    this.c = "";
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
    if (!this.f)
    {
      paramTopicViewHolder.a().setVisibility(8);
      return;
    }
    paramTopicViewHolder.a().setVisibility(0);
    ImageLoader localImageLoader = ImageLoader.Companion.a(ImageLoader.a, this.g, null, 2, null).a(48, 48).a().a(6);
    Drawable localDrawable = this.g.getResources().getDrawable(R.drawable.e);
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
    int j = StringsKt.indexOf$default((CharSequence)localObject, this.c, 0, false, 6, null);
    int i;
    if (((CharSequence)this.c).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (this.d) && (j != -1))
    {
      paramTweetTopicItem = new ForegroundColorSpan(this.g.getResources().getColor(R.color.g));
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).setSpan(paramTweetTopicItem, j, this.c.length() + j, 33);
      paramTopicViewHolder.b().setText((CharSequence)localObject);
    }
    else
    {
      paramTopicViewHolder.b().setText((CharSequence)localObject);
    }
    paramTopicViewHolder.b().setTypeface(Typeface.defaultFromStyle(1));
    paramTopicViewHolder.b().setTextColor(this.g.getResources().getColor(UiComponentSdkKt.a().b()));
  }
  
  private final boolean b(TweetTopicItem paramTweetTopicItem)
  {
    return Intrinsics.areEqual(paramTweetTopicItem.a(), "description");
  }
  
  private final void c(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if (paramTweetTopicItem.d() < 0L)
    {
      paramTopicViewHolder.c().setVisibility(8);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FormatUtils.a.a(paramTweetTopicItem.d()));
      ((StringBuilder)localObject).append(paramTweetTopicItem.e());
      localObject = ((StringBuilder)localObject).toString();
      paramTopicViewHolder.c().setVisibility(0);
      paramTopicViewHolder.c().setText((CharSequence)localObject);
    }
    if (paramTweetTopicItem.f() < 0L)
    {
      paramTopicViewHolder.f().setVisibility(8);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FormatUtils.a.a(paramTweetTopicItem.f()));
    ((StringBuilder)localObject).append(paramTweetTopicItem.g());
    paramTweetTopicItem = ((StringBuilder)localObject).toString();
    paramTopicViewHolder.f().setVisibility(0);
    paramTopicViewHolder.f().setText((CharSequence)paramTweetTopicItem);
  }
  
  private final boolean c(TweetTopicItem paramTweetTopicItem)
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
  
  private final void d(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if ((this.e) && (c(paramTweetTopicItem)))
    {
      paramTopicViewHolder.e().setVisibility(0);
      paramTopicViewHolder.e().setText(R.string.a);
      paramTopicViewHolder.f().setVisibility(8);
      paramTopicViewHolder.b().setTextColor(this.g.getResources().getColor(R.color.g));
      paramTopicViewHolder.c().setVisibility(8);
      return;
    }
    paramTopicViewHolder.e().setVisibility(8);
  }
  
  private final void e(TweetTopicItem paramTweetTopicItem, TopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    if ((this.e) && (c(paramTweetTopicItem)))
    {
      paramTopicViewHolder.d().setVisibility(8);
      return;
    }
    paramTopicViewHolder.d().setVisibility(0);
    paramTopicViewHolder.d().setBackgroundColor(this.g.getResources().getColor(UiComponentSdkKt.a().c()));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)getItem(paramInt);
    if (a(localTweetTopicItem)) {
      return -1;
    }
    if (b(localTweetTopicItem)) {
      return -2;
    }
    if (c(localTweetTopicItem)) {
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
      paramView = LayoutInflater.from(this.g).inflate(R.layout.c, paramViewGroup, false);
      if (paramView != null)
      {
        paramView = (ViewGroup)paramView;
        a(paramInt, new TopicListAdapter.TitleViewHolder(paramView));
        return (View)paramView;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    if (getItemViewType(paramInt) == -2)
    {
      paramView = LayoutInflater.from(this.g).inflate(R.layout.b, paramViewGroup, false);
      if (paramView != null)
      {
        paramView = (ViewGroup)paramView;
        a(paramInt, new TopicListAdapter.TitleViewHolder(paramView));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    else
    {
      paramView = LayoutInflater.from(this.g).inflate(R.layout.d, paramViewGroup, false);
      if (paramView == null) {
        break label168;
      }
      paramView = (ViewGroup)paramView;
      a(paramInt, new TopicListAdapter.TopicViewHolder(paramView));
    }
    return (View)paramView;
    label168:
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */