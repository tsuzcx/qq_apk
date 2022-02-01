package cooperation.qlink;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QlinkShareJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private String b = HardCodeUtil.a(2131709978);
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	cooperation/qlink/QlinkShareJumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 59	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +39 -> 59
    //   23: aload 7
    //   25: astore 6
    //   27: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +15 -> 45
    //   33: aload 7
    //   35: astore 6
    //   37: ldc 67
    //   39: iconst_2
    //   40: ldc 69
    //   42: invokestatic 73	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload 7
    //   47: ifnull +10 -> 57
    //   50: aload 7
    //   52: invokeinterface 78 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: aload 7
    //   61: astore 6
    //   63: aload 7
    //   65: ldc 80
    //   67: invokeinterface 84 2 0
    //   72: istore_2
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: ldc 86
    //   81: invokeinterface 89 2 0
    //   86: istore_3
    //   87: aload 7
    //   89: astore 6
    //   91: aload 7
    //   93: invokeinterface 92 1 0
    //   98: pop
    //   99: aload 7
    //   101: astore 6
    //   103: aload 7
    //   105: iload_3
    //   106: invokeinterface 96 2 0
    //   111: lstore 4
    //   113: aload 7
    //   115: astore 6
    //   117: lload 4
    //   119: l2f
    //   120: invokestatic 102	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   123: fcmpl
    //   124: ifle +31 -> 155
    //   127: aload 7
    //   129: astore 6
    //   131: aload_0
    //   132: aload_0
    //   133: ldc 103
    //   135: invokevirtual 106	cooperation/qlink/QlinkShareJumpActivity:getString	(I)Ljava/lang/String;
    //   138: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   141: aload 7
    //   143: ifnull +10 -> 153
    //   146: aload 7
    //   148: invokeinterface 78 1 0
    //   153: aconst_null
    //   154: areturn
    //   155: aload 7
    //   157: astore 6
    //   159: aload 7
    //   161: iload_2
    //   162: invokeinterface 107 2 0
    //   167: astore 9
    //   169: aload 7
    //   171: astore 6
    //   173: new 109	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   180: astore 10
    //   182: aload 7
    //   184: astore 6
    //   186: aload 10
    //   188: aload_0
    //   189: invokevirtual 114	cooperation/qlink/QlinkShareJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   192: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 7
    //   198: astore 6
    //   200: aload 10
    //   202: ldc 120
    //   204: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 7
    //   210: astore 6
    //   212: aload 10
    //   214: ldc 125
    //   216: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: astore 6
    //   224: aload 10
    //   226: ldc 120
    //   228: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 7
    //   234: astore 6
    //   236: aload 10
    //   238: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 10
    //   243: aload 7
    //   245: astore 6
    //   247: aload 10
    //   249: invokestatic 132	cooperation/qlink/QlinkShareJumpActivity:a	(Ljava/lang/String;)V
    //   252: aload 7
    //   254: astore 6
    //   256: new 109	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   263: astore 11
    //   265: aload 7
    //   267: astore 6
    //   269: aload 11
    //   271: aload 10
    //   273: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 7
    //   279: astore 6
    //   281: aload 11
    //   283: aload 10
    //   285: iconst_1
    //   286: anewarray 134	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: aload 9
    //   293: aastore
    //   294: iconst_0
    //   295: aaload
    //   296: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 7
    //   305: astore 6
    //   307: aload 11
    //   309: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 9
    //   314: aload 7
    //   316: astore 6
    //   318: new 140	java/io/File
    //   321: dup
    //   322: aload 10
    //   324: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   327: astore 10
    //   329: aload 7
    //   331: astore 6
    //   333: aload 10
    //   335: invokevirtual 145	java/io/File:exists	()Z
    //   338: ifne +42 -> 380
    //   341: aload 7
    //   343: astore 6
    //   345: aload 10
    //   347: invokevirtual 148	java/io/File:mkdirs	()Z
    //   350: ifne +30 -> 380
    //   353: aload 7
    //   355: astore 6
    //   357: aload_0
    //   358: ldc 149
    //   360: invokestatic 25	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   363: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   366: aload 7
    //   368: ifnull +10 -> 378
    //   371: aload 7
    //   373: invokeinterface 78 1 0
    //   378: aconst_null
    //   379: areturn
    //   380: aload 7
    //   382: astore 6
    //   384: aload 8
    //   386: aload_1
    //   387: invokevirtual 153	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   390: astore_1
    //   391: aload_1
    //   392: ifnonnull +52 -> 444
    //   395: aload 7
    //   397: astore 6
    //   399: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +15 -> 417
    //   405: aload 7
    //   407: astore 6
    //   409: ldc 67
    //   411: iconst_2
    //   412: ldc 155
    //   414: invokestatic 73	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload 7
    //   419: astore 6
    //   421: aload_0
    //   422: ldc 156
    //   424: invokestatic 25	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   427: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   430: aload 7
    //   432: ifnull +10 -> 442
    //   435: aload 7
    //   437: invokeinterface 78 1 0
    //   442: aconst_null
    //   443: areturn
    //   444: lload 4
    //   446: ldc2_w 157
    //   449: lcmp
    //   450: ifle +38 -> 488
    //   453: aload 7
    //   455: astore 6
    //   457: aload_0
    //   458: ldc 159
    //   460: invokestatic 25	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   463: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   466: aload 7
    //   468: astore 6
    //   470: aload_1
    //   471: invokevirtual 162	java/io/InputStream:close	()V
    //   474: aload 7
    //   476: ifnull +10 -> 486
    //   479: aload 7
    //   481: invokeinterface 78 1 0
    //   486: aconst_null
    //   487: areturn
    //   488: aload 7
    //   490: astore 6
    //   492: aload_0
    //   493: aload 9
    //   495: aload_1
    //   496: lload 4
    //   498: invokespecial 165	cooperation/qlink/QlinkShareJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   501: aload 7
    //   503: ifnull +10 -> 513
    //   506: aload 7
    //   508: invokeinterface 78 1 0
    //   513: aload 9
    //   515: areturn
    //   516: astore 6
    //   518: aload 7
    //   520: astore_1
    //   521: aload 6
    //   523: astore 7
    //   525: goto +14 -> 539
    //   528: astore_1
    //   529: aconst_null
    //   530: astore 6
    //   532: goto +50 -> 582
    //   535: astore 7
    //   537: aconst_null
    //   538: astore_1
    //   539: aload_1
    //   540: astore 6
    //   542: aload_0
    //   543: iconst_0
    //   544: putfield 167	cooperation/qlink/QlinkShareJumpActivity:jdField_a_of_type_Boolean	Z
    //   547: aload_1
    //   548: astore 6
    //   550: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +16 -> 569
    //   556: aload_1
    //   557: astore 6
    //   559: ldc 67
    //   561: iconst_2
    //   562: ldc 169
    //   564: aload 7
    //   566: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   569: aload_1
    //   570: ifnull +9 -> 579
    //   573: aload_1
    //   574: invokeinterface 78 1 0
    //   579: aconst_null
    //   580: areturn
    //   581: astore_1
    //   582: aload 6
    //   584: ifnull +10 -> 594
    //   587: aload 6
    //   589: invokeinterface 78 1 0
    //   594: aload_1
    //   595: athrow
    //   596: astore_1
    //   597: goto -123 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	QlinkShareJumpActivity
    //   0	600	1	paramUri	Uri
    //   72	90	2	i	int
    //   86	20	3	j	int
    //   111	386	4	l	long
    //   25	466	6	localObject1	Object
    //   516	6	6	localException1	Exception
    //   530	58	6	localUri	Uri
    //   16	508	7	localObject2	Object
    //   535	30	7	localException2	Exception
    //   4	381	8	localContentResolver	android.content.ContentResolver
    //   167	347	9	str	String
    //   180	166	10	localObject3	Object
    //   263	45	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	33	516	java/lang/Exception
    //   37	45	516	java/lang/Exception
    //   63	73	516	java/lang/Exception
    //   77	87	516	java/lang/Exception
    //   91	99	516	java/lang/Exception
    //   103	113	516	java/lang/Exception
    //   117	127	516	java/lang/Exception
    //   131	141	516	java/lang/Exception
    //   159	169	516	java/lang/Exception
    //   173	182	516	java/lang/Exception
    //   186	196	516	java/lang/Exception
    //   200	208	516	java/lang/Exception
    //   212	220	516	java/lang/Exception
    //   224	232	516	java/lang/Exception
    //   236	243	516	java/lang/Exception
    //   247	252	516	java/lang/Exception
    //   256	265	516	java/lang/Exception
    //   269	277	516	java/lang/Exception
    //   281	303	516	java/lang/Exception
    //   307	314	516	java/lang/Exception
    //   318	329	516	java/lang/Exception
    //   333	341	516	java/lang/Exception
    //   345	353	516	java/lang/Exception
    //   357	366	516	java/lang/Exception
    //   384	391	516	java/lang/Exception
    //   399	405	516	java/lang/Exception
    //   409	417	516	java/lang/Exception
    //   421	430	516	java/lang/Exception
    //   457	466	516	java/lang/Exception
    //   492	501	516	java/lang/Exception
    //   6	18	528	finally
    //   6	18	535	java/lang/Exception
    //   27	33	581	finally
    //   37	45	581	finally
    //   63	73	581	finally
    //   77	87	581	finally
    //   91	99	581	finally
    //   103	113	581	finally
    //   117	127	581	finally
    //   131	141	581	finally
    //   159	169	581	finally
    //   173	182	581	finally
    //   186	196	581	finally
    //   200	208	581	finally
    //   212	220	581	finally
    //   224	232	581	finally
    //   236	243	581	finally
    //   247	252	581	finally
    //   256	265	581	finally
    //   269	277	581	finally
    //   281	303	581	finally
    //   307	314	581	finally
    //   318	329	581	finally
    //   333	341	581	finally
    //   345	353	581	finally
    //   357	366	581	finally
    //   384	391	581	finally
    //   399	405	581	finally
    //   409	417	581	finally
    //   421	430	581	finally
    //   457	466	581	finally
    //   470	474	581	finally
    //   492	501	581	finally
    //   542	547	581	finally
    //   550	556	581	finally
    //   559	569	581	finally
    //   470	474	596	java/lang/Exception
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    int j = 0;
    int i = 0;
    if (localObject1 == null)
    {
      a(false);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND");
    int k = 1;
    Object localObject2;
    if (bool1)
    {
      localObject2 = (Uri)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject2 != null)
      {
        localObject1 = b((Uri)localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (FileUtil.b((String)localObject1)) && (new File((String)localObject1).canRead()))
        {
          i = 0;
        }
        else
        {
          localObject1 = a((Uri)localObject2);
          i = k;
        }
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localArrayList.add(localObject1);
          j = i;
        }
      }
      else
      {
        j = 0;
      }
      i = j;
    }
    else
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        bool1 = false;
        for (;;)
        {
          i = j;
          bool2 = bool1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = b((Uri)((Iterator)localObject1).next());
          if (FileUtil.b((String)localObject2)) {
            localArrayList.add(localObject2);
          } else {
            bool1 = true;
          }
        }
      }
    }
    boolean bool2 = false;
    if (localArrayList.size() == 0)
    {
      a(bool2);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    if (i == 0) {
      b();
    }
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
        localObject.delete();
      }
      i += 1;
    }
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QlinkShareJumpActivity.5(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131691299), HardCodeUtil.a(2131709981), new QlinkShareJumpActivity.6(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new QlinkShareJumpActivity.7(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131698443;
    } else {
      i = 2131698444;
    }
    String str = getString(i);
    DialogUtil.a(this, 230, getString(2131698399), str, 2131698392, 2131698392, new QlinkShareJumpActivity.2(this), null).show();
  }
  
  private boolean a()
  {
    Intent localIntent1 = getIntent();
    if (localIntent1.getExtras() == null) {
      new Bundle();
    }
    if (!this.app.isLogin())
    {
      Intent localIntent2 = new Intent();
      localIntent2.addFlags(67371008);
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        localIntent1.putStringArrayListExtra("qlink_share_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      }
      localIntent2.putExtra("qlink_share_intent_data", localIntent1);
      localIntent2.putExtra("from_register_guide", true);
      RouteUtils.a(this, localIntent2, "/base/login");
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && ((paramBoolean) || (!GesturePWDUtils.getAppForground(this))))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 4097);
      return true;
    }
    return false;
  }
  
  private String b(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this, paramUri);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 50)
    {
      DialogUtil.a(this, 230, getString(2131698399), getString(2131698403), 2131698392, 2131698392, new QlinkShareJumpActivity.3(this), null).show();
      return;
    }
    if (a()) {
      return;
    }
    if (a(false)) {
      return;
    }
    d();
  }
  
  private void b(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(getString(2131719632));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131690706), new QlinkShareJumpActivity.4(this));
    localQQCustomDialog.show();
  }
  
  private void c()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.app.getQQProxyForQlink().a("0X8004F47", this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
      ((Bundle)localObject).putInt("string_beforeshare_selectedfile_count", localArrayList.size());
      QQProxyForQlink.a(this, 10, (Bundle)localObject);
      finish();
      return;
    }
    DialogUtil.a(this, 230, getString(2131698399), getString(2131698444), 2131698392, 2131698392, new QlinkShareJumpActivity.8(this), null).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 4097)
      {
        d();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramBundle.getAction();
        this.jdField_a_of_type_AndroidOsBundle = paramBundle.getExtras();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND")) || (this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND_MULTIPLE"))))
        {
          if (paramBundle.getBooleanExtra("qlink_share_login_suc_flag", false))
          {
            paramBundle = paramBundle.getStringArrayListExtra("qlink_share_filepaths");
            if ((paramBundle != null) && (paramBundle.size() > 0))
            {
              paramBundle = paramBundle.iterator();
              while (paramBundle.hasNext())
              {
                String str = (String)paramBundle.next();
                if (FileUtil.b(str))
                {
                  if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(str);
                }
              }
            }
            if (!a(true))
            {
              d();
              return true;
            }
          }
          else
          {
            a();
          }
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        DialogUtil.a(this, 230, getString(2131698399), getString(2131698444), 2131698392, 2131698392, new QlinkShareJumpActivity.1(this), null).show();
        return false;
      }
    }
    finish();
    overridePendingTransition(0, 0);
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
        }
      }
      else
      {
        c();
        b();
      }
    }
    else
    {
      c();
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
        paramMessage = (String)paramMessage.obj;
      } else {
        paramMessage = null;
      }
      Object localObject = paramMessage;
      if (TextUtils.isEmpty(paramMessage)) {
        localObject = this.b;
      }
      b((String)localObject);
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity
 * JD-Core Version:    0.7.0.1
 */