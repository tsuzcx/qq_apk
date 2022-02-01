package com.tencent.mobileqq.dating;

import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.INearbyActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import com.tencent.util.VersionUtils;
import com.tencent.widget.SingleLineTextView;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;

public class NewVoteAnimHelper
  extends AnimateUtils.AnimationAdapter
  implements Handler.Callback
{
  public static final int[] a;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public NewVoteAnimHelper.NewVoteHolder a;
  FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  public List<TPraiseInfo> a;
  private Random jdField_a_of_type_JavaUtilRandom;
  public MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public boolean b;
  private int c;
  public boolean c;
  private int d;
  public boolean d;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  private int i = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 10, 25, 45, 60, 75, 100 };
  }
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Double = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder = new NewVoteAnimHelper.NewVoteHolder();
  }
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAppInterface, paramInt1);
    this.i = paramInt2;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt / 10000 >= 1.0D)
    {
      DecimalFormat localDecimalFormat;
      if (paramInt % 10000 > 1000) {
        localDecimalFormat = new DecimalFormat("#.#");
      } else {
        localDecimalFormat = new DecimalFormat("#");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localDecimalFormat.format(paramInt / 10000.0F));
      localStringBuilder.append(HardCodeUtil.a(2131707602));
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = null;
    if (this.jdField_c_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      } else {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.getLayoutParams();
      }
    }
    int j;
    Object localObject;
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      j = this.jdField_d_of_type_Int;
      paramInt = j;
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = 0;
        paramInt = j;
      }
    }
    else
    {
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int k;
      int n;
      int m;
      if (paramBoolean2)
      {
        k = 2130850767;
        j = this.jdField_c_of_type_Int;
        if (j == 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.jdField_a_of_type_Double * 7.0D));
        }
        else if (j == 1)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_Double * 3.0D + 0.5D));
        }
        else if (j == 2)
        {
          if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
          }
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
        }
        double d1 = this.jdField_a_of_type_Double;
        ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(d1 * 6.0D + 0.5D));
        ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(d1 * 6.0D + 0.5D));
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        n = this.jdField_d_of_type_Int;
        j = n;
        m = k;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = 0;
          j = n;
          m = k;
        }
      }
      else
      {
        j = this.jdField_c_of_type_Int;
        k = 2130850777;
        if (j == 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        }
        else
        {
          if (j == 1)
          {
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
          }
          do
          {
            k = 2130850770;
            break;
            if (j == 2)
            {
              if ((localObject instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams)localObject).addRule(15);
              }
              ((ViewGroup.MarginLayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 4.0F);
              break;
            }
          } while (j != 3);
        }
        ((ViewGroup.MarginLayoutParams)localObject).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject).height = -2;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
        TextView localTextView;
        StringBuilder localStringBuilder;
        if (this.i == 2)
        {
          localTextView = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(a(this.e));
          localTextView.setText(localStringBuilder.toString());
        }
        else
        {
          localTextView = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(this.e);
          localTextView.setText(localStringBuilder.toString());
        }
        n = this.jdField_d_of_type_Int - this.e;
        j = n;
        m = k;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Double * 15.0D + 0.5D));
          m = k;
          j = n;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(m);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
      paramInt = j;
    }
    if (this.i == 2) {
      localObject = a(paramInt);
    } else {
      localObject = String.valueOf(paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b instanceof TextView)) {
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b).setText((CharSequence)localObject);
    } else if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b instanceof SingleLineTextView)) {
      ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b).setText((CharSequence)localObject);
    }
    if (localLayoutParams != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a()
  {
    DatingUtil.a("voteAnim", new Object[] { "reset" });
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(false, false, 8);
  }
  
  public void a(int paramInt1, int paramInt2, View paramView1, TextView paramTextView, View paramView2, RelativeLayout paramRelativeLayout, HeartLayout paramHeartLayout)
  {
    if ((paramView1 != null) && (paramTextView != null))
    {
      if (paramView2 == null) {
        return;
      }
      if (paramHeartLayout != null) {
        this.jdField_d_of_type_Boolean = true;
      }
      int m;
      if (paramInt1 >= 0) {
        m = paramInt1;
      } else {
        m = this.jdField_d_of_type_Int;
      }
      if (paramInt2 >= 0) {
        j = paramInt2;
      } else {
        j = this.e;
      }
      if (j > m)
      {
        k = m % 20;
      }
      else
      {
        k = j;
        if (j < 0)
        {
          j = 0;
          break label93;
        }
      }
      int j = k;
      label93:
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (j <= 0) {
        if (this.jdField_a_of_type_Int != 0) {
          a();
        }
      }
      for (;;)
      {
        break;
        if ((this.jdField_d_of_type_Int == m) && (this.e == j))
        {
          if ((this.jdField_a_of_type_Int == 2) && ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean))) {
            this.jdField_a_of_type_Int = 3;
          }
        }
        else
        {
          if ((this.i == 2) && (paramView2 != null)) {
            try
            {
              if (paramView2.getContext() != null)
              {
                Context localContext = paramView2.getContext();
                if (((localContext instanceof INearbyActivity)) && (((INearbyActivity)localContext).getNearbyAppInterface() != null) && ((((INearbyActivity)localContext).getNearbyAppInterface() instanceof INearbyAppInterface))) {
                  ((INearbyAppInterface)((INearbyActivity)localContext).getNearbyAppInterface()).getNearbyProcManager().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
                }
              }
            }
            catch (Throwable localThrowable)
            {
              if (QLog.isColorLevel()) {
                QLog.e("NewVote err :FROM_NEARBY_PROFILE_CARD", 2, localThrowable, new Object[0]);
              }
            }
          }
          if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a(paramView1, paramTextView, paramView2, paramRelativeLayout, paramHeartLayout)))
          {
            this.f = paramInt1;
            this.g = paramInt2;
            if ((this.jdField_d_of_type_Boolean) && (!VersionUtils.e()))
            {
              a();
              return;
            }
            if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
            }
            return;
          }
          a();
        }
      }
      paramInt1 = this.jdField_d_of_type_Int;
      int k = this.e;
      int n = this.jdField_a_of_type_Int;
      paramInt2 = 4;
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(j) });
      this.jdField_d_of_type_Int = m;
      paramInt1 = this.e;
      if (j - paramInt1 > 0) {
        paramInt1 = j - paramInt1;
      } else {
        paramInt1 = 0;
      }
      this.e = j;
      NewVoteAnimHelper.NewVoteHolder localNewVoteHolder = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder;
      localNewVoteHolder.b = paramView2;
      localNewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
      localNewVoteHolder.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
      localNewVoteHolder.jdField_a_of_type_AndroidViewView = paramView1;
      localNewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
      FloatViewBuilder.a(localNewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      j = this.jdField_a_of_type_Int;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3) {
              return;
            }
            a(true, true, 0);
            return;
          }
          a(true, false, 0);
        }
      }
      else if (this.e > 0)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          a(true, true, 0);
          return;
        }
        if (this.jdField_d_of_type_Boolean) {
          paramInt2 = 0;
        }
        a(true, false, paramInt2);
        if ((this.jdField_d_of_type_Boolean) && ((paramInt1 <= 0) || (!VersionUtils.e()))) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        if (paramInt2 != 0)
        {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
          paramView1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, 0);
          boolean bool = this.jdField_d_of_type_Boolean;
          long l = 1000L;
          if (bool)
          {
            paramTextView = this.jdField_a_of_type_JavaUtilList;
            if ((paramTextView != null) && (!paramTextView.isEmpty()))
            {
              paramTextView = (PraiseManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
              paramView2 = new HashSet();
              paramRelativeLayout = this.jdField_a_of_type_JavaUtilList.iterator();
              while (paramRelativeLayout.hasNext())
              {
                paramHeartLayout = (TPraiseInfo)paramRelativeLayout.next();
                if (paramHeartLayout.uCustomId > 0L) {
                  paramView2.add(Integer.valueOf((int)paramHeartLayout.uCustomId));
                }
              }
              if (paramTextView.a(paramView2, new NewVoteAnimHelper.1(this, paramInt1)))
              {
                this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView1, 1000L);
                break label885;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView1, PraiseConfigHelper.jdField_b_of_type_Int);
              break label885;
            }
          }
          paramTextView = this.jdField_a_of_type_MqqOsMqqHandler;
          if (!this.jdField_d_of_type_Boolean) {
            l = 1500L;
          }
          paramTextView.sendMessageDelayed(paramView1, l);
          label885:
          this.jdField_a_of_type_Int = 1;
          this.jdField_b_of_type_Int = 0;
        }
      }
      else
      {
        a(false, false, 8);
      }
    }
  }
  
  protected void b()
  {
    DatingUtil.a("voteAnim", new Object[] { "finishAnim" });
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(true, false, 0);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if ((localAppInterface instanceof INearbyAppInterface))
      {
        ((INearbyAppInterface)localAppInterface).reportClickEventAsync("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
        return;
      }
      AppIntefaceReportWrap.a(localAppInterface, "CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
    }
  }
  
  public void c()
  {
    DatingUtil.a("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    if (this.jdField_a_of_type_Int == 1)
    {
      int j = this.jdField_b_of_type_Int;
      if (j == 2)
      {
        b();
        return;
      }
      if (j == 0)
      {
        a();
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    float f1 = 0.0F;
    int k;
    float f2;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
          k = paramMessage.arg1;
          if (k > 0)
          {
            int[] arrayOfInt = new int[2];
            if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(arrayOfInt);
              paramMessage = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373010);
              if (paramMessage != null) {
                f1 = (paramMessage.getWidth() + this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft()) * 0.5F;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.getLocationInWindow(arrayOfInt);
              if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b instanceof SingleLineTextView)) {}
              for (j = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b).getCompoundPaddingLeft();; j = ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b).getCompoundPaddingLeft())
              {
                f1 = j * 0.5F;
                break;
                if (!(this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b instanceof TextView)) {
                  break;
                }
              }
            }
            f2 = arrayOfInt[0];
            if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2130846080);
            }
            Object localObject1 = this.jdField_a_of_type_JavaUtilList;
            paramMessage = null;
            if ((localObject1 != null) && (k - 1 < ((List)localObject1).size()))
            {
              localObject1 = this.jdField_a_of_type_JavaUtilList;
              TPraiseInfo localTPraiseInfo = (TPraiseInfo)((List)localObject1).get(((List)localObject1).size() - k);
              long l;
              if (localTPraiseInfo == null) {
                l = 0L;
              } else {
                l = localTPraiseInfo.uCustomId;
              }
              if (l > 0L)
              {
                localObject3 = ((PraiseManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a((int)l, true, "from_profile_card");
                localObject1 = localObject3;
                if (localObject3 == null) {
                  break label443;
                }
                if ((localTPraiseInfo.iIsPayed > 0) && (((PraiseInfo)localObject3).c != null))
                {
                  paramMessage = ((PraiseInfo)localObject3).c;
                  localObject1 = localObject3;
                  break label443;
                }
                paramMessage = ((PraiseInfo)localObject3).b;
                localObject1 = localObject3;
                break label443;
              }
              if ((localTPraiseInfo != null) && (localTPraiseInfo.iIsPayed > 0)) {
                try
                {
                  localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), 2130842689);
                  localObject1 = null;
                  paramMessage = (Message)localObject3;
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  QLog.e("NewVoteAnimHelper", 1, localOutOfMemoryError, new Object[0]);
                }
              }
            }
            Object localObject2 = null;
            label443:
            Object localObject3 = paramMessage;
            if (paramMessage == null) {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b();
            }
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a((PraiseInfo)localObject2, (Bitmap)localObject3, f1 + f2, arrayOfInt[1]);
            int m = k - 1;
            if (m > 0)
            {
              paramMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, m, 0);
              if (this.jdField_a_of_type_JavaUtilRandom == null) {
                this.jdField_a_of_type_JavaUtilRandom = new Random();
              }
              localObject2 = jdField_a_of_type_ArrayOfInt;
              k = localObject2[this.jdField_a_of_type_JavaUtilRandom.nextInt(localObject2.length)];
              j = k;
              if (m < 10.0D) {
                j = k * 2;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, j);
              return false;
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 3100L);
            return false;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 100L);
          return false;
        }
        if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1))
        {
          this.jdField_b_of_type_Int = 2;
          b();
          return false;
        }
        c();
        return false;
      }
      a(this.f, this.g, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      return false;
    }
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()))
    {
      this.jdField_b_of_type_Int = 1;
      if (this.jdField_d_of_type_Boolean)
      {
        k = paramMessage.arg1;
        if (k > 0)
        {
          j = k;
          if (k > 20) {
            j = 20;
          }
          k = this.i;
          if ((k != 1) && (k != 2))
          {
            this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, j, 0).sendToTarget();
          }
          else
          {
            if (this.h == -1) {
              this.h = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).getInt("profilecard_host_last_newvote_animation_num", 0);
            }
            k = this.e;
            if ((k > 0) && (k != this.h))
            {
              this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, j, 0).sendToTarget();
              this.h = this.e;
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", this.h).commit();
            }
          }
        }
        else
        {
          a();
        }
      }
      else
      {
        if (this.jdField_c_of_type_Int == 2)
        {
          f1 = 0.5F;
          f2 = 0.5F;
        }
        else
        {
          f1 = 1.0F;
          f2 = 1.0F;
        }
        paramMessage = this.jdField_a_of_type_AndroidViewAnimationAnimation;
        if (paramMessage == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, f2);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        }
        else
        {
          paramMessage.reset();
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramMessage = this.jdField_b_of_type_AndroidViewAnimationAnimation;
        if (paramMessage == null)
        {
          this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        }
        else
        {
          paramMessage.reset();
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1100L);
      }
    }
    else
    {
      a();
    }
    DatingUtil.a("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder });
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == null) {
      return;
    }
    if ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) || (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
        bool2 = true;
      }
      DatingUtil.a("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_b_of_type_Int = 2;
        b();
      }
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) {
        return;
      }
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_1" });
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_2" });
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NewVoteAnimHelper
 * JD-Core Version:    0.7.0.1
 */