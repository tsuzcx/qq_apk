import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSAllInOneJump;
import com.tencent.qphone.base.util.QLog;

public class pwg
  implements IPTSAllInOneJump
{
  public final String a = "PTSAllInOneJumpModule";
  
  public void allInOneJump(String paramString)
  {
    QLog.i("PTSAllInOneJumpModule", 1, "[allInOneJump], url = " + paramString);
    if (BaseActivity.sTopActivity != null) {
      ors.a(BaseActivity.sTopActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwg
 * JD-Core Version:    0.7.0.1
 */