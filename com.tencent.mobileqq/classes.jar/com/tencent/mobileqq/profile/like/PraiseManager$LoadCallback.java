package com.tencent.mobileqq.profile.like;

import auwu;
import auwv;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.List;

public class PraiseManager$LoadCallback
  implements Runnable
{
  public int a;
  public String a;
  public int b;
  
  public PraiseManager$LoadCallback(PraiseManager paramPraiseManager, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    for (;;)
    {
      WeakReference[] arrayOfWeakReference;
      synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
      {
        if (this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label186;
        }
        arrayOfWeakReference = (WeakReference[])Array.newInstance(((WeakReference)this.this$0.jdField_a_of_type_JavaUtilList.get(0)).getClass(), this.this$0.jdField_a_of_type_JavaUtilList.size());
        this.this$0.jdField_a_of_type_JavaUtilList.toArray(arrayOfWeakReference);
        if (arrayOfWeakReference == null) {
          break label185;
        }
      }
      try
      {
        int j = arrayOfWeakReference.length;
        int i = 0;
        while (i < j)
        {
          ??? = arrayOfWeakReference[i];
          if ((??? != null) && (???.get() != null)) {
            ((auwv)???.get()).a(this.jdField_a_of_type_Int, (auwu)this.this$0.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(this.jdField_a_of_type_Int)), this.b, this.jdField_a_of_type_JavaLangString);
          }
          i += 1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PraiseManager", 1, "LoadCallback failed", localException);
      }
      label185:
      return;
      label186:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.LoadCallback
 * JD-Core Version:    0.7.0.1
 */