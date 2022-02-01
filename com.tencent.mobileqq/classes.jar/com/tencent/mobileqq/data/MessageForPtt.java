package com.tencent.mobileqq.data;

import afzo;
import android.content.res.Resources;
import android.text.TextUtils;
import anni;
import bdtl;
import bdvf;
import bedk;
import bgjw;
import bgmj;
import bgog;
import bgsp;
import bkcx;
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
import com.tencent.mobileqq.persistence.notColumn;
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
  implements afzo
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
  public float playProgress;
  @notColumn
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
    return bedk.a(str, true);
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
    //   5: new 182	localpb/richMsg/RichMsg$PttRec
    //   8: dup
    //   9: invokespecial 183	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: aload_0
    //   17: getfield 187	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   20: invokevirtual 191	localpb/richMsg/RichMsg$PttRec:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   23: checkcast 182	localpb/richMsg/RichMsg$PttRec
    //   26: astore 8
    //   28: aload 8
    //   30: astore 7
    //   32: iconst_1
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq +815 -> 850
    //   38: aload_0
    //   39: aload 7
    //   41: getfield 195	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   44: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   47: putfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 206	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   56: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   59: putfield 212	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   62: aload_0
    //   63: aload 7
    //   65: getfield 216	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: putfield 222	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   74: aload_0
    //   75: aload 7
    //   77: getfield 226	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   80: invokevirtual 230	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   83: putfield 232	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   86: aload_0
    //   87: aload 7
    //   89: getfield 235	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   92: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   95: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   98: aload_0
    //   99: aload 7
    //   101: getfield 241	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   104: invokevirtual 244	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   107: putfield 83	com/tencent/mobileqq/data/MessageForPtt:sttAbility	I
    //   110: aload_0
    //   111: aload 7
    //   113: getfield 246	localpb/richMsg/RichMsg$PttRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: putfield 248	com/tencent/mobileqq/data/MessageForPtt:md5	Ljava/lang/String;
    //   122: aload_0
    //   123: aload 7
    //   125: getfield 251	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: putfield 253	com/tencent/mobileqq/data/MessageForPtt:storageSource	Ljava/lang/String;
    //   134: aload_0
    //   135: aload 7
    //   137: getfield 256	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   140: invokevirtual 244	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   143: putfield 85	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   146: aload_0
    //   147: aload 7
    //   149: getfield 258	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   152: invokevirtual 244	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   155: putfield 260	com/tencent/mobileqq/data/MessageForPtt:isReport	I
    //   158: aload_0
    //   159: aload 7
    //   161: getfield 262	localpb/richMsg/RichMsg$PttRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   164: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   167: putfield 264	com/tencent/mobileqq/data/MessageForPtt:groupFileID	J
    //   170: aload_0
    //   171: aload 7
    //   173: getfield 266	localpb/richMsg/RichMsg$PttRec:sttText	Lcom/tencent/mobileqq/pb/PBStringField;
    //   176: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   179: putfield 268	com/tencent/mobileqq/data/MessageForPtt:sttText	Ljava/lang/String;
    //   182: aload_0
    //   183: aload 7
    //   185: getfield 270	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   188: invokevirtual 244	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   191: putfield 272	com/tencent/mobileqq/data/MessageForPtt:longPttVipFlag	I
    //   194: aload 7
    //   196: getfield 274	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   199: invokevirtual 277	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   202: ifeq +13 -> 215
    //   205: aload 7
    //   207: getfield 274	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   210: invokevirtual 230	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   213: istore 4
    //   215: aload_0
    //   216: iload 4
    //   218: putfield 81	com/tencent/mobileqq/data/MessageForPtt:expandStt	Z
    //   221: aload 7
    //   223: getfield 280	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   226: invokevirtual 281	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   229: ifeq +15 -> 244
    //   232: aload_0
    //   233: aload 7
    //   235: getfield 280	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   238: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   241: putfield 283	com/tencent/mobileqq/data/MessageForPtt:groupFileKeyStr	Ljava/lang/String;
    //   244: aload 7
    //   246: getfield 285	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   249: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   252: ifeq +1025 -> 1277
    //   255: aload 7
    //   257: getfield 285	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   260: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   263: lstore 5
    //   265: aload_0
    //   266: lload 5
    //   268: putfield 102	com/tencent/mobileqq/data/MessageForPtt:msgTime	J
    //   271: aload 7
    //   273: getfield 288	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   276: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   279: ifeq +1004 -> 1283
    //   282: aload 7
    //   284: getfield 288	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   287: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   290: lstore 5
    //   292: aload_0
    //   293: lload 5
    //   295: putfield 100	com/tencent/mobileqq/data/MessageForPtt:msgRecTime	J
    //   298: aload 7
    //   300: getfield 290	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   303: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   306: ifeq +983 -> 1289
    //   309: aload 7
    //   311: getfield 290	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   314: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   317: istore_1
    //   318: aload_0
    //   319: iload_1
    //   320: putfield 293	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   323: aload 7
    //   325: getfield 295	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   331: ifeq +963 -> 1294
    //   334: aload 7
    //   336: getfield 295	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   339: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   342: istore_1
    //   343: aload_0
    //   344: iload_1
    //   345: putfield 297	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   348: aload 7
    //   350: getfield 299	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   353: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   356: ifeq +943 -> 1299
    //   359: aload 7
    //   361: getfield 299	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   364: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   367: istore_1
    //   368: aload_0
    //   369: iload_1
    //   370: putfield 301	com/tencent/mobileqq/data/MessageForPtt:voiceChangeFlag	I
    //   373: aload 7
    //   375: getfield 303	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   378: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   381: ifeq +923 -> 1304
    //   384: aload 7
    //   386: getfield 303	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   389: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   392: istore_1
    //   393: aload_0
    //   394: iload_1
    //   395: putfield 305	com/tencent/mobileqq/data/MessageForPtt:busiType	I
    //   398: aload 7
    //   400: getfield 307	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   403: invokevirtual 281	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   406: ifeq +903 -> 1309
    //   409: aload 7
    //   411: getfield 307	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   414: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   417: astore 8
    //   419: aload_0
    //   420: aload 8
    //   422: putfield 89	com/tencent/mobileqq/data/MessageForPtt:directUrl	Ljava/lang/String;
    //   425: aload 7
    //   427: getfield 309	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   430: invokevirtual 281	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   433: ifeq +210 -> 643
    //   436: aload 7
    //   438: getfield 309	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: invokevirtual 200	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   444: astore 8
    //   446: aload_0
    //   447: aload 8
    //   449: putfield 91	com/tencent/mobileqq/data/MessageForPtt:fullLocalPath	Ljava/lang/String;
    //   452: aload 7
    //   454: getfield 311	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   457: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   460: ifeq +190 -> 650
    //   463: aload 7
    //   465: getfield 311	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   468: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   471: lstore 5
    //   473: aload_0
    //   474: lload 5
    //   476: putfield 313	com/tencent/mobileqq/data/MessageForPtt:extFlag	J
    //   479: aload 7
    //   481: getfield 316	localpb/richMsg/RichMsg$PttRec:redpack_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   484: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   487: ifeq +171 -> 658
    //   490: aload 7
    //   492: getfield 316	localpb/richMsg/RichMsg$PttRec:redpack_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore_1
    //   499: aload_0
    //   500: iload_1
    //   501: putfield 318	com/tencent/mobileqq/data/MessageForPtt:voiceRedPacketFlag	I
    //   504: aload 7
    //   506: getfield 321	localpb/richMsg/RichMsg$PttRec:autototext_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   512: ifeq +151 -> 663
    //   515: aload 7
    //   517: getfield 321	localpb/richMsg/RichMsg$PttRec:autototext_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   520: invokevirtual 220	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   523: istore_1
    //   524: aload_0
    //   525: iload_1
    //   526: putfield 323	com/tencent/mobileqq/data/MessageForPtt:autoToText	I
    //   529: aload_0
    //   530: getfield 327	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   533: ifnull +135 -> 668
    //   536: aload_0
    //   537: getfield 327	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   540: invokevirtual 332	java/util/ArrayList:isEmpty	()Z
    //   543: ifne +125 -> 668
    //   546: aload_0
    //   547: new 334	org/json/JSONArray
    //   550: dup
    //   551: invokespecial 335	org/json/JSONArray:<init>	()V
    //   554: putfield 337	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   557: aload_0
    //   558: getfield 327	com/tencent/mobileqq/data/MessageForPtt:atInfoList	Ljava/util/ArrayList;
    //   561: invokevirtual 341	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   564: astore 7
    //   566: aload 7
    //   568: invokeinterface 346 1 0
    //   573: ifeq +151 -> 724
    //   576: aload 7
    //   578: invokeinterface 350 1 0
    //   583: checkcast 352	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   586: astore 8
    //   588: aload_0
    //   589: getfield 337	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   592: aload 8
    //   594: getfield 355	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:uin	J
    //   597: invokevirtual 359	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   600: pop
    //   601: goto -35 -> 566
    //   604: astore 7
    //   606: aload_0
    //   607: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   610: ifnonnull +15 -> 625
    //   613: aload_0
    //   614: ldc 87
    //   616: putfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   619: aload_0
    //   620: ldc 87
    //   622: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   625: aload 7
    //   627: invokevirtual 365	java/lang/Throwable:printStackTrace	()V
    //   630: return
    //   631: astore 8
    //   633: aload 8
    //   635: invokevirtual 366	java/lang/Exception:printStackTrace	()V
    //   638: iconst_0
    //   639: istore_1
    //   640: goto -606 -> 34
    //   643: ldc 87
    //   645: astore 8
    //   647: goto -201 -> 446
    //   650: ldc2_w 367
    //   653: lstore 5
    //   655: goto -182 -> 473
    //   658: iconst_0
    //   659: istore_1
    //   660: goto -161 -> 499
    //   663: iconst_0
    //   664: istore_1
    //   665: goto -141 -> 524
    //   668: aload_0
    //   669: ldc_w 370
    //   672: invokevirtual 373	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 7
    //   677: aload 7
    //   679: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   682: ifne +12 -> 694
    //   685: aload_0
    //   686: aload 7
    //   688: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   691: putfield 387	com/tencent/mobileqq/data/MessageForPtt:mRobotFlag	I
    //   694: aload_0
    //   695: ldc_w 389
    //   698: invokevirtual 373	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   701: astore 7
    //   703: aload 7
    //   705: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   708: ifne +16 -> 724
    //   711: aload_0
    //   712: new 334	org/json/JSONArray
    //   715: dup
    //   716: aload 7
    //   718: invokespecial 392	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   721: putfield 337	com/tencent/mobileqq/data/MessageForPtt:atInfo	Lorg/json/JSONArray;
    //   724: aload_0
    //   725: ldc_w 394
    //   728: invokevirtual 373	com/tencent/mobileqq/data/MessageForPtt:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   731: astore 7
    //   733: aload 7
    //   735: ifnull +95 -> 830
    //   738: aload 7
    //   740: invokevirtual 117	java/lang/String:length	()I
    //   743: istore_1
    //   744: iload_1
    //   745: ifle +85 -> 830
    //   748: new 334	org/json/JSONArray
    //   751: dup
    //   752: aload 7
    //   754: invokespecial 392	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   757: astore 7
    //   759: aload 7
    //   761: invokevirtual 395	org/json/JSONArray:length	()I
    //   764: istore_3
    //   765: iload_3
    //   766: newarray int
    //   768: astore 8
    //   770: iload_2
    //   771: istore_1
    //   772: iload_1
    //   773: iload_3
    //   774: if_icmpge +30 -> 804
    //   777: aload 8
    //   779: iload_1
    //   780: aload 7
    //   782: iload_1
    //   783: invokevirtual 398	org/json/JSONArray:getInt	(I)I
    //   786: iastore
    //   787: iload_1
    //   788: iconst_1
    //   789: iadd
    //   790: istore_1
    //   791: goto -19 -> 772
    //   794: astore 7
    //   796: aload 7
    //   798: invokevirtual 366	java/lang/Exception:printStackTrace	()V
    //   801: goto -77 -> 724
    //   804: aload_0
    //   805: aload 8
    //   807: putfield 175	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   810: return
    //   811: astore 7
    //   813: aload_0
    //   814: invokevirtual 404	java/lang/Object:getClass	()Ljava/lang/Class;
    //   817: invokevirtual 409	java/lang/Class:getName	()Ljava/lang/String;
    //   820: iconst_2
    //   821: ldc_w 411
    //   824: aload 7
    //   826: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aload_0
    //   831: getfield 175	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   834: ifnull +11 -> 845
    //   837: aload_0
    //   838: getfield 175	com/tencent/mobileqq/data/MessageForPtt:waveformArray	[I
    //   841: arraylength
    //   842: ifne -212 -> 630
    //   845: aload_0
    //   846: invokevirtual 417	com/tencent/mobileqq/data/MessageForPtt:buileDefaultWaveform	()V
    //   849: return
    //   850: aload_0
    //   851: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   854: astore 7
    //   856: aload 7
    //   858: ifnonnull +28 -> 886
    //   861: aload_0
    //   862: getfield 420	com/tencent/mobileqq/data/MessageForPtt:versionCode	I
    //   865: ifle +21 -> 886
    //   868: aload_0
    //   869: new 109	java/lang/String
    //   872: dup
    //   873: aload_0
    //   874: getfield 187	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   877: ldc_w 422
    //   880: invokespecial 425	java/lang/String:<init>	([BLjava/lang/String;)V
    //   883: putfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   886: aload_0
    //   887: iconst_0
    //   888: putfield 85	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   891: aload_0
    //   892: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   895: ifnull +377 -> 1272
    //   898: aload_0
    //   899: getfield 428	com/tencent/mobileqq/data/MessageForPtt:msgtype	I
    //   902: sipush -1031
    //   905: if_icmpne +367 -> 1272
    //   908: aload_0
    //   909: aload_0
    //   910: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   913: invokestatic 433	bgjz:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   916: getfield 436	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   919: putfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   922: iconst_1
    //   923: istore_1
    //   924: aload_0
    //   925: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   928: ifnull +324 -> 1252
    //   931: aload_0
    //   932: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   935: invokevirtual 117	java/lang/String:length	()I
    //   938: ifle +314 -> 1252
    //   941: aload_0
    //   942: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   945: iconst_0
    //   946: invokevirtual 440	java/lang/String:charAt	(I)C
    //   949: bipush 22
    //   951: if_icmpne +301 -> 1252
    //   954: aload_0
    //   955: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   958: ldc_w 442
    //   961: invokevirtual 446	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   964: astore 7
    //   966: aload 7
    //   968: ifnull +284 -> 1252
    //   971: aload 7
    //   973: arraylength
    //   974: ifle +127 -> 1101
    //   977: aload_0
    //   978: aload 7
    //   980: iconst_0
    //   981: aaload
    //   982: invokevirtual 449	java/lang/String:trim	()Ljava/lang/String;
    //   985: putfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   988: iload_1
    //   989: ifeq +11 -> 1000
    //   992: aload_0
    //   993: aload_0
    //   994: getfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   997: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1000: aload 7
    //   1002: arraylength
    //   1003: istore_1
    //   1004: iload_1
    //   1005: iconst_1
    //   1006: if_icmple +17 -> 1023
    //   1009: aload_0
    //   1010: aload 7
    //   1012: iconst_1
    //   1013: aaload
    //   1014: invokestatic 455	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1017: invokevirtual 458	java/lang/Long:longValue	()J
    //   1020: putfield 212	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1023: aload 7
    //   1025: arraylength
    //   1026: istore_1
    //   1027: iload_1
    //   1028: iconst_2
    //   1029: if_icmple +14 -> 1043
    //   1032: aload_0
    //   1033: aload 7
    //   1035: iconst_2
    //   1036: aaload
    //   1037: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1040: putfield 222	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   1043: aload 7
    //   1045: arraylength
    //   1046: iconst_3
    //   1047: if_icmple +197 -> 1244
    //   1050: aload 7
    //   1052: iconst_3
    //   1053: aaload
    //   1054: invokevirtual 449	java/lang/String:trim	()Ljava/lang/String;
    //   1057: invokestatic 461	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1060: invokevirtual 464	java/lang/Integer:intValue	()I
    //   1063: ifeq +253 -> 1316
    //   1066: iconst_1
    //   1067: istore 4
    //   1069: aload_0
    //   1070: iload 4
    //   1072: putfield 232	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   1075: aload 7
    //   1077: arraylength
    //   1078: iconst_4
    //   1079: if_icmple -449 -> 630
    //   1082: aload_0
    //   1083: aload 7
    //   1085: iconst_4
    //   1086: aaload
    //   1087: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1090: return
    //   1091: astore 7
    //   1093: aload 7
    //   1095: invokevirtual 366	java/lang/Exception:printStackTrace	()V
    //   1098: goto -212 -> 886
    //   1101: aload_0
    //   1102: ldc 87
    //   1104: putfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1107: iload_1
    //   1108: ifeq -108 -> 1000
    //   1111: aload_0
    //   1112: aload_0
    //   1113: getfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1116: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1119: goto -119 -> 1000
    //   1122: astore 8
    //   1124: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq -104 -> 1023
    //   1130: aload_0
    //   1131: invokevirtual 404	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1134: invokevirtual 409	java/lang/Class:getName	()Ljava/lang/String;
    //   1137: iconst_2
    //   1138: new 123	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1145: ldc_w 466
    //   1148: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: aload 7
    //   1153: iconst_1
    //   1154: aaload
    //   1155: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: ldc_w 468
    //   1161: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: aload_0
    //   1165: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1168: invokestatic 472	bgjw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: goto -157 -> 1023
    //   1183: astore 8
    //   1185: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1188: ifeq -145 -> 1043
    //   1191: aload_0
    //   1192: invokevirtual 404	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1195: invokevirtual 409	java/lang/Class:getName	()Ljava/lang/String;
    //   1198: iconst_2
    //   1199: new 123	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 474
    //   1209: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload 7
    //   1214: iconst_2
    //   1215: aaload
    //   1216: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: ldc_w 468
    //   1222: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: aload_0
    //   1226: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1229: invokestatic 472	bgjw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1241: goto -198 -> 1043
    //   1244: aload_0
    //   1245: iconst_1
    //   1246: putfield 232	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   1249: goto -174 -> 1075
    //   1252: aload_0
    //   1253: getfield 362	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   1256: ifnonnull -626 -> 630
    //   1259: aload_0
    //   1260: ldc 87
    //   1262: putfield 202	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1265: aload_0
    //   1266: ldc 87
    //   1268: putfield 237	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   1271: return
    //   1272: iconst_0
    //   1273: istore_1
    //   1274: goto -350 -> 924
    //   1277: lconst_0
    //   1278: lstore 5
    //   1280: goto -1015 -> 265
    //   1283: lconst_0
    //   1284: lstore 5
    //   1286: goto -994 -> 292
    //   1289: iconst_0
    //   1290: istore_1
    //   1291: goto -973 -> 318
    //   1294: iconst_0
    //   1295: istore_1
    //   1296: goto -953 -> 343
    //   1299: iconst_0
    //   1300: istore_1
    //   1301: goto -933 -> 368
    //   1304: iconst_0
    //   1305: istore_1
    //   1306: goto -913 -> 393
    //   1309: ldc 87
    //   1311: astore 8
    //   1313: goto -894 -> 419
    //   1316: iconst_0
    //   1317: istore 4
    //   1319: goto -250 -> 1069
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1322	0	this	MessageForPtt
    //   33	1273	1	i	int
    //   4	767	2	j	int
    //   764	11	3	k	int
    //   1	1317	4	bool	boolean
    //   263	1022	5	l	long
    //   12	565	7	localObject1	Object
    //   604	22	7	localThrowable1	java.lang.Throwable
    //   675	106	7	localObject2	Object
    //   794	3	7	localException1	Exception
    //   811	14	7	localThrowable2	java.lang.Throwable
    //   854	230	7	localObject3	Object
    //   1091	122	7	localException2	Exception
    //   26	567	8	localObject4	Object
    //   631	3	8	localException3	Exception
    //   645	161	8	localObject5	Object
    //   1122	1	8	localException4	Exception
    //   1183	1	8	localException5	Exception
    //   1311	1	8	str	String
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
    //   668	694	604	java/lang/Throwable
    //   694	724	604	java/lang/Throwable
    //   724	733	604	java/lang/Throwable
    //   738	744	604	java/lang/Throwable
    //   796	801	604	java/lang/Throwable
    //   813	829	604	java/lang/Throwable
    //   830	845	604	java/lang/Throwable
    //   845	849	604	java/lang/Throwable
    //   850	856	604	java/lang/Throwable
    //   861	886	604	java/lang/Throwable
    //   886	922	604	java/lang/Throwable
    //   924	966	604	java/lang/Throwable
    //   971	988	604	java/lang/Throwable
    //   992	1000	604	java/lang/Throwable
    //   1000	1004	604	java/lang/Throwable
    //   1009	1023	604	java/lang/Throwable
    //   1023	1027	604	java/lang/Throwable
    //   1032	1043	604	java/lang/Throwable
    //   1043	1066	604	java/lang/Throwable
    //   1069	1075	604	java/lang/Throwable
    //   1075	1090	604	java/lang/Throwable
    //   1093	1098	604	java/lang/Throwable
    //   1101	1107	604	java/lang/Throwable
    //   1111	1119	604	java/lang/Throwable
    //   1124	1180	604	java/lang/Throwable
    //   1185	1241	604	java/lang/Throwable
    //   1244	1249	604	java/lang/Throwable
    //   1252	1271	604	java/lang/Throwable
    //   14	28	631	java/lang/Exception
    //   668	694	794	java/lang/Exception
    //   694	724	794	java/lang/Exception
    //   748	770	811	java/lang/Throwable
    //   777	787	811	java/lang/Throwable
    //   804	810	811	java/lang/Throwable
    //   861	886	1091	java/lang/Exception
    //   1009	1023	1122	java/lang/Exception
    //   1032	1043	1183	java/lang/Exception
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
      this.md5 = bkcx.a(new File(getLocalFilePath()));
      serial();
      if ((this.istroop == 1) || (this.istroop == 3000))
      {
        localPtt.uint32_file_type.set(4);
        localPtt.uint32_file_id.set((int)this.groupFileID);
        localPtt.uint32_file_size.set((int)this.fileSize);
        localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(bgmj.a(this.md5)));
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
          Object localObject1 = bdvf.a(this);
          localPtt.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject1));
          localObject1 = new im_msg_body.GeneralFlags();
          localResvAttr = new generalflags.ResvAttr();
          if (this.waveformArray != null)
          {
            localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(bgog.a(this.waveformArray).toByteArray()));
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
        localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(bgmj.a(this.md5)));
        localObject2 = bdtl.b(this);
        localPtt.bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
        localPtt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
        localObject2 = new im_msg_body.GeneralFlags();
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        if (this.waveformArray != null)
        {
          localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(bgog.a(this.waveformArray).toByteArray()));
          ((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
        }
        localElem.general_flags.set((MessageMicro)localObject2);
      }
    }
  }
  
  public String getSummaryMsg()
  {
    if (hasSttTxt()) {
      return BaseApplicationImpl.sApplication.getResources().getString(2131691134) + this.sttText;
    }
    return anni.a(2131705388);
  }
  
  public boolean hasSttTxt()
  {
    return (!bgsp.a(this.sttText)) && (!BaseApplicationImpl.sApplication.getResources().getString(2131718241).equals(this.sttText)) && (this.sttAbility != 3);
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
        ((RichMsg.PttRec)localObject2).voiceLength.set(bgjw.a(this.voiceLength));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPtt
 * JD-Core Version:    0.7.0.1
 */