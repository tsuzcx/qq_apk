package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aoed;
import aoee;
import aoeg;
import aoeh;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader.IQIMWebVideoUpCallback;
import com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame;
import com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class EditWebVideoHallowenUpload
  implements QIMWebVideoUploader.IQIMWebVideoUpCallback, QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback, EncodeVideoTask.ResultListener, Runnable
{
  public static Handler a;
  private double jdField_a_of_type_Double;
  public int a;
  public Activity a;
  private EditWebVideoHallowenUpload.Listener jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload$Listener;
  private EncodeVideoTask.ResultListener jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  public Runnable a;
  public String a;
  public WeakReference a;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private double jdField_b_of_type_Double;
  public int b;
  public String b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  public String c;
  private final int d;
  public String d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public EditWebVideoHallowenUpload(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, EditWebVideoHallowenUpload.Listener paramListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = this;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload$Listener = paramListener;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public EditWebVideoHallowenUpload(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, EditWebVideoHallowenUpload.Listener paramListener, String paramString1, String paramString2)
  {
    this(paramActivity, paramQQAppInterface, paramBoolean, paramInt, paramListener);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  /* Error */
  private int a(PublishParam paramPublishParam)
  {
    // Byte code:
    //   0: new 85	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData
    //   3: dup
    //   4: invokespecial 86	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:<init>	()V
    //   7: astore 11
    //   9: new 88	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 93	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   17: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: astore 15
    //   28: aload_1
    //   29: getfield 106	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore 14
    //   34: aload_1
    //   35: getfield 93	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   38: astore 12
    //   40: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 114
    //   48: iconst_2
    //   49: new 116	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   56: ldc 119
    //   58: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 15
    //   63: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   75: lstore 7
    //   77: aload_0
    //   78: new 138	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo
    //   81: dup
    //   82: invokespecial 139	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:<init>	()V
    //   85: putfield 141	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Ldov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   88: aload 12
    //   90: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   93: ifne +23 -> 116
    //   96: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +11 -> 110
    //   102: ldc 114
    //   104: iconst_2
    //   105: ldc 148
    //   107: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: sipush -300
    //   113: istore_2
    //   114: iload_2
    //   115: ireturn
    //   116: aload 14
    //   118: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   121: ifne +21 -> 142
    //   124: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +11 -> 138
    //   130: ldc 114
    //   132: iconst_2
    //   133: ldc 150
    //   135: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: sipush -301
    //   141: ireturn
    //   142: aload 12
    //   144: aload 11
    //   146: invokestatic 155	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils:a	(Ljava/lang/String;Ldov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData;)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifeq +38 -> 189
    //   154: iload_3
    //   155: istore_2
    //   156: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq -45 -> 114
    //   162: ldc 114
    //   164: iconst_2
    //   165: new 116	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   172: ldc 157
    //   174: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_3
    //   178: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload_3
    //   188: ireturn
    //   189: aload 11
    //   191: getfield 163	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   194: iconst_3
    //   195: iaload
    //   196: sipush 500
    //   199: iadd
    //   200: sipush 1000
    //   203: idiv
    //   204: istore 5
    //   206: aload 11
    //   208: getfield 163	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   211: iconst_2
    //   212: iaload
    //   213: istore 6
    //   215: aload 11
    //   217: getfield 163	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   220: iconst_0
    //   221: iaload
    //   222: istore_3
    //   223: aload 11
    //   225: getfield 163	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   228: iconst_1
    //   229: iaload
    //   230: istore 4
    //   232: iload 6
    //   234: bipush 90
    //   236: if_icmpeq +14 -> 250
    //   239: iload 4
    //   241: istore_2
    //   242: iload 6
    //   244: sipush 270
    //   247: if_icmpne +14 -> 261
    //   250: aload 11
    //   252: getfield 163	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   255: iconst_0
    //   256: iaload
    //   257: istore_2
    //   258: iload 4
    //   260: istore_3
    //   261: aload 14
    //   263: aload_0
    //   264: getfield 165	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_Double	D
    //   267: aload_0
    //   268: getfield 167	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_b_of_type_Double	D
    //   271: invokestatic 172	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   274: pop
    //   275: new 88	java/io/File
    //   278: dup
    //   279: aload 14
    //   281: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: astore 11
    //   286: new 174	java/io/FileInputStream
    //   289: dup
    //   290: aload 14
    //   292: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   295: astore 12
    //   297: aload 12
    //   299: aload 11
    //   301: invokevirtual 178	java/io/File:length	()J
    //   304: invokestatic 184	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   307: astore 11
    //   309: aload 11
    //   311: invokestatic 190	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   314: astore 13
    //   316: aload 12
    //   318: ifnull +8 -> 326
    //   321: aload 12
    //   323: invokevirtual 193	java/io/FileInputStream:close	()V
    //   326: aload 13
    //   328: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifeq +45 -> 376
    //   334: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +11 -> 348
    //   340: ldc 114
    //   342: iconst_2
    //   343: ldc 201
    //   345: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: sipush -302
    //   351: ireturn
    //   352: astore 11
    //   354: aconst_null
    //   355: astore 12
    //   357: aconst_null
    //   358: astore 11
    //   360: aconst_null
    //   361: astore 13
    //   363: goto -47 -> 316
    //   366: astore 12
    //   368: aload 12
    //   370: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   373: goto -47 -> 326
    //   376: aload 13
    //   378: ldc 206
    //   380: invokestatic 211	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 12
    //   385: aload 14
    //   387: aload 12
    //   389: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   392: ifeq +199 -> 591
    //   395: aload_1
    //   396: getfield 217	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:f	I
    //   399: iconst_5
    //   400: if_icmpgt +246 -> 646
    //   403: aload_1
    //   404: getfield 217	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:f	I
    //   407: istore 4
    //   409: new 116	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   416: aload 15
    //   418: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: getstatic 220	java/io/File:separator	Ljava/lang/String;
    //   424: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 222
    //   429: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: astore 13
    //   437: aconst_null
    //   438: aconst_null
    //   439: iload 4
    //   441: invokestatic 227	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   444: astore 14
    //   446: aload 14
    //   448: aload 13
    //   450: putfield 230	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   453: aload 14
    //   455: aload_1
    //   456: getfield 233	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:k	Ljava/lang/String;
    //   459: putfield 234	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   462: aload_1
    //   463: getfield 233	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:k	Ljava/lang/String;
    //   466: invokestatic 237	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;)I
    //   469: istore 4
    //   471: iload 4
    //   473: ifeq +179 -> 652
    //   476: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +29 -> 508
    //   482: ldc 114
    //   484: iconst_2
    //   485: new 116	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   492: ldc 239
    //   494: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 4
    //   499: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +38 -> 549
    //   514: ldc 114
    //   516: iconst_2
    //   517: new 116	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   524: ldc 241
    //   526: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   532: lload 7
    //   534: lsub
    //   535: l2d
    //   536: ldc2_w 242
    //   539: ddiv
    //   540: invokevirtual 246	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   543: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: aload_0
    //   550: getfield 141	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Ldov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   553: aload 12
    //   555: putfield 247	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   558: aload_0
    //   559: getfield 141	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Ldov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   562: aload 11
    //   564: putfield 249	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   567: aload_0
    //   568: getfield 141	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Ldov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   571: iload_3
    //   572: putfield 251	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_Int	I
    //   575: aload_0
    //   576: getfield 141	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Ldov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   579: iload_2
    //   580: putfield 252	dov/com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_b_of_type_Int	I
    //   583: aload_0
    //   584: iload 5
    //   586: putfield 253	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload:jdField_a_of_type_Int	I
    //   589: iconst_0
    //   590: ireturn
    //   591: aload 12
    //   593: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   596: ifne +164 -> 760
    //   599: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +40 -> 642
    //   605: ldc 114
    //   607: iconst_2
    //   608: new 116	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   615: ldc 255
    //   617: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 14
    //   622: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 257
    //   628: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 12
    //   633: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: sipush -301
    //   645: ireturn
    //   646: iconst_0
    //   647: istore 4
    //   649: goto -240 -> 409
    //   652: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   655: lstore 9
    //   657: aload 14
    //   659: invokestatic 260	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;)I
    //   662: istore 4
    //   664: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq +39 -> 706
    //   670: ldc 114
    //   672: iconst_2
    //   673: new 116	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 262
    //   683: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   689: lload 9
    //   691: lsub
    //   692: l2d
    //   693: ldc2_w 242
    //   696: ddiv
    //   697: invokevirtual 246	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   700: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: iload 4
    //   708: ifeq -200 -> 508
    //   711: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +30 -> 744
    //   717: ldc 114
    //   719: iconst_2
    //   720: new 116	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 264
    //   730: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: iload 4
    //   735: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: iload 4
    //   746: ireturn
    //   747: astore 11
    //   749: aconst_null
    //   750: astore 11
    //   752: goto -392 -> 360
    //   755: astore 13
    //   757: goto -397 -> 360
    //   760: aload 14
    //   762: astore 12
    //   764: goto -369 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	767	0	this	EditWebVideoHallowenUpload
    //   0	767	1	paramPublishParam	PublishParam
    //   113	467	2	i	int
    //   149	423	3	j	int
    //   230	515	4	k	int
    //   204	381	5	m	int
    //   213	35	6	n	int
    //   75	458	7	l1	long
    //   655	35	9	l2	long
    //   7	303	11	localObject1	Object
    //   352	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   358	205	11	localObject2	Object
    //   747	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   750	1	11	localObject3	Object
    //   38	318	12	localObject4	Object
    //   366	3	12	localIOException	java.io.IOException
    //   383	380	12	localObject5	Object
    //   314	135	13	str1	String
    //   755	1	13	localFileNotFoundException3	java.io.FileNotFoundException
    //   32	729	14	localObject6	Object
    //   26	391	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   286	297	352	java/io/FileNotFoundException
    //   321	326	366	java/io/IOException
    //   297	309	747	java/io/FileNotFoundException
    //   309	316	755	java/io/FileNotFoundException
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoUploadRunnable", 2, "jumpToH5Activity, uid:" + paramString1 + ", md5:" + paramString2);
    }
    jdField_a_of_type_AndroidOsHandler.post(new aoed(this, paramBoolean, paramString1, paramString2));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: invokestatic 296	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 300	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   8: ifeq +240 -> 248
    //   11: ldc_w 302
    //   14: iconst_0
    //   15: invokestatic 308	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   18: new 310	aoef
    //   21: dup
    //   22: aload_0
    //   23: aload 10
    //   25: invokespecial 313	aoef:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/EditWebVideoHallowenUpload;Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   28: invokevirtual 318	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   31: invokestatic 300	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   34: ifeq +213 -> 247
    //   37: lconst_0
    //   38: lstore 6
    //   40: aload 10
    //   42: getfield 321	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: astore 9
    //   47: aload 9
    //   49: monitorenter
    //   50: aload 10
    //   52: getfield 321	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: invokevirtual 326	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   58: istore 8
    //   60: lload 6
    //   62: lstore 4
    //   64: iload 8
    //   66: ifne +106 -> 172
    //   69: lload 6
    //   71: lstore_2
    //   72: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +16 -> 91
    //   78: lload 6
    //   80: lstore_2
    //   81: ldc_w 328
    //   84: iconst_2
    //   85: ldc_w 330
    //   88: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: lload 6
    //   93: lstore_2
    //   94: invokestatic 335	android/os/SystemClock:elapsedRealtime	()J
    //   97: lstore 4
    //   99: lload 6
    //   101: lstore_2
    //   102: aload 10
    //   104: getfield 321	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   107: ldc2_w 336
    //   110: invokevirtual 341	java/lang/Object:wait	(J)V
    //   113: lload 6
    //   115: lstore_2
    //   116: invokestatic 335	android/os/SystemClock:elapsedRealtime	()J
    //   119: lload 4
    //   121: lsub
    //   122: lstore 6
    //   124: lload 6
    //   126: lstore 4
    //   128: lload 6
    //   130: lstore_2
    //   131: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +38 -> 172
    //   137: lload 6
    //   139: lstore_2
    //   140: ldc_w 328
    //   143: iconst_2
    //   144: new 116	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 343
    //   154: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: lload 6
    //   159: invokevirtual 346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: lload 6
    //   170: lstore 4
    //   172: aload 9
    //   174: monitorexit
    //   175: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +13 -> 191
    //   181: ldc_w 328
    //   184: iconst_2
    //   185: ldc_w 348
    //   188: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: lload 4
    //   193: ldc2_w 349
    //   196: lcmp
    //   197: ifge +50 -> 247
    //   200: bipush 30
    //   202: lload 4
    //   204: l2i
    //   205: isub
    //   206: istore_1
    //   207: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +30 -> 240
    //   213: ldc_w 328
    //   216: iconst_2
    //   217: new 116	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 352
    //   227: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_1
    //   231: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload_1
    //   241: i2l
    //   242: lstore_2
    //   243: lload_2
    //   244: invokestatic 357	java/lang/Thread:sleep	(J)V
    //   247: return
    //   248: invokestatic 362	dov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Ldov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   251: invokevirtual 365	dov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   254: invokevirtual 371	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   257: pop
    //   258: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq -230 -> 31
    //   264: ldc_w 328
    //   267: iconst_2
    //   268: ldc_w 373
    //   271: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto -243 -> 31
    //   277: astore 9
    //   279: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +13 -> 295
    //   285: ldc_w 328
    //   288: iconst_2
    //   289: ldc_w 375
    //   292: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 9
    //   297: invokevirtual 376	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   300: goto -269 -> 31
    //   303: astore 10
    //   305: lload_2
    //   306: lstore 4
    //   308: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -139 -> 172
    //   314: ldc_w 328
    //   317: iconst_2
    //   318: ldc_w 378
    //   321: aload 10
    //   323: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   326: lload_2
    //   327: lstore 4
    //   329: goto -157 -> 172
    //   332: astore 10
    //   334: aload 9
    //   336: monitorexit
    //   337: aload 10
    //   339: athrow
    //   340: astore 9
    //   342: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -98 -> 247
    //   348: ldc_w 328
    //   351: iconst_2
    //   352: ldc_w 383
    //   355: aload 9
    //   357: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   360: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	EditWebVideoHallowenUpload
    //   206	35	1	i	int
    //   71	256	2	l1	long
    //   62	266	4	l2	long
    //   38	131	6	l3	long
    //   58	7	8	bool	boolean
    //   45	128	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   277	58	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   340	16	9	localInterruptedException1	java.lang.InterruptedException
    //   3	100	10	localRMVideoStateMgr	dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   303	19	10	localInterruptedException2	java.lang.InterruptedException
    //   332	6	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   248	274	277	java/lang/UnsatisfiedLinkError
    //   72	78	303	java/lang/InterruptedException
    //   81	91	303	java/lang/InterruptedException
    //   94	99	303	java/lang/InterruptedException
    //   102	113	303	java/lang/InterruptedException
    //   116	124	303	java/lang/InterruptedException
    //   131	137	303	java/lang/InterruptedException
    //   140	168	303	java/lang/InterruptedException
    //   50	60	332	finally
    //   72	78	332	finally
    //   81	91	332	finally
    //   94	99	332	finally
    //   102	113	332	finally
    //   116	124	332	finally
    //   131	137	332	finally
    //   140	168	332	finally
    //   172	175	332	finally
    //   308	326	332	finally
    //   334	337	332	finally
    //   243	247	340	java/lang/InterruptedException
  }
  
  public void a()
  {
    String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    QLog.d("EditWebVideoUploadRunnable", 1, "onPicUploadSuccess uuid " + this.jdField_e_of_type_JavaLangString + " md5 " + str);
    a(true, this.jdField_e_of_type_JavaLangString, str);
    jdField_a_of_type_AndroidOsHandler.post(new aoeg(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload$Listener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload$Listener.b();
    }
  }
  
  public void a(Activity paramActivity, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam)
  {
    ThreadManager.post(new aoee(this, paramEditSource, paramPublishParam, paramActivity), 5, null, true);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    String str3 = BaseApplicationImpl.sApplication.waitAppRuntime(null).getAccount();
    String str4 = ContactUtils.j((QQAppInterface)BaseApplicationImpl.sApplication.waitAppRuntime(null), str3);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = "http://qvq.qq.com/halloween/view.html?_wv=16777217&_wwv=12";
      if (this.jdField_d_of_type_Int == FlowCameraConstant.jdField_c_of_type_Int) {
        str1 = "http://qvq.qq.com/singleday/view.html?_wv=16777217&_wwv=12";
      }
    }
    localIntent.putExtra("url", String.format("%s&md5=%s&uuid=%s&id=%s&name=%s&st=%d", new Object[] { str1, paramString2, paramString1, str3, str4, Integer.valueOf(this.jdField_d_of_type_Int) }));
    paramActivity.startActivityForResult(localIntent, 0);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, boolean paramBoolean)
  {
    QLog.d("EditWebVideoUploadRunnable", 1, "videoPath = " + paramString1);
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_d_of_type_JavaLangString = paramString2;
    paramString2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString2 != null) {
      new QIMWebVideoUploader(paramString2, this, paramString1, paramArrayOfByte1, this.jdField_d_of_type_Int, this.jdField_a_of_type_Boolean).a();
    }
  }
  
  public void b()
  {
    new QIMWebVideoUploaderFirstFrame((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_JavaLangString).a();
  }
  
  public void b(int paramInt, String paramString)
  {
    QLog.d("EditWebVideoUploadRunnable", 1, "onPicUploadFailed erroCode " + paramInt + " erroDes " + paramString);
    a(false, "", "");
    jdField_a_of_type_AndroidOsHandler.post(new aoeh(this));
  }
  
  public void d_(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    b();
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoHallowenUpload
 * JD-Core Version:    0.7.0.1
 */