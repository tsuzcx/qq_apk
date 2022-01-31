package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import behq;
import behr;
import bejl;
import bekg;
import beki;
import bekp;
import bekr;
import bekz;
import bely;
import berl;
import besj;
import besl;
import betc;
import bfhk;
import bfhp;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareJsPlugin
  extends BaseJsPlugin
{
  private static final int ACTION_SHEET_DEFAULT_TYPE = 0;
  public static final int Custom_Ark = 2;
  public static final int MiniApp = 0;
  public static final int MiniGame = 1;
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final int QQ_ARK = 0;
  public static final int QQ_Qzone = 1;
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_MENU_STATE_NEED_HIDE = 0;
  public static final int SHARE_MENU_STATE_NEED_SHOW = 1;
  public static final int SHARE_MENU_STATE_UNDEFINED = -1;
  private static final String TAG = "ShareJsPlugin";
  public static final int UNDEFINED = -1;
  public static final int Weixin_Aio = 3;
  public static final int Weixin_pengyouquan = 4;
  private final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  public void hideShareMenu(bekr parambekr)
  {
    int i = -1;
    int m = 0;
    for (;;)
    {
      int j;
      int k;
      int n;
      try
      {
        localObject = (JSONArray)new JSONObject(parambekr.jdField_b_of_type_JavaLangString).opt("hideShareItems");
        if (localObject != null) {
          break label192;
        }
        j = -1;
        k = 0;
        localObject = (besl)this.mMiniAppContext.a(beki.a());
        if (m == 0) {
          ((besl)localObject).e = false;
        }
        if (k == 0) {
          ((besl)localObject).d = false;
        }
        if (j == 0) {
          ((besl)localObject).f = false;
        }
        if (i == 0) {
          ((besl)localObject).g = false;
        }
        parambekr.a();
        return;
      }
      catch (JSONException parambekr)
      {
        Object localObject;
        String str;
        boolean bool;
        parambekr.printStackTrace();
        return;
      }
      if (n < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).getString(n);
        if (str.equalsIgnoreCase("qq")) {
          m = 0;
        }
        if (str.equalsIgnoreCase("qzone")) {
          k = 0;
        }
        if (str.equalsIgnoreCase("wechatFriends")) {
          j = 1;
        }
        bool = str.equalsIgnoreCase("wechatMoment");
        if (bool) {
          i = 1;
        }
        n += 1;
      }
      else
      {
        continue;
        label192:
        n = 0;
        j = -1;
        k = -1;
        m = -1;
      }
    }
  }
  
  public void shareAppMessage(bekr parambekr)
  {
    int k;
    int j;
    besl localbesl;
    Object localObject2;
    int i;
    label69:
    String str1;
    label130:
    label136:
    String str5;
    label235:
    besj localbesj;
    for (;;)
    {
      Object localObject3;
      try
      {
        if (!"shareAppMessageDirectly".equals(parambekr.jdField_a_of_type_JavaLangString)) {
          break label1127;
        }
        k = 1;
        localObject3 = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
        j = ((JSONObject)localObject3).optInt("shareTarget", -1);
        localObject1 = null;
        localbesl = (besl)this.mMiniAppContext.a(beki.a());
        if (j != 0) {
          break label1134;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        String str3 = ((JSONObject)localObject3).optString("shareTemplateId");
        String str4 = ((JSONObject)localObject3).optString("shareTemplateData");
        if (!"shareAppMessageDirectly".equals(parambekr.jdField_a_of_type_JavaLangString)) {
          break label1111;
        }
        if (i != -1) {
          break label1100;
        }
        i = this.mShareProxy.getDefaultShareTarget();
        if ((i < 100) || (i > 200)) {
          break label1174;
        }
        j = 6;
        localbesl.jdField_b_of_type_Int = j;
        localbesl.jdField_a_of_type_JavaLangString = parambekr.jdField_a_of_type_JavaLangString;
        localbesl.c = parambekr.jdField_b_of_type_Int;
        String str2 = ((JSONObject)localObject3).optString("path");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = ((JSONObject)localObject3).optString("query");
        }
        str2 = ((JSONObject)localObject3).optString("title");
        str5 = ((JSONObject)localObject3).optString("imageUrl");
        localObject3 = ((JSONObject)localObject3).optString("generalWebpageUrl");
        if (!TextUtils.isEmpty(str1)) {
          break label1097;
        }
        if (!this.mMiniAppContext.e()) {
          break label659;
        }
        str1 = "miniGamePath";
        parambekr = new ShareJsPlugin.1(this, parambekr);
        localbesj = new besj();
        localbesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppContext.a();
        if (k == 0) {
          break label1181;
        }
        j = 11;
        label276:
        localbesj.jdField_a_of_type_Int = j;
        localbesj.jdField_b_of_type_Int = i;
        localbesj.jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
        localbesj.jdField_a_of_type_JavaLangString = str2;
        localbesj.c = str1;
        localbesj.d = ((String)localObject3);
        localbesj.e = str3;
        localbesj.f = str4;
        localbesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = ((EntryModel)localObject2);
        localbesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = ((ShareChatModel)localObject1);
        localbesj.jdField_b_of_type_Boolean = localbesl.h;
        if (localbesl.jdField_b_of_type_Int != 1) {
          break label737;
        }
        if ((!str5.startsWith("http")) && (!str5.startsWith("https"))) {
          break;
        }
        localbesj.jdField_b_of_type_JavaLangString = str5;
        this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
        return;
      }
      catch (JSONException parambekr)
      {
        label410:
        betc.d("ShareJsPlugin", parambekr.getMessage(), parambekr);
        parambekr.printStackTrace();
        return;
      }
      if (j == 2)
      {
        localObject2 = this.mMiniAppInfo;
        str1 = ((JSONObject)localObject3).optString("entryDataHash");
        if ((str1 != null) && (((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null) && (str1.equals(((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a())))
        {
          localObject1 = ((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel;
          break label1150;
        }
        betc.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + str1);
        break label1150;
      }
      if (j == 3)
      {
        localObject1 = null;
        localObject2 = null;
        i = 3;
      }
      else if (j == 4)
      {
        localObject1 = null;
        localObject2 = null;
        i = 4;
      }
      else
      {
        if (j == 5)
        {
          localObject2 = ((JSONObject)localObject3).optString("chatDataHash");
          localObject1 = localbesl.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel;
          if ((localObject1 != null) && (((ShareChatModel)localObject1).a().equals(localObject2))) {
            break label1166;
          }
          betc.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + null);
          localObject1 = null;
          break label1166;
        }
        if ((j != 6) || (!"shareAppMessageDirectlyToFriendList".equals(parambekr.jdField_a_of_type_JavaLangString))) {
          break label1116;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        continue;
        label659:
        str1 = this.mApkgInfo.a().jdField_a_of_type_JavaLangString;
      }
    }
    Object localObject1 = bejl.a().a(str5);
    if (!bely.a((String)localObject1))
    {
      localbesj.jdField_b_of_type_JavaLangString = ((String)localObject1);
      this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
      return;
    }
    this.mMiniAppContext.a(bekg.a(new ShareJsPlugin.2(this, localbesj, parambekr)));
    return;
    label737:
    if (localbesl.jdField_b_of_type_Int == 3)
    {
      localbesj.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
      return;
    }
    if (localbesl.jdField_b_of_type_Int == 4)
    {
      localbesj.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
      return;
    }
    if (!URLUtil.isHttpUrl(str5))
    {
      if (!URLUtil.isHttpsUrl(str5)) {
        break label1193;
      }
      break label1187;
      label824:
      if ((TextUtils.isEmpty(str5)) || (!new File(bejl.a().a(str5)).exists())) {
        break label1199;
      }
    }
    label1166:
    label1174:
    label1181:
    label1187:
    label1193:
    label1199:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bely.a(str5)) || ((!bool1) && (!bool2)))
      {
        if (this.mMiniAppContext.e())
        {
          localbesj.jdField_b_of_type_JavaLangString = bfhp.a();
          this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
          betc.d("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + str5 + "], use default share image");
          return;
        }
        if (this.mMiniAppContext.a(beki.a()) != null)
        {
          if (((besl)this.mMiniAppContext.a(beki.a())).i)
          {
            betc.d("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bekg.a(new ShareJsPlugin.3(this, localbesj, parambekr)));
        }
      }
      else
      {
        if ((str5.startsWith("http")) || (str5.startsWith("https")))
        {
          localbesj.jdField_b_of_type_JavaLangString = str5;
          this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
          return;
        }
        localbesj.jdField_b_of_type_JavaLangString = bejl.a().a(str5);
        this.mShareProxy.onJsShareAppMessage(localbesj, parambekr);
        return;
        label1097:
        break label235;
        label1100:
        int m = i;
        i = j;
        j = m;
        break label130;
        label1111:
        i = j;
        break label136;
        label1116:
        localObject1 = null;
        localObject2 = null;
        i = -1;
        break label69;
        label1127:
        k = 0;
        break;
      }
      return;
      label1134:
      if (j != 1) {
        break label410;
      }
      localObject1 = null;
      localObject2 = null;
      i = 1;
      break label69;
      label1150:
      str1 = null;
      localObject2 = localObject1;
      i = 0;
      localObject1 = str1;
      break label69;
      localObject2 = null;
      i = 0;
      break label69;
      j = 0;
      i = 0;
      break label130;
      j = 12;
      break label276;
      boolean bool1 = true;
      break label824;
      bool1 = false;
      break label824;
    }
  }
  
  public void shareAppMessageDirectly(bekr parambekr)
  {
    if (bfhk.a())
    {
      shareAppMessage(parambekr);
      return;
    }
    this.mMiniAppProxy.onCapsuleButtonMoreClick(new behr(this.mMiniAppContext));
  }
  
  public void shareAppPictureMessage(bekr parambekr)
  {
    int i = 3;
    Object localObject1;
    Object localObject2;
    int j;
    try
    {
      localObject1 = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
      k = ((JSONObject)localObject1).optInt("shareTarget", -1);
      if (k != 0) {
        break label507;
      }
      i = 0;
      localObject2 = (besl)this.mMiniAppContext.a(beki.a());
      j = k;
      if ("shareAppPictureMessageDirectly".equals(parambekr.jdField_a_of_type_JavaLangString))
      {
        j = k;
        k = i;
        if (i == -1)
        {
          j = this.mShareProxy.getDefaultShareTarget();
          if ((j < 100) || (j > 200)) {
            break label546;
          }
          k = 6;
        }
        label103:
        ((besl)localObject2).jdField_b_of_type_Int = k;
      }
      i = ((besl)localObject2).jdField_b_of_type_Int;
      ((besl)localObject2).jdField_a_of_type_JavaLangString = parambekr.jdField_a_of_type_JavaLangString;
      ((besl)localObject2).c = parambekr.jdField_b_of_type_Int;
      parambekr = new ShareJsPlugin.4(this, parambekr);
      this.mMiniAppContext.a();
      localObject2 = this.mApkgInfo;
      localObject2 = ((JSONObject)localObject1).optString("title");
      str1 = ((JSONObject)localObject1).optString("imageUrl");
      if (URLUtil.isHttpUrl(str1)) {
        break label501;
      }
      if (!URLUtil.isHttpsUrl(str1)) {
        break label554;
      }
    }
    catch (JSONException parambekr)
    {
      String str1;
      label197:
      parambekr.printStackTrace();
      return;
    }
    String str2 = bejl.a().a(str1);
    if ((!TextUtils.isEmpty(str1)) && (new File(str2).exists())) {}
    for (int k = 1;; k = 0)
    {
      localObject1 = new besj();
      ((besj)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppInfo;
      ((besj)localObject1).jdField_a_of_type_Int = 11;
      ((besj)localObject1).jdField_b_of_type_Int = j;
      ((besj)localObject1).jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
      ((besj)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (i != 0)
      {
        ((besj)localObject1).jdField_b_of_type_JavaLangString = str1;
        ((besj)localObject1).jdField_a_of_type_Boolean = false;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambekr);
        return;
      }
      if ((bely.a(str1)) || ((i == 0) && (k == 0)))
      {
        if (this.mMiniAppContext.e())
        {
          if (this.mMiniAppInfo != null)
          {
            ((besj)localObject1).jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
            ((besj)localObject1).jdField_a_of_type_Boolean = false;
            this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambekr);
            return;
          }
          betc.d("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
          return;
        }
        localObject2 = (besl)this.mMiniAppContext.a(beki.a());
        if (localObject2 != null)
        {
          if (((besl)localObject2).i)
          {
            betc.d("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bekg.a(new ShareJsPlugin.5(this, (besj)localObject1, parambekr)));
        }
      }
      else if ((i == 0) && (k != 0))
      {
        ((besj)localObject1).jdField_b_of_type_JavaLangString = str2;
        ((besj)localObject1).jdField_a_of_type_Boolean = true;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambekr);
        return;
      }
      label501:
      label507:
      do
      {
        i = -1;
        break;
        i = 1;
        break label197;
        return;
        if (k == 1)
        {
          i = 1;
          break;
        }
        if (k == 2)
        {
          i = 0;
          break;
        }
        if (k == 3) {
          break;
        }
      } while (k != 4);
      i = 4;
      break;
      label546:
      k = 0;
      j = 0;
      break label103;
      label554:
      i = 0;
      break label197;
    }
  }
  
  public void shareAppPictureMessageDirectly(bekr parambekr)
  {
    if (bfhk.a())
    {
      shareAppPictureMessage(parambekr);
      return;
    }
    this.mMiniAppProxy.onCapsuleButtonMoreClick(new behr(this.mMiniAppContext));
  }
  
  public void showActionSheet(bekr parambekr)
  {
    bekz.a(new ShareJsPlugin.6(this, parambekr));
  }
  
  public void showShareMenu(bekr parambekr)
  {
    boolean bool3 = true;
    boolean bool1;
    Object localObject;
    if ((parambekr.jdField_b_of_type_JavaLangString == null) || ("null".equals(parambekr.jdField_b_of_type_JavaLangString)) || ("{}".equals(parambekr.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      j = 1;
      k = 1;
      m = 1;
      bool1 = false;
      localObject = (besl)this.mMiniAppContext.a(beki.a());
      if (m != 1) {
        break label434;
      }
      bool2 = true;
      label75:
      ((besl)localObject).e = bool2;
      if (k != 1) {
        break label440;
      }
      bool2 = true;
      label91:
      ((besl)localObject).d = bool2;
      if (j != 1) {
        break label446;
      }
      bool2 = true;
      label106:
      ((besl)localObject).f = bool2;
      if (i != 1) {
        break label452;
      }
    }
    label274:
    label290:
    label434:
    label440:
    label446:
    label452:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      ((besl)localObject).g = bool2;
      ((besl)localObject).h = bool1;
      parambekr.a();
      return;
      for (;;)
      {
        for (;;)
        {
          int n;
          try
          {
            localObject = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
            bool1 = ((JSONObject)localObject).optBoolean("withShareTicket", false);
          }
          catch (JSONException localJSONException1)
          {
            int i1;
            int i2;
            String str;
            m = -1;
            k = -1;
            j = -1;
            bool1 = false;
            i = -1;
          }
          try
          {
            localObject = (JSONArray)((JSONObject)localObject).opt("showShareItems");
            if (localObject == null)
            {
              i = 1;
              k = 1;
              i1 = 1;
              i2 = 1;
              m = i2;
              j = k;
              k = i1;
              break;
            }
            n = 0;
            m = -1;
            i = -1;
            k = -1;
            j = -1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              m = -1;
              k = -1;
              j = -1;
              i = -1;
            }
          }
        }
        for (;;)
        {
          try
          {
            if (n < ((JSONArray)localObject).length())
            {
              str = ((JSONArray)localObject).getString(n);
              bool2 = str.equalsIgnoreCase("qq");
              if (!bool2) {
                continue;
              }
              j = 1;
            }
          }
          catch (JSONException localJSONException3)
          {
            break label397;
            break;
          }
          try
          {
            bool2 = str.equalsIgnoreCase("qzone");
            if (!bool2) {
              continue;
            }
            k = 1;
          }
          catch (JSONException localJSONException4)
          {
            break label397;
            break label274;
          }
          try
          {
            bool2 = str.equalsIgnoreCase("wechatFriends");
            if (!bool2) {
              continue;
            }
            i = 1;
          }
          catch (JSONException localJSONException5)
          {
            break label397;
            break label290;
          }
        }
        try
        {
          bool2 = str.equalsIgnoreCase("wechatMoment");
          if (bool2) {
            m = 1;
          }
          n += 1;
        }
        catch (JSONException localJSONException6)
        {
          break label397;
          i3 = i;
          continue;
        }
        n = j;
        if (j == -1) {
          n = 0;
        }
        j = k;
        if (k == -1) {
          j = 0;
        }
        if (i != -1) {
          break label493;
        }
        i3 = 0;
        k = i3;
        i = m;
        i1 = j;
        i2 = n;
        if (m == -1)
        {
          i = 0;
          k = i3;
          i1 = j;
          i2 = n;
        }
      }
      localJSONException1.printStackTrace();
      betc.d("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      parambekr.b();
      n = j;
      j = i;
      i = m;
      m = n;
      break;
      bool2 = false;
      break label75;
      bool2 = false;
      break label91;
      bool2 = false;
      break label106;
    }
  }
  
  public void updateShareMenuShareTicket(bekr parambekr)
  {
    try
    {
      boolean bool = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optBoolean("withShareTicket", false);
      ((besl)this.mMiniAppContext.a(beki.a())).h = bool;
      parambekr.a();
      return;
    }
    catch (JSONException parambekr)
    {
      betc.d("ShareJsPlugin", parambekr.getMessage(), parambekr);
      parambekr.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */