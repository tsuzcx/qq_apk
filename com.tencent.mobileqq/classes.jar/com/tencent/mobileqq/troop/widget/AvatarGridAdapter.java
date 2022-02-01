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
  public static String b = "AvatarGridAdapter";
  protected Handler a = new Handler(Looper.getMainLooper());
  protected WeakReference<Activity> c;
  protected List<AvatarInfo> d = new ArrayList(8);
  protected int e;
  protected boolean f = false;
  protected boolean g = true;
  public boolean h = false;
  protected QQAppInterface i;
  protected String j;
  protected int k;
  protected int l;
  protected boolean m;
  protected boolean n = false;
  protected String o;
  protected IFaceDecoder p = null;
  protected GridView q = null;
  protected boolean r;
  
  public AvatarGridAdapter(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    this.c = paramWeakReference;
    this.q = paramGridView;
    this.i = paramQQAppInterface;
    this.j = paramString1;
    this.o = paramString2;
    this.m = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference != null) && (paramWeakReference.get() != null) && (paramQQAppInterface != null))
    {
      paramString1 = (Activity)paramWeakReference.get();
      this.p = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.p.setDecodeTaskCompletionListener(this);
      paramString2 = paramString1.getResources();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i1 = paramString2.getDimensionPixelSize(2131298796);
      this.k = a((Activity)paramWeakReference.get());
      this.l = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(this.k);
      paramGridView.setColumnWidth(this.k);
      paramGridView.setVerticalSpacing(i1);
      paramGridView.setHorizontalSpacing(i1);
      paramGridView.setAdapter(this);
      this.r = ThemeUtil.isInNightMode(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(b, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
  }
  
  public int a(Activity paramActivity)
  {
    int i1 = paramActivity.getResources().getDimensionPixelSize(2131298796);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.c.get()).getResources().getDimensionPixelSize(2131298799) * 2 - i1 * 3) / 4;
  }
  
  public AvatarInfo a(int paramInt)
  {
    if ((this.d != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AvatarInfo)this.d.get(paramInt);
    }
    return null;
  }
  
  protected void a()
  {
    if ((this.h) && (this.d.size() >= 0) && (this.d.size() < 7))
    {
      AvatarInfo localAvatarInfo = new AvatarInfo();
      localAvatarInfo.e = 4;
      this.d.add(localAvatarInfo);
    }
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    int i1 = 0;
    while (i1 < this.q.getChildCount())
    {
      Object localObject = this.q.getChildAt(i1).getTag();
      if ((localObject != null) && ((localObject instanceof AvatarGridAdapter.ViewHolder)))
      {
        localObject = (AvatarGridAdapter.ViewHolder)localObject;
        if (((AvatarGridAdapter.ViewHolder)localObject).e.equals(paramAvatarInfo)) {
          if (!paramAvatarInfo.g) {
            ((AvatarGridAdapter.ViewHolder)localObject).b.setVisibility(8);
          } else {
            ((AvatarGridAdapter.ViewHolder)localObject).b.setProgress(paramUploadState.b);
          }
        }
      }
      i1 += 1;
    }
  }
  
  protected void a(AvatarGridAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = paramViewHolder.c;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131167490));
    }
    else
    {
      localBorderURLImageView.setBorderWidth(0);
    }
    ImageView localImageView = paramViewHolder.a;
    localImageView.setVisibility(8);
    if (paramInt1 == 4)
    {
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      paramViewHolder = paramContext;
      if (paramContext == null) {
        paramViewHolder = new FrameLayout.LayoutParams(this.k, this.l);
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
      paramContext = b(paramInt2);
      paramViewHolder.setTag(URLDrawableDecodeHandler.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.k, this.l));
      paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.x);
      if (this.r) {
        paramViewHolder.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(paramViewHolder);
      if (QLog.isColorLevel())
      {
        paramViewHolder = b;
        paramContext = new StringBuilder();
        paramContext.append("viewFactory: FROM_OTHERS, path=");
        paramContext.append(paramString);
        QLog.i(paramViewHolder, 2, String.format(paramContext.toString(), new Object[0]));
      }
    }
  }
  
  public void a(List<AvatarInfo> paramList)
  {
    if (this.n) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, String.format("updateDataSet %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.d.clear();
    this.d.addAll(paramList);
    a();
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public Rect b(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    Rect localRect = new Rect();
    if (localAvatarInfo != null) {
      ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect(localRect, localAvatarInfo.l);
    }
    return localRect;
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.q.getNumColumns())
    {
      ViewGroup.LayoutParams localLayoutParams = this.q.getLayoutParams();
      localLayoutParams.width = (this.q.getRequestedColumnWidth() * paramInt + (paramInt - 1) * this.q.getVerticalSpacing() + this.q.getPaddingLeft() + this.q.getPaddingRight());
      localLayoutParams.height = -2;
      if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      } else if ((localLayoutParams instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      }
      Object localObject = this.c;
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
      this.q.setNumColumns(paramInt);
      this.q.setLayoutParams(localLayoutParams);
    }
  }
  
  public int getCount()
  {
    List localList = this.d;
    int i1;
    if (localList != null) {
      i1 = localList.size();
    } else {
      i1 = 0;
    }
    int i2 = 4;
    if (i1 < 4) {
      i2 = i1;
    }
    c(i2);
    return i1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.c;
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
      localObject1 = LayoutInflater.from(localActivity).inflate(2131625904, null);
    }
    else
    {
      localObject1 = paramView;
    }
    AvatarInfo localAvatarInfo = a(paramInt);
    paramView = (View)localObject1;
    if (localAvatarInfo != null)
    {
      int i1 = localAvatarInfo.e;
      paramView = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      if (i1 != 4)
      {
        if ((i1 == 1) && ((localAvatarInfo.c == null) || (!new File(localAvatarInfo.c).exists())))
        {
          paramView = paramView.getArtWork(paramView.getAvatarAddress(localAvatarInfo.d, this.j, 1));
          break label236;
        }
        if ((i1 == 2) || ((localAvatarInfo.c != null) && (new File(localAvatarInfo.c).exists()))) {
          break label230;
        }
        if (i1 == 3)
        {
          paramView = paramView.getArtWork(paramView.getAvatarAddress(localAvatarInfo.d, this.j, 0));
          break label236;
        }
      }
      paramView = null;
      break label236;
      label230:
      paramView = localAvatarInfo.c;
      label236:
      Object localObject3;
      Object localObject2;
      if (((View)localObject1).getTag() == null)
      {
        localObject3 = new AvatarGridAdapter.ViewHolder(this);
        ((AvatarGridAdapter.ViewHolder)localObject3).a = ((ImageView)((View)localObject1).findViewById(2131427763));
        ((AvatarGridAdapter.ViewHolder)localObject3).b = ((ProgressBar)((View)localObject1).findViewById(2131435466));
        if (localActivity != null) {
          try
          {
            ((AvatarGridAdapter.ViewHolder)localObject3).b.setProgressDrawable(localActivity.getResources().getDrawable(2130844792));
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.e(b, 2, localOutOfMemoryError, new Object[0]);
            }
          }
        }
        ((AvatarGridAdapter.ViewHolder)localObject3).c = ((BorderURLImageView)((View)localObject1).findViewById(2131435388));
        localObject2 = (AbsListView.LayoutParams)((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject2 = new AbsListView.LayoutParams(this.k, this.l);
        }
        else
        {
          ((AbsListView.LayoutParams)localObject2).height = this.l;
          ((AbsListView.LayoutParams)localObject2).width = this.k;
        }
        ((AvatarGridAdapter.ViewHolder)localObject3).e = localAvatarInfo;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setTag(localObject3);
        localObject2 = localObject3;
      }
      else
      {
        localObject2 = (AvatarGridAdapter.ViewHolder)((View)localObject1).getTag();
        ((AvatarGridAdapter.ViewHolder)localObject2).e = localAvatarInfo;
      }
      if (localActivity != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131899105));
        ((StringBuilder)localObject3).append(paramInt);
        ((View)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
        if (i1 == 4) {
          ((View)localObject1).setContentDescription(HardCodeUtil.a(2131899104));
        }
        a((AvatarGridAdapter.ViewHolder)localObject2, localActivity, i1, paramView, paramInt, localAvatarInfo.k);
      }
      paramView = ((AvatarGridAdapter.ViewHolder)localObject2).b;
      if (localAvatarInfo.g)
      {
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
        paramView.setProgress(localAvatarInfo.f);
        paramView.setProgress(100);
      }
      else
      {
        paramView.setVisibility(8);
      }
      if (localAvatarInfo.j)
      {
        if (((AvatarGridAdapter.ViewHolder)localObject2).d == null)
        {
          ((AvatarGridAdapter.ViewHolder)localObject2).d = ((ViewStub)((View)localObject1).findViewById(2131449361)).inflate();
          ((View)localObject1).setTag(localObject2);
        }
        ((AvatarGridAdapter.ViewHolder)localObject2).d.setVisibility(0);
      }
      else if (((AvatarGridAdapter.ViewHolder)localObject2).d != null)
      {
        ((AvatarGridAdapter.ViewHolder)localObject2).d.setVisibility(8);
      }
      if ((this.f) && (paramInt == this.e) && (!this.g))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarGridAdapter
 * JD-Core Version:    0.7.0.1
 */