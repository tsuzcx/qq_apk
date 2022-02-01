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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class tay
  extends szd
{
  private static qsf jdField_b_of_type_Qsf = new qsf();
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<qcu> jdField_a_of_type_AndroidUtilSparseArray;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
  private Activity jdField_b_of_type_AndroidAppActivity;
  
  public tay(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<qcu> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    a(this.jdField_a_of_type_AndroidUtilSparseArray);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_b_of_type_Qsf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
  }
  
  private void a(SparseArray<qcu> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((qcu)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    return ppe.a((ArticleInfo)getItem(paramInt));
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
    if ((a() != null) && (paramList != null)) {
      a().addAll(paramList);
    }
    qda.a(this.jdField_a_of_type_AndroidUtilSparseArray, new taz(this, "onSetData", paramList));
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
  
  public int getCount()
  {
    if (a() != null) {
      return a().size();
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
    if ((a() == null) || (a().size() == 0)) {}
    int i;
    for (Object localObject = null;; localObject = (View)qda.a(this.jdField_a_of_type_AndroidUtilSparseArray, new tba(this, "onAdapterGetView", i, (BaseArticleInfo)localObject, paramInt, paramViewGroup)))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = b(paramInt);
      i = getItemViewType(paramInt);
      QLog.d("ReadInJoyProteusFamilyAdapter", 2, "getView | position : " + paramInt + " type : " + i + " article_title = " + ((BaseArticleInfo)localObject).mTitle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tay
 * JD-Core Version:    0.7.0.1
 */