package dov.com.qq.im.capture.music;

import bonc;
import java.util.Iterator;
import java.util.List;

class QIMMusicConfigManager$1
  implements Runnable
{
  QIMMusicConfigManager$1(QIMMusicConfigManager paramQIMMusicConfigManager, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    Iterator localIterator = QIMMusicConfigManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((bonc)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.1
 * JD-Core Version:    0.7.0.1
 */