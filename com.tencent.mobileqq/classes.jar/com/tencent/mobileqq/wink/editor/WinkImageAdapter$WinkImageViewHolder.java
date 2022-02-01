package com.tencent.mobileqq.wink.editor;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkImageAdapter$WinkImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "bind", "", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "areaWidth", "", "areaHeight", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkImageAdapter$WinkImageViewHolder
  extends RecyclerView.ViewHolder
{
  public static final WinkImageAdapter.WinkImageViewHolder.Companion a = new WinkImageAdapter.WinkImageViewHolder.Companion(null);
  @NotNull
  private static final ColorDrawable c = new ColorDrawable(-16777216);
  @NotNull
  private final ImageView b;
  
  public WinkImageAdapter$WinkImageViewHolder(@NotNull View paramView)
  {
    super(paramView);
    paramView = paramView.findViewById(2131435357);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "container.findViewById(R.id.image)");
    this.b = ((ImageView)paramView);
  }
  
  public final void a(@NotNull ResourceModel paramResourceModel, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "resource");
    Object localObject1 = paramResourceModel.size;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((SizeF)localObject1).width;
    float f2 = paramResourceModel.size.height;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[bind] image size=");
    ((StringBuilder)localObject1).append(f1);
    ((StringBuilder)localObject1).append('x');
    ((StringBuilder)localObject1).append(f2);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("area size=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append('x');
    ((StringBuilder)localObject1).append(paramInt2);
    AEQLog.a("WinkImageAdapter", ((StringBuilder)localObject1).toString());
    if (f1 * 3 <= f2 * 2) {
      this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    } else {
      this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
    Object localObject2 = c;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("file://");
    ((StringBuilder)localObject2).append(paramResourceModel.path);
    paramResourceModel = URLDrawable.getDrawable(((StringBuilder)localObject2).toString(), (URLDrawable.URLDrawableOptions)localObject1);
    this.b.setImageDrawable((Drawable)paramResourceModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkImageAdapter.WinkImageViewHolder
 * JD-Core Version:    0.7.0.1
 */