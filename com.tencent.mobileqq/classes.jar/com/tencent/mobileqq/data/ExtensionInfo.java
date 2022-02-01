package com.tencent.mobileqq.data;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.data.friend.IExtensionBusinessData;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    Object localObject1 = sBusinessDataInjectClasses;
    if (localObject1 == null)
    {
      QLog.e("ExtensionInfo", 1, "sBusinessDataInjectClasses == null");
      return;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Class)((Iterator)localObject1).next();
      String str = ((Class)localObject2).getName();
      try
      {
        localObject2 = (IExtensionBusinessData)((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]);
        this.businessDataCache.put(str, localObject2);
        ((IExtensionBusinessData)localObject2).a(this);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyBusinessDataPostRead, <init> ");
        localStringBuilder.append(str);
        QLog.d("ExtensionInfo", 1, localStringBuilder.toString(), localException);
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
  
  protected ContentValues createContentValues()
  {
    return doCreateContentValue();
  }
  
  public ContentValues doCreateContentValue()
  {
    Object localObject1 = TableBuilder.getValidField(getClassForTable());
    int k = ((List)localObject1).size();
    ContentValues localContentValues = new ContentValues(k);
    int j = this.hiddenChatSwitch;
    localContentValues.put("audioPanelType", Integer.valueOf(this.audioPanelType));
    localContentValues.put("bestIntimacyDays", Integer.valueOf(this.bestIntimacyDays));
    localContentValues.put("bestIntimacyType", Integer.valueOf(this.bestIntimacyType));
    localContentValues.put("chatDays", Integer.valueOf(this.chatDays));
    localContentValues.put("chatHotLevel", Integer.valueOf(this.chatHotLevel));
    localContentValues.put("chatInputType", Integer.valueOf(this.chatInputType));
    localContentValues.put("colorRingId", Long.valueOf(this.colorRingId));
    localContentValues.put("commingRingId", Long.valueOf(this.commingRingId));
    localContentValues.put("diyFontConfigBytes", this.diyFontConfigBytes);
    localContentValues.put("diyFontTimestampBytes", this.diyFontTimestampBytes);
    localContentValues.put("faceId", Integer.valueOf(this.faceId));
    localContentValues.put("faceIdUpdateTime", Long.valueOf(this.faceIdUpdateTime));
    localContentValues.put("feedContent", this.feedContent);
    localContentValues.put("feedHasPhoto", Boolean.valueOf(this.feedHasPhoto));
    localContentValues.put("feedPhotoUrl", this.feedPhotoUrl);
    localContentValues.put("feedTime", Long.valueOf(this.feedTime));
    localContentValues.put("feedType", Integer.valueOf(this.feedType));
    localContentValues.put("fontEffect", Integer.valueOf(this.fontEffect));
    localContentValues.put("fontEffectLastUpdateTime", Long.valueOf(this.fontEffectLastUpdateTime));
    localContentValues.put("friendRingId", Integer.valueOf(this.friendRingId));
    localContentValues.put("friendshipChatDays", Integer.valueOf(this.friendshipChatDays));
    localContentValues.put("friendshipLevel", Integer.valueOf(this.friendshipLevel));
    localContentValues.put("hasRemindChat", Boolean.valueOf(this.hasRemindChat));
    localContentValues.put("hasRemindFrdship", Boolean.valueOf(this.hasRemindFrdship));
    localContentValues.put("hasRemindIntimate", Boolean.valueOf(this.hasRemindIntimate));
    localContentValues.put("hasRemindLoverChat", Boolean.valueOf(this.hasRemindLoverChat));
    localContentValues.put("hasRemindPraise", Boolean.valueOf(this.hasRemindPraise));
    localContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(this.hasRemindQzoneVisit));
    localContentValues.put("hiddenChatSwitch", Integer.valueOf(this.hiddenChatSwitch));
    localContentValues.put("intimate_chatDays", Integer.valueOf(this.intimate_chatDays));
    localContentValues.put("intimate_level", Integer.valueOf(this.intimate_level));
    localContentValues.put("intimate_type", Integer.valueOf(this.intimate_type));
    localContentValues.put("isAdded2C2C", Boolean.valueOf(this.isAdded2C2C));
    localContentValues.put("isAioShortcutBarOpen", Boolean.valueOf(this.isAioShortcutBarOpen));
    localContentValues.put("isExtinguish", Boolean.valueOf(this.isExtinguish));
    localContentValues.put("isGrayTipMultiRemind", Integer.valueOf(this.isGrayTipMultiRemind));
    localContentValues.put("isGrayTipRemind", Integer.valueOf(this.isGrayTipRemind));
    localContentValues.put("isListenTogetherOpen", Boolean.valueOf(this.isListenTogetherOpen));
    localContentValues.put("isSharingLocation", Integer.valueOf(this.isSharingLocation));
    localContentValues.put("lastChatTime", Long.valueOf(this.lastChatTime));
    localContentValues.put("lastFriendshipTime", Long.valueOf(this.lastFriendshipTime));
    localContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(this.lastHotReactiveReCheckInTs));
    localContentValues.put("lastIceBreakChatTs", Long.valueOf(this.lastIceBreakChatTs));
    localContentValues.put("lastIceBreakCheckTs", Long.valueOf(this.lastIceBreakCheckTs));
    localContentValues.put("lastPLNewsTimestamp", Long.valueOf(this.lastPLNewsTimestamp));
    localContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(this.lastPullPLNewsTimestamp));
    localContentValues.put("lastQzoneVisitTime", Long.valueOf(this.lastQzoneVisitTime));
    localContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(this.lastShareLbsMsgUniseq));
    localContentValues.put("lastUpdateTime", Long.valueOf(this.lastUpdateTime));
    localContentValues.put("last_intimate_chatTime", Long.valueOf(this.last_intimate_chatTime));
    localContentValues.put("lastpraiseTime", Long.valueOf(this.lastpraiseTime));
    localContentValues.put("latestPLUpdateTimestamp", Long.valueOf(this.latestPLUpdateTimestamp));
    localContentValues.put("localChatRecTs", Long.valueOf(this.localChatRecTs));
    localContentValues.put("localChatSendTs", Long.valueOf(this.localChatSendTs));
    localContentValues.put("loverChatDays", Integer.valueOf(this.loverChatDays));
    localContentValues.put("loverChatLevel", Integer.valueOf(this.loverChatLevel));
    localContentValues.put("loverFlag", Integer.valueOf(this.loverFlag));
    localContentValues.put("loverLastChatTime", Long.valueOf(this.loverLastChatTime));
    localContentValues.put("loverTransFlag", Boolean.valueOf(this.loverTransFlag));
    localContentValues.put("mTogetherBusinessFlag", Long.valueOf(this.mTogetherBusinessFlag));
    localContentValues.put("magicFont", Integer.valueOf(this.magicFont));
    localContentValues.put("makeFrdsTs", Long.valueOf(this.makeFrdsTs));
    localContentValues.put("messageEnablePreview", Boolean.valueOf(this.messageEnablePreview));
    localContentValues.put("messageEnablePreviewNew", Integer.valueOf(this.messageEnablePreviewNew));
    localContentValues.put("messageEnableSound", Boolean.valueOf(this.messageEnableSound));
    localContentValues.put("messageEnableSoundNew", Integer.valueOf(this.messageEnableSoundNew));
    localContentValues.put("messageEnableVibrate", Boolean.valueOf(this.messageEnableVibrate));
    localContentValues.put("messageEnableVibrateNew", Integer.valueOf(this.messageEnableVibrateNew));
    localContentValues.put("mutual_mark_version", Integer.valueOf(this.mutual_mark_version));
    localContentValues.put("mutual_marks_store_json", this.mutual_marks_store_json);
    localContentValues.put("newBestIntimacyType", Integer.valueOf(this.newBestIntimacyType));
    localContentValues.put("openDoNotDisturbTime", Long.valueOf(this.openDoNotDisturbTime));
    localContentValues.put("pendantDiyId", Integer.valueOf(this.pendantDiyId));
    localContentValues.put("pendantId", Long.valueOf(this.pendantId));
    localContentValues.put("praiseDays", Integer.valueOf(this.praiseDays));
    localContentValues.put("praiseHotLevel", Integer.valueOf(this.praiseHotLevel));
    localContentValues.put("pttChangeVoiceType", Integer.valueOf(this.pttChangeVoiceType));
    localContentValues.put("qzoneHotDays", Integer.valueOf(this.qzoneHotDays));
    localContentValues.put("qzoneVisitType", Integer.valueOf(this.qzoneVisitType));
    localContentValues.put("richBuffer", this.richBuffer);
    localContentValues.put("richTime", Long.valueOf(this.richTime));
    localContentValues.put("showC2CPanel", Integer.valueOf(this.showC2CPanel));
    localContentValues.put("timestamp", Long.valueOf(this.timestamp));
    localContentValues.put("topPositionTime", Long.valueOf(this.topPositionTime));
    localContentValues.put("uVipFont", Long.valueOf(this.uVipFont));
    localContentValues.put("uin", this.uin);
    localContentValues.put("vipFontType", Integer.valueOf(this.vipFontType));
    int i = 0;
    for (;;)
    {
      if (i < k) {
        try
        {
          Object localObject2 = (Field)((List)localObject1).get(i);
          if (TextUtils.equals(((Field)localObject2).getName(), "hiddenChatSwitch"))
          {
            if (!((Field)localObject2).isAccessible()) {
              ((Field)localObject2).setAccessible(true);
            }
            i = ((Integer)((Field)localObject2).get(this)).intValue();
            if (i != j)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("fieldHiddenChatSwitch=");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(",tmpHiddenChatSwitch=");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append(",hiddenChatSwitch=");
              ((StringBuilder)localObject1).append(this.hiddenChatSwitch);
              ((StringBuilder)localObject1).append(",uin=");
              ((StringBuilder)localObject1).append(this.uin);
              QLog.i("ExtensionInfo", 1, ((StringBuilder)localObject1).toString(), new RuntimeException("stackInfo"));
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("detailEventUin", this.uin);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append("");
              ((HashMap)localObject1).put("fieldHiddenChatSwitch", ((StringBuilder)localObject2).toString());
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append("");
              ((HashMap)localObject1).put("tmpHiddenChatSwitch", ((StringBuilder)localObject2).toString());
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.hiddenChatSwitch);
              ((StringBuilder)localObject2).append("");
              ((HashMap)localObject1).put("hiddenChatSwitch", ((StringBuilder)localObject2).toString());
              ((HashMap)localObject1).put("detailEventDes", "ExtensionInfo table doCreateContentValue, fieldHiddenChatSwitch != tmpHiddenChatSwitch ！！！");
              ((HashMap)localObject1).put("stackInfo", QLog.getStackTraceString(new RuntimeException("stackInfo")));
              StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance("", "hiddenChatSwitchDataError", true, 0L, 0L, (HashMap)localObject1, "", false);
              return localContentValues;
            }
          }
          else
          {
            i += 1;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          QLog.i("ExtensionInfo", 1, "ExtensionInfo table doCreateContentValue, getField error", localIllegalAccessException);
        }
      }
    }
    return localContentValues;
  }
  
  public <T extends IExtensionBusinessData> T getBusinessData(Class<T> paramClass, Object... paramVarArgs)
  {
    String str = paramClass.getName();
    if (!this.businessDataCache.containsKey(str)) {
      try
      {
        paramClass = (IExtensionBusinessData)paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
        this.businessDataCache.put(str, paramClass);
        paramClass = new StringBuilder();
        paramClass.append("getBusinessData, <init>");
        paramClass.append(str);
        QLog.d("ExtensionInfo", 1, paramClass.toString());
      }
      catch (Exception paramClass)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusinessData, <init>");
        localStringBuilder.append(str);
        QLog.d("ExtensionInfo", 1, localStringBuilder.toString(), paramClass);
      }
    }
    paramClass = (IExtensionBusinessData)this.businessDataCache.get(str);
    if (paramClass != null) {
      paramClass.a(this, paramVarArgs);
    }
    return paramClass;
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
  protected void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 433	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +216 -> 222
    //   9: new 703	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 706	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: astore_1
    //   18: new 708	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 711	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 714	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   34: checkcast 716	java/util/concurrent/ConcurrentHashMap
    //   37: putfield 718	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload_2
    //   41: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   44: goto +178 -> 222
    //   47: astore_1
    //   48: new 346	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: ldc_w 723
    //   60: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload_1
    //   66: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 35
    //   75: iconst_1
    //   76: aload_2
    //   77: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: goto +139 -> 222
    //   86: astore_2
    //   87: goto +86 -> 173
    //   90: astore_3
    //   91: goto +12 -> 103
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_1
    //   97: goto +76 -> 173
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: astore_1
    //   105: new 346	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload_2
    //   115: astore_1
    //   116: aload 4
    //   118: ldc_w 723
    //   121: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_2
    //   126: astore_1
    //   127: aload 4
    //   129: aload_3
    //   130: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 35
    //   141: iconst_1
    //   142: aload 4
    //   144: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_2
    //   151: ifnull +71 -> 222
    //   154: aload_2
    //   155: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   158: goto +64 -> 222
    //   161: astore_1
    //   162: new 346	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   169: astore_2
    //   170: goto -114 -> 56
    //   173: aload_1
    //   174: ifnull +46 -> 220
    //   177: aload_1
    //   178: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   181: goto +39 -> 220
    //   184: astore_1
    //   185: new 346	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   192: astore_3
    //   193: aload_3
    //   194: ldc_w 723
    //   197: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: aload_1
    //   203: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 35
    //   212: iconst_1
    //   213: aload_3
    //   214: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_2
    //   221: athrow
    //   222: aload_0
    //   223: getfield 427	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull +216 -> 444
    //   231: new 703	java/io/ByteArrayInputStream
    //   234: dup
    //   235: aload_1
    //   236: invokespecial 706	java/io/ByteArrayInputStream:<init>	([B)V
    //   239: astore_1
    //   240: new 708	java/io/ObjectInputStream
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 711	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   248: astore_2
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: aload_2
    //   253: invokevirtual 714	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   256: checkcast 716	java/util/concurrent/ConcurrentHashMap
    //   259: putfield 728	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   262: aload_2
    //   263: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   266: goto +178 -> 444
    //   269: astore_1
    //   270: new 346	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   277: astore_2
    //   278: aload_2
    //   279: ldc_w 723
    //   282: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_2
    //   287: aload_1
    //   288: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 35
    //   297: iconst_1
    //   298: aload_2
    //   299: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto +139 -> 444
    //   308: astore_2
    //   309: goto +86 -> 395
    //   312: astore_3
    //   313: goto +12 -> 325
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_1
    //   319: goto +76 -> 395
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_2
    //   325: aload_2
    //   326: astore_1
    //   327: new 346	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   334: astore 4
    //   336: aload_2
    //   337: astore_1
    //   338: aload 4
    //   340: ldc_w 723
    //   343: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_2
    //   348: astore_1
    //   349: aload 4
    //   351: aload_3
    //   352: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   355: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_2
    //   360: astore_1
    //   361: ldc 35
    //   363: iconst_1
    //   364: aload 4
    //   366: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_2
    //   373: ifnull +71 -> 444
    //   376: aload_2
    //   377: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   380: goto +64 -> 444
    //   383: astore_1
    //   384: new 346	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   391: astore_2
    //   392: goto -114 -> 278
    //   395: aload_1
    //   396: ifnull +46 -> 442
    //   399: aload_1
    //   400: invokevirtual 721	java/io/ObjectInputStream:close	()V
    //   403: goto +39 -> 442
    //   406: astore_1
    //   407: new 346	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   414: astore_3
    //   415: aload_3
    //   416: ldc_w 723
    //   419: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_3
    //   424: aload_1
    //   425: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 35
    //   434: iconst_1
    //   435: aload_3
    //   436: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_2
    //   443: athrow
    //   444: aload_0
    //   445: invokespecial 730	com/tencent/mobileqq/data/ExtensionInfo:notifyBusinessDataPostRead	()V
    //   448: new 346	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   455: astore_1
    //   456: aload_1
    //   457: ldc_w 732
    //   460: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 584	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   469: invokestatic 736	mqq/app/MobileQQ:getShortUinStr	(Ljava/lang/String;)Ljava/lang/String;
    //   472: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_1
    //   477: ldc_w 738
    //   480: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: aload_0
    //   486: getfield 220	com/tencent/mobileqq/data/ExtensionInfo:intimate_type	I
    //   489: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_1
    //   494: ldc_w 740
    //   497: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: aload_0
    //   503: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:hiddenChatSwitch	I
    //   506: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_1
    //   511: ldc_w 742
    //   514: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload_1
    //   519: aload_0
    //   520: getfield 200	com/tencent/mobileqq/data/ExtensionInfo:isSharingLocation	I
    //   523: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: ldc 35
    //   529: iconst_1
    //   530: aload_1
    //   531: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 744	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	ExtensionInfo
    //   4	25	1	localObject1	Object
    //   47	19	1	localException1	Exception
    //   96	43	1	localObject2	Object
    //   161	17	1	localException2	Exception
    //   184	19	1	localException3	Exception
    //   226	25	1	localObject3	Object
    //   269	19	1	localException4	Exception
    //   318	43	1	localObject4	Object
    //   383	17	1	localException5	Exception
    //   406	19	1	localException6	Exception
    //   455	76	1	localStringBuilder1	StringBuilder
    //   26	51	2	localObject5	Object
    //   86	1	2	localObject6	Object
    //   94	1	2	localObject7	Object
    //   102	197	2	localObject8	Object
    //   308	1	2	localObject9	Object
    //   316	1	2	localObject10	Object
    //   324	119	2	localStringBuilder2	StringBuilder
    //   90	1	3	localException7	Exception
    //   100	30	3	localException8	Exception
    //   192	22	3	localStringBuilder3	StringBuilder
    //   312	1	3	localException9	Exception
    //   322	30	3	localException10	Exception
    //   414	22	3	localStringBuilder4	StringBuilder
    //   112	253	4	localStringBuilder5	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/lang/Exception
    //   29	40	86	finally
    //   105	114	86	finally
    //   116	125	86	finally
    //   127	137	86	finally
    //   139	150	86	finally
    //   29	40	90	java/lang/Exception
    //   18	27	94	finally
    //   18	27	100	java/lang/Exception
    //   154	158	161	java/lang/Exception
    //   177	181	184	java/lang/Exception
    //   262	266	269	java/lang/Exception
    //   251	262	308	finally
    //   327	336	308	finally
    //   338	347	308	finally
    //   349	359	308	finally
    //   361	372	308	finally
    //   251	262	312	java/lang/Exception
    //   240	249	316	finally
    //   240	249	322	java/lang/Exception
    //   376	380	383	java/lang/Exception
    //   399	403	406	java/lang/Exception
  }
  
  protected void postwrite()
  {
    super.postwrite();
    if ((this.intimate_type == 1) || (this.hiddenChatSwitch == 1) || (this.isSharingLocation == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ExtensionInfo postwrite()，uin: ");
      localStringBuilder.append(MobileQQ.getShortUinStr(this.uin));
      localStringBuilder.append(", intimate_type:");
      localStringBuilder.append(this.intimate_type);
      localStringBuilder.append(", hiddenChatSwitch:");
      localStringBuilder.append(this.hiddenChatSwitch);
      localStringBuilder.append(", isSharingLocation:");
      localStringBuilder.append(this.isSharingLocation);
      QLog.i("ExtensionInfo", 1, localStringBuilder.toString());
    }
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: new 752	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 753	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 752	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 753	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_3
    //   20: aconst_null
    //   21: astore_1
    //   22: new 755	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 758	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 718	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: ifnull +24 -> 60
    //   39: aload_2
    //   40: aload_0
    //   41: getfield 718	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   44: invokevirtual 762	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   47: aload_2
    //   48: invokevirtual 765	java/io/ObjectOutputStream:flush	()V
    //   51: aload_0
    //   52: aload 5
    //   54: invokevirtual 769	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: putfield 433	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   60: aload_0
    //   61: getfield 728	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   64: ifnull +51 -> 115
    //   67: new 755	java/io/ObjectOutputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 758	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore_1
    //   77: aload_1
    //   78: aload_0
    //   79: getfield 728	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: invokevirtual 762	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   85: aload_1
    //   86: invokevirtual 765	java/io/ObjectOutputStream:flush	()V
    //   89: aload_0
    //   90: aload 4
    //   92: invokevirtual 769	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   95: putfield 427	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   98: goto +19 -> 117
    //   101: astore 4
    //   103: aload_1
    //   104: astore_3
    //   105: aload 4
    //   107: astore_1
    //   108: goto +337 -> 445
    //   111: astore_3
    //   112: goto +123 -> 235
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_2
    //   118: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   121: goto +39 -> 160
    //   124: astore_2
    //   125: new 346	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc_w 772
    //   137: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: aload_2
    //   143: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: ldc 35
    //   152: iconst_1
    //   153: aload_3
    //   154: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +183 -> 344
    //   164: aload_1
    //   165: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   168: goto +176 -> 344
    //   171: astore_1
    //   172: new 346	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: ldc_w 772
    //   184: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_2
    //   189: aload_1
    //   190: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 35
    //   199: iconst_1
    //   200: aload_2
    //   201: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto +137 -> 344
    //   210: astore_1
    //   211: goto +234 -> 445
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_1
    //   217: goto +18 -> 235
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_2
    //   223: goto +222 -> 445
    //   226: astore_3
    //   227: aconst_null
    //   228: astore 4
    //   230: aload_1
    //   231: astore_2
    //   232: aload 4
    //   234: astore_1
    //   235: new 346	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   242: astore 4
    //   244: aload 4
    //   246: ldc_w 772
    //   249: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 4
    //   255: aload_3
    //   256: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 35
    //   265: iconst_1
    //   266: aload 4
    //   268: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: ifnull +46 -> 321
    //   278: aload_2
    //   279: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   282: goto +39 -> 321
    //   285: astore_2
    //   286: new 346	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   293: astore_3
    //   294: aload_3
    //   295: ldc_w 772
    //   298: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_3
    //   303: aload_2
    //   304: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc 35
    //   313: iconst_1
    //   314: aload_3
    //   315: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_1
    //   322: ifnull +22 -> 344
    //   325: aload_1
    //   326: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   329: goto +15 -> 344
    //   332: astore_1
    //   333: new 346	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   340: astore_2
    //   341: goto -161 -> 180
    //   344: aload_0
    //   345: invokespecial 774	com/tencent/mobileqq/data/ExtensionInfo:notifyBusinessDataPreWrite	()V
    //   348: new 346	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   355: astore_1
    //   356: aload_1
    //   357: ldc_w 776
    //   360: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_1
    //   365: aload_0
    //   366: getfield 584	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   369: invokestatic 736	mqq/app/MobileQQ:getShortUinStr	(Ljava/lang/String;)Ljava/lang/String;
    //   372: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: ldc_w 738
    //   380: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_1
    //   385: aload_0
    //   386: getfield 220	com/tencent/mobileqq/data/ExtensionInfo:intimate_type	I
    //   389: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_1
    //   394: ldc_w 740
    //   397: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_1
    //   402: aload_0
    //   403: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:hiddenChatSwitch	I
    //   406: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_1
    //   411: ldc_w 742
    //   414: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_1
    //   419: aload_0
    //   420: getfield 200	com/tencent/mobileqq/data/ExtensionInfo:isSharingLocation	I
    //   423: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: ldc 35
    //   429: iconst_1
    //   430: aload_1
    //   431: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 744	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: return
    //   438: astore 4
    //   440: aload_1
    //   441: astore_3
    //   442: aload 4
    //   444: astore_1
    //   445: aload_2
    //   446: ifnull +50 -> 496
    //   449: aload_2
    //   450: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   453: goto +43 -> 496
    //   456: astore_2
    //   457: new 346	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   464: astore 4
    //   466: aload 4
    //   468: ldc_w 772
    //   471: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 4
    //   477: aload_2
    //   478: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: ldc 35
    //   487: iconst_1
    //   488: aload 4
    //   490: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_3
    //   497: ifnull +46 -> 543
    //   500: aload_3
    //   501: invokevirtual 770	java/io/ObjectOutputStream:close	()V
    //   504: goto +39 -> 543
    //   507: astore_2
    //   508: new 346	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   515: astore_3
    //   516: aload_3
    //   517: ldc_w 772
    //   520: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_3
    //   525: aload_2
    //   526: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: ldc 35
    //   535: iconst_1
    //   536: aload_3
    //   537: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto +5 -> 548
    //   546: aload_1
    //   547: athrow
    //   548: goto -2 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	ExtensionInfo
    //   21	144	1	localObject1	Object
    //   171	19	1	localException1	Exception
    //   210	1	1	localObject2	Object
    //   216	1	1	localObject3	Object
    //   220	11	1	localObject4	Object
    //   234	92	1	localStringBuilder1	StringBuilder
    //   332	1	1	localException2	Exception
    //   355	192	1	localObject5	Object
    //   31	87	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   124	19	2	localException3	Exception
    //   179	100	2	localObject6	Object
    //   285	19	2	localException4	Exception
    //   340	110	2	localStringBuilder2	StringBuilder
    //   456	22	2	localException5	Exception
    //   507	19	2	localException6	Exception
    //   19	86	3	localObject7	Object
    //   111	1	3	localException7	Exception
    //   132	22	3	localStringBuilder3	StringBuilder
    //   214	1	3	localException8	Exception
    //   226	30	3	localException9	Exception
    //   293	244	3	localObject8	Object
    //   16	75	4	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   101	5	4	localObject9	Object
    //   228	39	4	localStringBuilder4	StringBuilder
    //   438	5	4	localObject10	Object
    //   464	25	4	localStringBuilder5	StringBuilder
    //   7	46	5	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   77	98	101	finally
    //   77	98	111	java/lang/Exception
    //   117	121	124	java/lang/Exception
    //   164	168	171	java/lang/Exception
    //   32	60	210	finally
    //   60	77	210	finally
    //   32	60	214	java/lang/Exception
    //   60	77	214	java/lang/Exception
    //   22	32	220	finally
    //   22	32	226	java/lang/Exception
    //   278	282	285	java/lang/Exception
    //   325	329	332	java/lang/Exception
    //   235	274	438	finally
    //   449	453	456	java/lang/Exception
    //   500	504	507	java/lang/Exception
  }
  
  public <T extends IExtensionBusinessData> void putBusinessData(T paramT)
  {
    this.businessDataCache.put(paramT.getClass().getName(), paramT);
  }
  
  public void setTogetherBusiness(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      l = this.mTogetherBusinessFlag;
      this.mTogetherBusinessFlag = (paramInt | l);
      return;
    }
    long l = this.mTogetherBusinessFlag;
    this.mTogetherBusinessFlag = ((paramInt ^ 0xFFFFFFFF) & l);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtensionInfo toString{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSharingLocation=");
    localStringBuilder.append(this.isSharingLocation);
    localStringBuilder.append(", hiddenChatSwitch=");
    localStringBuilder.append(this.hiddenChatSwitch);
    localStringBuilder.append(", intimate_type=");
    localStringBuilder.append(this.intimate_type);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */