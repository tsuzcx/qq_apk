package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.UniteEntity.Note;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.clockin.api.ITroopClockInHandler;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.LightApp;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.Sender;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.Source;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.SysMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857.RedGrayTipsInfo;

public class TroopTipsMsgMgr
  implements Manager
{
  protected static final String b;
  protected static HashMap<String, Boolean> c = new HashMap();
  protected QQAppInterface a;
  protected Queue<String> d = new LinkedList();
  public ArrayList<TroopTipsMsgMgr.RedGrayTips> e = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<{text:'A',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>");
    localStringBuilder.append(HardCodeUtil.a(2131913046));
    localStringBuilder.append("<{text:'B',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>");
    localStringBuilder.append(HardCodeUtil.a(2131913047));
    localStringBuilder.append("<{icon:'/rose',url:'url.qq.com?rose.png',alt:'玫瑰'}>");
    b = localStringBuilder.toString();
  }
  
  public TroopTipsMsgMgr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (!a(paramLong2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGameGrayTip, troopUin: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" busiId: ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
    int i;
    if (paramLong2 == 10035L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = "game_on_exp";
    } else {
      localObject = "game_off_exp";
    }
    TroopReportor.a("Grp_AIO", "AIO_exp", (String)localObject, 0, 0, new String[] { String.valueOf(paramLong1) });
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (((paramLong2 != 1068L) && (paramLong2 != 1067L)) || ((paramLong3 != 10036L) && (paramLong3 != 10038L))) {
      return;
    }
    if (paramString.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， contentXml is empty");
      }
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryRefreshClockInEntry， troopUin: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" busiId: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" templId: ");
      localStringBuilder.append(paramLong3);
      QLog.e("TroopTipsMsgMgr", 2, localStringBuilder.toString());
    }
    try
    {
      paramString = UniteGrayTipUtil.a(paramString);
      if (paramString == null) {
        return;
      }
      paramString = paramString.a();
      if (paramString == null) {
        return;
      }
      paramString = paramString.e();
      if (paramString == null) {
        return;
      }
      localStringBuilder = null;
      Iterator localIterator = paramString.iterator();
      do
      {
        paramString = localStringBuilder;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (UniteEntity.Note)localIterator.next();
      } while (paramString.d() != 4);
      paramString = (String)paramString.a().get(Integer.valueOf(6));
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramQQAppInterface.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， getClockInStatus");
        }
        ((ITroopClockInHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER)).a(String.valueOf(paramLong1), this.a.getCurrentAccountUin(), 1);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("tryRefreshClockInEntry， e: ");
        paramString.append(paramQQAppInterface);
        QLog.e("TroopTipsMsgMgr", 2, paramString.toString());
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(MessageForGrayTips paramMessageForGrayTips, String paramString)
  {
    String str1 = "url";
    if (paramMessageForGrayTips != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        int k = localJSONObject.getInt("startIndex");
        int m = localJSONObject.optInt("endIndex");
        if (m > 0)
        {
          int j = -1;
          if (localJSONObject.has("cmd")) {
            j = localJSONObject.getInt("cmd");
          }
          paramString = "";
          if (localJSONObject.has("data")) {
            paramString = localJSONObject.getString("data");
          }
          String str2 = null;
          if (localJSONObject.has("data_a")) {
            str2 = localJSONObject.getString("data_a");
          }
          if (localJSONObject.has(str1)) {
            paramString = localJSONObject.getString(str1);
          }
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_action", j);
          if ((j != 1) && (j != 2) && (j != 3))
          {
            if (j == 4) {
              break label261;
            }
            if (j != 5)
            {
              if ((j != 15) && (j != 18)) {
                if (j != 28) {
                  break label261;
                }
              }
            }
            else
            {
              localBundle.putString("troop_mem_uin", paramString);
              localBundle.putBoolean("need_update_nick", true);
              break label261;
            }
          }
          localBundle.putString("key_action_DATA", paramString);
          localBundle.putString("key_a_action_DATA", str2);
          label261:
          if (localJSONObject.has("icon"))
          {
            localBundle.putString("image_resource", localJSONObject.optString("icon"));
            localBundle.putString("image_alt", localJSONObject.optString("alt"));
          }
          if (localJSONObject.has("textColor")) {
            localBundle.putString("textColor", localJSONObject.getString("textColor"));
          }
          paramMessageForGrayTips.addHightlightItem(k, m, localBundle);
        }
        i += 1;
      }
    }
    catch (JSONException paramMessageForGrayTips)
    {
      label348:
      break label348;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopTipsMsgMgr", 2, "addGrayTips==>JSONException");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "setUnreadAIOGrayTips");
    }
    HashMap localHashMap = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localHashMap.put(localStringBuilder.toString(), Boolean.valueOf(true));
  }
  
  private void a(GroupOpenSysMsg.SysMsgBody paramSysMsgBody, TroopTipsEntity paramTroopTipsEntity)
  {
    if ((paramSysMsgBody.msg_type.get() == 2) && (paramSysMsgBody.light_app.has()))
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)MessageRecordFactory.a(-5008);
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.promptText = paramSysMsgBody.light_app.prompt.get();
      localArkAppMessage.appName = paramSysMsgBody.light_app.app.get();
      localArkAppMessage.appView = paramSysMsgBody.light_app.view.get();
      localArkAppMessage.appDesc = paramSysMsgBody.light_app.desc.get();
      localArkAppMessage.appMinVersion = paramSysMsgBody.light_app.ver.get();
      localArkAppMessage.metaList = paramSysMsgBody.light_app.meta.get();
      localArkAppMessage.config = paramSysMsgBody.light_app.config.get();
      if (paramSysMsgBody.light_app.source.has())
      {
        localArkAppMessage.mSourceName = paramSysMsgBody.light_app.source.name.get();
        localArkAppMessage.mSourceUrl = paramSysMsgBody.light_app.source.url.get();
      }
      localMessageForArkApp.ark_app_message = localArkAppMessage;
      if (paramSysMsgBody.sender.has())
      {
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_has", "1");
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_flag", "1");
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_head_url", paramSysMsgBody.sender.avatar.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_head_click_url", paramSysMsgBody.sender.url.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_nickname", paramSysMsgBody.sender.nick.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(BaseApplication.getContext().getResources().getColor(2131168022)));
        paramSysMsgBody = String.valueOf(paramSysMsgBody.sender.uin.get());
      }
      else
      {
        paramSysMsgBody = "";
      }
      localMessageForArkApp.saveExtInfoToExtStr("troop_mini_app_sys", "1");
      localMessageForArkApp.frienduin = paramTroopTipsEntity.troopUin;
      localMessageForArkApp.init(this.a.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, paramSysMsgBody, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, -5008, paramTroopTipsEntity.uinType, paramTroopTipsEntity.msgSeq);
      localMessageForArkApp.isread = true;
      localMessageForArkApp.getBytes();
      this.a.getMessageFacade().a(localMessageForArkApp, this.a.getCurrentAccountUin());
    }
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong == 10035L) || (paramLong == 10036L);
  }
  
  public static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageForUniteGrayTip.shmsgseq <= 0L) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (a(paramMessageForUniteGrayTip, paramQQAppInterface.h(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop))) {
      return true;
    }
    String str = String.format("shmsgseq=%d", new Object[] { Long.valueOf(paramMessageForUniteGrayTip.shmsgseq) });
    return a(paramMessageForUniteGrayTip, paramQQAppInterface.a(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.shmsgseq, 1000, str));
  }
  
  private static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, MessageRecord paramMessageRecord)
  {
    if (!TextUtils.equals(paramMessageForUniteGrayTip.senderuin, paramMessageRecord.senderuin)) {
      return false;
    }
    if (!TextUtils.equals(paramMessageForUniteGrayTip.frienduin, paramMessageRecord.frienduin)) {
      return false;
    }
    if (!TextUtils.equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_tips_seq_id"), paramMessageRecord.getExtInfoFromExtStr("uint64_tips_seq_id"))) {
      return false;
    }
    return TextUtils.equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id"), paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
  }
  
  private static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (a(paramMessageForUniteGrayTip, (MessageRecord)paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips");
    }
    Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("read", Boolean.valueOf(true));
    boolean bool = ((EntityManager)localObject1).update(TroopTipsEntity.class.getSimpleName(), (ContentValues)localObject2, "troopUin=? and msgSeq=?", new String[] { paramString1, paramString2 });
    ((EntityManager)localObject1).close();
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeReadedAIOGrayTips ok troopUin:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("msgSeq:");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject1).toString());
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramString2);
      ((HashMap)localObject1).remove(((StringBuilder)localObject2).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips error");
    }
  }
  
  public MessageForGrayTips a(TroopTipsEntity paramTroopTipsEntity)
  {
    if ((this.a != null) && (paramTroopTipsEntity != null))
    {
      Object localObject = new ArrayList();
      MessageForGrayTips localMessageForGrayTips = b(paramTroopTipsEntity);
      if (!MessageHandlerUtils.a(this.a, localMessageForGrayTips, false))
      {
        ((ArrayList)localObject).add(localMessageForGrayTips);
        this.a.getMessageFacade().a((List)localObject, this.a.getCurrentAccountUin());
        if (paramTroopTipsEntity.uinType == 1)
        {
          localObject = paramTroopTipsEntity.troopUin;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramTroopTipsEntity.msgSeq);
          localStringBuilder.append("");
          b((String)localObject, localStringBuilder.toString());
        }
      }
      return localMessageForGrayTips;
    }
    return null;
  }
  
  public MessageForGrayTips a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    TroopTipsEntity localTroopTipsEntity = new TroopTipsEntity();
    localTroopTipsEntity.troopUin = paramString1;
    localTroopTipsEntity.time = paramLong1;
    localTroopTipsEntity.expireTime = paramLong2;
    localTroopTipsEntity.msgSeq = paramInt1;
    localTroopTipsEntity.tipsPromptType = 1;
    localTroopTipsEntity.currentUin = this.a.getCurrentAccountUin();
    localTroopTipsEntity.optContent = paramString2;
    localTroopTipsEntity.optShowLatest = 1;
    localTroopTipsEntity.uinType = paramInt2;
    c(localTroopTipsEntity);
    return a(localTroopTipsEntity);
  }
  
  /* Error */
  public MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mobileqq.service.message.codec.decoder.MsgType0x2dcDecoder.Parse0x2dcContext paramParse0x2dcContext, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 683	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody
    //   9: dup
    //   10: invokespecial 684	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:<init>	()V
    //   13: astore 26
    //   15: aload 26
    //   17: aload_2
    //   18: invokevirtual 688	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 683	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody
    //   24: astore 27
    //   26: aload 27
    //   28: ifnonnull +27 -> 55
    //   31: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +12 -> 46
    //   37: ldc 88
    //   39: iconst_2
    //   40: ldc_w 690
    //   43: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aconst_null
    //   47: areturn
    //   48: astore_1
    //   49: ldc 88
    //   51: astore_2
    //   52: goto +5342 -> 5394
    //   55: aload 27
    //   57: getfield 694	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_enum_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   60: invokevirtual 697	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   63: istore 14
    //   65: aload 27
    //   67: getfield 700	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   70: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   73: istore 13
    //   75: aload 27
    //   77: getfield 703	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   80: astore 26
    //   82: aload 26
    //   84: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   87: lstore 23
    //   89: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: istore 25
    //   94: iload 25
    //   96: ifeq +97 -> 193
    //   99: new 23	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   106: astore 26
    //   108: aload 26
    //   110: ldc_w 705
    //   113: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 26
    //   119: iload_3
    //   120: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 26
    //   126: ldc_w 710
    //   129: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 26
    //   135: iload 14
    //   137: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 26
    //   143: ldc_w 712
    //   146: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 26
    //   152: iload 13
    //   154: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 26
    //   160: ldc_w 714
    //   163: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 26
    //   169: lload 23
    //   171: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc 88
    //   177: iconst_2
    //   178: aload 26
    //   180: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: goto +7 -> 193
    //   189: astore_1
    //   190: goto -141 -> 49
    //   193: new 23	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   200: astore 26
    //   202: aload 26
    //   204: lload 23
    //   206: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 26
    //   212: ldc_w 261
    //   215: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 26
    //   221: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: astore 26
    //   226: iload_3
    //   227: i2l
    //   228: lstore 17
    //   230: aload_0
    //   231: aload 26
    //   233: lload 17
    //   235: invokevirtual 717	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Ljava/lang/String;J)Z
    //   238: istore 25
    //   240: iload 25
    //   242: ifeq +5 -> 247
    //   245: aconst_null
    //   246: areturn
    //   247: lconst_0
    //   248: lstore 15
    //   250: lload 4
    //   252: lconst_0
    //   253: lcmp
    //   254: ifne +18 -> 272
    //   257: invokestatic 722	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   260: lstore 4
    //   262: goto +10 -> 272
    //   265: astore_1
    //   266: ldc 88
    //   268: astore_2
    //   269: goto +5125 -> 5394
    //   272: aload 27
    //   274: getfield 725	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_msg_expires	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   277: astore 28
    //   279: ldc_w 261
    //   282: astore 26
    //   284: aload 28
    //   286: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   289: lstore 19
    //   291: lload 19
    //   293: lconst_0
    //   294: lcmp
    //   295: ifeq +62 -> 357
    //   298: invokestatic 722	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   301: lload 19
    //   303: lcmp
    //   304: iflt +53 -> 357
    //   307: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +45 -> 355
    //   313: new 23	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   320: astore_1
    //   321: aload_1
    //   322: ldc_w 727
    //   325: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_1
    //   330: iload 14
    //   332: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_1
    //   337: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: astore_1
    //   341: ldc 88
    //   343: iconst_2
    //   344: aload_1
    //   345: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: goto +7 -> 355
    //   351: astore_1
    //   352: goto +5027 -> 5379
    //   355: aconst_null
    //   356: areturn
    //   357: new 488	com/tencent/mobileqq/troop/data/TroopTipsEntity
    //   360: dup
    //   361: invokespecial 655	com/tencent/mobileqq/troop/data/TroopTipsEntity:<init>	()V
    //   364: astore 28
    //   366: aload 28
    //   368: lload 23
    //   370: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   373: putfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   376: aload 28
    //   378: lload 4
    //   380: putfield 501	com/tencent/mobileqq/troop/data/TroopTipsEntity:time	J
    //   383: aload 28
    //   385: lload 19
    //   387: putfield 658	com/tencent/mobileqq/troop/data/TroopTipsEntity:expireTime	J
    //   390: aload 28
    //   392: lload 17
    //   394: putfield 508	com/tencent/mobileqq/troop/data/TroopTipsEntity:msgSeq	J
    //   397: aload 28
    //   399: iload 9
    //   401: putfield 730	com/tencent/mobileqq/troop/data/TroopTipsEntity:isOfflineMsg	Z
    //   404: iload 14
    //   406: tableswitch	default:+142 -> 548, 1:+4075->4481, 2:+142->548, 3:+142->548, 4:+142->548, 5:+142->548, 6:+3922->4328, 7:+5133->5539, 8:+142->548, 9:+3259->3665, 10:+3204->3610, 11:+3185->3591, 12:+3116->3522, 13:+3030->3436, 14:+142->548, 15:+2939->3345, 16:+142->548, 17:+2889->3295, 18:+2817->3223, 19:+2771->3177, 20:+1883->2289, 21:+1811->2217, 22:+1802->2208, 23:+1737->2143, 24:+942->1348, 25:+740->1146, 26:+587->993, 27:+532->938, 28:+408->814, 29:+142->548, 30:+351->757, 31:+294->700, 32:+145->551
    //   549: ldc_w 7705
    //   552: iload_1
    //   553: getfield 734	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_revert_graytips_traceless	Ltencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless;
    //   556: invokevirtual 737	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:has	()Z
    //   559: ifeq +129 -> 688
    //   562: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +12 -> 577
    //   568: ldc 88
    //   570: iconst_2
    //   571: ldc_w 739
    //   574: invokestatic 742	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload 27
    //   579: getfield 734	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_revert_graytips_traceless	Ltencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless;
    //   582: invokevirtual 745	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   585: checkcast 736	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless
    //   588: astore 27
    //   590: aload 27
    //   592: getfield 748	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   595: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   598: ifeq +4863 -> 5461
    //   601: aload 27
    //   603: getfield 748	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   606: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   609: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   612: astore_2
    //   613: goto +3 -> 616
    //   616: aload 27
    //   618: getfield 751	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:uint64_busi_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   621: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   624: ifeq +4843 -> 5467
    //   627: aload 27
    //   629: getfield 751	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:uint64_busi_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   632: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   635: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   638: astore 11
    //   640: goto +3 -> 643
    //   643: aload 27
    //   645: getfield 753	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:uint64_tips_seq_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   648: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   651: ifeq +16 -> 667
    //   654: aload 27
    //   656: getfield 753	tencent/im/oidb/cmd0x857/TroopTips0x857$RevertGrayTipsMsgTraceless:uint64_tips_seq_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   659: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   662: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   665: astore 26
    //   667: aload_1
    //   668: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   671: invokevirtual 757	com/tencent/imcore/message/QQMessageFacade:p	()Lcom/tencent/mobileqq/troop/data/TroopMessageManager;
    //   674: aload_2
    //   675: aload 11
    //   677: aload 26
    //   679: iconst_1
    //   680: iload 12
    //   682: invokevirtual 762	com/tencent/mobileqq/troop/data/TroopMessageManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V
    //   685: goto -137 -> 548
    //   688: ldc 88
    //   690: iconst_1
    //   691: ldc_w 764
    //   694: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   697: goto -149 -> 548
    //   700: aload 27
    //   702: getfield 768	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_group_digest_msg_summary	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary;
    //   705: invokevirtual 771	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary:has	()Z
    //   708: ifeq -160 -> 548
    //   711: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +12 -> 726
    //   717: ldc 88
    //   719: iconst_2
    //   720: ldc_w 773
    //   723: invokestatic 742	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   726: aload_1
    //   727: getstatic 778	com/tencent/mobileqq/app/QQManagerFactory:TROOP_ESSENCE_MSG_MANAGER	I
    //   730: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   733: checkcast 784	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager
    //   736: lload 23
    //   738: aload 27
    //   740: getfield 768	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_group_digest_msg_summary	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary;
    //   743: invokevirtual 785	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   746: checkcast 770	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary
    //   749: iload 9
    //   751: invokevirtual 788	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager:a	(JLtencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsgSummary;Z)V
    //   754: goto -206 -> 548
    //   757: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +12 -> 772
    //   763: ldc 88
    //   765: iconst_2
    //   766: ldc_w 790
    //   769: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload 27
    //   774: getfield 794	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_live_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg;
    //   777: invokevirtual 797	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg:has	()Z
    //   780: ifeq -232 -> 548
    //   783: aload 27
    //   785: getfield 794	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_live_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg;
    //   788: invokevirtual 798	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   791: checkcast 796	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg
    //   794: astore_2
    //   795: aload_1
    //   796: getstatic 801	com/tencent/mobileqq/app/QQManagerFactory:ILIVE_GROUP_TIPS_MANAGER	I
    //   799: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   802: checkcast 803	cooperation/ilive/group/IliveGroupTipsManager
    //   805: aload_2
    //   806: lload 23
    //   808: invokevirtual 806	cooperation/ilive/group/IliveGroupTipsManager:a	(Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQVaLiveNotifyMsg;J)V
    //   811: goto -263 -> 548
    //   814: aload 27
    //   816: getfield 810	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_study_room_member_msg	Ltencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush;
    //   819: invokevirtual 813	tencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush:has	()Z
    //   822: ifeq -274 -> 548
    //   825: aload 27
    //   827: getfield 703	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   830: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   833: lstore 4
    //   835: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq +36 -> 874
    //   841: new 23	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   848: astore_2
    //   849: aload_2
    //   850: ldc_w 815
    //   853: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload_2
    //   858: lload 4
    //   860: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: ldc 88
    //   866: iconst_2
    //   867: aload_2
    //   868: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 742	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: aload_1
    //   875: getstatic 818	com/tencent/mobileqq/app/QQManagerFactory:STUDY_ROOM_MANAGER	I
    //   878: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   881: checkcast 820	com/tencent/mobileqq/studyroom/StudyRoomManager
    //   884: astore_1
    //   885: aload 27
    //   887: getfield 810	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_study_room_member_msg	Ltencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush;
    //   890: invokevirtual 821	tencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   893: checkcast 812	tencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush
    //   896: invokevirtual 824	tencent/im/oidb/cmd0x857/TroopTips0x857$StudyRoomMemberChangePush:toByteArray	()[B
    //   899: astore_2
    //   900: new 23	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   907: astore 11
    //   909: aload 11
    //   911: lload 4
    //   913: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 11
    //   919: aload 26
    //   921: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload_1
    //   926: aload_2
    //   927: aload 11
    //   929: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: invokevirtual 827	com/tencent/mobileqq/studyroom/StudyRoomManager:a	([BLjava/lang/String;)V
    //   935: goto -387 -> 548
    //   938: aload 27
    //   940: getfield 831	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_group_digest_msg	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg;
    //   943: invokevirtual 834	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg:has	()Z
    //   946: ifeq -398 -> 548
    //   949: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +12 -> 964
    //   955: ldc 88
    //   957: iconst_2
    //   958: ldc_w 836
    //   961: invokestatic 742	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   964: aload_1
    //   965: getstatic 778	com/tencent/mobileqq/app/QQManagerFactory:TROOP_ESSENCE_MSG_MANAGER	I
    //   968: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   971: checkcast 784	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager
    //   974: aload 27
    //   976: getfield 831	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_group_digest_msg	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg;
    //   979: invokevirtual 837	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   982: checkcast 833	tencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg
    //   985: iload 9
    //   987: invokevirtual 840	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager:a	(Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQGroupDigestMsg;Z)V
    //   990: goto -442 -> 548
    //   993: aload 27
    //   995: getfield 844	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_vedio_game_push_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo;
    //   998: invokevirtual 847	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:has	()Z
    //   1001: ifeq +132 -> 1133
    //   1004: aload_1
    //   1005: getstatic 851	com/tencent/avgame/business/handler/AvGameRoomListHandler:a	Ljava/lang/String;
    //   1008: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1011: checkcast 849	com/tencent/avgame/business/handler/AvGameRoomListHandler
    //   1014: astore_2
    //   1015: aload_2
    //   1016: ifnull -468 -> 548
    //   1019: aload 27
    //   1021: getfield 844	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_qq_vedio_game_push_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo;
    //   1024: invokevirtual 852	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1027: checkcast 846	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo
    //   1030: astore 11
    //   1032: aload 11
    //   1034: ifnull +87 -> 1121
    //   1037: aload 11
    //   1039: getfield 855	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1042: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1045: ifeq +4429 -> 5474
    //   1048: aload 11
    //   1050: getfield 855	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1053: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1056: istore_3
    //   1057: goto +3 -> 1060
    //   1060: aload 11
    //   1062: getfield 859	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1065: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1068: ifeq +4411 -> 5479
    //   1071: aload 11
    //   1073: getfield 859	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1076: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1079: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1082: astore_1
    //   1083: goto +3 -> 1086
    //   1086: aload 11
    //   1088: getfield 862	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1091: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1094: ifeq +16 -> 1110
    //   1097: aload 11
    //   1099: getfield 862	tencent/im/oidb/cmd0x857/TroopTips0x857$QQVedioGamePushInfo:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1102: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1105: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1108: astore 26
    //   1110: aload_2
    //   1111: iload_3
    //   1112: aload_1
    //   1113: aload 26
    //   1115: invokevirtual 865	com/tencent/avgame/business/handler/AvGameRoomListHandler:b	(ILjava/lang/String;Ljava/lang/String;)V
    //   1118: goto -570 -> 548
    //   1121: ldc 88
    //   1123: iconst_2
    //   1124: ldc_w 867
    //   1127: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1130: goto -582 -> 548
    //   1133: ldc_w 869
    //   1136: iconst_1
    //   1137: ldc_w 871
    //   1140: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1143: goto -595 -> 548
    //   1146: aload 27
    //   1148: getfield 875	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_group_announce_tbc_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo;
    //   1151: invokevirtual 878	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:has	()Z
    //   1154: ifeq -606 -> 548
    //   1157: aload 27
    //   1159: getfield 875	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_group_announce_tbc_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo;
    //   1162: invokevirtual 879	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1165: checkcast 877	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo
    //   1168: astore 11
    //   1170: aload 11
    //   1172: ifnull -624 -> 548
    //   1175: aload 11
    //   1177: getfield 883	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:feeds_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1180: invokevirtual 886	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1183: ifeq +4302 -> 5485
    //   1186: aload 11
    //   1188: getfield 883	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:feeds_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1191: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1194: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1197: astore_2
    //   1198: goto +3 -> 1201
    //   1201: aload 11
    //   1203: getfield 897	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1206: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1209: lstore 4
    //   1211: aload 11
    //   1213: getfield 900	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupAnnounceTBCInfo:action	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1216: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1219: istore_3
    //   1220: iload_3
    //   1221: ifeq +113 -> 1334
    //   1224: iload_3
    //   1225: iconst_1
    //   1226: if_icmpeq +11 -> 1237
    //   1229: iload_3
    //   1230: iconst_2
    //   1231: if_icmpeq +6 -> 1237
    //   1234: goto -686 -> 548
    //   1237: new 244	org/json/JSONObject
    //   1240: dup
    //   1241: invokespecial 901	org/json/JSONObject:<init>	()V
    //   1244: astore_1
    //   1245: aload_1
    //   1246: ldc_w 903
    //   1249: aload_2
    //   1250: invokevirtual 906	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1253: pop
    //   1254: aload_1
    //   1255: ldc_w 908
    //   1258: lload 4
    //   1260: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1263: invokevirtual 906	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1266: pop
    //   1267: aload_1
    //   1268: ldc_w 909
    //   1271: iload_3
    //   1272: invokestatic 475	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1275: invokevirtual 906	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1278: pop
    //   1279: goto +14 -> 1293
    //   1282: astore_2
    //   1283: ldc 88
    //   1285: iconst_1
    //   1286: ldc_w 911
    //   1289: aload_2
    //   1290: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1293: ldc_w 916
    //   1296: invokestatic 99	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1299: checkcast 916	com/tencent/mobileqq/ark/api/IArkAPIService
    //   1302: ldc_w 918
    //   1305: ldc_w 920
    //   1308: aload_1
    //   1309: invokevirtual 921	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1312: invokeinterface 925 4 0
    //   1317: goto -769 -> 548
    //   1320: astore_1
    //   1321: ldc 88
    //   1323: iconst_1
    //   1324: ldc_w 927
    //   1327: aload_1
    //   1328: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1331: goto -783 -> 548
    //   1334: aload_1
    //   1335: aload_2
    //   1336: lload 4
    //   1338: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1341: iconst_1
    //   1342: invokestatic 932	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   1345: goto -797 -> 548
    //   1348: aload 27
    //   1350: getfield 703	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1353: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1356: lstore 4
    //   1358: aload 27
    //   1360: getfield 936	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_group_info_change	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange;
    //   1363: invokevirtual 939	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1366: checkcast 938	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange
    //   1369: astore 11
    //   1371: aload 11
    //   1373: ifnull -825 -> 548
    //   1376: aload 11
    //   1378: getfield 942	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_honor_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1381: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1384: istore 9
    //   1386: iload 9
    //   1388: ifeq +86 -> 1474
    //   1391: aload 11
    //   1393: getfield 942	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_honor_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1396: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1399: istore_3
    //   1400: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1403: ifeq +35 -> 1438
    //   1406: ldc_w 944
    //   1409: iconst_2
    //   1410: ldc_w 946
    //   1413: iconst_2
    //   1414: anewarray 4	java/lang/Object
    //   1417: dup
    //   1418: iconst_0
    //   1419: lload 4
    //   1421: invokestatic 553	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1424: aastore
    //   1425: dup
    //   1426: iconst_1
    //   1427: iload_3
    //   1428: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1431: aastore
    //   1432: invokestatic 557	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1435: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: aload_1
    //   1439: ldc_w 948
    //   1442: aload 26
    //   1444: invokevirtual 952	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1447: checkcast 948	com/tencent/mobileqq/troop/honor/api/ITroopHonorService
    //   1450: astore_2
    //   1451: iload_3
    //   1452: ifne +4038 -> 5490
    //   1455: iconst_1
    //   1456: istore 9
    //   1458: goto +3 -> 1461
    //   1461: aload_2
    //   1462: lload 4
    //   1464: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1467: iload 9
    //   1469: invokeinterface 955 3 0
    //   1474: aload 11
    //   1476: getfield 958	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_member_level_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1479: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1482: ifeq +4020 -> 5502
    //   1485: aload 11
    //   1487: getfield 958	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_member_level_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1490: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1493: istore_3
    //   1494: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq +35 -> 1532
    //   1500: ldc_w 944
    //   1503: iconst_2
    //   1504: ldc_w 960
    //   1507: iconst_2
    //   1508: anewarray 4	java/lang/Object
    //   1511: dup
    //   1512: iconst_0
    //   1513: lload 4
    //   1515: invokestatic 553	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1518: aastore
    //   1519: dup
    //   1520: iconst_1
    //   1521: iload_3
    //   1522: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1525: aastore
    //   1526: invokestatic 557	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1529: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1532: aload_0
    //   1533: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1536: getstatic 963	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1539: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1542: checkcast 965	com/tencent/mobileqq/app/TroopManager
    //   1545: astore_2
    //   1546: aload_2
    //   1547: lload 4
    //   1549: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1552: invokevirtual 969	com/tencent/mobileqq/app/TroopManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1555: astore 26
    //   1557: aload 26
    //   1559: ifnull +112 -> 1671
    //   1562: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq +40 -> 1605
    //   1568: new 23	java/lang/StringBuilder
    //   1571: dup
    //   1572: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   1575: astore 27
    //   1577: aload 27
    //   1579: ldc_w 971
    //   1582: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 27
    //   1588: lload 4
    //   1590: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: ldc 88
    //   1596: iconst_1
    //   1597: aload 27
    //   1599: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1602: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1605: aload 26
    //   1607: iload_3
    //   1608: i2b
    //   1609: putfield 977	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1612: aload_2
    //   1613: aload 26
    //   1615: invokevirtual 980	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   1618: aload_1
    //   1619: getstatic 983	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_ONLINE_PUSH_HANDLER	Ljava/lang/String;
    //   1622: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1625: astore_2
    //   1626: getstatic 988	com/tencent/mobileqq/troop/onlinepush/api/TroopOnlinePushObserver:TYPE_TROOP_RANK_SWITCH_CHANGE	I
    //   1629: istore 8
    //   1631: iload_3
    //   1632: ifne +3864 -> 5496
    //   1635: iconst_1
    //   1636: istore 9
    //   1638: goto +3 -> 1641
    //   1641: aload_2
    //   1642: iload 8
    //   1644: iconst_1
    //   1645: iconst_2
    //   1646: anewarray 4	java/lang/Object
    //   1649: dup
    //   1650: iconst_0
    //   1651: lload 4
    //   1653: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1656: aastore
    //   1657: dup
    //   1658: iconst_1
    //   1659: iload 9
    //   1661: invokestatic 324	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1664: aastore
    //   1665: invokevirtual 994	com/tencent/mobileqq/app/BusinessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1668: goto +3 -> 1671
    //   1671: aload_0
    //   1672: astore_2
    //   1673: aload_1
    //   1674: getstatic 997	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_PUSH_HANDLER	Ljava/lang/String;
    //   1677: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1680: checkcast 999	com/tencent/mobileqq/troop/api/handler/ITroopPushHandler
    //   1683: astore 26
    //   1685: aload 11
    //   1687: getfield 1002	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flagext4	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1690: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1693: ifeq +28 -> 1721
    //   1696: aload 26
    //   1698: ifnull +23 -> 1721
    //   1701: aload 26
    //   1703: lload 4
    //   1705: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1708: aload 11
    //   1710: getfield 1002	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flagext4	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1713: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1716: invokeinterface 1004 3 0
    //   1721: aload 11
    //   1723: getfield 1007	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1726: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1729: ifeq +28 -> 1757
    //   1732: aload 26
    //   1734: ifnull +23 -> 1757
    //   1737: aload 26
    //   1739: lload 4
    //   1741: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1744: aload 11
    //   1746: getfield 1007	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1749: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1752: invokeinterface 1009 3 0
    //   1757: aload 11
    //   1759: getfield 1012	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1762: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1765: ifeq +28 -> 1793
    //   1768: aload 26
    //   1770: ifnull +23 -> 1793
    //   1773: aload 26
    //   1775: lload 4
    //   1777: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1780: aload 11
    //   1782: getfield 1012	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1785: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1788: invokeinterface 1014 3 0
    //   1793: aload 11
    //   1795: getfield 1017	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1798: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1801: ifeq +308 -> 2109
    //   1804: aload 11
    //   1806: getfield 1017	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1809: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1812: istore_3
    //   1813: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1816: istore 9
    //   1818: iload 9
    //   1820: ifeq +57 -> 1877
    //   1823: new 23	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   1830: astore 26
    //   1832: aload 26
    //   1834: ldc_w 1019
    //   1837: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: pop
    //   1841: aload 26
    //   1843: lload 4
    //   1845: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload 26
    //   1851: ldc_w 1021
    //   1854: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 26
    //   1860: iload_3
    //   1861: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1864: pop
    //   1865: ldc_w 1023
    //   1868: iconst_2
    //   1869: aload 26
    //   1871: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1877: aload_2
    //   1878: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1881: getstatic 963	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1884: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1887: checkcast 965	com/tencent/mobileqq/app/TroopManager
    //   1890: astore 26
    //   1892: aload 26
    //   1894: ifnull +215 -> 2109
    //   1897: aload 26
    //   1899: lload 4
    //   1901: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1904: invokevirtual 969	com/tencent/mobileqq/app/TroopManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1907: astore 27
    //   1909: aload 27
    //   1911: ifnull +182 -> 2093
    //   1914: iload_3
    //   1915: sipush 128
    //   1918: iand
    //   1919: sipush 128
    //   1922: if_icmpne +3583 -> 5505
    //   1925: iconst_1
    //   1926: istore 9
    //   1928: goto +3 -> 1931
    //   1931: aload 27
    //   1933: iload 9
    //   1935: putfield 1026	com/tencent/mobileqq/data/troop/TroopInfo:isTroopBlocked	Z
    //   1938: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1941: ifeq +41 -> 1982
    //   1944: new 23	java/lang/StringBuilder
    //   1947: dup
    //   1948: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   1951: astore 28
    //   1953: aload 28
    //   1955: ldc_w 1028
    //   1958: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: pop
    //   1962: aload 28
    //   1964: iload 9
    //   1966: invokevirtual 1031	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1969: pop
    //   1970: ldc_w 1023
    //   1973: iconst_2
    //   1974: aload 28
    //   1976: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1979: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1982: aload 11
    //   1984: getfield 1034	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_appeal_deadline	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1987: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1990: ifeq +64 -> 2054
    //   1993: aload 27
    //   1995: aload 11
    //   1997: getfield 1034	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_appeal_deadline	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2000: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2003: i2l
    //   2004: putfield 1037	com/tencent/mobileqq/data/troop/TroopInfo:appealDeadline	J
    //   2007: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2010: ifeq +44 -> 2054
    //   2013: new 23	java/lang/StringBuilder
    //   2016: dup
    //   2017: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   2020: astore 28
    //   2022: aload 28
    //   2024: ldc_w 1039
    //   2027: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: pop
    //   2031: aload 28
    //   2033: aload 27
    //   2035: getfield 1037	com/tencent/mobileqq/data/troop/TroopInfo:appealDeadline	J
    //   2038: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2041: pop
    //   2042: ldc_w 1023
    //   2045: iconst_2
    //   2046: aload 28
    //   2048: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2051: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2054: aload 26
    //   2056: aload 27
    //   2058: invokevirtual 980	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   2061: aload_2
    //   2062: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2065: getstatic 983	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_ONLINE_PUSH_HANDLER	Ljava/lang/String;
    //   2068: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2071: getstatic 1042	com/tencent/mobileqq/troop/onlinepush/api/TroopOnlinePushObserver:TYPE_TROOP_BLOCK_STATUS_CHANGED	I
    //   2074: iconst_1
    //   2075: iconst_1
    //   2076: anewarray 4	java/lang/Object
    //   2079: dup
    //   2080: iconst_0
    //   2081: lload 23
    //   2083: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2086: aastore
    //   2087: invokevirtual 994	com/tencent/mobileqq/app/BusinessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   2090: goto +19 -> 2109
    //   2093: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2096: ifeq +13 -> 2109
    //   2099: ldc_w 1023
    //   2102: iconst_2
    //   2103: ldc_w 1044
    //   2106: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2109: aload 11
    //   2111: getfield 1047	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange:uint32_group_info_ext_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2114: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2117: ifeq +3401 -> 5518
    //   2120: aload_1
    //   2121: getstatic 1050	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_INFO_EXT_HANDLER	Ljava/lang/String;
    //   2124: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2127: checkcast 1052	com/tencent/mobileqq/troop/api/handler/ITroopInfoExtHandler
    //   2130: lload 4
    //   2132: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2135: invokeinterface 1054 2 0
    //   2140: goto +3378 -> 5518
    //   2143: aload 27
    //   2145: getfield 1058	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_sing_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$SingChangePushInfo;
    //   2148: invokevirtual 1061	tencent/im/oidb/cmd0x857/TroopTips0x857$SingChangePushInfo:has	()Z
    //   2151: ifeq +44 -> 2195
    //   2154: aload_1
    //   2155: getstatic 1064	com/tencent/mobileqq/app/QQManagerFactory:TOGETHER_CONTROLLER_MANAGER	I
    //   2158: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2161: checkcast 1066	com/tencent/mobileqq/together/TogetherControlManager
    //   2164: iconst_4
    //   2165: invokevirtual 1069	com/tencent/mobileqq/together/TogetherControlManager:a	(I)Lcom/tencent/mobileqq/together/TogetherParser;
    //   2168: astore_2
    //   2169: aload_2
    //   2170: ifnull +3348 -> 5518
    //   2173: aload_2
    //   2174: aload_1
    //   2175: lload 17
    //   2177: lload 4
    //   2179: aload 27
    //   2181: getfield 1058	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_sing_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$SingChangePushInfo;
    //   2184: invokevirtual 1070	tencent/im/oidb/cmd0x857/TroopTips0x857$SingChangePushInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2187: invokeinterface 1075 7 0
    //   2192: goto +3326 -> 5518
    //   2195: ldc_w 1077
    //   2198: iconst_2
    //   2199: ldc_w 1079
    //   2202: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2205: goto +3313 -> 5518
    //   2208: aload_1
    //   2209: aload 27
    //   2211: invokestatic 1084	com/tencent/mobileqq/location/net/QQTroopLocationPushDecoder:a	(Lcom/tencent/common/app/AppInterface;Ltencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody;)V
    //   2214: goto +3304 -> 5518
    //   2217: aload 27
    //   2219: getfield 1088	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_video_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$VideoChangePushInfo;
    //   2222: invokevirtual 1091	tencent/im/oidb/cmd0x857/TroopTips0x857$VideoChangePushInfo:has	()Z
    //   2225: ifeq +44 -> 2269
    //   2228: aload_1
    //   2229: getstatic 1064	com/tencent/mobileqq/app/QQManagerFactory:TOGETHER_CONTROLLER_MANAGER	I
    //   2232: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2235: checkcast 1066	com/tencent/mobileqq/together/TogetherControlManager
    //   2238: iconst_2
    //   2239: invokevirtual 1069	com/tencent/mobileqq/together/TogetherControlManager:a	(I)Lcom/tencent/mobileqq/together/TogetherParser;
    //   2242: astore_2
    //   2243: aload_2
    //   2244: ifnull +3274 -> 5518
    //   2247: aload_2
    //   2248: aload_1
    //   2249: lload 17
    //   2251: lload 4
    //   2253: aload 27
    //   2255: getfield 1088	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_video_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$VideoChangePushInfo;
    //   2258: invokevirtual 1092	tencent/im/oidb/cmd0x857/TroopTips0x857$VideoChangePushInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2261: invokeinterface 1075 7 0
    //   2266: goto +3252 -> 5518
    //   2269: ldc_w 1077
    //   2272: iconst_2
    //   2273: ldc_w 1094
    //   2276: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2279: goto +3239 -> 5518
    //   2282: astore_1
    //   2283: ldc 88
    //   2285: astore_2
    //   2286: goto +3108 -> 5394
    //   2289: aload 27
    //   2291: getfield 1098	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_general_gray_tip	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo;
    //   2294: invokevirtual 1101	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:has	()Z
    //   2297: istore 9
    //   2299: iload 9
    //   2301: ifeq +863 -> 3164
    //   2304: aload 27
    //   2306: getfield 1098	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_general_gray_tip	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo;
    //   2309: invokevirtual 1102	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2312: checkcast 1100	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo
    //   2315: astore 29
    //   2317: aload 29
    //   2319: getfield 1105	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_busi_type	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2322: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2325: istore 9
    //   2327: iload 9
    //   2329: ifeq +28 -> 2357
    //   2332: aload 29
    //   2334: getfield 1105	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_busi_type	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2337: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2340: lstore 17
    //   2342: goto +18 -> 2360
    //   2345: astore_1
    //   2346: goto +3180 -> 5526
    //   2349: astore_1
    //   2350: goto +776 -> 3126
    //   2353: astore_1
    //   2354: goto +791 -> 3145
    //   2357: lconst_0
    //   2358: lstore 17
    //   2360: aload 29
    //   2362: getfield 1106	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_busi_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2365: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2368: istore 9
    //   2370: iload 9
    //   2372: ifeq +16 -> 2388
    //   2375: aload 29
    //   2377: getfield 1106	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_busi_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2380: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2383: lstore 19
    //   2385: goto +6 -> 2391
    //   2388: lconst_0
    //   2389: lstore 19
    //   2391: aload 29
    //   2393: getfield 1109	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_templ_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2396: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2399: istore 9
    //   2401: iload 9
    //   2403: ifeq +16 -> 2419
    //   2406: aload 29
    //   2408: getfield 1109	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_templ_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2411: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2414: lstore 21
    //   2416: goto +6 -> 2422
    //   2419: lconst_0
    //   2420: lstore 21
    //   2422: aload 29
    //   2424: getfield 1112	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_ctrl_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2427: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2430: istore 9
    //   2432: iload 9
    //   2434: ifeq +16 -> 2450
    //   2437: aload 29
    //   2439: getfield 1112	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_ctrl_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2442: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2445: istore 13
    //   2447: goto +6 -> 2453
    //   2450: iconst_0
    //   2451: istore 13
    //   2453: aload 29
    //   2455: getfield 1115	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2458: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2461: istore 9
    //   2463: iload 9
    //   2465: ifeq +12 -> 2477
    //   2468: aload 29
    //   2470: getfield 1115	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2473: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2476: pop
    //   2477: aload 29
    //   2479: getfield 1116	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2482: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2485: istore 9
    //   2487: iload 9
    //   2489: ifeq +12 -> 2501
    //   2492: aload 29
    //   2494: getfield 1116	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2497: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2500: pop
    //   2501: aload 29
    //   2503: getfield 1119	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:bytes_pb_reserv	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2506: invokevirtual 886	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2509: istore 9
    //   2511: iload 9
    //   2513: ifeq +18 -> 2531
    //   2516: aload 29
    //   2518: getfield 1119	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:bytes_pb_reserv	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2521: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2524: invokevirtual 1120	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2527: astore_2
    //   2528: goto +5 -> 2533
    //   2531: aconst_null
    //   2532: astore_2
    //   2533: aload 29
    //   2535: getfield 1123	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2538: invokevirtual 886	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2541: istore 9
    //   2543: iload 9
    //   2545: ifeq +19 -> 2564
    //   2548: aload 29
    //   2550: getfield 1123	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2553: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2556: invokevirtual 1120	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2559: astore 11
    //   2561: goto +6 -> 2567
    //   2564: aconst_null
    //   2565: astore 11
    //   2567: aload 29
    //   2569: getfield 1124	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_tips_seq_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2572: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2575: istore 9
    //   2577: iload 9
    //   2579: ifeq +13 -> 2592
    //   2582: aload 29
    //   2584: getfield 1124	tencent/im/oidb/cmd0x857/TroopTips0x857$GeneralGrayTipInfo:uint64_tips_seq_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2587: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2590: lstore 15
    //   2592: aload 11
    //   2594: ifnull +26 -> 2620
    //   2597: aload 11
    //   2599: arraylength
    //   2600: ifle +20 -> 2620
    //   2603: new 111	java/lang/String
    //   2606: dup
    //   2607: aload 11
    //   2609: ldc_w 1126
    //   2612: invokespecial 1128	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2615: astore 11
    //   2617: goto +29 -> 2646
    //   2620: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2623: istore 9
    //   2625: iload 9
    //   2627: ifeq +15 -> 2642
    //   2630: ldc 88
    //   2632: iconst_2
    //   2633: ldc_w 1130
    //   2636: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2639: goto +3 -> 2642
    //   2642: aload 26
    //   2644: astore 11
    //   2646: iload 13
    //   2648: invokestatic 1132	com/tencent/mobileqq/graytip/UniteGrayTipUtil:a	(I)I
    //   2651: istore 13
    //   2653: aload_0
    //   2654: aload_1
    //   2655: lload 23
    //   2657: lload 19
    //   2659: lload 21
    //   2661: aload 11
    //   2663: invokespecial 1134	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJJLjava/lang/String;)V
    //   2666: aload_0
    //   2667: lload 19
    //   2669: invokespecial 73	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(J)Z
    //   2672: istore 9
    //   2674: iload 9
    //   2676: ifeq +42 -> 2718
    //   2679: invokestatic 1138	com/tencent/mobileqq/studymode/StudyModeManager:h	()Z
    //   2682: istore 9
    //   2684: iload 9
    //   2686: ifeq +5 -> 2691
    //   2689: aconst_null
    //   2690: areturn
    //   2691: aload_0
    //   2692: lload 23
    //   2694: lload 19
    //   2696: invokespecial 1140	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(JJ)V
    //   2699: goto +19 -> 2718
    //   2702: astore_1
    //   2703: goto -353 -> 2350
    //   2706: astore_1
    //   2707: goto -353 -> 2354
    //   2710: astore_1
    //   2711: goto -361 -> 2350
    //   2714: astore_1
    //   2715: goto -361 -> 2354
    //   2718: aload 28
    //   2720: getfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   2723: astore 28
    //   2725: aload_1
    //   2726: aload 28
    //   2728: iconst_1
    //   2729: iload 13
    //   2731: lload 4
    //   2733: aload 11
    //   2735: lload 17
    //   2737: lload 19
    //   2739: aload_2
    //   2740: invokestatic 1143	com/tencent/mobileqq/graytip/UniteGrayTipUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IIJLjava/lang/String;JJ[B)Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;
    //   2743: astore_2
    //   2744: aload_2
    //   2745: ifnull +2805 -> 5550
    //   2748: aload_2
    //   2749: ldc_w 1144
    //   2752: lload 17
    //   2754: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2757: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2760: aload_2
    //   2761: ldc_w 579
    //   2764: lload 19
    //   2766: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2769: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2772: aload_2
    //   2773: ldc_w 1146
    //   2776: lload 21
    //   2778: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2781: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2784: aload_2
    //   2785: ldc_w 1147
    //   2788: aload 11
    //   2790: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2793: aload_2
    //   2794: ldc_w 573
    //   2797: lload 15
    //   2799: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2802: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2805: aload 27
    //   2807: getfield 1150	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_group_cur_msg_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2810: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2813: istore 9
    //   2815: iload 9
    //   2817: ifeq +26 -> 2843
    //   2820: aload_2
    //   2821: aload 27
    //   2823: getfield 1150	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_group_cur_msg_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2826: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2829: putfield 535	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:shmsgseq	J
    //   2832: goto +11 -> 2843
    //   2835: astore_1
    //   2836: goto -486 -> 2350
    //   2839: astore_1
    //   2840: goto -486 -> 2354
    //   2843: aload 27
    //   2845: getfield 1153	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_sysdb_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2848: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2851: istore 9
    //   2853: iload 9
    //   2855: ifeq +21 -> 2876
    //   2858: aload_2
    //   2859: ldc_w 1155
    //   2862: aload 27
    //   2864: getfield 1153	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_sysdb_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2867: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2870: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2873: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   2876: aload_2
    //   2877: getfield 1159	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   2880: lload 15
    //   2882: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2885: putfield 1163	com/tencent/mobileqq/graytip/UniteGrayTipParam:p	Ljava/lang/String;
    //   2888: new 23	java/lang/StringBuilder
    //   2891: dup
    //   2892: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   2895: astore 11
    //   2897: aload 11
    //   2899: aload 26
    //   2901: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2904: pop
    //   2905: aload 11
    //   2907: lload 19
    //   2909: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2912: pop
    //   2913: aload 11
    //   2915: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2918: astore 11
    //   2920: new 23	java/lang/StringBuilder
    //   2923: dup
    //   2924: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   2927: astore 27
    //   2929: aload 27
    //   2931: aload 26
    //   2933: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2936: pop
    //   2937: aload 27
    //   2939: lload 17
    //   2941: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2944: pop
    //   2945: aload_1
    //   2946: ldc_w 1165
    //   2949: ldc_w 261
    //   2952: ldc_w 261
    //   2955: ldc_w 1167
    //   2958: ldc_w 1167
    //   2961: iconst_3
    //   2962: iconst_0
    //   2963: aload 11
    //   2965: aload 27
    //   2967: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2970: ldc_w 261
    //   2973: ldc_w 261
    //   2976: invokestatic 1172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2979: aload_2
    //   2980: invokestatic 1176	com/tencent/mobileqq/activity/aio/avatardoubletap/PaiYiPaiMsgUtil:a	(Ljava/lang/Object;)Z
    //   2983: istore 9
    //   2985: iload 9
    //   2987: ifeq +32 -> 3019
    //   2990: aload_2
    //   2991: lload 6
    //   2993: putfield 1179	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:msgUid	J
    //   2996: aload_2
    //   2997: ldc_w 1181
    //   3000: iload 8
    //   3002: invokestatic 475	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3005: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   3008: aload_2
    //   3009: ldc_w 1183
    //   3012: iload_3
    //   3013: invokestatic 475	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3016: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   3019: aload_2
    //   3020: aload_0
    //   3021: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3024: invokestatic 1185	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   3027: istore 9
    //   3029: iload 9
    //   3031: ifne +12 -> 3043
    //   3034: aload_1
    //   3035: aload_2
    //   3036: invokestatic 1190	com/tencent/mobileqq/graytip/UniteGrayTipMsgUtil:a	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;)Z
    //   3039: pop
    //   3040: goto +2510 -> 5550
    //   3043: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3046: ifeq +2504 -> 5550
    //   3049: new 23	java/lang/StringBuilder
    //   3052: dup
    //   3053: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   3056: astore_1
    //   3057: aload_1
    //   3058: ldc_w 1192
    //   3061: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3064: pop
    //   3065: aload_1
    //   3066: aload_2
    //   3067: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3070: pop
    //   3071: aload_1
    //   3072: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3075: astore_1
    //   3076: ldc 88
    //   3078: iconst_2
    //   3079: aload_1
    //   3080: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3083: goto +2467 -> 5550
    //   3086: astore_1
    //   3087: goto +39 -> 3126
    //   3090: astore_1
    //   3091: goto +2431 -> 5522
    //   3094: astore_1
    //   3095: goto +31 -> 3126
    //   3098: astore_1
    //   3099: goto +2423 -> 5522
    //   3102: astore_1
    //   3103: goto +23 -> 3126
    //   3106: astore_1
    //   3107: goto +2415 -> 5522
    //   3110: astore_1
    //   3111: ldc 88
    //   3113: astore_2
    //   3114: goto +2280 -> 5394
    //   3117: astore_1
    //   3118: goto +8 -> 3126
    //   3121: astore_1
    //   3122: goto +2400 -> 5522
    //   3125: astore_1
    //   3126: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3129: ifeq +2421 -> 5550
    //   3132: ldc 88
    //   3134: iconst_2
    //   3135: ldc_w 1194
    //   3138: aload_1
    //   3139: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3142: goto +2408 -> 5550
    //   3145: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3148: ifeq +2402 -> 5550
    //   3151: ldc 88
    //   3153: iconst_2
    //   3154: ldc_w 1196
    //   3157: aload_1
    //   3158: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3161: goto +2389 -> 5550
    //   3164: ldc_w 1198
    //   3167: iconst_1
    //   3168: ldc_w 1200
    //   3171: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3174: goto +2376 -> 5550
    //   3177: aload 27
    //   3179: getfield 1204	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_media_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo;
    //   3182: invokevirtual 1207	tencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo:has	()Z
    //   3185: ifeq +25 -> 3210
    //   3188: aload_1
    //   3189: lload 17
    //   3191: lload 4
    //   3193: aload 27
    //   3195: getfield 1204	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_media_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo;
    //   3198: invokevirtual 1208	tencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3201: checkcast 1206	tencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo
    //   3204: invokestatic 1213	com/tencent/mobileqq/listentogether/ListenTogetherPushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJLtencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo;)V
    //   3207: goto +2343 -> 5550
    //   3210: ldc_w 1198
    //   3213: iconst_1
    //   3214: ldc_w 1200
    //   3217: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3220: goto +2330 -> 5550
    //   3223: ldc 88
    //   3225: astore_2
    //   3226: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3229: ifeq +11 -> 3240
    //   3232: aload_2
    //   3233: iconst_2
    //   3234: ldc_w 1215
    //   3237: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3240: aload_2
    //   3241: iconst_1
    //   3242: ldc_w 1217
    //   3245: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3248: aload 27
    //   3250: getfield 1221	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_troopformtips_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$TroopFormGrayTipsInfo;
    //   3253: invokevirtual 1224	tencent/im/oidb/cmd0x857/TroopTips0x857$TroopFormGrayTipsInfo:has	()Z
    //   3256: ifeq +2294 -> 5550
    //   3259: aload 27
    //   3261: getfield 1221	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_troopformtips_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$TroopFormGrayTipsInfo;
    //   3264: invokevirtual 1225	tencent/im/oidb/cmd0x857/TroopTips0x857$TroopFormGrayTipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3267: checkcast 1223	tencent/im/oidb/cmd0x857/TroopTips0x857$TroopFormGrayTipsInfo
    //   3270: astore_2
    //   3271: ldc_w 1227
    //   3274: invokestatic 99	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3277: checkcast 1227	com/tencent/mobileqq/teamwork/api/ITeamWorkUtilsTemp
    //   3280: aload_1
    //   3281: aload_2
    //   3282: aload 28
    //   3284: getfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   3287: invokeinterface 1231 4 0
    //   3292: goto +2258 -> 5550
    //   3295: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3298: ifeq +12 -> 3310
    //   3301: ldc 88
    //   3303: iconst_2
    //   3304: ldc_w 1233
    //   3307: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3310: aload_1
    //   3311: ifnull +2239 -> 5550
    //   3314: aload_1
    //   3315: getstatic 1236	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_INFO_HANDLER	Ljava/lang/String;
    //   3318: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3321: checkcast 1238	com/tencent/mobileqq/troop/api/handler/ITroopInfoHandler
    //   3324: lload 23
    //   3326: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3329: iconst_0
    //   3330: ldc_w 261
    //   3333: iconst_0
    //   3334: iconst_1
    //   3335: iconst_0
    //   3336: iconst_1
    //   3337: invokeinterface 1241 8 0
    //   3342: goto +2208 -> 5550
    //   3345: ldc 88
    //   3347: astore_1
    //   3348: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3351: ifeq +11 -> 3362
    //   3354: aload_1
    //   3355: iconst_2
    //   3356: ldc_w 1243
    //   3359: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3362: aload 27
    //   3364: getfield 1247	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_miniapp_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MiniAppNotify;
    //   3367: invokevirtual 1250	tencent/im/oidb/cmd0x857/TroopTips0x857$MiniAppNotify:has	()Z
    //   3370: istore 9
    //   3372: iload 9
    //   3374: ifeq +2176 -> 5550
    //   3377: aload 27
    //   3379: getfield 1247	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_miniapp_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MiniAppNotify;
    //   3382: getfield 1253	tencent/im/oidb/cmd0x857/TroopTips0x857$MiniAppNotify:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3385: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3388: invokevirtual 1120	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3391: astore_2
    //   3392: new 331	tencent/im/oidb/cmd0x857/GroupOpenSysMsg$SysMsgBody
    //   3395: dup
    //   3396: invokespecial 1254	tencent/im/oidb/cmd0x857/GroupOpenSysMsg$SysMsgBody:<init>	()V
    //   3399: astore 11
    //   3401: aload 11
    //   3403: aload_2
    //   3404: invokevirtual 1255	tencent/im/oidb/cmd0x857/GroupOpenSysMsg$SysMsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3407: pop
    //   3408: aload_0
    //   3409: aload 11
    //   3411: aload 28
    //   3413: invokespecial 1257	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Ltencent/im/oidb/cmd0x857/GroupOpenSysMsg$SysMsgBody;Lcom/tencent/mobileqq/troop/data/TroopTipsEntity;)V
    //   3416: goto +2134 -> 5550
    //   3419: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3422: ifeq +2128 -> 5550
    //   3425: aload_1
    //   3426: iconst_2
    //   3427: ldc_w 1259
    //   3430: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3433: goto +2117 -> 5550
    //   3436: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3439: ifeq +12 -> 3451
    //   3442: ldc 88
    //   3444: iconst_2
    //   3445: ldc_w 1261
    //   3448: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3451: aload 27
    //   3453: getfield 1265	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_goldtips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem;
    //   3456: invokevirtual 1268	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem:has	()Z
    //   3459: ifeq +2091 -> 5550
    //   3462: aload 27
    //   3464: getfield 1265	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_goldtips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem;
    //   3467: invokevirtual 1269	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3470: checkcast 1267	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem
    //   3473: astore_1
    //   3474: aload_1
    //   3475: getfield 1272	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3478: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3481: ifeq +2069 -> 5550
    //   3484: aload_1
    //   3485: getfield 1272	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3488: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3491: iconst_3
    //   3492: if_icmpne +2058 -> 5550
    //   3495: ldc_w 1274
    //   3498: invokestatic 99	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3501: checkcast 1274	com/tencent/mobileqq/qwallet/transaction/INotifyMsgApi
    //   3504: iconst_1
    //   3505: aload 27
    //   3507: getfield 1265	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_goldtips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem;
    //   3510: invokevirtual 1269	tencent/im/oidb/cmd0x857/TroopTips0x857$GoldMsgTipsElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3513: aconst_null
    //   3514: invokeinterface 1278 4 0
    //   3519: goto +2031 -> 5550
    //   3522: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3525: ifeq +13 -> 3538
    //   3528: ldc_w 1280
    //   3531: iconst_2
    //   3532: ldc_w 1261
    //   3535: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3538: aload 27
    //   3540: getfield 1284	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:apllo_msg_push	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   3543: invokevirtual 1287	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   3546: ifeq +2004 -> 5550
    //   3549: aload 27
    //   3551: getfield 1284	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:apllo_msg_push	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   3554: invokevirtual 1288	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3557: checkcast 1286	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   3560: astore_2
    //   3561: aload_0
    //   3562: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3565: ifnull +1985 -> 5550
    //   3568: aload_1
    //   3569: ldc_w 1290
    //   3572: ldc_w 1292
    //   3575: invokevirtual 952	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3578: checkcast 1290	com/tencent/mobileqq/apollo/api/IApolloPushManager
    //   3581: iconst_1
    //   3582: aload_2
    //   3583: invokeinterface 1296 3 0
    //   3588: goto +1962 -> 5550
    //   3591: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3594: ifeq +1956 -> 5550
    //   3597: ldc_w 1298
    //   3600: iconst_2
    //   3601: ldc_w 1300
    //   3604: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3607: goto +1943 -> 5550
    //   3610: aload 27
    //   3612: getfield 1304	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_werewolf_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush;
    //   3615: invokevirtual 1307	tencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush:has	()Z
    //   3618: ifeq +1932 -> 5550
    //   3621: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3624: ifeq +13 -> 3637
    //   3627: ldc_w 1309
    //   3630: iconst_2
    //   3631: ldc_w 1311
    //   3634: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3637: aload_1
    //   3638: getstatic 1314	com/tencent/mobileqq/app/BusinessHandlerFactory:WEREWOLVES_HANDLER	Ljava/lang/String;
    //   3641: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3644: checkcast 1316	com/tencent/mobileqq/werewolves/WerewolvesHandler
    //   3647: aload 27
    //   3649: getfield 1304	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_werewolf_push	Ltencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush;
    //   3652: invokevirtual 1317	tencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3655: checkcast 1306	tencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush
    //   3658: aload_2
    //   3659: invokevirtual 1320	com/tencent/mobileqq/werewolves/WerewolvesHandler:a	(Ltencent/im/oidb/cmd0x857/TroopTips0x857$WereWolfPush;[B)V
    //   3662: goto +1888 -> 5550
    //   3665: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3668: istore 9
    //   3670: iload 9
    //   3672: ifeq +13 -> 3685
    //   3675: ldc_w 1322
    //   3678: iconst_2
    //   3679: ldc_w 1324
    //   3682: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3685: aload 27
    //   3687: getfield 1328	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_objmsg_update	Ltencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate;
    //   3690: invokevirtual 1331	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate:has	()Z
    //   3693: ifeq +1857 -> 5550
    //   3696: aload 27
    //   3698: getfield 1328	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_objmsg_update	Ltencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate;
    //   3701: invokevirtual 1332	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3704: checkcast 1330	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate
    //   3707: astore 11
    //   3709: aload 11
    //   3711: getfield 1335	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate:bytes_ext_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3714: invokevirtual 886	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3717: ifeq +1833 -> 5550
    //   3720: new 1337	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   3723: dup
    //   3724: invokespecial 1338	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   3727: astore_2
    //   3728: aload_2
    //   3729: aload 11
    //   3731: getfield 1335	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyObjmsgUpdate:bytes_ext_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3734: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3737: invokevirtual 1120	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3740: invokevirtual 1339	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3743: pop
    //   3744: goto +19 -> 3763
    //   3747: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3750: ifeq +13 -> 3763
    //   3753: ldc_w 1322
    //   3756: iconst_2
    //   3757: ldc_w 1341
    //   3760: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3763: aload_1
    //   3764: getstatic 1344	com/tencent/mobileqq/app/QQManagerFactory:GAME_PARTY_MANAGER	I
    //   3767: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3770: checkcast 1346	com/tencent/mobileqq/gameparty/GamePartyManager
    //   3773: aload_2
    //   3774: iconst_0
    //   3775: invokevirtual 1349	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   3778: goto +1772 -> 5550
    //   3781: aload 11
    //   3783: ifnull +9 -> 3792
    //   3786: aload 11
    //   3788: iconst_0
    //   3789: putfield 1353	com/tencent/mobileqq/service/message/codec/decoder/MsgType0x2dcDecoder$Parse0x2dcContext:a	Z
    //   3792: aload 27
    //   3794: getfield 1357	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_recall	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder;
    //   3797: invokevirtual 1360	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:has	()Z
    //   3800: ifeq +1750 -> 5550
    //   3803: aload 27
    //   3805: getfield 1357	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_recall	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder;
    //   3808: invokevirtual 1361	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3811: checkcast 1359	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder
    //   3814: astore 26
    //   3816: aload 26
    //   3818: getfield 1364	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3821: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3824: lstore 4
    //   3826: aload 26
    //   3828: getfield 1367	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:uint64_admin_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3831: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3834: lstore 6
    //   3836: aload 26
    //   3838: getfield 1370	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3841: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3844: istore 8
    //   3846: aload 26
    //   3848: getfield 1374	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:msg_wording_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo;
    //   3851: invokevirtual 1377	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo:has	()Z
    //   3854: istore 9
    //   3856: iload 9
    //   3858: ifeq +30 -> 3888
    //   3861: aload 26
    //   3863: getfield 1374	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:msg_wording_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo;
    //   3866: getfield 1381	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo:int32_item_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3869: invokevirtual 1384	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3872: istore_3
    //   3873: aload 26
    //   3875: getfield 1374	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:msg_wording_info	Ltencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo;
    //   3878: getfield 1387	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$WithDrawWordingInfo:string_item_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3881: invokevirtual 365	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3884: astore_1
    //   3885: goto +5 -> 3890
    //   3888: iconst_0
    //   3889: istore_3
    //   3890: new 51	java/util/HashMap
    //   3893: dup
    //   3894: invokespecial 52	java/util/HashMap:<init>	()V
    //   3897: astore 11
    //   3899: new 1389	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef
    //   3902: dup
    //   3903: invokespecial 1390	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef:<init>	()V
    //   3906: astore_2
    //   3907: aload_2
    //   3908: aload 26
    //   3910: getfield 1393	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:bytes_userdef	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3913: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3916: invokevirtual 1120	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3919: invokevirtual 1394	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3922: pop
    //   3923: aload_2
    //   3924: getfield 1397	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef:uint32_long_message_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3927: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3930: istore 13
    //   3932: iload 13
    //   3934: iconst_1
    //   3935: if_icmpne +62 -> 3997
    //   3938: aload_2
    //   3939: getfield 1401	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef:long_msg_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3942: invokevirtual 1406	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3945: checkcast 64	java/util/ArrayList
    //   3948: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3951: astore_2
    //   3952: aload_2
    //   3953: invokeinterface 166 1 0
    //   3958: ifeq +39 -> 3997
    //   3961: aload_2
    //   3962: invokeinterface 170 1 0
    //   3967: checkcast 1408	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef
    //   3970: astore 27
    //   3972: aload 11
    //   3974: aload 27
    //   3976: getfield 1411	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef:uint32_msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3979: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3982: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3985: aload 27
    //   3987: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3990: pop
    //   3991: goto -39 -> 3952
    //   3994: goto +315 -> 4309
    //   3997: new 64	java/util/ArrayList
    //   4000: dup
    //   4001: invokespecial 65	java/util/ArrayList:<init>	()V
    //   4004: astore 27
    //   4006: aload 26
    //   4008: getfield 1414	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder:uint32_recalled_msg_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4011: invokevirtual 1406	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4014: checkcast 64	java/util/ArrayList
    //   4017: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4020: astore_2
    //   4021: aload_2
    //   4022: invokeinterface 166 1 0
    //   4027: istore 9
    //   4029: iload 9
    //   4031: ifeq +263 -> 4294
    //   4034: aload_2
    //   4035: invokeinterface 170 1 0
    //   4040: checkcast 1416	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta
    //   4043: astore 28
    //   4045: new 1418	com/tencent/mobileqq/revokemsg/RevokeMsgInfo
    //   4048: dup
    //   4049: invokespecial 1419	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:<init>	()V
    //   4052: astore 26
    //   4054: aload 26
    //   4056: lload 4
    //   4058: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4061: putfield 1421	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:d	Ljava/lang/String;
    //   4064: aload 26
    //   4066: lload 6
    //   4068: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4071: putfield 1423	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:e	Ljava/lang/String;
    //   4074: aload 26
    //   4076: lload 23
    //   4078: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4081: putfield 1425	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:c	Ljava/lang/String;
    //   4084: aload 26
    //   4086: iconst_1
    //   4087: putfield 1427	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:a	I
    //   4090: aload 26
    //   4092: aload 28
    //   4094: getfield 1430	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4097: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4100: i2l
    //   4101: putfield 1432	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:b	J
    //   4104: aload 26
    //   4106: aload 28
    //   4108: getfield 1435	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta:uint32_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4111: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4114: i2l
    //   4115: putfield 1437	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:g	J
    //   4118: aload 26
    //   4120: aload 28
    //   4122: getfield 1440	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta:uint64_author_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4125: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4128: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4131: putfield 1443	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:l	Ljava/lang/String;
    //   4134: aload 26
    //   4136: iload 8
    //   4138: putfield 1446	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:m	I
    //   4141: aload 26
    //   4143: aload 28
    //   4145: getfield 1449	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta:uint32_is_anony_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4148: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4151: putfield 1452	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:n	I
    //   4154: aload 26
    //   4156: iload_3
    //   4157: putfield 1454	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:p	I
    //   4160: aload 26
    //   4162: aload_1
    //   4163: putfield 1457	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:q	Ljava/lang/String;
    //   4166: iload 13
    //   4168: iconst_1
    //   4169: if_icmpne +63 -> 4232
    //   4172: aload 11
    //   4174: aload 28
    //   4176: getfield 1430	tencent/im/oidb/cmd0x857/TroopTips0x857$MessageRecallReminder$MessageMeta:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4179: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4182: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4185: invokevirtual 185	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4188: checkcast 1408	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef
    //   4191: astore 28
    //   4193: aload 26
    //   4195: aload 28
    //   4197: getfield 1460	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef:long_msg_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4200: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4203: putfield 1462	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:i	I
    //   4206: aload 26
    //   4208: aload 28
    //   4210: getfield 1465	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef:long_msg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4213: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4216: putfield 1468	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:j	I
    //   4219: aload 26
    //   4221: aload 28
    //   4223: getfield 1471	tencent/im/msgrevoke/msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef:long_msg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4226: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4229: putfield 1474	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:k	I
    //   4232: aload 27
    //   4234: aload 26
    //   4236: invokevirtual 648	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4239: pop
    //   4240: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4243: ifeq +44 -> 4287
    //   4246: new 23	java/lang/StringBuilder
    //   4249: dup
    //   4250: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   4253: astore 28
    //   4255: aload 28
    //   4257: ldc_w 1476
    //   4260: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4263: pop
    //   4264: aload 28
    //   4266: aload 26
    //   4268: invokevirtual 1477	com/tencent/mobileqq/revokemsg/RevokeMsgInfo:toString	()Ljava/lang/String;
    //   4271: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4274: pop
    //   4275: ldc_w 1479
    //   4278: iconst_2
    //   4279: aload 28
    //   4281: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4284: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4287: goto -266 -> 4021
    //   4290: astore_1
    //   4291: goto +184 -> 4475
    //   4294: aload_0
    //   4295: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4298: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4301: aload 27
    //   4303: iconst_0
    //   4304: invokevirtual 1482	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/util/ArrayList;Z)V
    //   4307: aconst_null
    //   4308: areturn
    //   4309: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4312: ifeq +1248 -> 5560
    //   4315: ldc_w 1479
    //   4318: iconst_2
    //   4319: ldc_w 1484
    //   4322: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4325: goto +1235 -> 5560
    //   4328: aload 27
    //   4330: getfield 1488	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_group_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo;
    //   4333: invokevirtual 1491	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:has	()Z
    //   4336: ifeq +1106 -> 5442
    //   4339: aload 27
    //   4341: getfield 1488	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_group_notify	Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo;
    //   4344: invokevirtual 1492	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4347: checkcast 1490	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo
    //   4350: astore_1
    //   4351: aload_0
    //   4352: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4355: getstatic 1495	com/tencent/mobileqq/app/QQManagerFactory:TROOPINFO_MANAGER	I
    //   4358: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4361: checkcast 1497	com/tencent/mobileqq/model/TroopInfoManager
    //   4364: checkcast 1497	com/tencent/mobileqq/model/TroopInfoManager
    //   4367: lload 23
    //   4369: invokestatic 553	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4372: iconst_1
    //   4373: invokevirtual 1500	com/tencent/mobileqq/model/TroopInfoManager:a	(Ljava/lang/Long;Z)Lcom/tencent/mobileqq/troop/data/TroopFeedsDataManager;
    //   4376: astore_2
    //   4377: aload_2
    //   4378: ifnull +1064 -> 5442
    //   4381: iconst_1
    //   4382: aload_1
    //   4383: getfield 1503	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:opt_uint32_auto_pull_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4386: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4389: if_icmpne +1053 -> 5442
    //   4392: aload_2
    //   4393: aload_1
    //   4394: getfield 1506	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:opt_bytes_feeds_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4397: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4400: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4403: aload_1
    //   4404: getfield 1503	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:opt_uint32_auto_pull_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4407: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4410: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4413: invokevirtual 1511	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:a	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   4416: aload_0
    //   4417: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4420: getstatic 983	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_ONLINE_PUSH_HANDLER	Ljava/lang/String;
    //   4423: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4426: getstatic 1514	com/tencent/mobileqq/troop/onlinepush/api/TroopOnlinePushObserver:TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN	I
    //   4429: iconst_1
    //   4430: iconst_3
    //   4431: anewarray 4	java/lang/Object
    //   4434: dup
    //   4435: iconst_0
    //   4436: lload 23
    //   4438: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4441: aastore
    //   4442: dup
    //   4443: iconst_1
    //   4444: aload_1
    //   4445: getfield 1506	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:opt_bytes_feeds_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4448: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4451: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4454: aastore
    //   4455: dup
    //   4456: iconst_2
    //   4457: aload_1
    //   4458: getfield 1503	tencent/im/oidb/cmd0x857/TroopTips0x857$GroupNotifyInfo:opt_uint32_auto_pull_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4461: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4464: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4467: aastore
    //   4468: invokevirtual 994	com/tencent/mobileqq/app/BusinessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4471: goto +971 -> 5442
    //   4474: astore_1
    //   4475: ldc 88
    //   4477: astore_2
    //   4478: goto +916 -> 5394
    //   4481: ldc 88
    //   4483: astore_2
    //   4484: aload 27
    //   4486: getfield 1518	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_redtips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo;
    //   4489: invokevirtual 1521	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:has	()Z
    //   4492: istore 10
    //   4494: iload 10
    //   4496: ifeq +354 -> 4850
    //   4499: aload 27
    //   4501: getfield 1518	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_redtips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo;
    //   4504: invokevirtual 1522	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4507: checkcast 1520	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo
    //   4510: astore_2
    //   4511: aload_1
    //   4512: getfield 1526	com/tencent/mobileqq/app/QQAppInterface:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4515: invokevirtual 1530	com/tencent/mobileqq/app/automator/Automator:g	()Z
    //   4518: ifeq +23 -> 4541
    //   4521: aload_0
    //   4522: new 1532	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr$RedGrayTips
    //   4525: dup
    //   4526: aload_0
    //   4527: aload 28
    //   4529: getfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   4532: aload_2
    //   4533: invokespecial 1535	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr$RedGrayTips:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopTipsMsgMgr;Ljava/lang/String;Ltencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo;)V
    //   4536: invokevirtual 1538	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopTipsMsgMgr$RedGrayTips;)V
    //   4539: aconst_null
    //   4540: areturn
    //   4541: aload 28
    //   4543: aload_0
    //   4544: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4547: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4550: putfield 664	com/tencent/mobileqq/troop/data/TroopTipsEntity:currentUin	Ljava/lang/String;
    //   4553: sipush -2029
    //   4556: invokestatic 352	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4559: checkcast 1540	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   4562: astore_1
    //   4563: new 23	java/lang/StringBuilder
    //   4566: dup
    //   4567: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   4570: astore 11
    //   4572: aload 11
    //   4574: aload_2
    //   4575: getfield 1543	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4578: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4581: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4584: pop
    //   4585: aload 11
    //   4587: aload 26
    //   4589: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4592: pop
    //   4593: aload_1
    //   4594: aload 11
    //   4596: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4599: putfield 1546	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   4602: new 23	java/lang/StringBuilder
    //   4605: dup
    //   4606: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   4609: astore 11
    //   4611: aload 11
    //   4613: aload_2
    //   4614: getfield 1549	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4617: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4620: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4623: pop
    //   4624: aload 11
    //   4626: aload 26
    //   4628: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4631: pop
    //   4632: aload_1
    //   4633: aload 11
    //   4635: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4638: putfield 1552	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   4641: aload_1
    //   4642: aload_2
    //   4643: getfield 1555	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4646: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4649: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4652: putfield 1558	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   4655: aload_1
    //   4656: aload_2
    //   4657: getfield 1561	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4660: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4663: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4666: putfield 1564	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   4669: aload_1
    //   4670: aload_2
    //   4671: getfield 1567	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4674: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4677: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4680: putfield 1570	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   4683: aload_1
    //   4684: aload_2
    //   4685: getfield 1573	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:uint32_idiom_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4688: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4691: putfield 1576	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   4694: aload_1
    //   4695: aload_2
    //   4696: getfield 1579	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_idiom	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4699: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4702: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4705: putfield 1582	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   4708: aload_1
    //   4709: aload_2
    //   4710: getfield 1586	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:sint32_msgtype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   4713: invokevirtual 1589	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   4716: putfield 1592	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   4719: aload_1
    //   4720: aload_2
    //   4721: getfield 1595	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_broadcast_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4724: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4727: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4730: putfield 1598	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   4733: aload_1
    //   4734: aload_2
    //   4735: getfield 1601	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_idiom_alpha	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4738: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4741: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4744: putfield 1604	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   4747: aload_1
    //   4748: aload_2
    //   4749: getfield 1607	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_jumpurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4752: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4755: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4758: putfield 1609	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   4761: aload_1
    //   4762: aload_2
    //   4763: getfield 1612	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:uint32_subchannel	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4766: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4769: putfield 1615	com/tencent/mobileqq/data/MessageForQQWalletTips:subChannel	I
    //   4772: aload_1
    //   4773: aload_2
    //   4774: getfield 1618	tencent/im/oidb/cmd0x857/TroopTips0x857$RedGrayTipsInfo:bytes_poem_rule	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4777: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4780: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4783: putfield 1621	com/tencent/mobileqq/data/MessageForQQWalletTips:poemRule	Ljava/lang/String;
    //   4786: aload_1
    //   4787: aload_0
    //   4788: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4791: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4794: aload 28
    //   4796: getfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   4799: ldc_w 261
    //   4802: ldc_w 1623
    //   4805: invokestatic 1627	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   4808: sipush -2029
    //   4811: iconst_1
    //   4812: invokestatic 1627	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   4815: invokevirtual 1628	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   4818: aload_1
    //   4819: iconst_1
    //   4820: putfield 1629	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   4823: aload_1
    //   4824: invokevirtual 1630	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   4827: pop
    //   4828: aload_1
    //   4829: invokevirtual 1633	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   4832: aload_0
    //   4833: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4836: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4839: aload_1
    //   4840: aload 28
    //   4842: getfield 664	com/tencent/mobileqq/troop/data/TroopTipsEntity:currentUin	Ljava/lang/String;
    //   4845: invokevirtual 529	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   4848: aconst_null
    //   4849: areturn
    //   4850: aload 28
    //   4852: iconst_1
    //   4853: putfield 661	com/tencent/mobileqq/troop/data/TroopTipsEntity:tipsPromptType	I
    //   4856: aload 28
    //   4858: aload_0
    //   4859: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4862: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4865: putfield 664	com/tencent/mobileqq/troop/data/TroopTipsEntity:currentUin	Ljava/lang/String;
    //   4868: aload 28
    //   4870: aload 27
    //   4872: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4875: getfield 1642	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:opt_bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4878: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4881: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4884: putfield 497	com/tencent/mobileqq/troop/data/TroopTipsEntity:optContent	Ljava/lang/String;
    //   4887: aload 28
    //   4889: aload 27
    //   4891: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4894: getfield 1645	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:opt_uint32_remind	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4897: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4900: putfield 1648	com/tencent/mobileqq/troop/data/TroopTipsEntity:grayTipsRemindFlag	I
    //   4903: aload 27
    //   4905: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4908: getfield 1651	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:opt_bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4911: invokevirtual 886	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4914: istore 10
    //   4916: iload 10
    //   4918: ifeq +22 -> 4940
    //   4921: aload 28
    //   4923: aload 27
    //   4925: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4928: getfield 1651	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:opt_bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4931: invokevirtual 889	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4934: invokevirtual 894	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4937: putfield 1654	com/tencent/mobileqq/troop/data/TroopTipsEntity:grayTipsSummary	Ljava/lang/String;
    //   4940: aload 27
    //   4942: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4945: getfield 1657	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:uint32_robot_group_opt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4948: invokevirtual 856	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4951: istore 10
    //   4953: iload 10
    //   4955: ifeq +15 -> 4970
    //   4958: aload 27
    //   4960: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4963: getfield 1657	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:uint32_robot_group_opt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4966: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4969: pop
    //   4970: aload 28
    //   4972: getfield 497	com/tencent/mobileqq/troop/data/TroopTipsEntity:optContent	Ljava/lang/String;
    //   4975: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4978: ifeq +5 -> 4983
    //   4981: aconst_null
    //   4982: areturn
    //   4983: aload 28
    //   4985: aload 27
    //   4987: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   4990: getfield 1660	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:opt_uint32_show_lastest	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4993: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4996: putfield 667	com/tencent/mobileqq/troop/data/TroopTipsEntity:optShowLatest	I
    //   4999: aload 28
    //   5001: iload 13
    //   5003: putfield 1663	com/tencent/mobileqq/troop/data/TroopTipsEntity:serviceType	I
    //   5006: aload_0
    //   5007: aload 28
    //   5009: invokevirtual 670	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:c	(Lcom/tencent/mobileqq/troop/data/TroopTipsEntity;)V
    //   5012: iload 13
    //   5014: iconst_3
    //   5015: if_icmpne +11 -> 5026
    //   5018: aload_1
    //   5019: aload 28
    //   5021: invokestatic 1668	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/troop/data/TroopTipsEntity;)V
    //   5024: aconst_null
    //   5025: areturn
    //   5026: iload 13
    //   5028: bipush 6
    //   5030: if_icmpne +126 -> 5156
    //   5033: aload 27
    //   5035: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   5038: getfield 1669	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5041: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   5044: ifeq +112 -> 5156
    //   5047: aload 27
    //   5049: getfield 1637	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_msg_graytips	Ltencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo;
    //   5052: getfield 1669	tencent/im/oidb/cmd0x857/TroopTips0x857$AIOGrayTipsInfo:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5055: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5058: lstore 4
    //   5060: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5063: ifeq +37 -> 5100
    //   5066: new 23	java/lang/StringBuilder
    //   5069: dup
    //   5070: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   5073: astore_2
    //   5074: aload_2
    //   5075: ldc_w 1671
    //   5078: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: pop
    //   5082: aload_2
    //   5083: lload 4
    //   5085: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5088: pop
    //   5089: ldc_w 1673
    //   5092: iconst_2
    //   5093: aload_2
    //   5094: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5097: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5100: lload 4
    //   5102: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5105: aload_1
    //   5106: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5109: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5112: ifeq +174 -> 5286
    //   5115: invokestatic 1678	com/tencent/mobileqq/troop/data/TroopRankConfig:a	()Lcom/tencent/mobileqq/troop/data/TroopRankConfig;
    //   5118: lload 23
    //   5120: invokestatic 115	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5123: aload_1
    //   5124: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5127: iconst_1
    //   5128: invokevirtual 1681	com/tencent/mobileqq/troop/data/TroopRankConfig:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   5131: aload_0
    //   5132: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5135: getstatic 1684	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_MEMBER_CARD_HANDLER	Ljava/lang/String;
    //   5138: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5141: checkcast 1686	com/tencent/mobileqq/troop/api/handler/ITroopMemberCardHandler
    //   5144: lload 23
    //   5146: lload 4
    //   5148: invokeinterface 1687 5 0
    //   5153: goto +133 -> 5286
    //   5156: iload 13
    //   5158: bipush 11
    //   5160: if_icmpne +13 -> 5173
    //   5163: aload 28
    //   5165: bipush 10
    //   5167: putfield 1690	com/tencent/mobileqq/troop/data/TroopTipsEntity:repeatInterval	I
    //   5170: goto +116 -> 5286
    //   5173: iload 13
    //   5175: bipush 12
    //   5177: if_icmpne +109 -> 5286
    //   5180: aload 27
    //   5182: getfield 1693	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5185: invokevirtual 749	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   5188: istore 9
    //   5190: iload 9
    //   5192: ifeq +13 -> 5205
    //   5195: aload 27
    //   5197: getfield 1693	tencent/im/oidb/cmd0x857/TroopTips0x857$NotifyMsgBody:opt_uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5200: invokevirtual 484	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5203: lstore 15
    //   5205: aload 28
    //   5207: getfield 497	com/tencent/mobileqq/troop/data/TroopTipsEntity:optContent	Ljava/lang/String;
    //   5210: astore_1
    //   5211: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5214: ifeq +352 -> 5566
    //   5217: new 23	java/lang/StringBuilder
    //   5220: dup
    //   5221: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   5224: astore 11
    //   5226: aload 11
    //   5228: ldc_w 1695
    //   5231: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5234: pop
    //   5235: aload 11
    //   5237: aload_1
    //   5238: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5241: pop
    //   5242: aload 11
    //   5244: ldc_w 1697
    //   5247: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5250: pop
    //   5251: aload 11
    //   5253: lload 15
    //   5255: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5258: pop
    //   5259: aload 11
    //   5261: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5264: astore 11
    //   5266: aload_2
    //   5267: iconst_2
    //   5268: aload 11
    //   5270: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5273: goto +3 -> 5276
    //   5276: lload 23
    //   5278: aload_1
    //   5279: lload 15
    //   5281: invokestatic 1702	com/tencent/mobileqq/troop/utils/TroopUtils:a	(JLjava/lang/String;J)V
    //   5284: aconst_null
    //   5285: areturn
    //   5286: aload_0
    //   5287: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5290: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5293: invokevirtual 757	com/tencent/imcore/message/QQMessageFacade:p	()Lcom/tencent/mobileqq/troop/data/TroopMessageManager;
    //   5296: aload_0
    //   5297: getfield 69	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5300: aload 28
    //   5302: getfield 491	com/tencent/mobileqq/troop/data/TroopTipsEntity:troopUin	Ljava/lang/String;
    //   5305: aload 28
    //   5307: invokevirtual 1705	com/tencent/mobileqq/troop/data/TroopMessageManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/troop/data/TroopTipsEntity;)Lcom/tencent/mobileqq/data/MessageForGrayTips;
    //   5310: astore_2
    //   5311: iload 9
    //   5313: ifne +14 -> 5327
    //   5316: aload_1
    //   5317: aload_2
    //   5318: iconst_0
    //   5319: invokestatic 645	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Z
    //   5322: ifeq +5 -> 5327
    //   5325: aconst_null
    //   5326: areturn
    //   5327: aload_2
    //   5328: ifnull +36 -> 5364
    //   5331: new 23	java/lang/StringBuilder
    //   5334: dup
    //   5335: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   5338: astore_1
    //   5339: aload_1
    //   5340: iload 13
    //   5342: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5345: pop
    //   5346: aload_1
    //   5347: aload 26
    //   5349: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5352: pop
    //   5353: aload_2
    //   5354: ldc_w 1707
    //   5357: aload_1
    //   5358: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5361: invokevirtual 1708	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   5364: aload_2
    //   5365: areturn
    //   5366: astore_1
    //   5367: goto +24 -> 5391
    //   5370: astore_1
    //   5371: goto +20 -> 5391
    //   5374: astore_1
    //   5375: goto +16 -> 5391
    //   5378: astore_1
    //   5379: goto +12 -> 5391
    //   5382: astore_1
    //   5383: goto +8 -> 5391
    //   5386: astore_1
    //   5387: goto +4 -> 5391
    //   5390: astore_1
    //   5391: ldc 88
    //   5393: astore_2
    //   5394: aload_1
    //   5395: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   5398: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5401: ifeq +41 -> 5442
    //   5404: new 23	java/lang/StringBuilder
    //   5407: dup
    //   5408: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   5411: astore 11
    //   5413: aload 11
    //   5415: ldc_w 1710
    //   5418: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: pop
    //   5422: aload 11
    //   5424: aload_1
    //   5425: invokevirtual 1714	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   5428: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5431: pop
    //   5432: aload_2
    //   5433: iconst_2
    //   5434: aload 11
    //   5436: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5439: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5442: aconst_null
    //   5443: areturn
    //   5444: astore_2
    //   5445: goto -2026 -> 3419
    //   5448: astore 11
    //   5450: goto -1703 -> 3747
    //   5453: astore_1
    //   5454: goto +103 -> 5557
    //   5457: astore_1
    //   5458: goto -1464 -> 3994
    //   5461: aload 26
    //   5463: astore_2
    //   5464: goto -4848 -> 616
    //   5467: aload 26
    //   5469: astore 11
    //   5471: goto -4828 -> 643
    //   5474: iconst_m1
    //   5475: istore_3
    //   5476: goto -4416 -> 1060
    //   5479: aload 26
    //   5481: astore_1
    //   5482: goto -4396 -> 1086
    //   5485: aconst_null
    //   5486: astore_2
    //   5487: goto -4286 -> 1201
    //   5490: iconst_0
    //   5491: istore 9
    //   5493: goto -4032 -> 1461
    //   5496: iconst_0
    //   5497: istore 9
    //   5499: goto -3858 -> 1641
    //   5502: goto -3831 -> 1671
    //   5505: iconst_0
    //   5506: istore 9
    //   5508: goto -3577 -> 1931
    //   5511: astore_1
    //   5512: ldc 88
    //   5514: astore_2
    //   5515: goto -121 -> 5394
    //   5518: goto -76 -> 5442
    //   5521: astore_1
    //   5522: goto -2377 -> 3145
    //   5525: astore_1
    //   5526: ldc 88
    //   5528: astore_2
    //   5529: goto -135 -> 5394
    //   5532: astore_1
    //   5533: ldc 88
    //   5535: astore_2
    //   5536: goto -142 -> 5394
    //   5539: aload 26
    //   5541: astore_1
    //   5542: ldc 88
    //   5544: astore_2
    //   5545: iload 10
    //   5547: ifeq -1766 -> 3781
    //   5550: goto -108 -> 5442
    //   5553: astore_1
    //   5554: goto -1079 -> 4475
    //   5557: goto -1248 -> 4309
    //   5560: aconst_null
    //   5561: areturn
    //   5562: astore_1
    //   5563: goto -30 -> 5533
    //   5566: goto -290 -> 5276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5569	0	this	TroopTipsMsgMgr
    //   0	5569	1	paramQQAppInterface	QQAppInterface
    //   0	5569	2	paramArrayOfByte	byte[]
    //   0	5569	3	paramInt1	int
    //   0	5569	4	paramLong1	long
    //   0	5569	6	paramLong2	long
    //   0	5569	8	paramInt2	int
    //   0	5569	9	paramBoolean1	boolean
    //   0	5569	10	paramBoolean2	boolean
    //   0	5569	11	paramParse0x2dcContext	com.tencent.mobileqq.service.message.codec.decoder.MsgType0x2dcDecoder.Parse0x2dcContext
    //   0	5569	12	paramBoolean3	boolean
    //   73	5268	13	i	int
    //   63	342	14	j	int
    //   248	5032	15	l1	long
    //   228	2962	17	l2	long
    //   289	2619	19	l3	long
    //   2414	363	21	l4	long
    //   87	5190	23	l5	long
    //   92	149	25	bool	boolean
    //   13	5527	26	localObject1	Object
    //   24	5172	27	localObject2	Object
    //   277	5029	28	localObject3	Object
    //   2315	268	29	localGeneralGrayTipInfo	tencent.im.oidb.cmd0x857.TroopTips0x857.GeneralGrayTipInfo
    // Exception table:
    //   from	to	target	type
    //   31	46	48	java/lang/Exception
    //   99	186	189	java/lang/Exception
    //   257	262	265	java/lang/Exception
    //   298	341	265	java/lang/Exception
    //   341	348	351	java/lang/Exception
    //   1245	1279	1282	org/json/JSONException
    //   1293	1317	1320	java/lang/UnsatisfiedLinkError
    //   1532	1557	2282	java/lang/Exception
    //   1562	1605	2282	java/lang/Exception
    //   1605	1631	2282	java/lang/Exception
    //   1641	1668	2282	java/lang/Exception
    //   1673	1696	2282	java/lang/Exception
    //   1701	1721	2282	java/lang/Exception
    //   1721	1732	2282	java/lang/Exception
    //   1737	1757	2282	java/lang/Exception
    //   1757	1768	2282	java/lang/Exception
    //   1773	1793	2282	java/lang/Exception
    //   1793	1818	2282	java/lang/Exception
    //   1823	1877	2282	java/lang/Exception
    //   1877	1892	2282	java/lang/Exception
    //   1897	1909	2282	java/lang/Exception
    //   1931	1982	2282	java/lang/Exception
    //   1982	2054	2282	java/lang/Exception
    //   2054	2090	2282	java/lang/Exception
    //   2093	2109	2282	java/lang/Exception
    //   2109	2140	2282	java/lang/Exception
    //   2143	2169	2282	java/lang/Exception
    //   2173	2192	2282	java/lang/Exception
    //   2195	2205	2282	java/lang/Exception
    //   2208	2214	2282	java/lang/Exception
    //   2217	2243	2282	java/lang/Exception
    //   2247	2266	2282	java/lang/Exception
    //   2269	2279	2282	java/lang/Exception
    //   2332	2342	2345	java/lang/Exception
    //   2375	2385	2345	java/lang/Exception
    //   2406	2416	2345	java/lang/Exception
    //   2437	2447	2345	java/lang/Exception
    //   2468	2477	2345	java/lang/Exception
    //   2492	2501	2345	java/lang/Exception
    //   2516	2528	2345	java/lang/Exception
    //   2548	2561	2345	java/lang/Exception
    //   2582	2592	2345	java/lang/Exception
    //   2597	2617	2345	java/lang/Exception
    //   2630	2639	2345	java/lang/Exception
    //   2332	2342	2349	java/io/UnsupportedEncodingException
    //   2375	2385	2349	java/io/UnsupportedEncodingException
    //   2406	2416	2349	java/io/UnsupportedEncodingException
    //   2437	2447	2349	java/io/UnsupportedEncodingException
    //   2468	2477	2349	java/io/UnsupportedEncodingException
    //   2492	2501	2349	java/io/UnsupportedEncodingException
    //   2516	2528	2349	java/io/UnsupportedEncodingException
    //   2548	2561	2349	java/io/UnsupportedEncodingException
    //   2582	2592	2349	java/io/UnsupportedEncodingException
    //   2597	2617	2349	java/io/UnsupportedEncodingException
    //   2630	2639	2349	java/io/UnsupportedEncodingException
    //   2332	2342	2353	java/lang/NullPointerException
    //   2375	2385	2353	java/lang/NullPointerException
    //   2406	2416	2353	java/lang/NullPointerException
    //   2437	2447	2353	java/lang/NullPointerException
    //   2468	2477	2353	java/lang/NullPointerException
    //   2492	2501	2353	java/lang/NullPointerException
    //   2516	2528	2353	java/lang/NullPointerException
    //   2548	2561	2353	java/lang/NullPointerException
    //   2582	2592	2353	java/lang/NullPointerException
    //   2597	2617	2353	java/lang/NullPointerException
    //   2630	2639	2353	java/lang/NullPointerException
    //   2691	2699	2702	java/io/UnsupportedEncodingException
    //   2691	2699	2706	java/lang/NullPointerException
    //   2679	2684	2710	java/io/UnsupportedEncodingException
    //   2679	2684	2714	java/lang/NullPointerException
    //   2820	2832	2835	java/io/UnsupportedEncodingException
    //   2858	2876	2835	java/io/UnsupportedEncodingException
    //   2990	3019	2835	java/io/UnsupportedEncodingException
    //   3034	3040	2835	java/io/UnsupportedEncodingException
    //   2820	2832	2839	java/lang/NullPointerException
    //   2858	2876	2839	java/lang/NullPointerException
    //   2990	3019	2839	java/lang/NullPointerException
    //   3034	3040	2839	java/lang/NullPointerException
    //   3076	3083	3086	java/io/UnsupportedEncodingException
    //   3076	3083	3090	java/lang/NullPointerException
    //   2725	2744	3094	java/io/UnsupportedEncodingException
    //   2748	2815	3094	java/io/UnsupportedEncodingException
    //   2843	2853	3094	java/io/UnsupportedEncodingException
    //   2876	2985	3094	java/io/UnsupportedEncodingException
    //   3019	3029	3094	java/io/UnsupportedEncodingException
    //   3043	3076	3094	java/io/UnsupportedEncodingException
    //   2725	2744	3098	java/lang/NullPointerException
    //   2748	2815	3098	java/lang/NullPointerException
    //   2843	2853	3098	java/lang/NullPointerException
    //   2876	2985	3098	java/lang/NullPointerException
    //   3019	3029	3098	java/lang/NullPointerException
    //   3043	3076	3098	java/lang/NullPointerException
    //   2718	2725	3102	java/io/UnsupportedEncodingException
    //   2718	2725	3106	java/lang/NullPointerException
    //   2653	2674	3110	java/lang/Exception
    //   2679	2684	3110	java/lang/Exception
    //   2691	2699	3110	java/lang/Exception
    //   2718	2725	3110	java/lang/Exception
    //   2653	2674	3117	java/io/UnsupportedEncodingException
    //   2653	2674	3121	java/lang/NullPointerException
    //   2304	2327	3125	java/io/UnsupportedEncodingException
    //   2360	2370	3125	java/io/UnsupportedEncodingException
    //   2391	2401	3125	java/io/UnsupportedEncodingException
    //   2422	2432	3125	java/io/UnsupportedEncodingException
    //   2453	2463	3125	java/io/UnsupportedEncodingException
    //   2477	2487	3125	java/io/UnsupportedEncodingException
    //   2501	2511	3125	java/io/UnsupportedEncodingException
    //   2533	2543	3125	java/io/UnsupportedEncodingException
    //   2567	2577	3125	java/io/UnsupportedEncodingException
    //   2620	2625	3125	java/io/UnsupportedEncodingException
    //   2646	2653	3125	java/io/UnsupportedEncodingException
    //   4034	4166	4290	java/lang/Exception
    //   4172	4232	4290	java/lang/Exception
    //   4232	4287	4290	java/lang/Exception
    //   4294	4307	4474	java/lang/Exception
    //   4309	4325	4474	java/lang/Exception
    //   4328	4377	4474	java/lang/Exception
    //   4381	4471	4474	java/lang/Exception
    //   4499	4539	4474	java/lang/Exception
    //   4541	4848	4474	java/lang/Exception
    //   4921	4940	4474	java/lang/Exception
    //   4958	4970	4474	java/lang/Exception
    //   5018	5024	4474	java/lang/Exception
    //   5033	5100	4474	java/lang/Exception
    //   5100	5153	4474	java/lang/Exception
    //   5163	5170	4474	java/lang/Exception
    //   5195	5205	4474	java/lang/Exception
    //   5266	5273	5366	java/lang/Exception
    //   5276	5284	5366	java/lang/Exception
    //   5286	5311	5366	java/lang/Exception
    //   5316	5325	5366	java/lang/Exception
    //   5331	5364	5366	java/lang/Exception
    //   4484	4494	5370	java/lang/Exception
    //   4850	4916	5370	java/lang/Exception
    //   4940	4953	5370	java/lang/Exception
    //   4970	4981	5370	java/lang/Exception
    //   4983	5012	5370	java/lang/Exception
    //   5180	5190	5370	java/lang/Exception
    //   5205	5266	5370	java/lang/Exception
    //   366	404	5374	java/lang/Exception
    //   357	366	5378	java/lang/Exception
    //   230	240	5382	java/lang/Exception
    //   272	279	5382	java/lang/Exception
    //   284	291	5382	java/lang/Exception
    //   82	94	5386	java/lang/Exception
    //   193	226	5386	java/lang/Exception
    //   15	26	5390	java/lang/Exception
    //   55	82	5390	java/lang/Exception
    //   3377	3416	5444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3728	3744	5448	java/lang/Exception
    //   3899	3932	5453	java/lang/Exception
    //   3938	3952	5457	java/lang/Exception
    //   3952	3991	5457	java/lang/Exception
    //   551	577	5511	java/lang/Exception
    //   577	613	5511	java/lang/Exception
    //   616	640	5511	java/lang/Exception
    //   643	667	5511	java/lang/Exception
    //   667	685	5511	java/lang/Exception
    //   688	697	5511	java/lang/Exception
    //   700	726	5511	java/lang/Exception
    //   726	754	5511	java/lang/Exception
    //   757	772	5511	java/lang/Exception
    //   772	811	5511	java/lang/Exception
    //   814	874	5511	java/lang/Exception
    //   874	935	5511	java/lang/Exception
    //   938	964	5511	java/lang/Exception
    //   964	990	5511	java/lang/Exception
    //   993	1015	5511	java/lang/Exception
    //   1019	1032	5511	java/lang/Exception
    //   1037	1057	5511	java/lang/Exception
    //   1060	1083	5511	java/lang/Exception
    //   1086	1110	5511	java/lang/Exception
    //   1110	1118	5511	java/lang/Exception
    //   1121	1130	5511	java/lang/Exception
    //   1133	1143	5511	java/lang/Exception
    //   1146	1170	5511	java/lang/Exception
    //   1175	1198	5511	java/lang/Exception
    //   1201	1220	5511	java/lang/Exception
    //   1237	1245	5511	java/lang/Exception
    //   1245	1279	5511	java/lang/Exception
    //   1283	1293	5511	java/lang/Exception
    //   1293	1317	5511	java/lang/Exception
    //   1321	1331	5511	java/lang/Exception
    //   1334	1345	5511	java/lang/Exception
    //   1348	1371	5511	java/lang/Exception
    //   1376	1386	5511	java/lang/Exception
    //   1391	1438	5511	java/lang/Exception
    //   1438	1451	5511	java/lang/Exception
    //   1461	1474	5511	java/lang/Exception
    //   1474	1532	5511	java/lang/Exception
    //   2304	2327	5521	java/lang/NullPointerException
    //   2360	2370	5521	java/lang/NullPointerException
    //   2391	2401	5521	java/lang/NullPointerException
    //   2422	2432	5521	java/lang/NullPointerException
    //   2453	2463	5521	java/lang/NullPointerException
    //   2477	2487	5521	java/lang/NullPointerException
    //   2501	2511	5521	java/lang/NullPointerException
    //   2533	2543	5521	java/lang/NullPointerException
    //   2567	2577	5521	java/lang/NullPointerException
    //   2620	2625	5521	java/lang/NullPointerException
    //   2646	2653	5521	java/lang/NullPointerException
    //   2289	2299	5525	java/lang/Exception
    //   2304	2327	5525	java/lang/Exception
    //   2360	2370	5525	java/lang/Exception
    //   2391	2401	5525	java/lang/Exception
    //   2422	2432	5525	java/lang/Exception
    //   2453	2463	5525	java/lang/Exception
    //   2477	2487	5525	java/lang/Exception
    //   2501	2511	5525	java/lang/Exception
    //   2533	2543	5525	java/lang/Exception
    //   2567	2577	5525	java/lang/Exception
    //   2620	2625	5525	java/lang/Exception
    //   2646	2653	5525	java/lang/Exception
    //   2725	2744	5532	java/lang/Exception
    //   2748	2815	5532	java/lang/Exception
    //   2820	2832	5532	java/lang/Exception
    //   2843	2853	5532	java/lang/Exception
    //   2858	2876	5532	java/lang/Exception
    //   2876	2985	5532	java/lang/Exception
    //   2990	3019	5532	java/lang/Exception
    //   3019	3029	5532	java/lang/Exception
    //   3034	3040	5532	java/lang/Exception
    //   3043	3076	5532	java/lang/Exception
    //   3076	3083	5532	java/lang/Exception
    //   3126	3142	5532	java/lang/Exception
    //   3145	3161	5532	java/lang/Exception
    //   3164	3174	5532	java/lang/Exception
    //   3177	3207	5532	java/lang/Exception
    //   3210	3220	5532	java/lang/Exception
    //   3226	3240	5532	java/lang/Exception
    //   3240	3292	5532	java/lang/Exception
    //   3295	3310	5532	java/lang/Exception
    //   3314	3342	5532	java/lang/Exception
    //   3348	3362	5532	java/lang/Exception
    //   3362	3372	5532	java/lang/Exception
    //   3377	3416	5532	java/lang/Exception
    //   3419	3433	5532	java/lang/Exception
    //   3436	3451	5532	java/lang/Exception
    //   3451	3519	5532	java/lang/Exception
    //   3522	3538	5532	java/lang/Exception
    //   3538	3588	5532	java/lang/Exception
    //   3591	3607	5532	java/lang/Exception
    //   3610	3637	5532	java/lang/Exception
    //   3637	3662	5532	java/lang/Exception
    //   3665	3670	5532	java/lang/Exception
    //   3675	3685	5532	java/lang/Exception
    //   3685	3728	5532	java/lang/Exception
    //   3747	3763	5532	java/lang/Exception
    //   3763	3778	5532	java/lang/Exception
    //   3786	3792	5532	java/lang/Exception
    //   3861	3885	5532	java/lang/Exception
    //   3997	4021	5553	java/lang/Exception
    //   4021	4029	5553	java/lang/Exception
    //   3792	3856	5562	java/lang/Exception
    //   3890	3899	5562	java/lang/Exception
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.e.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleWalletTipsCache, size: ");
      ((StringBuilder)localObject).append(this.e.size());
      QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopTipsMsgMgr.RedGrayTips localRedGrayTips = (TroopTipsMsgMgr.RedGrayTips)((Iterator)localObject).next();
      TroopTips0x857.RedGrayTipsInfo localRedGrayTipsInfo = localRedGrayTips.a;
      String str = paramQQAppInterface.getCurrentAccountUin();
      MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localRedGrayTipsInfo.uint64_sender_uin.get());
      localStringBuilder.append("");
      localMessageForQQWalletTips.senderUin = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localRedGrayTipsInfo.uint64_receiver_uin.get());
      localStringBuilder.append("");
      localMessageForQQWalletTips.reciverUin = localStringBuilder.toString();
      localMessageForQQWalletTips.senderContent = localRedGrayTipsInfo.bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = localRedGrayTipsInfo.bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = localRedGrayTipsInfo.bytes_authkey.get().toStringUtf8();
      localMessageForQQWalletTips.idiomSeq = localRedGrayTipsInfo.uint32_idiom_seq.get();
      localMessageForQQWalletTips.idiom = localRedGrayTipsInfo.bytes_idiom.get().toStringUtf8();
      localMessageForQQWalletTips.msgType = localRedGrayTipsInfo.sint32_msgtype.get();
      localMessageForQQWalletTips.richContent = localRedGrayTipsInfo.bytes_broadcast_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.lastPinyin = localRedGrayTipsInfo.bytes_idiom_alpha.get().toStringUtf8();
      localMessageForQQWalletTips.bytes_jumpurl = localRedGrayTipsInfo.bytes_jumpurl.get().toStringUtf8();
      localMessageForQQWalletTips.subChannel = localRedGrayTipsInfo.uint32_subchannel.get();
      localMessageForQQWalletTips.poemRule = localRedGrayTipsInfo.bytes_poem_rule.get().toStringUtf8();
      localMessageForQQWalletTips.init(this.a.getCurrentAccountUin(), localRedGrayTips.b, "", "[QQWallet Tips]", MessageCache.c(), -2029, 1, MessageCache.c());
      localMessageForQQWalletTips.isread = true;
      localMessageForQQWalletTips.getBytes();
      localMessageForQQWalletTips.onReceiveGrapTips();
      paramQQAppInterface.getMessageFacade().a(localMessageForQQWalletTips, str);
    }
    this.e.clear();
  }
  
  public void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "saveTroopTips");
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramTroopTipsEntity.read = false;
    paramTroopTipsEntity.currentUin = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramTroopTipsEntity.troopUin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTroopTipsEntity.msgSeq);
    localStringBuilder.append("");
    a(paramQQAppInterface, localStringBuilder.toString());
    localEntityManager.persist(paramTroopTipsEntity);
    localEntityManager.close();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return;
      }
      List localList = b(paramString);
      if (localList != null)
      {
        if (localList.size() == 0) {
          return;
        }
        Object localObject1 = new SparseIntArray();
        int i = localList.size() - 1;
        Object localObject2;
        while (i >= 0)
        {
          localObject2 = (TroopTipsEntity)localList.get(i);
          if ((((TroopTipsEntity)localObject2).repeatInterval > 0) && (((SparseIntArray)localObject1).get(((TroopTipsEntity)localObject2).serviceType, 0) > 0))
          {
            String str = ((TroopTipsEntity)localObject2).troopUin;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((TroopTipsEntity)localObject2).msgSeq);
            localStringBuilder.append("");
            b(str, localStringBuilder.toString());
            localList.remove(localObject2);
          }
          else
          {
            ((SparseIntArray)localObject1).put(((TroopTipsEntity)localObject2).serviceType, ((SparseIntArray)localObject1).get(((TroopTipsEntity)localObject2).serviceType, 0) + 1);
          }
          i -= 1;
        }
        if (localList.size() > 0)
        {
          paramQQAppInterface = paramQQAppInterface.getMessageProxy(1).c(paramString, 1);
          if (paramQQAppInterface == null) {
            i = 0;
          } else {
            i = paramQQAppInterface.size();
          }
          int j = localList.size() - 1;
          while ((j >= 0) && (i > 0))
          {
            paramString = (TroopTipsEntity)localList.get(j);
            if (paramString.repeatInterval > 0)
            {
              int k;
              if (paramString.repeatInterval < i) {
                k = paramString.repeatInterval;
              } else {
                k = paramQQAppInterface.size();
              }
              int m = 0;
              while (m < k)
              {
                localObject1 = (MessageRecord)paramQQAppInterface.get(i - k + m);
                if ((((MessageRecord)localObject1).msgtype == 2024) && (String.valueOf(paramString.serviceType).equals(((MessageRecord)localObject1).getExtInfoFromExtStr("gray_tips_serviceType"))))
                {
                  localObject1 = paramString.troopUin;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(paramString.msgSeq);
                  ((StringBuilder)localObject2).append("");
                  b((String)localObject1, ((StringBuilder)localObject2).toString());
                  localList.remove(j);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("TroopTipsMsgMgr", 2, String.format("addGrayTipsIntoMessageListIfNeeded discard seq:%s interval:%d", new Object[] { Long.valueOf(paramString.msgSeq), Integer.valueOf(paramString.repeatInterval) }));
                  break;
                }
                m += 1;
              }
            }
            j -= 1;
          }
        }
        paramQQAppInterface = localList.iterator();
        while (paramQQAppInterface.hasNext()) {
          a((TroopTipsEntity)paramQQAppInterface.next());
        }
      }
    }
  }
  
  public void a(TroopTipsMsgMgr.RedGrayTips paramRedGrayTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "addWalletTipsCache");
    }
    this.e.add(paramRedGrayTips);
  }
  
  public boolean a(String paramString)
  {
    return c.isEmpty() ^ true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = ((StringBuilder)localObject).toString();
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((String)((Iterator)localObject).next()).equals(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tipsMsgFilterBySeq, flag in queue equals uniFlag:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    if (this.d.size() > 30) {
      this.d.poll();
    }
    this.d.offer(paramString);
    return false;
  }
  
  public MessageForGrayTips b(TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeTroopTipsEntity2GrayTips,entity:");
      ((StringBuilder)localObject).append(paramTroopTipsEntity.toString());
      QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    if (paramTroopTipsEntity.grayTipsRemindFlag != 0) {
      i = -2042;
    } else {
      i = 2024;
    }
    Object localObject = (MessageForGrayTips)MessageRecordFactory.a(2024);
    ((MessageForGrayTips)localObject).frienduin = paramTroopTipsEntity.troopUin;
    ((MessageForGrayTips)localObject).init(this.a.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, i, paramTroopTipsEntity.uinType, paramTroopTipsEntity.msgSeq);
    if (paramTroopTipsEntity.highlightNum != 0) {
      a((MessageForGrayTips)localObject, paramTroopTipsEntity.highlightItems);
    }
    if (paramTroopTipsEntity.optShowLatest == 1) {
      ((MessageForGrayTips)localObject).shmsgseq = 0L;
    }
    ((MessageForGrayTips)localObject).isread = true;
    ((MessageForGrayTips)localObject).saveExtInfoToExtStr("gray_tips_serviceType", String.valueOf(paramTroopTipsEntity.serviceType));
    return localObject;
  }
  
  public List<TroopTipsEntity> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = this.a.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    paramString = ((EntityManager)localObject).query(TroopTipsEntity.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.a.getCurrentAccountUin() }, null, null, "time ASC", null);
    ((EntityManager)localObject).close();
    if (paramString == null) {
      return null;
    }
    while (i < paramString.size())
    {
      localObject = (TroopTipsEntity)paramString.get(i);
      if ((((TroopTipsEntity)localObject).expireTime == 0L) || (NetConnInfoCenter.getServerTime() < ((TroopTipsEntity)localObject).expireTime)) {
        if (((TroopTipsEntity)localObject).optShowLatest == 1) {
          localArrayList2.add(localObject);
        } else {
          localArrayList1.add(localObject);
        }
      }
      i += 1;
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  /* Error */
  public void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +12 -> 20
    //   11: ldc 88
    //   13: iconst_2
    //   14: ldc_w 1814
    //   17: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: getstatic 54	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:c	Ljava/util/HashMap;
    //   23: invokevirtual 1815	java/util/HashMap:clear	()V
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   30: invokevirtual 604	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 6
    //   35: aload 6
    //   37: iconst_1
    //   38: ldc_w 488
    //   41: invokevirtual 617	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   44: iconst_1
    //   45: anewarray 111	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 1816
    //   53: aastore
    //   54: ldc_w 1818
    //   57: iconst_1
    //   58: anewarray 111	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: iconst_0
    //   64: invokestatic 475	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: aastore
    //   68: ldc_w 1816
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: invokevirtual 1821	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +144 -> 225
    //   84: aload 5
    //   86: invokeinterface 1826 1 0
    //   91: ifeq +88 -> 179
    //   94: aload 5
    //   96: ldc_w 1816
    //   99: invokeinterface 1829 2 0
    //   104: istore_2
    //   105: aconst_null
    //   106: astore 4
    //   108: iload_2
    //   109: iconst_m1
    //   110: if_icmpeq +121 -> 231
    //   113: aload 5
    //   115: iload_2
    //   116: invokeinterface 1831 2 0
    //   121: astore_1
    //   122: goto +3 -> 125
    //   125: aload 5
    //   127: ldc_w 1832
    //   130: invokeinterface 1829 2 0
    //   135: istore_2
    //   136: iload_2
    //   137: iconst_m1
    //   138: if_icmpeq +13 -> 151
    //   141: aload 5
    //   143: iload_2
    //   144: invokeinterface 1831 2 0
    //   149: astore 4
    //   151: aload_1
    //   152: ifnull +15 -> 167
    //   155: aload 4
    //   157: ifnull +10 -> 167
    //   160: aload_0
    //   161: aload_1
    //   162: aload 4
    //   164: invokespecial 1730	com/tencent/mobileqq/troop/utils/TroopTipsMsgMgr:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 5
    //   169: invokeinterface 1835 1 0
    //   174: istore_3
    //   175: iload_3
    //   176: ifne -82 -> 94
    //   179: aload 5
    //   181: invokeinterface 1836 1 0
    //   186: goto +39 -> 225
    //   189: astore_1
    //   190: goto +26 -> 216
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   198: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq -22 -> 179
    //   204: ldc 88
    //   206: iconst_2
    //   207: ldc_w 1838
    //   210: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -34 -> 179
    //   216: aload 5
    //   218: invokeinterface 1836 1 0
    //   223: aload_1
    //   224: athrow
    //   225: aload 6
    //   227: invokevirtual 628	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   230: return
    //   231: aconst_null
    //   232: astore_1
    //   233: goto -108 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	TroopTipsMsgMgr
    //   0	236	1	paramQQAppInterface	QQAppInterface
    //   104	40	2	i	int
    //   174	2	3	bool	boolean
    //   106	57	4	str	String
    //   77	140	5	localCursor	android.database.Cursor
    //   33	193	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   84	94	189	finally
    //   94	105	189	finally
    //   113	122	189	finally
    //   125	136	189	finally
    //   141	151	189	finally
    //   160	167	189	finally
    //   167	175	189	finally
    //   194	213	189	finally
    //   84	94	193	java/lang/Exception
    //   94	105	193	java/lang/Exception
    //   113	122	193	java/lang/Exception
    //   125	136	193	java/lang/Exception
    //   141	151	193	java/lang/Exception
    //   160	167	193	java/lang/Exception
    //   167	175	193	java/lang/Exception
  }
  
  public void c(TroopTipsEntity paramTroopTipsEntity)
  {
    Object localObject10 = "alt";
    String str2 = "text";
    String str1 = "uin";
    Object localObject8 = "icon";
    localObject6 = "url";
    if ((paramTroopTipsEntity != null) && (paramTroopTipsEntity.optContent != null))
    {
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramTroopTipsEntity.optContent);
      int i = 0;
      paramTroopTipsEntity.highlightNum = 0;
      localObject7 = new JSONArray();
      Object localObject1 = "";
      int j = 0;
      while (localMatcher.find())
      {
        j += 1;
        paramTroopTipsEntity.highlightNum = j;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("match count=====>");
          ((StringBuilder)localObject4).append(j);
          QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject4).toString());
        }
        Object localObject9 = localObject7;
        int m = localMatcher.start();
        int k = localMatcher.end();
        localObject4 = paramTroopTipsEntity.optContent.substring(m + 1, k);
        localObject7 = paramTroopTipsEntity.optContent.substring(i, m);
        Object localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append((String)localObject1);
        ((StringBuilder)localObject11).append((String)localObject7);
        localObject7 = ((StringBuilder)localObject11).toString();
        m = ((String)localObject7).length();
        i = k + 1;
        try
        {
          localStringBuilder = new StringBuilder();
          localJSONObject = new JSONObject((String)localObject4);
          localJSONObject.put("startIndex", m);
          bool = localJSONObject.has(str1);
          if (!bool) {}
        }
        catch (JSONException localJSONException1)
        {
          StringBuilder localStringBuilder;
          JSONObject localJSONObject;
          boolean bool;
          label552:
          label635:
          break label1294;
        }
        try
        {
          localObject1 = localJSONObject.get(str1).toString();
          localObject4 = localObject7;
        }
        catch (JSONException localJSONException2) {}
        try
        {
          localObject11 = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramTroopTipsEntity.troopUin, (String)localObject1);
          localObject1 = localObject7;
          if (localObject11 != null)
          {
            localObject4 = localObject7;
            localObject1 = new StringBuilder();
            localObject4 = localObject7;
            ((StringBuilder)localObject1).append((String)localObject7);
            localObject4 = localObject7;
            ((StringBuilder)localObject1).append((String)localObject11);
            localObject4 = localObject7;
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject4 = localObject1;
            localJSONObject.put("endIndex", ((String)localObject11).length() + m);
          }
          localObject4 = localObject1;
          localStringBuilder.append("text==>");
          localObject4 = localObject1;
          localStringBuilder.append((String)localObject11);
          break label552;
          localObject1 = localObject7;
          localObject4 = localObject7;
          if (localJSONObject.has(str2))
          {
            localObject4 = localObject7;
            localObject11 = localJSONObject.get(str2).toString();
            localObject1 = localObject7;
            if (localObject11 != null)
            {
              localObject4 = localObject7;
              localObject1 = new StringBuilder();
              localObject4 = localObject7;
              ((StringBuilder)localObject1).append((String)localObject7);
              localObject4 = localObject7;
              ((StringBuilder)localObject1).append((String)localObject11);
              localObject4 = localObject7;
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject4 = localObject1;
              localJSONObject.put("endIndex", ((String)localObject11).length() + m);
            }
            localObject4 = localObject1;
            localStringBuilder.append("text==>");
            localObject4 = localObject1;
            localStringBuilder.append((String)localObject11);
          }
          localObject7 = localObject6;
          localObject4 = localObject1;
          bool = localJSONObject.has("cmd");
          if (bool) {
            localObject4 = localObject1;
          }
        }
        catch (JSONException localJSONException3)
        {
          localObject2 = localObject4;
          localObject4 = localObject6;
          break label1291;
        }
        try
        {
          k = Integer.parseInt(localJSONObject.get("cmd").toString());
          localObject4 = localObject1;
          localJSONObject.put("cmd", k);
          localObject4 = localObject1;
          localStringBuilder.append(",cmd==>");
          localObject4 = localObject1;
          localStringBuilder.append(k);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label635;
        }
        localObject4 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject4 = localObject1;
          QLog.e("TroopTipsMsgMgr", 2, "decodeContent==>NumberFormatException");
        }
        localObject4 = localObject1;
        if (localJSONObject.has("textColor"))
        {
          localObject4 = localObject1;
          localObject11 = localJSONObject.getString("textColor");
          localObject4 = localObject1;
          localJSONObject.put("textColor", localObject11);
          localObject4 = localObject1;
          localStringBuilder.append(",textColor==>");
          localObject4 = localObject1;
          localStringBuilder.append((String)localObject11);
        }
        localObject4 = localObject1;
        if (localJSONObject.has("data"))
        {
          localObject4 = localObject1;
          localObject11 = localJSONObject.get("data").toString();
          localObject4 = localObject1;
          localJSONObject.put("data", localObject11);
          localObject4 = localObject1;
          localStringBuilder.append(",data==>");
          localObject4 = localObject1;
          localStringBuilder.append((String)localObject11);
        }
        localObject4 = localObject1;
        if (localJSONObject.has("data_a"))
        {
          localObject4 = localObject1;
          localObject11 = localJSONObject.get("data_a").toString();
          localObject4 = localObject1;
          localJSONObject.put("data_a", localObject11);
          localObject4 = localObject1;
          localStringBuilder.append(",data_a==>");
          localObject4 = localObject1;
          localStringBuilder.append((String)localObject11);
        }
        try
        {
          if (localJSONObject.has((String)localObject7))
          {
            localObject4 = localJSONObject.get((String)localObject7).toString();
            localJSONObject.put((String)localObject7, localObject4);
            localStringBuilder.append(",url:");
            localStringBuilder.append((String)localObject4);
          }
          localObject12 = localObject8;
        }
        catch (JSONException localJSONException5)
        {
          Object localObject12;
          Object localObject13;
          Object localObject14;
          label1270:
          label1273:
          Object localObject2;
          break label1287;
        }
        try
        {
          if (localJSONObject.has(localObject12))
          {
            localObject4 = localJSONObject.get(localObject12).toString();
            localJSONObject.put(localObject12, localObject4);
            localStringBuilder.append(",icon:");
            localStringBuilder.append((String)localObject4);
          }
          localObject13 = localObject10;
        }
        catch (JSONException localJSONException6)
        {
          break label1280;
        }
        try
        {
          if (localJSONObject.has(localObject13))
          {
            localObject11 = localJSONObject.get(localObject13).toString();
            if (localObject11 == null) {}
          }
        }
        catch (JSONException localJSONException7)
        {
          break label1273;
        }
        try
        {
          localObject14 = new StringBuilder();
          localObject4 = localObject7;
          localObject6 = localObject1;
        }
        catch (JSONException localJSONException8)
        {
          break label1273;
        }
        try
        {
          ((StringBuilder)localObject14).append("[");
          localObject6 = localObject1;
          ((StringBuilder)localObject14).append((String)localObject11);
          localObject6 = localObject1;
          ((StringBuilder)localObject14).append("]");
          localObject6 = localObject1;
          localObject14 = ((StringBuilder)localObject14).toString();
          localObject6 = localObject1;
          localObject11 = new StringBuilder();
          localObject6 = localObject1;
          ((StringBuilder)localObject11).append((String)localObject1);
          localObject6 = localObject1;
          ((StringBuilder)localObject11).append((String)localObject14);
          localObject6 = localObject1;
          localObject11 = ((StringBuilder)localObject11).toString();
          localObject6 = localObject11;
          localJSONObject.put("endIndex", m + ((String)localObject14).length());
          localObject6 = localObject11;
          localStringBuilder.append(",alt:");
          localObject6 = localObject11;
          localStringBuilder.append((String)localObject14);
          localObject6 = localObject11;
          bool = paramTroopTipsEntity.isSupportImage;
          localObject1 = localObject11;
          if (!bool)
          {
            localObject1 = localObject11;
            localObject8 = localObject12;
            localObject10 = localObject13;
            localObject7 = localObject9;
          }
        }
        catch (JSONException localJSONException4)
        {
          localObject3 = localObject6;
          break label1302;
        }
        try
        {
          localObject9.put(localJSONObject);
          localObject6 = localObject1;
          localObject4 = localObject7;
          if (!QLog.isColorLevel()) {
            break label1337;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("decodeContent==>");
          ((StringBuilder)localObject4).append(localStringBuilder.toString());
          QLog.d("TroopTipsMsgMgr", 2, ((StringBuilder)localObject4).toString());
          localObject6 = localObject1;
          localObject4 = localObject7;
        }
        catch (JSONException localJSONException9)
        {
          break label1270;
          Object localObject5 = localObject6;
          localObject3 = localObject7;
          break label1291;
        }
        break label1306;
        localObject4 = localObject7;
        break label1302;
        label1280:
        localObject4 = localObject7;
        break label1291;
        label1287:
        localObject4 = localObject7;
        label1291:
        break label1302;
        label1294:
        localObject4 = localObject6;
        localObject1 = localObject7;
        label1302:
        localObject7 = localObject4;
        label1306:
        localObject6 = localObject1;
        localObject4 = localObject7;
        if (QLog.isColorLevel())
        {
          QLog.e("TroopTipsMsgMgr", 2, "decodeContent:JSONException");
          localObject4 = localObject7;
          localObject6 = localObject1;
        }
        label1337:
        localObject1 = localObject6;
        localObject7 = localObject9;
        localObject6 = localObject4;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(paramTroopTipsEntity.optContent.substring(i, paramTroopTipsEntity.optContent.length()));
      paramTroopTipsEntity.optContent = ((StringBuilder)localObject4).toString();
      if (paramTroopTipsEntity.highlightNum != 0) {
        paramTroopTipsEntity.highlightItems = ((JSONArray)localObject7).toString();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopTipsMsgMgr", 2, "decodeContent ===> entity == null || content == null");
      }
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr
 * JD-Core Version:    0.7.0.1
 */