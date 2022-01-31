package com.tencent.mobileqq.pic;

import aumr;
import aunb;
import aung;
import aunn;
import aunv;
import auob;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.File;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BasePicOprerator$4
  implements Runnable
{
  public BasePicOprerator$4(aumr paramaumr, aunb paramaunb) {}
  
  public void run()
  {
    Object localObject;
    auob localauob;
    long l;
    if ((this.a != null) && (this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.a.b != null))
    {
      localObject = this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      File localFile = new File(this.a.b);
      if (this.a.jdField_a_of_type_Int == 0)
      {
        localauob = (auob)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
        if (localauob != null)
        {
          l = localFile.length();
          switch (this.a.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((PicPreDownloader)localObject).b.contains(this.this$0.jdField_a_of_type_Aunv))
      {
        ((PicPreDownloader)localObject).b.remove(this.this$0.jdField_a_of_type_Aunv);
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn.g);
        aung.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn.a + ",cmd:" + this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_Int + ",curHandingNum:" + ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        if ((this.a != null) && (this.a.b != null))
        {
          localObject = this.this$0.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          if ((localObject != null) && (((MessageForPic)localObject).size == 0L))
          {
            l = new File(this.a.b).length();
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForPic)localObject, l);
          }
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      }
      return;
      localauob.a(13059, l);
      continue;
      localauob.a(13060, l);
      localauob.b((MessageForPic)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.4
 * JD-Core Version:    0.7.0.1
 */