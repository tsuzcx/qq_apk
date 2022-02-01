package com.tencent.mobileqq.kandian.biz.hippy.tuwen.app;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageView;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.hippy.qq.view.tkd.text.HippyTKDTextView;
import com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroup;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.ReflectWrapper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import java.util.Map;

public class TuWenHippyViewCreator
  implements HippyCustomViewCreator
{
  private ReflectWrapper reflectWrapper;
  private final Map<String, Class<? extends View>> viewMap = new ArrayMap();
  
  public TuWenHippyViewCreator()
  {
    this.viewMap.put("ListView", NSHippyListView.class);
    this.viewMap.put("Text", HippyTKDTextView.class);
    this.viewMap.put("View", HippyTKDViewGroup.class);
    this.viewMap.put("Image", HippyTKDImageView.class);
    this.viewMap.put("TKDGifImageView", HippyTKDGifImageView.class);
  }
  
  public View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap)
  {
    paramString = (Class)this.viewMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    if (this.reflectWrapper == null) {
      this.reflectWrapper = new ReflectWrapper();
    }
    return (View)this.reflectWrapper.newInstance(paramString, new Class[] { Context.class }, new Object[] { paramContext });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TuWenHippyViewCreator
 * JD-Core Version:    0.7.0.1
 */