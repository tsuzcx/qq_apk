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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
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
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    if (localObject != null)
    {
      Canvas localCanvas = new Canvas(localObject);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(localRect);
      localPaint.setAntiAlias(true);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    }
    return localObject;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Canvas localCanvas = null;
    Object localObject = localCanvas;
    try
    {
      Drawable localDrawable = paramDrawable.getConstantState().newDrawable();
      localObject = localCanvas;
      int i = localDrawable.getIntrinsicWidth();
      localObject = localCanvas;
      int j = localDrawable.getIntrinsicHeight();
      localObject = localCanvas;
      if (localDrawable.getOpacity() != -1)
      {
        localObject = localCanvas;
        paramDrawable = Bitmap.Config.ARGB_8888;
      }
      else
      {
        localObject = localCanvas;
        paramDrawable = Bitmap.Config.RGB_565;
      }
      localObject = localCanvas;
      paramDrawable = Bitmap.createBitmap(i, j, paramDrawable);
      localObject = paramDrawable;
      localCanvas = new Canvas(paramDrawable);
      localObject = paramDrawable;
      localDrawable.setBounds(0, 0, i, j);
      localObject = paramDrawable;
      localDrawable.draw(localCanvas);
      return paramDrawable;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label106:
      break label106;
    }
    if (QLog.isColorLevel()) {
      QLog.e("HotChatPostItemViewQ.hotchat.aio_post_list_req", 2, "drawableToBitamp, OutOfMemoryError");
    }
    jdField_a_of_type_JavaUtilQueue.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    return localObject;
  }
  
  private static Bitmap a(String paramString)
  {
    try
    {
      if ((jdField_a_of_type_JavaUtilQueue.contains(paramString)) && (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        paramString = (Bitmap)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Drawable a(Drawable paramDrawable, float paramFloat)
  {
    if (paramDrawable == null) {
      return null;
    }
    if (paramFloat <= 0.0F) {
      return paramDrawable;
    }
    try
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      paramDrawable = new BitmapDrawable(a((Bitmap)localObject, paramFloat));
      return paramDrawable;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label101:
      break label101;
    }
    if (QLog.isColorLevel()) {
      QLog.e("HotChatPostItemViewQ.hotchat.aio_post_list_req", 2, "round, OutOfMemoryError");
    }
    return null;
  }
  
  private String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    Date localDate = new Date(paramLong);
    ((Calendar)localObject).setTime(localDate);
    Calendar.getInstance().setTimeInMillis(this.jdField_a_of_type_Long);
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (paramLong <= 59L) {
      return HardCodeUtil.a(2131705669);
    }
    if (paramLong <= 60L) {
      return "1分钟前";
    }
    if (paramLong < 3600L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)Math.floor(paramLong / 60L));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705661));
      return ((StringBuilder)localObject).toString();
    }
    if (paramLong < 86400L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)Math.floor(paramLong / 3600L));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705657));
      return ((StringBuilder)localObject).toString();
    }
    if ((paramLong >= 86400L) && (paramLong < 172800L)) {
      return HardCodeUtil.a(2131705678);
    }
    if (paramLong < 2592000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)Math.ceil(paramLong / 86400L));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705668));
      return ((StringBuilder)localObject).toString();
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
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Dalvik/1.6.0 (Linux; U; Android ");
      ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
      ((StringBuilder)localObject1).append("; ");
      ((StringBuilder)localObject1).append(Build.MODEL);
      ((StringBuilder)localObject1).append(")");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      new URL(paramString);
      if (paramInt5 > 0) {
        localObject1 = URLDrawable.getDrawable(paramString, paramInt5, paramInt5 * 2 / 3);
      } else {
        localObject1 = URLDrawable.getDrawable(paramString);
      }
      ((URLDrawable)localObject1).addHeader("User-Agent", (String)localObject2);
      if (((URLDrawable)localObject1).isDownloadStarted())
      {
        localObject2 = a(paramString);
        if (localObject2 != null)
        {
          paramImageView.setImageBitmap((Bitmap)localObject2);
          return;
        }
        paramImageView.setImageDrawable(a((Drawable)localObject1, paramFloat));
      }
      else
      {
        localObject2 = a(paramString);
        if (localObject2 != null)
        {
          paramImageView.setImageBitmap((Bitmap)localObject2);
          return;
        }
        paramImageView.setImageDrawable((Drawable)localObject1);
      }
      ((URLDrawable)localObject1).setURLDrawableListener(new HotChatPostItemView.1(paramImageView, paramInt6, paramInt4, paramInt5, paramString, (URLDrawable)localObject1, paramFloat, paramInt3));
      return;
    }
    catch (MalformedURLException paramString)
    {
      break label219;
    }
    catch (OutOfMemoryError paramImageView)
    {
      label204:
      break label204;
    }
    jdField_a_of_type_JavaUtilQueue.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    return;
    label219:
    paramImageView.setImageDrawable(null);
    paramImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public static void setImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    setImage(paramImageView, paramString, paramInt1, paramInt2, 0.0F, paramInt3, 0, 0, 0);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559930, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371876));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378784));
    this.d = ((TextView)localView.findViewById(2131365169));
    this.e = ((TextView)localView.findViewById(2131364978));
    this.f = ((TextView)localView.findViewById(2131376005));
    this.c = ((TextView)localView.findViewById(2131378722));
    this.g = ((TextView)localView.findViewById(2131381333));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368064));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131365295));
    this.jdField_a_of_type_AndroidViewView = localView;
    setBackgroundResource(2130842419);
    return this;
  }
  
  /* Error */
  public void setData(String paramString)
  {
    // Byte code:
    //   0: new 443	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 444	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: ldc_w 446
    //   15: invokevirtual 450	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   18: ifeq +513 -> 531
    //   21: aload 5
    //   23: ldc_w 446
    //   26: invokevirtual 454	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   29: astore_1
    //   30: aload_0
    //   31: aload_1
    //   32: ldc_w 456
    //   35: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   38: ldc2_w 463
    //   41: ldiv
    //   42: invokevirtual 468	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   45: putfield 212	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Long	J
    //   48: aload_1
    //   49: ldc_w 470
    //   52: invokevirtual 473	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   55: istore_3
    //   56: aload_1
    //   57: ldc_w 475
    //   60: invokevirtual 473	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload_0
    //   65: iload_2
    //   66: putfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   69: goto +3 -> 72
    //   72: aload 5
    //   74: ldc_w 477
    //   77: invokevirtual 454	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   80: astore 6
    //   82: aload 5
    //   84: ldc_w 479
    //   87: invokevirtual 454	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   90: astore 9
    //   92: aload 6
    //   94: ldc_w 481
    //   97: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 7
    //   102: aload 6
    //   104: ldc_w 487
    //   107: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_1
    //   111: aload 9
    //   113: ldc_w 489
    //   116: invokevirtual 493	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   119: astore 4
    //   121: aload 5
    //   123: ldc_w 495
    //   126: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 8
    //   131: aload 9
    //   133: ldc_w 497
    //   136: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 9
    //   141: aload 5
    //   143: ldc_w 499
    //   146: invokevirtual 502	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 10
    //   151: aload 5
    //   153: ldc_w 504
    //   156: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 11
    //   161: aload 5
    //   163: ldc_w 506
    //   166: invokevirtual 502	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 12
    //   171: aload 5
    //   173: ldc_w 508
    //   176: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 5
    //   181: aload_0
    //   182: getfield 404	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   185: aload 7
    //   187: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   190: aload_0
    //   191: getfield 404	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   194: aload 6
    //   196: ldc_w 514
    //   199: invokevirtual 518	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   202: invokevirtual 522	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   205: aload_0
    //   206: getfield 407	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   209: aload 8
    //   211: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   214: aload_0
    //   215: getfield 410	com/tencent/mobileqq/troop/widget/HotChatPostItemView:d	Landroid/widget/TextView;
    //   218: aload 9
    //   220: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   223: ldc_w 524
    //   226: aload 11
    //   228: invokevirtual 529	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +12 -> 243
    //   234: aload_0
    //   235: getfield 413	com/tencent/mobileqq/troop/widget/HotChatPostItemView:e	Landroid/widget/TextView;
    //   238: aload 11
    //   240: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   243: ldc_w 524
    //   246: aload 12
    //   248: invokevirtual 529	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +12 -> 263
    //   254: aload_0
    //   255: getfield 416	com/tencent/mobileqq/troop/widget/HotChatPostItemView:f	Landroid/widget/TextView;
    //   258: aload 12
    //   260: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   263: ldc_w 524
    //   266: aload 5
    //   268: invokevirtual 529	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +12 -> 283
    //   274: aload_0
    //   275: getfield 422	com/tencent/mobileqq/troop/widget/HotChatPostItemView:g	Landroid/widget/TextView;
    //   278: aload 5
    //   280: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   283: aload_0
    //   284: getfield 419	com/tencent/mobileqq/troop/widget/HotChatPostItemView:c	Landroid/widget/TextView;
    //   287: aload_0
    //   288: aload 10
    //   290: invokestatic 535	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   293: invokespecial 537	com/tencent/mobileqq/troop/widget/HotChatPostItemView:a	(J)Ljava/lang/String;
    //   296: invokevirtual 512	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   299: aload_0
    //   300: getfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   303: ifne +28 -> 331
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 44	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   311: ldc_w 539
    //   314: invokevirtual 544	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   317: checkcast 546	android/view/WindowManager
    //   320: invokeinterface 550 1 0
    //   325: invokevirtual 553	android/view/Display:getWidth	()I
    //   328: putfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   331: aload_0
    //   332: getfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   335: ifle +46 -> 381
    //   338: aload_0
    //   339: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   342: invokevirtual 557	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   345: checkcast 559	android/widget/LinearLayout$LayoutParams
    //   348: astore 5
    //   350: aload 5
    //   352: aload_0
    //   353: getfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   356: putfield 562	android/widget/LinearLayout$LayoutParams:width	I
    //   359: aload 5
    //   361: aload_0
    //   362: getfield 42	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_Int	I
    //   365: iconst_2
    //   366: imul
    //   367: iconst_3
    //   368: idiv
    //   369: putfield 565	android/widget/LinearLayout$LayoutParams:height	I
    //   372: aload_0
    //   373: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   376: aload 5
    //   378: invokevirtual 569	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   381: aload 4
    //   383: ifnull +91 -> 474
    //   386: aload 4
    //   388: invokevirtual 574	org/json/JSONArray:length	()I
    //   391: ifle +83 -> 474
    //   394: aload 4
    //   396: iconst_0
    //   397: invokevirtual 578	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   400: astore 4
    //   402: aload 4
    //   404: ldc_w 580
    //   407: invokevirtual 485	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore 5
    //   412: aload 4
    //   414: ldc_w 582
    //   417: invokevirtual 473	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   420: sipush 200
    //   423: if_icmple +39 -> 462
    //   426: aload_0
    //   427: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   430: aload 5
    //   432: invokevirtual 583	com/tencent/image/URLImageView:setTag	(Ljava/lang/Object;)V
    //   435: aload_0
    //   436: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   439: aload 5
    //   441: iconst_0
    //   442: iconst_0
    //   443: fconst_0
    //   444: iconst_0
    //   445: iload_3
    //   446: iload_2
    //   447: iconst_1
    //   448: invokestatic 378	com/tencent/mobileqq/troop/widget/HotChatPostItemView:setImage	(Landroid/widget/ImageView;Ljava/lang/String;IIFIIII)V
    //   451: aload_0
    //   452: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   455: iconst_0
    //   456: invokevirtual 586	com/tencent/image/URLImageView:setVisibility	(I)V
    //   459: goto +24 -> 483
    //   462: aload_0
    //   463: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   466: bipush 8
    //   468: invokevirtual 586	com/tencent/image/URLImageView:setVisibility	(I)V
    //   471: goto +12 -> 483
    //   474: aload_0
    //   475: getfield 430	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   478: bipush 8
    //   480: invokevirtual 586	com/tencent/image/URLImageView:setVisibility	(I)V
    //   483: aload_0
    //   484: getfield 427	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   487: aload_1
    //   488: aload_0
    //   489: getfield 427	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   492: invokevirtual 587	com/tencent/image/URLImageView:getWidth	()I
    //   495: aload_0
    //   496: getfield 427	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   499: invokevirtual 587	com/tencent/image/URLImageView:getWidth	()I
    //   502: aload_0
    //   503: getfield 427	com/tencent/mobileqq/troop/widget/HotChatPostItemView:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   506: invokevirtual 587	com/tencent/image/URLImageView:getWidth	()I
    //   509: iconst_2
    //   510: idiv
    //   511: i2f
    //   512: iconst_0
    //   513: iconst_0
    //   514: iconst_0
    //   515: iconst_0
    //   516: invokestatic 378	com/tencent/mobileqq/troop/widget/HotChatPostItemView:setImage	(Landroid/widget/ImageView;Ljava/lang/String;IIFIIII)V
    //   519: return
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 588	org/json/JSONException:printStackTrace	()V
    //   525: return
    //   526: astore 5
    //   528: goto -229 -> 299
    //   531: iconst_0
    //   532: istore_3
    //   533: sipush 360
    //   536: istore_2
    //   537: goto -465 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	HotChatPostItemView
    //   0	540	1	paramString	String
    //   63	474	2	i	int
    //   55	478	3	j	int
    //   119	294	4	localObject1	Object
    //   8	432	5	localObject2	Object
    //   526	1	5	localNumberFormatException	java.lang.NumberFormatException
    //   80	115	6	localJSONObject	org.json.JSONObject
    //   100	86	7	str1	String
    //   129	81	8	str2	String
    //   90	129	9	localObject3	Object
    //   149	140	10	str3	String
    //   159	80	11	str4	String
    //   169	90	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   0	69	520	org/json/JSONException
    //   72	243	520	org/json/JSONException
    //   243	263	520	org/json/JSONException
    //   263	283	520	org/json/JSONException
    //   283	299	520	org/json/JSONException
    //   299	331	520	org/json/JSONException
    //   331	381	520	org/json/JSONException
    //   386	459	520	org/json/JSONException
    //   462	471	520	org/json/JSONException
    //   474	483	520	org/json/JSONException
    //   483	519	520	org/json/JSONException
    //   283	299	526	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView
 * JD-Core Version:    0.7.0.1
 */