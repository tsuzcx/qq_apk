package com.tencent.mobileqq.data;

import aboc;
import android.annotation.TargetApi;
import android.database.Cursor;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyActivityDAUInfo;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

@TargetApi(11)
public class QQEntityManagerFactory
  extends EntityManagerFactory
{
  private static final Class[] EXTRA_CLASSES = { MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, ReadInJoyActivityDAUInfo.class, HotPicData.class, HotVideoData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, DynamicInfoEntity.class, DiyPendantEntity.class, ApolloObtainedActionData.class, RecentInviteUser.class, ApolloGameRedDot.class, InterestTagInfo.class, OcrRecogResult.class, ArDownloadInfo.class, BlessPtvModule.class, BlessWording.class, QQStoryUserInfo.class, HotPicSendData.class, PstnCardInfo.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, TroopTopicDetailInfo.class, HotChatInfo.class, ApolloGameData.class, EmoticonKeywords.class, BlessTask.class, VideoRedbagData.class, ApolloActionRecentData.class, TroopAioTopADInfo.class, NotificationRecommendTroopItem.class, ApolloGameModeData.class, FTSNewTroopSync.class };
  private static final String[] FORCE_IGNORED_TABLE = { "PAReportInfo", "CircleBuddy ", "CircleGroup ", "Sticker", "TopicInfo", "FriendMore", "FreshNewsNotify", "QQCardFolder", "bubble_diytext", "ApolloGameBtnData", "ApolloGameActivityConfig", "CardProfilev2", "SecMsgSession" };
  private static final String[] NO_ENTITY_TABLE = { "msg_sync_log", "msg_upgrade_log" };
  private static final String[] SYSTEM_TABLE;
  private static final String[] TABLE_TO_DROP = { "WhiteListItem", "TroopAIOCommonAppInfo", "TroopVideoUrlEntity", "FreshNewsInfo" };
  public static long corruptedTime = -1L;
  protected static boolean isUpdateFromLowV74;
  public String TAG = "QQEntityManagerFactory";
  protected boolean bUpdated;
  public SQLiteOpenHelper dbHelper;
  public QQEntityManagerFactory.SQLiteOpenHelperImpl mInnerDbHelper;
  public String name;
  
  static
  {
    SYSTEM_TABLE = new String[] { "android_metadata", "sqlite_sequence" };
  }
  
  public QQEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.name = paramString;
  }
  
  public static void checkColumnChange(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str;
    Object localObject1;
    label786:
    label799:
    Class localClass;
    if (localCursor1 != null)
    {
      localObject2 = null;
      for (;;)
      {
        if (localCursor1.moveToNext())
        {
          str = SecurityUtile.b(localCursor1.getString(0));
          Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
          if (localCursor2 != null)
          {
            if (str.equals("mr_fileManager")) {
              localObject1 = FileManagerEntity.class;
            }
            for (;;)
            {
              if (localObject1 != null) {
                OGEntityManager.a(localArrayList, str, localCursor2, (Class)localObject1);
              }
              localCursor2.close();
              break;
              if (str.equals(DataLineMsgRecord.tableName()))
              {
                localObject1 = DataLineMsgRecord.class;
              }
              else if (str.equals(MpfileTaskRecord.tableName()))
              {
                localObject1 = MpfileTaskRecord.class;
              }
              else if (str.equals(PrinterItemMsgRecord.tableName()))
              {
                localObject1 = PrinterItemMsgRecord.class;
              }
              else if (str.startsWith(RouterMsgRecord.tableBasicName()))
              {
                localObject1 = RouterMsgRecord.class;
              }
              else if (str.startsWith("mr_"))
              {
                localObject1 = MessageRecord.class;
              }
              else if (str.equals("recent"))
              {
                localObject1 = RecentUser.class;
              }
              else if (str.equals("recent_call"))
              {
                localObject1 = QCallRecent.class;
              }
              else if (str.equals(ConversationInfo.getConversationInfoTableName()))
              {
                localObject1 = ConversationInfo.class;
              }
              else if (str.equals(TroopBarData.class.getSimpleName()))
              {
                localObject1 = TroopBarData.class;
              }
              else if (str.equals("EcShopData"))
              {
                localObject1 = EcShopData.class;
              }
              else if (str.equals(TracePointsData.class.getSimpleName()))
              {
                localObject1 = TracePointsData.class;
              }
              else if (str.equals(TracePathData.class.getSimpleName()))
              {
                localObject1 = TracePathData.class;
              }
              else if (str.equals(QidianExternalInfo.class.getSimpleName()))
              {
                localObject1 = QidianExternalInfo.class;
              }
              else if (str.equals(QidianProfileUiInfo.class.getSimpleName()))
              {
                localObject1 = QidianProfileUiInfo.class;
              }
              else if (str.equals(BmqqAccountType.class.getSimpleName()))
              {
                localObject1 = BmqqAccountType.class;
              }
              else if (str.equals(PubAccountNavigationMenu.class.getSimpleName()))
              {
                localObject1 = PubAccountNavigationMenu.class;
              }
              else if (str.equals(QidianCorpInfo.class.getSimpleName()))
              {
                localObject1 = QidianCorpInfo.class;
              }
              else if (str.equals(QidianInternalInfo.class.getSimpleName()))
              {
                localObject1 = QidianInternalInfo.class;
              }
              else if (str.equals(QidianPAForWpa.class.getSimpleName()))
              {
                localObject1 = QidianPAForWpa.class;
              }
              else if (str.startsWith("TroopFileTansferItemEntity"))
              {
                localObject1 = TroopFileTansferItemEntity.class;
              }
              else if (str.startsWith("qc_"))
              {
                localObject1 = QCallRecord.class;
              }
              else if (str.equals("MessageRoamDate"))
              {
                localObject1 = RoamDate.class;
              }
              else if (str.equals(CardProfile.tableName()))
              {
                localObject1 = CardProfile.class;
              }
              else if (str.equals("TroopInfoV2"))
              {
                localObject1 = TroopInfo.class;
              }
              else if (str.equals(VideoRedbagData.class.getSimpleName()))
              {
                localObject1 = VideoRedbagData.class;
              }
              else if ((ArrayUtils.a(SYSTEM_TABLE, str)) || (ArrayUtils.a(NO_ENTITY_TABLE, str)))
              {
                if (!QLog.isColorLevel()) {
                  break label1052;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is system or no entity table");
                localObject1 = null;
              }
              else if (ArrayUtils.a(FORCE_IGNORED_TABLE, str))
              {
                if (!QLog.isColorLevel()) {
                  break label1052;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is force ignored");
                localObject1 = null;
              }
              else if (str.equals(ConfessConvInfo.getConversationInfoTableName()))
              {
                localObject1 = ConfessConvInfo.class;
              }
              else
              {
                if (!needToDrop(str, paramInt1, paramInt2)) {
                  break label786;
                }
                paramSQLiteDatabase.execSQL(TableBuilder.a(str));
                localObject1 = null;
              }
            }
            if (localObject2 != null) {
              break label1045;
            }
            localObject1 = generateExtraClassMap(EXTRA_CLASSES);
            if (!((Map)localObject1).containsKey(str)) {
              break label1058;
            }
            localClass = (Class)((Map)localObject1).get(str);
            localObject2 = localClass;
            if (QLog.isColorLevel()) {
              QLog.d("QQEntityManagerFactory", 2, "check table: " + str + " / " + localClass.getName());
            }
          }
        }
      }
    }
    label1045:
    label1052:
    label1058:
    for (Object localObject2 = localClass;; localObject2 = null)
    {
      for (;;)
      {
        if (localObject2 == null) {
          try
          {
            localClass = Class.forName(paramString + "." + str);
            localObject2 = localObject1;
            localObject1 = localClass;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQEntityManagerFactory", 2, "find unknown table: " + str);
            }
          }
        }
      }
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localCursor1.close();
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          paramSQLiteDatabase.execSQL((String)paramString.next());
        }
        paramSQLiteDatabase.setTransactionSuccessful();
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      }
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      return;
      localObject1 = localObject2;
      break label799;
      localObject1 = null;
      break;
    }
  }
  
  private static Map generateExtraClassMap(Class[] paramArrayOfClass)
  {
    HashMap localHashMap = new HashMap(paramArrayOfClass.length);
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = paramArrayOfClass[i];
      localHashMap.put(localClass.getSimpleName(), localClass);
      i += 1;
    }
    return localHashMap;
  }
  
  /* Error */
  public static String getSqliteLibraryVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_0
    //   6: ldc_w 448
    //   9: astore_3
    //   10: ldc_w 450
    //   13: aconst_null
    //   14: invokestatic 454	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aload 4
    //   21: astore_0
    //   22: aload_2
    //   23: astore_1
    //   24: aload_0
    //   25: ldc_w 456
    //   28: aconst_null
    //   29: invokevirtual 207	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 217 1 0
    //   41: ifeq +33 -> 74
    //   44: aload_2
    //   45: astore_1
    //   46: new 342	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   53: aload_3
    //   54: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: iconst_0
    //   59: invokeinterface 221 2 0
    //   64: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_3
    //   71: goto -38 -> 33
    //   74: aload_2
    //   75: ifnull +9 -> 84
    //   78: aload_2
    //   79: invokeinterface 248 1 0
    //   84: aload_3
    //   85: astore_1
    //   86: aload_0
    //   87: ifnull +9 -> 96
    //   90: aload_0
    //   91: invokevirtual 457	android/database/sqlite/SQLiteDatabase:close	()V
    //   94: aload_3
    //   95: astore_1
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: ldc_w 459
    //   104: astore_3
    //   105: ldc_w 461
    //   108: iconst_1
    //   109: ldc_w 463
    //   112: aload_2
    //   113: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_1
    //   117: ifnull +9 -> 126
    //   120: aload_1
    //   121: invokeinterface 248 1 0
    //   126: aload_3
    //   127: astore_1
    //   128: aload_0
    //   129: ifnull -33 -> 96
    //   132: aload_0
    //   133: invokevirtual 457	android/database/sqlite/SQLiteDatabase:close	()V
    //   136: ldc_w 459
    //   139: areturn
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload_1
    //   148: invokeinterface 248 1 0
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 457	android/database/sqlite/SQLiteDatabase:close	()V
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -21 -> 143
    //   167: astore_2
    //   168: goto -25 -> 143
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -73 -> 101
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: aload_3
    //   181: astore_2
    //   182: goto -81 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	153	0	localObject1	Object
    //   1	179	1	localObject2	Object
    //   3	76	2	localCursor	Cursor
    //   98	15	2	localThrowable1	java.lang.Throwable
    //   140	22	2	localObject3	Object
    //   163	1	2	localObject4	Object
    //   167	1	2	localObject5	Object
    //   171	8	2	localThrowable2	java.lang.Throwable
    //   181	1	2	localObject6	Object
    //   9	118	3	str	String
    //   177	4	3	localThrowable3	java.lang.Throwable
    //   17	3	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	19	98	java/lang/Throwable
    //   10	19	140	finally
    //   24	33	163	finally
    //   35	44	163	finally
    //   46	71	163	finally
    //   105	116	167	finally
    //   24	33	171	java/lang/Throwable
    //   35	44	177	java/lang/Throwable
    //   46	71	177	java/lang/Throwable
  }
  
  private static boolean needToDrop(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString.startsWith("RedPacketData_")) && (paramInt1 < 214)) {}
    while (ArrayUtils.a(TABLE_TO_DROP, paramString)) {
      return true;
    }
    return false;
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      if (!VersionUtils.e()) {
        break label183;
      }
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 219, new aboc(this));
    }
    for (;;)
    {
      paramString = BaseApplicationImpl.getApplication();
      if ((paramString != null) && (paramString.getProcessName().equalsIgnoreCase(paramString.getPackageName()))) {
        paramString = new File(SQLiteOpenHelper.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramString.exists())
        {
          SQLiteOpenHelper.jdField_a_of_type_Boolean = true;
          FileUtils.d(SQLiteOpenHelper.jdField_a_of_type_JavaLangString);
        }
        QLog.d(this.TAG, 1, "walFlag: " + SQLiteOpenHelper.jdField_a_of_type_Boolean);
        this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        QLog.d(this.TAG, 1, new Object[] { "new SQLiteOpenHelper = : ", this.dbHelper });
        return this.dbHelper;
        label183:
        this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 219);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, "build error", paramString);
        }
      }
    }
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Groups()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Friends()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RecentUser()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord(1)));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonPackage()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Emoticon()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonTab()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RoamSetting()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopMemberInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopRemindSettingData()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ShieldListInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ContactCard()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new QZoneCover()));
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = String.valueOf(AppConstants.G);
    localMessageRecord.istroop = 1001;
    paramSQLiteDatabase.execSQL(TableBuilder.a(localMessageRecord));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new CommonlyUsedTroop()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new HotChatInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new SpecialCareInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloBaseInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloPandora()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new FileManagerEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ReportedBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new MedalInfo()));
  }
  
  public String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  public boolean isUpdateFromLowV74()
  {
    return isUpdateFromLowV74;
  }
  
  public boolean isUpdated()
  {
    return this.bUpdated;
  }
  
  public void resetUpdateFromLowV74()
  {
    isUpdateFromLowV74 = false;
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.dropAllTable();
      return;
    }
    if (paramInt1 < 112) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord(1)));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
    }
    if (paramInt1 < 34)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(DiscussionInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
    }
    if (paramInt1 < 115) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopAppInfo.class.getSimpleName()));
    }
    if (paramInt1 < 29) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
    }
    if (paramInt1 < 35) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
    }
    if (paramInt1 < 36)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a("TroopSelfInfo"));
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
      this.bUpdated = true;
    }
    if (paramInt1 < 41)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(Card.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(ResourcePluginInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ResourcePluginInfo()));
    }
    if (paramInt1 < 48)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(Setting.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Setting()));
    }
    if (paramInt1 <= 66) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
    }
    if (paramInt1 < 74) {
      isUpdateFromLowV74 = true;
    }
    if (paramInt1 <= 84)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ShortVideoUpInfo()));
    }
    if (paramInt1 <= 89) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new HotChatInfo()));
    }
    if (paramInt1 <= 98) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingInfo.class.getSimpleName()));
    }
    if (paramInt1 < 102) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new SpecialCareInfo()));
    }
    if (paramInt1 < 103) {
      paramSQLiteDatabase.execSQL(TableBuilder.a("RecommendMessage"));
    }
    if (paramInt1 < 125)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloBaseInfo()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloPandora()));
    }
    if (paramInt1 < 113)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DateEventMsg.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingRecentDetail.class.getSimpleName()));
    }
    if (paramInt1 < 125) {
      paramSQLiteDatabase.execSQL(TableBuilder.a("t_qqcard_item"));
    }
    if (paramInt1 < 137) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(MessageRecord.getTableName(AppConstants.K, 0)));
    }
    if (paramInt1 < 145) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ContactCard()));
    }
    if (paramInt1 < 184)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "upgradeDatabase, change troopInfo table, newVer=" + paramInt2 + ", oldVer=" + paramInt1);
      }
    }
    if (paramInt1 < 185) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ReportedBanner()));
    }
    if (paramInt1 < 188)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a("CircleBuddy"));
      paramSQLiteDatabase.execSQL(TableBuilder.a("CircleGroup"));
    }
    if (paramInt1 < 189) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new MedalInfo()));
    }
    if (paramInt1 < 217) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(TableBuilder.b(TroopAIOAppInfo.class)));
    }
    checkColumnChange(getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      Ability localAbility = (Ability)localEntityManager.a(Ability.class, "flags=?", new String[] { String.valueOf(-1) });
      if (localAbility == null)
      {
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.b(localAbility);
        return true;
      }
      if ((localAbility.uin == null) || (!localAbility.uin.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.b(localAbility);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */