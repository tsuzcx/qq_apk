import android.text.TextUtils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.av.ui.redbag.ResultData;
import com.tencent.av.ui.redbag.ResultUI;
import com.tencent.qphone.base.util.QLog;

public class kfi
  extends ControlUIObserver
{
  public kfi(ResultUI paramResultUI) {}
  
  protected void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      return;
    }
    paramCPreEventInfo.jdField_b_of_type_Boolean = this.a.a("onAVActivityPreBackPressed");
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      paramCPreEventInfo.a = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramCPreEventInfo.jdField_b_of_type_Boolean + "]");
  }
  
  protected void f(String paramString)
  {
    if (this.a.a() != null)
    {
      QLog.w(this.a.i, 1, "onActivityOnResume, peerUin[" + paramString + "], mStarter[" + this.a.a.jdField_b_of_type_Boolean + "], mPlayUin[" + this.a.a.jdField_b_of_type_JavaLangString + "], mStartUin[" + this.a.a.a + "]");
      if (((this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.jdField_b_of_type_JavaLangString, paramString))) || ((!this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.a, paramString)))) {
        this.a.c();
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfi
 * JD-Core Version:    0.7.0.1
 */