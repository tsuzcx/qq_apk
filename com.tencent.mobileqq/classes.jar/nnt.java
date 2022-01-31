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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class nnt
  implements qxs, qxu
{
  public static long a;
  public static yjs a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private Context jdField_a_of_type_AndroidContentContext;
  public BaseData a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  nnu jdField_a_of_type_Nnu;
  private rab jdField_a_of_type_Rab = new rab();
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
    jdField_a_of_type_Yjs = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = npa.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
  }
  
  public qxr a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
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
      oag.a(((Container)localObject).getVirtualView(), localProteusItemData.a.getViewBean());
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
    if ((this.jdField_a_of_type_Nnu == null) || (paramBaseData != this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      this.jdField_a_of_type_Nnu = new nnu(this, (View)localObject, localProteusItemData);
    }
    return this.jdField_a_of_type_Nnu;
  }
  
  public void a()
  {
    a(true);
    if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null)) {
      nnu.a(this.jdField_a_of_type_Nnu).m();
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
    rvb.a(2, jdField_a_of_type_Yjs, jdField_a_of_type_Long);
    jdField_a_of_type_Yjs = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null)) {
      nnu.a(this.jdField_a_of_type_Nnu).p();
    }
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null))
    {
      nnu.a(this.jdField_a_of_type_Nnu).k();
      nnu.a(this.jdField_a_of_type_Nnu, null);
      this.jdField_a_of_type_Nnu = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null))
    {
      nnu.a(this.jdField_a_of_type_Nnu).k();
      nnu.a(this.jdField_a_of_type_Nnu, null);
      this.jdField_a_of_type_Nnu = null;
    }
  }
  
  public void g()
  {
    if (jdField_b_of_type_Boolean)
    {
      c = true;
      if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null)) {
        nnu.a(this.jdField_a_of_type_Nnu).p();
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Nnu != null) && (nnu.a(this.jdField_a_of_type_Nnu) != null)) {
      nnu.a(this.jdField_a_of_type_Nnu).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnt
 * JD-Core Version:    0.7.0.1
 */