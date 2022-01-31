import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

class pmg
  implements ViewBase.OnClickListener
{
  pmg(pmf parampmf, pgd parampgd, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Pgd.a();
      opy.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
      if (bdem.a(BaseApplicationImpl.getContext(), "com.tencent.reading")) {
        if (this.jdField_a_of_type_Pgd.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
        {
          paramViewBase = pmf.a(this.jdField_a_of_type_Pmf, this.jdField_a_of_type_Pgd.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
          if (!TextUtils.isEmpty(paramViewBase)) {
            pmf.a(this.jdField_a_of_type_Pmf, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
          }
        }
      }
      for (;;)
      {
        nwh.a(pmf.a(this.jdField_a_of_type_Pmf, this.jdField_a_of_type_Pgd.a().weishiUGInfo.bytes_report_base_url) + pmf.a(this.jdField_a_of_type_Pmf, this.jdField_a_of_type_Pgd.a().weishiUGInfo.bytes_click_report_tail));
        return;
        if (this.jdField_a_of_type_Pgd.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 1)
        {
          paramViewBase = pmf.a(this.jdField_a_of_type_Pmf, this.jdField_a_of_type_Pgd.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          if (!TextUtils.isEmpty(paramViewBase)) {
            ayrd.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
          }
        }
      }
      return;
    }
    catch (Exception paramViewBase) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmg
 * JD-Core Version:    0.7.0.1
 */