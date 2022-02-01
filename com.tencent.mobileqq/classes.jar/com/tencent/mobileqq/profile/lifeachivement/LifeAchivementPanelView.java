package com.tencent.mobileqq.profile.lifeachivement;

import afur;
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
import anip;
import azfe;
import azgv;
import azgy;
import azha;
import azhb;
import azhd;
import azhe;
import azhf;
import azhg;
import azhh;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
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
  public anip a;
  public azgv a;
  azha jdField_a_of_type_Azha;
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
  
  private void a(azhb paramazhb, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramazhb.jdField_a_of_type_Boolean = true;
      paramazhb.c += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Azgv.notifyItemChanged(paramInt1);
      return;
      if (paramInt2 == 2)
      {
        paramazhb.jdField_a_of_type_Boolean = false;
        paramazhb.c -= 1;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new azhf(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new azhg(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = afur.a(5.0F, getResources());
    int j = afur.a(0.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new azgy(i, j));
    this.jdField_a_of_type_Azha = new azhh(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.jdField_a_of_type_Azgv = new azgv(getContext(), null, this.jdField_a_of_type_Azha);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azgv);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561414, this, false));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369503));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new azhd(this));
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369502);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    d();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new azhe(this));
    this.jdField_b_of_type_AndroidViewViewGroup.setContentDescription(getResources().getString(2131691032));
  }
  
  public void a(Card paramCard, azfe paramazfe)
  {
    bool1 = true;
    String str = "";
    if (!TextUtils.isEmpty(paramCard.lifeAchievementOpenId)) {
      str = paramCard.lifeAchievementOpenId;
    }
    boolean bool2 = ProfileActivity.AllInOne.b(paramazfe.a);
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
    if (paramazfe.a.a == 0)
    {
      this.jdField_b_of_type_Boolean = bool2;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Long = l1;
      return;
    }
  }
  
  public void a(ArrayList<azhb> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showAchivementList dataArrayList.size() = " + paramArrayList.size() + ",totalCount = " + paramInt);
    }
    c();
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Azgv.a(paramArrayList, paramInt, bool);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    c();
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setCardHandler(anip paramanip)
  {
    this.jdField_a_of_type_Anip = paramanip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */