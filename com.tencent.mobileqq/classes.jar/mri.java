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

public class mri
{
  private static mri jdField_a_of_type_Mri = new mri();
  public int a;
  private long jdField_a_of_type_Long;
  private akim jdField_a_of_type_Akim = new mrj(this);
  private bfms<mro> jdField_a_of_type_Bfms = new bfms();
  private Map<String, mrq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private mrp jdField_a_of_type_Mrp;
  
  private mri()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static mri a()
  {
    return jdField_a_of_type_Mri;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    bbcv.a(paramContext, 230, paramString1, paramString2, 2131695919, 2131695921, new mrk(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new mrl(paramQQAppInterface, paramContext, paramIntent, str));
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
    this.jdField_a_of_type_Mrp = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mro parammro)
  {
    Object localObject = (mrq)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((mrq)localObject).jdField_a_of_type_Long < 60000L)) {
      parammro.a(((mrq)localObject).jdField_a_of_type_Int, (mrq)localObject, 1000);
    }
    do
    {
      return;
      localObject = (akhq)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Akim);
        long l = ((akhq)localObject).a(mud.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Bfms.a(l, parammro);
        return;
      }
      parammro.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mrp parammrp)
  {
    this.jdField_a_of_type_Mrp = parammrp;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammrp.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammrp = (akhq)paramAppInterface.getBusinessHandler(20);
    } while (parammrp == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Akim);
    parammrp.a(mud.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Mrp = null;
    this.jdField_a_of_type_Bfms.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mri
 * JD-Core Version:    0.7.0.1
 */