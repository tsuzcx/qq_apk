import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lct
  extends lcu<lcs>
{
  public lct(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ampl.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lcs b(int paramInt)
  {
    return (lcs)ampl.a().a(paramInt);
  }
  
  public Class<lcs> a()
  {
    return lcs.class;
  }
  
  @NonNull
  public lcs a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lcs();
  }
  
  @Nullable
  protected lcs a(amph[] paramArrayOfamph)
  {
    lcs locallcs = new lcs();
    paramArrayOfamph = a(this.jdField_a_of_type_JavaLangString, a(), paramArrayOfamph);
    if (paramArrayOfamph != null) {
      locallcs.a(paramArrayOfamph.jdField_a_of_type_Int, paramArrayOfamph.jdField_a_of_type_JavaLangString);
    }
    return locallcs;
  }
  
  public void a()
  {
    super.a();
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (a())
    {
    default: 
      return;
    case 249: 
      ((lui)((QQAppInterface)localObject).getManager(254)).b();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, a());
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (a())
    {
    default: 
      return;
    }
    ((lui)((QQAppInterface)localObject).getManager(254)).b();
  }
  
  public void a(lcs paramlcs)
  {
    super.a(paramlcs);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlcs == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (a())
    {
    case 543: 
    default: 
      return;
    case 132: 
      lhd.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      msy.a(localQQAppInterface, paramlcs.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      mau.a().a(paramlcs.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((lui)localQQAppInterface.getManager(254)).b(paramlcs.jdField_a_of_type_JavaLangString);
      lts.a(true);
      return;
    case 276: 
      bbgb.a(paramlcs.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      msn.a(paramlcs.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, a(), paramlcs.jdField_a_of_type_JavaLangString);
      return;
    }
    lna.a(paramlcs.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    switch (a())
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lct
 * JD-Core Version:    0.7.0.1
 */