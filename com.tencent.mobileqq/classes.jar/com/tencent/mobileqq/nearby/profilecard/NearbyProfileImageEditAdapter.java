package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.widget.RoundedRectangleImageView;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageEditAdapter$ViewHolder;", "newNearbyProfileEditPanel", "Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileEditPanel;", "(Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileEditPanel;)V", "picInfos", "", "Lcom/tencent/mobileqq/picbrowser/PicInfo;", "getPicInfos", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "Companion", "ViewHolder", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileImageEditAdapter
  extends RecyclerView.Adapter<NearbyProfileImageEditAdapter.ViewHolder>
{
  public static final NearbyProfileImageEditAdapter.Companion a = new NearbyProfileImageEditAdapter.Companion(null);
  @NotNull
  private final List<PicInfo> b;
  private final NewNearbyProfileEditPanel c;
  
  public NearbyProfileImageEditAdapter(@NotNull NewNearbyProfileEditPanel paramNewNearbyProfileEditPanel)
  {
    this.c = paramNewNearbyProfileEditPanel;
    this.b = ((List)new ArrayList());
  }
  
  @NotNull
  public NearbyProfileImageEditAdapter.ViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "p0");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(1946484739, paramViewGroup, false);
    RoundedRectangleImageView localRoundedRectangleImageView = (RoundedRectangleImageView)paramViewGroup.findViewById(1946419204);
    localRoundedRectangleImageView.setRadius(UIUtils.a(localRoundedRectangleImageView.getContext(), 7.5F));
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    return new NearbyProfileImageEditAdapter.ViewHolder(paramViewGroup);
  }
  
  @NotNull
  public final List<PicInfo> a()
  {
    return this.b;
  }
  
  public void a(@NotNull NearbyProfileImageEditAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "p0");
    if (paramInt >= this.b.size())
    {
      paramViewHolder.itemView.setOnClickListener(this.c.V);
      paramViewHolder.a().setImageResource(1946353685);
      return;
    }
    Object localObject2 = (PicInfo)this.b.get(paramInt);
    paramViewHolder.itemView.setOnClickListener((View.OnClickListener)new NearbyProfileImageEditAdapter.onBindViewHolder.1(this, paramInt, paramViewHolder, (PicInfo)localObject2));
    Object localObject1 = paramViewHolder.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "p0.image");
    localObject1 = ContextCompat.getDrawable(((ImageView)localObject1).getContext(), 2130847338);
    Object localObject3 = this.c.F;
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ((NearbyPeopleProfileActivity)localObject3).imageWidth;
        localURLDrawableOptions.mRequestHeight = ((NearbyPeopleProfileActivity)localObject3).imageWidth;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localObject1 = ((PicInfo)localObject2).d;
        int i = 0;
        if (localObject1 != null)
        {
          localObject1 = ((PicInfo)localObject2).d;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.localPath");
          if (((CharSequence)localObject1).length() <= 0) {
            break label423;
          }
          paramInt = 1;
          if (paramInt != 0)
          {
            localObject1 = new File(((PicInfo)localObject2).d).toURL();
            URLDrawable.removeMemoryCacheByUrl(((URL)localObject1).toString());
            localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
            paramViewHolder.a().setImageDrawable((Drawable)localObject1);
            return;
          }
        }
        localObject1 = (String)null;
        localObject3 = ((PicInfo)localObject2).c;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "info.thumbUrl");
        if ((StringsKt.isBlank((CharSequence)localObject3) ^ true)) {
          localObject1 = ((PicInfo)localObject2).c;
        } else if (!TextUtils.isEmpty((CharSequence)((PicInfo)localObject2).b)) {
          localObject1 = ((PicInfo)localObject2).b;
        }
        localObject2 = (CharSequence)localObject1;
        if (localObject2 == null) {
          break label428;
        }
        paramInt = i;
        if (((CharSequence)localObject2).length() == 0) {
          break label428;
        }
        if (paramInt == 0)
        {
          localObject1 = NearbyImgDownloader.convertURL((String)localObject1);
          paramViewHolder.a().setImageDrawable((Drawable)URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions));
          return;
        }
      }
      catch (MalformedURLException paramViewHolder)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GridAdapter.getView() new URL(). ");
          ((StringBuilder)localObject1).append(paramViewHolder.getMessage());
          QLog.d("NearbyProfileImageAdapt", 2, ((StringBuilder)localObject1).toString(), (Throwable)paramViewHolder);
        }
      }
      return;
      label423:
      paramInt = 0;
      continue;
      label428:
      paramInt = 1;
    }
  }
  
  public int getItemCount()
  {
    return Math.min(this.b.size() + 1, NearbyProfileCardConstants.a);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == NearbyProfileCardConstants.a - 1) {
      return 1;
    }
    if (paramInt >= this.c.J.size()) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageEditAdapter
 * JD-Core Version:    0.7.0.1
 */