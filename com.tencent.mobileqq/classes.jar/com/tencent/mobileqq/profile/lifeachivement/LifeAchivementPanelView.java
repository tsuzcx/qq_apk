package com.tencent.mobileqq.profile.lifeachivement;

import amov;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import aymg;
import aynw;
import aynz;
import ayob;
import ayoc;
import ayoe;
import ayof;
import ayog;
import ayoh;
import ayoi;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LifeAchivementPanelView
  extends ProfileContentTitleView
{
  public long a;
  public amov a;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public aynw a;
  ayob jdField_a_of_type_Ayob;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public LifeAchivementPanelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LifeAchivementPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ayoc paramayoc, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramayoc.jdField_a_of_type_Boolean = true;
      paramayoc.c += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Aynw.notifyItemChanged(paramInt1);
      return;
      if (paramInt2 == 2)
      {
        paramayoc.jdField_a_of_type_Boolean = false;
        paramayoc.c -= 1;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new ayog(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new ayoh(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.dp2px(5.0F, getResources());
    int j = AIOUtils.dp2px(0.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aynz(i, j));
    this.jdField_a_of_type_Ayob = new ayoi(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.jdField_a_of_type_Aynw = new aynw(getContext(), null, this.jdField_a_of_type_Ayob);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aynw);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561339, this, false));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369587));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ayoe(this));
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369586);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    d();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new ayof(this));
    this.jdField_b_of_type_AndroidViewViewGroup.setContentDescription(getResources().getString(2131691072));
  }
  
  public void a(Card paramCard, aymg paramaymg)
  {
    bool1 = true;
    String str = "";
    if (!TextUtils.isEmpty(paramCard.lifeAchievementOpenId)) {
      str = paramCard.lifeAchievementOpenId;
    }
    boolean bool2 = ProfileActivity.AllInOne.b(paramaymg.a);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(paramCard.uin).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramCard)
    {
      for (;;)
      {
        QLog.d("LifeAchivementPanelView", 1, "updateUserInfo exception ", paramCard);
        continue;
        bool1 = false;
      }
    }
    if (paramaymg.a.a == 0)
    {
      this.jdField_b_of_type_Boolean = bool2;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Long = l1;
      return;
    }
  }
  
  public void a(ArrayList<ayoc> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showAchivementList dataArrayList.size() = " + paramArrayList.size() + ",totalCount = " + paramInt);
    }
    c();
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Aynw.a(paramArrayList, paramInt, bool);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    c();
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setCardHandler(amov paramamov)
  {
    this.jdField_a_of_type_Amov = paramamov;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */