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
  private static volatile DrawClassifier jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier;
  private static boolean jdField_b_of_type_Boolean = false;
  public float a;
  private int jdField_a_of_type_Int = 5;
  private LiteClassifier jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLiteClassifier;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 1.75F;
  private String jdField_b_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip";
  private String c = "https://i.gtimg.cn/drawrp/aModel_";
  private String d;
  
  private DrawClassifier()
  {
    this.jdField_a_of_type_Float = 0.2F;
  }
  
  public static DrawClassifier a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier = new DrawClassifier();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier;
  }
  
  public static void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.messageType == 26))
    {
      if (jdField_b_of_type_Boolean) {
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
    Object localObject = QWalletTools.a();
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
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if ((localJSONObject != null) && (TextUtils.equals(localJSONObject.optString("id"), paramString))) {
          return localJSONObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void b(DoodleItem paramDoodleItem, DrawClassifier.OnRecogListener paramOnRecogListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "recognize called");
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramDoodleItem == null))
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
  
  public String a()
  {
    LiteClassifier localLiteClassifier = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLiteClassifier;
    if (localLiteClassifier == null) {
      return null;
    }
    return localLiteClassifier.a();
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close - mIsInit");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("DrawClassifier", 2, localStringBuilder.toString());
      }
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLiteClassifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLiteClassifier.a();
      }
      return;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_JavaLangString = paramString2;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("init recogtitle:");
        paramContext.append(this.jdField_a_of_type_JavaLangString);
        paramContext.append(",mIsInit");
        paramContext.append(this.jdField_a_of_type_Boolean);
        paramContext.append(",modelId:");
        paramContext.append(paramString1);
        QLog.d("DrawClassifier", 2, paramContext.toString());
      }
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          this.jdField_b_of_type_Float = 1.0F;
        } else {
          this.jdField_b_of_type_Float = 1.75F;
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
            this.c = paramContext.optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
            paramContext = b(paramContext, paramString1);
            if (paramContext != null)
            {
              this.jdField_a_of_type_Float = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
              this.jdField_a_of_type_Int = paramContext.optInt("topN", 5);
              this.jdField_b_of_type_Float = ((float)paramContext.optDouble("lineWidth", 1.0D));
              this.d = paramContext.optString("aMd5");
            }
            if (this.jdField_b_of_type_Float <= 0.0F) {
              this.jdField_b_of_type_Float = 1.0F;
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = paramContext.optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
            this.jdField_a_of_type_Float = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
            this.jdField_a_of_type_Int = paramContext.optInt("topN", 5);
          }
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          if (TextUtils.isEmpty(this.c.trim())) {
            this.c = "https://i.gtimg.cn/drawrp/aModel_";
          }
          paramContext = new StringBuilder();
          paramContext.append(this.c);
          paramContext.append(paramString1);
          paramContext.append(".zip");
          this.jdField_b_of_type_JavaLangString = paramContext.toString();
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
        paramContext.append(this.jdField_b_of_type_JavaLangString);
        paramContext.append(",threshold=");
        paramContext.append(this.jdField_a_of_type_Float);
        paramContext.append(",topN=");
        paramContext.append(this.jdField_a_of_type_Int);
        paramContext.append(",lineWidth=");
        paramContext.append(this.jdField_b_of_type_Float);
        QLog.d("DrawClassifier", 2, paramContext.toString());
      }
      if (this.jdField_a_of_type_Boolean)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier
 * JD-Core Version:    0.7.0.1
 */