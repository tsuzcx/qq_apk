package com.tencent.viola.ui.component;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VPageSliderView;
import com.tencent.viola.ui.view.VSliderView.VSliderListener;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class VPageSlider$1
  implements VSliderView.VSliderListener
{
  VPageSlider$1(VPageSlider paramVPageSlider) {}
  
  public void change(int paramInt)
  {
    this.this$0.mDomObj.saveState("index", Integer.valueOf(paramInt));
    if (!this.this$0.mAppendEvents.contains("change")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    String str;
    try
    {
      localJSONObject.put("index", paramInt);
    }
    catch (Exception localException)
    {
      str = VPageSlider.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change error :");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
    }
    JSONArray localJSONArray = new JSONArray();
    if (((VPageSliderView)this.this$0.getHostView()).getComponent().getDomObject() != null)
    {
      str = ((VPageSliderView)this.this$0.getHostView()).getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put("change");
    VPageSlider.access$000(this.this$0, "change", localJSONArray, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPageSlider.1
 * JD-Core Version:    0.7.0.1
 */