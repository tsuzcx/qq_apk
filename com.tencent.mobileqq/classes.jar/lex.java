import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class lex
  extends ley<lew>
{
  public lex(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aogj.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static lew b(int paramInt)
  {
    return (lew)aogj.a().a(paramInt);
  }
  
  public Class<lew> a()
  {
    return lew.class;
  }
  
  @NonNull
  public lew a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lew();
  }
  
  @Nullable
  protected lew a(aogf[] paramArrayOfaogf)
  {
    lew locallew = new lew();
    paramArrayOfaogf = a(this.jdField_a_of_type_JavaLangString, a(), paramArrayOfaogf);
    if (paramArrayOfaogf != null) {
      locallew.a(paramArrayOfaogf.jdField_a_of_type_Int, paramArrayOfaogf.jdField_a_of_type_JavaLangString);
    }
    return locallew;
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
      ((lwp)((QQAppInterface)localObject).getManager(254)).b();
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
    ((lwp)((QQAppInterface)localObject).getManager(254)).b();
  }
  
  public void a(lew paramlew)
  {
    super.a(paramlew);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramlew == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (a())
    {
    case 543: 
    default: 
      return;
    case 132: 
      ljg.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      mvs.a(localQQAppInterface, paramlew.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      mdj.a().a(paramlew.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((lwp)localQQAppInterface.getManager(254)).b(paramlew.jdField_a_of_type_JavaLangString);
      lvz.a(true);
      return;
    case 276: 
      bdex.a(paramlew.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      mvh.a(paramlew.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, a(), paramlew.jdField_a_of_type_JavaLangString);
      return;
    }
    lpd.a(paramlew.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lex
 * JD-Core Version:    0.7.0.1
 */