package com.tencent.tkd.topicsdk.selectowner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import com.tencent.tkd.topicsdk.managetopic.CreateTopicPage;
import com.tencent.tkd.topicsdk.managetopic.TopicEventDispatcher;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListView;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView;", "Lcom/tencent/tkd/topicsdk/selectowner/BaseSelectView;", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$MyTopicViewHolder;", "context", "Landroid/app/Activity;", "selectedTopicId", "", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "(Landroid/app/Activity;JLcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getContext", "()Landroid/app/Activity;", "createTopicListener", "Lkotlin/Function2;", "", "", "mTopicAdapter", "com/tencent/tkd/topicsdk/selectowner/SelectTopicView$mTopicAdapter$1", "Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$mTopicAdapter$1;", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "getSelectedTopicId", "()J", "handleRightActionClick", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class SelectTopicView
  extends BaseSelectView<TopicInfo, SelectTopicView.MyTopicViewHolder>
{
  public static final SelectTopicView.Companion a;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final SelectTopicView.mTopicAdapter.1 jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectTopicView$mTopicAdapter$1;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Function2<Integer, TopicInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectTopicView$Companion = new SelectTopicView.Companion(null);
  }
  
  public SelectTopicView(@NotNull Activity paramActivity, long paramLong, @NotNull ListPresenter<TopicInfo, ListContract.IListView<TopicInfo>> paramListPresenter)
  {
    super(paramActivity, paramListPresenter);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectTopicView$mTopicAdapter$1 = new SelectTopicView.mTopicAdapter.1(this, (Context)this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = ((Function2)new SelectTopicView.createTopicListener.1(this));
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
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
  public CommonListAdapter<TopicInfo, SelectTopicView.MyTopicViewHolder> a()
  {
    return (CommonListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectTopicView$mTopicAdapter$1;
  }
  
  @NotNull
  public String a()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(R.string.U);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ing.publish_to_topic_tip)");
    return str;
  }
  
  public void a()
  {
    TopicSDKHelperKt.a(this.jdField_a_of_type_AndroidAppActivity, CreateTopicPage.class, 1, null, null, null, 56, null);
  }
  
  @NotNull
  public String b()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(R.string.m);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getString(R.string.create_topic)");
    return str;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TopicEventDispatcher.a.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TopicEventDispatcher.a.b(this.jdField_a_of_type_KotlinJvmFunctionsFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */