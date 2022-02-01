package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class KdLottieView$2
  implements IHttpAdapter.OnHttpListener
{
  KdLottieView$2(KdLottieView paramKdLottieView, String paramString, VLottie.IVLottieLoadListener paramIVLottieLoadListener) {}
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    int i = Integer.parseInt(paramHttpResponse.statusCode);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 200) {
      bool1 = bool2;
    }
    try
    {
      if (paramHttpResponse.originalData != null)
      {
        paramHttpResponse = new JSONObject(new String(paramHttpResponse.originalData, "utf-8"));
        bool1 = true;
        LottieComposition.Factory.fromJson(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaLottieKdLottieView.getContext().getResources(), paramHttpResponse, new KdLottieView.2.1(this));
      }
      this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener.onResult(bool1);
      return;
    }
    catch (Exception paramHttpResponse) {}
  }
  
  public void onHttpStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.2
 * JD-Core Version:    0.7.0.1
 */