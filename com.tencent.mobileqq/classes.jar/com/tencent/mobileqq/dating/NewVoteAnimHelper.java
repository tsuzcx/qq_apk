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
  public static final int[] a = { 10, 25, 45, 60, 75, 100 };
  FloatViewBuilder b;
  public MqqHandler c = new CustomHandler(Looper.getMainLooper(), this);
  public boolean d = false;
  public boolean e = false;
  public NewVoteAnimHelper.NewVoteHolder f;
  public List<TPraiseInfo> g;
  public boolean h = false;
  public boolean i = false;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private double q;
  private Animation r;
  private Animation s;
  private AppInterface t;
  private Random u;
  private int v = -1;
  private int w = 0;
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.t = paramAppInterface;
    this.q = paramContext.getResources().getDisplayMetrics().density;
    this.l = paramInt;
    this.f = new NewVoteAnimHelper.NewVoteHolder();
  }
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAppInterface, paramInt1);
    this.w = paramInt2;
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
      localStringBuilder.append(HardCodeUtil.a(2131905417));
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.f.a()) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = null;
    if (this.l == 1) {
      if (this.f.d != null) {
        localLayoutParams = (RelativeLayout.LayoutParams)this.f.d.getLayoutParams();
      } else {
        localLayoutParams = (RelativeLayout.LayoutParams)this.f.c.getLayoutParams();
      }
    }
    int i1;
    Object localObject;
    if (!paramBoolean1)
    {
      this.f.a.setVisibility(8);
      this.f.b.setVisibility(8);
      i1 = this.m;
      paramInt = i1;
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = 0;
        paramInt = i1;
      }
    }
    else
    {
      localObject = (ViewGroup.MarginLayoutParams)this.f.a.getLayoutParams();
      int i2;
      int i4;
      int i3;
      if (paramBoolean2)
      {
        i2 = 2130852589;
        i1 = this.l;
        if (i1 == 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.q * 7.0D));
        }
        else if (i1 == 1)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(this.q * 3.0D + 0.5D));
        }
        else if (i1 == 2)
        {
          if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
          }
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
        }
        double d1 = this.q;
        ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(d1 * 6.0D + 0.5D));
        ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(d1 * 6.0D + 0.5D));
        this.f.b.setVisibility(8);
        i4 = this.m;
        i1 = i4;
        i3 = i2;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = 0;
          i1 = i4;
          i3 = i2;
        }
      }
      else
      {
        i1 = this.l;
        i2 = 2130852599;
        if (i1 == 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        }
        else
        {
          if (i1 == 1)
          {
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
          }
          do
          {
            i2 = 2130852592;
            break;
            if (i1 == 2)
            {
              if ((localObject instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams)localObject).addRule(15);
              }
              ((ViewGroup.MarginLayoutParams)localObject).leftMargin = DisplayUtil.a(this.t.getApplication(), 4.0F);
              break;
            }
          } while (i1 != 3);
        }
        ((ViewGroup.MarginLayoutParams)localObject).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject).height = -2;
        this.f.b.setVisibility(paramInt);
        TextView localTextView;
        StringBuilder localStringBuilder;
        if (this.w == 2)
        {
          localTextView = this.f.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(a(this.n));
          localTextView.setText(localStringBuilder.toString());
        }
        else
        {
          localTextView = this.f.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(this.n);
          localTextView.setText(localStringBuilder.toString());
        }
        i4 = this.m - this.n;
        i1 = i4;
        i3 = i2;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = ((int)(this.q * 15.0D + 0.5D));
          i3 = i2;
          i1 = i4;
        }
      }
      this.f.a.setBackgroundResource(i3);
      this.f.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.f.a.setVisibility(paramInt);
      paramInt = i1;
    }
    if (this.w == 2) {
      localObject = a(paramInt);
    } else {
      localObject = String.valueOf(paramInt);
    }
    if ((this.f.c instanceof TextView)) {
      ((TextView)this.f.c).setText((CharSequence)localObject);
    } else if ((this.f.c instanceof SingleLineTextView)) {
      ((SingleLineTextView)this.f.c).setText((CharSequence)localObject);
    }
    if (localLayoutParams != null)
    {
      if (this.f.d != null)
      {
        this.f.d.setLayoutParams(localLayoutParams);
        return;
      }
      this.f.c.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a()
  {
    DatingUtil.a("voteAnim", new Object[] { "reset" });
    this.c.removeCallbacksAndMessages(null);
    this.j = 0;
    this.k = 0;
    if ((this.f.a()) && (!this.i))
    {
      this.f.b.clearAnimation();
      this.f.a.clearAnimation();
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
        this.i = true;
      }
      int i3;
      if (paramInt1 >= 0) {
        i3 = paramInt1;
      } else {
        i3 = this.m;
      }
      if (paramInt2 >= 0) {
        i1 = paramInt2;
      } else {
        i1 = this.n;
      }
      if (i1 > i3)
      {
        i2 = i3 % 20;
      }
      else
      {
        i2 = i1;
        if (i1 < 0)
        {
          i1 = 0;
          break label93;
        }
      }
      int i1 = i2;
      label93:
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (i1 <= 0) {
        if (this.j != 0) {
          a();
        }
      }
      for (;;)
      {
        break;
        if ((this.m == i3) && (this.n == i1))
        {
          if ((this.j == 2) && ((this.e) || (this.h))) {
            this.j = 3;
          }
        }
        else
        {
          if ((this.w == 2) && (paramView2 != null)) {
            try
            {
              if (paramView2.getContext() != null)
              {
                Context localContext = paramView2.getContext();
                if (((localContext instanceof INearbyActivity)) && (((INearbyActivity)localContext).getNearbyAppInterface() != null) && ((((INearbyActivity)localContext).getNearbyAppInterface() instanceof INearbyAppInterface))) {
                  ((INearbyAppInterface)((INearbyActivity)localContext).getNearbyAppInterface()).getNearbyProcManager().a(this.t.getCurrentAccountUin());
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
          if ((this.j == 1) && (this.f.a(paramView1, paramTextView, paramView2, paramRelativeLayout, paramHeartLayout)))
          {
            this.o = paramInt1;
            this.p = paramInt2;
            if ((this.i) && (!VersionUtils.e()))
            {
              a();
              return;
            }
            if (!this.c.hasMessages(1)) {
              this.c.sendEmptyMessageDelayed(1, 3000L);
            }
            return;
          }
          a();
        }
      }
      paramInt1 = this.m;
      int i2 = this.n;
      int i4 = this.j;
      paramInt2 = 4;
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i1) });
      this.m = i3;
      paramInt1 = this.n;
      if (i1 - paramInt1 > 0) {
        paramInt1 = i1 - paramInt1;
      } else {
        paramInt1 = 0;
      }
      this.n = i1;
      NewVoteAnimHelper.NewVoteHolder localNewVoteHolder = this.f;
      localNewVoteHolder.c = paramView2;
      localNewVoteHolder.d = paramRelativeLayout;
      localNewVoteHolder.b = paramTextView;
      localNewVoteHolder.a = paramView1;
      localNewVoteHolder.e = paramHeartLayout;
      FloatViewBuilder.a(localNewVoteHolder.e);
      i1 = this.j;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return;
            }
            a(true, true, 0);
            return;
          }
          a(true, false, 0);
        }
      }
      else if (this.n > 0)
      {
        if (this.h)
        {
          a(true, true, 0);
          return;
        }
        if (this.i) {
          paramInt2 = 0;
        }
        a(true, false, paramInt2);
        if ((this.i) && ((paramInt1 <= 0) || (!VersionUtils.e()))) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        if (paramInt2 != 0)
        {
          this.c.removeMessages(0);
          paramView1 = this.c.obtainMessage(0, paramInt1, 0);
          boolean bool = this.i;
          long l1 = 1000L;
          if (bool)
          {
            paramTextView = this.g;
            if ((paramTextView != null) && (!paramTextView.isEmpty()))
            {
              paramTextView = (PraiseManager)this.t.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
              paramView2 = new HashSet();
              paramRelativeLayout = this.g.iterator();
              while (paramRelativeLayout.hasNext())
              {
                paramHeartLayout = (TPraiseInfo)paramRelativeLayout.next();
                if (paramHeartLayout.uCustomId > 0L) {
                  paramView2.add(Integer.valueOf((int)paramHeartLayout.uCustomId));
                }
              }
              if (paramTextView.a(paramView2, new NewVoteAnimHelper.1(this, paramInt1)))
              {
                this.c.sendMessageDelayed(paramView1, 1000L);
                break label885;
              }
              this.c.sendMessageDelayed(paramView1, PraiseConfigHelper.d);
              break label885;
            }
          }
          paramTextView = this.c;
          if (!this.i) {
            l1 = 1500L;
          }
          paramTextView.sendMessageDelayed(paramView1, l1);
          label885:
          this.j = 1;
          this.k = 0;
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
    this.j = 2;
    this.k = 0;
    if ((this.f.a()) && (!this.i))
    {
      this.f.b.clearAnimation();
      this.f.a.clearAnimation();
    }
    a(true, false, 0);
    if (!this.d)
    {
      this.d = true;
      AppInterface localAppInterface = this.t;
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
    DatingUtil.a("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.j), Integer.valueOf(this.k) });
    if (this.j == 1)
    {
      int i1 = this.k;
      if (i1 == 2)
      {
        b();
        return;
      }
      if (i1 == 0)
      {
        a();
        return;
      }
      this.c.removeCallbacksAndMessages(null);
      b();
    }
  }
  
  public void d()
  {
    if (this.c.hasMessages(3))
    {
      this.c.removeMessages(3);
      this.c.removeMessages(2);
      this.c.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    float f1 = 0.0F;
    int i2;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          i2 = paramMessage.arg1;
          if (i2 > 0)
          {
            int[] arrayOfInt = new int[2];
            if (this.f.d != null)
            {
              this.f.d.getLocationInWindow(arrayOfInt);
              paramMessage = this.f.d.findViewById(2131440579);
              if (paramMessage != null) {
                f1 = (paramMessage.getWidth() + this.f.d.getPaddingLeft()) * 0.5F;
              }
            }
            else
            {
              this.f.c.getLocationInWindow(arrayOfInt);
              if ((this.f.c instanceof SingleLineTextView)) {}
              for (i1 = ((SingleLineTextView)this.f.c).getCompoundPaddingLeft();; i1 = ((TextView)this.f.c).getCompoundPaddingLeft())
              {
                f1 = i1 * 0.5F;
                break;
                if (!(this.f.c instanceof TextView)) {
                  break;
                }
              }
            }
            f2 = arrayOfInt[0];
            if (this.b == null) {
              this.b = new FloatViewBuilder(this.t.getApplication(), 2130847550);
            }
            Object localObject1 = this.g;
            paramMessage = null;
            if ((localObject1 != null) && (i2 - 1 < ((List)localObject1).size()))
            {
              localObject1 = this.g;
              TPraiseInfo localTPraiseInfo = (TPraiseInfo)((List)localObject1).get(((List)localObject1).size() - i2);
              long l1;
              if (localTPraiseInfo == null) {
                l1 = 0L;
              } else {
                l1 = localTPraiseInfo.uCustomId;
              }
              if (l1 > 0L)
              {
                localObject3 = ((PraiseManager)this.t.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a((int)l1, true, "from_profile_card");
                localObject1 = localObject3;
                if (localObject3 == null) {
                  break label443;
                }
                if ((localTPraiseInfo.iIsPayed > 0) && (((PraiseInfo)localObject3).j != null))
                {
                  paramMessage = ((PraiseInfo)localObject3).j;
                  localObject1 = localObject3;
                  break label443;
                }
                paramMessage = ((PraiseInfo)localObject3).h;
                localObject1 = localObject3;
                break label443;
              }
              if ((localTPraiseInfo != null) && (localTPraiseInfo.iIsPayed > 0)) {
                try
                {
                  localObject3 = BitmapFactory.decodeResource(this.t.getApp().getResources(), 2130843642);
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
              localObject3 = this.b.b();
            }
            this.f.e.a((PraiseInfo)localObject2, (Bitmap)localObject3, f1 + f2, arrayOfInt[1]);
            int i3 = i2 - 1;
            if (i3 > 0)
            {
              paramMessage = this.c.obtainMessage(3, i3, 0);
              if (this.u == null) {
                this.u = new Random();
              }
              localObject2 = a;
              i2 = localObject2[this.u.nextInt(localObject2.length)];
              i1 = i2;
              if (i3 < 10.0D) {
                i1 = i2 * 2;
              }
              this.c.sendMessageDelayed(paramMessage, i1);
              return false;
            }
            this.c.sendEmptyMessageDelayed(2, 3100L);
            return false;
          }
          this.c.sendEmptyMessageDelayed(2, 100L);
          return false;
        }
        if ((this.j == 1) && (this.k == 1))
        {
          this.k = 2;
          b();
          return false;
        }
        c();
        return false;
      }
      a(this.o, this.p, this.f.a, this.f.b, this.f.c, this.f.d, this.f.e);
      return false;
    }
    if ((this.j == 1) && (this.k == 0) && (this.f.a()))
    {
      this.k = 1;
      if (this.i)
      {
        i2 = paramMessage.arg1;
        if (i2 > 0)
        {
          i1 = i2;
          if (i2 > 20) {
            i1 = 20;
          }
          i2 = this.w;
          if ((i2 != 1) && (i2 != 2))
          {
            this.c.obtainMessage(3, i1, 0).sendToTarget();
          }
          else
          {
            if (this.v == -1) {
              this.v = this.t.getApp().getSharedPreferences(this.t.getCurrentAccountUin(), 0).getInt("profilecard_host_last_newvote_animation_num", 0);
            }
            i2 = this.n;
            if ((i2 > 0) && (i2 != this.v))
            {
              this.c.obtainMessage(3, i1, 0).sendToTarget();
              this.v = this.n;
              this.t.getApp().getSharedPreferences(this.t.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", this.v).commit();
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
        if (this.l == 2)
        {
          f1 = 0.5F;
          f2 = 0.5F;
        }
        else
        {
          f1 = 1.0F;
          f2 = 1.0F;
        }
        paramMessage = this.r;
        if (paramMessage == null)
        {
          this.r = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, f2);
          this.r.setAnimationListener(this);
          this.r.setFillEnabled(true);
          this.r.setFillBefore(true);
          this.r.setDuration(400L);
        }
        else
        {
          paramMessage.reset();
        }
        this.f.a.clearAnimation();
        this.f.a.startAnimation(this.r);
        paramMessage = this.s;
        if (paramMessage == null)
        {
          this.s = new AlphaAnimation(0.0F, 1.0F);
          this.s.setAnimationListener(this);
          this.s.setFillEnabled(true);
          this.s.setFillBefore(true);
          this.s.setDuration(400L);
        }
        else
        {
          paramMessage.reset();
        }
        this.f.b.clearAnimation();
        this.f.b.startAnimation(this.s);
        this.c.sendEmptyMessageDelayed(2, 1100L);
      }
    }
    else
    {
      a();
    }
    DatingUtil.a("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.j), Integer.valueOf(this.k), this.f });
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == null) {
      return;
    }
    if ((paramAnimation == this.r) || (paramAnimation == this.s))
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramAnimation == this.r) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramAnimation == this.s) {
        bool2 = true;
      }
      DatingUtil.a("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.c.removeMessages(2);
      if ((this.k == 1) && (this.j == 1))
      {
        this.k = 2;
        b();
      }
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation != null)
    {
      if (!this.f.a()) {
        return;
      }
      if (paramAnimation == this.r)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_1" });
        this.f.a.setVisibility(0);
        return;
      }
      if (paramAnimation == this.s)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_2" });
        this.f.b.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NewVoteAnimHelper
 * JD-Core Version:    0.7.0.1
 */