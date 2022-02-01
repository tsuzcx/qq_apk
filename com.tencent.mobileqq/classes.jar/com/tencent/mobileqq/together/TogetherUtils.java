package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.ark.util.StringUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class TogetherUtils
{
  private TogetherUtils()
  {
    throw new UnsupportedOperationException("Can not create an instance.");
  }
  
  public static Bundle a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", paramInt);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", paramBoolean);
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", paramBoolean2);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", paramBoolean3);
    localBundle.putString("TOGETHER_BUNDLE_KEY_OWNER_UIN", paramString1);
    localBundle.putString("TOGETHER_BUNDLE_KEY_TROOP_UIN", paramString2);
    localBundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", paramInt);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", paramBoolean1);
    return localBundle;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().o(paramString, paramInt);
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.isEmpty()) {
        return null;
      }
      paramInt = paramQQAppInterface.size() - 1;
      while (paramInt >= 0)
      {
        paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
        if (!MessageUtils.b(paramString.msgtype)) {
          return paramString;
        }
        paramInt -= 1;
      }
    }
    return null;
  }
  
  public static <T extends TogetherSession> T a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 2) {
      return new WatchTogetherSession(paramString);
    }
    if (paramInt1 == 4) {
      return new SingTogetherSession(paramInt2, paramString);
    }
    throw new UnsupportedOperationException("Can not generate an object.");
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    for (;;)
    {
      int i;
      Object localObject;
      int j;
      int k;
      try
      {
        i = TagUtil.b(paramString);
        localObject = paramString;
        if (paramInt > 0)
        {
          localObject = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = paramString;
            if (i > paramInt)
            {
              localObject = new StringBuilder();
              j = 0;
              i = 0;
              if (j < paramString.length())
              {
                k = paramString.codePointAt(j);
                if ((k < 32) || (k > 126)) {
                  break label145;
                }
                i += 1;
                ((StringBuilder)localObject).appendCodePoint(k);
                if (i < paramInt) {
                  break label170;
                }
              }
              ((StringBuilder)localObject).append("...");
              paramString = ((StringBuilder)localObject).toString();
              return paramString;
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TogetherUtils", 2, paramString.getMessage(), paramString);
        }
        localObject = "";
      }
      return localObject;
      label145:
      if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
        continue;
        label170:
        j += 1;
      }
    }
  }
  
  public static String a(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    Object localObject = paramString;
    String str;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_TROOP_UIN"))
    {
      str = paramBundle.getString("TOGETHER_BUNDLE_KEY_TROOP_UIN");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = URLUtil.a(paramString, "troopuin", (String)localObject);
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OWNER_UIN"))
    {
      str = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      paramString = URLUtil.a((String)localObject, "troopowneruin", paramString);
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_OWNER"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", false));
      ((StringBuilder)localObject).append("");
      localObject = URLUtil.a(paramString, "isowner", ((StringBuilder)localObject).toString());
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_ADMIN"))
    {
      paramString = new StringBuilder();
      paramString.append(paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", false));
      paramString.append("");
      paramString = URLUtil.a((String)localObject, "isadmin", paramString.toString());
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", false));
      ((StringBuilder)localObject).append("");
      localObject = URLUtil.a(paramString, "isopen", ((StringBuilder)localObject).toString());
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE"))
    {
      paramString = new StringBuilder();
      paramString.append(paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", 0));
      paramString.append("");
      paramString = URLUtil.a((String)localObject, "from", paramString.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "jumpToDefaultTogetherWatch, realJumpURL=", paramString });
    }
    return paramString;
  }
  
  public static void a(int paramInt, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    Object localObject5 = null;
    String str1;
    if (paramMap1 == null) {
      str1 = null;
    } else {
      str1 = (String)paramMap1.get("chatType");
    }
    if (paramMap1 == null) {
      paramMap1 = null;
    } else {
      paramMap1 = (String)paramMap1.get("chatUIN");
    }
    if (paramMap == null) {
      localObject3 = null;
    } else {
      localObject3 = (HashMap)paramMap.get("extra");
    }
    if (localObject3 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Map)localObject3).get("aio_media_id");
    }
    if (localObject3 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((Map)localObject3).get("song_id");
    }
    if (localObject3 == null) {
      localObject4 = "";
    } else {
      localObject4 = ((Map)localObject3).get("match_id");
    }
    Object localObject4 = (String)localObject4;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = ((Map)localObject3).get("sub_type");
    }
    Object localObject3 = (Integer)localObject3;
    if (localObject3 != null) {
      try
      {
        i = ((Integer)localObject3).intValue();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TogetherUtils", 1, "categoryId to int ", localThrowable);
        j = 0;
        break label216;
      }
    } else {
      i = 0;
    }
    int j = i;
    label216:
    String str2;
    if (paramMap == null) {
      str2 = null;
    } else {
      str2 = (String)paramMap.get("summary");
    }
    if (paramMap == null) {
      paramMap = null;
    } else {
      paramMap = (String)paramMap.get("cover");
    }
    QLog.d("TogetherUtils", 1, new Object[] { "onArkTogetherClick params[", str1, " ", paramMap1, " ", localObject1, " ", localObject2, "]" });
    int k = -1;
    long l;
    if ((localObject1 instanceof Long)) {
      l = ((Long)localObject1).longValue();
    } else {
      l = 0L;
    }
    Object localObject1 = localObject5;
    if ((localObject2 instanceof String)) {
      localObject1 = (String)localObject2;
    }
    int i = k;
    if (!TextUtils.isEmpty(str1))
    {
      i = k;
      if (!TextUtils.isEmpty(paramMap1)) {
        try
        {
          if ("2".equalsIgnoreCase(str1))
          {
            i = 2;
          }
          else
          {
            boolean bool = "3".equalsIgnoreCase(str1);
            i = k;
            if (bool) {
              i = 1;
            }
          }
        }
        catch (Exception localException)
        {
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.i("TogetherUtils", 2, localException.getMessage(), localException);
            i = k;
          }
        }
      }
    }
    if (((i != 2) && (i != 1)) || (l == 0L))
    {
      QLog.d("TogetherUtils", 1, "onArkTogetherClick return invalid params");
      return;
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null)
    {
      QLog.d("TogetherUtils", 1, "onArkTogetherClick return null activity");
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("video_id", (String)localObject4);
    ((Bundle)localObject2).putInt("category_id", j);
    ((Bundle)localObject2).putString("title_name", str2);
    ((Bundle)localObject2).putString("room_cover", paramMap);
    ((Bundle)localObject2).putString("song_id", (String)localObject1);
    TogetherControlManager.a(localBaseActivity.app).a(localBaseActivity, paramInt, i, paramMap1, l, 8, (Bundle)localObject2);
  }
  
  public static void a(@NonNull Context paramContext, int paramInt1, @NonNull String paramString1, @Nullable String paramString2, @NonNull Bundle paramBundle, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        QQToast.makeText(paramContext, 0, 2131917986, 0).show();
        return;
      }
      paramString2 = new Intent();
      if (paramInt2 == 1) {
        paramContext = a(paramString1, paramBundle);
      } else {
        paramContext = b(paramString1, paramBundle);
      }
      paramContext = Uri.parse(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherUtils", 2, new Object[] { "jumpToDefaultTogetherWatch, realJumpURI=", paramContext.toString() });
      }
      paramString2.setData(paramContext);
      paramString2.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return;
    }
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    if (paramInt2 == 1) {
      paramString1 = a(paramString1, paramBundle);
    } else {
      paramString1 = b(paramString1, paramBundle);
    }
    paramString2.putExtra("url", paramString1);
    paramString2.setFlags(268435456);
    paramContext.startActivity(paramString2);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, int paramInt1, @NonNull String paramString1, @Nullable String paramString2, @NonNull Bundle paramBundle, int paramInt2)
  {
    a(paramQQAppInterface.getApp(), paramInt1, paramString1, paramString2, paramBundle, paramInt2);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull TogetherSession paramTogetherSession, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTogetherSession.l);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTogetherSession.m);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTogetherSession.n);
    b(paramQQAppInterface, localStringBuilder.toString(), paramBoolean, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsGroupWatchTogetherOpen, app =");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(",troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isOpen=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("TogetherUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramQQAppInterface != null)
    {
      localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).f(paramString);
        if (paramString != null)
        {
          boolean bool = paramString.isWatchTogetherOpen();
          paramString.setIsWatchTogether(paramBoolean);
          ((TroopManager)localObject).b(paramString);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("setIsGroupWatchTogetherOpen troopinfo saved, last=");
            paramString.append(bool);
            QLog.i("TogetherUtils", 2, paramString.toString());
          }
          if (bool != paramBoolean)
          {
            paramString = paramQQAppInterface.getHandler(Conversation.class);
            if (paramString != null) {
              paramString.sendEmptyMessage(1009);
            }
            paramQQAppInterface = paramQQAppInterface.getHandler(HiddenChatSettingFragment.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.sendEmptyMessage(1);
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("setBusinessTogetherOpen, uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isOpen=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" sessionType =");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" businessType=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("TogetherUtils", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    int i;
    boolean bool;
    if (paramInt1 == 1)
    {
      localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      i = j;
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).f(paramString);
        i = j;
        if (paramString != null)
        {
          bool = paramString.isTogetherBusinessOpen(paramInt2);
          paramString.setTogetherBusiness(paramBoolean, paramInt2);
          ((TroopManager)localObject).b(paramString);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("setBusinessTogetherOpen troopinfo saved, last=");
            paramString.append(bool);
            QLog.i("TogetherUtils", 2, paramString.toString());
          }
          i = j;
          if (bool == paramBoolean) {}
        }
      }
    }
    else
    {
      for (;;)
      {
        i = 1;
        break label334;
        i = j;
        if (paramInt1 != 2) {
          break label334;
        }
        localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramString = ((FriendsManager)localObject).d(paramString, false);
        if (paramString == null) {
          break;
        }
        bool = paramString.isTogetherBusinessOpen(paramInt2);
        paramString.setTogetherBusiness(paramBoolean, paramInt2);
        ((FriendsManager)localObject).a(paramString);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setBusinessTogetherOpen troopinfo saved, last=");
          paramString.append(bool);
          QLog.i("TogetherUtils", 2, paramString.toString());
        }
        i = j;
        if (bool == paramBoolean) {
          break label334;
        }
      }
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("TogetherUtils", 2, "setBusinessTogetherOpen extensionInfo is null");
        i = j;
      }
    }
    label334:
    if (i != 0)
    {
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(1009);
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(HiddenChatSettingFragment.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str;
    if (paramString1.equals("1041")) {
      str = "clk_joinbuy_bar";
    } else {
      str = "";
    }
    if ((paramString1.equals("1042")) || (paramString1.equals("1043"))) {
      str = "clk_sucbuy_bar";
    }
    if (paramString1.equals("1046")) {
      str = "clk_overtimebuy_bar";
    }
    if ((paramString1.equals("1044")) || (paramString1.equals("1045"))) {
      str = "clk_sucticket_bar";
    }
    if ((paramString1.equals("1047")) || (paramString1.equals("1048"))) {
      str = "clk_overtimeticket_bar";
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", str, 0, 0, paramString2, "", "", "");
  }
  
  public static boolean a(Intent paramIntent, TogetherSession paramTogetherSession, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherUtils", 2, "invokeJoinDialog ChatPie not onResume");
      }
      return false;
    }
    paramBoolean = paramIntent.getBooleanExtra("key_notification_click_action", false);
    boolean bool = paramIntent.getBooleanExtra("together_business_has_show_join_dialog", false);
    paramIntent.putExtra("together_business_has_show_join_dialog", true);
    if ((paramBoolean) && (!bool))
    {
      if ((paramTogetherSession.p == 1) && (paramTogetherSession.q != 2)) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherUtils", 2, new Object[] { "invokeJoinDialog togetherSession.status=", Integer.valueOf(paramTogetherSession.p), " togetherSession.userState=", Integer.valueOf(paramTogetherSession.q) });
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "invokeJoinDialog not from notification isFromNotification= ", Boolean.valueOf(paramBoolean), " hasShowJoinDialog=", Boolean.valueOf(bool) });
    }
    return false;
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface, @NonNull TogetherSession paramTogetherSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTogetherSession.l);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTogetherSession.m);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTogetherSession.n);
    return a(paramQQAppInterface, localStringBuilder.toString(), true, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("setBusinessTogetherOpen, uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" sessionType =");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" businessType=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("TogetherUtils", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.f(paramString);
        if (paramQQAppInterface != null)
        {
          bool = paramQQAppInterface.isTogetherBusinessOpen(paramInt2);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("isBusinessTogetherOpen troopinfo last=");
            paramQQAppInterface.append(bool);
            QLog.i("TogetherUtils", 2, paramQQAppInterface.toString());
          }
          return bool;
        }
      }
    }
    else if (paramInt1 == 2)
    {
      localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramQQAppInterface = ((FriendsManager)localObject).d(paramString, false);
      paramString = ((FriendsManager)localObject).c(paramString);
      if (paramString != null)
      {
        if (!paramString.isFriend()) {
          return false;
        }
        if (paramQQAppInterface != null)
        {
          bool = paramQQAppInterface.isTogetherBusinessOpen(paramInt2);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("isBusinessTogetherOpen extensionInfo last=");
            paramQQAppInterface.append(bool);
            QLog.d("TogetherUtils", 2, paramQQAppInterface.toString());
          }
          return bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TogetherUtils", 2, "isBusinessTogetherOpen extensionInfo is null");
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2) {
      str = paramQQAppInterface.getCurrentUin();
    } else {
      str = "qq_together_pref";
    }
    return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return false;
    }
    paramChatMessage = ((MessageForArkApp)paramChatMessage).ark_app_message;
    if (!"com.tencent.together".equals(paramChatMessage.appName)) {
      return false;
    }
    try
    {
      paramChatMessage = new JSONObject(paramChatMessage.metaList).optJSONObject("invite");
      if (paramChatMessage == null) {
        return false;
      }
      paramChatMessage = StringUtil.a(paramChatMessage).get("type");
      if ((paramChatMessage != null) && ((paramChatMessage instanceof String)))
      {
        boolean bool = "watch".equals(((String)paramChatMessage).toLowerCase());
        if (bool) {
          return true;
        }
      }
    }
    catch (JSONException paramChatMessage)
    {
      paramChatMessage.printStackTrace();
    }
    return false;
  }
  
  public static String b(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    Object localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID")) {
      localObject = URLUtil.a(paramString, "friend_user_openid", paramBundle.getString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID"));
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS"))
    {
      paramString = new StringBuilder();
      paramString.append(paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS"));
      paramString.append("");
      paramString = URLUtil.a((String)localObject, "isopen", paramString.toString());
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE"));
      ((StringBuilder)localObject).append("");
      localObject = URLUtil.a(paramString, "from", ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "generalC2CJumpURL, realJumpURL=", localObject });
    }
    return localObject;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2) {
      str = paramQQAppInterface.getCurrentUin();
    } else {
      str = "qq_together_pref";
    }
    paramQQAppInterface.getApplication().getSharedPreferences(str, 0).edit().putBoolean(paramString, paramBoolean1).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUtils
 * JD-Core Version:    0.7.0.1
 */