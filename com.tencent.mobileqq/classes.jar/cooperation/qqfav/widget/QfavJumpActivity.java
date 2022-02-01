package cooperation.qqfav.widget;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import anzj;
import aofl;
import bhlq;
import bhnh;
import bhpc;
import blha;
import bmmr;
import bmms;
import bmmt;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.io.InputStream;
import mqq.os.MqqHandler;

public class QfavJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  protected static String a;
  private aofl jdField_a_of_type_Aofl;
  private bhpc jdField_a_of_type_Bhpc;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private String a(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	cooperation/qqfav/widget/QfavJumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +33 -> 53
    //   23: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 52
    //   31: iconst_2
    //   32: ldc 54
    //   34: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload 6
    //   39: ifnull +10 -> 49
    //   42: aload 6
    //   44: invokeinterface 63 1 0
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: aload 6
    //   55: ldc 65
    //   57: invokeinterface 69 2 0
    //   62: istore_2
    //   63: aload 6
    //   65: ldc 71
    //   67: invokeinterface 74 2 0
    //   72: istore_3
    //   73: aload 6
    //   75: invokeinterface 77 1 0
    //   80: pop
    //   81: aload 6
    //   83: iload_3
    //   84: invokeinterface 81 2 0
    //   89: lstore 4
    //   91: lload 4
    //   93: l2f
    //   94: invokestatic 87	bhmi:c	()F
    //   97: fcmpl
    //   98: ifle +26 -> 124
    //   101: aload_0
    //   102: ldc 88
    //   104: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   107: putstatic 94	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: aload 6
    //   112: ifnull +10 -> 122
    //   115: aload 6
    //   117: invokeinterface 63 1 0
    //   122: aconst_null
    //   123: areturn
    //   124: aload 6
    //   126: iload_2
    //   127: invokeinterface 95 2 0
    //   132: astore 9
    //   134: aload_0
    //   135: invokevirtual 99	cooperation/qqfav/widget/QfavJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   138: astore 7
    //   140: aload 7
    //   142: ifnull +148 -> 290
    //   145: new 101	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   152: aload 7
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc 108
    //   159: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 7
    //   167: new 101	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   174: aload 7
    //   176: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 117
    //   181: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 119
    //   186: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 117
    //   191: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 10
    //   199: aload 10
    //   201: invokestatic 122	cooperation/qqfav/widget/QfavJumpActivity:b	(Ljava/lang/String;)V
    //   204: new 101	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   211: aload 10
    //   213: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 10
    //   218: iconst_1
    //   219: anewarray 124	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: aload 9
    //   226: aastore
    //   227: iconst_0
    //   228: aaload
    //   229: invokestatic 127	bhmi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore 7
    //   240: new 129	java/io/File
    //   243: dup
    //   244: aload 10
    //   246: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   249: astore 9
    //   251: aload 9
    //   253: invokevirtual 134	java/io/File:exists	()Z
    //   256: ifne +61 -> 317
    //   259: aload 9
    //   261: invokevirtual 137	java/io/File:mkdirs	()Z
    //   264: ifne +53 -> 317
    //   267: aload_0
    //   268: ldc 138
    //   270: invokestatic 142	anzj:a	(I)Ljava/lang/String;
    //   273: invokespecial 144	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;)V
    //   276: aload 6
    //   278: ifnull +10 -> 288
    //   281: aload 6
    //   283: invokeinterface 63 1 0
    //   288: aconst_null
    //   289: areturn
    //   290: new 101	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   297: ldc 108
    //   299: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokevirtual 147	cooperation/qqfav/widget/QfavJumpActivity:getCacheDir	()Ljava/io/File;
    //   306: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 7
    //   314: goto -147 -> 167
    //   317: aload 8
    //   319: aload_1
    //   320: invokevirtual 151	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnonnull +31 -> 356
    //   328: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +11 -> 342
    //   334: ldc 52
    //   336: iconst_2
    //   337: ldc 153
    //   339: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload 6
    //   344: ifnull +10 -> 354
    //   347: aload 6
    //   349: invokeinterface 63 1 0
    //   354: aconst_null
    //   355: areturn
    //   356: lload 4
    //   358: ldc2_w 154
    //   361: lcmp
    //   362: ifle +132 -> 494
    //   365: aload_0
    //   366: iconst_1
    //   367: putfield 157	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_Boolean	Z
    //   370: new 159	bhpc
    //   373: dup
    //   374: aload_0
    //   375: ldc 160
    //   377: invokespecial 163	bhpc:<init>	(Landroid/content/Context;I)V
    //   380: astore 8
    //   382: aload 8
    //   384: ldc 164
    //   386: invokevirtual 168	bhpc:setContentView	(I)V
    //   389: aload 8
    //   391: aload_0
    //   392: ldc 169
    //   394: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   397: invokevirtual 173	bhpc:setTitle	(Ljava/lang/String;)Lbhpc;
    //   400: pop
    //   401: aload 8
    //   403: aload_0
    //   404: ldc 174
    //   406: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   409: invokevirtual 178	bhpc:setMessage	(Ljava/lang/CharSequence;)Lbhpc;
    //   412: pop
    //   413: aload 8
    //   415: iconst_0
    //   416: invokevirtual 182	bhpc:setCanceledOnTouchOutside	(Z)V
    //   419: aload 8
    //   421: iconst_0
    //   422: invokevirtual 185	bhpc:setCancelable	(Z)V
    //   425: aload 8
    //   427: aload_0
    //   428: ldc 186
    //   430: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   433: new 188	bmmp
    //   436: dup
    //   437: aload_0
    //   438: aload_1
    //   439: invokespecial 191	bmmp:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/io/InputStream;)V
    //   442: invokevirtual 195	bhpc:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbhpc;
    //   445: pop
    //   446: aload 8
    //   448: aload_0
    //   449: ldc 196
    //   451: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   454: new 198	bmmq
    //   457: dup
    //   458: aload_0
    //   459: aload 7
    //   461: aload_1
    //   462: lload 4
    //   464: invokespecial 201	bmmq:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   467: invokevirtual 204	bhpc:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbhpc;
    //   470: pop
    //   471: aload 8
    //   473: invokevirtual 207	bhpc:show	()V
    //   476: aload 7
    //   478: astore_1
    //   479: aload 6
    //   481: ifnull -430 -> 51
    //   484: aload 6
    //   486: invokeinterface 63 1 0
    //   491: aload 7
    //   493: areturn
    //   494: aload_0
    //   495: aload 7
    //   497: aload_1
    //   498: lload 4
    //   500: invokespecial 210	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   503: goto -27 -> 476
    //   506: astore 7
    //   508: aload 6
    //   510: astore_1
    //   511: aload 7
    //   513: astore 6
    //   515: aload_0
    //   516: iconst_0
    //   517: putfield 212	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_Boolean	Z
    //   520: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +13 -> 536
    //   526: ldc 52
    //   528: iconst_2
    //   529: ldc 214
    //   531: aload 6
    //   533: invokestatic 217	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: aload_1
    //   537: ifnull +9 -> 546
    //   540: aload_1
    //   541: invokeinterface 63 1 0
    //   546: aconst_null
    //   547: areturn
    //   548: astore_1
    //   549: aconst_null
    //   550: astore 6
    //   552: aload 6
    //   554: ifnull +10 -> 564
    //   557: aload 6
    //   559: invokeinterface 63 1 0
    //   564: aload_1
    //   565: athrow
    //   566: astore_1
    //   567: goto -15 -> 552
    //   570: astore 7
    //   572: aload_1
    //   573: astore 6
    //   575: aload 7
    //   577: astore_1
    //   578: goto -26 -> 552
    //   581: astore 6
    //   583: aconst_null
    //   584: astore_1
    //   585: goto -70 -> 515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	QfavJumpActivity
    //   0	588	1	paramUri	android.net.Uri
    //   62	65	2	i	int
    //   72	12	3	j	int
    //   89	410	4	l	long
    //   16	558	6	localObject1	Object
    //   581	1	6	localException1	java.lang.Exception
    //   138	358	7	localObject2	Object
    //   506	6	7	localException2	java.lang.Exception
    //   570	6	7	localObject3	Object
    //   4	468	8	localObject4	Object
    //   132	128	9	localObject5	Object
    //   197	48	10	str	String
    // Exception table:
    //   from	to	target	type
    //   23	37	506	java/lang/Exception
    //   53	110	506	java/lang/Exception
    //   124	140	506	java/lang/Exception
    //   145	167	506	java/lang/Exception
    //   167	276	506	java/lang/Exception
    //   290	314	506	java/lang/Exception
    //   317	324	506	java/lang/Exception
    //   328	342	506	java/lang/Exception
    //   365	476	506	java/lang/Exception
    //   494	503	506	java/lang/Exception
    //   6	18	548	finally
    //   23	37	566	finally
    //   53	110	566	finally
    //   124	140	566	finally
    //   145	167	566	finally
    //   167	276	566	finally
    //   290	314	566	finally
    //   317	324	566	finally
    //   328	342	566	finally
    //   365	476	566	finally
    //   494	503	566	finally
    //   515	536	570	finally
    //   6	18	581	java/lang/Exception
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    bhpc localbhpc = new bhpc(this, 2131755824);
    localbhpc.setContentView(2131559008);
    localbhpc.setTitle(getString(2131718699));
    localbhpc.setMessage(paramString);
    localbhpc.setCanceledOnTouchOutside(false);
    localbhpc.setCancelable(false);
    localbhpc.setNegativeButton(getString(2131690559), new bmmt(this));
    localbhpc.show();
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QfavJumpActivity.3(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_Bhpc == null)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(this, getString(2131691145), anzj.a(2131708475), new bmmr(this));
      this.jdField_a_of_type_Bhpc.setOnDismissListener(new bmms(this));
    }
    this.jdField_a_of_type_Bhpc.show();
  }
  
  private boolean a(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (("android.intent.action.SEND".equals(localObject)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).putExtra("nOperation", 8);
      QfavPluginProxyActivity.a(this, this.app.getAccount(), (Intent)localObject, 1);
      return true;
    }
    if ("qqfav.action.ENTER_QQMAP".equals(localObject))
    {
      if (this.jdField_a_of_type_Aofl == null) {
        this.jdField_a_of_type_Aofl = new aofl(this.app.getAccount());
      }
      paramIntent.setClassName("com.tencent.mobileqq", "cooperation.qqfav.widget.LocationDetailActivity");
      paramIntent.setAction(null);
      super.startActivityForResult(paramIntent, 2);
      return true;
    }
    return false;
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
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
  }
  
  public String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return getString(2131718143);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.finish();
      do
      {
        return;
      } while ((paramInt2 == -1) && (a(getIntent())));
      super.finish();
      return;
      if (this.jdField_a_of_type_Aofl != null) {
        this.jdField_a_of_type_Aofl.a();
      }
    }
  }
  
  /* Error */
  public boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 372	cooperation/qqfav/widget/QfavJumpActivity:mNeedStatusTrans	Z
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 374	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   10: pop
    //   11: aload_0
    //   12: iconst_1
    //   13: invokestatic 379	bhnh:a	(Landroid/app/Activity;Z)Z
    //   16: ifne +9 -> 25
    //   19: aload_0
    //   20: invokespecial 359	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: invokespecial 380	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   29: astore 5
    //   31: aload 5
    //   33: ifnonnull +45 -> 78
    //   36: aload_0
    //   37: invokespecial 359	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   40: iconst_0
    //   41: ireturn
    //   42: astore_1
    //   43: ldc 52
    //   45: iconst_1
    //   46: new 101	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 382
    //   56: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   63: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: invokespecial 359	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload 5
    //   80: invokevirtual 261	android/content/Intent:getAction	()Ljava/lang/String;
    //   83: astore_1
    //   84: aload 5
    //   86: invokevirtual 391	android/content/Intent:getType	()Ljava/lang/String;
    //   89: astore 6
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 393	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   96: ldc_w 263
    //   99: aload_1
    //   100: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +13 -> 116
    //   106: ldc_w 269
    //   109: aload_1
    //   110: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +233 -> 346
    //   116: aload 5
    //   118: ldc_w 395
    //   121: invokevirtual 399	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   124: astore_1
    //   125: aload_1
    //   126: instanceof 401
    //   129: ifeq +283 -> 412
    //   132: aload_0
    //   133: aload_1
    //   134: checkcast 401	android/net/Uri
    //   137: invokestatic 406	com/tencent/mobileqq/forward/ForwardFileOption:a	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   140: astore 7
    //   142: aload 7
    //   144: ifnull +268 -> 412
    //   147: new 129	java/io/File
    //   150: dup
    //   151: aload 7
    //   153: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: astore 7
    //   158: aload 7
    //   160: invokevirtual 134	java/io/File:exists	()Z
    //   163: ifeq +80 -> 243
    //   166: aload 7
    //   168: invokevirtual 409	java/io/File:isFile	()Z
    //   171: istore 4
    //   173: iload 4
    //   175: ifeq +68 -> 243
    //   178: iconst_1
    //   179: istore_2
    //   180: iload_2
    //   181: istore_3
    //   182: aload 6
    //   184: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +93 -> 280
    //   190: iload_2
    //   191: istore_3
    //   192: aload 6
    //   194: ldc_w 417
    //   197: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   200: ifeq +80 -> 280
    //   203: iload_2
    //   204: istore_3
    //   205: iload_2
    //   206: ifne +74 -> 280
    //   209: iload_2
    //   210: istore_3
    //   211: aload_1
    //   212: instanceof 401
    //   215: ifeq +65 -> 280
    //   218: aload_0
    //   219: aload_0
    //   220: aload_1
    //   221: checkcast 401	android/net/Uri
    //   224: invokespecial 423	cooperation/qqfav/widget/QfavJumpActivity:a	(Landroid/net/Uri;)Ljava/lang/String;
    //   227: putfield 393	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 393	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   234: astore_1
    //   235: iload_2
    //   236: istore_3
    //   237: aload_1
    //   238: ifnull +42 -> 280
    //   241: iconst_1
    //   242: ireturn
    //   243: iconst_0
    //   244: istore_2
    //   245: goto -65 -> 180
    //   248: astore_1
    //   249: iconst_0
    //   250: istore_2
    //   251: new 425	java/util/ArrayList
    //   254: dup
    //   255: invokespecial 426	java/util/ArrayList:<init>	()V
    //   258: pop
    //   259: aload 5
    //   261: ldc_w 395
    //   264: invokevirtual 430	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   267: pop
    //   268: ldc 52
    //   270: iconst_1
    //   271: aload_1
    //   272: invokevirtual 431	java/lang/Exception:toString	()Ljava/lang/String;
    //   275: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload_2
    //   279: istore_3
    //   280: aload 6
    //   282: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifne +61 -> 346
    //   288: aload 6
    //   290: ldc_w 417
    //   293: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   296: ifne +14 -> 310
    //   299: aload 6
    //   301: ldc_w 433
    //   304: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   307: ifeq +39 -> 346
    //   310: iload_3
    //   311: ifne +35 -> 346
    //   314: aload 5
    //   316: aload_0
    //   317: ldc_w 435
    //   320: invokevirtual 439	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   323: pop
    //   324: aload 5
    //   326: ldc_w 441
    //   329: iconst_1
    //   330: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   333: pop
    //   334: aload_0
    //   335: aload 5
    //   337: invokespecial 448	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   340: aload_0
    //   341: invokespecial 359	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   344: iconst_0
    //   345: ireturn
    //   346: aload_0
    //   347: getfield 284	cooperation/qqfav/widget/QfavJumpActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: invokevirtual 451	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   353: ifne +40 -> 393
    //   356: new 258	android/content/Intent
    //   359: dup
    //   360: aload_0
    //   361: ldc_w 453
    //   364: invokespecial 456	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc_w 457
    //   372: invokevirtual 461	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   375: pop
    //   376: aload_1
    //   377: ldc_w 463
    //   380: iconst_1
    //   381: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   384: pop
    //   385: aload_0
    //   386: aload_1
    //   387: iconst_0
    //   388: invokespecial 317	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_0
    //   394: aload 5
    //   396: invokespecial 365	cooperation/qqfav/widget/QfavJumpActivity:a	(Landroid/content/Intent;)Z
    //   399: ifne +7 -> 406
    //   402: aload_0
    //   403: invokespecial 359	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   406: iconst_1
    //   407: ireturn
    //   408: astore_1
    //   409: goto -158 -> 251
    //   412: iconst_0
    //   413: istore_2
    //   414: goto -234 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	QfavJumpActivity
    //   0	417	1	paramBundle	android.os.Bundle
    //   179	235	2	i	int
    //   181	130	3	j	int
    //   171	3	4	bool	boolean
    //   29	366	5	localIntent	Intent
    //   89	211	6	str	String
    //   140	27	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	42	java/lang/Exception
    //   25	31	42	java/lang/Exception
    //   36	40	42	java/lang/Exception
    //   78	116	42	java/lang/Exception
    //   116	125	42	java/lang/Exception
    //   251	278	42	java/lang/Exception
    //   280	310	42	java/lang/Exception
    //   314	344	42	java/lang/Exception
    //   346	391	42	java/lang/Exception
    //   393	406	42	java/lang/Exception
    //   125	142	248	java/lang/Exception
    //   147	173	248	java/lang/Exception
    //   182	190	408	java/lang/Exception
    //   192	203	408	java/lang/Exception
    //   211	235	408	java/lang/Exception
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
      a(a());
      continue;
      a();
      paramMessage = super.getIntent();
      paramMessage.setClass(this, JumpActivity.class);
      paramMessage.putExtra("android.intent.extra.STREAM", this.jdField_b_of_type_JavaLangString);
      paramMessage.putExtra("qqfav_extra_from_system_share", true);
      super.startActivity(paramMessage);
      super.finish();
      continue;
      QLog.i("qqfav|QfavJumpActivity", 2, "progress: " + paramMessage.arg1);
      this.jdField_a_of_type_Bhpc.setProgress(paramMessage.arg1);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = bhnh.a(this);
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity
 * JD-Core Version:    0.7.0.1
 */