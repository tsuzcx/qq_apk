package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class KandianNegativeWindowForAd
  extends KandianNegativeWindow
  implements View.OnClickListener
{
  private KandianNegativeWindowForAd.OnComplainListener jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd$OnComplainListener;
  HashMap<Integer, DislikeInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  KandianNegativeWindow.iClickInterface b;
  View jdField_g_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_h_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_h_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_i_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_i_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_j_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_j_of_type_JavaUtilArrayList = new ArrayList();
  
  public KandianNegativeWindowForAd(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface = new KandianNegativeWindowForAd.1(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560248, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected int a()
  {
    int m = this.jdField_g_of_type_JavaUtilArrayList.size();
    int k = m;
    if (this.jdField_h_of_type_JavaUtilArrayList.size() > m) {
      k = this.jdField_h_of_type_JavaUtilArrayList.size();
    }
    m = k;
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > k) {
      m = this.jdField_i_of_type_JavaUtilArrayList.size();
    }
    k = m;
    if (this.jdField_j_of_type_JavaUtilArrayList.size() > m) {
      k = this.jdField_j_of_type_JavaUtilArrayList.size();
    }
    m = k;
    if (k > 6) {
      m = 6;
    }
    return m;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<AdDislikeInfo> paramArrayList)
  {
    b();
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    StringBuilder localStringBuilder = new StringBuilder();
    Integer localInteger1 = Integer.valueOf(3);
    Integer localInteger2 = Integer.valueOf(2);
    Integer localInteger3 = Integer.valueOf(1);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramArrayList.next();
        if (localAdDislikeInfo != null)
        {
          if (localAdDislikeInfo.a != 0)
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localAdDislikeInfo.a), localAdDislikeInfo);
          }
          else
          {
            paramInt1 = localAdDislikeInfo.b;
            if (paramInt1 != 1)
            {
              if (paramInt1 != 2)
              {
                if (paramInt1 == 3) {
                  this.jdField_i_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
                }
              }
              else {
                this.jdField_h_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
              }
            }
            else {
              this.jdField_g_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
            }
          }
          localStringBuilder.append(localAdDislikeInfo.toString());
          localStringBuilder.append("\n");
        }
      }
    }
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localInteger3))
    {
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger3);
      if (this.jdField_g_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_g_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.jdField_g_of_type_JavaUtilArrayList, this.jdField_g_of_type_AndroidViewView, 2130841735, paramArrayList.a, bool);
    }
    else
    {
      a(new ArrayList(), this.jdField_g_of_type_AndroidViewView, 2130841735, HardCodeUtil.a(2131705994), false);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localInteger2))
    {
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger2);
      if (this.jdField_h_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_h_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.jdField_h_of_type_JavaUtilArrayList, this.jdField_h_of_type_AndroidViewView, 2130841738, paramArrayList.a, bool);
    }
    else
    {
      a(new ArrayList(), this.jdField_h_of_type_AndroidViewView, 2130841738, HardCodeUtil.a(2131705997), false);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localInteger1))
    {
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger1);
      if (this.jdField_i_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_i_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.jdField_i_of_type_JavaUtilArrayList, this.jdField_i_of_type_AndroidViewView, 2130841727, paramArrayList.a, bool);
    }
    else
    {
      a(new ArrayList(), this.jdField_i_of_type_AndroidViewView, 2130841727, HardCodeUtil.a(2131705998), false);
    }
    paramArrayList = new DislikeInfo();
    paramArrayList.a = HardCodeUtil.a(2131706010);
    paramArrayList.c = 0;
    this.jdField_j_of_type_JavaUtilArrayList.add(paramArrayList);
    a(this.jdField_j_of_type_JavaUtilArrayList, this.jdField_j_of_type_AndroidViewView, 2130841718, paramArrayList.a, false);
    this.jdField_j_of_type_AndroidViewView.findViewById(2131369143).setVisibility(0);
    a();
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("setData:");
      paramArrayList.append(localStringBuilder.toString());
      QLog.d("KandianNegativeWindowForAd", 1, paramArrayList.toString());
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370637));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364625));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371758));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371759));
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131371752);
    this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131371760);
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131371756);
    this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131371750);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.findViewById(2131377256).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    ((ImageView)paramView.findViewById(2131366870).findViewById(2131369933)).setOnClickListener(this);
    this.jdField_i_of_type_Int = ((int)DeviceInfoUtil.i());
    this.jdField_j_of_type_Int = ((int)DeviceInfoUtil.j());
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298867));
    this.k = (this.jdField_i_of_type_Int - this.l * 2);
    setWidth(this.k);
    this.m = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298848));
    setOnDismissListener(new KandianNegativeWindowForAd.2(this));
  }
  
  public void a(KandianNegativeWindowForAd.OnComplainListener paramOnComplainListener)
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd$OnComplainListener = paramOnComplainListener;
  }
  
  protected int b()
  {
    if (this.jdField_h_of_type_Int <= 0)
    {
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_h_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    }
    int k = (a() + 1) * this.m + this.jdField_h_of_type_Int;
    b(this.jdField_g_of_type_AndroidViewView);
    int m = this.jdField_g_of_type_AndroidViewView.getMeasuredHeight() * this.n + this.jdField_h_of_type_Int;
    if (k > m) {
      return k;
    }
    return m;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_g_of_type_JavaUtilArrayList.clear();
    this.jdField_h_of_type_JavaUtilArrayList.clear();
    this.jdField_i_of_type_JavaUtilArrayList.clear();
    this.jdField_j_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(IReadInJoyModel paramIReadInJoyModel, ArrayList<AdDislikeInfo> paramArrayList)
  {
    int n = 0;
    int k;
    int m;
    if (paramIReadInJoyModel != null)
    {
      k = paramIReadInJoyModel.g();
      m = paramIReadInJoyModel.c();
      paramIReadInJoyModel = paramIReadInJoyModel.a();
    }
    else
    {
      paramIReadInJoyModel = null;
      k = 0;
      m = 0;
    }
    if (paramIReadInJoyModel != null) {
      n = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramIReadInJoyModel);
    }
    a(k, m, n, paramArrayList);
  }
  
  protected void d()
  {
    this.f.clear();
    a(this.jdField_g_of_type_JavaUtilArrayList.size(), this.jdField_g_of_type_AndroidViewView);
    a(this.jdField_h_of_type_JavaUtilArrayList.size(), this.jdField_h_of_type_AndroidViewView);
    a(this.jdField_i_of_type_JavaUtilArrayList.size(), this.jdField_i_of_type_AndroidViewView);
    a(this.jdField_j_of_type_JavaUtilArrayList.size(), this.jdField_j_of_type_AndroidViewView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131371760: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2))).a, this.jdField_b_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
        a(true);
      }
      break;
    case 2131371756: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3))).a, this.jdField_b_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
        a(true);
      }
      break;
    case 2131371752: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).a, this.jdField_b_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
        a(true);
      }
      break;
    case 2131371750: 
      KandianNegativeWindowForAd.OnComplainListener localOnComplainListener = this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd$OnComplainListener;
      if (localOnComplainListener != null) {
        localOnComplainListener.a();
      }
      dismiss();
      break;
    case 2131369933: 
      a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindowForAd
 * JD-Core Version:    0.7.0.1
 */