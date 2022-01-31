import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONObject;

public class pob
  implements ViewBase.OnClickListener
{
  pob(pnz parampnz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    olo.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    onh.a(pny.a(this.a.jdField_a_of_type_Pny).getContext(), paramViewBase.getEventAttachedData());
    paramViewBase = (String)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getDataAttribute(paramViewBase.getViewId(), "topic_id");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData().remove("reddot_num");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.refreshData();
    pny.a(this.a.jdField_a_of_type_Pny, new RecycleViewAdapterHelper.3.2.1(this));
    osg.a().i(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pob
 * JD-Core Version:    0.7.0.1
 */