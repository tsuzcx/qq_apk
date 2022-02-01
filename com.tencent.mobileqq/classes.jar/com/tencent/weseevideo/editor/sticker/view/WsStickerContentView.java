package com.tencent.weseevideo.editor.sticker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.tavcut.util.Util;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.TAVStickerContentView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import java.util.ArrayList;

public class WsStickerContentView
  extends TAVStickerContentView
  implements IStickerEventListener
{
  public static final float DRAG_ADSORPTION_THRESHOLD = 4.0F * ViewUtils.dip2px(2.0F);
  public static final float ROTATE_ADSORPTION_THRESHOLD = 2.0F;
  public static final float VIBRATE_TIME_INTERVAL = 250.0F;
  private static final long VIBRATOR_DURATION = 50L;
  private final String TAG = WsStickerContentView.class.getSimpleName();
  private float centerX = 0.0F;
  private float centerY = 0.0F;
  private WsStickerEditView curStickerEditView = null;
  private Paint dashLinePaint = new Paint();
  private Path dashPath = new Path();
  private boolean isStickerTouching = false;
  private long lastVibrateTime = 0L;
  private boolean needVibrate = false;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private ArrayList<PointF> points;
  private float rotate = 0.0F;
  private Paint solidLinePaint = new Paint();
  private Path solidPath = new Path();
  private Vibrator vibrator = (Vibrator)TAVStickerHelper.getContext().getSystemService("vibrator");
  
  public WsStickerContentView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public WsStickerContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WsStickerContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean checkVibrateInterval()
  {
    long l = System.currentTimeMillis();
    float f = (float)Math.abs(l - this.lastVibrateTime);
    TLog.d(this.TAG + "1", "time: " + l + "lastTime: " + this.lastVibrateTime);
    this.lastVibrateTime = l;
    return f > 250.0F;
  }
  
  private void drawDashLine(Canvas paramCanvas)
  {
    ArrayList localArrayList = getPoints();
    this.dashPath.reset();
    if (isDrawVerticalDashLine())
    {
      this.needVibrate = true;
      this.dashPath.moveTo(this.centerX, 0.0F);
      this.dashPath.lineTo(this.centerX, getHeight());
    }
    if (isDrawHorizontalDashLine())
    {
      this.needVibrate = true;
      this.dashPath.moveTo(0.0F, this.centerY);
      this.dashPath.lineTo(getWidth(), this.centerY);
    }
    if (isDrawNortheast2SouthwestLine())
    {
      this.needVibrate = true;
      this.dashPath.moveTo(((PointF)localArrayList.get(1)).x, ((PointF)localArrayList.get(1)).y);
      this.dashPath.lineTo(((PointF)localArrayList.get(3)).x, ((PointF)localArrayList.get(3)).y);
    }
    if (isDrawNorthwest2SoutheastLine())
    {
      this.needVibrate = true;
      this.dashPath.moveTo(((PointF)localArrayList.get(0)).x, ((PointF)localArrayList.get(0)).y);
      this.dashPath.lineTo(((PointF)localArrayList.get(2)).x, ((PointF)localArrayList.get(2)).y);
    }
    if (!this.dashPath.isEmpty()) {
      paramCanvas.drawPath(this.dashPath, this.dashLinePaint);
    }
  }
  
  private void drawSolidLine(Canvas paramCanvas)
  {
    this.solidPath.reset();
    if (isDrawVerticalSolidLine())
    {
      this.needVibrate = true;
      this.solidPath.moveTo(this.centerX, 0.0F);
      this.solidPath.lineTo(this.centerX, getHeight());
    }
    if (isDrawHorizontalSolidLine())
    {
      this.needVibrate = true;
      this.solidPath.moveTo(0.0F, this.centerY);
      this.solidPath.lineTo(getWidth(), this.centerY);
    }
    if (!this.solidPath.isEmpty())
    {
      paramCanvas.drawPath(this.solidPath, this.solidLinePaint);
      paramCanvas.drawPath(this.solidPath, this.dashLinePaint);
    }
  }
  
  private ArrayList<PointF> getPoints()
  {
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      int i = Math.min(getWidth(), getHeight());
      ((PointF)this.points.get(0)).set(this.centerX - i, this.centerY - i);
      ((PointF)this.points.get(1)).set(this.centerX + i, this.centerY - i);
      ((PointF)this.points.get(2)).set(this.centerX + i, this.centerY + i);
      PointF localPointF = (PointF)this.points.get(3);
      float f1 = this.centerX;
      float f2 = i;
      float f3 = this.centerY;
      localPointF.set(f1 - f2, i + f3);
    }
    return this.points;
  }
  
  private void init()
  {
    this.points = new ArrayList();
    int i = 0;
    while (i < 4)
    {
      this.points.add(new PointF());
      i += 1;
    }
    this.solidLinePaint.setAntiAlias(true);
    this.solidLinePaint.setColor(-16777216);
    this.solidLinePaint.setAlpha(13);
    this.solidLinePaint.setStrokeWidth(Util.dp2px(getContext(), 1.0F));
    this.solidLinePaint.setStyle(Paint.Style.STROKE);
    this.dashLinePaint.setAntiAlias(true);
    this.dashLinePaint.setColor(-1);
    this.dashLinePaint.setStrokeWidth(Util.dp2px(getContext(), 1.0F));
    this.dashLinePaint.setStyle(Paint.Style.STROKE);
    float f = Util.dp2px(getContext(), 2.0F);
    this.dashLinePaint.setPathEffect(new DashPathEffect(new float[] { f, f }, 0.0F));
    setWillNotDraw(false);
  }
  
  private boolean isDrawHorizontalDashLine()
  {
    return (Math.abs(this.rotate - 0.0F) < 2.0F) || (Math.abs(this.rotate - 180.0F) < 2.0F);
  }
  
  private boolean isDrawHorizontalSolidLine()
  {
    return Math.abs(getHeight() / 2.0F - this.centerY) < DRAG_ADSORPTION_THRESHOLD;
  }
  
  private boolean isDrawNortheast2SouthwestLine()
  {
    return (Math.abs(this.rotate - 315.0F) < 2.0F) || (Math.abs(this.rotate - 135.0F) < 2.0F);
  }
  
  private boolean isDrawNorthwest2SoutheastLine()
  {
    return (Math.abs(this.rotate - 45.0F) < 2.0F) || (Math.abs(this.rotate - 225.0F) < 2.0F);
  }
  
  private boolean isDrawVerticalDashLine()
  {
    return (Math.abs(this.rotate - 90.0F) < 2.0F) || (Math.abs(this.rotate - 270.0F) < 2.0F);
  }
  
  private boolean isDrawVerticalSolidLine()
  {
    return Math.abs(getWidth() / 2.0F - this.centerX) < DRAG_ADSORPTION_THRESHOLD;
  }
  
  private void startVibrator()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(50L, -1);
        this.vibrator.vibrate(localVibrationEffect);
        return;
      }
      this.vibrator.vibrate(50L);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    if ((paramView instanceof WsStickerEditView)) {}
    for (paramView = (WsStickerEditView)paramView;; paramView = null)
    {
      this.curStickerEditView = paramView;
      return;
    }
  }
  
  public WsStickerEditView getStickerEditView()
  {
    return this.curStickerEditView;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    StickerEventDispatcher.getInstance().addStickerEventListener(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    StickerEventDispatcher.getInstance().removeStickerEventListener(this);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.isStickerTouching) && (paramCanvas != null))
    {
      this.needVibrate = false;
      if ((this.curStickerEditView != null) && (this.curStickerEditView.isDrawGuideLine()))
      {
        if (TAVStickerOperationMode.OP_DRAG != this.operationMode) {
          break label82;
        }
        drawSolidLine(paramCanvas);
      }
    }
    for (;;)
    {
      if ((this.needVibrate) && (checkVibrateInterval()))
      {
        TLog.d(this.TAG, "startVibrator");
        startVibrator();
      }
      return;
      label82:
      if (TAVStickerOperationMode.OP_NONE != this.operationMode) {
        drawDashLine(paramCanvas);
      }
    }
  }
  
  public void onStickerDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.operationMode = paramTAVStickerOperationMode;
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.rotate = paramFloat4;
    TLog.d(this.TAG, "onStickerDataChanged -> sticker : $sticker, centerX : $centerX, centerY : $centerY, scale : $scale, rotate : $rotate , operationMode" + paramTAVStickerOperationMode.name());
  }
  
  public void onStickerStatusChanged(TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isStickerTouching = paramBoolean1;
    if (!this.isStickerTouching) {
      this.operationMode = TAVStickerOperationMode.OP_NONE;
    }
    TLog.d(this.TAG, "onStickerStatusChanged -> sticker : $sticker, isTouching :" + paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerContentView
 * JD-Core Version:    0.7.0.1
 */