import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class nlx
  implements View.OnClickListener, nmu
{
  int jdField_a_of_type_Int = 0;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  protected ViewGroup a;
  public AVGameAppInterface a;
  protected final String a;
  protected WeakReference<Context> a;
  public nio a;
  public nmq a;
  boolean jdField_a_of_type_Boolean = false;
  
  public nlx(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramAVGameAppInterface = a();
    if (paramAVGameAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "AVGameControlUI-->can not get AVActivity");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentResResources = paramAVGameAppInterface.getResources();
    } while (this.jdField_a_of_type_AndroidContentResResources != null);
    lbd.g(this.jdField_a_of_type_JavaLangString, "mRes is null. exit video progress");
    paramBaseActivity = paramAVGameAppInterface.getString(2131719926) + " 0x08";
    Toast.makeText(paramAVGameAppInterface.getApplicationContext(), paramBaseActivity, 0).show();
    paramAVGameAppInterface.finish();
  }
  
  public static boolean a(Context paramContext)
  {
    return true;
  }
  
  protected AVGameActivity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVGameActivity)) {
      return null;
    }
    return (AVGameActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  protected abstract void a(long paramLong, int paramInt, View paramView);
  
  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong, View paramView);
  
  public void a(long paramLong, String paramString)
  {
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString)) {
      str = localAVGameActivity.getString(2131695392);
    }
    for (paramString = localAVGameActivity.getString(2131695393);; paramString = localAVGameActivity.getString(2131695403))
    {
      a(paramLong, str, paramString);
      return;
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        break;
      }
      str = localAVGameActivity.getString(2131695402);
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (a()) {}
    AVGameActivity localAVGameActivity;
    do
    {
      return;
      localAVGameActivity = a();
    } while (localAVGameActivity == null);
    paramString1 = bhdj.a(localAVGameActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690697, new nma(this, paramLong));
    if (nqf.a(localAVGameActivity)) {}
    for (int i = 2131695404;; i = 2131695405)
    {
      paramString1.setPositiveButton(i, new nlz(this, paramLong)).show();
      return;
    }
  }
  
  public void a(List<niq> paramList) {}
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nio = paramnio;
  }
  
  public void a(nmq paramnmq)
  {
    this.jdField_a_of_type_Nmq = paramnmq;
    this.jdField_a_of_type_Nmq.a(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 6;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected boolean a(long paramLong, String paramString, View paramView, int paramInt)
  {
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {
      return false;
    }
    int i;
    if (localAVGameActivity.checkSelfPermission(paramString) == 0)
    {
      i = 1;
      if (i != 0) {
        break label263;
      }
      if (!a(localAVGameActivity)) {
        break label212;
      }
      nly localnly = new nly(this, paramString, paramLong, paramInt, paramView);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_Boolean = true;
      localAVGameActivity.requestPermissions(localnly, 0, new String[] { paramString });
      if (!"android.permission.CAMERA".equals(paramString)) {
        break label169;
      }
      bdla.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label169:
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        b(paramLong, paramView);
        bdla.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
        continue;
        label212:
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        a(paramLong, paramString);
      }
    }
    label263:
    return true;
  }
  
  public void b() {}
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  protected abstract void b(long paramLong, View paramView);
  
  protected abstract void c();
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = null;
  }
  
  public void onClick(View paramView)
  {
    a(AudioHelper.b(), paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlx
 * JD-Core Version:    0.7.0.1
 */