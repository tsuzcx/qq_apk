package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import biim;
import bile;
import bilj;
import biqk;
import biqn;
import bivx;
import bivy;
import bizc;
import bizg;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(bilj parambilj, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject = null;
    int j = 0;
    biqn localbiqn2;
    String str;
    if ((bilj.a(this.this$0) != null) && (!bilj.b(this.this$0).isFinishing()))
    {
      if ((bilj.a(this.this$0).b()) && (!bilj.a(this.this$0))) {
        bilj.a(this.this$0).setVisibility(0);
      }
      bilj.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localbiqn2 = biqk.a();
      if ((bilj.c(this.this$0) == null) || (bilj.d(this.this$0).isFinishing())) {
        break label616;
      }
      localObject = bilj.e(this.this$0).getIntent();
      str = ((Intent)localObject).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject = ((Intent)localObject).getStringExtra("KEY_CURRENT_TAB");
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = j;
        if (!((String)localObject).equals(String.valueOf(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int))) {}
      }
      else
      {
        if (str == null) {
          break label572;
        }
        if (str.startsWith("http")) {
          try
          {
            localObject = new Intent(bilj.a(this.this$0).a(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLDecoder.decode(str, "UTF-8"));
            ((Intent)localObject).putExtra("loc_play_show_material_id", str);
            bilj.a(this.this$0).a().startActivity((Intent)localObject);
            bilj.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        bizg.a().f("-1");
        j = bilj.a(this.this$0, localUnsupportedEncodingException);
        if (j == -1) {
          break label456;
        }
        bilj.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localUnsupportedEncodingException);
        localbiqn1 = bilj.a(this.this$0, j);
        i = j;
        if (localbiqn1 != null)
        {
          bizc.a().b(localbiqn1.a);
          localbiqn1.b = true;
          i = j;
        }
      }
      for (;;)
      {
        long l = 0L;
        if (QLog.isDevelopLevel())
        {
          l = System.currentTimeMillis();
          QLog.d("AEWaterMarkListPart", 4, "foundInitPosition cost=" + (l - this.jdField_a_of_type_Long));
        }
        if (i < bilj.a(this.this$0).getItemCount()) {
          bilj.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label456:
        localbiqn1 = bilj.a(this.this$0).a(localbiqn1);
        if (localbiqn1 != null)
        {
          bilj.a(this.this$0).a(localbiqn1);
          bilj.h(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localbiqn1.a);
          bizc.a().b(localbiqn1.a);
          localbiqn1.b = true;
          i = 1;
        }
        else
        {
          Toast.makeText(bilj.a(this.this$0).a(), 2131689782, 1).show();
          i = 0;
          continue;
          label572:
          i = j;
          if (localbiqn2 != null)
          {
            j = bilj.a(this.this$0, localbiqn2.a);
            i = j;
            if (j == -1)
            {
              bilj.a(this.this$0).a(localbiqn2);
              i = 1;
            }
          }
        }
      }
      label616:
      biqn localbiqn1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */