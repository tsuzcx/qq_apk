import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class msj
{
  private static msj jdField_a_of_type_Msj = new msj();
  public int a;
  private long jdField_a_of_type_Long;
  private aofu jdField_a_of_type_Aofu = new msk(this);
  private bkyb<msp> jdField_a_of_type_Bkyb = new bkyb();
  private Map<String, msr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private msq jdField_a_of_type_Msq;
  
  private msj()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static msj a()
  {
    return jdField_a_of_type_Msj;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    bhdj.a(paramContext, 230, paramString1, paramString2, 2131695360, 2131695362, new msl(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new msm(paramQQAppInterface, paramContext, paramIntent, str));
  }
  
  private static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AboutActivity.class);
    if ((paramContext instanceof Activity))
    {
      if (!((Activity)paramContext).isFinishing()) {}
    }
    else {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Msq = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, msp parammsp)
  {
    Object localObject = (msr)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((msr)localObject).jdField_a_of_type_Long < 60000L)) {
      parammsp.a(((msr)localObject).jdField_a_of_type_Int, (msr)localObject, 1000);
    }
    do
    {
      return;
      localObject = (aoep)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Aofu);
        long l = ((aoep)localObject).a(mvi.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Bkyb.a(l, parammsp);
        return;
      }
      parammsp.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, msq parammsq)
  {
    this.jdField_a_of_type_Msq = parammsq;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammsq.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammsq = (aoep)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (parammsq == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    parammsq.a(mvi.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Msq = null;
    this.jdField_a_of_type_Bkyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msj
 * JD-Core Version:    0.7.0.1
 */