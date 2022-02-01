import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dk
{
  private abgl jdField_a_of_type_Abgl;
  private ansy jdField_a_of_type_Ansy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public dj a;
  private dn jdField_a_of_type_Dn;
  private List<dj> jdField_a_of_type_JavaUtilList;
  
  public dk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ansy = new dl(this);
    this.jdField_a_of_type_Abgl = new dm(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (abgm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
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
    if (this.jdField_a_of_type_Dn != null) {
      this.jdField_a_of_type_Dn.a(paramInt);
    }
  }
  
  public dj a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = SharePreferenceUtils.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer");
    a();
    return b(str);
  }
  
  public dj a(long paramLong)
  {
    if ((paramLong != 0L) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        dj localdj = (dj)localIterator.next();
        if (localdj.jdField_a_of_type_Long == paramLong) {
          return localdj;
        }
      }
    }
    return null;
  }
  
  public dj a(String paramString)
  {
    di localdi = null;
    if (paramString != null)
    {
      localdi = new di();
      localdi.jdField_a_of_type_Int = 1;
      localdi.jdField_a_of_type_Long = 0L;
      localdi.jdField_a_of_type_JavaLangString = paramString;
      localdi.c = true;
      localdi.b = true;
      localdi.jdField_a_of_type_Boolean = true;
    }
    return localdi;
  }
  
  public List<dj> a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (((ansr)localObject).a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = ((ansr)localObject).a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dj localdj = a((String)((Iterator)localObject).next());
        this.jdField_a_of_type_JavaUtilList.add(localdj);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Abgl);
    }
    this.jdField_a_of_type_Dn = null;
  }
  
  public void a(dn paramdn)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ansy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Abgl);
    }
    this.jdField_a_of_type_Dn = paramdn;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharePreferenceUtils.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), str + "_last_printer", paramString);
  }
  
  public boolean a()
  {
    return ((aocn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a() != 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = auea.a(paramString);
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
  
  public dj b(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        dj localdj = (dj)localIterator.next();
        if (localdj.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localdj;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dk
 * JD-Core Version:    0.7.0.1
 */