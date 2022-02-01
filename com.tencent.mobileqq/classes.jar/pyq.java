import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.6.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class pyq
  implements pzb
{
  public pyq(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public BaseArticleInfo a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_Pze.a.size() > 0) && (paramInt < this.a.jdField_a_of_type_Pze.a.size())) {
      return (BaseArticleInfo)this.a.jdField_a_of_type_Pze.a.get(paramInt);
    }
    return null;
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.a.jdField_a_of_type_Pze.a;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Pze.notifyDataSetChanged();
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    ReadInJoyPicWaterFallFragment.b(this.a);
    this.a.jdField_a_of_type_Pze.a.remove(paramBaseArticleInfo);
    this.a.jdField_a_of_type_Pze.notifyItemRemoved(paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.a.jdField_a_of_type_Pze.a(paramList);
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean)
  {
    Map localMap = uvs.a(this.a.a());
    String str = prp.a(this.a.a());
    ThreadManager.post(new ReadInJoyPicWaterFallFragment.6.1(this, this.a.g(), paramMap, paramBoolean, localMap, str), 5, null, false);
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean, Map<Long, uvx> paramMap1, String paramString)
  {
    this.a.a(paramMap, paramBoolean, paramMap1, paramString);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap)
  {
    this.a.jdField_a_of_type_JavaUtilSet = paramSet;
    this.a.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a(paramBoolean, paramString);
  }
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_Pze.getItemCount() == 0;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.d();
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    this.a.jdField_a_of_type_Pze.a.removeAll(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.b(paramBoolean);
  }
  
  public void c()
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.e();
  }
  
  public void c(List<ChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, "refreshSubChannelData channelList size:" + paramList.size());
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, "refreshSubChannelData mClassificationListView =" + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView + ",showSub = " + this.a.jdField_a_of_type_Boolean);
    }
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        this.a.jdField_a_of_type_JavaUtilArrayList.add(new pyu(localChannelCoverInfo, localChannelCoverInfo.mChannelCoverName, String.valueOf(localChannelCoverInfo.mChannelCoverId)));
      }
      this.a.jdField_a_of_type_Pze.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyq
 * JD-Core Version:    0.7.0.1
 */