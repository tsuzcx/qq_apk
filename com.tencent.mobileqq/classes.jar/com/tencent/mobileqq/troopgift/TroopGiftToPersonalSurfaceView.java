package com.tencent.mobileqq.troopgift;

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
      float f = i / 2;
      ((Matrix)localObject).postTranslate(f, f);
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
    catch (OutOfMemoryError paramBitmap)
    {
      label346:
      break label346;
    }
    return null;
  }
  
  public void a(int paramInt, Action.OnActionEndListener paramOnActionEndListener)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d();
    int k = (int)(i * 0.15F);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), new ScaleAction(200, 1.05F, 0.0F) });
    DelayAction localDelayAction = new DelayAction(paramInt);
    float f1 = (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c;
    float f2 = (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d;
    int j = (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c;
    k /= 2;
    ((Sprite)localObject).a(new Action[] { localSequenceAction, new SequenceAction(new Action[] { localDelayAction, new MoveToAction(200, f1, f2, j - k, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d), new MoveToAction(200, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c + k + i, (int)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d) }) });
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a() == null)
    {
      if (paramOnActionEndListener != null) {
        paramOnActionEndListener.a();
      }
    }
    else
    {
      localObject = new ScaleAction(200, 1.05F, 0.0F);
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), localObject }), new SequenceAction(new Action[] { new MoveToAction(200, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c + k, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d), new MoveToAction(200, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - k - i, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d) }) });
      ((ScaleAction)localObject).a(paramOnActionEndListener);
    }
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    ((Sprite)localObject1).e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    int i = ((Sprite)localObject1).d();
    int k = i / 10;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
    int j = 0;
    localObject1 = localObject1[0];
    float f1 = this.jdField_a_of_type_Int / 2 - i;
    int n = this.d;
    int m = k * 2;
    ((Sprite)localObject1).a(f1, n - m);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - k);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3];
    n = this.jdField_a_of_type_Int / 2;
    int i1 = i * 6 / 5;
    ((Sprite)localObject1).a(n - i1, this.d + k);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].a(this.jdField_a_of_type_Int / 2 - i1, this.d + m);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].a(this.jdField_a_of_type_Int / 2 - i, this.d + m);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(200), new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    f1 = 9.0F / (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c);
    localObject1 = new DelayAction(500);
    k = (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[0].c;
    m = (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[0].d;
    n = (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c;
    i /= 20;
    localObject1 = new SequenceAction(new Action[] { localObject1, new FlowerAction(600, k, m, n, i, f1) });
    SequenceAction localSequenceAction1 = new SequenceAction(new Action[] { new DelayAction(700), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[1].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i, f1) });
    SequenceAction localSequenceAction2 = new SequenceAction(new Action[] { new DelayAction(600), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[2].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i, f1) });
    Object localObject2 = new DelayAction(900);
    k = (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3].c;
    m = (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[3].d;
    n = (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c;
    float f2 = 0.6F * f1;
    localObject2 = new SequenceAction(new Action[] { localObject2, new FlowerAction(600, k, m, n, i, f2) });
    SequenceAction localSequenceAction3 = new SequenceAction(new Action[] { new DelayAction(800), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[4].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i, f2) });
    SequenceAction localSequenceAction4 = new SequenceAction(new Action[] { new DelayAction(1000), new FlowerAction(600, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].c, (int)this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[5].d, (int)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c, i, f1) });
    i = 0;
    for (;;)
    {
      Sprite[] arrayOfSprite = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
      if (i >= arrayOfSprite.length) {
        break;
      }
      arrayOfSprite[i].e = 0.0F;
      arrayOfSprite[i].jdField_a_of_type_Int = 255;
      arrayOfSprite[i].a(new Action[] { new Action[] { localObject1, localSequenceAction1, localSequenceAction2, localObject2, localSequenceAction3, localSequenceAction4 }[i], new SequenceAction(new Action[] { new DelayAction(1300), new OpacityAction(300, 255, 0) }) });
      i += 1;
    }
    localObject1 = this.c;
    if ((localObject1 != null) && ((localObject1 instanceof FrameSprite)))
    {
      ((FrameSprite)localObject1).a = new TroopGiftToPersonalSurfaceView.1(this, paramOnFrameEndListener);
      ((FrameSprite)this.c).a(getContext(), this);
    }
    else
    {
      localObject1 = this.c;
      if ((localObject1 != null) && ((localObject1 instanceof VideoSprite))) {
        ((VideoSprite)localObject1).a(new TroopGiftToPersonalSurfaceView.2(this, paramOnFrameEndListener));
      }
    }
    if (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
      a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
      i = j;
      for (;;)
      {
        paramOnFrameEndListener = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
        if (i >= paramOnFrameEndListener.length) {
          break;
        }
        a(paramOnFrameEndListener[i]);
        i += 1;
      }
    }
  }
  
  public void setHeadPositionY(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    int j = paramInt1 / 6;
    int i;
    if (paramInt3 < j)
    {
      i = j;
    }
    else
    {
      i = paramInt3;
      if (paramInt3 + j > paramInt2) {
        i = paramInt2 - j;
      }
    }
    this.d = i;
    this.c.a(paramInt1 / 2, paramInt2 / 2);
    Sprite localSprite = this.c;
    localSprite.e = paramFloat;
    localSprite.jdField_a_of_type_Int = 255;
  }
  
  public void setReceiveHeadBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Sprite localSprite = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
      if (localSprite != null) {
        localSprite.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
      }
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    paramString = this.c;
    paramString.c = (paramInt1 / 2);
    paramString.d = (paramInt2 / 2);
    a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite = new Sprite[6];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1] = new Sprite();
      paramString = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
      paramString[paramInt1].e = 0.0F;
      a(paramString[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new Texture(this, paramBitmap3);
    paramInt1 = paramInt2;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new FrameSprite(this, paramArrayOfString);
    ((FrameSprite)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite = new Sprite[6];
    int i = 0;
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt] = new Sprite();
      paramArrayOfString = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite;
      paramArrayOfString[paramInt].e = 0.0F;
      a(paramArrayOfString[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new Texture(this, paramBitmap3);
    paramInt = i;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlSprite[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Sprite localSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
      if (localSprite != null) {
        localSprite.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */