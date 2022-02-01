package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import org.json.JSONObject;

public class ReadInJoyLegacyUtils
{
  static QQCustomDialog a;
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramReadInJoyUserInfo != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("accountType", Integer.valueOf(paramReadInJoyUserInfo.accountType));
        localJSONObject2.putOpt("uin", paramReadInJoyUserInfo.uin);
        localJSONObject1.putOpt("accountInfo", localJSONObject2);
        localJSONObject1.putOpt("nickName", paramReadInJoyUserInfo.nick);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("faceType", Integer.valueOf(paramReadInJoyUserInfo.faceType));
        localJSONObject2.putOpt("timeStamp", Long.valueOf(paramReadInJoyUserInfo.timestamp));
        localJSONObject2.putOpt("faceFlag", Integer.valueOf(paramReadInJoyUserInfo.faceFlag));
        localJSONObject2.putOpt("url", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
        localJSONObject2.putOpt("sysID", Integer.valueOf(paramReadInJoyUserInfo.systemID));
        localJSONObject1.putOpt("headerInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("ccLevel", Integer.valueOf(paramReadInJoyUserInfo.accountLevel));
        localJSONObject2.putOpt("iconUrlSmall", paramReadInJoyUserInfo.smallIconUrl);
        localJSONObject2.putOpt("iconUrlLarge", paramReadInJoyUserInfo.largeIconUrl);
        localJSONObject1.putOpt("accountLevelInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        if (!paramReadInJoyUserInfo.isLiving()) {
          break label342;
        }
        i = 1;
        localJSONObject2.putOpt("isLiving", Integer.valueOf(i));
        localJSONObject2.putOpt("source", Integer.valueOf(paramReadInJoyUserInfo.getLiveSource()));
        localJSONObject2.putOpt("url", paramReadInJoyUserInfo.getLiveUrl());
        localJSONObject1.putOpt("liveStatusInfo", localJSONObject2);
        localJSONObject1.putOpt("retCode", Integer.valueOf(0));
        localJSONObject1.putOpt("retMsg", "");
        paramReadInJoyUserInfo = localJSONObject1.toString();
        return paramReadInJoyUserInfo;
      }
      catch (Exception paramReadInJoyUserInfo)
      {
        QLog.e("ReadInJoy", 1, paramReadInJoyUserInfo.getMessage());
        try
        {
          localJSONObject1.putOpt("retCode", Integer.valueOf(-1));
          localJSONObject1.putOpt("retMsg", paramReadInJoyUserInfo.getMessage());
        }
        catch (Exception paramReadInJoyUserInfo)
        {
          QLog.e("ReadInJoy", 1, paramReadInJoyUserInfo.getMessage());
        }
      }
      return localJSONObject1.toString();
      label342:
      int i = 0;
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.d();
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).a)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b)))
    {
      d(paramActivity, paramAppInterface, paramProfileParams);
      return;
    }
    if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))
    {
      String str = paramAppInterface.getCurrentAccountUin();
      if (!((ProfileParams.CurLoginUsr)localObject).b.equals(str))
      {
        e(paramActivity, paramAppInterface, paramProfileParams);
        return;
      }
      d(paramActivity, paramAppInterface, paramProfileParams);
      return;
    }
    localObject = new ReadInJoyLegacyUtils.2(paramActivity, paramAppInterface, paramProfileParams);
    localObject = QZoneShareManager.getOpenID(paramAppInterface, paramProfileParams.a(), (BusinessObserver)localObject);
    if ((localObject != null) && ((b(paramActivity, (OpenID)localObject, paramAppInterface, paramProfileParams) ^ true))) {
      d(paramActivity, paramAppInterface, paramProfileParams);
    }
  }
  
  private static void a(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    paramInt = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAppInterface, paramString, paramInt);
    if (paramInt != -7)
    {
      if (paramInt != -6) {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).openPublicAccountProfile(paramIntent, paramContext, paramString);
      }
    }
    else {
      CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
    }
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      boolean bool1;
      int n;
      try
      {
        str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str5 = paramJSONObject.optString("sourceName", "");
        str2 = paramJSONObject.optString("picUrl", "");
        long l = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        localObject1 = paramJSONObject.optString("commentID");
        String str4 = paramJSONObject.optString("subCommentID");
        bool1 = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        n = paramJSONObject.optInt("showType", 0);
        boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
        boolean bool3 = paramJSONObject.optBoolean("showShare", true);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("startShowComment  uniqueKey = ");
        paramJSONObject.append(str1);
        paramJSONObject.append("source = ");
        paramJSONObject.append(i);
        paramJSONObject.append("feedsId = ");
        paramJSONObject.append((String)localObject2);
        paramJSONObject.append(" feedsType=");
        paramJSONObject.append(j);
        paramJSONObject.append("adTag = ");
        paramJSONObject.append(k);
        paramJSONObject.append("title = ");
        paramJSONObject.append(str3);
        paramJSONObject.append("sourceName = ");
        paramJSONObject.append(str5);
        paramJSONObject.append("picUrl =");
        paramJSONObject.append(str2);
        paramJSONObject.append("duration = ");
        paramJSONObject.append(l);
        paramJSONObject.append("articleId =");
        paramJSONObject.append(str6);
        QLog.d("ReadInJoy", 1, paramJSONObject.toString());
        localBundle = new Bundle();
        localBundle.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str5, str2, l));
        localBundle.putInt("source", i);
        localBundle.putString("commentId", (String)localObject1);
        localBundle.putString("subCommentId", str4);
        localBundle.putBoolean("isAwesome", bool1);
        localBundle.putInt("jumpType", m);
        localBundle.putInt("seq", paramInt);
        localBundle.putBoolean("canBiu", bool2);
        localBundle.putBoolean("showShare", bool3);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).a = ((String)localObject1);
        ((AnchorData)localObject2).b = str4;
        ((AnchorData)localObject2).c = bool1;
        ((AnchorData)localObject2).d = true;
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("anchorData commentId:");
        paramJSONObject.append((String)localObject1);
        paramJSONObject.append(" ,subCommentId :");
        paramJSONObject.append(str4);
        QLog.d("ReadInJoy", 1, paramJSONObject.toString());
        localObject1 = QBaseActivity.sTopActivity;
        paramJSONObject = null;
        if (str3 == null) {
          break label586;
        }
        paramJSONObject = new String(Base64Util.decode(str3, 0));
      }
      catch (Exception paramJSONObject)
      {
        String str1;
        Object localObject2;
        String str2;
        Object localObject1;
        Bundle localBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoy", 2, QLog.getStackTraceString(paramJSONObject));
        return;
      }
      ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, paramJSONObject, null, str2, (AnchorData)localObject2, false, bool1, localBundle);
      return;
      label586:
      if (n == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, CallCommentJs paramCallCommentJs)
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.e();
    a(paramJSONObject, localTroopMemberApiClient.e(new ReadInJoyLegacyUtils.1(paramCallCommentJs, paramString)));
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.d() == null) || (TextUtils.isEmpty(paramProfileParams.a()));
  }
  
  private static boolean b(Activity paramActivity, OpenID paramOpenID, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)) && ((paramOpenID.openID.equals(paramProfileParams.d().a) ^ true)))
    {
      e(paramActivity, paramAppInterface, paramProfileParams);
      return true;
    }
    return false;
  }
  
  private static void d(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    f(paramActivity, paramAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  private static void e(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    QQCustomDialog localQQCustomDialog = a;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      a = null;
    }
    paramAppInterface = new ReadInJoyLegacyUtils.3(paramActivity, paramProfileParams, paramAppInterface);
    paramProfileParams = new ReadInJoyLegacyUtils.4(paramActivity, paramProfileParams);
    a = DialogUtil.a(paramActivity, 230);
    a.setMessage(2131892939);
    a.setTitle(2131889094);
    a.setNegativeButton(2131887648, paramAppInterface);
    a.setPositiveButton(2131916409, paramAppInterface);
    a.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      a.show();
      return;
    }
    catch (Exception paramActivity) {}
    a.dismiss();
    a = null;
    return;
  }
  
  private static void f(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetailActivity.class));
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramAppInterface, paramProfileParams.b(), paramProfileParams.c(), localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils
 * JD-Core Version:    0.7.0.1
 */