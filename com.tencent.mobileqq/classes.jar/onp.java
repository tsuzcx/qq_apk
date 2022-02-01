import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class onp
  implements syk, syp
{
  protected BaseData a;
  protected VafContext a;
  protected WeakReference<Context> a;
  protected syj a;
  protected tbe a;
  
  public onp()
  {
    this.jdField_a_of_type_Tbe = new tbe();
  }
  
  public int a(BaseData paramBaseData)
  {
    return 0;
  }
  
  public syj a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qmv();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      pfr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramBaseData = null;
    try
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramBaseData = paramViewGroup;
      pfr.a(((Container)paramViewGroup).getVirtualView(), localProteusItemData.a.getViewBean());
      paramBaseData = paramViewGroup;
      str = localProteusItemData.c.toString();
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
    oqh.a("WebFastBaseProteusAdCreator", "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    this.jdField_a_of_type_Syj = a(paramViewGroup, localProteusItemData);
    return this.jdField_a_of_type_Syj;
  }
  
  protected syj a(View paramView, BaseData paramBaseData)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tbe != null) {
      this.jdField_a_of_type_Tbe.a();
    }
    if ((this.jdField_a_of_type_Syj instanceof onq))
    {
      localObject = this.jdField_a_of_type_Syj.a;
      if (!(localObject instanceof Container)) {
        break label93;
      }
    }
    label93:
    for (Object localObject = (Container)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        do
        {
          return;
          localObject = ((Container)localObject).getVirtualView();
        } while (localObject == null);
        localObject = ((ViewBase)localObject).findViewBaseByName(olk.a(Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0)));
      } while (!(localObject instanceof osm));
      ((osm)localObject).c();
      return;
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_Tbe != null) {
      this.jdField_a_of_type_Tbe.b();
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onp
 * JD-Core Version:    0.7.0.1
 */