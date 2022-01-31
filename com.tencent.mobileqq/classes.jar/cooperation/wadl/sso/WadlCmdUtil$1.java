package cooperation.wadl.sso;

import aahi;
import android.content.Intent;
import bdhb;
import bkjb;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(bkjb parambkjb, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = bkjb.a();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (bdhb.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString, false))
    {
      aahi.a("LAST_GET_CONF_VERSION", this.jdField_a_of_type_Long);
      aahi.a("LAST_GET_CONF_TIME", bkjb.a(this.this$0));
      localObject = new Intent("com.tencent.gamecenter.action");
      ((Intent)localObject).setPackage(BaseApplicationImpl.getApplication().getPackageName());
      ((Intent)localObject).putExtra("key_event_id", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */