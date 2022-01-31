package com.tencent.mobileqq.profile.like;

import com.tencent.commonsdk.cache.QQLruCache;
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
      synchronized (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label176;
        }
        WeakReference[] arrayOfWeakReference = (WeakReference[])Array.newInstance(((WeakReference)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_JavaUtilList.get(0)).getClass(), this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_JavaUtilList.size());
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_JavaUtilList.toArray(arrayOfWeakReference);
        if (arrayOfWeakReference != null)
        {
          int j = arrayOfWeakReference.length;
          int i = 0;
          if (i < j)
          {
            ??? = arrayOfWeakReference[i];
            if ((??? != null) && (???.get() != null)) {
              ((PraiseManager.OnPraiseLoadListener)???.get()).a(this.jdField_a_of_type_Int, (PraiseInfo)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(this.jdField_a_of_type_Int)), this.b, this.jdField_a_of_type_JavaLangString);
            }
            i += 1;
          }
        }
      }
      return;
      label176:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.LoadCallback
 * JD-Core Version:    0.7.0.1
 */