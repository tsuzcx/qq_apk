import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kxy
  extends SwiftBrowserShareMenuHandler
{
  kxy(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
    if ((localObject1 != null) && (((SwiftBrowserShareMenuHandler)localObject1).c()) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430138);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840673;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430108);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838336;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 2;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430114);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838337;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 3;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject2);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (ReadInJoyHelper.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject2 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
      if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430128);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838335;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430126);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838340;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430127);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838334;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 10;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (((SwiftBrowserShareMenuHandler)localObject1).b()) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430132);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838339;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430113);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130840675;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 5;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430112);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130840672;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 4;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      QidianManager.a(BaseApplicationImpl.getApplication(), localArrayList);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430131);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841716;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    localObject1 = new ArrayList();
    int i;
    Object localObject3;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.e) && (this.b != null))
    {
      localObject2 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        switch (((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)) {}
          for (localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430016);; localActionSheetItem.jdField_a_of_type_JavaLangString = ((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)
          {
            localActionSheetItem.jdField_b_of_type_Int = 2130840677;
            localActionSheetItem.jdField_a_of_type_Boolean = true;
            localActionSheetItem.c = 30;
            localActionSheetItem.jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject1).add(localActionSheetItem);
            i = 1;
            break;
          }
          localObject3 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430053);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_Int = 2130840671;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_Boolean = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).c = 31;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_JavaLangString = "";
          ((ArrayList)localObject1).add(localObject3);
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
        localObject2 = this.b.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430016);; localActionSheetItem.jdField_a_of_type_JavaLangString = ((PublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.jdField_b_of_type_Int = 2130840677;
              localActionSheetItem.jdField_a_of_type_Boolean = true;
              localActionSheetItem.c = 37;
              localActionSheetItem.jdField_b_of_type_JavaLangString = "";
              ((ArrayList)localObject1).add(localActionSheetItem);
              i = 1;
              break;
            }
          case 3: 
            localObject3 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430139);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_Int = 2130840678;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).c = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject1).add(localObject3);
            i = 1;
          }
        }
      }
    }
    Object localObject2 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(64);
    if ((localObject2 != null) && (((SwiftBrowserScreenShotHandler)localObject2).a()) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430133);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840676;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430124);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130841573;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 6;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430109);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840674;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 7;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430110);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838332;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 1;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430118);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840671;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 8;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    if (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430111);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840663;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 11;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    return (List[])new ArrayList[] { localArrayList, localObject1 };
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder)) {
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
        i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.c;
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
      ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$PublicAccountBrowserFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxy
 * JD-Core Version:    0.7.0.1
 */