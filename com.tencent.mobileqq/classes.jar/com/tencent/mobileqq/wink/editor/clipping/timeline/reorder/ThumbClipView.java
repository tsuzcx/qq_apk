package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.EmptyThumbnailProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IThumbnailProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IViewThumbnailGeneratedListener;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ThumbClipView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "createObjTag", "", "uuid", "onAttachedToWindow", "", "onDetachedFromWindow", "onThumbnailGenerated", "tag", "", "startTimeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "setClipUrl", "path", "selectedStart", "setThumbnailProvider", "provider", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbClipView
  extends AppCompatImageView
  implements IViewThumbnailGeneratedListener
{
  private IThumbnailProvider a = (IThumbnailProvider)new EmptyThumbnailProvider();
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThumbClipView");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a(@Nullable Object paramObject, long paramLong, @Nullable Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (Intrinsics.areEqual(paramObject, getTag())) && (!paramBitmap.isRecycled())) {
      post((Runnable)new ThumbClipView.onThumbnailGenerated.1(this, paramBitmap));
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.a((IViewThumbnailGeneratedListener)this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.b((IViewThumbnailGeneratedListener)this);
  }
  
  public final void setClipUrl(@NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uuid");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    setTag(a(paramString1));
    paramString1 = this.a.a(paramLong, getTag(), paramString2);
    paramString2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "resources");
    setImageDrawable((Drawable)new SafeBitmapDrawable(paramString2, paramString1));
  }
  
  public final void setThumbnailProvider(@NotNull IThumbnailProvider paramIThumbnailProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramIThumbnailProvider, "provider");
    this.a = paramIThumbnailProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ThumbClipView
 * JD-Core Version:    0.7.0.1
 */