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

public class mrf
{
  private static mrf jdField_a_of_type_Mrf = new mrf();
  public int a;
  private long jdField_a_of_type_Long;
  private akil jdField_a_of_type_Akil = new mrg(this);
  private bfnj<mrl> jdField_a_of_type_Bfnj = new bfnj();
  private Map<String, mrn> jdField_a_of_type_JavaUtilMap = new HashMap();
  private mrm jdField_a_of_type_Mrm;
  
  private mrf()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static mrf a()
  {
    return jdField_a_of_type_Mrf;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    bbdj.a(paramContext, 230, paramString1, paramString2, 2131695920, 2131695922, new mrh(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new mri(paramQQAppInterface, paramContext, paramIntent, str));
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
    this.jdField_a_of_type_Mrm = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mrl parammrl)
  {
    Object localObject = (mrn)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((mrn)localObject).jdField_a_of_type_Long < 60000L)) {
      parammrl.a(((mrn)localObject).jdField_a_of_type_Int, (mrn)localObject, 1000);
    }
    do
    {
      return;
      localObject = (akhp)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Akil);
        long l = ((akhp)localObject).a(mua.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Bfnj.a(l, parammrl);
        return;
      }
      parammrl.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mrm parammrm)
  {
    this.jdField_a_of_type_Mrm = parammrm;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammrm.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammrm = (akhp)paramAppInterface.getBusinessHandler(20);
    } while (parammrm == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Akil);
    parammrm.a(mua.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Mrm = null;
    this.jdField_a_of_type_Bfnj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */