package cooperation.qwallet.plugin;

import adpn;
import aivo;
import aixs;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QWalletPrivacyUtils
{
  public static final String BACK_URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201802/upload_895b44a9069ca68cb5c84439c7e1d2aa.jpg";
  public static final String TAG = "QWalletPrivacyUtils";
  
  public static boolean isOpenPrivacyDialog(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramBaseActivity == null)) {
      return false;
    }
    boolean bool = aivo.a(paramQQAppInterface.c(), "privacy_has_click_agree", false);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPrivacyUtils", 2, "hasClickAgree" + bool);
    }
    if (bool) {
      return false;
    }
    aixs localaixs = (aixs)paramQQAppInterface.getManager(245);
    if (localaixs != null)
    {
      if (localaixs.a("privacy", 0, new String[] { "switch" }) == 1)
      {
        i = 1;
        if (i == 0) {
          break label232;
        }
        if (localaixs.a("session", 0, new String[] { "1" }) != 1) {
          break label146;
        }
      }
      label146:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label151;
        }
        aivo.a(paramQQAppInterface.getAccount(), "privacy_has_click_agree", true);
        return false;
        i = 0;
        break;
      }
      label151:
      paramQQAppInterface = localaixs.a("privacy", "", new String[] { "title" });
      String str = localaixs.a("privacy", "", new String[] { "content" });
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(str)))
      {
        startPrivacyDialogActivity(paramBaseActivity, paramQQAppInterface, str, localaixs.a("privacy", "https://i.gtimg.cn/channel/imglib/201802/upload_895b44a9069ca68cb5c84439c7e1d2aa.jpg", new String[] { "background" }));
        return true;
      }
    }
    label232:
    return false;
  }
  
  public static void setHasClickAgree(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      aivo.a(paramAppRuntime.getAccount(), "privacy_has_click_agree", true);
      paramAppRuntime = (aixs)paramAppRuntime.getManager(245);
      if (paramAppRuntime != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("1", "1");
        paramAppRuntime.a(localHashMap);
      }
    }
  }
  
  private static void startPrivacyDialogActivity(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    localIntent.putExtra("background", paramString3);
    adpn.a(paramBaseActivity, localIntent, PublicTransFragmentActivity.class, QWalletPrivacyFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPrivacyUtils
 * JD-Core Version:    0.7.0.1
 */