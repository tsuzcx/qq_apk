import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pko
  implements oqx
{
  public pko(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup, List paramList, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, ArrayList<ooz> paramArrayList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ComponentContentRecommendFollowGroup", 2, "followThem, isSuccess = " + paramBoolean + ", followList = " + paramArrayList + ", errorMsg = " + paramString);
    }
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramArrayList = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        paramArrayList.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup.b(paramArrayList);
        i += 1;
      }
      ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup).notifyDataSetChanged();
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup.getContext(), 1, 2131652679, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pko
 * JD-Core Version:    0.7.0.1
 */