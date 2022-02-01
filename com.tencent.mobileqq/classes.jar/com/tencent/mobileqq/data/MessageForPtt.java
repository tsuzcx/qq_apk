package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.msgbackup.util.MsgBackupRichTextParse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import localpb.richMsg.RichMsg.PttRec;
import org.json.JSONArray;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class MessageForPtt
  extends MessageForRichText
  implements Media, MsgBackupRichTextParse
{
  public static final int PTT_SIZE_ANIM_START = -2;
  public static final int PTT_SIZE_RECV_ERROR = -4;
  public static final int PTT_SIZE_SATUTS_ERROR = -1;
  public static final int PTT_SIZE_UI_SEND = -3;
  public static final int STT_ABLE = 1;
  public static final int STT_DONE = 2;
  public static final int STT_EMPTY = 0;
  public static final int STT_FAIL = 3;
  private static final String TAG = "PttMsg";
  public static final int VIPFLAG_NONE = 0;
  public static final int VIPFLAG_SVIP = 2;
  public static final int VIPFLAG_VIP = 1;
  public JSONArray atInfo;
  public int autoToText = 0;
  public int busiType;
  public boolean c2cViaOffline;
  public String directUrl = "";
  @notColumn
  public long estimatedSize;
  public boolean expandStt = true;
  public long extFlag;
  public long fileSize;
  public String fullLocalPath = "";
  public long groupFileID;
  public String groupFileKeyStr = null;
  public boolean isReadPtt;
  public int isReport = 0;
  @notColumn
  public boolean isResend;
  public int itemType;
  public int longPttVipFlag;
  @notColumn
  public String mInputContent;
  public String md5;
  public long msgRecTime = 0L;
  public long msgTime = 0L;
  public int msgVia;
  public float playProgress;
  @notColumn
  public float playSpeedPos = SonicHelper.a;
  public int sampleRate;
  public boolean sendFromvoiceChangePanelFlag;
  public String storageSource;
  public int sttAbility = 0;
  @notColumn
  private volatile AIOSttResult sttResult;
  public String sttText;
  public int subVersion = 5;
  public String timeStr;
  public String url;
  public String urlAtServer;
  public int voiceChangeFlag;
  public int voiceLength;
  public int voiceRedPacketFlag;
  public int voiceType;
  public int[] waveformArray;
  
  public static String getLocalFilePath(int paramInt, String paramString)
  {
    return ((IMessageForPttInnerApi)QRoute.api(IMessageForPttInnerApi.class)).getLocalFilePath(paramInt, paramString);
  }
  
  public static String getMsgFilePath(int paramInt, String paramString)
  {
    return ((IMessageForPttInnerApi)QRoute.api(IMessageForPttInnerApi.class)).getMsgFilePath(paramInt, paramString);
  }
  
  public static String getTmpFilePath(String paramString)
  {
    return ((IMessageForPttInnerApi)QRoute.api(IMessageForPttInnerApi.class)).getTmpFilePath(paramString);
  }
  
  public void buileDefaultWaveform()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttMsg", 2, "buileDefaultWaveform");
    }
    int[] arrayOfInt = new int[34];
    Random localRandom = new Random(System.currentTimeMillis());
    int i = 0;
    while (i < 34)
    {
      arrayOfInt[i] = (localRandom.nextInt(55) + 20);
      i += 1;
    }
    this.waveformArray = arrayOfInt;
  }
  
  public void doParse()
  {
    boolean bool1;
    long l1;
    try
    {
      Object localObject1 = new RichMsg.PttRec();
      bool2 = true;
      bool1 = true;
      int j = 0;
      try
      {
        RichMsg.PttRec localPttRec = (RichMsg.PttRec)((RichMsg.PttRec)localObject1).mergeFrom(this.msgData);
        i = 1;
        localObject1 = localPttRec;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        i = 0;
      }
      if (i != 0)
      {
        this.url = ((RichMsg.PttRec)localObject1).localPath.get();
        this.fileSize = ((RichMsg.PttRec)localObject1).size.get();
        this.itemType = ((RichMsg.PttRec)localObject1).type.get();
        this.isReadPtt = ((RichMsg.PttRec)localObject1).isRead.get();
        this.urlAtServer = ((RichMsg.PttRec)localObject1).uuid.get();
        this.sttAbility = ((RichMsg.PttRec)localObject1).pttFlag.get();
        this.md5 = ((RichMsg.PttRec)localObject1).md5.get();
        this.storageSource = ((RichMsg.PttRec)localObject1).serverStorageSource.get();
        this.subVersion = ((RichMsg.PttRec)localObject1).version.get();
        this.isReport = ((RichMsg.PttRec)localObject1).isReport.get();
        this.groupFileID = ((RichMsg.PttRec)localObject1).groupFileID.get();
        this.sttText = ((RichMsg.PttRec)localObject1).sttText.get();
        this.longPttVipFlag = ((RichMsg.PttRec)localObject1).longPttVipFlag.get();
        if (((RichMsg.PttRec)localObject1).expandStt.has()) {
          bool1 = ((RichMsg.PttRec)localObject1).expandStt.get();
        }
        this.expandStt = bool1;
        if (((RichMsg.PttRec)localObject1).group_file_key.has()) {
          this.groupFileKeyStr = ((RichMsg.PttRec)localObject1).group_file_key.get();
        }
        bool1 = ((RichMsg.PttRec)localObject1).msgTime.has();
        long l2 = 0L;
        if (!bool1) {
          break label1344;
        }
        l1 = ((RichMsg.PttRec)localObject1).msgTime.get();
        this.msgTime = l1;
        l1 = l2;
        if (((RichMsg.PttRec)localObject1).msgRecTime.has()) {
          l1 = ((RichMsg.PttRec)localObject1).msgRecTime.get();
        }
        this.msgRecTime = l1;
        if (!((RichMsg.PttRec)localObject1).voiceType.has()) {
          break label1350;
        }
        i = ((RichMsg.PttRec)localObject1).voiceType.get();
        label350:
        this.voiceType = i;
        if (!((RichMsg.PttRec)localObject1).voiceLength.has()) {
          break label1355;
        }
        i = ((RichMsg.PttRec)localObject1).voiceLength.get();
        label378:
        this.voiceLength = i;
        if (!((RichMsg.PttRec)localObject1).voiceChangeFlag.has()) {
          break label1360;
        }
        i = ((RichMsg.PttRec)localObject1).voiceChangeFlag.get();
        label406:
        this.voiceChangeFlag = i;
        if (!((RichMsg.PttRec)localObject1).busiType.has()) {
          break label1365;
        }
        i = ((RichMsg.PttRec)localObject1).busiType.get();
        label434:
        this.busiType = i;
        if (!((RichMsg.PttRec)localObject1).directUrl.has()) {
          break label1370;
        }
        localObject3 = ((RichMsg.PttRec)localObject1).directUrl.get();
        label463:
        this.directUrl = ((String)localObject3);
        if (!((RichMsg.PttRec)localObject1).fullLocalPath.has()) {
          break label1377;
        }
        localObject3 = ((RichMsg.PttRec)localObject1).fullLocalPath.get();
        label493:
        this.fullLocalPath = ((String)localObject3);
        if (!((RichMsg.PttRec)localObject1).extFlag.has()) {
          break label1384;
        }
        l1 = ((RichMsg.PttRec)localObject1).extFlag.get();
        label523:
        this.extFlag = l1;
        if (!((RichMsg.PttRec)localObject1).redpack_type.has()) {
          break label1392;
        }
        i = ((RichMsg.PttRec)localObject1).redpack_type.get();
        label552:
        this.voiceRedPacketFlag = i;
        if (!((RichMsg.PttRec)localObject1).autototext_voice.has()) {
          break label1397;
        }
        i = ((RichMsg.PttRec)localObject1).autototext_voice.get();
        label580:
        this.autoToText = i;
        if ((this.atInfoList != null) && (!this.atInfoList.isEmpty()))
        {
          this.atInfo = new JSONArray();
          localObject1 = this.atInfoList.iterator();
        }
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (AtTroopMemberInfo)((Iterator)localObject1).next();
            this.atInfo.put(((AtTroopMemberInfo)localObject3).uin);
            continue;
            try
            {
              localObject1 = getExtInfoFromExtStr("is_to_robot");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.mRobotFlag = Integer.parseInt((String)localObject1);
              }
              localObject1 = getExtInfoFromExtStr("at_robot_info");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.atInfo = new JSONArray((String)localObject1);
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
        }
        Object localObject2 = getExtInfoFromExtStr("wave_form");
        if (localObject2 != null)
        {
          i = ((String)localObject2).length();
          if (i > 0) {
            try
            {
              localObject2 = new JSONArray((String)localObject2);
              int k = ((JSONArray)localObject2).length();
              localObject3 = new int[k];
              i = j;
              while (i < k)
              {
                localObject3[i] = ((JSONArray)localObject2).getInt(i);
                i += 1;
              }
              this.waveformArray = ((int[])localObject3);
              return;
            }
            catch (Throwable localThrowable1)
            {
              QLog.e(getClass().getName(), 2, "get wave from jason error", localThrowable1);
              return;
            }
          }
        }
        if ((this.waveformArray == null) || (this.waveformArray.length == 0)) {
          buileDefaultWaveform();
        }
      }
      else
      {
        String str1 = this.msg;
        if (str1 == null) {
          try
          {
            if (this.versionCode > 0) {
              this.msg = new String(this.msgData, "UTF-8");
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        this.subVersion = 0;
        if ((this.msg == null) || (this.msgtype != -1031)) {
          break label1402;
        }
        this.msg = ActionMsgUtil.a(this.msg).msg;
        i = 1;
        label929:
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
        {
          arrayOfString = this.msg.split("\\|");
          if (arrayOfString != null)
          {
            if (arrayOfString.length > 0)
            {
              this.url = arrayOfString[0].trim();
              if (i != 0) {
                this.urlAtServer = this.url;
              }
            }
            else
            {
              this.url = "";
              if (i != 0) {
                this.urlAtServer = this.url;
              }
            }
            i = arrayOfString.length;
            if (i <= 1) {}
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      boolean bool2;
      Object localObject3;
      String[] arrayOfString;
      label1052:
      StringBuilder localStringBuilder;
      if (this.msg == null)
      {
        this.url = "";
        this.urlAtServer = "";
      }
      localThrowable2.printStackTrace();
    }
    try
    {
      this.fileSize = Long.valueOf(arrayOfString[1]).longValue();
    }
    catch (Exception localException4)
    {
      break label1052;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = getClass().getName();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java.lang.NumberFormatException: Invalid long: ");
      localStringBuilder.append(arrayOfString[1]);
      localStringBuilder.append(" msg byte ");
      localStringBuilder.append(MessageRecordUtil.a(this.msg));
      QLog.d((String)localObject3, 2, localStringBuilder.toString());
    }
    int i = arrayOfString.length;
    if (i > 2) {}
    try
    {
      this.itemType = Integer.parseInt(arrayOfString[2]);
    }
    catch (Exception localException5)
    {
      label1151:
      break label1151;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = getClass().getName();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java.lang.NumberFormatException: Invalid int: ");
      localStringBuilder.append(arrayOfString[2]);
      localStringBuilder.append(" msg byte ");
      localStringBuilder.append(MessageRecordUtil.a(this.msg));
      QLog.d((String)localObject3, 2, localStringBuilder.toString());
    }
    if (arrayOfString.length > 3)
    {
      if (Integer.valueOf(arrayOfString[3].trim()).intValue() == 0) {
        break label1407;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.isReadPtt = bool1;
      break label1271;
      this.isReadPtt = true;
      label1271:
      if (arrayOfString.length <= 4) {
        return;
      }
      this.urlAtServer = arrayOfString[4];
      return;
      if (this.msg == null)
      {
        this.url = "";
        this.urlAtServer = "";
        return;
      }
      return;
      label1344:
      l1 = 0L;
      break;
      label1350:
      i = 0;
      break label350;
      label1355:
      i = 0;
      break label378;
      label1360:
      i = 0;
      break label406;
      label1365:
      i = 0;
      break label434;
      label1370:
      String str2 = "";
      break label463;
      label1377:
      str2 = "";
      break label493;
      label1384:
      l1 = -1L;
      break label523;
      label1392:
      i = 0;
      break label552;
      label1397:
      i = 0;
      break label580;
      label1402:
      i = 0;
      break label929;
      label1407:
      bool1 = false;
    }
  }
  
  public String getLocalFilePath()
  {
    return getLocalFilePath(this.voiceType, this.url);
  }
  
  public im_msg_body.RichText getRichText()
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    im_msg_body.Ptt localPtt = new im_msg_body.Ptt();
    if (TextUtils.isEmpty(this.md5)) {
      try
      {
        this.md5 = MD5FileUtil.a(new File(getLocalFilePath()));
        serial();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    Object localObject;
    generalflags.ResvAttr localResvAttr;
    if ((this.istroop != 1) && (this.istroop != 3000))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.md5);
      ((StringBuilder)localObject).append(".amr");
      localObject = ((StringBuilder)localObject).toString();
      localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPtt.uint32_file_type.set(4);
      localPtt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
      localPtt.uint32_file_size.set((int)this.fileSize);
      localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
      localObject = ((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPTTExtraInfo(this);
      localPtt.bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject));
      localPtt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
      localObject = new im_msg_body.GeneralFlags();
      localResvAttr = new generalflags.ResvAttr();
      if (this.waveformArray != null)
      {
        localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).changeWaveformToPb(this.waveformArray)));
        ((im_msg_body.GeneralFlags)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
      }
      localElem.general_flags.set((MessageMicro)localObject);
    }
    else
    {
      localPtt.uint32_file_type.set(4);
      localPtt.uint32_file_id.set((int)this.groupFileID);
      localPtt.uint32_file_size.set((int)this.fileSize);
      localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
      localPtt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
      if (this.urlAtServer != null)
      {
        localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.md5);
        ((StringBuilder)localObject).append(".amr");
        localObject = ((StringBuilder)localObject).toString();
        localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
      localPtt.uint32_format.set(this.voiceType);
      localPtt.uint32_time.set(this.voiceLength);
      localPtt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
      if (this.groupFileKeyStr != null) {
        localPtt.bytes_group_file_key.set(ByteStringMicro.copyFromUtf8(this.groupFileKeyStr));
      }
      localObject = ((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).groupConstructPTTExtraInfo(this);
      localPtt.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = new im_msg_body.GeneralFlags();
      localResvAttr = new generalflags.ResvAttr();
      if (this.waveformArray != null)
      {
        localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).changeWaveformToPb(this.waveformArray)));
        ((im_msg_body.GeneralFlags)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
      }
      localElem.general_flags.set((MessageMicro)localObject);
    }
    localRichText.ptt.set(localPtt);
    localRichText.elems.add(localElem);
    return localRichText;
  }
  
  public AIOSttResult getSttResult()
  {
    try
    {
      if (this.sttResult == null) {
        this.sttResult = new AIOSttResult();
      }
      AIOSttResult localAIOSttResult = this.sttResult;
      return localAIOSttResult;
    }
    finally {}
  }
  
  public String getSummaryMsg()
  {
    return ((IMessageForPttInnerApi)QRoute.api(IMessageForPttInnerApi.class)).getSummaryMsg(this.sttText, this.sttAbility);
  }
  
  public boolean hasSttTxt()
  {
    return ((IMessageForPttInnerApi)QRoute.api(IMessageForPttInnerApi.class)).hasSttTxt(this.sttText, this.sttAbility);
  }
  
  public boolean isReady()
  {
    long l = this.fileSize;
    return (l > 0L) || (l == -3L) || (l == -1L);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    int j = this.versionCode;
    int i = 0;
    if (j < 3) {
      this.subVersion = 0;
    }
    Object localObject2 = new RichMsg.PttRec();
    PBStringField localPBStringField = ((RichMsg.PttRec)localObject2).localPath;
    String str = this.url;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    ((RichMsg.PttRec)localObject2).size.set(this.fileSize);
    ((RichMsg.PttRec)localObject2).type.set(this.itemType);
    ((RichMsg.PttRec)localObject2).isRead.set(this.isReadPtt);
    localPBStringField = ((RichMsg.PttRec)localObject2).uuid;
    str = this.urlAtServer;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localPBStringField = ((RichMsg.PttRec)localObject2).md5;
    str = this.md5;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localPBStringField = ((RichMsg.PttRec)localObject2).serverStorageSource;
    str = this.storageSource;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    ((RichMsg.PttRec)localObject2).version.set(this.subVersion);
    ((RichMsg.PttRec)localObject2).isReport.set(this.isReport);
    ((RichMsg.PttRec)localObject2).pttFlag.set(this.sttAbility);
    ((RichMsg.PttRec)localObject2).groupFileID.set(this.groupFileID);
    localPBStringField = ((RichMsg.PttRec)localObject2).sttText;
    str = this.sttText;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    ((RichMsg.PttRec)localObject2).longPttVipFlag.set(this.longPttVipFlag);
    ((RichMsg.PttRec)localObject2).expandStt.set(this.expandStt);
    if (this.groupFileKeyStr != null) {
      ((RichMsg.PttRec)localObject2).group_file_key.set(this.groupFileKeyStr);
    }
    ((RichMsg.PttRec)localObject2).msgTime.set(this.msgTime);
    ((RichMsg.PttRec)localObject2).msgRecTime.set(this.msgRecTime);
    ((RichMsg.PttRec)localObject2).voiceType.set(this.voiceType);
    ((RichMsg.PttRec)localObject2).voiceLength.set(Utils.a(this.voiceLength));
    ((RichMsg.PttRec)localObject2).voiceChangeFlag.set(this.voiceChangeFlag);
    ((RichMsg.PttRec)localObject2).busiType.set(this.busiType);
    ((RichMsg.PttRec)localObject2).directUrl.set(this.directUrl);
    ((RichMsg.PttRec)localObject2).fullLocalPath.set(this.fullLocalPath);
    ((RichMsg.PttRec)localObject2).extFlag.set(this.extFlag);
    ((RichMsg.PttRec)localObject2).redpack_type.set(this.voiceRedPacketFlag);
    ((RichMsg.PttRec)localObject2).autototext_voice.set(this.autoToText);
    try
    {
      this.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mRobotFlag);
    ((StringBuilder)localObject1).append("");
    saveExtInfoToExtStr("is_to_robot", ((StringBuilder)localObject1).toString());
    localObject1 = this.atInfo;
    if (localObject1 != null) {
      saveExtInfoToExtStr("at_robot_info", ((JSONArray)localObject1).toString());
    }
    localObject1 = this.waveformArray;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new JSONArray();
      localObject2 = this.waveformArray;
      j = localObject2.length;
      while (i < j)
      {
        ((JSONArray)localObject1).put(localObject2[i]);
        i += 1;
      }
      saveExtInfoToExtStr("wave_form", ((JSONArray)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPtt
 * JD-Core Version:    0.7.0.1
 */