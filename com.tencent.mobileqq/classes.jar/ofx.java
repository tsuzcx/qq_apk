import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ofx
{
  public static ofu a()
  {
    ofu localofu2 = ofw.a();
    ofu localofu1 = localofu2;
    if (localofu2 == null) {
      localofu1 = new ofu();
    }
    return localofu1;
  }
  
  public static ofv a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ofv localofv = (ofv)((Iterator)localObject).next();
        if (localofv.jdField_a_of_type_Int == paramInt) {
          return localofv;
        }
      }
    }
    return new ofv();
  }
  
  public static boolean a()
  {
    return a(ofw.a());
  }
  
  public static boolean a(ofu paramofu)
  {
    return a(paramofu, 1, 1);
  }
  
  public static boolean a(ofu paramofu, int paramInt1, int paramInt2)
  {
    if ((paramofu == null) || (paramofu.jdField_a_of_type_JavaUtilArrayList == null) || (paramofu.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramofu = paramofu.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramofu.hasNext())
    {
      ofv localofv = (ofv)paramofu.next();
      if ((localofv.b == paramInt1) && (localofv.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    ofu localofu = a();
    if (localofu == null) {}
    for (String str = "false";; str = localofu.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localofu != null) {
        break;
      }
      return false;
    }
    if (localofu.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofx
 * JD-Core Version:    0.7.0.1
 */