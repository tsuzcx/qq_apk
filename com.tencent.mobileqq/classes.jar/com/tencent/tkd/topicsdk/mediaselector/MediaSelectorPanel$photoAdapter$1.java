package com.tencent.tkd.topicsdk.mediaselector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.ImageLoader;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$photoAdapter$1", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$ListPhotoViewHolder;", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel;", "bindViewHolder", "", "position", "", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "createView", "context", "Landroid/content/Context;", "viewGroup", "createViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaSelectorPanel$photoAdapter$1
  extends CommonListAdapter<Media, MediaSelectorPanel.ListPhotoViewHolder>
{
  MediaSelectorPanel$photoAdapter$1(Context paramContext1, Context paramContext2)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.o, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…_photo, viewGroup, false)");
    return paramContext;
  }
  
  @NotNull
  public MediaSelectorPanel.ListPhotoViewHolder a(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    int i = DisplayUtils.a.a(paramContext, 2.0F);
    i = (DisplayUtils.a.a(paramContext) - i * 3) / 4;
    paramView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(i, i));
    return new MediaSelectorPanel.ListPhotoViewHolder(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel, paramView);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(int paramInt, @NotNull Media paramMedia, @NotNull MediaSelectorPanel.ListPhotoViewHolder paramListPhotoViewHolder, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramMedia, "bean");
    Intrinsics.checkParameterIsNotNull(paramListPhotoViewHolder, "holder");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramListPhotoViewHolder.a(paramMedia);
    paramListPhotoViewHolder.a(paramInt);
    boolean bool = StringsKt.endsWith(paramMedia.getFilePath(), ".gif", true);
    if (paramMedia.getType() == MediaType.PHOTO)
    {
      paramListPhotoViewHolder.a().a(paramMedia.getFilePath());
      paramView = paramListPhotoViewHolder.b();
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      paramView.setVisibility(paramInt);
      paramListPhotoViewHolder.b().setText(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.getResources().getText(R.string.D));
    }
    else
    {
      paramListPhotoViewHolder.a().a(paramMedia.getFilePath());
      paramListPhotoViewHolder.b().setVisibility(0);
      paramListPhotoViewHolder.b().setText((CharSequence)paramMedia.getDurationStr());
    }
    paramInt = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().indexOf(paramMedia);
    if (paramInt >= 0)
    {
      paramListPhotoViewHolder.a().setVisibility(0);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a() > 1)
      {
        paramListPhotoViewHolder.a().setBackgroundResource(R.drawable.j);
        paramListPhotoViewHolder.a().setSelected(true);
        paramListPhotoViewHolder.a().setText((CharSequence)String.valueOf(paramInt + 1));
      }
      else
      {
        paramListPhotoViewHolder.a().setBackgroundResource(R.drawable.l);
        paramListPhotoViewHolder.a().setText((CharSequence)"");
      }
      paramListPhotoViewHolder.a().setVisibility(0);
      paramListPhotoViewHolder.a().setBackgroundResource(R.color.a);
      return;
    }
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a() > 1)
    {
      paramListPhotoViewHolder.a().setVisibility(0);
      paramListPhotoViewHolder.a().setBackgroundResource(R.drawable.j);
      paramListPhotoViewHolder.a().setSelected(false);
      paramListPhotoViewHolder.a().setText((CharSequence)"");
    }
    else
    {
      paramListPhotoViewHolder.a().setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().size() >= this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a())
    {
      paramListPhotoViewHolder.a().setVisibility(0);
      paramListPhotoViewHolder.a().setBackgroundResource(R.color.d);
      return;
    }
    paramListPhotoViewHolder.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.photoAdapter.1
 * JD-Core Version:    0.7.0.1
 */