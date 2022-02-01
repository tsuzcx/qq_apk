package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class AvatarGridAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  public static String a = "AvatarGridAdapter";
  protected int a;
  protected Handler a;
  protected QQAppInterface a;
  protected IFaceDecoder a;
  protected GridView a;
  protected List<AvatarInfo> a;
  protected WeakReference<Activity> a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  public boolean c;
  protected boolean d;
  protected boolean e = false;
  protected boolean f;
  
  public AvatarGridAdapter(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    this.jdField_a_of_type_ComTencentWidgetGridView = null;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Boolean = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference != null) && (paramWeakReference.get() != null) && (paramQQAppInterface != null))
    {
      paramString1 = (Activity)paramWeakReference.get();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      paramString2 = paramString1.getResources();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = paramString2.getDimensionPixelSize(2131298120);
      this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
      this.jdField_c_of_type_Int = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(this.jdField_b_of_type_Int);
      paramGridView.setColumnWidth(this.jdField_b_of_type_Int);
      paramGridView.setVerticalSpacing(i);
      paramGridView.setHorizontalSpacing(i);
      paramGridView.setAdapter(this);
      this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
  }
  
  public int a(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131298120);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298123) * 2 - i * 3) / 4;
  }
  
  public Rect a(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    Rect localRect = new Rect();
    if (localAvatarInfo != null) {
      ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect(localRect, localAvatarInfo.jdField_d_of_type_JavaLangString);
    }
    return localRect;
  }
  
  public AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  protected void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < 7))
    {
      AvatarInfo localAvatarInfo = new AvatarInfo();
      localAvatarInfo.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.getNumColumns())
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.getRequestedColumnWidth() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.getVerticalSpacing() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      } else if ((localLayoutParams instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      }
      Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (Activity)((WeakReference)localObject).get();
      }
      if ((localObject != null) && (Thread.currentThread() != ((Activity)localObject).getMainLooper().getThread()))
      {
        ((Activity)localObject).runOnUiThread(new AvatarGridAdapter.1(this, paramInt, localLayoutParams));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof AvatarGridAdapter.ViewHolder)))
      {
        localObject = (AvatarGridAdapter.ViewHolder)localObject;
        if (((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo.equals(paramAvatarInfo)) {
          if (!paramAvatarInfo.jdField_a_of_type_Boolean) {
            ((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          } else {
            ((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramUploadState.jdField_b_of_type_Int);
          }
        }
      }
      i += 1;
    }
  }
  
  protected void a(AvatarGridAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166570));
    }
    else
    {
      localBorderURLImageView.setBorderWidth(0);
    }
    ImageView localImageView = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    localImageView.setVisibility(8);
    if (paramInt1 == 4)
    {
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      paramViewHolder = paramContext;
      if (paramContext == null) {
        paramViewHolder = new FrameLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      paramViewHolder.gravity = 17;
      localImageView.setLayoutParams(paramViewHolder);
      localImageView.setVisibility(0);
      return;
    }
    if (paramString != null)
    {
      paramViewHolder = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(paramString);
      if (paramViewHolder == null) {
        return;
      }
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      paramViewHolder = URLDrawable.getDrawable(paramViewHolder, paramContext);
      paramContext = a(paramInt2);
      paramViewHolder.setTag(URLDrawableDecodeHandler.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.w);
      if (this.f) {
        paramViewHolder.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(paramViewHolder);
      if (QLog.isColorLevel())
      {
        paramViewHolder = jdField_a_of_type_JavaLangString;
        paramContext = new StringBuilder();
        paramContext.append("viewFactory: FROM_OTHERS, path=");
        paramContext.append(paramString);
        QLog.i(paramViewHolder, 2, String.format(paramContext.toString(), new Object[0]));
      }
    }
  }
  
  public void a(List<AvatarInfo> paramList)
  {
    if (this.e) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("updateDataSet %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    int j = 4;
    if (i < 4) {
      j = i;
    }
    a(j);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
    Activity localActivity;
    if (localObject1 != null) {
      localActivity = (Activity)((WeakReference)localObject1).get();
    } else {
      localActivity = null;
    }
    if (paramView == null)
    {
      if (localActivity == null) {
        break label691;
      }
      localObject1 = LayoutInflater.from(localActivity).inflate(2131559861, null);
    }
    else
    {
      localObject1 = paramView;
    }
    AvatarInfo localAvatarInfo = a(paramInt);
    paramView = (View)localObject1;
    if (localAvatarInfo != null)
    {
      int i = localAvatarInfo.jdField_b_of_type_Int;
      paramView = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      if (i != 4)
      {
        if ((i == 1) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
        {
          paramView = paramView.getArtWork(paramView.getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
          break label236;
        }
        if ((i == 2) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists()))) {
          break label230;
        }
        if (i == 3)
        {
          paramView = paramView.getArtWork(paramView.getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
          break label236;
        }
      }
      paramView = null;
      break label236;
      label230:
      paramView = localAvatarInfo.jdField_b_of_type_JavaLangString;
      label236:
      Object localObject3;
      Object localObject2;
      if (((View)localObject1).getTag() == null)
      {
        localObject3 = new AvatarGridAdapter.ViewHolder(this);
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131362182));
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131368560));
        if (localActivity != null) {
          try
          {
            ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localActivity.getResources().getDrawable(2130843838));
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError, new Object[0]);
            }
          }
        }
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)((View)localObject1).findViewById(2131368486));
        localObject2 = (AbsListView.LayoutParams)((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject2 = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        }
        else
        {
          ((AbsListView.LayoutParams)localObject2).height = this.jdField_c_of_type_Int;
          ((AbsListView.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
        }
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo = localAvatarInfo;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setTag(localObject3);
        localObject2 = localObject3;
      }
      else
      {
        localObject2 = (AvatarGridAdapter.ViewHolder)((View)localObject1).getTag();
        ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo = localAvatarInfo;
      }
      if (localActivity != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131701085));
        ((StringBuilder)localObject3).append(paramInt);
        ((View)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
        if (i == 4) {
          ((View)localObject1).setContentDescription(HardCodeUtil.a(2131701084));
        }
        a((AvatarGridAdapter.ViewHolder)localObject2, localActivity, i, paramView, paramInt, localAvatarInfo.jdField_d_of_type_Boolean);
      }
      paramView = ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar;
      if (localAvatarInfo.jdField_a_of_type_Boolean)
      {
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
        paramView.setProgress(localAvatarInfo.jdField_c_of_type_Int);
        paramView.setProgress(100);
      }
      else
      {
        paramView.setVisibility(8);
      }
      if (localAvatarInfo.jdField_c_of_type_Boolean)
      {
        if (((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView == null)
        {
          ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = ((ViewStub)((View)localObject1).findViewById(2131380410)).inflate();
          ((View)localObject1).setTag(localObject2);
        }
        ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      else if (((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView != null)
      {
        ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_Int) && (!this.jdField_b_of_type_Boolean))
      {
        ((View)localObject1).setVisibility(8);
        paramView = (View)localObject1;
      }
      else
      {
        ((View)localObject1).setVisibility(0);
        paramView = (View)localObject1;
      }
    }
    label691:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarGridAdapter
 * JD-Core Version:    0.7.0.1
 */