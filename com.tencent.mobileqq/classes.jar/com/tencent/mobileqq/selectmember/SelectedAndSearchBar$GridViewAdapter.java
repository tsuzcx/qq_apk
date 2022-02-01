package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectedAndSearchBar$GridViewAdapter
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SelectedAndSearchBar$GridViewAdapter(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = SelectedAndSearchBar.a(paramSelectedAndSearchBar).getResources().getDrawable(2130844953);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.f();
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1006) {
      return 11;
    }
    if (paramInt == 1) {
      return 4;
    }
    if (paramInt == 3000) {
      i = 101;
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar) != null) && (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).size() > 0))
      {
        ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).get(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).size() - 1);
        if (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar) != null) {
          SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).a(localResultRecord);
        }
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(false);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      super.notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    Bitmap localBitmap = null;
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar)).inflate(2131559277, null);
    }
    localView.setTag(localResultRecord);
    ImageView localImageView = (ImageView)localView.findViewById(2131366401);
    if (paramInt == getCount() - 1)
    {
      paramView = localBitmap;
      if (this.jdField_a_of_type_Boolean) {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      localImageView.setImageDrawable(paramView);
    }
    else
    {
      localImageView.setImageDrawable(null);
    }
    int i;
    if (localResultRecord.getUinType() == -1) {
      i = localResultRecord.type;
    } else {
      i = a(localResultRecord.getUinType());
    }
    int j;
    if (localResultRecord.type == -1) {
      j = i;
    } else {
      j = localResultRecord.type;
    }
    localResultRecord.type = j;
    if (AppConstants.DATALINE_PC_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130844282);
    }
    else if (AppConstants.DATALINE_IPAD_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130844277);
    }
    else if (AppConstants.DATALINE_PRINTER_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130844285);
    }
    else if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130839566);
    }
    else if (localResultRecord.type == 5)
    {
      localImageView.setImageResource(2130842159);
    }
    else
    {
      String str = localResultRecord.uin;
      localBitmap = SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).getBitmapFromCache(i, str);
      paramView = localBitmap;
      if (localBitmap == null)
      {
        SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).requestDecodeFace(str, i, true);
        paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar).getResources(), paramView));
    }
    if (AppSetting.d) {
      localImageView.setContentDescription(localResultRecord.name);
    }
    if (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar) == 1)
    {
      paramView = (ImageView)localView.findViewById(2131369370);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).updateSelectGradeIcon(paramView, localResultRecord.uin);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */