package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class KdLottieView$1
  implements Runnable
{
  KdLottieView$1(KdLottieView paramKdLottieView, String paramString, VLottie.IVLottieLoadListener paramIVLottieLoadListener) {}
  
  public void run()
  {
    Object localObject = ViolaResLoader.a.a().a(this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        localObject = ViolaUtils.readFile((File)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            KdLottieView.a(this.this$0, new JSONObject((String)localObject), this.a);
            if (this.b == null) {
              return;
            }
            this.b.onResult(true);
            return;
          }
          catch (JSONException localJSONException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("load lottie from local error: ");
            localStringBuilder.append(localJSONException.getMessage());
            QLog.e("KdLottieView", 1, localStringBuilder.toString());
            return;
          }
        } else {
          this.this$0.a(this.a, this.b);
        }
      }
      else
      {
        this.this$0.a(this.a, this.b);
      }
    }
    else
    {
      this.this$0.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.1
 * JD-Core Version:    0.7.0.1
 */