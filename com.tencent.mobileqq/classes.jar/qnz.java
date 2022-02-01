import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class qnz
  implements ViewBase.OnClickListener
{
  qnz(qnw paramqnw, BaseArticleInfo paramBaseArticleInfo, qfw paramqfw) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.isEmpty())) {
      return;
    }
    VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.get(0);
    if ((localVideoColumnInfo.a != null) && (localVideoColumnInfo.a.a != 3)) {
      six.a(this.jdField_a_of_type_Qfw.a().getContext(), localVideoColumnInfo.a);
    }
    piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean, paramViewBase);
    ptj.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnz
 * JD-Core Version:    0.7.0.1
 */