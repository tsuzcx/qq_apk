package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.CropConfig;
import dov.com.qq.im.ae.album.nocropper.CropResult;
import dov.com.qq.im.ae.album.nocropper.CropState;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;

public class AEImageCropperContainer
  extends FrameLayout
{
  public static final int a;
  private AEImageCropperContainer.GridCallback jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer$GridCallback;
  public AEImageCropperMask a;
  public AEImageCropperView a;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(12.0F);
  }
  
  public AEImageCropperContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEImageCropperContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private CropResult a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return CropResult.a();
    }
    CropConfig localCropConfig = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask.a();
    if (localCropConfig != null) {
      return CropResult.a(localCropConfig);
    }
    return CropResult.b();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView = new AEImageCropperView(paramContext, paramAttributeSet);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setMaxZoom(5.0F);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setGestureEnabled(false);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask = new AEImageCropperMask(paramContext, paramAttributeSet);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.setMargins(jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView, 0, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask, 1, paramContext);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setGestureCallback(new AEImageCropperContainer.TouchGestureCallback(this, null));
  }
  
  public Matrix a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView == null) {
      return new Matrix();
    }
    return new Matrix(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.getImageMatrix());
  }
  
  @Nullable
  public CropConfig a()
  {
    CropResult localCropResult = a();
    if ((localCropResult.jdField_a_of_type_DovComQqImAeAlbumNocropperCropState != CropState.b) || (localCropResult.jdField_a_of_type_ComTencentTavcutBeanCropConfig == null)) {
      return null;
    }
    return localCropResult.jdField_a_of_type_ComTencentTavcutBeanCropConfig;
  }
  
  public AEImageCropperView a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask.setVisibility(8);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.a = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(AEImageCropperContainer.GridCallback paramGridCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer$GridCallback = paramGridCallback;
  }
  
  public void setImageBitmap(Bitmap paramBitmap, AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.a(paramAEEditorImageInfo, paramInt1 - jdField_a_of_type_Int * 2, paramInt2 - jdField_a_of_type_Int * 2, paramBitmap);
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask.a(this, paramAEEditorImageInfo.a(), paramBitmap, paramAEEditorImageInfo.jdField_a_of_type_ComTencentTavcutBeanCropConfig, paramInt1, paramInt2);
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask.setVisibility(0);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setMinZoom(paramFloat);
    }
  }
  
  public void setRatioType(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperMask.a(paramInt, this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.a(), this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperContainer
 * JD-Core Version:    0.7.0.1
 */