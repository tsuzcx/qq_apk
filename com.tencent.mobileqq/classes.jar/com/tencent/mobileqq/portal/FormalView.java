package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int[] Z = { 2130846783, 2130846784, 2130846785, 2130846786, 2130846787, 2130846788, 2130846789, 2130846790, 2130846791, 2130846792, 2130846793, 2130846794, 2130846795, 2130846796, 2130846797, 2130846798, 2130846799, 2130846800, 2130846801, 2130846802, 2130846803, 2130846804, 2130846805, 2130846806, 2130846807, 2130846808, 2130846809, 2130846810, 2130846811, 2130846812, 2130846813, 2130846814, 2130846815, 2130846816, 2130846817, 2130846818, 2130846819 };
  private View A;
  private TextView B;
  private ImageShakeAnimView C;
  private long D = 0L;
  private long E;
  private ImageView F;
  private ImageView G;
  private View H;
  private View I;
  private ProgressViewYellow J;
  private ImageAlphaSwitchView K;
  private ImageView L;
  private ImageSwitchAnimView M;
  private int N = -1;
  private int O = -1;
  private int P = -1;
  private FlakeView Q;
  private Handler R;
  private Bitmap S = null;
  private Bitmap T = null;
  private View U;
  private ImageView V;
  private ImageView W;
  public boolean a = false;
  private String aa = "";
  private boolean ab = false;
  public int b;
  public HongbaoCaidanRainView c;
  public List<PortalManager.LogoConfig> d;
  public List<PortalManager.ComboNumber> e;
  public List<Integer> f = new ArrayList();
  public Map<Integer, PortalManager.ComboNumber> g = new HashMap();
  public boolean h = false;
  public long i = 0L;
  ValueAnimator j = null;
  private Context k;
  private StrokeTextView l;
  private StrokeTextView m;
  private StrokeTextView n;
  private ImageView o;
  private StrokeTextView p;
  private ImageView q;
  private ImageView r;
  private ImageView s;
  private AnimationSet t;
  private AnimationSet u;
  private AnimationDrawable v;
  private StrokeTextView w;
  private StrokeTextView x;
  private LinearLayout y;
  private TextView z;
  
  public FormalView(Context paramContext)
  {
    super(paramContext);
    this.k = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2131627460, this, true);
    paramContext = Typeface.createFromAsset(this.k.getAssets(), "fonts/HuNan-CC.ttf");
    this.p = ((StrokeTextView)findViewById(2131431014));
    this.p.setTypeface(paramContext);
    this.p.setInnerTextColor(-6347776);
    this.p.setStrokeColor(-1);
    this.p.setStrokeSize(AIOUtils.b(4.0F, getResources()));
    this.p.setStrokeEnable(true);
    this.p.setShadow(AIOUtils.b(2.0F, getResources()), 0.0F, AIOUtils.b(1.0F, getResources()), 1073741824);
    this.q = ((ImageView)findViewById(2131429606));
    this.w = ((StrokeTextView)findViewById(2131435119));
    this.w.setTypeface(paramContext);
    this.w.setInnerTextColor(-6347776);
    this.w.setStrokeColor(-1);
    this.w.setStrokeSize(AIOUtils.b(4.0F, getResources()));
    this.w.setStrokeEnable(true);
    this.w.setShadowLayer(AIOUtils.b(2.0F, getResources()), 0.0F, AIOUtils.b(1.0F, getResources()), 1711276032);
    this.l = ((StrokeTextView)findViewById(2131435112));
    this.l.setInnerTextColor(-6347776);
    this.l.setStrokeEnable(false);
    this.l.setShadow(AIOUtils.b(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.l.setTypeface(Typeface.defaultFromStyle(1));
    this.x = ((StrokeTextView)findViewById(2131444354));
    this.x.setInnerTextColor(-6347776);
    this.x.setStrokeEnable(false);
    this.x.setShadow(AIOUtils.b(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.x.setTypeface(Typeface.defaultFromStyle(1));
    this.x.setText(HardCodeUtil.a(2131902718));
    this.m = ((StrokeTextView)findViewById(2131435117));
    this.m.setInnerTextColor(Color.parseColor("#9F2400"));
    this.m.setStrokeColor(Color.parseColor("#FBEACD"));
    this.m.setStrokeSize(AIOUtils.b(2.0F, getResources()));
    this.m.setTextSize(1, 24.0F);
    this.m.setStrokeEnable(true);
    this.r = ((ImageView)findViewById(2131435109));
    this.s = ((ImageView)findViewById(2131435110));
    paramContext = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
    paramContext.height = ((int)(ViewUtils.getScreenWidth() * 736.0F / 750.0F));
    paramContext.topMargin = ViewUtils.dpToPx(203.0F);
    this.s.setLayoutParams(paramContext);
    this.n = ((StrokeTextView)findViewById(2131439285));
    this.n.setInnerTextColor(Color.parseColor("#9F2400"));
    this.n.setStrokeColor(Color.parseColor("#FBEACD"));
    this.n.setStrokeSize(AIOUtils.b(2.0F, getResources()));
    this.n.setStrokeEnable(true);
    this.o = ((ImageView)findViewById(2131448139));
    this.y = ((LinearLayout)findViewById(2131447357));
    this.A = findViewById(2131444355);
    this.B = ((TextView)findViewById(2131429745));
    this.z = ((TextView)findViewById(2131447360));
    paramContext = Typeface.createFromAsset(this.k.getAssets(), "fonts/DS-DIGIB.TTF");
    this.z.setTypeface(paramContext);
    this.z.setGravity(17);
    this.O = AIOUtils.b(70.0F, getResources());
    this.F = ((ImageView)findViewById(2131435537));
    this.G = ((ImageView)findViewById(2131435538));
    this.P = getResources().getDimensionPixelSize(2131298987);
    this.H = findViewById(2131440745);
    this.J = ((ProgressViewYellow)findViewById(2131440737));
    this.K = ((ImageAlphaSwitchView)findViewById(2131440758));
    this.K.setGravity(17);
    this.L = ((ImageView)findViewById(2131440759));
    this.M = ((ImageSwitchAnimView)findViewById(2131440755));
    this.I = findViewById(2131440756);
    this.U = findViewById(2131446100);
    this.V = ((ImageView)findViewById(2131446101));
    this.W = ((ImageView)findViewById(2131446102));
    int i1 = ViewUtils.getScreenWidth();
    int i2 = (int)(ViewUtils.getScreenWidth() * 406.0F / 750.0F);
    this.N = AIOUtils.b(40.0F, getResources());
    this.C = new ImageShakeAnimView(this.k, i1, i2, 0, 0, Integer.valueOf(2130846862), false);
    paramContext = new RelativeLayout.LayoutParams(i1, i2);
    paramContext.addRule(14);
    paramContext.topMargin = (-this.N);
    addView(this.C, 0, paramContext);
    this.Q = new FlakeView(this.k, false);
    addView(this.Q, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.R = new Handler(this);
  }
  
  private void b(String paramString)
  {
    boolean bool = FileUtils.fileExists(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doCowJumpAnimation exist = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",apngFilePath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return;
    }
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(URLDrawableHelperConstants.a);
    ((ApngOptions)localObject).a(1);
    paramString = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject, paramString);
    this.s.setVisibility(0);
    this.s.setImageDrawable(paramString);
  }
  
  private void h()
  {
    int i1;
    if (this.v == null)
    {
      this.v = new AnimationDrawable();
      i1 = 0;
    }
    try
    {
      while (i1 < Z.length)
      {
        this.v.addFrame(getResources().getDrawable(Z[i1]), 30);
        i1 += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label56:
      break label56;
    }
    this.v.setOneShot(false);
    this.q.setBackgroundDrawable(this.v);
    this.v.start();
    this.p.clearAnimation();
    this.p.setVisibility(8);
    this.r.clearAnimation();
    this.r.setVisibility(8);
    this.q.setVisibility(0);
  }
  
  public void a()
  {
    this.Q.a();
    b(false);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.i <= 500L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("combo, no network last time = ");
        paramString.append(this.i);
        QLog.d("FormalView", 2, paramString.toString());
      }
      return;
    }
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.B.setVisibility(8);
    this.A.setVisibility(8);
    this.o.setVisibility(8);
    b(false);
    if (l1 - this.D > 600L)
    {
      this.D = l1;
      this.C.a();
    }
    if (System.currentTimeMillis() - this.E < 500L) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.t == null)
    {
      this.t = new AnimationSet(true);
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      localObject2 = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      localObject3 = new OvershootInterpolator(1.0F);
      this.t.setInterpolator((Interpolator)localObject3);
      this.t.addAnimation((Animation)localObject1);
      this.t.addAnimation((Animation)localObject2);
      this.t.setDuration(400L);
      this.t.setFillAfter(true);
    }
    this.t.reset();
    this.q.setVisibility(8);
    this.ab = false;
    if (this.f.contains(Integer.valueOf(paramInt)))
    {
      this.ab = true;
      this.p.setVisibility(8);
      this.l.setVisibility(8);
      this.r.setVisibility(0);
      localObject1 = (PortalManager.ComboNumber)this.g.get(Integer.valueOf(paramInt));
      if (localObject1 == null)
      {
        this.ab = false;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("combo, get CN from map return null, combo=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("FormalView", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        Object localObject4;
        if (!TextUtils.isEmpty(((PortalManager.ComboNumber)localObject1).numberImageMD5))
        {
          localObject2 = PortalManager.a(((PortalManager.ComboNumber)localObject1).numberImageMD5, null);
          if (localObject2 == null)
          {
            this.ab = false;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("combo, get bmp from PM return null, combo=");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d("FormalView", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            this.r.setImageBitmap((Bitmap)localObject2);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
          ((StringBuilder)localObject2).append(PortalManager.h);
          ((StringBuilder)localObject2).append(((PortalManager.ComboNumber)localObject1).flowerImageMD5);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(BaseApplicationImpl.getApplication().getFilesDir());
          ((StringBuilder)localObject3).append(PortalManager.h);
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).flowerImage2MD5);
          localObject3 = ((StringBuilder)localObject3).toString();
          this.Q.a(30, new String[] { localObject2, localObject3 });
          localObject4 = this.c;
          if (localObject4 != null)
          {
            ((HongbaoCaidanRainView)localObject4).a(new String[] { localObject2, localObject3 });
            this.Q.setShowFullScreenCaidan(l1, 2000L);
          }
          localObject2 = (PortalManager)((BaseActivity)this.k).app.getManager(QQManagerFactory.MGR_PORTAL);
          if (localObject2 != null) {
            ((PortalManager)localObject2).a(3);
          }
          localObject2 = ((BaseActivity)this.k).app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).number);
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
        else
        {
          localObject2 = (SpringFestivalEntryManager)((BaseActivity)this.k).app.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          localObject3 = ((SpringFestivalEntryManager)localObject2).d().commonData.comboResUrl;
          localObject4 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getNumberImageFileName(), "");
          if (localObject4 == null)
          {
            this.ab = false;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("combo, get bmp from PM return null, combo=");
            ((StringBuilder)localObject5).append(paramInt);
            QLog.d("FormalView", 1, ((StringBuilder)localObject5).toString());
          }
          else
          {
            this.r.setImageBitmap((Bitmap)localObject4);
          }
          Object localObject5 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage1FileName(), "");
          Bitmap localBitmap = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage2FileName(), "");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("combo bitmap = ");
            localStringBuilder.append(localObject4);
            localStringBuilder.append(",flower1bitmap = ");
            localStringBuilder.append(localObject5);
            localStringBuilder.append(",flower2bitmap = ");
            localStringBuilder.append(localBitmap);
            QLog.d("FormalView", 2, localStringBuilder.toString());
          }
          if ((localObject5 != null) && (localBitmap != null))
          {
            this.Q.a(30, new Bitmap[] { localObject5, localBitmap });
            localObject4 = this.c;
            if (localObject4 != null)
            {
              ((HongbaoCaidanRainView)localObject4).a(new Bitmap[] { localObject5, localBitmap });
              this.Q.setShowFullScreenCaidan(l1, 2000L);
            }
          }
          if (localObject2 != null) {
            ((SpringFestivalEntryManager)localObject2).a(3);
          }
          localObject4 = ((PortalManager.ComboNumber)localObject1).getCowJumpAnimFileName();
          localObject2 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append((String)localObject4);
          b(((StringBuilder)localObject3).toString());
          localObject2 = ((BaseActivity)this.k).app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).number);
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
      }
    }
    l1 = 2000L;
    if (!this.ab)
    {
      this.ab = false;
      this.p.setVisibility(0);
      this.l.setVisibility(0);
      this.r.setVisibility(8);
      if (paramInt == 1)
      {
        this.p.setText(HardCodeUtil.a(2131902719));
      }
      else if (paramInt < 10)
      {
        localObject1 = this.p;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902715));
        ((StrokeTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = this.p;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append(paramInt);
        ((StrokeTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      this.r.clearAnimation();
      this.p.startAnimation(this.t);
    }
    else
    {
      this.p.setVisibility(8);
      this.l.setVisibility(8);
      this.r.setVisibility(0);
      this.p.clearAnimation();
      this.r.startAnimation(this.t);
      this.E = System.currentTimeMillis();
    }
    if (paramBoolean) {
      this.l.setText(paramString);
    }
    this.R.removeMessages(1);
    paramString = this.R;
    if (!this.ab) {
      l1 = 800L;
    }
    paramString.sendEmptyMessageDelayed(1, l1);
    this.h = true;
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.H.setVisibility(0);
    this.J.a(paramLong1, paramLong2);
    this.A.setVisibility(8);
    this.B.setVisibility(8);
    this.y.setVisibility(0);
    if (this.b == 1) {
      this.U.setVisibility(0);
    }
    String str = paramCharSequence.toString();
    if (!this.aa.equals(str))
    {
      this.z.setText(paramCharSequence);
      this.aa = str;
    }
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = AIOUtils.b(81.0F, getResources());
    paramCharSequence = (ViewGroup.MarginLayoutParams)this.I.getLayoutParams();
    paramCharSequence.leftMargin = ((int)((i1 - i2) * (paramLong2 - paramLong1) / paramLong2));
    this.I.setLayoutParams(paramCharSequence);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup;
    ViewGroup localViewGroup;
    do
    {
      if (((ViewGroup)localObject).getId() == 2131431325)
      {
        paramViewGroup = (ViewGroup)localObject;
        break;
      }
      if (((ViewGroup)localObject).getId() == 16908306) {
        break;
      }
      if (((ViewGroup)localObject).getParent() != null) {
        localViewGroup = (ViewGroup)((ViewGroup)localObject).getParent();
      } else {
        localViewGroup = null;
      }
      localObject = localViewGroup;
    } while (localViewGroup != null);
    localObject = paramViewGroup.findViewById(2131442343);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showResult, msg=");
      localStringBuilder.append(paramString);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    if ((!PortalConstants.a.equals(paramString)) && (System.currentTimeMillis() - this.E < 500L)) {
      return;
    }
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.q.setVisibility(8);
    this.p.clearAnimation();
    this.p.setVisibility(8);
    this.r.clearAnimation();
    this.r.setVisibility(8);
    if (PortalConstants.a.equals(paramString))
    {
      this.o.setVisibility(8);
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      this.m.setTextSize(1, 21.0F);
      this.m.setText(paramString);
      this.i = System.currentTimeMillis();
    }
    else
    {
      this.o.setVisibility(0);
      this.l.setVisibility(0);
      this.m.setVisibility(8);
      this.l.setText(paramString);
    }
    this.h = false;
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.Q.a(paramBoolean);
  }
  
  public void b()
  {
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.H.setVisibility(8);
    this.y.setVisibility(4);
    this.A.setVisibility(0);
    this.B.setVisibility(8);
    this.U.setVisibility(8);
    e();
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (this.c == null)
    {
      this.c = new HongbaoCaidanRainView(this.k);
      this.c.setId(2131442343);
      this.c.setClickable(false);
      this.c.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.b(40.0F, getResources()), 0.5F, 150.0F, AIOUtils.b(250.0F, getResources()), AIOUtils.b(3.0F, getResources()), AIOUtils.b(150.0F, getResources()), getResources().getDisplayMetrics().heightPixels);
    }
    Object localObject = paramViewGroup;
    ViewGroup localViewGroup;
    do
    {
      if (((ViewGroup)localObject).getId() == 2131431325)
      {
        paramViewGroup = (ViewGroup)localObject;
        break;
      }
      if (((ViewGroup)localObject).getId() == 16908306) {
        break;
      }
      if (((ViewGroup)localObject).getParent() != null) {
        localViewGroup = (ViewGroup)((ViewGroup)localObject).getParent();
      } else {
        localViewGroup = null;
      }
      localObject = localViewGroup;
    } while (localViewGroup != null);
    localObject = paramViewGroup.findViewById(2131442343);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
    paramViewGroup.addView(this.c, new RelativeLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readyGo, show=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = findViewById(2131435119);
    if (paramBoolean)
    {
      if (this.u == null)
      {
        AnimationSet localAnimationSet = new AnimationSet(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.8F, 1.0F, 1.85F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setDuration(400L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new FormalView.1(this, (View)localObject));
        this.u = localAnimationSet;
      }
      ((View)localObject).startAnimation(this.u);
      return;
    }
    ((View)localObject).clearAnimation();
    ((View)localObject).setVisibility(8);
    localObject = this.x;
    if (localObject != null) {
      ((StrokeTextView)localObject).setVisibility(8);
    }
  }
  
  public void c()
  {
    this.Q.b();
  }
  
  @TargetApi(11)
  public void d()
  {
    this.j = ValueAnimator.ofInt(new int[] { 0, 1000 });
    this.j.addUpdateListener(new FormalView.2(this));
    this.j.addListener(new FormalView.3(this));
    this.j.setDuration(300L);
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
    this.j.start();
  }
  
  public void e()
  {
    this.a = false;
    ((RelativeLayout.LayoutParams)this.C.getLayoutParams()).topMargin = (-this.N);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.F.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    this.G.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.H.getLayoutParams();
    localLayoutParams.topMargin = this.P;
    this.H.setLayoutParams(localLayoutParams);
  }
  
  public void f()
  {
    this.a = true;
    ((RelativeLayout.LayoutParams)this.C.getLayoutParams()).topMargin = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
    localLayoutParams.leftMargin = (-this.O);
    this.F.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    localLayoutParams.rightMargin = (-this.O);
    this.G.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.H.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.H.setLayoutParams(localLayoutParams);
  }
  
  public void g()
  {
    ValueAnimator localValueAnimator = this.j;
    if (localValueAnimator != null) {
      try
      {
        if (localValueAnimator.isRunning()) {
          this.j.cancel();
        }
        this.j = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.h)) {
      h();
    }
    return false;
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap2 != null)
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap2)) {
        return;
      }
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
      return;
    }
    super.setBackgroundResource(2130846745);
  }
  
  public void setCloudBmp(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 != null) && (paramBitmap2 != null))
    {
      this.F.setImageBitmap(paramBitmap1);
      this.G.setImageBitmap(paramBitmap2);
      return;
    }
    QLog.d("PortalManager", 1, "FormalView setCloudBmp, left or right is null");
    this.F.setImageResource(2130846739);
    this.G.setImageResource(2130846740);
  }
  
  public void setComboNumberList(List<PortalManager.ComboNumber> paramList)
  {
    this.e = paramList;
    this.f.clear();
    this.g.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Collections.sort(paramList, new FormalView.ComboCompare(null));
      int i1 = 0;
      while (i1 < paramList.size())
      {
        PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)paramList.get(i1);
        if (localComboNumber != null)
        {
          this.f.add(Integer.valueOf(localComboNumber.number));
          this.g.put(Integer.valueOf(localComboNumber.number), localComboNumber);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setComboNumberList, index=");
            localStringBuilder.append(i1);
            localStringBuilder.append(", p=");
            localStringBuilder.append(localComboNumber.toString());
            QLog.d("FormalView", 2, localStringBuilder.toString());
          }
        }
        i1 += 1;
      }
      ThreadManager.postImmediately(new FormalView.4(this, paramList), null, true);
    }
  }
  
  public void setHBSpeed(int paramInt)
  {
    this.Q.setHonhBaoSpeed(paramInt);
  }
  
  public void setLogoConfigList(List<PortalManager.LogoConfig> paramList)
  {
    this.d = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(i1);
        if (localLogoConfig != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLogoConfigList, index=");
          localStringBuilder.append(i1);
          localStringBuilder.append(", p=");
          localStringBuilder.append(localLogoConfig.toString());
          QLog.d("FormalView", 2, localStringBuilder.toString());
        }
        i1 += 1;
      }
    }
  }
  
  public void setProgressLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setProgressLogo, bmp=");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(", needSwitch=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap != null)
    {
      if (this.b == 1)
      {
        this.M.setLogo(paramBitmap);
        return;
      }
      if (paramBoolean)
      {
        this.M.a(paramBitmap);
        return;
      }
      this.M.setLogo(paramBitmap);
      return;
    }
    int i1 = this.b;
    Object localObject = null;
    if (i1 == 1) {
      paramBitmap = getResources().getDrawable(2130846911);
    } else if ((i1 != 2) && (i1 != 3)) {
      paramBitmap = null;
    } else {
      paramBitmap = getResources().getDrawable(2130846733);
    }
    if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
      localObject = ((SkinnableBitmapDrawable)paramBitmap).getBitmap();
    } else if ((paramBitmap instanceof BitmapDrawable)) {
      localObject = ((BitmapDrawable)paramBitmap).getBitmap();
    }
    if (localObject != null)
    {
      if (this.b == 1)
      {
        this.M.setLogo((Bitmap)localObject);
        return;
      }
      if (paramBoolean)
      {
        this.M.a((Bitmap)localObject);
        return;
      }
      this.M.setLogo((Bitmap)localObject);
    }
  }
  
  public void setProgressNameBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProgressNameBitmap, name=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(", bg=");
      localStringBuilder.append(paramBitmap2);
      localStringBuilder.append(", needSwitch=");
      localStringBuilder.append(paramBoolean);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    if (paramBitmap1 == null) {
      return;
    }
    if (paramBoolean)
    {
      this.K.a(paramBitmap1);
      return;
    }
    this.K.setImage(paramBitmap1);
  }
  
  public void setSmallIcon(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSmallIcon, icon=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(", name=");
      localStringBuilder.append(paramBitmap2);
      localStringBuilder.append(", mode=");
      localStringBuilder.append(this.b);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    this.W.setImageBitmap(paramBitmap2);
    this.V.setImageBitmap(paramBitmap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView
 * JD-Core Version:    0.7.0.1
 */