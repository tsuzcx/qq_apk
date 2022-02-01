package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private Sprite a;
  private Sprite b;
  private ImageButton c;
  private ImageButton d;
  private Label e;
  private float f;
  private TroopGiftToAllSurfaceView.Options g;
  private int h;
  private String i;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.c != null)
    {
      OpacityAction localOpacityAction = new OpacityAction(500, 255, 0);
      localOpacityAction.a(new TroopGiftToAllSurfaceView.4(this));
      this.c.a(new Action[] { localOpacityAction });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    if ((!paramOptions.f) && (paramBitmap1 != null))
    {
      Bitmap localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(paramOptions.i);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      float f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - paramBitmap2.getWidth() * f1) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(paramOptions.k)) && (!TextUtils.isEmpty(paramOptions.j)))
      {
        float f2 = localPaint.measureText(paramOptions.k);
        paramBitmap2 = paramOptions.k;
        int j = 0;
        f1 = 0.0F;
        int k = 0;
        while (j < paramOptions.j.length())
        {
          paramBitmap1 = new StringBuilder();
          paramBitmap1.append("");
          paramBitmap1.append(paramOptions.j.charAt(j));
          f1 += localPaint.measureText(paramBitmap1.toString());
          if (f1 + f2 > 475.0F) {
            break;
          }
          k += 1;
          j += 1;
        }
        paramBitmap1 = paramBitmap2;
        if (k > 0) {
          if (k == paramOptions.j.length())
          {
            paramBitmap1 = new StringBuilder();
            paramBitmap1.append(paramOptions.j);
            paramBitmap1.append(paramBitmap2);
            paramBitmap1 = paramBitmap1.toString();
          }
          else
          {
            paramBitmap1 = new StringBuilder();
            paramBitmap1.append(paramOptions.j.substring(0, k));
            paramBitmap1.append("...");
            paramBitmap1.append(paramBitmap2);
            paramBitmap1 = paramBitmap1.toString();
          }
        }
        f1 = localPaint.measureText(paramBitmap1);
        localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      }
      this.a = new Sprite(this, localBitmap);
      this.a.d = (this.g.a / 2);
      paramBitmap1 = this.a;
      paramBitmap1.e = this.h;
      paramBitmap1.f = 0.0F;
      a(paramBitmap1);
    }
    if (paramBitmap3 != null)
    {
      this.c = new ImageButton(this, paramBitmap3, false);
      this.c.a(this.g.a / 2, this.g.b * this.g.h / 100);
    }
    try
    {
      this.d = new ImageButton(this, BitmapFactory.decodeResource(getResources(), 2130849066), true);
      this.d.a(paramOptions.a - DisplayUtils.a(getContext(), 40.0F), DisplayUtils.a(getContext(), 120.0F));
      this.d.a(paramOnClickListener);
      this.d.f = 0.75F;
      a(this.d);
      return;
    }
    catch (OutOfMemoryError paramBitmap1)
    {
      label572:
      break label572;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    this.g = paramOptions;
    this.h = (paramOptions.b * paramOptions.d / 100);
    this.f = (getResources().getDisplayMetrics().density / 2.0F);
    this.i = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.s = true;
    paramString.d = (this.g.a / 2);
    paramString.e = (this.g.b / 2);
    this.b = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramOnClickListener, paramOptions);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    this.g = paramOptions;
    this.h = (paramOptions.b * paramOptions.d / 100);
    this.f = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new FrameSprite(this, paramArrayOfString);
    this.b = paramArrayOfString;
    this.b.d = (this.g.a / 2);
    this.b.e = (this.g.b / 2);
    this.b.f = paramOptions.c;
    paramArrayOfString.e(paramOptions.l);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramOnClickListener, paramOptions);
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((Sprite)localObject).a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    localObject = new OpacityAction(500, 255, 0, 1);
    ((Action)localObject).a(paramOnActionEndListener);
    paramOnActionEndListener = this.a;
    if (paramOnActionEndListener != null) {
      paramOnActionEndListener.a(new Action[] { localObject });
    }
    paramOnActionEndListener = this.c;
    if (paramOnActionEndListener != null)
    {
      paramOnActionEndListener.a(null);
      this.c.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    paramOnActionEndListener = this.e;
    if (paramOnActionEndListener != null) {
      paramOnActionEndListener.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    paramOnActionEndListener = this.d;
    if (paramOnActionEndListener != null) {
      paramOnActionEndListener.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (this.a != null)
    {
      localObject = new ScaleAction(500, 0.0F, this.f * 1.1F);
      float f1 = this.f;
      ScaleAction localScaleAction1 = new ScaleAction(200, 1.1F * f1, f1 * 0.95F);
      f1 = this.f;
      ScaleAction localScaleAction2 = new ScaleAction(200, 0.95F * f1, f1 * 1.05F);
      f1 = this.f;
      localObject = new SequenceAction(new Action[] { localObject, localScaleAction1, localScaleAction2, new ScaleAction(200, 1.05F * f1, f1 * 1.0F) });
      this.a.a(new Action[] { localObject });
    }
    Object localObject = this.b;
    if ((localObject != null) && ((localObject instanceof FrameSprite)))
    {
      ((FrameSprite)localObject).u = new TroopGiftToAllSurfaceView.1(this, paramOnFrameEndListener);
      ((FrameSprite)this.b).a(getContext(), this);
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && ((localObject instanceof VideoSprite))) {
        ((VideoSprite)localObject).a(paramOnFrameEndListener);
      }
    }
    paramOnFrameEndListener = new DelayAction(500);
    paramOnFrameEndListener.a(new TroopGiftToAllSurfaceView.2(this));
    localObject = this.a;
    if (localObject != null) {
      ((Sprite)localObject).a(new Action[] { paramOnFrameEndListener });
    }
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ImageButton)localObject).a(paramOnClickListener);
      paramOnClickListener = this.c;
      paramOnClickListener.f = 0.0F;
      a(paramOnClickListener);
      paramOnClickListener = new ScaleAction(500, 0.0F, this.f * 1.1F);
      float f1 = this.f;
      localObject = new ScaleAction(200, 1.1F * f1, f1 * 0.88F);
      f1 = this.f;
      paramOnClickListener = new SequenceAction(new Action[] { paramOnClickListener, localObject, new ScaleAction(200, 0.88F * f1, f1) });
      paramOnClickListener.a(new TroopGiftToAllSurfaceView.3(this));
      this.c.a(new Action[] { paramOnClickListener });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(new TroopGiftToAllSurfaceView.5(this, paramString, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */