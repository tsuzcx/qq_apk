package com.tencent.qidian.controller;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.util.LoginUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.cs.cmd0x6ff.subcmd0x519.CRMMsgHead;
import tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuRspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.RetInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x519.RspBody;

public class QidianPubAccountBigDataHandler
  extends BigDataHandler
{
  public static final AtomicBoolean d = new AtomicBoolean(false);
  public Map<Long, PubAccountNavigationMenu> c = null;
  
  public QidianPubAccountBigDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    ThreadManager.post(new QidianPubAccountBigDataHandler.1(this), 8, null, true);
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 51
    //   8: iconst_4
    //   9: ldc 53
    //   11: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 59	com/tencent/qidian/controller/QidianPubAccountBigDataHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   21: invokevirtual 71	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 74	com/tencent/qidian/controller/QidianPubAccountBigDataHandler:a	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   30: aload_1
    //   31: invokevirtual 79	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   34: goto +51 -> 85
    //   37: astore_2
    //   38: goto +55 -> 93
    //   41: astore_2
    //   42: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq -15 -> 30
    //   48: new 81	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: ldc 84
    //   59: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: aload_2
    //   65: invokevirtual 92	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 51
    //   74: iconst_2
    //   75: aload_3
    //   76: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: goto -52 -> 30
    //   85: getstatic 19	com/tencent/qidian/controller/QidianPubAccountBigDataHandler:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: iconst_1
    //   89: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   92: return
    //   93: aload_1
    //   94: invokevirtual 79	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   97: goto +5 -> 102
    //   100: aload_2
    //   101: athrow
    //   102: goto -2 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	QidianPubAccountBigDataHandler
    //   24	70	1	localEntityManager	EntityManager
    //   37	1	2	localObject	Object
    //   41	60	2	localException	Exception
    //   55	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   25	30	37	finally
    //   42	82	37	finally
    //   25	30	41	java/lang/Exception
  }
  
  private void a(long paramLong1, PubAccountNavigationMenu paramPubAccountNavigationMenu, long paramLong2)
  {
    Object localObject1 = this.a.getCurrentAccountUin();
    try
    {
      paramLong2 = Long.parseLong((String)localObject1);
      localObject1 = new subcmd0x519.GetNavigationMenuReqBody();
      ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint64_puin.set(paramLong1);
      Object localObject2 = ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint32_ver_no;
      int i;
      if (paramPubAccountNavigationMenu == null) {
        i = 0;
      } else {
        i = paramPubAccountNavigationMenu.version;
      }
      ((PBUInt32Field)localObject2).set(i);
      ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint64_uin.set(paramLong2);
      localObject2 = new subcmd0x519.ReqBody();
      ((subcmd0x519.ReqBody)localObject2).uint32_sub_cmd.set(36);
      ((subcmd0x519.ReqBody)localObject2).msg_get_navigation_menu_req.set((MessageMicro)localObject1);
      localObject1 = new subcmd0x519.CRMMsgHead();
      ((subcmd0x519.CRMMsgHead)localObject1).uint32_ver_no.set(LoginUtils.a("8.8.17"));
      ((subcmd0x519.CRMMsgHead)localObject1).uint32_crm_sub_cmd.set(36);
      ((subcmd0x519.CRMMsgHead)localObject1).uint32_clienttype.set(2);
      ((subcmd0x519.CRMMsgHead)localObject1).uint64_kf_uin.set(paramLong1);
      ((subcmd0x519.CRMMsgHead)localObject1).uint64_puin.set(paramLong1);
      ((subcmd0x519.ReqBody)localObject2).msg_crm_common_head.set((MessageMicro)localObject1);
      a(3001, (MessageMicro)localObject2, 1305, paramPubAccountNavigationMenu);
      return;
    }
    catch (Exception paramPubAccountNavigationMenu) {}
  }
  
  private void a(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.query(PubAccountNavigationMenu.class);
      if (paramEntityManager != null)
      {
        paramEntityManager = paramEntityManager.iterator();
        while (paramEntityManager.hasNext())
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu = (PubAccountNavigationMenu)paramEntityManager.next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadMenus query from db: ");
            localStringBuilder.append(localPubAccountNavigationMenu);
            QLog.d("QidianPubAccountBigDataHandler", 4, localStringBuilder.toString());
          }
          if (!this.c.containsKey(Long.valueOf(localPubAccountNavigationMenu.puin))) {
            this.c.put(Long.valueOf(localPubAccountNavigationMenu.puin), localPubAccountNavigationMenu);
          }
        }
      }
    }
  }
  
  private void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    this.c.put(Long.valueOf(paramPubAccountNavigationMenu.puin), paramPubAccountNavigationMenu);
    ThreadManager.post(new QidianPubAccountBigDataHandler.3(this, paramPubAccountNavigationMenu), 5, null, true);
  }
  
  private void a(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    if ((paramBoolean) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new subcmd0x519.RspBody();
        ((subcmd0x519.RspBody)localObject).mergeFrom((byte[])paramArrayOfByte);
        localObject = ((subcmd0x519.RspBody)localObject).msg_get_navigation_menu_rsp;
        subcmd0x519.RetInfo localRetInfo = (subcmd0x519.RetInfo)((subcmd0x519.GetNavigationMenuRspBody)localObject).msg_ret.get();
        i = localRetInfo.uint32_ret_code.get();
        if (i == 0)
        {
          if ((!((subcmd0x519.GetNavigationMenuRspBody)localObject).int32_is_show.has()) || (((subcmd0x519.GetNavigationMenuRspBody)localObject).int32_is_show.get() != 1)) {
            break label436;
          }
          paramBoolean = true;
          if (!((subcmd0x519.GetNavigationMenuRspBody)localObject).str_struct_msg.has()) {
            break label441;
          }
          paramArrayOfByte = ((subcmd0x519.GetNavigationMenuRspBody)localObject).str_struct_msg.get();
          if (!((subcmd0x519.GetNavigationMenuRspBody)localObject).uint32_ver_no.has()) {
            break label448;
          }
          i = ((subcmd0x519.GetNavigationMenuRspBody)localObject).uint32_ver_no.get();
          if (paramObject == null) {
            break label454;
          }
          paramObject = (PubAccountNavigationMenu)paramObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleGetNatigationMenu isShow: ");
            ((StringBuilder)localObject).append(paramBoolean);
            ((StringBuilder)localObject).append(" version: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" | xml: ");
            ((StringBuilder)localObject).append(paramArrayOfByte);
            QLog.d("QidianPubAccountBigDataHandler", 2, ((StringBuilder)localObject).toString());
          }
          localObject = paramObject;
          if (paramObject == null) {
            localObject = new PubAccountNavigationMenu();
          }
          if (paramArrayOfByte != null)
          {
            paramObject = paramArrayOfByte;
            if (paramArrayOfByte.length() != 0) {}
          }
          else
          {
            paramObject = ((PubAccountNavigationMenu)localObject).xml;
          }
          ((PubAccountNavigationMenu)localObject).xml = paramObject;
          ((PubAccountNavigationMenu)localObject).version = i;
          a((PubAccountNavigationMenu)localObject);
          if (paramBoolean)
          {
            notifyUI(3001, true, localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            break label435;
          }
          QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu no need show");
          return;
        }
        notifyUI(3001, false, null);
        paramArrayOfByte = "Unknown error";
        if (localRetInfo.str_error_msg.has()) {
          paramArrayOfByte = localRetInfo.str_error_msg.get();
        }
        if (!QLog.isColorLevel()) {
          break label435;
        }
        paramObject = new StringBuilder();
        paramObject.append("handleGetNatigationMenu error: ");
        paramObject.append(i);
        paramObject.append(" msg: ");
        paramObject.append(paramArrayOfByte);
        QLog.d("QidianPubAccountBigDataHandler", 2, paramObject.toString());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        notifyUI(3001, false, null);
        paramArrayOfByte.printStackTrace();
        return;
      }
      notifyUI(3001, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu fail");
      }
      label435:
      return;
      label436:
      paramBoolean = false;
      continue;
      label441:
      paramArrayOfByte = "";
      continue;
      label448:
      int i = 0;
      continue;
      label454:
      paramObject = null;
    }
  }
  
  public PubAccountNavigationMenu a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = (PubAccountNavigationMenu)this.c.get(Long.valueOf(l));
      if (paramString != null) {
        return paramString;
      }
      if (d.get()) {
        return null;
      }
      a(l);
      paramString = (PubAccountNavigationMenu)this.c.get(Long.valueOf(l));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  protected void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    if (paramInt2 != 1305)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianPubAccountBigDataHandler", 2, "recevie but not 0x519");
      }
      return;
    }
    if (paramInt1 != 3001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 2, "recevie CMD_BIG_DATA_GET_NATIGATION_MENU,begin to handle...");
    }
    a(paramBoolean, paramArrayOfByte, paramObject);
  }
  
  public void a(long paramLong)
  {
    if (!d.get())
    {
      Object localObject = this.a.getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        localObject = (PubAccountNavigationMenu)((EntityManager)localObject).find(PubAccountNavigationMenu.class, new String[] { String.valueOf(paramLong) });
        if (localObject != null) {
          this.c.put(Long.valueOf(((PubAccountNavigationMenu)localObject).puin), localObject);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 2, "getNatigationMenu: BEGIN");
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = (PubAccountNavigationMenu)this.c.get(Long.valueOf(l));
      if (paramString != null)
      {
        a(l, paramString, paramLong);
      }
      else if (d.get())
      {
        paramString = new PubAccountNavigationMenu();
        paramString.version = 0;
        paramString.puin = l;
        paramString.xml = "";
        a(l, paramString, paramLong);
      }
      else
      {
        ThreadManager.post(new QidianPubAccountBigDataHandler.2(this, l, paramLong), 8, null, true);
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNatigationMenu error: ");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("QidianPubAccountBigDataHandler", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 2, "getNatigationMenu: END");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QidianBusinessObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.set(false);
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler
 * JD-Core Version:    0.7.0.1
 */