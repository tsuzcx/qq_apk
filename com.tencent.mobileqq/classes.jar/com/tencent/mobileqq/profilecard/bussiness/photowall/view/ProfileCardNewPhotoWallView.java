package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProfileCardNewPhotoWallView
  extends LinearLayout
{
  private static final String TAG = "ProfileCardNewPhotoWallView";
  private Context ctx;
  protected int height;
  Activity mActivity;
  AppInterface mApp;
  private boolean mCancelRespond = false;
  protected Drawable mDefaultD;
  protected LayoutInflater mLayoutInflater;
  protected int mMargin;
  protected LinkedList<ProfilePhotoWall> mPhotoList;
  ArrayList<Integer> mPreviewPhotoLocation;
  private float mScale;
  private int mThumbmScale;
  String mUin;
  protected int width;
  
  public ProfileCardNewPhotoWallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardNewPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ctx = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    init();
  }
  
  private URL getImageViewUrl(int paramInt, ProfilePhotoWall paramProfilePhotoWall, URL paramURL)
  {
    URL localURL2;
    try
    {
      int i = this.mPhotoList.size();
      if (((i != 1) && (i != 4) && (i != 7)) || ((paramInt != 0) && (((i != 2) && (i != 5) && (i != 8)) || ((paramInt != 0) && (paramInt != 1) && (((i != 3) && (i != 6) && (i != 9)) || (paramInt != 0))))))
      {
        localURL3 = new URL("qzone_cover", "original", paramProfilePhotoWall.getThumbUrl(this.mThumbmScale));
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL = localURL3;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          return paramURL;
        }
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL = new StringBuilder();
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL.append("url = ");
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL.append(localURL3);
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL.append(" profilePhotoWall.getThumbUrl() = ");
        localURL1 = localURL3;
        localURL2 = localURL3;
        paramURL.append(paramProfilePhotoWall.getThumbUrl(this.mThumbmScale));
        localURL1 = localURL3;
        localURL2 = localURL3;
        QLog.d("ProfileCardNewPhotoWallView", 2, paramURL.toString());
        return localURL3;
      }
      catch (Exception paramProfilePhotoWall) {}catch (MalformedURLException paramProfilePhotoWall)
      {
        break label399;
      }
      URL localURL3 = new URL("qzone_cover", "original", paramProfilePhotoWall.getOriginUrl());
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL = localURL3;
      if (!QLog.isColorLevel()) {
        return paramURL;
      }
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL = new StringBuilder();
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL.append("url = ");
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL.append(localURL3);
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL.append(" profilePhotoWall.getOriginUrl() = ");
      localURL1 = localURL3;
      localURL2 = localURL3;
      paramURL.append(paramProfilePhotoWall.getOriginUrl());
      localURL1 = localURL3;
      localURL2 = localURL3;
      QLog.d("ProfileCardNewPhotoWallView", 2, paramURL.toString());
      return localURL3;
    }
    catch (Exception paramProfilePhotoWall)
    {
      URL localURL1 = paramURL;
      paramURL = localURL1;
      if (!QLog.isColorLevel()) {
        return paramURL;
      }
      QLog.i("Q.qzonecover.", 2, paramProfilePhotoWall.toString());
      return localURL1;
    }
    catch (MalformedURLException paramProfilePhotoWall)
    {
      localURL2 = paramURL;
    }
    label399:
    paramURL = localURL2;
    if (QLog.isColorLevel())
    {
      QLog.i("Q.qzonecover.", 2, paramProfilePhotoWall.toString());
      paramURL = localURL2;
    }
    return paramURL;
  }
  
  private void init()
  {
    int i = getResources().getDimensionPixelSize(2131297593);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mScale = localDisplayMetrics.density;
    this.width = (localDisplayMetrics.widthPixels - i * 2);
    this.height = localDisplayMetrics.heightPixels;
    this.mMargin = ((int)(this.mScale * 2.0F + 0.5F));
    i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i <= 240) {
      this.mThumbmScale = 60;
    } else if (i <= 320) {
      this.mThumbmScale = 100;
    } else {
      this.mThumbmScale = 160;
    }
    setOrientation(1);
  }
  
  private void setNightMode(URLImageView paramURLImageView)
  {
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isInNightMode(this.mApp))
    {
      paramURLImageView.setColorFilter(1996488704);
      return;
    }
    paramURLImageView.setColorFilter(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.mCancelRespond) {
      bool = false;
    }
    return bool;
  }
  
  public void genImg(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    this.mPhotoList = paramLinkedList;
    int i = 0;
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt > 3)
    {
      j = paramInt - 3;
      genImg(paramLinkedList, j);
      int k = (this.width - this.mMargin * 2) / 3;
      paramLinkedList = new LinearLayout(this.ctx);
      paramLinkedList.setOrientation(0);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.mMargin;
      while (i < 3)
      {
        localObject2 = getImageView(k, k, j + i);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        if (i != paramInt - 1) {
          ((LinearLayout.LayoutParams)localObject3).rightMargin = this.mMargin;
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramLinkedList.addView((View)localObject2);
        i += 1;
      }
      paramLinkedList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView(paramLinkedList);
      return;
    }
    paramLinkedList = new LinearLayout(this.ctx);
    paramLinkedList.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramLinkedList.setOrientation(0);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          i = this.width;
          paramInt = this.mMargin;
          i = (i - paramInt) * 2 / 3;
          j = i / 2;
          paramInt = (i - paramInt) / 2;
          localObject1 = getImageView(i, i, 0);
          localObject2 = new LinearLayout(this.ctx);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).setMargins(this.mMargin, 0, 0, 0);
          ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((LinearLayout)localObject2).setOrientation(1);
          localObject3 = getImageView(j, paramInt, 1);
          ViewGroup localViewGroup = getImageView(j, paramInt, 2);
          ((LinearLayout.LayoutParams)localViewGroup.getLayoutParams()).setMargins(0, this.mMargin, 0, 0);
          ((LinearLayout)localObject2).addView((View)localObject3);
          ((LinearLayout)localObject2).addView(localViewGroup);
          paramLinkedList.addView((View)localObject1);
          paramLinkedList.addView((View)localObject2);
        }
      }
      else
      {
        paramInt = (this.width - this.mMargin) / 2;
        localObject1 = getImageView(paramInt, paramInt, 0);
        localObject2 = getImageView(paramInt, paramInt, 1);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).setMargins(this.mMargin, 0, 0, 0);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramLinkedList.addView((View)localObject1);
        paramLinkedList.addView((View)localObject2);
      }
    }
    else
    {
      paramInt = this.width;
      paramLinkedList.addView(getImageView(paramInt, paramInt * 2 / 3, 0));
    }
    removeAllViews();
    addView(paramLinkedList);
  }
  
  public ViewGroup getImageView(int paramInt1, int paramInt2, int paramInt3)
  {
    ProfilePhotoWall localProfilePhotoWall = (ProfilePhotoWall)this.mPhotoList.get(paramInt3);
    Object localObject1 = null;
    Object localObject2 = getImageViewUrl(paramInt3, localProfilePhotoWall, null);
    if (localObject2 != null)
    {
      if (this.mDefaultD == null) {
        this.mDefaultD = getResources().getDrawable(2131166392);
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
      localObject1 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
    }
    localObject2 = (ViewGroup)getImageViewLayout();
    URLImageView localURLImageView = (URLImageView)((ViewGroup)localObject2).findViewById(2131368680);
    View localView = ((ViewGroup)localObject2).findViewById(2131368689);
    setNightMode(localURLImageView);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(855638016));
    localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(0));
    ((ViewGroup)localObject2).setLayoutParams(localLayoutParams);
    localURLImageView.setImageDrawable((Drawable)localObject1);
    localURLImageView.setContentDescription(String.format(HardCodeUtil.a(2131708450), new Object[] { Integer.valueOf(paramInt3 + 1) }));
    localView.setBackgroundDrawable(localStateListDrawable);
    ((ViewGroup)localObject2).setOnClickListener(new ProfileCardNewPhotoWallView.1(this, localProfilePhotoWall, paramInt3, localURLImageView));
    return localObject2;
  }
  
  protected View getImageViewLayout()
  {
    return this.mLayoutInflater.inflate(2131561360, null);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public void preparePhotoWall(String paramString, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.mUin = paramString;
    this.mActivity = paramActivity;
    this.mApp = paramAppInterface;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardNewPhotoWallView
 * JD-Core Version:    0.7.0.1
 */