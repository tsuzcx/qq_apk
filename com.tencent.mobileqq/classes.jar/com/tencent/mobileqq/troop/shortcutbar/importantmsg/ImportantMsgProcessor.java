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
  private BaseChatPie a;
  private QQAppInterface b;
  private IShortcutBarDataProvider c;
  private long d;
  private Observer e;
  
  private void a(ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    paramArrayList = ImportantMsgUtil.a(paramArrayList);
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.c;
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
      if (paramObject.troopUin != this.d) {
        return;
      }
      a(paramObject.getMsgInfoList());
      return;
    }
    if (((paramObject instanceof HashMap)) && (((HashMap)paramObject).containsKey(Long.valueOf(this.d))))
    {
      paramObject = new StringBuilder();
      paramObject.append("updateInternal seqChange: mTroopUin:");
      paramObject.append(this.d);
      QLog.i("ImportantMsgProcessor", 2, paramObject.toString());
      paramObject = (ImportantMsgManager)this.b.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER);
      paramObject.a(this.d, new ImportantMsgProcessor.3(this, paramObject));
    }
  }
  
  private void e()
  {
    this.e = new ImportantMsgProcessor.1(this);
    ((ImportantMsgManager)this.b.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).addObserver(this.e);
    f();
  }
  
  private void f()
  {
    Object localObject = (ImportantMsgManager)this.b.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER);
    long l = SystemClock.uptimeMillis();
    ((ImportantMsgManager)localObject).a(this.d, new ImportantMsgProcessor.2(this, (ImportantMsgManager)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initData Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
    ((StringBuilder)localObject).append("ms");
    QLog.i("ImportantMsgProcessor", 2, ((StringBuilder)localObject).toString());
  }
  
  private void g()
  {
    if (this.e != null)
    {
      ((ImportantMsgManager)this.b.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).deleteObserver(this.e);
      this.e = null;
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
      BaseChatPie localBaseChatPie = this.a;
      if ((localBaseChatPie != null) && (localBaseChatPie.aE() != null))
      {
        paramObject = (ImportantMsgInfo)paramObject;
        this.b.getMessageFacade().getLastMessage(String.valueOf(this.d), this.a.aE().a);
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
      ((ImportantMsgManager)this.b.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).a(this.d, new ArrayList(Arrays.asList(new Long[] { Long.valueOf(paramObject.b()) })), 1);
    }
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgProcessor
 * JD-Core Version:    0.7.0.1
 */