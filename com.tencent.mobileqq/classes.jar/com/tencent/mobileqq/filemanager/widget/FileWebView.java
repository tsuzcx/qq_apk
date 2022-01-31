package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Calendar;
import java.util.Timer;

public class FileWebView
  extends WebView
{
  float jdField_a_of_type_Float = 1.0F;
  final int jdField_a_of_type_Int = 80;
  long jdField_a_of_type_Long = 0L;
  FileWebView.TitilebarEventInterface jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean = false;
  float b = 0.0F;
  float c = 0.0F;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11)
    {
      setZoomControlGone(this);
      return;
    }
    getSettings().setDisplayZoomControls(false);
  }
  
  private Class a(ParameterizedType paramParameterizedType, int paramInt)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments()[paramInt];
    if ((paramParameterizedType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramParameterizedType).getRawType();
    }
    if ((paramParameterizedType instanceof GenericArrayType)) {
      return (Class)((GenericArrayType)paramParameterizedType).getGenericComponentType();
    }
    if ((paramParameterizedType instanceof TypeVariable)) {
      return a(((TypeVariable)paramParameterizedType).getBounds()[0], 0);
    }
    return (Class)paramParameterizedType;
  }
  
  private Class a(Type paramType, int paramInt)
  {
    if ((paramType instanceof ParameterizedType)) {
      return a((ParameterizedType)paramType, paramInt);
    }
    if ((paramType instanceof TypeVariable)) {
      return a(((TypeVariable)paramType).getBounds()[0], 0);
    }
    return (Class)paramType;
  }
  
  /* Error */
  public boolean a(WebView paramWebView, java.lang.String paramString, FileWebView.JSInterface paramJSInterface)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_2
    //   7: ldc 121
    //   9: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_2
    //   18: ldc 129
    //   20: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 6
    //   25: aload_2
    //   26: invokevirtual 136	java/lang/String:length	()I
    //   29: iconst_1
    //   30: if_icmple +539 -> 569
    //   33: aload 6
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmple +532 -> 569
    //   40: aload 6
    //   42: iconst_0
    //   43: aaload
    //   44: astore_1
    //   45: aload 6
    //   47: iconst_1
    //   48: aaload
    //   49: ldc 138
    //   51: ldc 140
    //   53: invokevirtual 144	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 146	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 153
    //   70: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc 159
    //   78: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: invokestatic 165	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface 170 1 0
    //   91: iconst_5
    //   92: if_icmpge +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_1
    //   98: iconst_2
    //   99: invokeinterface 174 2 0
    //   104: checkcast 123	java/lang/String
    //   107: ldc 176
    //   109: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_1
    //   118: iconst_3
    //   119: invokeinterface 174 2 0
    //   124: checkcast 123	java/lang/String
    //   127: astore 9
    //   129: aconst_null
    //   130: astore 6
    //   132: aload_2
    //   133: invokestatic 184	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)Ljava/util/LinkedHashMap;
    //   136: astore_1
    //   137: aload_1
    //   138: astore 6
    //   140: aload_3
    //   141: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   144: invokevirtual 192	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   147: astore 10
    //   149: aload 10
    //   151: arraylength
    //   152: istore 5
    //   154: iconst_0
    //   155: istore 4
    //   157: aconst_null
    //   158: astore_1
    //   159: iload 4
    //   161: iload 5
    //   163: if_icmpge +398 -> 561
    //   166: aload 10
    //   168: iload 4
    //   170: aaload
    //   171: astore 8
    //   173: aload_1
    //   174: astore 7
    //   176: aload 8
    //   178: invokevirtual 197	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   181: aload 9
    //   183: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +91 -> 277
    //   189: aload 8
    //   191: invokevirtual 205	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 7
    //   198: aload_1
    //   199: arraylength
    //   200: aload 6
    //   202: invokevirtual 208	java/util/LinkedHashMap:size	()I
    //   205: if_icmpne +72 -> 277
    //   208: aload_1
    //   209: astore 7
    //   211: aload 8
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +336 -> 551
    //   218: aload 6
    //   220: invokevirtual 208	java/util/LinkedHashMap:size	()I
    //   223: ifne +66 -> 289
    //   226: aload_1
    //   227: aload_3
    //   228: iconst_0
    //   229: anewarray 39	java/lang/Object
    //   232: invokevirtual 212	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_1
    //   239: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +28 -> 270
    //   245: ldc 220
    //   247: iconst_1
    //   248: new 146	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   255: ldc 222
    //   257: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_2
    //   261: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_1
    //   271: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   274: goto -134 -> 140
    //   277: iload 4
    //   279: iconst_1
    //   280: iadd
    //   281: istore 4
    //   283: aload 7
    //   285: astore_1
    //   286: goto -127 -> 159
    //   289: aload 6
    //   291: invokevirtual 233	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   294: invokeinterface 239 1 0
    //   299: astore_2
    //   300: aload 7
    //   302: arraylength
    //   303: anewarray 39	java/lang/Object
    //   306: astore 6
    //   308: iconst_0
    //   309: istore 4
    //   311: iload 4
    //   313: aload 7
    //   315: arraylength
    //   316: if_icmpge +207 -> 523
    //   319: aload_0
    //   320: aload 7
    //   322: iload 4
    //   324: aaload
    //   325: iload 4
    //   327: invokespecial 108	com/tencent/mobileqq/filemanager/widget/FileWebView:a	(Ljava/lang/reflect/Type;I)Ljava/lang/Class;
    //   330: invokevirtual 240	java/lang/Class:toString	()Ljava/lang/String;
    //   333: invokevirtual 243	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   336: astore 8
    //   338: aload 8
    //   340: ldc 245
    //   342: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   345: ifne +13 -> 358
    //   348: aload 8
    //   350: ldc 251
    //   352: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   355: ifeq +24 -> 379
    //   358: aload 6
    //   360: iload 4
    //   362: aload_2
    //   363: iload 4
    //   365: aaload
    //   366: checkcast 123	java/lang/String
    //   369: invokestatic 255	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   372: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   375: aastore
    //   376: goto +202 -> 578
    //   379: aload 8
    //   381: ldc_w 260
    //   384: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +42 -> 429
    //   390: aload 6
    //   392: iload 4
    //   394: aload_2
    //   395: iload 4
    //   397: aaload
    //   398: checkcast 123	java/lang/String
    //   401: invokestatic 266	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   404: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: goto +170 -> 578
    //   411: astore_1
    //   412: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +12 -> 427
    //   418: ldc 220
    //   420: iconst_2
    //   421: ldc_w 271
    //   424: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: iconst_0
    //   428: ireturn
    //   429: aload 8
    //   431: ldc_w 273
    //   434: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   437: ifeq +36 -> 473
    //   440: aload 6
    //   442: iload 4
    //   444: aload_2
    //   445: iload 4
    //   447: aaload
    //   448: checkcast 123	java/lang/String
    //   451: aastore
    //   452: goto +126 -> 578
    //   455: astore_1
    //   456: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +12 -> 471
    //   462: ldc 220
    //   464: iconst_2
    //   465: ldc_w 275
    //   468: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iconst_0
    //   472: ireturn
    //   473: aload 8
    //   475: ldc_w 277
    //   478: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   481: ifeq +97 -> 578
    //   484: aload 6
    //   486: iload 4
    //   488: aload_2
    //   489: iload 4
    //   491: aaload
    //   492: checkcast 123	java/lang/String
    //   495: invokestatic 282	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   498: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   501: aastore
    //   502: goto +76 -> 578
    //   505: astore_1
    //   506: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +12 -> 521
    //   512: ldc 220
    //   514: iconst_2
    //   515: ldc_w 287
    //   518: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: iconst_0
    //   522: ireturn
    //   523: aload_1
    //   524: aload_3
    //   525: aload 6
    //   527: invokevirtual 212	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   530: pop
    //   531: iconst_1
    //   532: ireturn
    //   533: astore_1
    //   534: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +12 -> 549
    //   540: ldc 220
    //   542: iconst_2
    //   543: ldc_w 289
    //   546: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: iconst_0
    //   550: ireturn
    //   551: aload_3
    //   552: aload_2
    //   553: invokeinterface 294 2 0
    //   558: goto -322 -> 236
    //   561: aload_1
    //   562: astore 7
    //   564: aconst_null
    //   565: astore_1
    //   566: goto -352 -> 214
    //   569: ldc 140
    //   571: astore_1
    //   572: ldc 140
    //   574: astore_2
    //   575: goto -518 -> 57
    //   578: iload 4
    //   580: iconst_1
    //   581: iadd
    //   582: istore 4
    //   584: goto -273 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	FileWebView
    //   0	587	1	paramWebView	WebView
    //   0	587	2	paramString	java.lang.String
    //   0	587	3	paramJSInterface	FileWebView.JSInterface
    //   155	428	4	i	int
    //   152	12	5	j	int
    //   23	503	6	localObject1	Object
    //   174	389	7	localWebView	WebView
    //   171	303	8	localObject2	Object
    //   127	55	9	str	java.lang.String
    //   147	20	10	arrayOfMethod	java.lang.reflect.Method[]
    // Exception table:
    //   from	to	target	type
    //   132	137	238	java/lang/Exception
    //   218	236	411	java/lang/IllegalAccessException
    //   289	308	411	java/lang/IllegalAccessException
    //   311	358	411	java/lang/IllegalAccessException
    //   358	376	411	java/lang/IllegalAccessException
    //   379	408	411	java/lang/IllegalAccessException
    //   429	452	411	java/lang/IllegalAccessException
    //   473	502	411	java/lang/IllegalAccessException
    //   523	531	411	java/lang/IllegalAccessException
    //   218	236	455	java/lang/IllegalArgumentException
    //   289	308	455	java/lang/IllegalArgumentException
    //   311	358	455	java/lang/IllegalArgumentException
    //   358	376	455	java/lang/IllegalArgumentException
    //   379	408	455	java/lang/IllegalArgumentException
    //   429	452	455	java/lang/IllegalArgumentException
    //   473	502	455	java/lang/IllegalArgumentException
    //   523	531	455	java/lang/IllegalArgumentException
    //   218	236	505	java/lang/reflect/InvocationTargetException
    //   289	308	505	java/lang/reflect/InvocationTargetException
    //   311	358	505	java/lang/reflect/InvocationTargetException
    //   358	376	505	java/lang/reflect/InvocationTargetException
    //   379	408	505	java/lang/reflect/InvocationTargetException
    //   429	452	505	java/lang/reflect/InvocationTargetException
    //   473	502	505	java/lang/reflect/InvocationTargetException
    //   523	531	505	java/lang/reflect/InvocationTargetException
    //   218	236	533	java/lang/Exception
    //   289	308	533	java/lang/Exception
    //   311	358	533	java/lang/Exception
    //   358	376	533	java/lang/Exception
    //   379	408	533	java/lang/Exception
    //   429	452	533	java/lang/Exception
    //   473	502	533	java/lang/Exception
    //   523	531	533	java/lang/Exception
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.jdField_a_of_type_JavaUtilTimer + " this " + this + "is cancel");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.b = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.f();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.c = paramMotionEvent.getY();
      if (this.b > this.c)
      {
        getContentHeight();
        getHeight();
        int i = getWebScrollY();
        getScale();
        if ((getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D) || (i == 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a();
      }
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
      } while (getScrollY() >= 1.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.e();
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {}
    do
    {
      return;
      paramInt1 = getContentHeight();
      paramInt3 = getView().getHeight();
      int i = getWebScrollY();
      float f = getScale();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileWebView", 4, "contentHeight[" + paramInt1 + "],height[" + paramInt3 + "],scroolY[" + i + "],scale[" + f + "]");
      }
      f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
      if ((f < paramInt3 * 2) && (!FileManagerUtil.a())) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.g();
      }
      if (f < 2.5D) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(FileWebView.TitilebarEventInterface paramTitilebarEventInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface = paramTitilebarEventInterface;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */