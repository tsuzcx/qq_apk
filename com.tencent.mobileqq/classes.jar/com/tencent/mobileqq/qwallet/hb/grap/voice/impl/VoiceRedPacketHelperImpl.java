package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IChatActivityFacadeTemp;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.raw;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class VoiceRedPacketHelperImpl
  implements IQQRecorder.OnQQRecorderListener, IQQRecorder.RecorderProcessorListener, IVoiceRedPacketHelper
{
  public static final int AUDIO_PANEL_CHANGE_VOICE = 3;
  public static final int AUDIO_PANEL_INPUT = 4;
  public static final int AUDIO_PANEL_PRESS_TO_SPEAK = 1;
  public static final int AUDIO_PANEL_RECORDER = 2;
  public static final int AUDIO_PANEL_RED_PACKET = 5;
  public static final int AUDIO_PANEL_UNKNOWN = 0;
  public static final int ERROR_NEED_TIPS = 2;
  public static final int ERROR_NOT_NEED_TIPS = 1;
  public static final int ERROR_NO_PERMISSION = 3;
  private static final int FLAG_RED_PACKET_KSONG = 3;
  private static final int FLAG_SEND_MSG_DELAY = 2;
  private static final int FLAG_SEND_MSG_IM = 1;
  private static final int FLAG_SEND_MSG_NONE = 0;
  public static final int FLAG_VOICE_RED_PACKET = 1;
  public static final String KEY_KSONG_FEEDS_ID = "ksong_feeds_id";
  public static final String KEY_KSONG_VOICE_TYPE = "ksong_redpacket_voice_type";
  public static final String KEY_SCORE_ID_MAP = "scoreIdMap";
  public static final int KSONG_RED_VOICE_TYPE_MIX = 2;
  public static final int KSONG_RED_VOICE_TYPE_NONE = 0;
  public static final int KSONG_RED_VOICE_TYPE_RECORD = 1;
  private static final long MIN_RECORD_TIME = 500L;
  public static final int RECOG_HAS_NO_OFFLINE_LIB = 0;
  public static final int RECOG_HAS_OFFLINE_LIB = 1;
  public static final int RECOG_RES_BUSY = 2;
  public static final int RECOG_RES_FAIL = 0;
  public static final int RECOG_RES_OTHER = 3;
  public static final int RECOG_RES_SUCC = 1;
  public static final int RECOG_TYPE_OFFLINE = 0;
  public static final int RECOG_TYPE_ONLINE = 1;
  private static final String TAG = "VoiceRedPacketHelperImpl";
  public static final int UPLOAD_TYPE_MIX = 0;
  public static final int UPLOAD_TYPE_MIX_AND_RECORD = 1;
  private static VoiceRedPacketHelperImpl sInstance;
  ByteArrayOutputStream byteArrayOutputStream;
  int clientTryTime;
  byte[] fileBytes;
  int identify;
  boolean isCancel;
  boolean isCheckInPhone;
  boolean isInitSuccess;
  private String mAccompanyPath = "";
  private final IChatActivityFacadeTemp mChatActivityFacadeTemp = ((IQwTemp)QRoute.api(IQwTemp.class)).newIChatActivityFacadeTemp();
  int mIsHeadSetOn = -1;
  boolean mIsSaveRecordPCMData;
  Map<MessageForPtt, VoiceRedPacketHelperImpl.RecordMsgInfo> mix2RecordMap = new HashMap();
  public WeakReference<VoiceRedPacketHelperImpl.OnVoiceRedPacketListener> onVoiceRedPacketListenerRef = new WeakReference(null);
  IQQRecorder recorder;
  HashMap<MessageForPtt, MessageForQQWalletMsg> redPacketCacheMap = new HashMap();
  int serverTryTime;
  BaseSessionInfo sessionInfo;
  
  private VoiceRedPacketHelperImpl.RecogResult checkInPhone(byte[] paramArrayOfByte, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private VoiceRedPacketHelperImpl.RecogResult checkInPhoneInner(byte[] paramArrayOfByte)
  {
    VoiceRedPacketHelperImpl.RecogResult localRecogResult = new VoiceRedPacketHelperImpl.RecogResult();
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return localRecogResult;
      }
      VoiceRecognizer.a().b();
      boolean bool;
      if (VoiceRecognizer.a().a(paramArrayOfByte, paramArrayOfByte.length) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localRecogResult.a = bool;
      localRecogResult.b = VoiceRecognizer.a().d();
      localRecogResult.c = cfdToScoreId(localRecogResult.b);
      VoiceRecognizer.a().c();
      this.clientTryTime += 1;
    }
    return localRecogResult;
  }
  
  public static VoiceRedPacketHelperImpl getInstance()
  {
    try
    {
      VoiceRedPacketHelperImpl localVoiceRedPacketHelperImpl = (VoiceRedPacketHelperImpl)QRoute.api(IVoiceRedPacketHelper.class);
      return localVoiceRedPacketHelperImpl;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getKSongFeedsId(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      return paramMessageRecord.getExtInfoFromExtStr("ksong_feeds_id");
    }
    return "";
  }
  
  public static int getKSongRedVoiceType(MessageRecord paramMessageRecord)
  {
    try
    {
      int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("ksong_redpacket_voice_type"));
      return i;
    }
    catch (Throwable paramMessageRecord)
    {
      label12:
      break label12;
    }
    return 0;
  }
  
  public static VoiceRedPacketHelperImpl.RedPacketVoiceIconIds getRedVoiceIconIds(MessageForPtt paramMessageForPtt)
  {
    VoiceRedPacketHelperImpl.RedPacketVoiceIconIds localRedPacketVoiceIconIds = new VoiceRedPacketHelperImpl.RedPacketVoiceIconIds();
    if (paramMessageForPtt.voiceRedPacketFlag == 3)
    {
      localRedPacketVoiceIconIds.a = R.drawable.ab;
      localRedPacketVoiceIconIds.b = R.drawable.af;
      localRedPacketVoiceIconIds.c = R.drawable.aa;
    }
    return localRedPacketVoiceIconIds;
  }
  
  private static String getSimplifiedPwd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  public static String getVoiceScoreId(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      return paramMessageRecord.getExtInfoFromExtStr("voice_score_id");
    }
    return "";
  }
  
  private boolean mixSong(byte[] paramArrayOfByte, String paramString1, String paramString2, RecordParams.RecorderParam paramRecorderParam)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("m");
        String str = ((StringBuilder)localObject).toString();
        localObject = new File(str);
        boolean bool = ((File)localObject).exists();
        if (!bool)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelperImpl", 2, "begin convert mp3 to pcm");
          }
          ((IQwTemp)QRoute.api(IQwTemp.class)).mixSong(paramArrayOfByte, paramString1, paramString2, paramRecorderParam, str);
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("begin mix pcm :");
          paramString1.append(((File)localObject).exists());
          QLog.d("VoiceRedPacketHelperImpl", 2, paramString1.toString());
        }
        if (((File)localObject).exists())
        {
          localObject = FileUtils.fileToBytes((File)localObject);
          i = Math.min(paramArrayOfByte.length, localObject.length);
          paramString1 = new byte[i];
          long l = System.currentTimeMillis();
          QWalletTools.a(paramString1, paramArrayOfByte, (byte[])localObject, i);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("mix pcm time:");
            paramArrayOfByte.append(System.currentTimeMillis() - l);
            QLog.d("VoiceRedPacketHelperImpl", 2, paramArrayOfByte.toString());
          }
          l = System.currentTimeMillis();
          paramArrayOfByte = new AudioCompositeProcessor();
          localObject = new WechatNsWrapper(MobileQQ.getContext());
          if (WechatNsWrapper.j) {
            paramArrayOfByte.a((IAudioProcessor)localObject);
          }
          paramArrayOfByte.a((IAudioProcessor)localObject);
          paramArrayOfByte.a(paramRecorderParam.a, paramRecorderParam.b, paramRecorderParam.c);
          ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString2);
          paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
          ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString2, paramRecorderParam, paramRecorderParam.length);
          i = paramString1.length;
          paramRecorderParam = new byte[800];
          int j = 0;
          break label511;
          int m = i - k;
          System.arraycopy(paramString1, j, paramRecorderParam, 0, k);
          localObject = paramArrayOfByte.a(paramRecorderParam, 0, k);
          k = j + k;
          j = k;
          i = m;
          if (localObject != null)
          {
            ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString2, ((IAudioProcessor.ProcessData)localObject).c, ((IAudioProcessor.ProcessData)localObject).a);
            j = k;
            i = m;
            break label511;
            ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString2);
            paramArrayOfByte.a();
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("pcm 2 silk time:");
              paramArrayOfByte.append(System.currentTimeMillis() - l);
              QLog.d("VoiceRedPacketHelperImpl", 2, paramArrayOfByte.toString());
            }
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
      label511:
      if (i > 0) {
        if (i < 800) {
          k = i;
        } else {
          k = 800;
        }
      }
    }
  }
  
  private void onError(int paramInt, String paramString)
  {
    VoiceRedPacketHelperImpl.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
    if ((localOnVoiceRedPacketListener != null) && (!localOnVoiceRedPacketListener.p())) {
      localOnVoiceRedPacketListener.a(paramInt, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, paramString);
    }
  }
  
  private void onNeedTipsError(String paramString)
  {
    onError(2, paramString);
  }
  
  public static void openVoiceRedPacket(MessageForQQWalletMsg paramMessageForQQWalletMsg) {}
  
  private void reportRecogResult(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    reportRecogResult(paramInt1, paramLong, paramInt2, paramMessageForQQWalletMsg, 0.0F);
  }
  
  private void reportRecogResult(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg, float paramFloat)
  {
    if (paramMessageForQQWalletMsg == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    localStringBuilder.append("|");
    paramInt1 = 0;
    if ((localBaseQQAppInterface != null) && (VoiceRecognizer.a().a(localBaseQQAppInterface))) {
      paramInt1 = 1;
    }
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramMessageForQQWalletMsg.istroop);
    localStringBuilder.append("|");
    localStringBuilder.append(paramFloat);
    VACDReportUtil.b(localStringBuilder.toString(), "QWalletStat", "voiceRedPackMatch", null, null, 0, null);
  }
  
  public static void saveKSongFeedsId(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_feeds_id", paramString);
    }
  }
  
  public static void saveKSongRedVoiceType(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      paramMessageRecord.saveExtInfoToExtStr("ksong_redpacket_voice_type", localStringBuilder.toString());
    }
  }
  
  private void uploadKSongMixRecord(MessageRecord paramMessageRecord, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "uploadKSongMixRecord is call");
    }
    paramMessageRecord = (MessageForPtt)paramMessageRecord;
    try
    {
      MessageForPtt localMessageForPtt = this.mChatActivityFacadeTemp.a(QWalletTools.b(), paramMessageRecord.getLocalFilePath(), this.sessionInfo, -2, paramMessageRecord.voiceType);
      if (localMessageForPtt != null)
      {
        this.mix2RecordMap.put(localMessageForPtt, new VoiceRedPacketHelperImpl.RecordMsgInfo(paramMessageRecord, paramLong, paramArrayOfByte, paramString));
        paramArrayOfByte = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
        if (mixSong(this.fileBytes, this.mAccompanyPath, paramMessageRecord.getLocalFilePath(), paramArrayOfByte))
        {
          paramString = QWalletTools.b();
          if ((paramString != null) && (this.sessionInfo != null) && (localMessageForPtt != null))
          {
            saveKSongRedVoiceType(2, localMessageForPtt);
            localMessageForPtt.voiceRedPacketFlag = 3;
            localMessageForPtt.serial();
            Bundle localBundle = new Bundle();
            localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
            this.mChatActivityFacadeTemp.a(paramString, this.sessionInfo.a, this.sessionInfo.b, paramMessageRecord.getLocalFilePath(), localMessageForPtt.uniseq, false, paramMessageRecord.voiceLength, paramArrayOfByte.c, true, 0, 5, true, localMessageForPtt.vipSubBubbleId, localBundle, null, null, false, localMessageForPtt, 0);
            paramArrayOfByte = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
            if (paramArrayOfByte != null) {
              this.identify = paramArrayOfByte.hashCode();
            }
            paramArrayOfByte = (MessageForQQWalletMsg)this.redPacketCacheMap.get(paramMessageRecord);
            this.redPacketCacheMap.put(localMessageForPtt, paramArrayOfByte);
            this.redPacketCacheMap.remove(paramMessageRecord);
          }
        }
        else
        {
          onError("Mix song error!");
          return;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public void afterProcess(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public void beforeProcess(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if ((paramIAudioProcessor instanceof WechatNsWrapper))
    {
      paramIAudioProcessor = this.byteArrayOutputStream;
      if ((paramIAudioProcessor != null) && (paramProcessData != null) && (this.mIsSaveRecordPCMData)) {
        paramIAudioProcessor.write(paramProcessData.c, 0, paramProcessData.a);
      }
    }
  }
  
  public void cancelRecord()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "cancelRecord() is called");
    }
    this.isCancel = true;
    stopRecord();
  }
  
  public String cfdToScoreId(float paramFloat)
  {
    int k = (int)(100.0F * paramFloat);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cfdToScoreId:");
      ((StringBuilder)localObject1).append(paramFloat);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(k);
      QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = QWalletTools.b();
    if (localObject1 != null)
    {
      localObject1 = (IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "");
      if (localObject1 != null)
      {
        localObject1 = ((IQWalletConfigService)localObject1).getObj("voice_pwd", new String[] { "scoreIdMap" });
        if (localObject1 != null) {
          try
          {
            if (((JSONObject)localObject1).length() > 0)
            {
              Iterator localIterator = ((JSONObject)localObject1).keys();
              if (localIterator != null) {
                while (localIterator.hasNext())
                {
                  String str2 = (String)localIterator.next();
                  String str1 = ((JSONObject)localObject1).getString(str2);
                  if (str2.contains("-"))
                  {
                    Object localObject2 = str2.split("-");
                    if ((localObject2 != null) && (localObject2.length > 0) && (localObject2.length <= 2))
                    {
                      boolean bool = TextUtils.isEmpty(str1);
                      if (!bool)
                      {
                        int i = -2147483648;
                        int j = 2147483647;
                        try
                        {
                          if (localObject2.length == 1)
                          {
                            i = Integer.parseInt(localObject2[0].trim());
                          }
                          else
                          {
                            if (localObject2.length != 2) {
                              continue;
                            }
                            str2 = localObject2[0].trim();
                            localObject2 = localObject2[1].trim();
                            if (!TextUtils.isEmpty(str2)) {
                              i = Integer.parseInt(str2);
                            }
                            j = Integer.parseInt((String)localObject2);
                          }
                          if ((k >= i) && (k <= j)) {
                            return str1;
                          }
                        }
                        catch (Throwable localThrowable2)
                        {
                          localThrowable2.printStackTrace();
                        }
                      }
                    }
                  }
                }
              }
            }
            if (k >= 65) {
              break label351;
            }
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
    }
    return "c";
    label351:
    if (k < 70) {
      return "b";
    }
    if (k < 75) {
      return "a";
    }
    if (k < 80) {
      return "s";
    }
    if (k < 90) {
      return "ss";
    }
    return "sss";
  }
  
  public void checkAndSendMessage(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver, long paramLong, byte[] paramArrayOfByte, String paramString, BaseTransProcessor paramBaseTransProcessor)
  {
    for (;;)
    {
      try
      {
        BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
        Object localObject1 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
        if (localObject1 == null) {
          break label485;
        }
        i = localObject1.hashCode();
        if ((localBaseQQAppInterface != null) && (paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)) && (localObject1 != null) && (!((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).p()) && (!this.isCancel) && (i == this.identify))
        {
          Object localObject2 = (MessageForPtt)paramMessageRecord;
          int j = ((MessageForPtt)localObject2).voiceRedPacketFlag;
          localObject1 = (MessageForQQWalletMsg)this.redPacketCacheMap.get(localObject2);
          boolean bool = QLog.isColorLevel();
          i = 2;
          Object localObject3;
          if (bool)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkAndSend MessagemessageForPtt flag:");
            ((StringBuilder)localObject3).append(j);
            QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
          }
          if (j == 1)
          {
            paramMessageRecord = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
            if ((paramMessageRecord != null) && (!paramMessageRecord.p())) {
              paramMessageRecord.a(true, ((MessageForPtt)localObject2).getExtInfoFromExtStr("voice_score_id"));
            }
            saveVoiceScoreId(getVoiceScoreId((MessageRecord)localObject2), (MessageRecord)localObject1);
            ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage(localBaseQQAppInterface, (MessageRecord)localObject2, paramBaseMessageObserver);
            return;
          }
          if (j == 2)
          {
            if ((localObject1 != null) && (((MessageForQQWalletMsg)localObject1).mQQWalletRedPacketMsg != null))
            {
              if (((MessageForQQWalletMsg)localObject1).istroop == 1) {
                i = 1;
              } else {
                if (((MessageForQQWalletMsg)localObject1).istroop != 3000) {
                  break label491;
                }
              }
              getSkey(new VoiceRedPacketHelperImpl.2(this, localBaseQQAppInterface, (MessageForQQWalletMsg)localObject1, i, paramLong, paramArrayOfByte, paramString, (MessageForPtt)localObject2, paramBaseTransProcessor, paramBaseMessageObserver));
              return;
            }
            onError("MessageForQQWalletMsg is null");
            return;
          }
          if (j == 3)
          {
            if (getKSongRedVoiceType(paramMessageRecord) == 1)
            {
              uploadKSongMixRecord(paramMessageRecord, paramLong, paramArrayOfByte, paramString);
              return;
            }
            if (getKSongRedVoiceType(paramMessageRecord) == 2)
            {
              paramMessageRecord = (MessageForPtt)paramMessageRecord;
              localObject2 = (VoiceRedPacketHelperImpl.RecordMsgInfo)this.mix2RecordMap.get(paramMessageRecord);
              localObject3 = (MessageForQQWalletMsg)this.redPacketCacheMap.get(paramMessageRecord);
              if ((localObject3 != null) && (((MessageForQQWalletMsg)localObject3).mQQWalletRedPacketMsg != null))
              {
                if (((MessageForQQWalletMsg)localObject3).istroop == 1) {
                  i = 1;
                } else {
                  if (((MessageForQQWalletMsg)localObject3).istroop != 3000) {
                    break label497;
                  }
                }
                getSkey(new VoiceRedPacketHelperImpl.3(this, (MessageForQQWalletMsg)localObject3, localBaseQQAppInterface, i, (VoiceRedPacketHelperImpl.RecordMsgInfo)localObject2, paramLong, paramArrayOfByte, paramString, (MessageForQQWalletMsg)localObject1, paramMessageRecord, paramBaseTransProcessor, paramBaseMessageObserver));
                return;
              }
              onError("MessageForQQWalletMsg is null");
              return;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        onError(paramMessageRecord.toString());
      }
      return;
      label485:
      int i = 0;
      continue;
      label491:
      i = 0;
      continue;
      label497:
      i = 0;
    }
  }
  
  public void clearReportStatus()
  {
    this.clientTryTime = 0;
    this.serverTryTime = 0;
  }
  
  public int getRedPackTypeForPtt(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      int j = ((MessageForPtt)paramMessageRecord).voiceRedPacketFlag;
      int i = 3;
      if ((j != 1) && (j != 2))
      {
        if (j != 3) {
          return 0;
        }
      }
      else {
        i = 1;
      }
      return i;
    }
    return 0;
  }
  
  public void getSkey(VoiceRedPacketHelperImpl.OnGetSkeyListener paramOnGetSkeyListener)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface != null)
    {
      if (paramOnGetSkeyListener == null) {
        return;
      }
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getSkey(localBaseQQAppInterface, new VoiceRedPacketHelperImpl.4(this, paramOnGetSkeyListener));
    }
  }
  
  public ByteStringMicro getVoiceScoreIdBytes(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramMessageRecord = ((MessageForPtt)paramMessageRecord).getExtInfoFromExtStr("voice_score_id");
        if (!TextUtils.isEmpty(paramMessageRecord))
        {
          paramMessageRecord = ByteStringMicro.copyFromUtf8(paramMessageRecord);
          return paramMessageRecord;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return null;
  }
  
  public boolean isNeedInterceptSend(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        bool1 = bool2;
        if (paramMessageRecord.voiceRedPacketFlag != 0)
        {
          bool1 = bool2;
          if (!paramMessageRecord.isResend) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("isNeedInterceptSend:");
      paramMessageRecord.append(bool1);
      QLog.d("VoiceRedPacketHelperImpl", 2, paramMessageRecord.toString());
    }
    return bool1;
  }
  
  public boolean isRedPackPTT(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      if ((paramMessageRecord.voiceRedPacketFlag == 1) || (paramMessageRecord.voiceRedPacketFlag == 2) || (paramMessageRecord.voiceRedPacketFlag == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "onBeginReceiveData() is called");
    }
    int i = 0;
    paramString = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
    if (paramString != null) {
      i = paramString.k();
    }
    return i;
  }
  
  public void onError(String paramString)
  {
    onError(1, paramString);
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    onError(3, "onInitFailed");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    onError(3, "onRecorderAbnormal");
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRecorderEnd() is called, isCancel:");
      ((StringBuilder)localObject1).append(this.isCancel);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(this.mIsHeadSetOn);
      QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        if (this.isCancel)
        {
          ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
          return;
        }
        localObject1 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
        if (localObject1 != null) {
          ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).n();
        }
        ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
        if (paramDouble < 500.0D)
        {
          showToast(R.string.b);
          onError("record time too short");
          return;
        }
        if ((this.mIsSaveRecordPCMData) && (this.byteArrayOutputStream != null))
        {
          this.byteArrayOutputStream.flush();
          this.fileBytes = this.byteArrayOutputStream.toByteArray();
          this.byteArrayOutputStream.reset();
        }
        localObject1 = (MessageForPtt)paramRecorderParam.f;
        bool1 = this.isCheckInPhone;
        i = 0;
        if (!bool1) {
          break label776;
        }
        Object localObject2 = (MessageForQQWalletMsg)this.redPacketCacheMap.get(localObject1);
        localObject2 = checkInPhone(this.fileBytes, (MessageForQQWalletMsg)localObject2);
        boolean bool2 = ((VoiceRedPacketHelperImpl.RecogResult)localObject2).a;
        if (bool2) {
          saveVoiceScoreId(((VoiceRedPacketHelperImpl.RecogResult)localObject2).c, (MessageRecord)localObject1);
        }
        localObject2 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
        bool1 = bool2;
        if (localObject2 != null)
        {
          bool1 = bool2;
          if (!((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject2).p())
          {
            bool1 = bool2;
            if (!bool2)
            {
              ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject2).a(false, "");
              bool1 = bool2;
            }
          }
        }
        localObject2 = (MessageForQQWalletMsg)this.redPacketCacheMap.get(localObject1);
        if (localObject2 == null)
        {
          onError("messageForQQWalletMsg is null!");
          return;
        }
        int k = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(((MessageForQQWalletMsg)localObject2).messageType);
        int j = 1;
        if (k == 8)
        {
          if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.C == 0)
          {
            if (this.mIsHeadSetOn == -1)
            {
              if (QWalletTools.a(MobileQQ.getContext())) {
                i = 1;
              }
              this.mIsHeadSetOn = i;
            }
            if ((this.mIsHeadSetOn == 1) && (Build.VERSION.SDK_INT >= 18) && (!mixSong(this.fileBytes, this.mAccompanyPath, paramString, paramRecorderParam)))
            {
              onError("mix song error!");
              return;
            }
            saveKSongRedVoiceType(2, (MessageRecord)localObject1);
          }
          else if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.C == 1)
          {
            saveKSongRedVoiceType(1, (MessageRecord)localObject1);
          }
          ((MessageForPtt)localObject1).voiceRedPacketFlag = 3;
        }
        else
        {
          if (!this.isCheckInPhone) {
            break label782;
          }
          i = j;
          ((MessageForPtt)localObject1).voiceRedPacketFlag = i;
        }
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("isCheckInPhone:");
          ((StringBuilder)localObject3).append(this.isCheckInPhone);
          ((StringBuilder)localObject3).append(",isRecognizedInPhone:");
          ((StringBuilder)localObject3).append(bool1);
          ((StringBuilder)localObject3).append(",redpkgType:");
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append("songFlag:");
          ((StringBuilder)localObject3).append(((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.C);
          QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
        }
        if ((bool1) || (!this.isCheckInPhone))
        {
          localObject2 = QWalletTools.b();
          if ((localObject2 != null) && (this.sessionInfo != null))
          {
            ((MessageForPtt)localObject1).serial();
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("DiyTextId", ((MessageForPtt)localObject1).vipBubbleDiyTextId);
            this.mChatActivityFacadeTemp.a((BaseQQAppInterface)localObject2, this.sessionInfo.a, this.sessionInfo.b, paramString, ((MessageForPtt)localObject1).uniseq, false, (int)paramDouble, paramRecorderParam.c, true, 0, 5, true, ((MessageForPtt)localObject1).vipSubBubbleId, (Bundle)localObject3, null, null, false, (MessageRecord)localObject1, 0);
            paramString = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
            if (paramString != null)
            {
              this.identify = paramString.hashCode();
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        onError(paramString.toString());
        paramString.printStackTrace();
      }
      return;
      label776:
      boolean bool1 = false;
      continue;
      label782:
      int i = 2;
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    onError("onRecorderError");
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "onRecorderNotReady() is called");
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecorderPrepare() is called :");
      ((StringBuilder)localObject).append(this.mIsSaveRecordPCMData);
      QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
    AudioUtil.b(R.raw.a, false);
    Object localObject = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, (byte[])localObject, localObject.length);
    paramString = (MessageForPtt)paramRecorderParam.f;
    if (this.mIsSaveRecordPCMData)
    {
      this.byteArrayOutputStream = new ByteArrayOutputStream();
      if (paramString.voiceRedPacketFlag == 3)
      {
        paramString = new byte[((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).bytesInSecond(paramRecorderParam.a, 2, 2) / 1000 * 200];
        Arrays.fill(paramString, (byte)0);
        this.byteArrayOutputStream.write(paramString, 0, paramString.length);
      }
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
    paramString = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
    if ((paramString != null) && (!paramString.p())) {
      paramString.a(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(paramInt2));
    }
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "onRecorderStart() is called");
    }
    VoiceRedPacketHelperImpl.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.onVoiceRedPacketListenerRef.get();
    if (localOnVoiceRedPacketListener != null) {
      localOnVoiceRedPacketListener.m();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void saveVoiceScoreId(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("voice_score_id", paramString);
    }
  }
  
  public void setAccompanyPath(String paramString)
  {
    this.mAccompanyPath = paramString;
  }
  
  public void setOnVoiceRedPacketListener(VoiceRedPacketHelperImpl.OnVoiceRedPacketListener paramOnVoiceRedPacketListener)
  {
    this.onVoiceRedPacketListenerRef = new WeakReference(paramOnVoiceRedPacketListener);
  }
  
  public void showToast(int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localBaseQQAppInterface.runOnUiThread(new VoiceRedPacketHelperImpl.1(this, localBaseApplication, paramInt, localBaseApplication.getResources().getDimensionPixelSize(R.dimen.b)));
  }
  
  public void startRecord(BaseSessionInfo paramBaseSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
        this.sessionInfo = paramBaseSessionInfo;
        i = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
        if (!TextUtils.isEmpty(paramString)) {
          break label776;
        }
        paramString = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c;
        if ((localBaseQQAppInterface != null) && (paramBaseSessionInfo != null))
        {
          if (TextUtils.isEmpty(paramString)) {
            return;
          }
          this.isCheckInPhone = paramBoolean;
          RecordParams.RecorderParam localRecorderParam = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
          if (!FileUtils.hasSDCardAndWritable())
          {
            showToast(R.string.k);
            onError("no sdcard");
            return;
          }
          if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord())
          {
            showToast(R.string.du);
            onError("sdcard full");
            return;
          }
          if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(localRecorderParam.c))
          {
            showToast(R.string.j);
            onError("internal storage full");
            return;
          }
          if (((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).QQAppInterface$isVideoChatting(localBaseQQAppInterface))
          {
            showToast(R.string.n);
            onError("ppt play error on video chatting");
            return;
          }
          if (i == 2)
          {
            this.isInitSuccess = true;
            if (!VoiceRecognizer.a().a(localBaseQQAppInterface)) {
              this.isInitSuccess = false;
            }
            if (!VoiceRecognizer.a().a(getSimplifiedPwd(paramString))) {
              this.isInitSuccess = false;
            }
          }
          long l1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getLong(localBaseQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", 0L);
          long l2 = NetConnInfoCenter.getServerTime();
          if ((l1 == 0L) || (l1 <= l2)) {
            break label779;
          }
          bool1 = false;
          boolean bool2 = QLog.isColorLevel();
          if (bool2)
          {
            paramString = new StringBuilder();
            paramString.append("startRecord() is checkInPhone:");
            paramString.append(paramBoolean);
            paramString.append(",isInitSuccess:");
            paramString.append(this.isInitSuccess);
            paramString.append(",isServerAvailable:");
            paramString.append(bool1);
            paramString.append(",redpkgType:");
            paramString.append(i);
            QLog.d("VoiceRedPacketHelperImpl", 2, paramString.toString());
          }
          if ((!this.isInitSuccess) && (!bool1)) {
            onError(2, ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(localBaseQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", MobileQQ.getContext().getResources().getString(R.string.u)));
          }
          if (paramBoolean)
          {
            if (!this.isInitSuccess) {
              this.isCheckInPhone = false;
            }
          }
          else if (!bool1) {
            this.isCheckInPhone = true;
          }
          this.mIsSaveRecordPCMData = false;
          if ((i != 2) || (!this.isInitSuccess)) {
            break label785;
          }
          this.mIsSaveRecordPCMData = true;
          paramString = TransFileUtil.getTransferFilePath(localBaseQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
          String str = MessageForPtt.getLocalFilePath(localRecorderParam.c, paramString);
          if ((paramString == null) || (paramString.equals(str))) {
            break label795;
          }
          new File(paramString).deleteOnExit();
          paramString = str;
          if (this.recorder == null) {
            this.recorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(BaseApplication.getContext());
          }
          paramBaseSessionInfo = this.mChatActivityFacadeTemp.a(localBaseQQAppInterface, paramString, paramBaseSessionInfo, -2, localRecorderParam.c);
          if (paramBaseSessionInfo == null)
          {
            onError("messageRecord create is null");
            return;
          }
          if (i == 8)
          {
            saveKSongRedVoiceType(1, paramBaseSessionInfo);
            paramBaseSessionInfo.voiceRedPacketFlag = 3;
          }
          else
          {
            if (!this.isCheckInPhone) {
              break label798;
            }
            i = 1;
            paramBaseSessionInfo.voiceRedPacketFlag = i;
          }
          this.redPacketCacheMap.put(paramBaseSessionInfo, paramMessageForQQWalletMsg);
          localRecorderParam.f = paramBaseSessionInfo;
          this.recorder.a(localRecorderParam);
          this.recorder.a(this);
          this.recorder.a(this);
          this.recorder.a(paramString, true);
          ((IQwTemp)QRoute.api(IQwTemp.class)).mediaPlayer_doStop(true, localBaseQQAppInterface);
          this.isCancel = false;
          this.mIsHeadSetOn = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelperImpl", 2, "startRecord() is called");
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramBaseSessionInfo)
      {
        onError(paramBaseSessionInfo.toString());
        paramBaseSessionInfo.printStackTrace();
      }
      return;
      label776:
      continue;
      label779:
      boolean bool1 = true;
      continue;
      label785:
      if (i == 8)
      {
        continue;
        label795:
        continue;
        label798:
        i = 2;
      }
    }
  }
  
  public void stopRecord()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "stopRecord() is called");
    }
    IQQRecorder localIQQRecorder = this.recorder;
    if ((localIQQRecorder != null) && (!localIQQRecorder.b())) {
      this.recorder.c();
    }
  }
  
  public void syncVoiceScoreIdToMr(String paramString, MessageForPtt paramMessageForPtt, BaseTransProcessor paramBaseTransProcessor)
  {
    saveVoiceScoreId(paramString, paramMessageForPtt);
    if (paramBaseTransProcessor != null) {
      if ((paramBaseTransProcessor instanceof IC2CPttUploadProcessor))
      {
        paramString = ((IC2CPttUploadProcessor)paramBaseTransProcessor).getNewestPTTRichText();
        if ((paramString != null) && (paramMessageForPtt != null)) {
          paramMessageForPtt.richText = paramString;
        }
      }
      else if ((paramBaseTransProcessor instanceof IGroupPttUploadProcessor))
      {
        paramString = ((IGroupPttUploadProcessor)paramBaseTransProcessor).getNewestPTTRichText(paramMessageForPtt);
        if ((paramString != null) && (paramMessageForPtt != null)) {
          paramMessageForPtt.richText = paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl
 * JD-Core Version:    0.7.0.1
 */