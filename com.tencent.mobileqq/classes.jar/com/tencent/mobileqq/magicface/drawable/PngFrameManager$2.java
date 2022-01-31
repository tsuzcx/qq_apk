package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import anqu;
import anzm;
import ascc;
import asci;
import ascj;
import askd;
import bbwg;
import bbwi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(ascc paramascc, asci paramasci) {}
  
  public void run()
  {
    File localFile = new File(anzm.r.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    askd localaskd = (askd)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localaskd.a(this.a.jdField_a_of_type_JavaLangString);
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
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Ascj.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localaskd.a((EmoticonPackage)localObject1);
      }
      label165:
      bbwg localbbwg;
      do
      {
        return;
        localbbwg = new bbwg(anqu.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbbwg.j = true;
      } while ((bbwi.a(localbbwg, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Ascj == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Ascj.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localaskd.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */