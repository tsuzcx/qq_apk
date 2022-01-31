package cooperation.wadl.sso;

import aact;
import android.content.Intent;
import bdcs;
import bkeu;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(bkeu parambkeu, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = bkeu.a();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (bdcs.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString, false))
    {
      aact.a("LAST_GET_CONF_VERSION", this.jdField_a_of_type_Long);
      aact.a("LAST_GET_CONF_TIME", bkeu.a(this.this$0));
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