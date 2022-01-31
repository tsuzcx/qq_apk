package cooperation.qqreader.shadow;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import bjbl;
import bjbo;

public class ReaderDefaultProxyActivity
  extends Activity
{
  private final String a = getClass().getName();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    bjbl.c(this.a, "[ReaderPlugin] 异常分支：自动重启Reader插件Activity的场景，finish不做任何处理 ");
    bjbo.a(this, -1, "Recover failed activity=" + this.a);
    finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderDefaultProxyActivity
 * JD-Core Version:    0.7.0.1
 */