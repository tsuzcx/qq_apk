package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import aokj;
import aokk;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;

public abstract class InfoStickerDrawable
  extends Drawable
{
  protected int a;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Context a;
  protected AnimStateTypeEvaluator a;
  private InfoStickerDrawable.AnimationListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetInfoStickerDrawable$AnimationListener;
  protected String a;
  public ArrayList a;
  protected Bitmap b;
  
  public InfoStickerDrawable(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator = new AnimStateTypeEvaluator();
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    return a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a());
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a(paramLong);
    if (localArrayList != null) {
      a(localCanvas, localArrayList);
    }
    return localBitmap;
  }
  
  protected abstract void a();
  
  protected abstract void a(Canvas paramCanvas, ArrayList paramArrayList);
  
  public abstract String[] a(String paramString);
  
  protected Bitmap b()
  {
    if (this.b == null) {
      this.b = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    }
    for (;;)
    {
      return this.b;
      new Canvas(this.b).drawColor(0, PorterDuff.Mode.CLEAR);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator, new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.b(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a() });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aokj(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aokk(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      a(paramCanvas, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */