package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;

public class BuddyTransfileProcessor
  extends BaseTransProcessor
{
  public static final int C2CPIC_TRANSTYPE_OFFLINE = 2;
  public static final int C2CPIC_TRANSTYPE_ONLINE = 1;
  public static final int C2CPIC_TRANSTYPE_UNKNOWN = 0;
  private static final String FILE_OFFFILE_DIR = "file/";
  private static final String FILE_PHOTO_DIR = "photo/";
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
  private SttManager mSttManager = (SttManager)this.app.getManager(QQManagerFactory.STT_MANAGER);
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
      paramInt2 = 1;
      this.isRawPic = true;
    }
    this.friendUin = paramString1;
    this.file.peerUin = paramString1;
    this.file.selfUin = this.selfUin;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.file.mUin = this.selfUin;
      this.file.friendUin = paramString1;
    }
    for (this.peerUin = this.selfUin;; this.peerUin = paramString1)
    {
      setFakeProgressCapable(false);
      setTransType(paramInt2);
      this.file.uinType = 0;
      if (FileUtils.c(paramString3)) {
        this.file.filePath = paramString3;
      }
      if ((paramString4 != null) && (!FileUtils.c(paramString4))) {
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
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.random + " msgseq:" + this.msgseq);
        }
      }
      return;
    }
  }
  
  public static BuddyTransfileProcessor.A9Message analysisOffLineFileMsg(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.A9Message localA9Message = new BuddyTransfileProcessor.A9Message();
    long l = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localA9Message.type = paramArrayOfByte[1];
      int k = PkgTools.getShortData(paramArrayOfByte, 2) + 4;
      int j = paramArrayOfByte[k];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = k + 1;
      arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, j, i);
      i += j;
      l = PkgTools.getLongData(paramArrayOfByte, i + 2 + PkgTools.getShortData(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l > 10000L) {
          paramArrayOfLong[0] = l;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localA9Message.serverPath = paramArrayOfByte;
      return localA9Message;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult analysisTransFileMsg(byte[] paramArrayOfByte, short paramShort, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult;
    int i;
    long l;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getFileUuid msgHex:" + HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
      if (paramShort != 169) {
        break label387;
      }
      localC2CPicMsgParseResult.type = 1;
      if (paramArrayOfByte[0] != 1) {
        break label414;
      }
      paramShort = paramArrayOfByte[1];
      i = PkgTools.getShortData(paramArrayOfByte, 2);
      localC2CPicMsgParseResult.dSig = new byte[i];
      PkgTools.copyData(localC2CPicMsgParseResult.dSig, 0, paramArrayOfByte, 4, i);
      int j = i + 4;
      i = paramArrayOfByte[j];
      j += 1;
      localC2CPicMsgParseResult.sUUID = new byte[i];
      PkgTools.copyData(localC2CPicMsgParseResult.sUUID, 0, paramArrayOfByte, j, i);
      j += i;
      i = PkgTools.getShortData(paramArrayOfByte, j);
      j += 2;
      localC2CPicMsgParseResult.sNote = new byte[i];
      PkgTools.copyData(localC2CPicMsgParseResult.sNote, 0, paramArrayOfByte, j, i);
      l = PkgTools.getLongData(paramArrayOfByte, j + i);
    }
    for (;;)
    {
      if (localC2CPicMsgParseResult.sUUID != null)
      {
        localC2CPicMsgParseResult.fileSize = 0L;
        if (l > 10000L) {
          paramArrayOfLong[0] = l;
        }
        localC2CPicMsgParseResult.serverPath = new String(localC2CPicMsgParseResult.sUUID);
        i = paramShort;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg  dwReserved: " + l + " serverPath:" + localC2CPicMsgParseResult.serverPath);
        }
      }
      for (i = paramShort;; i = 0)
      {
        if (localC2CPicMsgParseResult.serverPath != null)
        {
          localC2CPicMsgParseResult.msgContent = TransfileUtile.makeTransFileProtocolData(localC2CPicMsgParseResult.serverPath, localC2CPicMsgParseResult.fileSize, i, false, localC2CPicMsgParseResult.serverPath);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.msgContent);
          }
        }
        return localC2CPicMsgParseResult;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getFriendPhotoMsg vMsg is null");
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg fail");
        }
        return null;
        label387:
        if ((paramArrayOfByte[0] == 22) && (paramArrayOfByte[1] == 32)) {
          return decodeOffLinePic(paramArrayOfByte, false);
        }
      }
      label414:
      l = 0L;
      paramShort = 0;
    }
  }
  
  private static void buildAssistantFileInfo(String paramString, BuddyTransfileProcessor.FileInfo paramFileInfo)
  {
    paramFileInfo.fileDir = (paramFileInfo.fileDir + "ast/" + getPttTimeDir() + "/");
    paramFileInfo.fileDir = RmVFSUtils.getVFSPath(paramFileInfo.fileDir, true);
    paramFileInfo.suffix = ".ast";
    if (paramString == null) {
      paramFileInfo.name = getTransFileDateTime();
    }
  }
  
  private static void buildFileFileInfo(String paramString, byte[] paramArrayOfByte, BuddyTransfileProcessor.FileInfo paramFileInfo)
  {
    paramFileInfo.fileDir = AppConstants.SDCARD_FILE_SAVE_PATH;
    if (paramString == null)
    {
      paramFileInfo.name = getTransFileDateTime();
      if (paramArrayOfByte == null) {}
    }
    for (paramFileInfo.name += HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);; paramFileInfo.name = paramString)
    {
      paramFileInfo.suffix = "";
      return;
    }
  }
  
  @NotNull
  private static BuddyTransfileProcessor.FileInfo buildFileInfo(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    paramString1 = new BuddyTransfileProcessor.FileInfo(AppConstants.SDCARD_PATH + paramString1 + "/", null, "");
    switch (paramInt)
    {
    default: 
    case 2: 
    case 327697: 
    case 1: 
    case 65537: 
    case 0: 
    case 25: 
    case 53: 
    case 65: 
      do
      {
        do
        {
          do
          {
            return paramString1;
            buildPttFileInfo(paramString2, paramString1);
            return paramString1;
            buildAssistantFileInfo(paramString2, paramString1);
            return paramString1;
            buildPicFileInfo(paramString2, paramArrayOfByte, paramString1);
            return paramString1;
            buildFileFileInfo(paramString2, paramArrayOfByte, paramString1);
            return paramString1;
            paramString1.fileDir += "ptt/";
            paramString1.suffix = ".slk";
          } while (paramString2 != null);
          paramString1.name = ("buluo_" + getTransFileDateTime());
          return paramString1;
          paramString1.fileDir += "ptt/";
          paramString1.suffix = ".slk";
        } while (paramString2 != null);
        paramString1.name = ("vs_" + getTransFileDateTime());
        return paramString1;
        paramString1.fileDir += "ptt/";
        paramString1.suffix = ".slk";
      } while (paramString2 != null);
      paramString1.name = ("homework_" + getTransFileDateTime());
      return paramString1;
    }
    paramString1.fileDir += "ptt/";
    paramString1.suffix = ".slk";
    if (paramString2 == null)
    {
      paramString1.name = ("ef_" + getTransFileDateTime());
      return paramString1;
    }
    paramString1.name = ("ef_" + paramString2);
    return paramString1;
  }
  
  private static void buildPicFileInfo(String paramString, byte[] paramArrayOfByte, BuddyTransfileProcessor.FileInfo paramFileInfo)
  {
    paramFileInfo.fileDir += "photo/";
    paramFileInfo.suffix = ".jpg";
    if (paramString == null)
    {
      paramFileInfo.name = getTransFileDateTime();
      if (paramArrayOfByte != null) {
        paramFileInfo.name += HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
      }
    }
  }
  
  private static void buildPttFileInfo(String paramString, BuddyTransfileProcessor.FileInfo paramFileInfo)
  {
    paramFileInfo.fileDir = (paramFileInfo.fileDir + "ptt/" + getPttTimeDir() + "/");
    paramFileInfo.fileDir = RmVFSUtils.getVFSPath(paramFileInfo.fileDir, true);
    paramFileInfo.suffix = ".amr";
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("streamptt", 2, "pttdown,33333");
      }
      paramFileInfo.name = ("stream_" + getTransFileDateTime());
      if (QLog.isColorLevel()) {
        QLog.i("streamptt", 2, "pttdown,name = " + paramFileInfo.name);
      }
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult decodeOffLinePic(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
    localC2CPicMsgParseResult.type = 2;
    PkgTools.ascByteToLong(paramArrayOfByte, 2, 3).longValue();
    int j;
    int i;
    if ((paramArrayOfByte[5] == 49) && (paramArrayOfByte[6] == 48))
    {
      PkgTools.ascByteToLong(paramArrayOfByte, 7, 3).longValue();
      if (paramArrayOfByte[10] != 50) {
        break label309;
      }
      j = 11;
      localC2CPicMsgParseResult.repeatIndex = (paramArrayOfByte[11] - 65);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path repeat");
        i = j;
      }
    }
    for (;;)
    {
      if (paramArrayOfByte[i] == 65)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "parse down file path success");
        }
        if ((paramArrayOfByte.length <= i + 1) || (paramArrayOfByte[(i + 1)] != 10)) {}
      }
      try
      {
        localC2CPicMsgParseResult.actionUrl = new String(paramArrayOfByte, "utf-8").substring(i + 2);
        if (localC2CPicMsgParseResult.serverPath != null)
        {
          paramArrayOfByte = null;
          if (localC2CPicMsgParseResult.fileName.length() > 0) {
            paramArrayOfByte = localC2CPicMsgParseResult.fileName.split("\\.")[0];
          }
          localC2CPicMsgParseResult.msgContent = TransfileUtile.makeTransFileProtocolData(localC2CPicMsgParseResult.serverPath, localC2CPicMsgParseResult.fileSize, 1, false, localC2CPicMsgParseResult.serverPath, paramArrayOfByte, null);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : md5Str:" + paramArrayOfByte + ",afterDecode:" + TransfileUtile.getPicMD5ByMsgContent(localC2CPicMsgParseResult.msgContent));
          }
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.msgContent);
          }
        }
        return localC2CPicMsgParseResult;
        label309:
        if (paramArrayOfByte[10] == 49)
        {
          i = paramArrayOfByte[11];
          i = 12;
          if (paramArrayOfByte[12] - 65 == 0)
          {
            localC2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(paramArrayOfByte, 13, 10).longValue();
            j = 23;
            i = j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path fail");
            i = j;
            continue;
          }
          if (paramArrayOfByte[12] - 65 != 1) {
            continue;
          }
          localC2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(paramArrayOfByte, 13, 10).longValue();
          i = paramArrayOfByte[23] - 65;
          byte[] arrayOfByte = new byte[i];
          PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 24, i);
          localC2CPicMsgParseResult.fileName = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : ret.fileName:" + localC2CPicMsgParseResult.fileName);
          }
          j = i + 24;
          i = paramArrayOfByte[j] - 65;
          j += 1;
          arrayOfByte = new byte[i];
          PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, j, i);
          j += i;
          try
          {
            localC2CPicMsgParseResult.serverPath = new String(arrayOfByte, "utf-8");
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.serverPath);
              i = j;
            }
          }
          catch (Exception localException)
          {
            i = j;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.w("streamptt", 2, "buddy_mixed, decode action error");
        }
        i = 10;
      }
    }
  }
  
  public static String getPttTimeDir()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (localTime.month + 1 > 9) {}
    for (String str = "" + (localTime.month + 1);; str = "0" + (localTime.month + 1)) {
      return "" + localTime.year + str + "/" + localTime.monthDay;
    }
  }
  
  private static String getTransFileDateTime()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static String getTransferFilePath(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return getTransferFilePath(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String getTransferFilePath(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramString1 = buildFileInfo(paramString1, paramString2, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramString1.fileDir);
    }
    paramString2 = new File(paramString1.fileDir);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString1 = new File(paramString1.fileDir + paramString1.name + paramString1.suffix);
    if ((paramInt != 0) && (paramBoolean) && (!paramString1.exists())) {}
    try
    {
      paramString1.createNewFile();
      label127:
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
      }
      return paramString1.getAbsoluteFile().toString();
    }
    catch (IOException paramString2)
    {
      break label127;
    }
  }
  
  private void handleUploadStreamPttFinished(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    int i = paramUploadStreamStruct.jdField_a_of_type_Short;
    short s1 = (short)paramUploadStreamStruct.jdField_a_of_type_Int;
    Object localObject = paramUploadStreamStruct.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (paramUploadStreamStruct.b != 0)
      {
        this.respCode = paramUploadStreamStruct.b;
        updateSendMessageErrorDb(this.friendUin, 0, this.file.uniseq, this.respCode);
        setStepError(2, 9312, "friend_block");
        onError();
        StreamDataManager.b((String)localObject);
        StreamDataManager.a((String)localObject);
        if (paramUploadStreamStruct.b == 58) {
          insertFriendShieldTips();
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt.send", 2, "respCode = " + this.respCode);
        }
      }
    }
    do
    {
      int k;
      long l;
      int j;
      do
      {
        do
        {
          short s2;
          do
          {
            do
            {
              return;
              if (i == -1)
              {
                this.isStreamPttSuccess = true;
                setStepFinishTime(2);
                this.file.stepTrans.extraInfo.put("param_sliceNum", String.valueOf(StreamDataManager.b((String)localObject)));
                this.file.fileSize = new File(this.file.filePath).length();
                StreamDataManager.a((String)localObject);
                this.file.serverPath = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                if (paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {}
                for (s2 = 1;; s2 = 0)
                {
                  this.streamPttFlag = s2;
                  this.pttTimeStamp = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                  onSuccess();
                  return;
                }
              }
            } while (this.isStreamPttSuccess);
            s2 = StreamDataManager.a((String)localObject);
            if (s2 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              setStepError(2, 9310, "retry overflow");
              onError();
              StreamDataManager.b((String)localObject);
              StreamDataManager.a((String)localObject);
              return;
            }
            k = StreamDataManager.c((String)localObject);
            int m = StreamDataManager.b((String)localObject);
            this.severAckSlice = i;
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + m + ",slices:" + k + " uniseq:" + this.file.uniseq + ",flowLayer:" + s1 + ",prelayer:" + s2);
            }
          } while (s2 >= s1);
          StreamDataManager.a((String)localObject, s1);
          paramUploadStreamStruct = this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
          l = 0L;
          localObject = new Bundle();
          if (paramUploadStreamStruct != null)
          {
            l = paramUploadStreamStruct.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramUploadStreamStruct.vipBubbleDiyTextId);
          }
          startSendRangeStreamPack(true, i, (short)k, l, (Bundle)localObject);
          this.file.logEvent(2, 2);
          return;
        } while (this.isStreamPttSuccess);
        j = StreamDataManager.c((String)localObject);
        k = StreamDataManager.a((String)localObject);
        if (paramUploadStreamStruct.jdField_a_of_type_Int >= k) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.sendSeqMax == i)
      {
        if (this.streamPttTimeoutRetryCount < 8)
        {
          this.streamPttTimeoutRetryCount += 1;
          this.sendSeqMax = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.severAckSlice + " packnum: " + j + " maxSendSeq:" + this.sendSeqMax + " uniseq:" + this.file.uniseq + ",retryCount:" + this.streamPttTimeoutRetryCount + ",flowLayer:" + k);
          }
          paramUploadStreamStruct = this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
          l = 0L;
          localObject = new Bundle();
          if (paramUploadStreamStruct != null)
          {
            l = paramUploadStreamStruct.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramUploadStreamStruct.vipBubbleDiyTextId);
          }
          startSendRangeStreamPack(true, (short)this.severAckSlice, (short)j, l, (Bundle)localObject);
          return;
        }
        setStepError(2, 9310, "timeout");
        onError();
        StreamDataManager.a((String)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  private void insertFriendShieldTips()
  {
    String str1 = this.app.getCurrentAccountUin();
    String str2 = HardCodeUtil.a(2131701300);
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
    String str = paramString + paramLong;
    if (localITransFileController.containsProcessor(paramString, paramLong))
    {
      ((BuddyTransfileProcessor)localITransFileController.findProcessor(str)).stop();
      localITransFileController.removeProcessor(str);
      return true;
    }
    return false;
  }
  
  private void updateSendMessageErrorDb(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Message localMessage = this.app.getMessageFacade().a(paramString, paramInt1);
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
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject1).voiceLength);
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
    int i;
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      ReportController.b(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "8.5.5");
      ((MessageForPtt)localObject1).itemType = 2;
      ((MessageForPtt)localObject1).isread = false;
      ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
      ((MessageForPtt)localObject1).msgUid = MessageUtils.a((int)paramStreamInfo.random);
      if ((paramStreamInfo.pttTransFlag != 1) && (!SttManager.a(this.app))) {
        break label754;
      }
      i = 1;
      label318:
      ((MessageForPtt)localObject1).sttAbility = i;
      localObject2 = this.app;
      if (!((MessageForPtt)localObject1).isSend()) {
        break label760;
      }
    }
    label754:
    label760:
    for (paramStreamInfo = this.selfUin;; paramStreamInfo = this.friendUin)
    {
      ((MessageForPtt)localObject1).longPttVipFlag = VipUtils.a((QQAppInterface)localObject2, paramStreamInfo);
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((MessageForPtt)localObject1).time;
      ((MessageForPtt)localObject1).msgRecTime = l1;
      ((MessageForPtt)localObject1).msgTime = l2;
      ((MessageForPtt)localObject1).vipSubBubbleId = ((int)paramLong2);
      ((MessageForPtt)localObject1).vipBubbleDiyTextId = paramBundle.getInt("DiyTextId", 0);
      i = paramBundle.getInt("DiyPendantId", 0);
      if (i > 0) {
        ((MessageForPtt)localObject1).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i));
      }
      ((MessageForPtt)localObject1).serial();
      paramLong2 = paramLong1;
      if (paramLong1 == 4294967295L)
      {
        paramLong1 = this.app.getMessageFacade().a(((MessageForPtt)localObject1).frienduin);
        paramLong2 = paramLong1;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong1);
          paramLong2 = paramLong1;
        }
      }
      ((MessageForPtt)localObject1).vipBubbleID = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject1).time + " urlAtServer:" + ((MessageForPtt)localObject1).urlAtServer + " bubbleId:" + paramLong2 + " msgseq:" + ((MessageForPtt)localObject1).shmsgseq + " msgUid:" + ((MessageForPtt)localObject1).msgUid);
      }
      paramStreamInfo = this.app.getMessageFacade().b(((MessageForPtt)localObject1).frienduin, ((MessageForPtt)localObject1).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break label768;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject1).getBaseInfoString());
      }
      return null;
      ((MessageForPtt)localObject1).fileSize = 1000L;
      ReportController.b(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "8.5.5");
      break;
      i = 0;
      break label318;
    }
    label768:
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
    if (RichMediaStrategy.noReportByErrorCode(this.errCode)) {}
    long l;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while ((this.file.fileType != 2) || (this.mOldPttData) || (RichMediaStrategy.noReportByErrorCode(this.errCode)));
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      localHashMap = new HashMap();
      if (!this.file.stepTrans.isStream) {
        localHashMap.put("param_step", this.file.stepUrl.getStepReportInfo(1) + ";" + this.file.stepTrans.getStepReportInfo(2) + ";" + this.file.stepNotify.getStepReportInfo(3));
      }
      if (!paramBoolean) {
        break label278;
      }
      if (this.file.actionType != 0) {
        break;
      }
      localHashMap.put("param_toUin", this.peerUin);
      localHashMap.putAll(this.file.stepTrans.extraInfo);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", true, l, this.file.fileSize, localHashMap, "");
    } while (TextUtils.isEmpty(this.file.filePath));
    PttInfoCollector.reportPttSendCost(this.file.filePath, true, paramBoolean, 0, this.file.fileSize);
    return;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", true, l, this.file.fileSize, localHashMap, "");
    return;
    label278:
    if (this.file.actionType == 0)
    {
      if (!BaseTransProcessor.adjustErrorCode(this.errCode, localHashMap))
      {
        localHashMap.put("param_FailCode", Integer.toString(this.errCode));
        if ((this.errCode == -9527) || (this.errCode == 9311) || (this.errCode == 9044) || (this.errCode == 9350) || (this.errCode == 9351)) {
          localHashMap.put(BaseTransProcessor.param_Reason, this.errDesc);
        }
      }
      for (;;)
      {
        localHashMap.put("param_toUin", this.peerUin);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", false, l, this.file.fileSize, localHashMap, "");
        if (TextUtils.isEmpty(this.file.filePath)) {
          break;
        }
        PttInfoCollector.reportPttSendCost(this.file.filePath, true, paramBoolean, 0, this.file.fileSize);
        return;
        localHashMap.put("param_errorDesc", this.errDesc);
        continue;
        this.errCode = -9527;
        localHashMap.put("param_errorDesc", this.errDesc);
      }
    }
    localHashMap.put("param_FailCode", String.valueOf(this.errCode));
    localHashMap.put("param_errorDesc", this.errDesc);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", false, l, this.file.fileSize, localHashMap, "");
  }
  
  protected boolean isUploadProcessor()
  {
    return false;
  }
  
  void onError()
  {
    if (this.streamEs != null) {
      this.streamEs.shutdown();
    }
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    if ((!this.app.isLogin()) || (!this.app.isRunning())) {
      setError(9366, "account switch");
    }
    if (this.file.actionType == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l + " errCode:" + this.errCode + " errDesc:" + this.errDesc + " reason:" + (String)this.mReportInfo.get("param_reason") + " uniseq:" + this.file.uniseq);
      this.app.removeObserver(this.messageObserver);
      doReport(false);
      if (this.file.actionType != 0) {
        break;
      }
      sendMessageToUpdate(1005);
      stopSendStreamPtt(this.friendUin, this.file.uniseq);
      return;
    }
    sendMessageToUpdate(2005);
    stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
  }
  
  void onSuccess()
  {
    if (this.streamEs != null) {
      this.streamEs.shutdown();
    }
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    Object localObject;
    if (this.file.actionType == 0)
    {
      localObject = "streamptt.send";
      QLog.d((String)localObject, 2, "onSuccess elapsed:" + l + " uniseq:" + this.file.uniseq);
      doReport(true);
      this.app.removeObserver(this.messageObserver);
      if (this.file.actionType == 0) {
        updateMessageDataBaseContent(true);
      }
      if (this.file.actionType != 0) {
        break label157;
      }
      sendMessageToUpdate(1003);
      stopSendStreamPtt(this.file.mUin, this.file.uniseq);
    }
    label157:
    do
    {
      return;
      localObject = "streamptt.recv";
      break;
      sendMessageToUpdate(2003);
      stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
      localObject = (MessageForPtt)this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
    } while ((localObject == null) || (this.mSttManager == null) || (!this.mSttManager.b((MessageForPtt)localObject)));
    this.mSttManager.b((MessageForPtt)localObject, 2);
  }
  
  public void start() {}
  
  public void startReceiveOneStreamPack(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle)
  {
    this.file.stepTrans.isStream = true;
    setStepStartTime(2);
    this.isStop = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + paramStreamInfo.pttFormat + ", " + paramStreamInfo.pttTime);
    }
    this.file.logEvent(4, paramStreamData.vData.length);
    switch (this.file.fileType)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              setError(9039, "not mounted");
            }
            for (;;)
            {
              paramStreamInfo = this.app.getPreferences().edit();
              paramStreamInfo.putBoolean("sdcard_related_download_failed", true);
              paramStreamInfo.commit();
              onError();
              return;
              setError(9040, "no enough storage");
            }
          }
          i = StreamDataManager.a(this.file.serverPath);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
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
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s);
            }
            this.app.getMsgHandler().a(this.selfUin, this.peerUin, this.file.serverPath, StreamDataManager.c(this.file.serverPath), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.file.serverPath);
            }
            stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
            StreamDataManager.a(this.file.serverPath, true);
            StreamDataManager.a(this.file.serverPath);
            return;
          }
          StreamDataManager.a(this.file.serverPath, paramStreamInfo.shFlowLayer);
          StreamDataManager.a(this.file.serverPath, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        stopReceiveStreamPtt(this.friendUin, this.file.serverPath, this.file.uniseq);
        StreamDataManager.a(this.file.serverPath, false);
        StreamDataManager.a(this.file.serverPath);
        paramStreamData = this.selfUin + "_" + this.peerUin + "_" + paramStreamInfo.iMsgId;
        if (!streamStreamDuplicateList.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      streamStreamDuplicateList.add(paramStreamData);
      long l = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l * 1000L));
      paramStreamData = this.peerUin + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!StreamDataManager.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    StreamDataManager.c(paramStreamData);
    setStepFinishTime(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.file.serverPath);
    }
    this.app.getMsgHandler().a(this.selfUin, this.peerUin, this.file.serverPath, (short)-1, paramLong1);
    this.file.isStreamMode = true;
    this.file.serverPath = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int i = 1;; i = 0)
    {
      this.streamPttFlag = i;
      if (createMessageDataBaseContent(paramLong2, paramStreamInfo, paramLong3, paramBundle) != null) {
        this.app.handleReceivedMessage(1, true, true);
      }
      onSuccess();
      PttInfoCollector.reportPTTPV(this.app, 1, true, 3);
      PttInfoCollector.reportPTTPV(this.app, 1, true, 2);
      return;
    }
  }
  
  public void startSendOneStreamPack(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, Bundle paramBundle)
  {
    this.voiceType = paramInt2;
    this.voiceLength = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startSendOneStreamPack:" + paramInt2 + ", " + paramInt1 + ", " + paramShort + ", subBubbleId=" + paramLong);
    }
    this.file.stepTrans.isStream = true;
    String str = "";
    if ((this.app != null) && ("0".equals(this.app.getCurrentAccountUin()))) {}
    do
    {
      return;
      this.file.status = 1001;
      setStepStartTime(2);
      this.isStop = false;
      if (this.app != null)
      {
        str = this.app.getCurrentAccountUin();
        this.app.addObserver(this.messageObserver);
      }
      setStepStartTime(2);
      if (paramShort > this.sendSeqMax) {
        this.sendSeqMax = paramShort;
      }
      switch (this.file.fileType)
      {
      default: 
        return;
      }
    } while ((this.streamEs == null) || (this.streamEs.isShutdown()));
    this.streamEs.execute(new BuddyTransfileProcessor.2(this, str, paramShort, paramLong, paramBundle, paramBoolean));
  }
  
  public void startSendRangeStreamPack(boolean paramBoolean, short paramShort1, short paramShort2, long paramLong, Bundle paramBundle)
  {
    short s = paramShort1;
    while (s <= paramShort2)
    {
      startSendOneStreamPack((short)s, true, this.voiceLength, this.voiceType, paramLong, paramBundle);
      s += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "startSendRangeStreamPack, from slice " + paramShort1 + " to slice " + paramShort2 + ", subBubbleId=" + paramLong);
    }
  }
  
  public boolean stopReceiveStreamPtt(String paramString1, String paramString2, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    paramString2 = paramString1 + paramString2 + paramLong;
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
    label336:
    for (paramBoolean = true;; paramBoolean = false)
    {
      for (;;)
      {
        try
        {
          if (this.file.fileType != 2) {
            break;
          }
          MessageForPtt localMessageForPtt = (MessageForPtt)this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq);
          localMessageForPtt.url = this.file.filePath;
          localMessageForPtt.fileSize = this.file.transferedSize;
          localMessageForPtt.itemType = this.file.fileType;
          if (this.file.isRead != 1) {
            break label336;
          }
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.file.serverPath;
          if (SttManager.a(this.app))
          {
            localMessageForPtt.sttAbility = 1;
            QQAppInterface localQQAppInterface = this.app;
            if (localMessageForPtt.isSend())
            {
              Object localObject = this.selfUin;
              localMessageForPtt.longPttVipFlag = VipUtils.a(localQQAppInterface, (String)localObject);
              localMessageForPtt.serial();
              if (QLog.isColorLevel()) {
                QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
              }
              this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq, localMessageForPtt.msgData);
              localMessageForPtt.time = this.pttTimeStamp;
              this.app.getMessageFacade().a(this.friendUin, 0, this.file.uniseq, this.pttTimeStamp);
              localObject = this.app.getMessageFacade().a(this.friendUin, 0);
              if ((localObject == null) || (this.file.serverPath == null) || (!this.file.serverPath.equals(((Message)localObject).pttUrl))) {
                break;
              }
              ((Message)localObject).pttUrl = localMessageForPtt.url;
            }
          }
          else
          {
            localMessageForPtt.sttAbility = this.streamPttFlag;
            continue;
          }
          String str = this.friendUin;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */