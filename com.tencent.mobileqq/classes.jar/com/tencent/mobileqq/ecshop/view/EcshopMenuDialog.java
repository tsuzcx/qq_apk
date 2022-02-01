package com.tencent.mobileqq.ecshop.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.MenuConfBean;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EcshopMenuDialog
  extends PopupWindow
  implements View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private EcshopMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopMenuDialog$OnClickActionListener;
  
  private EcshopMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return DisplayUtil.a(paramContext, paramInt * 50 + 10 + 10 + 9);
  }
  
  private static View a(Activity paramActivity, List<EcshopConfBean.MenuConfBean> paramList, ArrayList<RedPointInfo> paramArrayList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131561888, null);
    a(paramActivity, localView, paramList, paramArrayList);
    return localView;
  }
  
  public static EcshopMenuDialog a(Activity paramActivity, List<EcshopConfBean.MenuConfBean> paramList, ArrayList<RedPointInfo> paramArrayList, EcshopMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    int i = a(paramActivity, paramList.size());
    int j = ViewUtils.a(122.0F);
    paramActivity = new EcshopMenuDialog(paramActivity, a(paramActivity, paramList, paramArrayList), j, i, true);
    paramActivity.setAnimationStyle(2131755035);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    paramActivity.a(paramActivity.getContentView());
    paramActivity.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopMenuDialog$OnClickActionListener = paramOnClickActionListener;
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    paramActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  private static void a(Context paramContext, View paramView, List<EcshopConfBean.MenuConfBean> paramList, ArrayList<RedPointInfo> paramArrayList)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131370288);
    localLinearLayout.removeAllViews();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      EcshopConfBean.MenuConfBean localMenuConfBean = (EcshopConfBean.MenuConfBean)localIterator.next();
      Object localObject1 = LayoutInflater.from(paramContext);
      paramList = null;
      paramView = null;
      localObject1 = ((LayoutInflater)localObject1).inflate(2131561889, null);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131381222);
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131379739);
      ((ImageView)((View)localObject1).findViewById(2131370806)).setImageDrawable(QQShopPicUtil.a(localMenuConfBean.d, URLDrawableHelperConstants.a));
      ((TextView)localObject2).setText(localMenuConfBean.jdField_a_of_type_JavaLangString);
      ((TextView)localObject2).setTextColor(Color.parseColor(localMenuConfBean.f));
      if (paramArrayList != null)
      {
        localObject2 = paramArrayList.iterator();
        for (;;)
        {
          paramList = paramView;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramList = (RedPointInfo)((Iterator)localObject2).next();
          if (paramList.mTabId == localMenuConfBean.jdField_a_of_type_Int) {
            paramView = paramList;
          }
        }
      }
      ((View)localObject1).setTag(new EcshopMenuDialog.ViewTag(paramList, localMenuConfBean));
      if (paramList != null)
      {
        if (QQShopRedPointUtil.a.a(paramList, -1, l)) {
          localImageView.setVisibility(0);
        } else {
          localImageView.setVisibility(8);
        }
      }
      else {
        localImageView.setVisibility(8);
      }
      localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, DisplayUtil.a(paramContext, 50.0F)));
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof EcshopMenuDialog.ViewTag))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    a(this.jdField_a_of_type_AndroidAppActivity, 1.0F);
  }
  
  public void onClick(View paramView)
  {
    EcshopMenuDialog.ViewTag localViewTag = (EcshopMenuDialog.ViewTag)paramView.getTag();
    EcshopMenuDialog.OnClickActionListener localOnClickActionListener = this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopMenuDialog$OnClickActionListener;
    if ((localOnClickActionListener != null) && (localViewTag != null)) {
      localOnClickActionListener.a(localViewTag);
    }
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    a(this.jdField_a_of_type_AndroidAppActivity, 0.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopMenuDialog
 * JD-Core Version:    0.7.0.1
 */