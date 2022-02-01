import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class qct
  implements qvp
{
  qct(qco paramqco, pxk parampxk, Container paramContainer, int paramInt) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((rhn)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    localObject = (rho)((rhn)localObject).a.get(paramInt);
    qco.a(this.jdField_a_of_type_Qco, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pxk.a(), (int)((rho)localObject).a, this.jdField_a_of_type_Pxk.a().innerUniqueID, this.jdField_a_of_type_Int, paramInt, this.jdField_a_of_type_Pxk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qct
 * JD-Core Version:    0.7.0.1
 */