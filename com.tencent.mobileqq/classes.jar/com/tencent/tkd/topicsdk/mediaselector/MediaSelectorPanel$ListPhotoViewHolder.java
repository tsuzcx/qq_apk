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
  private int jdField_a_of_type_Int;
  @NotNull
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private Media jdField_a_of_type_ComTencentTkdTopicsdkBeanMedia;
  @NotNull
  private ImageLoader jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader;
  private View jdField_b_of_type_AndroidViewView;
  @NotNull
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public MediaSelectorPanel$ListPhotoViewHolder(View paramView)
  {
    Object localObject2 = ((View)localObject1).findViewById(R.id.aD);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.markView)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.bh);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.selectedLayout)");
    this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.bi);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.selectedView)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.bn);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.tag_view)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    Object localObject1 = ((View)localObject1).findViewById(R.id.ah);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "itemView.findViewById(R.id.imageLayout)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localObject1 = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = new ImageLoader((Context)localObject1, TopicSDK.a.a().a().a());
    localObject2 = DisplayUtils.a;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject2).a(200.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject1 = ((ImageLoader)localObject1).a(i, ((DisplayUtils)localObject2).a(200.0F, localContext));
    localObject2 = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader = ((ImageLoader)localObject1).a((Drawable)new ColorDrawable(((Context)localObject2).getResources().getColor(R.color.d))).a(this.jdField_a_of_type_AndroidWidgetImageView);
    if (paramView.a() > 1) {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new MediaSelectorPanel.ListPhotoViewHolder.1(this));
    }
    while (paramView.a() != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new MediaSelectorPanel.ListPhotoViewHolder.2(this));
  }
  
  private final void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanMedia;
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().contains(localObject)) {
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().size() < this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a()) {
          b((Media)localObject);
        }
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a();
        if (localObject != null) {
          localObject = (Unit)((Function1)localObject).invoke(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c());
        }
        MediaSelectorPanel.a(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel).notifyDataSetChanged();
        return;
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a();
        if (localObject != null)
        {
          localObject = (Unit)((Function0)localObject).invoke();
          continue;
          this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().remove(localObject);
        }
      }
    }
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanMedia;
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().contains(localObject)) {
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().size() < this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a()) {
          c((Media)localObject);
        }
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a();
        if (localObject != null) {
          localObject = (Unit)((Function1)localObject).invoke(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c());
        }
        MediaSelectorPanel.a(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel).notifyDataSetChanged();
        return;
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a();
        if (localObject != null)
        {
          localObject = (Unit)((Function0)localObject).invoke();
          continue;
          this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().remove(localObject);
        }
      }
    }
  }
  
  private final void b(Media paramMedia)
  {
    if (paramMedia.getSize() < this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a()) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c().add(paramMedia);
    }
    Function1 localFunction1;
    do
    {
      return;
      localFunction1 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c();
    } while (localFunction1 == null);
    paramMedia = (Unit)localFunction1.invoke(paramMedia);
  }
  
  private final void c(Media paramMedia)
  {
    if (paramMedia.getSize() < this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.a())
    {
      paramMedia = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.b();
      if (paramMedia != null) {
        paramMedia = (Unit)paramMedia.invoke(Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    Function1 localFunction1;
    do
    {
      return;
      localFunction1 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel.c();
    } while (localFunction1 == null);
    paramMedia = (Unit)localFunction1.invoke(paramMedia);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final ImageLoader a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable Media paramMedia)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanMedia = paramMedia;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder
 * JD-Core Version:    0.7.0.1
 */