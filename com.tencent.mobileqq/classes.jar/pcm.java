import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONObject;

public class pcm
  implements ViewBase.OnClickListener
{
  pcm(pck parampck) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    oag.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    obz.a(pcj.a(this.a.jdField_a_of_type_Pcj).getContext(), paramViewBase.getEventAttachedData());
    paramViewBase = (String)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getDataAttribute(paramViewBase.getViewId(), "topic_id");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData().remove("reddot_num");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.refreshData();
    pcj.a(this.a.jdField_a_of_type_Pcj, new RecycleViewAdapterHelper.3.2.1(this));
    ogy.a().i(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcm
 * JD-Core Version:    0.7.0.1
 */