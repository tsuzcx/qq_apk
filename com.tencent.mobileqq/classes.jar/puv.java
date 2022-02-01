import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class puv
  implements ViewBase.OnClickListener
{
  puv(puu parampuu, BaseArticleInfo paramBaseArticleInfo, ppu paramppu, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.isEmpty())) {
      return;
    }
    QLog.i("BigImageVideoProteusItem", 1, "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances);
    paramViewBase = (VideoColumnInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.get(0);
    QLog.i("BigImageVideoProteusItem", 1, "" + paramViewBase);
    if ((paramViewBase.a != null) && (paramViewBase.a.a != 3)) {
      rpt.a(this.jdField_a_of_type_Ppu.a().getContext(), paramViewBase.a);
    }
    oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puv
 * JD-Core Version:    0.7.0.1
 */