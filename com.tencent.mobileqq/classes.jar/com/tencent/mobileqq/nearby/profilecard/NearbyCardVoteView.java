package com.tencent.mobileqq.nearby.profilecard;

import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NearbyCardVoteView
  extends RelativeLayout
  implements PraiseManager.OnPraiseLoadListener
{
  public static int c = 11;
  public static int d = 12;
  private double jdField_a_of_type_Double;
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = new NearbyCardVoteView.1(this);
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  public TextView a;
  public QQAppInterface a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  FloatViewBuilderFactory jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
  PraiseAnimation jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation = new PraiseAnimation();
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e = false;
  
  public NearbyCardVoteView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  private void a()
  {
    this.c = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(getContext());
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
    Object localObject = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    double d1 = this.jdField_a_of_type_Double;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(d1 * 50.0D), (int)(d1 * 50.0D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845678);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_b_of_type_AndroidViewView = new SingleLineTextView(getContext());
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846076);
    this.jdField_b_of_type_AndroidViewView.setId(2131370026);
    d1 = this.jdField_a_of_type_Double;
    localLayoutParams = new RelativeLayout.LayoutParams((int)(d1 * 25.0D), (int)(d1 * 25.0D));
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Double * 15.0D));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(10);
    addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ((int)(this.jdField_a_of_type_Double * 2.0D));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131369478);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850777);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject).getString(2131691151));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371828);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 11.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, -2, -2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new int[2];
    this.jdField_b_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
    float f1 = localObject[0] + this.jdField_b_of_type_AndroidViewView.getWidth() / 2;
    float f2 = localObject[1] - this.jdField_b_of_type_AndroidViewView.getHeight() / 2;
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a);
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, ((BaseFloatViewBuilder)localObject).a(), this, paramInt1, true, paramInt2, f1, f2);
      return;
    }
    if (paramInt2 == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(((BaseFloatViewBuilder)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseFloatViewBuilder)localObject, f1 - DisplayUtil.a(getContext(), 20.0F), f2 - DisplayUtil.a(getContext(), 120.0F), DisplayUtil.a(getContext(), 75.0F), DisplayUtil.a(getContext(), 65.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(((BaseFloatViewBuilder)localObject).a(), f1, f2);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if (paramPraiseInfo != null)
    {
      if ((!this.jdField_d_of_type_Boolean) && (paramInt1 == PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        a(paramPraiseInfo);
      }
      paramPraiseInfo = (Pair)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        float f1 = ((Point)paramPraiseInfo.first).x;
        float f2 = ((Point)paramPraiseInfo.first).y;
        paramInt2 = ((Integer)paramPraiseInfo.second).intValue();
        paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        HeartLayout localHeartLayout = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
        paramPraiseInfo.a(paramString, localHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(paramInt2, localHeartLayout.a).a(), this, paramInt1, false, paramInt2, f1, f2);
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramPraiseInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
      ((PraiseAnimation)localObject).jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      ((PraiseAnimation)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramPraiseInfo.a);
      paramPraiseInfo = (INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      boolean bool;
      if ((localObject != null) && (paramPraiseInfo.a(Long.valueOf(((NearbyPeopleCard)localObject).uin).longValue()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.c, bool, this.jdField_b_of_type_AndroidViewView.getBackground(), getResources());
      this.jdField_b_of_type_AndroidViewView.startAnimation(PraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation, 1.0F, 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int > 0))
    {
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      int j;
      int i;
      if (paramBoolean)
      {
        j = 2130850767;
        i = this.jdField_a_of_type_Int;
        i = j;
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).width = -2;
          ((RelativeLayout.LayoutParams)localObject1).height = -2;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
          i = j;
        }
      }
      else
      {
        j = 2130850770;
        i = this.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Int;
        i = j;
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).width = -2;
          ((RelativeLayout.LayoutParams)localObject1).height = -2;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          i = j;
        }
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      } else {
        QLog.e("VoteView", 1, "mRedDotView.setLayoutParams(pa) pa == null");
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("+");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    else
    {
      paramInt = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3, boolean paramBoolean4, List<TPraiseInfo> paramList)
  {
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.c = paramBoolean2;
    int j = 0;
    if (paramInt1 > 0) {
      i = paramInt1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    int i = this.jdField_a_of_type_Int;
    if (paramInt2 > i) {
      this.jdField_b_of_type_Int = (i % 20);
    } else if (paramInt2 < 0) {
      this.jdField_b_of_type_Int = 0;
    } else {
      this.jdField_b_of_type_Int = paramInt2;
    }
    this.jdField_a_of_type_Int -= paramInt2;
    Object localObject1 = (INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
    if ((!this.jdField_d_of_type_Boolean) && (this.c))
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (((INearbyLikeLimitManager)localObject1).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue())))
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130842689);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-13291);
        }
        else if (!this.jdField_a_of_type_Boolean)
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130845697);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-52924);
        }
        else
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130846076);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
        }
      }
      catch (NumberFormatException paramNewVoteAnimHelper)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VoteView", 2, paramNewVoteAnimHelper.toString(), paramNewVoteAnimHelper);
        }
        paramNewVoteAnimHelper = getResources().getDrawable(2130846076);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      paramNewVoteAnimHelper = getResources().getDrawable(2130842691);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      paramNewVoteAnimHelper = getResources().getDrawable(2130845699);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if ((localObject2 != null) && (((INearbyLikeLimitManager)localObject1).a(Long.valueOf(((NearbyPeopleCard)localObject2).uin).longValue()))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.c, paramBoolean1, paramNewVoteAnimHelper, getResources());
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramNewVoteAnimHelper);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
        double d1 = this.jdField_a_of_type_Double;
        paramNewVoteAnimHelper = new RelativeLayout.LayoutParams((int)(d1 * 32.0D), (int)(d1 * 32.0D));
        paramNewVoteAnimHelper.topMargin = ((int)(this.jdField_a_of_type_Double * 15.0D));
        paramNewVoteAnimHelper.addRule(14);
        paramNewVoteAnimHelper.addRule(10);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramNewVoteAnimHelper);
      }
    }
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) && (!paramBoolean3))
    {
      i = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i > 0)
      {
        paramNewVoteAnimHelper = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        paramNewVoteAnimHelper.a(this);
        a(paramNewVoteAnimHelper.a(i, true, "from_profile_card"));
      }
    }
    paramNewVoteAnimHelper = new StringBuilder();
    paramNewVoteAnimHelper.append(this.jdField_a_of_type_Int);
    paramNewVoteAnimHelper.append(HardCodeUtil.a(2131707148));
    setContentDescription(paramNewVoteAnimHelper.toString());
    if (!this.jdField_d_of_type_Boolean)
    {
      a(false, 4);
      if (paramBoolean3)
      {
        paramInt2 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramBoolean4) {
          paramInt1 = j;
        } else {
          paramInt1 = 2;
        }
        a(paramInt2, paramInt1);
      }
      paramNewVoteAnimHelper = this.jdField_b_of_type_AndroidWidgetTextView;
      paramList = new StringBuilder();
      paramList.append(this.jdField_a_of_type_Int);
      paramList.append("");
      paramNewVoteAnimHelper.setText(paramList.toString());
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramInt2 > 0) && (!this.e))
    {
      this.e = true;
      paramNewVoteAnimHelper = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt2);
      paramNewVoteAnimHelper.setText(((StringBuilder)localObject1).toString());
      a(false, 0);
      i = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("voteNum", -1);
      j = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("increaseNum", -1);
      if ((i != paramInt1) || (j != paramInt2))
      {
        paramNewVoteAnimHelper = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(jdField_d_of_type_Int, paramInt1, paramInt2, paramList);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          localObject1 = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
          localObject2 = new HashSet();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            TPraiseInfo localTPraiseInfo = (TPraiseInfo)localIterator.next();
            if (localTPraiseInfo.uCustomId > 0L) {
              ((Set)localObject2).add(Integer.valueOf((int)localTPraiseInfo.uCustomId));
            }
          }
          if (((PraiseManager)localObject1).a((Set)localObject2, new NearbyCardVoteView.2(this, paramInt1, paramInt2, paramList)))
          {
            paramNewVoteAnimHelper.sendToTarget();
            return;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramNewVoteAnimHelper, PraiseConfigHelper.jdField_b_of_type_Int);
          return;
        }
        paramNewVoteAnimHelper.sendToTarget();
      }
    }
    else
    {
      a(false, 0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = (PraiseManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      if (localObject != null) {
        ((PraiseManager)localObject).b(this);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setHeartLayout(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
  
  public void setIsTribe(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setNearbyPeopleCard(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView
 * JD-Core Version:    0.7.0.1
 */