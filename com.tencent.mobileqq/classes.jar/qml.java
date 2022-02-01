import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONObject;

public class qml
  implements ViewBase.OnClickListener
{
  qml(qmj paramqmj) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    pfr.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    pha.a(qmi.a(this.a.jdField_a_of_type_Qmi).getContext(), paramViewBase.getEventAttachedData());
    paramViewBase = (String)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getDataAttribute(paramViewBase.getViewId(), "topic_id");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData().remove("reddot_num");
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.refreshData();
    qmi.a(this.a.jdField_a_of_type_Qmi, new RecycleViewAdapterHelper.3.2.1(this));
    pmh.a().i(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */