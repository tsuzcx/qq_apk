package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Media;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import localpb.richMsg.RichMsg.PttRec;
import org.json.JSONArray;

public class MessageForPtt
  extends MessageForRichText
  implements MediaPlayerManager.Media
{
  public static final int PTT_SIZE_ANIM_START = -2;
  public static final int PTT_SIZE_RECV_ERROR = -4;
  public static final int PTT_SIZE_SATUTS_ERROR = -1;
  public static final int PTT_SIZE_UI_SEND = -3;
  public static final int STT_ABLE = 1;
  public static final int STT_DONE = 2;
  public static final int STT_EMPTY = 0;
  public static final int VIPFLAG_NONE = 0;
  public static final int VIPFLAG_SVIP = 2;
  public static final int VIPFLAG_VIP = 1;
  public static final int VOICE_CHANDE_YES = 1;
  public static final int VOICE_CHANGE_NO = 0;
  public JSONArray atInfo;
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
  public String groupFileKeyStr;
  public boolean isReadPtt;
  public int isReport;
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
  public int sampleRate;
  public String storageSource;
  public int sttAbility = 0;
  public String sttText;
  public int subVersion = 5;
  public String timeStr;
  public String url;
  public String urlAtServer;
  public int voiceChangeFlag;
  public int voiceLength;
  public int voiceRedPacketFlag;
  public int voiceType;
  
  public static String getLocalFilePath(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.endsWith(".amr"))
      {
        paramString = paramString.substring(0, paramString.length() - ".amr".length());
        str = paramString + ".slk";
      }
    }
    return str;
  }
  
  public static String getMsgFilePath(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.endsWith(".slk"))
      {
        paramString = paramString.substring(0, paramString.length() - ".slk".length());
        str = paramString + ".amr";
      }
    }
    return str;
  }
  
  public void doParse()
  {
    boolean bool = true;
    int j = 0;
    int i;
    label33:
    long l;
    try
    {
      localObject1 = new RichMsg.PttRec();
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject3;
      label289:
      label315:
      label340:
      label365:
      if (this.msg == null)
      {
        this.url = "";
        this.urlAtServer = "";
      }
      label390:
      label416:
      label443:
      label470:
      localThrowable.printStackTrace();
    }
    try
    {
      localObject3 = (RichMsg.PttRec)((RichMsg.PttRec)localObject1).mergeFrom(this.msgData);
      localObject1 = localObject3;
      i = 1;
    }
    catch (Exception localException3)
    {
      label604:
      localException3.printStackTrace();
      i = 0;
      break label33;
      str1 = "";
      break label443;
      label624:
      l = -1L;
      break label470;
      try
      {
        label632:
        this.mRobotFlag = Integer.parseInt(getExtInfoFromExtStr("is_to_robot"));
        this.atInfo = new JSONArray(getExtInfoFromExtStr("at_robot_info"));
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      localObject2 = this.msg;
      if (localObject2 != null) {
        break label709;
      }
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
        bool = ((RichMsg.PttRec)localObject1).expandStt.get();
      }
      this.expandStt = bool;
      if (((RichMsg.PttRec)localObject1).group_file_key.has()) {
        this.groupFileKeyStr = ((RichMsg.PttRec)localObject1).group_file_key.get();
      }
      if (!((RichMsg.PttRec)localObject1).msgTime.has()) {
        break label1098;
      }
      l = ((RichMsg.PttRec)localObject1).msgTime.get();
      this.msgTime = l;
      if (!((RichMsg.PttRec)localObject1).msgRecTime.has()) {
        break label1104;
      }
      l = ((RichMsg.PttRec)localObject1).msgRecTime.get();
      this.msgRecTime = l;
      if (!((RichMsg.PttRec)localObject1).voiceType.has()) {
        break label1110;
      }
      i = ((RichMsg.PttRec)localObject1).voiceType.get();
      this.voiceType = i;
      if (!((RichMsg.PttRec)localObject1).voiceLength.has()) {
        break label1115;
      }
      i = ((RichMsg.PttRec)localObject1).voiceLength.get();
      this.voiceLength = i;
      if (!((RichMsg.PttRec)localObject1).voiceChangeFlag.has()) {
        break label1120;
      }
      i = ((RichMsg.PttRec)localObject1).voiceChangeFlag.get();
      this.voiceChangeFlag = i;
      if (!((RichMsg.PttRec)localObject1).busiType.has()) {
        break label1125;
      }
      i = ((RichMsg.PttRec)localObject1).busiType.get();
      this.busiType = i;
      if (!((RichMsg.PttRec)localObject1).directUrl.has()) {
        break label1130;
      }
      localObject3 = ((RichMsg.PttRec)localObject1).directUrl.get();
      this.directUrl = ((String)localObject3);
      if (((RichMsg.PttRec)localObject1).fullLocalPath.has())
      {
        localObject3 = ((RichMsg.PttRec)localObject1).fullLocalPath.get();
        this.fullLocalPath = ((String)localObject3);
        if (!((RichMsg.PttRec)localObject1).extFlag.has()) {
          break label624;
        }
        l = ((RichMsg.PttRec)localObject1).extFlag.get();
        this.extFlag = l;
        i = j;
        if (((RichMsg.PttRec)localObject1).redpack_type.has()) {
          i = ((RichMsg.PttRec)localObject1).redpack_type.get();
        }
        this.voiceRedPacketFlag = i;
        if ((this.atInfoList == null) || (this.atInfoList.isEmpty())) {
          break label632;
        }
        this.atInfo = new JSONArray();
        localObject1 = this.atInfoList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next();
          this.atInfo.put(((MessageForText.AtTroopMemberInfo)localObject3).uin);
        }
      }
    }
    for (;;)
    {
      try
      {
        String str1;
        if (this.versionCode > 0) {
          this.msg = new String(this.msgData, "UTF-8");
        }
        label709:
        this.subVersion = 0;
        if ((this.msg == null) || (this.msgtype != -1031)) {
          break label1093;
        }
        this.msg = ActionMsgUtil.a(this.msg).msg;
        i = 1;
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
        {
          localObject2 = this.msg.split("\\|");
          if (localObject2 != null) {
            if (localObject2.length > 0)
            {
              this.url = localObject2[0].trim();
              if (i != 0) {
                this.urlAtServer = this.url;
              }
              i = localObject2.length;
              if (i <= 1) {}
            }
          }
        }
      }
      catch (Exception localException4)
      {
        try
        {
          this.fileSize = Long.valueOf(localObject2[1]).longValue();
          i = localObject2.length;
          if (i <= 2) {}
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2;
            this.itemType = Integer.parseInt(localObject2[2]);
            if (localObject2.length > 3)
            {
              if (Integer.valueOf(localObject2[3].trim()).intValue() == 0) {
                break label1137;
              }
              bool = true;
              this.isReadPtt = bool;
              if (localObject2.length <= 4) {
                break label604;
              }
              this.urlAtServer = localObject2[4];
              return;
              localException2 = localException2;
              localException2.printStackTrace();
              continue;
              this.url = "";
              if (i == 0) {
                continue;
              }
              this.urlAtServer = this.url;
              continue;
              localException4 = localException4;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid long: " + localException2[1] + " msg byte " + Utils.a(this.msg));
            }
          }
          catch (Exception localException5)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid int: " + localException2[2] + " msg byte " + Utils.a(this.msg));
            continue;
            this.isReadPtt = true;
            continue;
          }
        }
      }
      if (this.msg != null) {
        break label604;
      }
      this.url = "";
      this.urlAtServer = "";
      return;
      label1093:
      i = 0;
      continue;
      label1098:
      l = 0L;
      break;
      label1104:
      l = 0L;
      break label289;
      label1110:
      i = 0;
      break label315;
      label1115:
      i = 0;
      break label340;
      label1120:
      i = 0;
      break label365;
      label1125:
      i = 0;
      break label390;
      label1130:
      String str2 = "";
      break label416;
      label1137:
      bool = false;
    }
  }
  
  public String getLocalFilePath()
  {
    return getLocalFilePath(this.voiceType, this.url);
  }
  
  public String getSummaryMsg()
  {
    return "[语音]";
  }
  
  public boolean isReady()
  {
    return (this.fileSize > 0L) || (this.fileSize == -3L) || (this.fileSize == -1L);
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
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    RichMsg.PttRec localPttRec = new RichMsg.PttRec();
    PBStringField localPBStringField = localPttRec.localPath;
    String str;
    if (this.url != null) {
      str = this.url;
    }
    for (;;)
    {
      localPBStringField.set(str);
      localPttRec.size.set(this.fileSize);
      localPttRec.type.set(this.itemType);
      localPttRec.isRead.set(this.isReadPtt);
      localPBStringField = localPttRec.uuid;
      if (this.urlAtServer != null)
      {
        str = this.urlAtServer;
        label93:
        localPBStringField.set(str);
        localPBStringField = localPttRec.md5;
        if (this.md5 == null) {
          break label433;
        }
        str = this.md5;
        label115:
        localPBStringField.set(str);
        localPBStringField = localPttRec.serverStorageSource;
        if (this.storageSource == null) {
          break label439;
        }
        str = this.storageSource;
        label137:
        localPBStringField.set(str);
        localPttRec.version.set(this.subVersion);
        localPttRec.isReport.set(this.isReport);
        localPttRec.pttFlag.set(this.sttAbility);
        localPttRec.groupFileID.set(this.groupFileID);
        localPBStringField = localPttRec.sttText;
        if (this.sttText == null) {
          break label445;
        }
        str = this.sttText;
        localPBStringField.set(str);
        localPttRec.longPttVipFlag.set(this.longPttVipFlag);
        localPttRec.expandStt.set(this.expandStt);
        if (this.groupFileKeyStr != null) {
          localPttRec.group_file_key.set(this.groupFileKeyStr);
        }
        localPttRec.msgTime.set(this.msgTime);
        localPttRec.msgRecTime.set(this.msgRecTime);
        localPttRec.voiceType.set(this.voiceType);
        localPttRec.voiceLength.set(Utils.a(this.voiceLength));
        localPttRec.voiceChangeFlag.set(this.voiceChangeFlag);
        localPttRec.busiType.set(this.busiType);
        localPttRec.directUrl.set(this.directUrl);
        localPttRec.fullLocalPath.set(this.fullLocalPath);
        localPttRec.extFlag.set(this.extFlag);
        localPttRec.redpack_type.set(this.voiceRedPacketFlag);
      }
      try
      {
        this.msgData = localPttRec.toByteArray();
        saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
        if (this.atInfo != null) {
          saveExtInfoToExtStr("at_robot_info", this.atInfo.toString());
        }
        return;
        str = "";
        continue;
        str = "";
        break label93;
        label433:
        str = "";
        break label115;
        label439:
        str = "";
        break label137;
        label445:
        str = "";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPtt
 * JD-Core Version:    0.7.0.1
 */