import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lbp
  extends lbq<lbo>
{
  public lbp(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return apub.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lbo b(int paramInt)
  {
    return (lbo)apub.a().a(paramInt);
  }
  
  @NonNull
  public lbo a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbo();
  }
  
  @Nullable
  protected lbo a(aptx[] paramArrayOfaptx)
  {
    lbo locallbo = new lbo();
    paramArrayOfaptx = a(this.jdField_a_of_type_JavaLangString, type(), paramArrayOfaptx);
    if (paramArrayOfaptx != null) {
      locallbo.a(paramArrayOfaptx.jdField_a_of_type_Int, paramArrayOfaptx.jdField_a_of_type_JavaLangString);
    }
    return locallbo;
  }
  
  public void a(lbo paramlbo)
  {
    super.onUpdate(paramlbo);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlbo == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      lgd.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mti.a(localQQAppInterface, paramlbo.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      maq.a().a(paramlbo.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((ltv)localQQAppInterface.getManager(254)).b(paramlbo.jdField_a_of_type_JavaLangString);
      ltf.a(true);
      return;
    case 276: 
      bfxg.a(paramlbo.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      msu.a(paramlbo.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramlbo.jdField_a_of_type_JavaLangString);
      return;
    }
    lmg.a(paramlbo.jdField_a_of_type_JavaLangString);
  }
  
  public Class<lbo> clazz()
  {
    return lbo.class;
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
    ((ltv)((QQAppInterface)localObject).getManager(254)).c();
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
      ((ltv)((QQAppInterface)localObject).getManager(254)).c();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbp
 * JD-Core Version:    0.7.0.1
 */