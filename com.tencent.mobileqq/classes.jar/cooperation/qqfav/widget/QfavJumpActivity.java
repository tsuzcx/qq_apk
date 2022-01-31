package cooperation.qqfav.widget;

import ajyc;
import akeq;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import aqce;
import bbcv;
import bbei;
import bbgg;
import bfmt;
import bgrg;
import bgrh;
import bgri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.io.InputStream;
import mqq.os.MqqHandler;

public class QfavJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  protected static String a;
  private akeq jdField_a_of_type_Akeq;
  private bbgg jdField_a_of_type_Bbgg;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private String a(Uri paramUri)
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
    //   94: invokestatic 87	bbdj:c	()F
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
    //   229: invokestatic 127	bbdj:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   270: invokestatic 142	ajyc:a	(I)Ljava/lang/String;
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
    //   370: new 159	bbgg
    //   373: dup
    //   374: aload_0
    //   375: ldc 160
    //   377: invokespecial 163	bbgg:<init>	(Landroid/content/Context;I)V
    //   380: astore 8
    //   382: aload 8
    //   384: ldc 164
    //   386: invokevirtual 168	bbgg:setContentView	(I)V
    //   389: aload 8
    //   391: aload_0
    //   392: ldc 169
    //   394: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   397: invokevirtual 173	bbgg:setTitle	(Ljava/lang/String;)Lbbgg;
    //   400: pop
    //   401: aload 8
    //   403: aload_0
    //   404: ldc 174
    //   406: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   409: invokevirtual 178	bbgg:setMessage	(Ljava/lang/CharSequence;)Lbbgg;
    //   412: pop
    //   413: aload 8
    //   415: iconst_0
    //   416: invokevirtual 182	bbgg:setCanceledOnTouchOutside	(Z)V
    //   419: aload 8
    //   421: iconst_0
    //   422: invokevirtual 185	bbgg:setCancelable	(Z)V
    //   425: aload 8
    //   427: aload_0
    //   428: ldc 186
    //   430: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   433: new 188	bgre
    //   436: dup
    //   437: aload_0
    //   438: aload_1
    //   439: invokespecial 191	bgre:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/io/InputStream;)V
    //   442: invokevirtual 195	bbgg:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgg;
    //   445: pop
    //   446: aload 8
    //   448: aload_0
    //   449: ldc 196
    //   451: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   454: new 198	bgrf
    //   457: dup
    //   458: aload_0
    //   459: aload 7
    //   461: aload_1
    //   462: lload 4
    //   464: invokespecial 201	bgrf:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   467: invokevirtual 204	bbgg:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgg;
    //   470: pop
    //   471: aload 8
    //   473: invokevirtual 207	bbgg:show	()V
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
    //   0	588	1	paramUri	Uri
    //   62	65	2	i	int
    //   72	12	3	j	int
    //   89	410	4	l	long
    //   16	558	6	localObject1	Object
    //   581	1	6	localException1	Exception
    //   138	358	7	localObject2	Object
    //   506	6	7	localException2	Exception
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
    if (this.jdField_a_of_type_Bbgg != null) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    bbgg localbbgg = new bbgg(this, 2131755791);
    localbbgg.setContentView(2131558906);
    localbbgg.setTitle(getString(2131720249));
    localbbgg.setMessage(paramString);
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.setCancelable(false);
    localbbgg.setNegativeButton(getString(2131690572), new bgri(this));
    localbbgg.show();
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QfavJumpActivity.3(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_Bbgg == null)
    {
      this.jdField_a_of_type_Bbgg = bbcv.a(this, getString(2131691312), ajyc.a(2131709595), new bgrg(this));
      this.jdField_a_of_type_Bbgg.setOnDismissListener(new bgrh(this));
    }
    this.jdField_a_of_type_Bbgg.show();
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
      if (this.jdField_a_of_type_Akeq == null) {
        this.jdField_a_of_type_Akeq = new akeq(this.app.getAccount());
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
      return getString(2131719481);
    }
    return jdField_a_of_type_JavaLangString;
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
      if (this.jdField_a_of_type_Akeq != null) {
        this.jdField_a_of_type_Akeq.a();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      this.mNeedStatusTrans = false;
      super.doOnCreate(paramBundle);
      if (!bbei.a(this, true))
      {
        super.finish();
        return false;
      }
      paramBundle = super.getIntent();
      if (paramBundle == null)
      {
        super.finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("qqfav|QfavJumpActivity", 1, "QfavJumpActivity doOnCreate|exp:" + paramBundle.getMessage());
      super.finish();
      return false;
    }
    Object localObject1 = paramBundle.getAction();
    String str = paramBundle.getType();
    this.jdField_b_of_type_JavaLangString = null;
    int i;
    if (("android.intent.action.SEND".equals(localObject1)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject1)))
    {
      localObject1 = paramBundle.getParcelableExtra("android.intent.extra.STREAM");
      if (!(localObject1 instanceof Uri)) {
        break label348;
      }
      Object localObject2 = aqce.a(this, (Uri)localObject1);
      if (localObject2 == null) {
        break label348;
      }
      localObject2 = new File((String)localObject2);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
        break label353;
      }
      i = 1;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("image")) && (i == 0) && ((localObject1 instanceof Uri)))
      {
        this.jdField_b_of_type_JavaLangString = a((Uri)localObject1);
        if (this.jdField_b_of_type_JavaLangString != null) {
          return true;
        }
      }
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("image")) || (str.startsWith("text"))) && (i == 0))
      {
        paramBundle.setClass(this, JumpActivity.class);
        paramBundle.putExtra("qqfav_extra_from_system_share", true);
        super.startActivity(paramBundle);
        super.finish();
        return false;
      }
      if (!this.app.isLogin())
      {
        paramBundle = new Intent(this, LoginActivity.class);
        paramBundle.addFlags(67371008);
        paramBundle.putExtra("isActionSend", true);
        super.startActivityForResult(paramBundle, 0);
        return true;
      }
      if (!a(paramBundle)) {
        super.finish();
      }
      return true;
      label348:
      i = 0;
      continue;
      label353:
      i = 0;
    }
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
      this.jdField_a_of_type_Bbgg.setProgress(paramMessage.arg1);
    }
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = bbei.a(this);
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