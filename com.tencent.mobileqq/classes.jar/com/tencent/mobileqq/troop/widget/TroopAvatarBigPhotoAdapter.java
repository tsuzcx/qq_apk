package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TroopAvatarBigPhotoAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting = null;
  String jdField_a_of_type_JavaLangString;
  WeakReference<TextView> jdField_a_of_type_JavaLangRefWeakReference = null;
  protected List<String> a;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString = null;
  protected List<String> b;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = false;
  
  public TroopAvatarBigPhotoAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297559));
  }
  
  private URL a(URL paramURL)
  {
    URL localURL = paramURL;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localURL = paramURL;
      if ("2000".equals(this.jdField_b_of_type_JavaLangString))
      {
        localURL = paramURL;
        if (paramURL.getProtocol().startsWith("http"))
        {
          paramURL = paramURL.toString();
          localURL = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramURL, 2);
        }
      }
    }
    return localURL;
  }
  
  private boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > paramInt) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilList.get(paramInt))) && (AbsDownloader.getFile((String)this.jdField_b_of_type_JavaUtilList.get(paramInt)) != null);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    label67:
    Object localObject1;
    label83:
    label217:
    label219:
    do
    {
      return;
      localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      localImageProgressCircle = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
      paramViewHolder = a(paramInt);
      Object localObject2;
      if ((this.c) || (a(paramInt)))
      {
        paramViewHolder = (String)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
        if (TextUtils.isEmpty(paramViewHolder)) {
          break label217;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label219;
        }
        localObject1 = paramViewHolder;
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + (String)localObject1);
        }
        localObject2 = Uri.parse((String)localObject1).getScheme();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https")))) {
          break label320;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new File((String)localObject1).toURL();
          localObject1 = a((URL)localObject1);
          if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType != 0)) || (paramViewHolder == null) || (!paramViewHolder.equals(AvatarInfo.jdField_a_of_type_JavaLangString))) {
            break label350;
          }
          localURLImageView.setImageResource(2130842686);
          return;
        }
        catch (MalformedURLException paramViewHolder) {}
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
        break label67;
        break;
        localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if (((ITroopAvatarUtilApi)localObject2).isNumeric(paramViewHolder))
        {
          if ((paramViewHolder != null) && (paramViewHolder.equals(AvatarInfo.jdField_a_of_type_JavaLangString)))
          {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.jdField_a_of_type_JavaLangString, 0);
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getArtWork((String)localObject1);
            break label83;
          }
          localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.jdField_a_of_type_JavaLangString, 1);
          continue;
        }
        localObject1 = paramViewHolder;
        break label83;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        return;
        try
        {
          localObject1 = new URL((String)localObject1);
        }
        catch (MalformedURLException paramViewHolder) {}
      }
    } while (!QLog.isColorLevel());
    label320:
    QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
    return;
    label350:
    paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
    paramViewHolder.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    paramViewHolder.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    paramViewHolder.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    if (this.jdField_b_of_type_Boolean) {
      paramViewHolder.mPlayGifImage = true;
    }
    localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, paramViewHolder));
    a(localImageProgressCircle);
    localURLImageView.setURLDrawableDownListener(new TroopAvatarBigPhotoAdapter.1(this, localImageProgressCircle, localURLImageView));
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextView);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, Setting paramSetting)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(List<String> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559000, null);
      paramView = new TroopAvatarBigPhotoAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368729));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368832));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      TroopAvatarBigPhotoAdapter.ViewHolder localViewHolder = (TroopAvatarBigPhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter
 * JD-Core Version:    0.7.0.1
 */