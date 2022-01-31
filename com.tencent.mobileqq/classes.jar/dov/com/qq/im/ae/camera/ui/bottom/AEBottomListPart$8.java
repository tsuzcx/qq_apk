package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import bkpl;
import bkur;
import bkuy;
import bkzy;
import blab;
import bliu;
import bliy;
import bljn;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(bkuy parambkuy, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = null;
    int j = 0;
    blab localblab2;
    Object localObject1;
    String str;
    if ((bkuy.a(this.this$0) != null) && (!bkuy.b(this.this$0).isFinishing()))
    {
      if (bkuy.b(this.this$0)) {
        bkuy.a(this.this$0).setVisibility(0);
      }
      bkuy.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localblab2 = bkzy.a();
      if ((bkuy.c(this.this$0) == null) || (bkuy.d(this.this$0).isFinishing())) {
        break label690;
      }
      localObject1 = bkuy.e(this.this$0).getIntent();
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
            localObject1 = new Intent(bkuy.a(this.this$0).a(), QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", URLDecoder.decode((String)localObject2, "UTF-8"));
            ((Intent)localObject1).putExtra("loc_play_show_material_id", (String)localObject2);
            bkuy.a(this.this$0).a().startActivity((Intent)localObject1);
            bkuy.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        bliy.a().f("-1");
        j = bkuy.a(this.this$0, (String)localObject2);
        if (j == -1) {
          break label471;
        }
        bkuy.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + (String)localObject2);
        localblab1 = bkuy.a(this.this$0, j);
        i = j;
        if (localblab1 != null)
        {
          bliu.a().c(localblab1.a);
          localblab1.b = true;
          bkuy.h(this.this$0).getIntent().putExtra("key_camera_material_name", localblab1.i);
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
        if (i < bkuy.a(this.this$0).getItemCount()) {
          bkuy.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label471:
        localblab1 = bkuy.a(this.this$0).a((String)localObject2);
        if (localblab1 != null)
        {
          bkuy.a(this.this$0).a(localblab1);
          bkuy.i(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localblab1.a);
          localObject2 = localblab1.i;
          bljn.b("AEWaterMarkListPart", "dataNotify---塞拍同款名 takeSameName=" + (String)localObject2);
          bkuy.j(this.this$0).getIntent().putExtra("key_camera_material_name", (String)localObject2);
          bliu.a().c(localblab1.a);
          localblab1.b = true;
          i = 1;
        }
        else
        {
          Toast.makeText(bkuy.a(this.this$0).a(), 2131689784, 1).show();
          i = 0;
          continue;
          label639:
          i = j;
          if (localblab2 != null)
          {
            j = bkuy.a(this.this$0, localblab2.a);
            i = j;
            if (j == -1)
            {
              bkuy.a(this.this$0).a(localblab2);
              i = 1;
            }
          }
        }
      }
      label683:
      localObject2 = str;
      continue;
      label690:
      blab localblab1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */