package dov.com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoThumbGenMgr
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<RMVideoThumbGenMgr.ThumbGenItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(RMVideoThumbGenMgr.ThumbGenItem paramThumbGenItem, boolean paramBoolean)
  {
    int i = 1;
    if (paramThumbGenItem == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramThumbGenItem.jdField_a_of_type_Boolean = true;
        j = paramThumbGenItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramThumbGenItem.c != null) && (paramBoolean))
        {
          FileUtils.e(paramThumbGenItem.c);
          paramThumbGenItem.c = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramThumbGenItem.jdField_b_of_type_JavaLangString == null);
    FileUtils.e(paramThumbGenItem.jdField_b_of_type_JavaLangString);
    paramThumbGenItem.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  void a()
  {
    RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localThumbGenItem = (RMVideoThumbGenMgr.ThumbGenItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localThumbGenItem == null) || (a(localThumbGenItem, localThumbGenItem.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localThumbGenItem);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr
 * JD-Core Version:    0.7.0.1
 */