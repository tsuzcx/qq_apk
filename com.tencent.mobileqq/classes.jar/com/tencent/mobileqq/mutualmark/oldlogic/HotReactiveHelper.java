package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public class HotReactiveHelper
{
  static String jdField_a_of_type_JavaLangString = "HotReactiveHelper";
  private static final HashSet<ExtensionInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static boolean jdField_a_of_type_Boolean;
  static String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static boolean jdField_b_of_type_Boolean;
  static String c = jdField_b_of_type_JavaLangString + "/Tencent/MobileQQ/";
  static String d = c + "hotimage/";
  static String e = "friendshipres/";
  static String f = "friendshipres2/";
  static String g = "poke/";
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public static int a()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = TimeFormatterUtils.a(l);
    int k = TimeFormatterUtils.b(l);
    int j = ((23 - i) * 60 + (60 - k)) * 60;
    k = (60 - k + (17 - i) * 60) * 60;
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive", 2, "contact resume  offlast=" + j + "off18last=" + k);
    }
    if (i >= 18) {
      return j;
    }
    return k;
  }
  
  public static String a()
  {
    return VFSAssistantUtils.getSDKPrivatePath(d);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str2 = "";
    String str1 = str2;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type=" + paramInt + "getHotSmallChatConfig=" + str1);
      }
      return str1;
      str1 = localSharedPreferences.getString("hot_friend_chat_num_des", paramContext.getString(2131691171));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_up", paramContext.getString(2131693061));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_up", paramContext.getString(2131693075));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_up", paramContext.getString(2131693044));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_up2", paramContext.getString(2131693062));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_up2", paramContext.getString(2131693076));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_up2", paramContext.getString(2131693045));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_down", paramContext.getString(2131693057));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_down", paramContext.getString(2131693071));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_down", paramContext.getString(2131693042));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_dis", paramContext.getString(2131693059));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_dis", paramContext.getString(2131693073));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_dis", paramContext.getString(2131693043));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_down_remind", paramContext.getString(2131693072));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praise_dis_remind", paramContext.getString(2131693074));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_down_remind", paramContext.getString(2131693058));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_dis_remind", paramContext.getString(2131693060));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_qozne_down_remind", paramContext.getString(2131693077));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_qzone_dis_remind", paramContext.getString(2131693078));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praiseandchat_dis_remind", paramContext.getString(2131693055));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praiseandqone_dis_remind", paramContext.getString(2131693070));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chatandqzone_dis_remind", paramContext.getString(2131693056));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_pcqall_dis_remind", paramContext.getString(2131693069));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_up", paramContext.getString(2131693087));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_down", paramContext.getString(2131693081));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_dis", paramContext.getString(2131693082));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_up2", paramContext.getString(2131693088));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_close", paramContext.getString(2131693079));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_close2", paramContext.getString(2131693080));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_open", paramContext.getString(2131693083));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_open2", paramContext.getString(2131693084));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_update", paramContext.getString(2131693085));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_update2", paramContext.getString(2131693086));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up", paramContext.getString(2131693066));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up2", paramContext.getString(2131693067));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up3", paramContext.getString(2131693068));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down", paramContext.getString(2131693063));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down2", paramContext.getString(2131693064));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down3", paramContext.getString(2131693065));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_small_close_setting", paramContext.getString(2131719118));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_big_close_setting", paramContext.getString(2131719117));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade", paramContext.getString(2131693039));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade2", paramContext.getString(2131693040));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade3", paramContext.getString(2131693041));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_downgrade", paramContext.getString(2131693037));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_downgrade2", paramContext.getString(2131693038));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_1_upgrade", paramContext.getString(2131693047));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_1_will_downgrade", paramContext.getString(2131693048));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_1_downgrade", paramContext.getString(2131693046));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_upgrade", paramContext.getString(2131693050));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_will_downgrade", paramContext.getString(2131693051));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_downgrade", paramContext.getString(2131693049));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_upgrade", paramContext.getString(2131693053));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_will_downgrade", paramContext.getString(2131693054));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_downgrade", paramContext.getString(2131693052));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover1Upgrade", paramContext.getString(2131693262));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover2Upgrade", paramContext.getString(2131693264));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover2Downgrade", paramContext.getString(2131693263));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover3Downgrade", paramContext.getString(2131693265));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy1Upgrade", paramContext.getString(2131693254));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy2Upgrade", paramContext.getString(2131693256));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy2Downgrade", paramContext.getString(2131693255));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy3Downgrade", paramContext.getString(2131693257));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro1Upgrade", paramContext.getString(2131693258));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro2Upgrade", paramContext.getString(2131693260));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro2Downgrade", paramContext.getString(2131693259));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro3Downgrade", paramContext.getString(2131693261));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BestFriend1Upgrade", paramContext.getString(2131693249));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BestFriend2Upgrade", paramContext.getString(2131693251));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BestFriend2Downgrade", paramContext.getString(2131693250));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BestFriend3Downgrade", paramContext.getString(2131693252));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BindTip", paramContext.getString(2131693253));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind1Tip", paramContext.getString(2131693266));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind2Tip", paramContext.getString(2131693267));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind3Tip", paramContext.getString(2131693268));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BecomeGrayTip", paramContext.getString(2131693247));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BecomeLightTip", paramContext.getString(2131693248));
      continue;
      str1 = localSharedPreferences.getString("show_hot_friend_reactive_will_downgrade_push_tip", paramContext.getString(2131693246));
    }
  }
  
  public static HashSet<ExtensionInfo> a()
  {
    return jdField_a_of_type_JavaUtilHashSet;
  }
  
  public static List<HotReactiveHelper.HighLightUrlPattern> a(Context paramContext, String paramString)
  {
    paramContext = new ArrayList();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= 0)
      {
        i = paramString.indexOf("(", j);
        if (i >= 0) {
          break label53;
        }
      }
      label53:
      int k;
      do
      {
        do
        {
          localHighLightUrlPattern = new HotReactiveHelper.HighLightUrlPattern();
          localHighLightUrlPattern.jdField_a_of_type_JavaLangString = paramString;
          paramContext.add(0, localHighLightUrlPattern);
          return paramContext;
          j = paramString.indexOf(")[", i);
        } while (j < 0);
        k = paramString.indexOf("]", j);
      } while (k < 0);
      HotReactiveHelper.HighLightUrlPattern localHighLightUrlPattern = new HotReactiveHelper.HighLightUrlPattern();
      localHighLightUrlPattern.jdField_a_of_type_JavaLangString = paramString.substring(i + 1, j);
      localHighLightUrlPattern.jdField_a_of_type_Int = i;
      localHighLightUrlPattern.jdField_b_of_type_JavaLangString = paramString.substring(j + 2, k);
      paramString = paramString.replace(paramString.substring(i, k + 1), localHighLightUrlPattern.jdField_a_of_type_JavaLangString);
      j = localHighLightUrlPattern.jdField_a_of_type_JavaLangString.length() + k;
      paramContext.add(localHighLightUrlPattern);
    }
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramString1;
    String str2;
    if (paramString1.contains("#likepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 6L, 1L);
      str1 = paramString1.replace("#likepic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 6L, 1L);
      paramString1 = str1.replace("#praisepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#likepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 6L, 2L);
      str1 = paramString1.replace("#likepic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 6L, 2L);
      paramString1 = str1.replace("#praisepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#chatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 5L, 1L);
      str1 = paramString1.replace("#chatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#chatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 5L, 2L);
      paramString1 = str1.replace("#chatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#oftenchatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 12L, 1L);
      str1 = paramString1.replace("#oftenchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#oftenchatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 12L, 2L);
      paramString1 = str1.replace("#oftenchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverchatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 7L, 1L);
      str1 = paramString1.replace("#loverchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverchatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 7L, 2L);
      paramString1 = str1.replace("#loverchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 8L, 1L);
      str1 = paramString1.replace("#qzonechatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 8L, 1L);
      paramString1 = str1.replace("#qzonepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 8L, 2L);
      str1 = paramString1.replace("#qzonechatpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 8L, 2L);
      paramString1 = str1.replace("#qzonepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 4L, 1L);
      str1 = paramString1.replace("#friendshipicon1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#friendshipicon2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 4L, 2L);
      paramString1 = str1.replace("#friendshipicon2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon3"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 4L, 3L);
      str1 = paramString1.replace("#friendshipicon3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 1L, 0L);
      paramString1 = str1.replace("#loverpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 1L, 1L);
      str1 = paramString1.replace("#loverpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic3"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 1L, 2L);
      paramString1 = str1.replace("#loverpic3", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 2L, 0L);
      str1 = paramString1.replace("#sisterpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#sisterpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 2L, 1L);
      paramString1 = str1.replace("#sisterpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic3"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 2L, 2L);
      str1 = paramString1.replace("#sisterpic3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 3L, 0L);
      paramString1 = str1.replace("#brotherpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#brotherpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 3L, 1L);
      str1 = paramString1.replace("#brotherpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic3"))
    {
      paramQQAppInterface = MutualMarkConfigHelper.a(paramQQAppInterface, paramString2, 3L, 2L);
      paramString1 = str1.replace("#brotherpic3", paramQQAppInterface);
      localArrayList.add(paramQQAppInterface);
    }
    localArrayList.add(0, paramString1);
    return localArrayList;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FriendsManager paramFriendsManager)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString1;
    if (paramString1.contains("#likelevel1")) {
      str = paramString1.replace("#likelevel1", "" + paramFriendsManager.e);
    }
    paramString1 = str;
    if (str.contains("#likelevel2")) {
      paramString1 = str.replace("#likelevel2", "" + paramFriendsManager.f);
    }
    str = paramString1;
    if (paramString1.contains("#chatlevel1")) {
      str = paramString1.replace("#chatlevel1", "" + paramFriendsManager.jdField_a_of_type_Int);
    }
    paramString1 = str;
    if (str.contains("#chatlevel2")) {
      paramString1 = str.replace("#chatlevel2", "" + paramFriendsManager.b);
    }
    str = paramString1;
    if (paramString1.contains("#oftenchat1")) {
      str = paramString1.replace("#oftenchat1", "" + paramFriendsManager.g);
    }
    paramString1 = str;
    if (str.contains("#oftenchat2")) {
      paramString1 = str.replace("#oftenchat2", "" + paramFriendsManager.h);
    }
    str = paramString1;
    if (paramString1.contains("#loveroftenchat1")) {
      str = paramString1.replace("#loveroftenchat1", "" + paramFriendsManager.c);
    }
    paramString1 = str;
    if (str.contains("#loveroftenchat2")) {
      paramString1 = str.replace("#loveroftenchat2", "" + paramFriendsManager.d);
    }
    str = paramString1;
    if (paramString1.contains("#qzonelevel1")) {
      str = paramString1.replace("#qzonelevel1", "" + paramFriendsManager.i);
    }
    paramString1 = str;
    if (str.contains("#qzonelevel2")) {
      paramString1 = str.replace("#qzonelevel2", "" + paramFriendsManager.j);
    }
    str = paramString1;
    if (paramString1.contains("#friendshipday1")) {
      str = paramString1.replace("#friendshipday1", "" + paramFriendsManager.l);
    }
    paramString1 = str;
    if (str.contains("#friendshipday2")) {
      paramString1 = str.replace("#friendshipday2", "" + paramFriendsManager.m);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#likename1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 6L, 1L);
      paramFriendsManager = paramString1.replace("#likename1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#praisename1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 6L, 1L);
      paramString1 = paramFriendsManager.replace("#praisename1", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#likename2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 6L, 2L);
      paramFriendsManager = paramString1.replace("#likename2", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#praisename2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 6L, 2L);
      paramString1 = paramFriendsManager.replace("#praisename2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#chatname1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 5L, 1L);
      paramFriendsManager = paramString1.replace("#chatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#chatname2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 5L, 2L);
      paramString1 = paramFriendsManager.replace("#chatname2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#oftenchatname1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 12L, 1L);
      paramFriendsManager = paramString1.replace("#oftenchatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#oftenchatname2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 12L, 2L);
      paramString1 = paramFriendsManager.replace("#oftenchatname2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#loverchatname1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 7L, 1L);
      paramFriendsManager = paramString1.replace("#loverchatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#loverchatname2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 7L, 2L);
      paramString1 = paramFriendsManager.replace("#loverchatname2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#qzonename1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 8L, 1L);
      paramFriendsManager = paramString1.replace("#qzonename1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#qzonename2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 8L, 2L);
      paramString1 = paramFriendsManager.replace("#qzonename2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#friendshipname1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 4L, 1L);
      paramFriendsManager = paramString1.replace("#friendshipname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#friendshipname2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 4L, 2L);
      paramString1 = paramFriendsManager.replace("#friendshipname2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#friendshipname3"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 4L, 3L);
      paramFriendsManager = paramString1.replace("#friendshipname3", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#lovername1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 1L, 0L);
      paramString1 = paramFriendsManager.replace("#lovername1", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#lovername2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 1L, 1L);
      paramFriendsManager = paramString1.replace("#lovername2", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#lovername3"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 1L, 2L);
      paramString1 = paramFriendsManager.replace("#lovername3", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#sistername1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 2L, 0L);
      paramFriendsManager = paramString1.replace("#sistername1", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#sistername2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 2L, 1L);
      paramString1 = paramFriendsManager.replace("#sistername2", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#sistername3"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 2L, 2L);
      paramFriendsManager = paramString1.replace("#sistername3", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#brothername1"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 3L, 0L);
      paramString1 = paramFriendsManager.replace("#brothername1", str);
      localArrayList.add(str);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#brothername2"))
    {
      str = MutualMarkConfigHelper.a(paramQQAppInterface, 3L, 1L);
      paramFriendsManager = paramString1.replace("#brothername2", str);
      localArrayList.add(str);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#brothername3"))
    {
      paramQQAppInterface = MutualMarkConfigHelper.a(paramQQAppInterface, 3L, 2L);
      paramString1 = paramFriendsManager.replace("#brothername3", paramQQAppInterface);
      localArrayList.add(paramQQAppInterface);
    }
    localArrayList.add(0, paramString1.replace(HardCodeUtil.a(2131705633), paramString2));
    return localArrayList;
  }
  
  public static void a(Context paramContext, FriendsManager paramFriendsManager, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "updateIntimateRelationshipConfig begin  keys.length" + paramArrayOfString1.length + " values.length" + paramArrayOfString2.length);
    }
    paramFriendsManager.n = paramInt1;
    paramFriendsManager.o = paramInt2;
    paramFriendsManager.p = paramInt3;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (paramInt1 > 0) {
      paramContext.putInt("hot_intimate_min_days", paramInt1);
    }
    if (paramInt2 > 0) {
      paramContext.putInt("hot_intimate_max_days", paramInt2);
    }
    if (paramInt3 > 0) {
      paramContext.putInt("hot_intimate_day_msg_count", paramInt3);
    }
    if (paramArrayOfString1.length != paramArrayOfString2.length) {
      throw new RuntimeException("updateIntimateRelationshipConfig keys.length != values.length");
    }
    paramInt2 = paramArrayOfString1.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString2[paramInt1])) {
        paramContext.putString(paramArrayOfString1[paramInt1], paramArrayOfString2[paramInt1]);
      }
      paramInt1 += 1;
    }
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "updateIntimateRelationshipConfig end");
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("show_hot_friend_reactive_will_downgrade_push_tip", paramString);
      paramContext.commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up2", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up3", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down2", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down3", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade2", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade3", paramString9);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_downgrade", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_downgrade2", paramString11);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_graytip_priase_down_remind", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_graytip_praise_dis_remind", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_graytip_chat_down_remind", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_graytip_chat_dis_remind", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_graytip_qozne_down_remind", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_graytip_qzone_dis_remind", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_graytip_praiseandchat_dis_remind", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_graytip_chatandqzone_dis_remind", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_graytip_praiseandqone_dis_remind", paramString9);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_graytip_pcqall_dis_remind", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friendship_graytips_1_will_downgrade", paramString11);
    }
    if (!TextUtils.isEmpty(paramString12)) {
      paramContext.putString("hot_friendship_graytips_2_will_downgrade", paramString12);
    }
    if (!TextUtils.isEmpty(paramString13)) {
      paramContext.putString("hot_friendship_graytips_3_will_downgrade", paramString13);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_svip_key", paramString1);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_unionvip_key", paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_svip_setting", paramString3);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_unionvip_setting", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_key", paramString5);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_unionvip_key", paramString6);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_svip_key", paramString7);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_unionvip_key", paramString8);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_svip_setting", paramString9);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_unionvip_setting", paramString10);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_svip_setting", paramString11);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_unionvip_setting", paramString12);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_setting", paramString13);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_setting", paramString14);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_svip_setting", paramString15);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_unionvip_setting", paramString16);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_1_vip_type", paramString17);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_2_vip_type", paramString18);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_3_vip_type", paramString19);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_1_vip_setting", paramString20);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_2_vip_setting", paramString21);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_3_vip_setting", paramString22);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_graytip_chat_up", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_graytip_priase_up", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_graytip_close_up", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_graytip_lover_up", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_graytip_qzone_up", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_graytip_chat_up2", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_graytip_priase_up2", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_graytip_close_up2", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_graytip_lover_up2", paramString9);
    }
    if (!TextUtils.isEmpty(paramString21)) {
      paramContext.putString("hot_friend_graytip_lover_close", paramString21);
    }
    if (!TextUtils.isEmpty(paramString22)) {
      paramContext.putString("hot_friend_graytip_lover_close2", paramString22);
    }
    if (!TextUtils.isEmpty(paramString23)) {
      paramContext.putString("hot_friend_graytip_lover_open", paramString23);
    }
    if (!TextUtils.isEmpty(paramString24)) {
      paramContext.putString("hot_friend_graytip_lover_open2", paramString24);
    }
    if (!TextUtils.isEmpty(paramString25)) {
      paramContext.putString("hot_friend_graytip_lover_update", paramString25);
    }
    if (!TextUtils.isEmpty(paramString26)) {
      paramContext.putString("hot_friend_graytip_lover_update2", paramString26);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_graytip_qzone_up2", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friend_graytip_chat_down", paramString11);
    }
    if (!TextUtils.isEmpty(paramString12)) {
      paramContext.putString("hot_friend_graytip_priase_down", paramString12);
    }
    if (!TextUtils.isEmpty(paramString13)) {
      paramContext.putString("hot_friend_graytip_close_down", paramString13);
    }
    if (!TextUtils.isEmpty(paramString14)) {
      paramContext.putString("hot_friend_graytip_lover_down", paramString14);
    }
    if (!TextUtils.isEmpty(paramString15)) {
      paramContext.putString("hot_friend_graytip_qzone_down", paramString15);
    }
    if (!TextUtils.isEmpty(paramString16)) {
      paramContext.putString("hot_friend_graytip_chat_dis", paramString16);
    }
    if (!TextUtils.isEmpty(paramString17)) {
      paramContext.putString("hot_friend_graytip_priase_dis", paramString17);
    }
    if (!TextUtils.isEmpty(paramString18)) {
      paramContext.putString("hot_friend_graytip_close_dis", paramString18);
    }
    if (!TextUtils.isEmpty(paramString19)) {
      paramContext.putString("hot_friend_graytip_lover_dis", paramString19);
    }
    if (!TextUtils.isEmpty(paramString20)) {
      paramContext.putString("hot_friend_graytip_qzone_dis", paramString20);
    }
    if (!TextUtils.isEmpty(paramString27)) {
      paramContext.putString("hot_friendship_1_upgrade", paramString27);
    }
    if (!TextUtils.isEmpty(paramString28)) {
      paramContext.putString("hot_friendship_graytips_1_downgrade", paramString28);
    }
    if (!TextUtils.isEmpty(paramString29)) {
      paramContext.putString("hot_friendship_graytips_2_upgrade", paramString29);
    }
    if (!TextUtils.isEmpty(paramString30)) {
      paramContext.putString("hot_friendship_graytips_2_downgrade", paramString30);
    }
    if (!TextUtils.isEmpty(paramString31)) {
      paramContext.putString("hot_friendship_graytips_3_upgrade", paramString31);
    }
    if (!TextUtils.isEmpty(paramString32)) {
      paramContext.putString("hot_friendship_graytips_3_downgrade", paramString32);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    jdField_a_of_type_Boolean = paramBoolean;
    jdField_b_of_type_Boolean = true;
    paramContext.putBoolean("hot_friend_new_boat_big_use_new", jdField_a_of_type_Boolean);
    paramContext.putString("hot_friend_new_boat_small_close_setting", paramString1);
    paramContext.putString("hot_friend_new_boat_big_close_setting", paramString2);
    paramContext.putString("hot_friend_new_boat_small_close_key", paramString3);
    paramContext.putString("hot_friend_new_boat_big_close_key", paramString4);
    paramContext.commit();
  }
  
  public static void a(SharedPreferences paramSharedPreferences, FriendsManager paramFriendsManager)
  {
    int i = paramSharedPreferences.getInt("hot_intimate_min_days", paramFriendsManager.n);
    if (i > 0) {
      paramFriendsManager.n = i;
    }
    i = paramSharedPreferences.getInt("hot_intimate_max_days", paramFriendsManager.o);
    if (i > 0) {
      paramFriendsManager.o = i;
    }
    i = paramSharedPreferences.getInt("hot_intimate_day_msg_count", paramFriendsManager.p);
    if (i > 0) {
      paramFriendsManager.p = i;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parsNewBoatConfig:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("useBoat", 1);
        String str1 = paramString.optString("boatSSetting", "");
        String str2 = paramString.optString("boatBSetting", "");
        String str3 = paramString.optString("boatSName", "");
        String str4 = paramString.optString("boatBName", "");
        Object localObject = paramQQAppInterface.getApp();
        if (i == 1)
        {
          a((Context)localObject, bool, str1, str2, str3, str4);
          str1 = paramString.optString("grayBoatUp", "");
          str2 = paramString.optString("grayBoat2Up", "");
          str3 = paramString.optString("grayBoat3Up", "");
          str4 = paramString.optString("grayBoatDeg", "");
          localObject = paramString.optString("grayBoat2Deg", "");
          String str5 = paramString.optString("grayBoat3Deg", "");
          String str6 = paramString.optString("grayComingUp", "");
          String str7 = paramString.optString("grayComing2Up", "");
          String str8 = paramString.optString("grayComing3Up", "");
          String str9 = paramString.optString("grayComingDeg", "");
          paramString = paramString.optString("grayComing2Deg", "");
          a(paramQQAppInterface.getApp(), str1, str2, str3, str4, (String)localObject, str5, str6, str7, str8, str9, paramString);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "parsNewBoatConfig:error->" + paramQQAppInterface.toString());
      }
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parsXMLConfig: {\n" + paramString + "\n}");
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        new HashMap();
        localHashMap2 = new HashMap();
        localHashMap1 = new HashMap();
        localObject30 = "";
        localObject31 = "";
        i10 = 7;
        i11 = 30;
        i12 = 6;
        localObject32 = "";
        localObject33 = "";
        localObject34 = "";
        localObject35 = "";
        localObject36 = "";
        localObject37 = "";
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i24 = localXmlPullParser.getEventType();
        bool2 = false;
        i8 = 7;
        localObject18 = "";
        i9 = 3;
        localObject19 = "";
        localObject20 = "";
        localObject21 = "";
        localObject22 = "";
        localObject23 = "";
        localObject24 = "";
        localObject25 = "";
        localObject26 = "";
        localObject27 = "";
        localObject28 = "";
        localObject29 = "";
        localObject17 = "";
        i5 = 30;
        localObject13 = "";
        localObject14 = "";
        bool1 = false;
        i6 = 30;
        localObject12 = "";
        i = 30;
        localObject6 = "";
        m = 3;
        localObject5 = "";
        i2 = 3;
        i3 = 0;
        localObject10 = "";
        i4 = 3;
        localObject11 = "";
        localObject9 = "";
        localObject7 = "";
        i1 = 30;
        localObject8 = "";
        n = 5;
        localObject3 = "";
        k = 30;
        localObject4 = "";
        j = 7;
        localObject15 = "";
        i7 = 30;
        localObject16 = "";
        localObject1 = "";
        localObject2 = "";
      }
      catch (Exception paramQQAppInterface)
      {
        HashMap localHashMap2;
        HashMap localHashMap1;
        Object localObject30;
        Object localObject31;
        int i10;
        int i11;
        int i12;
        Object localObject32;
        Object localObject33;
        Object localObject34;
        Object localObject35;
        Object localObject36;
        Object localObject37;
        boolean bool2;
        boolean bool1;
        Object localObject51;
        Object localObject44;
        Object localObject45;
        Object localObject46;
        Object localObject47;
        Object localObject48;
        Object localObject49;
        Object localObject50;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString, paramQQAppInterface);
        return;
      }
      int i24 = localXmlPullParser.next();
      int i13 = k;
      int i14 = i5;
      Object localObject38 = localObject14;
      localObject51 = localObject17;
      Object localObject14 = localObject18;
      Object localObject17 = localObject19;
      Object localObject41 = localObject20;
      Object localObject42 = localObject21;
      Object localObject43 = localObject22;
      localObject44 = localObject23;
      localObject45 = localObject24;
      localObject46 = localObject25;
      localObject47 = localObject26;
      localObject48 = localObject1;
      int i5 = i6;
      Object localObject39 = localObject27;
      localObject49 = localObject2;
      int i6 = j;
      Object localObject18 = localObject6;
      Object localObject6 = localObject9;
      int j = i3;
      Object localObject19 = localObject12;
      int i3 = i;
      Object localObject40 = localObject28;
      localObject50 = localObject8;
      int i = i4;
      Object localObject8 = localObject13;
      int i15 = m;
      Object localObject12 = localObject4;
      int k = i8;
      Object localObject4 = localObject29;
      int i8 = i1;
      Object localObject13 = localObject10;
      int i16 = i2;
      Object localObject1 = localObject16;
      Object localObject2 = localObject15;
      int i2 = i9;
      int i4 = i7;
      int i9 = i14;
      int i1 = i;
      int m = j;
      int i7 = i16;
      j = i8;
      i = n;
      int n = i15;
      Object localObject20 = localObject51;
      Object localObject21 = localObject14;
      Object localObject22 = localObject17;
      Object localObject23 = localObject41;
      Object localObject24 = localObject42;
      Object localObject25 = localObject43;
      Object localObject26 = localObject44;
      Object localObject27 = localObject45;
      Object localObject28 = localObject46;
      Object localObject29 = localObject47;
      localObject17 = localObject48;
      localObject14 = localObject49;
      Object localObject9 = localObject3;
      Object localObject3 = localObject12;
      Object localObject10 = localObject5;
      localObject12 = localObject18;
      localObject18 = localObject7;
      Object localObject7 = localObject50;
      Object localObject15 = localObject13;
      Object localObject16 = localObject11;
      Object localObject5 = localObject19;
      localObject19 = localObject38;
      localObject13 = localObject39;
      Object localObject11 = localObject40;
      i8 = i13;
      break label30006;
      localObject38 = localXmlPullParser.getName();
      if (((String)localObject38).equalsIgnoreCase("ShowInContact"))
      {
        if (Integer.valueOf(localXmlPullParser.nextText()).intValue() == 1) {
          bool2 = true;
        }
      }
      else
      {
        if (((String)localObject38).equalsIgnoreCase("ShowInChat"))
        {
          if (Integer.valueOf(localXmlPullParser.nextText()).intValue() != 1) {
            break label30815;
          }
          bool1 = true;
          break label30815;
        }
        int i17;
        int i18;
        int i19;
        int i23;
        int i21;
        int i20;
        int i22;
        if (((String)localObject38).equalsIgnoreCase("minInteractiveDays"))
        {
          i2 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i2 <= 0)
          {
            i13 = i8;
            localObject41 = localObject17;
            i2 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i15 = 3;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i14 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i13;
            m = n;
            n = i1;
            i1 = i2;
            i2 = i8;
            i5 = i9;
            i8 = i14;
            i9 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxInteractiveDays"))
        {
          k = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (k <= 0)
          {
            k = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = 30;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minLoverInteractiveDays"))
        {
          i8 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i8 <= 0)
          {
            i16 = 3;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i16;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxLoverInteractiveDays"))
        {
          i6 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i6 <= 0)
          {
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            i17 = 30;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            j = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = j;
            j = i17;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minLinkDays"))
        {
          i4 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i4 <= 0)
          {
            localObject41 = localObject17;
            i4 = j;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i16 = 3;
            i15 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i5 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i14 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i15;
            k = i8;
            m = n;
            n = i1;
            i1 = i4;
            i2 = i7;
            i4 = i5;
            i5 = i9;
            i7 = i16;
            i8 = i14;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxLinkDays"))
        {
          i5 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i5 <= 0)
          {
            i5 = i9;
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i13 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i16 = 30;
            localObject39 = localObject11;
            i7 = i4;
            i6 = i3;
            i9 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i6;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i13;
            i6 = i16;
            i8 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minIntimacyDays"))
        {
          i9 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i9 <= 0)
          {
            i16 = 3;
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i13 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i9 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i13;
            i5 = i16;
            i8 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxIntimacyDays"))
        {
          i1 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i1 <= 0)
          {
            i14 = i8;
            localObject41 = localObject17;
            i1 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i4 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i5 = 30;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i2 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i4;
            k = i14;
            m = n;
            n = i2;
            i2 = i8;
            i4 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minQzoneVisitDays"))
        {
          m = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (m <= 0)
          {
            m = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i5 = 3;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i3;
            k = m;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i3 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxQzoneVisitDays"))
        {
          i7 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i7 <= 0)
          {
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i16 = 30;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i16;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxRemindTimes"))
        {
          n = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (n <= 0)
          {
            n = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            i2 = 5;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = n;
            m = i2;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else
        {
          if (((String)localObject38).equalsIgnoreCase("fireNumDescription"))
          {
            localObject41 = localXmlPullParser.nextText();
            i15 = i8;
            localObject2 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject17 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseUpgrade"))
          {
            localHashMap2.put("grayPraiseUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatUpgrade"))
          {
            localHashMap2.put("grayChatUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseUpgrade"))
          {
            localHashMap2.put("grayCloseUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpgrade"))
          {
            localHashMap2.put("grayQzoneLoverUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitUpgrade"))
          {
            localHashMap2.put("grayQzoneVisitUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraise2Upgrade"))
          {
            localHashMap2.put("grayPraiseUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChat2Upgrade"))
          {
            localHashMap2.put("grayChatUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColse2Upgrade"))
          {
            localHashMap2.put("grayCloseUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLover2Upgrade"))
          {
            localHashMap2.put("grayQzoneLoverUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisit2Upgrade"))
          {
            localHashMap2.put("grayQzoneVisitUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDegrade"))
          {
            localHashMap2.put("grayPriaseDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDegrade"))
          {
            localHashMap2.put("grayChatDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseDegrade"))
          {
            localHashMap2.put("grayCloseDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverDegrade"))
          {
            localHashMap2.put("grayQzoneLoverDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverOpen"))
          {
            localHashMap2.put("grayQzoneLoverOpen", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverOpen2"))
          {
            localHashMap2.put("grayQzoneLoverOpen2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpdate"))
          {
            localHashMap2.put("grayQzoneLoverUpdate", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpdate2"))
          {
            localHashMap2.put("grayQzoneLoverUpdate2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverClose"))
          {
            localHashMap2.put("grayQzoneLoverClose", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverClose2"))
          {
            localHashMap2.put("grayQzoneLoverClose2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitDegrade"))
          {
            localHashMap2.put("grayQzoneVisitDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDis"))
          {
            localHashMap2.put("grayPriaseDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDis"))
          {
            localHashMap2.put("grayChatDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseDis"))
          {
            localHashMap2.put("grayCloseDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverDis"))
          {
            localHashMap2.put("grayQzoneLoverDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitDis"))
          {
            localHashMap2.put("grayQzoneVisitDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDegradeRemind"))
          {
            localObject38 = localXmlPullParser.nextText();
            localObject19 = localObject22;
            localObject22 = localObject38;
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject22;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDisRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject8 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject43 = localObject9;
            localObject13 = localObject40;
            i4 = i1;
            localObject9 = localObject7;
            localObject11 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject8;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject8 = localObject9;
            localObject9 = localObject11;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDegradeRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject5 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject40;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject5;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDisRemind"))
          {
            localObject16 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneDegradeRemind"))
          {
            localObject15 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneDisRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject6 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject40;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject6;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatAndPraiseRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            localObject7 = localObject18;
            i15 = i8;
            localObject18 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject40;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject18;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatAnQzoneRemind"))
          {
            localObject38 = localXmlPullParser.nextText();
            localObject18 = localObject21;
            localObject21 = localObject38;
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject21;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseAndQzoneRemind"))
          {
            localObject39 = localXmlPullParser.nextText();
            i15 = i8;
            localObject12 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject14 = localObject39;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject41 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject12;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject14;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject41;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPCQallRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            localObject10 = localObject15;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            localObject11 = localObject40;
            i5 = i3;
            i13 = i2;
            localObject43 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject15 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject11;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1Upgrade"))
          {
            localHashMap2.put("graytipFriendship1Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1WillDowngrade"))
          {
            localObject41 = localXmlPullParser.nextText();
            i15 = i8;
            localObject3 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject41;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject3;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1Downgrade"))
          {
            localHashMap2.put("graytipFriendship1Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2Upgrade"))
          {
            localHashMap2.put("graytipFriendship2Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2WillDowngrade"))
          {
            localObject43 = localXmlPullParser.nextText();
            i15 = i8;
            localObject9 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject11 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject9;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject9 = localObject11;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2Downgrade"))
          {
            localHashMap2.put("graytipFriendship2Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3Upgrade"))
          {
            localHashMap2.put("graytipFriendship3Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3WillDowngrade"))
          {
            localObject43 = localXmlPullParser.nextText();
            localObject14 = localObject19;
            i15 = i8;
            localObject19 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject41 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject19;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject41;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3Downgrade"))
          {
            localHashMap2.put("graytipFriendship3Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("friendshipMinDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 <= 0) {
              break label31052;
            }
            j = i13;
            break label31052;
          }
          if (((String)localObject38).equalsIgnoreCase("friendshipMaxDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 <= 0) {
              break label31289;
            }
            i = i13;
            break label31289;
          }
          if (((String)localObject38).equalsIgnoreCase("friendship"))
          {
            i16 = Integer.parseInt(localXmlPullParser.nextText());
            i14 = i8;
            localObject41 = localObject17;
            i3 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i5 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i16;
            k = i14;
            m = n;
            n = i1;
            i1 = i3;
            i2 = i8;
            i3 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("intimateMinDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 > 0)
            {
              i10 = i13;
              break label31526;
            }
          }
          else
          {
            if (((String)localObject38).equalsIgnoreCase("intimateMaxDays"))
            {
              i13 = Integer.parseInt(localXmlPullParser.nextText());
              if (i13 > 0)
              {
                i11 = i13;
                break label31763;
              }
            }
            else
            {
              if (((String)localObject38).equalsIgnoreCase("intimateDayMsgCount"))
              {
                i13 = Integer.parseInt(localXmlPullParser.nextText());
                if (i13 > 0)
                {
                  i12 = i13;
                  break label32000;
                }
              }
              else
              {
                if (((String)localObject38).equalsIgnoreCase("graytipLover1Upgrade"))
                {
                  localHashMap1.put("graytipLover1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover2Upgrade"))
                {
                  localHashMap1.put("graytipLover2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover2Downgrade"))
                {
                  localHashMap1.put("graytipLover2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover3Downgrade"))
                {
                  localHashMap1.put("graytipLover3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy1Upgrade"))
                {
                  localHashMap1.put("graytipBuddy1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy2Upgrade"))
                {
                  localHashMap1.put("graytipBuddy2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy2Downgrade"))
                {
                  localHashMap1.put("graytipBuddy2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy3Downgrade"))
                {
                  localHashMap1.put("graytipBuddy3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro1Upgrade"))
                {
                  localHashMap1.put("graytipLadyBro1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro2Upgrade"))
                {
                  localHashMap1.put("graytipLadyBro2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro2Downgrade"))
                {
                  localHashMap1.put("graytipLadyBro2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro3Downgrade"))
                {
                  localHashMap1.put("graytipLadyBro3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBestFriend1Upgrade"))
                {
                  localHashMap1.put("graytipBestFriend1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBestFriend2Upgrade"))
                {
                  localHashMap1.put("graytipBestFriend2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBestFriend2Downgrade"))
                {
                  localHashMap1.put("graytipBestFriend2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBestFriend3Downgrade"))
                {
                  localHashMap1.put("graytipBestFriend3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBindTip"))
                {
                  localHashMap1.put("graytipIntimateshipBindTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind1Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind1Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind2Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind2Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind3Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind3Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBecomeGrayTip"))
                {
                  localHashMap1.put("graytipIntimateshipBecomeGrayTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBecomeLightTip"))
                {
                  localHashMap1.put("graytipIntimateshipBecomeLightTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipWillDowngradeWording"))
                {
                  localObject41 = localXmlPullParser.nextText();
                  localObject17 = localObject20;
                  i15 = i8;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject20 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatSVipKey"))
                {
                  localObject40 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject4 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  i16 = k;
                  localObject5 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject4;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject4 = localObject5;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatUnionVipKey"))
                {
                  localObject39 = localXmlPullParser.nextText();
                  i15 = i8;
                  i8 = j;
                  localObject11 = localObject16;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject43 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject16 = localObject1;
                  localObject1 = localObject17;
                  localObject2 = localObject42;
                  localObject3 = localObject43;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatSVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatUnionVipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject40 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject29 = localObject13;
                  i6 = i5;
                  localObject38 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject39 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject40;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject43;
                  localObject27 = localObject29;
                  localObject28 = localObject38;
                  localObject29 = localObject39;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseSvipKey"))
                {
                  localObject28 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseUnionVipKey"))
                {
                  localObject27 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseSVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject26 = localObject29;
                  localObject29 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject29;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseUnionVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject25 = localObject28;
                  localObject28 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject28;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover1VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject32 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject32;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject32 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover2VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject33 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject33;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject33 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover3VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject34 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject34;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject34 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover1VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject35 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject35;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject35 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover2VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject36 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject36;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject36 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover3VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject37 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject37;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject37 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject24 = localObject27;
                  localObject27 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject27;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatUnionVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject23 = localObject26;
                  localObject26 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject26;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject22 = localObject25;
                  localObject25 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject25;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatUnionVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject21 = localObject24;
                  localObject24 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject24;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject20 = localObject23;
                  localObject23 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject23;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseUnionSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject1 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject43;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseSVipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject30 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject30;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject30 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                i17 = i2;
                i13 = k;
                i18 = i4;
                i19 = i5;
                i23 = i9;
                i16 = i1;
                i14 = m;
                i21 = i7;
                i15 = n;
                i20 = i6;
                i22 = i8;
                if (!((String)localObject38).equalsIgnoreCase("bigCloseUnionSetting")) {
                  break label30128;
                }
                localObject43 = localXmlPullParser.nextText();
                i15 = i8;
                localObject31 = localObject17;
                i8 = j;
                i14 = i7;
                j = i6;
                localObject42 = localObject14;
                localObject38 = localObject13;
                i6 = i5;
                localObject39 = localObject11;
                i7 = i4;
                i5 = i3;
                i13 = i2;
                localObject11 = localObject9;
                localObject13 = localObject8;
                i4 = i1;
                localObject8 = localObject7;
                localObject9 = localObject6;
                i1 = i;
                localObject14 = localObject5;
                i3 = m;
                localObject40 = localObject4;
                i16 = k;
                localObject4 = localObject3;
                localObject41 = localObject2;
                localObject17 = localObject1;
                localObject1 = localObject31;
                localObject2 = localObject42;
                localObject3 = localObject11;
                localObject5 = localObject10;
                localObject6 = localObject12;
                localObject7 = localObject18;
                localObject10 = localObject15;
                localObject11 = localObject16;
                localObject12 = localObject14;
                localObject14 = localObject19;
                localObject15 = localObject41;
                localObject31 = localObject43;
                localObject16 = localObject17;
                localObject17 = localObject20;
                localObject18 = localObject21;
                localObject19 = localObject22;
                localObject20 = localObject23;
                localObject21 = localObject24;
                localObject22 = localObject25;
                localObject23 = localObject26;
                localObject24 = localObject27;
                localObject25 = localObject28;
                localObject26 = localObject29;
                localObject27 = localObject38;
                localObject28 = localObject39;
                localObject29 = localObject40;
                i = i5;
                k = i15;
                m = n;
                n = i1;
                i1 = i8;
                i2 = i14;
                i5 = i9;
                i8 = i16;
                i9 = i13;
                continue;
                localObject38 = i2 + "|" + k + "|" + i4 + "|" + i5 + "|" + i9 + "|" + i1 + "|" + m + "|" + i7 + "|" + n + "|" + i8 + "|" + i6 + "|" + j + "|" + i;
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRespGetHotDaysConfig success：showInContact|ShowInChat|settingdays=" + bool2 + "|" + bool1 + "|" + (String)localObject38 + "version=" + paramInt + "maxRemindTimes=" + n);
                }
                SharedPreUtils.r(paramQQAppInterface.getApp(), paramInt, paramQQAppInterface.getCurrentAccountUin());
                SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), bool2, bool1, (String)localObject38);
                SharedPreUtils.t(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), i3);
                localObject38 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                ((FriendsManager)localObject38).a(bool2, bool1, i2, k, i4, i5, i9, i1, m, i7, j, i, n);
                a(paramQQAppInterface.getApp(), (String)localObject4, (String)localObject11, (String)localObject13, (String)localObject29, (String)localObject28, (String)localObject27, (String)localObject26, (String)localObject25, (String)localObject24, (String)localObject23, (String)localObject22, (String)localObject21, (String)localObject20, (String)localObject1, (String)localObject30, (String)localObject31, (String)localObject32, (String)localObject33, (String)localObject34, (String)localObject35, (String)localObject36, (String)localObject37);
                b(paramQQAppInterface.getApp(), (String)localObject2);
                a(paramQQAppInterface.getApp(), (String)localHashMap2.get("grayChatUp"), (String)localHashMap2.get("grayPraiseUp"), (String)localHashMap2.get("grayCloseUp"), (String)localHashMap2.get("grayQzoneLoverUp"), (String)localHashMap2.get("grayQzoneVisitUp"), (String)localHashMap2.get("grayChatUp2"), (String)localHashMap2.get("grayPraiseUp2"), (String)localHashMap2.get("grayCloseUp2"), (String)localHashMap2.get("grayQzoneLoverUp2"), (String)localHashMap2.get("grayQzoneVisitUp2"), (String)localHashMap2.get("grayChatDown"), (String)localHashMap2.get("grayPriaseDown"), (String)localHashMap2.get("grayCloseDown"), (String)localHashMap2.get("grayQzoneLoverDown"), (String)localHashMap2.get("grayQzoneVisitDown"), (String)localHashMap2.get("grayChatDis"), (String)localHashMap2.get("grayPriaseDis"), (String)localHashMap2.get("grayCloseDis"), (String)localHashMap2.get("grayQzoneLoverDis"), (String)localHashMap2.get("grayQzoneVisitDis"), (String)localHashMap2.get("grayQzoneLoverClose"), (String)localHashMap2.get("grayQzoneLoverClose2"), (String)localHashMap2.get("grayQzoneLoverOpen"), (String)localHashMap2.get("grayQzoneLoverOpen2"), (String)localHashMap2.get("grayQzoneLoverUpdate"), (String)localHashMap2.get("grayQzoneLoverUpdate2"), (String)localHashMap2.get("graytipFriendship1Upgrade"), (String)localHashMap2.get("graytipFriendship1Downgrade"), (String)localHashMap2.get("graytipFriendship2Upgrade"), (String)localHashMap2.get("graytipFriendship2Downgrade"), (String)localHashMap2.get("graytipFriendship3Upgrade"), (String)localHashMap2.get("graytipFriendship3Downgrade"));
                a(paramQQAppInterface.getApp(), (String)localObject19, (String)localObject8, (String)localObject5, (String)localObject16, (String)localObject15, (String)localObject6, (String)localObject7, (String)localObject18, (String)localObject12, (String)localObject10, (String)localObject3, (String)localObject9, (String)localObject14);
                localObject1 = paramQQAppInterface.getApp();
                localObject2 = (String)localHashMap1.get("graytipLover1Upgrade");
                localObject3 = (String)localHashMap1.get("graytipLover2Upgrade");
                localObject4 = (String)localHashMap1.get("graytipLover2Downgrade");
                localObject5 = (String)localHashMap1.get("graytipLover3Downgrade");
                localObject6 = (String)localHashMap1.get("graytipBuddy1Upgrade");
                localObject7 = (String)localHashMap1.get("graytipBuddy2Upgrade");
                localObject8 = (String)localHashMap1.get("graytipBuddy2Downgrade");
                localObject9 = (String)localHashMap1.get("graytipBuddy3Downgrade");
                localObject10 = (String)localHashMap1.get("graytipLadyBro1Upgrade");
                localObject11 = (String)localHashMap1.get("graytipLadyBro2Upgrade");
                localObject12 = (String)localHashMap1.get("graytipLadyBro2Downgrade");
                localObject13 = (String)localHashMap1.get("graytipLadyBro3Downgrade");
                localObject14 = (String)localHashMap1.get("graytipBestFriend1Upgrade");
                localObject15 = (String)localHashMap1.get("graytipBestFriend2Upgrade");
                localObject16 = (String)localHashMap1.get("graytipBestFriend2Downgrade");
                localObject18 = (String)localHashMap1.get("graytipBestFriend3Downgrade");
                localObject19 = (String)localHashMap1.get("graytipIntimateshipBindTip");
                localObject20 = (String)localHashMap1.get("graytipIntimateshipUnBind1Tip");
                localObject21 = (String)localHashMap1.get("graytipIntimateshipUnBind2Tip");
                localObject22 = (String)localHashMap1.get("graytipIntimateshipUnBind3Tip");
                localObject23 = (String)localHashMap1.get("graytipIntimateshipBecomeGrayTip");
                localObject24 = (String)localHashMap1.get("graytipIntimateshipBecomeLightTip");
                a((Context)localObject1, (FriendsManager)localObject38, i10, i11, i12, new String[] { "hot_intimate_Lover1Upgrade", "hot_intimate_Lover2Upgrade", "hot_intimate_Lover2Downgrade", "hot_intimate_Lover3Downgrade", "hot_intimate_Buddy1Upgrade", "hot_intimate_Buddy2Upgrade", "hot_intimate_Buddy2Downgrade", "hot_intimate_Buddy3Downgrade", "hot_intimate_LadyBro1Upgrade", "hot_intimate_LadyBro2Upgrade", "hot_intimate_LadyBro2Downgrade", "hot_intimate_LadyBro3Downgrade", "hot_intimate_BestFriend1Upgrade", "hot_intimate_BestFriend2Upgrade", "hot_intimate_BestFriend2Downgrade", "hot_intimate_BestFriend3Downgrade", "hot_intimate_BindTip", "hot_intimate_UnBind1Tip", "hot_intimate_UnBind2Tip", "hot_intimate_UnBind3Tip", "hot_intimate_BecomeGrayTip", "hot_intimate_BecomeLightTip" }, new String[] { localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24 });
                a(paramQQAppInterface.getApp(), (String)localObject17);
                return;
              }
              break label32000;
            }
            break label31763;
          }
          break label31526;
          label30006:
          if (i24 == 1) {
            continue;
          }
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
        }
        switch (i24)
        {
        case 2: 
        default: 
          i22 = i8;
          i20 = i6;
          i15 = n;
          i21 = i7;
          i14 = m;
          i16 = i1;
          i23 = i9;
          i19 = i5;
          i18 = i4;
          i13 = k;
          i17 = i2;
        case 3: 
          i5 = i23;
          k = i22;
          localObject41 = localObject17;
          i1 = j;
          i2 = i21;
          j = i20;
          localObject43 = localObject14;
          localObject38 = localObject13;
          i6 = i19;
          localObject39 = localObject11;
          i7 = i18;
          m = i3;
          i9 = i17;
          localObject11 = localObject9;
          localObject13 = localObject8;
          i4 = i16;
          localObject8 = localObject7;
          localObject9 = localObject6;
          n = i;
          localObject14 = localObject5;
          i3 = i14;
          localObject40 = localObject4;
          i8 = i13;
          localObject4 = localObject3;
          localObject42 = localObject2;
          localObject17 = localObject1;
          localObject1 = localObject41;
          localObject2 = localObject43;
          localObject3 = localObject11;
          localObject5 = localObject10;
          localObject6 = localObject12;
          localObject7 = localObject18;
          localObject10 = localObject15;
          localObject11 = localObject16;
          localObject12 = localObject14;
          localObject14 = localObject19;
          localObject15 = localObject42;
          localObject16 = localObject17;
          localObject17 = localObject20;
          localObject18 = localObject21;
          localObject19 = localObject22;
          localObject20 = localObject23;
          localObject21 = localObject24;
          localObject22 = localObject25;
          localObject23 = localObject26;
          localObject24 = localObject27;
          localObject25 = localObject28;
          localObject26 = localObject29;
          localObject27 = localObject38;
          localObject28 = localObject39;
          localObject29 = localObject40;
          i = m;
          m = i15;
          break;
        case 4: 
          label30128:
          i15 = i8;
          localObject41 = localObject17;
          i8 = j;
          i14 = i7;
          j = i6;
          localObject43 = localObject14;
          localObject38 = localObject13;
          i6 = i5;
          localObject39 = localObject11;
          i7 = i4;
          i5 = i3;
          i13 = i2;
          localObject11 = localObject9;
          localObject13 = localObject8;
          i4 = i1;
          localObject8 = localObject7;
          localObject9 = localObject6;
          i1 = i;
          localObject14 = localObject5;
          i3 = m;
          localObject40 = localObject4;
          i16 = k;
          localObject4 = localObject3;
          localObject42 = localObject2;
          localObject17 = localObject1;
          localObject1 = localObject41;
          localObject2 = localObject43;
          localObject3 = localObject11;
          localObject5 = localObject10;
          localObject6 = localObject12;
          localObject7 = localObject18;
          localObject10 = localObject15;
          localObject11 = localObject16;
          localObject12 = localObject14;
          localObject14 = localObject19;
          localObject15 = localObject42;
          localObject16 = localObject17;
          localObject17 = localObject20;
          localObject18 = localObject21;
          localObject19 = localObject22;
          localObject20 = localObject23;
          localObject21 = localObject24;
          localObject22 = localObject25;
          localObject23 = localObject26;
          localObject24 = localObject27;
          localObject25 = localObject28;
          localObject26 = localObject29;
          localObject27 = localObject38;
          localObject28 = localObject39;
          localObject29 = localObject40;
          i = i5;
          k = i15;
          m = n;
          n = i1;
          i1 = i8;
          i2 = i14;
          i5 = i9;
          i8 = i16;
          i9 = i13;
          break;
        }
      }
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label30815:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label31052:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label31289:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label31526:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label31763:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label32000:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
    }
  }
  
  public static void a(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo != null) {
      jdField_a_of_type_JavaUtilHashSet.add(paramExtensionInfo);
    }
  }
  
  public static boolean a()
  {
    if (jdField_b_of_type_Boolean) {
      return jdField_a_of_type_Boolean;
    }
    jdField_a_of_type_Boolean = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("hot_friend_new_boat_big_use_new", false);
    jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isNewVersionBoat local:" + jdField_a_of_type_Boolean);
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {}
    while ((paramInt < 18) || (paramInt >= 24) || (TimeFormatterUtils.c(paramLong) == 2131719984)) {
      return false;
    }
    return true;
  }
  
  public static int b()
  {
    return TimeFormatterUtils.a(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static String b()
  {
    String str = a();
    return str + e;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.putString("hot_friend_chat_num_des", paramString);
    }
    paramContext.commit();
  }
  
  public static String c()
  {
    String str = a();
    return str + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper
 * JD-Core Version:    0.7.0.1
 */