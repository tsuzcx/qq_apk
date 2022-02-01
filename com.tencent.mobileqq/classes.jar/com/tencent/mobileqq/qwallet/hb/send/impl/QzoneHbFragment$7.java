package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

class QzoneHbFragment$7
  implements Runnable
{
  QzoneHbFragment$7(QzoneHbFragment paramQzoneHbFragment, String paramString) {}
  
  public void run()
  {
    Object localObject1 = ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).getConfigCache();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject(new String(Base64.decode(((String)localObject1).toString(), 0)));
        this.this$0.a((JSONObject)localObject1);
        return;
      }
      catch (Exception localException1)
      {
        ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).setConfigCache("");
        localException1.printStackTrace();
      }
    }
    Object localObject2 = new File(this.a);
    if (((File)localObject2).exists())
    {
      try
      {
        Object localObject3 = new byte[1024];
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new FileInputStream((File)localObject2);
        try
        {
          for (;;)
          {
            int i = ((FileInputStream)localObject2).read((byte[])localObject3);
            if (i <= 0) {
              break;
            }
            localStringBuilder.append(new String((byte[])localObject3, 0, i));
          }
          ((FileInputStream)localObject2).close();
          localObject3 = new JSONObject(new String(Base64.decode(localStringBuilder.toString(), 0)));
          ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).setConfigCache(localStringBuilder.toString());
          this.this$0.a((JSONObject)localObject3);
          return;
        }
        catch (Exception localException2) {}
        if (localObject2 == null) {
          break label224;
        }
      }
      catch (Exception localException3)
      {
        localObject2 = null;
      }
      try
      {
        ((FileInputStream)localObject2).close();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
      label224:
      localException3.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.7
 * JD-Core Version:    0.7.0.1
 */