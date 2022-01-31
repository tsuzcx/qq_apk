import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nqo
  extends beir
{
  nqo(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    beir localbeir = (beir)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Beho.a(4);
    if ((localbeir != null) && (localbeir.c()) && (!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696878);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842294;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696873);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838917;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 2;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696886);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838918;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 3;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bkbq.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696887);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838916;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696893);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838921;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696876);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838915;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 10;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((localbeir != null) && (localbeir.b()) && (!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696890);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838920;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696869);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842297;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 5;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696870);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842293;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 4;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      bfyh.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696884);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844027;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    Object localObject2;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (nqz)((Iterator)localObject1).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        switch (((nqz)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((nqz)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695706);; localActionSheetItem.label = ((nqz)localObject2).jdField_a_of_type_JavaLangString)
          {
            localActionSheetItem.icon = 2130842299;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            localArrayList2.add(localActionSheetItem);
            i = 1;
            break;
          }
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131695767);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842291;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 31;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
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
          localObject2 = (nqz)((Iterator)localObject1).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((nqz)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nqz)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695706);; localActionSheetItem.label = ((nqz)localObject2).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.icon = 2130842299;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              localArrayList2.add(localActionSheetItem);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696874);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842300;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (beim)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_Beho.a(64);
    if ((localObject1 != null) && (((beim)localObject1).a()) && (!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696897);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842298;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696859);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843813;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 6;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((bejh)this.jdField_a_of_type_Behr.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.g;
      }
      if (bagk.a((String)localObject1))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696867);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130849939;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList2.add(localObject1);
        bagk.a(0, 0);
      }
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696868);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842295;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 7;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696865);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130838913;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 1;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696898);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842291;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 8;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((localbeir != null) && (localbeir.d()))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696880);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842296;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if (!sxe.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696871);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842283;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 11;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = paramActionSheetItem.action;
    if (i == 7)
    {
      super.onItemClick(paramActionSheetItem, paramShareActionSheet);
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
        super.onItemClick(paramActionSheetItem, paramShareActionSheet);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      azqs.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    azqs.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqo
 * JD-Core Version:    0.7.0.1
 */