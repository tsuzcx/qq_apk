import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nci
  extends bbbt
{
  nci(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public List<bahx>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    bbbt localbbbt = (bbbt)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bbaq.a(4);
    if ((localbbbt != null) && (localbbbt.c()) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630988);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842035;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 34;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630983);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838732;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 2;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630996);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838733;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 3;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bgmq.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630997);
        ((bahx)localObject1).jdField_b_of_type_Int = 2130838731;
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).c = 13;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631003);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838736;
      ((bahx)localObject1).c = 9;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630986);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838730;
      ((bahx)localObject1).c = 10;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((localbbbt != null) && (localbbbt.b()) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631000);
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838735;
      ((bahx)localObject1).c = 12;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630979);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842038;
      ((bahx)localObject1).c = 5;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630980);
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842034;
      ((bahx)localObject1).c = 4;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      bcpn.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630994);
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).jdField_b_of_type_Int = 2130843511;
      ((bahx)localObject1).c = 20;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    Object localObject2;
    bahx localbahx;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (nct)((Iterator)localObject1).next();
        localbahx = new bahx();
        switch (((nct)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((nct)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localbahx.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629864);; localbahx.jdField_a_of_type_JavaLangString = ((nct)localObject2).jdField_a_of_type_JavaLangString)
          {
            localbahx.jdField_b_of_type_Int = 2130842040;
            localbahx.jdField_b_of_type_Boolean = true;
            localbahx.c = 30;
            localbahx.jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localbahx);
            i = 1;
            break;
          }
          localObject2 = new bahx();
          ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629925);
          ((bahx)localObject2).jdField_b_of_type_Int = 2130842032;
          ((bahx)localObject2).jdField_b_of_type_Boolean = true;
          ((bahx)localObject2).c = 31;
          ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList2.add(localObject2);
          i = 1;
        }
      }
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (this.f)
    {
      j = i;
      if (this.b != null)
      {
        localObject1 = this.b.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (nct)((Iterator)localObject1).next();
          localbahx = new bahx();
          switch (((nct)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nct)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localbahx.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131629864);; localbahx.jdField_a_of_type_JavaLangString = ((nct)localObject2).jdField_a_of_type_JavaLangString)
            {
              localbahx.jdField_b_of_type_Int = 2130842040;
              localbahx.jdField_b_of_type_Boolean = true;
              localbahx.c = 37;
              localbahx.jdField_b_of_type_JavaLangString = "";
              localArrayList2.add(localbahx);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new bahx();
            ((bahx)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630984);
            ((bahx)localObject2).jdField_b_of_type_Int = 2130842041;
            ((bahx)localObject2).jdField_b_of_type_Boolean = true;
            ((bahx)localObject2).c = 35;
            ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (bbbo)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bbaq.a(64);
    if ((localObject1 != null) && (((bbbo)localObject1).a()) && (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631007);
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842039;
      ((bahx)localObject1).c = 21;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630969);
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).jdField_b_of_type_Int = 2130843306;
      ((bahx)localObject1).c = 6;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bbcj)this.jdField_a_of_type_Bbat.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.h;
      }
      if (axea.a((String)localObject1))
      {
        localObject1 = new bahx();
        ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630977);
        ((bahx)localObject1).jdField_b_of_type_Boolean = true;
        ((bahx)localObject1).jdField_b_of_type_Int = 2130849183;
        ((bahx)localObject1).c = 68;
        ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
        axea.a(0, 0);
      }
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630978);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842036;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 7;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630975);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838728;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 1;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131631008);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842032;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 8;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((localbbbt != null) && (localbbbt.d()))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630990);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842037;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 38;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if (!rsv.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131630981);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130842024;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 11;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof baia)) {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "Item clicked but tag not found");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Bahv.b();
        i = ((baia)localObject).a.c;
        if (i == 7)
        {
          super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(i);
          return;
        }
        if (i == 8)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(i);
          return;
        }
        super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      awqx.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    awqx.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nci
 * JD-Core Version:    0.7.0.1
 */