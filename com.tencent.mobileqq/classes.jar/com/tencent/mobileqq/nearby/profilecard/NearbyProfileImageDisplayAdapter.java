package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.widget.RoundedRectangleImageView;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageDisplayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageDisplayAdapter$VH;", "newNearbyProfileDisplayPanel", "Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel;", "(Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel;)V", "fistVH", "imageNotSetYet", "", "selectedVh", "getItemCount", "", "isHost", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "setDisplayBackImage", "drawable", "Landroid/graphics/drawable/Drawable;", "picInfo", "Lcom/tencent/mobileqq/picbrowser/PicInfo;", "chosenVh", "setFirstVhImage", "imageUrl", "", "VH", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileImageDisplayAdapter
  extends RecyclerView.Adapter<NearbyProfileImageDisplayAdapter.VH>
{
  private NearbyProfileImageDisplayAdapter.VH a;
  private NearbyProfileImageDisplayAdapter.VH b;
  private boolean c;
  private final NewNearbyProfileDisplayPanel d;
  
  public NearbyProfileImageDisplayAdapter(@NotNull NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel)
  {
    this.d = paramNewNearbyProfileDisplayPanel;
    this.c = true;
  }
  
  private final void a(Drawable paramDrawable, PicInfo paramPicInfo, NearbyProfileImageDisplayAdapter.VH paramVH)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((NearbyProfileImageDisplayAdapter.VH)localObject).c();
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    localObject = paramVH.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "chosenBgView");
    ((View)localObject).setVisibility(0);
    this.b = paramVH;
    if (paramDrawable != null)
    {
      paramDrawable = paramDrawable.getConstantState();
      if (paramDrawable != null)
      {
        paramDrawable = paramDrawable.newDrawable();
        if (paramDrawable != null)
        {
          this.c = false;
          this.d.a(paramDrawable, paramPicInfo);
        }
      }
    }
  }
  
  private final boolean a()
  {
    return this.d.e.mMode == 2;
  }
  
  @NotNull
  public NearbyProfileImageDisplayAdapter.VH a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "p0");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(1946484738, paramViewGroup, false);
    RoundedRectangleImageView localRoundedRectangleImageView = (RoundedRectangleImageView)paramViewGroup.findViewById(1946419204);
    localRoundedRectangleImageView.setRadius(UIUtils.a(localRoundedRectangleImageView.getContext(), 7.5F));
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    return new NearbyProfileImageDisplayAdapter.VH(paramViewGroup);
  }
  
  public void a(@NotNull NearbyProfileImageDisplayAdapter.VH paramVH, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVH, "p0");
    if (paramInt == 0) {
      this.a = paramVH;
    } else if (paramVH == this.a) {
      this.a = ((NearbyProfileImageDisplayAdapter.VH)null);
    }
    Object localObject1 = this.d.k;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= paramInt)
      {
        if (a())
        {
          paramVH.itemView.setOnClickListener((View.OnClickListener)new NearbyProfileImageDisplayAdapter.onBindViewHolder.1(this, (List)localObject1));
          paramVH.b().setImageResource(1946353683);
        }
        return;
      }
      localObject1 = (PicInfo)((List)localObject1).get(paramInt);
      if (localObject1 != null)
      {
        localObject2 = this.d.e;
        paramVH.itemView.setOnClickListener((View.OnClickListener)new NearbyProfileImageDisplayAdapter.onBindViewHolder.2(this, paramVH, (PicInfo)localObject1));
        localObject3 = paramVH.a();
        ((ImageView)localObject3).setBackgroundResource(2130842185);
        ((ImageView)localObject3).setImageResource(2130847501);
        localObject3 = (Context)localObject2;
        localObject4 = ContextCompat.getDrawable((Context)localObject3, 2130846492);
        paramVH.b().setBackgroundDrawable((Drawable)localObject4);
        localObject3 = ContextCompat.getDrawable((Context)localObject3, 2130847338);
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = ((NearbyPeopleProfileActivity)localObject2).mIsPlayDynamicAvatar;
        int i = 1;
        if (bool)
        {
          localObject4 = (CharSequence)((PicInfo)localObject1).e;
          if (localObject4 == null) {
            break label730;
          }
          if (((CharSequence)localObject4).length() != 0) {
            break label725;
          }
          break label730;
          if (paramInt == 0)
          {
            if (DynamicAvatarDownloadManager.e(((PicInfo)localObject1).e))
            {
              this.d.a((PicInfo)localObject1, null);
              localObject4 = paramVH.a();
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "p0.playImage");
              ((ImageView)localObject4).setVisibility(8);
              continue;
            }
            if (NetworkUtil.isWifiConnected((Context)localObject2)) {
              ((NearbyPeopleProfileActivity)localObject2).downDynamicAvatar(((PicInfo)localObject1).e);
            }
            localObject4 = paramVH.a();
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "p0.playImage");
            ((ImageView)localObject4).setVisibility(0);
            continue;
          }
        }
        localObject4 = paramVH.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "p0.playImage");
        ((ImageView)localObject4).setVisibility(8);
        if (((PicInfo)localObject1).d != null)
        {
          localObject4 = ((PicInfo)localObject1).d;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "info.localPath");
          if (((CharSequence)localObject4).length() <= 0) {
            break label735;
          }
          paramInt = 1;
          if (paramInt != 0)
          {
            localObject4 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((NearbyPeopleProfileActivity)localObject2).imageWidth;
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((NearbyPeopleProfileActivity)localObject2).imageWidth;
            ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(new File(((PicInfo)localObject1).d).toURL(), (URLDrawable.URLDrawableOptions)localObject4);
            paramVH.b().setImageDrawable((Drawable)localObject2);
            break label691;
          }
        }
        localObject4 = (CharSequence)((PicInfo)localObject1).b;
        paramInt = i;
        if (localObject4 != null)
        {
          if (((CharSequence)localObject4).length() != 0) {
            break label740;
          }
          paramInt = i;
        }
        if (paramInt == 0)
        {
          localObject4 = NearbyImgDownloader.convertURL(((PicInfo)localObject1).b);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((NearbyPeopleProfileActivity)localObject2).imageWidth;
          localURLDrawableOptions.mRequestHeight = ((NearbyPeopleProfileActivity)localObject2).imageWidth;
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable((URL)localObject4, localURLDrawableOptions);
          ((URLDrawable)localObject2).setDownloadListener((URLDrawable.DownloadListener)new ImgDownloadListener((Context)BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
          paramVH.b().setImageDrawable((Drawable)localObject2);
        }
        else if (((PicInfo)localObject1).h == "type_qq_head_pic")
        {
          paramVH.b().setImageDrawable(ContextCompat.getDrawable((Context)localObject2, 2130841061));
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("PicGallery.getView() new URL(). ");
          ((StringBuilder)localObject3).append(localMalformedURLException.getMessage());
          QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject3).toString(), (Throwable)localMalformedURLException);
        }
      }
      label691:
      if (this.c)
      {
        ImageView localImageView = paramVH.b();
        Intrinsics.checkExpressionValueIsNotNull(localImageView, "p0.image");
        a(localImageView.getDrawable(), (PicInfo)localObject1, paramVH);
      }
      return;
      label725:
      paramInt = 0;
      continue;
      label730:
      paramInt = 1;
      continue;
      label735:
      paramInt = 0;
      continue;
      label740:
      paramInt = 0;
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    NearbyProfileImageDisplayAdapter.VH localVH = this.a;
    if (localVH != null)
    {
      Object localObject = (CharSequence)paramString;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = this.d.e;
        Drawable localDrawable = ContextCompat.getDrawable((Context)localObject, 2130853313);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ((NearbyPeopleProfileActivity)localObject).bigImageWidth;
        localURLDrawableOptions.mRequestHeight = ((NearbyPeopleProfileActivity)localObject).bigImageWidth;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mUseMemoryCache = false;
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        localObject = localVH.b();
        paramString = (Drawable)paramString;
        ((ImageView)localObject).setImageDrawable(paramString);
        if (this.c)
        {
          localObject = this.d.k;
          if (localObject != null)
          {
            localObject = (PicInfo)((List)localObject).get(0);
            if (localObject != null) {
              a(paramString, (PicInfo)localObject, localVH);
            }
          }
        }
      }
      paramString = localVH.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "it.playImage");
      paramString.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.d.k;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    int j = i;
    if (a()) {
      j = Math.min(i + 1, NearbyProfileCardConstants.a);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageDisplayAdapter
 * JD-Core Version:    0.7.0.1
 */