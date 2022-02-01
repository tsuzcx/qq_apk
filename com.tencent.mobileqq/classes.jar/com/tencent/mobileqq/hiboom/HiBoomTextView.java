package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.graphics.Bitmap;
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
import auef;
import aueg;
import aueh;
import auei;
import auej;
import auen;
import auex;
import auey;
import auez;
import aufa;
import aufb;
import aufc;
import aufd;
import com.etrump.mixlayout.EMCollection;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import gb;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import t;

public class HiBoomTextView
  extends ImageView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public static Handler a;
  public static aufc a;
  private static QQLruCache<String, EMEmoticon> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new auey(2014, 10);
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new auex(this));
  public aueg a;
  private aueh jdField_a_of_type_Aueh;
  public final aufa a;
  public aufd a;
  private EMEmoticon jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private MessageForHiBoom jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom;
  private String jdField_a_of_type_JavaLangString;
  private t jdField_a_of_type_T;
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  private ETFont jdField_b_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public HiBoomTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Aufa = new aufa(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    f();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Aufa = new aufa(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    f();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Aufa = new aufa(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    f();
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return (paramInt1 + "_" + str + "_" + paramInt2).hashCode();
  }
  
  public static boolean c()
  {
    return ETTextView.enableAnimation;
  }
  
  public static void d()
  {
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      jdField_a_of_type_Aufc = new aufc(null);
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        gb localgb = (gb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(42);
        if ((localgb != null) && (localgb.a != null)) {
          jdField_a_of_type_AndroidOsHandler = new auez(localgb.a.getLooper());
        }
      }
    }
  }
  
  public static void e()
  {
    if (jdField_a_of_type_AndroidOsHandler != null)
    {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(260);
    }
    if (jdField_a_of_type_Aufc != null) {
      jdField_a_of_type_Aufc.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130847074);
    setScaleType(ImageView.ScaleType.CENTER);
    d();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    aueh localaueh;
    Object localObject;
    if (a())
    {
      localaueh = auef.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Aueg);
      if ((localaueh == null) || ((localaueh.jdField_a_of_type_Int != 3) && (localaueh.jdField_a_of_type_Int != 1))) {
        break label266;
      }
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != this.jdField_a_of_type_Int))
      {
        localObject = ".hy3";
        if (localaueh.jdField_a_of_type_Int == 1) {
          localObject = ".hy";
        }
        localObject = this.jdField_a_of_type_Aueg.a() + this.jdField_a_of_type_Int + File.separator + this.jdField_a_of_type_Int + (String)localObject;
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(this.jdField_a_of_type_Int, (String)localObject, this.jdField_d_of_type_Int);
      }
      localObject = new EMCollection(auef.a().a);
      if ((localObject == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)) {
        break label258;
      }
      bool = ((EMCollection)localObject).retrieve(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      j = ((EMCollection)localObject).getEmoticonCount();
      if ((!bool) || (j <= 0)) {
        break label250;
      }
      j = ((EMCollection)localObject).getEmoticonIndex(0);
      if (this.g != j)
      {
        this.g = j;
        this.jdField_a_of_type_Boolean = true;
      }
    }
    label250:
    while ((localaueh == null) || (localaueh.jdField_a_of_type_Int != 4)) {
      for (;;)
      {
        boolean bool;
        int j;
        requestLayout();
        invalidate();
        return;
        this.g = 0;
        continue;
        this.g = 0;
      }
    }
    label258:
    label266:
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != this.jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_Aueg.a() + this.jdField_a_of_type_Int + File.separator + this.jdField_a_of_type_Int + ".fz4";
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(this.jdField_a_of_type_Int, (String)localObject, this.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null) {}
    for (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = this.jdField_c_of_type_Int;; this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = this.jdField_b_of_type_Long)
    {
      if (this.jdField_a_of_type_T == null) {
        this.jdField_a_of_type_T = new t(this);
      }
      this.jdField_a_of_type_T.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
      {
        jdField_a_of_type_Aufc.obtainMessage(257, aufb.a(this)).sendToTarget();
        if ((paramBoolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (c())) {
          this.jdField_b_of_type_Boolean = true;
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int < 0) || (this.jdField_a_of_type_Aueg == null)) {
      return false;
    }
    return auef.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Aueg).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom.getExtInfoFromExtStr("font_animation_played"))) {
        break label76;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom.saveExtInfoToExtStr("font_animation_played", "1");
      ThreadManager.excute(new HiBoomTextView.2(this), 128, null, true);
    }
    label76:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) {
        a(bool1);
      }
      return;
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int < 0) || (this.jdField_a_of_type_Aueg == null)) {
      return false;
    }
    return auef.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Aueg).c.get();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) && (!this.jdField_c_of_type_Boolean))
    {
      jdField_a_of_type_Aufc.obtainMessage(259, aufb.a(this)).sendToTarget();
      if ((c()) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_T != null) {
      this.jdField_a_of_type_T.g();
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_d_of_type_Boolean = false;
    if (!a())
    {
      if (b()) {
        setImageResource(2130847073);
      }
      setScaleX(this.jdField_a_of_type_Float);
      setScaleY(this.jdField_a_of_type_Float);
      super.onDraw(paramCanvas);
      return;
    }
    setScaleX(1.0F);
    setScaleY(1.0F);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.startsWith("#")) && (this.jdField_b_of_type_JavaLangString.length() == 9))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
      paramCanvas.drawRoundRect(new RectF(1.0F, 1.0F, getMeasuredWidth() - 1, getMeasuredHeight() - 1), ScreenUtil.dip2px(4.0F), ScreenUtil.dip2px(4.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.startsWith("#")) && (this.jdField_c_of_type_JavaLangString.length() == 9))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), ScreenUtil.dip2px(4.0F), ScreenUtil.dip2px(4.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    aueh localaueh = auef.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Aueg);
    int j = (getMeasuredWidth() - this.e) / 2;
    int k = (getMeasuredHeight() - this.f) / 2;
    if ((j > 0) || (k > 0)) {
      paramCanvas.translate(j, k);
    }
    if (localaueh.jdField_a_of_type_Int == 2) {}
    for (;;)
    {
      try
      {
        if (localaueh.a(this.jdField_a_of_type_JavaLangString.length()))
        {
          j = Math.max(getMeasuredHeight(), getMeasuredWidth());
          localaueh.a(this.jdField_a_of_type_JavaLangString, j, paramCanvas);
        }
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("HiBoomFont.TextView", 2, "hiboom draw failed, fontId = " + this.jdField_a_of_type_Int);
        }
        setImageResource(2130847073);
        setScaleX(this.jdField_a_of_type_Float);
        setScaleY(this.jdField_a_of_type_Float);
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_d_of_type_Boolean = true;
        continue;
      }
      if ((localException.jdField_a_of_type_Int == 1) || (localException.jdField_a_of_type_Int == 3))
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
        {
          Bitmap localBitmap = this.jdField_a_of_type_Aufa.a();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            synchronized (this.jdField_a_of_type_Aufa)
            {
              paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
            }
          }
          setImageResource(2130847074);
          setScaleX(this.jdField_a_of_type_Float);
          setScaleY(this.jdField_a_of_type_Float);
          super.onDraw(paramCanvas);
        }
        else
        {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      else if (???.jdField_a_of_type_Int == 4) {
        if (this.jdField_a_of_type_T != null)
        {
          if (!this.jdField_a_of_type_T.a(paramCanvas)) {
            this.jdField_d_of_type_Boolean = true;
          }
          if (!c()) {
            this.jdField_a_of_type_T.f();
          }
        }
        else
        {
          this.jdField_d_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((this.jdField_d_of_type_Int > 0) && (i1 == 1073741824) && (k > this.jdField_d_of_type_Int)) {
      k = this.jdField_d_of_type_Int;
    }
    for (;;)
    {
      int j = m;
      if (this.jdField_d_of_type_Int > 0)
      {
        j = m;
        if (n == 1073741824)
        {
          j = m;
          if (m > this.jdField_d_of_type_Int) {
            j = this.jdField_d_of_type_Int;
          }
        }
      }
      if (!a()) {
        if (this.jdField_d_of_type_Int > 0)
        {
          paramInt1 = this.jdField_d_of_type_Int;
          if (i1 != 1073741824) {
            break label191;
          }
          paramInt2 = k;
          label126:
          this.e = paramInt2;
          if (n == 1073741824) {
            paramInt1 = j;
          }
          this.f = paramInt1;
          label146:
          break label251;
        }
      }
      for (;;)
      {
        if (i1 != 1073741824) {
          k = this.e;
        }
        if (n != 1073741824) {
          j = this.f;
        }
        setMeasuredDimension(k, j);
        return;
        paramInt1 = auen.jdField_a_of_type_Int;
        break;
        label191:
        paramInt2 = paramInt1;
        break label126;
        Object localObject = auef.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Aueg);
        if (((aueh)localObject).jdField_a_of_type_Int == 2)
        {
          if (((aueh)localObject).jdField_a_of_type_Auei.a == null) {
            continue;
          }
          localObject = ((aueh)localObject).jdField_a_of_type_Auei.a.iterator();
          label251:
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          auej localauej = (auej)((Iterator)localObject).next();
          if (this.jdField_a_of_type_JavaLangString.length() != localauej.jdField_a_of_type_Int) {
            break label146;
          }
          paramInt1 = localauej.jdField_a_of_type_ArrayOfInt[0];
          paramInt2 = localauej.jdField_a_of_type_ArrayOfInt[1];
          double d1 = paramInt1 / paramInt2;
          if ((i1 == 1073741824) && (n == 1073741824)) {
            if (k / j > d1)
            {
              this.e = ((int)(d1 * j));
              this.f = j;
            }
          }
          for (;;)
          {
            if (this.jdField_d_of_type_Int <= 0) {
              break label473;
            }
            if (paramInt1 <= paramInt2) {
              break label475;
            }
            this.f = (paramInt2 * this.jdField_d_of_type_Int / paramInt1);
            this.e = this.jdField_d_of_type_Int;
            break;
            this.f = ((int)(k / d1));
            this.e = k;
            continue;
            if (i1 == 1073741824)
            {
              this.e = k;
              this.f = ((int)(k / d1));
            }
            else if (n == 1073741824)
            {
              this.f = j;
              this.e = ((int)(d1 * j));
            }
            else
            {
              this.e = paramInt1;
              this.f = paramInt2;
            }
          }
          label473:
          continue;
          label475:
          this.e = (paramInt1 * this.jdField_d_of_type_Int / paramInt2);
          this.f = this.jdField_d_of_type_Int;
          continue;
        }
        if ((((aueh)localObject).jdField_a_of_type_Int == 1) || (((aueh)localObject).jdField_a_of_type_Int == 3))
        {
          paramInt1 = auen.jdField_a_of_type_Int;
          if (this.jdField_d_of_type_Int > 0)
          {
            paramInt1 = this.jdField_d_of_type_Int;
            if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
            {
              this.f = paramInt1;
              this.e = paramInt1;
              if (i1 != 1073741824) {
                k = this.e;
              }
              if (n != 1073741824) {
                j = this.f;
              }
              setMeasuredDimension(k, j);
            }
          }
          else
          {
            if ((i1 == 1073741824) && (n == 1073741824)) {
              paramInt1 = Math.min(k, j);
            }
            for (;;)
            {
              paramInt1 = Math.min(paramInt1, auen.jdField_a_of_type_Int);
              break;
              if (i1 == 1073741824) {
                paramInt1 = k;
              } else if (n == 1073741824) {
                paramInt1 = j;
              }
            }
          }
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(paramInt1);
          if ((this.jdField_a_of_type_Long != this.jdField_b_of_type_Long) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(this.jdField_b_of_type_ComEtrumpMixlayoutETFont)))
          {
            this.jdField_b_of_type_Boolean = false;
            if (this.jdField_b_of_type_ComEtrumpMixlayoutETFont == null) {
              this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
            }
            this.jdField_b_of_type_ComEtrumpMixlayoutETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
            this.h = 0;
            this.i = 0;
            if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
            {
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.deleteDescriptor();
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
            }
            this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = EMEmoticon.createEmoticon(auef.a().a, this.jdField_a_of_type_JavaLangString, this.g, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
            {
              this.h = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getWidth();
              this.i = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
              if ((this.h < 1) || (this.i < 1))
              {
                this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.deleteDescriptor();
                this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
              }
            }
            aufa.a(this.jdField_a_of_type_Aufa, this.h, this.i);
            b();
          }
          if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
          {
            this.e = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getWidth();
            this.f = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
          }
          else
          {
            this.f = paramInt1;
            this.e = paramInt1;
          }
        }
        else if (((aueh)localObject).jdField_a_of_type_Int == 4)
        {
          if (this.jdField_a_of_type_T == null)
          {
            if (this.jdField_d_of_type_Int > 0)
            {
              paramInt1 = this.jdField_d_of_type_Int;
              label932:
              if (i1 != 1073741824) {
                break label974;
              }
            }
            label974:
            for (paramInt2 = k;; paramInt2 = paramInt1)
            {
              this.e = paramInt2;
              if (n == 1073741824) {
                paramInt1 = j;
              }
              this.f = paramInt1;
              break;
              paramInt1 = auen.jdField_a_of_type_Int;
              break label932;
            }
          }
          localObject = this.jdField_a_of_type_T.a(paramInt1, paramInt2, this.jdField_d_of_type_Int);
          this.e = localObject[0];
          this.f = localObject[1];
          if (this.jdField_b_of_type_ComEtrumpMixlayoutETFont == null) {
            this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
          }
          if ((this.jdField_a_of_type_Long != this.jdField_b_of_type_Long) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(this.jdField_b_of_type_ComEtrumpMixlayoutETFont)))
          {
            this.jdField_b_of_type_ComEtrumpMixlayoutETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
            b();
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBGStrokeColor(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setBackgroundColor(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, @Nonnull aueg paramaueg)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Aueg = paramaueg;
    this.jdField_a_of_type_Aueh = auef.a().a(paramInt1, paramInt2, paramaueg);
    this.jdField_a_of_type_Aueh.a(this);
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
      if (a()) {
        a();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null) && (this.jdField_b_of_type_Long != this.jdField_c_of_type_Int))
    {
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, MessageForHiBoom paramMessageForHiBoom, SessionInfo paramSessionInfo, @Nonnull aueg paramaueg)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom = paramMessageForHiBoom;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (this.jdField_b_of_type_Long != paramMessageForHiBoom.uniseq)
    {
      this.jdField_b_of_type_Long = paramMessageForHiBoom.uniseq;
      this.jdField_a_of_type_Boolean = true;
    }
    setHiBoom(paramInt1, paramInt2, paramaueg);
  }
  
  public void setLoadingScale(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setMaxSize(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    do
    {
      return;
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 20) {
        localCharSequence = paramCharSequence.subSequence(0, 20);
      }
      this.jdField_a_of_type_JavaLangString = localCharSequence.toString();
      this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
      if ((this.jdField_b_of_type_Long != this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null))
      {
        this.jdField_b_of_type_Long = this.jdField_c_of_type_Int;
        this.jdField_a_of_type_Boolean = true;
      }
    } while (!a());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView
 * JD-Core Version:    0.7.0.1
 */