package com.tencent.tkd.topicsdk.covergallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView$GalleryGridAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;)V", "onValidItemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnValidItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnValidItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPos", "getSelectedPos", "()I", "setSelectedPos", "(I)V", "getCount", "getItem", "Lcom/tencent/tkd/topicsdk/bean/Media;", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverGalleryView$GalleryGridAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public Media a(int paramInt)
  {
    return (Media)CoverGalleryView.a(this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView).get(paramInt);
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public int getCount()
  {
    return CoverGalleryView.a(this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView.getContext()).inflate(R.layout.u, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "LayoutInflater.from(cont…ver_album, parent, false)");
      paramViewGroup = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView;
      if (paramView != null)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        paramViewGroup = new CoverGalleryView.GalleryGridHolder(paramViewGroup, localViewGroup);
        localViewGroup.setTag(paramViewGroup);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    else
    {
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null) {
        break label166;
      }
      paramViewGroup = (CoverGalleryView.GalleryGridHolder)paramViewGroup;
    }
    paramViewGroup.a(a(paramInt).getFilePath());
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramViewGroup.a().setVisibility(0);
      paramViewGroup.b().setVisibility(8);
    }
    else
    {
      paramViewGroup.a().setVisibility(8);
      paramViewGroup.b().setVisibility(0);
    }
    paramViewGroup.a().setOnClickListener((View.OnClickListener)new CoverGalleryView.GalleryGridAdapter.getView.1(this, paramInt));
    return paramView;
    label166:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridHolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridAdapter
 * JD-Core Version:    0.7.0.1
 */