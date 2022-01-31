import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;
import org.json.JSONObject;

class oup
  implements ViewBase.OnClickListener
{
  oup(ouo paramouo, opw paramopw, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Opw.a();
    if (localArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localArticleInfo.getProteusItemData();
    } while (localJSONObject == null);
    qoe localqoe = this.jdField_a_of_type_Opw.a();
    if (this.jdField_a_of_type_Int == 1120) {}
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
      if (!qcn.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())) {
        ouo.a(this.jdField_a_of_type_Ouo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase, localqoe);
      }
      ogy.a().a(paramViewBase.mArticleID, System.currentTimeMillis());
      ouo.a(this.jdField_a_of_type_Ouo, paramViewBase, bool, localJSONObject);
      localqoe.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oup
 * JD-Core Version:    0.7.0.1
 */