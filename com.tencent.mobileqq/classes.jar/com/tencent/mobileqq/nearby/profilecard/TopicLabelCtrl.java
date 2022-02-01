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
  private QQAppInterface a;
  private View b;
  private View c;
  private LabelContainer d;
  private boolean e;
  private Context f;
  
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
    LinearLayout localLinearLayout = new LinearLayout(this.f);
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
    View localView = new View(this.f);
    localView.setBackgroundDrawable(paramString1);
    localLinearLayout.addView(localView, DisplayUtil.a(this.f, 18.0F), DisplayUtil.a(this.f, 15.0F));
    ((LinearLayout.LayoutParams)localView.getLayoutParams()).leftMargin = DisplayUtil.a(this.f, 4.0F);
    paramString1 = new TextView(this.f);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(i);
    localLinearLayout.addView(paramString1);
    paramString1 = (LinearLayout.LayoutParams)paramString1.getLayoutParams();
    paramString1.rightMargin = DisplayUtil.a(this.f, 6.0F);
    paramString1.leftMargin = DisplayUtil.a(this.f, 2.0F);
    localLinearLayout.setBackgroundResource(2130847192);
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
    this.a = paramQQAppInterface;
    this.e = paramBoolean;
    this.b = paramView.findViewById(2131447583);
    this.d = ((LabelContainer)paramView.findViewById(2131437015));
    this.c = paramView.findViewById(2131437230);
    this.f = paramView.getContext();
  }
  
  public void a(cmd0xac5.NearbyNowData paramNearbyNowData)
  {
    if (this.d.getChildCount() > 0) {
      this.d.removeAllViews();
    }
    this.d.setSpace(DisplayUtil.a(this.f, 6.0F), DisplayUtil.a(this.f, 8.0F));
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
        this.d.addView(paramNearbyNowData, -2, DisplayUtil.a(this.f, 24.0F));
        i += 1;
      }
      this.d.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.TopicLabelCtrl
 * JD-Core Version:    0.7.0.1
 */