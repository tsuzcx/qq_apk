package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import bijd;
import bilv;
import bima;
import birb;
import bire;
import biwo;
import biwp;
import bizt;
import bizx;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(bima parambima, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject = null;
    int j = 0;
    bire localbire2;
    String str;
    if ((bima.a(this.this$0) != null) && (!bima.b(this.this$0).isFinishing()))
    {
      if ((bima.a(this.this$0).b()) && (!bima.a(this.this$0))) {
        bima.a(this.this$0).setVisibility(0);
      }
      bima.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localbire2 = birb.a();
      if ((bima.c(this.this$0) == null) || (bima.d(this.this$0).isFinishing())) {
        break label616;
      }
      localObject = bima.e(this.this$0).getIntent();
      str = ((Intent)localObject).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject = ((Intent)localObject).getStringExtra("KEY_CURRENT_TAB");
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = j;
        if (!((String)localObject).equals(String.valueOf(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int))) {}
      }
      else
      {
        if (str == null) {
          break label572;
        }
        if (str.startsWith("http")) {
          try
          {
            localObject = new Intent(bima.a(this.this$0).a(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLDecoder.decode(str, "UTF-8"));
            ((Intent)localObject).putExtra("loc_play_show_material_id", str);
            bima.a(this.this$0).a().startActivity((Intent)localObject);
            bima.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        bizx.a().f("-1");
        j = bima.a(this.this$0, localUnsupportedEncodingException);
        if (j == -1) {
          break label456;
        }
        bima.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localUnsupportedEncodingException);
        localbire1 = bima.a(this.this$0, j);
        i = j;
        if (localbire1 != null)
        {
          bizt.a().b(localbire1.a);
          localbire1.b = true;
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
        if (i < bima.a(this.this$0).getItemCount()) {
          bima.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label456:
        localbire1 = bima.a(this.this$0).a(localbire1);
        if (localbire1 != null)
        {
          bima.a(this.this$0).a(localbire1);
          bima.h(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localbire1.a);
          bizt.a().b(localbire1.a);
          localbire1.b = true;
          i = 1;
        }
        else
        {
          Toast.makeText(bima.a(this.this$0).a(), 2131689782, 1).show();
          i = 0;
          continue;
          label572:
          i = j;
          if (localbire2 != null)
          {
            j = bima.a(this.this$0, localbire2.a);
            i = j;
            if (j == -1)
            {
              bima.a(this.this$0).a(localbire2);
              i = 1;
            }
          }
        }
      }
      label616:
      bire localbire1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */