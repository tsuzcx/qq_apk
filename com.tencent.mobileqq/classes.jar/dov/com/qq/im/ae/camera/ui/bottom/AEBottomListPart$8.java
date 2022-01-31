package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import bkle;
import bkqk;
import bkqr;
import bkvr;
import bkvu;
import blen;
import bler;
import blfg;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(bkqr parambkqr, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = null;
    int j = 0;
    bkvu localbkvu2;
    Object localObject1;
    String str;
    if ((bkqr.a(this.this$0) != null) && (!bkqr.b(this.this$0).isFinishing()))
    {
      if (bkqr.b(this.this$0)) {
        bkqr.a(this.this$0).setVisibility(0);
      }
      bkqr.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localbkvu2 = bkvr.a();
      if ((bkqr.c(this.this$0) == null) || (bkqr.d(this.this$0).isFinishing())) {
        break label690;
      }
      localObject1 = bkqr.e(this.this$0).getIntent();
      str = ((Intent)localObject1).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject1 = ((Intent)localObject1).getStringExtra("KEY_CURRENT_TAB");
      if (!"null".equalsIgnoreCase(str)) {
        break label683;
      }
    }
    for (;;)
    {
      int i;
      if (localObject1 != null)
      {
        i = j;
        if (!((String)localObject1).equals(AECaptureMode.NORMAL.name)) {}
      }
      else
      {
        if (localObject2 == null) {
          break label639;
        }
        if (((String)localObject2).startsWith("http")) {
          try
          {
            localObject1 = new Intent(bkqr.a(this.this$0).a(), QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", URLDecoder.decode((String)localObject2, "UTF-8"));
            ((Intent)localObject1).putExtra("loc_play_show_material_id", (String)localObject2);
            bkqr.a(this.this$0).a().startActivity((Intent)localObject1);
            bkqr.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        bler.a().f("-1");
        j = bkqr.a(this.this$0, (String)localObject2);
        if (j == -1) {
          break label471;
        }
        bkqr.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + (String)localObject2);
        localbkvu1 = bkqr.a(this.this$0, j);
        i = j;
        if (localbkvu1 != null)
        {
          blen.a().c(localbkvu1.a);
          localbkvu1.b = true;
          bkqr.h(this.this$0).getIntent().putExtra("key_camera_material_name", localbkvu1.i);
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
        if (i < bkqr.a(this.this$0).getItemCount()) {
          bkqr.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label471:
        localbkvu1 = bkqr.a(this.this$0).a((String)localObject2);
        if (localbkvu1 != null)
        {
          bkqr.a(this.this$0).a(localbkvu1);
          bkqr.i(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localbkvu1.a);
          localObject2 = localbkvu1.i;
          blfg.b("AEWaterMarkListPart", "dataNotify---塞拍同款名 takeSameName=" + (String)localObject2);
          bkqr.j(this.this$0).getIntent().putExtra("key_camera_material_name", (String)localObject2);
          blen.a().c(localbkvu1.a);
          localbkvu1.b = true;
          i = 1;
        }
        else
        {
          Toast.makeText(bkqr.a(this.this$0).a(), 2131689784, 1).show();
          i = 0;
          continue;
          label639:
          i = j;
          if (localbkvu2 != null)
          {
            j = bkqr.a(this.this$0, localbkvu2.a);
            i = j;
            if (j == -1)
            {
              bkqr.a(this.this$0).a(localbkvu2);
              i = 1;
            }
          }
        }
      }
      label683:
      localObject2 = str;
      continue;
      label690:
      bkvu localbkvu1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */