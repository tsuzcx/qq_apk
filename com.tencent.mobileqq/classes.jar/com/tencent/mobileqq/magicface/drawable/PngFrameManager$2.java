package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import anqz;
import anzr;
import asce;
import asck;
import ascl;
import askf;
import bbwu;
import bbww;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(asce paramasce, asck paramasck) {}
  
  public void run()
  {
    File localFile = new File(anzr.r.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    askf localaskf = (askf)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localaskf.a(this.a.jdField_a_of_type_JavaLangString);
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
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Ascl.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localaskf.a((EmoticonPackage)localObject1);
      }
      label165:
      bbwu localbbwu;
      do
      {
        return;
        localbbwu = new bbwu(anqz.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbbwu.j = true;
      } while ((bbww.a(localbbwu, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Ascl == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Ascl.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localaskf.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */