import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dd
{
  private ajgs jdField_a_of_type_Ajgs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public dc a;
  private dg jdField_a_of_type_Dg;
  private List<dc> jdField_a_of_type_JavaUtilList;
  private xrg jdField_a_of_type_Xrg;
  
  public dd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ajgs = new de(this);
    this.jdField_a_of_type_Xrg = new df(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (xrh)paramQQAppInterface.a(51);
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
    if (this.jdField_a_of_type_Dg != null) {
      this.jdField_a_of_type_Dg.a(paramInt);
    }
  }
  
  public dc a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = azzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer");
    a();
    return b(str);
  }
  
  public dc a(long paramLong)
  {
    if ((paramLong != 0L) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        dc localdc = (dc)localIterator.next();
        if (localdc.jdField_a_of_type_Long == paramLong) {
          return localdc;
        }
      }
    }
    return null;
  }
  
  public dc a(String paramString)
  {
    db localdb = null;
    if (paramString != null)
    {
      localdb = new db();
      localdb.jdField_a_of_type_Int = 1;
      localdb.jdField_a_of_type_Long = 0L;
      localdb.jdField_a_of_type_JavaLangString = paramString;
      localdb.c = true;
      localdb.b = true;
      localdb.jdField_a_of_type_Boolean = true;
    }
    return localdb;
  }
  
  public List<dc> a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (ajgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (((ajgm)localObject).a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = ((ajgm)localObject).a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dc localdc = a((String)((Iterator)localObject).next());
        this.jdField_a_of_type_JavaUtilList.add(localdc);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajgs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Xrg);
    }
    this.jdField_a_of_type_Dg = null;
  }
  
  public void a(dg paramdg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Xrg);
    }
    this.jdField_a_of_type_Dg = paramdg;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    azzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer", paramString);
  }
  
  public boolean a()
  {
    return ((ajrc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a() != 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = apck.a(paramString);
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
  
  public dc b(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        dc localdc = (dc)localIterator.next();
        if (localdc.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localdc;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dd
 * JD-Core Version:    0.7.0.1
 */