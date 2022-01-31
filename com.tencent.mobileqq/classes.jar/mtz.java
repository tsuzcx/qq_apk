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

public class mtz
{
  private static mtz jdField_a_of_type_Mtz = new mtz();
  public int a;
  private long jdField_a_of_type_Long;
  private amab jdField_a_of_type_Amab = new mua(this);
  private bhod<muf> jdField_a_of_type_Bhod = new bhod();
  private Map<String, muh> jdField_a_of_type_JavaUtilMap = new HashMap();
  private mug jdField_a_of_type_Mug;
  
  private mtz()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static mtz a()
  {
    return jdField_a_of_type_Mtz;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    bdcd.a(paramContext, 230, paramString1, paramString2, 2131696081, 2131696083, new mub(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new muc(paramQQAppInterface, paramContext, paramIntent, str));
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
    this.jdField_a_of_type_Mug = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, muf parammuf)
  {
    Object localObject = (muh)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((muh)localObject).jdField_a_of_type_Long < 60000L)) {
      parammuf.a(((muh)localObject).jdField_a_of_type_Int, (muh)localObject, 1000);
    }
    do
    {
      return;
      localObject = (alzf)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_Amab);
        long l = ((alzf)localObject).a(mwu.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_Bhod.a(l, parammuf);
        return;
      }
      parammuf.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, mug parammug)
  {
    this.jdField_a_of_type_Mug = parammug;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      parammug.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      parammug = (alzf)paramAppInterface.getBusinessHandler(20);
    } while (parammug == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_Amab);
    parammug.a(mwu.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Mug = null;
    this.jdField_a_of_type_Bhod.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mtz
 * JD-Core Version:    0.7.0.1
 */