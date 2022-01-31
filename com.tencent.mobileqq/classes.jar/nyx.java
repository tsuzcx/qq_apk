import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class nyx
  implements rkh, rkj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private rmq jdField_a_of_type_Rmq = new rmq();
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerTriplePicItemData)) {
      i = oai.a((ProteusBannerTriplePicItemData)paramBaseData);
    }
    return i;
  }
  
  public rkg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramBaseData = null;
    try
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramBaseData = paramViewGroup;
      olo.a(((Container)paramViewGroup).getVirtualView(), localProteusItemData.a.getViewBean());
      paramBaseData = paramViewGroup;
      str = localProteusItemData.b.toString();
      paramBaseData = paramViewGroup;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        boolean bool;
        String str = "error!! msg=" + paramViewGroup.toString();
      }
    }
    bool = false;
    paramViewGroup = paramBaseData;
    if (paramBaseData == null)
    {
      paramViewGroup = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFastProteusViewAdBannerTriplePicCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new nyy(this, paramViewGroup, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.p == 24);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rmq.a();
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Rmq.b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyx
 * JD-Core Version:    0.7.0.1
 */