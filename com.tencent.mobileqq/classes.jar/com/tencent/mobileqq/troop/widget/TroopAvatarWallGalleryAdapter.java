package com.tencent.mobileqq.troop.widget;

import ajfa;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class TroopAvatarWallGalleryAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting = null;
  String jdField_a_of_type_JavaLangString;
  protected List a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = true;
  protected int c;
  
  public TroopAvatarWallGalleryAdapter(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131558493));
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, TroopAvatarWallGalleryAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    do
    {
      do
      {
        return;
        localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
        localImageProgressCircle = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
        paramViewHolder = b(paramInt);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarWallGalleryAdapter", 2, "loadThumbImage() path = " + paramViewHolder);
        }
      } while (TextUtils.isEmpty(paramViewHolder));
      localObject = Uri.parse(paramViewHolder).getScheme();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))) {}
      for (;;)
      {
        try
        {
          paramViewHolder = new File(paramViewHolder).toURL();
          localObject = a(paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType != 0)) || (!((String)localObject).equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString))) {
            break label210;
          }
          localURLImageView.setImageResource(2130840537);
          return;
        }
        catch (MalformedURLException paramViewHolder) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarWallGalleryAdapter", 2, paramViewHolder.toString());
        return;
        try
        {
          paramViewHolder = NearbyImgDownloader.a(paramViewHolder);
        }
        catch (MalformedURLException paramViewHolder) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAvatarWallGalleryAdapter", 2, paramViewHolder.toString());
    return;
    label210:
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.c;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
    if (this.jdField_b_of_type_Boolean) {
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    }
    localURLImageView.setImageDrawable(URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject));
    a(localImageProgressCircle);
    localURLImageView.setURLDrawableDownListener(new ajfa(this, localImageProgressCircle, localURLImageView));
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
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public String b(int paramInt)
  {
    String str2 = a(paramInt);
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (this.jdField_a_of_type_Boolean);
      str1 = str2;
    } while (!AvatarTroopUtil.b(str2));
    if (str2.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)) {}
    for (String str1 = AvatarTroopUtil.a(str2, this.jdField_a_of_type_JavaLangString, 0);; str1 = AvatarTroopUtil.a(str2, this.jdField_a_of_type_JavaLangString, 1)) {
      return AvatarTroopUtil.b(str1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971612, null);
      paramView = new TroopAvatarWallGalleryAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131361846));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.c));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131361845));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramInt, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription("大图预览" + (paramInt + 1));
      return localView;
      paramViewGroup = (TroopAvatarWallGalleryAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */