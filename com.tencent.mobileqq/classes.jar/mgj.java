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

public class mgj
{
  private static mgj jdField_a_of_type_Mgj = new mgj();
  public int a;
  private long jdField_a_of_type_Long;
  private ajuc jdField_a_of_type_Ajuc = new mgk(this);
  private beey<mgp> jdField_a_of_type_Beey = new beey();
  private Map<String, mgr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private mgq jdField_a_of_type_Mgq;
  
  private mgj()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static mgj a()
  {
    return jdField_a_of_type_Mgj;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    babr.a(paramContext, 230, paramString1, paramString2, 2131630226, 2131630228, new mgl(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new mgm(paramQQAppInterface, paramContext, paramIntent, str));
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
    this.jdField_a_of_type_Mgq = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mgp parammgp)
  {
    Object localObject = (mgr)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((mgr)localObject).jdField_a_of_type_Long < 60000L)) {
      parammgp.a(((mgr)localObject).jdField_a_of_type_Int, (mgr)localObject, 1000);
    }
    do
    {
      return;
      localObject = (ajtg)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
        long l = ((ajtg)localObject).a(mje.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Beey.a(l, parammgp);
        return;
      }
      parammgp.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mgq parammgq)
  {
    this.jdField_a_of_type_Mgq = parammgq;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammgq.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammgq = (ajtg)paramAppInterface.getBusinessHandler(20);
    } while (parammgq == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    parammgq.a(mje.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Mgq = null;
    this.jdField_a_of_type_Beey.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgj
 * JD-Core Version:    0.7.0.1
 */