package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawClassifier
{
  private static volatile DrawClassifier b;
  private static boolean k = false;
  public float a = 0.2F;
  private LiteClassifier c;
  private boolean d = false;
  private String e;
  private String f = "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip";
  private int g = 5;
  private float h = 1.75F;
  private String i = "https://i.gtimg.cn/drawrp/aModel_";
  private String j;
  
  public static DrawClassifier a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new DrawClassifier();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.messageType == 26))
    {
      if (k) {
        return;
      }
      ThreadManager.executeOnFileThread(new DrawClassifier.1(paramMessageForQQWalletMsg));
    }
  }
  
  private void a(String paramString1, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init modelUrl=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.i("DrawClassifier", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = QWalletTools.b();
    if (localObject == null)
    {
      paramOnClassifierInitListener.a(false);
      return;
    }
    if ((IPreloadService)((BaseQQAppInterface)localObject).getRuntimeService(IPreloadService.class, "") == null)
    {
      paramOnClassifierInitListener.a(false);
      return;
    }
    localObject = new DownloadParam();
    ((DownloadParam)localObject).filePos = 1;
    ((DownloadParam)localObject).url = paramString1;
    ((DownloadParam)localObject).md5 = paramString2;
    ((DownloadParam)localObject).useQWalletConfig = true;
    PreloadStaticApi.a().getResPath((DownloadParam)localObject, new DrawClassifier.3(this, paramOnClassifierInitListener));
  }
  
  private static JSONObject b(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray("modelList");
    if (paramJSONObject != null)
    {
      int m = 0;
      while (m < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(m);
        if ((localJSONObject != null) && (TextUtils.equals(localJSONObject.optString("id"), paramString))) {
          return localJSONObject;
        }
        m += 1;
      }
    }
    return null;
  }
  
  private void b(DoodleItem paramDoodleItem, DrawClassifier.OnRecogListener paramOnRecogListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "recognize called");
    }
    if ((!this.d) || (paramDoodleItem == null))
    {
      if (paramOnRecogListener != null) {
        paramOnRecogListener.a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "recognize has not init");
      }
    }
    ThreadManager.excute(new DrawClassifier.4(this, paramOnRecogListener, paramDoodleItem), 16, null, true);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.e = paramString2;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("init recogtitle:");
        paramContext.append(this.e);
        paramContext.append(",mIsInit");
        paramContext.append(this.d);
        paramContext.append(",modelId:");
        paramContext.append(paramString1);
        QLog.d("DrawClassifier", 2, paramContext.toString());
      }
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          this.h = 1.0F;
        } else {
          this.h = 1.75F;
        }
        paramContext = RedPacketManagerImpl.getHbPannelConfig(10);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("init configObj:");
          paramString2.append(paramContext);
          QLog.d("DrawClassifier", 2, paramString2.toString());
        }
        if (paramContext != null) {
          if (!TextUtils.isEmpty(paramString1))
          {
            this.i = paramContext.optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
            paramContext = b(paramContext, paramString1);
            if (paramContext != null)
            {
              this.a = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
              this.g = paramContext.optInt("topN", 5);
              this.h = ((float)paramContext.optDouble("lineWidth", 1.0D));
              this.j = paramContext.optString("aMd5");
            }
            if (this.h <= 0.0F) {
              this.h = 1.0F;
            }
          }
          else
          {
            this.f = paramContext.optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
            this.a = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
            this.g = paramContext.optInt("topN", 5);
          }
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          if (TextUtils.isEmpty(this.i.trim())) {
            this.i = "https://i.gtimg.cn/drawrp/aModel_";
          }
          paramContext = new StringBuilder();
          paramContext.append(this.i);
          paramContext.append(paramString1);
          paramContext.append(".zip");
          this.f = paramContext.toString();
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("init modelUrl=");
        paramContext.append(this.f);
        paramContext.append(",threshold=");
        paramContext.append(this.a);
        paramContext.append(",topN=");
        paramContext.append(this.g);
        paramContext.append(",lineWidth=");
        paramContext.append(this.h);
        QLog.d("DrawClassifier", 2, paramContext.toString());
      }
      if (this.d)
      {
        if (paramOnClassifierInitListener != null) {
          paramOnClassifierInitListener.a(true);
        }
        return;
      }
      TensorFlowlibManager.a().a(new DrawClassifier.2(this, paramOnClassifierInitListener));
      return;
    }
    finally {}
  }
  
  public void a(DoodleItem paramDoodleItem, DrawClassifier.OnRecogListener paramOnRecogListener)
  {
    b(paramDoodleItem, paramOnRecogListener);
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close - mIsInit");
        localStringBuilder.append(this.d);
        QLog.d("DrawClassifier", 2, localStringBuilder.toString());
      }
      boolean bool = this.d;
      if (!bool) {
        return;
      }
      this.d = false;
      if (this.c != null) {
        this.c.b();
      }
      return;
    }
    finally {}
  }
  
  public String c()
  {
    LiteClassifier localLiteClassifier = this.c;
    if (localLiteClassifier == null) {
      return null;
    }
    return localLiteClassifier.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier
 * JD-Core Version:    0.7.0.1
 */