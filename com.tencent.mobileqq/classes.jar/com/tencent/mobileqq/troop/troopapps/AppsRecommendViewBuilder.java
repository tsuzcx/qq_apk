package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
  
  AppsRecommendViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, paramTroopAppShortcutContainer, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = new TroopAppShortcutContainer.TroopAppInfo();
  }
  
  private String a(int paramInt)
  {
    if (paramInt > 100000000) {
      return String.valueOf(paramInt / 100000000) + "亿";
    }
    if (paramInt > 10000) {
      return String.valueOf(paramInt / 10000) + "万";
    }
    return String.valueOf(paramInt);
  }
  
  private void a(View paramView)
  {
    TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.c, 1, 0);
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long), "", this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_e_of_type_JavaLangString);
  }
  
  private void a(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Boolean)
      {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-5196865);
      }
    }
    for (;;)
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699458));
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
      if (this.jdField_a_of_type_Boolean)
      {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
        continue;
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699467));
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
        if (this.jdField_a_of_type_Boolean) {
          paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long), "", this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_e_of_type_JavaLangString);
    if (!TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699464), 0).a();
    }
    do
    {
      return;
      new AddTroopAppCgi(this, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Long, false, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (!QLog.isColorLevel());
    QLog.d("AppsRecommendViewBuilder", 2, "onClickAdd mTroopUin:" + this.jdField_a_of_type_Long + " append_appid:" + this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long);
  }
  
  private void b(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int i = 1;
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_JavaUtilList.size();
    GradientDrawable localGradientDrawable;
    label87:
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f > 0) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g > 0) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h > 0)) {
      if (j > 1)
      {
        if (i <= 0) {
          break label260;
        }
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(34.0F);
        if (!this.jdField_a_of_type_Boolean) {
          break label155;
        }
        localGradientDrawable.setColor(-14803426);
        j = -7959655;
        k = 0;
        label90:
        if (k >= paramItemViewHolder.jdField_b_of_type_JavaUtilList.size()) {
          return;
        }
        if (k < i) {
          break label168;
        }
        ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setVisibility(8);
      }
    }
    for (;;)
    {
      k += 1;
      break label90;
      i = j;
      break;
      i = j;
      if (j > 2) {
        i = 2;
      }
      break;
      label155:
      localGradientDrawable.setColor(-1315339);
      j = -8091759;
      break label87;
      label168:
      ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_JavaUtilList.get(k));
      ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setVisibility(0);
      ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setTextColor(j);
      ((TextView)paramItemViewHolder.jdField_b_of_type_JavaUtilList.get(k)).setBackgroundDrawable(localGradientDrawable);
    }
    label260:
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void c(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g <= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h <= 0))
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    GradientDrawable localGradientDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f > 0)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699468).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.f)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break label313;
      }
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7959655);
      localGradientDrawable.setColor(-14803426);
    }
    for (;;)
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g > 0)
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699459).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.g)), new Object[0]));
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(34.0F);
        localGradientDrawable.setColor(-1315339);
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h <= 0) {
        break;
      }
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699469).replace("$COUNT", a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.h)), new Object[0]));
      break;
      label313:
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8091759);
      localGradientDrawable.setColor(-1315339);
    }
  }
  
  private void d(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_JavaUtilList.size();
    Object localObject = (RelativeLayout.LayoutParams)paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if (j > 0)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(-21.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources());
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(19.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.a(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      int i = 0;
      if (i < paramItemViewHolder.jdField_a_of_type_JavaUtilList.size())
      {
        if (i >= j) {
          ((ImageView)paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
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
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(0.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources());
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.a(7.0F, paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    Object localObject;
    if (paramView == null)
    {
      paramView = new AppsRecommendViewBuilder.ItemViewHolder();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559982, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131362887));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362899));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362902));
      paramView.c = ((TextView)((View)localObject).findViewById(2131362882));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131362875));
      paramView.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131362903));
      paramInt = 0;
      while (paramInt < paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        paramViewGroup = (ImageView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
        paramInt += 1;
      }
      paramView.jdField_b_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131378930));
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
    for (;;)
    {
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidContentContext;
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
      paramViewGroup = (AppsRecommendViewBuilder.ItemViewHolder)paramView.getTag();
    }
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
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131699466).replace("$COUNT", String.valueOf(paramInt));
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString, 0).a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699465), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699464), 0).a();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TroopAppShortcutContainer.TroopAppInfo))) {}
    Object localObject;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (TroopAppShortcutContainer.TroopAppInfo)paramObject;
          localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        } while (localObject == null);
        ArrayList localArrayList = ((TroopAppShortcutMgr)localObject).a(this.jdField_a_of_type_Long);
        if ((localArrayList != null) && (!localArrayList.contains(paramObject)))
        {
          localArrayList.add(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.e();
        }
        localObject = ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long);
      } while (localObject == null);
      i = ((ArrayList)localObject).indexOf(paramObject);
    } while ((i < 0) || (i >= ((ArrayList)localObject).size()));
    ((TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.f();
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = ((TroopAppShortcutContainer.TroopAppInfo)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      if (this.jdField_b_of_type_Boolean) {
        b(paramView);
      } else {
        a(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsRecommendViewBuilder
 * JD-Core Version:    0.7.0.1
 */