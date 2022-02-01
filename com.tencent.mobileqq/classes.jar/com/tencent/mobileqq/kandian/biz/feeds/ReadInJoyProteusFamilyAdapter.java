package com.tencent.mobileqq.kandian.biz.feeds;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IHandlerFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyProteusFamilyAdapter
  extends ReadInJoyBaseAdapter
{
  private static DynamicItemViewHelper jdField_b_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper = new DynamicItemViewHelper();
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<IBaseHandler> jdField_a_of_type_AndroidUtilSparseArray;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
  private Activity jdField_b_of_type_AndroidAppActivity;
  
  public ReadInJoyProteusFamilyAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<IBaseHandler> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    a(this.jdField_a_of_type_AndroidUtilSparseArray);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_b_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
  }
  
  private void a(SparseArray<IBaseHandler> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((IBaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    return RIJBaseItemViewType.a((AbsBaseArticleInfo)getItem(paramInt));
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    return null;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList) {}
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1) {}
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    if ((b() != null) && (paramList != null)) {
      b().addAll(paramList);
    }
    ((IHandlerFactory)QRoute.api(IHandlerFactory.class)).invokeHandlerMethod(this.jdField_a_of_type_AndroidUtilSparseArray, new ReadInJoyProteusFamilyAdapter.1(this, "onSetData", paramList));
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return false;
  }
  
  public AbsBaseArticleInfo b(int paramInt)
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return false;
  }
  
  public int getCount()
  {
    if (b() != null) {
      return b().size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return super.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((b() != null) && (b().size() != 0))
    {
      paramView = a(paramInt);
      int i = getItemViewType(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView | position : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" type : ");
      localStringBuilder.append(i);
      localStringBuilder.append(" article_title = ");
      localStringBuilder.append(paramView.mTitle);
      QLog.d("ReadInJoyProteusFamilyAdapter", 2, localStringBuilder.toString());
      return (View)((IHandlerFactory)QRoute.api(IHandlerFactory.class)).invokeHandlerMethodWithReturn(this.jdField_a_of_type_AndroidUtilSparseArray, new ReadInJoyProteusFamilyAdapter.2(this, "onAdapterGetView", i, paramView, paramInt, paramViewGroup));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyAdapter
 * JD-Core Version:    0.7.0.1
 */