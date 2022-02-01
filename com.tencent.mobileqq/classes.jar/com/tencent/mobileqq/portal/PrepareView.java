package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;

public class PrepareView
  extends RelativeLayout
{
  public int a = -1;
  public List<PortalManager.LogoConfig> b;
  private Context c;
  private boolean d = false;
  private RelativeLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  private CountDownTimer i;
  private RelativeLayout j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private ImageSwitchAnimView r;
  private ImageAlphaSwitchView s;
  private ImageView t;
  private ImageView u;
  private ImageView v;
  private ImageView w;
  private ImageView x;
  private ImageView y;
  private ImageShakeAnimView z;
  
  public PrepareView(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
  }
  
  private Bitmap b(int paramInt)
  {
    int i1 = this.a;
    if (i1 == 1)
    {
      if (paramInt == 0)
      {
        paramInt = 2130846911;
        break label64;
      }
      if (paramInt == 1)
      {
        paramInt = 2130846912;
        break label64;
      }
    }
    else if ((i1 == 2) || (i1 == 3))
    {
      if (paramInt == 0)
      {
        paramInt = 2130846733;
        break label64;
      }
      if (paramInt == 1)
      {
        paramInt = 2130846734;
        break label64;
      }
    }
    paramInt = 0;
    label64:
    if (paramInt != 0)
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.a < 0) {
      return;
    }
    CountDownTimer localCountDownTimer = this.i;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      this.i = null;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTimeDown time = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",mMode = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("PrepareView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a < 0) {
      return;
    }
    this.j.setVisibility(8);
    this.e.setVisibility(0);
    Object localObject = this.i;
    if (localObject != null) {
      ((CountDownTimer)localObject).cancel();
    }
    this.i = new PrepareView.1(this, paramLong, 1000L);
    this.i.start();
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i1 = this.a;
    if (i1 == 1)
    {
      if ((this.t != null) && (this.u != null)) {}
    }
    else if ((i1 == 2) || (i1 == 3))
    {
      if (this.r == null) {
        return;
      }
      if (this.s == null) {
        return;
      }
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = b(0);
    }
    if (localBitmap != null)
    {
      paramBitmap = this.r;
      if (paramBitmap != null)
      {
        i1 = this.a;
        if (i1 == 3) {
          paramBitmap.a(localBitmap);
        } else if (i1 == 2) {
          paramBitmap.setLogo(localBitmap);
        }
      }
      paramBitmap = this.t;
      if ((paramBitmap != null) && (this.a == 1)) {
        paramBitmap.setImageBitmap(localBitmap);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    a();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.c).inflate(2131627463, this, true);
      this.t = ((ImageView)findViewById(2131437736));
      this.u = ((ImageView)findViewById(2131439123));
    }
    else
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return false;
      }
      LayoutInflater.from(this.c).inflate(2131627462, this, true);
      this.r = ((ImageSwitchAnimView)findViewById(2131437736));
      this.s = ((ImageAlphaSwitchView)findViewById(2131439123));
    }
    this.e = ((RelativeLayout)findViewById(2131447359));
    this.f = ((TextView)findViewById(2131447355));
    this.g = ((TextView)findViewById(2131447356));
    this.h = ((TextView)findViewById(2131447358));
    this.j = ((RelativeLayout)findViewById(2131432268));
    this.k = ((TextView)findViewById(2131447346));
    this.l = ((TextView)findViewById(2131447347));
    this.m = ((TextView)findViewById(2131447348));
    this.n = ((TextView)findViewById(2131447349));
    this.o = ((TextView)findViewById(2131435866));
    this.p = ((TextView)findViewById(2131435867));
    this.q = ((TextView)findViewById(2131437229));
    Object localObject = Typeface.createFromAsset(this.c.getAssets(), "fonts/DS-DIGIB.TTF");
    this.f.setTypeface((Typeface)localObject);
    this.g.setTypeface((Typeface)localObject);
    this.h.setTypeface((Typeface)localObject);
    this.k.setTypeface((Typeface)localObject);
    this.l.setTypeface((Typeface)localObject);
    this.m.setTypeface((Typeface)localObject);
    this.n.setTypeface((Typeface)localObject);
    this.o.setTypeface((Typeface)localObject);
    this.p.setTypeface((Typeface)localObject);
    this.q.setTypeface((Typeface)localObject);
    this.v = ((ImageView)findViewById(2131437070));
    this.w = ((ImageView)findViewById(2131444788));
    this.x = ((ImageView)findViewById(2131450230));
    this.y = ((ImageView)findViewById(2131431439));
    localObject = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(25.0F, getResources());
      this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramInt = AIOUtils.b(475.0F, getResources());
    int i1 = AIOUtils.b(335.0F, getResources());
    this.z = new ImageShakeAnimView(this.c, paramInt, i1, (getResources().getDisplayMetrics().widthPixels - paramInt) / 2, 0, Integer.valueOf(2130846861), true);
    localObject = new RelativeLayout.LayoutParams(paramInt, i1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    addView(this.z, 0, (ViewGroup.LayoutParams)localObject);
    return true;
  }
  
  public void b()
  {
    this.z.a();
  }
  
  public void b(Bitmap paramBitmap)
  {
    int i1 = this.a;
    if (i1 == 1)
    {
      if ((this.t != null) && (this.u != null)) {}
    }
    else if ((i1 == 2) || (i1 == 3))
    {
      if (this.r == null) {
        return;
      }
      if (this.s == null) {
        return;
      }
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = b(1);
    }
    if (localBitmap != null)
    {
      paramBitmap = this.s;
      if (paramBitmap != null)
      {
        i1 = this.a;
        if (i1 == 3)
        {
          paramBitmap.setGravity(3);
          this.s.a(localBitmap);
        }
        else if (i1 == 2)
        {
          paramBitmap.setGravity(17);
          this.s.setImage(localBitmap);
          i1 = localBitmap.getWidth();
          int i2 = localBitmap.getHeight();
          paramBitmap = this.s.getLayoutParams();
          int i3 = paramBitmap.width;
          paramBitmap.width = ((int)(paramBitmap.height * (i1 * 1.0F / i2)));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateBusinessNameBitmap,bitmapWidth = ");
            localStringBuilder.append(i1);
            localStringBuilder.append(",bitmapHeight = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(",lp.width = ");
            localStringBuilder.append(paramBitmap.width);
            localStringBuilder.append(",lp.height = ");
            localStringBuilder.append(paramBitmap.height);
            localStringBuilder.append(",originWidth = ");
            localStringBuilder.append(i3);
            QLog.d("PrepareView", 2, localStringBuilder.toString());
          }
          this.s.setLayoutParams(paramBitmap);
        }
      }
      paramBitmap = this.u;
      if ((paramBitmap != null) && (this.a == 1)) {
        paramBitmap.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void c() {}
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    if (this.a < 0) {
      return;
    }
    if (paramBitmap1 != null) {}
    try
    {
      paramBitmap2 = getBackground();
      if ((paramBitmap2 != null) && ((paramBitmap2 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap2).getBitmap() == paramBitmap1)) {
        break label68;
      }
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap1));
    }
    catch (Throwable paramBitmap1)
    {
      label68:
      break label68;
    }
    super.setBackgroundResource(2130846745);
    if (paramBitmap3 != null) {}
    label187:
    try
    {
      paramBitmap1 = this.v.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap3)) {
        break label126;
      }
      this.v.setImageBitmap(paramBitmap3);
    }
    catch (Throwable paramBitmap1)
    {
      label126:
      break label126;
    }
    this.v.setImageResource(2130846741);
    if (paramBitmap4 != null) {}
    try
    {
      paramBitmap1 = this.w.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap4)) {
        break label187;
      }
      this.w.setImageBitmap(paramBitmap4);
    }
    catch (Throwable paramBitmap1)
    {
      break label187;
    }
    this.w.setImageResource(2130846742);
    if (paramBitmap5 != null)
    {
      paramBitmap1 = this.x.getDrawable();
      if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable)) || (((BitmapDrawable)paramBitmap1).getBitmap() != paramBitmap5)) {
        this.x.setImageBitmap(paramBitmap5);
      }
    }
    else
    {
      this.x.setImageResource(2130846869);
    }
  }
  
  public void setLogo(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    a(paramBitmap1);
    b(paramBitmap2);
  }
  
  public void setLogoConfigList(List<PortalManager.LogoConfig> paramList)
  {
    this.b = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(i1);
        if (localLogoConfig != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("prepareview, setLogoConfigList, index=");
          localStringBuilder.append(i1);
          localStringBuilder.append(", p=");
          localStringBuilder.append(localLogoConfig.toString());
          QLog.d("PortalManager", 2, localStringBuilder.toString());
        }
        i1 += 1;
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    if (((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) || (this.a == paramInt)) {
      return;
    }
    if (a(paramInt)) {
      this.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView
 * JD-Core Version:    0.7.0.1
 */