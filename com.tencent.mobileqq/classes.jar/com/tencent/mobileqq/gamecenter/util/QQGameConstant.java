package com.tencent.mobileqq.gamecenter.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;

public class QQGameConstant
{
  public static final String a;
  public static Map<String, String> a;
  public static Queue<String> a;
  public static boolean a;
  public static final String b;
  public static final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131710259);
    b = HardCodeUtil.a(2131710258);
    c = HardCodeUtil.a(2131710260);
    jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Boolean = true;
  }
  
  public static StateListDrawable a(Context paramContext)
  {
    Object localObject1 = new Drawable[3];
    float f1 = AIOUtils.a(4.0F, paramContext.getResources());
    float f2 = AIOUtils.a(4.0F, paramContext.getResources());
    float f3 = AIOUtils.a(4.0F, paramContext.getResources());
    float f4 = AIOUtils.a(4.0F, paramContext.getResources());
    int i = 0;
    while (i < 2)
    {
      localObject2 = new RoundRectShape(new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, null, null);
      localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setPadding(AIOUtils.a(2.0F, paramContext.getResources()), AIOUtils.a(0.0F, paramContext.getResources()), AIOUtils.a(2.0F, paramContext.getResources()), AIOUtils.a(2.0F, paramContext.getResources()));
      localShapeDrawable.setShape((Shape)localObject2);
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(83886080);
      localObject1[i] = localShapeDrawable;
      i += 1;
    }
    Object localObject2 = new float[8];
    localObject2[0] = f1;
    localObject2[1] = f1;
    localObject2[2] = f2;
    localObject2[3] = f2;
    localObject2[4] = f3;
    localObject2[5] = f3;
    localObject2[6] = f4;
    localObject2[7] = f4;
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[2] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[2] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, String paramString1, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mLoadingDrawable = paramDrawable2;
    paramString1.mFailedDrawable = paramDrawable2;
    paramDrawable2 = URLDrawable.getDrawable(paramString2, paramString1);
    paramString1 = new StateListDrawable();
    paramString1.addState(new int[] { 16842919 }, paramDrawable2);
    paramString1.addState(new int[] { 16842910 }, paramDrawable1);
    return paramString1;
  }
  
  public static StateListDrawable a(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = URLDrawable.getDrawable(paramString1, paramContext.getResources().getDrawable(2130850453), paramContext.getResources().getDrawable(2130850453));
    paramString2 = URLDrawable.getDrawable(paramString2);
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramString1);
    paramContext.addState(new int[] { 16842908 }, paramString2);
    paramContext.addState(new int[] { 16842910 }, paramString2);
    paramContext.addState(new int[0], paramString2);
    return paramContext;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      String str3 = paramMessageRecord.extStr;
      Object localObject = str3;
      str1 = str2;
      if (TextUtils.isEmpty(str3))
      {
        str1 = str2;
        localObject = paramMessageRecord.mExJsonObject.toString();
      }
      str1 = str2;
      paramMessageRecord = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = str2;
        localObject = new JSONObject((String)localObject);
        str1 = str2;
        paramMessageRecord = PublicAccountEventReport.a(((JSONObject)localObject).optString("report_key_bytes_oac_msg_extend", ""));
        str1 = str2;
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          return paramMessageRecord;
        }
        str1 = str2;
        str2 = ((JSONObject)localObject).optString("public_account_msg_id", "");
        str1 = str2;
        paramMessageRecord = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramMessageRecord = ((JSONObject)localObject).optString("pa_msgId", "");
          return paramMessageRecord;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQGameConstant", 1, "getPAMsgId error =" + paramMessageRecord.toString());
      paramMessageRecord = str1;
    }
    return paramMessageRecord;
  }
  
  /* Error */
  public static String a(MessageRecord paramMessageRecord, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 193
    //   8: iconst_1
    //   9: new 195	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   16: ldc 217
    //   18: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: ifnonnull +10 -> 42
    //   35: ldc 152
    //   37: astore 7
    //   39: aload 7
    //   41: areturn
    //   42: ldc 152
    //   44: astore 8
    //   46: ldc 152
    //   48: astore 11
    //   50: ldc 152
    //   52: astore 9
    //   54: aload_0
    //   55: invokestatic 225	com/tencent/mobileqq/gamecenter/util/QQGameConstant:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   58: astore 12
    //   60: iload_1
    //   61: ifne +556 -> 617
    //   64: new 195	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   71: aload 12
    //   73: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 227
    //   78: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 7
    //   86: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   89: aload 7
    //   91: invokeinterface 233 2 0
    //   96: ifeq +71 -> 167
    //   99: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload 7
    //   104: invokeinterface 237 2 0
    //   109: checkcast 239	java/lang/String
    //   112: astore 10
    //   114: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +38 -> 155
    //   120: ldc 193
    //   122: iconst_1
    //   123: new 195	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   130: ldc 241
    //   132: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_1
    //   136: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc 243
    //   141: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 10
    //   146: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload 10
    //   157: astore 7
    //   159: aload 10
    //   161: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq -125 -> 39
    //   167: aload_0
    //   168: getfield 157	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   171: astore 7
    //   173: aload 7
    //   175: astore 10
    //   177: aload 7
    //   179: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifeq +12 -> 194
    //   185: aload_0
    //   186: getfield 167	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   189: invokevirtual 173	org/json/JSONObject:toString	()Ljava/lang/String;
    //   192: astore 10
    //   194: aload 8
    //   196: astore 7
    //   198: aload 10
    //   200: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +694 -> 897
    //   206: aload 8
    //   208: astore 7
    //   210: new 169	org/json/JSONObject
    //   213: dup
    //   214: aload 10
    //   216: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   219: ldc 178
    //   221: ldc 152
    //   223: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 10
    //   228: aload 8
    //   230: astore 7
    //   232: aload 10
    //   234: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne +495 -> 732
    //   240: aload 8
    //   242: astore 7
    //   244: new 169	org/json/JSONObject
    //   247: dup
    //   248: aload 10
    //   250: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   253: ldc 245
    //   255: ldc 152
    //   257: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   260: astore 10
    //   262: aload 8
    //   264: astore 7
    //   266: aload 10
    //   268: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifne +941 -> 1212
    //   274: aload 8
    //   276: astore 7
    //   278: new 169	org/json/JSONObject
    //   281: dup
    //   282: aload 10
    //   284: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   287: astore 11
    //   289: aload 8
    //   291: astore 7
    //   293: aload 11
    //   295: ldc 247
    //   297: invokevirtual 251	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   300: astore 10
    //   302: aload 10
    //   304: ifnull +901 -> 1205
    //   307: aload 8
    //   309: astore 7
    //   311: aload 10
    //   313: invokevirtual 254	org/json/JSONArray:toString	()Ljava/lang/String;
    //   316: astore 9
    //   318: aload 8
    //   320: astore 7
    //   322: aload 10
    //   324: iconst_0
    //   325: invokevirtual 258	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   328: ldc_w 260
    //   331: ldc 152
    //   333: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   336: astore 8
    //   338: aload 8
    //   340: astore 7
    //   342: aload 10
    //   344: iconst_1
    //   345: invokevirtual 258	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   348: ldc_w 262
    //   351: ldc 152
    //   353: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   356: astore 10
    //   358: aload 8
    //   360: astore 7
    //   362: aload 11
    //   364: ldc_w 264
    //   367: ldc 152
    //   369: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 11
    //   374: aload 8
    //   376: astore 7
    //   378: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   381: new 195	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   388: aload 12
    //   390: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 227
    //   395: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: aload 8
    //   403: invokeinterface 268 3 0
    //   408: pop
    //   409: aload 8
    //   411: astore 7
    //   413: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   416: new 195	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   423: aload 12
    //   425: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 270
    //   431: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: aload 10
    //   439: invokeinterface 268 3 0
    //   444: pop
    //   445: aload 8
    //   447: astore 7
    //   449: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   452: new 195	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   459: aload 12
    //   461: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 272
    //   467: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: aload 11
    //   475: invokeinterface 268 3 0
    //   480: pop
    //   481: aload 8
    //   483: astore 7
    //   485: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   488: new 195	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   495: aload 12
    //   497: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: ldc_w 274
    //   503: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: aload 9
    //   511: invokeinterface 268 3 0
    //   516: pop
    //   517: aload 8
    //   519: astore 7
    //   521: aload 10
    //   523: astore 8
    //   525: aload 11
    //   527: astore 10
    //   529: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +73 -> 605
    //   535: ldc 193
    //   537: iconst_1
    //   538: new 195	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   545: ldc_w 276
    //   548: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: iload_1
    //   552: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: ldc_w 278
    //   558: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 7
    //   563: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc_w 280
    //   569: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 8
    //   574: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 282
    //   580: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 10
    //   585: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc_w 284
    //   591: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 9
    //   596: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: iload_1
    //   606: ifeq -567 -> 39
    //   609: iload_1
    //   610: iconst_1
    //   611: if_icmpne +102 -> 713
    //   614: aload 8
    //   616: areturn
    //   617: iload_1
    //   618: iconst_1
    //   619: if_icmpne +29 -> 648
    //   622: new 195	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   629: aload 12
    //   631: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: ldc_w 270
    //   637: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: astore 7
    //   645: goto -559 -> 86
    //   648: iload_1
    //   649: iconst_2
    //   650: if_icmpne +29 -> 679
    //   653: new 195	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   660: aload 12
    //   662: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc_w 272
    //   668: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: astore 7
    //   676: goto -590 -> 86
    //   679: iload_1
    //   680: iconst_4
    //   681: if_icmpne +29 -> 710
    //   684: new 195	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   691: aload 12
    //   693: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 274
    //   699: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: astore 7
    //   707: goto -621 -> 86
    //   710: ldc 152
    //   712: areturn
    //   713: iload_1
    //   714: iconst_2
    //   715: if_icmpne +6 -> 721
    //   718: aload 10
    //   720: areturn
    //   721: iload_1
    //   722: iconst_4
    //   723: if_icmpne +6 -> 729
    //   726: aload 9
    //   728: areturn
    //   729: ldc 152
    //   731: areturn
    //   732: ldc 152
    //   734: astore 7
    //   736: iload_1
    //   737: ifne +418 -> 1155
    //   740: aload_0
    //   741: instanceof 286
    //   744: ifeq +193 -> 937
    //   747: aload_0
    //   748: checkcast 286	com/tencent/mobileqq/data/MessageForArkApp
    //   751: astore_0
    //   752: aload_0
    //   753: getfield 290	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   756: getfield 295	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   759: astore 8
    //   761: getstatic 43	com/tencent/mobileqq/gamecenter/util/QQGameConstant:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   764: new 195	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   771: aload 12
    //   773: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc 227
    //   778: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: aload 8
    //   786: invokeinterface 268 3 0
    //   791: pop
    //   792: aload 8
    //   794: astore 7
    //   796: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq -760 -> 39
    //   802: ldc 193
    //   804: iconst_1
    //   805: new 195	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 297
    //   815: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: iload_1
    //   819: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: ldc_w 278
    //   825: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 8
    //   830: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: aload 8
    //   841: areturn
    //   842: astore 9
    //   844: aload 7
    //   846: astore 8
    //   848: aload 9
    //   850: invokevirtual 300	java/lang/Throwable:printStackTrace	()V
    //   853: aload 8
    //   855: astore 7
    //   857: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +37 -> 897
    //   863: ldc 193
    //   865: iconst_1
    //   866: new 195	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 302
    //   876: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 9
    //   881: invokevirtual 305	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   884: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload 8
    //   895: astore 7
    //   897: goto -161 -> 736
    //   900: astore_0
    //   901: ldc 193
    //   903: iconst_1
    //   904: new 195	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   911: ldc_w 307
    //   914: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload_0
    //   918: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   921: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload 7
    //   932: astore 8
    //   934: goto -173 -> 761
    //   937: aload 7
    //   939: astore 8
    //   941: aload_0
    //   942: instanceof 309
    //   945: ifeq -184 -> 761
    //   948: aload_0
    //   949: checkcast 309	com/tencent/mobileqq/data/MessageForStructing
    //   952: getfield 313	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   955: checkcast 315	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   958: astore_0
    //   959: aload_0
    //   960: invokevirtual 319	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getStructMsgItemLists	()Ljava/util/List;
    //   963: checkcast 321	java/util/ArrayList
    //   966: astore 7
    //   968: aload 7
    //   970: ifnonnull +257 -> 1227
    //   973: ldc 152
    //   975: areturn
    //   976: iload 5
    //   978: aload 7
    //   980: invokevirtual 325	java/util/ArrayList:size	()I
    //   983: if_icmpge +120 -> 1103
    //   986: aload 7
    //   988: iload 5
    //   990: invokevirtual 328	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   993: instanceof 330
    //   996: ifeq +252 -> 1248
    //   999: aload 7
    //   1001: iload 5
    //   1003: invokevirtual 328	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1006: checkcast 330	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   1009: checkcast 330	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   1012: getfield 333	com/tencent/mobileqq/structmsg/AbsStructMsgItem:a	Ljava/util/ArrayList;
    //   1015: astore 8
    //   1017: iload_1
    //   1018: istore_3
    //   1019: iload_2
    //   1020: istore_1
    //   1021: iconst_0
    //   1022: istore 6
    //   1024: iload_3
    //   1025: istore_2
    //   1026: iload_2
    //   1027: istore_3
    //   1028: iload_1
    //   1029: istore 4
    //   1031: iload 6
    //   1033: aload 8
    //   1035: invokevirtual 325	java/util/ArrayList:size	()I
    //   1038: if_icmpge +215 -> 1253
    //   1041: aload 8
    //   1043: iload 6
    //   1045: invokevirtual 328	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1048: instanceof 335
    //   1051: ifeq +30 -> 1081
    //   1054: iconst_1
    //   1055: istore_3
    //   1056: iload_3
    //   1057: ifeq +180 -> 1237
    //   1060: iload_2
    //   1061: ifeq +176 -> 1237
    //   1064: aload 7
    //   1066: iload 5
    //   1068: invokevirtual 328	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1071: checkcast 337	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   1074: getfield 338	com/tencent/mobileqq/structmsg/AbsStructMsgElement:b	Ljava/lang/String;
    //   1077: invokestatic 339	com/tencent/mobileqq/gamecenter/util/QQGameConstant:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1080: areturn
    //   1081: iload_1
    //   1082: istore_3
    //   1083: aload 8
    //   1085: iload 6
    //   1087: invokevirtual 328	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1090: instanceof 341
    //   1093: ifeq -37 -> 1056
    //   1096: iconst_1
    //   1097: istore_2
    //   1098: iload_1
    //   1099: istore_3
    //   1100: goto -44 -> 1056
    //   1103: aload 7
    //   1105: invokevirtual 325	java/util/ArrayList:size	()I
    //   1108: iconst_2
    //   1109: if_icmpne +43 -> 1152
    //   1112: aload_0
    //   1113: getfield 344	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   1116: invokestatic 339	com/tencent/mobileqq/gamecenter/util/QQGameConstant:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1119: astore_0
    //   1120: aload_0
    //   1121: areturn
    //   1122: astore_0
    //   1123: ldc 193
    //   1125: iconst_1
    //   1126: new 195	java/lang/StringBuilder
    //   1129: dup
    //   1130: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1133: ldc_w 346
    //   1136: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload_0
    //   1140: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1143: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: ldc 152
    //   1154: areturn
    //   1155: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1158: ifeq +35 -> 1193
    //   1161: ldc 193
    //   1163: iconst_1
    //   1164: new 195	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1171: ldc_w 297
    //   1174: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload_1
    //   1178: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1181: ldc_w 348
    //   1184: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1193: ldc 152
    //   1195: areturn
    //   1196: astore 9
    //   1198: aload 7
    //   1200: astore 8
    //   1202: goto -354 -> 848
    //   1205: ldc 152
    //   1207: astore 10
    //   1209: goto -851 -> 358
    //   1212: ldc 152
    //   1214: astore 7
    //   1216: ldc 152
    //   1218: astore 8
    //   1220: aload 11
    //   1222: astore 10
    //   1224: goto -695 -> 529
    //   1227: iconst_0
    //   1228: istore 5
    //   1230: iconst_0
    //   1231: istore_1
    //   1232: iconst_0
    //   1233: istore_2
    //   1234: goto -258 -> 976
    //   1237: iload 6
    //   1239: iconst_1
    //   1240: iadd
    //   1241: istore 6
    //   1243: iload_3
    //   1244: istore_1
    //   1245: goto -219 -> 1026
    //   1248: iload_2
    //   1249: istore 4
    //   1251: iload_1
    //   1252: istore_3
    //   1253: iload 5
    //   1255: iconst_1
    //   1256: iadd
    //   1257: istore 5
    //   1259: iload 4
    //   1261: istore_2
    //   1262: iload_3
    //   1263: istore_1
    //   1264: goto -288 -> 976
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1267	0	paramMessageRecord	MessageRecord
    //   0	1267	1	paramInt	int
    //   1019	243	2	i	int
    //   1018	245	3	j	int
    //   1029	231	4	k	int
    //   976	282	5	m	int
    //   1022	220	6	n	int
    //   37	1178	7	localObject1	Object
    //   44	1175	8	localObject2	Object
    //   52	675	9	str1	String
    //   842	38	9	localThrowable1	Throwable
    //   1196	1	9	localThrowable2	Throwable
    //   112	1111	10	localObject3	Object
    //   48	1173	11	localObject4	Object
    //   58	714	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   210	228	842	java/lang/Throwable
    //   232	240	842	java/lang/Throwable
    //   244	262	842	java/lang/Throwable
    //   266	274	842	java/lang/Throwable
    //   278	289	842	java/lang/Throwable
    //   293	302	842	java/lang/Throwable
    //   311	318	842	java/lang/Throwable
    //   322	338	842	java/lang/Throwable
    //   342	358	842	java/lang/Throwable
    //   362	374	842	java/lang/Throwable
    //   378	409	842	java/lang/Throwable
    //   413	445	842	java/lang/Throwable
    //   449	481	842	java/lang/Throwable
    //   485	517	842	java/lang/Throwable
    //   752	761	900	java/lang/Throwable
    //   948	968	1122	java/lang/Throwable
    //   976	1017	1122	java/lang/Throwable
    //   1031	1054	1122	java/lang/Throwable
    //   1064	1081	1122	java/lang/Throwable
    //   1083	1096	1122	java/lang/Throwable
    //   1103	1120	1122	java/lang/Throwable
    //   529	605	1196	java/lang/Throwable
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (!paramString.contains("pubAccountAppid")) {}
    }
    try
    {
      localObject1 = Uri.parse(paramString).getQueryParameter("pubAccountAppid");
      return localObject1;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameConstant", 1, "getappid error=" + paramString.toString());
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    TroopUtils.a(paramContext, TroopInfoActivity.a(paramString, 3001), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameConstant
 * JD-Core Version:    0.7.0.1
 */