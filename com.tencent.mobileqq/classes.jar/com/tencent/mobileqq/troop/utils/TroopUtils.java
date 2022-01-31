package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopUtils
{
  protected static String a = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
  protected static String b = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
  public static String c = "http://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
  
  private static char a(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 3;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return 0;
      }
      if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentAccountUin())) {
        return 1;
      }
      if (TroopInfo.isTroopMember(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin())) {
        return 2;
      }
    }
    return 3;
  }
  
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static int a(SearchGroup.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.bGroupAllow.has()) && (paramGroupInfo.bGroupAllow.get())) {
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    int i;
    if (j > 0)
    {
      i = k;
      if (k > 0) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "drawable width or height is 0, and use default drawable");
      }
      paramDrawable = FaceDrawable.a(1, 3);
      j = paramDrawable.getIntrinsicWidth();
      k = paramDrawable.getIntrinsicHeight();
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "the default drawable width or height is 0");
        }
        return null;
      }
    }
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(j, i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, j, i);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, paramResources.getDrawable(2130845541));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (paramResources = paramDrawable.getConstantState().newDrawable(paramResources);; paramResources = paramDrawable.getConstantState().newDrawable(paramResources).mutate())
    {
      paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramResources.setAlpha(paramInt >>> 24);
      return paramResources;
    }
  }
  
  public static Bundle a(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.lCode));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.lUin));
    localBundle.putString("troop_info_name", paramGroupInfo.strName);
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.iFaceId);
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.strIntro);
    localBundle.putString("troop_info_loca", paramGroupInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwCertType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.iMemberCnt);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", (int)paramGroupInfo.dwGroupActiveGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    if (!TextUtils.isEmpty(paramGroupInfo.strJoinAuth)) {
      localBundle.putString("authKey", paramGroupInfo.strJoinAuth);
    }
    return localBundle;
  }
  
  public static Object a(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = JSONObject.NULL;
    }
    for (;;)
    {
      return localObject;
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!(paramObject instanceof JSONObject))
        {
          localObject = paramObject;
          if (!paramObject.equals(JSONObject.NULL)) {
            try
            {
              if ((paramObject instanceof Collection)) {
                return new JSONArray((Collection)paramObject);
              }
              if (paramObject.getClass().isArray()) {
                return a(paramObject);
              }
              if ((paramObject instanceof Map)) {
                return new JSONObject((Map)paramObject);
              }
              localObject = paramObject;
              if (!(paramObject instanceof Boolean))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Byte))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Character))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Double))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Float))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Integer))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Long))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof Short))
                            {
                              localObject = paramObject;
                              if (!(paramObject instanceof String)) {
                                if (paramObject.getClass().getPackage().getName().startsWith("java."))
                                {
                                  paramObject = paramObject.toString();
                                  return paramObject;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramObject) {}
          }
        }
      }
    }
    return null;
  }
  
  public static String a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      return null;
    }
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localObject = new JSONObject();
      Iterator localIterator = paramBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject).put(str, a(paramBundle1.get(str)));
        continue;
        return paramBundle1;
      }
    }
    catch (JSONException paramBundle1)
    {
      paramBundle1.printStackTrace();
      paramBundle1 = null;
    }
    for (;;)
    {
      localJSONObject2.put("param", localObject);
      if (paramBundle2 != null)
      {
        paramBundle1 = paramBundle2.keySet().iterator();
        while (paramBundle1.hasNext())
        {
          localObject = (String)paramBundle1.next();
          localJSONObject2.put((String)localObject, a(paramBundle2.get((String)localObject)));
        }
      }
      localJSONObject1.put("key", localJSONObject2);
      paramBundle1 = localJSONObject1.toString();
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(a(paramString));
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = paramString;
      if (arrayOfByte != null)
      {
        localObject = new StringBuilder();
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          ((StringBuilder)localObject).append(a(k >>> 4));
          ((StringBuilder)localObject).append(a(k));
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      do
      {
        Object localObject = paramString;
      } while (!QLog.isColorLevel());
      QLog.e("TroopUtils", 2, "encrypt has exception: " + localNoSuchAlgorithmException.getMessage());
    }
    return localObject;
    return paramString;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        paramString = null;
      }
    }
    do
    {
      return paramString;
      str = paramString.replace("%req_uin%", str);
      paramString = str;
      if (str.contains("%action_uin%"))
      {
        paramString = paramStructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramString = str.replace("%action_uin%", paramString);
      }
      str = paramString;
      if (paramString.contains("%actor_uin%"))
      {
        str = paramStructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = paramString.replace("%actor_uin%", str);
      }
      paramString = str;
    } while (!str.contains("%group_name%"));
    paramStructMsg = paramStructMsg.msg.group_name.get();
    if (TextUtils.isEmpty(paramStructMsg)) {
      return null;
    }
    return str.replace("%group_name%", paramStructMsg);
  }
  
  public static JSONArray a(Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (!paramObject.getClass().isArray()) {
      throw new JSONException("Not a primitive array: " + paramObject.getClass());
    }
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(a(Array.get(paramObject, i)));
      i += 1;
    }
    return localJSONArray;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    QQToastNotifier localQQToastNotifier = new QQToastNotifier(paramActivity);
    int i = paramActivity.getResources().getDimensionPixelSize(2131558448);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    default: 
      localQQToastNotifier.a(2131434466, i, 0, 1);
      return;
    case 2: 
      localQQToastNotifier.a("该群群主拒绝添加任何成员", i, 0, 1);
      return;
    case 3: 
      localQQToastNotifier.a("你的操作太频繁，请稍后再试!", i, 0, 1);
      return;
    case 4: 
      localQQToastNotifier.a("你输入的群号码无效", i, 0, 1);
      return;
    case 5: 
      localQQToastNotifier.a("该群不存在或者被删除", i, 0, 1);
      return;
    }
    localQQToastNotifier.a(2131434432, i, 0, 1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = ContactUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, false);
    Intent localIntent = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramContext);
    localIntent.putExtra("isBack2Root", true);
    ((Context)localObject).startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (TroopAppMgr)paramQQAppInterface.getManager(108);
    if (paramString2 != null) {
      if (!((TroopManager)paramQQAppInterface.getManager(51)).b(paramString1).isHomeworkTroop()) {
        break label172;
      }
    }
    label172:
    for (int i = 32;; i = 0)
    {
      paramString2 = paramString2.a(1104864064, i);
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.url))) {}
      for (paramString2 = paramString2.url.replace("$GCODE$", paramString1);; paramString2 = null)
      {
        String str = paramString2;
        if (paramString2 == null) {
          str = a + paramString1;
        }
        localIntent.putExtra("url", str);
        paramActivity.startActivityForResult(localIntent, 12001);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", b + str);
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    String str = paramQQAppInterface.getAccount();
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = ((TicketManager)localObject).getSkey(str);
    localObject = ((TicketManager)localObject).getPskey(str, "connect.qq.com");
    localBundle.putString("Referer", "https://cgi.connect.qq.com/");
    localBundle.putString("Cookie", "p_skey=" + (String)localObject + ";p_uin=" + str + ";skey=" + paramQQAppInterface + ";uin=" + str);
    localStringBuilder.append("?");
    localStringBuilder.append("appid=" + paramString);
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put("BUNDLE", localBundle);
    paramQQAppInterface.put("CONTEXT", paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkApiState params = " + localBundle);
    }
    new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", paramCallback, paramInt, paramBundle).a(paramQQAppInterface);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, AvatarWallAdapter paramAvatarWallAdapter)
  {
    if (paramAvatarWallAdapter != null) {
      paramAvatarWallAdapter.a(paramArrayList, paramString3, paramString1, paramString2);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setTitle("已获得群号").setMessage("完善资料后系统已自动分配群号。你可以在管理群中，开启群号查找功能或修改其他查找方式。").setPositiveButton("我知道了", paramOnClickListener);
    paramActivity.show();
    TroopReportor.a("Grp_manage_new", "gainUin_msgBox", "exp", 0, 0, new String[] { String.valueOf(paramTroopInfo.troopuin), "", TroopReportor.a(paramTroopInfo, paramAppRuntime) });
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return false;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopOwner(paramString2);
  }
  
  public static boolean a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(51);
    paramString = localTroopManager.c(paramString);
    if (paramString != null) {
      return paramString.hasSetTroopHead();
    }
    return (TroopHandler.a) && (localTroopManager.b());
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() < 1);
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    if (StringUtil.a(paramString)) {
      return 0;
    }
    int j = 5381;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return true;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopAdmin(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils
 * JD-Core Version:    0.7.0.1
 */