package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageDisplayAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "chosenBgView", "kotlin.jvm.PlatformType", "getChosenBgView", "()Landroid/view/View;", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "playImage", "getPlayImage", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileImageDisplayAdapter$VH
  extends RecyclerView.ViewHolder
{
  private final ImageView a;
  private final ImageView b;
  private final View c;
  
  public NearbyProfileImageDisplayAdapter$VH(@NotNull View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(1946419222));
    this.b = ((ImageView)paramView.findViewById(1946419204));
    this.c = paramView.findViewById(1946419201);
  }
  
  public final ImageView a()
  {
    return this.a;
  }
  
  public final ImageView b()
  {
    return this.b;
  }
  
  public final View c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageDisplayAdapter.VH
 * JD-Core Version:    0.7.0.1
 */