package dov.com.qq.im.ae.gif.video;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class PngsCreateWorkingQueue$2
  implements PngsCreator.Callback
{
  PngsCreateWorkingQueue$2(PngsCreateWorkingQueue paramPngsCreateWorkingQueue, MaterialWrapper paramMaterialWrapper, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(PngsCreateWorkingQueue.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      Util.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    PngsCreateWorkingQueue.a(this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue).c.add(str);
    PngsCreateWorkingQueue.a(this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue).a.add(paramString);
    if ((this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.c != null) && (!this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.c.equals(""))) {
      PngsCreateWorkingQueue.a(this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue).b.add(this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.c);
    }
    for (;;)
    {
      PngsCreateWorkingQueue.a(this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue).d.add(Integer.valueOf(this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      PngsCreateWorkingQueue.a(this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue).b.add(this.jdField_a_of_type_DovComQqImAeGifVideoMaterialWrapper.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.2
 * JD-Core Version:    0.7.0.1
 */