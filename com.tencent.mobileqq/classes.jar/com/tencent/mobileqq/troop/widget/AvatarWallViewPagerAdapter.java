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
  protected int a;
  protected Handler a;
  protected View a;
  protected AppInterface a;
  protected AvatarWallViewPager a;
  protected String a;
  protected List<AvatarInfo> a;
  protected WeakReference<Activity> a;
  protected boolean a;
  protected int b;
  protected Handler b;
  protected View b;
  protected String b;
  protected boolean b;
  protected int c = 637534208;
  
  public AvatarWallViewPagerAdapter(WeakReference<Activity> paramWeakReference, AvatarWallViewPager paramAvatarWallViewPager, int paramInt1, int paramInt2, AppInterface paramAppInterface, String paramString1, boolean paramBoolean, Handler paramHandler, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = paramAvatarWallViewPager;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (ThemeUtil.isInNightMode(paramAppInterface)) {
      this.c = -1308622848;
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
    ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect((Rect)localObject, paramAvatarInfo.d);
    paramString.setTag(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).buildCustomClipDecoderParams(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    paramString.setDecodeHandler((DownloadParams.DecodeHandler)((ITroopCardApi)QRoute.api(ITroopCardApi.class)).get_CUSTOM_CLIP_DECODER());
    return paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public List<AvatarInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(List<AvatarInfo> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
      }
      return false;
    }
    if (AvatarInfo.a(paramList, this.jdField_a_of_type_JavaUtilList))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b();
    return true;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (View)paramObject;
    int i = paramObject.getId();
    if (i >= 0)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        return -2;
      }
      if (paramObject.getTag() == null) {
        return -2;
      }
      paramObject = (AvatarInfo)paramObject.getTag();
      AvatarInfo localAvatarInfo = (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((paramObject.jdField_c_of_type_JavaLangString.equals(localAvatarInfo.jdField_c_of_type_JavaLangString)) && (paramObject.jdField_b_of_type_Int == localAvatarInfo.jdField_b_of_type_Int))
      {
        if (paramObject.jdField_c_of_type_Boolean != localAvatarInfo.jdField_c_of_type_Boolean) {
          return -2;
        }
        return -1;
      }
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = a();
    Object localObject2 = this.jdField_a_of_type_MqqUtilWeakReference;
    Object localObject1 = null;
    if ((localObject2 != null) && (((WeakReference)localObject2).get() != null) && (i != 0))
    {
      if (i > 1) {
        if (paramInt == 1)
        {
          if (paramViewGroup == null)
          {
            localObject2 = this.jdField_a_of_type_AndroidViewView;
            if ((localObject2 != null) && (((View)localObject2).getParent() == null)) {
              return this.jdField_a_of_type_AndroidViewView;
            }
          }
          else
          {
            localObject1 = this.jdField_a_of_type_AndroidViewView;
            if ((localObject1 == null) || (((View)localObject1).getParent() != null)) {
              this.jdField_a_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
            }
            paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
            return this.jdField_a_of_type_AndroidViewView;
          }
        }
        else if (paramInt == i) {
          if (paramViewGroup == null)
          {
            localObject2 = this.jdField_b_of_type_AndroidViewView;
            if ((localObject2 != null) && (((View)localObject2).getParent() == null)) {
              return this.jdField_b_of_type_AndroidViewView;
            }
          }
          else
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView;
            if ((localObject1 == null) || (((View)localObject1).getParent() != null)) {
              this.jdField_b_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
            }
            paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
            return this.jdField_b_of_type_AndroidViewView;
          }
        }
      }
      if (i > 1)
      {
        if (paramInt == 0)
        {
          i -= 1;
          break label230;
        }
        if (paramInt != i + 1)
        {
          i = paramInt - 1;
          break label230;
        }
      }
      i = 0;
      label230:
      localObject2 = LayoutInflater.from((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).inflate(2131559865, null);
      AvatarWallViewPagerAdapter.ViewHolder localViewHolder = new AvatarWallViewPagerAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject2).findViewById(2131368486));
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      int j = i;
      if (a() <= i) {
        j = 0;
      }
      AvatarInfo localAvatarInfo = (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localAvatarInfo != null)
      {
        i = localAvatarInfo.jdField_b_of_type_Int;
        Object localObject3 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if ((i == 1) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists()))) {
          localObject1 = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1));
        } else if ((i != 2) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
        {
          if (i == 3) {
            localObject1 = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0));
          }
        }
        else {
          localObject1 = localAvatarInfo.jdField_b_of_type_JavaLangString;
        }
        localObject3 = this.jdField_a_of_type_MqqUtilWeakReference;
        if (localObject3 != null) {
          ((View)localObject2).setContentDescription(((Activity)((WeakReference)localObject3).get()).getString(2131696064));
        }
        if (localObject1 != null)
        {
          localObject3 = a((String)localObject1, localAvatarInfo);
          if (localObject3 != null)
          {
            ((URLDrawable)localObject3).setColorFilter(this.c, PorterDuff.Mode.SRC_ATOP);
            localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("viewFactory: FROM_OTHERS, path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.i("AvatarWallViewPagerAdapter", 2, String.format(((StringBuilder)localObject3).toString(), new Object[0]));
          }
        }
        if (localAvatarInfo.jdField_c_of_type_Boolean)
        {
          if (localViewHolder.jdField_a_of_type_AndroidViewView == null)
          {
            localViewHolder.jdField_a_of_type_AndroidViewView = ((ViewStub)((View)localObject2).findViewById(2131380410)).inflate();
            localObject1 = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject1).height = -1;
            ((FrameLayout.LayoutParams)localObject1).width = -1;
            localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        else if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      ((View)localObject2).setTag(localAvatarInfo);
      ((View)localObject2).setId(j);
      if (paramViewGroup != null)
      {
        paramViewGroup.addView((View)localObject2);
        return localObject2;
      }
      i = getCount();
      if (i > 1)
      {
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          return localObject2;
        }
        if (paramInt == i - 2) {
          this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */