package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import asfa;
import asos;
import awxo;
import awxu;
import awxv;
import axfj;
import bihu;
import bihw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(awxo paramawxo, awxu paramawxu) {}
  
  public void run()
  {
    File localFile = new File(asos.r.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    axfj localaxfj = (axfj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localaxfj.a(this.a.jdField_a_of_type_JavaLangString);
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
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Awxv.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localaxfj.a((EmoticonPackage)localObject1);
      }
      label165:
      bihu localbihu;
      do
      {
        return;
        localbihu = new bihu(asfa.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbihu.j = true;
      } while ((bihw.a(localbihu, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Awxv == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Awxv.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localaxfj.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */