package com.tencent.qidian;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bcpj;
import bcpk;
import bcpm;
import bcqy;
import befo;
import behi;
import com.tencent.biz.pubaccount.PhotoHorizontalScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.List;

@TargetApi(9)
public class PhotoWallViewForQiDianProfile
  extends LinearLayout
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public bcpm a;
  private behi jdField_a_of_type_Behi = new bcpj(this);
  public PhotoHorizontalScrollView a;
  public GridView a;
  public List<bcqy> a;
  public int b;
  private View b;
  public int c = -1;
  
  public PhotoWallViewForQiDianProfile(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  @TargetApi(11)
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_JavaUtilList != null)) {
      QLog.i("PhotoWallViewForQiDianProfile", 2, "updatePhotoView urlList size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
        this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.c);
        bcpk localbcpk = new bcpk(this, this.jdField_a_of_type_AndroidContentContext);
        localbcpk.a(this.jdField_a_of_type_JavaUtilList);
        i = this.jdField_a_of_type_JavaUtilList.size();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.jdField_a_of_type_Int + this.c) * i, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
        this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localbcpk);
        this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Behi);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
        setVisibility(0);
      }
      return;
    }
  }
  
  public void a(Context paramContext, List<bcqy> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoWallViewForQiDianProfile", 2, "initView");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493822, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305875));
    this.jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305876));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306294));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307943);
    this.c = getResources().getDimensionPixelSize(2131166807);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131166809);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131166808);
    if (befo.c()) {
      this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView.setOverScrollMode(2);
    }
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoWallCallback(bcpm parambcpm)
  {
    this.jdField_a_of_type_Bcpm = parambcpm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile
 * JD-Core Version:    0.7.0.1
 */