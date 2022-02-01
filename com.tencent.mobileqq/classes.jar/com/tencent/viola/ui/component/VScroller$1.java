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
    if (this.this$0.mAppendEvents.contains("loadMore"))
    {
      paramVScrollView = this.this$0;
      VScroller.access$100(paramVScrollView, "loadMore", paramVScrollView.getDomObject());
    }
  }
  
  public void onScroll(VScrollView paramVScrollView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(VScrollView paramVScrollView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.this$0.mAppendEvents.contains("loadMore")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = new JSONObject();
    Object localObject2 = new JSONObject();
    Object localObject1 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(this.this$0.getContentWidth()));
      localStringBuilder.append("dp");
      ((JSONObject)localObject3).put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(this.this$0.getContentHeight()));
      localStringBuilder.append("dp");
      ((JSONObject)localObject3).put("height", localStringBuilder.toString());
      localJSONObject.put("contentSize", localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(FlexConvertUtils.px2dip(paramFloat3));
      ((StringBuilder)localObject3).append("dp");
      ((JSONObject)localObject2).put("x", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(FlexConvertUtils.px2dip(paramFloat4));
      ((StringBuilder)localObject3).append("dp");
      ((JSONObject)localObject2).put("y", ((StringBuilder)localObject3).toString());
      localJSONObject.put("contentOffset", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramFloat1));
      ((StringBuilder)localObject2).append("dp");
      ((JSONObject)localObject1).put("x", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramFloat2));
      ((StringBuilder)localObject2).append("dp");
      ((JSONObject)localObject1).put("y", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramVScrollView.getWidth()));
      ((StringBuilder)localObject2).append("dp");
      ((JSONObject)localObject1).put("width", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramVScrollView.getHeight()));
      ((StringBuilder)localObject2).append("dp");
      ((JSONObject)localObject1).put("height", ((StringBuilder)localObject2).toString());
      localJSONObject.put("frame", localObject1);
    }
    catch (JSONException paramVScrollView)
    {
      paramVScrollView.printStackTrace();
    }
    paramVScrollView = new JSONArray();
    if (this.this$0.getDomObject() != null)
    {
      localObject1 = this.this$0.getDomObject().getRef();
      if (localObject1 != null) {
        paramVScrollView.put(localObject1);
      }
    }
    paramVScrollView.put("scrollEnd");
    VScroller.access$000(this.this$0, "scrollEnd", paramVScrollView, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VScroller.1
 * JD-Core Version:    0.7.0.1
 */