import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class nys
  implements rkk, rkm
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private rmt jdField_a_of_type_Rmt = new rmt();
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusInnerData)) {
      return oal.a((ProteusInnerData)paramBaseData);
    }
    return 20;
  }
  
  public rkj a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new poo();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      olr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
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
      olr.a(((Container)paramViewGroup).getVirtualView(), localProteusItemData.a.getViewBean());
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
      QLog.d("WebFastProteusViewAdBannerBigPicCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new nyt(this, paramViewGroup, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if ((localObject == null) || (!(localObject instanceof Activity)) || (((Activity)localObject).getWindow().getAttributes().softInputMode != 4)) {}
    do
    {
      return;
      localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
    } while (localObject == null);
    ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAbsListView.getWindowToken(), 2);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.p == 22;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rmt.a();
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Rmt.b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nys
 * JD-Core Version:    0.7.0.1
 */