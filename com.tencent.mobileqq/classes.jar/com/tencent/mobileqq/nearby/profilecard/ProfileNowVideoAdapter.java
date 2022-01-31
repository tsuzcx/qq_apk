package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ProfileNowVideoAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected GradientDrawable a;
  protected View a;
  protected AutoPlayVideoView a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  protected GradientDrawable b;
  protected boolean b;
  protected int c;
  protected GradientDrawable c;
  
  public void a(ImageView paramImageView, String paramString)
  {
    URLDrawable localURLDrawable = null;
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearbyCard_now_video_cover";
        if (!TextUtils.isEmpty(paramString)) {
          localURLDrawable = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        localURLDrawable.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.g);
        if (localURLDrawable.getStatus() != 2)
        {
          localObject1 = localURLDrawable;
          if (localURLDrawable.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable.restartDownload();
          localObject1 = localURLDrawable;
          if (QLog.isColorLevel())
          {
            QLog.w("ProfileNowVideoAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable;
          }
        }
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject2 = localException2;
        }
      }
      localObject1 = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.w("ProfileNowVideoAdapter", 2, "loadImage empty url");
        localObject1 = localURLDrawable;
        continue;
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
        if (QLog.isColorLevel()) {
          QLog.w("ProfileNowVideoAdapter", 2, "loadImage exp: url=" + paramString + ", " + localException1.toString());
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_Boolean) && (paramInt == getCount() - 1);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ProfileNowVideoAdapter.VideoFeeds localVideoFeeds = (ProfileNowVideoAdapter.VideoFeeds)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970483, paramViewGroup, false);
      paramView = new ProfileNowVideoAdapter.ViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366702));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370798));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364504));
      paramView.c = ((TextView)localView.findViewById(2131370796));
      paramView.d = ((TextView)localView.findViewById(2131370797));
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131370795));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370654);
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131370661);
      if (paramInt == 0)
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          return this.jdField_a_of_type_AndroidViewView;
        }
        paramViewGroup = new AutoPlayVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        paramViewGroup.setCoverUrl(localVideoFeeds.b);
        paramViewGroup.setCorner(this.jdField_c_of_type_Int);
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramViewGroup, 0);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileNowVideoAdapter", 2, "new videoView:" + paramViewGroup.hashCode());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileNowVideoAdapter", 2, "release old videoView:" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView.hashCode());
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView.a();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView.setImageDrawable(null);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView = paramViewGroup;
        this.jdField_a_of_type_AndroidViewView = localView;
        paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
        paramViewGroup.setCoverUrl(localVideoFeeds.b);
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView, localVideoFeeds.b);
      }
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (!this.jdField_a_of_type_Boolean) {
        break label554;
      }
      if (paramInt != getCount() - 1) {
        break label485;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable);
    }
    for (;;)
    {
      paramViewGroup.d.setVisibility(8);
      if (paramInt != 0) {
        break label689;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAutoPlayVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return localView;
      paramViewGroup = (ProfileNowVideoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label485:
      if (paramInt != 0) {
        a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, localVideoFeeds.b);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoFeeds.c);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localVideoFeeds.d);
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    label554:
    if (paramInt != 0) {
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, localVideoFeeds.b);
    }
    if ((this.jdField_b_of_type_Boolean) && (paramInt == getCount() - 1))
    {
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setBackgroundDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableGradientDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.c.setVisibility(8);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoFeeds.c);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localVideoFeeds.d);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    label689:
    if (paramInt == getCount() - 1)
    {
      if (getCount() > 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return localView;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return localView;
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ProfileNowVideoAdapter
 * JD-Core Version:    0.7.0.1
 */