package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewImageAdapter;", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewImageAdapter$PreviewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "previewImageHeight", "", "getPreviewImageHeight", "()I", "previewImageWidth", "getPreviewImageWidth", "bindViewHolder", "", "position", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "createView", "viewGroup", "createViewHolder", "PreviewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreviewImageAdapter
  extends CommonListAdapter<CaptureTask, PreviewImageAdapter.PreviewHolder>
{
  public PreviewImageAdapter(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final int a()
  {
    return (DisplayUtils.a.a(a()) - DisplayUtils.a.a(a(), 22.5F) * 2) / 11;
  }
  
  private final int b()
  {
    return DisplayUtils.a.a(a(), 56.0F);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.p, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…review, viewGroup, false)");
    return paramContext;
  }
  
  @NotNull
  public PreviewImageAdapter.PreviewHolder a(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (ImageView)paramView.findViewById(R.id.aa);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "imageView");
    paramView = paramContext.getLayoutParams();
    paramView.width = a();
    paramView.height = b();
    paramContext.setLayoutParams(paramView);
    paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new PreviewImageAdapter.PreviewHolder(this, paramContext);
  }
  
  public void a(int paramInt, @NotNull CaptureTask paramCaptureTask, @NotNull PreviewImageAdapter.PreviewHolder paramPreviewHolder, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "bean");
    Intrinsics.checkParameterIsNotNull(paramPreviewHolder, "holder");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramCaptureTask = paramCaptureTask.a();
    paramPreviewHolder.a().setImageBitmap(paramCaptureTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.PreviewImageAdapter
 * JD-Core Version:    0.7.0.1
 */