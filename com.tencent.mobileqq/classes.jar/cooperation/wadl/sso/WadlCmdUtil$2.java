package cooperation.wadl.sso;

import aceh;
import android.content.Intent;
import bgmg;
import bmxq;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class WadlCmdUtil$2
  implements Runnable
{
  public WadlCmdUtil$2(bmxq parambmxq, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = bmxq.a();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (bgmg.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString, false))
    {
      aceh.a("LAST_GET_CONF_VERSION", this.jdField_a_of_type_Long);
      aceh.a("LAST_GET_CONF_TIME", bmxq.a(this.this$0));
      localObject = new Intent("com.tencent.gamecenter.action");
      ((Intent)localObject).setPackage(BaseApplicationImpl.getApplication().getPackageName());
      ((Intent)localObject).putExtra("key_event_id", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.2
 * JD-Core Version:    0.7.0.1
 */