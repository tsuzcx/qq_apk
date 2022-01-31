package com.tencent.mobileqq.troopgift;

import ajvr;
import ajvt;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.FlowerAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.util.DisplayUtil;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Sprite[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
  protected int b;
  private Sprite b;
  private Sprite c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = DisplayUtil.a(getContext(), 4.0F);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      Object localObject = new Canvas(localBitmap2);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawCircle(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, paramBitmap.getWidth() / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap = new Paint();
      paramBitmap.setColor(-1);
      paramBitmap.setAntiAlias(true);
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localObject = new Matrix();
      ((Matrix)localObject).postScale((paramInt1 - i) / localBitmap2.getWidth(), (paramInt2 - i) / localBitmap2.getHeight());
      ((Matrix)localObject).postTranslate(i / 2, i / 2);
      localCanvas.drawBitmap(localBitmap2, (Matrix)localObject, paramBitmap);
      paramBitmap = new Paint();
      paramBitmap.setColor(-16777216);
      paramBitmap.setAlpha(43);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setAntiAlias(true);
      paramBitmap.setStrokeWidth(DisplayUtil.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, Action.OnActionEndListener paramOnActionEndListener)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), new ScaleAction(200, 1.05F, 0.0F) }), new SequenceAction(new Action[] { new DelayAction(paramInt), new MoveToAction(200, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - j / 2, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d), new MoveToAction(200, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c + j / 2 + i, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d) }) });
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a() == null)
    {
      if (paramOnActionEndListener != null) {
        paramOnActionEndListener.a();
      }
      return;
    }
    ScaleAction localScaleAction = new ScaleAction(200, 1.05F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), localScaleAction }), new SequenceAction(new Action[] { new MoveToAction(200, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c + j / 2, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d), new MoveToAction(200, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - j / 2 - i, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d) }) });
    localScaleAction.a(paramOnActionEndListener);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    int i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c();
    int j = i / 10;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(200), new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c);
    SequenceAction localSequenceAction1 = new SequenceAction(new Action[] { new DelayAction(500), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[0].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[0].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f) });
    SequenceAction localSequenceAction2 = new SequenceAction(new Action[] { new DelayAction(700), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f) });
    SequenceAction localSequenceAction3 = new SequenceAction(new Action[] { new DelayAction(600), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f) });
    SequenceAction localSequenceAction4 = new SequenceAction(new Action[] { new DelayAction(900), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f * 0.6F) });
    SequenceAction localSequenceAction5 = new SequenceAction(new Action[] { new DelayAction(800), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f * 0.6F) });
    SequenceAction localSequenceAction6 = new SequenceAction(new Action[] { new DelayAction(1000), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[i].jdField_b_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[i].a(new Action[] { new Action[] { localSequenceAction1, localSequenceAction2, localSequenceAction3, localSequenceAction4, localSequenceAction5, localSequenceAction6 }[i], new SequenceAction(new Action[] { new DelayAction(1300), new OpacityAction(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof FrameSprite)))
    {
      ((FrameSprite)this.c).a = new ajvr(this, paramOnFrameEndListener);
      ((FrameSprite)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
      a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite.length)
      {
        a(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new ajvt(this, paramOnFrameEndListener));
      }
    }
  }
  
  public void setHeadPositionY(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    int j = paramInt1 / 6;
    int i;
    if (paramInt3 < j) {
      i = j;
    }
    for (;;)
    {
      this.d = i;
      this.c.a(paramInt1 / 2, paramInt2 / 2);
      this.c.e = paramFloat;
      this.c.jdField_b_of_type_Int = 255;
      return;
      i = paramInt3;
      if (paramInt3 + j > paramInt2) {
        i = paramInt2 - j;
      }
    }
  }
  
  public void setReceiveHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null)) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).b(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite = new Sprite[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1] = new Sprite();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new Texture(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new FrameSprite(this, paramArrayOfString);
    ((FrameSprite)this.c).a(paramInt);
    a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite = new Sprite[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt] = new Sprite();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new Texture(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null)) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */