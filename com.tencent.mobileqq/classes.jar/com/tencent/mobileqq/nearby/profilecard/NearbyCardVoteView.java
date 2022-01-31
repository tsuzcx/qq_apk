package com.tencent.mobileqq.nearby.profilecard;

import SummaryCard.TPraiseInfo;
import alud;
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
import apit;
import astm;
import astn;
import asto;
import auvr;
import avjy;
import avjz;
import awsn;
import awsp;
import awsr;
import awss;
import bdaq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NearbyCardVoteView
  extends RelativeLayout
  implements awss
{
  public static int c;
  public static int d;
  private double jdField_a_of_type_Double;
  public int a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  public TextView a;
  asto jdField_a_of_type_Asto;
  awsn jdField_a_of_type_Awsn = new awsn();
  public QQAppInterface a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  static
  {
    jdField_c_of_type_Int = 11;
    jdField_d_of_type_Int = 12;
  }
  
  public NearbyCardVoteView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new avjy(this);
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new avjy(this);
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new avjy(this);
    a();
  }
  
  private void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Asto = new asto(getContext());
    this.jdField_a_of_type_Awsn.jdField_a_of_type_Asto = this.jdField_a_of_type_Asto;
    Object localObject = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Double * 50.0D), (int)(this.jdField_a_of_type_Double * 50.0D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845113);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_b_of_type_AndroidViewView = new SingleLineTextView(getContext());
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845479);
    this.jdField_b_of_type_AndroidViewView.setId(2131369430);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131368896);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130849811);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject).getString(2131691194));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371107);
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
    localObject = this.jdField_a_of_type_Asto.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a);
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, ((astm)localObject).a(), this, paramInt1, true, paramInt2, f1, f2);
      return;
    }
    if (paramInt2 == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(((astm)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (astm)localObject, f1 - bdaq.a(getContext(), 20.0F), f2 - bdaq.a(getContext(), 120.0F), bdaq.a(getContext(), 75.0F), bdaq.a(getContext(), 65.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(((astm)localObject).a(), f1, f2);
  }
  
  public void a(int paramInt1, awsr paramawsr, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while (paramawsr == null);
      if ((!this.jdField_d_of_type_Boolean) && (paramInt1 == PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        a(paramawsr);
      }
      paramawsr = (Pair)this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    } while (paramawsr == null);
    float f1 = ((Point)paramawsr.first).x;
    float f2 = ((Point)paramawsr.first).y;
    paramInt2 = ((Integer)paramawsr.second).intValue();
    this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_Asto.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a).a(), this, paramInt1, false, paramInt2, f1, f2);
    this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
  }
  
  public void a(awsr paramawsr)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramawsr != null) && (!this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramawsr.a);
      paramawsr = (auvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!paramawsr.c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Awsn.a(this.jdField_c_of_type_Boolean, bool, this.jdField_b_of_type_AndroidViewView.getBackground(), getResources());
      this.jdField_b_of_type_AndroidViewView.startAnimation(awsn.a(this.jdField_a_of_type_Awsn, 1.0F, 0.3F));
      this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean = true;
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
        j = 2130849802;
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
      j = 2130849805;
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, apit paramapit, boolean paramBoolean3, boolean paramBoolean4, List<TPraiseInfo> paramList)
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
      localObject = (auvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207);
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
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (((auvr)localObject).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue())))
          {
            paramapit = getResources().getDrawable(2130842245);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-13291);
            if (!this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean) {
              break label568;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!((auvr)localObject).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
              break label563;
            }
            paramBoolean1 = true;
            this.jdField_a_of_type_Awsn.a(this.jdField_c_of_type_Boolean, paramBoolean1, paramapit, getResources());
            if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean) && (!paramBoolean3))
            {
              i = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (i > 0)
              {
                paramapit = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209);
                paramapit.a(this);
                a(paramapit.a(i, true, "from_profile_card"));
              }
            }
            setContentDescription(this.jdField_a_of_type_Int + alud.a(2131707504));
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
            paramapit = getResources().getDrawable(2130845132);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-52924);
            continue;
          }
        }
        catch (NumberFormatException paramapit)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VoteView", 2, paramapit.toString(), paramapit);
          }
          paramapit = getResources().getDrawable(2130845479);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
          continue;
          paramapit = getResources().getDrawable(2130845479);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
          continue;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramapit = getResources().getDrawable(2130842247);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        else
        {
          paramapit = getResources().getDrawable(2130845134);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
          continue;
          paramBoolean1 = false;
          continue;
          this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramapit);
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
            paramapit = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Double * 32.0D), (int)(this.jdField_a_of_type_Double * 32.0D));
            paramapit.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double));
            paramapit.addRule(14);
            paramapit.addRule(10);
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramapit);
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
    paramapit = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(jdField_d_of_type_Int, paramInt1, paramInt2, paramList);
    label666:
    label671:
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramapit.sendToTarget();
      return;
    }
    Object localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TPraiseInfo localTPraiseInfo = (TPraiseInfo)localIterator.next();
      if (localTPraiseInfo.uCustomId > 0L) {
        localHashSet.add(Integer.valueOf((int)localTPraiseInfo.uCustomId));
      }
    }
    if (((PraiseManager)localObject).a(localHashSet, new avjz(this, paramInt1, paramInt2, paramList)))
    {
      paramapit.sendToTarget();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramapit, awsp.jdField_b_of_type_Int);
    return;
    label953:
    a(false, 0);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      PraiseManager localPraiseManager = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209);
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
    astn.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView
 * JD-Core Version:    0.7.0.1
 */