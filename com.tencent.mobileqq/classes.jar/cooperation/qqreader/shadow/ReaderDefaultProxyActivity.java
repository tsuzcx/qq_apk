package cooperation.qqreader.shadow;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import bfne;
import bfnk;

public class ReaderDefaultProxyActivity
  extends Activity
{
  private final String a = getClass().getName();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bfne.b(this.a, "[ReaderPlugin] 异常分支：自动重启Reader插件Activity的场景，finish不做任何处理 ");
    bfnk.a(this, -1, "Recover failed activity=" + this.a, "");
    finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderDefaultProxyActivity
 * JD-Core Version:    0.7.0.1
 */