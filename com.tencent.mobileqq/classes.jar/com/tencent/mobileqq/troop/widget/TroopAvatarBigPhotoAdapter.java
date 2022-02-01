package com.tencent.mobileqq.troop.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TroopAvatarBigPhotoAdapter
  extends BaseAdapter
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting = null;
  String jdField_a_of_type_JavaLangString;
  WeakReference<TextView> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  protected List<String> a;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = null;
  protected List<String> b;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  boolean e;
  
  public TroopAvatarBigPhotoAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297550));
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
    List localList = this.jdField_b_of_type_JavaUtilList;
    return (localList != null) && (localList.size() > paramInt) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilList.get(paramInt))) && (AbsDownloader.getFile((String)this.jdField_b_of_type_JavaUtilList.get(paramInt)) != null);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  void a()
  {
    Object localObject = new int[2];
    int i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(0)).intValue();
    int j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(1)).intValue();
    int k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(2)).intValue();
    int m = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(3)).intValue();
    this.jdField_b_of_type_Int = (i - localObject[0]);
    this.jdField_c_of_type_Int = (j - localObject[1]);
    this.jdField_a_of_type_Float = (k / ViewUtils.a());
    this.jdField_b_of_type_Float = (m / ViewUtils.b());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculateScale()   leftLocation = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" topLocation = ");
      ((StringBuilder)localObject).append(j);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      URLImageView localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      ImageProgressCircle localImageProgressCircle = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
      paramViewHolder = a(paramInt);
      if ((!this.jdField_c_of_type_Boolean) && (!a(paramInt)))
      {
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
      }
      else
      {
        paramViewHolder = (String)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
      }
      if (TextUtils.isEmpty(paramViewHolder)) {
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if (((ITroopAvatarUtilApi)localObject2).isNumeric(paramViewHolder))
        {
          if ((paramViewHolder != null) && (paramViewHolder.equals(AvatarInfo.jdField_a_of_type_JavaLangString))) {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.jdField_a_of_type_JavaLangString, 0);
          } else {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.jdField_a_of_type_JavaLangString, 1);
          }
          localObject1 = ((ITroopAvatarUtilApi)localObject2).getArtWork((String)localObject1);
          break label179;
        }
      }
      Object localObject1 = paramViewHolder;
      label179:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadThumbImage() path = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = Uri.parse((String)localObject1).getScheme();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https")))) {
        try
        {
          if (this.e) {
            localObject1 = new URL("qzone_cover", "original", (String)localObject1);
          } else {
            localObject1 = new URL((String)localObject1);
          }
        }
        catch (MalformedURLException paramViewHolder)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
          }
          return;
        }
      }
      try
      {
        localObject1 = new File((String)localObject1).toURL();
        localObject1 = a((URL)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataSetting;
        if (((localObject2 == null) || (((Setting)localObject2).bHeadType == 0)) && (paramViewHolder != null) && (paramViewHolder.equals(AvatarInfo.jdField_a_of_type_JavaLangString)))
        {
          localURLImageView.setImageResource(2130842585);
          return;
        }
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        paramViewHolder.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
        paramViewHolder.mLoadingDrawable = URLDrawableHelperConstants.a;
        if (this.jdField_b_of_type_Boolean) {
          paramViewHolder.mPlayGifImage = true;
        }
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, paramViewHolder));
        if ((!this.d) && (this.e) && (this.jdField_a_of_type_JavaUtilArrayList != null))
        {
          a(localURLImageView);
          this.d = true;
        }
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("loadBigMap() mWidthScale = ");
          paramViewHolder.append(this.jdField_a_of_type_Float);
          paramViewHolder.append(" mHeightScale = ");
          paramViewHolder.append(this.jdField_b_of_type_Float);
          QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        }
        a(localImageProgressCircle);
        localURLImageView.setURLDrawableDownListener(new TroopAvatarBigPhotoAdapter.1(this, localImageProgressCircle, localURLImageView));
        return;
      }
      catch (MalformedURLException paramViewHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        }
      }
    }
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextView);
  }
  
  void a(URLImageView paramURLImageView)
  {
    a();
    paramURLImageView.setPivotX(0.0F);
    paramURLImageView.setPivotY(0.0F);
    paramURLImageView.setScaleX(this.jdField_a_of_type_Float);
    paramURLImageView.setScaleY(this.jdField_b_of_type_Float);
    paramURLImageView.setTranslationX(this.jdField_b_of_type_Int);
    paramURLImageView.setTranslationY(this.jdField_c_of_type_Int);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterAnimation()   mWidthScale = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
      ((StringBuilder)localObject).append(" mHeightScale = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterAnimation()   mLeftDelta = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" mTopDelta = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new DecelerateInterpolator();
    paramURLImageView.animate().setDuration(200L).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
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
  
  public void a(String paramString, Setting paramSetting)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(List<String> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558894, null);
      paramView = new TroopAvatarBigPhotoAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368461));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368560));
      localView.setTag(paramView);
    }
    else
    {
      TroopAvatarBigPhotoAdapter.ViewHolder localViewHolder = (TroopAvatarBigPhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter
 * JD-Core Version:    0.7.0.1
 */