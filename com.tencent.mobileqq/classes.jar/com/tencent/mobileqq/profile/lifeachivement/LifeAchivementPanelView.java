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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LifeAchivementPanelView
  extends ProfileContentTitleView
{
  long jdField_a_of_type_Long;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  LifeAchivementAdapter.onItemClickListener jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener;
  LifeAchivementAdapter jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter;
  String jdField_a_of_type_JavaLangString;
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
  
  private void a(LifeAchivementData paramLifeAchivementData, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramLifeAchivementData.jdField_a_of_type_Boolean = true;
      paramLifeAchivementData.c += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter.notifyItemChanged(paramInt1);
      return;
      if (paramInt2 == 2)
      {
        paramLifeAchivementData.jdField_a_of_type_Boolean = false;
        paramLifeAchivementData.c -= 1;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new LifeAchivementPanelView.3(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new LifeAchivementPanelView.4(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.a(5.0F, getResources());
    int j = AIOUtils.a(0.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new LifeAchivementAdapter.SpacesItemDecoration(i, j));
    this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener = new LifeAchivementPanelView.5(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter = new LifeAchivementAdapter(getContext(), null, this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    removeContentViews();
    addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, Card paramCard, String paramString)
  {
    boolean bool1 = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      boolean bool2 = ProfileActivity.AllInOne.b(paramProfileCardInfo.a);
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
      if (paramProfileCardInfo.a.a == 0)
      {
        this.b = bool2;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_a_of_type_Long = l1;
        return;
      }
      paramString = "";
    }
  }
  
  public void a(ArrayList<LifeAchivementData> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showAchivementList dataArrayList.size() = " + paramArrayList.size() + ",totalCount = " + paramInt);
    }
    removeContentViews();
    addContentView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter.a(paramArrayList, paramInt, bool);
  }
  
  public void init()
  {
    super.init();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561508, this, false));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370025));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new LifeAchivementPanelView.1(this));
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370024);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    b();
    this.mTitleContainer.setOnClickListener(new LifeAchivementPanelView.2(this));
    this.mTitleContainer.setContentDescription(getResources().getString(2131691264));
  }
  
  public void setCardHandler(CardHandler paramCardHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = paramCardHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */