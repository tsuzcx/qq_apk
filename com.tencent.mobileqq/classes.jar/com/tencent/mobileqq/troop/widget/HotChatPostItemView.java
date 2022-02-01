package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anni;
import bfvu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HotChatPostItemView
  extends LinearLayout
{
  public static HashMap<String, Bitmap> a;
  public static Queue<String> a;
  private static int jdField_b_of_type_Int = 10;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilQueue = new LinkedList();
  }
  
  public HotChatPostItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public HotChatPostItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public HotChatPostItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {}
    do
    {
      return localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          localOutOfMemoryError.printStackTrace();
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    localObject2 = new Canvas(localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localObject1;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Canvas localCanvas = null;
    localObject = localCanvas;
    try
    {
      Drawable localDrawable = paramDrawable.getConstantState().newDrawable();
      localObject = localCanvas;
      int i = localDrawable.getIntrinsicWidth();
      localObject = localCanvas;
      int j = localDrawable.getIntrinsicHeight();
      localObject = localCanvas;
      if (localDrawable.getOpacity() != -1) {
        localObject = localCanvas;
      }
      for (paramDrawable = Bitmap.Config.ARGB_8888;; paramDrawable = Bitmap.Config.RGB_565)
      {
        localObject = localCanvas;
        paramDrawable = Bitmap.createBitmap(i, j, paramDrawable);
        localObject = paramDrawable;
        localCanvas = new Canvas(paramDrawable);
        localObject = paramDrawable;
        localDrawable.setBounds(0, 0, i, j);
        localObject = paramDrawable;
        localDrawable.draw(localCanvas);
        return paramDrawable;
        localObject = localCanvas;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotChatPostItemViewQ.hotchat.aio_post_list_req", 2, "drawableToBitamp, OutOfMemoryError");
      }
      jdField_a_of_type_JavaUtilQueue.clear();
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  /* Error */
  private static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   6: aload_0
    //   7: invokeinterface 180 2 0
    //   12: ifeq +29 -> 41
    //   15: getstatic 32	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: aload_0
    //   19: invokevirtual 183	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   22: ifeq +19 -> 41
    //   25: getstatic 32	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   28: aload_0
    //   29: invokevirtual 187	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 59	android/graphics/Bitmap
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: aconst_null
    //   42: astore_0
    //   43: goto -7 -> 36
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	36	46	finally
  }
  
  public static Drawable a(Drawable paramDrawable, float paramFloat)
  {
    Object localObject;
    if (paramDrawable == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramDrawable;
    } while (paramFloat <= 0.0F);
    for (;;)
    {
      try
      {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        if (paramDrawable.getOpacity() != -1)
        {
          localObject = Bitmap.Config.ARGB_8888;
          localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
          paramDrawable.draw(localCanvas);
          paramDrawable = new BitmapDrawable(a((Bitmap)localObject, paramFloat));
          return paramDrawable;
        }
      }
      catch (OutOfMemoryError paramDrawable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatPostItemViewQ.hotchat.aio_post_list_req", 2, "round, OutOfMemoryError");
        }
        return null;
      }
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  private String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(paramLong);
    localCalendar.setTime(localDate);
    Calendar.getInstance().setTimeInMillis(this.jdField_a_of_type_Long);
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (paramLong <= 59L) {
      return anni.a(2131704372);
    }
    if (paramLong <= 60L) {
      return "1分钟前";
    }
    if (paramLong < 3600L) {
      return (int)Math.floor(paramLong / 60L) + anni.a(2131704364);
    }
    if (paramLong < 86400L) {
      return (int)Math.floor(paramLong / 3600L) + anni.a(2131704360);
    }
    if ((paramLong >= 86400L) && (paramLong < 172800L)) {
      return anni.a(2131704381);
    }
    if (paramLong < 2592000L) {
      return (int)Math.ceil(paramLong / 86400L) + anni.a(2131704371);
    }
    if ((paramLong >= 2592000L) && (paramLong < 31104000L)) {
      return new SimpleDateFormat("MM-dd").format(localDate);
    }
    return new SimpleDateFormat("yy-MM-dd").format(localDate);
  }
  
  private static void b(String paramString, Bitmap paramBitmap)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap.size() > jdField_b_of_type_Int) {
        jdField_a_of_type_JavaUtilHashMap.remove(jdField_a_of_type_JavaUtilQueue.poll());
      }
      jdField_a_of_type_JavaUtilQueue.offer(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      return;
    }
    finally {}
  }
  
  public static void setImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject;
    URLDrawable localURLDrawable;
    try
    {
      localObject = "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")";
      new URL(paramString);
      if (paramInt5 <= 0) {
        break label128;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, paramInt5, paramInt5 * 2 / 3);
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramImageView.setImageDrawable(null);
        paramImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
        return;
        localURLDrawable = URLDrawable.getDrawable(paramString);
      }
      paramImageView.setImageDrawable(a(localURLDrawable, paramFloat));
      localURLDrawable.setURLDrawableListener(new bfvu(paramImageView, paramInt6, paramInt4, paramInt5, paramString, localURLDrawable, paramFloat, paramInt3));
      return;
    }
    catch (OutOfMemoryError paramImageView)
    {
      label128:
      jdField_a_of_type_JavaUtilQueue.clear();
      jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    localURLDrawable.addHeader("User-Agent", (String)localObject);
    if (localURLDrawable.isDownloadStarted())
    {
      localObject = a(paramString);
      if (localObject != null)
      {
        paramImageView.setImageBitmap((Bitmap)localObject);
        return;
      }
    }
    for (;;)
    {
      localObject = a(paramString);
      if (localObject != null)
      {
        paramImageView.setImageBitmap((Bitmap)localObject);
        return;
      }
      paramImageView.setImageDrawable(localURLDrawable);
    }
  }
  
  public static void setImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    setImage(paramImageView, paramString, paramInt1, paramInt2, 0.0F, paramInt3, 0, 0, 0);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559930, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371719));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378776));
    this.d = ((TextView)localView.findViewById(2131364999));
    this.e = ((TextView)localView.findViewById(2131364797));
    this.f = ((TextView)localView.findViewById(2131375967));
    this.c = ((TextView)localView.findViewById(2131378714));
    this.g = ((TextView)localView.findViewById(2131381395));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367855));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131365127));
    this.jdField_a_of_type_AndroidViewView = localView;
    setBackgroundResource(2130842293);
    return this;
  }
  
  /* Error */
  public void setData(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: sipush 360
    //   5: istore_3
    //   6: new 442	org/json/JSONObject
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 443	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: aload 5
    //   18: ldc_w 445
    //   21: invokevirtual 449	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   24: ifeq +51 -> 75
    //   27: aload 5
    //   29: ldc_w 445
    //   32: invokevirtual 453	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: ldc_w 455
    //   41: invokestatic 461	java/lang/System:currentTimeMillis	()J
    //   44: ldc2_w 462
    //   47: ldiv
    //   48: invokevirtual 467	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   51: putfield 213	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Long	J
    //   54: aload_1
    //   55: ldc_w 469
    //   58: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: aload_1
    //   63: ldc_w 474
    //   66: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   69: istore_3
    //   70: aload_0
    //   71: iload_3
    //   72: putfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   75: aload 5
    //   77: ldc_w 476
    //   80: invokevirtual 453	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   83: astore 6
    //   85: aload 5
    //   87: ldc_w 478
    //   90: invokevirtual 453	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   93: astore 9
    //   95: aload 6
    //   97: ldc_w 480
    //   100: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 7
    //   105: aload 6
    //   107: ldc_w 486
    //   110: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_1
    //   114: aload 9
    //   116: ldc_w 488
    //   119: invokevirtual 492	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   122: astore 4
    //   124: aload 5
    //   126: ldc_w 494
    //   129: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 8
    //   134: aload 9
    //   136: ldc_w 496
    //   139: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 9
    //   144: aload 5
    //   146: ldc_w 498
    //   149: invokevirtual 501	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 10
    //   154: aload 5
    //   156: ldc_w 503
    //   159: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 11
    //   164: aload 5
    //   166: ldc_w 505
    //   169: invokevirtual 501	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 12
    //   174: aload 5
    //   176: ldc_w 507
    //   179: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 5
    //   184: aload_0
    //   185: getfield 403	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   188: aload 7
    //   190: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   193: aload_0
    //   194: getfield 403	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   197: aload 6
    //   199: ldc_w 513
    //   202: invokevirtual 517	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   205: invokevirtual 521	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   208: aload_0
    //   209: getfield 406	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   212: aload 8
    //   214: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   217: aload_0
    //   218: getfield 409	com/tencent/mobileqq/troop/widget/HotChatPostItemView:d	Landroid/widget/TextView;
    //   221: aload 9
    //   223: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   226: ldc_w 523
    //   229: aload 11
    //   231: invokevirtual 528	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifne +12 -> 246
    //   237: aload_0
    //   238: getfield 412	com/tencent/mobileqq/troop/widget/HotChatPostItemView:e	Landroid/widget/TextView;
    //   241: aload 11
    //   243: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   246: ldc_w 523
    //   249: aload 12
    //   251: invokevirtual 528	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifne +12 -> 266
    //   257: aload_0
    //   258: getfield 415	com/tencent/mobileqq/troop/widget/HotChatPostItemView:f	Landroid/widget/TextView;
    //   261: aload 12
    //   263: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   266: ldc_w 523
    //   269: aload 5
    //   271: invokevirtual 528	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifne +12 -> 286
    //   277: aload_0
    //   278: getfield 421	com/tencent/mobileqq/troop/widget/HotChatPostItemView:g	Landroid/widget/TextView;
    //   281: aload 5
    //   283: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   286: aload_0
    //   287: getfield 418	com/tencent/mobileqq/troop/widget/HotChatPostItemView:c	Landroid/widget/TextView;
    //   290: aload_0
    //   291: aload 10
    //   293: invokestatic 534	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   296: invokespecial 536	com/tencent/mobileqq/troop/widget/HotChatPostItemView:a	(J)Ljava/lang/String;
    //   299: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   302: aload_0
    //   303: getfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   306: ifne +28 -> 334
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 45	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   314: ldc_w 538
    //   317: invokevirtual 543	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   320: checkcast 545	android/view/WindowManager
    //   323: invokeinterface 549 1 0
    //   328: invokevirtual 552	android/view/Display:getWidth	()I
    //   331: putfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   334: aload_0
    //   335: getfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   338: ifle +46 -> 384
    //   341: aload_0
    //   342: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   345: invokevirtual 556	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   348: checkcast 558	android/widget/LinearLayout$LayoutParams
    //   351: astore 5
    //   353: aload 5
    //   355: aload_0
    //   356: getfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   359: putfield 561	android/widget/LinearLayout$LayoutParams:width	I
    //   362: aload 5
    //   364: aload_0
    //   365: getfield 43	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   368: iconst_2
    //   369: imul
    //   370: iconst_3
    //   371: idiv
    //   372: putfield 564	android/widget/LinearLayout$LayoutParams:height	I
    //   375: aload_0
    //   376: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   379: aload 5
    //   381: invokevirtual 568	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   384: aload 4
    //   386: ifnull +131 -> 517
    //   389: aload 4
    //   391: invokevirtual 573	org/json/JSONArray:length	()I
    //   394: ifle +123 -> 517
    //   397: aload 4
    //   399: iconst_0
    //   400: invokevirtual 577	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   403: astore 4
    //   405: aload 4
    //   407: ldc_w 579
    //   410: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: astore 5
    //   415: aload 4
    //   417: ldc_w 581
    //   420: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: sipush 200
    //   426: if_icmple +73 -> 499
    //   429: aload_0
    //   430: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   433: aload 5
    //   435: invokevirtual 582	com/tencent/image/URLImageView:setTag	(Ljava/lang/Object;)V
    //   438: aload_0
    //   439: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   442: aload 5
    //   444: iconst_0
    //   445: iconst_0
    //   446: fconst_0
    //   447: iconst_0
    //   448: iload_2
    //   449: iload_3
    //   450: iconst_1
    //   451: invokestatic 377	com/tencent/mobileqq/troop/widget/HotChatPostItemView:setImage	(Landroid/widget/ImageView;Ljava/lang/String;IIFIIII)V
    //   454: aload_0
    //   455: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   458: iconst_0
    //   459: invokevirtual 585	com/tencent/image/URLImageView:setVisibility	(I)V
    //   462: aload_0
    //   463: getfield 426	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   466: aload_1
    //   467: aload_0
    //   468: getfield 426	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   471: invokevirtual 586	com/tencent/image/URLImageView:getWidth	()I
    //   474: aload_0
    //   475: getfield 426	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   478: invokevirtual 586	com/tencent/image/URLImageView:getWidth	()I
    //   481: aload_0
    //   482: getfield 426	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   485: invokevirtual 586	com/tencent/image/URLImageView:getWidth	()I
    //   488: iconst_2
    //   489: idiv
    //   490: i2f
    //   491: iconst_0
    //   492: iconst_0
    //   493: iconst_0
    //   494: iconst_0
    //   495: invokestatic 377	com/tencent/mobileqq/troop/widget/HotChatPostItemView:setImage	(Landroid/widget/ImageView;Ljava/lang/String;IIFIIII)V
    //   498: return
    //   499: aload_0
    //   500: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   503: bipush 8
    //   505: invokevirtual 585	com/tencent/image/URLImageView:setVisibility	(I)V
    //   508: goto -46 -> 462
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 587	org/json/JSONException:printStackTrace	()V
    //   516: return
    //   517: aload_0
    //   518: getfield 429	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   521: bipush 8
    //   523: invokevirtual 585	com/tencent/image/URLImageView:setVisibility	(I)V
    //   526: goto -64 -> 462
    //   529: astore 5
    //   531: goto -229 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	HotChatPostItemView
    //   0	534	1	paramString	String
    //   1	448	2	i	int
    //   5	445	3	j	int
    //   122	294	4	localObject1	Object
    //   14	429	5	localObject2	Object
    //   529	1	5	localNumberFormatException	java.lang.NumberFormatException
    //   83	115	6	localJSONObject	org.json.JSONObject
    //   103	86	7	str1	String
    //   132	81	8	str2	String
    //   93	129	9	localObject3	Object
    //   152	140	10	str3	String
    //   162	80	11	str4	String
    //   172	90	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   6	16	511	org/json/JSONException
    //   16	75	511	org/json/JSONException
    //   75	246	511	org/json/JSONException
    //   246	266	511	org/json/JSONException
    //   266	286	511	org/json/JSONException
    //   286	302	511	org/json/JSONException
    //   302	334	511	org/json/JSONException
    //   334	384	511	org/json/JSONException
    //   389	462	511	org/json/JSONException
    //   462	498	511	org/json/JSONException
    //   499	508	511	org/json/JSONException
    //   517	526	511	org/json/JSONException
    //   286	302	529	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView
 * JD-Core Version:    0.7.0.1
 */