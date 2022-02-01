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
  protected List<String> a = new ArrayList(5);
  protected List<String> b = new ArrayList(5);
  protected List<String> c = new ArrayList(5);
  List<oidb_0x496.RobotSubscribeCategory> d = new ArrayList();
  protected int e = 60000;
  protected Handler f = new Handler(Looper.getMainLooper());
  protected AppInterface g;
  protected String h = null;
  protected HashMap<Long, MessageForUniteGrayTip> i = new HashMap();
  protected boolean j = false;
  public String k = null;
  public String l = null;
  public String m = null;
  public String n = null;
  HashMap<String, Long> o = new HashMap();
  private HashMap<String, ArrayList<String>> p = new HashMap();
  private String q = "";
  private String r = "";
  private boolean s = false;
  private String t = null;
  private FriendListObserver u;
  private final FriendObserver v = new TroopRobotManager.2(this);
  
  public TroopRobotManager(AppInterface paramAppInterface)
  {
    this.g = paramAppInterface;
    paramAppInterface = (ITroopRobotService)this.g.getRuntimeService(ITroopRobotService.class, "all");
    a();
    paramAppInterface = this.g;
    if (paramAppInterface != null) {
      paramAppInterface.addObserver(this.v);
    }
  }
  
  private void a()
  {
    if (this.u == null)
    {
      AppInterface localAppInterface = this.g;
      if (localAppInterface != null)
      {
        if (!(localAppInterface instanceof QQAppInterface)) {
          return;
        }
        this.u = new TroopRobotManager.1(this);
        this.g.addObserver(this.u);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    SharedPreferences localSharedPreferences = this.g.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
    long l1;
    if (!this.o.containsKey(paramString))
    {
      l1 = localSharedPreferences.getLong(paramString, 0L);
      this.o.put(paramString, Long.valueOf(l1));
    }
    else
    {
      l1 = Math.max(((Long)this.o.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l1).commit();
      this.o.put(paramString, Long.valueOf(l1));
    }
    if (paramMessageRecord.shmsgseq > ((Long)this.o.get(paramString)).longValue())
    {
      localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
      this.o.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQAppInterface localQQAppInterface = null;
    AppInterface localAppInterface = this.g;
    if ((localAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localAppInterface;
    }
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreUtils.f(localQQAppInterface.getApplication(), localQQAppInterface.getCurrentUin(), paramString, false);
  }
  
  public static boolean a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    String str1 = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
    if (!TextUtils.isEmpty(str1))
    {
      paramTextView.setText(paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description"));
      paramTextView.append("\r\n");
      String str2 = HardCodeUtil.a(2131913002);
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new TroopRobotManager.3(str1, paramMessageRecord), 0, str2.length(), 33);
      paramTextView.append(localSpannableString);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    FriendListObserver localFriendListObserver = this.u;
    if (localFriendListObserver != null)
    {
      AppInterface localAppInterface = this.g;
      if (localAppInterface != null)
      {
        localAppInterface.removeObserver(localFriendListObserver);
        this.u = null;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    if (!TextUtils.isEmpty(paramChatMessage)) {}
    try
    {
      int i1 = Integer.parseInt(paramChatMessage);
      return i1;
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
  
  public void a(long paramLong1, long paramLong2)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)this.i.remove(Long.valueOf(paramLong1));
    if (localMessageForUniteGrayTip != null)
    {
      localMessageForUniteGrayTip.shmsgseq = paramLong2;
      UniteGrayTipMsgUtil.a((QQAppInterface)this.g, localMessageForUniteGrayTip);
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, EditText paramEditText, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString)
  {
    Object localObject = ContactUtils.b(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
    paramEditText = AtTroopMemberSpan.a(paramQQAppInterface, paramContext, paramSessionInfo.b, paramChatMessage.senderuin, (String)localObject, false, paramEditText, true, true);
    paramContext = new ArrayList();
    paramSessionInfo = AtTroopMemberSpan.a(paramEditText, paramContext);
    paramEditText = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      i1 = Integer.parseInt(paramEditText);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSessionInfo);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      paramSessionInfo = ((StringBuilder)localObject).toString();
    }
    catch (Exception paramContext)
    {
      int i1;
      label180:
      label183:
      break label183;
    }
    try
    {
      a(paramBaseChatPie, paramSessionInfo, paramContext, i1);
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
    MessageSignal localMessageSignal = paramBaseChatPie.bv().p().b();
    localSendMsgParams.d = localMessageSignal.c();
    localSendMsgParams.c = localMessageSignal.b();
    localSendMsgParams.e = localMessageSignal.a();
    localSendMsgParams.f = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localSendMsgParams.g = System.currentTimeMillis();
    localSendMsgParams.z = paramInt;
    ChatActivityFacade.a(paramBaseChatPie.d, paramBaseChatPie.e, paramBaseChatPie.ah, paramString, paramArrayList, localSendMsgParams);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = (ITroopRobotService)this.g.getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = ((ITroopRobotService)localObject2).isRobotTroop(paramMessageRecord.frienduin);
    int i3 = 0;
    int i2 = 0;
    if (bool)
    {
      if (paramMessageRecord.mRobotFlag == -1) {
        return false;
      }
      if (paramMessageRecord.mRobotFlag == 1) {
        return true;
      }
      Object localObject1 = ((HotChatManager)this.g.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramMessageRecord.frienduin);
      int i1;
      if ((localObject1 != null) && (((HotChatInfo)localObject1).isRobotHotChat))
      {
        if ((((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg))) && (paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
        {
          i1 = 0;
          while (i1 < paramMessageRecord.atInfoList.size())
          {
            if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i1)).uin)) {
              return true;
            }
            i1 += 1;
          }
          return false;
        }
        return true;
      }
      if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg)))
      {
        Object localObject3;
        if (this.l != null)
        {
          if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
          {
            i1 = 0;
            while (i1 < paramMessageRecord.atInfoList.size())
            {
              if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i1)).uin))
              {
                if (!(paramMessageRecord instanceof MessageForPtt))
                {
                  if ((paramMessageRecord instanceof MessageForMixedMsg)) {
                    return true;
                  }
                  localObject1 = paramMessageRecord.msg;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("@");
                  ((StringBuilder)localObject3).append(this.l);
                  ((StringBuilder)localObject3).append(" ");
                  localObject1 = ((String)localObject1).replace(((StringBuilder)localObject3).toString(), "");
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("@");
                  ((StringBuilder)localObject3).append(this.l);
                  localObject1 = ((String)localObject1).replace(((StringBuilder)localObject3).toString(), "");
                  i1 = i2;
                  while (i1 < this.c.size())
                  {
                    if (((String)localObject1).equals(((String)this.c.get(i1)).replace("$ROBOTNICK$", this.l)))
                    {
                      ((ITroopRobotService)localObject2).release(paramMessageRecord.frienduin, this.k, (String)this.c.get(i1));
                      return true;
                    }
                    i1 += 1;
                  }
                }
                return true;
              }
              i1 += 1;
            }
          }
          return true;
        }
        if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
        {
          i1 = 0;
          while (i1 < paramMessageRecord.atInfoList.size())
          {
            localObject3 = (AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i1);
            if (((ITroopRobotService)localObject2).isRobotUin(((AtTroopMemberInfo)localObject3).uin))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((AtTroopMemberInfo)localObject3).uin);
              ((StringBuilder)localObject1).append("");
              this.h = ((StringBuilder)localObject1).toString();
              Object localObject4 = (QQAppInterface)this.g;
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
                i2 = i3;
                while (i2 < this.b.size())
                {
                  if (((String)localObject5).equals(((String)this.b.get(i2)).replace((CharSequence)localObject1, (CharSequence)localObject4)))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("");
                    ((StringBuilder)localObject1).append(((AtTroopMemberInfo)localObject3).uin);
                    ((ITroopRobotService)localObject2).markStart(paramMessageRecord, ((StringBuilder)localObject1).toString(), (String)localObject4, (String)this.b.get(i2));
                    ReportController.b((QQAppInterface)this.g, "dc00899", "Grp_robot", "", "msg", "conti_dialog_msg", 0, 0, paramMessageRecord.frienduin, this.h, (String)this.b.get(i1), "");
                    return true;
                  }
                  i2 += 1;
                }
                return true;
              }
              return true;
            }
            i1 += 1;
          }
        }
        if (!(paramMessageRecord instanceof MessageForPtt))
        {
          if ((paramMessageRecord instanceof MessageForMixedMsg)) {
            return false;
          }
          i1 = 0;
          while (i1 < this.a.size())
          {
            localObject1 = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("troopuin_");
            ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
            localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), this.l);
            if (localObject1 == null) {
              localObject1 = "";
            } else {
              localObject1 = ((String)localObject1).toUpperCase().replaceAll(" ", "");
            }
            localObject1 = ((String)this.a.get(i1)).replace("$ROBOTNICK$", (CharSequence)localObject1);
            localObject2 = paramMessageRecord.msg.toUpperCase().replaceAll(" ", "");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject2).contains((CharSequence)localObject1)))
            {
              ReportController.b((QQAppInterface)this.g, "dc00899", "Grp_robot", "", "msg", "keyword_msg", 0, 0, paramMessageRecord.frienduin, this.h, (String)this.a.get(i1), "");
              return true;
            }
            i1 += 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = ((ITroopRobotService)this.g.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramMessageRecord.senderuin);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    String str = c(paramMessageRecord);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    a(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.o.get(str)).longValue()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public String c(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.frienduin);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
    }
    b();
    AppInterface localAppInterface = this.g;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.v);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager
 * JD-Core Version:    0.7.0.1
 */