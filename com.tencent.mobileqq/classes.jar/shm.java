import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class shm
  implements axrt
{
  shm(shl paramshl) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3) {}
    shp localshp;
    do
    {
      do
      {
        return;
        localObject = ((axro)paramaxsq.jdField_a_of_type_Axsp).a();
      } while ((localObject == null) || (!(localObject instanceof shp)));
      localshp = (shp)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((shp)localObject).jdField_a_of_type_JavaLangString);
      localshp.jdField_b_of_type_Long = (System.currentTimeMillis() - localshp.jdField_a_of_type_Long);
    } while (localshp.jdField_a_of_type_Shi == null);
    Object localObject = localshp.jdField_a_of_type_Shi;
    if (paramaxsq.jdField_a_of_type_Int == 0) {}
    for (paramaxsq = new ErrorMessage(0, "");; paramaxsq = new ErrorMessage(paramaxsq.b, paramaxsq.jdField_a_of_type_JavaLangString))
    {
      ((shi)localObject).a(localshp, paramaxsq);
      return;
    }
  }
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof shp)))
    {
      shp localshp = (shp)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            sht localsht = (sht)((WeakReference)localIterator.next()).get();
            if (localsht != null) {
              localsht.a(localshp.jdField_b_of_type_JavaLangString, localshp.jdField_a_of_type_Int, i, localshp);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shm
 * JD-Core Version:    0.7.0.1
 */