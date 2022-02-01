package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.ImageLoader;
import com.tencent.tkd.topicsdk.list.CommonListAdapter.BaseListViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$ListPhotoViewHolder;", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel;Landroid/view/View;)V", "imageLoader", "Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "getImageLoader", "()Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "setImageLoader", "(Lcom/tencent/tkd/topicsdk/framework/ImageLoader;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "markView", "getMarkView", "()Landroid/view/View;", "setMarkView", "(Landroid/view/View;)V", "media", "Lcom/tencent/tkd/topicsdk/bean/Media;", "getMedia", "()Lcom/tencent/tkd/topicsdk/bean/Media;", "setMedia", "(Lcom/tencent/tkd/topicsdk/bean/Media;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "selectedLayout", "selectedView", "Landroid/widget/TextView;", "getSelectedView", "()Landroid/widget/TextView;", "setSelectedView", "(Landroid/widget/TextView;)V", "tagView", "getTagView", "setTagView", "handleClickVideoItem", "", "handleSelectMedia", "tryAddPhotoUnderSizeLimit", "trySelectVideoUnderSizeLimit", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaSelectorPanel$ListPhotoViewHolder
  extends CommonListAdapter.BaseListViewHolder
{
  @NotNull
  private View b;
  private View c;
  @NotNull
  private TextView d;
  @NotNull
  private TextView e;
  @NotNull
  private ImageView f;
  @NotNull
  private ImageLoader g;
  private int h;
  @Nullable
  private Media i;
  
  public MediaSelectorPanel$ListPhotoViewHolder(View paramView)
  {
    Object localObject2 = ((View)localObject1).findViewById(R.id.N);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.markView)");
    this.b = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.ai);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.selectedLayout)");
    this.c = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.aj);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.selectedView)");
    this.d = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.an);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.tag_view)");
    this.e = ((TextView)localObject2);
    Object localObject1 = ((View)localObject1).findViewById(R.id.y);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "itemView.findViewById(R.id.imageLayout)");
    this.f = ((ImageView)localObject1);
    localObject1 = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = new ImageLoader((Context)localObject1, TopicSDK.a.a().b().n());
    localObject2 = DisplayUtils.a;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int j = ((DisplayUtils)localObject2).a(200.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject1 = ((ImageLoader)localObject1).a(j, ((DisplayUtils)localObject2).a(200.0F, localContext));
    localObject2 = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    this.g = ((ImageLoader)localObject1).a((Drawable)new ColorDrawable(((Context)localObject2).getResources().getColor(R.color.i))).a(this.f);
    if (paramView.getMaxSelectCount() > 1)
    {
      this.c.setOnClickListener((View.OnClickListener)new MediaSelectorPanel.ListPhotoViewHolder.1(this));
      return;
    }
    if (paramView.getMaxSelectCount() == 1) {
      this.f.setOnClickListener((View.OnClickListener)new MediaSelectorPanel.ListPhotoViewHolder.2(this));
    }
  }
  
  private final void b(Media paramMedia)
  {
    if (paramMedia.getSize() < this.a.getMaxMediaSize())
    {
      this.a.getSelectedMedias().add(paramMedia);
      return;
    }
    Function1 localFunction1 = this.a.getOnSelectedOverSizeListener();
    if (localFunction1 != null) {
      paramMedia = (Unit)localFunction1.invoke(paramMedia);
    }
  }
  
  private final void c(Media paramMedia)
  {
    if (paramMedia.getSize() < this.a.getMaxMediaSize())
    {
      paramMedia = this.a.getOnItemClickListener();
      if (paramMedia != null) {
        paramMedia = (Unit)paramMedia.invoke(Integer.valueOf(this.h));
      }
    }
    else
    {
      Function1 localFunction1 = this.a.getOnSelectedOverSizeListener();
      if (localFunction1 != null) {
        paramMedia = (Unit)localFunction1.invoke(paramMedia);
      }
    }
  }
  
  private final void f()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (!this.a.getSelectedMedias().contains(localObject))
      {
        if (this.a.getSelectedMedias().size() < this.a.getMaxSelectCount())
        {
          b((Media)localObject);
        }
        else
        {
          localObject = this.a.getOnOverSelectListener();
          if (localObject != null) {
            localObject = (Unit)((Function0)localObject).invoke();
          }
        }
      }
      else {
        this.a.getSelectedMedias().remove(localObject);
      }
      localObject = this.a.getOnSelectChangeListener();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.a.getSelectedMedias());
      }
      MediaSelectorPanel.a(this.a).notifyDataSetChanged();
    }
  }
  
  private final void g()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (!this.a.getSelectedMedias().contains(localObject))
      {
        if (this.a.getSelectedMedias().size() < this.a.getMaxSelectCount())
        {
          c((Media)localObject);
        }
        else
        {
          localObject = this.a.getOnOverSelectListener();
          if (localObject != null) {
            localObject = (Unit)((Function0)localObject).invoke();
          }
        }
      }
      else {
        this.a.getSelectedMedias().remove(localObject);
      }
      localObject = this.a.getOnSelectChangeListener();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.a.getSelectedMedias());
      }
      MediaSelectorPanel.a(this.a).notifyDataSetChanged();
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(@Nullable Media paramMedia)
  {
    this.i = paramMedia;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.d;
  }
  
  @NotNull
  public final TextView c()
  {
    return this.e;
  }
  
  @NotNull
  public final ImageLoader d()
  {
    return this.g;
  }
  
  public final int e()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder
 * JD-Core Version:    0.7.0.1
 */