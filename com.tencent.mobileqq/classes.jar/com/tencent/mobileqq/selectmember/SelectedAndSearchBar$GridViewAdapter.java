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
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectedAndSearchBar$GridViewAdapter
  extends BaseAdapter
{
  private boolean b = false;
  private Drawable c;
  private Bitmap d;
  
  public SelectedAndSearchBar$GridViewAdapter(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.c = SelectedAndSearchBar.g(paramSelectedAndSearchBar).getResources().getDrawable(2130846389);
    this.d = BaseImageUtil.k();
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
      return 101;
    }
    if (paramInt == 10014) {
      i = 117;
    }
    return i;
  }
  
  public void a()
  {
    if (this.b)
    {
      if ((SelectedAndSearchBar.a(this.a) != null) && (SelectedAndSearchBar.a(this.a).size() > 0))
      {
        ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.a).get(SelectedAndSearchBar.a(this.a).size() - 1);
        if (SelectedAndSearchBar.b(this.a) != null) {
          SelectedAndSearchBar.b(this.a).a(localResultRecord);
        }
        this.a.a(false);
        this.b = false;
      }
    }
    else
    {
      this.b = true;
      super.notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return SelectedAndSearchBar.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectedAndSearchBar.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#getView() ");
      ((StringBuilder)localObject).append(localResultRecord.toString());
      QLog.i("SelectedAndSearchBar", 2, ((StringBuilder)localObject).toString());
    }
    Bitmap localBitmap = null;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = LayoutInflater.from(SelectedAndSearchBar.g(this.a)).inflate(2131625198, null);
    }
    ((View)localObject).setTag(localResultRecord);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131432714);
    if (paramInt == getCount() - 1)
    {
      if (this.b) {
        paramView = this.c;
      } else {
        paramView = null;
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
    if (localResultRecord.uinType == 10014)
    {
      paramView = localBitmap;
      if (SelectedAndSearchBar.h(this.a) != null) {
        paramView = SelectedAndSearchBar.h(this.a).getAvatarDrawable(localResultRecord.guildId, 100, null, true);
      }
      localImageView.setBackgroundDrawable(paramView);
    }
    else if (AppConstants.DATALINE_PC_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130845599);
    }
    else if (AppConstants.DATALINE_IPAD_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130845594);
    }
    else if (AppConstants.DATALINE_PRINTER_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130845602);
    }
    else if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(localResultRecord.uin))
    {
      localImageView.setBackgroundResource(2130839779);
    }
    else if (localResultRecord.type == 5)
    {
      localImageView.setImageResource(2130843087);
    }
    else
    {
      String str = localResultRecord.uin;
      localBitmap = SelectedAndSearchBar.i(this.a).getBitmapFromCache(i, str);
      paramView = localBitmap;
      if (localBitmap == null)
      {
        SelectedAndSearchBar.i(this.a).requestDecodeFace(str, i, true);
        paramView = this.d;
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.g(this.a).getResources(), paramView));
    }
    if (AppSetting.e) {
      localImageView.setContentDescription(localResultRecord.name);
    }
    if (SelectedAndSearchBar.j(this.a) == 1)
    {
      paramView = (ImageView)((View)localObject).findViewById(2131436399);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).updateSelectGradeIcon(paramView, localResultRecord.uin);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.b = false;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */