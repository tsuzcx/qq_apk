package com.tencent.mobileqq.qqfeatureswitch.impl;

import com.tencent.featuretoggle.OnToggleListener;
import com.tencent.featuretoggle.Toggle;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSDKReporter;
import com.tencent.mobileqq.qqfeatureswitch.OnUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import mqq.app.MobileQQ;

public class FeatureRuntimeServiceImpl$ToggleUpdateListener
  extends OnToggleListener
{
  private void c()
  {
    try
    {
      QLog.d("FeatureRuntimeServiceImpl", 1, "checkUserIdChanged");
      if (FeatureRuntimeServiceImpl.access$100() == null) {
        return;
      }
      if (FeatureRuntimeServiceImpl.access$100().size() <= 1)
      {
        FeatureRuntimeServiceImpl.access$100().clear();
        return;
      }
      String str = (String)FeatureRuntimeServiceImpl.access$100().pop();
      QLog.d("FeatureRuntimeServiceImpl", 1, new Object[] { "checkUserIdChanged, new user id is ", MobileQQ.getShortUinStr(str) });
      Toggle.a(str, true);
      FeatureRuntimeServiceImpl.access$100().clear();
      return;
    }
    finally {}
  }
  
  public void a()
  {
    c();
    FeatureSDKReporter.a();
    if ((FeatureRuntimeServiceImpl.access$000() != null) && (!FeatureRuntimeServiceImpl.access$000().isEmpty()))
    {
      Iterator localIterator = FeatureRuntimeServiceImpl.access$000().iterator();
      while (localIterator.hasNext()) {
        ((OnUpdateListener)localIterator.next()).a();
      }
      return;
    }
    QLog.d("FeatureRuntimeServiceImpl", 1, "mListeners is null or mListener is empty");
  }
  
  public void b()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.impl.FeatureRuntimeServiceImpl.ToggleUpdateListener
 * JD-Core Version:    0.7.0.1
 */