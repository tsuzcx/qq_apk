package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.mvp.BaseListAdapter;
import com.tencent.tkd.topicsdk.mvp.BaseListView;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.weibo.component.R.string;
import com.tencent.tkd.weibo.tweetTopic.TopicListAdapter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView;", "Lcom/tencent/tkd/topicsdk/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView$HotTopicListPresenter;", "(Landroid/content/Context;Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView$HotTopicListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "mAdapter", "Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter;", "value", "", "needShowTopicCoverImg", "getNeedShowTopicCoverImg", "()Z", "setNeedShowTopicCoverImg", "(Z)V", "getEmptyText", "", "HotTopicListPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class HotTopicListView
  extends BaseListView<TweetTopicItem>
{
  private boolean a;
  private final TopicListAdapter b;
  private HashMap c;
  
  public HotTopicListView(@NotNull Context paramContext, @NotNull HotTopicListView.HotTopicListPresenter paramHotTopicListPresenter)
  {
    super(paramContext, (ListPresenter)paramHotTopicListPresenter);
    this.b = new TopicListAdapter(paramContext);
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public BaseListAdapter<TweetTopicItem> getAdapter()
  {
    return (BaseListAdapter)this.b;
  }
  
  @NotNull
  public String getEmptyText()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getString(R.string.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…ent_hot_topic_empty_tips)");
    return localObject;
  }
  
  public final boolean getNeedShowTopicCoverImg()
  {
    return this.a;
  }
  
  public final void setNeedShowTopicCoverImg(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView
 * JD-Core Version:    0.7.0.1
 */