package com.tencent.tkd.topicsdk.selectowner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/SelectCommunityView;", "Lcom/tencent/tkd/topicsdk/selectowner/BaseSelectView;", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Lcom/tencent/tkd/topicsdk/selectowner/SelectCommunityView$CommunityViewHolder;", "context", "Landroid/app/Activity;", "selectedCommunityId", "", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getContext", "()Landroid/app/Activity;", "mAdapter", "com/tencent/tkd/topicsdk/selectowner/SelectCommunityView$mAdapter$1", "Lcom/tencent/tkd/topicsdk/selectowner/SelectCommunityView$mAdapter$1;", "selectTip", "getSelectTip", "()Ljava/lang/String;", "getSelectedCommunityId", "CommunityViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class SelectCommunityView
  extends BaseSelectView<CommunityInfo, SelectCommunityView.CommunityViewHolder>
{
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final SelectCommunityView.mAdapter.1 jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectCommunityView$mAdapter$1;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
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
  public CommonListAdapter<CommunityInfo, SelectCommunityView.CommunityViewHolder> a()
  {
    return (CommonListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkSelectownerSelectCommunityView$mAdapter$1;
  }
  
  @NotNull
  public String a()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(R.string.S);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…publish_to_community_tip)");
    return str;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectCommunityView
 * JD-Core Version:    0.7.0.1
 */