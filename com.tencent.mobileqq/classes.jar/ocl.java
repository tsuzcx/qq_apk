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

public class ocl
  implements sai, sak
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private Context jdField_a_of_type_AndroidContentContext;
  public BaseData a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  ocm jdField_a_of_type_Ocm;
  private scp jdField_a_of_type_Scp = new scp();
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
      i = odv.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
  }
  
  public sah a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
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
      opy.a(((Container)localObject).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.c.toString();
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
    if ((this.jdField_a_of_type_Ocm == null) || (paramBaseData != this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      this.jdField_a_of_type_Ocm = new ocm(this, (View)localObject, localProteusItemData);
    }
    return this.jdField_a_of_type_Ocm;
  }
  
  public void a()
  {
    a(true);
    if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null)) {
      ocm.a(this.jdField_a_of_type_Ocm).m();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.t;
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
    if (paramBaseData.s == 17)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    szl.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null)) {
      ocm.a(this.jdField_a_of_type_Ocm).p();
    }
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null))
    {
      ocm.a(this.jdField_a_of_type_Ocm).k();
      ocm.a(this.jdField_a_of_type_Ocm, null);
      this.jdField_a_of_type_Ocm = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null))
    {
      ocm.a(this.jdField_a_of_type_Ocm).k();
      ocm.a(this.jdField_a_of_type_Ocm, null);
      this.jdField_a_of_type_Ocm = null;
    }
  }
  
  public void g()
  {
    if (jdField_b_of_type_Boolean)
    {
      c = true;
      if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null)) {
        ocm.a(this.jdField_a_of_type_Ocm).p();
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Ocm != null) && (ocm.a(this.jdField_a_of_type_Ocm) != null)) {
      ocm.a(this.jdField_a_of_type_Ocm).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocl
 * JD-Core Version:    0.7.0.1
 */