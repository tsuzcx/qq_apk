package com.tencent.tkd.weibo.atContact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.weibo.component.R.id;
import com.tencent.tkd.weibo.component.R.string;
import com.tencent.tkd.weibo.framework.mvp.BaseListView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/MyFansListView;", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/tkd/weibo/atContact/MyFansListView$MyFansListPresenter;", "(Landroid/content/Context;Lcom/tencent/tkd/weibo/atContact/MyFansListView$MyFansListPresenter;)V", "adapter", "Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter;", "mAdapter", "setCenterEmpty", "", "MyFansListPresenter", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class MyFansListView
  extends BaseListView<AtPersonItem>
{
  private final AtPersonListAdapter jdField_a_of_type_ComTencentTkdWeiboAtContactAtPersonListAdapter;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
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
  
  @NotNull
  public AtPersonListAdapter a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboAtContactAtPersonListAdapter;
  }
  
  public void setCenterEmpty()
  {
    super.setCenterEmpty();
    TextView localTextView = (TextView)a(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tv_empty");
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localTextView.setText((CharSequence)localContext.getResources().getString(R.string.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFansListView
 * JD-Core Version:    0.7.0.1
 */