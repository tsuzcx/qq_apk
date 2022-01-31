import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.util.CommonUtil;
import java.util.ArrayList;

public class sjx
  extends BroadcastReceiver
{
  public sjx(DirectForwardActivity paramDirectForwardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramContext = paramIntent.getStringArrayList("procNameList");
      paramIntent = paramIntent.getString("verify");
      if ((paramContext != null) && (paramContext.size() != 0) && (this.a.a != null) && (CommonUtil.a(paramIntent, paramContext))) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      label53:
      int i = 0;
      while (i < paramContext.size())
      {
        if (this.a.a.equals(paramContext.get(i)))
        {
          this.a.finish();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjx
 * JD-Core Version:    0.7.0.1
 */