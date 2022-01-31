package com.tencent.mobileqq.pic;

import aunl;
import aunt;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class PicPreDownloader$5
  implements Runnable
{
  PicPreDownloader$5(PicPreDownloader paramPicPreDownloader, int paramInt) {}
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      int j;
      int i;
      aunt localaunt;
      synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localaunt = (aunt)localIterator.next();
        switch (localaunt.f)
        {
        case 4: 
          k += 1;
          localaunt.e = localaunt.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localaunt.a.g, Integer.valueOf(localaunt.e));
          this.this$0.d.add(0, localaunt);
          localaunt.e = localaunt.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localaunt.a.g, Integer.valueOf(localaunt.e));
        }
      }
      i += 1;
      localaunt.e = localaunt.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localaunt.a.g, Integer.valueOf(localaunt.e));
      this.this$0.b.add(0, localaunt);
      continue;
      j += 1;
      localaunt.e = localaunt.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localaunt.a.g, Integer.valueOf(localaunt.e));
      this.this$0.c.add(0, localaunt);
      continue;
      label310:
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.a + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */