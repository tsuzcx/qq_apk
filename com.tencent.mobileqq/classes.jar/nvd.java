import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nvd
{
  public static nva a()
  {
    nva localnva2 = nvc.a();
    nva localnva1 = localnva2;
    if (localnva2 == null) {
      localnva1 = new nva();
    }
    return localnva1;
  }
  
  public static nvb a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nvb localnvb = (nvb)((Iterator)localObject).next();
        if (localnvb.jdField_a_of_type_Int == paramInt) {
          return localnvb;
        }
      }
    }
    return new nvb();
  }
  
  public static boolean a()
  {
    nva localnva = nvc.a();
    if (localnva == null) {}
    for (String str = "false";; str = localnva.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localnva != null) {
        break;
      }
      return false;
    }
    if (localnva.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(nva paramnva)
  {
    return a(paramnva, 1, 1);
  }
  
  public static boolean a(nva paramnva, int paramInt1, int paramInt2)
  {
    if ((paramnva == null) || (paramnva.jdField_a_of_type_JavaUtilArrayList == null) || (paramnva.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramnva = paramnva.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramnva.hasNext())
    {
      nvb localnvb = (nvb)paramnva.next();
      if ((localnvb.b == paramInt1) && (localnvb.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    nva localnva = nvc.a();
    if (localnva == null) {}
    for (String str = "false";; str = localnva.b + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localnva != null) {
        break;
      }
      return false;
    }
    if (localnva.b == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c()
  {
    return (a()) && (a(nvc.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvd
 * JD-Core Version:    0.7.0.1
 */