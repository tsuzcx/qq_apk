import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nrt
{
  public static nrq a()
  {
    nrq localnrq2 = nrs.a();
    nrq localnrq1 = localnrq2;
    if (localnrq2 == null) {
      localnrq1 = new nrq();
    }
    return localnrq1;
  }
  
  public static nrr a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nrr localnrr = (nrr)((Iterator)localObject).next();
        if (localnrr.jdField_a_of_type_Int == paramInt) {
          return localnrr;
        }
      }
    }
    return new nrr();
  }
  
  public static boolean a()
  {
    nrq localnrq = nrs.a();
    if (localnrq == null) {}
    for (String str = "false";; str = localnrq.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localnrq != null) {
        break;
      }
      return false;
    }
    if (localnrq.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrt
 * JD-Core Version:    0.7.0.1
 */