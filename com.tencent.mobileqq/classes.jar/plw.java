import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;
import org.json.JSONObject;

class plw
  implements ViewBase.OnClickListener
{
  plw(plv paramplv, pgd parampgd, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pgd.a();
    if (localArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localArticleInfo.getProteusItemData();
    } while (localJSONObject == null);
    rqj localrqj = this.jdField_a_of_type_Pgd.a();
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
      if (!rdm.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())) {
        plv.a(this.jdField_a_of_type_Plv, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase, localrqj);
      }
      owy.a().a(paramViewBase.mArticleID, System.currentTimeMillis());
      plv.a(this.jdField_a_of_type_Plv, paramViewBase, bool, localJSONObject);
      localrqj.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */