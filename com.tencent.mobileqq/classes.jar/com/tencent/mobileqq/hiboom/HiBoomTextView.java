package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.Vas.ColorFont.FounderHiBoomLayout;
import com.etrump.mixlayout.EMCollection;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.api.ETFontUtil;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HiBoomTextView
  extends ImageView
{
  private static QQLruCache<String, EMEmoticon> H = new HiBoomTextView.3(2014, 10);
  private static Bitmap I = null;
  public static Handler j;
  public static HiBoomTextView.EmoticonUIHandler k;
  private ETFont A;
  private ETFont B = null;
  private long C;
  private long D;
  private boolean E;
  private ChatMessage F;
  private BaseSessionInfo G;
  public int a;
  public int b = -1;
  public HiBoomFont.HiBoomFontDownloader c;
  public final HiBoomTextView.BitmapLocker d = new HiBoomTextView.BitmapLocker(this, null);
  public boolean e;
  public int f;
  public float g = 1.0F;
  public HiBoomTextView.OnDoubleClick h = null;
  GestureDetector i = new GestureDetector(getContext(), new HiBoomTextView.1(this));
  private HiBoomFontDrawer l = null;
  private Paint m;
  private String n;
  private int o;
  private int p;
  private int q;
  private String r;
  private String s;
  private FounderHiBoomLayout t;
  private int u;
  private int v;
  private int w;
  private EMEmoticon x = null;
  private boolean y = false;
  private boolean z = false;
  
  public HiBoomTextView(Context paramContext)
  {
    super(paramContext);
    k();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1073741824) {
      paramInt2 = this.q;
    }
    return paramInt2;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = HiBoomConstants.a;
    int i2 = this.o;
    if (i2 > 0) {
      return i2;
    }
    if ((paramInt1 == 1073741824) && (paramInt3 == 1073741824)) {
      paramInt2 = Math.min(paramInt2, paramInt4);
    } else if (paramInt1 != 1073741824) {
      if (paramInt3 == 1073741824) {
        paramInt2 = paramInt4;
      } else {
        paramInt2 = i1;
      }
    }
    return Math.min(paramInt2, HiBoomConstants.a);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append(paramInt1);
    paramString.append("_");
    paramString.append(str);
    paramString.append("_");
    paramString.append(paramInt2);
    return paramString.toString().hashCode();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject = this.t;
    if (localObject == null)
    {
      paramInt1 = this.o;
      if (paramInt1 <= 0) {
        paramInt1 = HiBoomConstants.a;
      }
      if (paramInt3 == 1073741824) {
        paramInt2 = paramInt4;
      } else {
        paramInt2 = paramInt1;
      }
      this.p = paramInt2;
      if (paramInt5 == 1073741824) {
        paramInt1 = paramInt6;
      }
      this.q = paramInt1;
      return;
    }
    localObject = ((FounderHiBoomLayout)localObject).a(paramInt1, paramInt2, this.o);
    this.p = localObject[0];
    this.q = localObject[1];
    if (this.B == null) {
      this.B = new ETFont(0, null, 0.0F);
    }
    if ((this.C != this.D) || (!this.A.equals(this.B)))
    {
      this.B.copy(this.A);
      this.C = this.D;
      e();
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble)
  {
    double d1;
    if ((paramInt1 == 1073741824) && (paramInt3 == 1073741824))
    {
      d1 = paramInt2;
      double d2 = paramInt4;
      Double.isNaN(d1);
      Double.isNaN(d2);
      if (d1 / d2 > paramDouble)
      {
        Double.isNaN(d2);
        this.p = ((int)(paramDouble * d2));
        this.q = paramInt4;
        return;
      }
      Double.isNaN(d1);
      this.q = ((int)(d1 / paramDouble));
      this.p = paramInt2;
      return;
    }
    if (paramInt1 == 1073741824)
    {
      this.p = paramInt2;
      d1 = paramInt2;
      Double.isNaN(d1);
      this.q = ((int)(d1 / paramDouble));
      return;
    }
    if (paramInt3 == 1073741824)
    {
      this.q = paramInt4;
      d1 = paramInt4;
      Double.isNaN(d1);
      this.p = ((int)(d1 * paramDouble));
      return;
    }
    this.p = paramInt5;
    this.q = paramInt6;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, HiBoomFontDrawer paramHiBoomFontDrawer)
  {
    if (paramHiBoomFontDrawer.a.d != null)
    {
      paramHiBoomFontDrawer = paramHiBoomFontDrawer.a.d.iterator();
      while (paramHiBoomFontDrawer.hasNext())
      {
        HiBoomInfo.HiBoomInfoStyle localHiBoomInfoStyle = (HiBoomInfo.HiBoomInfoStyle)paramHiBoomFontDrawer.next();
        if (this.n.length() == localHiBoomInfoStyle.f)
        {
          int i1 = localHiBoomInfoStyle.e[0];
          int i2 = localHiBoomInfoStyle.e[1];
          double d1 = i1;
          double d2 = i2;
          Double.isNaN(d1);
          Double.isNaN(d2);
          a(paramInt1, paramInt2, paramInt3, paramInt4, i1, i2, d1 / d2);
          paramInt1 = this.o;
          if (paramInt1 > 0)
          {
            if (i1 > i2)
            {
              this.q = (i2 * paramInt1 / i1);
              this.p = paramInt1;
              return;
            }
            this.p = (i1 * paramInt1 / i2);
            this.q = paramInt1;
          }
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((!TextUtils.isEmpty(this.s)) && (this.s.startsWith("#")) && (this.s.length() == 9))
    {
      this.m.setColor(Color.parseColor(this.s));
      this.m.setStyle(Paint.Style.STROKE);
      this.m.setStrokeWidth(1.0F);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), ScreenUtil.dip2px(4.0F), ScreenUtil.dip2px(4.0F), this.m);
    }
  }
  
  private boolean a(Canvas paramCanvas, HiBoomFontDrawer paramHiBoomFontDrawer)
  {
    if (paramHiBoomFontDrawer.b == 2) {}
    try
    {
      if (!paramHiBoomFontDrawer.a(this.n.length())) {
        break label87;
      }
      int i1 = Math.max(getMeasuredHeight(), getMeasuredWidth());
      paramHiBoomFontDrawer.a(this.n, i1, paramCanvas);
    }
    catch (Exception paramCanvas)
    {
      label47:
      break label47;
    }
    this.E = true;
    if ((paramHiBoomFontDrawer.b != 1) && (paramHiBoomFontDrawer.b != 3))
    {
      if (paramHiBoomFontDrawer.b == 4) {
        c(paramCanvas);
      }
      label87:
      return false;
    }
    return d(paramCanvas);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1073741824) {
      paramInt2 = this.p;
    }
    return paramInt2;
  }
  
  private void b(Canvas paramCanvas)
  {
    if ((!TextUtils.isEmpty(this.r)) && (this.r.startsWith("#")) && (this.r.length() == 9))
    {
      this.m.setStyle(Paint.Style.FILL);
      this.m.setColor(Color.parseColor(this.r));
      paramCanvas.drawRoundRect(new RectF(1.0F, 1.0F, getMeasuredWidth() - 1, getMeasuredHeight() - 1), ScreenUtil.dip2px(4.0F), ScreenUtil.dip2px(4.0F), this.m);
    }
  }
  
  private static void b(Message paramMessage)
  {
    HiBoomTextView.EmoticonHolder localEmoticonHolder = (HiBoomTextView.EmoticonHolder)paramMessage.obj;
    if (localEmoticonHolder != null)
    {
      d(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getWidth(), HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getHeight());
      ETEngine localETEngine = HiBoomFont.a().b;
      paramMessage = new StringBuilder();
      paramMessage.append(HiBoomTextView.EmoticonHolder.b(localEmoticonHolder));
      paramMessage.append(HiBoomTextView.EmoticonHolder.c(localEmoticonHolder).getId());
      paramMessage.append(HiBoomTextView.EmoticonHolder.d(localEmoticonHolder));
      paramMessage.append(HiBoomTextView.EmoticonHolder.c(localEmoticonHolder).getSize());
      String str = paramMessage.toString();
      Object localObject = (EMEmoticon)H.get(str);
      paramMessage = (Message)localObject;
      if (localObject == null)
      {
        localObject = EMEmoticon.createEmoticon(localETEngine, HiBoomTextView.EmoticonHolder.b(localEmoticonHolder), HiBoomTextView.EmoticonHolder.d(localEmoticonHolder), HiBoomTextView.EmoticonHolder.c(localEmoticonHolder));
        paramMessage = (Message)localObject;
        if (localObject != null)
        {
          H.put(str, localObject);
          paramMessage = (Message)localObject;
        }
      }
      if (paramMessage != null)
      {
        paramMessage.gotoFrame(HiBoomTextView.EmoticonHolder.e(localEmoticonHolder));
        paramMessage.drawFrame(I);
        paramMessage = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder);
        localObject = HiBoomTextView.EmoticonHolder.f(localEmoticonHolder).get();
        int i1 = 0;
        int i2 = 0;
        if (localObject != null)
        {
          localObject = ((HiBoomTextView)HiBoomTextView.EmoticonHolder.f(localEmoticonHolder).get()).d;
          i1 = i2;
          try
          {
            if (!paramMessage.isRecycled())
            {
              i1 = i2;
              if (((HiBoomTextView)HiBoomTextView.EmoticonHolder.f(localEmoticonHolder).get()).D == HiBoomTextView.EmoticonHolder.g(localEmoticonHolder))
              {
                paramMessage.eraseColor(0);
                localETEngine.native_cloneBitmap(I, paramMessage);
                i1 = 1;
              }
            }
          }
          finally {}
        }
        if (i1 != 0)
        {
          new Message().what = 259;
          k.obtainMessage(259, localEmoticonHolder).sendToTarget();
        }
      }
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i2 = this.o;
    int i1 = paramInt2;
    if (i2 > 0)
    {
      i1 = paramInt2;
      if (paramInt1 == 1073741824)
      {
        i1 = paramInt2;
        if (paramInt2 > i2) {
          i1 = i2;
        }
      }
    }
    return i1;
  }
  
  private void c(Canvas paramCanvas)
  {
    FounderHiBoomLayout localFounderHiBoomLayout = this.t;
    if (localFounderHiBoomLayout != null)
    {
      if (!localFounderHiBoomLayout.a(paramCanvas)) {
        this.E = true;
      }
      if (!d()) {
        this.t.g();
      }
    }
    else
    {
      this.E = true;
    }
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = I;
    if ((localBitmap != null) && ((localBitmap.getWidth() < paramInt1) || (I.getHeight() < paramInt2)))
    {
      I.recycle();
      I = null;
    }
    localBitmap = I;
    if (localBitmap == null)
    {
      I = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return;
    }
    localBitmap.eraseColor(0);
  }
  
  public static boolean d()
  {
    return ETFontUtil.enableAnimation;
  }
  
  private boolean d(Canvas paramCanvas)
  {
    if (this.x != null)
    {
      Bitmap localBitmap = this.d.a();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        synchronized (this.d)
        {
          paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
        }
      }
      setImageResource(2130849051);
      setScaleX(this.g);
      setScaleY(this.g);
      return true;
    }
    this.E = true;
    return false;
  }
  
  private void e(Canvas paramCanvas)
  {
    if (b()) {
      setImageResource(2130849050);
    }
    setScaleX(this.g);
    setScaleY(this.g);
  }
  
  public static void g()
  {
    if (j == null)
    {
      k = new HiBoomTextView.EmoticonUIHandler(null);
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject != null)
      {
        localObject = (IFontManagerService)((AppRuntime)localObject).getRuntimeService(IFontManagerService.class, "");
        if ((localObject != null) && (((IFontManagerService)localObject).getHandlerThread() != null)) {
          j = new HiBoomTextView.4(((IFontManagerService)localObject).getHandlerThread().getLooper());
        }
      }
    }
  }
  
  public static void h()
  {
    Object localObject = j;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      j.sendEmptyMessage(260);
    }
    localObject = k;
    if (localObject != null) {
      ((HiBoomTextView.EmoticonUIHandler)localObject).removeCallbacksAndMessages(null);
    }
    H.evictAll();
  }
  
  private void k()
  {
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setDither(true);
    this.m.setFilterBitmap(true);
    setImageResource(2130849051);
    setScaleType(ImageView.ScaleType.CENTER);
    g();
  }
  
  private void l()
  {
    if ((this.C != this.D) || (!this.A.equals(this.B)))
    {
      this.y = false;
      if (this.B == null) {
        this.B = new ETFont(0, null, 0.0F);
      }
      this.B.copy(this.A);
      this.C = this.D;
      this.v = 0;
      this.w = 0;
      EMEmoticon localEMEmoticon = this.x;
      if (localEMEmoticon != null)
      {
        localEMEmoticon.deleteDescriptor();
        this.x = null;
      }
      this.x = EMEmoticon.createEmoticon(HiBoomFont.a().a, this.n, this.u, this.A);
      localEMEmoticon = this.x;
      if (localEMEmoticon != null)
      {
        this.v = localEMEmoticon.getWidth();
        this.w = this.x.getHeight();
        if ((this.v < 1) || (this.w < 1))
        {
          this.x.deleteDescriptor();
          this.x = null;
        }
      }
      HiBoomTextView.BitmapLocker.a(this.d, this.v, this.w);
      e();
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiboom draw failed, fontId = ");
      localStringBuilder.append(this.a);
      QLog.e("HiBoomFont.TextView", 2, localStringBuilder.toString());
    }
    setImageResource(2130849050);
    setScaleX(this.g);
    setScaleY(this.g);
  }
  
  private void n()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).updateMsgFieldByUniseq(this.G.b, this.G.a, this.F.uniseq, "extStr", this.F.extStr);
  }
  
  private void setHiBoomSize(int paramInt)
  {
    EMEmoticon localEMEmoticon = this.x;
    if (localEMEmoticon != null)
    {
      this.p = localEMEmoticon.getWidth();
      this.q = this.x.getHeight();
      return;
    }
    this.q = paramInt;
    this.p = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = (paramBoolean ^ true);
    this.e = paramBoolean;
    if (this.x != null)
    {
      k.obtainMessage(257, HiBoomTextView.EmoticonHolder.a(this)).sendToTarget();
      if ((paramBoolean) && (!this.z) && (!this.y) && (d())) {
        this.y = true;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.a != 0) && (this.b >= 0) && (this.c != null)) {
      return HiBoomFont.a().a(this.a, this.b, this.c).g.get();
    }
    return false;
  }
  
  public boolean b()
  {
    if ((this.a != 0) && (this.b >= 0) && (this.c != null)) {
      return HiBoomFont.a().a(this.a, this.b, this.c).i.get();
    }
    return false;
  }
  
  public void c()
  {
    if (a())
    {
      Object localObject1 = HiBoomFont.a().a(this.a, this.b, this.c);
      if ((localObject1 != null) && ((((HiBoomFontDrawer)localObject1).b == 3) || (((HiBoomFontDrawer)localObject1).b == 1)))
      {
        Object localObject2 = this.A;
        if ((localObject2 == null) || (((ETFont)localObject2).mFontId != this.a))
        {
          if (((HiBoomFontDrawer)localObject1).b == 1) {
            localObject1 = ".hy";
          } else {
            localObject1 = ".hy3";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.c.a());
          ((StringBuilder)localObject2).append(this.a);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(this.a);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          this.A = new ETFont(this.a, (String)localObject1, this.o);
        }
        localObject1 = new EMCollection(HiBoomFont.a().a);
        if (!TextUtils.isEmpty(this.n))
        {
          localObject2 = this.A;
          if (localObject2 != null)
          {
            boolean bool = ((EMCollection)localObject1).retrieve(this.n, (IETFont)localObject2);
            int i1 = ((EMCollection)localObject1).getEmoticonCount();
            if ((bool) && (i1 > 0))
            {
              i1 = ((EMCollection)localObject1).getEmoticonIndex(0);
              if (this.u == i1) {
                break label465;
              }
              this.u = i1;
              this.e = true;
              break label465;
            }
            this.u = 0;
            break label465;
          }
        }
        this.u = 0;
      }
      else if ((localObject1 != null) && (((HiBoomFontDrawer)localObject1).b == 4))
      {
        localObject1 = this.A;
        if ((localObject1 == null) || (((ETFont)localObject1).mFontId != this.a))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.c.a());
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(".fz4");
          localObject1 = ((StringBuilder)localObject1).toString();
          this.A = new ETFont(this.a, (String)localObject1, this.o);
        }
        this.A.mText = getText();
        if (this.F == null) {
          this.A.mAnimationId = this.f;
        } else {
          this.A.mAnimationId = this.D;
        }
        if (this.t == null) {
          this.t = new FounderHiBoomLayout(this);
        }
        this.t.a(this.A);
      }
    }
    label465:
    requestLayout();
    invalidate();
  }
  
  public void e()
  {
    ChatMessage localChatMessage = this.F;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localChatMessage != null) {
      if (TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("font_animation_played")))
      {
        this.F.saveExtInfoToExtStr("font_animation_played", "1");
        ThreadManager.excute(new HiBoomTextView.2(this), 128, null, true);
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
    }
    this.e = bool1;
    if (this.x != null) {
      a(bool1);
    }
  }
  
  public void f()
  {
    if ((this.x != null) && (!this.z))
    {
      k.obtainMessage(259, HiBoomTextView.EmoticonHolder.a(this)).sendToTarget();
      if ((d()) && (this.e)) {
        this.y = true;
      }
    }
    FounderHiBoomLayout localFounderHiBoomLayout = this.t;
    if (localFounderHiBoomLayout != null) {
      localFounderHiBoomLayout.h();
    }
  }
  
  public String getText()
  {
    return this.n;
  }
  
  public boolean i()
  {
    return this.F == null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.E = false;
    if (!a())
    {
      e(paramCanvas);
      super.onDraw(paramCanvas);
      return;
    }
    setScaleX(1.0F);
    setScaleY(1.0F);
    b(paramCanvas);
    a(paramCanvas);
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(this.a, this.b, this.c);
    int i1 = (getMeasuredWidth() - this.p) / 2;
    int i2 = (getMeasuredHeight() - this.q) / 2;
    if ((i1 > 0) || (i2 > 0)) {
      paramCanvas.translate(i1, i2);
    }
    if (a(paramCanvas, localHiBoomFontDrawer)) {
      super.onDraw(paramCanvas);
    }
    if (this.E)
    {
      m();
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    i1 = c(i3, i1);
    i2 = c(i4, i2);
    if (!a())
    {
      paramInt1 = this.o;
      if (paramInt1 <= 0) {
        paramInt1 = HiBoomConstants.a;
      }
      if (i3 == 1073741824) {
        paramInt2 = i1;
      } else {
        paramInt2 = paramInt1;
      }
      this.p = paramInt2;
      if (i4 == 1073741824) {
        paramInt1 = i2;
      }
      this.q = paramInt1;
    }
    else
    {
      Object localObject = HiBoomFont.a().a(this.a, this.b, this.c);
      if (((HiBoomFontDrawer)localObject).b == 2)
      {
        a(i3, i1, i4, i2, (HiBoomFontDrawer)localObject);
      }
      else if ((((HiBoomFontDrawer)localObject).b != 1) && (((HiBoomFontDrawer)localObject).b != 3))
      {
        if (((HiBoomFontDrawer)localObject).b == 4) {
          a(paramInt1, paramInt2, i3, i1, i4, i2);
        }
      }
      else
      {
        paramInt1 = a(i3, i1, i4, i2);
        localObject = this.A;
        if (localObject == null)
        {
          this.q = paramInt1;
          this.p = paramInt1;
          setMeasuredDimension(b(i3, i1), a(i4, i2));
          return;
        }
        ((ETFont)localObject).setSize(paramInt1);
        l();
        setHiBoomSize(paramInt1);
      }
    }
    setMeasuredDimension(b(i3, i1), a(i4, i2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.i.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBGStrokeColor(String paramString)
  {
    this.s = paramString;
  }
  
  public void setBackgroundColor(String paramString)
  {
    this.r = paramString;
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, ChatMessage paramChatMessage, BaseSessionInfo paramBaseSessionInfo, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.F = paramChatMessage;
    this.G = paramBaseSessionInfo;
    if (this.D != paramChatMessage.uniseq)
    {
      this.D = paramChatMessage.uniseq;
      this.e = true;
    }
    setHiBoom(paramInt1, paramInt2, paramHiBoomFontDownloader);
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.b = paramInt2;
    this.c = paramHiBoomFontDownloader;
    this.l = HiBoomFont.a().a(paramInt1, paramInt2, paramHiBoomFontDownloader);
    this.l.a(this);
    if (this.a != paramInt1)
    {
      this.a = paramInt1;
      this.f = a(this.n, this.a, 0);
      if (a()) {
        c();
      }
    }
    if (this.F == null)
    {
      long l1 = this.D;
      paramInt1 = this.f;
      if (l1 != paramInt1)
      {
        this.D = paramInt1;
        this.e = true;
      }
    }
  }
  
  public void setLoadingScale(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void setMaxSize(int paramInt)
  {
    this.o = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 20) {
      localCharSequence = paramCharSequence.subSequence(0, 20);
    }
    this.n = localCharSequence.toString();
    this.f = a(this.n, this.a, 0);
    long l1 = this.D;
    int i1 = this.f;
    if ((l1 != i1) && (this.F == null))
    {
      this.D = i1;
      this.e = true;
    }
    if (a()) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView
 * JD-Core Version:    0.7.0.1
 */