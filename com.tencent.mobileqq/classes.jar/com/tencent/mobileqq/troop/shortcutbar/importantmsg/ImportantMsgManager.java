package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class ImportantMsgManager
  extends Observable
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
  private HashMap<Long, ImportantMsgItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Long, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ImportantMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new ImportantMsgManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
  }
  
  private void a(long paramLong)
  {
    ImportantMsgItem localImportantMsgItem = (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localImportantMsgItem != null)
    {
      setChanged();
      notifyObservers(localImportantMsgItem);
    }
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    a(paramLong, paramArrayList, 2);
  }
  
  private void a(long paramLong, ArrayList<ImportantMsgItem.MsgInfo> paramArrayList, List<Long> paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("handlerRspImportantMsg mImportantDataMap notcontains troopUin:");
      paramArrayList.append(paramLong);
      QLog.i("ImportantMsgManager", 1, paramArrayList.toString());
      return;
    }
    paramList = (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      paramList.addMsgInfos(paramArrayList);
    }
    paramList.updateMaxMsgSeq();
    paramArrayList = new StringBuilder();
    paramArrayList.append("handlerRspImportantMsg reciveMaxSeq:");
    paramArrayList.append(paramList.maxImportantMsgSeq);
    paramArrayList.append(" registerProxy lastSeq:");
    paramArrayList.append(a(paramLong));
    QLog.i("ImportantMsgManager", 1, paramArrayList.toString());
    a(paramList.clone());
    a(paramLong);
  }
  
  private void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1)
  {
    if (!paramBoolean) {
      return;
    }
    a(paramLong, paramList, paramList1);
  }
  
  private void a(HashMap<Long, Integer> paramHashMap)
  {
    setChanged();
    notifyObservers(paramHashMap);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    int i = a(paramLong1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needReqImportantMsg lastMsgSeq svr: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" localMsgSeq:");
    localStringBuilder.append(paramLong2);
    QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
    return i > paramLong2;
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    return false;
  }
  
  private void b(long paramLong, ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      a(paramLong, new ImportantMsgManager.7(this, paramArrayList));
    }
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  protected ImportantMsgItem a(long paramLong)
  {
    ImportantMsgItem localImportantMsgItem = new ImportantMsgItem();
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ImportantMsgItem.class, false, "troopUin=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (ImportantMsgItem)((List)localObject).get(0);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readEntity exception + ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ImportantMsgManager", 1, localStringBuilder.toString(), localException);
      localImportantMsgItem.troopUin = paramLong;
    }
    return localImportantMsgItem;
  }
  
  public void a(long paramLong, ImportantMsgManager.callbackInMainThread paramcallbackInMainThread)
  {
    if (paramcallbackInMainThread == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      paramcallbackInMainThread.a(paramLong, (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      return;
    }
    ThreadManager.post(new ImportantMsgManager.6(this, paramLong, paramcallbackInMainThread), 5, null, false);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList, int paramInt)
  {
    ((ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).a(paramLong, new ImportantMsgManager.5(this, paramArrayList, paramInt));
  }
  
  public void a(long paramLong, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0xea3.BackMsg localBackMsg = (oidb_0xea3.BackMsg)paramList.next();
        ArrayList localArrayList2 = new ArrayList();
        ImportantMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBackMsg, localArrayList2);
        if (!localArrayList2.isEmpty()) {
          localArrayList1.add(localArrayList2.get(0));
        }
      }
    }
    a(paramLong, ImportantMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, localArrayList1, true), paramList1);
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.post(new ImportantMsgManager.8(this, paramEntity), 5, null, false);
  }
  
  public void a(ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (localTroopShortcutBarHandler == null) {
      return;
    }
    if (a(paramImportantMsgItem.troopUin, paramImportantMsgItem.maxImportantMsgSeq))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramImportantMsgItem.getMsgInfoList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(Long.valueOf(((ImportantMsgItem.MsgInfo)localIterator.next()).msgSeq));
      } while (localArrayList.size() < 20);
      localTroopShortcutBarHandler.a(paramImportantMsgItem.troopUin, localArrayList);
    }
  }
  
  public void onDestroy()
  {
    TroopShortcutBarObserver localTroopShortcutBarObserver = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
    if (localTroopShortcutBarObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localTroopShortcutBarObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager
 * JD-Core Version:    0.7.0.1
 */