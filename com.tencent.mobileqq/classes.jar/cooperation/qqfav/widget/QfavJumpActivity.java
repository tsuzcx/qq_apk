package cooperation.qqfav.widget;

import ajjy;
import ajqg;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import apir;
import babr;
import badd;
import bafb;
import beez;
import bfjo;
import bfjp;
import bfjq;
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
  private ajqg jdField_a_of_type_Ajqg;
  private bafb jdField_a_of_type_Bafb;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this);
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
    //   94: invokestatic 87	bace:c	()F
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
    //   132: astore 7
    //   134: new 97	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   141: aload_0
    //   142: invokevirtual 102	cooperation/qqfav/widget/QfavJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   145: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc 108
    //   150: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 113
    //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 108
    //   160: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 9
    //   168: aload 9
    //   170: invokestatic 120	cooperation/qqfav/widget/QfavJumpActivity:b	(Ljava/lang/String;)V
    //   173: new 97	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   180: aload 9
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 9
    //   187: iconst_1
    //   188: anewarray 122	java/lang/String
    //   191: dup
    //   192: iconst_0
    //   193: aload 7
    //   195: aastore
    //   196: iconst_0
    //   197: aaload
    //   198: invokestatic 125	bace:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore 7
    //   209: new 127	java/io/File
    //   212: dup
    //   213: aload 9
    //   215: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: astore 9
    //   220: aload 9
    //   222: invokevirtual 132	java/io/File:exists	()Z
    //   225: ifne +34 -> 259
    //   228: aload 9
    //   230: invokevirtual 135	java/io/File:mkdirs	()Z
    //   233: ifne +26 -> 259
    //   236: aload_0
    //   237: ldc 136
    //   239: invokestatic 140	ajjy:a	(I)Ljava/lang/String;
    //   242: invokespecial 142	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;)V
    //   245: aload 6
    //   247: ifnull +10 -> 257
    //   250: aload 6
    //   252: invokeinterface 63 1 0
    //   257: aconst_null
    //   258: areturn
    //   259: aload 8
    //   261: aload_1
    //   262: invokevirtual 146	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   265: astore_1
    //   266: aload_1
    //   267: ifnonnull +31 -> 298
    //   270: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +11 -> 284
    //   276: ldc 52
    //   278: iconst_2
    //   279: ldc 148
    //   281: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 6
    //   286: ifnull +10 -> 296
    //   289: aload 6
    //   291: invokeinterface 63 1 0
    //   296: aconst_null
    //   297: areturn
    //   298: lload 4
    //   300: ldc2_w 149
    //   303: lcmp
    //   304: ifle +132 -> 436
    //   307: aload_0
    //   308: iconst_1
    //   309: putfield 152	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_Boolean	Z
    //   312: new 154	bafb
    //   315: dup
    //   316: aload_0
    //   317: ldc 155
    //   319: invokespecial 158	bafb:<init>	(Landroid/content/Context;I)V
    //   322: astore 8
    //   324: aload 8
    //   326: ldc 159
    //   328: invokevirtual 163	bafb:setContentView	(I)V
    //   331: aload 8
    //   333: aload_0
    //   334: ldc 164
    //   336: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   339: invokevirtual 168	bafb:setTitle	(Ljava/lang/String;)Lbafb;
    //   342: pop
    //   343: aload 8
    //   345: aload_0
    //   346: ldc 169
    //   348: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   351: invokevirtual 173	bafb:setMessage	(Ljava/lang/CharSequence;)Lbafb;
    //   354: pop
    //   355: aload 8
    //   357: iconst_0
    //   358: invokevirtual 177	bafb:setCanceledOnTouchOutside	(Z)V
    //   361: aload 8
    //   363: iconst_0
    //   364: invokevirtual 180	bafb:setCancelable	(Z)V
    //   367: aload 8
    //   369: aload_0
    //   370: ldc 181
    //   372: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   375: new 183	bfjm
    //   378: dup
    //   379: aload_0
    //   380: aload_1
    //   381: invokespecial 186	bfjm:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/io/InputStream;)V
    //   384: invokevirtual 190	bafb:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   387: pop
    //   388: aload 8
    //   390: aload_0
    //   391: ldc 191
    //   393: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   396: new 193	bfjn
    //   399: dup
    //   400: aload_0
    //   401: aload 7
    //   403: aload_1
    //   404: lload 4
    //   406: invokespecial 196	bfjn:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   409: invokevirtual 199	bafb:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   412: pop
    //   413: aload 8
    //   415: invokevirtual 202	bafb:show	()V
    //   418: aload 7
    //   420: astore_1
    //   421: aload 6
    //   423: ifnull -372 -> 51
    //   426: aload 6
    //   428: invokeinterface 63 1 0
    //   433: aload 7
    //   435: areturn
    //   436: aload_0
    //   437: aload 7
    //   439: aload_1
    //   440: lload 4
    //   442: invokespecial 205	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   445: goto -27 -> 418
    //   448: astore 7
    //   450: aload 6
    //   452: astore_1
    //   453: aload 7
    //   455: astore 6
    //   457: aload_0
    //   458: iconst_0
    //   459: putfield 207	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_Boolean	Z
    //   462: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +13 -> 478
    //   468: ldc 52
    //   470: iconst_2
    //   471: ldc 209
    //   473: aload 6
    //   475: invokestatic 212	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   478: aload_1
    //   479: ifnull +9 -> 488
    //   482: aload_1
    //   483: invokeinterface 63 1 0
    //   488: aconst_null
    //   489: areturn
    //   490: astore_1
    //   491: aconst_null
    //   492: astore 6
    //   494: aload 6
    //   496: ifnull +10 -> 506
    //   499: aload 6
    //   501: invokeinterface 63 1 0
    //   506: aload_1
    //   507: athrow
    //   508: astore_1
    //   509: goto -15 -> 494
    //   512: astore 7
    //   514: aload_1
    //   515: astore 6
    //   517: aload 7
    //   519: astore_1
    //   520: goto -26 -> 494
    //   523: astore 6
    //   525: aconst_null
    //   526: astore_1
    //   527: goto -70 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	QfavJumpActivity
    //   0	530	1	paramUri	Uri
    //   62	65	2	i	int
    //   72	12	3	j	int
    //   89	352	4	l	long
    //   16	500	6	localObject1	Object
    //   523	1	6	localException1	Exception
    //   132	306	7	str	String
    //   448	6	7	localException2	Exception
    //   512	6	7	localObject2	Object
    //   4	410	8	localObject3	Object
    //   166	63	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	448	java/lang/Exception
    //   53	110	448	java/lang/Exception
    //   124	245	448	java/lang/Exception
    //   259	266	448	java/lang/Exception
    //   270	284	448	java/lang/Exception
    //   307	418	448	java/lang/Exception
    //   436	445	448	java/lang/Exception
    //   6	18	490	finally
    //   23	37	508	finally
    //   53	110	508	finally
    //   124	245	508	finally
    //   259	266	508	finally
    //   270	284	508	finally
    //   307	418	508	finally
    //   436	445	508	finally
    //   457	478	512	finally
    //   6	18	523	java/lang/Exception
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    bafb localbafb = new bafb(this, 2131690181);
    localbafb.setContentView(2131493345);
    localbafb.setTitle(getString(2131654355));
    localbafb.setMessage(paramString);
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.setCancelable(false);
    localbafb.setNegativeButton(getString(2131625011), new bfjq(this));
    localbafb.show();
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QfavJumpActivity.3(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(this, getString(2131625736), ajjy.a(2131643810), new bfjo(this));
      this.jdField_a_of_type_Bafb.setOnDismissListener(new bfjp(this));
    }
    this.jdField_a_of_type_Bafb.show();
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
      if (this.jdField_a_of_type_Ajqg == null) {
        this.jdField_a_of_type_Ajqg = new ajqg(this.app.getAccount());
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
      return getString(2131653600);
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
      if (this.jdField_a_of_type_Ajqg != null) {
        this.jdField_a_of_type_Ajqg.a();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      this.mNeedStatusTrans = false;
      super.doOnCreate(paramBundle);
      if (!badd.a(this, true))
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
      Object localObject2 = apir.a(this, (Uri)localObject1);
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
      this.jdField_a_of_type_Bafb.setProgress(paramMessage.arg1);
    }
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = badd.a(this);
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