import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class nzb
  implements rkh, rkj
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private Context jdField_a_of_type_AndroidContentContext;
  public BaseData a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  nzc jdField_a_of_type_Nzc;
  private rmq jdField_a_of_type_Rmq = new rmq();
  public BaseData b;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void f()
  {
    a(false);
    jdField_b_of_type_Boolean = false;
    c = false;
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = oai.a((ProteusBannerVideoItemData)paramBaseData);
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
    paramViewGroup = null;
    try
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramViewGroup = (ViewGroup)localObject;
      olo.a(((Container)localObject).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.b.toString();
      paramViewGroup = (ViewGroup)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        boolean bool;
        String str = "error!! msg=" + localException.toString();
      }
    }
    bool = false;
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFastProteusViewAdBannerVideoCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    if ((this.jdField_a_of_type_Nzc == null) || (paramBaseData != this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      this.jdField_a_of_type_Nzc = new nzc(this, (View)localObject, localProteusItemData);
    }
    return this.jdField_a_of_type_Nzc;
  }
  
  public void a()
  {
    a(true);
    if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null)) {
      nzc.a(this.jdField_a_of_type_Nzc).m();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.q;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = paramAbsListView.getFirstVisiblePosition();
    int j = paramAbsListView.getLastVisiblePosition();
    if ((i >= paramInt) && (i <= j))
    {
      h();
      return;
    }
    g();
  }
  
  public boolean a(BaseData paramBaseData)
  {
    if (paramBaseData.p == 17)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    shq.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null)) {
      nzc.a(this.jdField_a_of_type_Nzc).p();
    }
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null))
    {
      nzc.a(this.jdField_a_of_type_Nzc).k();
      nzc.a(this.jdField_a_of_type_Nzc, null);
      this.jdField_a_of_type_Nzc = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null))
    {
      nzc.a(this.jdField_a_of_type_Nzc).k();
      nzc.a(this.jdField_a_of_type_Nzc, null);
      this.jdField_a_of_type_Nzc = null;
    }
  }
  
  public void g()
  {
    if (jdField_b_of_type_Boolean)
    {
      c = true;
      if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null)) {
        nzc.a(this.jdField_a_of_type_Nzc).p();
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Nzc != null) && (nzc.a(this.jdField_a_of_type_Nzc) != null)) {
      nzc.a(this.jdField_a_of_type_Nzc).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */