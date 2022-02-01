package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList;
  
  public QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramContext;
    this.jdField_a_of_type_AndroidContentContext = paramList;
    Object localObject;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = localObject;
    this.jdField_a_of_type_JavaUtilList = paramOnClickListener;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      return 4;
    }
    if (paramInt == 3000) {
      return 101;
    }
    if (paramInt == 1006) {
      i = 11;
    }
    return i;
  }
  
  private void a(ImageView paramImageView, ResultRecord paramResultRecord)
  {
    if (AppConstants.DATALINE_PC_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844282);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844277);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844285);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130839566);
      return;
    }
    int i = a(paramResultRecord.getUinType());
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramResultRecord.uin));
  }
  
  public ResultRecord a(int paramInt)
  {
    return (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    if (paramView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihForwardAvatar.i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihForwardAvatar.i));
    }
    else
    {
      localImageView = (ImageView)paramView;
    }
    a(localImageView, a(paramInt));
    localImageView.setTag(a(paramInt));
    localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localImageView.setFocusable(false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter
 * JD-Core Version:    0.7.0.1
 */