package com.tencent.mobileqq.kandian.base.msf;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class ReadInJoyMSFService$1
  implements Runnable
{
  ReadInJoyMSFService$1(ReadInJoyMSFService paramReadInJoyMSFService, ToServiceMsg paramToServiceMsg, WeakReference paramWeakReference) {}
  
  public void run()
  {
    int i = ReadInJoyMSFService.access$008(this.this$0);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("seq", Integer.valueOf(i));
    ReadInJoyMSFService.access$100(this.this$0).put(Integer.valueOf(i), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService.1
 * JD-Core Version:    0.7.0.1
 */