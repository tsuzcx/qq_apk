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
import com.tencent.tkd.weibo.R.color;
import com.tencent.tkd.weibo.R.drawable;
import com.tencent.tkd.weibo.R.layout;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "needHighLightKeyword", "", "getNeedHighLightKeyword", "()Z", "setNeedHighLightKeyword", "(Z)V", "bindDivider", "", "holder", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$ViewHolder;", "bindTopicDiscussText", "currentItem", "bindTopicIcon", "bindTopicName", "bindTopicViewHolder", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter
  extends BaseListAdapter<TweetTopicItem>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private final void a(int paramInt, TopicListAdapter.ViewHolder paramViewHolder)
  {
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)getItem(paramInt);
    a(localTweetTopicItem, paramViewHolder);
    b(localTweetTopicItem, paramViewHolder);
    c(localTweetTopicItem, paramViewHolder);
    a(paramViewHolder);
  }
  
  private final void a(TweetTopicItem paramTweetTopicItem, TopicListAdapter.ViewHolder paramViewHolder)
  {
    ImageLoader localImageLoader = ImageLoader.Companion.a(ImageLoader.a, this.jdField_a_of_type_AndroidContentContext, null, 2, null).a(48, 48).a().a(6);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(R.drawable.f);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_topic_error)");
    localImageLoader.a(localDrawable).a(paramViewHolder.a()).a(paramTweetTopicItem.b());
  }
  
  private final void a(TopicListAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.a().setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(UiComponentSdkKt.a().b()));
  }
  
  private final void b(TweetTopicItem paramTweetTopicItem, TopicListAdapter.ViewHolder paramViewHolder)
  {
    int i = 0;
    Object localObject = paramTweetTopicItem.c();
    int j = StringsKt.indexOf$default((CharSequence)localObject, this.jdField_a_of_type_JavaLangString, 0, false, 6, null);
    if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() == 0) {
      i = 1;
    }
    if ((i != 0) || (!this.jdField_a_of_type_Boolean) || (j == -1)) {
      paramViewHolder.a().setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramViewHolder.a().setTypeface(Typeface.defaultFromStyle(1));
      paramViewHolder.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(UiComponentSdkKt.a().a()));
      return;
      paramTweetTopicItem = new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.h));
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).setSpan(paramTweetTopicItem, j, this.jdField_a_of_type_JavaLangString.length() + j, 33);
      paramViewHolder.a().setText((CharSequence)localObject);
    }
  }
  
  private final void c(TweetTopicItem paramTweetTopicItem, TopicListAdapter.ViewHolder paramViewHolder)
  {
    if (paramTweetTopicItem.a() <= 0L)
    {
      paramViewHolder.b().setVisibility(8);
      return;
    }
    String str = FormatUtils.a.a(paramTweetTopicItem.a()) + '人';
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.c));
    paramTweetTopicItem = new SpannableStringBuilder((CharSequence)(str + paramTweetTopicItem.d()));
    paramTweetTopicItem.setSpan(localForegroundColorSpan, 0, str.length(), 33);
    paramViewHolder.b().setVisibility(0);
    paramViewHolder.b().setText((CharSequence)paramTweetTopicItem);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @SuppressLint({"ViewHolder"})
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(R.layout.d, paramViewGroup, false);
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    paramView = (ViewGroup)paramView;
    a(paramInt, new TopicListAdapter.ViewHolder(paramView));
    return (View)paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */