import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nnj
  extends bcet
{
  nnj(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void a(bbje parambbje, bcuq parambcuq)
  {
    this.jdField_a_of_type_Bbjc.b();
    int i = parambbje.c;
    if (i == 7)
    {
      super.a(parambbje, parambcuq);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(i);
    }
    do
    {
      do
      {
        return;
        if (i == 8)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.a(i);
          return;
        }
        super.a(parambbje, parambcuq);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      axqw.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    axqw.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
  
  public List<bbje>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    bcet localbcet = (bcet)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bcdq.a(4);
    if ((localbcet != null) && (localbcet.c()) && (!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696700);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842127;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 34;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696695);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838754;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 2;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696708);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838755;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 3;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bhvh.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new bbje();
        ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696709);
        ((bbje)localObject1).jdField_b_of_type_Int = 2130838753;
        ((bbje)localObject1).jdField_b_of_type_Boolean = true;
        ((bbje)localObject1).c = 13;
        ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696715);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838758;
      ((bbje)localObject1).c = 9;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696698);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838752;
      ((bbje)localObject1).c = 10;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((localbcet != null) && (localbcet.b()) && (!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696712);
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838757;
      ((bbje)localObject1).c = 12;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696691);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842130;
      ((bbje)localObject1).c = 5;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696692);
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842126;
      ((bbje)localObject1).c = 4;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      bdto.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696706);
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).jdField_b_of_type_Int = 2130843595;
      ((bbje)localObject1).c = 20;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    Object localObject2;
    bbje localbbje;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (nnu)((Iterator)localObject1).next();
        localbbje = new bbje();
        switch (((nnu)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((nnu)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695545);; localbbje.jdField_a_of_type_JavaLangString = ((nnu)localObject2).jdField_a_of_type_JavaLangString)
          {
            localbbje.jdField_b_of_type_Int = 2130842132;
            localbbje.jdField_b_of_type_Boolean = true;
            localbbje.c = 30;
            localbbje.jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localbbje);
            i = 1;
            break;
          }
          localObject2 = new bbje();
          ((bbje)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695606);
          ((bbje)localObject2).jdField_b_of_type_Int = 2130842124;
          ((bbje)localObject2).jdField_b_of_type_Boolean = true;
          ((bbje)localObject2).c = 31;
          ((bbje)localObject2).jdField_b_of_type_JavaLangString = "";
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
          localObject2 = (nnu)((Iterator)localObject1).next();
          localbbje = new bbje();
          switch (((nnu)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nnu)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695545);; localbbje.jdField_a_of_type_JavaLangString = ((nnu)localObject2).jdField_a_of_type_JavaLangString)
            {
              localbbje.jdField_b_of_type_Int = 2130842132;
              localbbje.jdField_b_of_type_Boolean = true;
              localbbje.c = 37;
              localbbje.jdField_b_of_type_JavaLangString = "";
              localArrayList2.add(localbbje);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new bbje();
            ((bbje)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696696);
            ((bbje)localObject2).jdField_b_of_type_Int = 2130842133;
            ((bbje)localObject2).jdField_b_of_type_Boolean = true;
            ((bbje)localObject2).c = 35;
            ((bbje)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (bceo)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bcdq.a(64);
    if ((localObject1 != null) && (((bceo)localObject1).a()) && (!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696719);
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842131;
      ((bbje)localObject1).c = 21;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696681);
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).jdField_b_of_type_Int = 2130843387;
      ((bbje)localObject1).c = 6;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bcfj)this.jdField_a_of_type_Bcdt.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.h;
      }
      if (ayec.a((String)localObject1))
      {
        localObject1 = new bbje();
        ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696689);
        ((bbje)localObject1).jdField_b_of_type_Boolean = true;
        ((bbje)localObject1).jdField_b_of_type_Int = 2130849418;
        ((bbje)localObject1).c = 68;
        ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
        ayec.a(0, 0);
      }
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696690);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842128;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 7;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696687);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838750;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 1;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696720);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842124;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 8;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((localbcet != null) && (localbcet.d()))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696702);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842129;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 38;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if (!sfn.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696693);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130842116;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 11;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnj
 * JD-Core Version:    0.7.0.1
 */