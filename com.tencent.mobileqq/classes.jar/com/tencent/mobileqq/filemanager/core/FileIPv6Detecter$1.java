package com.tencent.mobileqq.filemanager.core;

import asgt;
import asgu;
import asgw;
import asgx;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FileIPv6Detecter$1
  implements Runnable
{
  public FileIPv6Detecter$1(asgt paramasgt, asgx paramasgx, long paramLong, asgw paramasgw) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = new Socket();
    for (;;)
    {
      try
      {
        int j = this.jdField_a_of_type_Asgx.jdField_a_of_type_Int;
        i = j;
        if (j == 0) {
          i = 80;
        }
        ((Socket)localObject1).connect(new InetSocketAddress(this.jdField_a_of_type_Asgx.a(), i), 6000);
      }
      catch (Exception localException4)
      {
        int i;
        long l;
        localException4.printStackTrace();
        try
        {
          localException1.close();
          i = 1;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          i = 1;
        }
        continue;
      }
      finally
      {
        try
        {
          localException2.close();
          throw localObject2;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          continue;
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      try
      {
        ((Socket)localObject1).close();
        i = 0;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        i = 0;
      }
    }
    l = System.currentTimeMillis();
    localObject1 = new StringBuilder().append("[IPv6-File] delectIP Result:");
    if (i == 0)
    {
      bool1 = true;
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, bool1 + " cost:" + (l - this.jdField_a_of_type_Long) + " [" + this.jdField_a_of_type_Asgw.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Asgw.jdField_a_of_type_Int + "] ipInfo[" + this.jdField_a_of_type_Asgx.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Asgx.jdField_a_of_type_Int + "]");
      localObject1 = asgt.a(this.this$0, this.jdField_a_of_type_Asgw);
      if (localObject1 != null)
      {
        ((asgu)localObject1).b = false;
        if (i != 0) {
          break label322;
        }
        bool1 = true;
        ((asgu)localObject1).a = bool1;
        localObject1 = this.this$0;
        if (i != 0) {
          break label327;
        }
        bool1 = bool2;
        asgt.a((asgt)localObject1, bool1, this.jdField_a_of_type_Asgw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Asgx.a(), this.jdField_a_of_type_Asgx.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1
 * JD-Core Version:    0.7.0.1
 */