import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nrw
{
  public static nrt a()
  {
    nrt localnrt2 = nrv.a();
    nrt localnrt1 = localnrt2;
    if (localnrt2 == null) {
      localnrt1 = new nrt();
    }
    return localnrt1;
  }
  
  public static nru a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nru localnru = (nru)((Iterator)localObject).next();
        if (localnru.jdField_a_of_type_Int == paramInt) {
          return localnru;
        }
      }
    }
    return new nru();
  }
  
  public static boolean a()
  {
    nrt localnrt = nrv.a();
    if (localnrt == null) {}
    for (String str = "false";; str = localnrt.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localnrt != null) {
        break;
      }
      return false;
    }
    if (localnrt.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrw
 * JD-Core Version:    0.7.0.1
 */