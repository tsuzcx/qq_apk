package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observer;

public class ImportantMsgProcessor
  extends IShortcutBarProcessor
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private Observer jdField_a_of_type_JavaUtilObserver;
  
  private void a(ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    paramArrayList = ImportantMsgUtil.a(paramArrayList);
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localIShortcutBarDataProvider != null) {
      localIShortcutBarDataProvider.a(2, paramArrayList);
    }
  }
  
  private void c(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof ImportantMsgItem))
    {
      paramObject = (ImportantMsgItem)paramObject;
      if (paramObject.troopUin != this.jdField_a_of_type_Long) {
        return;
      }
      a(paramObject.getMsgInfoList());
      return;
    }
    if (((paramObject instanceof HashMap)) && (((HashMap)paramObject).containsKey(Long.valueOf(this.jdField_a_of_type_Long))))
    {
      paramObject = new StringBuilder();
      paramObject.append("updateInternal seqChange: mTroopUin:");
      paramObject.append(this.jdField_a_of_type_Long);
      QLog.i("ImportantMsgProcessor", 2, paramObject.toString());
      paramObject = (ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER);
      paramObject.a(this.jdField_a_of_type_Long, new ImportantMsgProcessor.3(this, paramObject));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilObserver = new ImportantMsgProcessor.1(this);
    ((ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    f();
  }
  
  private void f()
  {
    Object localObject = (ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER);
    long l = SystemClock.uptimeMillis();
    ((ImportantMsgManager)localObject).a(this.jdField_a_of_type_Long, new ImportantMsgProcessor.2(this, (ImportantMsgManager)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initData Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
    ((StringBuilder)localObject).append("ms");
    QLog.i("ImportantMsgProcessor", 2, ((StringBuilder)localObject).toString());
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilObserver != null)
    {
      ((ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_JavaUtilObserver = null;
    }
  }
  
  public void a()
  {
    g();
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof ImportantMsgInfo)) {
        return;
      }
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localBaseChatPie != null) && (localBaseChatPie.a() != null))
      {
        paramObject = (ImportantMsgInfo)paramObject;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a);
        return;
      }
      QLog.i("ImportantMsgProcessor", 2, "mChatPie == null or mChatPie.getSessionInfo() == null");
    }
  }
  
  public void b()
  {
    e();
  }
  
  public void b(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof ImportantMsgInfo)) {
        return;
      }
      paramObject = (ImportantMsgInfo)paramObject;
      ((ImportantMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).a(this.jdField_a_of_type_Long, new ArrayList(Arrays.asList(new Long[] { Long.valueOf(paramObject.a()) })), 1);
    }
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgProcessor
 * JD-Core Version:    0.7.0.1
 */