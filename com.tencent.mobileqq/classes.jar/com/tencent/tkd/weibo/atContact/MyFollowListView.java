package com.tencent.tkd.weibo.atContact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.topicsdk.mvp.BaseListView;
import com.tencent.tkd.weibo.component.R.string;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/MyFollowListView;", "Lcom/tencent/tkd/topicsdk/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/tkd/weibo/atContact/MyFollowListView$MyFollowListPresenter;", "(Landroid/content/Context;Lcom/tencent/tkd/weibo/atContact/MyFollowListView$MyFollowListPresenter;)V", "adapter", "Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter;", "mAdapter", "getEmptyText", "", "MyFollowListPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class MyFollowListView
  extends BaseListView<AtPersonItem>
{
  private final AtPersonListAdapter a;
  private HashMap b;
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public AtPersonListAdapter getAdapter()
  {
    return this.a;
  }
  
  @NotNull
  public String getEmptyText()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getString(R.string.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…ent_my_follow_empty_tips)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFollowListView
 * JD-Core Version:    0.7.0.1
 */