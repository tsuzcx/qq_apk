package cooperation.comic.jsp;

import bgij;
import com.tencent.qphone.base.util.QLog;
import gp;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class QQComicJsPlugin$4
  implements Runnable
{
  public QQComicJsPlugin$4(bgij parambgij) {}
  
  public void run()
  {
    Object localObject = bgij.a();
    if (localObject != null)
    {
      long l1 = System.currentTimeMillis();
      gp.a(new File((String)localObject));
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQComicJsPlugin", 2, "clean cache cost " + (l2 - l1) + " ms");
      }
    }
    bgij.a().set(false);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("size", this.this$0.a());
      ((JSONObject)localObject).put("data", localJSONObject);
      label137:
      this.this$0.callJs(bgij.b(), new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */