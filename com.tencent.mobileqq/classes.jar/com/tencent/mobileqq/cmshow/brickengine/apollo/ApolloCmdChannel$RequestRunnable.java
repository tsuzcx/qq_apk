package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ApolloCmdChannel$RequestRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ApolloCmdChannel> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  
  ApolloCmdChannel$RequestRunnable(ApolloCmdChannel paramApolloCmdChannel, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannel);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    ??? = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (??? == null) {
      return;
    }
    ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)((WeakReference)???).get();
    if (localApolloCmdChannel == null) {
      return;
    }
    if ((this.jdField_a_of_type_Long != -1L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      synchronized (ApolloCmdChannel.access$000(localApolloCmdChannel))
      {
        Iterator localIterator = ApolloCmdChannel.access$000(localApolloCmdChannel).iterator();
        while (localIterator.hasNext())
        {
          HandleResult localHandleResult = ((IRequestHandler)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b);
          if (localHandleResult != null)
          {
            if (localHandleResult.jdField_a_of_type_Boolean) {
              localIterator.remove();
            }
            if (localHandleResult.b) {
              localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, localHandleResult.jdField_a_of_type_JavaLangString);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.RequestRunnable
 * JD-Core Version:    0.7.0.1
 */