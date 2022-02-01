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
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  protected Bitmap a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IFaceDecoder a;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  protected List<AvatarInfo> a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = true;
  protected int c;
  boolean c;
  protected int d;
  boolean d;
  protected int e;
  boolean e;
  protected boolean f;
  
  public TroopAvatarWallGalleryAdapter(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Gallery paramGallery)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(7);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297550));
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public Rect a(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    Rect localRect = new Rect();
    if (localAvatarInfo != null) {
      ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect(localRect, localAvatarInfo.d);
    }
    return localRect;
  }
  
  public AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    AvatarInfo localAvatarInfo = a(paramInt);
    String str = null;
    if (localAvatarInfo == null) {
      return null;
    }
    Object localObject = localAvatarInfo.c;
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(localAvatarInfo.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    if (this.jdField_a_of_type_Boolean) {
      return localObject;
    }
    localObject = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((localAvatarInfo.jdField_b_of_type_Int == 1) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists()))) {
      return ((ITroopAvatarUtilApi)localObject).getArtWork(((ITroopAvatarUtilApi)localObject).getAvatarAddress(localAvatarInfo.c, this.jdField_a_of_type_JavaLangString, 1));
    }
    if ((localAvatarInfo.jdField_b_of_type_Int != 2) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
    {
      if (localAvatarInfo.jdField_b_of_type_Int == 3) {
        return ((ITroopAvatarUtilApi)localObject).getArtWork(((ITroopAvatarUtilApi)localObject).getAvatarAddress(localAvatarInfo.c, this.jdField_a_of_type_JavaLangString, 0));
      }
    }
    else {
      str = localAvatarInfo.jdField_b_of_type_JavaLangString;
    }
    return str;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, TroopAvatarWallGalleryAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      URLImageView localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      ImageProgressCircle localImageProgressCircle = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
      paramViewHolder = a(paramInt);
      Rect localRect = a(paramInt);
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
      localObject = ((AvatarInfo)localObject).c;
      Setting localSetting = this.jdField_a_of_type_ComTencentMobileqqDataSetting;
      if (((localSetting == null) || (localSetting.bHeadType == 0)) && (AvatarInfo.jdField_a_of_type_JavaLangString.equals(localObject)) && (!this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_JavaLangString, 4, true);
        }
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
      {
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.setTag(URLDrawableDecodeHandler.a(localRect.left, localRect.top, localRect.width(), localRect.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
        paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.w);
      }
      else if (!this.jdField_c_of_type_Boolean)
      {
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramInt = Math.min(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        if (SimpleUIUtil.a())
        {
          paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.i);
          paramViewHolder.setTag(new int[] { paramInt, paramInt, (int)(paramInt * 0.07142858F) });
        }
        else
        {
          paramViewHolder.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
          paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.b);
        }
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
      else
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_c_of_type_Int;
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.setDecodeHandler(null);
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
      if (this.f) {
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
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
    notifyDataSetChanged();
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof AvatarGridAdapter.ViewHolder)))
      {
        localObject = (TroopAvatarWallGalleryAdapter.ViewHolder)localObject;
        if (((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo.equals(paramAvatarInfo)) {
          if (!paramAvatarInfo.jdField_a_of_type_Boolean) {
            ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(8);
          } else {
            ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(paramUploadState.jdField_b_of_type_Int);
          }
        }
      }
      i += 1;
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
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(List<AvatarInfo> paramList)
  {
    if (AvatarInfo.a(paramList, this.jdField_a_of_type_JavaUtilList))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562949, null);
      localObject = new TroopAvatarWallGalleryAdapter.ViewHolder(this);
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368461));
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131368560));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (TroopAvatarWallGalleryAdapter.ViewHolder)paramView.getTag();
    }
    a(paramInt, (TroopAvatarWallGalleryAdapter.ViewHolder)localObject);
    ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo = a(paramInt);
    Object localObject = ((TroopAvatarWallGalleryAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131714989));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */