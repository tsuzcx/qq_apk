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
  private BeancurdHandler jdField_a_of_type_ComTencentMobileqqBeancurdHandler;
  @Nullable
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TofuConfigNew jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew;
  private final Object jdField_a_of_type_JavaLangObject;
  private final ConcurrentHashMap<String, CopyOnWriteArrayList<TofuLimitMsg>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private final CopyOnWriteArrayList<NewBeancurdMsg> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  public TofuManagerNew()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public TofuManagerNew(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqBeancurdHandler = ((BeancurdHandler)paramQQAppInterface.getBusinessHandler(BeancurdHandler.class.getName()));
    this.jdField_a_of_type_ComTencentMobileqqBeancurdHandler.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew = new TofuConfigNew();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private MessageRecord a(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    String str = paramNewBeancurdMsg.frienduin;
    MessageRecord localMessageRecord = MessageRecordFactory.a(-7016);
    localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str, str, paramNewBeancurdMsg.extensionInfoStr, -1L, -7016, 0, -1L);
    localMessageRecord.isread = true;
    return localMessageRecord;
  }
  
  @NonNull
  private CopyOnWriteArrayList<TofuLimitMsg> a(String paramString)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localCopyOnWriteArrayList;
        if (localCopyOnWriteArrayList == null)
        {
          localObject1 = TofuProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private CopyOnWriteArrayList<TofuLimitMsg> a(CopyOnWriteArrayList<TofuLimitMsg> paramCopyOnWriteArrayList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    String str = TofuManagerNewUtil.a();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      TofuLimitMsg localTofuLimitMsg = (TofuLimitMsg)paramCopyOnWriteArrayList.next();
      if (!a(localTofuLimitMsg, str)) {
        localCopyOnWriteArrayList.add(localTofuLimitMsg);
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  private void a(@NonNull NewBeancurdMsg paramNewBeancurdMsg, TofuLimitMsg paramTofuLimitMsg)
  {
    MessageRecord localMessageRecord = a(paramNewBeancurdMsg);
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
    {
      a(paramNewBeancurdMsg.frienduin, (int)paramTofuLimitMsg.businessId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
      a(paramTofuLimitMsg);
    }
  }
  
  private void a(@NonNull TofuLimitMsg paramTofuLimitMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "realInsertTofuMsg, msg = ", paramTofuLimitMsg.toString() });
    }
    a(paramTofuLimitMsg.friendUin).add(paramTofuLimitMsg);
    a(new TofuManagerNew.1(this, paramTofuLimitMsg));
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 32, null, false);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = a(paramInt);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 0, (int[])localObject);
    if (!ListUtils.a(paramString))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (MessageRecord)paramString.next();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).msgtype, ((MessageRecord)localObject).uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq);
        }
      }
    }
  }
  
  private boolean a(TofuLimitMsg paramTofuLimitMsg)
  {
    return a(a(paramTofuLimitMsg.friendUin), paramTofuLimitMsg);
  }
  
  private boolean a(TofuLimitMsg paramTofuLimitMsg, String paramString)
  {
    return TextUtils.equals(TofuManagerNewUtil.a(paramTofuLimitMsg.insertMsgTime), paramString) ^ true;
  }
  
  private boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo == null) || (!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, paramString)) || (!this.b);
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
          i = 1;
          break label56;
        }
      }
    }
    int i = 0;
    label56:
    if (i != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("TofuNew.TofuManagerNew", 2, "isRepeat = true");
      }
    }
    for (;;)
    {
      bool = false;
      break label266;
      paramCopyOnWriteArrayList = a(paramCopyOnWriteArrayList);
      localIterator = paramCopyOnWriteArrayList.iterator();
      i = 0;
      while (localIterator.hasNext()) {
        if (((TofuLimitMsg)localIterator.next()).businessId == paramTofuLimitMsg.businessId) {
          i += 1;
        }
      }
      if (i >= this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "businessMsgCount = ", Integer.valueOf(i), ", config = ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.jdField_a_of_type_Int) });
        }
      }
      else
      {
        if (ListUtils.a(paramCopyOnWriteArrayList) < this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.b) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "ListUtils.size(filterMsgList) = ", Integer.valueOf(ListUtils.a(paramCopyOnWriteArrayList)), ", config = ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.b) });
        }
      }
    }
    boolean bool = true;
    label266:
    QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "realCheckCanInsert tofuMsg = ", paramTofuLimitMsg.toString(), ", canInsert = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  private void b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    a(new TofuManagerNew.3(this, localCopyOnWriteArrayList));
  }
  
  private void b(String paramString)
  {
    a(new TofuManagerNew.2(this, paramString));
  }
  
  private void c(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramNewBeancurdMsg);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TofuNew.TofuManagerNew", 2, "onAIODestroy");
    }
    b();
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = null;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TofuNew.TofuManagerNew", 1, "requestTofuMsg err: not has AIO");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBeancurdHandler.a(paramContext, paramString1, paramString2);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramBaseSessionInfo != null) {
        str = paramBaseSessionInfo.a;
      } else {
        str = "null";
      }
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "onAIOCreate: curFriendUin = ", str });
    }
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    paramBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    if ((paramBaseSessionInfo != null) && (!TextUtils.isEmpty(paramBaseSessionInfo.a))) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
    }
  }
  
  public void a(@NonNull BeancurdMsg paramBeancurdMsg)
  {
    a(TofuLimitMsg.create(paramBeancurdMsg));
  }
  
  public void a(NewBeancurdMsg paramNewBeancurdMsg)
  {
    b(paramNewBeancurdMsg);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.a(paramString);
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
      if ((NetConnInfoCenter.getServerTime() - paramMessageRecord.time) * 1000L < this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuConfigNew.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int[] a(int paramInt)
  {
    int j = BeancurdManager.a(paramInt);
    int[] arrayOfInt = BeancurdManager.a;
    int k = arrayOfInt.length;
    int i = 0;
    paramInt = 0;
    while (paramInt < k)
    {
      if (arrayOfInt[paramInt] == j)
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
    k = BeancurdManager.a.length + 1;
    arrayOfInt = new int[k];
    paramInt = i;
    while (paramInt < k - 1)
    {
      arrayOfInt[paramInt] = BeancurdManager.a[paramInt];
      paramInt += 1;
    }
    arrayOfInt[paramInt] = j;
    return arrayOfInt;
  }
  
  public void b(BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramBaseSessionInfo != null) {
        localObject = paramBaseSessionInfo.a;
      } else {
        localObject = "null";
      }
      QLog.d("TofuNew.TofuManagerNew", 2, new Object[] { "onSendMsg: friendUin = ", localObject });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    if ((localObject != null) && (paramBaseSessionInfo != null) && (TextUtils.equals(((BaseSessionInfo)localObject).a, paramBaseSessionInfo.a))) {
      this.b = true;
    }
  }
  
  public void b(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    TofuLimitMsg localTofuLimitMsg = TofuLimitMsg.create(paramNewBeancurdMsg);
    if (!a(localTofuLimitMsg))
    {
      QLog.d("TofuNew.TofuManagerNew", 1, "insertNewTofuMsg: but can not insert!");
      return;
    }
    if (a(paramNewBeancurdMsg.frienduin))
    {
      a(paramNewBeancurdMsg, localTofuLimitMsg);
      return;
    }
    c(paramNewBeancurdMsg);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManagerNew
 * JD-Core Version:    0.7.0.1
 */