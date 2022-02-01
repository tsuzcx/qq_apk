package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import org.json.JSONObject;

final class h
  implements Runnable
{
  h(MiniAppCamera paramMiniAppCamera, String paramString, WebviewContainer paramWebviewContainer, int paramInt) {}
  
  public void run()
  {
    if (MiniAppCamera.f())
    {
      try
      {
        String str = b.a().a("jpg");
        localObject = new File(str);
        ((File)localObject).getParentFile().mkdirs();
        Bitmap localBitmap = MiniAppCamera.b(MiniAppCamera.g());
        if (localBitmap == null)
        {
          MiniAppCamera.a(this.d, this.a, this.b, this.c);
          return;
        }
        MiniAppCamera.a(localBitmap, (File)localObject, "");
        if (StringUtil.a(MiniAppCamera.g()))
        {
          MiniAppCamera.a(this.d, this.a, this.b, this.c);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        MiniAppCamera.a(this.d, this.a, this.b, this.c);
        return;
      }
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("tempThumbPath", b.a().b(localException));
      ((JSONObject)localObject).put("tempVideoPath", b.a().b(MiniAppCamera.g()));
      this.b.appBrandRuntime.i.evaluateCallbackJs(this.c, ((JSONObject)localObject).toString());
      MiniAppCamera.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.h
 * JD-Core Version:    0.7.0.1
 */