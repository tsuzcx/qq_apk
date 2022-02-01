package com.tencent.mobileqq.tofumsg;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.BeancurdHandler;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.beancurd.IBeancurdUpdater;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TofuManagerNew
  implements IBeancurdUpdater, ITofuManagerNew
{
  private final QQAppInterface a;
  private BeancurdHandler b;
  private final TofuConfigNew c;
  private final ConcurrentHashMap<String, CopyOnWriteArrayList<TofuLimitMsg>> d;
  private final CopyOnWriteArrayList<NewBeancurdMsg> e;
  private volatile boolean f = false;
  private volatile boolean g = false;
  @Nullable
  private BaseSessionInfo h;
  private final Object i;
  
  public TofuManagerNew()
  {
    this.a = null;
    this.c = null;
    this.d = new ConcurrentHashMap();
    this.e = new CopyOnWriteArrayList();
    this.i = new Object();
  }
  
  public TofuManagerNew(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((BeancurdHandler)paramQQAppInterface.getBusinessHandler(BeancurdHandler.class.getName()));
    this.b.a(this);
    this.c = new TofuConfigNew();
    this.d = new ConcurrentHashMap();
    this.e = new CopyOnWriteArrayList();
    this.i = new Object();
  }
  
  private CopyOnWriteArrayList<TofuLimitMsg> a(CopyOnWriteArrayList<TofuLimitMsg> paramCopyOnWriteArrayList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      TofuLimitMsg localTofuLimitMsg = (TofuLimitMsg)paramCopyOnWriteArrayList.next();
      if (b(localTofuLimitMsg)) {
        localCopyOnWriteArrayList.add(localTofuLimitMsg);
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  private void a(@NonNull NewBeancurdMsg paramNewBeancurdMsg, TofuLimitMsg paramTofuLimitMsg)
  {
    MessageRecord localMessageRecord = c(paramNewBeancurdMsg);
    if (!MessageHandlerUtils.a(this.a, localMessageRecord, false))
    {
      a(paramNewBeancurdMsg.frienduin, (int)paramTofuLimitMsg.businessId);
      this.a.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
      c(paramTofuLimitMsg);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 32, null, false);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = a(paramInt);
    paramString = this.a.getMessageFacade().a(paramString, 0, (int[])localObject);
    if (!ListUtils.a(paramString))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (MessageRecord)paramString.next();
        if (localObject != null)
        {
          this.a.getMessageFacade().a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).msgtype, ((MessageRecord)localObject).uniseq);
          this.a.getMessageFacade().h(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq);
        }
      }
    }
  }
  
  private boolean a(TofuLimitMsg paramTofuLimitMsg)
  {
    return a(b(paramTofuLimitMsg.friendUin), paramTofuLimitMsg);
  }
  
  private boolean a(CopyOnWriteArrayList<TofuLimitMsg> paramCopyOnWriteArrayList, TofuLimitMsg paramTofuLimitMsg)
  {
    Iterator localIterator;
    if ((paramTofuLimitMsg.flag & 0x1) == 1)
    {
      localIterator = paramCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((TofuLimitMsg)localIterator.next()).businessMsgId, paramTofuLimitMsg.businessMsgId))
        {
          j = 1;
          break label56;
        }
      }
    }
    int j = 0;
    label56:
    if (j != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("TofuNew.TofuManagerNew", 2, "isRepeat = true");
      }
    }
    for (;;)
    {
      bool = false;
      break label261;
      paramCopyOnWriteArrayList = a(paramCopyOnWriteArrayList);
      localIterator = paramCopyOnWriteArrayList.iterator();
      j = 0;
      while (localIterator.hasNext()) {
        if (((TofuLimitMsg)localIterator.next()).businessId == paramTofuLimitMsg.businessId) {
          j += 1;
        }
      }
      if (j >= this.c.a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "businessMsgCount = ", Integer.valueOf(j), ", config = ", Integer.valueOf(this.c.a) });
        }
      }
      else
      {
        if (ListUtils.b(paramCopyOnWriteArrayList) < this.c.b) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "ListUtils.size(filterMsgList) = ", Integer.valueOf(ListUtils.b(paramCopyOnWriteArrayList)), ", config = ", Integer.valueOf(this.c.b) });
        }
      }
    }
    boolean bool = true;
    label261:
    QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "realCheckCanInsert tofuMsg = ", paramTofuLimitMsg.toString(), ", canInsert = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  @NonNull
  private CopyOnWriteArrayList<TofuLimitMsg> b(String paramString)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.d.get(paramString);
    if (localObject1 == null) {
      synchronized (this.i)
      {
        CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.d.get(paramString);
        localObject1 = localCopyOnWriteArrayList;
        if (localCopyOnWriteArrayList == null)
        {
          localObject1 = TofuProxy.a().a(this.a, paramString);
          this.d.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private void b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(this.e);
    this.e.clear();
    a(new TofuManagerNew.3(this, localCopyOnWriteArrayList));
  }
  
  private boolean b(TofuLimitMsg paramTofuLimitMsg)
  {
    return NetConnInfoCenter.getServerTime() * 1000L - paramTofuLimitMsg.insertMsgTime < this.c.c;
  }
  
  private MessageRecord c(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    String str = paramNewBeancurdMsg.frienduin;
    MessageRecord localMessageRecord = MessageRecordFactory.a(-7016);
    localMessageRecord.init(this.a.getAccount(), str, str, paramNewBeancurdMsg.extensionInfoStr, -1L, -7016, 0, -1L);
    localMessageRecord.isread = true;
    return localMessageRecord;
  }
  
  private void c(@NonNull TofuLimitMsg paramTofuLimitMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "realInsertTofuMsg, msg = ", paramTofuLimitMsg.toString() });
    }
    b(paramTofuLimitMsg.friendUin).add(paramTofuLimitMsg);
    a(new TofuManagerNew.1(this, paramTofuLimitMsg));
  }
  
  private boolean c(String paramString)
  {
    return (this.h == null) || (!this.f) || (!TextUtils.equals(this.h.b, paramString)) || (!this.g);
  }
  
  private void d(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    this.e.add(paramNewBeancurdMsg);
  }
  
  private void d(String paramString)
  {
    a(new TofuManagerNew.2(this, paramString));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TofuNew.TofuManagerNew", 2, "onAIODestroy");
    }
    b();
    this.f = false;
    this.g = false;
    this.h = null;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (!this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TofuNew.TofuManagerNew", 1, "requestTofuMsg err: not has AIO");
      }
      return;
    }
    this.b.a(paramContext, paramString1, paramString2);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramBaseSessionInfo != null) {
        str = paramBaseSessionInfo.b;
      } else {
        str = "null";
      }
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "onAIOCreate: curFriendUin = ", str });
    }
    this.f = true;
    this.g = false;
    this.h = paramBaseSessionInfo;
    paramBaseSessionInfo = this.h;
    if ((paramBaseSessionInfo != null) && (!TextUtils.isEmpty(paramBaseSessionInfo.b))) {
      d(this.h.b);
    }
  }
  
  public void a(NewBeancurdMsg paramNewBeancurdMsg)
  {
    BeancurdManager localBeancurdManager = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (BeancurdManager.c((int)paramNewBeancurdMsg.busiid))
    {
      if (!BeancurdManager.d((int)paramNewBeancurdMsg.busiid)) {
        return;
      }
      b(paramNewBeancurdMsg);
    }
  }
  
  public void a(String paramString)
  {
    this.c.a(paramString);
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    return a(TofuLimitMsg.create(paramBeancurdMsg));
  }
  
  public boolean a(@Nullable MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((NetConnInfoCenter.getServerTime() - paramMessageRecord.time) * 1000L < this.c.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int[] a(int paramInt)
  {
    int k = BeancurdManager.a(paramInt);
    int[] arrayOfInt = BeancurdManager.a;
    int m = arrayOfInt.length;
    int j = 0;
    paramInt = 0;
    while (paramInt < m)
    {
      if (arrayOfInt[paramInt] == k)
      {
        paramInt = 1;
        break label47;
      }
      paramInt += 1;
    }
    paramInt = 0;
    label47:
    if (paramInt != 0) {
      return BeancurdManager.a;
    }
    m = BeancurdManager.a.length + 1;
    arrayOfInt = new int[m];
    paramInt = j;
    while (paramInt < m - 1)
    {
      arrayOfInt[paramInt] = BeancurdManager.a[paramInt];
      paramInt += 1;
    }
    arrayOfInt[paramInt] = k;
    return arrayOfInt;
  }
  
  public void b(BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramBaseSessionInfo != null) {
        localObject = paramBaseSessionInfo.b;
      } else {
        localObject = "null";
      }
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "onSendMsg: friendUin = ", localObject });
    }
    Object localObject = this.h;
    if ((localObject != null) && (paramBaseSessionInfo != null) && (TextUtils.equals(((BaseSessionInfo)localObject).b, paramBaseSessionInfo.b))) {
      this.g = true;
    }
  }
  
  public void b(@NonNull BeancurdMsg paramBeancurdMsg)
  {
    c(TofuLimitMsg.create(paramBeancurdMsg));
  }
  
  public void b(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    TofuLimitMsg localTofuLimitMsg = TofuLimitMsg.create(paramNewBeancurdMsg);
    if (!a(localTofuLimitMsg))
    {
      QLog.d("TofuNew.TofuManagerNew", 1, "insertNewTofuMsg: but can not insert!");
      return;
    }
    if (c(paramNewBeancurdMsg.frienduin))
    {
      a(paramNewBeancurdMsg, localTofuLimitMsg);
      return;
    }
    d(paramNewBeancurdMsg);
  }
  
  public void onDestroy()
  {
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManagerNew
 * JD-Core Version:    0.7.0.1
 */