import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lbq
  extends lbr<lbp>
{
  public lbq(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aqlk.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lbp b(int paramInt)
  {
    return (lbp)aqlk.a().a(paramInt);
  }
  
  @NonNull
  public lbp a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbp();
  }
  
  @Nullable
  protected lbp a(aqlg[] paramArrayOfaqlg)
  {
    lbp locallbp = new lbp();
    paramArrayOfaqlg = a(this.jdField_a_of_type_JavaLangString, type(), paramArrayOfaqlg);
    if (paramArrayOfaqlg != null) {
      locallbp.a(paramArrayOfaqlg.jdField_a_of_type_Int, paramArrayOfaqlg.jdField_a_of_type_JavaLangString);
    }
    return locallbp;
  }
  
  public void a(lbp paramlbp)
  {
    super.onUpdate(paramlbp);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlbp == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      lgb.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mta.a(localQQAppInterface, paramlbp.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      mal.a().a(paramlbp.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((ltr)localQQAppInterface.getManager(254)).b(paramlbp.jdField_a_of_type_JavaLangString);
      ltb.a(true);
      return;
    case 276: 
      bgoh.a(paramlbp.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      msn.a(paramlbp.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramlbp.jdField_a_of_type_JavaLangString);
      return;
    }
    lma.a(paramlbp.jdField_a_of_type_JavaLangString);
  }
  
  public Class<lbp> clazz()
  {
    return lbp.class;
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
    ((ltr)((QQAppInterface)localObject).getManager(254)).c();
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
      ((ltr)((QQAppInterface)localObject).getManager(254)).c();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbq
 * JD-Core Version:    0.7.0.1
 */