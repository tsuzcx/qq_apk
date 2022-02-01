package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AppsRecommendViewBuilder
  extends AppsBaseBuilder
  implements View.OnClickListener, AddTroopAppCgi.CgiCallBack
{
  protected TroopAppShortcutContainer.TroopAppInfo a;
  
  AppsRecommendViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramBaseActivity, paramTroopAppShortcutContainer, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = new TroopAppShortcutContainer.TroopAppInfo();
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt > 100000000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt / 100000000));
      localStringBuilder.append("亿");
      return localStringBuilder.toString();
    }
    if (paramInt > 10000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt / 10000));
      localStringBuilder.append("万");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  private void a(View paramView)
  {
    TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.c, 1, 0);
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long), "", this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_e_of_type_JavaLangString);
  }
  
  private void a(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Boolean)
      {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-5196865);
      }
      else
      {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699563));
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
        if (this.jdField_a_of_type_Boolean) {
          paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
        }
      }
    }
    else
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699572));
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
      if (this.jdField_a_of_type_Boolean) {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void b(View paramView)
  {
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long), "", this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_e_of_type_JavaLangString);
    if (!TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699569), 0).a();
      return;
    }
    new AddTroopAppCgi(this, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Long, false, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onClickAdd mTroopUin:");
      paramView.append(this.jdField_a_of_type_Long);
      paramView.append(" append_appid:");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long);
      QLog.d("AppsRecommendViewBuilder", 2, paramView.toString());
    }
  }
  
  private void b(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_JavaUtilList.size();
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h <= 0))
    {
      i = j;
      if (j > 2) {
        i = 2;
      }
    }
    else
    {
      i = j;
      if (j > 1) {
        i = 1;
      }
    }
    if (i > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      if (this.jdField_a_of_type_Boolean)
      {
        j = -7959655;
        localGradientDrawable.setColor(-14803426);
      }
      else
      {
        j = -8091759;
        localGradientDrawable.setColor(-1315339);
      }
      int k = 0;
      while (k < paramItemViewHolder.jdField_b_of_type_JavaUtilList.size())
      {
        if (k >= i)
        {
          ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setVisibility(8);
        }
        else
        {
          ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_JavaUtilList.get(k));
          ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setVisibility(0);
          ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setTextColor(j);
          ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setBackgroundDrawable(localGradientDrawable);
        }
        k += 1;
      }
    }
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void c(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h <= 0))
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f > 0)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699573).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g > 0)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699564).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h > 0)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699574).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h)), new Object[0]));
    }
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(34.0F);
    if (this.jdField_a_of_type_Boolean)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7959655);
      localGradientDrawable.setColor(-14803426);
    }
    else
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8091759);
      localGradientDrawable.setColor(-1315339);
    }
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void d(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_JavaUtilList.size();
    Object localObject = (RelativeLayout.LayoutParams)paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if (j > 0)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(-21.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources());
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(19.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.b(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      int i = 0;
      while (i < paramItemViewHolder.jdField_a_of_type_JavaUtilList.size())
      {
        if (i >= j)
        {
          ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(8);
        }
        else
        {
          localObject = (String)this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_JavaUtilList.get(i);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            Drawable localDrawable = ImageUtil.a(true);
            localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
            localDrawable = ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).getDrawable();
            if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
              ((FaceDrawable)localDrawable).cancel();
            }
            ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
          }
          else
          {
            localObject = ImageUtil.a(true);
            ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
          }
        }
        i += 1;
      }
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(0.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources());
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.b(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    if (paramView == null)
    {
      paramView = new AppsRecommendViewBuilder.ItemViewHolder();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559853, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131362839));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362851));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362854));
      paramView.c = ((TextView)((View)localObject).findViewById(2131362834));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131362827));
      paramView.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131362855));
      paramInt = 0;
      while (paramInt < paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        paramViewGroup = (ImageView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
        paramInt += 1;
      }
      paramView.jdField_b_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131378317));
      paramInt = 0;
      while (paramInt < paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        paramViewGroup = (TextView)paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.jdField_b_of_type_JavaUtilList.add(paramViewGroup);
        paramInt += 1;
      }
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramViewGroup = (AppsRecommendViewBuilder.ItemViewHolder)paramView.getTag();
    }
    paramView.setClickable(true);
    paramView.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_e_of_type_Int == 1) {
      bool = true;
    }
    TroopAppShortcutUtils.a((Context)localObject, localImageView, str, 48.0F, bool);
    d(paramViewGroup);
    c(paramViewGroup);
    b(paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_JavaLangString);
    paramViewGroup.c.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.d);
    a(paramViewGroup);
    if (this.jdField_a_of_type_Boolean)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      paramView.setBackgroundColor(-16777216);
    }
    return paramView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo;
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    QLog.e("AppsRecommendViewBuilder", 1, new Object[] { "add appid retCode: ", Integer.valueOf(paramInt) });
    if (paramInt == 41005)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      if (paramInt > 0)
      {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131699571).replace("$COUNT", String.valueOf(paramInt));
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString, 0).a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699570), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699569), 0).a();
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
        return;
      }
      paramObject = (TroopAppShortcutContainer.TroopAppInfo)paramObject;
      Object localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ArrayList localArrayList = ((TroopAppShortcutMgr)localObject).a(this.jdField_a_of_type_Long);
        if ((localArrayList != null) && (!localArrayList.contains(paramObject)))
        {
          localArrayList.add(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.e();
        }
        localObject = ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long);
        if (localObject != null)
        {
          int i = ((ArrayList)localObject).indexOf(paramObject);
          if ((i >= 0) && (i < ((ArrayList)localObject).size()))
          {
            ((TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.f();
          }
        }
      }
    }
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = ((TroopAppShortcutContainer.TroopAppInfo)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362827)
    {
      if (i == 2131362856) {
        a(paramView);
      }
    }
    else if (this.jdField_b_of_type_Boolean) {
      b(paramView);
    } else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsRecommendViewBuilder
 * JD-Core Version:    0.7.0.1
 */