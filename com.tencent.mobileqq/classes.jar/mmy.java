import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager.1;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class mmy
  implements Manager
{
  public static final String c = String.valueOf(System.currentTimeMillis());
  public int a;
  public QQAppInterface a;
  final String jdField_a_of_type_JavaLangString = "TroopRedTouchManager2_";
  oidb_0x791.GetRedDotRes jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
  boolean jdField_a_of_type_Boolean = false;
  public final String b = mmy.class.getSimpleName();
  
  public mmy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("redDotInfo2String, oidb_0x791.RedDotInfo:");
    localStringBuilder.append("uint32_appid:").append(paramRedDotInfo.uint32_appid.get()).append("|redDotInfo.bool_display_reddot:").append(paramRedDotInfo.bool_display_reddot.get()).append("|uint32_number:").append(paramRedDotInfo.uint32_number.get()).append("|uint32_reason:").append(paramRedDotInfo.uint32_reason.get()).append("|uint32_last_time:").append(paramRedDotInfo.uint32_last_time.get()).append("|uint64_cmd_uin:").append(paramRedDotInfo.uint64_cmd_uin.get()).append("|uint32_cmd_uin_type:").append(paramRedDotInfo.uint32_cmd_uin_type.get()).append("|str_face_url:").append(paramRedDotInfo.str_face_url.get().toStringUtf8()).append("|str_custom_buffer:").append(paramRedDotInfo.str_custom_buffer.get().toStringUtf8()).append("|uint32_expire_time:").append(paramRedDotInfo.uint32_expire_time.get());
    return localStringBuilder.toString();
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 165	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 51	mmy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   13: invokevirtual 177	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   16: new 56	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   23: ldc 37
    //   25: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 51	mmy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: invokevirtual 181	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   35: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 184	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: invokestatic 189	bace:a	(Ljava/io/File;)[B
    //   47: astore_3
    //   48: new 191	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   51: dup
    //   52: invokespecial 192	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull +11 -> 70
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 196	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 199	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   81: aload_1
    //   82: astore_2
    //   83: goto -13 -> 70
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 200	java/lang/NullPointerException:printStackTrace	()V
    //   98: aload_1
    //   99: astore_2
    //   100: goto -30 -> 70
    //   103: astore_2
    //   104: goto -10 -> 94
    //   107: astore_2
    //   108: goto -31 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	mmy
    //   55	27	1	localGetRedDotRes1	oidb_0x791.GetRedDotRes
    //   86	4	1	localObject1	Object
    //   93	6	1	localObject2	Object
    //   57	16	2	localGetRedDotRes2	oidb_0x791.GetRedDotRes
    //   74	4	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   82	1	2	localGetRedDotRes3	oidb_0x791.GetRedDotRes
    //   91	4	2	localNullPointerException1	java.lang.NullPointerException
    //   99	1	2	localObject3	Object
    //   103	1	2	localNullPointerException2	java.lang.NullPointerException
    //   107	1	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   47	17	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	56	74	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2	56	86	finally
    //   62	68	86	finally
    //   77	81	86	finally
    //   94	98	86	finally
    //   2	56	91	java/lang/NullPointerException
    //   62	68	103	java/lang/NullPointerException
    //   62	68	107	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {}
    for (;;)
    {
      return;
      try
      {
        ThreadManager.post(new TroopRedTouchManager.2(this, paramGetRedDotRes), 5, null, false);
      }
      finally {}
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      int k;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        boolean bool = baig.f(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        k = j;
        if (localRedDotInfo.uint32_number.get() > 0)
        {
          k = j;
          if (7 == localRedDotInfo.uint32_appid.get())
          {
            k = j;
            if (bool) {
              k = j + localRedDotInfo.uint32_number.get();
            }
          }
        }
      }
    }
    return j;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int m = 0;
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if ((this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) || (paramQQAppInterface == null)) {
      return 0;
    }
    boolean bool3 = asdc.a(paramQQAppInterface);
    boolean bool4 = a();
    boolean bool1;
    boolean bool2;
    label66:
    int k;
    if (!paramQQAppInterface.q)
    {
      bool1 = true;
      if ((!bool1) || (!bool4)) {
        break label158;
      }
      bool2 = true;
      paramQQAppInterface = a(bool2);
      if (paramQQAppInterface.jdField_a_of_type_Int == -1) {
        break label338;
      }
      k = paramQQAppInterface.d;
      bool2 = true;
    }
    for (;;)
    {
      paramQQAppInterface = new StringBuilder();
      int i = 0;
      label100:
      if (m < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(m);
        if (!localRedDotInfo.bool_display_reddot.get()) {}
        for (;;)
        {
          m += 1;
          break label100;
          bool1 = false;
          break;
          bool2 = false;
          break label66;
          int n = localRedDotInfo.uint32_appid.get();
          int j;
          if ((2 != n) && (3 != n) && (4 != n) && (5 != n))
          {
            j = i;
            if (mmq.a(localRedDotInfo))
            {
              j = i;
              if (!b()) {}
            }
          }
          else
          {
            j = i + 1;
            paramQQAppInterface.append(n);
            paramQQAppInterface.append(",");
          }
          i = j;
        }
      }
      label158:
      QLog.d("nearby.redpoint", 1, "getLebaRedPoint, needShow=" + bool4 + ", isNewTab=" + bool3 + ", redType=" + k + ", isNearbyRedPoint=" + bool2 + ", isNearbyEntryShow=" + bool1 + ", redPointNums=" + i + ", appId=" + paramQQAppInterface.toString());
      return i;
      label338:
      bool2 = false;
      k = 0;
    }
  }
  
  public atay a(boolean paramBoolean)
  {
    try
    {
      atay localatay = a(paramBoolean, true);
      return localatay;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public atay a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1;
    atay localatay;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo5;
    Object localObject3;
    Object localObject1;
    try
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = (mmy)localQQAppInterface.getManager(70);
      localRedTypeInfo1 = ((mmy)localObject2).a();
      i = 0;
      localatay = new atay();
      if (!paramBoolean1) {
        break label965;
      }
      if (!asdc.a(localQQAppInterface)) {
        break label907;
      }
      localRedTypeInfo2 = ((mmy)localObject2).b();
      localRedTypeInfo3 = ((mmy)localObject2).g();
      localRedTypeInfo4 = ((mmy)localObject2).i();
      localRedTypeInfo5 = ((mmy)localObject2).h();
      localObject3 = ((mmy)localObject2).b();
      localObject1 = ((mmy)localObject2).a();
      d();
      ((mmy)localObject2).e();
      f();
      j = i;
      if (localObject3 == null) {
        break label233;
      }
      j = i;
      if (((ArrayList)localObject3).size() <= 0) {
        break label233;
      }
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = ((oidb_0x791.RedDotInfo)((Iterator)localObject3).next()).str_face_url.get().toStringUtf8();
          if ((!TextUtils.isEmpty(str)) && (!((ArrayList)localObject2).contains(str))) {
            ((ArrayList)localObject2).add(str);
          }
        }
      }
      localatay.a(3);
    }
    finally {}
    localatay.a((List)localObject2, false);
    int j = 56;
    label233:
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((ArrayList)localObject1).size() > 0)
      {
        i = j;
        if (asdc.b(localAppInterface))
        {
          localObject2 = new ArrayList();
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = ((oidb_0x791.RedDotInfo)((Iterator)localObject1).next()).str_face_url.get().toStringUtf8();
              if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((ArrayList)localObject2).contains(localObject3))) {
                ((ArrayList)localObject2).add(localObject3);
              }
            }
          }
          localatay.a(3);
          localatay.a((List)localObject2, false);
          i = 61;
        }
      }
    }
    int k;
    label514:
    int m;
    if (i == 0) {
      if (asdc.b(localAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.redpoint", 2, "in memory nearbyMsgBoxUnReadNum=" + this.jdField_a_of_type_Int);
        }
        if (paramBoolean2)
        {
          ThreadManager.post(new TroopRedTouchManager.1(this, localAppInterface), 8, null, false);
          j = this.jdField_a_of_type_Int;
          if (j <= 0) {
            break label980;
          }
          localatay.a(5);
          localatay.b(j);
          QLog.d("nearby.redpoint", 1, "addRedNum:" + j + ", total=" + localatay.b + ", type=" + 60);
          k = 60;
          j = 2;
          i = j;
          m = k;
          if (localRedTypeInfo3 != null)
          {
            i = j;
            m = k;
            if (asdc.a(localAppInterface, 1))
            {
              if (localRedTypeInfo3.red_type.get() != 0) {
                break label758;
              }
              localatay.a(0);
              i = j;
              break label998;
            }
          }
          label565:
          j = i;
          k = m;
          if (localRedTypeInfo4 != null)
          {
            j = i;
            k = m;
            if (localRedTypeInfo4.red_type.get() == 5)
            {
              localatay.a(5);
              localatay.a(localRedTypeInfo4.red_content.get());
              baig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
              k = m;
              j = i;
            }
          }
          label635:
          m = j;
          i = k;
          if (k != 0) {
            break label1005;
          }
          if ((localRedTypeInfo1 == null) || (!asdc.a(localAppInterface, 2))) {
            break label856;
          }
          localatay.a(0);
          i = 25;
          m = j;
          break label1005;
        }
      }
    }
    for (;;)
    {
      label677:
      localatay.c = j;
      QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, needShow, isNewTab=" + paramBoolean1 + ", redType=" + i + ", redInfo=" + localatay);
      for (;;)
      {
        localatay.d = i;
        return localatay;
        this.jdField_a_of_type_Int = MsgBoxListActivity.a(localAppInterface, ajed.I);
        break;
        label758:
        i = j;
        if (localRedTypeInfo3.red_type.get() != 5) {
          break label998;
        }
        localatay.a(5);
        localatay.a(localRedTypeInfo3.red_content.get());
        i = 2;
        QLog.d("nearby.redpoint", 1, "addRedNum:" + localRedTypeInfo3.red_content.get() + ", total=" + localatay.b + ", type=" + 38);
        break label998;
        label856:
        if ((localRedTypeInfo2 != null) && (asdc.a(localAppInterface, 3)))
        {
          i = 23;
          localatay.a(0);
          m = j;
          break label1005;
        }
        if (localRedTypeInfo5 == null) {
          break label1014;
        }
        localatay.a(0);
        i = 42;
        m = j;
        break label1005;
        label907:
        if (((mmy)localObject2).c() != null)
        {
          localatay.a(0);
          i = 24;
          j = 1;
          paramBoolean1 = false;
          break label677;
        }
        if ((localRedTypeInfo1 == null) || (!asdc.a(localAppInterface, 1001))) {
          break label1023;
        }
        localatay.a(0);
        i = 25;
        j = 1;
        paramBoolean1 = false;
        break label677;
        label965:
        QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, don't needShow");
        i = 0;
      }
      label980:
      j = 1;
      k = i;
      break label514;
      j = 1;
      k = i;
      break label635;
      label998:
      m = 38;
      break label565;
      for (;;)
      {
        label1005:
        paramBoolean1 = true;
        j = m;
        break;
        label1014:
        m = 0;
        i = k;
      }
      label1023:
      paramBoolean1 = false;
      j = 0;
      i = 0;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    if (a(25) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  /* Error */
  public ArrayList<oidb_0x791.RedDotInfo> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 216	mmy:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: new 326	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 328	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   47: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   53: if_icmpge +98 -> 151
    //   56: aload_0
    //   57: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   60: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: iload_1
    //   64: invokevirtual 228	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 69	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   70: astore 4
    //   72: aload 4
    //   74: getfield 101	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: pop
    //   81: aload 4
    //   83: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   86: invokevirtual 93	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   89: istore_2
    //   90: aload 4
    //   92: getfield 117	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   95: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   98: pop2
    //   99: aload 4
    //   101: getfield 135	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 145	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   110: astore 5
    //   112: bipush 61
    //   114: aload 4
    //   116: getfield 73	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: if_icmpne +22 -> 144
    //   125: iload_2
    //   126: ifeq +18 -> 144
    //   129: aload 5
    //   131: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +10 -> 144
    //   137: aload_3
    //   138: aload 4
    //   140: invokevirtual 354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -106 -> 42
    //   151: goto -123 -> 28
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	mmy
    //   41	107	1	i	int
    //   89	37	2	bool	boolean
    //   21	117	3	localObject1	Object
    //   154	4	3	localObject2	Object
    //   70	69	4	localRedDotInfo	oidb_0x791.RedDotInfo
    //   110	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	154	finally
    //   17	22	154	finally
    //   32	40	154	finally
    //   42	125	154	finally
    //   129	144	154	finally
  }
  
  public oidb_0x791.RedDotInfo a()
  {
    label287:
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      oidb_0x791.RedDotInfo localRedDotInfo2;
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localGetRedDotRes == null) {
          return null;
        }
        bool1 = ((stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean;
        Iterator localIterator = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get().iterator();
        localGetRedDotRes = null;
        if (!localIterator.hasNext()) {
          break label247;
        }
        localRedDotInfo2 = (oidb_0x791.RedDotInfo)localIterator.next();
        if (!localRedDotInfo2.bool_display_reddot.get()) {
          continue;
        }
        i = localRedDotInfo2.uint32_appid.get();
        if (!mmq.b(i)) {
          continue;
        }
        if ((i == 37) && (localRedDotInfo2.uint32_expire_time.get() < NetConnInfoCenter.getServerTime()))
        {
          urk.d(this.b, "%d red dot time out", new Object[] { Integer.valueOf(i) });
          continue;
        }
        if (i != 37) {}
      }
      finally {}
      if ((!bool2) && (i != 48) && ((bool1) || (i != 28)) && ((i != vmk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (localRedDotInfo2.uint32_number.get() > 0))) {
        if (mmq.a(localRedDotInfo2, localRedDotInfo1) > 0)
        {
          Object localObject = localRedDotInfo2;
          break label287;
          label247:
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.redPoint", 2, "return:" + a(localObject));
          }
        }
      }
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        oidb_0x791.RedDotInfo localRedDotInfo = null;
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localGetRedDotRes == null) {
          return localRedDotInfo;
        }
        int i = 0;
        if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
        {
          localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if (paramInt == localRedDotInfo.uint32_appid.get())
          {
            boolean bool = localRedDotInfo.bool_display_reddot.get();
            if (bool) {}
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return null;
    }
    int i = 0;
    oidb_0x791.RedDotInfo localRedDotInfo2;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (paramInt == localRedDotInfo2.uint32_appid.get())
      {
        localRedDotInfo1 = localRedDotInfo2;
        if (paramBoolean) {
          if (!localRedDotInfo2.bool_display_reddot.get()) {
            break label94;
          }
        }
      }
    }
    for (oidb_0x791.RedDotInfo localRedDotInfo1 = localRedDotInfo2;; localRedDotInfo1 = null)
    {
      return localRedDotInfo1;
      label94:
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new StringBuilder("clearStoryWeakRedPoint==>");
        i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
        if (i >= 0)
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if ((!localRedDotInfo.bool_display_reddot.get()) || (!mmq.a(localRedDotInfo.uint32_appid.get()))) {
            break label209;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
          mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
          ((StringBuilder)localObject1).append(a(localRedDotInfo)).append("|");
        }
      }
      finally {}
      a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) {
        afqa.jdField_a_of_type_Int |= 0x2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(this.b + "Q.qqstory.redPoint", 2, localObject2.toString());
        continue;
        label209:
        i -= 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    int i;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.redpoint", 2, "clearStoryRedPointByAppId：appId=" + paramInt);
      }
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      Object localObject = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject == null) {
        return;
      }
      localStringBuilder = new StringBuilder("clearStoryRedPointByAppId==>[");
      if ((paramInt != 56) && (paramInt != 61)) {
        break label236;
      }
      localObject = null;
      i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
      if (i >= 0)
      {
        oidb_0x791.RedDotInfo localRedDotInfo3 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        if (localRedDotInfo3.uint32_appid.get() != paramInt) {
          break label330;
        }
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
        localStringBuilder.append(a(localRedDotInfo3)).append("] [");
        localObject = localRedDotInfo3;
      }
    }
    finally {}
    if (localRedDotInfo1 != null) {
      mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo1);
    }
    label187:
    label330:
    label342:
    for (;;)
    {
      a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.b + "Q.qqstory.redPoint", 2, localStringBuilder.toString());
      break;
      label236:
      i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label342;
        }
        oidb_0x791.RedDotInfo localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        if ((localRedDotInfo2.bool_display_reddot.get()) && (localRedDotInfo2.uint32_appid.get() == paramInt))
        {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
          mmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo2);
          localStringBuilder.append(a(localRedDotInfo2)).append("]");
          break label187;
          i -= 1;
          break;
        }
        i -= 1;
      }
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    Object localObject;
    int j;
    label111:
    int i;
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      localObject = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if ((localObject == null) || (paramRedDotInfo == null)) {
        return;
      }
      j = paramRedDotInfo.uint32_appid.get();
      if (!QLog.isColorLevel()) {
        break label298;
      }
      QLog.d("nearby.redpoint", 2, "set：appId=" + j + ", uin=" + paramRedDotInfo.uint64_cmd_uin.get() + ", hasRed=" + paramRedDotInfo.bool_display_reddot.get());
    }
    finally {}
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get() == j) {
        if ((j == 56) || (j == 61))
        {
          if (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() != paramRedDotInfo.uint64_cmd_uin.get()) {
            break label286;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          if (!QLog.isColorLevel()) {
            break label303;
          }
          QLog.d("nearby.redpoint", 2, "APPID_NEARBY_CONCERN_UPDATE, onPush：has same uin reddot, uin=" + paramRedDotInfo.uint64_cmd_uin.get());
          break label303;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(paramRedDotInfo);
      }
      a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      break;
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
      i = 1;
      continue;
      label286:
      i += 1;
      break label111;
      i = 0;
      continue;
      label298:
      i = 0;
      break label111;
      label303:
      i = 1;
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    Object localObject2 = null;
    int i;
    String str;
    if ((paramRedDotInfo1 != null) && (paramRedDotInfo1.uint32_last_time.has()))
    {
      i = paramRedDotInfo1.uint32_last_time.get();
      if (QLog.isColorLevel()) {
        QLog.i(this.b, 2, "TENCENT_DOCS_ASSISTANT  show redDot" + paramRedDotInfo2.bool_display_reddot.get());
      }
      if (!paramRedDotInfo2.bool_display_reddot.get())
      {
        str = "";
        if (paramRedDotInfo1 == null) {
          break label334;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!paramRedDotInfo1.str_custom_buffer.has()) {
          break label334;
        }
        paramRedDotInfo1 = paramRedDotInfo1.str_custom_buffer.get().toStringUtf8();
        Object localObject1 = str;
        if (!TextUtils.isEmpty(paramRedDotInfo1))
        {
          JSONObject localJSONObject = new JSONObject(paramRedDotInfo1);
          if (localJSONObject.has("lastMsg"))
          {
            paramRedDotInfo1 = localJSONObject.getString("lastMsg");
            localObject1 = paramRedDotInfo1;
            if (!localJSONObject.has("lastTime")) {
              break label322;
            }
            i = localJSONObject.getInt("lastTime");
            localObject1 = localObject2;
            if (paramRedDotInfo2.str_custom_buffer.has()) {
              localObject1 = paramRedDotInfo2.str_custom_buffer.get().toStringUtf8();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = new JSONObject((String)localObject1);
              ((JSONObject)localObject1).put("lastMsg", paramRedDotInfo1);
              ((JSONObject)localObject1).put("lastTime", i);
              paramRedDotInfo1 = ((JSONObject)localObject1).toString();
              paramRedDotInfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramRedDotInfo1));
            }
          }
          else
          {
            paramRedDotInfo1 = str;
            if (!localJSONObject.has("msg")) {
              continue;
            }
            paramRedDotInfo1 = localJSONObject.getString("msg");
            continue;
          }
          localObject1 = new JSONObject();
          continue;
        }
        paramRedDotInfo1 = (oidb_0x791.RedDotInfo)localObject1;
      }
      catch (Exception paramRedDotInfo1)
      {
        QLog.e(this.b, 1, "parse tencentDocs redDot info error" + paramRedDotInfo1.getMessage());
        return;
      }
      label322:
      continue;
      return;
      i = 0;
      break;
      label334:
      paramRedDotInfo1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("nearby.redpoint", 1, "setNearbyRedState, show=" + paramBoolean);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    localEditor.putBoolean("troop_nearby_red_point_state_" + str, paramBoolean);
    localEditor.commit();
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean("troop_nearby_red_point_state_" + str, true);
  }
  
  public boolean a(List<Integer> paramList, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    int m = 0;
    for (;;)
    {
      int j;
      try
      {
        int n = paramGetRedDotRes.rpt_msg_reddot_info.size();
        j = 0;
        bool = false;
        if (j < n)
        {
          oidb_0x791.RedDotInfo localRedDotInfo1 = (oidb_0x791.RedDotInfo)paramGetRedDotRes.rpt_msg_reddot_info.get(j);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.redpoint", 2, "setAllRedDot：appId=" + localRedDotInfo1.uint32_appid.get() + ", uin=" + localRedDotInfo1.uint64_cmd_uin.get() + ", hasRed=" + localRedDotInfo1.bool_display_reddot.get());
          }
          paramList.remove(Integer.valueOf(localRedDotInfo1.uint32_appid.get()));
          if (mmq.c(localRedDotInfo1.uint32_appid.get())) {
            break label779;
          }
          k = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
          i = 0;
          if (i >= k) {
            break label771;
          }
          oidb_0x791.RedDotInfo localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if (localRedDotInfo2.uint32_appid.get() != localRedDotInfo1.uint32_appid.get()) {
            break label825;
          }
          k = localRedDotInfo1.uint32_appid.get();
          if (mmq.b(k)) {
            break label788;
          }
          if (mmq.c(k))
          {
            break label788;
            label234:
            if (localRedDotInfo2.uint64_cmd_uin.get() != localRedDotInfo1.uint64_cmd_uin.get()) {
              break label766;
            }
            if (localRedDotInfo1.uint32_last_time.get() <= localRedDotInfo2.uint32_last_time.get()) {
              break label763;
            }
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            a(true);
            if (!QLog.isColorLevel()) {
              break label805;
            }
            QLog.d("nearby.redpoint", 2, "APPID_NEARBY_CONCERN_UPDATE, setAllRedDot：has same uin reddot, uin=" + localRedDotInfo1.uint64_cmd_uin.get());
            break label805;
            label334:
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(localRedDotInfo1);
            bool = true;
            break label779;
            label352:
            if (localRedDotInfo1.uint32_last_time.get() <= localRedDotInfo2.uint32_last_time.get()) {
              break label758;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.b + "Q.qqstory.redPoint", 2, "网络红点比本地红点新，netRedPoint：" + a(localRedDotInfo1) + "|localRedPoint:" + a(localRedDotInfo2));
            }
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            if (!mmq.c(k)) {
              break label750;
            }
            a(true);
            i = 0;
            bool = true;
            break label810;
          }
          if (k == 46)
          {
            a(localRedDotInfo2, localRedDotInfo1);
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            i = 0;
            bool = true;
            break label810;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo1);
          i = 0;
          bool = true;
          break label810;
        }
        j = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
        i = m;
        if (i < j)
        {
          paramGetRedDotRes = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if (paramList.contains(Integer.valueOf(paramGetRedDotRes.uint32_appid.get())))
          {
            paramGetRedDotRes.bool_display_reddot.set(false);
            paramGetRedDotRes.uint32_number.set(0);
            paramGetRedDotRes.uint32_reason.set(0);
            paramGetRedDotRes.uint64_cmd_uin.set(0L);
            paramGetRedDotRes.str_face_url.set(ByteStringMicro.EMPTY);
            paramGetRedDotRes.str_custom_buffer.set(ByteStringMicro.EMPTY);
            paramGetRedDotRes.uint32_expire_time.set(0);
            paramGetRedDotRes.uint32_cmd_uin_type.set(0);
            paramGetRedDotRes.uint32_report_type.set(0);
            bool = true;
            break label832;
          }
        }
        else
        {
          if (bool) {
            a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "setAll==>拉回来的红点数据与本地的做对比，对比uint32_last_time, reult:" + bool);
          }
          return bool;
        }
      }
      finally {}
      break label832;
      label750:
      int i = 0;
      boolean bool = true;
      break label810;
      label758:
      i = 0;
      break label810;
      label763:
      break label808;
      label766:
      i = 1;
      break label810;
      label771:
      i = 0;
      int k = 1;
      label779:
      label788:
      label805:
      label808:
      label810:
      do
      {
        j += 1;
        break;
        if (k == 56) {
          break label234;
        }
        if (k != 61) {
          break label352;
        }
        break label234;
        bool = true;
        i = 0;
        k = 0;
        if (k != 0) {
          break label334;
        }
      } while (i == 0);
      continue;
      label825:
      i += 1;
      continue;
      label832:
      i += 1;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        localRedDotInfo1 = a(paramInt3);
        if (localRedDotInfo1 != null) {
          continue;
        }
        paramBoolean = bool;
      }
      finally
      {
        try
        {
          oidb_0x791.RedDotInfo localRedDotInfo1;
          oidb_0x791.RedDotInfo localRedDotInfo2;
          localRedDotInfo2.mergeFrom(localRedDotInfo1.toByteArray());
          if (localRedDotInfo2.uint32_last_time.get() > paramInt2)
          {
            paramBoolean = bool;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "result is out of date, current:" + paramInt2 + ", last:" + localRedDotInfo2.uint32_last_time.get());
            paramBoolean = bool;
            continue;
          }
          localRedDotInfo2.bool_display_reddot.set(paramBoolean);
          localRedDotInfo2.uint32_number.set(paramInt1);
          localRedDotInfo2.uint64_cmd_uin.set(paramLong);
          localRedDotInfo2.uint32_last_time.set(paramInt2);
          a(localRedDotInfo2);
          if (QLog.isColorLevel()) {
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "updateStoryMessageRedPoint==>" + a(localRedDotInfo2));
          }
          paramBoolean = true;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          paramBoolean = bool;
        }
        localObject = finally;
      }
      return paramBoolean;
      localRedDotInfo2 = new oidb_0x791.RedDotInfo();
    }
  }
  
  public int b()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 35: 
      return 2;
    case 52: 
      return 3;
    case 11: 
      return 4;
    }
    return 8;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    Object localObject = a(23);
    oidb_0x791.RedDotInfo localRedDotInfo = a(26);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  /* Error */
  public ArrayList<oidb_0x791.RedDotInfo> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 216	mmy:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: new 326	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 328	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   47: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   53: if_icmpge +98 -> 151
    //   56: aload_0
    //   57: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   60: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: iload_1
    //   64: invokevirtual 228	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 69	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   70: astore 4
    //   72: aload 4
    //   74: getfield 101	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: pop
    //   81: aload 4
    //   83: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   86: invokevirtual 93	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   89: istore_2
    //   90: aload 4
    //   92: getfield 117	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   95: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   98: pop2
    //   99: aload 4
    //   101: getfield 135	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 145	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   110: astore 5
    //   112: bipush 56
    //   114: aload 4
    //   116: getfield 73	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: if_icmpne +22 -> 144
    //   125: iload_2
    //   126: ifeq +18 -> 144
    //   129: aload 5
    //   131: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +10 -> 144
    //   137: aload_3
    //   138: aload 4
    //   140: invokevirtual 354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -106 -> 42
    //   151: goto -123 -> 28
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	mmy
    //   41	107	1	i	int
    //   89	37	2	bool	boolean
    //   21	117	3	localObject1	Object
    //   154	4	3	localObject2	Object
    //   70	69	4	localRedDotInfo	oidb_0x791.RedDotInfo
    //   110	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	154	finally
    //   17	22	154	finally
    //   32	40	154	finally
    //   42	125	154	finally
    //   129	144	154	finally
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b())) {}
    oidb_0x791.RedDotInfo localRedDotInfo;
    do
    {
      return false;
      localRedDotInfo = a();
    } while ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() == 37));
    return true;
  }
  
  public int c()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    return localRedDotInfo.uint32_report_type.get();
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c()
  {
    Object localObject = a(24);
    oidb_0x791.RedDotInfo localRedDotInfo = a(27);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int m = 0;
    int i = 0;
    int k;
    if (m < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(m);
      int j;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        j = i;
      }
      label134:
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            i = j;
            break;
            k = localRedDotInfo.uint32_appid.get();
            if ((6 == k) && (i == 0))
            {
              j = k;
            }
            else
            {
              if ((2 != k) && (3 != k) && (4 != k) && (5 != k)) {
                break label134;
              }
              j = k;
            }
          }
          j = i;
        } while (localRedDotInfo.uint32_number.get() <= 0);
        j = i;
      } while (7 != localRedDotInfo.uint32_appid.get());
    }
    for (;;)
    {
      return k;
      k = i;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo d()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a(59);
    if (localRedDotInfo != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo e()
  {
    if (a(65) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo f()
  {
    if (a(60) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  /* Error */
  public BusinessInfoCheckUpdate.RedTypeInfo g()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   9: ifnonnull +11 -> 20
    //   12: aload_0
    //   13: aload_0
    //   14: invokespecial 216	mmy:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: putfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   20: aload_0
    //   21: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnonnull +11 -> 39
    //   31: aconst_null
    //   32: astore 11
    //   34: aload_0
    //   35: monitorexit
    //   36: aload 11
    //   38: areturn
    //   39: ldc 54
    //   41: astore 11
    //   43: lconst_0
    //   44: lstore 7
    //   46: iconst_0
    //   47: istore_2
    //   48: iconst_0
    //   49: istore 4
    //   51: iconst_0
    //   52: istore_1
    //   53: iload_2
    //   54: aload_0
    //   55: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   58: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   61: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   64: if_icmpge +368 -> 432
    //   67: aload_0
    //   68: getfield 214	mmy:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   71: getfield 220	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: iload_2
    //   75: invokevirtual 228	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 69	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   81: astore 14
    //   83: aload 14
    //   85: getfield 101	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   88: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   91: istore_1
    //   92: aload 14
    //   94: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   97: invokevirtual 93	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   100: istore 4
    //   102: aload 14
    //   104: getfield 117	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   107: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   110: lstore 7
    //   112: aload 14
    //   114: getfield 135	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   117: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   120: invokevirtual 145	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   123: astore 13
    //   125: bipush 38
    //   127: aload 14
    //   129: getfield 73	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: if_icmpne +211 -> 346
    //   138: aload 14
    //   140: astore 12
    //   142: lload 7
    //   144: lstore 9
    //   146: aload 13
    //   148: astore 11
    //   150: iload 4
    //   152: istore 5
    //   154: iload_1
    //   155: istore_3
    //   156: iload 4
    //   158: ifne +30 -> 188
    //   161: iload 4
    //   163: ifne +183 -> 346
    //   166: iload_1
    //   167: ifle +179 -> 346
    //   170: iload_1
    //   171: istore_3
    //   172: iload 4
    //   174: istore 5
    //   176: aload 13
    //   178: astore 11
    //   180: lload 7
    //   182: lstore 9
    //   184: aload 14
    //   186: astore 12
    //   188: aload 12
    //   190: ifnull +236 -> 426
    //   193: new 388	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   196: dup
    //   197: invokespecial 443	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   200: astore 13
    //   202: iload 5
    //   204: ifeq +135 -> 339
    //   207: iload_3
    //   208: ifle +186 -> 394
    //   211: aload 13
    //   213: getfield 391	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   216: iconst_5
    //   217: invokevirtual 446	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   220: aload 13
    //   222: getfield 395	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   225: iload_3
    //   226: invokestatic 682	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   229: invokevirtual 448	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   232: iload 6
    //   234: istore 4
    //   236: aload 12
    //   238: getfield 150	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 556	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   244: ifeq +40 -> 284
    //   247: aload 12
    //   249: getfield 150	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   252: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   255: invokevirtual 145	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   258: astore 12
    //   260: new 558	org/json/JSONObject
    //   263: dup
    //   264: aload 12
    //   266: invokespecial 559	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   269: ldc_w 684
    //   272: invokevirtual 687	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   275: istore_1
    //   276: iload_1
    //   277: iconst_1
    //   278: if_icmpne +79 -> 357
    //   281: iconst_1
    //   282: istore 4
    //   284: new 558	org/json/JSONObject
    //   287: dup
    //   288: invokespecial 591	org/json/JSONObject:<init>	()V
    //   291: astore 12
    //   293: aload 12
    //   295: ldc_w 689
    //   298: aload 11
    //   300: invokevirtual 578	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload 12
    //   306: ldc_w 691
    //   309: lload 9
    //   311: invokevirtual 694	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 12
    //   317: ldc_w 696
    //   320: iload 4
    //   322: invokevirtual 699	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload 13
    //   328: getfield 451	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   331: aload 12
    //   333: invokevirtual 582	org/json/JSONObject:toString	()Ljava/lang/String;
    //   336: invokevirtual 448	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   339: aload 13
    //   341: astore 11
    //   343: goto -309 -> 34
    //   346: iload_2
    //   347: iconst_1
    //   348: iadd
    //   349: istore_2
    //   350: aload 13
    //   352: astore 11
    //   354: goto -301 -> 53
    //   357: iconst_0
    //   358: istore 4
    //   360: goto -76 -> 284
    //   363: astore 12
    //   365: aload 12
    //   367: invokevirtual 700	java/lang/Exception:printStackTrace	()V
    //   370: iload 6
    //   372: istore 4
    //   374: goto -90 -> 284
    //   377: astore 11
    //   379: aload_0
    //   380: monitorexit
    //   381: aload 11
    //   383: athrow
    //   384: astore 11
    //   386: aload 11
    //   388: invokevirtual 700	java/lang/Exception:printStackTrace	()V
    //   391: goto -52 -> 339
    //   394: aload 13
    //   396: getfield 391	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   399: iconst_0
    //   400: invokevirtual 446	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   403: aload 13
    //   405: getfield 395	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   408: ldc 54
    //   410: invokevirtual 448	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   413: aload 13
    //   415: getfield 451	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   418: ldc 54
    //   420: invokevirtual 448	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   423: goto -84 -> 339
    //   426: aconst_null
    //   427: astore 11
    //   429: goto -395 -> 34
    //   432: aconst_null
    //   433: astore 12
    //   435: lload 7
    //   437: lstore 9
    //   439: iload 4
    //   441: istore 5
    //   443: iload_1
    //   444: istore_3
    //   445: goto -257 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	mmy
    //   52	392	1	i	int
    //   47	303	2	j	int
    //   155	290	3	k	int
    //   49	391	4	bool1	boolean
    //   152	290	5	bool2	boolean
    //   1	370	6	bool3	boolean
    //   44	392	7	l1	long
    //   144	294	9	l2	long
    //   24	329	11	localObject1	Object
    //   377	5	11	localObject2	Object
    //   384	3	11	localException1	Exception
    //   427	1	11	localObject3	Object
    //   140	192	12	localObject4	Object
    //   363	3	12	localException2	Exception
    //   433	1	12	localObject5	Object
    //   123	291	13	localObject6	Object
    //   81	104	14	localRedDotInfo	oidb_0x791.RedDotInfo
    // Exception table:
    //   from	to	target	type
    //   260	276	363	java/lang/Exception
    //   5	20	377	finally
    //   20	26	377	finally
    //   53	138	377	finally
    //   193	202	377	finally
    //   211	232	377	finally
    //   236	260	377	finally
    //   260	276	377	finally
    //   284	339	377	finally
    //   365	370	377	finally
    //   386	391	377	finally
    //   394	423	377	finally
    //   284	339	384	java/lang/Exception
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo h()
  {
    if (a(42) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo i()
  {
    for (;;)
    {
      long l1;
      int i;
      boolean bool1;
      Object localObject6;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        l1 = 0L;
        int j = 0;
        i = 0;
        localObject1 = "";
        bool1 = false;
        if (j >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
          break label367;
        }
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
        i = localRedDotInfo.uint32_number.get();
        bool1 = localRedDotInfo.bool_display_reddot.get();
        l1 = localRedDotInfo.uint64_cmd_uin.get();
        localObject6 = localRedDotInfo.str_face_url.get().toStringUtf8();
        if (63 == localRedDotInfo.uint32_appid.get())
        {
          localObject1 = localRedDotInfo;
          l2 = l1;
          localObject5 = localObject6;
          bool2 = bool1;
          k = i;
          if (!bool1)
          {
            if ((!bool1) && (i > 0))
            {
              k = i;
              bool2 = bool1;
              localObject5 = localObject6;
              l2 = l1;
              localObject1 = localRedDotInfo;
            }
          }
          else
          {
            if (localObject1 == null) {
              break label361;
            }
            localObject6 = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject1 = localObject6;
            if (!bool2) {
              continue;
            }
            if (k <= 0) {
              break label325;
            }
            if (k <= 99) {
              break label322;
            }
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_type.set(5);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_content.set(String.valueOf(k));
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("faceUrl", localObject5);
              ((JSONObject)localObject1).put("uin", l2);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_desc.set(((JSONObject)localObject1).toString());
              localObject1 = localObject6;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              Object localObject2 = localObject6;
            }
            continue;
          }
        }
        j += 1;
      }
      finally {}
      Object localObject4 = localObject6;
      continue;
      label322:
      continue;
      label325:
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_desc.set("");
      localObject4 = localObject6;
      continue;
      label361:
      localObject4 = null;
      continue;
      label367:
      Object localObject5 = localObject4;
      localObject4 = null;
      long l2 = l1;
      boolean bool2 = bool1;
      int k = i;
    }
  }
  
  public void onDestroy()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmy
 * JD-Core Version:    0.7.0.1
 */