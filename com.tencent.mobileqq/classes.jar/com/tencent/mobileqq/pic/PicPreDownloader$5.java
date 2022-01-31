package com.tencent.mobileqq.pic;

import atpn;
import atpv;
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
      atpv localatpv;
      synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localatpv = (atpv)localIterator.next();
        switch (localatpv.f)
        {
        case 4: 
          k += 1;
          localatpv.e = localatpv.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localatpv.a.g, Integer.valueOf(localatpv.e));
          this.this$0.d.add(0, localatpv);
          localatpv.e = localatpv.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localatpv.a.g, Integer.valueOf(localatpv.e));
        }
      }
      i += 1;
      localatpv.e = localatpv.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localatpv.a.g, Integer.valueOf(localatpv.e));
      this.this$0.b.add(0, localatpv);
      continue;
      j += 1;
      localatpv.e = localatpv.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localatpv.a.g, Integer.valueOf(localatpv.e));
      this.this$0.c.add(0, localatpv);
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