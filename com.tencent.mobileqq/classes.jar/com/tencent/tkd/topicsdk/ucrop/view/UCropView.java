package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.ucrop.R.styleable;
import com.tencent.tkd.topicsdk.ucrop.callback.CropBoundsChangeListener;
import com.tencent.tkd.topicsdk.ucrop.callback.OverlayViewChangeListener;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/UCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureCropView", "Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "getGestureCropView", "()Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "setGestureCropView", "(Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;)V", "overlayView", "Lcom/tencent/tkd/topicsdk/ucrop/view/OverlayView;", "getOverlayView", "()Lcom/tencent/tkd/topicsdk/ucrop/view/OverlayView;", "processStyledAttributes", "", "a", "Landroid/content/res/TypedArray;", "resetCropImageView", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setListenersToViews", "setVideo", "path", "", "videoWidth", "videoHeight", "onPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "shouldDelayChildPressedState", "", "videoSeekTo", "position", "Companion", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class UCropView
  extends FrameLayout
{
  public static final UCropView.Companion a = new UCropView.Companion(null);
  @NotNull
  private static String d = "video";
  @NotNull
  private static String e = "image";
  @Nullable
  private IGestureCropView b;
  @NotNull
  private final OverlayView c;
  
  @JvmOverloads
  public UCropView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public UCropView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.b);
    paramAttributeSet = localTypedArray.getString(R.styleable.o);
    if (Intrinsics.areEqual(d, paramAttributeSet)) {
      paramAttributeSet = (IGestureCropView)new GestureCropVideoView(paramContext);
    } else {
      paramAttributeSet = (IGestureCropView)new GestureCropImageView(paramContext);
    }
    this.b = paramAttributeSet;
    paramAttributeSet = this.b;
    if (paramAttributeSet != null)
    {
      addView(paramAttributeSet.getView(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      Intrinsics.checkExpressionValueIsNotNull(localTypedArray, "a");
      a(localTypedArray);
    }
    paramContext = new OverlayView(paramContext, null, 0, 6, null);
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    Intrinsics.checkExpressionValueIsNotNull(localTypedArray, "a");
    paramContext.a(localTypedArray);
    this.c = paramContext;
    localTypedArray.recycle();
    b();
  }
  
  private final void a(TypedArray paramTypedArray)
  {
    int i = R.styleable.c;
    float f2 = 0.0F;
    float f3 = Math.abs(paramTypedArray.getFloat(i, 0.0F));
    float f4 = Math.abs(paramTypedArray.getFloat(R.styleable.d, 0.0F));
    paramTypedArray = this.b;
    if (paramTypedArray != null)
    {
      paramTypedArray = paramTypedArray.getGestureCropHandler();
      if (paramTypedArray != null)
      {
        float f1 = f2;
        if (f3 != 0.0F) {
          if (f4 == 0.0F) {
            f1 = f2;
          } else {
            f1 = f3 / f4;
          }
        }
        paramTypedArray.a(f1);
      }
    }
  }
  
  private final void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((IGestureCropView)localObject).getGestureCropHandler();
      if (localObject != null) {
        ((GestureCropHandler)localObject).a((CropBoundsChangeListener)new UCropView.setListenersToViews.1(this));
      }
    }
    this.c.setOverlayViewChangeListener((OverlayViewChangeListener)new UCropView.setListenersToViews.2(this));
  }
  
  public final void a()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    removeView(((IGestureCropView)localObject).getView());
    if ((this.b instanceof GestureCropVideoView))
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = (IGestureCropView)new GestureCropVideoView((Context)localObject);
    }
    else
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = (IGestureCropView)new GestureCropImageView((Context)localObject);
    }
    this.b = ((IGestureCropView)localObject);
    b();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((IGestureCropView)localObject).getGestureCropHandler().a(this.c.getCropViewRect());
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    addView(((IGestureCropView)localObject).getView(), 0);
  }
  
  public final void a(int paramInt)
  {
    IGestureCropView localIGestureCropView = this.b;
    Object localObject = localIGestureCropView;
    if (!(localIGestureCropView instanceof GestureCropVideoView)) {
      localObject = null;
    }
    localObject = (GestureCropVideoView)localObject;
    if (localObject != null) {
      ((GestureCropVideoView)localObject).a(paramInt);
    }
  }
  
  @Nullable
  public final IGestureCropView getGestureCropView()
  {
    return this.b;
  }
  
  @NotNull
  public final OverlayView getOverlayView()
  {
    return this.c;
  }
  
  public final void setGestureCropView(@Nullable IGestureCropView paramIGestureCropView)
  {
    this.b = paramIGestureCropView;
  }
  
  public final void setImageBitmap(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    IGestureCropView localIGestureCropView = this.b;
    Object localObject = localIGestureCropView;
    if (!(localIGestureCropView instanceof GestureCropImageView)) {
      localObject = null;
    }
    localObject = (GestureCropImageView)localObject;
    if (localObject != null) {
      ((GestureCropImageView)localObject).setImageBitmap(paramBitmap);
    }
  }
  
  public final void setVideo(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    IGestureCropView localIGestureCropView = this.b;
    Object localObject = localIGestureCropView;
    if (!(localIGestureCropView instanceof GestureCropVideoView)) {
      localObject = null;
    }
    localObject = (GestureCropVideoView)localObject;
    if (localObject != null)
    {
      ((GestureCropVideoView)localObject).setFilePath(paramString);
      ((GestureCropVideoView)localObject).setVideoWidth(paramInt1);
      ((GestureCropVideoView)localObject).setVideoHeight(paramInt2);
      ((GestureCropVideoView)localObject).setOnPreparedListener(paramOnPreparedListener);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.UCropView
 * JD-Core Version:    0.7.0.1
 */