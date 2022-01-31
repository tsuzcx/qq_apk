import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class suf
  implements aysc
{
  suf(sue paramsue) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3) {}
    sui localsui;
    do
    {
      do
      {
        return;
        localObject = ((ayrx)paramaysz.jdField_a_of_type_Aysy).a();
      } while ((localObject == null) || (!(localObject instanceof sui)));
      localsui = (sui)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((sui)localObject).jdField_a_of_type_JavaLangString);
      localsui.jdField_b_of_type_Long = (System.currentTimeMillis() - localsui.jdField_a_of_type_Long);
    } while (localsui.jdField_a_of_type_Sub == null);
    Object localObject = localsui.jdField_a_of_type_Sub;
    if (paramaysz.jdField_a_of_type_Int == 0) {}
    for (paramaysz = new ErrorMessage(0, "");; paramaysz = new ErrorMessage(paramaysz.b, paramaysz.jdField_a_of_type_JavaLangString))
    {
      ((sub)localObject).a(localsui, paramaysz);
      return;
    }
  }
  
  public void onUpdateProgeress(aysy arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof sui)))
    {
      sui localsui = (sui)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            sum localsum = (sum)((WeakReference)localIterator.next()).get();
            if (localsum != null) {
              localsum.a(localsui.jdField_b_of_type_JavaLangString, localsui.jdField_a_of_type_Int, i, localsui);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suf
 * JD-Core Version:    0.7.0.1
 */