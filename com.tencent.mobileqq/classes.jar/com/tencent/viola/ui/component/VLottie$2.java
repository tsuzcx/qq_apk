package com.tencent.viola.ui.component;

import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import org.json.JSONObject;

class VLottie$2
  implements VLottie.IVLottieLoadListener
{
  VLottie$2(VLottie paramVLottie) {}
  
  public void onResult(boolean paramBoolean)
  {
    try
    {
      if ((this.this$0.mDomObj != null) && (ViolaUtils.getBoolean(this.this$0.mDomObj.getAttributes().get("isAutoPlay")))) {
        this.this$0.play();
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("success", paramBoolean);
      this.this$0.fireEvent("loadFinish", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VComponent", "lottie v_setAnimation message:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VLottie.2
 * JD-Core Version:    0.7.0.1
 */