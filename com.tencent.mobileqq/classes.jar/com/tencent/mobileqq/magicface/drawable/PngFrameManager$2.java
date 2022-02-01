package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import aqyy;
import avkv;
import avlb;
import avlc;
import avsq;
import bgoe;
import bgog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(avkv paramavkv, avlb paramavlb) {}
  
  public void run()
  {
    File localFile = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    avsq localavsq = (avsq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    ??? = localavsq.a(this.a.jdField_a_of_type_JavaLangString);
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
        this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Avlc.a(localFile);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
        localavsq.a((EmoticonPackage)localObject1);
      }
      label165:
      bgoe localbgoe;
      do
      {
        return;
        localbgoe = new bgoe(aqyy.a(this.a.jdField_a_of_type_JavaLangString), localFile);
        localbgoe.j = true;
      } while ((bgog.a(localbgoe, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.this$0.jdField_a_of_type_Avlc == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null));
      this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Avlc.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
      localavsq.a((EmoticonPackage)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */