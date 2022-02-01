package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VVideoView$1
  implements View.OnLayoutChangeListener
{
  VVideoView$1(VVideoView paramVVideoView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((VVideoView.a(this.a)) && (this.a.getComponent() != null) && (paramView != null) && (paramView.getWidth() >= paramView.getHeight()))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("left", paramInt1);
        localJSONObject.put("top", paramInt2);
        localJSONObject.put("right", paramInt3);
        localJSONObject.put("bottom", paramInt4);
        localJSONObject.put("width", paramView.getWidth());
        localJSONObject.put("height", paramView.getHeight());
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
      this.a.a("onFullScreenSizeChange", localJSONObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("test video onLayoutChange left:");
        paramView.append(paramInt1);
        paramView.append(",top:");
        paramView.append(paramInt2);
        paramView.append(",right:");
        paramView.append(paramInt3);
        paramView.append(",bottom:");
        paramView.append(paramInt4);
        paramView.append(",oldLeft:");
        paramView.append(paramInt5);
        paramView.append(",oldTop:");
        paramView.append(paramInt6);
        paramView.append(",oldRight:");
        paramView.append(paramInt7);
        paramView.append(",oldBottom:");
        paramView.append(paramInt8);
        QLog.d("VVideoView", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView.1
 * JD-Core Version:    0.7.0.1
 */