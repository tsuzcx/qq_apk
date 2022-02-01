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
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
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
  public static String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvatarGridAdapter";
  }
  
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
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    paramString1 = (Activity)paramWeakReference.get();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramString2 = paramString1.getResources();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = paramString2.getDimensionPixelSize(2131298126);
    this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
    this.jdField_c_of_type_Int = TroopPhotoUtil.a(this.jdField_b_of_type_Int);
    paramGridView.setColumnWidth(this.jdField_b_of_type_Int);
    paramGridView.setVerticalSpacing(i);
    paramGridView.setHorizontalSpacing(i);
    paramGridView.setAdapter(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public int a(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131298126);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298129) * 2 - i * 3) / 4;
  }
  
  public Rect a(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    Rect localRect = new Rect();
    if (localAvatarInfo != null) {
      TroopPhotoUtil.a(localRect, localAvatarInfo.jdField_d_of_type_JavaLangString);
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
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.getNumColumns())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.getRequestedColumnWidth() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.getVerticalSpacing() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label123;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label141;
      }
    }
    label141:
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if ((localActivity == null) || (Thread.currentThread() == localActivity.getMainLooper().getThread())) {
        break label155;
      }
      localActivity.runOnUiThread(new AvatarGridAdapter.1(this, paramInt, localLayoutParams));
      return;
      label123:
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break;
      }
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      break;
    }
    label155:
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
    this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof AvatarGridAdapter.ViewHolder)))
      {
        localObject = (AvatarGridAdapter.ViewHolder)localObject;
        if (((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.equals(paramAvatarInfo))
        {
          if (paramAvatarInfo.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((AvatarGridAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramUploadState.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(AvatarGridAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166556));
      ImageView localImageView = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
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
    }
    label135:
    do
    {
      do
      {
        do
        {
          return;
          localBorderURLImageView.setBorderWidth(0);
          break;
        } while (paramString == null);
        paramViewHolder = TroopPhotoUtil.a(paramString);
      } while (paramViewHolder == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      paramViewHolder = URLDrawable.getDrawable(paramViewHolder, paramContext);
      paramContext = a(paramInt2);
      paramViewHolder.setTag(URLDrawableDecodeHandler.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.y);
      if (this.f) {
        paramViewHolder.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(paramViewHolder);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
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
    int j = 4;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (i < 4) {
        j = i;
      }
      a(j);
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Object localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localObject1 = null)
    {
      View localView = paramView;
      if (paramView == null)
      {
        if (localObject1 == null)
        {
          localView = paramView;
          localObject1 = paramView;
          paramView = localView;
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
        }
        localView = LayoutInflater.from((Context)localObject1).inflate(2131559990, null);
      }
      AvatarInfo localAvatarInfo = a(paramInt);
      int i;
      Object localObject3;
      if (localAvatarInfo != null)
      {
        i = localAvatarInfo.jdField_b_of_type_Int;
        localObject3 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if (i != 4) {
          break label458;
        }
        paramView = (View)localObject2;
        label113:
        if (localView.getTag() != null) {
          break label641;
        }
        localObject3 = new AvatarGridAdapter.ViewHolder(this);
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362156));
        ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131368832));
        if (localObject1 == null) {}
      }
      for (;;)
      {
        try
        {
          ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(((Activity)localObject1).getResources().getDrawable(2130843918));
          ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)localView.findViewById(2131368754));
          localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null)
          {
            localObject2 = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            ((AvatarGridAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo = localAvatarInfo;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localView.setTag(localObject3);
            localObject2 = localObject3;
            if (localObject1 != null)
            {
              localView.setContentDescription(HardCodeUtil.a(2131700942) + paramInt);
              if (i == 4) {
                localView.setContentDescription(HardCodeUtil.a(2131700941));
              }
              a((AvatarGridAdapter.ViewHolder)localObject2, (Context)localObject1, i, paramView, paramInt, localAvatarInfo.jdField_d_of_type_Boolean);
            }
            paramView = ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localAvatarInfo.jdField_a_of_type_Boolean) {
              break label661;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localAvatarInfo.jdField_c_of_type_Int);
            paramView.setProgress(100);
            if (!localAvatarInfo.jdField_c_of_type_Boolean) {
              break label670;
            }
            if (((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView == null)
            {
              ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131381153)).inflate();
              localView.setTag(localObject2);
            }
            ((AvatarGridAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label691;
            }
            localView.setVisibility(8);
            paramView = localView;
            localObject1 = localView;
            break;
            label458:
            if ((i == 1) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              break label113;
            }
            if ((i == 2) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localAvatarInfo.jdField_b_of_type_JavaLangString;
              break label113;
            }
            paramView = (View)localObject2;
            if (i != 3) {
              break label113;
            }
            paramView = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError, new Object[0]);
          continue;
          localOutOfMemoryError.height = this.jdField_c_of_type_Int;
          localOutOfMemoryError.width = this.jdField_b_of_type_Int;
          continue;
        }
        label641:
        AvatarGridAdapter.ViewHolder localViewHolder = (AvatarGridAdapter.ViewHolder)localView.getTag();
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo = localAvatarInfo;
        continue;
        label661:
        paramView.setVisibility(8);
        continue;
        label670:
        if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          continue;
          label691:
          localView.setVisibility(0);
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarGridAdapter
 * JD-Core Version:    0.7.0.1
 */