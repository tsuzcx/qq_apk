package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.QQMessageFacadeVipUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.app.AppRuntime;

public class BuddyTransfileProcessor
  extends BaseTransProcessor
{
  public static final int C2CPIC_TRANSTYPE_OFFLINE = 2;
  public static final int C2CPIC_TRANSTYPE_ONLINE = 1;
  public static final int C2CPIC_TRANSTYPE_UNKNOWN = 0;
  private static final String FILE_OFFFILE_DIR = "file/";
  public static boolean PbOn = true;
  public static final String STORAGE_FTN = "ftn";
  public static final String STORAGE_PIC_PLATFORM = "picplatform";
  public static final String STORAGE_PTT_CENTER = "pttcenter";
  public static final String STREAM_TAG_R = "streamptt.recv";
  public static final String STREAM_TAG_S = "streamptt.send";
  public static final String TAG = "streamptt";
  private static List<String> streamStreamDuplicateList = new ArrayList();
  protected QQAppInterface app = (QQAppInterface)this.app;
  private String friendUin;
  public boolean isPause = false;
  public boolean isRawPic = false;
  public boolean isStop;
  boolean isStreamPttSuccess = false;
  private boolean mOldPttData = false;
  MessageObserver messageObserver = new BuddyTransfileProcessor.1(this);
  private int msgseq;
  private String peerUin;
  long pttTimeStamp = -1L;
  private long random;
  int respCode = -1;
  private String selfUin = this.app.getCurrentAccountUin();
  int sendSeqMax = 0;
  boolean setPttRecordFinishTime = false;
  int severAckSlice = 1;
  private ExecutorService streamEs;
  int streamPttFlag = -1;
  int streamPttTimeoutRetryCount = 0;
  int voiceLength = 0;
  int voiceType = 0;
  
  public BuddyTransfileProcessor(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, TransFileControllerImpl paramTransFileControllerImpl, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, paramTransFileControllerImpl);
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      this.isRawPic = true;
      paramInt2 = 1;
    }
    this.friendUin = paramString1;
    this.file.peerUin = paramString1;
    this.file.selfUin = this.selfUin;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.file.mUin = this.selfUin;
      this.file.friendUin = paramString1;
      this.peerUin = this.selfUin;
    }
    else
    {
      this.peerUin = paramString1;
    }
    setFakeProgressCapable(false);
    setTransType(paramInt2);
    this.file.uinType = 0;
    if (FileUtils.isLocalPath(paramString3)) {
      this.file.filePath = paramString3;
    }
    if ((paramString4 != null) && (!FileUtils.isLocalPath(paramString4))) {
      this.file.serverPath = paramString4;
    }
    if (paramInt2 == 65538)
    {
      this.file.fileMd5 = this.file.filePath;
      this.file.suffixType = "gif";
    }
    if ((paramInt2 == 2) && (paramBoolean1))
    {
      paramString1 = this.app.getMessageFacade().a(this.peerUin, 0, paramLong);
      if (paramString1 != null)
      {
        this.random = MessageUtils.a(paramString1.msgUid);
        this.msgseq = ((int)paramString1.shmsgseq);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("random:");
        paramString1.append(this.random);
        paramString1.append(" msgseq:");
        paramString1.append(this.msgseq);
        QLog.e("streamptt", 2, paramString1.toString());
      }
    }
  }
  
  public static BuddyTransfileProcessor.A9Message analysisOffLineFileMsg(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.A9Message localA9Message = new BuddyTransfileProcessor.A9Message();
    long l = paramArrayOfLong[0];
    if (paramArrayOfByte[0] == 1)
    {
      localA9Message.type = paramArrayOfByte[1];
      int k = 4 + PkgTools.getShortData(paramArrayOfByte, 2);
      int j = paramArrayOfByte[k];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = k + 1;
      byte[] arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, j, i);
      i = j + i;
      l = PkgTools.getLongData(paramArrayOfByte, i + 2 + PkgTools.getShortData(paramArrayOfByte, i));
      if (l > 10000L) {
        paramArrayOfLong[0] = l;
      }
      paramArrayOfByte = new String(arrayOfByte);
    }
    else
    {
      paramArrayOfByte = null;
    }
    localA9Message.serverPath = paramArrayOfByte;
    return localA9Message;
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult analysisTransFileMsg(byte[] paramArrayOfByte, short paramShort, long[] paramArrayOfLong)
  {
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFileUuid msgHex:");
        ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramArrayOfByte));
        QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new BuddyTransfileProcessor.C2CPicMsgParseResult();
      if (paramShort == 169)
      {
        ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).type = 1;
        long l;
        if (paramArrayOfByte[0] == 1)
        {
          paramShort = paramArrayOfByte[1];
          int i = PkgTools.getShortData(paramArrayOfByte, 2);
          ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).dSig = new byte[i];
          PkgTools.copyData(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).dSig, 0, paramArrayOfByte, 4, i);
          int j = 4 + i;
          i = paramArrayOfByte[j];
          j += 1;
          ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sUUID = new byte[i];
          PkgTools.copyData(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sUUID, 0, paramArrayOfByte, j, i);
          j += i;
          i = PkgTools.getShortData(paramArrayOfByte, j);
          j += 2;
          ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sNote = new byte[i];
          PkgTools.copyData(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sNote, 0, paramArrayOfByte, j, i);
          l = PkgTools.getLongData(paramArrayOfByte, j + i);
        }
        else
        {
          l = 0L;
          paramShort = 0;
        }
        if (((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sUUID != null)
        {
          ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).fileSize = 0L;
          if (l > 10000L) {
            paramArrayOfLong[0] = l;
          }
          ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).serverPath = new String(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).sUUID);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("analysisFileC2cMsg  dwReserved: ");
            paramArrayOfByte.append(l);
            paramArrayOfByte.append(" serverPath:");
            paramArrayOfByte.append(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).serverPath);
            QLog.d("streamptt", 2, paramArrayOfByte.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "analysisFileC2cMsg fail");
          }
          return null;
        }
      }
      else
      {
        if ((paramArrayOfByte[0] == 22) && (paramArrayOfByte[1] == 32)) {
          return decodeOffLinePic(paramArrayOfByte, false);
        }
        paramShort = 0;
      }
      if (((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).serverPath != null)
      {
        ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).msgContent = TransfileUtile.makeTransFileProtocolData(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).serverPath, ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).fileSize, paramShort, false, ((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).serverPath);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("getFriendPhotoMsg serverPath:");
          paramArrayOfByte.append(((BuddyTransfileProcessor.C2CPicMsgParseResult)localObject).msgContent);
          QLog.d("streamptt", 2, paramArrayOfByte.toString());
        }
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "getFriendPhotoMsg vMsg is null");
    }
    return null;
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult decodeOffLinePic(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
    localC2CPicMsgParseResult.type = 2;
    PkgTools.ascByteToLong(paramArrayOfByte, 2, 3).longValue();
    Object localObject;
    int j;
    if ((paramArrayOfByte[5] == 49) && (paramArrayOfByte[6] == 48))
    {
      PkgTools.ascByteToLong(paramArrayOfByte, 7, 3).longValue();
      if (paramArrayOfByte[10] == 50)
      {
        localC2CPicMsgParseResult.repeatIndex = (paramArrayOfByte[11] - 65);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path repeat");
        }
        i = 11;
      }
      else if (paramArrayOfByte[10] == 49)
      {
        i = paramArrayOfByte[11];
        i = 12;
        if (paramArrayOfByte[12] - 65 == 0)
        {
          localC2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(paramArrayOfByte, 13, 10).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path fail");
          }
          i = 23;
          break label381;
        }
        if (paramArrayOfByte[12] - 65 != 1) {
          break label381;
        }
        localC2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(paramArrayOfByte, 13, 10).longValue();
        i = paramArrayOfByte[23] - 65;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramArrayOfByte, 24, i);
        localC2CPicMsgParseResult.fileName = new String((byte[])localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("<---decodeOffLinePic : ret.fileName:");
          ((StringBuilder)localObject).append(localC2CPicMsgParseResult.fileName);
          QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
        }
        j = 24 + i;
        i = paramArrayOfByte[j] - 65;
        j += 1;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramArrayOfByte, j, i);
        j = i + j;
      }
    }
    try
    {
      localC2CPicMsgParseResult.serverPath = new String((byte[])localObject, "utf-8");
      i = j;
      if (!QLog.isColorLevel()) {
        break label381;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFriendPhotoMsg serverPath:");
      ((StringBuilder)localObject).append(localC2CPicMsgParseResult.serverPath);
      QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
      i = j;
    }
    catch (Exception localException)
    {
      label373:
      int k;
      break label373;
    }
    int i = j;
    break label381;
    i = 10;
    label381:
    if (paramArrayOfByte[i] == 65)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "parse down file path success");
      }
      j = paramArrayOfByte.length;
      k = i + 1;
      if ((j <= k) || (paramArrayOfByte[k] != 10)) {}
    }
    try
    {
      localC2CPicMsgParseResult.actionUrl = new String(paramArrayOfByte, "utf-8").substring(i + 2);
    }
    catch (Exception paramArrayOfByte)
    {
      label452:
      break label452;
    }
    QLog.w("streamptt", 2, "buddy_mixed, decode action error");
    if (localC2CPicMsgParseResult.serverPath != null)
    {
      paramArrayOfByte = null;
      if (localC2CPicMsgParseResult.fileName.length() > 0) {
        paramArrayOfByte = localC2CPicMsgParseResult.fileName.split("\\.")[0];
      }
      localC2CPicMsgParseResult.msgContent = TransfileUtile.makeTransFileProtocolData(localC2CPicMsgParseResult.serverPath, localC2CPicMsgParseResult.fileSize, 1, false, localC2CPicMsgParseResult.serverPath, paramArrayOfByte, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<---decodeOffLinePic : md5Str:");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        ((StringBuilder)localObject).append(",afterDecode:");
        ((StringBuilder)localObject).append(TransfileUtile.getPicMD5ByMsgContent(localC2CPicMsgParseResult.msgContent));
        QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("getFriendPhotoMsg serverPath:");
        paramArrayOfByte.append(localC2CPicMsgParseResult.msgContent);
        QLog.d("streamptt", 2, paramArrayOfByte.toString());
      }
    }
    return localC2CPicMsgParseResult;
  }
  
  private void handleUploadStreamPttFinished(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    int i = paramUploadStreamStruct.jdField_a_of_type_Short;
    short s1 = (short)paramUploadStreamStruct.jdField_a_of_type_Int;
    Object localObject = paramUploadStreamStruct.jdField_a_of_type_JavaLangString;
    short s2 = 0;
    int k;
    int m;
    long l;
    if (paramBoolean)
    {
      if (paramUploadStreamStruct.b != 0)
      {
        this.respCode = paramUploadStreamStruct.b;
        updateSendMessageErrorDb(this.friendUin, 0, this.file.uniseq, this.respCode);
        onError();
        StreamDataManager.b((String)localObject);
        ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool((String)localObject);
        if (paramUploadStreamStruct.b == 58) {
          insertFriendShieldTips();
        }
        if (QLog.isColorLevel())
        {
          paramUploadStreamStruct = new StringBuilder();
          paramUploadStreamStruct.append("respCode = ");
          paramUploadStreamStruct.append(this.respCode);
          QLog.e("streamptt.send", 2, paramUploadStreamStruct.toString());
        }
      }
      else
      {
        if (i == -1)
        {
          this.isStreamPttSuccess = true;
          this.file.stepTrans.extraInfo.put("param_sliceNum", String.valueOf(StreamDataManager.b((String)localObject)));
          this.file.fileSize = new File(this.file.filePath).length();
          ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool((String)localObject);
          this.file.serverPath = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.fileKey;
          if (paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {
            s2 = 1;
          }
          this.streamPttFlag = s2;
          this.pttTimeStamp = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.msgTime;
          onSuccess();
          return;
        }
        if (this.isStreamPttSuccess) {
          return;
        }
        s2 = StreamDataManager.a((String)localObject);
        if (s2 > 10)
        {
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
          }
          onError();
          StreamDataManager.b((String)localObject);
          ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool((String)localObject);
          return;
        }
        k = StreamDataManager.c((String)localObject);
        m = StreamDataManager.b((String)localObject);
        this.severAckSlice = i;
        if (QLog.isColorLevel())
        {
          paramUploadStreamStruct = new StringBuilder();
          paramUploadStreamStruct.append("server reset.ResetSeq: ");
          paramUploadStreamStruct.append(i);
          paramUploadStreamStruct.append(" packnum: ");
          paramUploadStreamStruct.append(m);
          paramUploadStreamStruct.append(",slices:");
          paramUploadStreamStruct.append(k);
          paramUploadStreamStruct.append(" uniseq:");
          paramUploadStreamStruct.append(this.file.uniseq);
          paramUploadStreamStruct.append(",flowLayer:");
          paramUploadStreamStruct.append(s1);
          paramUploadStreamStruct.append(",prelayer:");
          paramUploadStreamStruct.append(s2);
          QLog.d("streamptt.send", 2, paramUploadStreamStruct.toString());
        }
        if (s2 >= s1) {
          return;
        }
        StreamDataManager.a((String)localObject, s1);
        paramUploadStreamStruct = this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
        localObject = new Bundle();
        if (paramUploadStreamStruct != null)
        {
          l = paramUploadStreamStruct.vipSubBubbleId;
          ((Bundle)localObject).putInt("DiyTextId", paramUploadStreamStruct.vipBubbleDiyTextId);
        }
        else
        {
          l = 0L;
        }
        startSendRangeStreamPack(true, i, (short)k, l, (Bundle)localObject);
        this.file.logEvent(2, 2);
      }
    }
    else
    {
      if (this.isStreamPttSuccess) {
        return;
      }
      int j = StreamDataManager.c((String)localObject);
      k = StreamDataManager.a((String)localObject);
      if (paramUploadStreamStruct.jdField_a_of_type_Int < k)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
        }
        return;
      }
      if (this.sendSeqMax == i)
      {
        m = this.streamPttTimeoutRetryCount;
        if (m < 8)
        {
          this.streamPttTimeoutRetryCount = (m + 1);
          this.sendSeqMax = 0;
          if (QLog.isColorLevel())
          {
            paramUploadStreamStruct = new StringBuilder();
            paramUploadStreamStruct.append("client check timeout.retry:severAckSlice:");
            paramUploadStreamStruct.append(this.severAckSlice);
            paramUploadStreamStruct.append(" packnum: ");
            paramUploadStreamStruct.append(j);
            paramUploadStreamStruct.append(" maxSendSeq:");
            paramUploadStreamStruct.append(this.sendSeqMax);
            paramUploadStreamStruct.append(" uniseq:");
            paramUploadStreamStruct.append(this.file.uniseq);
            paramUploadStreamStruct.append(",retryCount:");
            paramUploadStreamStruct.append(this.streamPttTimeoutRetryCount);
            paramUploadStreamStruct.append(",flowLayer:");
            paramUploadStreamStruct.append(k);
            QLog.d("streamptt.send", 2, paramUploadStreamStruct.toString());
          }
          paramUploadStreamStruct = this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
          localObject = new Bundle();
          if (paramUploadStreamStruct != null)
          {
            l = paramUploadStreamStruct.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramUploadStreamStruct.vipBubbleDiyTextId);
          }
          else
          {
            l = 0L;
          }
          startSendRangeStreamPack(true, (short)this.severAckSlice, (short)j, l, (Bundle)localObject);
          return;
        }
        onError();
        ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool((String)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
      }
    }
  }
  
  private void insertFriendShieldTips()
  {
    String str1 = this.app.getCurrentAccountUin();
    String str2 = HardCodeUtil.a(2131701440);
    long l = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
    localMessageRecord.init(str1, this.friendUin, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.app.getMessageFacade().a(localMessageRecord, str1);
  }
  
  private boolean stopSendStreamPtt(String paramString, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    if (localITransFileController.containsProcessor(paramString, paramLong))
    {
      ((BuddyTransfileProcessor)localITransFileController.findProcessor((String)localObject)).stop();
      localITransFileController.removeProcessor((String)localObject);
      return true;
    }
    return false;
  }
  
  private void updateSendMessageErrorDb(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Message localMessage = this.app.getMessageFacade().getLastMessage(paramString, paramInt1);
    this.app.getMsgCache().a(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.app.getMessageFacade().a(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  public MessageRecord createMessageDataBaseContent(long paramLong1, StreamInfo paramStreamInfo, long paramLong2, Bundle paramBundle)
  {
    Object localObject1 = new byte[3];
    PkgTools.intToAscString(this.file.serverPath.length(), (byte[])localObject1, 0, 3, "utf-8");
    localObject1 = (MessageForPtt)MessageRecordFactory.a(-2002);
    ((MessageForPtt)localObject1).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject1).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("voiceLength createMessageDataBaseContent ");
      ((StringBuilder)localObject2).append(((MessageForPtt)localObject1).voiceLength);
      QLog.d("streamptt", 2, ((StringBuilder)localObject2).toString());
    }
    ((MessageForPtt)localObject1).selfuin = this.selfUin;
    ((MessageForPtt)localObject1).frienduin = this.friendUin;
    ((MessageForPtt)localObject1).senderuin = this.file.mUin;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject1).setPttStreamFlag(10001);
    ((MessageForPtt)localObject1).msgtype = -2002;
    ((MessageForPtt)localObject1).istroop = 0;
    ((MessageForPtt)localObject1).urlAtServer = this.file.serverPath;
    ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject1).voiceType, this.file.filePath);
    Object localObject2 = new File(this.file.filePath);
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      ReportController.b(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "8.7.0");
    }
    else
    {
      ((MessageForPtt)localObject1).fileSize = 1000L;
      ReportController.b(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "8.7.0");
    }
    ((MessageForPtt)localObject1).itemType = 2;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
    ((MessageForPtt)localObject1).msgUid = MessageUtils.a((int)paramStreamInfo.random);
    if ((paramStreamInfo.pttTransFlag != 1) && (!((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getSttAbility(this.app))) {
      i = 0;
    } else {
      i = 1;
    }
    ((MessageForPtt)localObject1).sttAbility = i;
    localObject2 = this.app;
    if (((MessageForPtt)localObject1).isSend()) {
      paramStreamInfo = this.selfUin;
    } else {
      paramStreamInfo = this.friendUin;
    }
    ((MessageForPtt)localObject1).longPttVipFlag = VipUtils.a((AppRuntime)localObject2, paramStreamInfo);
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = ((MessageForPtt)localObject1).time;
    ((MessageForPtt)localObject1).msgRecTime = l1;
    ((MessageForPtt)localObject1).msgTime = l2;
    ((MessageForPtt)localObject1).vipSubBubbleId = ((int)paramLong2);
    ((MessageForPtt)localObject1).vipBubbleDiyTextId = paramBundle.getInt("DiyTextId", 0);
    int i = paramBundle.getInt("DiyPendantId", 0);
    if (i > 0) {
      ((MessageForPtt)localObject1).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i));
    }
    ((MessageForPtt)localObject1).serial();
    if (paramLong1 == 4294967295L)
    {
      paramLong2 = QQMessageFacadeVipUtils.a(this.app, ((MessageForPtt)localObject1).frienduin);
      paramLong1 = paramLong2;
      if (QLog.isColorLevel())
      {
        paramStreamInfo = new StringBuilder();
        paramStreamInfo.append("Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:");
        paramStreamInfo.append(paramLong2);
        QLog.e("streamptt.recv", 2, paramStreamInfo.toString());
        paramLong1 = paramLong2;
      }
    }
    ((MessageForPtt)localObject1).vipBubbleID = paramLong1;
    if (QLog.isColorLevel())
    {
      paramStreamInfo = new StringBuilder();
      paramStreamInfo.append("Stream ptt:createMessageDataBaseContent:time");
      paramStreamInfo.append(((MessageForPtt)localObject1).time);
      paramStreamInfo.append(" urlAtServer:");
      paramStreamInfo.append(((MessageForPtt)localObject1).urlAtServer);
      paramStreamInfo.append(" bubbleId:");
      paramStreamInfo.append(paramLong1);
      paramStreamInfo.append(" msgseq:");
      paramStreamInfo.append(((MessageForPtt)localObject1).shmsgseq);
      paramStreamInfo.append(" msgUid:");
      paramStreamInfo.append(((MessageForPtt)localObject1).msgUid);
      QLog.e("streamptt.recv", 2, paramStreamInfo.toString());
    }
    paramStreamInfo = this.app.getMessageFacade().a(((MessageForPtt)localObject1).frienduin, ((MessageForPtt)localObject1).istroop);
    if ((paramStreamInfo != null) && (paramStreamInfo.size() > 0))
    {
      paramStreamInfo = paramStreamInfo.iterator();
      while (paramStreamInfo.hasNext()) {
        if (MsgProxyUtils.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true))
        {
          if (QLog.isColorLevel())
          {
            paramStreamInfo = new StringBuilder();
            paramStreamInfo.append("same Ptt :");
            paramStreamInfo.append(((MessageForPtt)localObject1).getBaseInfoString());
            QLog.w("streamptt", 2, paramStreamInfo.toString());
          }
          return null;
        }
      }
    }
    this.app.getMessageFacade().a((MessageRecord)localObject1, this.selfUin);
    this.file.setFileId(((MessageForPtt)localObject1).uniseq);
    return localObject1;
  }
  
  public void createStreamThreadPool()
  {
    this.streamEs = Executors.newSingleThreadExecutor();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
      return;
    }
    if (this.file.fileType == 2)
    {
      if (this.mOldPttData) {
        return;
      }
      if (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
        return;
      }
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      HashMap localHashMap = new HashMap();
      Object localObject;
      if (!this.file.stepTrans.isStream)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.file.stepUrl.getStepReportInfo(1));
        ((StringBuilder)localObject).append(";");
        ((StringBuilder)localObject).append(this.file.stepTrans.getStepReportInfo(2));
        ((StringBuilder)localObject).append(";");
        ((StringBuilder)localObject).append(this.file.stepNotify.getStepReportInfo(3));
        localHashMap.put("param_step", ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        if (this.file.actionType == 0)
        {
          localHashMap.put("param_toUin", this.peerUin);
          localHashMap.putAll(this.file.stepTrans.extraInfo);
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", true, l, this.file.fileSize, localHashMap, "");
          if (!TextUtils.isEmpty(this.file.filePath)) {
            ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPttSendCost(this.file.filePath, true, paramBoolean, 0, this.file.fileSize);
          }
        }
        else
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", true, l, this.file.fileSize, localHashMap, "");
        }
      }
      else if (this.file.actionType == 0)
      {
        localObject = this.mProcessorReport;
        if (!ProcessorReport.adjustErrorCode(this.mProcessorReport.errCode, localHashMap))
        {
          localHashMap.put("param_FailCode", Integer.toString(this.mProcessorReport.errCode));
          if ((this.mProcessorReport.errCode != -9527) && (this.mProcessorReport.errCode != 9311) && (this.mProcessorReport.errCode != 9044) && (this.mProcessorReport.errCode != 9350) && (this.mProcessorReport.errCode != 9351)) {
            localHashMap.put("param_errorDesc", this.mProcessorReport.errDesc);
          } else {
            localHashMap.put("param_reason", this.mProcessorReport.errDesc);
          }
        }
        else
        {
          this.mProcessorReport.errCode = -9527;
          localHashMap.put("param_errorDesc", this.mProcessorReport.errDesc);
        }
        localHashMap.put("param_toUin", this.peerUin);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", false, l, this.file.fileSize, localHashMap, "");
        if (!TextUtils.isEmpty(this.file.filePath)) {
          ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPttSendCost(this.file.filePath, true, paramBoolean, 0, this.file.fileSize);
        }
      }
      else
      {
        localHashMap.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        localHashMap.put("param_errorDesc", this.mProcessorReport.errDesc);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", false, l, this.file.fileSize, localHashMap, "");
      }
    }
  }
  
  void onError()
  {
    Object localObject = this.streamEs;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdown();
    }
    long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    if ((!this.app.isLogin()) || (!this.app.isRunning())) {
      this.mProcessorReport.setError(9366, "account switch", null, null);
    }
    if (this.file.actionType == 0) {
      localObject = "streamptt.send";
    } else {
      localObject = "streamptt.recv";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError elapsed:");
    localStringBuilder.append(l);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.mProcessorReport.errCode);
    localStringBuilder.append(" errDesc:");
    localStringBuilder.append(this.mProcessorReport.errDesc);
    localStringBuilder.append(" reason:");
    localStringBuilder.append((String)this.mProcessorReport.mReportInfo.get("param_reason"));
    localStringBuilder.append(" uniseq:");
    localStringBuilder.append(this.file.uniseq);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    this.app.removeObserver(this.messageObserver);
    doReport(false);
    if (this.file.actionType == 0)
    {
      sendMessageToUpdate(1005);
      stopSendStreamPtt(this.friendUin, this.file.uniseq);
      return;
    }
    sendMessageToUpdate(2005);
    stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
  }
  
  void onSuccess()
  {
    Object localObject = this.streamEs;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdown();
    }
    long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    if (this.file.actionType == 0) {
      localObject = "streamptt.send";
    } else {
      localObject = "streamptt.recv";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSuccess elapsed:");
    localStringBuilder.append(l);
    localStringBuilder.append(" uniseq:");
    localStringBuilder.append(this.file.uniseq);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    doReport(true);
    this.app.removeObserver(this.messageObserver);
    if (this.file.actionType == 0) {
      updateMessageDataBaseContent(true);
    }
    if (this.file.actionType == 0)
    {
      sendMessageToUpdate(1003);
      stopSendStreamPtt(this.file.mUin, this.file.uniseq);
      return;
    }
    sendMessageToUpdate(2003);
    stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
    localObject = (MessageForPtt)this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
    if ((localObject != null) && (((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class)).needAuotoChange((MessageForPtt)localObject))) {
      ((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class)).translate((MessageForPtt)localObject, 2);
    }
  }
  
  public void start() {}
  
  public void startReceiveOneStreamPack(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle)
  {
    this.file.stepTrans.isStream = true;
    int j = 0;
    this.isStop = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startReceiveOneStreamPack:");
      localStringBuilder.append(paramStreamInfo.pttFormat);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramStreamInfo.pttTime);
      QLog.d("RecordParams", 2, localStringBuilder.toString());
    }
    this.file.logEvent(4, paramStreamData.vData.length);
    if (this.file.fileType != 2) {
      return;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() >= 1))
    {
      int i = StreamDataManager.a(this.file.serverPath);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("curFlowLayer: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" received shFlowLayer:");
        localStringBuilder.append(paramStreamInfo.shFlowLayer);
        localStringBuilder.append(",seq");
        localStringBuilder.append(paramStreamData.shPackSeq);
        localStringBuilder.append(",packNum:");
        localStringBuilder.append(paramStreamInfo.shPackNum);
        localStringBuilder.append(" lkey:");
        localStringBuilder.append(paramLong1);
        QLog.d("streamptt.recv", 2, localStringBuilder.toString());
      }
      StreamDataManager.c(this.file.serverPath, paramLong1);
      if (i != paramStreamInfo.shFlowLayer)
      {
        this.app.getMsgHandler().a(this.selfUin, this.peerUin, this.file.serverPath, StreamDataManager.c(this.file.serverPath), paramLong1);
        return;
      }
      if (StreamDataManager.a(this.file.serverPath, paramStreamData.shPackSeq))
      {
        this.file.logEvent(2, 2);
        short s = (short)(StreamDataManager.a(this.file.serverPath) + 1);
        StreamDataManager.a(this.file.serverPath, s);
        if (QLog.isColorLevel())
        {
          paramStreamInfo = new StringBuilder();
          paramStreamInfo.append("startReceiveOneStreamPack JudgeReceiveError flowLayer: ");
          paramStreamInfo.append(s);
          QLog.d("streamptt.recv", 2, paramStreamInfo.toString());
        }
        this.app.getMsgHandler().a(this.selfUin, this.peerUin, this.file.serverPath, StreamDataManager.c(this.file.serverPath), paramLong1);
        return;
      }
      if (paramStreamInfo.oprType == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramStreamInfo = new StringBuilder();
          paramStreamInfo.append("cancelled:");
          paramStreamInfo.append(this.file.serverPath);
          QLog.d("streamptt.recv", 2, paramStreamInfo.toString());
        }
        stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
        StreamDataManager.a(this.file.serverPath, true);
        ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(this.file.serverPath);
        return;
      }
      StreamDataManager.a(this.file.serverPath, paramStreamInfo.shFlowLayer);
      StreamDataManager.a(this.file.serverPath, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
      if (paramStreamInfo.shPackNum > 0)
      {
        stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
        StreamDataManager.a(this.file.serverPath, false);
        ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(this.file.serverPath);
        paramStreamData = new StringBuilder();
        paramStreamData.append(this.selfUin);
        paramStreamData.append("_");
        paramStreamData.append(this.peerUin);
        paramStreamData.append("_");
        paramStreamData.append(paramStreamInfo.iMsgId);
        paramStreamData = paramStreamData.toString();
        if (streamStreamDuplicateList.contains(paramStreamData))
        {
          if (QLog.isColorLevel())
          {
            paramStreamInfo = new StringBuilder();
            paramStreamInfo.append("find stream stream duplicate,discard it ,key:");
            paramStreamInfo.append(paramStreamData);
            QLog.d("streamptt.recv", 2, paramStreamInfo.toString());
          }
          return;
        }
        streamStreamDuplicateList.add(paramStreamData);
        long l = paramStreamInfo.iSendTime;
        paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l * 1000L));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.peerUin);
        localStringBuilder.append("_");
        localStringBuilder.append(paramStreamData);
        paramStreamData = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stream duplicateKey:");
          localStringBuilder.append(paramStreamData);
          QLog.d("streamptt.recv", 2, localStringBuilder.toString());
        }
        if (StreamDataManager.d(paramStreamData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
          }
          return;
        }
        StreamDataManager.b(paramStreamData);
        if (QLog.isColorLevel())
        {
          paramStreamData = new StringBuilder();
          paramStreamData.append("startReceiveOneStreamPack received success path: ");
          paramStreamData.append(this.file.serverPath);
          QLog.d("streamptt.recv", 2, paramStreamData.toString());
        }
        this.app.getMsgHandler().a(this.selfUin, this.peerUin, this.file.serverPath, (short)-1, paramLong1);
        this.file.isStreamMode = true;
        this.file.serverPath = paramStreamInfo.fileKey;
        i = j;
        if (paramStreamInfo.pttTransFlag == 1) {
          i = 1;
        }
        this.streamPttFlag = i;
        if (createMessageDataBaseContent(paramLong2, paramStreamInfo, paramLong3, paramBundle) != null) {
          this.app.handleReceivedMessage(1, true, true);
        }
        onSuccess();
        ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPTTPV(this.app, 1, true, 3);
        ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPTTPV(this.app, 1, true, 2);
      }
      return;
    }
    if (!Environment.getExternalStorageState().equals("mounted")) {
      this.mProcessorReport.setError(9039, "not mounted", null, null);
    } else {
      this.mProcessorReport.setError(9040, "no enough storage", null, null);
    }
    paramStreamInfo = this.app.getPreferences().edit();
    paramStreamInfo.putBoolean("sdcard_related_download_failed", true);
    paramStreamInfo.commit();
    onError();
  }
  
  public void startSendOneStreamPack(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, Bundle paramBundle)
  {
    this.voiceType = paramInt2;
    this.voiceLength = paramInt1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSendOneStreamPack:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(", subBubbleId=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("RecordParams", 2, ((StringBuilder)localObject).toString());
    }
    this.file.stepTrans.isStream = true;
    Object localObject = this.app;
    if ((localObject != null) && ("0".equals(((QQAppInterface)localObject).getCurrentAccountUin()))) {
      return;
    }
    this.file.status = 1001;
    this.isStop = false;
    localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      this.app.addObserver(this.messageObserver);
    }
    else
    {
      localObject = "";
    }
    if (paramShort > this.sendSeqMax) {
      this.sendSeqMax = paramShort;
    }
    if (this.file.fileType != 2) {
      return;
    }
    ExecutorService localExecutorService = this.streamEs;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown())) {
      this.streamEs.execute(new BuddyTransfileProcessor.2(this, (String)localObject, paramShort, paramLong, paramBundle, paramBoolean));
    }
  }
  
  public void startSendRangeStreamPack(boolean paramBoolean, short paramShort1, short paramShort2, long paramLong, Bundle paramBundle)
  {
    short s = paramShort1;
    while (s <= paramShort2)
    {
      startSendOneStreamPack((short)s, true, this.voiceLength, this.voiceType, paramLong, paramBundle);
      s += 1;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("startSendRangeStreamPack, from slice ");
      paramBundle.append(paramShort1);
      paramBundle.append(" to slice ");
      paramBundle.append(paramShort2);
      paramBundle.append(", subBubbleId=");
      paramBundle.append(paramLong);
      QLog.d("streamptt", 2, paramBundle.toString());
    }
  }
  
  public boolean stopReceiveStreamPtt(String paramString1, String paramString2, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramLong);
    paramString2 = localStringBuilder.toString();
    if (localITransFileController.containsProcessor(paramString1, paramLong))
    {
      ((BuddyTransfileProcessor)localITransFileController.findProcessor(paramString2)).stop();
      localITransFileController.removeProcessor(paramString2);
      return true;
    }
    return false;
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.file.fileType == 2)
        {
          MessageForPtt localMessageForPtt = (MessageForPtt)this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
          localMessageForPtt.url = this.file.filePath;
          localMessageForPtt.fileSize = this.file.transferedSize;
          localMessageForPtt.itemType = this.file.fileType;
          if (this.file.isRead != 1) {
            break label359;
          }
          paramBoolean = true;
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.file.serverPath;
          if (((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getSttAbility(this.app)) {
            localMessageForPtt.sttAbility = 1;
          } else {
            localMessageForPtt.sttAbility = this.streamPttFlag;
          }
          QQAppInterface localQQAppInterface = this.app;
          if (localMessageForPtt.isSend()) {
            localObject = this.selfUin;
          } else {
            localObject = this.friendUin;
          }
          localMessageForPtt.longPttVipFlag = VipUtils.a(localQQAppInterface, (String)localObject);
          localMessageForPtt.serial();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Stream ptt:updataMessageDataBaseContent:time");
            ((StringBuilder)localObject).append(localMessageForPtt.time);
            ((StringBuilder)localObject).append(" urlAtServer:");
            ((StringBuilder)localObject).append(localMessageForPtt.urlAtServer);
            QLog.e("streamptt.send", 2, ((StringBuilder)localObject).toString());
          }
          this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq, localMessageForPtt.msgData);
          localMessageForPtt.time = this.pttTimeStamp;
          this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq, this.pttTimeStamp);
          Object localObject = this.app.getMessageFacade().getLastMessage(this.friendUin, 0);
          if ((localObject != null) && (this.file.serverPath != null) && (this.file.serverPath.equals(((Message)localObject).pttUrl))) {
            ((Message)localObject).pttUrl = localMessageForPtt.url;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label359:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */