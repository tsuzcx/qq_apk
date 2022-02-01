package com.tencent.mobileqq.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.AggregationExceptions;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.Log;
import aqmk;
import aqml;
import aqmm;
import aqmn;
import aqmr;
import aqms;
import aqmt;
import avsy;
import aycd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ContactSyncManager
  implements Manager
{
  private static String jdField_a_of_type_JavaLangString = aqmk.jdField_a_of_type_JavaLangString;
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private volatile Account jdField_a_of_type_AndroidAccountsAccount;
  private AccountManager jdField_a_of_type_AndroidAccountsAccountManager;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new aqmn(this, ThreadManager.getSubThreadLooper());
  private aycd jdField_a_of_type_Aycd = new aqmm(this);
  public QQAppInterface a;
  private ContactSyncManager.RefreshContactRunnable jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable = new ContactSyncManager.RefreshContactRunnable(this, null);
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "pref_sync_contact";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = "com.android.contacts";
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  
  public ContactSyncManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "ContactSyncManager onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAccountsAccountManager = AccountManager.get(paramQQAppInterface.getApp());
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("contactsync", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_sync_contact", true);
    for (;;)
    {
      try
      {
        b();
        boolean bool = b();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "ContactSyncManager oncreate | support = " + bool);
        }
        if (!bool) {
          continue;
        }
        paramQQAppInterface.registObserver(this.jdField_a_of_type_Aycd);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "initSyncAccount e = ", localThrowable);
        continue;
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_remove_account_prefix" + paramQQAppInterface.getCurrentAccountUin(), false);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public static String a(String paramString)
  {
    String str = paramString;
    if (Build.MANUFACTURER.contains("OPPO")) {
      str = paramString.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace("&", "");
    }
    return str;
  }
  
  /* Error */
  private List<aqms> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_1
    //   11: new 225	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 226	java/util/ArrayList:<init>	()V
    //   18: astore 4
    //   20: aload_1
    //   21: aload_0
    //   22: invokespecial 228	com/tencent/mobileqq/contactsync/ContactSyncManager:c	()Ljava/lang/String;
    //   25: invokestatic 233	aqmr:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   28: getstatic 236	aqmr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +152 -> 191
    //   42: aload_2
    //   43: astore_1
    //   44: aload 4
    //   46: aload_2
    //   47: invokeinterface 248 1 0
    //   52: invokevirtual 252	java/util/ArrayList:ensureCapacity	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: invokeinterface 255 1 0
    //   63: ifeq +128 -> 191
    //   66: aload_2
    //   67: astore_1
    //   68: new 257	aqms
    //   71: dup
    //   72: invokespecial 258	aqms:<init>	()V
    //   75: astore_3
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: aload_2
    //   80: iconst_0
    //   81: invokeinterface 262 2 0
    //   86: putfield 265	aqms:jdField_a_of_type_Long	J
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: aload_2
    //   93: iconst_1
    //   94: invokeinterface 269 2 0
    //   99: putfield 270	aqms:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload_2
    //   103: astore_1
    //   104: aload_3
    //   105: aload_2
    //   106: iconst_2
    //   107: invokeinterface 274 2 0
    //   112: putfield 277	aqms:jdField_a_of_type_Int	I
    //   115: aload_2
    //   116: astore_1
    //   117: aload 4
    //   119: aload_3
    //   120: invokevirtual 281	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: goto -69 -> 55
    //   127: astore_3
    //   128: aload_2
    //   129: astore_1
    //   130: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +15 -> 148
    //   136: aload_2
    //   137: astore_1
    //   138: ldc 89
    //   140: iconst_2
    //   141: ldc_w 283
    //   144: aload_3
    //   145: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_2
    //   149: ifnull +9 -> 158
    //   152: aload_2
    //   153: invokeinterface 286 1 0
    //   158: ldc 89
    //   160: iconst_1
    //   161: new 134	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 288
    //   171: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 4
    //   176: invokevirtual 291	java/util/ArrayList:size	()I
    //   179: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 4
    //   190: areturn
    //   191: aload_2
    //   192: ifnull -34 -> 158
    //   195: aload_2
    //   196: invokeinterface 286 1 0
    //   201: goto -43 -> 158
    //   204: astore_1
    //   205: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -50 -> 158
    //   211: ldc 89
    //   213: iconst_2
    //   214: ldc_w 296
    //   217: aload_1
    //   218: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: goto -63 -> 158
    //   224: astore_1
    //   225: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq -70 -> 158
    //   231: ldc 89
    //   233: iconst_2
    //   234: ldc_w 296
    //   237: aload_1
    //   238: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: goto -83 -> 158
    //   244: astore_2
    //   245: aconst_null
    //   246: astore_1
    //   247: aload_1
    //   248: ifnull +9 -> 257
    //   251: aload_1
    //   252: invokeinterface 286 1 0
    //   257: aload_2
    //   258: athrow
    //   259: astore_1
    //   260: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -6 -> 257
    //   266: ldc 89
    //   268: iconst_2
    //   269: ldc_w 296
    //   272: aload_1
    //   273: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   276: goto -19 -> 257
    //   279: astore_2
    //   280: goto -33 -> 247
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_2
    //   286: goto -158 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ContactSyncManager
    //   10	128	1	localObject1	Object
    //   204	14	1	localThrowable1	Throwable
    //   224	14	1	localThrowable2	Throwable
    //   246	6	1	localObject2	Object
    //   259	14	1	localThrowable3	Throwable
    //   37	159	2	localCursor	android.database.Cursor
    //   244	14	2	localObject3	Object
    //   279	1	2	localObject4	Object
    //   285	1	2	localObject5	Object
    //   75	45	3	localaqms	aqms
    //   127	18	3	localException1	java.lang.Exception
    //   283	1	3	localException2	java.lang.Exception
    //   18	171	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   44	55	127	java/lang/Exception
    //   57	66	127	java/lang/Exception
    //   68	76	127	java/lang/Exception
    //   78	89	127	java/lang/Exception
    //   91	102	127	java/lang/Exception
    //   104	115	127	java/lang/Exception
    //   117	124	127	java/lang/Exception
    //   195	201	204	java/lang/Throwable
    //   152	158	224	java/lang/Throwable
    //   20	38	244	finally
    //   251	257	259	java/lang/Throwable
    //   44	55	279	finally
    //   57	66	279	finally
    //   68	76	279	finally
    //   78	89	279	finally
    //   91	102	279	finally
    //   104	115	279	finally
    //   117	124	279	finally
    //   130	136	279	finally
    //   138	148	279	finally
    //   20	38	283	java/lang/Exception
  }
  
  private Map<String, PhoneContact> a()
  {
    List localList = ((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
    if (localList != null)
    {
      HashMap localHashMap = new HashMap(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (!TextUtils.isEmpty(localPhoneContact.uin)) {
          localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getQQContacts | allList.size = " + localList.size() + " | map.size=" + localHashMap.size());
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | current authority = " + this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_JavaLangString.equals("com.android.contacts"))
    {
      Object localObject = d();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | find substitute authority = " + (String)localObject);
        }
        this.jdField_c_of_type_JavaLangString = ((String)localObject);
        localObject = this.jdField_a_of_type_AndroidAccountsAccount;
        if (localObject != null) {
          ContentResolver.setSyncAutomatically((Account)localObject, this.jdField_c_of_type_JavaLangString, true);
        }
        b(3);
      }
    }
  }
  
  private void a(long paramLong, List<ContentProviderOperation> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_a_of_type_JavaLangString).build(), "_id = ?", new String[] { paramLong + "" });
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteRawContact | leave");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Account paramAccount)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "markAccountDeleteByUser | accountSetIDel = " + jdField_a_of_type_JavaUtilSet + " | name = " + paramAccount.name + " | contain = " + jdField_a_of_type_JavaUtilSet.contains(paramAccount.name));
      }
      if (jdField_a_of_type_JavaUtilSet.remove(paramAccount.name)) {
        return;
      }
      paramQQAppInterface.getApp().getSharedPreferences("contactsync", 0).edit().putBoolean("pref_remove_account_prefix" + paramAccount.name, true).apply();
      ??? = (ContactSyncManager)paramQQAppInterface.getManager(41);
      if (??? != null)
      {
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals(e(paramAccount.name)))) {
          ((ContactSyncManager)???).jdField_b_of_type_Boolean = true;
        }
        ((ContactSyncManager)???).jdField_a_of_type_AndroidAccountsAccount = null;
        ((ContactSyncManager)???).d = false;
        return;
      }
    }
  }
  
  private void a(List<ContentProviderOperation> paramList, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id1", Long.valueOf(paramLong1));
    localContentValues.put("raw_contact_id2", Long.valueOf(paramLong2));
    localContentValues.put("type", Integer.valueOf(1));
    paramList.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(localContentValues).withYieldAllowed(true).build());
  }
  
  private void a(List<ContentProviderOperation> paramList, PhoneContact paramPhoneContact)
  {
    paramList = aqml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, c(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.a(paramPhoneContact.name);
    paramList.b(paramPhoneContact.mobileNo);
  }
  
  /* Error */
  private void a(List<ContentProviderOperation> paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: aload_1
    //   5: lload_3
    //   6: invokestatic 530	aqml:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;J)Laqml;
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 534	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   18: invokevirtual 537	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore_1
    //   22: aload_1
    //   23: getstatic 541	aqmp:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   26: getstatic 542	aqmp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc_w 544
    //   32: iconst_1
    //   33: anewarray 189	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: lload_3
    //   39: invokestatic 547	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +114 -> 165
    //   54: aload 5
    //   56: astore_1
    //   57: aload 5
    //   59: invokeinterface 255 1 0
    //   64: ifeq +101 -> 165
    //   67: aload 5
    //   69: astore_1
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 269 2 0
    //   78: ldc_w 549
    //   81: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -30 -> 54
    //   87: aload 5
    //   89: astore_1
    //   90: aload 5
    //   92: iconst_2
    //   93: invokeinterface 269 2 0
    //   98: astore 7
    //   100: aload 5
    //   102: astore_1
    //   103: aload 7
    //   105: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +18 -> 126
    //   111: aload 5
    //   113: astore_1
    //   114: aload 7
    //   116: aload_2
    //   117: getfield 520	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   120: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +42 -> 165
    //   126: aload 5
    //   128: astore_1
    //   129: aload 5
    //   131: iconst_0
    //   132: invokeinterface 262 2 0
    //   137: lstore_3
    //   138: aload 5
    //   140: astore_1
    //   141: getstatic 541	aqmp:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   144: lload_3
    //   145: invokestatic 555	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   148: astore 7
    //   150: aload 5
    //   152: astore_1
    //   153: aload 6
    //   155: aload_2
    //   156: getfield 520	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   159: aload 7
    //   161: invokevirtual 558	aqml:a	(Ljava/lang/String;Landroid/net/Uri;)Laqml;
    //   164: pop
    //   165: aload 5
    //   167: ifnull +10 -> 177
    //   170: aload 5
    //   172: invokeinterface 286 1 0
    //   177: return
    //   178: astore_1
    //   179: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -5 -> 177
    //   185: ldc 89
    //   187: iconst_2
    //   188: ldc_w 560
    //   191: aload_1
    //   192: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_2
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: astore_1
    //   203: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +16 -> 222
    //   209: aload 5
    //   211: astore_1
    //   212: ldc 89
    //   214: iconst_2
    //   215: ldc_w 562
    //   218: aload_2
    //   219: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 5
    //   224: ifnull -47 -> 177
    //   227: aload 5
    //   229: invokeinterface 286 1 0
    //   234: return
    //   235: astore_1
    //   236: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -62 -> 177
    //   242: ldc 89
    //   244: iconst_2
    //   245: ldc_w 560
    //   248: aload_1
    //   249: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: return
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 286 1 0
    //   266: aload_2
    //   267: athrow
    //   268: astore_1
    //   269: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -6 -> 266
    //   275: ldc 89
    //   277: iconst_2
    //   278: ldc_w 560
    //   281: aload_1
    //   282: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -19 -> 266
    //   288: astore_2
    //   289: goto -33 -> 256
    //   292: astore_2
    //   293: goto -93 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	ContactSyncManager
    //   0	296	1	paramList	List<ContentProviderOperation>
    //   0	296	2	paramPhoneContact	PhoneContact
    //   0	296	3	paramLong	long
    //   47	181	5	localCursor	android.database.Cursor
    //   9	145	6	localaqml	aqml
    //   98	62	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   170	177	178	java/lang/Throwable
    //   22	49	196	java/lang/Exception
    //   227	234	235	java/lang/Throwable
    //   22	49	253	finally
    //   260	266	268	java/lang/Throwable
    //   57	67	288	finally
    //   70	87	288	finally
    //   90	100	288	finally
    //   103	111	288	finally
    //   114	126	288	finally
    //   129	138	288	finally
    //   141	150	288	finally
    //   153	165	288	finally
    //   203	209	288	finally
    //   212	222	288	finally
    //   57	67	292	java/lang/Exception
    //   70	87	292	java/lang/Exception
    //   90	100	292	java/lang/Exception
    //   103	111	292	java/lang/Exception
    //   114	126	292	java/lang/Exception
    //   129	138	292	java/lang/Exception
    //   141	150	292	java/lang/Exception
    //   153	165	292	java/lang/Exception
  }
  
  private boolean a(String paramString)
  {
    if (f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, String.format("doSyncContacts | shouldStopSync = true | pos = %s", new Object[] { paramString }));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "applyBatch | enter");
    }
    boolean bool = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().applyBatch(this.jdField_c_of_type_JavaLangString, paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "applyBatch | result = " + bool + " | leave");
      }
      return bool;
    }
    catch (RemoteException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (IllegalArgumentException paramArrayList)
    {
      for (;;)
      {
        String str = Log.getStackTraceString(paramArrayList);
        if ((!TextUtils.isEmpty(str)) && (str.contains("Unknown authority"))) {
          a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: ", paramArrayList);
        }
        bool = false;
      }
    }
  }
  
  private boolean a(ArrayList<ContentProviderOperation> paramArrayList, int paramInt, String paramString)
  {
    if ((paramArrayList.size() > paramInt) && (!f()))
    {
      boolean bool = a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, String.format("applyBatchOn | %s | res=%b size=%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramArrayList.size()) }));
      }
      paramArrayList.clear();
      return bool;
    }
    return false;
  }
  
  private boolean a(Map<String, PhoneContact> paramMap, int paramInt)
  {
    label1099:
    label1105:
    label1110:
    label1116:
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        bool = a("enter");
        if (bool)
        {
          bool = false;
          return bool;
        }
        Object localObject3 = a();
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if ((localObject1 == null) || (!((PhoneContactManagerImp)localObject1).l())) {
            break label1105;
          }
          i = 1;
          if (i == 0)
          {
            if (!QLog.isColorLevel()) {
              break label1099;
            }
            QLog.d("ContactSync.Manager", 2, "doSyncContacts no read contacts permission !");
            break label1099;
          }
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = new HashSet(paramMap.size());
        localObject1 = new HashSet();
        int m = 0;
        int n = 0;
        i = 0;
        int i1 = paramMap.size();
        int k = 0;
        Iterator localIterator = ((List)localObject3).iterator();
        if (localIterator.hasNext())
        {
          aqms localaqms = (aqms)localIterator.next();
          if (a("for1"))
          {
            bool = false;
            continue;
          }
          String str = localaqms.jdField_a_of_type_JavaLangString;
          if ((TextUtils.isEmpty(str)) || (!paramMap.containsKey(localaqms.jdField_a_of_type_JavaLangString)))
          {
            a(localaqms.jdField_a_of_type_Long, localArrayList);
            j = m + 1;
            m = j;
            if (j >= 15) {
              continue;
            }
            m = j;
            if (k >= 3) {
              continue;
            }
            m = j;
            if (!aqmt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqms.jdField_a_of_type_Int)) {
              continue;
            }
            k += 1;
            m = j;
            continue;
          }
          if ((TextUtils.isEmpty(str)) || (!paramMap.containsKey(str))) {
            continue;
          }
          if (((Set)localObject2).contains(Integer.valueOf(localaqms.jdField_a_of_type_Int)))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ContactSync.Manager", 2, "doSyncContacts | error: duplicate contact id");
            }
            n += 1;
            a(localaqms.jdField_a_of_type_Long, localArrayList);
            paramMap.remove(str);
            continue;
          }
          ((Set)localObject2).add(Integer.valueOf(localaqms.jdField_a_of_type_Int));
          j = i;
          if (((PhoneContact)paramMap.get(str)).contactID == localaqms.jdField_a_of_type_Int) {
            break label1110;
          }
          ((Set)localObject1).add(localaqms.jdField_a_of_type_JavaLangString);
          j = i + 1;
          a(localArrayList, (PhoneContact)paramMap.get(str), localaqms.jdField_a_of_type_Long);
          break label1110;
        }
        paramMap = paramMap.values();
        QLog.d("ContactSync.Manager", 1, String.format("doSyncContacts syncFrom|selfUin|syncUin|qqContactSize|rawContactSize|delCnt|delCntConflict|aggCnt|willInsertCnt|dangersDelCnt = %d|%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), b(a()), Integer.valueOf(i1), Integer.valueOf(((List)localObject3).size()), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(paramMap.size()), Integer.valueOf(k) }));
        aqmt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, i1, ((List)localObject3).size(), m, n, k, paramMap.size());
        a(localArrayList, 0, "doSyncContacts apply update ops");
        paramMap = paramMap.iterator();
        paramInt = 0;
        if (paramMap.hasNext())
        {
          localObject3 = (PhoneContact)paramMap.next();
          if (a("for2"))
          {
            bool = false;
            continue;
          }
          if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID)))
          {
            a(localArrayList, (PhoneContact)localObject3);
            ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
            ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
            paramInt += 1;
            a(localArrayList, 500, "doSyncContacts apply insert ops");
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label1116;
          }
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | contact " + ((PhoneContact)localObject3).contactID + " has two match phonenum");
          break label1116;
        }
        a(localArrayList, 0, "doSyncContacts apply insert ops left");
        QLog.d("ContactSync.Manager", 1, String.format("doSyncContacts realInsertCnt|aggCnt = %d|%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((Set)localObject1).size()) }));
        if (((Set)localObject1).size() == 0)
        {
          bool = true;
          continue;
        }
        localArrayList.clear();
        localArrayList.ensureCapacity(((Set)localObject1).size());
        localObject2 = a();
        paramMap = b();
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aqms)((Iterator)localObject2).next();
          if ((((Set)localObject1).contains(((aqms)localObject3).jdField_a_of_type_JavaLangString)) && (paramMap.containsKey(((aqms)localObject3).jdField_a_of_type_JavaLangString)))
          {
            a(localArrayList, ((aqms)localObject3).jdField_a_of_type_Long, ((Long)paramMap.get(((aqms)localObject3).jdField_a_of_type_JavaLangString)).longValue());
            ((Set)localObject1).remove(((aqms)localObject3).jdField_a_of_type_JavaLangString);
          }
          a(localArrayList, 500, "doSyncContacts apply aggregate batch");
          continue;
        }
        a(localArrayList, 0, "doSyncContacts apply aggregate batch left");
      }
      finally {}
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder(1024);
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramMap.append(c((String)((Iterator)localObject1).next())).append("|");
        }
        QLog.d("ContactSync.Manager", 2, String.format("doSyncContacts | remain source IDs = [%s] | leave", new Object[] { paramMap.toString() }));
      }
      boolean bool = true;
      continue;
      bool = false;
      continue;
      int i = 0;
      continue;
      i = j;
    }
  }
  
  public static String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid uin";
    }
    return paramString.substring(0, 3);
  }
  
  /* Error */
  private Map<String, Long> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: new 309	java/util/HashMap
    //   14: dup
    //   15: invokespecial 352	java/util/HashMap:<init>	()V
    //   18: astore_1
    //   19: aload_2
    //   20: getstatic 733	aqmq:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   23: getstatic 734	aqmq:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +216 -> 250
    //   37: aload_2
    //   38: astore_3
    //   39: new 309	java/util/HashMap
    //   42: dup
    //   43: aload_2
    //   44: invokeinterface 248 1 0
    //   49: invokespecial 314	java/util/HashMap:<init>	(I)V
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_2
    //   57: invokeinterface 255 1 0
    //   62: ifeq +78 -> 140
    //   65: aload_2
    //   66: astore_3
    //   67: aload 4
    //   69: aload_2
    //   70: iconst_0
    //   71: invokeinterface 269 2 0
    //   76: invokestatic 738	aihb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: aload_2
    //   80: iconst_3
    //   81: invokeinterface 262 2 0
    //   86: invokestatic 462	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 739	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: goto -39 -> 54
    //   96: astore_3
    //   97: aload 4
    //   99: astore_1
    //   100: aload_3
    //   101: astore 4
    //   103: aload_2
    //   104: astore_3
    //   105: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +16 -> 124
    //   111: aload_2
    //   112: astore_3
    //   113: ldc 89
    //   115: iconst_2
    //   116: ldc_w 741
    //   119: aload 4
    //   121: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: astore_3
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokeinterface 286 1 0
    //   136: aload_1
    //   137: astore_3
    //   138: aload_3
    //   139: areturn
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: astore_3
    //   145: aload_2
    //   146: ifnull -8 -> 138
    //   149: aload_2
    //   150: invokeinterface 286 1 0
    //   155: aload_1
    //   156: areturn
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq -25 -> 138
    //   166: ldc 89
    //   168: iconst_2
    //   169: ldc_w 743
    //   172: aload_2
    //   173: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -46 -> 138
    //   187: ldc 89
    //   189: iconst_2
    //   190: ldc_w 743
    //   193: aload_2
    //   194: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_1
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: ifnull +9 -> 212
    //   206: aload_3
    //   207: invokeinterface 286 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -6 -> 212
    //   221: ldc 89
    //   223: iconst_2
    //   224: ldc_w 743
    //   227: aload_2
    //   228: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto -19 -> 212
    //   234: astore_1
    //   235: goto -33 -> 202
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_2
    //   242: goto -139 -> 103
    //   245: astore 4
    //   247: goto -144 -> 103
    //   250: goto -107 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ContactSyncManager
    //   18	180	1	localObject1	Object
    //   199	14	1	localObject2	Object
    //   234	1	1	localObject3	Object
    //   10	140	2	localObject4	Object
    //   157	16	2	localThrowable1	Throwable
    //   178	16	2	localThrowable2	Throwable
    //   214	14	2	localThrowable3	Throwable
    //   241	1	2	localObject5	Object
    //   38	29	3	localObject6	Object
    //   96	5	3	localException1	java.lang.Exception
    //   104	103	3	localObject7	Object
    //   52	89	4	localObject8	Object
    //   238	1	4	localException2	java.lang.Exception
    //   245	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   56	65	96	java/lang/Exception
    //   67	93	96	java/lang/Exception
    //   149	155	157	java/lang/Throwable
    //   130	136	178	java/lang/Throwable
    //   19	33	199	finally
    //   206	212	214	java/lang/Throwable
    //   39	54	234	finally
    //   56	65	234	finally
    //   67	93	234	finally
    //   105	111	234	finally
    //   113	124	234	finally
    //   19	33	238	java/lang/Exception
    //   39	54	245	java/lang/Exception
  }
  
  private void b()
  {
    Account[] arrayOfAccount = this.jdField_a_of_type_AndroidAccountsAccountManager.getAccountsByType("com.tencent.mobileqq.account");
    if (arrayOfAccount.length > 0)
    {
      this.jdField_a_of_type_AndroidAccountsAccount = arrayOfAccount[0];
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "initSyncAccount | syncAccount = " + this.jdField_a_of_type_AndroidAccountsAccount);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ContactSyncManager.4(this, arrayOfAccount));
    }
  }
  
  private String c()
  {
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid phone num";
    }
    return paramString.substring(paramString.length() - 3);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 772 1 0
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 365	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccount	Landroid/accounts/Account;
    //   14: aload_0
    //   15: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccountManager	Landroid/accounts/AccountManager;
    //   18: ldc_w 746
    //   21: invokevirtual 750	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   24: astore 4
    //   26: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc 89
    //   34: iconst_2
    //   35: new 134	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 774
    //   45: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: arraylength
    //   51: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload 4
    //   62: arraylength
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_1
    //   66: iload_1
    //   67: iload_2
    //   68: if_icmpge +130 -> 198
    //   71: aload 4
    //   73: iload_1
    //   74: aaload
    //   75: astore 5
    //   77: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +36 -> 116
    //   83: ldc 89
    //   85: iconst_2
    //   86: new 134	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 776
    //   96: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 5
    //   101: getfield 421	android/accounts/Account:name	Ljava/lang/String;
    //   104: invokestatic 674	com/tencent/mobileqq/contactsync/ContactSyncManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: getstatic 36	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   119: astore_3
    //   120: aload_3
    //   121: monitorenter
    //   122: getstatic 36	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   125: aload 5
    //   127: getfield 421	android/accounts/Account:name	Ljava/lang/String;
    //   130: invokeinterface 660 2 0
    //   135: pop
    //   136: aload_3
    //   137: monitorexit
    //   138: aload_0
    //   139: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccountManager	Landroid/accounts/AccountManager;
    //   142: aload 5
    //   144: new 778	aqmo
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 779	aqmo:<init>	(Lcom/tencent/mobileqq/contactsync/ContactSyncManager;)V
    //   152: aconst_null
    //   153: invokevirtual 783	android/accounts/AccountManager:removeAccount	(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   156: pop
    //   157: iload_1
    //   158: iconst_1
    //   159: iadd
    //   160: istore_1
    //   161: goto -95 -> 66
    //   164: astore 4
    //   166: aload_3
    //   167: monitorexit
    //   168: aload 4
    //   170: athrow
    //   171: astore_3
    //   172: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +13 -> 188
    //   178: ldc 89
    //   180: iconst_2
    //   181: ldc_w 785
    //   184: aload_3
    //   185: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_0
    //   189: getfield 54	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   192: invokeinterface 788 1 0
    //   197: return
    //   198: aload_0
    //   199: getfield 54	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   202: invokeinterface 788 1 0
    //   207: return
    //   208: astore_3
    //   209: aload_0
    //   210: getfield 54	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   213: invokeinterface 788 1 0
    //   218: aload_3
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ContactSyncManager
    //   65	96	1	i	int
    //   63	6	2	j	int
    //   171	14	3	localThrowable	Throwable
    //   208	11	3	localObject1	Object
    //   24	48	4	arrayOfAccount	Account[]
    //   164	5	4	localObject2	Object
    //   75	68	5	localAccount	Account
    // Exception table:
    //   from	to	target	type
    //   122	138	164	finally
    //   166	168	164	finally
    //   9	60	171	java/lang/Throwable
    //   60	64	171	java/lang/Throwable
    //   77	116	171	java/lang/Throwable
    //   116	122	171	java/lang/Throwable
    //   138	157	171	java/lang/Throwable
    //   168	171	171	java/lang/Throwable
    //   9	60	208	finally
    //   60	64	208	finally
    //   77	116	208	finally
    //   116	122	208	finally
    //   138	157	208	finally
    //   168	171	208	finally
    //   172	188	208	finally
  }
  
  private String d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageManager().queryContentProviders(null, 0, 131072);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProviderInfo localProviderInfo = (ProviderInfo)((Iterator)localObject).next();
        if ((localProviderInfo.authority.contains("contacts")) && (!localProviderInfo.authority.equals("com.android.contacts"))) {
          return localProviderInfo.authority;
        }
      }
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() > 4))
    {
      localObject = new StringBuilder();
      int j = paramString.length() - 4;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append("*");
        i += 1;
      }
      ((StringBuilder)localObject).append(paramString.substring(j));
      localObject = ((StringBuilder)localObject).toString();
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString != null);
    return "";
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("pref_remove_account_prefix" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).apply();
    if (QLog.isColorLevel()) {
      QLog.i("ContactSync.Manager", 2, "markCurrentUserRebirth");
    }
  }
  
  private boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldAddAccount | is device support = " + b() + " | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean + " | hasIRemovedByUser = " + this.jdField_b_of_type_Boolean);
    }
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Object localObject = a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldAddAccount | syncUin = " + b((String)localObject) + " | currentUin = " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        return false;
      }
      localObject = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("coundlAddAccount | pcm = ").append(localObject).append(" | bindState = ");
        if (localObject == null) {
          break label310;
        }
      }
      label310:
      for (int i = ((avsy)localObject).d();; i = -1000)
      {
        QLog.d("ContactSync.Manager", 2, i);
        if ((localObject == null) || (!((avsy)localObject).d())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "couldAddAccount | bind state = " + ((avsy)localObject).d());
        }
        return true;
      }
    }
    return false;
  }
  
  private static String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("(");
      int j = paramString.lastIndexOf(")");
      if ((i != -1) && (j != -1)) {
        return paramString.substring(i + 1, j);
      }
    }
    return null;
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldSyncContact | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = a();
        avsy localavsy = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        StringBuilder localStringBuilder = new StringBuilder().append("couldSyncContact | bind state = ");
        if (localavsy == null) {
          break label276;
        }
        i = 9;
        QLog.d("ContactSync.Manager", 1, i + " | account.name = " + b((String)localObject));
        bool1 = bool2;
        if (localavsy != null)
        {
          bool1 = bool2;
          if (localavsy.d())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject))
            {
              localObject = this.jdField_a_of_type_AndroidAccountsAccount;
              if (localObject == null) {
                break label288;
              }
              bool2 = ContentResolver.getSyncAutomatically((Account)localObject, this.jdField_c_of_type_JavaLangString);
              if (ContentResolver.getIsSyncable((Account)localObject, this.jdField_c_of_type_JavaLangString) <= 0) {
                break label283;
              }
              bool1 = true;
              label220:
              bool3 = ContentResolver.getMasterSyncAutomatically();
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ContactSync.Manager", 1, "couldSyncContact | isSystemSyncAutomatic = " + bool2 + " | isSystemSyncable = " + bool1 + " | isMasterSyncAutomatic = " + bool3);
      bool1 = bool2;
      return bool1;
      label276:
      i = -100000;
      break;
      label283:
      bool1 = false;
      break label220;
      label288:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = true;
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    boolean bool1;
    StringBuilder localStringBuilder;
    if ((localAccount == null) || (Thread.interrupted()))
    {
      bool1 = true;
      if ((bool1) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder().append("shouldStopSync | account = ");
        if (localAccount != null) {
          break label82;
        }
      }
    }
    for (;;)
    {
      QLog.d("ContactSync.Manager", 2, bool2 + " | interrupted = " + Thread.interrupted());
      return bool1;
      bool1 = false;
      break;
      label82:
      bool2 = false;
    }
  }
  
  private boolean g()
  {
    boolean bool = d();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "addSyncAccount | could add account = " + bool);
    }
    if (!bool) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Account localAccount = new Account(a(String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() })), "com.tencent.mobileqq.account");
        if (!this.jdField_a_of_type_AndroidAccountsAccountManager.addAccountExplicitly(localAccount, null, null)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly success");
        }
        this.jdField_a_of_type_AndroidAccountsAccount = localAccount;
        ContentResolver.setIsSyncable(this.jdField_a_of_type_AndroidAccountsAccount, this.jdField_c_of_type_JavaLangString, 1);
        ContentResolver.setSyncAutomatically(localAccount, this.jdField_c_of_type_JavaLangString, true);
        b(2);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | e = ", localThrowable);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly fail");
      }
    }
  }
  
  /* Error */
  public aqmu a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 6
    //   12: aload 6
    //   14: aload_1
    //   15: iconst_1
    //   16: anewarray 189	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 911
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +681 -> 714
    //   36: aload_1
    //   37: astore 4
    //   39: aload_1
    //   40: invokeinterface 255 1 0
    //   45: ifeq +669 -> 714
    //   48: aload_1
    //   49: astore 4
    //   51: aload_1
    //   52: iconst_0
    //   53: invokeinterface 262 2 0
    //   58: lstore_2
    //   59: aload_1
    //   60: ifnull +651 -> 711
    //   63: aload_1
    //   64: invokeinterface 286 1 0
    //   69: lload_2
    //   70: ldc2_w 912
    //   73: lcmp
    //   74: ifne +137 -> 211
    //   77: aconst_null
    //   78: areturn
    //   79: astore 4
    //   81: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +14 -> 98
    //   87: ldc 89
    //   89: iconst_2
    //   90: ldc_w 915
    //   93: aload 4
    //   95: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -29 -> 69
    //   101: astore 5
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore 4
    //   108: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +17 -> 128
    //   114: aload_1
    //   115: astore 4
    //   117: ldc 89
    //   119: iconst_2
    //   120: ldc_w 917
    //   123: aload 5
    //   125: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull +575 -> 704
    //   132: aload_1
    //   133: invokeinterface 286 1 0
    //   138: ldc2_w 912
    //   141: lstore_2
    //   142: goto -73 -> 69
    //   145: astore 4
    //   147: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +14 -> 164
    //   153: ldc 89
    //   155: iconst_2
    //   156: ldc_w 915
    //   159: aload 4
    //   161: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: ldc2_w 912
    //   167: lstore_2
    //   168: goto -99 -> 69
    //   171: astore_1
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +10 -> 187
    //   180: aload 4
    //   182: invokeinterface 286 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore 4
    //   191: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -7 -> 187
    //   197: ldc 89
    //   199: iconst_2
    //   200: ldc_w 915
    //   203: aload 4
    //   205: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -21 -> 187
    //   211: new 919	aqmu
    //   214: dup
    //   215: invokespecial 920	aqmu:<init>	()V
    //   218: astore 7
    //   220: aload 6
    //   222: getstatic 541	aqmp:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   225: getstatic 542	aqmp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   228: ldc_w 544
    //   231: iconst_1
    //   232: anewarray 189	java/lang/String
    //   235: dup
    //   236: iconst_0
    //   237: lload_2
    //   238: invokestatic 547	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: aastore
    //   242: aconst_null
    //   243: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   246: astore 4
    //   248: aload 4
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +49 -> 301
    //   255: aload_1
    //   256: astore 4
    //   258: aload_1
    //   259: invokeinterface 255 1 0
    //   264: ifeq +37 -> 301
    //   267: aload_1
    //   268: astore 4
    //   270: aload_1
    //   271: iconst_1
    //   272: invokeinterface 269 2 0
    //   277: ldc_w 549
    //   280: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq -28 -> 255
    //   286: aload_1
    //   287: astore 4
    //   289: aload 7
    //   291: aload_1
    //   292: iconst_2
    //   293: invokeinterface 269 2 0
    //   298: putfield 921	aqmu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_1
    //   302: astore 4
    //   304: aload_1
    //   305: ifnull +393 -> 698
    //   308: aload_1
    //   309: invokeinterface 286 1 0
    //   314: aload 6
    //   316: getstatic 378	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   319: getstatic 923	aqmr:b	[Ljava/lang/String;
    //   322: ldc_w 925
    //   325: iconst_1
    //   326: anewarray 189	java/lang/String
    //   329: dup
    //   330: iconst_0
    //   331: lload_2
    //   332: invokestatic 547	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: aastore
    //   336: aconst_null
    //   337: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   340: astore 4
    //   342: aload 4
    //   344: ifnull +64 -> 408
    //   347: aload 4
    //   349: astore_1
    //   350: aload 4
    //   352: invokeinterface 255 1 0
    //   357: ifeq +51 -> 408
    //   360: aload 4
    //   362: astore_1
    //   363: aload 7
    //   365: aload 4
    //   367: iconst_0
    //   368: invokeinterface 269 2 0
    //   373: putfield 926	aqmu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   376: aload 4
    //   378: astore_1
    //   379: aload 7
    //   381: aload 4
    //   383: iconst_1
    //   384: invokeinterface 269 2 0
    //   389: putfield 927	aqmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   392: aload 4
    //   394: astore_1
    //   395: aload 7
    //   397: aload 4
    //   399: iconst_2
    //   400: invokeinterface 274 2 0
    //   405: putfield 928	aqmu:jdField_a_of_type_Int	I
    //   408: aload 4
    //   410: ifnull +10 -> 420
    //   413: aload 4
    //   415: invokeinterface 286 1 0
    //   420: aload 7
    //   422: areturn
    //   423: astore 4
    //   425: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +14 -> 442
    //   431: ldc 89
    //   433: iconst_2
    //   434: ldc_w 930
    //   437: aload 4
    //   439: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -128 -> 314
    //   445: astore 5
    //   447: aload_1
    //   448: astore 4
    //   450: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +17 -> 470
    //   456: aload_1
    //   457: astore 4
    //   459: ldc 89
    //   461: iconst_2
    //   462: ldc_w 917
    //   465: aload 5
    //   467: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_1
    //   471: astore 4
    //   473: aload_1
    //   474: ifnull +224 -> 698
    //   477: aload_1
    //   478: invokeinterface 286 1 0
    //   483: goto -169 -> 314
    //   486: astore 4
    //   488: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +14 -> 505
    //   494: ldc 89
    //   496: iconst_2
    //   497: ldc_w 930
    //   500: aload 4
    //   502: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: goto -191 -> 314
    //   508: astore 5
    //   510: aload_1
    //   511: astore 4
    //   513: aload 5
    //   515: astore_1
    //   516: aload 4
    //   518: ifnull +10 -> 528
    //   521: aload 4
    //   523: invokeinterface 286 1 0
    //   528: aload_1
    //   529: athrow
    //   530: astore 4
    //   532: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq -7 -> 528
    //   538: ldc 89
    //   540: iconst_2
    //   541: ldc_w 930
    //   544: aload 4
    //   546: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: goto -21 -> 528
    //   552: astore_1
    //   553: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq -136 -> 420
    //   559: ldc 89
    //   561: iconst_2
    //   562: ldc_w 932
    //   565: aload_1
    //   566: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   569: goto -149 -> 420
    //   572: astore 5
    //   574: aload_1
    //   575: astore 4
    //   577: aload 4
    //   579: astore_1
    //   580: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +17 -> 600
    //   586: aload 4
    //   588: astore_1
    //   589: ldc 89
    //   591: iconst_2
    //   592: ldc_w 917
    //   595: aload 5
    //   597: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   600: aload 4
    //   602: ifnull -182 -> 420
    //   605: aload 4
    //   607: invokeinterface 286 1 0
    //   612: goto -192 -> 420
    //   615: astore_1
    //   616: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq -199 -> 420
    //   622: ldc 89
    //   624: iconst_2
    //   625: ldc_w 932
    //   628: aload_1
    //   629: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   632: goto -212 -> 420
    //   635: astore 4
    //   637: aload_1
    //   638: ifnull +9 -> 647
    //   641: aload_1
    //   642: invokeinterface 286 1 0
    //   647: aload 4
    //   649: athrow
    //   650: astore_1
    //   651: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -7 -> 647
    //   657: ldc 89
    //   659: iconst_2
    //   660: ldc_w 932
    //   663: aload_1
    //   664: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: goto -20 -> 647
    //   670: astore 4
    //   672: goto -35 -> 637
    //   675: astore 5
    //   677: goto -100 -> 577
    //   680: astore_1
    //   681: goto -165 -> 516
    //   684: astore 5
    //   686: goto -239 -> 447
    //   689: astore_1
    //   690: goto -515 -> 175
    //   693: astore 5
    //   695: goto -590 -> 105
    //   698: aload 4
    //   700: astore_1
    //   701: goto -387 -> 314
    //   704: ldc2_w 912
    //   707: lstore_2
    //   708: goto -639 -> 69
    //   711: goto -642 -> 69
    //   714: ldc2_w 912
    //   717: lstore_2
    //   718: goto -659 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	ContactSyncManager
    //   0	721	1	paramUri	Uri
    //   58	660	2	l	long
    //   37	13	4	localUri1	Uri
    //   79	15	4	localThrowable1	Throwable
    //   106	10	4	localUri2	Uri
    //   145	15	4	localThrowable2	Throwable
    //   173	8	4	localObject1	Object
    //   189	15	4	localThrowable3	Throwable
    //   246	168	4	localObject2	Object
    //   423	15	4	localThrowable4	Throwable
    //   448	24	4	localUri3	Uri
    //   486	15	4	localThrowable5	Throwable
    //   511	11	4	localUri4	Uri
    //   530	15	4	localThrowable6	Throwable
    //   575	31	4	localUri5	Uri
    //   635	13	4	localObject3	Object
    //   670	29	4	localObject4	Object
    //   101	23	5	localException1	java.lang.Exception
    //   445	21	5	localException2	java.lang.Exception
    //   508	6	5	localObject5	Object
    //   572	24	5	localException3	java.lang.Exception
    //   675	1	5	localException4	java.lang.Exception
    //   684	1	5	localException5	java.lang.Exception
    //   693	1	5	localException6	java.lang.Exception
    //   10	305	6	localContentResolver	ContentResolver
    //   218	203	7	localaqmu	aqmu
    // Exception table:
    //   from	to	target	type
    //   63	69	79	java/lang/Throwable
    //   12	32	101	java/lang/Exception
    //   132	138	145	java/lang/Throwable
    //   12	32	171	finally
    //   180	187	189	java/lang/Throwable
    //   308	314	423	java/lang/Throwable
    //   220	248	445	java/lang/Exception
    //   477	483	486	java/lang/Throwable
    //   220	248	508	finally
    //   521	528	530	java/lang/Throwable
    //   413	420	552	java/lang/Throwable
    //   314	342	572	java/lang/Exception
    //   605	612	615	java/lang/Throwable
    //   314	342	635	finally
    //   641	647	650	java/lang/Throwable
    //   350	360	670	finally
    //   363	376	670	finally
    //   379	392	670	finally
    //   395	408	670	finally
    //   580	586	670	finally
    //   589	600	670	finally
    //   350	360	675	java/lang/Exception
    //   363	376	675	java/lang/Exception
    //   379	392	675	java/lang/Exception
    //   395	408	675	java/lang/Exception
    //   258	267	680	finally
    //   270	286	680	finally
    //   289	301	680	finally
    //   450	456	680	finally
    //   459	470	680	finally
    //   258	267	684	java/lang/Exception
    //   270	286	684	java/lang/Exception
    //   289	301	684	java/lang/Exception
    //   39	48	689	finally
    //   51	59	689	finally
    //   108	114	689	finally
    //   117	128	689	finally
    //   39	48	693	java/lang/Exception
    //   51	59	693	java/lang/Exception
  }
  
  public String a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return e(str);
    }
    return null;
  }
  
  /* Error */
  public String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 189	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 935
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 255 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 269 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 286 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 89
    //   78: iconst_2
    //   79: ldc_w 937
    //   82: aload_1
    //   83: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 89
    //   103: iconst_2
    //   104: ldc_w 939
    //   107: aload_3
    //   108: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 286 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 89
    //   132: iconst_2
    //   133: ldc_w 937
    //   136: aload_1
    //   137: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 286 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 89
    //   166: iconst_2
    //   167: ldc_w 937
    //   170: aload_2
    //   171: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String a(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    int i;
    int j;
    if ((paramGetOnlineInfoResp.iTermType == 65793L) || (paramGetOnlineInfoResp.iTermType == 67586L))
    {
      i = 1;
      j = (int)paramGetOnlineInfoResp.dwStatus;
      if ((20 != j) && (21 != j) && (40 != j) && (41 != j)) {
        break label90;
      }
    }
    for (;;)
    {
      i = ContactUtils.getFriendStatus(j, (int)paramGetOnlineInfoResp.iTermType);
      if ((i == 0) || (i == 6)) {
        break label97;
      }
      return paramGetOnlineInfoResp.strTermDesc;
      i = 0;
      break;
      label90:
      if (i == 0) {}
    }
    label97:
    return null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteSyncContact | mobileNo = " + c(paramString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().delete(aqmr.a(c()), "sourceid=?", new String[] { paramString });
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "setSyncContactAllowed | allow = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("pref_sync_contact", paramBoolean).commit();
    if (paramBoolean)
    {
      this.d = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.d = true;
      return;
    }
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncAllContacts | isSyncing = " + this.jdField_c_of_type_Boolean + " syncFrom = " + paramInt);
    }
    if ((this.jdField_c_of_type_Boolean) || (!e())) {
      return false;
    }
    this.jdField_c_of_type_Boolean = true;
    BaseApplicationImpl.sUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable);
    boolean bool = a(a(), paramInt);
    if (this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.d = false;
    }
    this.jdField_c_of_type_Boolean = false;
    return bool;
  }
  
  /* Error */
  public String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 189	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 997
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 255 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 269 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 286 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 89
    //   78: iconst_2
    //   79: ldc_w 999
    //   82: aload_1
    //   83: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 89
    //   103: iconst_2
    //   104: ldc_w 1001
    //   107: aload_3
    //   108: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 286 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 89
    //   132: iconst_2
    //   133: ldc_w 999
    //   136: aload_1
    //   137: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 286 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 89
    //   166: iconst_2
    //   167: ldc_w 999
    //   170: aload_2
    //   171: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String b(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    String str1 = "";
    String str2 = "";
    int i;
    switch (paramGetOnlineInfoResp.eNetworkType)
    {
    default: 
      i = 0;
      paramGetOnlineInfoResp = str2;
    }
    while (i != 0)
    {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131698094), new Object[] { str1, paramGetOnlineInfoResp });
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698369);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698370);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698369);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698366);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698369);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698367);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698369);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698365);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698368);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131698364);
      i = 1;
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    String str = Build.MANUFACTURER;
    if (str.toLowerCase().contains("samsung")) {
      return c();
    }
    if (!str.toLowerCase().contains("oppo")) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncBindContactList");
    }
    BaseApplicationImpl.sUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ContactSyncManager.2(this, paramInt));
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable.a(paramInt);
      BaseApplicationImpl.sUiHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable, 30000L);
    }
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT < 22) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().acquireContentProviderClient("com.android.contacts");
      return true;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.sUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager$RefreshContactRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aycd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager
 * JD-Core Version:    0.7.0.1
 */