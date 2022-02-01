import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ojz
  extends biho
{
  private ojz(oju paramoju) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    biho localbiho = (biho)this.jdField_a_of_type_Oju.mComponentsProvider.a(4);
    if ((localbiho != null) && (localbiho.c()) && (!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696135);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842692;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(2);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718663);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846269;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(3);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696143);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846275;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bmhv.a()) && (this.jdField_a_of_type_Oju.mApp != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_Oju.mApp.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696144);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839145;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(9);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696150);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846279;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696133);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846281;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((localbiho != null) && (localbiho.b()) && (!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696147);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839149;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(5);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718662);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846260;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(4);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718751);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846263;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      bjxa.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696141);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844390;
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
        localObject2 = (okk)((Iterator)localObject1).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        switch (((okk)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((okk)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131694963);; localActionSheetItem.label = ((okk)localObject2).jdField_a_of_type_JavaLangString)
          {
            localActionSheetItem.icon = 2130842697;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            localArrayList2.add(localActionSheetItem);
            i = 1;
            break;
          }
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131695016);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842689;
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
          localObject2 = (okk)((Iterator)localObject1).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((okk)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((okk)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131694963);; localActionSheetItem.label = ((okk)localObject2).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.icon = 2130842697;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              localArrayList2.add(localActionSheetItem);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696131);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842698;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (bihj)this.jdField_a_of_type_Oju.mComponentsProvider.a(64);
    if ((localObject1 != null) && (((bihj)localObject1).a()) && (!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696154);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842696;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(6);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696116);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846315;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.mComponentContext.a().a(2)).mUIStyle.mWWVRulesFromUrl & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Oju.mUrl;
      }
      if (beaz.a((String)localObject1))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696124);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130850575;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList2.add(localObject1);
        beaz.a(0, 0);
      }
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(7);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696125);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846298;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(1);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696122);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846309;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696155);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842689;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 8;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((localbiho != null) && (localbiho.d()))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696137);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842694;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if (!uta.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(11);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696128);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846341;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
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
      this.jdField_a_of_type_Oju.a(i);
    }
    do
    {
      do
      {
        return;
        if (i == 8)
        {
          this.jdField_a_of_type_Oju.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Oju.a(i);
          return;
        }
        super.onItemClick(paramActionSheetItem, paramShareActionSheet);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_Oju.mApp == null);
      bdla.b(null, "CliOper", "", this.jdField_a_of_type_Oju.mApp.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_Oju.mApp == null));
    bdla.b(null, "CliOper", "", this.jdField_a_of_type_Oju.mApp.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojz
 * JD-Core Version:    0.7.0.1
 */