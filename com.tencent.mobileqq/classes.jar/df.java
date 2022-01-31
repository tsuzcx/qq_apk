import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class df
{
  private almg jdField_a_of_type_Almg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public de a;
  private di jdField_a_of_type_Di;
  private List<de> jdField_a_of_type_JavaUtilList;
  private zoz jdField_a_of_type_Zoz;
  
  public df(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Almg = new dg(this);
    this.jdField_a_of_type_Zoz = new dh(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (zpa)paramQQAppInterface.a(51);
      if (paramQQAppInterface.a())
      {
        DeviceInfo[] arrayOfDeviceInfo = paramQQAppInterface.a();
        if (arrayOfDeviceInfo != null)
        {
          int j = arrayOfDeviceInfo.length;
          int i = 0;
          while (i < j)
          {
            DeviceInfo localDeviceInfo = arrayOfDeviceInfo[i];
            if ((paramQQAppInterface.c(localDeviceInfo.din)) && (paramQQAppInterface.a(localDeviceInfo.din, 17)) && (paramLong == localDeviceInfo.din)) {
              return localDeviceInfo;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a();
    if (this.jdField_a_of_type_Di != null) {
      this.jdField_a_of_type_Di.a(paramInt);
    }
  }
  
  public de a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer");
    a();
    return b(str);
  }
  
  public de a(long paramLong)
  {
    if ((paramLong != 0L) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        de localde = (de)localIterator.next();
        if (localde.jdField_a_of_type_Long == paramLong) {
          return localde;
        }
      }
    }
    return null;
  }
  
  public de a(String paramString)
  {
    dd localdd = null;
    if (paramString != null)
    {
      localdd = new dd();
      localdd.jdField_a_of_type_Int = 1;
      localdd.jdField_a_of_type_Long = 0L;
      localdd.jdField_a_of_type_JavaLangString = paramString;
      localdd.c = true;
      localdd.b = true;
      localdd.jdField_a_of_type_Boolean = true;
    }
    return localdd;
  }
  
  public List<de> a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (((allz)localObject).a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = ((allz)localObject).a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        de localde = a((String)((Iterator)localObject).next());
        this.jdField_a_of_type_JavaUtilList.add(localde);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Zoz);
    }
    this.jdField_a_of_type_Di = null;
  }
  
  public void a(di paramdi)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Zoz);
    }
    this.jdField_a_of_type_Di = paramdi;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer", paramString);
  }
  
  public boolean a()
  {
    return ((alxb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a() != 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = arni.a(paramString);
      if ((i != 3) && (i != 0) && (i != 7) && (i != 6) && (i != 9))
      {
        bool1 = bool2;
        if (i != 10) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public de b(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        de localde = (de)localIterator.next();
        if (localde.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localde;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     df
 * JD-Core Version:    0.7.0.1
 */