package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSViewDecorationUtil;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSBoringView
  extends FrameLayout
  implements IView
{
  private static final String TAG = "PTSBoringView";
  private Paint borderPaint;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  private String nodeKey;
  private TextView textView;
  
  public PTSBoringView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  private void bindData()
  {
    if (!PTSLog.isDebug())
    {
      PTSLog.i("PTSBoringView", "[bindData] is not debug version.");
      return;
    }
    Object localObject = this.textView;
    if (localObject != null) {
      ((TextView)localObject).setText("custom view");
    }
    setBackgroundColor(-1294411560);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bindData], nodeKey = ");
    ((StringBuilder)localObject).append(this.nodeKey);
    PTSLog.i("PTSBoringView", ((StringBuilder)localObject).toString());
  }
  
  private void drawDashBorder(Canvas paramCanvas)
  {
    if (!PTSLog.isDebug())
    {
      PTSLog.i("PTSBoringView", "[drawDashBorder] is not debug version.");
      return;
    }
    float f = PTSDeviceUtil.dp2px(3.0F);
    if (this.borderPaint == null)
    {
      this.borderPaint = new Paint(1);
      this.borderPaint.setStyle(Paint.Style.STROKE);
      this.borderPaint.setColor(-16465569);
      this.borderPaint.setStrokeWidth(f);
      this.borderPaint.setPathEffect(new DashPathEffect(new float[] { 15.0F, 15.0F }, 0.0F));
    }
    setLayerType(1, null);
    PTSViewDecorationUtil.drawBorderImp(paramCanvas, this.borderPaint, getWidth(), getHeight(), f, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void initUI()
  {
    if (!PTSLog.isDebug())
    {
      PTSLog.i("PTSBoringView", "[initUI] is not debug version, do not show text.");
      return;
    }
    this.textView = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i = PTSDeviceUtil.dp2pxInt(3.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    addView(this.textView, localLayoutParams);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
    this.mRoundedCorner.drawBorder(paramCanvas);
    drawDashBorder(paramCanvas);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
    bindData();
  }
  
  public void setNodeKey(String paramString)
  {
    this.nodeKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSBoringView
 * JD-Core Version:    0.7.0.1
 */