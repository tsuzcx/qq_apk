package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class HasClockView
  extends ClockView
  implements Observer
{
  Runnable a = new HasClockView.2(this);
  private QQAppInterface b;
  private Context c;
  private FrameLayout d;
  private ClockInData e;
  private RelativeLayout f;
  private RoundRectUrlImageView g;
  private ImageView h;
  private TextView i;
  private TickerView j;
  private TickerView k;
  private TickerView l;
  private TextView m;
  private TextView n;
  private ImageView o;
  private LinearLayout p;
  private Rotate3dAnimation q;
  private Handler r = new Handler();
  private boolean s = true;
  private List<HasClockView.RotateData> t;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  
  public HasClockView(Context paramContext, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, ClockInData paramClockInData, ClockInCallback paramClockInCallback, ClockAnimController paramClockAnimController)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramFrameLayout;
    this.e = paramClockInData;
    this.t = new ArrayList();
    this.t.add(new HasClockView.RotateData(this, 90.0F, -10.0F, 300));
    this.t.add(new HasClockView.RotateData(this, -10.0F, 15.0F, 300));
    this.t.add(new HasClockView.RotateData(this, 15.0F, 0.0F, 250));
    c();
  }
  
  private void a(float paramFloat)
  {
    ImageView localImageView = this.o;
    if ((localImageView != null) && (this.n != null) && (this.p != null))
    {
      localImageView.setAlpha(paramFloat);
      this.n.setAlpha(paramFloat);
      this.p.setAlpha(paramFloat);
    }
  }
  
  private String c(int paramInt)
  {
    if (paramInt < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    if (this.b != null)
    {
      Context localContext = this.c;
      if ((localContext != null) && (this.d != null) && (this.e != null))
      {
        this.f = ((RelativeLayout)LayoutInflater.from(localContext).inflate(2131627654, null));
        this.d.addView(this.f);
        this.g = ((RoundRectUrlImageView)this.f.findViewById(2131429397));
        this.h = ((ImageView)this.f.findViewById(2131449248));
        this.i = ((TextView)this.f.findViewById(2131428290));
        this.j = ((TickerView)this.f.findViewById(2131447362));
        this.k = ((TickerView)this.f.findViewById(2131447365));
        this.l = ((TickerView)this.f.findViewById(2131447371));
        this.m = ((TextView)this.f.findViewById(2131430800));
        this.p = ((LinearLayout)this.f.findViewById(2131430797));
        this.n = ((TextView)this.f.findViewById(2131430798));
        this.o = ((ImageView)this.f.findViewById(2131430796));
        e();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HasClockView", 2, "create arg error");
    }
  }
  
  private boolean d()
  {
    return (this.b != null) && (this.c != null) && (this.d != null) && (this.e != null) && (this.g != null) && (this.h != null) && (this.i != null) && (this.j != null) && (this.k != null) && (this.l != null) && (this.m != null) && (this.p != null) && (this.n != null) && (this.o != null);
  }
  
  private void e()
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "updateUI checkData error");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI data:");
      localStringBuilder.append(this.e.toString());
      QLog.d("HasClockView", 2, localStringBuilder.toString());
    }
    f();
    g();
    i();
    h();
  }
  
  private void f()
  {
    this.g.setAllRadius(ViewUtils.dpToPx(16.0F));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(this.e.q))
    {
      localObject = URLDrawable.getDrawable(this.e.q, (URLDrawable.URLDrawableOptions)localObject);
      this.g.setImageDrawable((Drawable)localObject);
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void g()
  {
    Object localObject1 = ImageUtil.j();
    Object localObject2 = this.b;
    localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject2, 1, ((QQAppInterface)localObject2).getCurrentUin(), 4, (Drawable)localObject1, (Drawable)localObject1);
    localObject2 = this.h.getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable)) && (localObject2 != localObject1)) {
      ((FaceDrawable)localObject2).cancel();
    }
    this.h.setImageDrawable((Drawable)localObject1);
  }
  
  private void h()
  {
    Object localObject = Calendar.getInstance();
    if (this.e.l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "updateTimeUI : selfClockTime == 0");
      }
      return;
    }
    ((Calendar)localObject).setTimeInMillis(this.e.l * 1000L);
    this.v = ((Calendar)localObject).get(11);
    this.w = ((Calendar)localObject).get(12);
    this.x = ((Calendar)localObject).get(13);
    int i1;
    if (this.e.c) {
      i1 = a(this.v, 24);
    } else {
      i1 = this.v;
    }
    localObject = c(i1);
    if (this.e.c) {
      i1 = a(this.w, 60);
    } else {
      i1 = this.w;
    }
    String str1 = c(i1);
    if (this.e.c) {
      i1 = a(this.x, 60);
    } else {
      i1 = this.x;
    }
    String str2 = c(i1);
    this.j.setCharacterLists(new String[] { "1234567890" });
    this.j.setCustomCharacterList(b(this.v, 24));
    this.j.setText((String)localObject, false);
    this.j.setAnimationDuration(1000L);
    this.j.setGravity(17);
    this.k.setCharacterLists(new String[] { "1234567890" });
    this.k.setCustomCharacterList(b(this.w, 60));
    this.k.setText(str1, false);
    this.k.setAnimationDuration(1000L);
    this.j.setAnimationDelay(30L);
    this.k.setGravity(17);
    this.l.setCharacterLists(new String[] { "1234567890" });
    this.l.setCustomCharacterList(b(this.x, 60));
    this.l.setText(str2, false);
    this.l.setAnimationDuration(1000L);
    this.j.setAnimationDelay(60L);
    this.l.setGravity(17);
  }
  
  private void i()
  {
    this.p.setOnTouchListener(new HasClockView.1(this));
    this.m.setText(this.e.m);
    this.i.setText(this.e.k);
    this.o.setImageResource(2130852617);
    this.o.setColorFilter(Color.parseColor("#FFFFFF"));
    this.n.setText(this.e.n);
  }
  
  private void j()
  {
    TickerView localTickerView = this.j;
    if ((localTickerView != null) && (this.k != null) && (this.l != null) && (this.v != 0) && (this.w != 0) && (this.x != 0))
    {
      localTickerView.setPreferredScrollingDirection(2);
      this.j.setDigitalAnimWidthSpeedIncrement(false);
      this.j.setIgnoreWidthAnim(true);
      this.j.setText(c(this.v));
      this.j.setVisibility(0);
      this.k.setPreferredScrollingDirection(2);
      this.k.setDigitalAnimWidthSpeedIncrement(false);
      this.k.setIgnoreWidthAnim(true);
      this.k.setText(c(this.w));
      this.k.setVisibility(0);
      this.l.setPreferredScrollingDirection(2);
      this.l.setDigitalAnimWidthSpeedIncrement(false);
      this.l.setIgnoreWidthAnim(true);
      this.l.setText(c(this.x));
      this.l.setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HasClockView", 2, "smoothUpdateTime error");
    }
  }
  
  private void k()
  {
    if (this.f != null)
    {
      if (this.t == null) {
        return;
      }
      b(0);
      this.f.bringToFront();
      if (this.u >= this.t.size()) {
        return;
      }
      if (this.q == null)
      {
        this.q = new Rotate3dAnimation();
        this.q.setFillAfter(true);
        this.q.setAnimationListener(new HasClockView.3(this));
      }
      HasClockView.RotateData localRotateData = (HasClockView.RotateData)this.t.get(this.u);
      if (localRotateData != null)
      {
        float f1 = this.f.getWidth() / 2.0F;
        float f2 = this.f.getHeight() / 2.0F;
        float f3 = this.c.getResources().getDisplayMetrics().density;
        this.q.setInterpolator(new LinearInterpolator());
        this.q.a(f3, localRotateData.a, localRotateData.b, f1, f2, 0.0F, true);
        this.q.setDuration(localRotateData.c);
        this.f.startAnimation(this.q);
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 8) % paramInt2 + 1;
  }
  
  public void a()
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ClockInData)localObject1).o)))
    {
      localObject1 = new Intent(this.c, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.e.o);
      this.c.startActivity((Intent)localObject1);
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("op_via", "2");
    Object localObject2 = this.b;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
      ((HashMap)localObject1).put("A8", this.b.getCurrentAccountUin());
    }
    localObject2 = this.e;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).a))) {
      ((HashMap)localObject1).put("qq_group_num", this.e.a);
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
  }
  
  public ArrayList<String> b(int paramInt1, int paramInt2)
  {
    int i1 = a(paramInt1, paramInt2);
    ArrayList localArrayList = new ArrayList();
    String str = c(i1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(str.substring(0, 1));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(str.substring(1, 2));
    str = ((StringBuilder)localObject2).toString();
    paramInt1 = 0;
    while (paramInt1 < 7)
    {
      i1 = (i1 + 1) % paramInt2;
      localObject2 = c(i1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(((String)localObject2).substring(0, 1));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(((String)localObject2).substring(1, 2));
      str = localStringBuilder.toString();
      paramInt1 += 1;
    }
    localArrayList.add(localObject1);
    localArrayList.add(str);
    return localArrayList;
  }
  
  public void b()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((Rotate3dAnimation)localObject).setAnimationListener(null);
      this.q.cancel();
      this.q = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.f = null;
    }
    localObject = this.t;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.f;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    paramObservable = (Integer)paramObject;
    if (paramObservable.intValue() == 2)
    {
      e();
      k();
      return;
    }
    if (paramObservable.intValue() == 3)
    {
      paramObservable = this.r;
      if (paramObservable != null)
      {
        paramObject = this.a;
        if (paramObject != null) {
          paramObservable.post(paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView
 * JD-Core Version:    0.7.0.1
 */