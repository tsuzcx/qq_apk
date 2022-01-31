import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lcy
  extends lcz<lcx>
{
  public lcy(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ampm.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lcx b(int paramInt)
  {
    return (lcx)ampm.a().a(paramInt);
  }
  
  public Class<lcx> a()
  {
    return lcx.class;
  }
  
  @NonNull
  public lcx a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lcx();
  }
  
  @Nullable
  protected lcx a(ampi[] paramArrayOfampi)
  {
    lcx locallcx = new lcx();
    paramArrayOfampi = a(this.jdField_a_of_type_JavaLangString, a(), paramArrayOfampi);
    if (paramArrayOfampi != null) {
      locallcx.a(paramArrayOfampi.jdField_a_of_type_Int, paramArrayOfampi.jdField_a_of_type_JavaLangString);
    }
    return locallcx;
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
      ((lun)((QQAppInterface)localObject).getManager(254)).b();
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
    ((lun)((QQAppInterface)localObject).getManager(254)).b();
  }
  
  public void a(lcx paramlcx)
  {
    super.a(paramlcx);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlcx == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (a())
    {
    case 543: 
    default: 
      return;
    case 132: 
      lhi.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mtb.a(localQQAppInterface, paramlcx.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      maz.a().a(paramlcx.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((lun)localQQAppInterface.getManager(254)).b(paramlcx.jdField_a_of_type_JavaLangString);
      ltx.a(true);
      return;
    case 276: 
      bbfn.a(paramlcx.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      msq.a(paramlcx.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, a(), paramlcx.jdField_a_of_type_JavaLangString);
      return;
    }
    lnf.a(paramlcx.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     lcy
 * JD-Core Version:    0.7.0.1
 */