package com.tencent.mobileqq.stt;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttShardRsp;

public class SttManager
  implements Handler.Callback, Manager, BusinessObserver
{
  protected Handler a;
  public ISttListener a;
  private ConcurrentHashMap<Long, SttTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<Long> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public AppRuntime a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  protected Handler b;
  
  public SttManager() {}
  
  public SttManager(AppRuntime paramAppRuntime)
  {
    this();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.sttAbility = 3;
      paramMessageForPtt.sttText = "";
      paramMessageForPtt.isReadPtt = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_succ_flag", "0");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("");
      localHashMap.put("param_version", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("_");
      localStringBuilder.append(Build.MODEL);
      localHashMap.put("param_deviceName", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localHashMap.put("param_resultCode", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", false, 0L, 0L, localHashMap, null);
      try
      {
        paramMessageForPtt.serial();
        ((IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
      catch (Exception paramMessageForPtt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "updatedb", paramMessageForPtt);
        }
      }
    }
  }
  
  private Long b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    SttTask localSttTask = SttTask.a(paramMessageForPtt, this.jdField_a_of_type_MqqAppAppRuntime, paramInt);
    localSttTask.a(this.jdField_a_of_type_AndroidOsHandler);
    Long localLong = localSttTask.b();
    if (localLong != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, localSttTask);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(Long.valueOf(paramMessageForPtt.uniseq));
    }
    return localLong;
  }
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    a();
    if (paramMessageForPtt.istroop == 0)
    {
      if (StringUtil.a(paramMessageForPtt.urlAtServer))
      {
        QLog.e("", 1, new Object[] { "stt err, c2c no fileID ", paramMessageForPtt });
        paramMessageForPtt.getSttResult().a(1, 2003);
        this.b.post(new SttManager.1(this, paramMessageForPtt));
        return Long.valueOf(paramMessageForPtt.uniseq);
      }
    }
    else if (StringUtil.a(paramMessageForPtt.md5))
    {
      QLog.e("", 1, new Object[] { "stt err, troop no md5 ", paramMessageForPtt });
      paramMessageForPtt.getSttResult().a(1, 2004);
      this.b.post(new SttManager.2(this, paramMessageForPtt));
      return Long.valueOf(paramMessageForPtt.uniseq);
    }
    Object localObject1 = QVipAutoPttProcessor.c();
    boolean bool = QVipConfigManager.a(this.jdField_a_of_type_MqqAppAppRuntime, "have_add_ptt_svip_gray_msg", false);
    Object localObject2;
    if ((((QVipAutoPttConfig)localObject1).a == 2) && (!bool) && (VasUtil.a(this.jdField_a_of_type_MqqAppAppRuntime).getVipStatus().isSVip()) && (PttConstants.c))
    {
      localObject1 = new UniteGrayTipParam(paramMessageForPtt.frienduin, paramMessageForPtt.selfuin, HardCodeUtil.a(2131714420), paramMessageForPtt.istroop, -5020, 655392, paramMessageForPtt.time);
      localObject2 = new MessageForUniteGrayTip();
      if (paramMessageForPtt.istroop == 1) {
        ((MessageForUniteGrayTip)localObject2).shmsgseq = paramMessageForPtt.shmsgseq;
      }
      ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_MqqAppAppRuntime, (UniteGrayTipParam)localObject1);
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageForUniteGrayTip)localObject2);
      QVipConfigManager.b(this.jdField_a_of_type_MqqAppAppRuntime, "have_add_ptt_svip_gray_msg", true);
      QLog.e("Q.stt", 1, "stage2 first translate It is need add gray msg and insert success");
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stage2 first translate It is need add gray msg and insert falied:conf.stage == ");
      ((StringBuilder)localObject2).append(((QVipAutoPttConfig)localObject1).a);
      ((StringBuilder)localObject2).append(" && ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("Q.stt", 1, ((StringBuilder)localObject2).toString());
    }
    return b(paramMessageForPtt, paramInt);
  }
  
  public void a(ISttListener paramISttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSttISttListener = paramISttListener;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SttResultPush.MsgBody();
    try
    {
      ((SttResultPush.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = Long.valueOf(0L);
      if (((SttResultPush.MsgBody)localObject).msg_ptt_shard_resp.has()) {
        paramArrayOfByte = Long.valueOf(((SttResultPush.MsgBody)localObject).msg_ptt_shard_resp.uint64_sessionid.get());
      } else if (((SttResultPush.MsgBody)localObject).msg_ptt_resp.has()) {
        paramArrayOfByte = Long.valueOf(((SttResultPush.MsgBody)localObject).msg_ptt_resp.uint64_sessionid.get());
      }
      SttTask localSttTask = (SttTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramArrayOfByte);
      if (localSttTask == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onSttResultPush task not find: session = ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.e("Q.stt", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      boolean bool = localSttTask.a((SttResultPush.MsgBody)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSttResultPush task doReceivePushData session = ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        ((StringBuilder)localObject).append(" | result = ");
        ((StringBuilder)localObject).append(bool);
        QLog.e("Q.stt", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(Long.valueOf(paramMessageForPtt.uniseq));
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.autoToText >= 1) && (!a(paramMessageForPtt)) && (paramMessageForPtt.sttAbility != 2)) {
      return true;
    }
    ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).initAutoToTextSwitch(this.jdField_a_of_type_MqqAppAppRuntime);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needAuotoChange AutoChangeFlag=");
      localStringBuilder.append(PttConstants.c);
      localStringBuilder.append(" AutoChangeSetTime=");
      localStringBuilder.append(PttConstants.a);
      localStringBuilder.append(" isTranslating=");
      localStringBuilder.append(a(paramMessageForPtt));
      localStringBuilder.append("msgPtt.msgTime=");
      localStringBuilder.append(paramMessageForPtt.msgTime);
      localStringBuilder.append(" msgPtt.time=");
      localStringBuilder.append(paramMessageForPtt.time);
      localStringBuilder.append(" msgPtt.sttAbility=");
      localStringBuilder.append(paramMessageForPtt.sttAbility);
      localStringBuilder.append(" isRedPackPTT=");
      localStringBuilder.append(((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt));
      QLog.d("Q.stt", 2, localStringBuilder.toString());
    }
    return (!a(paramMessageForPtt)) && (!((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt)) && (PttConstants.c) && ((PttConstants.a < paramMessageForPtt.msgTime) || (PttConstants.a < paramMessageForPtt.time)) && (paramMessageForPtt.voiceChangeFlag != 1) && ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    int i = paramMessage.what;
    Object localObject2;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label506;
        }
        if (i != 4)
        {
          if ((i != 1001) && (i != 1002))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleMessage unknown msg = ");
            ((StringBuilder)localObject1).append(paramMessage.what);
            QLog.e("Q.stt", 1, ((StringBuilder)localObject1).toString());
            return true;
          }
          localObject1 = (SttTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleMessage STT_MSG_STT_RSP_ERROR get sttTask is null = ");
              ((StringBuilder)localObject1).append(paramMessage.what);
              QLog.e("Q.stt", 2, ((StringBuilder)localObject1).toString());
            }
            return true;
          }
          paramMessage = ((SttTask)localObject1).a();
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(paramMessage.uniseq));
          this.b.post(new SttManager.3(this, paramMessage));
          return true;
        }
      }
      localObject2 = (SttTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleMessage STT_MSG_TASK_STT_UPDATE get sttTask is null = ");
          ((StringBuilder)localObject1).append(paramMessage.what);
          QLog.e("Q.stt", 2, ((StringBuilder)localObject1).toString());
        }
        return true;
      }
      localObject1 = ((SttTask)localObject2).a();
      if (((SttTask)localObject2).a() == 3)
      {
        ((MessageForPtt)localObject1).sttText = ((MessageForPtt)localObject1).getSttResult().a();
        ((MessageForPtt)localObject1).sttAbility = 2;
        ((MessageForPtt)localObject1).isReadPtt = true;
        ((MessageForPtt)localObject1).serial();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(((MessageForPtt)localObject1).uniseq));
        this.b.post(new SttManager.4(this, (MessageForPtt)localObject1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "PttSttReport PTT_STT_RESULT_MONITOR success");
        }
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("resultCode", "0");
        ((HashMap)localObject2).put("subCode", "0");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultMonitor", true, 0L, 0L, (HashMap)localObject2, null);
      }
      if (!((MessageForPtt)localObject1).getSttResult().a()) {
        break label786;
      }
      boolean bool;
      if (paramMessage.what == 4) {
        bool = true;
      } else {
        bool = false;
      }
      if ((bool) && (!((MessageForPtt)localObject1).isReadPtt))
      {
        ((MessageForPtt)localObject1).isReadPtt = true;
        ((MessageForPtt)localObject1).serial();
      }
      this.b.post(new SttManager.5(this, (MessageForPtt)localObject1, bool));
      return true;
    }
    label506:
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleMessage TIME OUT task not key = ");
        ((StringBuilder)localObject1).append(paramMessage.what);
        ((StringBuilder)localObject1).append("  | session = ");
        ((StringBuilder)localObject1).append(l);
        QLog.e("Q.stt", 2, ((StringBuilder)localObject1).toString());
      }
      return true;
    }
    Object localObject1 = (SttTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleMessage TIME OUT key = ");
      ((StringBuilder)localObject2).append(paramMessage.what);
      ((StringBuilder)localObject2).append("  | session = ");
      ((StringBuilder)localObject2).append(l);
      QLog.e("Q.stt", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (((SttTask)localObject1).a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(((SttTask)localObject1).a().uniseq));
      i = 2002;
      if (paramMessage.what == 3) {
        i = 2006;
      }
      paramMessage = ((SttTask)localObject1).a(i);
      if (paramMessage != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMessage, localObject1);
        this.b.post(new SttManager.6(this, (SttTask)localObject1));
        return true;
      }
      paramMessage = ((SttTask)localObject1).a();
      a(paramMessage, paramMessage.getSttResult().c());
      this.b.post(new SttManager.7(this, (SttTask)localObject1));
    }
    label786:
    return true;
  }
  
  public void onDestroy()
  {
    ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).resetSttAbility();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqSttISttListener = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
      return;
    }
    Long localLong = Long.valueOf(paramBundle.getLong("k_session", 0L));
    SttTask localSttTask = (SttTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localLong);
    if (localSttTask == null)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mSttTaskList get by session is null , session = ");
        paramBundle.append(localLong);
        QLog.e("Q.stt", 2, paramBundle.toString());
      }
      return;
    }
    paramBoolean = localSttTask.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onReceive result is ");
      paramBundle.append(paramBoolean);
      QLog.d("Q.stt", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager
 * JD-Core Version:    0.7.0.1
 */