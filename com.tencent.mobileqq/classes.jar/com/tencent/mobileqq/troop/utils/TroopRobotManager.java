package com.tencent.mobileqq.troop.utils;

import ajxu;
import ajxv;
import ajxw;
import ajxx;
import ajxy;
import ajxz;
import ajya;
import ajyb;
import ajyc;
import ajyd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.UinRange;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.ReqBody;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class TroopRobotManager
  implements Manager
{
  protected int a;
  protected Handler a;
  public AppInterface a;
  public TroopRobotManager.OnTalkingChangeListener a;
  protected String a;
  protected HashMap a;
  protected List a;
  public boolean a;
  public String b;
  HashMap b;
  protected List b;
  public String c;
  private HashMap c;
  protected List c;
  public String d;
  protected List d;
  private String jdField_e_of_type_JavaLangString = "";
  List jdField_e_of_type_JavaUtilList = new ArrayList();
  private String f = "";
  
  public TroopRobotManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_a_of_type_Int = 60000;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_c_of_type_JavaUtilList.add("你好$ROBOTNICK$");
    this.jdField_d_of_type_JavaUtilList.add("再见$ROBOTNICK$");
    ThreadManager.post(new ajxu(this), 5, null, true);
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.msg))
    {
      Object localObject = Patterns.d.matcher(paramMessageRecord.msg);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group(0);
        int i = paramMessageRecord.msg.indexOf((String)localObject);
        if (i >= 0)
        {
          String str = paramMessageRecord.msg.substring(0, i);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_url", (String)localObject);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_description", str);
          paramMessageRecord.saveExtInfoToExtStr("robot_processed", "true");
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
    long l;
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      l = localSharedPreferences.getLong(paramString, 0L);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
    for (;;)
    {
      if (paramMessageRecord.shmsgseq > ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue())
      {
        localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
      }
      return;
      l = Math.max(((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l).commit();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    a(true);
    b(Long.parseLong(paramMessageRecord.frienduin), paramString3, new ajxy(this, paramString3));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "Grp_robot", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static boolean a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
    if (!TextUtils.isEmpty(str))
    {
      paramTextView.setText(paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description"));
      paramTextView.append("\r\n");
      SpannableString localSpannableString = new SpannableString("更多详情");
      localSpannableString.setSpan(new ajxv(str, paramMessageRecord), 0, "更多详情".length(), 33);
      paramTextView.append(localSpannableString);
      bool = true;
    }
    return bool;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord))) {
        return paramMessageRecord + " 更多详情";
      }
    }
    return null;
  }
  
  private void b()
  {
    Object localObject1 = SharedPreUtils.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        this.jdField_c_of_type_JavaUtilHashMap.clear();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null)
          {
            String str = ((JSONObject)localObject3).optString("robotUin");
            localObject3 = ((JSONObject)localObject3).optJSONArray("barItem");
            if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
            {
              ArrayList localArrayList = new ArrayList(((JSONArray)localObject3).length());
              int j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localArrayList.add(((JSONArray)localObject3).optString(j));
                j += 1;
              }
              this.jdField_c_of_type_JavaUtilHashMap.put(str, localArrayList);
            }
          }
          i += 1;
        }
        localObject2 = SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("userTail");
      this.f = ((JSONObject)localObject2).optString("robotTail");
      return;
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_processed");
    return (!TextUtils.isEmpty(paramMessageRecord)) && (paramMessageRecord.equals("true"));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    int i = 0;
    if (!TextUtils.isEmpty(paramChatMessage)) {}
    try
    {
      i = Integer.parseInt(paramChatMessage);
      return i;
    }
    catch (Exception paramChatMessage) {}
    return 0;
  }
  
  public oidb_0x496.RobotSubscribeCategory a(int paramInt)
  {
    Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      oidb_0x496.RobotSubscribeCategory localRobotSubscribeCategory = (oidb_0x496.RobotSubscribeCategory)localIterator.next();
      if (localRobotSubscribeCategory.id.get() == paramInt) {
        return localRobotSubscribeCategory;
      }
    }
    return null;
  }
  
  public String a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramMessageForPtt.mRobotFlag == 2) || (b(paramMessageForPtt.senderuin))) {
      if ((paramMessageForPtt.atInfoList != null) && (!paramMessageForPtt.atInfoList.isEmpty()))
      {
        localObject1 = paramMessageForPtt.atInfoList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label444;
        }
        localObject1 = (MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next();
      }
    }
    label444:
    for (paramQQAppInterface = b(ContactUtils.g(paramQQAppInterface, paramMessageForPtt.frienduin, ((MessageForText.AtTroopMemberInfo)localObject1).uin + ""));; paramQQAppInterface = null)
    {
      localObject1 = paramQQAppInterface;
      long l;
      do
      {
        for (;;)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramQQAppInterface = (QQAppInterface)localObject1;
            if (((String)localObject1).length() > 16)
            {
              paramQQAppInterface = ((String)localObject1).substring(0, 8);
              paramQQAppInterface = paramQQAppInterface + "...";
            }
          }
          return paramQQAppInterface;
          localObject1 = localObject2;
          if (paramMessageForPtt.atInfo != null)
          {
            localObject1 = localObject2;
            if (paramMessageForPtt.atInfo.length() < 0)
            {
              l = paramMessageForPtt.atInfo.optLong(0);
              localObject1 = b(ContactUtils.g(paramQQAppInterface, paramMessageForPtt.frienduin, l + ""));
              continue;
              localObject1 = localObject2;
              if (paramMessageForPtt.mRobotFlag == 1)
              {
                if ((paramMessageForPtt.atInfoList == null) || (paramMessageForPtt.atInfoList.isEmpty())) {
                  break;
                }
                Iterator localIterator = paramMessageForPtt.atInfoList.iterator();
                do
                {
                  localObject1 = localObject2;
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localObject1 = (MessageForText.AtTroopMemberInfo)localIterator.next();
                } while (!a(((MessageForText.AtTroopMemberInfo)localObject1).uin));
                localObject1 = a(ContactUtils.g(paramQQAppInterface, paramMessageForPtt.frienduin, ((MessageForText.AtTroopMemberInfo)localObject1).uin + ""));
              }
            }
          }
        }
        localObject1 = localObject2;
      } while (paramMessageForPtt.atInfo == null);
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= paramMessageForPtt.atInfo.length()) {
          break;
        }
        l = paramMessageForPtt.atInfo.optLong(i);
        if (a(l))
        {
          localObject1 = a(ContactUtils.g(paramQQAppInterface, paramMessageForPtt.frienduin, l + ""));
          break;
        }
        i += 1;
      }
    }
  }
  
  public String a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    return paramMessageRecord.frienduin + "_" + str;
  }
  
  public String a(String paramString)
  {
    return this.jdField_e_of_type_JavaLangString.replace("#机器人#", paramString);
  }
  
  public ArrayList a()
  {
    return (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    a(false);
  }
  
  public void a(long paramLong, int paramInt, TroopRobotManager.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(1, true);
    localReqBody.version.set(paramInt, true);
    localReqBody.group_id.set(paramLong, true);
    ProtoUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new ajyb(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong1));
    if (localMessageForUniteGrayTip != null)
    {
      localMessageForUniteGrayTip.shmsgseq = paramLong2;
      UniteGrayTipUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localMessageForUniteGrayTip);
    }
  }
  
  public void a(long paramLong, String paramString, TroopRobotManager.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(3, true);
    localReqBody.group_id.set(paramLong, true);
    localReqBody.keyword.set(paramString, true);
    ProtoUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new ajyc(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, EditText paramEditText, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString)
  {
    String str = ContactUtils.g(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
    paramEditText = AtTroopMemberSpan.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin, str, false, paramEditText, true, true);
    paramContext = new ArrayList();
    paramEditText = AtTroopMemberSpan.a(paramEditText, paramContext);
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      int i = Integer.parseInt(paramSessionInfo);
      paramBaseChatPie.a(paramEditText + " " + paramString, paramContext, i);
      new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_robot").c("sub_page").d("next_msg_clk").a(new String[] { paramChatMessage.frienduin, paramSessionInfo }).a();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopRobotManager", 2, "parse robotNewTipsClsId error");
    }
  }
  
  public void a(oidb_0x496.Robot paramRobot)
  {
    try
    {
      int i;
      if (paramRobot.uin_range.has())
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.uin_range.size()) && (i < 5))
        {
          oidb_0x496.UinRange localUinRange = (oidb_0x496.UinRange)paramRobot.uin_range.get(i);
          TroopRobotManager.UinRange localUinRange1 = new TroopRobotManager.UinRange();
          localUinRange1.a = localUinRange.start_uin.get();
          localUinRange1.b = localUinRange.end_uin.get();
          this.jdField_a_of_type_JavaUtilList.add(localUinRange1);
          i += 1;
        }
      }
      if (paramRobot.fire_keywords.has())
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.fire_keywords.size()) && (i < 5))
        {
          this.jdField_b_of_type_JavaUtilList.add(paramRobot.fire_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.start_keywords.has())
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.start_keywords.size()) && (i < 5))
        {
          this.jdField_c_of_type_JavaUtilList.add(paramRobot.start_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.end_keywords.has())
      {
        this.jdField_d_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.end_keywords.size()) && (i < 5))
        {
          this.jdField_d_of_type_JavaUtilList.add(paramRobot.end_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.session_timeout.has()) {
        this.jdField_a_of_type_Int = paramRobot.session_timeout.get();
      }
      if (paramRobot.subscribe_categories.has())
      {
        this.jdField_e_of_type_JavaUtilList.clear();
        this.jdField_e_of_type_JavaUtilList.addAll(paramRobot.subscribe_categories.get());
      }
      return;
    }
    finally {}
  }
  
  public void a(TroopRobotManager.OnTalkingChangeListener paramOnTalkingChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager$OnTalkingChangeListener = paramOnTalkingChangeListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      if (!TextUtils.isEmpty(paramString1)) {
        b(Long.parseLong(paramString1), paramString2, new ajxx(this, paramString2));
      }
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      a(false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    a(true);
  }
  
  public void a(String paramString1, String paramString2, cmd0x934.RspBody paramRspBody)
  {
    ThreadManager.post(new ajya(this, paramString1, paramString2, paramRspBody), 5, null, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(paramString);
    if (localTroopInfo != null)
    {
      if (!paramBoolean) {
        break label50;
      }
      localTroopInfo.dwAppPrivilegeFlag |= 0x10000000;
    }
    for (;;)
    {
      localTroopManager.b(localTroopInfo);
      return;
      label50:
      localTroopInfo.dwAppPrivilegeFlag &= 0xEFFFFFFF;
      BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).edit().remove("troopuin_" + paramString).commit();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("robot_aio_bar");
    if (localJSONArray != null) {
      SharedPreUtils.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), localJSONArray.toString());
    }
    paramJSONObject = paramJSONObject.optJSONObject("robot_voice_tail");
    if (paramJSONObject != null) {
      SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramJSONObject.toString());
    }
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.post(new ajxw(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        TroopRobotManager.UinRange localUinRange = (TroopRobotManager.UinRange)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramLong >= localUinRange.a) && (paramLong <= localUinRange.b)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(Context paramContext, String paramString, long paramLong)
  {
    if (a(paramLong))
    {
      paramString = "https://qun.qq.com/qqweb/m/qun/qun_robot/index.html?gc=" + paramString + "&robotUin=" + paramLong + "&_wv=16778243";
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotManager", 2, "url :" + paramString);
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool3 = true;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    if ((!a(paramMessageRecord.frienduin)) || (paramMessageRecord.mRobotFlag == -1)) {
      bool1 = false;
    }
    Object localObject;
    label187:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramMessageRecord.mRobotFlag == 1);
              localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(59)).a(paramMessageRecord.frienduin);
              if ((localObject == null) || (!((HotChatInfo)localObject).isRobotHotChat)) {
                break label187;
              }
              if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt))) {
                break;
              }
              bool1 = bool3;
            } while (!(paramMessageRecord instanceof MessageForMixedMsg));
            bool1 = bool3;
          } while (paramMessageRecord.atInfoList == null);
          bool1 = bool3;
        } while (paramMessageRecord.atInfoList.size() <= 0);
        i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i < paramMessageRecord.atInfoList.size())
          {
            if (a(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin)) {
              bool1 = true;
            }
          }
          else {
            return bool1;
          }
          i += 1;
        }
        if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForReplyText)) && (!(paramMessageRecord instanceof MessageForPtt)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
          break label1090;
        }
        if (this.jdField_c_of_type_JavaLangString == null) {
          break;
        }
        bool1 = bool3;
      } while (paramMessageRecord.atInfoList == null);
      bool1 = bool3;
    } while (paramMessageRecord.atInfoList.size() <= 0);
    int i = 0;
    for (;;)
    {
      bool1 = bool3;
      if (i >= paramMessageRecord.atInfoList.size()) {
        break;
      }
      if (a(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin))
      {
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForPtt)) {
          break;
        }
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForMixedMsg)) {
          break;
        }
        localObject = paramMessageRecord.msg.replace("@" + this.jdField_c_of_type_JavaLangString + " ", "").replace("@" + this.jdField_c_of_type_JavaLangString, "");
        i = j;
        for (;;)
        {
          bool1 = bool3;
          if (i >= this.jdField_d_of_type_JavaUtilList.size()) {
            break;
          }
          if (((String)localObject).equals(((String)this.jdField_d_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", this.jdField_c_of_type_JavaLangString)))
          {
            a(paramMessageRecord.frienduin, (String)this.jdField_d_of_type_JavaUtilList.get(i));
            return true;
          }
          i += 1;
        }
      }
      i += 1;
    }
    String str1;
    if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
    {
      i = 0;
      for (;;)
      {
        if (i >= paramMessageRecord.atInfoList.size()) {
          break label874;
        }
        localObject = (MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
        if (a(((MessageForText.AtTroopMemberInfo)localObject).uin))
        {
          this.jdField_a_of_type_JavaLangString = (((MessageForText.AtTroopMemberInfo)localObject).uin + "");
          str1 = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageRecord.frienduin, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin);
          BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).edit().putString("troopuin_" + paramMessageRecord.frienduin, str1).commit();
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForPtt)) {
            break;
          }
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForMixedMsg)) {
            break;
          }
          String str2 = paramMessageRecord.msg.replace("@" + str1 + " ", "").replace("@" + str1, "");
          j = 0;
          for (;;)
          {
            bool1 = bool3;
            if (j >= this.jdField_c_of_type_JavaUtilList.size()) {
              break;
            }
            if (str2.equals(((String)this.jdField_c_of_type_JavaUtilList.get(j)).replace("$ROBOTNICK$", str1)))
            {
              a(paramMessageRecord, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin, str1, (String)this.jdField_c_of_type_JavaUtilList.get(j));
              ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "conti_dialog_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_c_of_type_JavaUtilList.get(i), "");
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    label874:
    if (((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
      return false;
    }
    i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      localObject = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).getString("troopuin_" + paramMessageRecord.frienduin, this.jdField_c_of_type_JavaLangString);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((String)localObject).toUpperCase().replaceAll(" ", ""))
      {
        localObject = ((String)this.jdField_b_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", (CharSequence)localObject);
        str1 = paramMessageRecord.msg.toUpperCase().replaceAll(" ", "");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!str1.contains((CharSequence)localObject))) {
          break;
        }
        ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "keyword_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_b_of_type_JavaUtilList.get(i), "");
        return true;
      }
      i += 1;
    }
    label1090:
    return false;
  }
  
  public boolean a(String paramString)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(59)).a(paramString);
    if (localHotChatInfo != null) {
      return localHotChatInfo.isRobotHotChat;
    }
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(51)).a(paramString);
    return (paramString != null) && ((paramString.dwAppPrivilegeFlag & 0x10000000) != 0L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    paramString2 = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString3, "" + paramString2);
    paramString1 = paramString1.replace("@" + paramString2 + " ", "").replace("@" + paramString2, "");
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_c_of_type_JavaUtilList.size())
      {
        if (paramString1.equals(((String)this.jdField_c_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", paramString2))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public byte[] a()
  {
    return FileUtils.a(BaseApplication.getContext().getFileStreamPath("troop_robot_config"));
  }
  
  public byte[] a(String paramString1, String paramString2)
  {
    return FileUtils.a(BaseApplication.getContext().getFileStreamPath("troop_robot_panel_data_" + paramString1 + "_" + paramString2));
  }
  
  public String b(String paramString)
  {
    return this.f.replace("#用户名#", paramString);
  }
  
  public void b(long paramLong, String paramString, TroopRobotManager.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(2, true);
    localReqBody.group_id.set(paramLong, true);
    localReqBody.keyword.set(paramString, true);
    ProtoUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new ajyd(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void b(oidb_0x496.Robot paramRobot)
  {
    ThreadManager.post(new ajxz(this, paramRobot), 5, null, true);
  }
  
  public boolean b(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return a(l);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    if ((!a()) || (this.jdField_c_of_type_JavaLangString == null)) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.replace("@" + this.jdField_c_of_type_JavaLangString + " ", "").replace("@" + this.jdField_c_of_type_JavaLangString, "");
      int i = 0;
      while (i < this.jdField_d_of_type_JavaUtilList.size())
      {
        if (paramString1.equals(((String)this.jdField_d_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", this.jdField_c_of_type_JavaLangString))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    if (!b(paramMessageRecord.senderuin)) {}
    String str;
    do
    {
      return false;
      str = a(paramMessageRecord);
    } while (TextUtils.isEmpty(str));
    a(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(str)).longValue()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager
 * JD-Core Version:    0.7.0.1
 */