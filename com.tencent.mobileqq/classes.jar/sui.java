import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class sui
  implements aysa
{
  sui(suh paramsuh) {}
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.jdField_a_of_type_Int == 3) {}
    sul localsul;
    do
    {
      do
      {
        return;
        localObject = ((ayrv)paramaysx.jdField_a_of_type_Aysw).a();
      } while ((localObject == null) || (!(localObject instanceof sul)));
      localsul = (sul)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((sul)localObject).jdField_a_of_type_JavaLangString);
      localsul.jdField_b_of_type_Long = (System.currentTimeMillis() - localsul.jdField_a_of_type_Long);
    } while (localsul.jdField_a_of_type_Sue == null);
    Object localObject = localsul.jdField_a_of_type_Sue;
    if (paramaysx.jdField_a_of_type_Int == 0) {}
    for (paramaysx = new ErrorMessage(0, "");; paramaysx = new ErrorMessage(paramaysx.b, paramaysx.jdField_a_of_type_JavaLangString))
    {
      ((sue)localObject).a(localsul, paramaysx);
      return;
    }
  }
  
  public void onUpdateProgeress(aysw arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof sul)))
    {
      sul localsul = (sul)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            sup localsup = (sup)((WeakReference)localIterator.next()).get();
            if (localsup != null) {
              localsup.a(localsul.jdField_b_of_type_JavaLangString, localsul.jdField_a_of_type_Int, i, localsul);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sui
 * JD-Core Version:    0.7.0.1
 */