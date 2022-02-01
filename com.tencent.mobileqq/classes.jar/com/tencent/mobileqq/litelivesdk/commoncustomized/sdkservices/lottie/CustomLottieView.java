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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840463);
  private LottieGiftInfo jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo;
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 1000000;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 30;
  private String jdField_c_of_type_JavaLangString = "LottieView";
  private final int d = 10;
  
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, LottieImageAsset paramLottieImageAsset)
  {
    paramContext = this.jdField_c_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" aw=");
    ((StringBuilder)localObject).append(paramLottieImageAsset.getWidth());
    ((StringBuilder)localObject).append(" ah=");
    ((StringBuilder)localObject).append(paramLottieImageAsset.getHeight());
    QLog.e(paramContext, 1, ((StringBuilder)localObject).toString());
    int i = paramLottieImageAsset.getWidth();
    int j = paramLottieImageAsset.getHeight();
    paramContext = a(paramBitmap, i, j);
    paramBitmap = new Paint();
    paramLottieImageAsset = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramLottieImageAsset);
    float f = i / 2;
    ((Canvas)localObject).drawCircle(f, f, f, paramBitmap);
    paramBitmap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject).drawBitmap(paramContext, 0.0F, 0.0F, paramBitmap);
    return paramLottieImageAsset;
  }
  
  private Bitmap a(Context paramContext, LottieImageAsset paramLottieImageAsset)
  {
    if ("img_1.png".equals(paramLottieImageAsset.getFileName()))
    {
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo.b) {
        return a(this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
      }
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo.jdField_a_of_type_JavaLangString == null) {
        paramContext = "";
      } else {
        paramContext = this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo.jdField_a_of_type_JavaLangString;
      }
      Object localObject = paramContext;
      if (paramContext.length() > 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.substring(0, 8));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      return a((String)localObject, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo.f, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
    }
    return a(paramContext, this.jdField_a_of_type_AndroidGraphicsBitmap, paramLottieImageAsset);
  }
  
  private Bitmap a(LottieGiftInfo paramLottieGiftInfo, int paramInt1, int paramInt2)
  {
    String str = paramLottieGiftInfo.jdField_a_of_type_JavaLangString;
    int i = str.length();
    Object localObject1 = "..";
    Object localObject2 = str;
    if (i > 3)
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
    str = paramLottieGiftInfo.h;
    if (!TextUtils.isEmpty(str))
    {
      i = str.lastIndexOf("_") + 1;
      paramLottieGiftInfo = str.substring(i);
      return a(str.substring(0, i).replaceFirst("_", (String)localObject2).replace("_", (CharSequence)localObject1), paramLottieGiftInfo, paramInt1, paramInt2);
    }
    return a(paramLottieGiftInfo.jdField_a_of_type_JavaLangString, paramLottieGiftInfo.f, paramInt1, paramInt2);
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
    int i = localRect.width() / 2;
    localPaint.setFakeBoldText(true);
    localCanvas.drawText(paramString1, paramInt1 - i, paramInt2, localPaint);
    localPaint.setTextSize(28.0F);
    localPaint.getTextBounds(paramString2, 0, paramString2.length(), localRect);
    i = localRect.width() / 2;
    localPaint.setFakeBoldText(false);
    int j = localFontMetricsInt.top;
    localCanvas.drawText(paramString2, paramInt1 - i, paramInt2 - j, localPaint);
    return localBitmap;
  }
  
  private void a(String paramString, LoadToPlayInter paramLoadToPlayInter)
  {
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      this.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
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
  
  public Bitmap a()
  {
    return BitmapFactory.decodeResource(getResources(), 2130840463);
  }
  
  public Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = a();
    }
    float f1 = localBitmap.getWidth();
    float f2 = localBitmap.getHeight();
    float f3 = (float)paramDouble1 / f1;
    float f4 = (float)paramDouble2 / f2;
    paramBitmap = this.jdField_c_of_type_JavaLangString;
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
    Cancellable localCancellable = this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
    if (localCancellable != null)
    {
      localCancellable.cancel();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable = null;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.i(this.jdField_c_of_type_JavaLangString, 1, "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.i(this.jdField_c_of_type_JavaLangString, 1, "onDetachedFromWindow");
  }
  
  public void onH264End()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getContext().getResources().getDisplayMetrics().widthPixels, UIUtil.getContentViewHeight(getContext()));
  }
  
  public void onPlayAtTime(long paramLong, boolean paramBoolean)
  {
    String str = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayAtTime: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" start time = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" containerShow visibile = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isAnimating() = ");
    localStringBuilder.append(isAnimating());
    localStringBuilder.append(" isPlaying = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("  lottie view shown=");
    localStringBuilder.append(isShown());
    QLog.d(str, 1, localStringBuilder.toString());
    if ((isAnimating()) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      int i;
      if ((isAnimating()) && (paramBoolean)) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      if ((!isAnimating()) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    if (!paramBoolean) {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (paramLong > this.jdField_a_of_type_Int))
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setAnimState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setComposition(LottieCompositionInterface paramLottieCompositionInterface) {}
  
  public void setConfig(String paramString1, String paramString2, LottieGiftInfo paramLottieGiftInfo, Bitmap paramBitmap, LoadToPlayInter paramLoadToPlayInter)
  {
    String str = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("title=");
    localStringBuilder.append(paramLottieGiftInfo.d);
    localStringBuilder.append(" subtitle=");
    localStringBuilder.append(paramLottieGiftInfo.f);
    QLog.i(str, 1, localStringBuilder.toString());
    str = this.jdField_c_of_type_JavaLangString;
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
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieGiftInfo = paramLottieGiftInfo;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(this.jdField_a_of_type_JavaLangString, paramLoadToPlayInter);
  }
  
  public void setImageAssetDelegate(LiveLottieApi.ImageAssetDelegate paramImageAssetDelegate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView
 * JD-Core Version:    0.7.0.1
 */