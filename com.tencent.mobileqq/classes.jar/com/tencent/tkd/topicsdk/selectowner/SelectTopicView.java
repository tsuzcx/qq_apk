package com.tencent.tkd.topicsdk.selectowner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListView;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView;", "Lcom/tencent/tkd/topicsdk/selectowner/BaseSelectView;", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$MyTopicViewHolder;", "context", "Landroid/app/Activity;", "selectedTopicId", "", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "(Landroid/app/Activity;JLcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getContext", "()Landroid/app/Activity;", "createTopicListener", "Lkotlin/Function2;", "", "", "mTopicAdapter", "com/tencent/tkd/topicsdk/selectowner/SelectTopicView$mTopicAdapter$1", "Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$mTopicAdapter$1;", "selectTip", "", "getSelectTip", "()Ljava/lang/String;", "getSelectedTopicId", "()J", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class SelectTopicView
  extends BaseSelectView<TopicInfo, SelectTopicView.MyTopicViewHolder>
{
  public static final SelectTopicView.Companion a = new SelectTopicView.Companion(null);
  private final SelectTopicView.mTopicAdapter.1 b;
  private final Function2<Integer, TopicInfo, Unit> c;
  @NotNull
  private final Activity d;
  private final long e;
  private HashMap f;
  
  public SelectTopicView(@NotNull Activity paramActivity, long paramLong, @NotNull ListPresenter<TopicInfo, ListContract.IListView<TopicInfo>> paramListPresenter)
  {
    super(paramActivity, paramListPresenter);
    this.d = paramActivity;
    this.e = paramLong;
    this.b = new SelectTopicView.mTopicAdapter.1(this, (Context)this.d);
    this.c = ((Function2)new SelectTopicView.createTopicListener.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    View localView2 = (View)this.f.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.f.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public CommonListAdapter<TopicInfo, SelectTopicView.MyTopicViewHolder> getAdapter()
  {
    return (CommonListAdapter)this.b;
  }
  
  @NotNull
  public final Activity getContext()
  {
    return this.d;
  }
  
  @NotNull
  public String getSelectTip()
  {
    String str = this.d.getResources().getString(R.string.K);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ing.publish_to_topic_tip)");
    return str;
  }
  
  public final long getSelectedTopicId()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TopicEventDispatcher.a.a(this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TopicEventDispatcher.a.b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */