import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lbx
  extends lby<lbw>
{
  public lbx(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aran.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lbw b(int paramInt)
  {
    return (lbw)aran.a().a(paramInt);
  }
  
  @NonNull
  public lbw a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbw();
  }
  
  @Nullable
  protected lbw a(araj[] paramArrayOfaraj)
  {
    lbw locallbw = new lbw();
    paramArrayOfaraj = a(this.jdField_a_of_type_JavaLangString, type(), paramArrayOfaraj);
    if (paramArrayOfaraj != null) {
      locallbw.a(paramArrayOfaraj.jdField_a_of_type_Int, paramArrayOfaraj.jdField_a_of_type_JavaLangString);
    }
    return locallbw;
  }
  
  public void a(lbw paramlbw)
  {
    super.onUpdate(paramlbw);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlbw == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      lgj.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mtz.a(localQQAppInterface, paramlbw.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      mbh.a().a(paramlbw.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((lun)localQQAppInterface.getManager(254)).b(paramlbw.jdField_a_of_type_JavaLangString);
      ltx.a(true);
      return;
    case 276: 
      bhoj.a(paramlbw.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      mtl.a(paramlbw.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramlbw.jdField_a_of_type_JavaLangString);
      return;
    }
    lmo.a(paramlbw.jdField_a_of_type_JavaLangString);
  }
  
  public Class<lbw> clazz()
  {
    return lbw.class;
  }
  
  public boolean isAccountRelated()
  {
    switch (type())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void onReqFailed(int paramInt)
  {
    super.onReqFailed(paramInt);
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    }
    ((lun)((QQAppInterface)localObject).getManager(254)).c();
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    case 249: 
      ((lun)((QQAppInterface)localObject).getManager(254)).c();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbx
 * JD-Core Version:    0.7.0.1
 */