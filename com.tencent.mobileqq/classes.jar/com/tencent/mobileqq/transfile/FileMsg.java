package com.tencent.mobileqq.transfile;

import KQQFS.VerifyCode;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMsg
{
  public static final String DYNAMIC_EMO_EXT = "gif";
  public static final String FILE_PHOTO_DIR = "photo/";
  public static final String FILE_PTT_DIR = "ptt/";
  public static final int LOG_EVENT_FLOW_DOWN = 4;
  public static final int LOG_EVENT_FLOW_UP = 3;
  public static final int LOG_EVENT_RETRY = 2;
  public static final int LOG_EVENT_SERVER_EXIST = 5;
  public static final int LOG_EVENT_SIGNAL_SIG_FINISH = 0;
  public static final int LOG_EVENT_SIGNAL_URL_FINISH = 1;
  public static final long MAGIC_TIME = 612345L;
  public static final int RESULT_CODE_0X211_CCMSG_ERROR = 90460;
  public static final int RESULT_CODE_A9_NAME_NULL = 90451;
  public static final int RESULT_CODE_A9_OFLINE_UUID_NULL = 9081;
  public static final int RESULT_CODE_CONECTION_TIMEOUT = 4606;
  public static final int RESULT_CODE_DECODE_RESP_ERROR = 9045;
  public static final int RESULT_CODE_FAIL_BUT_NOT_SET_REASON = 9001;
  public static final int RESULT_CODE_FILEIO = 9003;
  public static final int RESULT_CODE_GETFILEMD5ERROR = 9041;
  public static final int RESULT_CODE_GROUP_REDIRECT_ERROR = 9011;
  public static final int RESULT_CODE_HTTPDECODE_EXCEPTION = 9023;
  public static final int RESULT_CODE_HTTP_SERVER_404_ERROR = 9024;
  public static final int RESULT_CODE_HTTP_SERVER_4XX_ERROR = 9060;
  public static final int RESULT_CODE_HTTP_SERVER_5XX_ERROR = 9061;
  public static final int RESULT_CODE_HTTP_SERVER_CONNECT_EXCEPTION = 9052;
  public static final int RESULT_CODE_HTTP_SERVER_NO_ROUTER = 9053;
  public static final int RESULT_CODE_HTTP_SERVER_OTHER = 9032;
  public static final int RESULT_CODE_HTTP_SERVER_PORT_UNREACH = 9054;
  public static final int RESULT_CODE_HTTP_SERVER_RANG_ERROR = 9009;
  public static final int RESULT_CODE_HTTP_SERVER_READ_TIME_OUT = 8;
  public static final int RESULT_CODE_HTTP_SERVER_SAFE_404_ERROR = 9035;
  public static final int RESULT_CODE_HTTP_SERVER_SOCKET_EXCEPTION = 9057;
  public static final int RESULT_CODE_MD5_COMPARE_ERROR = 9082;
  public static final int RESULT_CODE_MSF_TIMEOUT = 9043;
  public static final int RESULT_CODE_MSG_HANDLER_ERROR = 9006;
  public static final int RESULT_CODE_NO_NETWORK = 9004;
  public static final int RESULT_CODE_NO_SIG = 9008;
  public static final int RESULT_CODE_PARAM_ERROR = 9005;
  public static final int RESULT_CODE_RECV_LESS_THAN_EXPECTED = 9015;
  public static final int RESULT_CODE_SDCARDNOSPACE = 9040;
  public static final int RESULT_CODE_SENDFILENOTEXIST = 9042;
  public static final int RESULT_CODE_UNKONW_ERROR = 9001;
  public static final int RESULT_CODE_URL_FORM_EXCEPTION = 9048;
  public static final int RESULT_CODE_WY_OFLINE_UUID_NULL = 9080;
  public static final int RETRY_HTTP_FAIL = 1;
  public static final int RETRY_SIGNAL_FAIL = 0;
  public static final int RETRY_STREAM_OUT_OF_ORDER = 2;
  public static String RichTag = "richfile";
  public static final int STATUS_FILE_EXPIRED = 5002;
  public static final int STATUS_FILE_TRANSFERING = 5000;
  public static final int STATUS_FILE_UNEXSIT = 5003;
  public static final int STATUS_FILE_UNSAFE = 5001;
  public static final int STATUS_FORWARD_WAIT = 4001;
  public static final int STATUS_PAUSE = 1006;
  public static final int STATUS_PLAY_RECV_PROCESS_KILL = 2009;
  public static final int STATUS_PTT_VOICE_CHANGING = 7000;
  public static final int STATUS_RECV_CANCEL = 2004;
  public static final int STATUS_RECV_ERROR = 2005;
  public static final int STATUS_RECV_FINISHED = 2003;
  public static final int STATUS_RECV_PAUSE = 2007;
  public static final int STATUS_RECV_PREPARED = 2008;
  public static final int STATUS_RECV_PROCESS = 2002;
  public static final int STATUS_RECV_REQUEST = 2000;
  public static final int STATUS_RECV_SPACE_ERROR = 2006;
  public static final int STATUS_RECV_START = 2001;
  public static final int STATUS_SEND_AND_SAVE_FINISHED = 1008;
  public static final int STATUS_SEND_CANCEL = 1004;
  public static final int STATUS_SEND_COMPRESS = 998;
  public static final int STATUS_SEND_ERROR = 1005;
  public static final int STATUS_SEND_FINISHED = 1003;
  public static final int STATUS_SEND_PREPARE = 999;
  public static final int STATUS_SEND_PROCESS = 1002;
  public static final int STATUS_SEND_REQUEST = 1000;
  public static final int STATUS_SEND_START = 1001;
  public static final int STATUS_UPLOAD_FINISHED = 1007;
  public static final int STATUS_VERIFY_ERROR = 3002;
  public static final int STATUS_VERIFY_REQUIRE = 3000;
  public static final int STATUS_VERIFY_SUCCESS = 3001;
  public static final int TRANSFILE_TYPE_ASSISTANT = 327697;
  public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_BIG = 36;
  public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_MEDIUM = 37;
  public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_SMALL = 38;
  public static final int TRANSFILE_TYPE_BASE_STATIC_AVATAR = 48;
  public static final int TRANSFILE_TYPE_BDH_COMMON_UP = 24;
  public static final int TRANSFILE_TYPE_BULUO_AUDIO_SILK = 25;
  public static final int TRANSFILE_TYPE_C2B_UPLOAD_FILE = 34;
  public static final int TRANSFILE_TYPE_CIRCLE = 131077;
  public static final int TRANSFILE_TYPE_EXTEND_FRIEND_SOUND = 23;
  public static final int TRANSFILE_TYPE_FILE = 0;
  public static final int TRANSFILE_TYPE_FRESH_NEWS_PHOTO = 21;
  public static final int TRANSFILE_TYPE_FRIEND_AVATAR = 22;
  public static final int TRANSFILE_TYPE_HOMEWORK_AUDIO_SILK = 65;
  public static final int TRANSFILE_TYPE_JS_PTT = 32;
  public static final int TRANSFILE_TYPE_LIGHT_VIDEO = 327689;
  public static final int TRANSFILE_TYPE_MAP = 65536;
  public static final int TRANSFILE_TYPE_MULTIMSG = 131078;
  public static final int TRANSFILE_TYPE_NEARBY_ALUMNI = 131080;
  public static final int TRANSFILE_TYPE_NEARBY_AUTH_THUMB = 64;
  public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_BIG = 39;
  public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_MEDIUM = 40;
  public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_SMALL = 41;
  public static final int TRANSFILE_TYPE_NEARBY_PEOPLE_PHOTO_WALL = 8;
  public static final int TRANSFILE_TYPE_OCR = 57;
  public static final int TRANSFILE_TYPE_PA_AUDIO = 33;
  public static final int TRANSFILE_TYPE_PERSONALITY_LABEL_PHOTO_WALL = 56;
  public static final int TRANSFILE_TYPE_PIC = 1;
  public static final int TRANSFILE_TYPE_PIC_EMO = 65538;
  public static final int TRANSFILE_TYPE_PIC_THUMB = 65537;
  public static final int TRANSFILE_TYPE_PISMA = 49;
  public static final int TRANSFILE_TYPE_PROFILE_COVER = 35;
  public static final int TRANSFILE_TYPE_PTT = 2;
  public static final int TRANSFILE_TYPE_PTT_SLICE_TO_TEXT = 327696;
  public static final int TRANSFILE_TYPE_QQHEAD_PIC = 131074;
  public static final int TRANSFILE_TYPE_RAWPIC = 131075;
  public static final int TRANSFILE_TYPE_SCRIBBLE_DATA = 262153;
  public static final int TRANSFILE_TYPE_SHARE_PIC_TO_WX = 66;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_C2C = 6;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_DEVICE = 19;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_DISUSS = 17;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_FORWARD = 20;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_C2C = 7;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_DISUSS = 18;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_TROOP = 16;
  public static final int TRANSFILE_TYPE_SHORT_VIDEO_TROOP = 9;
  public static final int TRANSFILE_TYPE_SM_LONGMESSAGE = 131079;
  public static final int TRANSFILE_TYPE_STAR_PHOTO = 50;
  public static final int TRANSFILE_TYPE_STAR_PHOTO_THUMBNAIL = 51;
  public static final int TRANSFILE_TYPE_STORY_UGC_PIC = 196610;
  public static final int TRANSFILE_TYPE_STORY_UGC_VIDEO = 196609;
  public static final int TRANSFILE_TYPE_STRUCT_SHARE = 52;
  public static final int TRANSFILE_TYPE_THEME = 131072;
  public static final int TRANSFILE_TYPE_TRIBE_UGC_VIDEO = 327681;
  public static final int TRANSFILE_TYPE_TROOP_EFFECT_PIC = 55;
  public static final int TRANSFILE_TYPE_UFDOWNLOAD_FILE = 5;
  public static final int TRANSFILE_TYPE_URL = 131076;
  public static final int TRANSFILE_TYPE_VIDEO = 3;
  public static final int TRANSFILE_TYPE_VOICE_SEARCH_SILK = 53;
  public static final int TYPE_RECV = 1;
  public static final int TYPE_RECV_ONLINE = 2;
  public static final int TYPE_SEND = 0;
  public static final int UIN_BUDDY = 0;
  public static final int UIN_DISCUSS = 2;
  public static final int UIN_TROOP = 1;
  static String[] actionTagArr = { "up", "down", "down" };
  public static String defaultTag;
  static String[] fileTypeTagArray = { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
  private static String[] logDesc = { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
  public int actionType = -1;
  public long appShareID = 0L;
  public String appShareUrl = "";
  public byte[] bdhExtendInfo;
  public String bigDownUrl;
  public int commandId;
  public String compressUrl;
  public HttpMsg curRequest;
  private int currPofSendStream = 0;
  public String domain;
  public String downDomain;
  public long endTime;
  public int errorCode;
  public File file;
  public long fileID;
  public String fileKey = "";
  public String fileMd5;
  public String filePath = "";
  public long fileSize;
  public int fileType = -1;
  public String fileUrl;
  public String forwardTaskKey;
  public String friendUin;
  public int isRead;
  public boolean isStreamMode = false;
  public int lastStatus = -1;
  public byte[] localFileMd5;
  public String logTag = defaultTag;
  public long mSecMsgId;
  public long mSubMsgId;
  public String mUin;
  public String msgTime = "";
  public String orgiDownUrl;
  public String peerUin = "";
  public int picScale;
  public long picThumbSize;
  public BaseTransProcessor processor = null;
  public boolean processorDoReportSelf = false;
  public int pttSlicePos;
  public String pttSliceText;
  public OutputStream revStream = null;
  public String selfUin = "";
  public InputStream sendStream;
  public String serverPath;
  public long startTime;
  public int status = -1;
  public FileMsg.StepTransInfo stepMsgDirecDown = new FileMsg.StepTransInfo();
  public FileMsg.StepBaseInfo stepNotify = new FileMsg.StepBaseInfo();
  public FileMsg.StepBaseInfo stepSig = new FileMsg.StepBaseInfo();
  public FileMsg.StepTransInfo stepTrans = new FileMsg.StepTransInfo();
  public FileMsg.StepBaseInfo stepUrl = new FileMsg.StepBaseInfo();
  public long stepUrlCost;
  public String suffixType;
  public String thumbDownUrl;
  public String thumbPath = "";
  public String thumbUrl;
  public String tmpFilePath = "";
  public byte[] transferData;
  public long transferedSize;
  public String uKey;
  public int uinType = -1;
  public long uniseq;
  public String[] urls;
  public byte[] userInfo;
  public String uuidPath;
  public VerifyCode verifyCode;
  
  static
  {
    defaultTag = "defaultTag";
  }
  
  public FileMsg()
  {
    this.startTime = System.currentTimeMillis();
  }
  
  public FileMsg(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      this.startTime = System.currentTimeMillis();
      this.mUin = paramString1;
      this.actionType = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.filePath = paramString2;
        this.file = new File(this.filePath);
        if (this.file.exists())
        {
          this.fileSize = this.file.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.suffixType = paramString2.substring(paramInt).toLowerCase();
          }
        }
        openSendFile(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.serverPath = paramString2;
  }
  
  public static String getTransFileDateTime()
  {
    try
    {
      Thread.sleep(10L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l));
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
  
  private void openSendFile(String paramString)
  {
    this.sendStream = new FileInputStream(paramString);
  }
  
  public void closeInputStream()
  {
    try
    {
      if (this.sendStream != null) {
        this.sendStream.close();
      }
      label14:
      this.sendStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void closeOutputStream()
  {
    try
    {
      if (this.revStream != null) {
        this.revStream.close();
      }
      this.revStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("8pic", 2, "exception io FileMsg, " + localIOException.toString());
        }
        localIOException.printStackTrace();
      }
    }
  }
  
  public OutputStream getReceiveStream()
  {
    if (this.revStream == null) {}
    try
    {
      if (this.fileType == 0) {}
      for (this.revStream = new FileOutputStream(this.filePath, true);; this.revStream = new FileOutputStream(this.filePath)) {
        label30:
        return this.revStream;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label30;
    }
  }
  
  public byte[] getSendStreamSlice(int paramInt1, int paramInt2)
  {
    InputStream localInputStream = this.sendStream;
    this.transferData = new byte[paramInt2];
    if (paramInt1 == 0) {}
    for (;;)
    {
      try
      {
        localInputStream = resetSendStream();
        if (paramInt1 <= this.currPofSendStream) {
          continue;
        }
        localInputStream.skip(paramInt1 - this.currPofSendStream);
        this.currPofSendStream = paramInt1;
        localInputStream.read(this.transferData, 0, paramInt2);
        this.currPofSendStream += paramInt2;
      }
      catch (Exception localException)
      {
        this.transferData = null;
        continue;
      }
      return this.transferData;
      if (paramInt1 < this.currPofSendStream)
      {
        localInputStream = resetSendStream();
        localInputStream.skip(paramInt1);
      }
    }
  }
  
  public void logEvent(int paramInt1, int paramInt2)
  {
    FileMsg.StepTransInfo localStepTransInfo;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localStepTransInfo = this.stepTrans;
      localStepTransInfo.retryCount += 1;
      return;
    case 4: 
      localStepTransInfo = this.stepTrans;
      localStepTransInfo.flowDown += paramInt2;
      return;
    case 3: 
      localStepTransInfo = this.stepTrans;
      localStepTransInfo.flowUp += paramInt2;
      return;
    }
    this.stepTrans.serverExist = true;
  }
  
  public InputStream resetSendStream()
  {
    try
    {
      this.sendStream = new FileInputStream(this.filePath);
      return this.sendStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.sendStream = null;
      }
    }
  }
  
  public void setActionType(int paramInt)
  {
    this.actionType = paramInt;
  }
  
  public void setFileId(long paramLong)
  {
    this.uniseq = paramLong;
  }
  
  public void setFileKey(String paramString)
  {
    this.fileKey = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      try
      {
        this.filePath = paramString;
        this.file = new File(paramString);
        File localFile = this.file.getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        if ((this.actionType == 0) && (this.sendStream == null))
        {
          if (this.file.exists())
          {
            this.fileSize = this.file.length();
            if ((paramString != null) && (paramString.contains("."))) {
              this.suffixType = paramString.substring(paramString.lastIndexOf(".")).toLowerCase();
            }
          }
          this.sendStream = new FileInputStream(paramString);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.filePath = null;
        return;
      }
    } while (this.revStream != null);
    if (this.fileType == 0)
    {
      this.revStream = new FileOutputStream(paramString, true);
      return;
    }
    this.revStream = new FileOutputStream(paramString);
  }
  
  public void setFileType(int paramInt)
  {
    this.fileType = paramInt;
  }
  
  public void setFileUrl(String paramString)
  {
    this.fileUrl = paramString;
  }
  
  public void setPicScale(int paramInt)
  {
    this.picScale = paramInt;
  }
  
  public void setRcvStream(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.revStream == null) {
          if (this.fileType == 0)
          {
            this.revStream = new FileOutputStream(paramString, true);
            return;
          }
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.filePath = null;
        return;
      }
    }
    this.revStream = new FileOutputStream(paramString);
  }
  
  public void setServerPath(String paramString)
  {
    this.serverPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg
 * JD-Core Version:    0.7.0.1
 */