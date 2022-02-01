package com.tencent.open.pcpush;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import java.util.concurrent.ConcurrentHashMap;

class PCPushProxy$WorkHandler
  extends Handler
{
  public PCPushProxy$WorkHandler(PCPushProxy paramPCPushProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage msg.what = ");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(", msg.obj = ");
    ((StringBuilder)localObject).append(paramMessage.obj);
    LogUtility.b("PCPushProxy", ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 115)
    {
      if (i != 116)
      {
        String str = (String)paramMessage.obj;
        PCPushProxy.PkgEntry localPkgEntry = null;
        if (str != null)
        {
          localPkgEntry = (PCPushProxy.PkgEntry)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (localPkgEntry == null)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("handleMessage get entry = null, key = ");
            paramMessage.append(str);
            LogUtility.e("PCPushProxy", paramMessage.toString());
            return;
          }
          if (localPkgEntry.jdField_b_of_type_Int != 1) {
            localObject = localPkgEntry.jdField_b_of_type_JavaLangString.substring(localPkgEntry.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
          } else {
            localObject = localPkgEntry.jdField_b_of_type_JavaLangString;
          }
        }
        else
        {
          LogUtility.e("PCPushProxy", "handleMessage get key = null");
          localObject = null;
        }
        i = paramMessage.what;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              if (localPkgEntry != null) {
                StaticAnalyz.a("500", localPkgEntry.c, (String)localObject);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(str);
            }
          }
          else if (localPkgEntry != null)
          {
            if (localPkgEntry.c.startsWith("ANDROIDQQ.PCPUSH."))
            {
              StaticAnalyz.a("100", localPkgEntry.c, (String)localObject);
            }
            else
            {
              paramMessage = new StringBuilder();
              paramMessage.append("ANDROIDQQ.PCPUSH.");
              paramMessage.append(localPkgEntry.c);
              StaticAnalyz.a("100", paramMessage.toString(), (String)localObject);
            }
            this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(localPkgEntry);
          }
        }
        else {
          this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        }
        return;
      }
      StaticAnalyz.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
      return;
    }
    StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy.WorkHandler
 * JD-Core Version:    0.7.0.1
 */