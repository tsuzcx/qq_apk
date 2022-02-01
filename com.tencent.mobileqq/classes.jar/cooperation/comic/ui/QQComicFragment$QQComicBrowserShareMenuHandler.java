package cooperation.comic.ui;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicShareReportUtils;
import cooperation.comic.jsp.QQComicJsPlugin;
import cooperation.comic.utils.VipComicUrlHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

class QQComicFragment$QQComicBrowserShareMenuHandler
  extends SwiftBrowserShareMenuHandler
{
  QQComicFragment$QQComicBrowserShareMenuHandler(QQComicFragment paramQQComicFragment) {}
  
  private void a()
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    ColorNoteController localColorNoteController = localQQBrowserActivity.getColorNoteController();
    if (localColorNoteController != null)
    {
      if (localColorNoteController.c()) {
        break label45;
      }
      if (localColorNoteController.b())
      {
        localColorNoteController.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localColorNoteController.i();
    return;
    label45:
    localColorNoteController.f();
  }
  
  private void a(ColorNoteController paramColorNoteController, QQBrowserActivity paramQQBrowserActivity)
  {
    if (paramColorNoteController == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690765);
    QQComicJsPlugin localQQComicJsPlugin = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if (localQQComicJsPlugin != null)
    {
      localObject1 = localQQComicJsPlugin.c;
      localObject2 = localQQComicJsPlugin.d;
    }
    if ((((String)localObject1).isEmpty()) && (this.jdField_a_of_type_CooperationComicUiQQComicFragment.mSwiftTitleUI != null)) {
      if (!this.jdField_a_of_type_CooperationComicUiQQComicFragment.mSwiftTitleUI.a().isEmpty()) {
        localObject1 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.mSwiftTitleUI.a();
      }
    }
    for (;;)
    {
      if (((String)localObject2).isEmpty()) {
        if (((String)localObject1).equals(localObject3)) {
          localObject2 = paramQQBrowserActivity.getOriginalUrl();
        }
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = paramQQBrowserActivity.getOriginalUrl();
          paramQQBrowserActivity = VipComicUrlHelper.a(VipComicUrlHelper.b((String)localObject3, "from", "1041001"), "from", "1041001");
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "originalUrl is " + (String)localObject3 + " ,newUrl is " + paramQQBrowserActivity);
          }
          localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("colorNoteType", 2);
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewFragment", 2, "ColorNote mainTitle is " + (String)localObject1 + ",subTitle is " + (String)localObject2 + ",subType is " + paramQQBrowserActivity);
            }
            paramColorNoteController.a(new QQComicFragment.QQComicBrowserShareMenuHandler.1(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
            return;
            localObject1 = localObject3;
            break;
            localObject2 = localObject3;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    String str1 = localObject[0];
    String str2 = localObject[1];
    String str3 = localObject[2];
    String str4 = localObject[3];
    String str5 = localObject[4];
    VipComicShareReportUtils.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "6", str4, str5);
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      VipComicShareReportUtils.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, str5);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      VipComicShareReportUtils.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "2", str4, str5);
    }
    boolean bool = WXShareHelper.a().a();
    if (((this.jdField_a_of_type_Long & 0x4000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      VipComicShareReportUtils.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "3", str4, str5);
    }
    if (((this.jdField_a_of_type_Long & 0x8000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      VipComicShareReportUtils.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "4", str4, str5);
    }
    ArrayList localArrayList2 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
      VipComicShareReportUtils.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, str5);
    }
    QQComicJsPlugin localQQComicJsPlugin = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    int i;
    int j;
    if ((localQQComicJsPlugin != null) && (localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0))
    {
      if (localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
        break label644;
      }
      i = 1;
      if (i == 0) {
        break label649;
      }
      j = 117;
      label368:
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(j));
      if (i == 0) {
        break label655;
      }
    }
    label644:
    label649:
    label655:
    for (localObject = "5";; localObject = "4")
    {
      VipComicShareReportUtils.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, (String)localObject, str4, str5);
      localObject = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str6 = ((QQBrowserActivity)localObject).getOriginalUrl();
      if ((str6 != null) && (str6.indexOf("cancelColorTab=1") == -1))
      {
        ColorNoteController localColorNoteController = ((QQBrowserActivity)localObject).getColorNoteController();
        a(localColorNoteController, (QQBrowserActivity)localObject);
        if ((localColorNoteController != null) && (localColorNoteController.a()) && (!ColorNoteUtils.c(str6)))
        {
          i = 70;
          localObject = "2";
          if (localColorNoteController.c())
          {
            i = 82;
            localObject = "3";
          }
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
          VipComicShareReportUtils.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, (String)localObject, str4, str5);
        }
      }
      if ((localQQComicJsPlugin != null) && ((localQQComicJsPlugin.jdField_a_of_type_Int & 0x2) > 0))
      {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        VipComicShareReportUtils.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "9", str4, str5);
      }
      if ((localQQComicJsPlugin != null) && ((localQQComicJsPlugin.jdField_a_of_type_Int & 0x1) > 0))
      {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
        VipComicShareReportUtils.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "10", str4, str5);
      }
      return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      i = 0;
      break;
      j = 116;
      break label368;
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int j = paramActionSheetItem.action;
    paramShareActionSheet = a();
    Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    String str1 = localObject[0];
    String str2 = localObject[1];
    String str3 = localObject[2];
    String str4 = localObject[3];
    localObject = localObject[4];
    if ((j == 2) || (j == 73)) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
            return;
            if (j == 3)
            {
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 2, false);
                return;
              }
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 2, false);
              return;
            }
            if ((j == 9) || (j == 10))
            {
              int i = -1;
              if (!WXShareHelper.a().a()) {
                i = 2131720753;
              }
              while (i != -1)
              {
                QRUtils.a(0, i);
                return;
                if (!WXShareHelper.a().b()) {
                  i = 2131720754;
                }
              }
              if (j == 9)
              {
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
                {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 3, true);
                  return;
                }
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 3, true);
                return;
              }
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 4, true);
                return;
              }
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 4, true);
              return;
            }
            if (j != 14) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p));
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "6" });
          VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, (String)localObject);
          return;
          if (j == 117)
          {
            VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "5", str4, (String)localObject);
            this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
            return;
          }
          if (j == 116)
          {
            VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "4", str4, (String)localObject);
            this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
            return;
          }
          if (j == 70)
          {
            VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "2", str4, (String)localObject);
            a();
            return;
          }
          if (j == 82)
          {
            VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "3", str4, (String)localObject);
            a();
            return;
          }
          if (j != 72) {
            break;
          }
          if (this.jdField_a_of_type_AndroidOsBundle == null) {
            this.jdField_a_of_type_AndroidOsBundle = new Bundle();
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("to_qq", paramActionSheetItem.uin);
          this.jdField_a_of_type_AndroidOsBundle.putString("to_uin_name", paramActionSheetItem.label);
          this.jdField_a_of_type_AndroidOsBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a == null);
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().show();
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { String.valueOf(101) });
        return;
        if (j != 40) {
          break;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p));
      VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "10", str4, (String)localObject);
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "7" });
      return;
    } while ((j != 11) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)));
    VipComicShareReportUtils.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "9", str4, (String)localObject);
    this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "8" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment.QQComicBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */