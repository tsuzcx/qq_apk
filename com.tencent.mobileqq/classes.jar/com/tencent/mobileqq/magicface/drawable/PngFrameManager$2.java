package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import apih;
import apro;
import atte;
import attk;
import attl;
import aube;
import bdvv;
import bdvx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(atte paramatte, attk paramattk) {}
  
  public void run()
  {
    File localFile = new File(apro.r.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    aube localaube = (aube)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localaube.a(this.a.jdField_a_of_type_JavaLangString);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject1).aio = true;
    }
    synchronized (this.this$0)
    {
      if (this.this$0.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (!localFile.exists()) {
          break label165;
        }
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Attl.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localaube.a((EmoticonPackage)localObject1);
      }
      label165:
      bdvv localbdvv;
      do
      {
        return;
        localbdvv = new bdvv(apih.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbdvv.j = true;
      } while ((bdvx.a(localbdvv, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Attl == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Attl.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localaube.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */