package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import android.os.Bundle;
import aunn;
import aunq;
import auqe;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ODCsChannel$1
  implements Runnable
{
  public ODCsChannel$1(aunn paramaunn, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, aunq paramaunq) {}
  
  public void run()
  {
    Object localObject1 = auqe.a().a("Od", "1104763709");
    Bundle localBundle;
    try
    {
      localObject1 = (Bundle)((Future)localObject1).get();
      if (localObject1 == null)
      {
        QLog.i("ODCsChannel", 2, "getAccessToken: get access token fail，bundle = null");
        if (this.jdField_a_of_type_Int > 0)
        {
          aunn.a(this.this$0, this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
          return;
        }
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.printStackTrace();
        QLog.e("ODCsChannel", 2, "getAccessToken: error=" + localExecutionException.getMessage());
        Object localObject2 = null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        QLog.e("ODCsChannel", 2, "getAccessToken: error=" + localInterruptedException.getMessage());
        localBundle = null;
      }
      aunn.a(this.this$0, -1, null, null, this.jdField_a_of_type_Aunq);
      return;
    }
    int i = localBundle.getInt("code");
    Object localObject3 = localBundle.getBundle("data");
    if ((localObject3 == null) || (i != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getAccessToken: get access token fail，errorCode=").append(i).append(" accessToken=");
      if (localObject3 == null) {}
      for (localObject3 = "null";; localObject3 = ((Bundle)localObject3).toString())
      {
        QLog.i("ODCsChannel", 2, (String)localObject3);
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        aunn.a(this.this$0, this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
        return;
      }
      aunn.a(this.this$0, i, null, localBundle, this.jdField_a_of_type_Aunq);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ODCsChannel", 2, "getAccessToken: accessToken=" + ((Bundle)localObject3).toString());
    }
    aunn.a(this.this$0, (Bundle)localObject3);
    this.this$0.a(this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aunq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsChannel.1
 * JD-Core Version:    0.7.0.1
 */