import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSAllInOneJump;
import com.tencent.qphone.base.util.QLog;

public class qzi
  implements IPTSAllInOneJump
{
  public void allInOneJump(String paramString)
  {
    QLog.i("PTSAllInOneJumpModule", 1, "[allInOneJump], url = " + paramString);
    if (BaseActivity.sTopActivity != null) {
      pkh.a(BaseActivity.sTopActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzi
 * JD-Core Version:    0.7.0.1
 */