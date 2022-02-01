package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
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
  protected QQAppInterface a;
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
  
  public AvatarWallViewPagerAdapter(WeakReference<Activity> paramWeakReference, AvatarWallViewPager paramAvatarWallViewPager, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, Handler paramHandler, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = paramAvatarWallViewPager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
      this.c = -1308622848;
    }
    if (((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null)) && (QLog.isColorLevel())) {
      QLog.e("AvatarWallViewPagerAdapter", 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
  }
  
  private URLDrawable a(String paramString, AvatarInfo paramAvatarInfo)
  {
    paramString = TroopPhotoUtil.a(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    localObject = new Rect();
    TroopPhotoUtil.a((Rect)localObject, paramAvatarInfo.d);
    paramString.setTag(URLDrawableDecodeHandler.a(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.y);
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
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
      }
    }
    do
    {
      return false;
      if (!AvatarInfo.a(paramList, this.jdField_a_of_type_JavaUtilList)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
    return false;
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
    if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -2;
    }
    if (paramObject.getTag() == null) {
      return -2;
    }
    paramObject = (AvatarInfo)paramObject.getTag();
    AvatarInfo localAvatarInfo = (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if ((!paramObject.jdField_c_of_type_JavaLangString.equals(localAvatarInfo.jdField_c_of_type_JavaLangString)) || (paramObject.jdField_b_of_type_Int != localAvatarInfo.jdField_b_of_type_Int) || (paramObject.jdField_c_of_type_Boolean != localAvatarInfo.jdField_c_of_type_Boolean)) {
      return -2;
    }
    return -1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = null;
    int i = a();
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "instantiateItem activity is null or data list count is 0");
      }
      return null;
    }
    if (i > 1) {
      if (paramInt == 1)
      {
        if (paramViewGroup == null)
        {
          if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == null)) {
            return this.jdField_a_of_type_AndroidViewView;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() != null)) {
            this.jdField_a_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
          return this.jdField_a_of_type_AndroidViewView;
        }
      }
      else if (paramInt == i) {
        if (paramViewGroup == null)
        {
          if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() == null)) {
            return this.jdField_b_of_type_AndroidViewView;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView.getParent() != null)) {
            this.jdField_b_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
          return this.jdField_b_of_type_AndroidViewView;
        }
      }
    }
    if (i > 1) {
      if (paramInt == 0) {
        i -= 1;
      }
    }
    for (;;)
    {
      View localView = LayoutInflater.from((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).inflate(2131559994, null);
      AvatarWallViewPagerAdapter.ViewHolder localViewHolder = new AvatarWallViewPagerAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368754));
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      if (a() <= i) {
        i = 0;
      }
      for (;;)
      {
        AvatarInfo localAvatarInfo = (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        int j;
        Object localObject2;
        if (localAvatarInfo != null)
        {
          j = localAvatarInfo.jdField_b_of_type_Int;
          localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
          if ((j == 1) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
          {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getArtWork(((ITroopAvatarUtilApi)localObject2).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1));
            label377:
            if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
              localView.setContentDescription(((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131696049));
            }
            if (localObject1 != null)
            {
              localObject2 = a((String)localObject1, localAvatarInfo);
              if (localObject2 != null)
              {
                ((URLDrawable)localObject2).setColorFilter(this.c, PorterDuff.Mode.SRC_ATOP);
                localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
              }
              if (QLog.isColorLevel()) {
                QLog.i("AvatarWallViewPagerAdapter", 2, String.format("viewFactory: FROM_OTHERS, path=" + (String)localObject1, new Object[0]));
              }
            }
            if (!localAvatarInfo.jdField_c_of_type_Boolean) {
              break label688;
            }
            if (localViewHolder.jdField_a_of_type_AndroidViewView == null)
            {
              localViewHolder.jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131381153)).inflate();
              localObject1 = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject1).height = -1;
              ((FrameLayout.LayoutParams)localObject1).width = -1;
              localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        else
        {
          label566:
          localView.setTag(localAvatarInfo);
          localView.setId(i);
          if (paramViewGroup == null) {
            break label709;
          }
          paramViewGroup.addView(localView);
        }
        for (;;)
        {
          return localView;
          if (paramInt == i + 1)
          {
            i = 0;
            break;
          }
          i = paramInt - 1;
          break;
          if ((j == 2) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
          {
            localObject1 = localAvatarInfo.jdField_b_of_type_JavaLangString;
            break label377;
          }
          if (j != 3) {
            break label377;
          }
          localObject1 = ((ITroopAvatarUtilApi)localObject2).getArtWork(((ITroopAvatarUtilApi)localObject2).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0));
          break label377;
          label688:
          if (localViewHolder.jdField_a_of_type_AndroidViewView == null) {
            break label566;
          }
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          break label566;
          label709:
          i = getCount();
          if (i > 1) {
            if (paramInt == 1) {
              this.jdField_a_of_type_AndroidViewView = localView;
            } else if (paramInt == i - 2) {
              this.jdField_b_of_type_AndroidViewView = localView;
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */