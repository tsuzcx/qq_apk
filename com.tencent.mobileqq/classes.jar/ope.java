import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ope
{
  public static opa a()
  {
    opa localopa2 = opd.a();
    opa localopa1 = localopa2;
    if (localopa2 == null) {
      localopa1 = new opa();
    }
    return localopa1;
  }
  
  public static opc a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        opc localopc = (opc)((Iterator)localObject).next();
        if (localopc.jdField_a_of_type_Int == paramInt) {
          return localopc;
        }
      }
    }
    return new opc();
  }
  
  public static boolean a()
  {
    return a(opd.a());
  }
  
  public static boolean a(opa paramopa)
  {
    return a(paramopa, 1, 1);
  }
  
  public static boolean a(opa paramopa, int paramInt1, int paramInt2)
  {
    if ((paramopa == null) || (paramopa.jdField_a_of_type_JavaUtilArrayList == null) || (paramopa.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramopa = paramopa.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramopa.hasNext())
    {
      opc localopc = (opc)paramopa.next();
      if ((localopc.b == paramInt1) && (localopc.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    opa localopa = a();
    if (localopa == null) {}
    for (String str = "false";; str = localopa.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localopa != null) {
        break;
      }
      return false;
    }
    if (localopa.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */