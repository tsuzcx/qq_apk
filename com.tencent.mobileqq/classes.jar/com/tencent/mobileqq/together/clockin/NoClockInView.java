package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder.OnQQAvatarFHDListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

public class NoClockInView
  extends ClockView
  implements View.OnClickListener, QQAvatarFHDDecoder.OnQQAvatarFHDListener, Observer
{
  boolean a = false;
  private Context b;
  private QQAppInterface c;
  private ClockInData d;
  private FrameLayout e;
  private RelativeLayout f;
  private RoundRectUrlImageView g;
  private RoundRectUrlImageView h;
  private RoundRectUrlImageView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private LinearLayout m;
  private TextView n;
  private View o;
  private TextView p;
  private Button q;
  private LinearLayout r;
  private ImageView s;
  private TextView t;
  private TextView u;
  private ClockInCallback v;
  private QQAvatarFHDDecoder w;
  private Rotate3dAnimation x = null;
  
  public NoClockInView(Context paramContext, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, ClockInData paramClockInData, ClockInCallback paramClockInCallback, ClockAnimController paramClockAnimController)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.c = paramQQAppInterface;
    this.b = paramContext;
    this.e = paramFrameLayout;
    this.d = paramClockInData;
    this.v = paramClockInCallback;
    c();
  }
  
  private String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return this.b.getString(2131917417);
    case 6: 
      return this.b.getString(2131917416);
    case 5: 
      return this.b.getString(2131917415);
    case 4: 
      return this.b.getString(2131917414);
    case 3: 
      return this.b.getString(2131917413);
    case 2: 
      return this.b.getString(2131917412);
    }
    return this.b.getString(2131917418);
  }
  
  private void c()
  {
    if (this.c != null)
    {
      Object localObject = this.b;
      if ((localObject != null) && (this.e != null) && (this.f == null))
      {
        this.f = ((RelativeLayout)LayoutInflater.from((Context)localObject).inflate(2131627655, null));
        localObject = this.f;
        if (localObject == null) {
          return;
        }
        this.e.addView((View)localObject);
        this.g = ((RoundRectUrlImageView)this.f.findViewById(2131429397));
        this.i = ((RoundRectUrlImageView)this.f.findViewById(2131429405));
        this.h = ((RoundRectUrlImageView)this.f.findViewById(2131429412));
        this.j = ((TextView)this.f.findViewById(2131431604));
        this.k = ((TextView)this.f.findViewById(2131431613));
        this.l = ((TextView)this.f.findViewById(2131431623));
        this.m = ((LinearLayout)this.f.findViewById(2131430801));
        this.n = ((TextView)this.f.findViewById(2131430802));
        this.o = this.f.findViewById(2131430804);
        this.p = ((TextView)this.f.findViewById(2131430803));
        this.r = ((LinearLayout)this.f.findViewById(2131433195));
        this.s = ((ImageView)this.f.findViewById(2131434905));
        this.t = ((TextView)this.f.findViewById(2131433194));
        this.u = ((TextView)this.f.findViewById(2131433193));
        this.q = ((Button)this.f.findViewById(2131430795));
        this.q.setTag(Integer.valueOf(2131430795));
        this.q.setOnClickListener(this);
        e();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NoClockInView", 2, "init failed");
    }
  }
  
  private boolean d()
  {
    return (this.c != null) && (this.b != null) && (this.f != null) && (this.d != null) && (this.e != null) && (this.g != null) && (this.h != null) && (this.i != null) && (this.j != null) && (this.k != null) && (this.l != null) && (this.m != null) && (this.n != null) && (this.o != null) && (this.p != null) && (this.r != null) && (this.t != null) && (this.s != null) && (this.u != null) && (this.q != null);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NoClockInView", 2, "updateUI");
    }
    if (d())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkData true");
        localStringBuilder.append(this.d.toString());
        QLog.d("NoClockInView", 2, localStringBuilder.toString());
      }
      f();
      g();
      h();
    }
  }
  
  private void f()
  {
    if (i())
    {
      if (this.w == null) {
        this.w = new QQAvatarFHDDecoder(this.c);
      }
      this.g.setAllRadius(ViewUtils.dpToPx(16.0F));
      this.w.a(this.d.d, false, this);
      this.g.setVisibility(0);
      this.i.setAllRadius(ViewUtils.dpToPx(16.0F));
      this.i.setVisibility(0);
      this.h.setAllRadius(ViewUtils.dpToPx(16.0F));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (!TextUtils.isEmpty(this.d.g))
      {
        localObject = URLDrawable.getDrawable(this.d.g, (URLDrawable.URLDrawableOptions)localObject);
        this.h.setImageDrawable((Drawable)localObject);
        this.h.setVisibility(0);
        return;
      }
      this.h.setVisibility(8);
      return;
    }
    this.g.setAllRadius(ViewUtils.dpToPx(16.0F));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(this.d.g))
    {
      localObject = URLDrawable.getDrawable(this.d.g, (URLDrawable.URLDrawableOptions)localObject);
      this.g.setImageDrawable((Drawable)localObject);
      this.g.setVisibility(0);
    }
    else
    {
      this.g.setVisibility(8);
    }
    this.h.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void g()
  {
    if (i())
    {
      Object localObject = ImageUtil.j();
      localObject = FaceDrawable.getFaceDrawable(this.c, 1, this.d.d, 4, (Drawable)localObject, (Drawable)localObject);
      Drawable localDrawable = this.s.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable)) && (localDrawable != localObject)) {
        ((FaceDrawable)localDrawable).cancel();
      }
      this.s.setImageDrawable((Drawable)localObject);
      if (!TextUtils.isEmpty(this.d.e)) {
        this.t.setText(this.d.e);
      }
      if (!TextUtils.isEmpty(this.d.f)) {
        this.u.setText(this.d.f);
      }
      this.r.setVisibility(0);
      return;
    }
    this.r.setVisibility(8);
  }
  
  private void h()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(2) + 1;
    int i2 = localCalendar.get(5);
    TextView localTextView = this.j;
    StringBuilder localStringBuilder;
    if (i2 < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
    }
    localStringBuilder.append(i2);
    localTextView.setText(localStringBuilder.toString());
    localTextView = this.k;
    if (i1 < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
    }
    localStringBuilder.append(i1);
    localTextView.setText(localStringBuilder.toString());
    this.l.setText(c(localCalendar.get(7)));
    if (!TextUtils.isEmpty(this.d.j)) {
      this.q.setText(this.d.j);
    }
    if ((TextUtils.isEmpty(this.d.h)) && (TextUtils.isEmpty(this.d.i)))
    {
      this.m.setVisibility(8);
      return;
    }
    this.m.setVisibility(0);
    if ((!TextUtils.isEmpty(this.d.h)) && (!TextUtils.isEmpty(this.d.i))) {
      this.o.setVisibility(0);
    } else {
      this.o.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.d.h))
    {
      this.n.setVisibility(0);
      this.n.setText(this.d.h);
    }
    else
    {
      this.n.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.d.i))
    {
      this.p.setVisibility(0);
      this.p.setText(this.d.i);
      return;
    }
    this.p.setVisibility(8);
  }
  
  private boolean i()
  {
    ClockInData localClockInData = this.d;
    return (localClockInData != null) && (!TextUtils.isEmpty(localClockInData.d));
  }
  
  private void j()
  {
    ClockInCallback localClockInCallback = this.v;
    if (localClockInCallback != null) {
      localClockInCallback.a();
    }
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = this.f;
    if (localRelativeLayout != null)
    {
      if (this.b == null) {
        return;
      }
      if (this.x == null)
      {
        float f1 = localRelativeLayout.getWidth() / 2.0F;
        float f2 = this.f.getHeight() / 2.0F;
        this.x = new Rotate3dAnimation(this.b.getResources().getDisplayMetrics().density, 0.0F, -90.0F, f1, f2, 0.0F, true);
      }
      this.x.setDuration(200L);
      this.x.setInterpolator(new LinearInterpolator());
      this.x.setFillAfter(true);
      this.x.setAnimationListener(new NoClockInView.2(this));
      if (QLog.isColorLevel()) {
        QLog.d("NoClockInView", 2, "startRotateAnim");
      }
      this.a = true;
      this.f.startAnimation(this.x);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetQQAvatarFHD isSuc");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ,uin = ");
      localStringBuilder.append(paramString);
      QLog.d("NoClockInView", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramDrawable != null)) {
      ThreadManager.post(new NoClockInView.1(this, paramDrawable), 8, null, true);
    }
  }
  
  public void b()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      ((Rotate3dAnimation)localObject).setAnimationListener(null);
      this.x.cancel();
      this.x = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.f = null;
    }
  }
  
  public void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.f;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (((Integer)paramView.getTag()).intValue() == 2131430795)) {
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    if ((((Integer)paramObject).intValue() == 1) && (!this.a)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.NoClockInView
 * JD-Core Version:    0.7.0.1
 */