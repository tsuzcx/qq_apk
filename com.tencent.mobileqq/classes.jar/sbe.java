import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import org.json.JSONObject;

class sbe
  extends sah
{
  private Container a;
  
  public sbe(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.a = ((Container)paramView);
    }
  }
  
  private JSONObject a(ProteusBookData paramProteusBookData)
  {
    if (paramProteusBookData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
      return paramProteusBookData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(paramProteusBookData.b);
    }
    return null;
  }
  
  private void b()
  {
    ViewFactory.findClickableViewListener(this.a.getVirtualView(), new sbf(this));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.s)
    {
    }
    do
    {
      return;
    } while (this.a == null);
    paramBaseData1 = (ProteusBookData)paramBaseData2;
    if (paramBaseData1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean != null)
    {
      paramBaseData1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.putDynamicJson(a(paramBaseData1));
      opy.a(this.a.getVirtualView(), paramBaseData1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getViewBean());
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbe
 * JD-Core Version:    0.7.0.1
 */