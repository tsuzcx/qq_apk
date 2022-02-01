import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

class qce
  implements ViewBase.OnClickListener
{
  qce(qcd paramqcd, pvc parampvc, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvc.a();
        ozp.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
        pim.a.a(localArticleInfo);
        int j = 0;
        if (bfwv.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.jdField_a_of_type_Pvc.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = qcd.a(this.jdField_a_of_type_Qcd, this.jdField_a_of_type_Pvc.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              qcd.a(this.jdField_a_of_type_Qcd, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
              break label323;
            }
          }
          if (i == 0)
          {
            paramViewBase = new JSONObject(localArticleInfo.proteusItemsData).getString("kandian_jump_url");
            if (!TextUtils.isEmpty(paramViewBase)) {
              bbgk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
            }
          }
          oix.a(qcd.a(this.jdField_a_of_type_Qcd, this.jdField_a_of_type_Pvc.a().weishiUGInfo.bytes_report_base_url) + qcd.a(this.jdField_a_of_type_Qcd, this.jdField_a_of_type_Pvc.a().weishiUGInfo.bytes_click_report_tail));
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_Pvc.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() != 1) {
            continue;
          }
          paramViewBase = qcd.a(this.jdField_a_of_type_Qcd, this.jdField_a_of_type_Pvc.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          i = j;
          if (TextUtils.isEmpty(paramViewBase)) {
            continue;
          }
          bbgk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
        }
      }
      catch (Exception paramViewBase)
      {
        return;
      }
      label323:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qce
 * JD-Core Version:    0.7.0.1
 */