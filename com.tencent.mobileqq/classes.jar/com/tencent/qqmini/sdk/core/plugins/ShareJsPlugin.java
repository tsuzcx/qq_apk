package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import begz;
import beha;
import beiu;
import bejp;
import bejr;
import bejy;
import beka;
import beki;
import belh;
import bequ;
import bers;
import beru;
import besl;
import bfgt;
import bfgy;
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
  
  public void hideShareMenu(beka parambeka)
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
        localObject = (JSONArray)new JSONObject(parambeka.jdField_b_of_type_JavaLangString).opt("hideShareItems");
        if (localObject != null) {
          break label192;
        }
        j = -1;
        k = 0;
        localObject = (beru)this.mMiniAppContext.a(bejr.a());
        if (m == 0) {
          ((beru)localObject).e = false;
        }
        if (k == 0) {
          ((beru)localObject).d = false;
        }
        if (j == 0) {
          ((beru)localObject).f = false;
        }
        if (i == 0) {
          ((beru)localObject).g = false;
        }
        parambeka.a();
        return;
      }
      catch (JSONException parambeka)
      {
        Object localObject;
        String str;
        boolean bool;
        parambeka.printStackTrace();
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
  
  public void shareAppMessage(beka parambeka)
  {
    int k;
    int j;
    beru localberu;
    Object localObject2;
    int i;
    label69:
    String str1;
    label130:
    label136:
    String str5;
    label235:
    bers localbers;
    for (;;)
    {
      Object localObject3;
      try
      {
        if (!"shareAppMessageDirectly".equals(parambeka.jdField_a_of_type_JavaLangString)) {
          break label1127;
        }
        k = 1;
        localObject3 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
        j = ((JSONObject)localObject3).optInt("shareTarget", -1);
        localObject1 = null;
        localberu = (beru)this.mMiniAppContext.a(bejr.a());
        if (j != 0) {
          break label1134;
        }
        localObject1 = null;
        localObject2 = null;
        i = 0;
        String str3 = ((JSONObject)localObject3).optString("shareTemplateId");
        String str4 = ((JSONObject)localObject3).optString("shareTemplateData");
        if (!"shareAppMessageDirectly".equals(parambeka.jdField_a_of_type_JavaLangString)) {
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
        localberu.jdField_b_of_type_Int = j;
        localberu.jdField_a_of_type_JavaLangString = parambeka.jdField_a_of_type_JavaLangString;
        localberu.c = parambeka.jdField_b_of_type_Int;
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
        parambeka = new ShareJsPlugin.1(this, parambeka);
        localbers = new bers();
        localbers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppContext.a();
        if (k == 0) {
          break label1181;
        }
        j = 11;
        label276:
        localbers.jdField_a_of_type_Int = j;
        localbers.jdField_b_of_type_Int = i;
        localbers.jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
        localbers.jdField_a_of_type_JavaLangString = str2;
        localbers.c = str1;
        localbers.d = ((String)localObject3);
        localbers.e = str3;
        localbers.f = str4;
        localbers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = ((EntryModel)localObject2);
        localbers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = ((ShareChatModel)localObject1);
        localbers.jdField_b_of_type_Boolean = localberu.h;
        if (localberu.jdField_b_of_type_Int != 1) {
          break label737;
        }
        if ((!str5.startsWith("http")) && (!str5.startsWith("https"))) {
          break;
        }
        localbers.jdField_b_of_type_JavaLangString = str5;
        this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
        return;
      }
      catch (JSONException parambeka)
      {
        label410:
        besl.d("ShareJsPlugin", parambeka.getMessage(), parambeka);
        parambeka.printStackTrace();
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
        besl.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + str1);
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
          localObject1 = localberu.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel;
          if ((localObject1 != null) && (((ShareChatModel)localObject1).a().equals(localObject2))) {
            break label1166;
          }
          besl.d("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + null);
          localObject1 = null;
          break label1166;
        }
        if ((j != 6) || (!"shareAppMessageDirectlyToFriendList".equals(parambeka.jdField_a_of_type_JavaLangString))) {
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
    Object localObject1 = beiu.a().a(str5);
    if (!belh.a((String)localObject1))
    {
      localbers.jdField_b_of_type_JavaLangString = ((String)localObject1);
      this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
      return;
    }
    this.mMiniAppContext.a(bejp.a(new ShareJsPlugin.2(this, localbers, parambeka)));
    return;
    label737:
    if (localberu.jdField_b_of_type_Int == 3)
    {
      localbers.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
      return;
    }
    if (localberu.jdField_b_of_type_Int == 4)
    {
      localbers.jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
      this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
      return;
    }
    if (!URLUtil.isHttpUrl(str5))
    {
      if (!URLUtil.isHttpsUrl(str5)) {
        break label1193;
      }
      break label1187;
      label824:
      if ((TextUtils.isEmpty(str5)) || (!new File(beiu.a().a(str5)).exists())) {
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
      if ((belh.a(str5)) || ((!bool1) && (!bool2)))
      {
        if (this.mMiniAppContext.e())
        {
          localbers.jdField_b_of_type_JavaLangString = bfgy.a();
          this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
          besl.d("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + str5 + "], use default share image");
          return;
        }
        if (this.mMiniAppContext.a(bejr.a()) != null)
        {
          if (((beru)this.mMiniAppContext.a(bejr.a())).i)
          {
            besl.d("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bejp.a(new ShareJsPlugin.3(this, localbers, parambeka)));
        }
      }
      else
      {
        if ((str5.startsWith("http")) || (str5.startsWith("https")))
        {
          localbers.jdField_b_of_type_JavaLangString = str5;
          this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
          return;
        }
        localbers.jdField_b_of_type_JavaLangString = beiu.a().a(str5);
        this.mShareProxy.onJsShareAppMessage(localbers, parambeka);
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
  
  public void shareAppMessageDirectly(beka parambeka)
  {
    if (bfgt.a())
    {
      shareAppMessage(parambeka);
      return;
    }
    this.mMiniAppProxy.onCapsuleButtonMoreClick(new beha(this.mMiniAppContext));
  }
  
  public void shareAppPictureMessage(beka parambeka)
  {
    int i = 3;
    Object localObject1;
    Object localObject2;
    int j;
    try
    {
      localObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      k = ((JSONObject)localObject1).optInt("shareTarget", -1);
      if (k != 0) {
        break label507;
      }
      i = 0;
      localObject2 = (beru)this.mMiniAppContext.a(bejr.a());
      j = k;
      if ("shareAppPictureMessageDirectly".equals(parambeka.jdField_a_of_type_JavaLangString))
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
        ((beru)localObject2).jdField_b_of_type_Int = k;
      }
      i = ((beru)localObject2).jdField_b_of_type_Int;
      ((beru)localObject2).jdField_a_of_type_JavaLangString = parambeka.jdField_a_of_type_JavaLangString;
      ((beru)localObject2).c = parambeka.jdField_b_of_type_Int;
      parambeka = new ShareJsPlugin.4(this, parambeka);
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
    catch (JSONException parambeka)
    {
      String str1;
      label197:
      parambeka.printStackTrace();
      return;
    }
    String str2 = beiu.a().a(str1);
    if ((!TextUtils.isEmpty(str1)) && (new File(str2).exists())) {}
    for (int k = 1;; k = 0)
    {
      localObject1 = new bers();
      ((bers)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppInfo;
      ((bers)localObject1).jdField_a_of_type_Int = 11;
      ((bers)localObject1).jdField_b_of_type_Int = j;
      ((bers)localObject1).jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
      ((bers)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (i != 0)
      {
        ((bers)localObject1).jdField_b_of_type_JavaLangString = str1;
        ((bers)localObject1).jdField_a_of_type_Boolean = false;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambeka);
        return;
      }
      if ((belh.a(str1)) || ((i == 0) && (k == 0)))
      {
        if (this.mMiniAppContext.e())
        {
          if (this.mMiniAppInfo != null)
          {
            ((bers)localObject1).jdField_b_of_type_JavaLangString = this.mMiniAppInfo.iconUrl;
            ((bers)localObject1).jdField_a_of_type_Boolean = false;
            this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambeka);
            return;
          }
          besl.d("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
          return;
        }
        localObject2 = (beru)this.mMiniAppContext.a(bejr.a());
        if (localObject2 != null)
        {
          if (((beru)localObject2).i)
          {
            besl.d("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          this.mMiniAppContext.a(bejp.a(new ShareJsPlugin.5(this, (bers)localObject1, parambeka)));
        }
      }
      else if ((i == 0) && (k != 0))
      {
        ((bers)localObject1).jdField_b_of_type_JavaLangString = str2;
        ((bers)localObject1).jdField_a_of_type_Boolean = true;
        this.mShareProxy.onJsShareAppPictureMessage(localObject1, parambeka);
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
  
  public void shareAppPictureMessageDirectly(beka parambeka)
  {
    if (bfgt.a())
    {
      shareAppPictureMessage(parambeka);
      return;
    }
    this.mMiniAppProxy.onCapsuleButtonMoreClick(new beha(this.mMiniAppContext));
  }
  
  public void showActionSheet(beka parambeka)
  {
    beki.a(new ShareJsPlugin.6(this, parambeka));
  }
  
  public void showShareMenu(beka parambeka)
  {
    boolean bool3 = true;
    boolean bool1;
    Object localObject;
    if ((parambeka.jdField_b_of_type_JavaLangString == null) || ("null".equals(parambeka.jdField_b_of_type_JavaLangString)) || ("{}".equals(parambeka.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      j = 1;
      k = 1;
      m = 1;
      bool1 = false;
      localObject = (beru)this.mMiniAppContext.a(bejr.a());
      if (m != 1) {
        break label434;
      }
      bool2 = true;
      label75:
      ((beru)localObject).e = bool2;
      if (k != 1) {
        break label440;
      }
      bool2 = true;
      label91:
      ((beru)localObject).d = bool2;
      if (j != 1) {
        break label446;
      }
      bool2 = true;
      label106:
      ((beru)localObject).f = bool2;
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
      ((beru)localObject).g = bool2;
      ((beru)localObject).h = bool1;
      parambeka.a();
      return;
      for (;;)
      {
        for (;;)
        {
          int n;
          try
          {
            localObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
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
      besl.d("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      parambeka.b();
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
  
  public void updateShareMenuShareTicket(beka parambeka)
  {
    try
    {
      boolean bool = new JSONObject(parambeka.jdField_b_of_type_JavaLangString).optBoolean("withShareTicket", false);
      ((beru)this.mMiniAppContext.a(bejr.a())).h = bool;
      parambeka.a();
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("ShareJsPlugin", parambeka.getMessage(), parambeka);
      parambeka.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */