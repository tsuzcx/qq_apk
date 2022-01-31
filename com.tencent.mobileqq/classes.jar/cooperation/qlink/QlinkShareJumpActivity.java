package cooperation.qlink;

import ajyc;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import apeh;
import apvb;
import bbcv;
import bbgg;
import bfmt;
import bgmt;
import bgns;
import bgnt;
import bgnu;
import bgnv;
import bgnw;
import bgnx;
import bgny;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
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
  private bbgg jdField_a_of_type_Bbgg;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private String b = ajyc.a(2131710016);
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	cooperation/qlink/QlinkShareJumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 7
    //   6: aload 7
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 59	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +31 -> 51
    //   23: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 67
    //   31: iconst_2
    //   32: ldc 69
    //   34: invokestatic 73	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload 6
    //   39: ifnull +10 -> 49
    //   42: aload 6
    //   44: invokeinterface 78 1 0
    //   49: aconst_null
    //   50: areturn
    //   51: aload 6
    //   53: ldc 80
    //   55: invokeinterface 84 2 0
    //   60: istore_2
    //   61: aload 6
    //   63: ldc 86
    //   65: invokeinterface 89 2 0
    //   70: istore_3
    //   71: aload 6
    //   73: invokeinterface 92 1 0
    //   78: pop
    //   79: aload 6
    //   81: iload_3
    //   82: invokeinterface 96 2 0
    //   87: lstore 4
    //   89: lload 4
    //   91: l2f
    //   92: invokestatic 102	bbdj:c	()F
    //   95: fcmpl
    //   96: ifle +27 -> 123
    //   99: aload_0
    //   100: aload_0
    //   101: ldc 103
    //   103: invokevirtual 106	cooperation/qlink/QlinkShareJumpActivity:getString	(I)Ljava/lang/String;
    //   106: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   109: aload 6
    //   111: ifnull +10 -> 121
    //   114: aload 6
    //   116: invokeinterface 78 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: aload 6
    //   125: iload_2
    //   126: invokeinterface 107 2 0
    //   131: astore 8
    //   133: new 109	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   140: aload_0
    //   141: invokevirtual 114	cooperation/qlink/QlinkShareJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   144: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: ldc 120
    //   149: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 125
    //   154: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 120
    //   159: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: aload 9
    //   169: invokestatic 132	cooperation/qlink/QlinkShareJumpActivity:a	(Ljava/lang/String;)V
    //   172: new 109	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   179: aload 9
    //   181: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 9
    //   186: iconst_1
    //   187: anewarray 134	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload 8
    //   194: aastore
    //   195: iconst_0
    //   196: aaload
    //   197: invokestatic 137	bbdj:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 8
    //   208: new 139	java/io/File
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: astore 9
    //   219: aload 9
    //   221: invokevirtual 144	java/io/File:exists	()Z
    //   224: ifne +34 -> 258
    //   227: aload 9
    //   229: invokevirtual 147	java/io/File:mkdirs	()Z
    //   232: ifne +26 -> 258
    //   235: aload_0
    //   236: ldc 148
    //   238: invokestatic 25	ajyc:a	(I)Ljava/lang/String;
    //   241: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   244: aload 6
    //   246: ifnull +10 -> 256
    //   249: aload 6
    //   251: invokeinterface 78 1 0
    //   256: aconst_null
    //   257: areturn
    //   258: aload 7
    //   260: aload_1
    //   261: invokevirtual 152	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   264: astore_1
    //   265: aload_1
    //   266: ifnonnull +40 -> 306
    //   269: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +11 -> 283
    //   275: ldc 67
    //   277: iconst_2
    //   278: ldc 154
    //   280: invokestatic 73	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: ldc 155
    //   286: invokestatic 25	ajyc:a	(I)Ljava/lang/String;
    //   289: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   292: aload 6
    //   294: ifnull +10 -> 304
    //   297: aload 6
    //   299: invokeinterface 78 1 0
    //   304: aconst_null
    //   305: areturn
    //   306: lload 4
    //   308: ldc2_w 156
    //   311: lcmp
    //   312: ifle +30 -> 342
    //   315: aload_0
    //   316: ldc 158
    //   318: invokestatic 25	ajyc:a	(I)Ljava/lang/String;
    //   321: putfield 27	cooperation/qlink/QlinkShareJumpActivity:b	Ljava/lang/String;
    //   324: aload_1
    //   325: invokevirtual 161	java/io/InputStream:close	()V
    //   328: aload 6
    //   330: ifnull +10 -> 340
    //   333: aload 6
    //   335: invokeinterface 78 1 0
    //   340: aconst_null
    //   341: areturn
    //   342: aload_0
    //   343: aload 8
    //   345: aload_1
    //   346: lload 4
    //   348: invokespecial 164	cooperation/qlink/QlinkShareJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   351: aload 6
    //   353: ifnull +10 -> 363
    //   356: aload 6
    //   358: invokeinterface 78 1 0
    //   363: aload 8
    //   365: areturn
    //   366: astore 6
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_0
    //   371: iconst_0
    //   372: putfield 166	cooperation/qlink/QlinkShareJumpActivity:jdField_a_of_type_Boolean	Z
    //   375: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +13 -> 391
    //   381: ldc 67
    //   383: iconst_2
    //   384: ldc 168
    //   386: aload 6
    //   388: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_1
    //   392: ifnull +9 -> 401
    //   395: aload_1
    //   396: invokeinterface 78 1 0
    //   401: aconst_null
    //   402: areturn
    //   403: astore_1
    //   404: aconst_null
    //   405: astore 6
    //   407: aload 6
    //   409: ifnull +10 -> 419
    //   412: aload 6
    //   414: invokeinterface 78 1 0
    //   419: aload_1
    //   420: athrow
    //   421: astore_1
    //   422: goto -94 -> 328
    //   425: astore_1
    //   426: goto -19 -> 407
    //   429: astore 7
    //   431: aload_1
    //   432: astore 6
    //   434: aload 7
    //   436: astore_1
    //   437: goto -30 -> 407
    //   440: astore 7
    //   442: aload 6
    //   444: astore_1
    //   445: aload 7
    //   447: astore 6
    //   449: goto -79 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	QlinkShareJumpActivity
    //   0	452	1	paramUri	Uri
    //   60	66	2	i	int
    //   70	12	3	j	int
    //   87	260	4	l	long
    //   16	341	6	localCursor	android.database.Cursor
    //   366	21	6	localException1	Exception
    //   405	43	6	localObject1	Object
    //   4	255	7	localContentResolver	android.content.ContentResolver
    //   429	6	7	localObject2	Object
    //   440	6	7	localException2	Exception
    //   131	233	8	str	String
    //   165	63	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	366	java/lang/Exception
    //   6	18	403	finally
    //   324	328	421	java/lang/Exception
    //   23	37	425	finally
    //   51	109	425	finally
    //   123	244	425	finally
    //   258	265	425	finally
    //   269	283	425	finally
    //   283	292	425	finally
    //   315	324	425	finally
    //   324	328	425	finally
    //   342	351	425	finally
    //   370	391	429	finally
    //   23	37	440	java/lang/Exception
    //   51	109	440	java/lang/Exception
    //   123	244	440	java/lang/Exception
    //   258	265	440	java/lang/Exception
    //   269	283	440	java/lang/Exception
    //   283	292	440	java/lang/Exception
    //   315	324	440	java/lang/Exception
    //   342	351	440	java/lang/Exception
  }
  
  private void a()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      a(false);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND"))
    {
      localObject2 = (Uri)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject2 == null) {
        break label259;
      }
      localObject1 = b((Uri)localObject2);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (apvb.a((String)localObject1)) && (new File((String)localObject1).canRead())) {
        break label254;
      }
      localObject1 = a((Uri)localObject2);
      i = 1;
      label104:
      j = i;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    label259:
    for (j = i;; j = 0)
    {
      boolean bool2 = false;
      i = j;
      for (;;)
      {
        if (localArrayList.size() == 0)
        {
          a(bool2);
          return;
          localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            boolean bool1 = false;
            bool2 = bool1;
            i = j;
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject2 = b((Uri)((Iterator)localObject1).next());
            if (apvb.a((String)localObject2)) {
              localArrayList.add(localObject2);
            }
            for (;;)
            {
              break;
              bool1 = true;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          if (i != 0) {
            break;
          }
          b();
          return;
        }
        bool2 = false;
        i = j;
      }
      label254:
      i = 0;
      break label104;
    }
  }
  
  private static void a(String paramString)
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
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new QlinkShareJumpActivity.5(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_Bbgg == null)
    {
      this.jdField_a_of_type_Bbgg = bbcv.a(this, getString(2131691312), ajyc.a(2131710019), new bgnw(this));
      this.jdField_a_of_type_Bbgg.setOnDismissListener(new bgnx(this));
    }
    this.jdField_a_of_type_Bbgg.show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = getString(2131698421);; str = getString(2131698422))
    {
      bbcv.a(this, 230, getString(2131698377), str, 2131698370, 2131698370, new bgnt(this), null).show();
      return;
    }
  }
  
  private boolean a()
  {
    Intent localIntent1 = getIntent();
    if (localIntent1.getExtras() == null) {
      new Bundle();
    }
    if (!this.app.isLogin())
    {
      Intent localIntent2 = new Intent(this, LoginActivity.class);
      localIntent2.addFlags(67371008);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localIntent1.putStringArrayListExtra("qlink_share_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      }
      localIntent2.putExtra("qlink_share_intent_data", localIntent1);
      localIntent2.putExtra("from_register_guide", true);
      startActivity(localIntent2);
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
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 50) {
      bbcv.a(this, 230, getString(2131698377), getString(2131698381), 2131698370, 2131698370, new bgnu(this), null).show();
    }
    while ((a()) || (a(false))) {
      return;
    }
    d();
  }
  
  private void b(String paramString)
  {
    bbgg localbbgg = new bbgg(this, 2131755791);
    localbbgg.setContentView(2131558906);
    localbbgg.setTitle(getString(2131720249));
    localbbgg.setMessage(paramString);
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.setCancelable(false);
    localbbgg.setNegativeButton(getString(2131690572), new bgnv(this));
    localbbgg.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
  }
  
  private void d()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.a().a("0X8004F47", this.jdField_a_of_type_JavaUtilArrayList.size());
      localBundle = new Bundle();
      localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList = new ArrayList();
      localArrayList.addAll(apeh.a());
      if (localArrayList == null) {
        break label141;
      }
    }
    label141:
    for (int i = localArrayList.size();; i = 0)
    {
      localBundle.putInt("string_beforeshare_selectedfile_count", i);
      bgmt.a(this, 10, localBundle);
      finish();
      return;
      bbcv.a(this, 230, getString(2131698377), getString(2131698422), 2131698370, 2131698370, new bgny(this), null).show();
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramBundle.getAction();
        this.jdField_a_of_type_AndroidOsBundle = paramBundle.getExtras();
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND")) && (!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND_MULTIPLE")))) {
          break label225;
        }
        if (!paramBundle.getBooleanExtra("qlink_share_login_suc_flag", false)) {
          break label218;
        }
        paramBundle = paramBundle.getStringArrayListExtra("qlink_share_filepaths");
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            String str = (String)paramBundle.next();
            if (apvb.a(str))
            {
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(str);
            }
          }
        }
        if (a(true)) {
          break label237;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        bbcv.a(this, 230, getString(2131698377), getString(2131698422), 2131698370, 2131698370, new bgns(this), null).show();
        return false;
      }
      d();
      break label237;
      label218:
      a();
    }
    else
    {
      label225:
      finish();
      overridePendingTransition(0, 0);
      return false;
    }
    label237:
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {}
      for (paramMessage = (String)paramMessage.obj;; paramMessage = null)
      {
        Object localObject = paramMessage;
        if (TextUtils.isEmpty(paramMessage)) {
          localObject = this.b;
        }
        b((String)localObject);
        break;
      }
      c();
      b();
      continue;
      this.jdField_a_of_type_Bbgg.setProgress(paramMessage.arg1);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity
 * JD-Core Version:    0.7.0.1
 */