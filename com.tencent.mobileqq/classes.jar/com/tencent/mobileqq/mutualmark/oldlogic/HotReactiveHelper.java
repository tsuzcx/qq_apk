package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.AppInterface;
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
  static String a = "HotReactiveHelper";
  static String b = Environment.getExternalStorageDirectory().getAbsolutePath();
  static String c;
  static String d;
  static String e = "friendshipres/";
  static String f = "friendshipres2/";
  static String g = "poke/";
  private static boolean h = false;
  private static boolean i = false;
  private static final HashSet<ExtensionInfo> j = new HashSet();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("/Tencent/MobileQQ/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("hotimage/");
    d = localStringBuilder.toString();
  }
  
  public static int a()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    int n = TimeFormatterUtils.a(l);
    int k = 60 - TimeFormatterUtils.b(l);
    int m = ((23 - n) * 60 + k) * 60;
    k = ((17 - n) * 60 + k) * 60;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("contact resume  offlast=");
      localStringBuilder.append(m);
      localStringBuilder.append("off18last=");
      localStringBuilder.append(k);
      QLog.d("FriendReactive", 2, localStringBuilder.toString());
    }
    if (n >= 18) {
      k = m;
    }
    return k;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (paramInt != 97)
    {
      if (paramInt != 134) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        paramContext = "";
                        break;
                      case 171: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BestFriend3Downgrade", paramContext.getString(2131890746));
                        break;
                      case 170: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BestFriend2Downgrade", paramContext.getString(2131890744));
                        break;
                      case 169: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BestFriend2Upgrade", paramContext.getString(2131890745));
                        break;
                      case 168: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BestFriend1Upgrade", paramContext.getString(2131890743));
                        break;
                      case 167: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BecomeLightTip", paramContext.getString(2131890742));
                        break;
                      case 166: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BecomeGrayTip", paramContext.getString(2131890741));
                        break;
                      case 165: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_UnBind3Tip", paramContext.getString(2131890762));
                        break;
                      case 164: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_UnBind2Tip", paramContext.getString(2131890761));
                        break;
                      case 163: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_UnBind1Tip", paramContext.getString(2131890760));
                        break;
                      case 162: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_BindTip", paramContext.getString(2131890747));
                        break;
                      case 161: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_LadyBro3Downgrade", paramContext.getString(2131890755));
                        break;
                      case 160: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_LadyBro2Downgrade", paramContext.getString(2131890753));
                        break;
                      case 159: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_LadyBro2Upgrade", paramContext.getString(2131890754));
                        break;
                      case 158: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_LadyBro1Upgrade", paramContext.getString(2131890752));
                        break;
                      case 157: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Buddy3Downgrade", paramContext.getString(2131890751));
                        break;
                      case 156: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Buddy2Downgrade", paramContext.getString(2131890749));
                        break;
                      case 155: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Buddy2Upgrade", paramContext.getString(2131890750));
                        break;
                      case 154: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Buddy1Upgrade", paramContext.getString(2131890748));
                        break;
                      case 153: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Lover3Downgrade", paramContext.getString(2131890759));
                        break;
                      case 152: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Lover2Downgrade", paramContext.getString(2131890757));
                        break;
                      case 151: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Lover2Upgrade", paramContext.getString(2131890758));
                        break;
                      case 150: 
                        paramContext = ((SharedPreferences)localObject).getString("hot_intimate_Lover1Upgrade", paramContext.getString(2131890756));
                      }
                      break;
                    case 107: 
                      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_3_downgrade", paramContext.getString(2131890126));
                      break;
                    case 106: 
                      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_3_will_downgrade", paramContext.getString(2131890128));
                      break;
                    case 105: 
                      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_3_upgrade", paramContext.getString(2131890127));
                      break;
                    case 104: 
                      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_2_downgrade", paramContext.getString(2131890123));
                      break;
                    case 103: 
                      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_2_will_downgrade", paramContext.getString(2131890125));
                    }
                    break;
                  case 101: 
                    paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_2_upgrade", paramContext.getString(2131890124));
                    break;
                  case 100: 
                    paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_1_downgrade", paramContext.getString(2131890120));
                    break;
                  case 99: 
                    paramContext = ((SharedPreferences)localObject).getString("hot_friendship_graytips_1_will_downgrade", paramContext.getString(2131890122));
                  }
                  break;
                case 90: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_big_close_setting", paramContext.getString(2131916367));
                  break;
                case 89: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_small_close_setting", paramContext.getString(2131916368));
                  break;
                case 88: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_upcoming_downgrade2", paramContext.getString(2131890112));
                  break;
                case 87: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_upcoming_downgrade", paramContext.getString(2131890111));
                  break;
                case 86: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_upcoming_upgrade3", paramContext.getString(2131890115));
                  break;
                case 85: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_upcoming_upgrade2", paramContext.getString(2131890114));
                  break;
                case 84: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_upcoming_upgrade", paramContext.getString(2131890113));
                  break;
                case 83: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_down3", paramContext.getString(2131890139));
                  break;
                case 82: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_down2", paramContext.getString(2131890138));
                  break;
                case 81: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_down", paramContext.getString(2131890137));
                  break;
                case 80: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_up3", paramContext.getString(2131890142));
                  break;
                case 79: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_up2", paramContext.getString(2131890141));
                  break;
                case 78: 
                  paramContext = ((SharedPreferences)localObject).getString("hot_friend_new_boat_graytip_close_up", paramContext.getString(2131890140));
                }
                break;
              case 74: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_update2", paramContext.getString(2131890160));
                break;
              case 73: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_update", paramContext.getString(2131890159));
                break;
              case 72: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_open2", paramContext.getString(2131890158));
                break;
              case 71: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_open", paramContext.getString(2131890157));
                break;
              case 70: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_close2", paramContext.getString(2131890154));
                break;
              case 69: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_close", paramContext.getString(2131890153));
                break;
              case 68: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_up2", paramContext.getString(2131890162));
                break;
              case 67: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_dis", paramContext.getString(2131890156));
                break;
              case 66: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_down", paramContext.getString(2131890155));
                break;
              case 65: 
                paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_lover_up", paramContext.getString(2131890161));
              }
              break;
            case 54: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_pcqall_dis_remind", paramContext.getString(2131890143));
              break;
            case 53: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_praiseandqone_dis_remind", paramContext.getString(2131890144));
              break;
            case 52: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chatandqzone_dis_remind", paramContext.getString(2131890130));
              break;
            case 51: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_praiseandchat_dis_remind", paramContext.getString(2131890129));
              break;
            case 50: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_qzone_dis_remind", paramContext.getString(2131890152));
              break;
            case 49: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_qozne_down_remind", paramContext.getString(2131890151));
              break;
            case 48: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_dis_remind", paramContext.getString(2131890134));
              break;
            case 47: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_down_remind", paramContext.getString(2131890132));
              break;
            case 46: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_praise_dis_remind", paramContext.getString(2131890148));
              break;
            case 45: 
              paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_priase_down_remind", paramContext.getString(2131890146));
            }
            break;
          case 43: 
            paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_close_up2", paramContext.getString(2131890119));
            break;
          case 42: 
            paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_priase_up2", paramContext.getString(2131890150));
            break;
          case 41: 
            paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_up2", paramContext.getString(2131890136));
          }
          break;
        case 28: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_close_dis", paramContext.getString(2131890117));
          break;
        case 27: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_priase_dis", paramContext.getString(2131890147));
          break;
        case 26: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_dis", paramContext.getString(2131890133));
          break;
        case 25: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_close_down", paramContext.getString(2131890116));
          break;
        case 24: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_priase_down", paramContext.getString(2131890145));
          break;
        case 23: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_down", paramContext.getString(2131890131));
          break;
        case 22: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_close_up", paramContext.getString(2131890118));
          break;
        case 21: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_priase_up", paramContext.getString(2131890149));
          break;
        case 20: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_graytip_chat_up", paramContext.getString(2131890135));
          break;
        case 19: 
          paramContext = ((SharedPreferences)localObject).getString("hot_friend_chat_num_des", paramContext.getString(2131888037));
          break;
        }
      } else {
        paramContext = ((SharedPreferences)localObject).getString("show_hot_friend_reactive_will_downgrade_push_tip", paramContext.getString(2131890740));
      }
    }
    else {
      paramContext = ((SharedPreferences)localObject).getString("hot_friendship_1_upgrade", paramContext.getString(2131890121));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("getHotSmallChatConfig=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, ((StringBuilder)localObject).toString());
    }
    return paramContext;
  }
  
  public static List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramString1;
    String str2;
    if (paramString1.contains("#likepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 6L, 1L);
      str1 = paramString1.replace("#likepic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 6L, 1L);
      paramString1 = str1.replace("#praisepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#likepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 6L, 2L);
      str1 = paramString1.replace("#likepic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 6L, 2L);
      paramString1 = str1.replace("#praisepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#chatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 5L, 1L);
      str1 = paramString1.replace("#chatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#chatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 5L, 2L);
      paramString1 = str1.replace("#chatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#oftenchatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 12L, 1L);
      str1 = paramString1.replace("#oftenchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#oftenchatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 12L, 2L);
      paramString1 = str1.replace("#oftenchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverchatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 7L, 1L);
      str1 = paramString1.replace("#loverchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverchatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 7L, 2L);
      paramString1 = str1.replace("#loverchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 8L, 1L);
      str1 = paramString1.replace("#qzonechatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 8L, 1L);
      paramString1 = str1.replace("#qzonepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 8L, 2L);
      str1 = paramString1.replace("#qzonechatpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 8L, 2L);
      paramString1 = str1.replace("#qzonepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 4L, 1L);
      str1 = paramString1.replace("#friendshipicon1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#friendshipicon2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 4L, 2L);
      paramString1 = str1.replace("#friendshipicon2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon3"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 4L, 3L);
      str1 = paramString1.replace("#friendshipicon3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 1L, 0L);
      paramString1 = str1.replace("#loverpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 1L, 1L);
      str1 = paramString1.replace("#loverpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic3"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 1L, 2L);
      paramString1 = str1.replace("#loverpic3", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 2L, 0L);
      str1 = paramString1.replace("#sisterpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#sisterpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 2L, 1L);
      paramString1 = str1.replace("#sisterpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic3"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 2L, 2L);
      str1 = paramString1.replace("#sisterpic3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic1"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 3L, 0L);
      paramString1 = str1.replace("#brotherpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#brotherpic2"))
    {
      str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 3L, 1L);
      str1 = paramString1.replace("#brotherpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic3"))
    {
      paramAppInterface = MutualMarkConfigHelper.a(paramAppInterface, paramString2, 3L, 2L);
      paramString1 = str1.replace("#brotherpic3", paramAppInterface);
      localArrayList.add(paramAppInterface);
    }
    localArrayList.add(0, paramString1);
    return localArrayList;
  }
  
  public static List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, FriendsManager paramFriendsManager)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramString1;
    if (paramString1.contains("#likelevel1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.f);
      localObject = paramString1.replace("#likelevel1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#likelevel2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.g);
      paramString1 = ((String)localObject).replace("#likelevel2", paramString1.toString());
    }
    localObject = paramString1;
    if (paramString1.contains("#chatlevel1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.b);
      localObject = paramString1.replace("#chatlevel1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#chatlevel2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.c);
      paramString1 = ((String)localObject).replace("#chatlevel2", paramString1.toString());
    }
    localObject = paramString1;
    if (paramString1.contains("#oftenchat1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.h);
      localObject = paramString1.replace("#oftenchat1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#oftenchat2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.i);
      paramString1 = ((String)localObject).replace("#oftenchat2", paramString1.toString());
    }
    localObject = paramString1;
    if (paramString1.contains("#loveroftenchat1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.d);
      localObject = paramString1.replace("#loveroftenchat1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#loveroftenchat2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.e);
      paramString1 = ((String)localObject).replace("#loveroftenchat2", paramString1.toString());
    }
    localObject = paramString1;
    if (paramString1.contains("#qzonelevel1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.j);
      localObject = paramString1.replace("#qzonelevel1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#qzonelevel2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.k);
      paramString1 = ((String)localObject).replace("#qzonelevel2", paramString1.toString());
    }
    localObject = paramString1;
    if (paramString1.contains("#friendshipday1"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramFriendsManager.m);
      localObject = paramString1.replace("#friendshipday1", ((StringBuilder)localObject).toString());
    }
    paramString1 = (String)localObject;
    if (((String)localObject).contains("#friendshipday2"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramFriendsManager.n);
      paramString1 = ((String)localObject).replace("#friendshipday2", paramString1.toString());
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#likename1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 6L, 1L);
      paramFriendsManager = paramString1.replace("#likename1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#praisename1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 6L, 1L);
      paramString1 = paramFriendsManager.replace("#praisename1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#likename2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 6L, 2L);
      paramFriendsManager = paramString1.replace("#likename2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#praisename2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 6L, 2L);
      paramString1 = paramFriendsManager.replace("#praisename2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#chatname1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 5L, 1L);
      paramFriendsManager = paramString1.replace("#chatname1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#chatname2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 5L, 2L);
      paramString1 = paramFriendsManager.replace("#chatname2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#oftenchatname1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 12L, 1L);
      paramFriendsManager = paramString1.replace("#oftenchatname1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#oftenchatname2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 12L, 2L);
      paramString1 = paramFriendsManager.replace("#oftenchatname2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#loverchatname1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 7L, 1L);
      paramFriendsManager = paramString1.replace("#loverchatname1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#loverchatname2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 7L, 2L);
      paramString1 = paramFriendsManager.replace("#loverchatname2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#qzonename1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 8L, 1L);
      paramFriendsManager = paramString1.replace("#qzonename1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#qzonename2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 8L, 2L);
      paramString1 = paramFriendsManager.replace("#qzonename2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#friendshipname1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 4L, 1L);
      paramFriendsManager = paramString1.replace("#friendshipname1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#friendshipname2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 4L, 2L);
      paramString1 = paramFriendsManager.replace("#friendshipname2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#friendshipname3"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 4L, 3L);
      paramFriendsManager = paramString1.replace("#friendshipname3", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#lovername1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 1L, 0L);
      paramString1 = paramFriendsManager.replace("#lovername1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#lovername2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 1L, 1L);
      paramFriendsManager = paramString1.replace("#lovername2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#lovername3"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 1L, 2L);
      paramString1 = paramFriendsManager.replace("#lovername3", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#sistername1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 2L, 0L);
      paramFriendsManager = paramString1.replace("#sistername1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#sistername2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 2L, 1L);
      paramString1 = paramFriendsManager.replace("#sistername2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#sistername3"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 2L, 2L);
      paramFriendsManager = paramString1.replace("#sistername3", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#brothername1"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 3L, 0L);
      paramString1 = paramFriendsManager.replace("#brothername1", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramFriendsManager = paramString1;
    if (paramString1.contains("#brothername2"))
    {
      localObject = MutualMarkConfigHelper.a(paramAppInterface, 3L, 1L);
      paramFriendsManager = paramString1.replace("#brothername2", (CharSequence)localObject);
      localArrayList.add(localObject);
    }
    paramString1 = paramFriendsManager;
    if (paramFriendsManager.contains("#brothername3"))
    {
      paramAppInterface = MutualMarkConfigHelper.a(paramAppInterface, 3L, 2L);
      paramString1 = paramFriendsManager.replace("#brothername3", paramAppInterface);
      localArrayList.add(paramAppInterface);
    }
    localArrayList.add(0, paramString1.replace(HardCodeUtil.a(2131903584), paramString2));
    return localArrayList;
  }
  
  public static void a(Context paramContext, FriendsManager paramFriendsManager, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateIntimateRelationshipConfig begin  keys.length");
      localStringBuilder.append(paramArrayOfString1.length);
      localStringBuilder.append(" values.length");
      localStringBuilder.append(paramArrayOfString2.length);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    paramFriendsManager.o = paramInt1;
    paramFriendsManager.p = paramInt2;
    paramFriendsManager.q = paramInt3;
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
    if (paramArrayOfString1.length == paramArrayOfString2.length)
    {
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
        QLog.i(a, 2, "updateIntimateRelationshipConfig end");
      }
      return;
    }
    paramContext = new RuntimeException("updateIntimateRelationshipConfig keys.length != values.length");
    for (;;)
    {
      throw paramContext;
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
    h = paramBoolean;
    i = true;
    paramContext.putBoolean("hot_friend_new_boat_big_use_new", h);
    paramContext.putString("hot_friend_new_boat_small_close_setting", paramString1);
    paramContext.putString("hot_friend_new_boat_big_close_setting", paramString2);
    paramContext.putString("hot_friend_new_boat_small_close_key", paramString3);
    paramContext.putString("hot_friend_new_boat_big_close_key", paramString4);
    paramContext.commit();
  }
  
  public static void a(SharedPreferences paramSharedPreferences, FriendsManager paramFriendsManager)
  {
    int k = paramSharedPreferences.getInt("hot_intimate_min_days", paramFriendsManager.o);
    if (k > 0) {
      paramFriendsManager.o = k;
    }
    k = paramSharedPreferences.getInt("hot_intimate_max_days", paramFriendsManager.p);
    if (k > 0) {
      paramFriendsManager.p = k;
    }
    k = paramSharedPreferences.getInt("hot_intimate_day_msg_count", paramFriendsManager.q);
    if (k > 0) {
      paramFriendsManager.q = k;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parsNewBoatConfig:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int k = paramString.optInt("useBoat", 1);
        localObject1 = paramString.optString("boatSSetting", "");
        localObject2 = paramString.optString("boatBSetting", "");
        String str1 = paramString.optString("boatSName", "");
        String str2 = paramString.optString("boatBName", "");
        Object localObject3 = paramQQAppInterface.getApp();
        if (k == 1)
        {
          bool = true;
          a((Context)localObject3, bool, (String)localObject1, (String)localObject2, str1, str2);
          localObject1 = paramString.optString("grayBoatUp", "");
          localObject2 = paramString.optString("grayBoat2Up", "");
          str1 = paramString.optString("grayBoat3Up", "");
          str2 = paramString.optString("grayBoatDeg", "");
          localObject3 = paramString.optString("grayBoat2Deg", "");
          String str3 = paramString.optString("grayBoat3Deg", "");
          String str4 = paramString.optString("grayComingUp", "");
          String str5 = paramString.optString("grayComing2Up", "");
          String str6 = paramString.optString("grayComing3Up", "");
          String str7 = paramString.optString("grayComingDeg", "");
          paramString = paramString.optString("grayComing2Deg", "");
          a(paramQQAppInterface.getApp(), (String)localObject1, (String)localObject2, str1, str2, (String)localObject3, str3, str4, str5, str6, str7, paramString);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramString = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parsNewBoatConfig:error->");
          ((StringBuilder)localObject1).append(paramQQAppInterface.toString());
          QLog.i(paramString, 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parsXMLConfig: {\n");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("\n}");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    label25090:
    label26125:
    label26766:
    label27407:
    label28051:
    for (;;)
    {
      try
      {
        new HashMap();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i16 = localXmlPullParser.getEventType();
        localObject37 = "";
        localObject36 = localObject37;
        localObject35 = localObject36;
        localObject34 = localObject35;
        localObject33 = localObject34;
        localObject32 = localObject33;
        localObject31 = localObject32;
        localObject30 = localObject31;
        localObject29 = localObject30;
        localObject28 = localObject29;
        localObject27 = localObject28;
        localObject26 = localObject27;
        localObject25 = localObject26;
        localObject24 = localObject25;
        localObject23 = localObject24;
        localObject22 = localObject23;
        localObject21 = localObject22;
        localObject20 = localObject21;
        localObject19 = localObject20;
        localObject18 = localObject19;
        localObject17 = localObject18;
        localObject16 = localObject17;
        localObject15 = localObject16;
        localObject14 = localObject15;
        localObject13 = localObject14;
        localObject12 = localObject13;
        localObject11 = localObject12;
        localObject10 = localObject11;
        localObject9 = localObject10;
        localObject8 = localObject9;
        localObject7 = localObject8;
        localObject6 = localObject7;
        localObject5 = localObject6;
        localObject4 = localObject5;
        localObject3 = localObject4;
        localObject2 = localObject3;
        localObject1 = localObject2;
        i15 = 30;
        i14 = 3;
        i13 = 3;
        n = 3;
        k = 30;
        i12 = 30;
        i11 = 3;
        i10 = 30;
        i9 = 5;
        i8 = 7;
        i7 = 30;
        i4 = 7;
        i3 = 30;
        boolean bool2 = false;
        boolean bool1 = false;
        i6 = 0;
        i5 = 7;
        i2 = 30;
        i1 = 6;
        if (i16 != 1)
        {
          if (i16 != 2)
          {
            m = i15;
            i16 = i14;
            i17 = i13;
            i18 = i12;
            i19 = i11;
            i20 = i10;
            i21 = i9;
            i22 = i8;
            i23 = i7;
            i24 = i4;
            i25 = i3;
            i26 = i6;
            localObject38 = localObject37;
            localObject39 = localObject36;
            localObject40 = localObject35;
            localObject41 = localObject34;
            localObject42 = localObject33;
            localObject43 = localObject32;
            localObject44 = localObject31;
            localObject45 = localObject30;
            localObject46 = localObject29;
            localObject47 = localObject28;
            localObject48 = localObject27;
            localObject49 = localObject26;
            localObject50 = localObject25;
            localObject51 = localObject24;
            localObject52 = localObject23;
            localObject53 = localObject22;
            localObject54 = localObject21;
            localObject55 = localObject20;
            localObject56 = localObject19;
            localObject57 = localObject18;
            localObject58 = localObject17;
            localObject59 = localObject16;
            localObject60 = localObject15;
            localObject61 = localObject14;
            localObject62 = localObject13;
            localObject63 = localObject12;
            localObject64 = localObject11;
            localObject65 = localObject10;
            localObject66 = localObject9;
            localObject67 = localObject8;
            localObject68 = localObject7;
            localObject69 = localObject6;
            localObject70 = localObject5;
            localObject71 = localObject4;
            localObject72 = localObject3;
            localObject73 = localObject2;
            i27 = i5;
            i28 = i2;
            i29 = i1;
            localObject74 = localObject1;
            break label27830;
          }
          String str = localXmlPullParser.getName();
          if (str.equalsIgnoreCase("ShowInContact"))
          {
            if (Integer.valueOf(localXmlPullParser.nextText()).intValue() == 1) {
              bool2 = true;
            }
          }
          else
          {
            if (str.equalsIgnoreCase("ShowInChat"))
            {
              if (Integer.valueOf(localXmlPullParser.nextText()).intValue() != 1) {
                break label25081;
              }
              bool1 = true;
              break label25081;
            }
            if (str.equalsIgnoreCase("minInteractiveDays"))
            {
              i19 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i19 > 0) {
                break label25090;
              }
              m = k;
              k = n;
              i11 = 3;
            }
            else if (str.equalsIgnoreCase("maxInteractiveDays"))
            {
              i18 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i18 > 0) {
                break label25297;
              }
              m = k;
              k = n;
              i12 = 30;
            }
            else if (str.equalsIgnoreCase("minLoverInteractiveDays"))
            {
              i22 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i22 > 0) {
                break label25504;
              }
              m = k;
              k = n;
              i8 = 3;
            }
            else if (str.equalsIgnoreCase("maxLoverInteractiveDays"))
            {
              i23 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i23 > 0) {
                break label25711;
              }
              m = k;
              k = n;
              i7 = 30;
            }
            else if (str.equalsIgnoreCase("minLinkDays"))
            {
              i17 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i17 > 0) {
                break label25918;
              }
              m = k;
              k = n;
              i13 = 3;
            }
            else if (str.equalsIgnoreCase("maxLinkDays"))
            {
              m = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (m > 0) {
                break label26125;
              }
              m = k;
              k = n;
              i15 = 30;
            }
            else if (str.equalsIgnoreCase("minIntimacyDays"))
            {
              i16 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i16 > 0) {
                break label26332;
              }
              m = k;
              k = n;
              i14 = 3;
            }
            else if (str.equalsIgnoreCase("maxIntimacyDays"))
            {
              i18 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i18 > 0) {
                break label26539;
              }
              k = n;
              m = 30;
            }
            else if (str.equalsIgnoreCase("minQzoneVisitDays"))
            {
              m = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (m > 0) {
                break label26546;
              }
              m = k;
              k = 3;
            }
            else if (str.equalsIgnoreCase("maxQzoneVisitDays"))
            {
              i20 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i20 > 0) {
                break label26559;
              }
              m = k;
              k = n;
              i10 = 30;
            }
            else if (str.equalsIgnoreCase("maxRemindTimes"))
            {
              i21 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              if (i21 > 0) {
                break label26766;
              }
              m = k;
              k = n;
              i9 = 5;
            }
            else
            {
              if (str.equalsIgnoreCase("fireNumDescription"))
              {
                localObject60 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseUpgrade"))
              {
                localHashMap1.put("grayPraiseUp", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatUpgrade"))
              {
                localHashMap1.put("grayChatUp", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayColseUpgrade"))
              {
                localHashMap1.put("grayCloseUp", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverUpgrade"))
              {
                localHashMap1.put("grayQzoneLoverUp", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneVisitUpgrade"))
              {
                localHashMap1.put("grayQzoneVisitUp", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraise2Upgrade"))
              {
                localHashMap1.put("grayPraiseUp2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChat2Upgrade"))
              {
                localHashMap1.put("grayChatUp2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayColse2Upgrade"))
              {
                localHashMap1.put("grayCloseUp2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLover2Upgrade"))
              {
                localHashMap1.put("grayQzoneLoverUp2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneVisit2Upgrade"))
              {
                localHashMap1.put("grayQzoneVisitUp2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseDegrade"))
              {
                localHashMap1.put("grayPriaseDown", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatDegrade"))
              {
                localHashMap1.put("grayChatDown", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayColseDegrade"))
              {
                localHashMap1.put("grayCloseDown", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverDegrade"))
              {
                localHashMap1.put("grayQzoneLoverDown", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverOpen"))
              {
                localHashMap1.put("grayQzoneLoverOpen", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverOpen2"))
              {
                localHashMap1.put("grayQzoneLoverOpen2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverUpdate"))
              {
                localHashMap1.put("grayQzoneLoverUpdate", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverUpdate2"))
              {
                localHashMap1.put("grayQzoneLoverUpdate2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverClose"))
              {
                localHashMap1.put("grayQzoneLoverClose", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverClose2"))
              {
                localHashMap1.put("grayQzoneLoverClose2", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneVisitDegrade"))
              {
                localHashMap1.put("grayQzoneVisitDown", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseDis"))
              {
                localHashMap1.put("grayPriaseDis", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatDis"))
              {
                localHashMap1.put("grayChatDis", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayColseDis"))
              {
                localHashMap1.put("grayCloseDis", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayLoverDis"))
              {
                localHashMap1.put("grayQzoneLoverDis", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneVisitDis"))
              {
                localHashMap1.put("grayQzoneVisitDis", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseDegradeRemind"))
              {
                localObject61 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseDisRemind"))
              {
                localObject62 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatDegradeRemind"))
              {
                localObject63 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatDisRemind"))
              {
                localObject64 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneDegradeRemind"))
              {
                localObject65 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayQzoneDisRemind"))
              {
                localObject66 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatAndPraiseRemind"))
              {
                localObject67 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayChatAnQzoneRemind"))
              {
                localObject68 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPraiseAndQzoneRemind"))
              {
                localObject69 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("grayPCQallRemind"))
              {
                localObject70 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship1Upgrade"))
              {
                localHashMap1.put("graytipFriendship1Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship1WillDowngrade"))
              {
                localObject71 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship1Downgrade"))
              {
                localHashMap1.put("graytipFriendship1Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship2Upgrade"))
              {
                localHashMap1.put("graytipFriendship2Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship2WillDowngrade"))
              {
                localObject72 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship2Downgrade"))
              {
                localHashMap1.put("graytipFriendship2Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship3Upgrade"))
              {
                localHashMap1.put("graytipFriendship3Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship3WillDowngrade"))
              {
                localObject73 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipFriendship3Downgrade"))
              {
                localHashMap1.put("graytipFriendship3Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("friendshipMinDays"))
              {
                m = Integer.parseInt(localXmlPullParser.nextText());
                if (m <= 0) {
                  break label26973;
                }
                break label26977;
              }
              if (str.equalsIgnoreCase("friendshipMaxDays"))
              {
                m = Integer.parseInt(localXmlPullParser.nextText());
                if (m <= 0) {
                  break label27188;
                }
                break label27192;
              }
              if (str.equalsIgnoreCase("friendship"))
              {
                i26 = Integer.parseInt(localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateMinDays"))
              {
                int i30 = Integer.parseInt(localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                if (i30 <= 0) {
                  break label27830;
                }
                i27 = i30;
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateMaxDays"))
              {
                m = Integer.parseInt(localXmlPullParser.nextText());
                if (m <= 0) {
                  break label27403;
                }
                break label27407;
              }
              if (str.equalsIgnoreCase("intimateDayMsgCount"))
              {
                m = Integer.parseInt(localXmlPullParser.nextText());
                if (m <= 0) {
                  break label27618;
                }
                break label27622;
              }
              if (str.equalsIgnoreCase("graytipLover1Upgrade"))
              {
                localHashMap2.put("graytipLover1Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLover2Upgrade"))
              {
                localHashMap2.put("graytipLover2Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLover2Downgrade"))
              {
                localHashMap2.put("graytipLover2Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLover3Downgrade"))
              {
                localHashMap2.put("graytipLover3Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBuddy1Upgrade"))
              {
                localHashMap2.put("graytipBuddy1Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBuddy2Upgrade"))
              {
                localHashMap2.put("graytipBuddy2Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBuddy2Downgrade"))
              {
                localHashMap2.put("graytipBuddy2Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBuddy3Downgrade"))
              {
                localHashMap2.put("graytipBuddy3Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLadyBro1Upgrade"))
              {
                localHashMap2.put("graytipLadyBro1Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLadyBro2Upgrade"))
              {
                localHashMap2.put("graytipLadyBro2Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLadyBro2Downgrade"))
              {
                localHashMap2.put("graytipLadyBro2Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipLadyBro3Downgrade"))
              {
                localHashMap2.put("graytipLadyBro3Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBestFriend1Upgrade"))
              {
                localHashMap2.put("graytipBestFriend1Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBestFriend2Upgrade"))
              {
                localHashMap2.put("graytipBestFriend2Upgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBestFriend2Downgrade"))
              {
                localHashMap2.put("graytipBestFriend2Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipBestFriend3Downgrade"))
              {
                localHashMap2.put("graytipBestFriend3Downgrade", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipBindTip"))
              {
                localHashMap2.put("graytipIntimateshipBindTip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipUnBind1Tip"))
              {
                localHashMap2.put("graytipIntimateshipUnBind1Tip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipUnBind2Tip"))
              {
                localHashMap2.put("graytipIntimateshipUnBind2Tip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipUnBind3Tip"))
              {
                localHashMap2.put("graytipIntimateshipUnBind3Tip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipBecomeGrayTip"))
              {
                localHashMap2.put("graytipIntimateshipBecomeGrayTip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipIntimateshipBecomeLightTip"))
              {
                localHashMap2.put("graytipIntimateshipBecomeLightTip", localXmlPullParser.nextText());
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("graytipWillDowngradeWording"))
              {
                localObject74 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallChatSVipKey"))
              {
                localObject38 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallChatUnionVipKey"))
              {
                localObject39 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigChatSVipKey"))
              {
                localObject40 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigChatUnionVipKey"))
              {
                localObject41 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallCloseSvipKey"))
              {
                localObject42 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallCloseUnionVipKey"))
              {
                localObject43 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigCloseSVipKey"))
              {
                localObject44 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigCloseUnionVipKey"))
              {
                localObject45 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover1VipKey"))
              {
                localObject54 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover2VipKey"))
              {
                localObject55 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover3VipKey"))
              {
                localObject56 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover1VipSetting"))
              {
                localObject57 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover2VipSetting"))
              {
                localObject58 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("intimateLover3VipSetting"))
              {
                localObject59 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallChatSVipSetting"))
              {
                localObject46 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallChatUnionVipSetting"))
              {
                localObject47 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigChatSVipSetting"))
              {
                localObject48 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigChatUnionVipSetting"))
              {
                localObject49 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallCloseSVipSetting"))
              {
                localObject50 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject51 = localObject24;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("smallCloseUnionSetting"))
              {
                localObject51 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject52 = localObject23;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              if (str.equalsIgnoreCase("bigCloseSVipSetting"))
              {
                localObject52 = localXmlPullParser.nextText();
                m = i15;
                i16 = i14;
                i17 = i13;
                i18 = i12;
                i19 = i11;
                i20 = i10;
                i21 = i9;
                i22 = i8;
                i23 = i7;
                i24 = i4;
                i25 = i3;
                i26 = i6;
                localObject38 = localObject37;
                localObject39 = localObject36;
                localObject40 = localObject35;
                localObject41 = localObject34;
                localObject42 = localObject33;
                localObject43 = localObject32;
                localObject44 = localObject31;
                localObject45 = localObject30;
                localObject46 = localObject29;
                localObject47 = localObject28;
                localObject48 = localObject27;
                localObject49 = localObject26;
                localObject50 = localObject25;
                localObject51 = localObject24;
                localObject53 = localObject22;
                localObject54 = localObject21;
                localObject55 = localObject20;
                localObject56 = localObject19;
                localObject57 = localObject18;
                localObject58 = localObject17;
                localObject59 = localObject16;
                localObject60 = localObject15;
                localObject61 = localObject14;
                localObject62 = localObject13;
                localObject63 = localObject12;
                localObject64 = localObject11;
                localObject65 = localObject10;
                localObject66 = localObject9;
                localObject67 = localObject8;
                localObject68 = localObject7;
                localObject69 = localObject6;
                localObject70 = localObject5;
                localObject71 = localObject4;
                localObject72 = localObject3;
                localObject73 = localObject2;
                i27 = i5;
                i28 = i2;
                i29 = i1;
                localObject74 = localObject1;
                break label27830;
              }
              m = i15;
              i16 = i14;
              i17 = i13;
              i18 = i12;
              i19 = i11;
              i20 = i10;
              i21 = i9;
              i22 = i8;
              i23 = i7;
              i24 = i4;
              i25 = i3;
              i26 = i6;
              localObject38 = localObject37;
              localObject39 = localObject36;
              localObject40 = localObject35;
              localObject41 = localObject34;
              localObject42 = localObject33;
              localObject43 = localObject32;
              localObject44 = localObject31;
              localObject45 = localObject30;
              localObject46 = localObject29;
              localObject47 = localObject28;
              localObject48 = localObject27;
              localObject49 = localObject26;
              localObject50 = localObject25;
              localObject51 = localObject24;
              localObject52 = localObject23;
              localObject53 = localObject22;
              localObject54 = localObject21;
              localObject55 = localObject20;
              localObject56 = localObject19;
              localObject57 = localObject18;
              localObject58 = localObject17;
              localObject59 = localObject16;
              localObject60 = localObject15;
              localObject61 = localObject14;
              localObject62 = localObject13;
              localObject63 = localObject12;
              localObject64 = localObject11;
              localObject65 = localObject10;
              localObject66 = localObject9;
              localObject67 = localObject8;
              localObject68 = localObject7;
              localObject69 = localObject6;
              localObject70 = localObject5;
              localObject71 = localObject4;
              localObject72 = localObject3;
              localObject73 = localObject2;
              i27 = i5;
              i28 = i2;
              i29 = i1;
              localObject74 = localObject1;
              if (!str.equalsIgnoreCase("bigCloseUnionSetting")) {
                break label27830;
              }
              localObject53 = localXmlPullParser.nextText();
              m = i15;
              i16 = i14;
              i17 = i13;
              i18 = i12;
              i19 = i11;
              i20 = i10;
              i21 = i9;
              i22 = i8;
              i23 = i7;
              i24 = i4;
              i25 = i3;
              i26 = i6;
              localObject38 = localObject37;
              localObject39 = localObject36;
              localObject40 = localObject35;
              localObject41 = localObject34;
              localObject42 = localObject33;
              localObject43 = localObject32;
              localObject44 = localObject31;
              localObject45 = localObject30;
              localObject46 = localObject29;
              localObject47 = localObject28;
              localObject48 = localObject27;
              localObject49 = localObject26;
              localObject50 = localObject25;
              localObject51 = localObject24;
              localObject52 = localObject23;
              localObject54 = localObject21;
              localObject55 = localObject20;
              localObject56 = localObject19;
              localObject57 = localObject18;
              localObject58 = localObject17;
              localObject59 = localObject16;
              localObject60 = localObject15;
              localObject61 = localObject14;
              localObject62 = localObject13;
              localObject63 = localObject12;
              localObject64 = localObject11;
              localObject65 = localObject10;
              localObject66 = localObject9;
              localObject67 = localObject8;
              localObject68 = localObject7;
              localObject69 = localObject6;
              localObject70 = localObject5;
              localObject71 = localObject4;
              localObject72 = localObject3;
              localObject73 = localObject2;
              i27 = i5;
              i28 = i2;
              i29 = i1;
              localObject74 = localObject1;
              break label27830;
            }
            i16 = localXmlPullParser.next();
            n = k;
            k = m;
          }
        }
        else
        {
          localObject38 = new StringBuilder();
          ((StringBuilder)localObject38).append(i11);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i12);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i13);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i15);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i14);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(k);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(n);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i10);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i9);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i8);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i7);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i4);
          ((StringBuilder)localObject38).append("|");
          ((StringBuilder)localObject38).append(i3);
          localObject38 = ((StringBuilder)localObject38).toString();
          if (!QLog.isColorLevel()) {
            break label28051;
          }
          localObject39 = a;
          localObject40 = new StringBuilder();
          ((StringBuilder)localObject40).append("handleRespGetHotDaysConfig success：showInContact|ShowInChat|settingdays=");
          ((StringBuilder)localObject40).append(bool2);
          ((StringBuilder)localObject40).append("|");
          ((StringBuilder)localObject40).append(bool1);
          ((StringBuilder)localObject40).append("|");
          ((StringBuilder)localObject40).append((String)localObject38);
          ((StringBuilder)localObject40).append("version=");
          ((StringBuilder)localObject40).append(paramInt);
          ((StringBuilder)localObject40).append("maxRemindTimes=");
          ((StringBuilder)localObject40).append(i9);
          QLog.d((String)localObject39, 2, ((StringBuilder)localObject40).toString());
          SharedPreUtils.q(paramQQAppInterface.getApp(), paramInt, paramQQAppInterface.getCurrentAccountUin());
          SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), bool2, bool1, (String)localObject38);
          SharedPreUtils.r(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), i6);
          localObject38 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          ((FriendsManager)localObject38).a(bool2, bool1, i11, i12, i13, i15, i14, k, n, i10, i4, i3, i9);
          a(paramQQAppInterface.getApp(), (String)localObject37, localObject36, localObject35, localObject34, localObject33, localObject32, localObject31, localObject30, localObject29, localObject28, localObject27, localObject26, localObject25, (String)localObject24, (String)localObject23, (String)localObject22, (String)localObject21, (String)localObject20, (String)localObject19, (String)localObject18, (String)localObject17, (String)localObject16);
          c(paramQQAppInterface.getApp(), (String)localObject15);
          a(paramQQAppInterface.getApp(), (String)localHashMap1.get("grayChatUp"), (String)localHashMap1.get("grayPraiseUp"), (String)localHashMap1.get("grayCloseUp"), (String)localHashMap1.get("grayQzoneLoverUp"), (String)localHashMap1.get("grayQzoneVisitUp"), (String)localHashMap1.get("grayChatUp2"), (String)localHashMap1.get("grayPraiseUp2"), (String)localHashMap1.get("grayCloseUp2"), (String)localHashMap1.get("grayQzoneLoverUp2"), (String)localHashMap1.get("grayQzoneVisitUp2"), (String)localHashMap1.get("grayChatDown"), (String)localHashMap1.get("grayPriaseDown"), (String)localHashMap1.get("grayCloseDown"), (String)localHashMap1.get("grayQzoneLoverDown"), (String)localHashMap1.get("grayQzoneVisitDown"), (String)localHashMap1.get("grayChatDis"), (String)localHashMap1.get("grayPriaseDis"), (String)localHashMap1.get("grayCloseDis"), (String)localHashMap1.get("grayQzoneLoverDis"), (String)localHashMap1.get("grayQzoneVisitDis"), (String)localHashMap1.get("grayQzoneLoverClose"), (String)localHashMap1.get("grayQzoneLoverClose2"), (String)localHashMap1.get("grayQzoneLoverOpen"), (String)localHashMap1.get("grayQzoneLoverOpen2"), (String)localHashMap1.get("grayQzoneLoverUpdate"), (String)localHashMap1.get("grayQzoneLoverUpdate2"), (String)localHashMap1.get("graytipFriendship1Upgrade"), (String)localHashMap1.get("graytipFriendship1Downgrade"), (String)localHashMap1.get("graytipFriendship2Upgrade"), (String)localHashMap1.get("graytipFriendship2Downgrade"), (String)localHashMap1.get("graytipFriendship3Upgrade"), (String)localHashMap1.get("graytipFriendship3Downgrade"));
          a(paramQQAppInterface.getApp(), (String)localObject14, (String)localObject13, (String)localObject12, (String)localObject11, (String)localObject10, (String)localObject9, (String)localObject8, (String)localObject7, (String)localObject6, (String)localObject5, (String)localObject4, (String)localObject3, (String)localObject2);
          localObject2 = paramQQAppInterface.getApp();
          localObject3 = (String)localHashMap2.get("graytipLover1Upgrade");
          localObject4 = (String)localHashMap2.get("graytipLover2Upgrade");
          localObject5 = (String)localHashMap2.get("graytipLover2Downgrade");
          localObject6 = (String)localHashMap2.get("graytipLover3Downgrade");
          localObject7 = (String)localHashMap2.get("graytipBuddy1Upgrade");
          localObject8 = (String)localHashMap2.get("graytipBuddy2Upgrade");
          localObject9 = (String)localHashMap2.get("graytipBuddy2Downgrade");
          localObject10 = (String)localHashMap2.get("graytipBuddy3Downgrade");
          localObject11 = (String)localHashMap2.get("graytipLadyBro1Upgrade");
          localObject12 = (String)localHashMap2.get("graytipLadyBro2Upgrade");
          localObject13 = (String)localHashMap2.get("graytipLadyBro2Downgrade");
          localObject14 = (String)localHashMap2.get("graytipLadyBro3Downgrade");
          localObject15 = (String)localHashMap2.get("graytipBestFriend1Upgrade");
          localObject16 = (String)localHashMap2.get("graytipBestFriend2Upgrade");
          localObject17 = (String)localHashMap2.get("graytipBestFriend2Downgrade");
          localObject18 = (String)localHashMap2.get("graytipBestFriend3Downgrade");
          localObject19 = (String)localHashMap2.get("graytipIntimateshipBindTip");
          localObject20 = (String)localHashMap2.get("graytipIntimateshipUnBind1Tip");
          localObject21 = (String)localHashMap2.get("graytipIntimateshipUnBind2Tip");
          localObject22 = (String)localHashMap2.get("graytipIntimateshipUnBind3Tip");
          localObject23 = (String)localHashMap2.get("graytipIntimateshipBecomeGrayTip");
          localObject24 = (String)localHashMap2.get("graytipIntimateshipBecomeLightTip");
          a((Context)localObject2, (FriendsManager)localObject38, i5, i2, i1, new String[] { "hot_intimate_Lover1Upgrade", "hot_intimate_Lover2Upgrade", "hot_intimate_Lover2Downgrade", "hot_intimate_Lover3Downgrade", "hot_intimate_Buddy1Upgrade", "hot_intimate_Buddy2Upgrade", "hot_intimate_Buddy2Downgrade", "hot_intimate_Buddy3Downgrade", "hot_intimate_LadyBro1Upgrade", "hot_intimate_LadyBro2Upgrade", "hot_intimate_LadyBro2Downgrade", "hot_intimate_LadyBro3Downgrade", "hot_intimate_BestFriend1Upgrade", "hot_intimate_BestFriend2Upgrade", "hot_intimate_BestFriend2Downgrade", "hot_intimate_BestFriend3Downgrade", "hot_intimate_BindTip", "hot_intimate_UnBind1Tip", "hot_intimate_UnBind2Tip", "hot_intimate_UnBind3Tip", "hot_intimate_BecomeGrayTip", "hot_intimate_BecomeLightTip" }, new String[] { localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24 });
          a(paramQQAppInterface.getApp(), (String)localObject1);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, paramString, paramQQAppInterface);
        }
        return;
      }
      int m = k;
      int k = n;
      continue;
      label25081:
      m = k;
      k = n;
      continue;
      m = i15;
      int i16 = i14;
      int i17 = i13;
      int i18 = i12;
      int i20 = i10;
      int i21 = i9;
      int i22 = i8;
      int i23 = i7;
      int i24 = i4;
      int i25 = i3;
      int i26 = i6;
      Object localObject38 = localObject37;
      Object localObject39 = localObject36;
      Object localObject40 = localObject35;
      Object localObject41 = localObject34;
      Object localObject42 = localObject33;
      Object localObject43 = localObject32;
      Object localObject44 = localObject31;
      Object localObject45 = localObject30;
      Object localObject46 = localObject29;
      Object localObject47 = localObject28;
      Object localObject48 = localObject27;
      Object localObject49 = localObject26;
      Object localObject50 = localObject25;
      Object localObject51 = localObject24;
      Object localObject52 = localObject23;
      Object localObject53 = localObject22;
      Object localObject54 = localObject21;
      Object localObject55 = localObject20;
      Object localObject56 = localObject19;
      Object localObject57 = localObject18;
      Object localObject58 = localObject17;
      Object localObject59 = localObject16;
      Object localObject60 = localObject15;
      Object localObject61 = localObject14;
      Object localObject62 = localObject13;
      Object localObject63 = localObject12;
      Object localObject64 = localObject11;
      Object localObject65 = localObject10;
      Object localObject66 = localObject9;
      Object localObject67 = localObject8;
      Object localObject68 = localObject7;
      Object localObject69 = localObject6;
      Object localObject70 = localObject5;
      Object localObject71 = localObject4;
      Object localObject72 = localObject3;
      Object localObject73 = localObject2;
      int i27 = i5;
      int i28 = i2;
      int i29 = i1;
      Object localObject74 = localObject1;
      break label27830;
      label25297:
      m = i15;
      i16 = i14;
      i17 = i13;
      int i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label25504:
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label25711:
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label25918:
      m = i15;
      i16 = i14;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label26332:
      m = i15;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label26539:
      m = i15;
      break label28037;
      label26546:
      int n = k;
      k = m;
      m = n;
      continue;
      label26559:
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label26973:
      m = i4;
      label26977:
      i24 = m;
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label27188:
      m = i3;
      label27192:
      i25 = m;
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i28 = i2;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      m = i2;
      i28 = m;
      m = i15;
      i16 = i14;
      i17 = i13;
      i18 = i12;
      i19 = i11;
      i20 = i10;
      i21 = i9;
      i22 = i8;
      i23 = i7;
      i24 = i4;
      i25 = i3;
      i26 = i6;
      localObject38 = localObject37;
      localObject39 = localObject36;
      localObject40 = localObject35;
      localObject41 = localObject34;
      localObject42 = localObject33;
      localObject43 = localObject32;
      localObject44 = localObject31;
      localObject45 = localObject30;
      localObject46 = localObject29;
      localObject47 = localObject28;
      localObject48 = localObject27;
      localObject49 = localObject26;
      localObject50 = localObject25;
      localObject51 = localObject24;
      localObject52 = localObject23;
      localObject53 = localObject22;
      localObject54 = localObject21;
      localObject55 = localObject20;
      localObject56 = localObject19;
      localObject57 = localObject18;
      localObject58 = localObject17;
      localObject59 = localObject16;
      localObject60 = localObject15;
      localObject61 = localObject14;
      localObject62 = localObject13;
      localObject63 = localObject12;
      localObject64 = localObject11;
      localObject65 = localObject10;
      localObject66 = localObject9;
      localObject67 = localObject8;
      localObject68 = localObject7;
      localObject69 = localObject6;
      localObject70 = localObject5;
      localObject71 = localObject4;
      localObject72 = localObject3;
      localObject73 = localObject2;
      i27 = i5;
      i29 = i1;
      localObject74 = localObject1;
      break label27830;
      label27618:
      m = i1;
      label27622:
      localObject74 = localObject1;
      i29 = m;
      i28 = i2;
      i27 = i5;
      localObject73 = localObject2;
      localObject72 = localObject3;
      localObject71 = localObject4;
      localObject70 = localObject5;
      localObject69 = localObject6;
      localObject68 = localObject7;
      localObject67 = localObject8;
      localObject66 = localObject9;
      localObject65 = localObject10;
      localObject64 = localObject11;
      localObject63 = localObject12;
      localObject62 = localObject13;
      localObject61 = localObject14;
      localObject60 = localObject15;
      localObject59 = localObject16;
      localObject58 = localObject17;
      localObject57 = localObject18;
      localObject56 = localObject19;
      localObject55 = localObject20;
      localObject54 = localObject21;
      localObject53 = localObject22;
      localObject52 = localObject23;
      localObject51 = localObject24;
      localObject50 = localObject25;
      localObject49 = localObject26;
      localObject48 = localObject27;
      localObject47 = localObject28;
      localObject46 = localObject29;
      localObject45 = localObject30;
      localObject44 = localObject31;
      localObject43 = localObject32;
      localObject42 = localObject33;
      localObject41 = localObject34;
      localObject40 = localObject35;
      localObject39 = localObject36;
      localObject38 = localObject37;
      i26 = i6;
      i25 = i3;
      i24 = i4;
      i23 = i7;
      i22 = i8;
      i21 = i9;
      i20 = i10;
      i19 = i11;
      i18 = i12;
      i17 = i13;
      i16 = i14;
      m = i15;
      label27830:
      localObject1 = localObject74;
      int i1 = i29;
      int i2 = i28;
      int i5 = i27;
      localObject2 = localObject73;
      Object localObject3 = localObject72;
      Object localObject4 = localObject71;
      Object localObject5 = localObject70;
      Object localObject6 = localObject69;
      Object localObject7 = localObject68;
      Object localObject8 = localObject67;
      Object localObject9 = localObject66;
      Object localObject10 = localObject65;
      Object localObject11 = localObject64;
      Object localObject12 = localObject63;
      Object localObject13 = localObject62;
      Object localObject14 = localObject61;
      Object localObject15 = localObject60;
      Object localObject16 = localObject59;
      Object localObject17 = localObject58;
      Object localObject18 = localObject57;
      Object localObject19 = localObject56;
      Object localObject20 = localObject55;
      Object localObject21 = localObject54;
      Object localObject22 = localObject53;
      Object localObject23 = localObject52;
      Object localObject24 = localObject51;
      Object localObject25 = localObject50;
      Object localObject26 = localObject49;
      Object localObject27 = localObject48;
      Object localObject28 = localObject47;
      Object localObject29 = localObject46;
      Object localObject30 = localObject45;
      Object localObject31 = localObject44;
      Object localObject32 = localObject43;
      Object localObject33 = localObject42;
      Object localObject34 = localObject41;
      Object localObject35 = localObject40;
      Object localObject36 = localObject39;
      Object localObject37 = localObject38;
      int i6 = i26;
      int i3 = i25;
      int i4 = i24;
      int i7 = i23;
      int i8 = i22;
      int i9 = i21;
      int i10 = i20;
      int i11 = i19;
      int i12 = i18;
      i18 = k;
      int i13 = i17;
      int i14 = i16;
      k = n;
      int i15 = m;
      m = i18;
    }
  }
  
  public static void a(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo != null) {
      j.add(paramExtensionInfo);
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    if (paramLong <= 0L) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt >= 18)
    {
      bool1 = bool2;
      if (paramInt < 24)
      {
        if (TimeFormatterUtils.c(paramLong) == 2131917319) {
          return false;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b()
  {
    return TimeFormatterUtils.a(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static List<HotReactiveHelper.HighLightUrlPattern> b(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramString;
    int m = 0;
    int k = 0;
    while (m >= 0)
    {
      m = paramContext.indexOf("(", k);
      if (m < 0) {
        break;
      }
      k = paramContext.indexOf(")[", m);
      if (k < 0) {
        break;
      }
      int n = paramContext.indexOf("]", k);
      if (n < 0) {
        break;
      }
      paramString = new HotReactiveHelper.HighLightUrlPattern();
      paramString.a = paramContext.substring(m + 1, k);
      paramString.c = m;
      paramString.b = paramContext.substring(k + 2, n);
      paramContext = paramContext.replace(paramContext.substring(m, n + 1), paramString.a);
      k = paramString.a.length() + n;
      localArrayList.add(paramString);
    }
    paramString = new HotReactiveHelper.HighLightUrlPattern();
    paramString.a = paramContext;
    localArrayList.add(0, paramString);
    return localArrayList;
  }
  
  public static String c()
  {
    return VFSAssistantUtils.getSDKPrivatePath(d);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.putString("hot_friend_chat_num_des", paramString);
    }
    paramContext.commit();
  }
  
  public static String d()
  {
    String str = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(e);
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    String str = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(f);
    return localStringBuilder.toString();
  }
  
  public static HashSet<ExtensionInfo> f()
  {
    return j;
  }
  
  public static boolean g()
  {
    if (i) {
      return h;
    }
    h = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("hot_friend_new_boat_big_use_new", false);
    i = true;
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNewVersionBoat local:");
      localStringBuilder.append(h);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper
 * JD-Core Version:    0.7.0.1
 */