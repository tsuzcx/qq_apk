import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.ReportCenter;
import java.lang.ref.WeakReference;

class phx
  implements Runnable
{
  phx(phw paramphw, String paramString) {}
  
  public void run()
  {
    Object localObject = (WebUiBaseInterface)this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str1;
    String str2;
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localObject).b()) && (!this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      str1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_Phw.b });
      str2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.jdField_a_of_type_Phw.b });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label429;
      }
    }
    label429:
    for (localObject = this.jdField_a_of_type_Phw.jdField_a_of_type_JavaLangString;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      String str3 = String.format(this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430119), new Object[] { this.jdField_a_of_type_Phw.c });
      ShareMsgHelper.a(this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity, 1001, 1, "struct_msg_from_h5", this.jdField_a_of_type_Phw.b, (String)localObject, this.jdField_a_of_type_Phw.c, this.jdField_a_of_type_Phw.d, str3, this.jdField_a_of_type_Phw.e, "web", null, null, null, "plugin", null, str1, str2, "http://url.cn/JS8oE7", this.jdField_a_of_type_Phw.f, null);
      int j = 0;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        j = 1;
      }
      int i = j;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Phw.d)) {
        i = j | 0x2;
      }
      j = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Phw.c)) {
        j = i | 0x4;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "14");
      ((Bundle)localObject).putString("intext_3", "1");
      ((Bundle)localObject).putString("intext_2", "" + j);
      ((Bundle)localObject).putString("stringext_1", "" + this.jdField_a_of_type_Phw.e);
      ReportCenter.a().a((Bundle)localObject, "", this.jdField_a_of_type_Phw.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phx
 * JD-Core Version:    0.7.0.1
 */