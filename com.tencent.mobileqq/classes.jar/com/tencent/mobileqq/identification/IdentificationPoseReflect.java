package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtCameraSetting;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class IdentificationPoseReflect
  extends IdentificationBaseModel
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  
  public IdentificationPoseReflect(Intent paramIntent, RequestHelper.RequestListener paramRequestListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIdentificationRequestHelper$RequestListener = paramRequestListener;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf = ((FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf"));
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    YtLogger.i("qq_Identification.Model", "[YTUtilityInterface.setAppBrightness] brightness: " + paramInt);
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("qq_Identification.Model", 1, "setAppBrightness activity invalid");
      return;
    }
    paramActivity = paramActivity.getWindow();
    if (paramActivity == null)
    {
      QLog.e("qq_Identification.Model", 1, "setAppBrightness window==null");
      return;
    }
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    if (paramInt == -1) {}
    int i;
    for (localLayoutParams.screenBrightness = -1.0F;; localLayoutParams.screenBrightness = (i / 255.0F))
    {
      paramActivity.setAttributes(localLayoutParams);
      return;
      i = paramInt;
      if (paramInt <= 0) {
        i = 1;
      }
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  /* Error */
  public int a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 36	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   10: aload_2
    //   11: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 136
    //   16: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 6
    //   24: new 36	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   31: aload_2
    //   32: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 138
    //   37: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 8
    //   45: new 36	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   52: astore 9
    //   54: new 36	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   61: astore 10
    //   63: new 140	java/io/BufferedReader
    //   66: dup
    //   67: new 142	java/io/InputStreamReader
    //   70: dup
    //   71: new 144	java/io/FileInputStream
    //   74: dup
    //   75: new 146	java/io/File
    //   78: dup
    //   79: aload 6
    //   81: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 155	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   90: invokespecial 158	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   93: astore_2
    //   94: new 140	java/io/BufferedReader
    //   97: dup
    //   98: new 142	java/io/InputStreamReader
    //   101: dup
    //   102: new 144	java/io/FileInputStream
    //   105: dup
    //   106: new 146	java/io/File
    //   109: dup
    //   110: aload 8
    //   112: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: invokespecial 155	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   121: invokespecial 158	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore 6
    //   126: aload 6
    //   128: astore 8
    //   130: aload_2
    //   131: astore 7
    //   133: aload_2
    //   134: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore 11
    //   139: aload 11
    //   141: ifnull +76 -> 217
    //   144: aload 6
    //   146: astore 8
    //   148: aload_2
    //   149: astore 7
    //   151: aload 9
    //   153: aload 11
    //   155: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -33 -> 126
    //   162: astore 7
    //   164: aload_2
    //   165: astore_1
    //   166: aload 7
    //   168: astore_2
    //   169: ldc 34
    //   171: iconst_1
    //   172: new 36	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   179: ldc 163
    //   181: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 166	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 169	java/io/BufferedReader:close	()V
    //   205: aload 6
    //   207: ifnull +8 -> 215
    //   210: aload 6
    //   212: invokevirtual 169	java/io/BufferedReader:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: aload 6
    //   219: astore 8
    //   221: aload_2
    //   222: astore 7
    //   224: aload 6
    //   226: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore 11
    //   231: aload 11
    //   233: ifnull +108 -> 341
    //   236: aload 6
    //   238: astore 8
    //   240: aload_2
    //   241: astore 7
    //   243: aload 10
    //   245: aload 11
    //   247: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: goto -34 -> 217
    //   254: astore_1
    //   255: aload 6
    //   257: astore 8
    //   259: aload_2
    //   260: astore 7
    //   262: ldc 34
    //   264: iconst_1
    //   265: new 36	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   272: ldc 171
    //   274: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_2
    //   291: ifnull +7 -> 298
    //   294: aload_2
    //   295: invokevirtual 169	java/io/BufferedReader:close	()V
    //   298: aload 6
    //   300: ifnull -85 -> 215
    //   303: aload 6
    //   305: invokevirtual 169	java/io/BufferedReader:close	()V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore_1
    //   311: ldc 34
    //   313: iconst_1
    //   314: new 36	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   321: ldc 174
    //   323: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: iconst_1
    //   340: ireturn
    //   341: aload 6
    //   343: astore 8
    //   345: aload_2
    //   346: astore 7
    //   348: invokestatic 179	com/tencent/mobileqq/identification/YtSDKKit:a	()Lcom/tencent/mobileqq/identification/YtSDKKit;
    //   351: aload 9
    //   353: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 10
    //   358: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokevirtual 182	com/tencent/mobileqq/identification/YtSDKKit:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: aload 6
    //   367: astore 8
    //   369: aload_2
    //   370: astore 7
    //   372: aload_0
    //   373: getfield 29	com/tencent/mobileqq/identification/IdentificationPoseReflect:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   376: ifnull +596 -> 972
    //   379: aload 6
    //   381: astore 8
    //   383: aload_2
    //   384: astore 7
    //   386: aload_0
    //   387: getfield 29	com/tencent/mobileqq/identification/IdentificationPoseReflect:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   390: getfield 186	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   393: ifnull +579 -> 972
    //   396: aload 6
    //   398: astore 8
    //   400: aload_2
    //   401: astore 7
    //   403: invokestatic 179	com/tencent/mobileqq/identification/YtSDKKit:a	()Lcom/tencent/mobileqq/identification/YtSDKKit;
    //   406: iconst_5
    //   407: invokevirtual 189	com/tencent/mobileqq/identification/YtSDKKit:a	(I)Lorg/json/JSONObject;
    //   410: astore 9
    //   412: aload 9
    //   414: ifnonnull +101 -> 515
    //   417: aload 6
    //   419: astore 8
    //   421: aload_2
    //   422: astore 7
    //   424: ldc 34
    //   426: iconst_1
    //   427: ldc 191
    //   429: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_2
    //   433: ifnull +7 -> 440
    //   436: aload_2
    //   437: invokevirtual 169	java/io/BufferedReader:close	()V
    //   440: aload 6
    //   442: ifnull -227 -> 215
    //   445: aload 6
    //   447: invokevirtual 169	java/io/BufferedReader:close	()V
    //   450: iconst_1
    //   451: ireturn
    //   452: astore_1
    //   453: ldc 34
    //   455: iconst_1
    //   456: new 36	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   463: ldc 174
    //   465: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   472: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: iconst_1
    //   482: ireturn
    //   483: astore_1
    //   484: ldc 34
    //   486: iconst_1
    //   487: new 36	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   494: ldc 193
    //   496: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   503: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: goto -72 -> 440
    //   515: aload 6
    //   517: astore 8
    //   519: aload_2
    //   520: astore 7
    //   522: new 195	org/json/JSONArray
    //   525: dup
    //   526: invokespecial 196	org/json/JSONArray:<init>	()V
    //   529: astore 10
    //   531: aload 6
    //   533: astore 8
    //   535: aload_2
    //   536: astore 7
    //   538: aload_0
    //   539: getfield 29	com/tencent/mobileqq/identification/IdentificationPoseReflect:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   542: getfield 186	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   545: astore 11
    //   547: aload 6
    //   549: astore 8
    //   551: aload_2
    //   552: astore 7
    //   554: aload 11
    //   556: arraylength
    //   557: istore 4
    //   559: iconst_0
    //   560: istore_3
    //   561: iload_3
    //   562: iload 4
    //   564: if_icmpge +27 -> 591
    //   567: aload 6
    //   569: astore 8
    //   571: aload_2
    //   572: astore 7
    //   574: aload 10
    //   576: aload 11
    //   578: iload_3
    //   579: iaload
    //   580: invokevirtual 200	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   583: pop
    //   584: iload_3
    //   585: iconst_1
    //   586: iadd
    //   587: istore_3
    //   588: goto -27 -> 561
    //   591: aload 6
    //   593: astore 8
    //   595: aload_2
    //   596: astore 7
    //   598: aload 9
    //   600: ldc 202
    //   602: aload 10
    //   604: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   607: pop
    //   608: aload 6
    //   610: astore 8
    //   612: aload_2
    //   613: astore 7
    //   615: aload 9
    //   617: ldc 209
    //   619: aload_0
    //   620: getfield 29	com/tencent/mobileqq/identification/IdentificationPoseReflect:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   623: getfield 213	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   626: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload 6
    //   632: astore 8
    //   634: aload_2
    //   635: astore 7
    //   637: aload 9
    //   639: ldc 215
    //   641: new 204	org/json/JSONObject
    //   644: dup
    //   645: aload_0
    //   646: getfield 29	com/tencent/mobileqq/identification/IdentificationPoseReflect:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   649: getfield 218	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:selectData	Ljava/lang/String;
    //   652: invokespecial 219	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   655: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   658: pop
    //   659: aload 6
    //   661: astore 8
    //   663: aload_2
    //   664: astore 7
    //   666: aload 9
    //   668: ldc 221
    //   670: invokevirtual 225	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   673: pop
    //   674: aload 6
    //   676: astore 8
    //   678: aload_2
    //   679: astore 7
    //   681: aload_1
    //   682: invokevirtual 231	android/content/Context:getFilesDir	()Ljava/io/File;
    //   685: invokevirtual 234	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   688: astore_1
    //   689: aload 6
    //   691: astore 8
    //   693: aload_2
    //   694: astore 7
    //   696: aload 9
    //   698: ldc 236
    //   700: new 36	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   707: aload_1
    //   708: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: ldc 238
    //   713: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   722: pop
    //   723: aload 6
    //   725: astore 8
    //   727: aload_2
    //   728: astore 7
    //   730: aload 9
    //   732: ldc 240
    //   734: new 36	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   741: aload_1
    //   742: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: ldc 242
    //   747: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 6
    //   759: astore 8
    //   761: aload_2
    //   762: astore 7
    //   764: ldc 34
    //   766: iconst_1
    //   767: iconst_4
    //   768: anewarray 244	java/lang/Object
    //   771: dup
    //   772: iconst_0
    //   773: ldc 246
    //   775: aastore
    //   776: dup
    //   777: iconst_1
    //   778: new 36	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   785: aload_1
    //   786: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: ldc 238
    //   791: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: aastore
    //   798: dup
    //   799: iconst_2
    //   800: ldc 248
    //   802: aastore
    //   803: dup
    //   804: iconst_3
    //   805: ldc 242
    //   807: aastore
    //   808: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   811: aload 6
    //   813: astore 8
    //   815: aload_2
    //   816: astore 7
    //   818: new 146	java/io/File
    //   821: dup
    //   822: aload 9
    //   824: ldc 236
    //   826: ldc 254
    //   828: invokevirtual 258	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   831: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   834: astore_1
    //   835: aload 6
    //   837: astore 8
    //   839: aload_2
    //   840: astore 7
    //   842: aload_1
    //   843: invokevirtual 261	java/io/File:getParentFile	()Ljava/io/File;
    //   846: astore 10
    //   848: aload 10
    //   850: ifnull +158 -> 1008
    //   853: aload 6
    //   855: astore 8
    //   857: aload_2
    //   858: astore 7
    //   860: aload 10
    //   862: invokevirtual 264	java/io/File:exists	()Z
    //   865: ifne +143 -> 1008
    //   868: aload 6
    //   870: astore 8
    //   872: aload_2
    //   873: astore 7
    //   875: aload 10
    //   877: invokevirtual 267	java/io/File:mkdirs	()Z
    //   880: istore 5
    //   882: iload 5
    //   884: ifne +18 -> 902
    //   887: aload 6
    //   889: astore 8
    //   891: aload_2
    //   892: astore 7
    //   894: aload 9
    //   896: ldc 236
    //   898: invokevirtual 225	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   901: pop
    //   902: aload 6
    //   904: astore 8
    //   906: aload_2
    //   907: astore 7
    //   909: aload_1
    //   910: invokevirtual 264	java/io/File:exists	()Z
    //   913: ifeq +15 -> 928
    //   916: aload 6
    //   918: astore 8
    //   920: aload_2
    //   921: astore 7
    //   923: aload_1
    //   924: invokevirtual 270	java/io/File:delete	()Z
    //   927: pop
    //   928: aload 6
    //   930: astore 8
    //   932: aload_2
    //   933: astore 7
    //   935: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   938: ifeq +34 -> 972
    //   941: aload 6
    //   943: astore 8
    //   945: aload_2
    //   946: astore 7
    //   948: ldc 34
    //   950: iconst_2
    //   951: iconst_2
    //   952: anewarray 244	java/lang/Object
    //   955: dup
    //   956: iconst_0
    //   957: ldc_w 275
    //   960: aastore
    //   961: dup
    //   962: iconst_1
    //   963: aload 9
    //   965: invokevirtual 276	org/json/JSONObject:toString	()Ljava/lang/String;
    //   968: aastore
    //   969: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   972: aload 6
    //   974: astore 8
    //   976: aload_2
    //   977: astore 7
    //   979: ldc 34
    //   981: iconst_1
    //   982: ldc_w 278
    //   985: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: aload_2
    //   989: ifnull +7 -> 996
    //   992: aload_2
    //   993: invokevirtual 169	java/io/BufferedReader:close	()V
    //   996: aload 6
    //   998: ifnull +8 -> 1006
    //   1001: aload 6
    //   1003: invokevirtual 169	java/io/BufferedReader:close	()V
    //   1006: iconst_0
    //   1007: ireturn
    //   1008: iconst_1
    //   1009: istore 5
    //   1011: goto -129 -> 882
    //   1014: astore_1
    //   1015: ldc 34
    //   1017: iconst_1
    //   1018: new 36	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1025: ldc 193
    //   1027: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload_1
    //   1031: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1034: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: goto -47 -> 996
    //   1046: astore_1
    //   1047: ldc 34
    //   1049: iconst_1
    //   1050: new 36	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1057: ldc 174
    //   1059: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload_1
    //   1063: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1066: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1075: goto -69 -> 1006
    //   1078: astore_1
    //   1079: ldc 34
    //   1081: iconst_1
    //   1082: new 36	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1089: ldc 193
    //   1091: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: aload_1
    //   1095: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1098: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1107: goto -902 -> 205
    //   1110: astore_1
    //   1111: ldc 34
    //   1113: iconst_1
    //   1114: new 36	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1121: ldc 174
    //   1123: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload_1
    //   1127: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1130: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1139: iconst_1
    //   1140: ireturn
    //   1141: astore_1
    //   1142: ldc 34
    //   1144: iconst_1
    //   1145: new 36	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1152: ldc 193
    //   1154: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: aload_1
    //   1158: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1161: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1170: goto -872 -> 298
    //   1173: astore_1
    //   1174: aconst_null
    //   1175: astore 6
    //   1177: aconst_null
    //   1178: astore_2
    //   1179: aload 6
    //   1181: astore 8
    //   1183: aload_2
    //   1184: astore 7
    //   1186: ldc 34
    //   1188: iconst_1
    //   1189: new 36	java/lang/StringBuilder
    //   1192: dup
    //   1193: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1196: ldc_w 282
    //   1199: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: aload_1
    //   1203: invokevirtual 283	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1206: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1215: aload_2
    //   1216: ifnull +7 -> 1223
    //   1219: aload_2
    //   1220: invokevirtual 169	java/io/BufferedReader:close	()V
    //   1223: aload 6
    //   1225: ifnull -1010 -> 215
    //   1228: aload 6
    //   1230: invokevirtual 169	java/io/BufferedReader:close	()V
    //   1233: iconst_1
    //   1234: ireturn
    //   1235: astore_1
    //   1236: ldc 34
    //   1238: iconst_1
    //   1239: new 36	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1246: ldc 174
    //   1248: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: aload_1
    //   1252: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1255: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: iconst_1
    //   1265: ireturn
    //   1266: astore_1
    //   1267: ldc 34
    //   1269: iconst_1
    //   1270: new 36	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1277: ldc 193
    //   1279: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: aload_1
    //   1283: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1286: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1292: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1295: goto -72 -> 1223
    //   1298: astore_1
    //   1299: aconst_null
    //   1300: astore 6
    //   1302: aconst_null
    //   1303: astore_2
    //   1304: aload_2
    //   1305: ifnull +7 -> 1312
    //   1308: aload_2
    //   1309: invokevirtual 169	java/io/BufferedReader:close	()V
    //   1312: aload 6
    //   1314: ifnull +8 -> 1322
    //   1317: aload 6
    //   1319: invokevirtual 169	java/io/BufferedReader:close	()V
    //   1322: aload_1
    //   1323: athrow
    //   1324: astore_2
    //   1325: ldc 34
    //   1327: iconst_1
    //   1328: new 36	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1335: ldc 193
    //   1337: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: aload_2
    //   1341: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1344: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1353: goto -41 -> 1312
    //   1356: astore_2
    //   1357: ldc 34
    //   1359: iconst_1
    //   1360: new 36	java/lang/StringBuilder
    //   1363: dup
    //   1364: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1367: ldc 174
    //   1369: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: aload_2
    //   1373: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1376: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1385: goto -63 -> 1322
    //   1388: astore_1
    //   1389: aconst_null
    //   1390: astore 6
    //   1392: goto -88 -> 1304
    //   1395: astore_1
    //   1396: aload 8
    //   1398: astore 6
    //   1400: aload 7
    //   1402: astore_2
    //   1403: goto -99 -> 1304
    //   1406: astore 7
    //   1408: aload_1
    //   1409: astore_2
    //   1410: aload 7
    //   1412: astore_1
    //   1413: goto -109 -> 1304
    //   1416: astore_1
    //   1417: aconst_null
    //   1418: astore 6
    //   1420: goto -241 -> 1179
    //   1423: astore_1
    //   1424: goto -245 -> 1179
    //   1427: astore_1
    //   1428: aconst_null
    //   1429: astore 6
    //   1431: aconst_null
    //   1432: astore_2
    //   1433: goto -1178 -> 255
    //   1436: astore_1
    //   1437: aconst_null
    //   1438: astore 6
    //   1440: goto -1185 -> 255
    //   1443: astore_2
    //   1444: aconst_null
    //   1445: astore 6
    //   1447: aload 7
    //   1449: astore_1
    //   1450: goto -1281 -> 169
    //   1453: astore 7
    //   1455: aconst_null
    //   1456: astore 6
    //   1458: aload_2
    //   1459: astore_1
    //   1460: aload 7
    //   1462: astore_2
    //   1463: goto -1294 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1466	0	this	IdentificationPoseReflect
    //   0	1466	1	paramContext	android.content.Context
    //   0	1466	2	paramString	String
    //   560	28	3	i	int
    //   557	8	4	j	int
    //   880	130	5	bool	boolean
    //   22	1435	6	localObject1	Object
    //   1	149	7	str1	String
    //   162	5	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   222	1179	7	str2	String
    //   1406	42	7	localObject2	Object
    //   1453	8	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   43	1354	8	localObject3	Object
    //   52	912	9	localObject4	Object
    //   61	815	10	localObject5	Object
    //   137	440	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   133	139	162	java/io/FileNotFoundException
    //   151	159	162	java/io/FileNotFoundException
    //   224	231	162	java/io/FileNotFoundException
    //   243	251	162	java/io/FileNotFoundException
    //   348	365	162	java/io/FileNotFoundException
    //   372	379	162	java/io/FileNotFoundException
    //   386	396	162	java/io/FileNotFoundException
    //   403	412	162	java/io/FileNotFoundException
    //   424	432	162	java/io/FileNotFoundException
    //   522	531	162	java/io/FileNotFoundException
    //   538	547	162	java/io/FileNotFoundException
    //   554	559	162	java/io/FileNotFoundException
    //   574	584	162	java/io/FileNotFoundException
    //   598	608	162	java/io/FileNotFoundException
    //   615	630	162	java/io/FileNotFoundException
    //   637	659	162	java/io/FileNotFoundException
    //   666	674	162	java/io/FileNotFoundException
    //   681	689	162	java/io/FileNotFoundException
    //   696	723	162	java/io/FileNotFoundException
    //   730	757	162	java/io/FileNotFoundException
    //   764	811	162	java/io/FileNotFoundException
    //   818	835	162	java/io/FileNotFoundException
    //   842	848	162	java/io/FileNotFoundException
    //   860	868	162	java/io/FileNotFoundException
    //   875	882	162	java/io/FileNotFoundException
    //   894	902	162	java/io/FileNotFoundException
    //   909	916	162	java/io/FileNotFoundException
    //   923	928	162	java/io/FileNotFoundException
    //   935	941	162	java/io/FileNotFoundException
    //   948	972	162	java/io/FileNotFoundException
    //   979	988	162	java/io/FileNotFoundException
    //   133	139	254	java/io/IOException
    //   151	159	254	java/io/IOException
    //   224	231	254	java/io/IOException
    //   243	251	254	java/io/IOException
    //   348	365	254	java/io/IOException
    //   372	379	254	java/io/IOException
    //   386	396	254	java/io/IOException
    //   403	412	254	java/io/IOException
    //   424	432	254	java/io/IOException
    //   522	531	254	java/io/IOException
    //   538	547	254	java/io/IOException
    //   554	559	254	java/io/IOException
    //   574	584	254	java/io/IOException
    //   598	608	254	java/io/IOException
    //   615	630	254	java/io/IOException
    //   637	659	254	java/io/IOException
    //   666	674	254	java/io/IOException
    //   681	689	254	java/io/IOException
    //   696	723	254	java/io/IOException
    //   730	757	254	java/io/IOException
    //   764	811	254	java/io/IOException
    //   818	835	254	java/io/IOException
    //   842	848	254	java/io/IOException
    //   860	868	254	java/io/IOException
    //   875	882	254	java/io/IOException
    //   894	902	254	java/io/IOException
    //   909	916	254	java/io/IOException
    //   923	928	254	java/io/IOException
    //   935	941	254	java/io/IOException
    //   948	972	254	java/io/IOException
    //   979	988	254	java/io/IOException
    //   303	308	310	java/io/IOException
    //   445	450	452	java/io/IOException
    //   436	440	483	java/io/IOException
    //   992	996	1014	java/io/IOException
    //   1001	1006	1046	java/io/IOException
    //   201	205	1078	java/io/IOException
    //   210	215	1110	java/io/IOException
    //   294	298	1141	java/io/IOException
    //   63	94	1173	org/json/JSONException
    //   1228	1233	1235	java/io/IOException
    //   1219	1223	1266	java/io/IOException
    //   63	94	1298	finally
    //   1308	1312	1324	java/io/IOException
    //   1317	1322	1356	java/io/IOException
    //   94	126	1388	finally
    //   133	139	1395	finally
    //   151	159	1395	finally
    //   224	231	1395	finally
    //   243	251	1395	finally
    //   262	290	1395	finally
    //   348	365	1395	finally
    //   372	379	1395	finally
    //   386	396	1395	finally
    //   403	412	1395	finally
    //   424	432	1395	finally
    //   522	531	1395	finally
    //   538	547	1395	finally
    //   554	559	1395	finally
    //   574	584	1395	finally
    //   598	608	1395	finally
    //   615	630	1395	finally
    //   637	659	1395	finally
    //   666	674	1395	finally
    //   681	689	1395	finally
    //   696	723	1395	finally
    //   730	757	1395	finally
    //   764	811	1395	finally
    //   818	835	1395	finally
    //   842	848	1395	finally
    //   860	868	1395	finally
    //   875	882	1395	finally
    //   894	902	1395	finally
    //   909	916	1395	finally
    //   923	928	1395	finally
    //   935	941	1395	finally
    //   948	972	1395	finally
    //   979	988	1395	finally
    //   1186	1215	1395	finally
    //   169	197	1406	finally
    //   94	126	1416	org/json/JSONException
    //   133	139	1423	org/json/JSONException
    //   151	159	1423	org/json/JSONException
    //   224	231	1423	org/json/JSONException
    //   243	251	1423	org/json/JSONException
    //   348	365	1423	org/json/JSONException
    //   372	379	1423	org/json/JSONException
    //   386	396	1423	org/json/JSONException
    //   403	412	1423	org/json/JSONException
    //   424	432	1423	org/json/JSONException
    //   522	531	1423	org/json/JSONException
    //   538	547	1423	org/json/JSONException
    //   554	559	1423	org/json/JSONException
    //   574	584	1423	org/json/JSONException
    //   598	608	1423	org/json/JSONException
    //   615	630	1423	org/json/JSONException
    //   637	659	1423	org/json/JSONException
    //   666	674	1423	org/json/JSONException
    //   681	689	1423	org/json/JSONException
    //   696	723	1423	org/json/JSONException
    //   730	757	1423	org/json/JSONException
    //   764	811	1423	org/json/JSONException
    //   818	835	1423	org/json/JSONException
    //   842	848	1423	org/json/JSONException
    //   860	868	1423	org/json/JSONException
    //   875	882	1423	org/json/JSONException
    //   894	902	1423	org/json/JSONException
    //   909	916	1423	org/json/JSONException
    //   923	928	1423	org/json/JSONException
    //   935	941	1423	org/json/JSONException
    //   948	972	1423	org/json/JSONException
    //   979	988	1423	org/json/JSONException
    //   63	94	1427	java/io/IOException
    //   94	126	1436	java/io/IOException
    //   63	94	1443	java/io/FileNotFoundException
    //   94	126	1453	java/io/FileNotFoundException
  }
  
  public void a()
  {
    super.a();
    YtSDKKitFramework.getInstance().deInit();
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    Object localObject;
    int k;
    int i;
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new IdentificationPoseReflect.1(this, paramActivity));
      localObject = CameraControl.a().jdField_a_of_type_AndroidHardwareCamera;
      k = CameraControl.a().jdField_a_of_type_Int;
      i = -1;
    }
    try
    {
      int j = YtCameraSetting.initCamera(paramActivity.getApplicationContext(), (Camera)localObject, k);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera error : ", localException.getMessage() });
      }
      YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
      localYtSDKPlatformContext.currentCamera = ((Camera)localObject);
      localYtSDKPlatformContext.currentCameraId = k;
      localYtSDKPlatformContext.currentRotateState = YtCameraSetting.getRotate(BaseApplicationImpl.getApplication(), k, 1);
      localYtSDKPlatformContext.reflectLayout = null;
      localYtSDKPlatformContext.reflectListener = new IdentificationPoseReflect.3(this);
      localYtSDKPlatformContext.currentAppContext = paramActivity.getApplicationContext();
      localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
      JSONObject localJSONObject = YtSDKKit.a().a(5);
      ArrayList localArrayList = YtSDKKitConfigHelper.getPipleStateNames((YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject);
      if ((localArrayList != null) && (localJSONObject != null)) {
        break label273;
      }
      if (!(paramActivity instanceof QQIdentiferActivity)) {
        break label263;
      }
      a(new IdentificationPoseReflect.4(this, paramActivity));
      QLog.e("qq_Identification.Model", 1, "initSdkResult stateNames == null || sdkConfig == null");
      return;
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContext, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new IdentificationPoseReflect.5(this))) });
    }
    QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera result : ", Integer.valueOf(i) });
    if (i != 0)
    {
      new HashMap().put("process_action", "failed");
      if ((paramActivity instanceof QQIdentiferActivity)) {
        a(new IdentificationPoseReflect.2(this, paramActivity));
      }
      return;
    }
    label263:
    label273:
    return;
  }
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("qq_Identification.Model", 1, "initLoadSo error : so path is empty");
      return false;
    }
    try
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramArrayOfString[i];
          System.load(paramString + (String)localObject);
          i += 1;
        }
        QLog.d("qq_Identification.Model", 1, "init load so success");
        return true;
      }
      QLog.e("qq_Identification.Model", 1, new Object[] { "init load so, soDir is not exists, so path : ", localObject });
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so Exception : " + paramString.getMessage());
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so UnsatisfiedLinkError : " + paramString.getMessage());
    }
    return false;
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    try
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        System.loadLibrary(str);
        QLog.d("qq_Identification.Model", 1, "init load lib" + str + ".so success");
        i += 1;
      }
      QLog.d("qq_Identification.Model", 1, "init load so success");
      return true;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so Exception : " + paramArrayOfString.getMessage());
      return false;
    }
    catch (UnsatisfiedLinkError paramArrayOfString)
    {
      for (;;)
      {
        QLog.e("qq_Identification.Model", 1, "System.load so UnsatisfiedLinkError : " + paramArrayOfString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect
 * JD-Core Version:    0.7.0.1
 */