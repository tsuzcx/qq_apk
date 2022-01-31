import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class ovv
  implements pjv
{
  ovv(ovq paramovq, opw paramopw, Container paramContainer, int paramInt) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((pqz)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    localObject = (pra)((pqz)localObject).a.get(paramInt);
    ovq.a(this.jdField_a_of_type_Ovq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Opw.a(), (int)((pra)localObject).a, this.jdField_a_of_type_Opw.a().innerUniqueID, this.jdField_a_of_type_Int, paramInt, this.jdField_a_of_type_Opw.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovv
 * JD-Core Version:    0.7.0.1
 */