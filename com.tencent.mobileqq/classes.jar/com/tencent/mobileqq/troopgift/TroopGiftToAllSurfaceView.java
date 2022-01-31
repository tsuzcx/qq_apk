package com.tencent.mobileqq.troopgift;

import akcy;
import akcz;
import akda;
import akdb;
import akdc;
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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ImageButton jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel;
  private Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private TroopGiftToAllSurfaceView.Options jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options;
  private String jdField_a_of_type_JavaLangString;
  private ImageButton jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton;
  private Sprite jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton != null)
    {
      OpacityAction localOpacityAction = new OpacityAction(500, 255, 0);
      localOpacityAction.a(new akdb(this));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(new Action[] { localOpacityAction });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!paramOptions.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(paramOptions.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(paramOptions.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramOptions.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(paramOptions.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = paramOptions.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < paramOptions.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + paramOptions.jdField_a_of_type_JavaLangString.charAt(i));
          if (f1 + f3 + f2 > 475.0F) {
            break;
          }
          f1 += f3;
          j += 1;
          i += 1;
        }
        if (j <= 0) {
          break label577;
        }
        if (j != paramOptions.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = paramOptions.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite(this, localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = 0.0F;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton = new ImageButton(this, paramBitmap3, false);
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.f / 100);
      }
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton = new ImageButton(this, BitmapFactory.decodeResource(getResources(), 2130844064), true);
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(paramOptions.jdField_a_of_type_Int - DisplayUtils.a(getContext(), 40.0F), DisplayUtils.a(getContext(), 120.0F));
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(paramOnClickListener);
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.e = 0.75F;
        a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton);
        return;
        paramBitmap1 = paramOptions.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options = paramOptions;
    this.jdField_a_of_type_Int = (paramOptions.jdField_b_of_type_Int * paramOptions.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.jdField_a_of_type_Boolean = true;
    paramString.c = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramOnClickListener, paramOptions);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options = paramOptions;
    this.jdField_a_of_type_Int = (paramOptions.jdField_b_of_type_Int * paramOptions.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new FrameSprite(this, paramArrayOfString);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = paramArrayOfString;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.e = paramOptions.jdField_a_of_type_Float;
    paramArrayOfString.a(paramOptions.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramOnClickListener, paramOptions);
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    OpacityAction localOpacityAction = new OpacityAction(500, 255, 0, 1);
    localOpacityAction.a(paramOnActionEndListener);
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localOpacityAction });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(null);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null)
    {
      SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new ScaleAction(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new ScaleAction(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new ScaleAction(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localSequenceAction });
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null) && ((this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite instanceof FrameSprite)))
    {
      ((FrameSprite)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite).a = new akcy(this, paramOnFrameEndListener);
      ((FrameSprite)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite).a(getContext(), this);
    }
    for (;;)
    {
      paramOnFrameEndListener = new DelayAction(500);
      paramOnFrameEndListener.a(new akcz(this));
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { paramOnFrameEndListener });
      }
      return;
      if ((this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite != null) && ((this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite).a(paramOnFrameEndListener);
      }
    }
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(paramOnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.e = 0.0F;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton);
      paramOnClickListener = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new ScaleAction(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new ScaleAction(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      paramOnClickListener.a(new akda(this));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(new Action[] { paramOnClickListener });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(new akdc(this, paramString, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */