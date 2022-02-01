import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class msd
{
  private static msd jdField_a_of_type_Msd = new msd();
  public int a;
  private long jdField_a_of_type_Long;
  private aojs jdField_a_of_type_Aojs = new mse(this);
  private blgz<msj> jdField_a_of_type_Blgz = new blgz();
  private Map<String, msl> jdField_a_of_type_JavaUtilMap = new HashMap();
  private msk jdField_a_of_type_Msk;
  
  private msd()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static msd a()
  {
    return jdField_a_of_type_Msd;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    bhlq.a(paramContext, 230, paramString1, paramString2, 2131695006, 2131695008, new msf(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new msg(paramQQAppInterface, paramContext, paramIntent, str));
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
    this.jdField_a_of_type_Msk = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, msj parammsj)
  {
    Object localObject = (msl)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((msl)localObject).jdField_a_of_type_Long < 60000L)) {
      parammsj.a(((msl)localObject).jdField_a_of_type_Int, (msl)localObject, 1000);
    }
    do
    {
      return;
      localObject = (aoip)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Aojs);
        long l = ((aoip)localObject).a(mvb.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Blgz.a(l, parammsj);
        return;
      }
      parammsj.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, msk parammsk)
  {
    this.jdField_a_of_type_Msk = parammsk;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammsk.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammsk = (aoip)paramAppInterface.getBusinessHandler(20);
    } while (parammsk == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    parammsk.a(mvb.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Msk = null;
    this.jdField_a_of_type_Blgz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msd
 * JD-Core Version:    0.7.0.1
 */