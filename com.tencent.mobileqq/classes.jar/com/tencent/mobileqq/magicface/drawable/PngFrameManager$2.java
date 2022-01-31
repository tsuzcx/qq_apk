package com.tencent.mobileqq.magicface.drawable;

import anam;
import android.os.Handler;
import android.os.Message;
import anjd;
import arga;
import argg;
import argh;
import arnz;
import batm;
import bato;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(arga paramarga, argg paramargg) {}
  
  public void run()
  {
    File localFile = new File(anjd.r.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    arnz localarnz = (arnz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localarnz.a(this.a.jdField_a_of_type_JavaLangString);
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
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Argh.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localarnz.a((EmoticonPackage)localObject1);
      }
      label165:
      batm localbatm;
      do
      {
        return;
        localbatm = new batm(anam.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbatm.j = true;
      } while ((bato.a(localbatm, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Argh == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Argh.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localarnz.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */