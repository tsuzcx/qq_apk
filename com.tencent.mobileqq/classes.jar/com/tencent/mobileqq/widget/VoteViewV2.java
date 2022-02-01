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
  private Context a;
  private LayoutInflater b;
  private double c;
  private ViewGroup d;
  private TextView e;
  private HeartLayout f;
  private FloatViewBuilder g;
  private boolean h;
  QQAppInterface i;
  protected TextView j;
  protected ImageView k;
  protected TextView l;
  public int m;
  public int n;
  protected int o = 0;
  PraiseAnimation p = new PraiseAnimation();
  private boolean q;
  private boolean r;
  private boolean s = false;
  
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
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = getResources().getDisplayMetrics().density;
    b();
  }
  
  private void b()
  {
    this.b.inflate(getLayout(), this);
    this.j = ((TextView)findViewById(2131449995));
    this.d = ((ViewGroup)findViewById(2131444535));
    this.e = ((TextView)findViewById(2131444536));
    this.l = ((TextView)findViewById(2131439880));
    Vote2RotateAnimation.a();
    this.k = ((ImageView)findViewById(2131449998));
    a(1);
  }
  
  public void a()
  {
    if (SimpleUIUtil.e())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.p.f = false;
    if (!this.s)
    {
      VoteRotateAnimation.a();
      VasWebviewUtil.a(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.s = true;
    postDelayed(new VoteViewV2.1(this), 3000L);
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
    PraiseAnimation localPraiseAnimation;
    if (this.o == 1)
    {
      if ((!this.q) && (this.h)) {
        this.k.setImageResource(2130847538);
      } else {
        this.k.setImageResource(2130847539);
      }
      this.j.setTextColor(this.a.getResources().getColor(2131168118));
      this.l.setTextColor(this.a.getResources().getColor(2131168118));
      if (this.p.e != null)
      {
        localPraiseAnimation = this.p;
        localPraiseAnimation.e = ImageUtil.a(localPraiseAnimation.e, -7894119);
      }
    }
    else
    {
      if ((!this.q) && (this.h)) {
        this.k.setImageResource(2130847538);
      } else {
        this.k.setImageResource(2130847540);
      }
      this.j.setTextColor(this.a.getResources().getColor(2131168212));
      this.l.setTextColor(this.a.getResources().getColor(2131168212));
      if (this.p.e != null)
      {
        localPraiseAnimation = this.p;
        localPraiseAnimation.e = ImageUtil.a(localPraiseAnimation.e, -1);
      }
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.k.setColorFilter(1996488704);
        this.j.setTextColor(getResources().getColor(2131167993));
      }
    }
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if ((paramInt1 == PraiseManager.a(this.i)) && (paramPraiseInfo != null) && (!this.q))
    {
      a(paramPraiseInfo);
      paramPraiseInfo = (Pair)this.p.h.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        this.p.a(this.i, this.f, this.g.b(), this, paramInt1, false, 0, ((Point)paramPraiseInfo.first).x, ((Point)paramPraiseInfo.first).y);
        this.p.h.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if (SimpleUIUtil.e())
    {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
      return;
    }
    if ((!this.q) && (paramPraiseInfo != null) && (!this.p.f) && (!this.s))
    {
      PraiseAnimation localPraiseAnimation = this.p;
      localPraiseAnimation.c = this.k;
      localPraiseAnimation.e = new BitmapDrawable(getResources(), paramPraiseInfo.f);
      if (this.o == 1)
      {
        paramPraiseInfo = this.p;
        paramPraiseInfo.e = ImageUtil.a(paramPraiseInfo.e, -7894119);
      }
      this.p.a(false, false, this.k.getDrawable(), getResources());
      this.k.startAnimation(PraiseAnimation.a(this.p, 1.0F, 0.3F));
      this.p.f = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
    if (this.d.getVisibility() == 0) {
      return;
    }
    this.d.setBackgroundResource(2130852589);
    ViewGroup localViewGroup = this.d;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localViewGroup.setVisibility(i1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = this.q;
    int i3 = 4;
    int i1;
    if (bool)
    {
      i1 = this.n;
      if (i1 > 0)
      {
        int i2;
        if (paramBoolean)
        {
          i2 = 2130852589;
          i1 = this.m;
        }
        else
        {
          i1 = this.m - i1;
          i2 = 2130852599;
        }
        this.d.setBackgroundResource(i2);
        this.d.setVisibility(paramInt);
        TextView localTextView = this.e;
        if (paramBoolean)
        {
          localObject = "";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("+");
          ((StringBuilder)localObject).append(this.n);
          localObject = ((StringBuilder)localObject).toString();
        }
        localTextView.setText((CharSequence)localObject);
        Object localObject = this.e;
        if (paramBoolean) {
          paramInt = i3;
        } else {
          paramInt = 0;
        }
        ((TextView)localObject).setVisibility(paramInt);
        break label187;
      }
    }
    paramInt = this.m;
    if (this.q)
    {
      i1 = paramInt;
      if (this.r) {}
    }
    else
    {
      this.d.setVisibility(4);
      i1 = paramInt;
    }
    label187:
    this.j.setText(String.valueOf(i1));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.q = paramBoolean1;
    this.h = paramBoolean2;
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    this.m = paramInt1;
    paramInt1 = this.m;
    if (paramInt2 > paramInt1) {
      this.n = (paramInt1 % 20);
    } else if (paramInt2 < 0) {
      this.n = 0;
    } else {
      this.n = paramInt2;
    }
    Object localObject;
    if ((!this.q) && (this.h)) {
      localObject = getResources().getDrawable(2130847538);
    } else if (this.o == 1) {
      localObject = getResources().getDrawable(2130847539);
    } else {
      localObject = getResources().getDrawable(2130847540);
    }
    setContentDescription(String.format(getContext().getString(2131888113), new Object[] { String.valueOf(this.m) }));
    if (this.p.f) {
      this.p.a(false, false, (Drawable)localObject, getResources());
    } else {
      this.k.setImageDrawable((Drawable)localObject);
    }
    if ((!paramBoolean1) && (!this.p.f) && (!paramBoolean3) && (!this.s))
    {
      paramInt1 = PraiseManager.a(this.i);
      if (paramInt1 > 0)
      {
        localObject = (PraiseManager)this.i.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        ((PraiseManager)localObject).a(this);
        a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
      }
    }
    if (!this.q)
    {
      a(false, 4);
      if ((paramBoolean3) && (this.f != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.j.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.g == null) {
          this.g = new FloatViewBuilder(getContext(), 2130847550);
        }
        double d1 = paramNewVoteAnimHelper[0];
        double d2 = this.j.getCompoundPaddingLeft();
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (float)(d1 + d2 * 0.5D);
        float f2 = paramNewVoteAnimHelper[1];
        paramInt1 = PraiseManager.a(this.i);
        if (paramInt1 > 0)
        {
          this.p.a(this.i, this.f, this.g.b(), this, paramInt1, true, 0, f1, f2);
          return;
        }
        this.f.a(this.g.b(), f1, f2);
      }
    }
    else
    {
      if (paramNewVoteAnimHelper != null)
      {
        paramNewVoteAnimHelper.a(this.m, this.n, this.d, this.e, this.j, null, this.f);
        a(this.r);
        return;
      }
      a(true, 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.f;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected int getLayout()
  {
    return 2131627748;
  }
  
  protected void onDetachedFromWindow()
  {
    QQAppInterface localQQAppInterface = this.i;
    if (localQQAppInterface != null) {
      ((PraiseManager)localQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).b(this);
    }
    this.s = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.i = paramQQAppInterface;
    this.f = paramHeartLayout;
    FloatViewBuilder.a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2
 * JD-Core Version:    0.7.0.1
 */