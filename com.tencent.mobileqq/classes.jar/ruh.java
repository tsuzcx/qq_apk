import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ruh
  extends rqj
{
  private static ppz jdField_a_of_type_Ppz = new ppz();
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<pdc> jdField_a_of_type_AndroidUtilSparseArray;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
  private Activity b;
  
  public ruh(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<pdc> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    a(this.jdField_a_of_type_AndroidUtilSparseArray);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_a_of_type_Ppz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
  }
  
  private void a(SparseArray<pdc> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    return rqj.c((ArticleInfo)getItem(paramInt));
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return null;
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return null;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList) {}
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1) {}
  
  public void a(List<BaseArticleInfo> paramList)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (paramList != null)) {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
    pdh.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rui(this, "onSetData", paramList));
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return false;
  }
  
  public void c(List<View> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
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
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    paramView = b(paramInt);
    int i = getItemViewType(paramInt);
    QLog.d("ReadInJoyProteusFamilyAdapter", 2, "getView | position : " + paramInt + " type : " + i + " article_title = " + paramView.mTitle);
    return (View)pdh.a(this.jdField_a_of_type_AndroidUtilSparseArray, new ruj(this, "onAdapterGetView", i, paramView, paramInt, paramViewGroup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ruh
 * JD-Core Version:    0.7.0.1
 */