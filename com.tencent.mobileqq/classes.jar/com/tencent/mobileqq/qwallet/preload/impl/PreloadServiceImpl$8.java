package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class PreloadServiceImpl$8
  extends Handler
{
  private LinkedList<IPreloadService.FlowControlObj> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  
  PreloadServiceImpl$8(PreloadServiceImpl paramPreloadServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadServiceImpl);
    IPreloadService.FlowControlObj localFlowControlObj = (IPreloadService.FlowControlObj)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
    this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    ThreadManager.excute(new PreloadServiceImpl.8.1(this, localWeakReference, localFlowControlObj), 64, null, false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadServiceImpl.mIsOnDestroy) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        a();
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList.addLast((IPreloadService.FlowControlObj)paramMessage.obj);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */