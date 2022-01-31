import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONObject;

public class puj
  implements ViewBase.OnClickListener
{
  puj(puh parampuh) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    opy.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    ors.a(pug.a(this.a.jdField_a_of_type_Pug).getContext(), paramViewBase.getEventAttachedData());
    paramViewBase = (String)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getDataAttribute(paramViewBase.getViewId(), "topic_id");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData().remove("reddot_num");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.refreshData();
    pug.a(this.a.jdField_a_of_type_Pug, new RecycleViewAdapterHelper.3.2.1(this));
    owy.a().i(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     puj
 * JD-Core Version:    0.7.0.1
 */