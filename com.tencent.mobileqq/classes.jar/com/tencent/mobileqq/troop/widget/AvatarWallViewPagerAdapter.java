package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class AvatarWallViewPagerAdapter
  extends PagerAdapter
{
  protected Handler a = new Handler(Looper.getMainLooper());
  protected boolean b = false;
  protected WeakReference<Activity> c;
  protected Handler d;
  protected AvatarWallViewPager e;
  protected int f;
  protected int g;
  protected AppInterface h;
  protected String i;
  protected String j;
  protected boolean k;
  protected List<AvatarInfo> l = new ArrayList(0);
  protected View m;
  protected View n;
  protected int o = 637534208;
  
  public AvatarWallViewPagerAdapter(WeakReference<Activity> paramWeakReference, AvatarWallViewPager paramAvatarWallViewPager, int paramInt1, int paramInt2, AppInterface paramAppInterface, String paramString1, boolean paramBoolean, Handler paramHandler, String paramString2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.c = paramWeakReference;
    this.d = paramHandler;
    this.e = paramAvatarWallViewPager;
    this.h = paramAppInterface;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramBoolean;
    if (ThemeUtil.isInNightMode(paramAppInterface)) {
      this.o = -1308622848;
    }
    if ((paramWeakReference != null) && (paramWeakReference.get() != null) && (paramAppInterface != null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvatarWallViewPagerAdapter", 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
  }
  
  private URLDrawable a(String paramString, AvatarInfo paramAvatarInfo)
  {
    paramString = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    localObject = new Rect();
    ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect((Rect)localObject, paramAvatarInfo.l);
    paramString.setTag(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).buildCustomClipDecoderParams(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), this.f, this.g));
    paramString.setDecodeHandler((DownloadParams.DecodeHandler)((ITroopCardApi)QRoute.api(ITroopCardApi.class)).get_CUSTOM_CLIP_DECODER());
    return paramString;
  }
  
  public int a()
  {
    return this.l.size();
  }
  
  public boolean a(List<AvatarInfo> paramList)
  {
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
      }
      return false;
    }
    if (AvatarInfo.a(paramList, this.l))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.l.clear();
    this.l.addAll(paramList);
    this.n = null;
    this.m = null;
    notifyDataSetChanged();
    this.e.c();
    return true;
  }
  
  public List<AvatarInfo> b()
  {
    return this.l;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i1 = a();
    if (i1 <= 1) {
      return i1;
    }
    return i1 + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (View)paramObject;
    int i1 = paramObject.getId();
    if (i1 >= 0)
    {
      if (i1 >= this.l.size()) {
        return -2;
      }
      if (paramObject.getTag() == null) {
        return -2;
      }
      paramObject = (AvatarInfo)paramObject.getTag();
      AvatarInfo localAvatarInfo = (AvatarInfo)this.l.get(i1);
      if ((paramObject.d.equals(localAvatarInfo.d)) && (paramObject.e == localAvatarInfo.e))
      {
        if (paramObject.j != localAvatarInfo.j) {
          return -2;
        }
        return -1;
      }
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i1 = a();
    Object localObject2 = this.c;
    Object localObject1 = null;
    if ((localObject2 != null) && (((WeakReference)localObject2).get() != null) && (i1 != 0))
    {
      if (i1 > 1) {
        if (paramInt == 1)
        {
          if (paramViewGroup == null)
          {
            localObject2 = this.m;
            if ((localObject2 != null) && (((View)localObject2).getParent() == null)) {
              return this.m;
            }
          }
          else
          {
            localObject1 = this.m;
            if ((localObject1 == null) || (((View)localObject1).getParent() != null)) {
              this.m = ((View)instantiateItem(null, paramInt));
            }
            paramViewGroup.addView(this.m);
            return this.m;
          }
        }
        else if (paramInt == i1) {
          if (paramViewGroup == null)
          {
            localObject2 = this.n;
            if ((localObject2 != null) && (((View)localObject2).getParent() == null)) {
              return this.n;
            }
          }
          else
          {
            localObject1 = this.n;
            if ((localObject1 == null) || (((View)localObject1).getParent() != null)) {
              this.n = ((View)instantiateItem(null, paramInt));
            }
            paramViewGroup.addView(this.n);
            return this.n;
          }
        }
      }
      if (i1 > 1)
      {
        if (paramInt == 0)
        {
          i1 -= 1;
          break label230;
        }
        if (paramInt != i1 + 1)
        {
          i1 = paramInt - 1;
          break label230;
        }
      }
      i1 = 0;
      label230:
      localObject2 = LayoutInflater.from((Context)this.c.get()).inflate(2131625908, null);
      AvatarWallViewPagerAdapter.ViewHolder localViewHolder = new AvatarWallViewPagerAdapter.ViewHolder(this);
      localViewHolder.a = ((URLImageView)((View)localObject2).findViewById(2131435388));
      localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
      int i2 = i1;
      if (a() <= i1) {
        i2 = 0;
      }
      AvatarInfo localAvatarInfo = (AvatarInfo)this.l.get(i2);
      if (localAvatarInfo != null)
      {
        i1 = localAvatarInfo.e;
        Object localObject3 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if ((i1 == 1) && ((localAvatarInfo.c == null) || (!new File(localAvatarInfo.c).exists()))) {
          localObject1 = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.d, this.i, 1));
        } else if ((i1 != 2) && ((localAvatarInfo.c == null) || (!new File(localAvatarInfo.c).exists())))
        {
          if (i1 == 3) {
            localObject1 = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.d, this.i, 0));
          }
        }
        else {
          localObject1 = localAvatarInfo.c;
        }
        localObject3 = this.c;
        if (localObject3 != null) {
          ((View)localObject2).setContentDescription(((Activity)((WeakReference)localObject3).get()).getString(2131893829));
        }
        if (localObject1 != null)
        {
          localObject3 = a((String)localObject1, localAvatarInfo);
          if (localObject3 != null)
          {
            ((URLDrawable)localObject3).setColorFilter(this.o, PorterDuff.Mode.SRC_ATOP);
            localViewHolder.a.setImageDrawable((Drawable)localObject3);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("viewFactory: FROM_OTHERS, path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.i("AvatarWallViewPagerAdapter", 2, String.format(((StringBuilder)localObject3).toString(), new Object[0]));
          }
        }
        if (localAvatarInfo.j)
        {
          if (localViewHolder.b == null)
          {
            localViewHolder.b = ((ViewStub)((View)localObject2).findViewById(2131449361)).inflate();
            localObject1 = (FrameLayout.LayoutParams)localViewHolder.b.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject1).height = -1;
            ((FrameLayout.LayoutParams)localObject1).width = -1;
            localViewHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          localViewHolder.b.setVisibility(0);
        }
        else if (localViewHolder.b != null)
        {
          localViewHolder.b.setVisibility(8);
        }
      }
      ((View)localObject2).setTag(localAvatarInfo);
      ((View)localObject2).setId(i2);
      if (paramViewGroup != null)
      {
        paramViewGroup.addView((View)localObject2);
        return localObject2;
      }
      i1 = getCount();
      if (i1 > 1)
      {
        if (paramInt == 1)
        {
          this.m = ((View)localObject2);
          return localObject2;
        }
        if (paramInt == i1 - 2) {
          this.n = ((View)localObject2);
        }
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarWallViewPagerAdapter", 2, "instantiateItem activity is null or data list count is 0");
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */