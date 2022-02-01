package com.tencent.mobileqq.profile.lifeachivement;

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
import anri;
import azrb;
import azsr;
import azsu;
import azsw;
import azsx;
import azsz;
import azta;
import aztb;
import aztc;
import aztd;
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
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public anri a;
  public azsr a;
  azsw jdField_a_of_type_Azsw;
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
  
  private void a(azsx paramazsx, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramazsx.jdField_a_of_type_Boolean = true;
      paramazsx.c += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Azsr.notifyItemChanged(paramInt1);
      return;
      if (paramInt2 == 2)
      {
        paramazsx.jdField_a_of_type_Boolean = false;
        paramazsx.c -= 1;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new aztb(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new aztc(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.dp2px(5.0F, getResources());
    int j = AIOUtils.dp2px(0.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new azsu(i, j));
    this.jdField_a_of_type_Azsw = new aztd(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.jdField_a_of_type_Azsr = new azsr(getContext(), null, this.jdField_a_of_type_Azsw);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azsr);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561401, this, false));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369756));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new azsz(this));
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369755);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    d();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new azta(this));
    this.jdField_b_of_type_AndroidViewViewGroup.setContentDescription(getResources().getString(2131691157));
  }
  
  public void a(Card paramCard, azrb paramazrb)
  {
    bool1 = true;
    String str = "";
    if (!TextUtils.isEmpty(paramCard.lifeAchievementOpenId)) {
      str = paramCard.lifeAchievementOpenId;
    }
    boolean bool2 = ProfileActivity.AllInOne.b(paramazrb.a);
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
    if (paramazrb.a.a == 0)
    {
      this.jdField_b_of_type_Boolean = bool2;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Long = l1;
      return;
    }
  }
  
  public void a(ArrayList<azsx> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showAchivementList dataArrayList.size() = " + paramArrayList.size() + ",totalCount = " + paramInt);
    }
    c();
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Azsr.a(paramArrayList, paramInt, bool);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    c();
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setCardHandler(anri paramanri)
  {
    this.jdField_a_of_type_Anri = paramanri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */