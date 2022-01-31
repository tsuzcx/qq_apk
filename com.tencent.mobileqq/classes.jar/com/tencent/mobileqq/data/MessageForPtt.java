package com.tencent.mobileqq.data;

import acmt;
import ajjy;
import android.content.res.Resources;
import android.text.TextUtils;
import atnz;
import axpg;
import axqw;
import azzz;
import bach;
import baeh;
import baip;
import bech;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import localpb.richMsg.RichMsg.PttRec;
import org.json.JSONArray;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class MessageForPtt
  extends MessageForRichText
  implements acmt
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
  public static final int VOICE_CHANDE_YES = 1;
  public static final int VOICE_CHANGE_NO = 0;
  public JSONArray atInfo;
  public int autoToText;
  public int busiType;
  public boolean c2cViaOffline;
  public String directUrl = "";
  @atnz
  public long estimatedSize;
  public boolean expandStt = true;
  public long extFlag;
  public long fileSize;
  public String fullLocalPath = "";
  public long groupFileID;
  public String groupFileKeyStr;
  public boolean isReadPtt;
  public int isReport;
  @atnz
  public boolean isResend;
  public int itemType;
  public int longPttVipFlag;
  @atnz
  public String mInputContent;
  public String md5;
  public long msgRecTime = 0L;
  public long msgTime = 0L;
  public int msgVia;
  public float playProgress;
  @atnz
  public float playSpeedPos = MediaPlayerManager.a;
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
  public int[] waveformArray;
  
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
  
  public static String getTmpFilePath(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".slk"))
    {
      paramString = paramString.substring(0, paramString.length() - ".sik".length());
      str = paramString + ".tmp";
    }
    return str;
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
  
  /* Error */
  public void doParse()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: new 177	localpb/richMsg/RichMsg$PttRec
    //   8: dup
    //   9: invokespecial 178	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: aload_0
    //   17: getfield 182	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   20: invokevirtual 186	localpb/richMsg/RichMsg$PttRec:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   23: checkcast 177	localpb/richMsg/RichMsg$PttRec
    //   26: astore 8
    //   28: aload 8
    //   30: astore 7
    //   32: iconst_1
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq +791 -> 826
    //   38: aload_0
    //   39: aload 7
    //   41: getfield 190	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   44: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   47: putfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 201	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   56: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   59: putfield 207	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   62: aload_0
    //   63: aload 7
    //   65: getfield 211	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: putfield 217	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   74: aload_0
    //   75: aload 7
    //   77: getfield 221	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   80: invokevirtual 225	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   83: putfield 227	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   86: aload_0
    //   87: aload 7
    //   89: getfield 230	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   92: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   95: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   98: aload_0
    //   99: aload 7
    //   101: getfield 236	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   104: invokevirtual 239	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   107: putfield 83	com/tencent/mobileqq/data/MessageForPtt:sttAbility	I
    //   110: aload_0
    //   111: aload 7
    //   113: getfield 241	localpb/richMsg/RichMsg$PttRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: putfield 243	com/tencent/mobileqq/data/MessageForPtt:md5	Ljava/lang/String;
    //   122: aload_0
    //   123: aload 7
    //   125: getfield 246	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: putfield 248	com/tencent/mobileqq/data/MessageForPtt:storageSource	Ljava/lang/String;
    //   134: aload_0
    //   135: aload 7
    //   137: getfield 251	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   140: invokevirtual 239	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   143: putfield 85	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   146: aload_0
    //   147: aload 7
    //   149: getfield 253	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   152: invokevirtual 239	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   155: putfield 255	com/tencent/mobileqq/data/MessageForPtt:isReport	I
    //   158: aload_0
    //   159: aload 7
    //   161: getfield 257	localpb/richMsg/RichMsg$PttRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   164: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   167: putfield 259	com/tencent/mobileqq/data/MessageForPtt:groupFileID	J
    //   170: aload_0
    //   171: aload 7
    //   173: getfield 261	localpb/richMsg/RichMsg$PttRec:sttText	Lcom/tencent/mobileqq/pb/PBStringField;
    //   176: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   179: putfield 263	com/tencent/mobileqq/data/MessageForPtt:sttText	Ljava/lang/String;
    //   182: aload_0
    //   183: aload 7
    //   185: getfield 265	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   188: invokevirtual 239	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   191: putfield 267	com/tencent/mobileqq/data/MessageForPtt:longPttVipFlag	I
    //   194: aload 7
    //   196: getfield 269	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   199: invokevirtual 272	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   202: ifeq +13 -> 215
    //   205: aload 7
    //   207: getfield 269	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   210: invokevirtual 225	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   213: istore 4
    //   215: aload_0
    //   216: iload 4
    //   218: putfield 81	com/tencent/mobileqq/data/MessageForPtt:expandStt	Z
    //   221: aload 7
    //   223: getfield 275	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   226: invokevirtual 276	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   229: ifeq +15 -> 244
    //   232: aload_0
    //   233: aload 7
    //   235: getfield 275	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   238: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   241: putfield 278	com/tencent/mobileqq/data/MessageForPtt:groupFileKeyStr	Ljava/lang/String;
    //   244: aload 7
    //   246: getfield 280	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   249: invokevirtual 281	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   252: ifeq +1001 -> 1253
    //   255: aload 7
    //   257: getfield 280	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   260: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   263: lstore 5
    //   265: aload_0
    //   266: lload 5
    //   268: putfield 102	com/tencent/mobileqq/data/MessageForPtt:msgTime	J
    //   271: aload 7
    //   273: getfield 283	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   276: invokevirtual 281	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   279: ifeq +980 -> 1259
    //   282: aload 7
    //   284: getfield 283	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   287: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   290: lstore 5
    //   292: aload_0
    //   293: lload 5
    //   295: putfield 100	com/tencent/mobileqq/data/MessageForPtt:msgRecTime	J
    //   298: aload 7
    //   300: getfield 285	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   303: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   306: ifeq +959 -> 1265
    //   309: aload 7
    //   311: getfield 285	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   314: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   317: istore_1
    //   318: aload_0
    //   319: iload_1
    //   320: putfield 288	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   323: aload 7
    //   325: getfield 290	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   331: ifeq +939 -> 1270
    //   334: aload 7
    //   336: getfield 290	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   339: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   342: istore_1
    //   343: aload_0
    //   344: iload_1
    //   345: putfield 292	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   348: aload 7
    //   350: getfield 294	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   353: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   356: ifeq +919 -> 1275
    //   359: aload 7
    //   361: getfield 294	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   364: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   367: istore_1
    //   368: aload_0
    //   369: iload_1
    //   370: putfield 296	com/tencent/mobileqq/data/MessageForPtt:voiceChangeFlag	I
    //   373: aload 7
    //   375: getfield 298	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   378: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   381: ifeq +899 -> 1280
    //   384: aload 7
    //   386: getfield 298	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   389: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   392: istore_1
    //   393: aload_0
    //   394: iload_1
    //   395: putfield 300	com/tencent/mobileqq/data/MessageForPtt:busiType	I
    //   398: aload 7
    //   400: getfield 302	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   403: invokevirtual 276	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   406: ifeq +879 -> 1285
    //   409: aload 7
    //   411: getfield 302	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   414: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   417: astore 8
    //   419: aload_0
    //   420: aload 8
    //   422: putfield 89	com/tencent/mobileqq/data/MessageForPtt:directUrl	Ljava/lang/String;
    //   425: aload 7
    //   427: getfield 304	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   430: invokevirtual 276	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   433: ifeq +210 -> 643
    //   436: aload 7
    //   438: getfield 304	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: invokevirtual 195	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   444: astore 8
    //   446: aload_0
    //   447: aload 8
    //   449: putfield 91	com/tencent/mobileqq/data/MessageForPtt:fullLocalPath	Ljava/lang/String;
    //   452: aload 7
    //   454: getfield 306	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   457: invokevirtual 281	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   460: ifeq +190 -> 650
    //   463: aload 7
    //   465: getfield 306	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   468: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   471: lstore 5
    //   473: aload_0
    //   474: lload 5
    //   476: putfield 308	com/tencent/mobileqq/data/MessageForPtt:extFlag	J
    //   479: aload 7
    //   481: getfield 311	localpb/richMsg/RichMsg$PttRec:redpack_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   484: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   487: ifeq +171 -> 658
    //   490: aload 7
    //   492: getfield 311	localpb/richMsg/RichMsg$PttRec:redpack_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore_1
    //   499: aload_0
    //   500: iload_1
    //   501: putfield 313	com/tencent/mobileqq/data/MessageForPtt:voiceRedPacketFlag	I
    //   504: aload 7
    //   506: getfield 316	localpb/richMsg/RichMsg$PttRec:autototext_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   512: ifeq +151 -> 663
    //   515: aload 7
    //   517: getfield 316	localpb/richMsg/RichMsg$PttRec:autototext_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   520: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   523: istore_1
    //   524: aload_0
    //   525: iload_1
    //   526: putfield 318	com/tencent/mobileqq/data/MessageForPtt:autoToText	I
    //   529: aload_0
    //   530: getfield 322	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   533: ifnull +135 -> 668
    //   536: aload_0
    //   537: getfield 322	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   540: invokevirtual 327	java/util/ArrayList:isEmpty	()Z
    //   543: ifne +125 -> 668
    //   546: aload_0
    //   547: new 329	org/json/JSONArray
    //   550: dup
    //   551: invokespecial 330	org/json/JSONArray:<init>	()V
    //   554: putfield 332	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   557: aload_0
    //   558: getfield 322	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   561: invokevirtual 336	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   564: astore 7
    //   566: aload 7
    //   568: invokeinterface 341 1 0
    //   573: ifeq +127 -> 700
    //   576: aload 7
    //   578: invokeinterface 345 1 0
    //   583: checkcast 347	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   586: astore 8
    //   588: aload_0
    //   589: getfield 332	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   592: aload 8
    //   594: getfield 350	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:uin	J
    //   597: invokevirtual 354	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   600: pop
    //   601: goto -35 -> 566
    //   604: astore 7
    //   606: aload_0
    //   607: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   610: ifnonnull +15 -> 625
    //   613: aload_0
    //   614: ldc 87
    //   616: putfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   619: aload_0
    //   620: ldc 87
    //   622: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   625: aload 7
    //   627: invokevirtual 360	java/lang/Throwable:printStackTrace	()V
    //   630: return
    //   631: astore 8
    //   633: aload 8
    //   635: invokevirtual 361	java/lang/Exception:printStackTrace	()V
    //   638: iconst_0
    //   639: istore_1
    //   640: goto -606 -> 34
    //   643: ldc 87
    //   645: astore 8
    //   647: goto -201 -> 446
    //   650: ldc2_w 362
    //   653: lstore 5
    //   655: goto -182 -> 473
    //   658: iconst_0
    //   659: istore_1
    //   660: goto -161 -> 499
    //   663: iconst_0
    //   664: istore_1
    //   665: goto -141 -> 524
    //   668: aload_0
    //   669: aload_0
    //   670: ldc_w 365
    //   673: invokevirtual 368	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokestatic 374	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   679: putfield 377	com/tencent/mobileqq/data/MessageForPtt:mRobotFlag	I
    //   682: aload_0
    //   683: new 329	org/json/JSONArray
    //   686: dup
    //   687: aload_0
    //   688: ldc_w 379
    //   691: invokevirtual 368	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   694: invokespecial 382	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   697: putfield 332	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   700: aload_0
    //   701: ldc_w 384
    //   704: invokevirtual 368	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   707: astore 7
    //   709: aload 7
    //   711: ifnull +95 -> 806
    //   714: aload 7
    //   716: invokevirtual 117	java/lang/String:length	()I
    //   719: istore_1
    //   720: iload_1
    //   721: ifle +85 -> 806
    //   724: new 329	org/json/JSONArray
    //   727: dup
    //   728: aload 7
    //   730: invokespecial 382	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   733: astore 7
    //   735: aload 7
    //   737: invokevirtual 385	org/json/JSONArray:length	()I
    //   740: istore_3
    //   741: iload_3
    //   742: newarray int
    //   744: astore 8
    //   746: iload_2
    //   747: istore_1
    //   748: iload_1
    //   749: iload_3
    //   750: if_icmpge +30 -> 780
    //   753: aload 8
    //   755: iload_1
    //   756: aload 7
    //   758: iload_1
    //   759: invokevirtual 388	org/json/JSONArray:getInt	(I)I
    //   762: iastore
    //   763: iload_1
    //   764: iconst_1
    //   765: iadd
    //   766: istore_1
    //   767: goto -19 -> 748
    //   770: astore 7
    //   772: aload 7
    //   774: invokevirtual 361	java/lang/Exception:printStackTrace	()V
    //   777: goto -77 -> 700
    //   780: aload_0
    //   781: aload 8
    //   783: putfield 170	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   786: return
    //   787: astore 7
    //   789: aload_0
    //   790: invokevirtual 394	java/lang/Object:getClass	()Ljava/lang/Class;
    //   793: invokevirtual 399	java/lang/Class:getName	()Ljava/lang/String;
    //   796: iconst_2
    //   797: ldc_w 401
    //   800: aload 7
    //   802: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   805: return
    //   806: aload_0
    //   807: getfield 170	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   810: ifnull +11 -> 821
    //   813: aload_0
    //   814: getfield 170	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   817: arraylength
    //   818: ifne -188 -> 630
    //   821: aload_0
    //   822: invokevirtual 407	com/tencent/mobileqq/data/MessageForPtt:buileDefaultWaveform	()V
    //   825: return
    //   826: aload_0
    //   827: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   830: astore 7
    //   832: aload 7
    //   834: ifnonnull +28 -> 862
    //   837: aload_0
    //   838: getfield 410	com/tencent/mobileqq/data/MessageForPtt:versionCode	I
    //   841: ifle +21 -> 862
    //   844: aload_0
    //   845: new 109	java/lang/String
    //   848: dup
    //   849: aload_0
    //   850: getfield 182	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   853: ldc_w 412
    //   856: invokespecial 415	java/lang/String:<init>	([BLjava/lang/String;)V
    //   859: putfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   862: aload_0
    //   863: iconst_0
    //   864: putfield 85	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   867: aload_0
    //   868: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   871: ifnull +377 -> 1248
    //   874: aload_0
    //   875: getfield 418	com/tencent/mobileqq/data/MessageForPtt:msgtype	I
    //   878: sipush -1031
    //   881: if_icmpne +367 -> 1248
    //   884: aload_0
    //   885: aload_0
    //   886: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   889: invokestatic 423	baac:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   892: getfield 426	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   895: putfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   898: iconst_1
    //   899: istore_1
    //   900: aload_0
    //   901: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   904: ifnull +324 -> 1228
    //   907: aload_0
    //   908: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   911: invokevirtual 117	java/lang/String:length	()I
    //   914: ifle +314 -> 1228
    //   917: aload_0
    //   918: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   921: iconst_0
    //   922: invokevirtual 430	java/lang/String:charAt	(I)C
    //   925: bipush 22
    //   927: if_icmpne +301 -> 1228
    //   930: aload_0
    //   931: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   934: ldc_w 432
    //   937: invokevirtual 436	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   940: astore 7
    //   942: aload 7
    //   944: ifnull +284 -> 1228
    //   947: aload 7
    //   949: arraylength
    //   950: ifle +127 -> 1077
    //   953: aload_0
    //   954: aload 7
    //   956: iconst_0
    //   957: aaload
    //   958: invokevirtual 439	java/lang/String:trim	()Ljava/lang/String;
    //   961: putfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   964: iload_1
    //   965: ifeq +11 -> 976
    //   968: aload_0
    //   969: aload_0
    //   970: getfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   973: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   976: aload 7
    //   978: arraylength
    //   979: istore_1
    //   980: iload_1
    //   981: iconst_1
    //   982: if_icmple +17 -> 999
    //   985: aload_0
    //   986: aload 7
    //   988: iconst_1
    //   989: aaload
    //   990: invokestatic 445	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   993: invokevirtual 448	java/lang/Long:longValue	()J
    //   996: putfield 207	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   999: aload 7
    //   1001: arraylength
    //   1002: istore_1
    //   1003: iload_1
    //   1004: iconst_2
    //   1005: if_icmple +14 -> 1019
    //   1008: aload_0
    //   1009: aload 7
    //   1011: iconst_2
    //   1012: aaload
    //   1013: invokestatic 374	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1016: putfield 217	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   1019: aload 7
    //   1021: arraylength
    //   1022: iconst_3
    //   1023: if_icmple +197 -> 1220
    //   1026: aload 7
    //   1028: iconst_3
    //   1029: aaload
    //   1030: invokevirtual 439	java/lang/String:trim	()Ljava/lang/String;
    //   1033: invokestatic 451	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1036: invokevirtual 454	java/lang/Integer:intValue	()I
    //   1039: ifeq +253 -> 1292
    //   1042: iconst_1
    //   1043: istore 4
    //   1045: aload_0
    //   1046: iload 4
    //   1048: putfield 227	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   1051: aload 7
    //   1053: arraylength
    //   1054: iconst_4
    //   1055: if_icmple -425 -> 630
    //   1058: aload_0
    //   1059: aload 7
    //   1061: iconst_4
    //   1062: aaload
    //   1063: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1066: return
    //   1067: astore 7
    //   1069: aload 7
    //   1071: invokevirtual 361	java/lang/Exception:printStackTrace	()V
    //   1074: goto -212 -> 862
    //   1077: aload_0
    //   1078: ldc 87
    //   1080: putfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1083: iload_1
    //   1084: ifeq -108 -> 976
    //   1087: aload_0
    //   1088: aload_0
    //   1089: getfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1092: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1095: goto -119 -> 976
    //   1098: astore 8
    //   1100: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1103: ifeq -104 -> 999
    //   1106: aload_0
    //   1107: invokevirtual 394	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1110: invokevirtual 399	java/lang/Class:getName	()Ljava/lang/String;
    //   1113: iconst_2
    //   1114: new 123	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1121: ldc_w 456
    //   1124: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload 7
    //   1129: iconst_1
    //   1130: aaload
    //   1131: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: ldc_w 458
    //   1137: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload_0
    //   1141: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1144: invokestatic 462	azzz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1147: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: goto -157 -> 999
    //   1159: astore 8
    //   1161: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1164: ifeq -145 -> 1019
    //   1167: aload_0
    //   1168: invokevirtual 394	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1171: invokevirtual 399	java/lang/Class:getName	()Ljava/lang/String;
    //   1174: iconst_2
    //   1175: new 123	java/lang/StringBuilder
    //   1178: dup
    //   1179: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1182: ldc_w 464
    //   1185: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: aload 7
    //   1190: iconst_2
    //   1191: aaload
    //   1192: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: ldc_w 458
    //   1198: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: aload_0
    //   1202: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1205: invokestatic 462	azzz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1208: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1214: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1217: goto -198 -> 1019
    //   1220: aload_0
    //   1221: iconst_1
    //   1222: putfield 227	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   1225: goto -174 -> 1051
    //   1228: aload_0
    //   1229: getfield 357	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1232: ifnonnull -602 -> 630
    //   1235: aload_0
    //   1236: ldc 87
    //   1238: putfield 197	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1241: aload_0
    //   1242: ldc 87
    //   1244: putfield 232	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1247: return
    //   1248: iconst_0
    //   1249: istore_1
    //   1250: goto -350 -> 900
    //   1253: lconst_0
    //   1254: lstore 5
    //   1256: goto -991 -> 265
    //   1259: lconst_0
    //   1260: lstore 5
    //   1262: goto -970 -> 292
    //   1265: iconst_0
    //   1266: istore_1
    //   1267: goto -949 -> 318
    //   1270: iconst_0
    //   1271: istore_1
    //   1272: goto -929 -> 343
    //   1275: iconst_0
    //   1276: istore_1
    //   1277: goto -909 -> 368
    //   1280: iconst_0
    //   1281: istore_1
    //   1282: goto -889 -> 393
    //   1285: ldc 87
    //   1287: astore 8
    //   1289: goto -870 -> 419
    //   1292: iconst_0
    //   1293: istore 4
    //   1295: goto -250 -> 1045
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1298	0	this	MessageForPtt
    //   33	1249	1	i	int
    //   4	743	2	j	int
    //   740	11	3	k	int
    //   1	1293	4	bool	boolean
    //   263	998	5	l	long
    //   12	565	7	localObject1	Object
    //   604	22	7	localThrowable1	java.lang.Throwable
    //   707	50	7	localObject2	Object
    //   770	3	7	localException1	Exception
    //   787	14	7	localThrowable2	java.lang.Throwable
    //   830	230	7	localObject3	Object
    //   1067	122	7	localException2	Exception
    //   26	567	8	localObject4	Object
    //   631	3	8	localException3	Exception
    //   645	137	8	localObject5	Object
    //   1098	1	8	localException4	Exception
    //   1159	1	8	localException5	Exception
    //   1287	1	8	str	String
    // Exception table:
    //   from	to	target	type
    //   5	14	604	java/lang/Throwable
    //   14	28	604	java/lang/Throwable
    //   38	194	604	java/lang/Throwable
    //   194	215	604	java/lang/Throwable
    //   215	244	604	java/lang/Throwable
    //   244	265	604	java/lang/Throwable
    //   265	292	604	java/lang/Throwable
    //   292	318	604	java/lang/Throwable
    //   318	343	604	java/lang/Throwable
    //   343	368	604	java/lang/Throwable
    //   368	393	604	java/lang/Throwable
    //   393	419	604	java/lang/Throwable
    //   419	446	604	java/lang/Throwable
    //   446	473	604	java/lang/Throwable
    //   473	499	604	java/lang/Throwable
    //   499	524	604	java/lang/Throwable
    //   524	566	604	java/lang/Throwable
    //   566	601	604	java/lang/Throwable
    //   633	638	604	java/lang/Throwable
    //   668	700	604	java/lang/Throwable
    //   700	709	604	java/lang/Throwable
    //   714	720	604	java/lang/Throwable
    //   772	777	604	java/lang/Throwable
    //   789	805	604	java/lang/Throwable
    //   806	821	604	java/lang/Throwable
    //   821	825	604	java/lang/Throwable
    //   826	832	604	java/lang/Throwable
    //   837	862	604	java/lang/Throwable
    //   862	898	604	java/lang/Throwable
    //   900	942	604	java/lang/Throwable
    //   947	964	604	java/lang/Throwable
    //   968	976	604	java/lang/Throwable
    //   976	980	604	java/lang/Throwable
    //   985	999	604	java/lang/Throwable
    //   999	1003	604	java/lang/Throwable
    //   1008	1019	604	java/lang/Throwable
    //   1019	1042	604	java/lang/Throwable
    //   1045	1051	604	java/lang/Throwable
    //   1051	1066	604	java/lang/Throwable
    //   1069	1074	604	java/lang/Throwable
    //   1077	1083	604	java/lang/Throwable
    //   1087	1095	604	java/lang/Throwable
    //   1100	1156	604	java/lang/Throwable
    //   1161	1217	604	java/lang/Throwable
    //   1220	1225	604	java/lang/Throwable
    //   1228	1247	604	java/lang/Throwable
    //   14	28	631	java/lang/Exception
    //   668	700	770	java/lang/Exception
    //   724	746	787	java/lang/Throwable
    //   753	763	787	java/lang/Throwable
    //   780	786	787	java/lang/Throwable
    //   837	862	1067	java/lang/Exception
    //   985	999	1098	java/lang/Exception
    //   1008	1019	1159	java/lang/Exception
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
    if (TextUtils.isEmpty(this.md5)) {}
    try
    {
      this.md5 = bech.a(new File(getLocalFilePath()));
      serial();
      if ((this.istroop == 1) || (this.istroop == 3000))
      {
        localPtt.uint32_file_type.set(4);
        localPtt.uint32_file_id.set((int)this.groupFileID);
        localPtt.uint32_file_size.set((int)this.fileSize);
        localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(bach.a(this.md5)));
        localPtt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
        if (this.urlAtServer != null)
        {
          localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
          localPtt.uint32_format.set(this.voiceType);
          localPtt.uint32_time.set(this.voiceLength);
          localPtt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
          if (this.groupFileKeyStr != null) {
            localPtt.bytes_group_file_key.set(ByteStringMicro.copyFromUtf8(this.groupFileKeyStr));
          }
          Object localObject1 = axqw.a(this);
          localPtt.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject1));
          localObject1 = new im_msg_body.GeneralFlags();
          localResvAttr = new generalflags.ResvAttr();
          if (this.waveformArray != null)
          {
            localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(baeh.a(this.waveformArray).toByteArray()));
            ((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
          }
          localElem.general_flags.set((MessageMicro)localObject1);
          localRichText.ptt.set(localPtt);
          localRichText.elems.add(localElem);
          return localRichText;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        continue;
        Object localObject2 = this.md5 + ".amr";
        localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        continue;
        localObject2 = this.md5 + ".amr";
        localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        localPtt.uint32_file_type.set(4);
        localPtt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
        localPtt.uint32_file_size.set((int)this.fileSize);
        localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(bach.a(this.md5)));
        localObject2 = axpg.b(this);
        localPtt.bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
        localPtt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
        localObject2 = new im_msg_body.GeneralFlags();
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        if (this.waveformArray != null)
        {
          localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(baeh.a(this.waveformArray).toByteArray()));
          ((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
        }
        localElem.general_flags.set((MessageMicro)localObject2);
      }
    }
  }
  
  public String getSummaryMsg()
  {
    if (hasSttTxt()) {
      return BaseApplicationImpl.sApplication.getResources().getString(2131625722) + this.sttText;
    }
    return ajjy.a(2131640817);
  }
  
  public boolean hasSttTxt()
  {
    return (!baip.a(this.sttText)) && (!BaseApplicationImpl.sApplication.getResources().getString(2131653920).equals(this.sttText)) && (this.sttAbility != 3);
  }
  
  public boolean isReady()
  {
    return (this.fileSize > 0L) || (this.fileSize == -3L) || (this.fileSize == -1L);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    Object localObject2 = new RichMsg.PttRec();
    PBStringField localPBStringField = ((RichMsg.PttRec)localObject2).localPath;
    Object localObject1;
    if (this.url != null) {
      localObject1 = this.url;
    }
    for (;;)
    {
      localPBStringField.set((String)localObject1);
      ((RichMsg.PttRec)localObject2).size.set(this.fileSize);
      ((RichMsg.PttRec)localObject2).type.set(this.itemType);
      ((RichMsg.PttRec)localObject2).isRead.set(this.isReadPtt);
      localPBStringField = ((RichMsg.PttRec)localObject2).uuid;
      if (this.urlAtServer != null)
      {
        localObject1 = this.urlAtServer;
        label102:
        localPBStringField.set((String)localObject1);
        localPBStringField = ((RichMsg.PttRec)localObject2).md5;
        if (this.md5 == null) {
          break label537;
        }
        localObject1 = this.md5;
        label127:
        localPBStringField.set((String)localObject1);
        localPBStringField = ((RichMsg.PttRec)localObject2).serverStorageSource;
        if (this.storageSource == null) {
          break label543;
        }
        localObject1 = this.storageSource;
        label152:
        localPBStringField.set((String)localObject1);
        ((RichMsg.PttRec)localObject2).version.set(this.subVersion);
        ((RichMsg.PttRec)localObject2).isReport.set(this.isReport);
        ((RichMsg.PttRec)localObject2).pttFlag.set(this.sttAbility);
        ((RichMsg.PttRec)localObject2).groupFileID.set(this.groupFileID);
        localPBStringField = ((RichMsg.PttRec)localObject2).sttText;
        if (this.sttText == null) {
          break label549;
        }
        localObject1 = this.sttText;
        localPBStringField.set((String)localObject1);
        ((RichMsg.PttRec)localObject2).longPttVipFlag.set(this.longPttVipFlag);
        ((RichMsg.PttRec)localObject2).expandStt.set(this.expandStt);
        if (this.groupFileKeyStr != null) {
          ((RichMsg.PttRec)localObject2).group_file_key.set(this.groupFileKeyStr);
        }
        ((RichMsg.PttRec)localObject2).msgTime.set(this.msgTime);
        ((RichMsg.PttRec)localObject2).msgRecTime.set(this.msgRecTime);
        ((RichMsg.PttRec)localObject2).voiceType.set(this.voiceType);
        ((RichMsg.PttRec)localObject2).voiceLength.set(azzz.a(this.voiceLength));
        ((RichMsg.PttRec)localObject2).voiceChangeFlag.set(this.voiceChangeFlag);
        ((RichMsg.PttRec)localObject2).busiType.set(this.busiType);
        ((RichMsg.PttRec)localObject2).directUrl.set(this.directUrl);
        ((RichMsg.PttRec)localObject2).fullLocalPath.set(this.fullLocalPath);
        ((RichMsg.PttRec)localObject2).extFlag.set(this.extFlag);
        ((RichMsg.PttRec)localObject2).redpack_type.set(this.voiceRedPacketFlag);
        ((RichMsg.PttRec)localObject2).autototext_voice.set(this.autoToText);
      }
      try
      {
        this.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
        saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
        if (this.atInfo != null) {
          saveExtInfoToExtStr("at_robot_info", this.atInfo.toString());
        }
        if ((this.waveformArray != null) && (this.waveformArray.length > 0))
        {
          localObject1 = new JSONArray();
          localObject2 = this.waveformArray;
          int j = localObject2.length;
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              ((JSONArray)localObject1).put(localObject2[i]);
              i += 1;
              continue;
              localObject1 = "";
              break;
              localObject1 = "";
              break label102;
              label537:
              localObject1 = "";
              break label127;
              label543:
              localObject1 = "";
              break label152;
              label549:
              localObject1 = "";
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        saveExtInfoToExtStr("wave_form", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPtt
 * JD-Core Version:    0.7.0.1
 */