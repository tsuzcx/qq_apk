import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class oen
{
  public static oek a()
  {
    oek localoek2 = oem.a();
    oek localoek1 = localoek2;
    if (localoek2 == null) {
      localoek1 = new oek();
    }
    return localoek1;
  }
  
  public static oel a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        oel localoel = (oel)((Iterator)localObject).next();
        if (localoel.jdField_a_of_type_Int == paramInt) {
          return localoel;
        }
      }
    }
    return new oel();
  }
  
  public static oeo a()
  {
    return oep.a();
  }
  
  public static boolean a()
  {
    return a(oem.a());
  }
  
  public static boolean a(oek paramoek)
  {
    return a(paramoek, 1, 1);
  }
  
  public static boolean a(oek paramoek, int paramInt1, int paramInt2)
  {
    if ((paramoek == null) || (paramoek.jdField_a_of_type_JavaUtilArrayList == null) || (paramoek.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramoek = paramoek.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramoek.hasNext())
    {
      oel localoel = (oel)paramoek.next();
      if ((localoel.b == paramInt1) && (localoel.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    oek localoek = a();
    if (localoek == null) {}
    for (String str = "false";; str = localoek.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localoek != null) {
        break;
      }
      return false;
    }
    if (localoek.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oen
 * JD-Core Version:    0.7.0.1
 */