package com.tencent.mobileqq.troop.widget;

import akeh;
import akgy;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
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
import bdzx;
import bfpi;
import bfvi;
import bgey;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
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
  protected List<akeh> a;
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
  
  private URLDrawable a(String paramString, akeh paramakeh)
  {
    paramString = akgy.a(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdzx.a;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    localObject = new Rect();
    akgy.a((Rect)localObject, paramakeh.d);
    paramString.setTag(bgey.a(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    paramString.setDecodeHandler(bgey.y);
    return paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public List<akeh> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(List<akeh> paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
      }
    }
    do
    {
      return false;
      if (!akeh.a(paramList, this.jdField_a_of_type_JavaUtilList)) {
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
    paramObject = (akeh)paramObject.getTag();
    akeh localakeh = (akeh)this.jdField_a_of_type_JavaUtilList.get(i);
    if ((!paramObject.jdField_c_of_type_JavaLangString.equals(localakeh.jdField_c_of_type_JavaLangString)) || (paramObject.jdField_b_of_type_Int != localakeh.jdField_b_of_type_Int) || (paramObject.jdField_c_of_type_Boolean != localakeh.jdField_c_of_type_Boolean)) {
      return -2;
    }
    return -1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
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
      View localView = LayoutInflater.from((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).inflate(2131559866, null);
      bfvi localbfvi = new bfvi(this);
      localbfvi.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368269));
      localbfvi.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      if (a() <= i) {
        i = 0;
      }
      for (;;)
      {
        akeh localakeh = (akeh)this.jdField_a_of_type_JavaUtilList.get(i);
        int j;
        if (localakeh != null)
        {
          j = localakeh.jdField_b_of_type_Int;
          if ((j == 1) && ((localakeh.jdField_b_of_type_JavaLangString == null) || (!new File(localakeh.jdField_b_of_type_JavaLangString).exists())))
          {
            localObject = bfpi.b(bfpi.a(localakeh.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1));
            label358:
            if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
              localView.setContentDescription(((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695367));
            }
            if (localObject != null)
            {
              URLDrawable localURLDrawable = a((String)localObject, localakeh);
              if (localURLDrawable != null)
              {
                localURLDrawable.setColorFilter(this.c, PorterDuff.Mode.SRC_ATOP);
                localbfvi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
              }
              if (QLog.isColorLevel()) {
                QLog.i("AvatarWallViewPagerAdapter", 2, String.format("viewFactory: FROM_OTHERS, path=" + (String)localObject, new Object[0]));
              }
            }
            if (!localakeh.jdField_c_of_type_Boolean) {
              break label661;
            }
            if (localbfvi.jdField_a_of_type_AndroidViewView == null)
            {
              localbfvi.jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131380459)).inflate();
              localObject = (FrameLayout.LayoutParams)localbfvi.jdField_a_of_type_AndroidViewView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).height = -1;
              ((FrameLayout.LayoutParams)localObject).width = -1;
              localbfvi.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            localbfvi.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        else
        {
          label547:
          localView.setTag(localakeh);
          localView.setId(i);
          if (paramViewGroup == null) {
            break label682;
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
          if ((j == 2) || ((localakeh.jdField_b_of_type_JavaLangString != null) && (new File(localakeh.jdField_b_of_type_JavaLangString).exists())))
          {
            localObject = localakeh.jdField_b_of_type_JavaLangString;
            break label358;
          }
          if (j != 3) {
            break label358;
          }
          localObject = bfpi.b(bfpi.a(localakeh.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0));
          break label358;
          label661:
          if (localbfvi.jdField_a_of_type_AndroidViewView == null) {
            break label547;
          }
          localbfvi.jdField_a_of_type_AndroidViewView.setVisibility(8);
          break label547;
          label682:
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