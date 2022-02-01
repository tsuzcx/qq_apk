package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.bm.library.PhotoView;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/GalleryView$mAdapter$1", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "setPrimaryItem", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GalleryView$mAdapter$1
  extends PagerAdapterProxy
{
  GalleryView$mAdapter$1(Context paramContext) {}
  
  public int a()
  {
    return GalleryView.a(this.a).size();
  }
  
  @NotNull
  public Object a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    PhotoView localPhotoView = new PhotoView(this.b);
    localPhotoView.a();
    paramViewGroup.addView((View)localPhotoView);
    paramViewGroup = this.a.getPicLoader();
    if (paramViewGroup != null)
    {
      Object localObject = GalleryView.a(this.a).get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mList[position]");
      paramViewGroup.invoke(localObject, localPhotoView);
    }
    else
    {
      localPhotoView.setImageURI(Uri.parse((String)GalleryView.a(this.a).get(paramInt)));
    }
    localPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localPhotoView.setOnClickListener(GalleryView.b(this.a));
    localPhotoView.setOnLongClickListener((View.OnLongClickListener)new GalleryView.mAdapter.1.instantiateItem.1(this, paramInt));
    return localPhotoView;
  }
  
  public void a(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public boolean a(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return paramView == paramObject;
  }
  
  public void b(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    super.b(paramViewGroup, paramInt, paramObject);
    GalleryView.a(this.a, (PhotoView)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.GalleryView.mAdapter.1
 * JD-Core Version:    0.7.0.1
 */