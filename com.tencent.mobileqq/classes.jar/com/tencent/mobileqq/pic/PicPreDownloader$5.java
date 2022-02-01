package com.tencent.mobileqq.pic;

import ayxp;
import ayxx;
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
      ayxx localayxx;
      synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localayxx = (ayxx)localIterator.next();
        switch (localayxx.f)
        {
        case 4: 
          k += 1;
          localayxx.e = localayxx.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localayxx.a.g, Integer.valueOf(localayxx.e));
          this.this$0.d.add(0, localayxx);
          localayxx.e = localayxx.f;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localayxx.a.g, Integer.valueOf(localayxx.e));
        }
      }
      i += 1;
      localayxx.e = localayxx.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localayxx.a.g, Integer.valueOf(localayxx.e));
      this.this$0.b.add(0, localayxx);
      continue;
      j += 1;
      localayxx.e = localayxx.f;
      this.this$0.jdField_a_of_type_JavaUtilMap.put(localayxx.a.g, Integer.valueOf(localayxx.e));
      this.this$0.c.add(0, localayxx);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */