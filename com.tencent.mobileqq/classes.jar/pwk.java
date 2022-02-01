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

class pwk
  implements ViewBase.OnClickListener
{
  pwk(pwj parampwj, ppu paramppu, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        ArticleInfo localArticleInfo = this.jdField_a_of_type_Ppu.a();
        oyj.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
        int j = 0;
        if (bhny.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.jdField_a_of_type_Ppu.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = pwj.a(this.jdField_a_of_type_Pwj, this.jdField_a_of_type_Ppu.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              pwj.a(this.jdField_a_of_type_Pwj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
              break label315;
            }
          }
          if (i == 0)
          {
            paramViewBase = new JSONObject(localArticleInfo.proteusItemsData).getString("kandian_jump_url");
            if (!TextUtils.isEmpty(paramViewBase)) {
              bcni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
            }
          }
          ohk.a(pwj.a(this.jdField_a_of_type_Pwj, this.jdField_a_of_type_Ppu.a().weishiUGInfo.bytes_report_base_url) + pwj.a(this.jdField_a_of_type_Pwj, this.jdField_a_of_type_Ppu.a().weishiUGInfo.bytes_click_report_tail));
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_Ppu.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() != 1) {
            continue;
          }
          paramViewBase = pwj.a(this.jdField_a_of_type_Pwj, this.jdField_a_of_type_Ppu.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          i = j;
          if (TextUtils.isEmpty(paramViewBase)) {
            continue;
          }
          bcni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
        }
      }
      catch (Exception paramViewBase)
      {
        return;
      }
      label315:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwk
 * JD-Core Version:    0.7.0.1
 */