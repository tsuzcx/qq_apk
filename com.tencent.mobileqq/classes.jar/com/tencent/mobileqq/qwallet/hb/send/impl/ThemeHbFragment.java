package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.anim;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.FrameAnimHelper;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView.OnRollListener;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, Animation.AnimationListener, FragmentInterface, RollNumberView.OnRollListener
{
  private int A;
  private JSONArray B;
  private JSONArray C;
  private String D;
  private Drawable E;
  private String F = "";
  private ThemeHbFragment.SendHbHandler G = new ThemeHbFragment.SendHbHandler(this);
  private String H;
  private String I = "1";
  private String J;
  private int[] K = null;
  private long L = 0L;
  private boolean M;
  private int N = 0;
  private JSONArray O;
  public JSONArray a;
  public String b = "1";
  private View c;
  private View d;
  private View l;
  private RelativeLayout m;
  private LinearLayout n;
  private RollNumberView o;
  private TextView p;
  private Button q;
  private View r;
  private Animation s;
  private int t = 0;
  private ImageView u;
  private FrameAnimHelper v;
  private ImageView w;
  private TextView x;
  private TextView y;
  private ThemeRedPkgConfig z = null;
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      try
      {
        if ((64 == this.i) && (!TextUtils.isEmpty(this.J)))
        {
          this.o.b(paramDouble);
          String str = QwUtils.a(this.H, this.J);
          this.p.setText(this.F);
          this.q.setText(String.format(getString(R.string.E), new Object[] { this.J, str }));
          this.H = str;
          return 0;
        }
        this.o.b(paramDouble);
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  private void a(Bundle paramBundle)
  {
    this.p.setVisibility(0);
    this.u.setVisibility(0);
    this.J = paramBundle.getString("group_count");
    this.M = paramBundle.getBoolean("isGroupThemeHb");
    try
    {
      a(Integer.valueOf(paramBundle.getString("theme_type")).intValue());
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.M)
    {
      paramBundle = this.y;
      if (paramBundle != null)
      {
        paramBundle.setText(String.format(getString(R.string.D), new Object[] { this.b }));
        this.y.setVisibility(0);
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.p.setVisibility(4);
    this.u.setVisibility(8);
    Object localObject = ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).getFaceConfig(this.f);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      try
      {
        paramBundle = new JSONObject("{\"hb_face_desc\":\" 让对方做表情领红包\",\"hb_face_imgurl\":\"\",\"hb_face_money_array\":[\"0.18\",\"1.18\",\"2.18\",\"6.18\",\"8.18\",\"18.00\"]}");
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject;
      }
    }
    if (paramBundle == null)
    {
      this.f.showThemeHbToast(HardCodeUtil.a(R.string.cY));
      this.f.finish();
      return;
    }
    this.x.setText(paramBundle.optString("hb_face_desc"));
    localObject = paramBundle.optString("hb_face_imgurl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getBitmap(this.g, (String)localObject);
      this.w.setImageBitmap((Bitmap)localObject);
    }
    this.O = paramBundle.optJSONArray("hb_face_money_array");
    e();
  }
  
  private void c()
  {
    this.G.postDelayed(new ThemeHbFragment.1(this), 10L);
  }
  
  private boolean c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (this.n != null))
    {
      int i = (int)this.f.getResources().getDimension(R.dimen.a);
      this.v = new FrameAnimHelper(this.f, this.n, i, true, new ThemeHbFragment.4(this));
      this.v.a(paramString, true);
      return true;
    }
    return false;
  }
  
  private void d(String paramString)
  {
    e(paramString);
    if ((64 == this.i) || (this.i == 64) || (this.i == 16384))
    {
      paramString = a(-11001, "", "");
      this.f.setResult(-1, paramString);
    }
    if (isAdded())
    {
      this.f.cancelCallBack();
      this.f.finish();
      this.f.overridePendingTransition(0, 0);
    }
  }
  
  private void e()
  {
    int j = new Random(System.currentTimeMillis()).nextInt(this.O.length());
    int i = j;
    if (j == this.N) {
      i = j + 1;
    }
    this.N = i;
    if (this.N >= this.O.length()) {
      i = 0;
    } else {
      i = this.N;
    }
    this.N = i;
    try
    {
      String str = this.O.optString(this.N);
      this.H = str;
      float f = Float.parseFloat(str);
      this.o.b(f);
      this.o.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.f.addHbUploadData(paramString);
    }
  }
  
  private void f()
  {
    if (this.c != null)
    {
      if (!isAdded()) {
        return;
      }
      ImageView localImageView = (ImageView)this.c.findViewById(R.id.y);
      int j = 8;
      int i;
      if (localImageView != null)
      {
        if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.f)) {
          i = 8;
        } else {
          i = 0;
        }
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
      localImageView = (ImageView)this.c.findViewById(R.id.w);
      if (localImageView != null)
      {
        i = j;
        if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.f)) {
          i = 0;
        }
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
      this.o = ((RollNumberView)this.c.findViewById(R.id.cy));
      this.s = AnimationUtils.loadAnimation(this.f, R.anim.a);
      this.s.setAnimationListener(this);
      this.p = ((TextView)this.c.findViewById(R.id.V));
      this.u = ((ImageView)this.c.findViewById(R.id.ad));
      this.q = ((Button)this.c.findViewById(R.id.cg));
      this.m = ((RelativeLayout)this.c.findViewById(R.id.cA));
      this.n = ((LinearLayout)this.c.findViewById(R.id.e));
      this.r = this.c.findViewById(R.id.ae);
      this.l = this.c.findViewById(R.id.bx);
      this.d = this.c.findViewById(R.id.cz);
      this.w = ((ImageView)this.c.findViewById(R.id.P));
      this.x = ((TextView)this.c.findViewById(R.id.R));
      this.y = ((TextView)this.c.findViewById(R.id.M));
    }
  }
  
  private void g()
  {
    this.o.setLisener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.d.setVisibility(0);
    if (64 == this.i) {
      this.I = "1";
    }
    if (isAdded()) {
      ((InputMethodManager)this.f.getSystemService("input_method")).hideSoftInputFromWindow(this.m.getWindowToken(), 0);
    }
  }
  
  private void h()
  {
    if ((!TextUtils.isEmpty(this.D)) && (isAdded()))
    {
      this.E = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getDrawableByTheme(this.g, this.D);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageBgProcess mHbDrawable = ");
        localStringBuilder.append(this.E);
        QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
      }
      if (this.E != null)
      {
        this.u.setBackgroundDrawable(null);
        this.u.setImageDrawable(this.E);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess not exist, start download...");
      }
      ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).download(this.g, this.D, new ThemeHbFragment.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "theme config bak img error...");
    }
  }
  
  private void i()
  {
    if ((!TextUtils.isEmpty(this.D)) && (isAdded()))
    {
      String str = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getZipFolderPath(this.g, this.D);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAnimFrameBgProcess zipName = ");
        localStringBuilder.append(str);
        QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
      }
      if (c(str)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess not exist, start download...");
      }
      ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).downloadWithSuffix(this.g, this.D, ".zip", new ThemeHbFragment.3(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess theme config bak img error...");
    }
  }
  
  private void j()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.L < 2000L) {
      return;
    }
    this.L = l1;
    for (;;)
    {
      try
      {
        Object localObject1 = this.C;
        if ((localObject1 != null) && (this.t < this.C.length()) && (this.t >= 0))
        {
          localObject1 = this.C.optString(this.t);
          Object localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = getResources().getString(R.string.L);
          }
          localObject1 = this.f.getMapPacketExtra();
          ((Map)localObject1).put("total_num", this.b);
          ((Map)localObject1).put("total_amount", QwUtils.b(this.H));
          ((Map)localObject1).put("wishing", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.z.b);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("resource_type", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.i);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("channel", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.z.a);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("type", ((StringBuilder)localObject2).toString());
          ((Map)localObject1).put("bus_type", this.I);
          if (this.M)
          {
            ((Map)localObject1).put("groupid", this.f.mGroupId);
            ((Map)localObject1).put("theme_type", this.f.mThemeType);
          }
          this.h.a((Map)localObject1);
          if (this.i != 16384) {
            break label370;
          }
          localObject1 = "bqredpacket.order.send";
          e((String)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str = "";
      continue;
      label370:
      str = "theme.pack.go";
    }
  }
  
  private void k()
  {
    QLog.i("ThemeHbFragment", 2, "clickFaceAction...");
    this.f.onFaceHbPacket(this.H);
  }
  
  private void l()
  {
    int i;
    int j;
    label282:
    Object localObject2;
    if (this.M)
    {
      if ((this.a != null) && (this.B != null))
      {
        Object localObject1 = new Random();
        try
        {
          if (this.A > 0) {
            i = b(((Random)localObject1).nextInt(this.A));
          } else {
            i = 0;
          }
          try
          {
            this.b = this.a.optString(i, "1");
            localObject1 = this.B.optString(i, "0.1");
            this.H = QwUtils.a(this.b, (String)localObject1);
            this.F = this.C.optString(i, getString(R.string.v));
            j = i;
            if (a(new BigDecimal((String)localObject1).doubleValue()) != 0) {
              break label282;
            }
            this.o.a();
            this.p.setText(this.F);
            if (this.y != null) {
              this.y.setText(String.format(getString(R.string.D), new Object[] { this.b }));
            }
            localObject1 = this.q;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(R.string.I));
            localStringBuilder.append(" ");
            localStringBuilder.append(this.H);
            localStringBuilder.append(HardCodeUtil.a(R.string.cZ));
            ((Button)localObject1).setText(localStringBuilder.toString());
            j = i;
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
        catch (Exception localException2)
        {
          i = 0;
        }
        j = i;
        localObject2 = this.K;
        if ((localObject2 != null) && (localObject2.length > j)) {
          localObject2[j] = 1;
        }
        this.t = j;
      }
    }
    else
    {
      localObject2 = this.C;
      if ((localObject2 != null) && (this.B != null))
      {
        i = ((JSONArray)localObject2).length();
        if (i > 0)
        {
          j = this.B.length();
          if ((j > 0) && (j == i))
          {
            i = b(new Random().nextInt(j));
            try
            {
              this.H = this.B.optString(i);
              double d1 = new BigDecimal(this.H).doubleValue();
              this.F = this.C.optString(i);
              if (a(d1) == 0) {
                this.o.a();
              }
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
            }
            int[] arrayOfInt = this.K;
            if ((arrayOfInt != null) && (arrayOfInt.length > i)) {
              arrayOfInt[i] = 1;
            }
            this.t = i;
          }
        }
      }
    }
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    } else {
      localIntent.putExtra("retmsg", paramString1);
    }
    localIntent.putExtra("result", paramInt);
    return localIntent;
  }
  
  public void a()
  {
    this.L = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseThemeConfig themeId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ThemeHbFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.z = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getThemeRedPkgConfById(paramInt);
    Object localObject = this.z;
    if (localObject == null)
    {
      this.f.showThemeHbToast(getString(R.string.P));
      return;
    }
    this.C = ((ThemeRedPkgConfig)localObject).l;
    this.B = this.z.m;
    this.D = this.z.e;
    if (this.M)
    {
      this.C = this.z.n;
      this.B = this.z.o;
      this.a = this.z.p;
      if (this.a == null) {
        this.a = new JSONArray();
      }
    }
    if (this.B == null) {
      this.B = new JSONArray();
    }
    if (this.C == null) {
      this.C = new JSONArray();
    }
    if (1 == this.z.b)
    {
      i();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.D);
      ((StringBuilder)localObject).append(".png");
      this.D = ((StringBuilder)localObject).toString();
      h();
    }
    int i;
    if (this.M)
    {
      localObject = this.a;
      if ((localObject != null) && (this.B != null))
      {
        i = ((JSONArray)localObject).length();
        int j = this.B.length();
        int k = this.C.length();
        paramInt = j;
        if (k > j) {
          paramInt = k;
        }
        this.A = paramInt;
        j = this.A;
        paramInt = i;
        if (j > i) {
          paramInt = j;
        }
        this.A = paramInt;
        this.K = new int[this.A];
      }
    }
    else
    {
      localObject = this.B;
      if (localObject == null)
      {
        QLog.i("ThemeHbFragment", 2, "mArrMoney error, null checked...");
        return;
      }
      i = ((JSONArray)localObject).length();
      paramInt = this.C.length();
      localObject = getString(R.string.v);
      if (i > paramInt) {
        while (paramInt < i)
        {
          this.C.put(localObject);
          paramInt += 1;
        }
      }
      if (i < paramInt)
      {
        localObject = new JSONArray();
        paramInt = 0;
        while (paramInt < i)
        {
          ((JSONArray)localObject).put(this.C.get(paramInt));
          paramInt += 1;
        }
        this.C = ((JSONArray)localObject);
      }
      if (i > 0) {
        this.K = new int[i];
      }
    }
  }
  
  public int b(int paramInt)
  {
    int[] arrayOfInt = this.K;
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt))
    {
      if (paramInt < 0) {
        return 0;
      }
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        i = (paramInt + j) % k;
        if (this.K[i] == 0) {
          break label65;
        }
        j += 1;
      }
      int i = 0;
      label65:
      if (j == k)
      {
        i = 0;
        for (;;)
        {
          j = paramInt;
          if (i >= k) {
            break;
          }
          this.K[i] = 0;
          i += 1;
        }
      }
      j = i;
      return j;
    }
    return 0;
  }
  
  public void d()
  {
    if (this.t >= 0)
    {
      Object localObject = this.G;
      if (localObject != null)
      {
        localObject = ((ThemeHbFragment.SendHbHandler)localObject).obtainMessage();
        ((Message)localObject).what = 100;
        this.G.sendMessage((Message)localObject);
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    l();
    this.l.setVisibility(0);
    this.r.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.i("ThemeHbFragment", 2, "onAnimationStart...");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.ae)
    {
      if (this.i == 16384)
      {
        e("bqredpacket.order.randomamount");
        e();
        return;
      }
      e("theme.pack.change");
      l();
      return;
    }
    if (i == R.id.cg)
    {
      if (this.i == 16384)
      {
        k();
        return;
      }
      j();
      return;
    }
    if ((i == R.id.cz) || (i == R.id.w) || (i == R.id.y))
    {
      paramView = this.v;
      if (paramView != null) {
        paramView.a();
      }
      if (this.i == 16384) {
        paramView = "bqredpacket.order.close";
      } else {
        paramView = "theme.pack.back";
      }
      d(paramView);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getArguments();
    if (this.i == 16384) {
      e("bqredpacket.order.expose");
    }
    int i;
    if (this.i == 16384) {
      i = R.layout.m;
    } else {
      i = R.layout.t;
    }
    this.c = paramLayoutInflater.inflate(i, null);
    f();
    if (this.i == 16384) {
      b(paramViewGroup);
    } else {
      a(paramViewGroup);
    }
    c();
    g();
    return this.c;
  }
  
  public void onDestroyView()
  {
    this.E = null;
    this.u = null;
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment
 * JD-Core Version:    0.7.0.1
 */