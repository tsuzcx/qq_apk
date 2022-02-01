package com.tencent.mobileqq.qqexpand.manager;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendFriendSearchHistoryManager
  implements Handler.Callback
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  WeakReference<BaseQQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  WeakReference<ExtendFriendSearchHistoryManager.HistoryTagChangeListener> b;
  
  public ExtendFriendSearchHistoryManager(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    ThreadManager.postImmediately(new ExtendFriendSearchHistoryManager.1(this), null, true);
  }
  
  private void b()
  {
    ??? = (BaseQQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (??? == null) {
      return;
    }
    int i = 0;
    Object localObject4 = FileUtils.readObject(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.jdField_a_of_type_Int), ((BaseQQAppInterface)???).getCurrentAccountUin() }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = null;
    ??? = localObject2;
    if (localObject4 != null)
    {
      ??? = localObject2;
      if ((localObject4 instanceof List)) {
        ??? = (List)localObject4;
      }
    }
    localObject2 = ???;
    if (??? == null) {
      localObject2 = new ArrayList();
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        while (this.jdField_a_of_type_JavaUtilList.size() > 10) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
        this.jdField_a_of_type_Boolean = true;
        i = 1;
      }
      if (i != 0)
      {
        ??? = this.b;
        if ((??? != null) && (((WeakReference)???).get() != null)) {
          ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).aM_();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void c()
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseQQAppInterface == null) {
      return;
    }
    FileUtils.writeObject(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.jdField_a_of_type_Int), localBaseQQAppInterface.getCurrentAccountUin() }), this.jdField_a_of_type_JavaUtilList);
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Boolean = true;
      ??? = this.b;
      if ((??? != null) && (((WeakReference)???).get() != null)) {
        ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).aM_();
      }
      if (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(0)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public void a(ExtendFriendSearchHistoryManager.HistoryTagChangeListener paramHistoryTagChangeListener)
  {
    if (paramHistoryTagChangeListener != null)
    {
      this.b = new WeakReference(paramHistoryTagChangeListener);
      return;
    }
    this.b = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      this.jdField_a_of_type_JavaUtilList.add(0, paramString);
      if (this.jdField_a_of_type_JavaUtilList.size() > 10) {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
      paramString = this.b;
      if ((paramString != null) && (paramString.get() != null)) {
        ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).aM_();
      }
      if (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(0)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */