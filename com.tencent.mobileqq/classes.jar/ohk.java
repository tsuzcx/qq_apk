import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ohk
{
  public static ohh a()
  {
    ohh localohh2 = ohj.a();
    ohh localohh1 = localohh2;
    if (localohh2 == null) {
      localohh1 = new ohh();
    }
    return localohh1;
  }
  
  public static ohi a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ohi localohi = (ohi)((Iterator)localObject).next();
        if (localohi.jdField_a_of_type_Int == paramInt) {
          return localohi;
        }
      }
    }
    return new ohi();
  }
  
  public static boolean a()
  {
    return a(ohj.a());
  }
  
  public static boolean a(ohh paramohh)
  {
    return a(paramohh, 1, 1);
  }
  
  public static boolean a(ohh paramohh, int paramInt1, int paramInt2)
  {
    if ((paramohh == null) || (paramohh.jdField_a_of_type_JavaUtilArrayList == null) || (paramohh.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramohh = paramohh.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramohh.hasNext())
    {
      ohi localohi = (ohi)paramohh.next();
      if ((localohi.b == paramInt1) && (localohi.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    ohh localohh = a();
    if (localohh == null) {}
    for (String str = "false";; str = localohh.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localohh != null) {
        break;
      }
      return false;
    }
    if (localohh.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohk
 * JD-Core Version:    0.7.0.1
 */