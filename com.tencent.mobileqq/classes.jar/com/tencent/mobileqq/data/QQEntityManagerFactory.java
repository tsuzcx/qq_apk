package com.tencent.mobileqq.data;

import afug;
import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.Environment;
import anhk;
import arig;
import ayvj;
import bbzh;
import bgmg;
import bkfj;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyActivityDAUInfo;
import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.message.UinToTinyId;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopCardEntity;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
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
import com.tencent.util.VersionUtils;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
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
  private static final Class[] EXTRA_CLASSES = { MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, ReadInJoyActivityDAUInfo.class, HotPicData.class, HotVideoData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, DynamicInfoEntity.class, DiyPendantEntity.class, ApolloObtainedActionData.class, RecentInviteUser.class, ApolloGameRedDot.class, InterestTagInfo.class, OcrRecogResult.class, ArDownloadInfo.class, BlessPtvModule.class, BlessWording.class, QQStoryUserInfo.class, HotPicSendData.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, HotChatInfo.class, ApolloGameData.class, EmoticonKeywords.class, BlessTask.class, VideoRedbagData.class, ApolloActionRecentData.class, TroopAioTopADInfo.class, NotificationRecommendTroopItem.class, FTSNewTroopSync.class, GuideData.class, FeedInfo.class, BeancurdMsg.class, APIQuotaEntity.class, AppInfo.class, QuestionSquareBean.class, CmGamePushItem.class, ApolloActionData.class, QZoneMsgEntityNew.class, ApolloPreDownloadData.class, ApolloBaseInfo.class, TraceData.class, PadFaceAd.class, GameNoticeInfo.class, ExtensionInfo.class, ApolloWhiteFaceID.class, MiniAppEntity.class, ColorNote.class, DesktopCardEntity.class, FrontBackData.class, DeskTopAppEntity.class, StickerRecommendEntity.class, StickerRecommendSortEntity.class, TofuItem.class };
  private static final String[] FORCE_IGNORED_TABLE = { "PAReportInfo", "CircleBuddy ", "CircleGroup ", "Sticker", "TopicInfo", "FriendMore", "FreshNewsNotify", "QQCardFolder", "bubble_diytext", "ApolloGameBtnData", "ApolloGameActivityConfig", "CardProfilev2", "SecMsgSession" };
  private static final String[] NO_ENTITY_TABLE = { "msg_sync_log", "msg_upgrade_log" };
  private static final String[] SYSTEM_TABLE;
  private static final String[] TABLE_TO_DROP = { "WhiteListItem", "TroopAIOCommonAppInfo", "TroopVideoUrlEntity", "FreshNewsInfo", "GodListConfig", "GodEntity", "DatingSig", "DatingFeedInfo", "OpenTroopInfo", "TroopStorySnapListEntity", "SearchHistoryEntity", "TroopTopicDetailInfo", "MiniAppInfo" };
  protected static boolean isUpdateFromLowV74;
  private static Class[] mVerifyClasses = { MessageRecord.class, RecentUser.class, Friends.class, TroopInfo.class };
  protected boolean bUpdated;
  
  static
  {
    SYSTEM_TABLE = new String[] { "android_metadata", "sqlite_sequence" };
  }
  
  public QQEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.name = paramString;
    this.TAG = "QQEntityManagerFactory";
  }
  
  public static void checkColumnChange(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str;
    Object localObject1;
    label828:
    label841:
    Class localClass;
    if (localCursor1 != null)
    {
      localObject2 = null;
      for (;;)
      {
        if (localCursor1.moveToNext())
        {
          str = SecurityUtile.decode(localCursor1.getString(0));
          Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
          if (localCursor2 != null)
          {
            if (str.equals("mr_fileManager")) {
              localObject1 = FileManagerEntity.class;
            }
            for (;;)
            {
              if (localObject1 != null) {
                OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject1);
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
              else if (str.equals(TroopAIOAppInfo.class.getSimpleName()))
              {
                localObject1 = TroopAIOAppInfo.class;
              }
              else if (str.equals("TroopInfoV2"))
              {
                localObject1 = TroopInfo.class;
              }
              else if (str.equals(VideoRedbagData.class.getSimpleName()))
              {
                localObject1 = VideoRedbagData.class;
              }
              else if ((bkfj.a(SYSTEM_TABLE, str)) || (bkfj.a(NO_ENTITY_TABLE, str)))
              {
                if (!QLog.isColorLevel()) {
                  break label1094;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is system or no entity table");
                localObject1 = null;
              }
              else if (bkfj.a(FORCE_IGNORED_TABLE, str))
              {
                if (!QLog.isColorLevel()) {
                  break label1094;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is force ignored");
                localObject1 = null;
              }
              else if (str.equals(ConfessConvInfo.getConversationInfoTableName()))
              {
                localObject1 = ConfessConvInfo.class;
              }
              else if (str.equals(UinToTinyId.getTinyTableName()))
              {
                localObject1 = UinToTinyId.class;
              }
              else
              {
                if (!needToDrop(str, paramInt1, paramInt2)) {
                  break label828;
                }
                paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
                localObject1 = null;
              }
            }
            if (localObject2 != null) {
              break label1087;
            }
            localObject1 = generateExtraClassMap(EXTRA_CLASSES);
            if (!((Map)localObject1).containsKey(str)) {
              break label1100;
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
    label1087:
    label1094:
    label1100:
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
      break label841;
      localObject1 = null;
      break;
    }
  }
  
  private static Map<String, Class> generateExtraClassMap(Class[] paramArrayOfClass)
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
  
  private static boolean needToDrop(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString.startsWith("RedPacketData_")) && (paramInt1 < 214)) {}
    while (bkfj.a(TABLE_TO_DROP, paramString)) {
      return true;
    }
    return false;
  }
  
  private void verifyDBVersion() {}
  
  public SQLiteOpenHelper build(String paramString)
  {
    verifyDBVersion();
    if (this.dbHelper == null)
    {
      if (!VersionUtils.isHoneycomb()) {
        break label187;
      }
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 325, new arig(this));
    }
    for (;;)
    {
      paramString = BaseApplicationImpl.getApplication();
      if ((paramString != null) && (paramString.getQQProcessName().equalsIgnoreCase(paramString.getPackageName()))) {
        paramString = new File(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      try
      {
        if (paramString.exists())
        {
          SQLiteOpenHelper.WAL_ENABLE = true;
          bgmg.d(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
        }
        QLog.d(this.TAG, 1, "walFlag: " + SQLiteOpenHelper.WAL_ENABLE);
        this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        QLog.d(this.TAG, 1, new Object[] { "new SQLiteOpenHelper = : ", this.dbHelper });
        return this.dbHelper;
        label187:
        this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 325);
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
  
  public void cleanOverDueCorruptDatabase()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
    if ((localFile.exists()) && (System.currentTimeMillis() - localFile.lastModified() > 604800000L)) {
      localFile.delete();
    }
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Groups()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Friends()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RecentUser()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Card()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DiscussionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PhoneContact()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord(1)));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new EmoticonPackage()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Emoticon()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new EmoticonTab()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RoamSetting()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopMemberInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopRemindSettingData()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShieldListInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ContactCard()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new QZoneCover()));
    MessageRecord localMessageRecord = bbzh.a(-1000);
    localMessageRecord.frienduin = String.valueOf(anhk.H);
    localMessageRecord.istroop = 1001;
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(localMessageRecord));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SearchHistory()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExtensionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new CommonlyUsedTroop()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExpiredPushBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new HotChatInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SpecialCareInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloBaseInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloPandora()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FileManagerEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportedBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MedalInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TempMsgInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PushSwitchGrayTipsInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppletsAccountInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ColorNote()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FrontBackData()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TofuItem()));
  }
  
  public EntityManager createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    ayvj localayvj = new ayvj(this.dbHelper, this.mName);
    this.closed = false;
    return localayvj;
  }
  
  public void doAfterUpgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  public boolean isUpdated()
  {
    return this.bUpdated;
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.dropAllTable();
      return;
    }
    if (paramInt1 < 112) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord(1)));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExtensionInfo()));
    }
    if (paramInt1 < 34)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DiscussionInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DiscussionInfo()));
    }
    if (paramInt1 < 115) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopAppInfo.class.getSimpleName()));
    }
    if (paramInt1 < 29) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
    }
    if (paramInt1 < 35) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PhoneContact()));
    }
    if (paramInt1 < 36)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("TroopSelfInfo"));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
      this.bUpdated = true;
    }
    if (paramInt1 < 41)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(Card.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Card()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(ResourcePluginInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ResourcePluginInfo()));
    }
    if (paramInt1 < 48)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(Setting.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Setting()));
    }
    if (paramInt1 <= 66) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SearchHistory()));
    }
    if (paramInt1 < 74) {
      isUpdateFromLowV74 = true;
    }
    if (paramInt1 <= 84)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExpiredPushBanner()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShortVideoUpInfo()));
    }
    if (paramInt1 <= 89) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new HotChatInfo()));
    }
    if (paramInt1 <= 98) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()));
    }
    if (paramInt1 < 102) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SpecialCareInfo()));
    }
    if (paramInt1 < 103) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("RecommendMessage"));
    }
    if (paramInt1 < 125)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloBaseInfo()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloPandora()));
    }
    if (paramInt1 < 113)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DateEventMsg.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingRecentDetail.class.getSimpleName()));
    }
    if (paramInt1 < 125) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("t_qqcard_item"));
    }
    if (paramInt1 < 137) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MessageRecord.getTableName(anhk.M, 0)));
    }
    if (paramInt1 < 145) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ContactCard()));
    }
    if (paramInt1 < 184)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "upgradeDatabase, change troopInfo table, newVer=" + paramInt2 + ", oldVer=" + paramInt1);
      }
    }
    if (paramInt1 < 185) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportedBanner()));
    }
    if (paramInt1 < 188)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("CircleBuddy"));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("CircleGroup"));
    }
    if (paramInt1 < 189) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MedalInfo()));
    }
    if (paramInt1 < 217) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(TroopAIOAppInfo.class)));
    }
    if (paramInt1 < 233)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowRecommend.class)));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(PushRecommend.class)));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowExposure.class)));
    }
    if (paramInt1 < 238) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TempMsgInfo()));
    }
    if (paramInt1 < 241) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PushSwitchGrayTipsInfo()));
    }
    if (paramInt1 < 242) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppletsAccountInfo()));
    }
    if (paramInt1 < 242) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new OcrRecogResult()));
    }
    if (paramInt1 < 282) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ColorNote()));
    }
    if (paramInt1 < 300) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FrontBackData()));
    }
    if (paramInt1 < 307)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DeskTopAppEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DeskTopAppEntity()));
    }
    if (paramInt1 < 309) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TofuItem()));
    }
    checkColumnChange(getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public boolean verifyAuthentication()
  {
    return super.verifyAuthentication();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */