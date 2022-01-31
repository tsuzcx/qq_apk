package cooperation.wadl.sso;

import android.content.Intent;
import bace;
import bgtf;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import yez;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(bgtf parambgtf, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = bgtf.a();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (bace.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString, false))
    {
      yez.a("LAST_GET_CONF_VERSION", this.jdField_a_of_type_Long);
      yez.a("LAST_GET_CONF_TIME", bgtf.a(this.this$0));
      localObject = new Intent("com.tencent.gamecenter.action");
      ((Intent)localObject).setPackage(BaseApplicationImpl.getApplication().getPackageName());
      ((Intent)localObject).putExtra("key_event_id", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */