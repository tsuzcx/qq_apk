import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.widget.AbsListView;

public class ood
  extends onp
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private int jdField_a_of_type_Int;
  ooe jdField_a_of_type_Ooe = null;
  
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
    b = false;
    c = false;
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Syj instanceof ooe)))
    {
      if (ooe.a((ooe)this.jdField_a_of_type_Syj) != null) {
        ooe.a((ooe)this.jdField_a_of_type_Syj).setVisibility(8);
      }
      if (ooe.a((ooe)this.jdField_a_of_type_Syj) != null) {
        ooe.a((ooe)this.jdField_a_of_type_Syj).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Syj instanceof ooe)))
    {
      if (ooe.a((ooe)this.jdField_a_of_type_Syj) != null) {
        ooe.a((ooe)this.jdField_a_of_type_Syj).setVisibility(0);
      }
      if (ooe.a((ooe)this.jdField_a_of_type_Syj) != null) {
        ooe.a((ooe)this.jdField_a_of_type_Syj).setVisibility(0);
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = opz.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
  }
  
  protected syj a(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_Ooe = new ooe(this, paramView, paramBaseData, this.jdField_a_of_type_JavaLangRefWeakReference);
    return this.jdField_a_of_type_Ooe;
  }
  
  public void a()
  {
    a(true);
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null)) {
      ooe.a(this.jdField_a_of_type_Ooe).m();
    }
    this.jdField_a_of_type_Int = Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.u;
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
      i();
      return;
    }
    g();
    j();
  }
  
  public boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData != null) && (paramBaseData.t == 17)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      }
      return bool;
    }
  }
  
  public void b()
  {
    super.b();
    ubb.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null)) {
      ooe.a(this.jdField_a_of_type_Ooe).p();
    }
    i();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null)) {
      ooe.a(this.jdField_a_of_type_Ooe).q();
    }
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null))
    {
      ooe.a(this.jdField_a_of_type_Ooe).k();
      ooe.a(this.jdField_a_of_type_Ooe, null);
      this.jdField_a_of_type_Ooe = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null))
    {
      ooe.a(this.jdField_a_of_type_Ooe).k();
      ooe.a(this.jdField_a_of_type_Ooe, null);
      this.jdField_a_of_type_Ooe = null;
    }
  }
  
  public void g()
  {
    if (b)
    {
      c = true;
      if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null)) {
        ooe.a(this.jdField_a_of_type_Ooe).q();
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Ooe != null) && (ooe.a(this.jdField_a_of_type_Ooe) != null)) {
      ooe.a(this.jdField_a_of_type_Ooe).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ood
 * JD-Core Version:    0.7.0.1
 */