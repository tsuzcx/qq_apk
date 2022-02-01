package com.tencent.util;

import com.tencent.mobileqq.activity.aio.QcircleRedDotEntity;
import com.tencent.mobileqq.activity.aio.QzoneRedDotEntity;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.bridge.DBVersionProvider;
import com.tencent.mobileqq.persistence.bridge.EntityManagerFactoryBuilderServiceImpl;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBExistCheckCorruptionInterceptor;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBFixCorruptionInterceptor;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBReportCorruptionInterceptor;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity102;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity103;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity112;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity113;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity115;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity125;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity137;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity145;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity184;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity185;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity188;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity189;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity217;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity233;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity238;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity241;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity242;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity282;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity29;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity300;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity307;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity309;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity327;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity34;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity35;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity36;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity41;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity48;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity67;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity70;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity85;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity90;
import com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity99;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.BMQQAccountTypeInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.CardProfileInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.CommonTableColumnCheckInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConfessConvInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConversationInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.DataLineRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.DropTableInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ECShopDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.FileManagerInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ForceIgnoreInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.MPFileTaskInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.MessageRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.PrinterItemMsgRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.PubAccountNavigationMenuInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecentInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianCorpInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianExternalInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianInternalInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianPAForWPAInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianProfileUIInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RecentUserInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RoamDateInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RouterMsgRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.SystemOrNoEntityInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TracePathDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TracePointsDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopAIOAppInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopBarDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopFileTransferItemInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.UinToTinyIdInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.VideoRedBagDataInterceptor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DBBuildUtil
{
  private static final String TAG = "DBInjectUtil";
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends Interceptor<Void>>> sDBCorruptionInterceptorList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends Entity>> sDBCreateTableList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends IEntityManagerFactoryBuilderService>> sDBService = new ArrayList();
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends DBUpgradeEntity>> sDBUpgradeEntityList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends Interceptor<Class>>> sTableColumnCheckInterceptorList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends Entity>> sVerifyTableList;
  
  static
  {
    sDBService.add(EntityManagerFactoryBuilderServiceImpl.class);
    sDBCreateTableList = new ArrayList();
    sDBCreateTableList.add(Groups.class);
    sDBCreateTableList.add(Friends.class);
    sDBCreateTableList.add(RecentUser.class);
    sDBCreateTableList.add(Ability.class);
    sDBCreateTableList.add(TroopInfo.class);
    sDBCreateTableList.add(Card.class);
    sDBCreateTableList.add(DiscussionInfo.class);
    sDBCreateTableList.add(PhoneContact.class);
    sDBCreateTableList.add(DataLineMsgRecord.class);
    sDBCreateTableList.add(EmoticonPackage.class);
    sDBCreateTableList.add(Emoticon.class);
    sDBCreateTableList.add(EmoticonTab.class);
    sDBCreateTableList.add(RoamSetting.class);
    sDBCreateTableList.add(TroopMemberInfo.class);
    sDBCreateTableList.add(TroopRemindSettingData.class);
    sDBCreateTableList.add(ShieldListInfo.class);
    sDBCreateTableList.add(ContactCard.class);
    sDBCreateTableList.add(QZoneCover.class);
    sDBCreateTableList.add(SearchHistory.class);
    sDBCreateTableList.add(ExtensionInfo.class);
    sDBCreateTableList.add(CommonlyUsedTroop.class);
    sDBCreateTableList.add(ExpiredPushBanner.class);
    sDBCreateTableList.add(HotChatInfo.class);
    sDBCreateTableList.add(SpecialCareInfo.class);
    sDBCreateTableList.add(ApolloBaseInfo.class);
    sDBCreateTableList.add(ApolloPandora.class);
    sDBCreateTableList.add(FileManagerEntity.class);
    sDBCreateTableList.add(ReportedBanner.class);
    sDBCreateTableList.add(MedalInfo.class);
    sDBCreateTableList.add(TempMsgInfo.class);
    sDBCreateTableList.add(PushSwitchGrayTipsInfo.class);
    sDBCreateTableList.add(AppletsAccountInfo.class);
    sDBCreateTableList.add(ColorNote.class);
    sDBCreateTableList.add(FrontBackData.class);
    sDBCreateTableList.add(TofuItem.class);
    sDBCreateTableList.add(TroopEssenceMsgItem.class);
    sDBCreateTableList.add(QcircleRedDotEntity.class);
    sDBCreateTableList.add(QzoneRedDotEntity.class);
    sVerifyTableList = new ArrayList();
    sVerifyTableList.add(MessageRecord.class);
    sVerifyTableList.add(RecentUser.class);
    sVerifyTableList.add(Friends.class);
    sVerifyTableList.add(TroopInfo.class);
    sDBCorruptionInterceptorList = new ArrayList();
    sDBCorruptionInterceptorList.add(DBExistCheckCorruptionInterceptor.class);
    sDBCorruptionInterceptorList.add(DBReportCorruptionInterceptor.class);
    sDBCorruptionInterceptorList.add(DBFixCorruptionInterceptor.class);
    sTableColumnCheckInterceptorList = new ArrayList();
    sTableColumnCheckInterceptorList.add(FileManagerInterceptor.class);
    sTableColumnCheckInterceptorList.add(DataLineRecordInterceptor.class);
    sTableColumnCheckInterceptorList.add(MPFileTaskInterceptor.class);
    sTableColumnCheckInterceptorList.add(PrinterItemMsgRecordInterceptor.class);
    sTableColumnCheckInterceptorList.add(RouterMsgRecordInterceptor.class);
    sTableColumnCheckInterceptorList.add(MessageRecordInterceptor.class);
    sTableColumnCheckInterceptorList.add(RecentUserInterceptor.class);
    sTableColumnCheckInterceptorList.add(QCallRecentInterceptor.class);
    sTableColumnCheckInterceptorList.add(ConversationInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(TroopBarDataInterceptor.class);
    sTableColumnCheckInterceptorList.add(ECShopDataInterceptor.class);
    sTableColumnCheckInterceptorList.add(TracePointsDataInterceptor.class);
    sTableColumnCheckInterceptorList.add(TracePathDataInterceptor.class);
    sTableColumnCheckInterceptorList.add(QiDianExternalInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(QiDianProfileUIInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(BMQQAccountTypeInterceptor.class);
    sTableColumnCheckInterceptorList.add(PubAccountNavigationMenuInterceptor.class);
    sTableColumnCheckInterceptorList.add(QiDianCorpInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(QiDianInternalInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(QiDianPAForWPAInterceptor.class);
    sTableColumnCheckInterceptorList.add(TroopFileTransferItemInterceptor.class);
    sTableColumnCheckInterceptorList.add(QCallRecordInterceptor.class);
    sTableColumnCheckInterceptorList.add(RoamDateInterceptor.class);
    sTableColumnCheckInterceptorList.add(CardProfileInterceptor.class);
    sTableColumnCheckInterceptorList.add(TroopAIOAppInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(TroopInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(VideoRedBagDataInterceptor.class);
    sTableColumnCheckInterceptorList.add(SystemOrNoEntityInterceptor.class);
    sTableColumnCheckInterceptorList.add(ForceIgnoreInterceptor.class);
    sTableColumnCheckInterceptorList.add(ConfessConvInfoInterceptor.class);
    sTableColumnCheckInterceptorList.add(UinToTinyIdInterceptor.class);
    sTableColumnCheckInterceptorList.add(DropTableInterceptor.class);
    sTableColumnCheckInterceptorList.add(CommonTableColumnCheckInterceptor.class);
    sDBUpgradeEntityList = new ArrayList();
    sDBUpgradeEntityList.add(DBUpgradeEntity29.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity34.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity35.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity36.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity41.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity48.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity67.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity70.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity85.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity90.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity99.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity102.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity103.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity112.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity113.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity115.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity125.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity137.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity145.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity184.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity185.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity188.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity189.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity217.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity233.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity238.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity241.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity242.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity282.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity300.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity307.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity309.class);
    sDBUpgradeEntityList.add(DBUpgradeEntity327.class);
  }
  
  private static List<Interceptor<Void>> createDBCorruptionInterceptorList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = sDBCorruptionInterceptorList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        localArrayList.add(localClass.newInstance());
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DBInjectUtil", 1, localThrowable, new Object[0]);
      }
    }
    return localArrayList;
  }
  
  private static List<DBUpgradeEntity> createDBUpgradeEntityList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = sDBUpgradeEntityList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        localArrayList.add(localClass.newInstance());
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DBInjectUtil", 1, localThrowable, new Object[0]);
      }
    }
    return localArrayList;
  }
  
  private static List<Entity> createOnDBCreateTableList(IEntityManagerFactoryBuilderService paramIEntityManagerFactoryBuilderService)
  {
    paramIEntityManagerFactoryBuilderService = new ArrayList(Arrays.asList((Object[])paramIEntityManagerFactoryBuilderService.getDBCreateTableProvider().get()));
    Iterator localIterator = sDBCreateTableList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        paramIEntityManagerFactoryBuilderService.add(localClass.newInstance());
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DBInjectUtil", 1, localThrowable, new Object[0]);
      }
    }
    return paramIEntityManagerFactoryBuilderService;
  }
  
  private static List<Interceptor<Class>> createTableColumnCheckList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = sTableColumnCheckInterceptorList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        localArrayList.add(localClass.newInstance());
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DBInjectUtil", 1, localThrowable, new Object[0]);
      }
    }
    return localArrayList;
  }
  
  public static QQEntityManagerFactory.Builder getDefaultEntityManagerFactoryBuilder(String paramString)
  {
    paramString = new QQEntityManagerFactory.Builder(paramString, new DBVersionProvider());
    try
    {
      IEntityManagerFactoryBuilderService localIEntityManagerFactoryBuilderService = (IEntityManagerFactoryBuilderService)((Class)sDBService.get(0)).newInstance();
      paramString.tableEntityList(createOnDBCreateTableList(localIEntityManagerFactoryBuilderService)).verifyClassList(sVerifyTableList).corruptionInterceptors(createDBCorruptionInterceptorList()).onDBTableVerifyFailListener(localIEntityManagerFactoryBuilderService.getDBVerifyFailHandler()).tableColumnCheckInterceptors(createTableColumnCheckList()).onDBUpgradeListener(localIEntityManagerFactoryBuilderService.getDBUpGradeListener()).dbUpgradeEntityList(createDBUpgradeEntityList()).afterDBUpgradeListener(localIEntityManagerFactoryBuilderService.getDBUpGradeFinishListener());
      return paramString;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DBInjectUtil", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.DBBuildUtil
 * JD-Core Version:    0.7.0.1
 */