package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyLabelInfo;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class TopicLabelCtrl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LabelContainer jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public View a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 16777216) {
      i = paramInt1 - 16777216;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 16777216) {
      paramInt1 = paramInt2 - 16777216;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-7829368);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      localObject = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject);
      paramString1 = (String)localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawable exception, exp=");
        localStringBuilder.append(localException);
        localStringBuilder.append(", url=");
        localStringBuilder.append(paramString1);
        QLog.w("TopicLabelCtrl", 2, localStringBuilder.toString());
      }
      paramString1 = new ColorDrawable(-7829368);
    }
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    localView.setBackgroundDrawable(paramString1);
    localLinearLayout.addView(localView, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    ((LinearLayout.LayoutParams)localView.getLayoutParams()).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    paramString1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(i);
    localLinearLayout.addView(paramString1);
    paramString1 = (LinearLayout.LayoutParams)paramString1.getLayoutParams();
    paramString1.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    paramString1.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    localLinearLayout.setBackgroundResource(2130845722);
    paramString1 = localLinearLayout.getBackground();
    if (paramString1 != null)
    {
      paramString1.setColorFilter(new LightingColorFilter(-16777216, paramInt1));
      paramString1.invalidateSelf();
    }
    localLinearLayout.setOnClickListener(new TopicLabelCtrl.1(this));
    return localLinearLayout;
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378882);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer = ((LabelContainer)paramView.findViewById(2131369877));
    this.b = paramView.findViewById(2131370069);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
  }
  
  public void a(cmd0xac5.NearbyNowData paramNearbyNowData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.getChildCount() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.removeAllViews();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setSpace(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    List localList = null;
    if (paramNearbyNowData != null) {
      localList = paramNearbyNowData.label_info.get();
    }
    if ((localList != null) && (localList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        paramNearbyNowData = new StringBuilder();
        paramNearbyNowData.append("updateData, nearbyLabelInfoList.size=");
        paramNearbyNowData.append(localList.size());
        QLog.i("TopicLabelCtrl", 2, paramNearbyNowData.toString());
      }
      int i = 0;
      while (i < localList.size())
      {
        paramNearbyNowData = (cmd0xac5.NearbyLabelInfo)localList.get(i);
        paramNearbyNowData = a(paramNearbyNowData.label_pic.get().toStringUtf8(), paramNearbyNowData.label_name.get().toStringUtf8(), paramNearbyNowData.font_colour.get(), paramNearbyNowData.label_colour.get());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.addView(paramNearbyNowData, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 24.0F));
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.TopicLabelCtrl
 * JD-Core Version:    0.7.0.1
 */