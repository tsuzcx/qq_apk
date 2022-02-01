package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinAnimManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySkinAnimManager
  extends ReadInJoyAnimBaseManager
  implements IReadInJoySkinAnimManager
{
  private boolean A;
  private int B;
  private int C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private int H;
  private int I;
  private boolean J;
  private Runnable K;
  private int g = -2;
  private int h = -2;
  private List<String> i;
  private int j;
  private String k;
  private String l;
  private String m;
  private ReadInJoySkinAnimManager.ResourceHandler n;
  private boolean o;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> p;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> q;
  private int r;
  private int s;
  private Context t;
  private SoundPool u;
  private SoundPool v;
  private int w;
  private int x;
  private volatile boolean y;
  private boolean z;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.o = false;
    this.r = -2;
    this.s = -2;
    this.x = 0;
    this.y = false;
    this.z = false;
    this.A = false;
    this.C = -2;
    this.D = true;
    this.E = false;
    this.F = false;
    this.G = false;
    this.H = 1;
    this.I = -1;
    this.J = false;
    this.K = new ReadInJoySkinAnimManager.2(this);
    this.t = paramContext;
    this.n = new ReadInJoySkinAnimManager.ResourceHandler(this);
    if ((float)Runtime.getRuntime().maxMemory() <= 1.415578E+008F) {
      bool = true;
    }
    this.J = bool;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (BaseActivity)paramContext;
      ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)paramContext.app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      if ((localReadInJoyRefreshManager.d() == 1) && (localReadInJoyRefreshManager.e()))
      {
        this.i = RefreshRes.k();
        this.j = RefreshRes.f();
        this.k = RefreshRes.c();
        this.l = localReadInJoyRefreshManager.c();
        this.m = RefreshRes.h();
        this.I = 1;
      }
      else
      {
        this.i = CommonSkinRes.l();
        this.j = CommonSkinRes.i();
        this.k = CommonSkinRes.f();
        this.l = ((ReadInJoySkinManager)paramContext.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b();
        this.m = CommonSkinRes.j();
        this.I = 2;
      }
      if (this.g == -2)
      {
        this.g = ((int)(paramContext.getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
        int i1 = this.j;
        if (i1 == 1) {
          this.h = ((int)(paramContext.getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
        } else if (i1 == 2)
        {
          if (localReadInJoyRefreshManager.b()) {
            this.h = paramContext.getWindowManager().getDefaultDisplay().getWidth();
          } else {
            this.h = ((int)(paramContext.getWindowManager().getDefaultDisplay().getWidth() * 1.0F));
          }
        }
        else if (i1 == 3) {
          this.h = paramContext.getWindowManager().getDefaultDisplay().getWidth();
        }
      }
      if (this.H == 1)
      {
        this.H = 2;
        ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, true), 8, null, true);
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      i1 = (int)Math.floor(7340032.0F / paramInt2);
      if (paramInt1 > i1)
      {
        paramInt1 = (int)Math.ceil(paramInt1 / i1);
        break label36;
      }
    }
    paramInt1 = 1;
    label36:
    int i1 = paramInt1;
    StringBuilder localStringBuilder;
    if (paramInt1 <= 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSamplingRate invalid samplingRate. Here simpleBitmapSize = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" samplingRate = ");
      localStringBuilder.append(paramInt1);
      QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
      i1 = 1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSamplingRate simpleBitmapSize = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" samplingRate = ");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
    }
    return i1;
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return 1;
    }
    int i2 = paramOptions.outWidth;
    if (i2 > paramInt1)
    {
      int i1 = 2;
      int i3 = i2 / 2;
      for (;;)
      {
        i2 = i1;
        if (i3 / i1 < paramInt1) {
          break;
        }
        i1 *= 2;
      }
    }
    i2 = 1;
    double d = paramInt2 * paramInt3;
    Double.isNaN(d);
    d = Math.sqrt(d * 1.0D / 10485760.0D);
    while (i2 < d) {
      i2 *= 2;
    }
    if (QLog.isColorLevel())
    {
      paramOptions = new StringBuilder();
      paramOptions.append("calculateInSampleSize inSampleSize = ");
      paramOptions.append(i2);
      QLog.d("ReadInJoySkinAnimManager", 1, paramOptions.toString());
    }
    return i2;
  }
  
  private int a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.k);
    localStringBuilder.append("refreshAnimatePictures");
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    boolean bool = new File(localStringBuilder.toString()).exists();
    int i2 = 0;
    int i1 = i2;
    if (bool)
    {
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = false;
      paramString.inPreferredConfig = Bitmap.Config.ARGB_4444;
      try
      {
        paramString = ImageUtil.a(localStringBuilder.toString(), paramString);
        i2 = a(paramString);
        i1 = i2;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getSamplingRate simpleBitmapSize = ");
          paramString.append(i2);
          QLog.d("ReadInJoySkinAnimManager", 1, paramString.toString());
          return i2;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPngDrawable oom = ");
        localStringBuilder.append(paramString);
        QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    return i1;
  }
  
  private Drawable a(String paramString1, String paramString2, String paramString3, Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString3);
    if (new File(localStringBuilder.toString()).exists())
    {
      paramString3 = new BitmapFactory.Options();
      if ((this.C == -2) && (this.h != -2))
      {
        paramString3.inJustDecodeBounds = true;
        ImageUtil.a(localStringBuilder.toString(), paramString3);
        int i1 = this.j;
        if (i1 == 1) {
          this.C = a(paramString3, this.h, paramInt1, paramInt2);
        } else if (i1 == 2) {
          this.C = a(paramString3, this.h, paramInt1, paramInt2);
        } else if (i1 == 3) {
          this.C = a(paramString3, this.h, paramInt1, paramInt2);
        }
      }
      paramInt2 = this.C;
      if (paramInt2 != -2)
      {
        paramString3.inSampleSize = paramInt2;
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("mSampleSize = ");
          paramString2.append(this.C);
          QLog.d("ReadInJoySkinAnimManager", 1, paramString2.toString());
        }
      }
      paramString3.inJustDecodeBounds = false;
      paramString3.inPreferredConfig = Bitmap.Config.ARGB_4444;
      try
      {
        paramString2 = ImageUtil.a(localStringBuilder.toString(), paramString3);
        paramString1 = paramString2;
      }
      catch (OutOfMemoryError paramString2)
      {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt1, this.l, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
        paramString3 = new StringBuilder();
        paramString3.append("getPngDrawable oom = ");
        paramString3.append(paramString2);
        paramString3.append(" resFolderPath:");
        paramString3.append(paramString1);
        QLog.e("ReadInJoySkinAnimManager", 1, paramString3.toString());
        return null;
      }
    }
    else
    {
      paramString1 = null;
    }
    if (paramString1 != null) {
      return new BitmapDrawable(paramResources, paramString1);
    }
    QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable bitmap = null");
    return null;
  }
  
  private void a(int paramInt)
  {
    ArrayList localArrayList = this.p;
    int i4 = 0;
    int i2;
    if (localArrayList != null) {
      i2 = localArrayList.size();
    } else {
      i2 = 0;
    }
    int i1;
    if ((i2 > 0) && (this.j == 1))
    {
      i1 = this.g;
      if (paramInt >= i1) {
        paramInt = 100;
      } else if ((paramInt < i1) && (paramInt > 0) && (i1 != 0)) {
        paramInt = paramInt * 100 / i1;
      } else {
        paramInt = 0;
      }
      if (paramInt == 100)
      {
        paramInt = this.r;
        i1 = i2 - 1;
        if (paramInt != i1)
        {
          this.r = i1;
          a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(this.r)).c);
        }
      }
      else
      {
        i1 = 0;
        int i3;
        for (;;)
        {
          i3 = i4;
          if (i1 >= i2) {
            break;
          }
          if (((ReadInJoySkinAnimManager.PngWrapper)this.p.get(i1)).b >= paramInt)
          {
            i3 = i1;
            break;
          }
          i1 += 1;
        }
        if (i3 != this.r)
        {
          this.r = i3;
          a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(i3)).c);
        }
      }
    }
    else if ((i2 > 0) && (this.j == 2))
    {
      if (this.r == -2)
      {
        double d1 = Math.random();
        double d2 = i2;
        Double.isNaN(d2);
        this.r = ((int)Math.floor(d1 * d2));
        paramInt = this.r;
        this.s = paramInt;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(paramInt)).c);
      }
      paramInt = this.r;
      i1 = this.s;
      if (paramInt != i1)
      {
        this.r = i1;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(this.r)).c);
      }
    }
    else if ((i2 > 0) && (this.j == 3) && (!this.E))
    {
      this.E = true;
      ((SkinPullRefreshHeader)this.b).removeCallbacks(this.K);
      ((SkinPullRefreshHeader)this.b).post(this.K);
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    ((SkinPullRefreshHeader)this.b).a(paramDrawable, this.o ^ true);
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.k;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Drawable localDrawable = a(str1, "refreshRandomPictures", str2, localResources, paramList.size(), paramInt);
      if (localDrawable != null) {
        paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, 0, localDrawable));
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("initResources size = ");
      paramList.append(paramArrayList.size());
      QLog.d("ReadInJoySkinAnimManager", 1, paramList.toString());
    }
    this.q = paramArrayList;
    this.n.sendEmptyMessage(1);
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.k;
    int i2 = paramList.size();
    Iterator localIterator = paramList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      i1 += 1;
      if ((i1 % paramInt2 == 0) || (i1 == i2))
      {
        int i3 = b(str2);
        Drawable localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, paramList.size(), paramInt1);
        if ((i3 != -2) && (localDrawable != null)) {
          paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, i3, localDrawable));
        }
      }
    }
    Collections.sort(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("initResources size = ");
      paramList.append(paramArrayList.size());
      QLog.d("ReadInJoySkinAnimManager", 1, paramList.toString());
    }
    this.q = paramArrayList;
    this.n.sendEmptyMessage(1);
  }
  
  private void a(boolean paramBoolean)
  {
    List localList = this.i;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      b(paramBoolean);
      int i2 = a((String)localList.get(0));
      if (this.J)
      {
        i1 = this.j;
        if ((i1 == 1) || (i1 == 3))
        {
          i1 = a(localList.size(), i2);
          break label83;
        }
      }
      int i1 = 1;
      label83:
      ArrayList localArrayList = new ArrayList();
      int i3 = this.j;
      if ((i3 == 1) || (i3 == 2) || (i3 == 3)) {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.l, null, null, null);
      }
      i3 = this.j;
      if ((i3 != 1) && (i3 != 3))
      {
        if (i3 == 2) {
          a(localList, localArrayList, i2);
        }
      }
      else {
        a(localList, localArrayList, i2, i1);
      }
    }
  }
  
  private int b(String paramString)
  {
    Object localObject = paramString.substring(0, paramString.length() - 4);
    if (localObject != null) {}
    try
    {
      int i1 = Integer.parseInt((String)localObject);
      if ((i1 < 0) || (i1 > 100)) {
        break label65;
      }
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label33:
      break label33;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPNGIndex NumberFormatException pngName = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("ReadInJoySkinAnimManager", 1, ((StringBuilder)localObject).toString());
    label65:
    return -2;
  }
  
  private void b(int paramInt)
  {
    if (this.y)
    {
      boolean bool;
      if ((paramInt >= this.B) && (!this.z)) {
        bool = true;
      } else {
        bool = false;
      }
      this.A = bool;
      if (this.A)
      {
        AppInterface localAppInterface = ((BaseActivity)this.t).getAppInterface();
        if ((localAppInterface != null) && (((SharedPreUtils.bz(this.t, localAppInterface.getCurrentAccountUin())) && (this.I == 2)) || (this.I == 1))) {
          g();
        }
      }
      int i1 = this.B;
      if (paramInt >= i1)
      {
        this.z = true;
        return;
      }
      if (paramInt < i1) {
        this.z = false;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.m != null)
      {
        SoundPool localSoundPool = h();
        if (localSoundPool != null)
        {
          this.v = localSoundPool;
          this.n.sendEmptyMessage(2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
      }
    }
  }
  
  private void d()
  {
    if (this.b != null)
    {
      ((SkinPullRefreshHeader)this.b).removeCallbacks(this.K);
      this.E = false;
    }
  }
  
  private void e()
  {
    if (this.p == null)
    {
      this.p = this.q;
      if ((this.p.size() > 0) && (this.b != null)) {
        if (this.G)
        {
          a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(0)).c);
          ((SkinPullRefreshHeader)this.b).removeCallbacks(this.K);
          ((SkinPullRefreshHeader)this.b).post(this.K);
        }
        else
        {
          a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(0)).c);
        }
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPngArray mRefreshPullDownPNGS.size = ");
      localStringBuilder.append(this.p.size());
      QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
    }
    this.q = null;
    this.H = 3;
  }
  
  private void f()
  {
    if (this.u == null) {
      this.u = this.v;
    } else {
      QLog.e("ReadInJoySkinAnimManager", 1, "setSoundPool mRefreshPullDownPNGS.size != null");
    }
    this.v = null;
    String str = this.m;
    if ((str != null) && (new File(str).exists()))
    {
      SoundPool localSoundPool = this.u;
      if (localSoundPool != null)
      {
        this.w = localSoundPool.load(str, 0);
        long l1 = System.currentTimeMillis();
        this.u.setOnLoadCompleteListener(new ReadInJoySkinAnimManager.1(this, l1));
      }
    }
  }
  
  private void g()
  {
    Object localObject = (AudioManager)this.t.getSystemService("audio");
    int i1;
    if (localObject != null)
    {
      f = ((AudioManager)localObject).getStreamVolume(3);
      i1 = ((AudioManager)localObject).getStreamMaxVolume(3);
      if (i1 != 0)
      {
        f /= i1;
        break label47;
      }
    }
    float f = 0.5F;
    label47:
    if (localObject != null) {
      i1 = ((AudioManager)localObject).getRingerMode();
    } else {
      i1 = 2;
    }
    if (i1 == 2) {
      this.x = this.u.play(this.w, f, f, 0, 0, 1.0F);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playSound volume = ");
      ((StringBuilder)localObject).append(f);
      ((StringBuilder)localObject).append(" RINGER_MODE_NORMAL = ");
      ((StringBuilder)localObject).append(2);
      QLog.d("ReadInJoySkinAnimManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private SoundPool h()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      SoundPool.Builder localBuilder = new SoundPool.Builder();
      localBuilder.setMaxStreams(1);
      localBuilder.setAudioAttributes(new AudioAttributes.Builder().build());
      return localBuilder.build();
    }
    return new SoundPool(1, 3, 0);
  }
  
  public void a()
  {
    Object localObject = this.u;
    if (localObject != null) {
      ((SoundPool)localObject).stop(this.x);
    }
    d();
    localObject = this.p;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.p.clear();
    }
    this.p = null;
    if (this.H == 3) {
      this.H = 1;
    }
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    super.a(paramSlideActiveAnimController);
    if ((this.d != null) && (this.d.h())) {
      this.d.a(this.l, RefreshRes.d(), QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    }
  }
  
  public void b()
  {
    if (this.H == 1)
    {
      this.H = 2;
      ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, false), 8, null, true);
    }
  }
  
  public boolean c()
  {
    if ((this.F) && (!this.G)) {
      d();
    }
    this.D = true;
    if ((this.d != null) && (this.d.h()) && (this.d.c()))
    {
      if (this.j == 3) {
        d();
      }
      return true;
    }
    return false;
  }
  
  public void endOfRefresh()
  {
    super.endOfRefresh();
    if ((this.d != null) && (this.d.h())) {
      this.d.d();
    }
    this.G = false;
    if (!this.F) {
      d();
    }
  }
  
  public int getPullRefreshAreaHeight()
  {
    this.B = this.t.getResources().getDimensionPixelSize(2131299643);
    return this.B;
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.b == null)
    {
      Object localObject = LayoutInflater.from(this.t);
      boolean bool2 = false;
      this.b = ((SkinPullRefreshHeader)((LayoutInflater)localObject).inflate(2131629292, paramViewGroup, false));
      if (((this.b instanceof RelativeLayout)) && (this.g > 0))
      {
        localObject = (RelativeLayout)this.b;
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        paramViewGroup = null;
        int i1 = this.j;
        if ((i1 != 1) && (i1 != 3))
        {
          if (i1 == 2) {
            paramViewGroup = "refreshRandomPictures";
          }
        }
        else {
          paramViewGroup = "refreshAnimatePictures";
        }
        List localList = this.i;
        if ((localList != null) && (!localList.isEmpty()) && (paramViewGroup != null))
        {
          StringBuilder localStringBuilder = new StringBuilder(this.k);
          localStringBuilder.append(paramViewGroup);
          localStringBuilder.append("/");
          localStringBuilder.append((String)localList.get(0));
          if (new File(localStringBuilder.toString()).exists())
          {
            paramViewGroup = new BitmapFactory.Options();
            paramViewGroup.inJustDecodeBounds = true;
            ImageUtil.a(localStringBuilder.toString(), paramViewGroup);
            if ((this.h != -2) && (paramViewGroup.outWidth != 0)) {
              i1 = paramViewGroup.outHeight * this.h / paramViewGroup.outWidth;
            } else {
              i1 = 0;
            }
            i2 = i1;
            if (!QLog.isColorLevel()) {
              break label329;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getRefreshView options.outHeight = ");
            localStringBuilder.append(paramViewGroup.outHeight);
            localStringBuilder.append(" options.outWidth = ");
            localStringBuilder.append(paramViewGroup.outWidth);
            QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
            i2 = i1;
            break label329;
          }
        }
        int i2 = 0;
        label329:
        if (i2 != 0) {
          localLayoutParams.height = i2;
        } else {
          localLayoutParams.height = this.g;
        }
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        if (this.h != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject).findViewById(2131444561);
          localObject = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = this.h;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (QLog.isColorLevel())
        {
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("getRefreshView sDisplayHeight = ");
          paramViewGroup.append(this.g);
          paramViewGroup.append(" sDisplayWidth = ");
          paramViewGroup.append(this.h);
          paramViewGroup.append(" refreshType = ");
          paramViewGroup.append(this.j);
          QLog.d("ReadInJoySkinAnimManager", 1, paramViewGroup.toString());
        }
        paramViewGroup = this.t;
        if ((paramViewGroup instanceof BaseActivity))
        {
          paramViewGroup = (ReadInJoyRefreshManager)((BaseActivity)paramViewGroup).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
          localObject = paramViewGroup.a(this.t, 0);
          if ((localObject != null) && (((RefreshData)localObject).isAD)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          this.o = bool1;
          localObject = (SkinPullRefreshHeader)this.b;
          boolean bool1 = bool2;
          if (paramViewGroup.d() == 1)
          {
            bool1 = bool2;
            if (this.o) {
              bool1 = true;
            }
          }
          ((SkinPullRefreshHeader)localObject).setAdTabVisibility(bool1);
        }
      }
    }
    return (View)this.b;
  }
  
  public boolean isSkinAnimManager()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "resource onDestroy");
    }
    Object localObject = this.u;
    if (localObject != null)
    {
      ((SoundPool)localObject).stop(this.x);
      this.u.release();
      this.u = null;
    }
    this.y = false;
    this.A = false;
    this.z = false;
    localObject = this.p;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.p.clear();
      this.p = null;
    }
    this.H = 1;
    if (this.d != null) {
      this.d.j();
    }
    d();
  }
  
  public void onPullRefreshCancel()
  {
    d();
    super.onPullRefreshCancel();
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.G = true;
    this.b.a(0L);
    if ((this.d != null) && (this.d.h())) {
      this.d.a((SkinPullRefreshHeader)this.b);
    }
    int i1 = 0;
    ArrayList localArrayList = this.p;
    if (localArrayList != null) {
      i1 = localArrayList.size();
    }
    if (i1 > 0)
    {
      double d1 = Math.random();
      double d2 = i1;
      Double.isNaN(d2);
      this.s = ((int)Math.floor(d1 * d2));
    }
    super.onPullRefreshComplete(paramBoolean);
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    super.onPullRefreshing(paramInt, paramBoolean);
    if (this.b == null) {
      return;
    }
    if (paramBoolean)
    {
      this.b.f();
      return;
    }
    this.b.c(0L);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.F = this.G;
    }
    if ((this.d != null) && (this.d.h()) && (this.d.a(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onTouchPullDistance(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    if ((this.d != null) && (this.d.h())) {
      this.d.a((SkinPullRefreshHeader)this.b, paramInt1, paramInt2);
    }
    a(paramInt1);
    b(paramInt1);
    if (this.D)
    {
      paramInt1 = this.j;
      if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3))
      {
        Object localObject = this.p;
        if (localObject != null) {
          paramInt1 = ((ArrayList)localObject).size();
        } else {
          paramInt1 = 0;
        }
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.j, paramInt1, this.l, null, null, null);
        localObject = this.m;
        if ((localObject != null) && (new File((String)localObject).exists()))
        {
          if (this.y) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt1, 0, this.l, null, null, null);
        }
        this.D = false;
      }
    }
  }
  
  public void showPullRefresh()
  {
    if (this.b == null) {
      return;
    }
    this.b.a(0L);
    if ((this.b instanceof SkinPullRefreshHeader)) {
      ((SkinPullRefreshHeader)this.b).a(false, "");
    }
    this.b.f();
    if ((this.d != null) && (this.d.h())) {
      this.d.a((SkinPullRefreshHeader)this.b);
    }
    ArrayList localArrayList = this.p;
    int i2;
    if (localArrayList != null) {
      i2 = localArrayList.size();
    } else {
      i2 = 0;
    }
    int i1;
    if ((i2 > 0) && (this.j == 1))
    {
      int i3 = this.B * 100 / this.g;
      i1 = 0;
      while (i1 < i2)
      {
        if (((ReadInJoySkinAnimManager.PngWrapper)this.p.get(i1)).b >= i3) {
          break label178;
        }
        i1 += 1;
      }
      i1 = 0;
      label178:
      this.r = i1;
      a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(i1)).c);
    }
    else if ((i2 > 0) && (this.j == 2))
    {
      double d1 = Math.random();
      double d2 = i2;
      Double.isNaN(d2);
      this.r = ((int)Math.floor(d1 * d2));
      i1 = this.r;
      this.s = i1;
      a(((ReadInJoySkinAnimManager.PngWrapper)this.p.get(i1)).c);
    }
    else if ((i2 > 0) && (this.j == 3))
    {
      this.r = 0;
      ((SkinPullRefreshHeader)this.b).removeCallbacks(this.K);
      ((SkinPullRefreshHeader)this.b).post(this.K);
    }
    this.z = false;
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if (this.b == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.b.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.b.a(0);
      return;
    }
    this.b.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */