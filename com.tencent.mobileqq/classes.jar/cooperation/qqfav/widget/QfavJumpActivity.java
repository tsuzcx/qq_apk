package cooperation.qqfav.widget;

import amxd;
import amxe;
import amxf;
import amxg;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.io.InputStream;
import mqq.os.MqqHandler;

public class QfavJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  public static String a;
  private QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public QfavJumpActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
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
    //   94: invokestatic 87	com/tencent/mobileqq/utils/FileUtils:c	()F
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
    //   198: invokestatic 125	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   225: ifne +31 -> 256
    //   228: aload 9
    //   230: invokevirtual 135	java/io/File:mkdirs	()Z
    //   233: ifne +23 -> 256
    //   236: aload_0
    //   237: ldc 137
    //   239: invokespecial 139	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;)V
    //   242: aload 6
    //   244: ifnull +10 -> 254
    //   247: aload 6
    //   249: invokeinterface 63 1 0
    //   254: aconst_null
    //   255: areturn
    //   256: aload 8
    //   258: aload_1
    //   259: invokevirtual 143	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   262: astore_1
    //   263: aload_1
    //   264: ifnonnull +31 -> 295
    //   267: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +11 -> 281
    //   273: ldc 52
    //   275: iconst_2
    //   276: ldc 145
    //   278: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload 6
    //   283: ifnull +10 -> 293
    //   286: aload 6
    //   288: invokeinterface 63 1 0
    //   293: aconst_null
    //   294: areturn
    //   295: lload 4
    //   297: ldc2_w 146
    //   300: lcmp
    //   301: ifle +132 -> 433
    //   304: aload_0
    //   305: iconst_1
    //   306: putfield 149	cooperation/qqfav/widget/QfavJumpActivity:jdField_b_of_type_Boolean	Z
    //   309: new 151	com/tencent/mobileqq/utils/QQCustomDialog
    //   312: dup
    //   313: aload_0
    //   314: ldc 152
    //   316: invokespecial 155	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   319: astore 8
    //   321: aload 8
    //   323: ldc 156
    //   325: invokevirtual 160	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   328: aload 8
    //   330: aload_0
    //   331: ldc 161
    //   333: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   336: invokevirtual 165	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   339: pop
    //   340: aload 8
    //   342: aload_0
    //   343: ldc 166
    //   345: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   348: invokevirtual 170	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   351: pop
    //   352: aload 8
    //   354: iconst_0
    //   355: invokevirtual 174	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   358: aload 8
    //   360: iconst_0
    //   361: invokevirtual 177	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   364: aload 8
    //   366: aload_0
    //   367: ldc 178
    //   369: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   372: new 180	amxb
    //   375: dup
    //   376: aload_0
    //   377: aload_1
    //   378: invokespecial 183	amxb:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/io/InputStream;)V
    //   381: invokevirtual 187	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   384: pop
    //   385: aload 8
    //   387: aload_0
    //   388: ldc 188
    //   390: invokevirtual 92	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   393: new 190	amxc
    //   396: dup
    //   397: aload_0
    //   398: aload 7
    //   400: aload_1
    //   401: lload 4
    //   403: invokespecial 193	amxc:<init>	(Lcooperation/qqfav/widget/QfavJumpActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   406: invokevirtual 196	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   409: pop
    //   410: aload 8
    //   412: invokevirtual 199	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   415: aload 7
    //   417: astore_1
    //   418: aload 6
    //   420: ifnull -369 -> 51
    //   423: aload 6
    //   425: invokeinterface 63 1 0
    //   430: aload 7
    //   432: areturn
    //   433: aload_0
    //   434: aload 7
    //   436: aload_1
    //   437: lload 4
    //   439: invokespecial 202	cooperation/qqfav/widget/QfavJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   442: goto -27 -> 415
    //   445: astore 7
    //   447: aload 6
    //   449: astore_1
    //   450: aload 7
    //   452: astore 6
    //   454: aload_0
    //   455: iconst_0
    //   456: putfield 204	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_Boolean	Z
    //   459: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +13 -> 475
    //   465: ldc 52
    //   467: iconst_2
    //   468: ldc 206
    //   470: aload 6
    //   472: invokestatic 209	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: aload_1
    //   476: ifnull +9 -> 485
    //   479: aload_1
    //   480: invokeinterface 63 1 0
    //   485: aconst_null
    //   486: areturn
    //   487: astore_1
    //   488: aconst_null
    //   489: astore 6
    //   491: aload 6
    //   493: ifnull +10 -> 503
    //   496: aload 6
    //   498: invokeinterface 63 1 0
    //   503: aload_1
    //   504: athrow
    //   505: astore_1
    //   506: goto -15 -> 491
    //   509: astore 7
    //   511: aload_1
    //   512: astore 6
    //   514: aload 7
    //   516: astore_1
    //   517: goto -26 -> 491
    //   520: astore 6
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -70 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	QfavJumpActivity
    //   0	527	1	paramUri	Uri
    //   62	65	2	i	int
    //   72	12	3	j	int
    //   89	349	4	l	long
    //   16	497	6	localObject1	Object
    //   520	1	6	localException1	Exception
    //   132	303	7	str	String
    //   445	6	7	localException2	Exception
    //   509	6	7	localObject2	Object
    //   4	407	8	localObject3	Object
    //   166	63	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	445	java/lang/Exception
    //   53	110	445	java/lang/Exception
    //   124	242	445	java/lang/Exception
    //   256	263	445	java/lang/Exception
    //   267	281	445	java/lang/Exception
    //   304	415	445	java/lang/Exception
    //   433	442	445	java/lang/Exception
    //   6	18	487	finally
    //   23	37	505	finally
    //   53	110	505	finally
    //   124	242	505	finally
    //   256	263	505	finally
    //   267	281	505	finally
    //   304	415	505	finally
    //   433	442	505	finally
    //   454	475	509	finally
    //   6	18	520	java/lang/Exception
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131624516);
    localQQCustomDialog.setContentView(2130968855);
    localQQCustomDialog.setTitle(getString(2131434797));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131433712), new amxg(this));
    localQQCustomDialog.show();
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new amxd(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131436315), "取消", new amxe(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new amxf(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.app.getAccount());
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
      return getString(2131436306);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy.a();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        this.mNeedStatusTrans = false;
        super.doOnCreate(paramBundle);
        paramBundle = super.getIntent();
        if (paramBundle == null)
        {
          super.finish();
          return false;
        }
        Object localObject1 = paramBundle.getAction();
        String str = paramBundle.getType();
        this.jdField_b_of_type_JavaLangString = null;
        if (("android.intent.action.SEND".equals(localObject1)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject1)))
        {
          localObject1 = paramBundle.getParcelableExtra("android.intent.extra.STREAM");
          if ((localObject1 == null) || (!(localObject1 instanceof Uri))) {
            break label317;
          }
          Object localObject2 = ForwardFileOption.a(this, (Uri)localObject1);
          if (localObject2 == null) {
            break label317;
          }
          localObject2 = new File((String)localObject2);
          if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
            break label322;
          }
          i = 1;
          if ((str.startsWith("image")) && (i == 0))
          {
            this.jdField_b_of_type_JavaLangString = a((Uri)localObject1);
            if (this.jdField_b_of_type_JavaLangString != null) {
              return true;
            }
          }
          if ((str.startsWith("image")) || ((str.startsWith("text")) && (i == 0)))
          {
            paramBundle.setClass(this, JumpActivity.class);
            paramBundle.putExtra("qqfav_extra_from_system_share", true);
            super.startActivity(paramBundle);
            super.finish();
            return false;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("qqfav|QfavJumpActivity", 1, "QfavJumpActivity doOnCreate|exp:" + paramBundle.getMessage());
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
      label317:
      int i = 0;
      continue;
      label322:
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity
 * JD-Core Version:    0.7.0.1
 */