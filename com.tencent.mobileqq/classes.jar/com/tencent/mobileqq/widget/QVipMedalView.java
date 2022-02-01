package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QVipMedalView
  extends ViewGroup
{
  protected int a;
  protected QVipMedalView.Adapter a;
  protected List<ImageView> a;
  protected int b;
  
  public QVipMedalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(ImageView paramImageView, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
      return;
    }
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, URLDrawableHelperConstants.a, null, null);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramImageView);
    paramImageView.setImageDrawable(paramString);
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramString != null) {
      paramInt1 = VipInfoHandler.a(paramString, paramString.getCurrentUin(), false);
    } else {
      paramInt1 = 98;
    }
    if (paramInt2 != 0)
    {
      AnimatorHandler localAnimatorHandler = new AnimatorHandler();
      Message localMessage = Message.obtain();
      localMessage.arg1 = 1;
      localMessage.obj = paramImageView;
      localMessage.what = 0;
      paramImageView = new Bundle();
      paramImageView.putInt("iTipsTimes", paramInt3);
      localMessage.setData(paramImageView);
      localAnimatorHandler.removeMessages(localMessage.what);
      localAnimatorHandler.sendMessage(localMessage);
      ReportController.b(paramString, "dc00898", "", paramString.getCurrentUin(), "0X800B2B3", "0X800B2B3", paramInt1, 0, String.valueOf(paramInt1), "", "", "");
      return;
    }
    ReportController.b(paramString, "dc00898", "", paramString.getCurrentUin(), "0X800B2B2", "0X800B2B2", paramInt1, 0, String.valueOf(paramInt1), "", "", "");
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter;
    if (localObject == null) {
      return;
    }
    if (((QVipMedalView.Adapter)localObject).a() == getChildCount()) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("consistency check failed ! adapter count=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a());
    ((StringBuilder)localObject).append(" view list size=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    ((StringBuilder)localObject).append(" child count=");
    ((StringBuilder)localObject).append(getChildCount());
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    AssertUtils.fail((String)localObject, new Object[0]);
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a();
    removeAllViews();
    while (i < j)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > i) {
        ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
      } else {
        this.jdField_a_of_type_JavaUtilList.add(new ImageView(getContext()));
      }
      a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.b(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.c(i));
      addView((View)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 4.0F);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      ReportController.b(localQQAppInterface, "dc00898", "", localQQAppInterface.getCurrentUin(), paramString, paramString, paramInt, 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter;
    if (localObject == null) {
      return;
    }
    int i = ((QVipMedalView.Adapter)localObject).a();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int m = (this.b + this.jdField_a_of_type_Int) * paramInt2 + getPaddingLeft();
      int n = this.b + m;
      if (n > paramInt3 - paramInt1)
      {
        if (paramInt2 == 0)
        {
          QLog.e("QVipMedalView", 1, "illegal size to layout the medal!! no one can layout");
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("It only can layout ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("medal");
        QLog.d("QVipMedalView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      ((ImageView)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).layout(m, j, n, paramInt4 - k);
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    QVipMedalView.Adapter localAdapter = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter;
    int i = 0;
    if (localAdapter == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      this.b = (paramInt1 - getPaddingTop() - getPaddingBottom());
    }
    else
    {
      this.b = UIUtils.a(getContext(), 20.0F);
      paramInt1 = this.b + getPaddingBottom() + getPaddingTop();
    }
    if (k == 1073741824)
    {
      paramInt2 = j;
    }
    else
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a();
      j = this.b;
      k = this.jdField_a_of_type_Int;
      m = getPaddingLeft();
      paramInt2 = getPaddingRight() + (j * paramInt2 + (paramInt2 - 1) * k + m);
    }
    j = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a();
    b();
    while (i < j)
    {
      ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
      i += 1;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAdapter(QVipMedalView.Adapter paramAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter = paramAdapter;
    removeAllViews();
    paramAdapter = this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter;
    if (paramAdapter != null)
    {
      int j = paramAdapter.a();
      int i = 0;
      while (i < j)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > i) {
          ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
        } else {
          this.jdField_a_of_type_JavaUtilList.add(new ImageView(getContext()));
        }
        a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.b(i), this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.c(i));
        addView((View)this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
    }
    requestLayout();
  }
  
  public void setData(MedalList paramMedalList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter = new QVipMedalView.Adapter();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter.a(paramMedalList);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView$Adapter);
  }
  
  public void setItemMargin(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QVipMedalView
 * JD-Core Version:    0.7.0.1
 */