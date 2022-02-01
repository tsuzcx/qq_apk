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
import com.Vas.ColorFont.FounderHiBoomLayout;
import com.etrump.mixlayout.EMCollection;
import com.etrump.mixlayout.EMEmoticon;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HiBoomTextView
  extends ImageView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public static Handler a;
  private static QQLruCache<String, EMEmoticon> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new HiBoomTextView.3(2014, 10);
  public static HiBoomTextView.EmoticonUIHandler a;
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new HiBoomTextView.1(this));
  private FounderHiBoomLayout jdField_a_of_type_ComVasColorFontFounderHiBoomLayout;
  private EMEmoticon jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public HiBoomFont.HiBoomFontDownloader a;
  private HiBoomFontDrawer jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer = null;
  public final HiBoomTextView.BitmapLocker a;
  public HiBoomTextView.OnDoubleClick a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  private ETFont jdField_b_of_type_ComEtrumpMixlayoutETFont = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker = new HiBoomTextView.BitmapLocker(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = null;
    f();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker = new HiBoomTextView.BitmapLocker(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = null;
    f();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker = new HiBoomTextView.BitmapLocker(this, null);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = null;
    f();
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
  
  public static boolean c()
  {
    return ETFontUtil.enableAnimation;
  }
  
  public static void d()
  {
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler = new HiBoomTextView.EmoticonUIHandler(null);
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject != null)
      {
        localObject = (IFontManagerService)((AppRuntime)localObject).getRuntimeService(IFontManagerService.class, "");
        if ((localObject != null) && (((IFontManagerService)localObject).getHandlerThread() != null)) {
          jdField_a_of_type_AndroidOsHandler = new HiBoomTextView.4(((IFontManagerService)localObject).getHandlerThread().getLooper());
        }
      }
    }
  }
  
  public static void e()
  {
    Object localObject = jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(260);
    }
    localObject = jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler;
    if (localObject != null) {
      ((HiBoomTextView.EmoticonUIHandler)localObject).removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130847397);
    setScaleType(ImageView.ScaleType.CENTER);
    d();
  }
  
  private void g()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).updateMsgFieldByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (a())
    {
      Object localObject1 = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
      if ((localObject1 != null) && ((((HiBoomFontDrawer)localObject1).jdField_a_of_type_Int == 3) || (((HiBoomFontDrawer)localObject1).jdField_a_of_type_Int == 1)))
      {
        Object localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        if ((localObject2 == null) || (((ETFont)localObject2).mFontId != this.jdField_a_of_type_Int))
        {
          if (((HiBoomFontDrawer)localObject1).jdField_a_of_type_Int == 1) {
            localObject1 = ".hy";
          } else {
            localObject1 = ".hy3";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(this.jdField_a_of_type_Int, (String)localObject1, this.jdField_d_of_type_Int);
        }
        localObject1 = new EMCollection(HiBoomFont.a().a);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
          if (localObject2 != null)
          {
            boolean bool = ((EMCollection)localObject1).retrieve(this.jdField_a_of_type_JavaLangString, (IETFont)localObject2);
            int j = ((EMCollection)localObject1).getEmoticonCount();
            if ((bool) && (j > 0))
            {
              j = ((EMCollection)localObject1).getEmoticonIndex(0);
              if (this.g == j) {
                break label465;
              }
              this.g = j;
              this.jdField_a_of_type_Boolean = true;
              break label465;
            }
            this.g = 0;
            break label465;
          }
        }
        this.g = 0;
      }
      else if ((localObject1 != null) && (((HiBoomFontDrawer)localObject1).jdField_a_of_type_Int == 4))
      {
        localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        if ((localObject1 == null) || (((ETFont)localObject1).mFontId != this.jdField_a_of_type_Int))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(".fz4");
          localObject1 = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(this.jdField_a_of_type_Int, (String)localObject1, this.jdField_d_of_type_Int);
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = a();
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = this.jdField_c_of_type_Int;
        } else {
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = this.jdField_b_of_type_Long;
        }
        if (this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout == null) {
          this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout = new FounderHiBoomLayout(this);
        }
        this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      }
    }
    label465:
    requestLayout();
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = (paramBoolean ^ true);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
    {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler.obtainMessage(257, HiBoomTextView.EmoticonHolder.a(this)).sendToTarget();
      if ((paramBoolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (c())) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader != null)) {
      return HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return false;
  }
  
  public void b()
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localChatMessage != null) {
      if (TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("font_animation_played")))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.saveExtInfoToExtStr("font_animation_played", "1");
        ThreadManager.excute(new HiBoomTextView.2(this), 128, null, true);
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) {
      a(bool1);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader != null)) {
      return HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).c.get();
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) && (!this.jdField_c_of_type_Boolean))
    {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler.obtainMessage(259, HiBoomTextView.EmoticonHolder.a(this)).sendToTarget();
      if ((c()) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    FounderHiBoomLayout localFounderHiBoomLayout = this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout;
    if (localFounderHiBoomLayout != null) {
      localFounderHiBoomLayout.g();
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null;
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
        setImageResource(2130847396);
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
    ??? = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
    int j = (getMeasuredWidth() - this.e) / 2;
    int k = (getMeasuredHeight() - this.f) / 2;
    if ((j > 0) || (k > 0)) {
      paramCanvas.translate(j, k);
    }
    if (((HiBoomFontDrawer)???).jdField_a_of_type_Int == 2) {}
    try
    {
      if (!((HiBoomFontDrawer)???).a(this.jdField_a_of_type_JavaLangString.length())) {
        break label561;
      }
      j = Math.max(getMeasuredHeight(), getMeasuredWidth());
      ((HiBoomFontDrawer)???).a(this.jdField_a_of_type_JavaLangString, j, paramCanvas);
    }
    catch (Exception localException)
    {
      label380:
      Bitmap localBitmap;
      break label380;
    }
    this.jdField_d_of_type_Boolean = true;
    break label561;
    if ((((HiBoomFontDrawer)???).jdField_a_of_type_Int != 1) && (((HiBoomFontDrawer)???).jdField_a_of_type_Int != 3))
    {
      if (((HiBoomFontDrawer)???).jdField_a_of_type_Int == 4)
      {
        ??? = this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout;
        if (??? != null)
        {
          if (!((FounderHiBoomLayout)???).a(paramCanvas)) {
            this.jdField_d_of_type_Boolean = true;
          }
          if (!c()) {
            this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout.f();
          }
        }
        else
        {
          this.jdField_d_of_type_Boolean = true;
        }
      }
    }
    else if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker.a();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker)
        {
          paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
        }
      }
      setImageResource(2130847397);
      setScaleX(this.jdField_a_of_type_Float);
      setScaleY(this.jdField_a_of_type_Float);
      super.onDraw(paramCanvas);
    }
    else
    {
      this.jdField_d_of_type_Boolean = true;
    }
    label561:
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("hiboom draw failed, fontId = ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Int);
        QLog.e("HiBoomFont.TextView", 2, ((StringBuilder)???).toString());
      }
      setImageResource(2130847396);
      setScaleX(this.jdField_a_of_type_Float);
      setScaleY(this.jdField_a_of_type_Float);
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = this.jdField_d_of_type_Int;
    int k = j;
    if (n > 0)
    {
      k = j;
      if (i2 == 1073741824)
      {
        k = j;
        if (j > n) {
          k = n;
        }
      }
    }
    n = this.jdField_d_of_type_Int;
    j = m;
    if (n > 0)
    {
      j = m;
      if (i1 == 1073741824)
      {
        j = m;
        if (m > n) {
          j = n;
        }
      }
    }
    if (!a())
    {
      paramInt1 = this.jdField_d_of_type_Int;
      if (paramInt1 <= 0) {
        paramInt1 = HiBoomConstants.jdField_a_of_type_Int;
      }
      if (i2 == 1073741824) {
        paramInt2 = k;
      } else {
        paramInt2 = paramInt1;
      }
      this.e = paramInt2;
      if (i1 == 1073741824) {
        paramInt1 = j;
      }
      this.f = paramInt1;
    }
    else
    {
      Object localObject = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
      if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int == 2)
      {
        if (((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a != null)
        {
          localObject = ((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a.iterator();
          HiBoomInfo.HiBoomInfoStyle localHiBoomInfoStyle;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localHiBoomInfoStyle = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject).next();
          } while (this.jdField_a_of_type_JavaLangString.length() != localHiBoomInfoStyle.jdField_a_of_type_Int);
          paramInt1 = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[0];
          paramInt2 = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[1];
          double d1 = paramInt1;
          double d2 = paramInt2;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if ((i2 == 1073741824) && (i1 == 1073741824))
          {
            d2 = k;
            double d3 = j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 / d3 > d1)
            {
              Double.isNaN(d3);
              this.e = ((int)(d1 * d3));
              this.f = j;
            }
            else
            {
              Double.isNaN(d2);
              this.f = ((int)(d2 / d1));
              this.e = k;
            }
          }
          else if (i2 == 1073741824)
          {
            this.e = k;
            d2 = k;
            Double.isNaN(d2);
            this.f = ((int)(d2 / d1));
          }
          else if (i1 == 1073741824)
          {
            this.f = j;
            d2 = j;
            Double.isNaN(d2);
            this.e = ((int)(d2 * d1));
          }
          else
          {
            this.e = paramInt1;
            this.f = paramInt2;
          }
          m = this.jdField_d_of_type_Int;
          if (m > 0) {
            if (paramInt1 > paramInt2)
            {
              this.f = (paramInt2 * m / paramInt1);
              this.e = m;
            }
            else
            {
              this.e = (paramInt1 * m / paramInt2);
              this.f = m;
            }
          }
        }
      }
      else if ((((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 1) && (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 3))
      {
        if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int == 4)
        {
          localObject = this.jdField_a_of_type_ComVasColorFontFounderHiBoomLayout;
          if (localObject == null)
          {
            paramInt1 = this.jdField_d_of_type_Int;
            if (paramInt1 <= 0) {
              paramInt1 = HiBoomConstants.jdField_a_of_type_Int;
            }
            if (i2 == 1073741824) {
              paramInt2 = k;
            } else {
              paramInt2 = paramInt1;
            }
            this.e = paramInt2;
            if (i1 == 1073741824) {
              paramInt1 = j;
            }
            this.f = paramInt1;
          }
          else
          {
            localObject = ((FounderHiBoomLayout)localObject).a(paramInt1, paramInt2, this.jdField_d_of_type_Int);
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
      else
      {
        paramInt1 = HiBoomConstants.jdField_a_of_type_Int;
        paramInt2 = this.jdField_d_of_type_Int;
        if (paramInt2 > 0)
        {
          paramInt1 = paramInt2;
        }
        else
        {
          if ((i2 == 1073741824) && (i1 == 1073741824)) {
            paramInt1 = Math.min(k, j);
          } else if (i2 == 1073741824) {
            paramInt1 = k;
          } else if (i1 == 1073741824) {
            paramInt1 = j;
          }
          paramInt1 = Math.min(paramInt1, HiBoomConstants.jdField_a_of_type_Int);
        }
        localObject = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        if (localObject == null)
        {
          this.f = paramInt1;
          this.e = paramInt1;
          if (i2 != 1073741824) {
            k = this.e;
          }
          if (i1 != 1073741824) {
            j = this.f;
          }
          setMeasuredDimension(k, j);
          return;
        }
        ((ETFont)localObject).setSize(paramInt1);
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
          localObject = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
          if (localObject != null)
          {
            ((EMEmoticon)localObject).deleteDescriptor();
            this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
          }
          this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = EMEmoticon.createEmoticon(HiBoomFont.a().a, this.jdField_a_of_type_JavaLangString, this.g, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          localObject = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
          if (localObject != null)
          {
            this.h = ((EMEmoticon)localObject).getWidth();
            this.i = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
            if ((this.h < 1) || (this.i < 1))
            {
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.deleteDescriptor();
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
            }
          }
          HiBoomTextView.BitmapLocker.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker, this.h, this.i);
          b();
        }
        localObject = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
        if (localObject != null)
        {
          this.e = ((EMEmoticon)localObject).getWidth();
          this.f = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
        }
        else
        {
          this.f = paramInt1;
          this.e = paramInt1;
        }
      }
    }
    if (i2 != 1073741824) {
      k = this.e;
    }
    if (i1 != 1073741824) {
      j = this.f;
    }
    setMeasuredDimension(k, j);
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
  
  public void setHiBoom(int paramInt1, int paramInt2, ChatMessage paramChatMessage, BaseSessionInfo paramBaseSessionInfo, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    if (this.jdField_b_of_type_Long != paramChatMessage.uniseq)
    {
      this.jdField_b_of_type_Long = paramChatMessage.uniseq;
      this.jdField_a_of_type_Boolean = true;
    }
    setHiBoom(paramInt1, paramInt2, paramHiBoomFontDownloader);
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = paramHiBoomFontDownloader;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer = HiBoomFont.a().a(paramInt1, paramInt2, paramHiBoomFontDownloader);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.a(this);
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
      if (a()) {
        a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      long l = this.jdField_b_of_type_Long;
      paramInt1 = this.jdField_c_of_type_Int;
      if (l != paramInt1)
      {
        this.jdField_b_of_type_Long = paramInt1;
        this.jdField_a_of_type_Boolean = true;
      }
    }
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
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 20) {
      localCharSequence = paramCharSequence.subSequence(0, 20);
    }
    this.jdField_a_of_type_JavaLangString = localCharSequence.toString();
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
    long l = this.jdField_b_of_type_Long;
    int j = this.jdField_c_of_type_Int;
    if ((l != j) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null))
    {
      this.jdField_b_of_type_Long = j;
      this.jdField_a_of_type_Boolean = true;
    }
    if (a()) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView
 * JD-Core Version:    0.7.0.1
 */