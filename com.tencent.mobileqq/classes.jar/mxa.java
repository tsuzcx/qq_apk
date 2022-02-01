import android.content.Context;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.SmallScreenDavWTObserver.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class mxa
  extends mxh
{
  protected final lzj a;
  
  public mxa(lzj paramlzj)
  {
    super(paramlzj.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Lzj = paramlzj;
  }
  
  private void a(String paramString)
  {
    boolean bool = lzr.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (bool) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenDavWTObserver.1(this, paramString));
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.ObserverImpl", 2, "startAlertDialog, isAppForeground[" + bool + "], msg[" + paramString + "]");
    }
  }
  
  protected void a()
  {
    a(BaseApplicationImpl.getContext().getString(2131695733));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ObserverImpl", 4, "changeUIMode, start[" + paramBoolean1 + "], isAdmin[" + paramBoolean2 + "], from[" + paramString + "]");
    }
    if ((!paramBoolean2) && (paramBoolean1) && (nad.b()))
    {
      paramString = BaseApplicationImpl.getContext();
      Object localObject = lbz.a().a();
      localObject = ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).b((lfe)localObject);
      if (((myx)localObject).a) {
        break label124;
      }
      ((myx)localObject).a = true;
      a(paramString.getString(2131695739));
    }
    label124:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WTogether", 2, "showNetTip, have shown. 3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxa
 * JD-Core Version:    0.7.0.1
 */