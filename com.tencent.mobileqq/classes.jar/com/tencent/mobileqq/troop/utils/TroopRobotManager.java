package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.MessageSignal;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class TroopRobotManager
  implements Manager
{
  protected int a;
  protected Handler a;
  protected AppInterface a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new TroopRobotManager.2(this);
  protected String a;
  protected HashMap<Long, MessageForUniteGrayTip> a;
  protected List<String> a;
  protected boolean a;
  public String b;
  HashMap<String, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  protected List<String> b;
  private boolean jdField_b_of_type_Boolean = false;
  public String c;
  private HashMap<String, ArrayList<String>> c;
  protected List<String> c;
  public String d;
  List<oidb_0x496.RobotSubscribeCategory> d;
  public String e = null;
  private String f = "";
  private String g = "";
  private String h = null;
  
  public TroopRobotManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 60000;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = (ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    a();
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramAppInterface != null) {
      paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localAppInterface != null)
      {
        if (!(localAppInterface instanceof QQAppInterface)) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopRobotManager.1(this);
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
    else
    {
      l = Math.max(((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l).commit();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
    if (paramMessageRecord.shmsgseq > ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue())
    {
      localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQAppInterface localQQAppInterface = null;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localAppInterface;
    }
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreUtils.d(localQQAppInterface.getApplication(), localQQAppInterface.getCurrentUin(), paramString, false);
  }
  
  public static boolean a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    String str1 = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
    if (!TextUtils.isEmpty(str1))
    {
      paramTextView.setText(paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description"));
      paramTextView.append("\r\n");
      String str2 = HardCodeUtil.a(2131715529);
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new TroopRobotManager.3(str1, paramMessageRecord), 0, str2.length(), 33);
      paramTextView.append(localSpannableString);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    FriendListObserver localFriendListObserver = this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
    if (localFriendListObserver != null)
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localAppInterface != null)
      {
        localAppInterface.removeObserver(localFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    if (!TextUtils.isEmpty(paramChatMessage)) {}
    try
    {
      int i = Integer.parseInt(paramChatMessage);
      return i;
    }
    catch (Exception paramChatMessage)
    {
      label22:
      break label22;
    }
    return 0;
  }
  
  public String a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return "";
  }
  
  public String a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.frienduin);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong1));
    if (localMessageForUniteGrayTip != null)
    {
      localMessageForUniteGrayTip.shmsgseq = paramLong2;
      UniteGrayTipMsgUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localMessageForUniteGrayTip);
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, EditText paramEditText, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString)
  {
    Object localObject = ContactUtils.b(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
    paramEditText = AtTroopMemberSpan.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin, (String)localObject, false, paramEditText, true, true);
    paramContext = new ArrayList();
    paramSessionInfo = AtTroopMemberSpan.a(paramEditText, paramContext);
    paramEditText = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      i = Integer.parseInt(paramEditText);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSessionInfo);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      paramSessionInfo = ((StringBuilder)localObject).toString();
    }
    catch (Exception paramContext)
    {
      int i;
      label180:
      label183:
      break label183;
    }
    try
    {
      a(paramBaseChatPie, paramSessionInfo, paramContext, i);
      new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_robot").c("sub_page").d("next_msg_clk").a(new String[] { paramChatMessage.frienduin, paramEditText }).a();
      return;
    }
    catch (Exception paramContext)
    {
      break label180;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotManager", 2, "parse robotNewTipsClsId error");
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, int paramInt)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    MessageSignal localMessageSignal = paramBaseChatPie.b().a().a();
    localSendMsgParams.b = localMessageSignal.b();
    localSendMsgParams.jdField_a_of_type_Int = localMessageSignal.a();
    localSendMsgParams.jdField_c_of_type_Boolean = localMessageSignal.a();
    localSendMsgParams.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    localSendMsgParams.g = paramInt;
    ChatActivityFacade.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_AndroidContentContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramArrayList, localSendMsgParams);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = (ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = ((ITroopRobotService)localObject2).isRobotTroop(paramMessageRecord.frienduin);
    int k = 0;
    int j = 0;
    if (bool)
    {
      if (paramMessageRecord.mRobotFlag == -1) {
        return false;
      }
      if (paramMessageRecord.mRobotFlag == 1) {
        return true;
      }
      Object localObject1 = ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramMessageRecord.frienduin);
      int i;
      if ((localObject1 != null) && (((HotChatInfo)localObject1).isRobotHotChat))
      {
        if ((((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg))) && (paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
        {
          i = 0;
          while (i < paramMessageRecord.atInfoList.size())
          {
            if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin)) {
              return true;
            }
            i += 1;
          }
          return false;
        }
        return true;
      }
      if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg)))
      {
        Object localObject3;
        if (this.jdField_c_of_type_JavaLangString != null)
        {
          if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
          {
            i = 0;
            while (i < paramMessageRecord.atInfoList.size())
            {
              if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin))
              {
                if (!(paramMessageRecord instanceof MessageForPtt))
                {
                  if ((paramMessageRecord instanceof MessageForMixedMsg)) {
                    return true;
                  }
                  localObject1 = paramMessageRecord.msg;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("@");
                  ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
                  ((StringBuilder)localObject3).append(" ");
                  localObject1 = ((String)localObject1).replace(((StringBuilder)localObject3).toString(), "");
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("@");
                  ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
                  localObject1 = ((String)localObject1).replace(((StringBuilder)localObject3).toString(), "");
                  i = j;
                  while (i < this.jdField_c_of_type_JavaUtilList.size())
                  {
                    if (((String)localObject1).equals(((String)this.jdField_c_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", this.jdField_c_of_type_JavaLangString)))
                    {
                      ((ITroopRobotService)localObject2).release(paramMessageRecord.frienduin, this.jdField_b_of_type_JavaLangString, (String)this.jdField_c_of_type_JavaUtilList.get(i));
                      return true;
                    }
                    i += 1;
                  }
                }
                return true;
              }
              i += 1;
            }
          }
          return true;
        }
        if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
        {
          i = 0;
          while (i < paramMessageRecord.atInfoList.size())
          {
            localObject3 = (AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
            if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)localObject3).uin))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((AtTroopMemberInfo)localObject3).uin);
              ((StringBuilder)localObject1).append("");
              this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
              Object localObject4 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              Object localObject5 = paramMessageRecord.frienduin;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localObject1 = "$ROBOTNICK$";
              localStringBuilder.append(((AtTroopMemberInfo)localObject3).uin);
              localObject4 = ContactUtils.b((AppInterface)localObject4, (String)localObject5, localStringBuilder.toString());
              localObject5 = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).edit();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("troopuin_");
              localStringBuilder.append(paramMessageRecord.frienduin);
              ((SharedPreferences.Editor)localObject5).putString(localStringBuilder.toString(), (String)localObject4).commit();
              if ((!(paramMessageRecord instanceof MessageForPtt)) && (!(paramMessageRecord instanceof MessageForMixedMsg)))
              {
                localObject5 = paramMessageRecord.msg;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("@");
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append(" ");
                localObject5 = ((String)localObject5).replace(localStringBuilder.toString(), "");
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("@");
                localStringBuilder.append((String)localObject4);
                localObject5 = ((String)localObject5).replace(localStringBuilder.toString(), "");
                j = k;
                while (j < this.jdField_b_of_type_JavaUtilList.size())
                {
                  if (((String)localObject5).equals(((String)this.jdField_b_of_type_JavaUtilList.get(j)).replace((CharSequence)localObject1, (CharSequence)localObject4)))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("");
                    ((StringBuilder)localObject1).append(((AtTroopMemberInfo)localObject3).uin);
                    ((ITroopRobotService)localObject2).markStart(paramMessageRecord, ((StringBuilder)localObject1).toString(), (String)localObject4, (String)this.jdField_b_of_type_JavaUtilList.get(j));
                    ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "conti_dialog_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_b_of_type_JavaUtilList.get(i), "");
                    return true;
                  }
                  j += 1;
                }
                return true;
              }
              return true;
            }
            i += 1;
          }
        }
        if (!(paramMessageRecord instanceof MessageForPtt))
        {
          if ((paramMessageRecord instanceof MessageForMixedMsg)) {
            return false;
          }
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject1 = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("troopuin_");
            ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
            localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), this.jdField_c_of_type_JavaLangString);
            if (localObject1 == null) {
              localObject1 = "";
            } else {
              localObject1 = ((String)localObject1).toUpperCase().replaceAll(" ", "");
            }
            localObject1 = ((String)this.jdField_a_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", (CharSequence)localObject1);
            localObject2 = paramMessageRecord.msg.toUpperCase().replaceAll(" ", "");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject2).contains((CharSequence)localObject1)))
            {
              ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "keyword_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilList.get(i), "");
              return true;
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = ((ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramMessageRecord.senderuin);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    String str = a(paramMessageRecord);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    a(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(str)).longValue()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
    }
    b();
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager
 * JD-Core Version:    0.7.0.1
 */