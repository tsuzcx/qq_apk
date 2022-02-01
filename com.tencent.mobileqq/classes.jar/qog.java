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

class qog
  implements ViewBase.OnClickListener
{
  qog(qof paramqof, qfw paramqfw, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        ArticleInfo localArticleInfo = this.jdField_a_of_type_Qfw.a();
        piv.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
        ptj.a.a(localArticleInfo);
        int j = 0;
        if (bhfn.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.jdField_a_of_type_Qfw.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = qof.a(this.jdField_a_of_type_Qof, this.jdField_a_of_type_Qfw.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              qof.a(this.jdField_a_of_type_Qof, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
              break label323;
            }
          }
          if (i == 0)
          {
            paramViewBase = new JSONObject(localArticleInfo.proteusItemsData).getString("kandian_jump_url");
            if (!TextUtils.isEmpty(paramViewBase)) {
              bcnc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
            }
          }
          oqt.a(qof.a(this.jdField_a_of_type_Qof, this.jdField_a_of_type_Qfw.a().weishiUGInfo.bytes_report_base_url) + qof.a(this.jdField_a_of_type_Qof, this.jdField_a_of_type_Qfw.a().weishiUGInfo.bytes_click_report_tail));
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_Qfw.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() != 1) {
            continue;
          }
          paramViewBase = qof.a(this.jdField_a_of_type_Qof, this.jdField_a_of_type_Qfw.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          i = j;
          if (TextUtils.isEmpty(paramViewBase)) {
            continue;
          }
          bcnc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
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
 * Qualified Name:     qog
 * JD-Core Version:    0.7.0.1
 */