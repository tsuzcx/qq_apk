package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;

public class VoteViewV2
  extends FrameLayout
  implements PraiseManager.OnPraiseLoadListener
{
  private double jdField_a_of_type_Double;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  PraiseAnimation jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation = new PraiseAnimation();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public VoteViewV2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Double = getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970531, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371051));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371052));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371053));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371050));
    Drawable localDrawable = getResources().getDrawable(2130843030);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    if (localDrawable != null)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = localDrawable.getIntrinsicWidth();
      localLayoutParams.height = localDrawable.getIntrinsicHeight();
    }
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 != PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (paramPraiseInfo == null) || (this.jdField_b_of_type_Boolean));
      a(paramPraiseInfo);
      paramPraiseInfo = (Pair)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    } while (paramPraiseInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, false, 0, ((Point)paramPraiseInfo.first).x, ((Point)paramPraiseInfo.first).y);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramPraiseInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramPraiseInfo.a);
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(false, false, this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(PraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation, 1.0F, 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130845924);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int j;
    int i;
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int > 0)) {
      if (paramBoolean)
      {
        j = 2130845924;
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(j);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label112;
        }
        localObject = "";
        label58:
        localTextView.setText((CharSequence)localObject);
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label139;
        }
        paramInt = 4;
        label77:
        ((TextView)localObject).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      return;
      j = 2130845931;
      i = this.jdField_a_of_type_Int - this.jdField_b_of_type_Int;
      break;
      label112:
      localObject = "+" + this.jdField_b_of_type_Int;
      break label58;
      label139:
      paramInt = 0;
      break label77;
      paramInt = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        i = paramInt;
        if (this.c) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        i = paramInt;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    label39:
    Object localObject;
    StateListDrawable localStateListDrawable;
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (paramInt2 <= this.jdField_a_of_type_Int) {
        break label377;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int % 20);
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break label399;
      }
      localObject = getResources().getDrawable(2130843030);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(-3382488));
      localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(-33744));
      setBackgroundDrawable(localStateListDrawable);
      label115:
      setContentDescription(String.format(getContext().getString(2131427380), new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      if (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) {
        break label465;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(false, false, (Drawable)localObject, getResources());
    }
    float f1;
    float f2;
    for (;;)
    {
      if ((!paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) && (!paramBoolean3))
      {
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 > 0)
        {
          localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208);
          ((PraiseManager)localObject).a(this);
          a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
        }
      }
      if (this.jdField_b_of_type_Boolean) {
        break label496;
      }
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.jdField_a_of_type_AndroidWidgetTextView.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(getContext(), 2130843035);
        }
        f1 = (float)(paramNewVoteAnimHelper[0] + this.jdField_a_of_type_AndroidWidgetTextView.getCompoundPaddingLeft() * 0.5D);
        f2 = paramNewVoteAnimHelper[1];
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 <= 0) {
          break label477;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, true, 0, f1, f2);
      }
      return;
      paramInt1 = 0;
      break;
      label377:
      if (paramInt2 < 0)
      {
        this.jdField_b_of_type_Int = 0;
        break label39;
      }
      this.jdField_b_of_type_Int = paramInt2;
      break label39;
      label399:
      localObject = getResources().getDrawable(2130843029);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(-1728053248));
      localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(1711276032));
      setBackgroundDrawable(localStateListDrawable);
      break label115;
      label465:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label477:
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), f1, f2);
    return;
    label496:
    if (paramNewVoteAnimHelper != null)
    {
      paramNewVoteAnimHelper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, null, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      a(this.c);
      return;
    }
    a(true, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).b(this);
    }
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2
 * JD-Core Version:    0.7.0.1
 */