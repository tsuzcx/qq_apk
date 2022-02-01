package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class VoteViewV2
  extends FrameLayout
  implements PraiseManager.OnPraiseLoadListener
{
  private double jdField_a_of_type_Double;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  PraiseAnimation jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation = new PraiseAnimation();
  private boolean jdField_a_of_type_Boolean;
  protected TextView b;
  private boolean b;
  protected TextView c;
  private boolean c;
  private boolean d = false;
  public int e;
  public int f;
  protected int g = 0;
  
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
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381000));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376322));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376323));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372362));
    Vote2RotateAnimation.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381003));
    a(1);
  }
  
  protected int a()
  {
    return 2131561392;
  }
  
  public void a()
  {
    if (SimpleUIUtil.a())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = false;
    if (!this.d)
    {
      VoteRotateAnimation.a();
      VasWebviewUtil.a(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.d = true;
    postDelayed(new VoteViewV2.1(this), 3000L);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    PraiseAnimation localPraiseAnimation;
    if (this.g == 1)
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846068);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846069);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167138));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167138));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        localPraiseAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
        localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -7894119);
      }
    }
    else
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846068);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846070);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167222));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167222));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        localPraiseAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
        localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -1);
      }
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      }
    }
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if ((paramInt1 == PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramPraiseInfo != null) && (!this.jdField_b_of_type_Boolean))
    {
      a(paramPraiseInfo);
      paramPraiseInfo = (Pair)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, false, 0, ((Point)paramPraiseInfo.first).x, ((Point)paramPraiseInfo.first).y);
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if (SimpleUIUtil.a())
    {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramPraiseInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) && (!this.d))
    {
      PraiseAnimation localPraiseAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
      localPraiseAnimation.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetImageView;
      localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramPraiseInfo.a);
      if (this.g == 1)
      {
        paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
        paramPraiseInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(paramPraiseInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -7894119);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(false, false, this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(PraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation, 1.0F, 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850767);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localViewGroup.setVisibility(i);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    int k = 4;
    int i;
    if (bool)
    {
      i = this.f;
      if (i > 0)
      {
        int j;
        if (paramBoolean)
        {
          j = 2130850767;
          i = this.e;
        }
        else
        {
          i = this.e - i;
          j = 2130850777;
        }
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(j);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramBoolean)
        {
          localObject = "";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("+");
          ((StringBuilder)localObject).append(this.f);
          localObject = ((StringBuilder)localObject).toString();
        }
        localTextView.setText((CharSequence)localObject);
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramBoolean) {
          paramInt = k;
        } else {
          paramInt = 0;
        }
        ((TextView)localObject).setVisibility(paramInt);
        break label187;
      }
    }
    paramInt = this.e;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramInt;
      if (this.jdField_c_of_type_Boolean) {}
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      i = paramInt;
    }
    label187:
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    this.e = paramInt1;
    paramInt1 = this.e;
    if (paramInt2 > paramInt1) {
      this.f = (paramInt1 % 20);
    } else if (paramInt2 < 0) {
      this.f = 0;
    } else {
      this.f = paramInt2;
    }
    Object localObject;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      localObject = getResources().getDrawable(2130846068);
    } else if (this.g == 1) {
      localObject = getResources().getDrawable(2130846069);
    } else {
      localObject = getResources().getDrawable(2130846070);
    }
    setContentDescription(String.format(getContext().getString(2131691167), new Object[] { String.valueOf(this.e) }));
    if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(false, false, (Drawable)localObject, getResources());
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if ((!paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) && (!paramBoolean3) && (!this.d))
    {
      paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt1 > 0)
      {
        localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        ((PraiseManager)localObject).a(this);
        a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
      }
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.jdField_b_of_type_AndroidWidgetTextView.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(getContext(), 2130846080);
        }
        double d1 = paramNewVoteAnimHelper[0];
        double d2 = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundPaddingLeft();
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (float)(d1 + d2 * 0.5D);
        float f2 = paramNewVoteAnimHelper[1];
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, true, 0, f1, f2);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), f1, f2);
      }
    }
    else
    {
      if (paramNewVoteAnimHelper != null)
      {
        paramNewVoteAnimHelper.a(this.e, this.f, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
        a(this.jdField_c_of_type_Boolean);
        return;
      }
      a(true, 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((PraiseManager)localQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).b(this);
    }
    this.d = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2
 * JD-Core Version:    0.7.0.1
 */