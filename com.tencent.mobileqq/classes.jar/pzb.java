import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class pzb
  extends pyz
{
  public pzb(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public int a(int paramInt)
  {
    int i = -1;
    try
    {
      paramInt = this.jdField_a_of_type_Aukn.a(GuideData.class.getSimpleName(), "source=?", new String[] { String.valueOf(paramInt) });
      return paramInt;
    }
    catch (Exception localException)
    {
      do
      {
        paramInt = i;
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyOperationManager", 2, localException, new Object[0]);
    }
    return -1;
  }
  
  public BaseResData a(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if ("operation_guide".equals(str1)) {}
    for (paramString = GuideData.class;; paramString = null)
    {
      if (paramString == null) {}
      do
      {
        return null;
        String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        paramString = this.jdField_a_of_type_Aukn.a(paramString, paramString.getSimpleName(), true, "uin=? and showTime!=0 and business=?", new String[] { str2, str1 }, null, null, "showTime desc", "1");
      } while ((paramString == null) || (paramString.size() <= 0));
      return (BaseResData)paramString.get(0);
    }
  }
  
  public List<GuideData> a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    return this.jdField_a_of_type_Aukn.a(GuideData.class, GuideData.class.getSimpleName(), true, "uin=? and showTime=? and business=? and endTime>? and id=?", new String[] { paramString1, "0", str, String.valueOf(i), paramString2 }, null, null, "seq desc", null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aukn != null)
    {
      this.jdField_a_of_type_Aukn.a(GuideData.class);
      return;
    }
    QLog.e("ReadInJoyOperationManager", 1, "[clearGuideDataInDatabase] entity manager is null");
  }
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    this.jdField_a_of_type_Aukn.b(paramBaseResData);
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return true;
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.showTime = ((int)(System.currentTimeMillis() / 1000L));
    paramBaseResData.setStatus(1000);
    this.jdField_a_of_type_Aukn.b(paramBaseResData);
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return aybq.a(new File(b(paramString, paramBaseResData.id)));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzb
 * JD-Core Version:    0.7.0.1
 */