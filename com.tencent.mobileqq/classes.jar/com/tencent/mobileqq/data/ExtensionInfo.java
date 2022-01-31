package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionInfo
  extends Entity
{
  public static final int AUDIO_PANEL_TYPE__LS = 3;
  public static final int AUDIO_PANEL_TYPE__NONE = -1;
  public static final int AUDIO_PANEL_TYPE__PRESS_RECORDER = 1;
  public static final int AUDIO_PANEL_TYPE__RECORDER = 2;
  public static final int AUDIO_PANEL_TYPE__VOICE_CHANGER = 0;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final int CHAT_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_SHOW_NONE_PANEL = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final int INTERACTION_TYPE_NORMAL = 0;
  public static final int INTERACTION_TYPE_SMALL = 1;
  public static final int INTERACTION_TYPE_SUPER = 2;
  public static final int INTIMACY_FRIEND_LOW = 1;
  public static final int INTIMACY_FRIEND_NONE = 0;
  public static final int INTIMACY_FRIEND_SUPER = 2;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public static final int QZONE_VISIT_TYPE_NONE = 0;
  public static final int QZONE_VISIT_TYPE_NORMAL = 1;
  public static final int QZONE_VISIT_TYPE_SUPER = 2;
  public static final int TYPE_FROM_CHAT = 1;
  public static final int TYPE_FROM_CONTACT = 0;
  public String apolloDataBuffer;
  public String apolloHistoryDress;
  public long apolloLocalTS;
  public long apolloServerTS;
  public int apolloStatus;
  public long apolloUpdateTime;
  public int apolloVipFlag;
  public int apolloVipLevel;
  @defaultValue(a=-1)
  public int audioPanelType = -1;
  @Deprecated
  public int bestIntimacyDays;
  public int bestIntimacyType = 0;
  @notColumn
  public long chatAnimStartTime;
  public int chatDays;
  public int chatHotLevel = 0;
  public int chatInputType = 0;
  public long colorRingId;
  public long commingRingId;
  public byte[] diyFontConfigBytes;
  public ConcurrentHashMap diyFontConfigMap;
  public byte[] diyFontTimestampBytes;
  public ConcurrentHashMap diyFontTimestampMap;
  public int faceId;
  public long faceIdUpdateTime;
  public String feedContent;
  public boolean feedHasPhoto;
  public long feedTime;
  public int feedType;
  public int fontEffect;
  public long fontEffectLastUpdateTime;
  public boolean hasRemindChat;
  public boolean hasRemindPraise;
  public boolean hasRemindQzoneVisit;
  public boolean isAdded2C2C;
  @notColumn
  public boolean isDataChanged;
  public int isGrayTipMultiRemind = 0;
  public int isGrayTipRemind = 0;
  public boolean isQzoneLover;
  public long lastChatTime;
  @notColumn
  public long lastGrayPushTime = -1L;
  public long lastMedalTimestamp;
  public long lastPLNewsTimestamp;
  public long lastPullPLNewsTimestamp;
  public long lastQzoneVisitTime;
  public long lastUpdateTime;
  public long lastpraiseTime;
  public long latestPLUpdateTimestamp;
  public int magicFont;
  public long medalUpdateTimestamp;
  public int pendantDiyId;
  public long pendantId;
  @notColumn
  public long praiseAnimStartTime;
  @Deprecated
  public int praiseDays;
  public int praiseHotLevel = 0;
  public int pttChangeVoiceType = 0;
  public int qzoneHotDays;
  @notColumn
  public long qzoneVisitAnimStartTime;
  public int qzoneVisitType = 0;
  public byte[] richBuffer;
  @notColumn
  public RichStatus richStatus;
  public long richTime;
  public int showC2CPanel = 1;
  public long timestamp;
  public long uVipFont;
  @unique
  public String uin;
  public int uinType;
  public int vipFontType;
  
  public RichStatus getRichStatus()
  {
    return getRichStatus(false);
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.getEmptyStatus();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.parseStatus(this.richBuffer);
      this.richStatus.time = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = new RichStatus(null);
    }
  }
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
  
  /* Error */
  protected void postRead()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 188	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   10: ifnull +45 -> 55
    //   13: new 190	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 188	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   21: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: astore_1
    //   25: new 195	java/io/ObjectInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: checkcast 204	java/util/concurrent/ConcurrentHashMap
    //   44: putfield 206	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   55: aload_0
    //   56: getfield 211	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   59: ifnull +46 -> 105
    //   62: new 190	java/io/ByteArrayInputStream
    //   65: dup
    //   66: aload_0
    //   67: getfield 211	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   70: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   73: astore_2
    //   74: aload 5
    //   76: astore_1
    //   77: new 195	java/io/ObjectInputStream
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_2
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   91: checkcast 204	java/util/concurrent/ConcurrentHashMap
    //   94: putfield 213	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   105: return
    //   106: astore_1
    //   107: ldc 215
    //   109: iconst_1
    //   110: new 217	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   117: ldc 220
    //   119: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: goto -80 -> 55
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: astore_1
    //   143: ldc 215
    //   145: iconst_1
    //   146: new 217	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   153: ldc 220
    //   155: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: ifnull -117 -> 55
    //   175: aload_2
    //   176: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   179: goto -124 -> 55
    //   182: astore_1
    //   183: ldc 215
    //   185: iconst_1
    //   186: new 217	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   193: ldc 220
    //   195: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto -156 -> 55
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   225: aload_2
    //   226: athrow
    //   227: astore_1
    //   228: ldc 215
    //   230: iconst_1
    //   231: new 217	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   238: ldc 220
    //   240: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: goto -31 -> 225
    //   259: astore_1
    //   260: ldc 215
    //   262: iconst_1
    //   263: new 217	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   270: ldc 220
    //   272: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: return
    //   289: astore_3
    //   290: aload 4
    //   292: astore_2
    //   293: aload_2
    //   294: astore_1
    //   295: ldc 215
    //   297: iconst_1
    //   298: new 217	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   305: ldc 220
    //   307: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_3
    //   311: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_2
    //   324: ifnull -219 -> 105
    //   327: aload_2
    //   328: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   331: return
    //   332: astore_1
    //   333: ldc 215
    //   335: iconst_1
    //   336: new 217	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   343: ldc 220
    //   345: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_1
    //   349: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   352: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: return
    //   362: astore_3
    //   363: aload_1
    //   364: astore_2
    //   365: aload_3
    //   366: astore_1
    //   367: aload_2
    //   368: ifnull +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore_2
    //   378: ldc 215
    //   380: iconst_1
    //   381: new 217	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   388: ldc 220
    //   390: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: goto -31 -> 375
    //   409: astore_1
    //   410: goto -43 -> 367
    //   413: astore_3
    //   414: goto -121 -> 293
    //   417: astore_2
    //   418: goto -201 -> 217
    //   421: astore_3
    //   422: goto -281 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	ExtensionInfo
    //   24	53	1	localObject1	java.lang.Object
    //   106	17	1	localException1	java.lang.Exception
    //   142	1	1	localObject2	java.lang.Object
    //   182	17	1	localException2	java.lang.Exception
    //   216	6	1	localObject3	java.lang.Object
    //   227	17	1	localException3	java.lang.Exception
    //   259	17	1	localException4	java.lang.Exception
    //   294	1	1	localObject4	java.lang.Object
    //   332	32	1	localException5	java.lang.Exception
    //   366	10	1	localObject5	java.lang.Object
    //   409	1	1	localObject6	java.lang.Object
    //   33	143	2	localObject7	java.lang.Object
    //   214	12	2	localObject8	java.lang.Object
    //   292	80	2	localObject9	java.lang.Object
    //   377	17	2	localException6	java.lang.Exception
    //   417	1	2	localObject10	java.lang.Object
    //   138	21	3	localException7	java.lang.Exception
    //   289	22	3	localException8	java.lang.Exception
    //   362	4	3	localObject11	java.lang.Object
    //   413	1	3	localException9	java.lang.Exception
    //   421	1	3	localException10	java.lang.Exception
    //   4	287	4	localObject12	java.lang.Object
    //   1	74	5	localObject13	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   51	55	106	java/lang/Exception
    //   25	34	138	java/lang/Exception
    //   175	179	182	java/lang/Exception
    //   25	34	214	finally
    //   221	225	227	java/lang/Exception
    //   101	105	259	java/lang/Exception
    //   77	86	289	java/lang/Exception
    //   327	331	332	java/lang/Exception
    //   77	86	362	finally
    //   295	323	362	finally
    //   371	375	377	java/lang/Exception
    //   86	97	409	finally
    //   86	97	413	java/lang/Exception
    //   36	47	417	finally
    //   143	171	417	finally
    //   36	47	421	java/lang/Exception
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 240	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 240	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 5
    //   22: new 243	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 246	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 206	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: ifnull +23 -> 58
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 206	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: invokevirtual 250	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: invokevirtual 253	java/io/ObjectOutputStream:flush	()V
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: putfield 188	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   58: aload_0
    //   59: getfield 213	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnull +367 -> 429
    //   65: new 243	java/io/ObjectOutputStream
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 246	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 213	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   80: invokevirtual 250	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: invokevirtual 253	java/io/ObjectOutputStream:flush	()V
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   93: putfield 211	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   112: return
    //   113: astore_2
    //   114: ldc 215
    //   116: iconst_1
    //   117: new 217	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 260
    //   127: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto -39 -> 104
    //   146: astore_1
    //   147: ldc 215
    //   149: iconst_1
    //   150: new 217	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 260
    //   160: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: return
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_1
    //   180: aload 4
    //   182: astore_2
    //   183: ldc 215
    //   185: iconst_1
    //   186: new 217	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 260
    //   196: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   220: aload_2
    //   221: ifnull -109 -> 112
    //   224: aload_2
    //   225: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   228: return
    //   229: astore_1
    //   230: ldc 215
    //   232: iconst_1
    //   233: new 217	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 260
    //   243: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: return
    //   260: astore_1
    //   261: ldc 215
    //   263: iconst_1
    //   264: new 217	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 260
    //   274: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto -70 -> 220
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 258	java/io/ObjectOutputStream:close	()V
    //   312: aload_1
    //   313: athrow
    //   314: astore_2
    //   315: ldc 215
    //   317: iconst_1
    //   318: new 217	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 260
    //   328: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_2
    //   332: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto -40 -> 304
    //   347: astore_2
    //   348: ldc 215
    //   350: iconst_1
    //   351: new 217	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 260
    //   361: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_2
    //   365: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: goto -65 -> 312
    //   380: astore_1
    //   381: goto -85 -> 296
    //   384: astore 4
    //   386: aload_1
    //   387: astore_3
    //   388: aload 4
    //   390: astore_1
    //   391: goto -95 -> 296
    //   394: astore_3
    //   395: aload_1
    //   396: astore 4
    //   398: aload_3
    //   399: astore_1
    //   400: aload_2
    //   401: astore_3
    //   402: aload 4
    //   404: astore_2
    //   405: goto -109 -> 296
    //   408: astore_3
    //   409: aload_2
    //   410: astore_1
    //   411: aload 4
    //   413: astore_2
    //   414: goto -231 -> 183
    //   417: astore_3
    //   418: aload_2
    //   419: astore 4
    //   421: aload_1
    //   422: astore_2
    //   423: aload 4
    //   425: astore_1
    //   426: goto -243 -> 183
    //   429: aconst_null
    //   430: astore_1
    //   431: goto -335 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	ExtensionInfo
    //   12	97	1	localObject1	java.lang.Object
    //   146	18	1	localException1	java.lang.Exception
    //   179	38	1	localObject2	java.lang.Object
    //   229	18	1	localException2	java.lang.Exception
    //   260	18	1	localException3	java.lang.Exception
    //   293	20	1	localObject3	java.lang.Object
    //   380	7	1	localObject4	java.lang.Object
    //   390	41	1	localObject5	java.lang.Object
    //   30	71	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   113	18	2	localException4	java.lang.Exception
    //   182	119	2	localObject6	java.lang.Object
    //   314	18	2	localException5	java.lang.Exception
    //   347	54	2	localException6	java.lang.Exception
    //   404	19	2	localObject7	java.lang.Object
    //   1	1	3	localObject8	java.lang.Object
    //   177	132	3	localException7	java.lang.Exception
    //   387	1	3	localObject9	java.lang.Object
    //   394	5	3	localObject10	java.lang.Object
    //   401	1	3	localObject11	java.lang.Object
    //   408	1	3	localException8	java.lang.Exception
    //   417	1	3	localException9	java.lang.Exception
    //   3	178	4	localObject12	java.lang.Object
    //   384	5	4	localObject13	java.lang.Object
    //   396	28	4	localObject14	java.lang.Object
    //   20	69	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   100	104	113	java/lang/Exception
    //   108	112	146	java/lang/Exception
    //   22	31	177	java/lang/Exception
    //   224	228	229	java/lang/Exception
    //   216	220	260	java/lang/Exception
    //   22	31	293	finally
    //   300	304	314	java/lang/Exception
    //   308	312	347	java/lang/Exception
    //   31	58	380	finally
    //   58	75	380	finally
    //   75	96	384	finally
    //   183	212	394	finally
    //   31	58	408	java/lang/Exception
    //   58	75	408	java/lang/Exception
    //   75	96	417	java/lang/Exception
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
    this.richStatus = null;
    this.isAdded2C2C = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */