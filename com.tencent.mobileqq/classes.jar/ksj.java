import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ksj
  extends ksk<ksi>
{
  public ksj(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return alzw.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static ksi b(int paramInt)
  {
    return (ksi)alzw.a().a(paramInt);
  }
  
  public Class<ksi> a()
  {
    return ksi.class;
  }
  
  @NonNull
  public ksi a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new ksi();
  }
  
  @Nullable
  protected ksi a(alzs[] paramArrayOfalzs)
  {
    paramArrayOfalzs = a(this.jdField_a_of_type_JavaLangString, a(), paramArrayOfalzs);
    int i = paramArrayOfalzs.jdField_a_of_type_Int;
    paramArrayOfalzs = paramArrayOfalzs.jdField_a_of_type_JavaLangString;
    ksi localksi = new ksi();
    localksi.a(i, paramArrayOfalzs);
    return localksi;
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
      ((ljw)((QQAppInterface)localObject).getManager(254)).b();
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
    ((ljw)((QQAppInterface)localObject).getManager(254)).b();
  }
  
  public void a(ksi paramksi)
  {
    super.a(paramksi);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (a())
    {
    default: 
      return;
    case 132: 
      kwt.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mic.a(localQQAppInterface, paramksi.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      lqh.a().a(paramksi.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((ljw)localQQAppInterface.getManager(254)).b(paramksi.jdField_a_of_type_JavaLangString);
      ljg.a(true);
      return;
    case 276: 
      baei.a(paramksi.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      mhr.a(paramksi.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, a(), paramksi.jdField_a_of_type_JavaLangString);
      return;
    }
    lco.a(paramksi.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     ksj
 * JD-Core Version:    0.7.0.1
 */