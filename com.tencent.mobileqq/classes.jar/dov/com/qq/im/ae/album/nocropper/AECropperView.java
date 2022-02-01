package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import boih;
import boii;
import boij;
import boik;
import boil;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class AECropperView
  extends FrameLayout
{
  private boih jdField_a_of_type_Boih;
  private AECropperGridView jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView;
  public AECropperImageView a;
  private boolean jdField_a_of_type_Boolean;
  
  public AECropperView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private boik a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return boik.a();
    }
    boij localboij = this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.a();
    if (localboij != null) {
      return boik.a(localboij);
    }
    return boik.b();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView = new AECropperImageView(paramContext, paramAttributeSet);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView = new AECropperGridView(paramContext, paramAttributeSet);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, 0);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet.width = 0;
      paramAttributeSet.height = -1;
    }
    addView(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView, 0, paramAttributeSet);
    addView(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView, 1, paramAttributeSet);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setGestureCallback(new boii(this, null));
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return 0.0F;
    }
    return this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return 1;
    }
    return this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.a();
  }
  
  public Matrix a()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return new Matrix();
    }
    return new Matrix(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.getImageMatrix());
  }
  
  @Nullable
  public EditorPicInfo a(@NonNull EditorPicInfo paramEditorPicInfo)
  {
    boik localboik = a();
    if ((localboik.jdField_a_of_type_Boil != boil.b) || (localboik.jdField_a_of_type_Boij == null)) {
      return null;
    }
    int i = b();
    int j = c();
    paramEditorPicInfo.x = (localboik.jdField_a_of_type_Boij.a * 1.0D / i);
    paramEditorPicInfo.y = (localboik.jdField_a_of_type_Boij.b * 1.0D / j);
    paramEditorPicInfo.w = (localboik.jdField_a_of_type_Boij.c * 1.0D / i);
    paramEditorPicInfo.h = (localboik.jdField_a_of_type_Boij.d * 1.0D / j);
    return paramEditorPicInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.a();
    }
  }
  
  public float b()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return 0.0F;
    }
    return this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.b();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.b();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i == 1) || (i == 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.a = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(boih paramboih)
  {
    this.jdField_a_of_type_Boih = paramboih;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setMinZoom(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperView
 * JD-Core Version:    0.7.0.1
 */