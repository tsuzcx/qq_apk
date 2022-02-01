package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.FormatUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyword", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "bindTopicName", "", "currentItem", "holder", "Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter$TopicViewHolder;", "buildContentView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "position", "", "buildTitleView", "resId", "getCount", "getItem", "getItemId", "", "getItemViewType", "getView", "getViewTypeCount", "updateTopicList", "list", "", "inputString", "Companion", "TitleViewHolder", "TopicViewHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTopicListAdapter
  extends BaseAdapter
{
  public static final ReadInJoyTopicListAdapter.Companion a = new ReadInJoyTopicListAdapter.Companion(null);
  private String b;
  private final List<TweetTopicItem> c;
  private final Context d;
  
  public ReadInJoyTopicListAdapter(@NotNull Context paramContext)
  {
    this.d = paramContext;
    this.b = "";
    this.c = ((List)new ArrayList());
  }
  
  private final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (paramViewGroup != null) {
        paramViewGroup = (ReadInJoyTopicListAdapter.TopicViewHolder)paramViewGroup;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter.TopicViewHolder");
      }
    }
    else
    {
      paramView = LayoutInflater.from(this.d).inflate(2131626352, paramViewGroup, false);
      if (paramView == null) {
        break label209;
      }
      paramView = (View)paramView;
      localObject1 = (ViewGroup)paramView;
      paramViewGroup = new ReadInJoyTopicListAdapter.TopicViewHolder((ViewGroup)localObject1);
      ((ViewGroup)localObject1).setTag(paramViewGroup);
    }
    Object localObject1 = a(paramInt);
    a(a(paramInt), paramViewGroup);
    Object localObject2 = paramViewGroup.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FormatUtils.a.a(((TweetTopicItem)localObject1).d()));
    localStringBuilder.append(((TweetTopicItem)localObject1).e());
    ((TextView)localObject2).setText((CharSequence)localStringBuilder.toString());
    paramViewGroup = paramViewGroup.c();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FormatUtils.a.a(((TweetTopicItem)localObject1).f()));
    ((StringBuilder)localObject2).append(((TweetTopicItem)localObject1).g());
    paramViewGroup.setText((CharSequence)((StringBuilder)localObject2).toString());
    return paramView;
    label209:
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final View a(View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (paramViewGroup != null) {
        paramViewGroup = (ReadInJoyTopicListAdapter.TitleViewHolder)paramViewGroup;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter.TitleViewHolder");
      }
    }
    else
    {
      paramView = LayoutInflater.from(this.d).inflate(paramInt2, paramViewGroup, false);
      if (paramView == null) {
        break label100;
      }
      paramView = (View)paramView;
      ViewGroup localViewGroup = (ViewGroup)paramView;
      paramViewGroup = new ReadInJoyTopicListAdapter.TitleViewHolder(localViewGroup);
      localViewGroup.setTag(paramViewGroup);
    }
    paramViewGroup.a().setText((CharSequence)a(paramInt1).c());
    return paramView;
    label100:
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void a(TweetTopicItem paramTweetTopicItem, ReadInJoyTopicListAdapter.TopicViewHolder paramTopicViewHolder)
  {
    Object localObject = (CharSequence)paramTweetTopicItem.c();
    int j = StringsKt.indexOf$default((CharSequence)localObject, this.b, 0, false, 6, null);
    int i;
    if (((CharSequence)this.b).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (j != -1))
    {
      paramTweetTopicItem = new ForegroundColorSpan(this.d.getResources().getColor(2097348639));
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).setSpan(paramTweetTopicItem, j, this.b.length() + j, 33);
      paramTopicViewHolder.a().setText((CharSequence)localObject);
    }
    else
    {
      paramTopicViewHolder.a().setText((CharSequence)localObject);
    }
    paramTopicViewHolder.a().setTypeface(Typeface.defaultFromStyle(1));
  }
  
  @NotNull
  public TweetTopicItem a(int paramInt)
  {
    return (TweetTopicItem)this.c.get(paramInt);
  }
  
  public final void a(@NotNull List<TweetTopicItem> paramList, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Intrinsics.checkParameterIsNotNull(paramString, "inputString");
    this.b = paramString;
    this.c.clear();
    this.c.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    String str = ((TweetTopicItem)this.c.get(paramInt)).a();
    paramInt = str.hashCode();
    if (paramInt != -1724546052)
    {
      if ((paramInt == 110371416) && (str.equals("title"))) {
        return -1;
      }
    }
    else if (str.equals("description")) {
      return -2;
    }
    return 2;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i != -2)
    {
      if (i != -1) {
        return a(paramView, paramViewGroup, paramInt);
      }
      return a(paramView, paramViewGroup, paramInt, 2097610780);
    }
    return a(paramView, paramViewGroup, paramInt, 2097610779);
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter
 * JD-Core Version:    0.7.0.1
 */