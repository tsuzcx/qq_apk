import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ew
{
  private ajut jdField_a_of_type_Ajut;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ev a;
  private ez jdField_a_of_type_Ez;
  private List<ev> jdField_a_of_type_JavaUtilList;
  private yag jdField_a_of_type_Yag;
  
  public ew(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ajut = new ex(this);
    this.jdField_a_of_type_Yag = new ey(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (yah)paramQQAppInterface.a(51);
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
    if (this.jdField_a_of_type_Ez != null) {
      this.jdField_a_of_type_Ez.a(paramInt);
    }
  }
  
  public ev a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = bbax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer");
    a();
    return b(str);
  }
  
  public ev a(long paramLong)
  {
    if ((paramLong != 0L) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ev localev = (ev)localIterator.next();
        if (localev.jdField_a_of_type_Long == paramLong) {
          return localev;
        }
      }
    }
    return null;
  }
  
  public ev a(String paramString)
  {
    eu localeu = null;
    if (paramString != null)
    {
      localeu = new eu();
      localeu.jdField_a_of_type_Int = 1;
      localeu.jdField_a_of_type_Long = 0L;
      localeu.jdField_a_of_type_JavaLangString = paramString;
      localeu.c = true;
      localeu.b = true;
      localeu.jdField_a_of_type_Boolean = true;
    }
    return localeu;
  }
  
  public List<ev> a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (((ajum)localObject).a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = ((ajum)localObject).a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ev localev = a((String)((Iterator)localObject).next());
        this.jdField_a_of_type_JavaUtilList.add(localev);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajut);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Yag);
    }
    this.jdField_a_of_type_Ez = null;
  }
  
  public void a(ez paramez)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajut);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Yag);
    }
    this.jdField_a_of_type_Ez = paramez;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bbax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer", paramString);
  }
  
  public boolean a()
  {
    return ((akfl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a() != 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = apug.a(paramString);
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
  
  public ev b(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ev localev = (ev)localIterator.next();
        if (localev.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localev;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ew
 * JD-Core Version:    0.7.0.1
 */