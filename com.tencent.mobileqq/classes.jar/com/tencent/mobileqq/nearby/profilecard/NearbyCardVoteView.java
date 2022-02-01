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
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
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
  public static int c;
  public static int d;
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
  
  static
  {
    jdField_c_of_type_Int = 11;
    jdField_d_of_type_Int = 12;
  }
  
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
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(getContext());
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
    Object localObject = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Double * 50.0D), (int)(this.jdField_a_of_type_Double * 50.0D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845805);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_b_of_type_AndroidViewView = new SingleLineTextView(getContext());
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846200);
    this.jdField_b_of_type_AndroidViewView.setId(2131370359);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Double * 25.0D), (int)(this.jdField_a_of_type_Double * 25.0D));
    localLayoutParams.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(10);
    addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ((int)(2.0D * this.jdField_a_of_type_Double));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131369788);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850840);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject).getString(2131691230));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131372234);
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
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while (paramPraiseInfo == null);
      if ((!this.jdField_d_of_type_Boolean) && (paramInt1 == PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        a(paramPraiseInfo);
      }
      paramPraiseInfo = (Pair)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    } while (paramPraiseInfo == null);
    float f1 = ((Point)paramPraiseInfo.first).x;
    float f2 = ((Point)paramPraiseInfo.first).y;
    paramInt2 = ((Integer)paramPraiseInfo.second).intValue();
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a).a(), this, paramInt1, false, paramInt2, f1, f2);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramPraiseInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramPraiseInfo.a);
      paramPraiseInfo = (NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!paramPraiseInfo.c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_c_of_type_Boolean, bool, this.jdField_b_of_type_AndroidViewView.getBackground(), getResources());
      this.jdField_b_of_type_AndroidViewView.startAnimation(PraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation, 1.0F, 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    int j;
    int i;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int > 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130850831;
        i = this.jdField_a_of_type_Int;
        i = j;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).width = -2;
          ((RelativeLayout.LayoutParams)localObject).height = -2;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
          i = j;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
        if (localObject == null) {
          break label215;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label105:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label228;
        }
        localObject = "";
        label128:
        localTextView.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Int + "");
      return;
      j = 2130850834;
      i = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      i = j;
      if (localObject == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      i = j;
      break;
      label215:
      QLog.e("VoteView", 1, "mRedDotView.setLayoutParams(pa) pa == null");
      break label105;
      label228:
      localObject = "+" + this.jdField_b_of_type_Int;
      break label128;
      paramInt = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3, boolean paramBoolean4, List<TPraiseInfo> paramList)
  {
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      this.jdField_a_of_type_Int = i;
      if (paramInt2 <= this.jdField_a_of_type_Int) {
        break label371;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int % 20);
      label43:
      this.jdField_a_of_type_Int -= paramInt2;
      localObject = (NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      if ((this.jdField_d_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
        break label493;
      }
    }
    label371:
    int j;
    label493:
    do
    {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (((NearbyLikeLimitManager)localObject).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue())))
          {
            paramNewVoteAnimHelper = getResources().getDrawable(2130842789);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-13291);
            if (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) {
              break label568;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!((NearbyLikeLimitManager)localObject).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
              break label563;
            }
            paramBoolean1 = true;
            this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_c_of_type_Boolean, paramBoolean1, paramNewVoteAnimHelper, getResources());
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
            setContentDescription(this.jdField_a_of_type_Int + HardCodeUtil.a(2131707123));
            if (this.jdField_d_of_type_Boolean) {
              break label671;
            }
            a(false, 4);
            if (paramBoolean3)
            {
              paramInt2 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (!paramBoolean4) {
                break label666;
              }
              paramInt1 = 0;
              a(paramInt2, paramInt1);
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Int + "");
            return;
            i = 0;
            break;
            if (paramInt2 < 0)
            {
              this.jdField_b_of_type_Int = 0;
              break label43;
            }
            this.jdField_b_of_type_Int = paramInt2;
            break label43;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            paramNewVoteAnimHelper = getResources().getDrawable(2130845824);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-52924);
            continue;
          }
        }
        catch (NumberFormatException paramNewVoteAnimHelper)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VoteView", 2, paramNewVoteAnimHelper.toString(), paramNewVoteAnimHelper);
          }
          paramNewVoteAnimHelper = getResources().getDrawable(2130846200);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
          continue;
          paramNewVoteAnimHelper = getResources().getDrawable(2130846200);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
          continue;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130842791);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        else
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130845826);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
          continue;
          paramBoolean1 = false;
          continue;
          this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramNewVoteAnimHelper);
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
            paramNewVoteAnimHelper = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Double * 32.0D), (int)(this.jdField_a_of_type_Double * 32.0D));
            paramNewVoteAnimHelper.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double));
            paramNewVoteAnimHelper.addRule(14);
            paramNewVoteAnimHelper.addRule(10);
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramNewVoteAnimHelper);
            continue;
            paramInt1 = 2;
          }
        }
      }
      if ((this.jdField_b_of_type_Boolean) || (paramInt2 <= 0) || (this.e)) {
        break label953;
      }
      this.e = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + paramInt2);
      a(false, 0);
      i = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("voteNum", -1);
      j = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("increaseNum", -1);
    } while ((i == paramInt1) && (j == paramInt2));
    label563:
    label568:
    paramNewVoteAnimHelper = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(jdField_d_of_type_Int, paramInt1, paramInt2, paramList);
    label666:
    label671:
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramNewVoteAnimHelper.sendToTarget();
      return;
    }
    Object localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TPraiseInfo localTPraiseInfo = (TPraiseInfo)localIterator.next();
      if (localTPraiseInfo.uCustomId > 0L) {
        localHashSet.add(Integer.valueOf((int)localTPraiseInfo.uCustomId));
      }
    }
    if (((PraiseManager)localObject).a(localHashSet, new NearbyCardVoteView.2(this, paramInt1, paramInt2, paramList)))
    {
      paramNewVoteAnimHelper.sendToTarget();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramNewVoteAnimHelper, PraiseConfigHelper.jdField_b_of_type_Int);
    return;
    label953:
    a(false, 0);
  }
  
  public void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      PraiseManager localPraiseManager = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      if (localPraiseManager != null) {
        localPraiseManager.b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView
 * JD-Core Version:    0.7.0.1
 */