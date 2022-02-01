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
  private int b = -1;
  @Nullable
  private Function1<? super Integer, Unit> c;
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.c = paramFunction1;
  }
  
  @NotNull
  public Media b(int paramInt)
  {
    return (Media)CoverGalleryView.a(this.a).get(paramInt);
  }
  
  @Nullable
  public final Function1<Integer, Unit> b()
  {
    return this.c;
  }
  
  public int getCount()
  {
    return CoverGalleryView.a(this.a).size();
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.p, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "LayoutInflater.from(cont…ver_album, parent, false)");
      paramViewGroup = this.a;
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
    paramViewGroup.a(b(paramInt).getFilePath());
    if (paramInt == this.b)
    {
      paramViewGroup.b().setVisibility(0);
      paramViewGroup.c().setVisibility(8);
    }
    else
    {
      paramViewGroup.b().setVisibility(8);
      paramViewGroup.c().setVisibility(0);
    }
    paramViewGroup.a().setOnClickListener((View.OnClickListener)new CoverGalleryView.GalleryGridAdapter.getView.1(this, paramInt));
    return paramView;
    label166:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridHolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridAdapter
 * JD-Core Version:    0.7.0.1
 */