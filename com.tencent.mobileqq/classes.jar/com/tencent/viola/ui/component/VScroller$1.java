package com.tencent.viola.ui.component;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VScrollView;
import com.tencent.viola.ui.view.VScrollView.VScrollViewListener;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VScroller$1
  implements VScrollView.VScrollViewListener
{
  VScroller$1(VScroller paramVScroller) {}
  
  public void onLoadMore(VScrollView paramVScrollView, int paramInt1, int paramInt2)
  {
    if (this.this$0.mAppendEvents.contains("loadMore")) {
      VScroller.access$100(this.this$0, "loadMore", this.this$0.getDomObject());
    }
  }
  
  public void onScroll(VScrollView paramVScrollView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(VScrollView paramVScrollView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.this$0.mAppendEvents.contains("loadMore")) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("width", FlexConvertUtils.px2dip(this.this$0.getContentWidth()) + "dp");
      ((JSONObject)localObject).put("height", FlexConvertUtils.px2dip(this.this$0.getContentHeight()) + "dp");
      localJSONObject1.put("contentSize", localObject);
      localJSONObject2.put("x", FlexConvertUtils.px2dip(paramFloat3) + "dp");
      localJSONObject2.put("y", FlexConvertUtils.px2dip(paramFloat4) + "dp");
      localJSONObject1.put("contentOffset", localJSONObject2);
      localJSONObject3.put("x", FlexConvertUtils.px2dip(paramFloat1) + "dp");
      localJSONObject3.put("y", FlexConvertUtils.px2dip(paramFloat2) + "dp");
      localJSONObject3.put("width", FlexConvertUtils.px2dip(paramVScrollView.getWidth()) + "dp");
      localJSONObject3.put("height", FlexConvertUtils.px2dip(paramVScrollView.getHeight()) + "dp");
      localJSONObject1.put("frame", localJSONObject3);
      paramVScrollView = new JSONArray();
      if (this.this$0.getDomObject() != null)
      {
        localObject = this.this$0.getDomObject().getRef();
        if (localObject != null) {
          paramVScrollView.put(localObject);
        }
      }
      paramVScrollView.put("scrollEnd");
      VScroller.access$000(this.this$0, "scrollEnd", paramVScrollView, localJSONObject1);
      return;
    }
    catch (JSONException paramVScrollView)
    {
      for (;;)
      {
        paramVScrollView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VScroller.1
 * JD-Core Version:    0.7.0.1
 */