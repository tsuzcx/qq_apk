package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import bglv;
import bgmh;
import bgmj;
import bgnt;
import bgod;
import bgoj;
import bgok;
import bgor;
import bgpv;
import bhmo;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MoreItem;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareJsPlugin
  extends BaseJsPlugin
{
  private static final int ACTION_SHEET_DEFAULT_TYPE = 0;
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_MENU_STATE_NEED_HIDE = 0;
  public static final int SHARE_MENU_STATE_NEED_SHOW = 1;
  public static final int SHARE_MENU_STATE_UNDEFINED = -1;
  private static final String TAG = "ShareJsPlugin";
  public static final int UNDEFINED = -1;
  private final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  public void hideShareMenu(bgok parambgok)
  {
    int i = -1;
    int k = 0;
    for (;;)
    {
      int j;
      int n;
      int m;
      try
      {
        localObject = (JSONArray)new JSONObject(parambgok.jdField_b_of_type_JavaLangString).opt("hideShareItems");
        if (localObject != null) {
          break label200;
        }
        j = 0;
        n = 0;
        m = 0;
        i = k;
        k = n;
        localObject = bgmj.a(this.mMiniAppContext);
        if (m == 0) {
          ((ShareState)localObject).withShareQQ = false;
        }
        if (k == 0) {
          ((ShareState)localObject).withShareQzone = false;
        }
        if (j == 0) {
          ((ShareState)localObject).withShareWeChatFriend = false;
        }
        if (i == 0) {
          ((ShareState)localObject).withShareWeChatMoment = false;
        }
        ((ShareState)localObject).withShareOthers = false;
        parambgok.a();
        return;
      }
      catch (JSONException parambgok)
      {
        Object localObject;
        String str;
        boolean bool;
        parambgok.printStackTrace();
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
          j = 0;
        }
        bool = str.equalsIgnoreCase("wechatMoment");
        if (bool) {
          i = 0;
        }
        n += 1;
      }
      else
      {
        continue;
        label200:
        n = 0;
        j = -1;
        k = -1;
        m = -1;
      }
    }
  }
  
  public void shareAppMessage(bgok parambgok)
  {
    int k;
    int j;
    ShareState localShareState;
    Object localObject2;
    int i;
    label61:
    label116:
    label122:
    String str1;
    for (;;)
    {
      Object localObject3;
      try
      {
        if (!"shareAppMessageDirectly".equals(parambgok.a)) {
          break label1057;
        }
        k = 1;
        localObject3 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        j = ((JSONObject)localObject3).optInt("shareTarget", -1);
        localObject1 = null;
        localShareState = bgmj.a(this.mMiniAppContext);
        if (j != 0) {
          break label1064;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        String str2 = ((JSONObject)localObject3).optString("shareTemplateId");
        String str3 = ((JSONObject)localObject3).optString("shareTemplateData");
        if (!"shareAppMessageDirectly".equals(parambgok.a)) {
          break label1041;
        }
        if (i != -1) {
          break label1030;
        }
        i = this.mShareProxy.getDefaultShareTarget();
        if (!MoreItem.a(i)) {
          break label1104;
        }
        j = 6;
        localShareState.fromShareMenuBtn = j;
        localShareState.shareEvent = parambgok.a;
        localShareState.shareCallbackId = parambgok.jdField_b_of_type_Int;
        if (TextUtils.isEmpty(localShareState.stagingJsonParams)) {
          break label1027;
        }
        localObject3 = new JSONObject(localShareState.stagingJsonParams);
        localShareState.stagingJsonParams = null;
        label171:
        str1 = ((JSONObject)localObject3).optString("path");
        parambgok = str1;
        if (TextUtils.isEmpty(str1)) {
          parambgok = ((JSONObject)localObject3).optString("query");
        }
        String str4 = ((JSONObject)localObject3).optString("title");
        str1 = ((JSONObject)localObject3).optString("imageUrl");
        localObject3 = ((JSONObject)localObject3).optString("generalWebpageUrl");
        if (!TextUtils.isEmpty(parambgok)) {
          break label1024;
        }
        if (!this.mMiniAppContext.b()) {
          break label667;
        }
        parambgok = "miniGamePath";
        label248:
        bgoj localbgoj = new bgoj();
        if (k == 0) {
          break label1111;
        }
        j = 11;
        label265:
        parambgok = localbgoj.a(j).b(i).a(this.mMiniAppInfo.name).b(str4).d(parambgok).e((String)localObject3).f(str2).g(str3).a((EntryModel)localObject2).a((ShareChatModel)localObject1).c(localShareState.withShareTicket).a(this.mMiniAppInfo).a(this.mMiniAppContext.a()).b(localShareState.isShareInMiniProcess);
        if (localShareState.fromShareMenuBtn != 1) {
          break label733;
        }
        if ((!str1.startsWith("http")) && (!str1.startsWith("https"))) {
          break;
        }
        parambgok.c(str1).a().a();
        return;
      }
      catch (JSONException parambgok)
      {
        label398:
        QMLog.e("ShareJsPlugin", parambgok.getMessage(), parambgok);
        parambgok.printStackTrace();
        return;
      }
      if (j == 2)
      {
        localObject2 = this.mMiniAppInfo;
        str1 = ((JSONObject)localObject3).optString("entryDataHash");
        if ((str1 != null) && (((MiniAppInfo)localObject2).launchParam.entryModel != null) && (str1.equals(((MiniAppInfo)localObject2).launchParam.entryModel.getEntryHash())))
        {
          localObject1 = ((MiniAppInfo)localObject2).launchParam.entryModel;
          break label1080;
        }
        QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + str1);
        break label1080;
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
          localObject1 = localShareState.shareChatModel;
          if ((localObject1 != null) && (((ShareChatModel)localObject1).getEntryHash().equals(localObject2))) {
            break label1096;
          }
          QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + null);
          localObject1 = null;
          break label1096;
        }
        if ((j == 6) && ("shareAppMessageDirectlyToFriendList".equals(parambgok.a)))
        {
          localObject1 = null;
          localObject2 = null;
          i = 0;
        }
        else
        {
          if (!MoreItem.a(j)) {
            break label1046;
          }
          localObject1 = null;
          localObject2 = null;
          i = 6;
          continue;
          label667:
          parambgok = this.mApkgInfo.a().entryPagePath;
        }
      }
    }
    Object localObject1 = bgnt.a().a(str1);
    if (!bgpv.a((String)localObject1))
    {
      parambgok.c((String)localObject1).a(true).a().a();
      return;
    }
    bgmh.a(this.mMiniAppContext, new ShareJsPlugin.1(this, parambgok));
    return;
    label733:
    if ((localShareState.fromShareMenuBtn == 3) || (localShareState.fromShareMenuBtn == 4))
    {
      parambgok.c(this.mMiniAppInfo.iconUrl).a().a();
      return;
    }
    if (!URLUtil.isHttpUrl(str1))
    {
      if (!URLUtil.isHttpsUrl(str1)) {
        break label1123;
      }
      break label1117;
      label788:
      if ((TextUtils.isEmpty(str1)) || (!new File(bgnt.a().a(str1)).exists())) {
        break label1129;
      }
    }
    label1024:
    label1027:
    label1030:
    label1041:
    label1046:
    label1057:
    label1064:
    label1080:
    label1096:
    label1104:
    label1111:
    label1117:
    label1123:
    label1129:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bgpv.a(str1)) || ((!bool1) && (!bool2)))
      {
        if (this.mMiniAppContext.b())
        {
          parambgok.c(WnsUtil.defaultShareImg()).a().a();
          QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + str1 + "], use default share image");
          return;
        }
        if (bgmj.a(this.mMiniAppContext) != null)
        {
          if (bgmj.a(this.mMiniAppContext).isGettingScreenShot)
          {
            QMLog.e("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          bgmh.a(this.mMiniAppContext, new ShareJsPlugin.2(this, parambgok));
        }
      }
      else
      {
        if ((str1.startsWith("http")) || (str1.startsWith("https")))
        {
          parambgok.c(str1).a().a();
          return;
        }
        parambgok.c(bgnt.a().a(str1)).a(true).a().a();
        return;
        break label248;
        break label171;
        int m = i;
        i = j;
        j = m;
        break label116;
        i = j;
        break label122;
        localObject1 = null;
        localObject2 = null;
        i = -1;
        break label61;
        k = 0;
        break;
      }
      return;
      if (j != 1) {
        break label398;
      }
      localObject1 = null;
      localObject2 = null;
      i = 1;
      break label61;
      str1 = null;
      localObject2 = localObject1;
      i = 0;
      localObject1 = str1;
      break label61;
      localObject2 = null;
      i = 0;
      break label61;
      j = 0;
      i = 0;
      break label116;
      j = 12;
      break label265;
      boolean bool1 = true;
      break label788;
      bool1 = false;
      break label788;
    }
  }
  
  public void shareAppMessageDirectly(bgok parambgok)
  {
    if (QUAUtil.isQQApp())
    {
      shareAppMessage(parambgok);
      return;
    }
    bgmj.a(this.mMiniAppContext).stagingJsonParams = parambgok.jdField_b_of_type_JavaLangString;
    bhmo.a(this.mMiniAppContext);
  }
  
  public void shareAppPictureMessage(bgok parambgok)
  {
    int i = 3;
    int m = 1;
    ShareState localShareState;
    int k;
    try
    {
      localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      j = ((JSONObject)localObject).optInt("shareTarget", -1);
      if (j != 0) {
        break label446;
      }
      i = 0;
      localShareState = bgmj.a(this.mMiniAppContext);
      k = j;
      if ("shareAppPictureMessageDirectly".equals(parambgok.a))
      {
        k = i;
        if (i == -1)
        {
          j = this.mShareProxy.getDefaultShareTarget();
          if (!MoreItem.a(j)) {
            break label481;
          }
          k = 6;
        }
        label87:
        localShareState.fromShareMenuBtn = k;
        k = j;
      }
      i = localShareState.fromShareMenuBtn;
      localShareState.shareEvent = parambgok.a;
      localShareState.shareCallbackId = parambgok.jdField_b_of_type_Int;
      parambgok = ((JSONObject)localObject).optString("title");
      localObject = ((JSONObject)localObject).optString("imageUrl");
      if (URLUtil.isHttpUrl((String)localObject)) {
        break label440;
      }
      if (!URLUtil.isHttpsUrl((String)localObject)) {
        break label489;
      }
    }
    catch (JSONException parambgok)
    {
      Object localObject;
      label157:
      parambgok.printStackTrace();
      return;
    }
    String str = bgnt.a().a((String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File(str).exists())) {}
    for (int j = m;; j = 0)
    {
      parambgok = new bgoj().a(11).b(k).a(this.mMiniAppInfo.name).b(parambgok).a(this.mMiniAppContext.a()).a(this.mMiniAppInfo).a(this.mMiniAppContext.a()).b(localShareState.isShareInMiniProcess);
      if (i != 0)
      {
        parambgok.c((String)localObject).a().b();
        return;
      }
      label440:
      label445:
      label446:
      do
      {
        if (MoreItem.a(j))
        {
          i = 6;
          break;
          if ((bgpv.a((String)localObject)) || ((i == 0) && (j == 0)))
          {
            if (this.mMiniAppContext.b())
            {
              if (this.mMiniAppInfo != null)
              {
                parambgok.c(this.mMiniAppInfo.iconUrl).a().b();
                return;
              }
              QMLog.e("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
              return;
            }
            localShareState = bgmj.a(this.mMiniAppContext);
            if (localShareState == null) {
              break label445;
            }
            if (localShareState.isGettingScreenShot)
            {
              QMLog.e("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
              return;
            }
            bgmh.a(this.mMiniAppContext, new ShareJsPlugin.3(this, parambgok));
            return;
          }
          if ((i != 0) || (j == 0)) {
            break label445;
          }
          parambgok.c(str).a(true).a().b();
          return;
        }
        i = -1;
        break;
        i = 1;
        break label157;
        return;
        if (j == 1)
        {
          i = 1;
          break;
        }
        if (j == 2)
        {
          i = 0;
          break;
        }
        if (j == 3) {
          break;
        }
      } while (j != 4);
      i = 4;
      break;
      label481:
      k = 0;
      j = 0;
      break label87;
      label489:
      i = 0;
      break label157;
    }
  }
  
  public void shareAppPictureMessageDirectly(bgok parambgok)
  {
    if (QUAUtil.isQQApp())
    {
      shareAppPictureMessage(parambgok);
      return;
    }
    bhmo.a(this.mMiniAppContext);
  }
  
  public void showActionSheet(bgok parambgok)
  {
    bgor.a(new ShareJsPlugin.4(this, parambgok));
  }
  
  public void showShareMenu(bgok parambgok)
  {
    boolean bool3 = false;
    int n;
    Object localObject;
    if ((parambgok.jdField_b_of_type_JavaLangString == null) || ("null".equals(parambgok.jdField_b_of_type_JavaLangString)) || ("{}".equals(parambgok.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      n = 1;
      k = 1;
      j = 1;
      bool1 = false;
      localObject = bgmj.a(this.mMiniAppContext);
      if (j != 1) {
        break label431;
      }
      bool2 = true;
      label66:
      ((ShareState)localObject).withShareQQ = bool2;
      if (k != 1) {
        break label437;
      }
      bool2 = true;
      label82:
      ((ShareState)localObject).withShareQzone = bool2;
      if (n != 1) {
        break label443;
      }
    }
    label267:
    label283:
    label431:
    label437:
    label443:
    for (bool2 = true;; bool2 = false)
    {
      ((ShareState)localObject).withShareWeChatFriend = bool2;
      bool2 = bool3;
      if (i == 1) {
        bool2 = true;
      }
      ((ShareState)localObject).withShareWeChatMoment = bool2;
      ((ShareState)localObject).withShareOthers = true;
      ((ShareState)localObject).withShareTicket = bool1;
      parambgok.a();
      return;
      for (;;)
      {
        int i3;
        for (;;)
        {
          int m;
          try
          {
            localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
            bool2 = ((JSONObject)localObject).optBoolean("withShareTicket", false);
          }
          catch (JSONException localJSONException1)
          {
            String str;
            int i1;
            int i2;
            label341:
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
              n = 1;
              k = 1;
              j = 1;
              bool1 = bool2;
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
              bool1 = bool2;
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
              bool1 = str.equalsIgnoreCase("qq");
              if (!bool1) {
                continue;
              }
              j = 1;
            }
          }
          catch (JSONException localJSONException3)
          {
            bool1 = bool2;
            break label400;
            break;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("qzone");
            if (!bool1) {
              continue;
            }
            k = 1;
          }
          catch (JSONException localJSONException4)
          {
            bool1 = bool2;
            break label400;
            break label267;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatFriends");
            if (!bool1) {
              continue;
            }
            i = 1;
          }
          catch (JSONException localJSONException5)
          {
            bool1 = bool2;
            break label400;
            break label283;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatMoment");
            if (bool1) {
              m = 1;
            }
            n += 1;
          }
          catch (JSONException localJSONException6)
          {
            bool1 = bool2;
            break label400;
            i3 = i;
            break label341;
          }
        }
      }
      i1 = j;
      if (j == -1) {
        i1 = 0;
      }
      i2 = k;
      if (k == -1) {
        i2 = 0;
      }
      if (i != -1) {
        break label504;
      }
      i3 = 0;
      n = i3;
      i = m;
      k = i2;
      j = i1;
      bool1 = bool2;
      if (m != -1) {
        break;
      }
      i = 0;
      n = i3;
      k = i2;
      j = i1;
      bool1 = bool2;
      break;
      localJSONException1.printStackTrace();
      QMLog.e("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      parambgok.b();
      n = i;
      i = m;
      break;
      bool2 = false;
      break label66;
      bool2 = false;
      break label82;
    }
  }
  
  public void updateShareMenuShareTicket(bgok parambgok)
  {
    try
    {
      boolean bool = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optBoolean("withShareTicket", false);
      bgmj.a(this.mMiniAppContext).withShareTicket = bool;
      parambgok.a();
      return;
    }
    catch (JSONException parambgok)
    {
      QMLog.e("ShareJsPlugin", parambgok.getMessage(), parambgok);
      parambgok.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */