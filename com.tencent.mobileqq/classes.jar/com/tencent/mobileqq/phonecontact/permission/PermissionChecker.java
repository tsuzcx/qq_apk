package com.tencent.mobileqq.phonecontact.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class PermissionChecker
{
  private static PermissionChecker jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionChecker;
  private PermissionParam jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
  private Boolean jdField_a_of_type_JavaLangBoolean = null;
  private WeakReference<PermissionListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  private static int a()
  {
    int j;
    if (VersionUtils.k())
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      int k = 0;
      j = 0;
      try
      {
        if (localBaseApplication.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
          j = 1;
        }
        int i = j;
        k = j;
        if (localBaseApplication.checkSelfPermission("android.permission.WRITE_CONTACTS") == 0) {
          i = j | 0x2;
        }
        k = i;
        int m = localBaseApplication.checkSelfPermission("android.permission.GET_ACCOUNTS");
        j = i;
        if (m != 0) {
          return j;
        }
        return i | 0x4;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CheckPermission exception:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d("IMCore.PhoneContact.PermissionChecker", 1, localStringBuilder.toString(), localThrowable);
        return k;
      }
    }
    else
    {
      j = 7;
    }
    return j;
  }
  
  public static PermissionChecker a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionChecker == null) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionChecker = new PermissionChecker();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionChecker;
  }
  
  public static void a(Activity paramActivity, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "checkReadContactPermission error");
      }
      return;
    }
    boolean bool = a().c();
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, String.format("checkReadContactPermission [%s, %s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(VersionUtils.k()) }));
    }
    if (bool)
    {
      if (paramRunnable1 != null) {
        paramRunnable1.run();
      }
    }
    else
    {
      if (VersionUtils.k())
      {
        if ((paramRunnable2 instanceof IReqPermissionRunnable)) {
          ((IReqPermissionRunnable)paramRunnable2).a();
        }
        PermissionParam localPermissionParam = new PermissionParam();
        localPermissionParam.jdField_a_of_type_JavaLangRunnable = paramRunnable1;
        localPermissionParam.jdField_b_of_type_JavaLangRunnable = paramRunnable2;
        localPermissionParam.jdField_a_of_type_Int = 1;
        a().a(paramActivity, localPermissionParam, null, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
        return;
      }
      if (paramRunnable2 != null) {
        paramRunnable2.run();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
    if (localObject != null)
    {
      ((PermissionParam)localObject).jdField_b_of_type_Int = a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPermissionResult = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam.jdField_b_of_type_Int);
      QLog.d("IMCore.PhoneContact.PermissionChecker", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (PermissionListener)((WeakReference)localObject).get();
      }
      if (localObject != null) {
        ((PermissionListener)localObject).a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam.a(paramBoolean);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam = null;
  }
  
  public static boolean a()
  {
    boolean bool1 = a("android.permission.READ_CONTACTS");
    boolean bool2 = a("android.permission.WRITE_CONTACTS");
    boolean bool3 = a("android.permission.GET_ACCOUNTS");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkLackOfPermission| readContactsPermission: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", writeContactsPermission: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", getAccountsPermission: ");
      localStringBuilder.append(bool3);
      QLog.d("IMCore.PhoneContact.PermissionChecker", 2, localStringBuilder.toString());
    }
    return (!bool1) || (!bool2) || (!bool3);
  }
  
  public static boolean a(String paramString)
  {
    Object localObject;
    if (VersionUtils.k())
    {
      localObject = BaseApplication.getContext();
      try
      {
        int i = ((Context)localObject).checkSelfPermission(paramString);
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CheckPermission exception:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("IMCore.PhoneContact.PermissionChecker", 1, ((StringBuilder)localObject).toString(), paramString);
        }
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: iload 4
    //   13: istore_3
    //   14: invokestatic 32	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 175	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: getstatic 181	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   23: iconst_1
    //   24: anewarray 100	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc 183
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: ldc 185
    //   36: invokevirtual 191	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 7
    //   41: aload 7
    //   43: astore 6
    //   45: iload 4
    //   47: istore_3
    //   48: aload 7
    //   50: astore 5
    //   52: aload 7
    //   54: invokeinterface 196 1 0
    //   59: istore_1
    //   60: iload_1
    //   61: ifle +5 -> 66
    //   64: iconst_1
    //   65: istore_2
    //   66: aload 7
    //   68: astore 6
    //   70: iload_2
    //   71: istore_3
    //   72: aload 7
    //   74: astore 5
    //   76: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +78 -> 157
    //   82: aload 7
    //   84: astore 6
    //   86: iload_2
    //   87: istore_3
    //   88: aload 7
    //   90: astore 5
    //   92: new 46	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   99: astore 8
    //   101: aload 7
    //   103: astore 6
    //   105: iload_2
    //   106: istore_3
    //   107: aload 7
    //   109: astore 5
    //   111: aload 8
    //   113: ldc 198
    //   115: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 7
    //   121: astore 6
    //   123: iload_2
    //   124: istore_3
    //   125: aload 7
    //   127: astore 5
    //   129: aload 8
    //   131: iload_1
    //   132: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 7
    //   138: astore 6
    //   140: iload_2
    //   141: istore_3
    //   142: aload 7
    //   144: astore 5
    //   146: ldc 59
    //   148: iconst_2
    //   149: aload 8
    //   151: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iload_2
    //   158: istore 4
    //   160: aload 7
    //   162: ifnull +59 -> 221
    //   165: aload 7
    //   167: astore 5
    //   169: aload 5
    //   171: invokeinterface 201 1 0
    //   176: iload_2
    //   177: ireturn
    //   178: astore 5
    //   180: goto +44 -> 224
    //   183: astore 7
    //   185: aload 5
    //   187: astore 6
    //   189: aload 7
    //   191: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   194: aload 5
    //   196: astore 6
    //   198: ldc 59
    //   200: iconst_1
    //   201: ldc 206
    //   203: aload 7
    //   205: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: iload_3
    //   209: istore 4
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: iload_3
    //   217: istore_2
    //   218: goto -49 -> 169
    //   221: iload 4
    //   223: ireturn
    //   224: aload 6
    //   226: ifnull +10 -> 236
    //   229: aload 6
    //   231: invokeinterface 201 1 0
    //   236: goto +6 -> 242
    //   239: aload 5
    //   241: athrow
    //   242: goto -3 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	PermissionChecker
    //   59	73	1	i	int
    //   4	214	2	bool1	boolean
    //   13	204	3	bool2	boolean
    //   1	221	4	bool3	boolean
    //   6	164	5	localObject1	Object
    //   178	62	5	localObject2	Object
    //   9	221	6	localObject3	Object
    //   39	127	7	localCursor	android.database.Cursor
    //   183	21	7	localException	java.lang.Exception
    //   99	51	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	41	178	finally
    //   52	60	178	finally
    //   76	82	178	finally
    //   92	101	178	finally
    //   111	119	178	finally
    //   129	136	178	finally
    //   146	157	178	finally
    //   189	194	178	finally
    //   198	208	178	finally
    //   14	41	183	java/lang/Exception
    //   52	60	183	java/lang/Exception
    //   76	82	183	java/lang/Exception
    //   92	101	183	java/lang/Exception
    //   111	119	183	java/lang/Exception
    //   129	136	183	java/lang/Exception
    //   146	157	183	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam = null;
  }
  
  public void a(Activity paramActivity, PermissionParam paramPermissionParam, PermissionListener paramPermissionListener, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      try
      {
        if ((paramActivity instanceof AppActivity))
        {
          AppActivity localAppActivity = (AppActivity)paramActivity;
          paramActivity = paramPermissionParam;
          if (paramPermissionParam == null) {
            paramActivity = new PermissionParam();
          }
          paramPermissionParam = new StringBuilder(512);
          ArrayList localArrayList = new ArrayList();
          int j = paramVarArgs.length;
          int i = 0;
          while (i < j)
          {
            String str = paramVarArgs[i];
            localArrayList.add(str);
            paramPermissionParam.append(str);
            paramPermissionParam.append(",");
            i += 1;
          }
          paramActivity.jdField_a_of_type_JavaUtilList = localArrayList;
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam = paramActivity;
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
          if (paramPermissionListener != null) {
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPermissionListener);
          }
          paramActivity = new StringBuilder();
          paramActivity.append("requestPermissions = ");
          paramActivity.append(paramPermissionParam.toString());
          QLog.d("IMCore.PhoneContact.PermissionChecker", 1, paramActivity.toString());
          localAppActivity.requestPermissions(this, 1, paramVarArgs);
          return;
        }
        QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "requestPermissions| activity is not AppActivity");
        return;
      }
      catch (Throwable paramActivity)
      {
        paramPermissionParam = new StringBuilder();
        paramPermissionParam.append("requestPermissions exception:");
        paramPermissionParam.append(paramActivity.getMessage());
        QLog.d("IMCore.PhoneContact.PermissionChecker", 1, paramPermissionParam.toString(), paramActivity);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2;
    boolean bool1;
    boolean bool3;
    if (VersionUtils.k())
    {
      bool2 = a("android.permission.READ_CONTACTS");
      bool1 = bool2;
      if ((bool1) && (paramBoolean)) {
        bool1 = d();
      }
      bool3 = true;
    }
    else
    {
      bool1 = d();
      bool3 = false;
      bool2 = false;
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    QLog.d("IMCore.PhoneContact.PermissionChecker", 1, String.format("hasReadContactPermission checkAgain=%b isM=%b ret=%b apiRet=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    return bool1;
  }
  
  public boolean b()
  {
    if (VersionUtils.k()) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(a("android.permission.READ_CONTACTS"));
    } else if (this.jdField_a_of_type_JavaLangBoolean == null) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    ThreadManager.excute(new PermissionChecker.1(this), 16, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", new Object[] { Boolean.valueOf(VersionUtils.k()), this.jdField_a_of_type_JavaLangBoolean }));
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public boolean c()
  {
    return a(false);
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "CheckPermission user denied = ");
    a(false);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "CheckPermission user grant = ");
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.permission.PermissionChecker
 * JD-Core Version:    0.7.0.1
 */