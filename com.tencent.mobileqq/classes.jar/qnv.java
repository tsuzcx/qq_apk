import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;
import org.json.JSONObject;

class qnv
  implements ViewBase.OnClickListener
{
  qnv(qnu paramqnu, qfw paramqfw, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qfw.a();
    if (localArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localArticleInfo.getProteusItemData();
    } while (localJSONObject == null);
    szd localszd = this.jdField_a_of_type_Qfw.a();
    if (this.jdField_a_of_type_Int == 1126) {}
    for (boolean bool = true;; bool = false)
    {
      paramViewBase = localArticleInfo;
      if (!bool)
      {
        paramViewBase = localArticleInfo;
        if (localArticleInfo.mSubArtilceList != null)
        {
          paramViewBase = localArticleInfo;
          if (localArticleInfo.mSubArtilceList.size() > 0)
          {
            paramViewBase = localArticleInfo;
            if (localArticleInfo.mSubArtilceList.get(0) != null) {
              paramViewBase = (BaseArticleInfo)localArticleInfo.mSubArtilceList.get(0);
            }
          }
        }
      }
      if (!six.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())) {
        qnu.a(this.jdField_a_of_type_Qnu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase, localszd);
      }
      pvj.a().a(paramViewBase.mArticleID, System.currentTimeMillis());
      qnu.a(this.jdField_a_of_type_Qnu, paramViewBase, bool, localJSONObject);
      localszd.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnv
 * JD-Core Version:    0.7.0.1
 */