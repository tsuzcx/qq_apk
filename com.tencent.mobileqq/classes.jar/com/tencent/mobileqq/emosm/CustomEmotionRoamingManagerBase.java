package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public abstract class CustomEmotionRoamingManagerBase<T extends CustomEmotionBase>
  implements Manager
{
  public QQAppInterface a;
  protected String a;
  public CopyOnWriteArrayList<WeakReference<SyncListener>> a;
  protected AtomicBoolean a;
  
  public CustomEmotionRoamingManagerBase(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  protected abstract int a();
  
  protected abstract CustomEmoRoamingBaseHandler<T> a();
  
  protected abstract CustomEmotionRoamingDBManagerBase<T> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a(SyncListener paramSyncListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramSyncListener) {
        return;
      }
    }
    paramSyncListener = new WeakReference(paramSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramSyncListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    CustomEmoRoamingBaseHandler localCustomEmoRoamingBaseHandler;
    do
    {
      return;
      localCustomEmoRoamingBaseHandler = a();
    } while (localCustomEmoRoamingBaseHandler == null);
    if (QLog.isColorLevel()) {
      QLog.d("CustomEmotionRoamingManagerBase", 2, "------------start syncRoaming----------");
    }
    localCustomEmoRoamingBaseHandler.a();
  }
  
  public void b(SyncListener paramSyncListener)
  {
    if (paramSyncListener == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
 * JD-Core Version:    0.7.0.1
 */