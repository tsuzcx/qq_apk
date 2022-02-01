package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TroopAvatarWallGalleryAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  Context a;
  Gallery b;
  String c;
  Setting d;
  int e;
  QQAppInterface f;
  boolean g = false;
  String h = null;
  boolean i = true;
  boolean j = true;
  boolean k = false;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  boolean p = false;
  protected Bitmap q = null;
  protected IFaceDecoder r;
  protected boolean s;
  protected List<AvatarInfo> t = new ArrayList(7);
  
  public TroopAvatarWallGalleryAdapter(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Gallery paramGallery)
  {
    this.f = paramQQAppInterface;
    this.a = paramContext;
    this.c = paramString;
    this.b = paramGallery;
    this.e = ((int)paramContext.getResources().getDimension(2131298203));
    this.l = paramInt1;
    this.m = paramInt2;
    this.r = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.r.setDecodeTaskCompletionListener(this);
    this.s = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public AvatarInfo a(int paramInt)
  {
    if ((this.t != null) && (paramInt < getCount())) {
      return (AvatarInfo)this.t.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.r.destory();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void a(int paramInt, TroopAvatarWallGalleryAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.f == null) {
        return;
      }
      URLImageView localURLImageView = paramViewHolder.a;
      ImageProgressCircle localImageProgressCircle = paramViewHolder.b;
      paramViewHolder = c(paramInt);
      Rect localRect = b(paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadBigImage loadThumbImage() path = ");
        ((StringBuilder)localObject).append(paramViewHolder);
        QLog.i("TroopAvatarWallGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      }
      if (TextUtils.isEmpty(paramViewHolder)) {
        return;
      }
      paramViewHolder = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(paramViewHolder);
      if (paramViewHolder == null) {
        return;
      }
      Object localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((AvatarInfo)localObject).d;
      Setting localSetting = this.d;
      if (((localSetting == null) || (localSetting.bHeadType == 0)) && (AvatarInfo.a.equals(localObject)) && (!this.p))
      {
        this.p = true;
        if (!this.r.isPausing()) {
          this.r.requestDecodeFace(this.c, 4, true);
        }
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      if ((this.k) && (this.j))
      {
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.setTag(URLDrawableDecodeHandler.a(localRect.left, localRect.top, localRect.width(), localRect.height(), this.l, this.m));
        paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.x);
      }
      else if (!this.j)
      {
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramInt = Math.min(this.n, this.o);
        if (SimpleUIUtil.e())
        {
          paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.j);
          paramViewHolder.setTag(new int[] { paramInt, paramInt, (int)(paramInt * 0.07142858F) });
        }
        else
        {
          paramViewHolder.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
          paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.c);
        }
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
      else
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.l;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.m;
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.setDecodeHandler(null);
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
      if (this.s) {
        paramViewHolder.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localURLImageView.setImageDrawable(paramViewHolder);
      if (paramViewHolder.getStatus() != 1)
      {
        if (localImageProgressCircle.getVisibility() != 0) {
          localImageProgressCircle.setVisibility(0);
        }
        localImageProgressCircle.setProgress(0);
        localURLImageView.setURLDrawableDownListener(new TroopAvatarWallGalleryAdapter.1(this, localImageProgressCircle, localURLImageView));
        return;
      }
      a(localImageProgressCircle);
    }
  }
  
  public void a(Setting paramSetting)
  {
    this.d = paramSetting;
    notifyDataSetChanged();
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    int i1 = 0;
    while (i1 < this.b.getChildCount())
    {
      Object localObject = this.b.getChildAt(i1).getTag();
      if ((localObject != null) && ((localObject instanceof AvatarGridAdapter.ViewHolder)))
      {
        localObject = (TroopAvatarWallGalleryAdapter.ViewHolder)localObject;
        if (((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).c.equals(paramAvatarInfo)) {
          if (!paramAvatarInfo.g) {
            ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).b.setVisibility(8);
          } else {
            ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).b.setProgress(paramUploadState.b);
          }
        }
      }
      i1 += 1;
    }
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 4) {
      paramImageProgressCircle.setVisibility(4);
    }
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(List<AvatarInfo> paramList)
  {
    if (AvatarInfo.a(paramList, this.t))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.t.clear();
    this.t.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
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
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String c(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    String str = null;
    if (localAvatarInfo == null) {
      return null;
    }
    Object localObject = localAvatarInfo.d;
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(localAvatarInfo.c))) {
      return null;
    }
    if (this.g) {
      return localObject;
    }
    localObject = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((localAvatarInfo.e == 1) && ((localAvatarInfo.c == null) || (!new File(localAvatarInfo.c).exists()))) {
      return ((ITroopAvatarUtilApi)localObject).getArtWork(((ITroopAvatarUtilApi)localObject).getAvatarAddress(localAvatarInfo.d, this.c, 1));
    }
    if ((localAvatarInfo.e != 2) && ((localAvatarInfo.c == null) || (!new File(localAvatarInfo.c).exists())))
    {
      if (localAvatarInfo.e == 3) {
        return ((ITroopAvatarUtilApi)localObject).getArtWork(((ITroopAvatarUtilApi)localObject).getAvatarAddress(localAvatarInfo.d, this.c, 0));
      }
    }
    else {
      str = localAvatarInfo.c;
    }
    return str;
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public int getCount()
  {
    List localList = this.t;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629557, null);
      localObject = new TroopAvatarWallGalleryAdapter.ViewHolder(this);
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).a = ((URLImageView)paramView.findViewById(2131435357));
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).a.setLayoutParams(new RelativeLayout.LayoutParams(this.l, this.m));
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).b = ((ImageProgressCircle)paramView.findViewById(2131435466));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (TroopAvatarWallGalleryAdapter.ViewHolder)paramView.getTag();
    }
    a(paramInt, (TroopAvatarWallGalleryAdapter.ViewHolder)localObject);
    ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).c = a(paramInt);
    Object localObject = ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912483));
    localStringBuilder.append(paramInt + 1);
    ((URLImageView)localObject).setContentDescription(localStringBuilder.toString());
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */