package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import bdcz;
import bdeu;
import bdfp;
import bdfr;
import bdfx;
import bdfz;
import bdgb;
import bdgi;
import bdhe;
import bdml;
import bdng;
import bdnw;
import bdzi;
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
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  public void hideShareMenu(bdfz parambdfz)
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
        localObject = (JSONArray)new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).opt("hideShareItems");
        if (localObject != null) {
          break label192;
        }
        j = -1;
        k = 0;
        localObject = (bdgb)this.mMiniAppContext.a(bdfr.a());
        if (m == 0) {
          ((bdgb)localObject).e = false;
        }
        if (k == 0) {
          ((bdgb)localObject).d = false;
        }
        if (j == 0) {
          ((bdgb)localObject).f = false;
        }
        if (i == 0) {
          ((bdgb)localObject).g = false;
        }
        parambdfz.a();
        return;
      }
      catch (JSONException parambdfz)
      {
        Object localObject;
        String str;
        boolean bool;
        parambdfz.printStackTrace();
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
  
  public void shareAppMessage(bdfz parambdfz)
  {
    int j;
    int k;
    bdgb localbdgb;
    Object localObject2;
    int i;
    label70:
    int m;
    label110:
    label117:
    String str1;
    String str5;
    label216:
    bdng localbdng;
    for (;;)
    {
      Object localObject3;
      try
      {
        if (!"shareAppMessageDirectly".equals(parambdfz.jdField_a_of_type_JavaLangString)) {
          break label1111;
        }
        j = 1;
        localObject3 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
        k = ((JSONObject)localObject3).optInt("shareTarget", -1);
        localObject1 = null;
        localbdgb = (bdgb)this.mMiniAppContext.a(bdfr.a());
        if (k != 0) {
          break label1117;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        String str3 = ((JSONObject)localObject3).optString("shareTemplateId");
        String str4 = ((JSONObject)localObject3).optString("shareTemplateData");
        if (!"shareAppMessageDirectly".equals(parambdfz.jdField_a_of_type_JavaLangString)) {
          break label1094;
        }
        if (i != -1) {
          break label1085;
        }
        m = 0;
        i = 0;
        localbdgb.jdField_b_of_type_Int = m;
        localbdgb.jdField_a_of_type_JavaLangString = parambdfz.jdField_a_of_type_JavaLangString;
        localbdgb.c = parambdfz.jdField_b_of_type_Int;
        String str2 = ((JSONObject)localObject3).optString("path");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = ((JSONObject)localObject3).optString("query");
        }
        str2 = ((JSONObject)localObject3).optString("title");
        str5 = ((JSONObject)localObject3).optString("imageUrl");
        localObject3 = ((JSONObject)localObject3).optString("generalWebpageUrl");
        if (!TextUtils.isEmpty(str1)) {
          break label1082;
        }
        if (!this.mMiniAppContext.e()) {
          break label644;
        }
        str1 = "miniGamePath";
        parambdfz = new ShareJsPlugin.1(this, parambdfz);
        localbdng = new bdng();
        localbdng.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppContext.a();
        if (j == 0) {
          break label1158;
        }
        j = 11;
        label256:
        localbdng.jdField_a_of_type_Int = j;
        localbdng.jdField_b_of_type_Int = i;
        localbdng.jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
        localbdng.jdField_a_of_type_JavaLangString = str2;
        localbdng.c = str1;
        localbdng.d = ((String)localObject3);
        localbdng.e = str3;
        localbdng.f = str4;
        localbdng.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = ((EntryModel)localObject2);
        localbdng.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = ((ShareChatModel)localObject1);
        localbdng.jdField_b_of_type_Boolean = localbdgb.h;
        if (localbdgb.jdField_b_of_type_Int != 1) {
          break label722;
        }
        if ((!str5.startsWith("http")) && (!str5.startsWith("https"))) {
          break;
        }
        localbdng.jdField_b_of_type_JavaLangString = str5;
        this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
        return;
      }
      catch (JSONException parambdfz)
      {
        label390:
        bdnw.d("ShareJsPlugin", parambdfz.getMessage(), parambdfz);
        parambdfz.printStackTrace();
        return;
      }
      if (k == 2)
      {
        localObject2 = this.mMiniAppInfo;
        str1 = ((JSONObject)localObject3).optString("entryDataHash");
        if ((str1 != null) && (((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null) && (str1.equals(((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a())))
        {
          localObject1 = ((MiniAppInfo)localObject2).launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel;
          break label1134;
        }
        bdnw.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + str1);
        break label1134;
      }
      if (k == 3)
      {
        localObject1 = null;
        localObject2 = null;
        i = 3;
      }
      else if (k == 4)
      {
        localObject1 = null;
        localObject2 = null;
        i = 4;
      }
      else
      {
        if (k == 5)
        {
          localObject2 = ((JSONObject)localObject3).optString("chatDataHash");
          localObject1 = localbdgb.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel;
          if ((localObject1 != null) && (((ShareChatModel)localObject1).a().equals(localObject2))) {
            break label1150;
          }
          bdnw.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + null);
          localObject1 = null;
          break label1150;
        }
        if ((k != 6) || (!"shareAppMessageDirectlyToFriendList".equals(parambdfz.jdField_a_of_type_JavaLangString))) {
          break label1100;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        continue;
        label644:
        str1 = this.mApkgInfo.a().jdField_a_of_type_JavaLangString;
      }
    }
    Object localObject1 = bdeu.a().a(str5);
    if (!bdhe.a((String)localObject1))
    {
      localbdng.jdField_b_of_type_JavaLangString = ((String)localObject1);
      this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
      return;
    }
    this.mMiniAppContext.a(bdfp.a(new ShareJsPlugin.2(this, localbdng, parambdfz)));
    return;
    label722:
    if (localbdgb.jdField_b_of_type_Int == 3)
    {
      localbdng.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
      return;
    }
    if (localbdgb.jdField_b_of_type_Int == 4)
    {
      localbdng.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
      return;
    }
    if (!URLUtil.isHttpUrl(str5))
    {
      if (!URLUtil.isHttpsUrl(str5)) {
        break label1170;
      }
      break label1164;
      label809:
      if ((TextUtils.isEmpty(str5)) || (!new File(bdeu.a().a(str5)).exists())) {
        break label1176;
      }
    }
    label1158:
    label1164:
    label1170:
    label1176:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bdhe.a(str5)) || ((!bool1) && (!bool2)))
      {
        if (this.mMiniAppContext.e())
        {
          localbdng.jdField_b_of_type_JavaLangString = bdzi.a();
          this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
          bdnw.d("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + str5 + "], use default share image");
          return;
        }
        if (this.mMiniAppContext.a(bdfr.a()) != null)
        {
          if (((bdgb)this.mMiniAppContext.a(bdfr.a())).i)
          {
            bdnw.d("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bdfp.a(new ShareJsPlugin.3(this, localbdng, parambdfz)));
        }
      }
      else
      {
        if ((str5.startsWith("http")) || (str5.startsWith("https")))
        {
          localbdng.jdField_b_of_type_JavaLangString = str5;
          this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
          return;
        }
        localbdng.jdField_b_of_type_JavaLangString = bdeu.a().a(str5);
        this.mShareProxy.onJsShareAppMessage(localbdng, parambdfz);
        return;
        label1082:
        break label216;
        label1085:
        m = i;
        i = k;
        break label110;
        label1094:
        i = k;
        break label117;
        label1100:
        localObject1 = null;
        localObject2 = null;
        i = -1;
        break label70;
        label1111:
        j = 0;
        break;
      }
      return;
      label1117:
      if (k != 1) {
        break label390;
      }
      localObject1 = null;
      localObject2 = null;
      i = 1;
      break label70;
      label1134:
      str1 = null;
      localObject2 = localObject1;
      i = 0;
      localObject1 = str1;
      break label70;
      label1150:
      localObject2 = null;
      i = 0;
      break label70;
      j = 12;
      break label256;
      boolean bool1 = true;
      break label809;
      bool1 = false;
      break label809;
    }
  }
  
  public void shareAppPictureMessage(bdfz parambdfz)
  {
    int i = 3;
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      k = ((JSONObject)localObject1).optInt("shareTarget", -1);
      if (k != 0) {
        break label485;
      }
      i = 0;
      localObject2 = (bdgb)this.mMiniAppContext.a(bdfr.a());
      j = k;
      if ("shareAppPictureMessageDirectly".equals(parambdfz.jdField_a_of_type_JavaLangString))
      {
        j = k;
        k = i;
        if (i == -1)
        {
          k = 0;
          j = 0;
        }
        ((bdgb)localObject2).jdField_b_of_type_Int = k;
      }
      i = ((bdgb)localObject2).jdField_b_of_type_Int;
      ((bdgb)localObject2).jdField_a_of_type_JavaLangString = parambdfz.jdField_a_of_type_JavaLangString;
      ((bdgb)localObject2).c = parambdfz.jdField_b_of_type_Int;
      parambdfz = new ShareJsPlugin.4(this, parambdfz);
      this.mMiniAppContext.a();
      localObject2 = this.mApkgInfo;
      localObject2 = ((JSONObject)localObject1).optString("title");
      str1 = ((JSONObject)localObject1).optString("imageUrl");
      if (URLUtil.isHttpUrl(str1)) {
        break label479;
      }
      if (!URLUtil.isHttpsUrl(str1)) {
        break label524;
      }
    }
    catch (JSONException parambdfz)
    {
      int j;
      String str1;
      label175:
      parambdfz.printStackTrace();
      return;
    }
    String str2 = bdeu.a().a(str1);
    if ((!TextUtils.isEmpty(str1)) && (new File(str2).exists())) {}
    for (int k = 1;; k = 0)
    {
      localObject1 = new bdng();
      ((bdng)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppInfo;
      ((bdng)localObject1).jdField_a_of_type_Int = 11;
      ((bdng)localObject1).jdField_b_of_type_Int = j;
      ((bdng)localObject1).jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
      ((bdng)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (i != 0)
      {
        ((bdng)localObject1).jdField_b_of_type_JavaLangString = str1;
        ((bdng)localObject1).jdField_a_of_type_Boolean = false;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambdfz);
        return;
      }
      if ((bdhe.a(str1)) || ((i == 0) && (k == 0)))
      {
        if (this.mMiniAppContext.e())
        {
          if (this.mMiniAppInfo != null)
          {
            ((bdng)localObject1).jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
            ((bdng)localObject1).jdField_a_of_type_Boolean = false;
            this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambdfz);
            return;
          }
          bdnw.d("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
          return;
        }
        localObject2 = (bdgb)this.mMiniAppContext.a(bdfr.a());
        if (localObject2 != null)
        {
          if (((bdgb)localObject2).i)
          {
            bdnw.d("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bdfp.a(new ShareJsPlugin.5(this, (bdng)localObject1, parambdfz)));
        }
      }
      else if ((i == 0) && (k != 0))
      {
        ((bdng)localObject1).jdField_b_of_type_JavaLangString = str2;
        ((bdng)localObject1).jdField_a_of_type_Boolean = true;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambdfz);
        return;
      }
      label479:
      label485:
      do
      {
        i = -1;
        break;
        i = 1;
        break label175;
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
      label524:
      i = 0;
      break label175;
    }
  }
  
  public void showActionSheet(bdfz parambdfz)
  {
    bdgi.a(new ShareJsPlugin.6(this, parambdfz));
  }
  
  public void showShareMenu(bdfz parambdfz)
  {
    boolean bool3 = true;
    boolean bool1;
    Object localObject;
    if ((parambdfz.jdField_b_of_type_JavaLangString == null) || ("null".equals(parambdfz.jdField_b_of_type_JavaLangString)) || ("{}".equals(parambdfz.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      j = 1;
      k = 1;
      m = 1;
      bool1 = false;
      localObject = (bdgb)this.mMiniAppContext.a(bdfr.a());
      if (m != 1) {
        break label434;
      }
      bool2 = true;
      label75:
      ((bdgb)localObject).e = bool2;
      if (k != 1) {
        break label440;
      }
      bool2 = true;
      label91:
      ((bdgb)localObject).d = bool2;
      if (j != 1) {
        break label446;
      }
      bool2 = true;
      label106:
      ((bdgb)localObject).f = bool2;
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
      ((bdgb)localObject).g = bool2;
      ((bdgb)localObject).h = bool1;
      parambdfz.a();
      return;
      for (;;)
      {
        for (;;)
        {
          int n;
          try
          {
            localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
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
      bdnw.d("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      parambdfz.b();
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
  
  public void updateShareMenuShareTicket(bdfz parambdfz)
  {
    try
    {
      boolean bool = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).optBoolean("withShareTicket", false);
      ((bdgb)this.mMiniAppContext.a(bdfr.a())).h = bool;
      parambdfz.a();
      return;
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("ShareJsPlugin", parambdfz.getMessage(), parambdfz);
      parambdfz.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */