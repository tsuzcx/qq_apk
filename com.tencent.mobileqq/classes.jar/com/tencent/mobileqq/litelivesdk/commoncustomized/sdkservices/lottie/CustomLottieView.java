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
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LoadToPlayInter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LottieGiftInfo;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
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
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840592);
  private LuxuryGiftAdapter jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter;
  private LottieGiftInfo jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo;
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
  
  public CustomLottieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public CustomLottieView(Context paramContext, AttributeSet paramAttributeSet, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this(paramContext, paramAttributeSet, 0, paramLuxuryGiftAdapter);
  }
  
  public CustomLottieView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this(paramContext, null, paramLuxuryGiftAdapter);
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, LottieImageAsset paramLottieImageAsset)
  {
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().e(this.jdField_c_of_type_JavaLangString, " aw=" + paramLottieImageAsset.getWidth() + " ah=" + paramLottieImageAsset.getHeight(), new Object[0]);
    int i = paramLottieImageAsset.getWidth();
    int j = paramLottieImageAsset.getHeight();
    paramContext = a(paramBitmap, i, j);
    paramBitmap = new Paint();
    paramLottieImageAsset = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramLottieImageAsset);
    localCanvas.drawCircle(i / 2, i / 2, i / 2, paramBitmap);
    paramBitmap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramContext, 0.0F, 0.0F, paramBitmap);
    return paramLottieImageAsset;
  }
  
  private Bitmap a(Context paramContext, LottieImageAsset paramLottieImageAsset)
  {
    if ("img_1.png".equals(paramLottieImageAsset.getFileName()))
    {
      if (this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo.anchorUin != this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo.mCurAnchorUin) {
        return a(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
      }
      if (this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo.senderName == null) {}
      for (paramContext = "";; paramContext = this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo.senderName)
      {
        Object localObject = paramContext;
        if (paramContext.length() > 10) {
          localObject = paramContext.substring(0, 8) + "...";
        }
        return a((String)localObject, this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo.comment, paramLottieImageAsset.getWidth(), paramLottieImageAsset.getHeight());
      }
    }
    return a(paramContext, this.jdField_a_of_type_AndroidGraphicsBitmap, paramLottieImageAsset);
  }
  
  private Bitmap a(LottieGiftInfo paramLottieGiftInfo, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramLottieGiftInfo.senderName;
    Object localObject2 = localObject1;
    if (((String)localObject1).length() > 3) {
      localObject2 = ((String)localObject1).substring(0, 3) + "..";
    }
    String str = paramLottieGiftInfo.anchorName;
    if ((!TextUtils.isEmpty(str)) && (str.length() > 3)) {
      localObject1 = str.substring(0, 3) + "..";
    }
    for (;;)
    {
      str = paramLottieGiftInfo.linkMicComment;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      int i = str.lastIndexOf("_");
      paramLottieGiftInfo = str.substring(i + 1);
      return a(str.substring(0, i + 1).replaceFirst("_", (String)localObject2).replace("_", (CharSequence)localObject1), paramLottieGiftInfo, paramInt1, paramInt2);
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = "..";
      }
    }
    return a(paramLottieGiftInfo.senderName, paramLottieGiftInfo.comment, paramInt1, paramInt2);
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint(1);
    localPaint.setTextSize(32.0F);
    localPaint.setColor(Color.rgb(144, 75, 0));
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
    paramInt2 = (localFontMetricsInt.top + paramInt2 - localFontMetricsInt.bottom) / 2 - localFontMetricsInt.top / 2;
    Rect localRect = new Rect();
    localPaint.getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = paramInt1 / 2;
    int j = localRect.width() / 2;
    localPaint.setFakeBoldText(true);
    localCanvas.drawText(paramString1, i - j, paramInt2, localPaint);
    localPaint.setTextSize(28.0F);
    localPaint.getTextBounds(paramString2, 0, paramString2.length(), localRect);
    paramInt1 /= 2;
    i = localRect.width() / 2;
    localPaint.setFakeBoldText(false);
    j = localFontMetricsInt.top;
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while (TextUtils.isEmpty(paramString));
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    try
    {
      paramString = new FileInputStream(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
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
    return BitmapFactory.decodeResource(getResources(), 2130840592);
  }
  
  public Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    Matrix localMatrix = new Matrix();
    if (paramBitmap == null) {
      paramBitmap = a();
    }
    for (;;)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = (float)paramDouble1 / f1;
      float f4 = (float)paramDouble2 / f2;
      this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().e(this.jdField_c_of_type_JavaLangString, " sw=" + f3 + " sh=" + f4, new Object[0]);
      localMatrix.postScale(f3, f4);
      return Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, localMatrix, true);
    }
  }
  
  public void a()
  {
    if (!isAnimating()) {
      ThreadCenter.postLogicTask(new CustomLottieView.4(this));
    }
  }
  
  public void cancelLoaderTask()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable.cancel();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable = null;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().i(this.jdField_c_of_type_JavaLangString, "onAttachedToWindow", new Object[0]);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().i(this.jdField_c_of_type_JavaLangString, "onDetachedFromWindow", new Object[0]);
  }
  
  public void onH264End()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getContext().getResources().getDisplayMetrics().widthPixels, UIUtil.getContentViewHeight(getContext()));
  }
  
  public void onPlayAtTime(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().d(this.jdField_c_of_type_JavaLangString, "onPlayAtTime: " + paramLong + " start time = " + this.jdField_a_of_type_Int + " containerShow visibile = " + paramBoolean + " isAnimating() = " + isAnimating() + " isPlaying = " + this.jdField_a_of_type_Boolean + "  lottie view shown=" + isShown(), new Object[0]);
    if ((isAnimating()) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = true;
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if ((!isAnimating()) || (!paramBoolean)) {
        break label181;
      }
      i = 0;
      setVisibility(i);
      if ((!isAnimating()) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    if (!paramBoolean) {}
    label181:
    while ((this.jdField_a_of_type_Boolean) || (paramLong <= this.jdField_a_of_type_Int))
    {
      return;
      i = 8;
      break;
    }
    a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setAnimState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setConfig(String paramString1, String paramString2, LottieGiftInfo paramLottieGiftInfo, Bitmap paramBitmap, LoadToPlayInter paramLoadToPlayInter)
  {
    this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger().i(this.jdField_c_of_type_JavaLangString, "title=" + paramLottieGiftInfo.giftName + " subtitle=" + paramLottieGiftInfo.comment, new Object[0]);
    LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceLuxuryGiftAdapter.getLogger();
    String str = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("head bitmap is null ?  ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      localLogInterface.e(str, bool, new Object[0]);
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLottieGiftInfo = paramLottieGiftInfo;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      a(this.jdField_a_of_type_JavaLangString, paramLoadToPlayInter);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView
 * JD-Core Version:    0.7.0.1
 */