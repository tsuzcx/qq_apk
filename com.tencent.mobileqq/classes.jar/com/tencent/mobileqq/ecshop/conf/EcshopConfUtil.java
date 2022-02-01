package com.tencent.mobileqq.ecshop.conf;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class EcshopConfUtil
{
  public static EcshopConfBean a()
  {
    EcshopConfBean localEcshopConfBean2 = EcshopConfProcessor.a();
    EcshopConfBean localEcshopConfBean1 = localEcshopConfBean2;
    if (localEcshopConfBean2 == null) {
      localEcshopConfBean1 = new EcshopConfBean();
    }
    return localEcshopConfBean1;
  }
  
  public static boolean a()
  {
    return a(EcshopConfProcessor.a());
  }
  
  public static boolean a(EcshopConfBean paramEcshopConfBean)
  {
    return a(paramEcshopConfBean, 1, 1);
  }
  
  public static boolean a(EcshopConfBean paramEcshopConfBean, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEcshopConfBean != null)
    {
      bool1 = bool2;
      if (paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          return false;
        }
        paramEcshopConfBean = paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList.iterator();
        EcshopConfBean.TabConfBean localTabConfBean;
        do
        {
          bool1 = bool2;
          if (!paramEcshopConfBean.hasNext()) {
            break;
          }
          localTabConfBean = (EcshopConfBean.TabConfBean)paramEcshopConfBean.next();
        } while ((localTabConfBean.b != paramInt1) || (localTabConfBean.jdField_a_of_type_Int != paramInt2));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b()
  {
    EcshopConfBean localEcshopConfBean = a();
    Object localObject;
    if (localEcshopConfBean == null)
    {
      localObject = "false";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localEcshopConfBean.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    QLog.i("EcshopEcshopConfUtil", 2, (String)localObject);
    boolean bool = false;
    if (localEcshopConfBean == null) {
      return false;
    }
    if (localEcshopConfBean.jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.conf.EcshopConfUtil
 * JD-Core Version:    0.7.0.1
 */