package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.falco.base.libapi.lottie.LiveLottieApi.ImageAssetDelegate;
import com.tencent.falco.base.libapi.lottie.LoadToPlayInter;
import com.tencent.falco.base.libapi.lottie.LottieCompositionInterface;
import com.tencent.falco.base.libapi.lottie.LottieGiftInfo;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class CustomLottieView
  extends DiniFlyAnimationView
  implements LottieViewInterface
{
  private String a;
  private String b;
  private LottieGiftInfo c;
  private Bitmap d = BitmapFactory.decodeResource(getResources(), 2130841225);
  private Context e;
  private String f = "LottieView";
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  private final int j = 1000000;
  private final int k = 30;
  private final int l = 10;
  private HashMap<String, Integer> m = new HashMap();
  private Cancellable n;
  
  public CustomLottieView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomLottieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomLottieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramContext;
    b();
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, LottieImageAsset paramLottieImageAsset)
  {
    paramContext = this.f;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" aw=");
    ((StringBuilder)localObject).append(paramLottieImageAsset.getWidth());
    ((StringBuilder)localObject).append(" ah=");
    ((StringBuilder)localObject).append(paramLottieImageAsset.getHeight());
    QLog.e(paramContext, 1, ((StringBuilder)localObject).toString());
    int i1 = paramLottieImageAsset.getWidth();
    int i2 = paramLottieImageAsset.getHeight();
    paramContext = a(paramBitmap, i1, i2);
    paramBitmap = new Paint();
    paramLottieImageAsset = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramLottieImageAsset);
    float f1 = i1 / 2;
    ((Canvas)localObject).drawCircle(f1, f1, f1, paramBitmap);
    paramBitmap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject).drawBitmap(paramContext, 0.0F, 0.0F, paramBitmap);
    return paramLottieImageAsset;
  }
  
  private Bitmap a(Context paramContext, LottieImageAsset paramLottieImageAsset)
  {
    if ("img_1.png".equals(paramLottieImageAsset.getFileName()))
    {
      if (this.c.h != this.c.j) {
        return a(this.c, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
      }
      if (this.c.a == null) {
        paramContext = "";
      } else {
        paramContext = this.c.a;
      }
      Object localObject = paramContext;
      if (paramContext.length() > 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.substring(0, 8));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      return a((String)localObject, this.c.f, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
    }
    return a(paramContext, this.d, paramLottieImageAsset);
  }
  
  private Bitmap a(LottieGiftInfo paramLottieGiftInfo, int paramInt1, int paramInt2)
  {
    String str = paramLottieGiftInfo.a;
    int i1 = str.length();
    Object localObject1 = "..";
    Object localObject2 = str;
    if (i1 > 3)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str.substring(0, 3));
      ((StringBuilder)localObject2).append("..");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    str = paramLottieGiftInfo.g;
    if ((!TextUtils.isEmpty(str)) && (str.length() > 3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str.substring(0, 3));
      ((StringBuilder)localObject1).append("..");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (!TextUtils.isEmpty(str))
    {
      localObject1 = str;
    }
    str = paramLottieGiftInfo.i;
    if (!TextUtils.isEmpty(str))
    {
      i1 = str.lastIndexOf("_") + 1;
      paramLottieGiftInfo = str.substring(i1);
      return a(str.substring(0, i1).replaceFirst("_", (String)localObject2).replace("_", (CharSequence)localObject1), paramLottieGiftInfo, paramInt1, paramInt2);
    }
    return a(paramLottieGiftInfo.a, paramLottieGiftInfo.f, paramInt1, paramInt2);
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint(1);
    localPaint.setTextSize(32.0F);
    localPaint.setColor(Color.rgb(144, 75, 0));
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
    paramInt2 = (paramInt2 + localFontMetricsInt.top - localFontMetricsInt.bottom) / 2 - localFontMetricsInt.top / 2;
    Rect localRect = new Rect();
    localPaint.getTextBounds(paramString1, 0, paramString1.length(), localRect);
    paramInt1 /= 2;
    int i1 = localRect.width() / 2;
    localPaint.setFakeBoldText(true);
    localCanvas.drawText(paramString1, paramInt1 - i1, paramInt2, localPaint);
    localPaint.setTextSize(28.0F);
    localPaint.getTextBounds(paramString2, 0, paramString2.length(), localRect);
    i1 = localRect.width() / 2;
    localPaint.setFakeBoldText(false);
    int i2 = localFontMetricsInt.top;
    localCanvas.drawText(paramString2, paramInt1 - i1, paramInt2 - i2, localPaint);
    return localBitmap;
  }
  
  private void a(String paramString, LoadToPlayInter paramLoadToPlayInter)
  {
    this.g = 0;
    if (this.m.containsKey(paramString))
    {
      this.g = ((Integer)this.m.get(paramString)).intValue();
      if (paramLoadToPlayInter != null) {
        paramLoadToPlayInter.onPrepareStart();
      }
      return;
    }
    ThreadCenter.postLogicTask(new CustomLottieView.3(this, paramString, paramLoadToPlayInter));
  }
  
  private static InputStream b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        try
        {
          paramString = new FileInputStream(paramString);
          return paramString;
        }
        catch (FileNotFoundException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private void b()
  {
    setImageAssetDelegate(new CustomLottieView.1(this));
    addAnimatorListener(new CustomLottieView.2(this));
  }
  
  public Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = getDefaultIcon();
    }
    float f1 = localBitmap.getWidth();
    float f2 = localBitmap.getHeight();
    float f3 = (float)paramDouble1 / f1;
    float f4 = (float)paramDouble2 / f2;
    paramBitmap = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" sw=");
    localStringBuilder.append(f3);
    localStringBuilder.append(" sh=");
    localStringBuilder.append(f4);
    QLog.i(paramBitmap, 1, localStringBuilder.toString());
    localMatrix.postScale(f3, f4);
    return Bitmap.createBitmap(localBitmap, 0, 0, (int)f1, (int)f2, localMatrix, true);
  }
  
  public void a()
  {
    if (!isAnimating()) {
      ThreadCenter.postLogicTask(new CustomLottieView.4(this));
    }
  }
  
  public void cancelLoaderTask()
  {
    Cancellable localCancellable = this.n;
    if (localCancellable != null)
    {
      localCancellable.cancel();
      this.n = null;
    }
  }
  
  public Bitmap getDefaultIcon()
  {
    return BitmapFactory.decodeResource(getResources(), 2130841225);
  }
  
  public View getView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.i(this.f, 1, "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.i(this.f, 1, "onDetachedFromWindow");
  }
  
  public void onH264End()
  {
    this.i = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getContext().getResources().getDisplayMetrics().widthPixels, UIUtil.getContentViewHeight(getContext()));
  }
  
  public void onPlayAtTime(long paramLong, boolean paramBoolean)
  {
    String str = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayAtTime: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" start time = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" containerShow visibile = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isAnimating() = ");
    localStringBuilder.append(isAnimating());
    localStringBuilder.append(" isPlaying = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("  lottie view shown=");
    localStringBuilder.append(isShown());
    QLog.d(str, 1, localStringBuilder.toString());
    if ((isAnimating()) && (!this.i)) {
      this.i = true;
    }
    if ((this.h) && (this.i))
    {
      int i1;
      if ((isAnimating()) && (paramBoolean)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      setVisibility(i1);
      if ((!isAnimating()) && (this.i)) {
        this.i = false;
      }
    }
    if (!paramBoolean) {
      return;
    }
    if ((!this.h) && (paramLong > this.g))
    {
      a();
      this.h = true;
    }
  }
  
  public void setAnimState(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setComposition(LottieCompositionInterface paramLottieCompositionInterface) {}
  
  public void setConfig(String paramString1, String paramString2, LottieGiftInfo paramLottieGiftInfo, Bitmap paramBitmap, LoadToPlayInter paramLoadToPlayInter)
  {
    String str = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("title=");
    localStringBuilder.append(paramLottieGiftInfo.d);
    localStringBuilder.append(" subtitle=");
    localStringBuilder.append(paramLottieGiftInfo.f);
    QLog.i(str, 1, localStringBuilder.toString());
    str = this.f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("head bitmap is null ?  ");
    boolean bool;
    if (paramBitmap == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.i(str, 1, localStringBuilder.toString());
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLottieGiftInfo;
    this.d = paramBitmap;
    a(this.a, paramLoadToPlayInter);
  }
  
  public void setImageAssetDelegate(LiveLottieApi.ImageAssetDelegate paramImageAssetDelegate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView
 * JD-Core Version:    0.7.0.1
 */