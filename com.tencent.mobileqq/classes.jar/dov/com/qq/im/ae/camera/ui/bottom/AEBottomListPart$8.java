package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import bndy;
import bnjw;
import bnkd;
import bnpc;
import bnpf;
import bnyh;
import bnyl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(bnkd parambnkd, List paramList, long paramLong) {}
  
  public void run()
  {
    String str1 = null;
    int k = 0;
    int j = 1;
    bnpf localbnpf;
    Object localObject2;
    String str2;
    if ((bnkd.a(this.this$0) != null) && (!bnkd.b(this.this$0).isFinishing()))
    {
      if (bnkd.b(this.this$0)) {
        bnkd.a(this.this$0).setVisibility(0);
      }
      bnkd.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localbnpf = bnpc.a();
      if ((bnkd.c(this.this$0) == null) || (bnkd.d(this.this$0).isFinishing())) {
        break label653;
      }
      localObject2 = bnkd.e(this.this$0).getIntent();
      str2 = ((Intent)localObject2).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject2 = ((Intent)localObject2).getStringExtra("KEY_CURRENT_TAB");
      if (!"null".equalsIgnoreCase(str2)) {
        break label646;
      }
    }
    for (;;)
    {
      int i;
      if (localObject2 != null)
      {
        i = k;
        if (!((String)localObject2).equals(AECaptureMode.NORMAL.name)) {}
      }
      else
      {
        if (str1 == null) {
          break label602;
        }
        if (str1.startsWith("http")) {
          try
          {
            localObject2 = new Intent(bnkd.a(this.this$0).a(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", URLDecoder.decode(str1, "UTF-8"));
            ((Intent)localObject2).putExtra("loc_play_show_material_id", str1);
            bnkd.a(this.this$0).a().startActivity((Intent)localObject2);
            bnkd.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        bnyl.a().f("-1");
        i = bnkd.a(this.this$0, localUnsupportedEncodingException);
        if (i == -1) {
          break label473;
        }
        bnkd.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localUnsupportedEncodingException);
        localObject1 = bnkd.a(this.this$0, i);
        if (localObject1 != null)
        {
          bnyh.a().d(((bnpf)localObject1).a);
          ((bnpf)localObject1).b = true;
          bnkd.h(this.this$0).getIntent().putExtra("key_camera_material_name", ((bnpf)localObject1).i);
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
        if (i < bnkd.a(this.this$0).getItemCount()) {
          bnkd.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label473:
        localObject2 = bnkd.a(this.this$0);
        if ((bnkd.a(this.this$0) != null) && (bnkd.a(this.this$0).c())) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((bnpc)localObject2).a((String)localObject1, bool);
          if (localObject1 == null) {
            break label564;
          }
          bnkd.a(this.this$0).a((bnpf)localObject1);
          bnyh.a().d(((bnpf)localObject1).a);
          ((bnpf)localObject1).b = true;
          i = j;
          break;
        }
        label564:
        if (bnkd.a(this.this$0) == AECaptureMode.NORMAL) {
          Toast.makeText(bnkd.a(this.this$0).a(), 2131689671, 1).show();
        }
        i = 0;
        continue;
        label602:
        i = k;
        if (localbnpf != null)
        {
          j = bnkd.a(this.this$0, localbnpf.a);
          i = j;
          if (j == -1)
          {
            bnkd.a(this.this$0).a(localbnpf);
            i = 1;
          }
        }
      }
      label646:
      Object localObject1 = str2;
      continue;
      label653:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */