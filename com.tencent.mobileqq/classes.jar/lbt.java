import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lbt
  extends lbu<lbs>
{
  public lbt(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aqxe.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lbs b(int paramInt)
  {
    return (lbs)aqxe.a().a(paramInt);
  }
  
  @NonNull
  public lbs a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbs();
  }
  
  @Nullable
  protected lbs a(aqxa[] paramArrayOfaqxa)
  {
    lbs locallbs = new lbs();
    paramArrayOfaqxa = a(this.jdField_a_of_type_JavaLangString, type(), paramArrayOfaqxa);
    if (paramArrayOfaqxa != null) {
      locallbs.a(paramArrayOfaqxa.jdField_a_of_type_Int, paramArrayOfaqxa.jdField_a_of_type_JavaLangString);
    }
    return locallbs;
  }
  
  public void a(lbs paramlbs)
  {
    super.onUpdate(paramlbs);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlbs == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      lgp.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mug.a(localQQAppInterface, paramlbs.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      mbl.a().a(paramlbs.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((lui)localQQAppInterface.getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).b(paramlbs.jdField_a_of_type_JavaLangString);
      lts.a(true);
      return;
    case 276: 
      bhfy.a(paramlbs.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      mtr.a(paramlbs.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramlbs.jdField_a_of_type_JavaLangString);
      return;
    }
    lmt.a(paramlbs.jdField_a_of_type_JavaLangString);
  }
  
  public Class<lbs> clazz()
  {
    return lbs.class;
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
    ((lui)((QQAppInterface)localObject).getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).c();
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
      ((lui)((QQAppInterface)localObject).getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).c();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbt
 * JD-Core Version:    0.7.0.1
 */