package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyProgressView
  extends NativeText
{
  Paint a = new Paint();
  RectF b = new RectF();
  RectF c = new RectF();
  private int d = 0;
  private String e;
  private String f;
  
  public ReadInjoyProgressView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new ReadInjoyProgressView.1(this, paramVafContext.getContext());
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBackgroundColor(0);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1178) {
      return false;
    }
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      try
      {
        this.d = paramObject.getInt("progress");
        this.e = paramObject.getString("bgcolor");
        this.f = paramObject.getString("fgcolor");
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyProgressView
 * JD-Core Version:    0.7.0.1
 */