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

public class nng
  extends bcfh
{
  nng(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void a(bbjs parambbjs, bcvf parambcvf)
  {
    this.jdField_a_of_type_Bbjq.b();
    int i = parambbjs.c;
    if (i == 7)
    {
      super.a(parambbjs, parambcvf);
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
        super.a(parambbjs, parambcvf);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      axqy.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    axqy.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
  
  public List<bbjs>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    bcfh localbcfh = (bcfh)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bcee.a(4);
    if ((localbcfh != null) && (localbcfh.c()) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696701);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842128;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 34;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696696);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838754;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 2;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696709);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838755;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 3;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bhvy.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696710);
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130838753;
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).c = 13;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696716);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838758;
      ((bbjs)localObject1).c = 9;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696699);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838752;
      ((bbjs)localObject1).c = 10;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((localbcfh != null) && (localbcfh.b()) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696713);
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838757;
      ((bbjs)localObject1).c = 12;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696692);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842131;
      ((bbjs)localObject1).c = 5;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696693);
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842127;
      ((bbjs)localObject1).c = 4;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      bduf.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696707);
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130843596;
      ((bbjs)localObject1).c = 20;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    Object localObject2;
    bbjs localbbjs;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (nnr)((Iterator)localObject1).next();
        localbbjs = new bbjs();
        switch (((nnr)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((nnr)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695546);; localbbjs.jdField_a_of_type_JavaLangString = ((nnr)localObject2).jdField_a_of_type_JavaLangString)
          {
            localbbjs.jdField_b_of_type_Int = 2130842133;
            localbbjs.jdField_b_of_type_Boolean = true;
            localbbjs.c = 30;
            localbbjs.jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localbbjs);
            i = 1;
            break;
          }
          localObject2 = new bbjs();
          ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695607);
          ((bbjs)localObject2).jdField_b_of_type_Int = 2130842125;
          ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
          ((bbjs)localObject2).c = 31;
          ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
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
          localObject2 = (nnr)((Iterator)localObject1).next();
          localbbjs = new bbjs();
          switch (((nnr)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nnr)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695546);; localbbjs.jdField_a_of_type_JavaLangString = ((nnr)localObject2).jdField_a_of_type_JavaLangString)
            {
              localbbjs.jdField_b_of_type_Int = 2130842133;
              localbbjs.jdField_b_of_type_Boolean = true;
              localbbjs.c = 37;
              localbbjs.jdField_b_of_type_JavaLangString = "";
              localArrayList2.add(localbbjs);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new bbjs();
            ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696697);
            ((bbjs)localObject2).jdField_b_of_type_Int = 2130842134;
            ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
            ((bbjs)localObject2).c = 35;
            ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (bcfc)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Bcee.a(64);
    if ((localObject1 != null) && (((bcfc)localObject1).a()) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696720);
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842132;
      ((bbjs)localObject1).c = 21;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696682);
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130843388;
      ((bbjs)localObject1).c = 6;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bcfx)this.jdField_a_of_type_Bceh.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.h;
      }
      if (ayee.a((String)localObject1))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696690);
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130849427;
        ((bbjs)localObject1).c = 68;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList2.add(localObject1);
        ayee.a(0, 0);
      }
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696691);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842129;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 7;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696688);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838750;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 1;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696721);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842125;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 8;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if ((localbcfh != null) && (localbcfh.d()))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696703);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842130;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 38;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    if (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696694);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130842117;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 11;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nng
 * JD-Core Version:    0.7.0.1
 */