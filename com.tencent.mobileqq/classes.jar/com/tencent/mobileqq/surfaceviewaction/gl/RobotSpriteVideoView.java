package com.tencent.mobileqq.surfaceviewaction.gl;

import aili;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.util.DisplayUtil;

public class RobotSpriteVideoView
  extends SpriteGLView
{
  public int a;
  ImageButton jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton;
  Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  protected VideoSprite a;
  String jdField_a_of_type_JavaLangString;
  Sprite jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  String jdField_b_of_type_JavaLangString;
  
  public RobotSpriteVideoView(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, ImageButton.OnClickListener paramOnClickListener)
  {
    super(paramContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new aili(this, this, getContext(), paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c = true;
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite(this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b = 0;
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite(this);
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b = 0;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton = new ImageButton(this, BitmapFactory.decodeResource(paramContext.getResources(), 2130843998), true);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(paramOnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.e = 0.75F;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
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
      ((Matrix)localObject).postScale(paramInt1 / localBitmap2.getWidth(), paramInt2 / localBitmap2.getHeight());
      localCanvas.drawBitmap(localBitmap2, (Matrix)localObject, paramBitmap);
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramOnFrameEndListener);
    paramOnFrameEndListener = new int[2];
    FrameSprite.OnFrameEndListener tmp21_20 = paramOnFrameEndListener;
    tmp21_20[0] = 506;
    FrameSprite.OnFrameEndListener tmp27_21 = tmp21_20;
    tmp27_21[1] = 640;
    tmp27_21;
    RobotResourcesManager.a(paramString, paramOnFrameEndListener);
    paramString = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    int k = (int)(paramString.widthPixels * paramOnFrameEndListener[1] / paramOnFrameEndListener[0]) - DisplayUtil.a(getContext(), 70.0F);
    int m = paramString.widthPixels;
    int n = DisplayUtil.a(getContext(), 70.0F);
    int i1 = DisplayUtil.a(getContext(), 30.0F);
    int i2 = m - m / 2 - i1 / 2 - n / 2;
    try
    {
      paramString = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramString.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(i2, k);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.c = (m - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.c());
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.d = (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.d() / 2);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (this.jdField_b_of_type_JavaLangString.contains("|"))
      {
        paramString = this.jdField_b_of_type_JavaLangString.split("\\|");
        paramOnFrameEndListener = paramString;
        if (paramString.length > 4) {
          paramOnFrameEndListener = new String[] { paramString[0], paramString[1], paramString[2], paramString[3] };
        }
        paramString = new Bitmap[paramOnFrameEndListener.length];
        int j = 0;
        int i3 = paramOnFrameEndListener.length;
        int i = 0;
        while (i < i3)
        {
          paramString[j] = localQQAppInterface.a(paramOnFrameEndListener[i], true);
          j += 1;
          i += 1;
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        paramString = new String[1];
        paramString[0] = this.jdField_b_of_type_JavaLangString;
      }
      paramString = RobotResourcesManager.a().a(m, paramString);
      if (paramString == null) {}
    }
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this, a(paramString.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F)));
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(n + i2 + i1, k);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new OpacityAction(500, 0, 255) });
      paramString = new SequenceAction(new Action[] { new DelayAction(500), new OpacityAction(500, 0, 255) });
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.RobotSpriteVideoView
 * JD-Core Version:    0.7.0.1
 */