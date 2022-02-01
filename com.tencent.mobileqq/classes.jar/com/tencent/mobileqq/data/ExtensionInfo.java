package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.friend.IExtensionBusinessData;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class ExtensionInfo
  extends Entity
{
  public static final int AUDIO_PANEL_TYPE_LS = 3;
  public static final int AUDIO_PANEL_TYPE_NONE = -1;
  public static final int AUDIO_PANEL_TYPE_PRESS_RECORDER = 1;
  public static final int AUDIO_PANEL_TYPE_RECORDER = 2;
  public static final int AUDIO_PANEL_TYPE_VOICE_CHANGER = 0;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final int CHAT_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_SHOW_NONE_PANEL = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final int FEED_TYPE_QSTORY = 2;
  public static final int FEED_TYPE_QZONE = 0;
  public static final int FEED_TYPE_WEISHI = 1;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public static final String TAG = "ExtensionInfo";
  public static final int TYPE_FROM_CHAT = 1;
  public static final int TYPE_FROM_CONTACT = 0;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_ExtensionBusinessData.yml", version=1)
  private static ArrayList<Class<? extends IExtensionBusinessData>> sBusinessDataInjectClasses = new ArrayList();
  @defaultValue(defaultInteger=-1)
  public int audioPanelType = -1;
  @Deprecated
  public int bestIntimacyDays = 0;
  public int bestIntimacyType = 0;
  @notColumn
  private Map<String, IExtensionBusinessData> businessDataCache = new HashMap();
  @notColumn
  public long chatAnimStartTime;
  public int chatDays = 0;
  public int chatHotLevel = 0;
  public int chatInputType = 0;
  public long colorRingId = 0L;
  public long commingRingId = 0L;
  public byte[] diyFontConfigBytes;
  public ConcurrentHashMap<Integer, String> diyFontConfigMap;
  public byte[] diyFontTimestampBytes;
  public ConcurrentHashMap<Integer, Integer> diyFontTimestampMap;
  public int faceId;
  public long faceIdUpdateTime;
  public String feedContent;
  public boolean feedHasPhoto = false;
  public String feedPhotoUrl;
  public long feedTime;
  public int feedType;
  public int fontEffect;
  public long fontEffectLastUpdateTime;
  @notColumn
  public long frdshipAnimStartTime;
  public int friendRingId;
  public int friendshipChatDays = 0;
  public int friendshipLevel = 0;
  public boolean hasRemindChat;
  public boolean hasRemindFrdship;
  public boolean hasRemindIntimate;
  public boolean hasRemindLoverChat;
  public boolean hasRemindPraise;
  public boolean hasRemindQzoneVisit;
  @defaultValue(defaultInteger=0)
  public int hiddenChatSwitch = 0;
  @notColumn
  public long intimateAnimStartTime;
  public int intimate_chatDays = 0;
  public int intimate_level = 0;
  public int intimate_type = 0;
  public boolean isAdded2C2C;
  public boolean isAioShortcutBarOpen = true;
  @notColumn
  public boolean isDataChanged;
  public boolean isExtinguish = false;
  public int isGrayTipMultiRemind = 0;
  public int isGrayTipRemind = 0;
  public boolean isListenTogetherOpen = false;
  @defaultValue(defaultInteger=0)
  public int isSharingLocation = 0;
  public long lastChatTime = 0L;
  @notColumn
  public long lastFriendshipGrayPushTime = -1L;
  public long lastFriendshipTime = 0L;
  @notColumn
  public long lastGrayPushTime = -1L;
  public long lastHotReactiveReCheckInTs = 0L;
  public long lastIceBreakChatTs = 0L;
  public long lastIceBreakCheckTs = 0L;
  public long lastPLNewsTimestamp;
  public long lastPullPLNewsTimestamp;
  public long lastQzoneVisitTime;
  @defaultValue(defaultInteger=0)
  public long lastShareLbsMsgUniseq;
  public long lastUpdateTime;
  public long last_intimate_chatTime = 0L;
  public long lastpraiseTime = 0L;
  public long latestPLUpdateTimestamp;
  public long localChatRecTs = 0L;
  public long localChatSendTs = 0L;
  @notColumn
  public long loverChatAnimStartTime;
  public int loverChatDays = 0;
  public int loverChatLevel = 0;
  public int loverFlag = 0;
  public long loverLastChatTime = 0L;
  public boolean loverTransFlag = false;
  public long mTogetherBusinessFlag = 0L;
  public int magicFont;
  public long makeFrdsTs = 0L;
  public boolean messageEnablePreview = true;
  @defaultValue(defaultInteger=0)
  public int messageEnablePreviewNew = 0;
  public boolean messageEnableSound = true;
  @defaultValue(defaultInteger=0)
  public int messageEnableSoundNew = 0;
  public boolean messageEnableVibrate = true;
  @defaultValue(defaultInteger=0)
  public int messageEnableVibrateNew = 0;
  public int mutual_mark_version = 0;
  public String mutual_marks_store_json;
  public int newBestIntimacyType = 0;
  public long openDoNotDisturbTime = 0L;
  public int pendantDiyId;
  public long pendantId;
  @notColumn
  public long praiseAnimStartTime;
  @Deprecated
  public int praiseDays = 0;
  public int praiseHotLevel = 0;
  public int pttChangeVoiceType = 0;
  public int qzoneHotDays;
  @notColumn
  public long qzoneVisitAnimStartTime;
  public int qzoneVisitType = 0;
  public byte[] richBuffer;
  public long richTime;
  public int showC2CPanel = 1;
  public long timestamp = 0L;
  @defaultValue(defaultInteger=-1)
  public long topPositionTime;
  public long uVipFont;
  @unique
  public String uin;
  public int vipFontType;
  
  static
  {
    sBusinessDataInjectClasses.add(ExtensionMutualMarkData.class);
    sBusinessDataInjectClasses.add(ExtensionRichStatus.class);
  }
  
  private void notifyBusinessDataPostRead()
  {
    if (sBusinessDataInjectClasses == null) {
      QLog.e("ExtensionInfo", 1, "sBusinessDataInjectClasses == null");
    }
    for (;;)
    {
      return;
      Iterator localIterator = sBusinessDataInjectClasses.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        String str = ((Class)localObject).getName();
        try
        {
          localObject = (IExtensionBusinessData)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
          this.businessDataCache.put(str, localObject);
          ((IExtensionBusinessData)localObject).a(this);
        }
        catch (Exception localException)
        {
          QLog.d("ExtensionInfo", 1, "notifyBusinessDataPostRead, <init> " + str, localException);
        }
      }
    }
  }
  
  private void notifyBusinessDataPreWrite()
  {
    Iterator localIterator = this.businessDataCache.values().iterator();
    while (localIterator.hasNext()) {
      ((IExtensionBusinessData)localIterator.next()).b(this);
    }
  }
  
  public <T extends IExtensionBusinessData> T getBusinessData(Class<T> paramClass, Object... paramVarArgs)
  {
    String str = paramClass.getName();
    if (!this.businessDataCache.containsKey(str)) {}
    try
    {
      paramClass = (IExtensionBusinessData)paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      this.businessDataCache.put(str, paramClass);
      QLog.d("ExtensionInfo", 1, "getBusinessData, <init>" + str);
      paramClass = (IExtensionBusinessData)this.businessDataCache.get(str);
      if (paramClass != null) {
        paramClass.a(this, paramVarArgs);
      }
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        QLog.d("ExtensionInfo", 1, "getBusinessData, <init>" + str, paramClass);
      }
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
  
  public boolean isTogetherBusinessOpen(int paramInt)
  {
    return (this.mTogetherBusinessFlag & paramInt) != 0L;
  }
  
  /* Error */
  public void postRead()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 404	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   10: ifnull +45 -> 55
    //   13: new 406	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 404	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   21: invokespecial 409	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: astore_1
    //   25: new 411	java/io/ObjectInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 414	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: checkcast 419	java/util/concurrent/ConcurrentHashMap
    //   44: putfield 421	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   55: aload_0
    //   56: getfield 426	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   59: ifnull +46 -> 105
    //   62: new 406	java/io/ByteArrayInputStream
    //   65: dup
    //   66: aload_0
    //   67: getfield 426	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   70: invokespecial 409	java/io/ByteArrayInputStream:<init>	([B)V
    //   73: astore_2
    //   74: aload 5
    //   76: astore_1
    //   77: new 411	java/io/ObjectInputStream
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 414	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_2
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   91: checkcast 419	java/util/concurrent/ConcurrentHashMap
    //   94: putfield 428	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   105: aload_0
    //   106: invokespecial 430	com/tencent/mobileqq/data/ExtensionInfo:notifyBusinessDataPostRead	()V
    //   109: ldc 35
    //   111: iconst_1
    //   112: new 346	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 432
    //   122: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 434	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   129: invokestatic 440	mqq/app/MobileQQ:getShortUinStr	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 442
    //   138: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 220	com/tencent/mobileqq/data/ExtensionInfo:intimate_type	I
    //   145: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc_w 447
    //   151: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:hiddenChatSwitch	I
    //   158: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc_w 449
    //   164: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: getfield 200	com/tencent/mobileqq/data/ExtensionInfo:isSharingLocation	I
    //   171: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 452	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: return
    //   181: astore_1
    //   182: ldc 35
    //   184: iconst_1
    //   185: new 346	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 454
    //   195: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto -156 -> 55
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: astore_1
    //   219: ldc 35
    //   221: iconst_1
    //   222: new 346	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 454
    //   232: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_3
    //   236: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_2
    //   249: ifnull -194 -> 55
    //   252: aload_2
    //   253: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   256: goto -201 -> 55
    //   259: astore_1
    //   260: ldc 35
    //   262: iconst_1
    //   263: new 346	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 454
    //   273: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: goto -234 -> 55
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   303: aload_2
    //   304: athrow
    //   305: astore_1
    //   306: ldc 35
    //   308: iconst_1
    //   309: new 346	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 454
    //   319: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto -32 -> 303
    //   338: astore_1
    //   339: ldc 35
    //   341: iconst_1
    //   342: new 346	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 454
    //   352: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -263 -> 105
    //   371: astore_3
    //   372: aload 4
    //   374: astore_2
    //   375: aload_2
    //   376: astore_1
    //   377: ldc 35
    //   379: iconst_1
    //   380: new 346	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 454
    //   390: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_3
    //   394: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: aload_2
    //   407: ifnull -302 -> 105
    //   410: aload_2
    //   411: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   414: goto -309 -> 105
    //   417: astore_1
    //   418: ldc 35
    //   420: iconst_1
    //   421: new 346	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 454
    //   431: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: goto -342 -> 105
    //   450: astore_3
    //   451: aload_1
    //   452: astore_2
    //   453: aload_3
    //   454: astore_1
    //   455: aload_2
    //   456: ifnull +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   463: aload_1
    //   464: athrow
    //   465: astore_2
    //   466: ldc 35
    //   468: iconst_1
    //   469: new 346	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 454
    //   479: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_2
    //   483: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -32 -> 463
    //   498: astore_1
    //   499: goto -44 -> 455
    //   502: astore_3
    //   503: goto -128 -> 375
    //   506: astore_2
    //   507: goto -212 -> 295
    //   510: astore_3
    //   511: goto -294 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	ExtensionInfo
    //   24	53	1	localObject1	Object
    //   181	18	1	localException1	Exception
    //   218	1	1	localObject2	Object
    //   259	18	1	localException2	Exception
    //   294	6	1	localObject3	Object
    //   305	18	1	localException3	Exception
    //   338	18	1	localException4	Exception
    //   376	1	1	localObject4	Object
    //   417	35	1	localException5	Exception
    //   454	10	1	localObject5	Object
    //   498	1	1	localObject6	Object
    //   33	220	2	localObject7	Object
    //   292	12	2	localObject8	Object
    //   374	86	2	localObject9	Object
    //   465	18	2	localException6	Exception
    //   506	1	2	localObject10	Object
    //   214	22	3	localException7	Exception
    //   371	23	3	localException8	Exception
    //   450	4	3	localObject11	Object
    //   502	1	3	localException9	Exception
    //   510	1	3	localException10	Exception
    //   4	369	4	localObject12	Object
    //   1	74	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   51	55	181	java/lang/Exception
    //   25	34	214	java/lang/Exception
    //   252	256	259	java/lang/Exception
    //   25	34	292	finally
    //   299	303	305	java/lang/Exception
    //   101	105	338	java/lang/Exception
    //   77	86	371	java/lang/Exception
    //   410	414	417	java/lang/Exception
    //   77	86	450	finally
    //   377	406	450	finally
    //   459	463	465	java/lang/Exception
    //   86	97	498	finally
    //   86	97	502	java/lang/Exception
    //   36	47	506	finally
    //   219	248	506	finally
    //   36	47	510	java/lang/Exception
  }
  
  public void postwrite()
  {
    super.postwrite();
    if ((this.intimate_type == 1) || (this.hiddenChatSwitch == 1) || (this.isSharingLocation == 1)) {
      QLog.i("ExtensionInfo", 1, "ExtensionInfo postwrite()，uin: " + MobileQQ.getShortUinStr(this.uin) + ", intimate_type:" + this.intimate_type + ", hiddenChatSwitch:" + this.hiddenChatSwitch + ", isSharingLocation:" + this.isSharingLocation);
    }
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 465	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 466	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 465	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 466	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 5
    //   22: new 468	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 471	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 421	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: ifnull +23 -> 58
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 421	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: invokevirtual 475	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: invokevirtual 478	java/io/ObjectOutputStream:flush	()V
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: putfield 404	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   58: aload_0
    //   59: getfield 428	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnull +448 -> 510
    //   65: new 468	java/io/ObjectOutputStream
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 471	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 428	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   80: invokevirtual 475	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: invokevirtual 478	java/io/ObjectOutputStream:flush	()V
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   93: putfield 426	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   112: aload_0
    //   113: invokespecial 485	com/tencent/mobileqq/data/ExtensionInfo:notifyBusinessDataPreWrite	()V
    //   116: ldc 35
    //   118: iconst_1
    //   119: new 346	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 487
    //   129: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: getfield 434	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   136: invokestatic 440	mqq/app/MobileQQ:getShortUinStr	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 442
    //   145: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: getfield 220	com/tencent/mobileqq/data/ExtensionInfo:intimate_type	I
    //   152: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 447
    //   158: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:hiddenChatSwitch	I
    //   165: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc_w 449
    //   171: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: getfield 200	com/tencent/mobileqq/data/ExtensionInfo:isSharingLocation	I
    //   178: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 452	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: return
    //   188: astore_2
    //   189: ldc 35
    //   191: iconst_1
    //   192: new 346	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 489
    //   202: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: goto -114 -> 104
    //   221: astore_1
    //   222: ldc 35
    //   224: iconst_1
    //   225: new 346	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 489
    //   235: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: goto -139 -> 112
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_1
    //   257: aload 4
    //   259: astore_2
    //   260: ldc 35
    //   262: iconst_1
    //   263: new 346	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 489
    //   273: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_3
    //   277: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_1
    //   290: ifnull +7 -> 297
    //   293: aload_1
    //   294: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   297: aload_2
    //   298: ifnull -186 -> 112
    //   301: aload_2
    //   302: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   305: goto -193 -> 112
    //   308: astore_1
    //   309: ldc 35
    //   311: iconst_1
    //   312: new 346	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 489
    //   322: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: goto -226 -> 112
    //   341: astore_1
    //   342: ldc 35
    //   344: iconst_1
    //   345: new 346	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 489
    //   355: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto -74 -> 297
    //   374: astore_1
    //   375: aconst_null
    //   376: astore_2
    //   377: aload_2
    //   378: ifnull +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   385: aload_3
    //   386: ifnull +7 -> 393
    //   389: aload_3
    //   390: invokevirtual 483	java/io/ObjectOutputStream:close	()V
    //   393: aload_1
    //   394: athrow
    //   395: astore_2
    //   396: ldc 35
    //   398: iconst_1
    //   399: new 346	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 489
    //   409: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_2
    //   413: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: goto -40 -> 385
    //   428: astore_2
    //   429: ldc 35
    //   431: iconst_1
    //   432: new 346	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 489
    //   442: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_2
    //   446: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: goto -65 -> 393
    //   461: astore_1
    //   462: goto -85 -> 377
    //   465: astore 4
    //   467: aload_1
    //   468: astore_3
    //   469: aload 4
    //   471: astore_1
    //   472: goto -95 -> 377
    //   475: astore_3
    //   476: aload_1
    //   477: astore 4
    //   479: aload_3
    //   480: astore_1
    //   481: aload_2
    //   482: astore_3
    //   483: aload 4
    //   485: astore_2
    //   486: goto -109 -> 377
    //   489: astore_3
    //   490: aload_2
    //   491: astore_1
    //   492: aload 4
    //   494: astore_2
    //   495: goto -235 -> 260
    //   498: astore_3
    //   499: aload_2
    //   500: astore 4
    //   502: aload_1
    //   503: astore_2
    //   504: aload 4
    //   506: astore_1
    //   507: goto -247 -> 260
    //   510: aconst_null
    //   511: astore_1
    //   512: goto -416 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	this	ExtensionInfo
    //   12	97	1	localObject1	Object
    //   221	18	1	localException1	Exception
    //   256	38	1	localObject2	Object
    //   308	18	1	localException2	Exception
    //   341	18	1	localException3	Exception
    //   374	20	1	localObject3	Object
    //   461	7	1	localObject4	Object
    //   471	41	1	localObject5	Object
    //   30	71	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   188	18	2	localException4	Exception
    //   259	123	2	localObject6	Object
    //   395	18	2	localException5	Exception
    //   428	54	2	localException6	Exception
    //   485	19	2	localObject7	Object
    //   1	1	3	localObject8	Object
    //   254	136	3	localException7	Exception
    //   468	1	3	localObject9	Object
    //   475	5	3	localObject10	Object
    //   482	1	3	localObject11	Object
    //   489	1	3	localException8	Exception
    //   498	1	3	localException9	Exception
    //   3	255	4	localObject12	Object
    //   465	5	4	localObject13	Object
    //   477	28	4	localObject14	Object
    //   20	69	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   100	104	188	java/lang/Exception
    //   108	112	221	java/lang/Exception
    //   22	31	254	java/lang/Exception
    //   301	305	308	java/lang/Exception
    //   293	297	341	java/lang/Exception
    //   22	31	374	finally
    //   381	385	395	java/lang/Exception
    //   389	393	428	java/lang/Exception
    //   31	58	461	finally
    //   58	75	461	finally
    //   75	96	465	finally
    //   260	289	475	finally
    //   31	58	489	java/lang/Exception
    //   58	75	489	java/lang/Exception
    //   75	96	498	java/lang/Exception
  }
  
  public <T extends IExtensionBusinessData> void putBusinessData(T paramT)
  {
    this.businessDataCache.put(paramT.getClass().getName(), paramT);
  }
  
  public void setTogetherBusiness(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.mTogetherBusinessFlag |= paramInt;
      return;
    }
    this.mTogetherBusinessFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public String toString()
  {
    return "ExtensionInfo toString{uin='" + this.uin + '\'' + ", isSharingLocation=" + this.isSharingLocation + ", hiddenChatSwitch=" + this.hiddenChatSwitch + ", intimate_type=" + this.intimate_type + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */