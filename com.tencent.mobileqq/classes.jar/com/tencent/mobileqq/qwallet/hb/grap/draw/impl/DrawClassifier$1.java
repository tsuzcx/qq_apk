package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class DrawClassifier$1
  implements Runnable
{
  DrawClassifier$1(MessageForQQWalletMsg paramMessageForQQWalletMsg) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "tryPreDownLoadModel");
        }
        String str3 = this.a.mQQWalletRedPacketMsg.body.feedId;
        Object localObject1 = RedPacketManagerImpl.getHbPannelConfig(10);
        String str2 = "https://i.gtimg.cn/drawrp/aModel_";
        localObject3 = "";
        if (localObject1 == null) {
          break label217;
        }
        if (!TextUtils.isEmpty(str3))
        {
          localObject3 = ((JSONObject)localObject1).optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
          localObject1 = DrawClassifier.a((JSONObject)localObject1, str3);
          if (localObject1 != null)
          {
            str1 = ((JSONObject)localObject1).optString("aMd5");
            break label211;
          }
        }
        else
        {
          localObject1 = ((JSONObject)localObject1).optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
          str1 = "";
          if (!TextUtils.isEmpty(str3))
          {
            if (!TextUtils.isEmpty(((String)localObject3).trim())) {
              break label225;
            }
            localObject1 = str2;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(str3);
            ((StringBuilder)localObject3).append(".zip");
            localObject1 = ((StringBuilder)localObject3).toString();
          }
          localObject3 = new DownloadParam();
          ((DownloadParam)localObject3).filePos = 1;
          ((DownloadParam)localObject3).url = ((String)localObject1);
          ((DownloadParam)localObject3).md5 = str1;
          ((DownloadParam)localObject3).useQWalletConfig = true;
          PreloadStaticApi.a().getResPath((DownloadParam)localObject3, new DrawClassifier.1.1(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      String str1 = "";
      label211:
      Object localObject2 = "";
      continue;
      label217:
      str1 = "";
      localObject2 = str1;
      continue;
      label225:
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier.1
 * JD-Core Version:    0.7.0.1
 */