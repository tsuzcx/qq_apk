package com.tencent.mobileqq.stt;

import aikf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;

public class SttManager
  implements Handler.Callback, Manager, BusinessObserver
{
  private static int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private SttManager.ISttListener jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b = -1;
  
  public SttManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.c(), 0).getInt("k_c_v", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.c(), 0).edit().putInt("k_c_v", paramInt).commit();
  }
  
  private boolean a()
  {
    if (this.b == -1) {
      this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    }
    return this.b == 1;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_" + paramQQAppInterface.getAccount(), 0);
    }
    if (jdField_a_of_type_Int == 1) {
      return true;
    }
    return ((SttManager)paramQQAppInterface.getManager(16)).a();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (a(paramQQAppInterface) != paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        jdField_a_of_type_Int = i;
        paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_" + paramQQAppInterface.getAccount(), jdField_a_of_type_Int).commit();
        return true;
      }
    }
    return false;
  }
  
  public Long a(MessageForPtt paramMessageForPtt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong)) {
      return localLong;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(localLong, paramMessageForPtt);
    SttServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, localLong);
    return localLong;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt).apply();
    try
    {
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("appversion", "7.6.3");
      localStatisticCollector.a("", "PttSttEntryChange", false, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(SttManager.ISttListener paramISttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener = paramISttListener;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SttResultPush.MsgBody();
    for (;;)
    {
      SttResultPush.TransPttResp localTransPttResp;
      Long localLong;
      int i;
      int j;
      int k;
      int m;
      try
      {
        ((SttResultPush.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localTransPttResp = ((SttResultPush.MsgBody)localObject).msg_ptt_resp;
        localLong = Long.valueOf(localTransPttResp.uint64_sessionid.get());
        i = localTransPttResp.uint32_pos.get();
        j = localTransPttResp.uint32_len.get();
        k = localTransPttResp.uint32_total_len.get();
        m = 1 << localTransPttResp.uint32_seq.get();
        int n = localTransPttResp.uint32_error_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onSttResultPush with: " + n + ", " + localLong + ", " + i + ", " + j + ", " + k);
        }
        if ((n != 0) || (i + j > k))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
          }
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, localLong).sendToTarget();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
        return;
      }
      if (j >= k) {
        paramArrayOfByte = new String(localTransPttResp.bytes_text.get().toByteArray());
      }
      while (paramArrayOfByte != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, (int)(localLong.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong.longValue() & 0xFFFFFFFF), paramArrayOfByte).sendToTarget();
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        localObject = (aikf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localLong);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null)
        {
          paramArrayOfByte = new aikf(null);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(k);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, localLong);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, localLong);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 30000L);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, paramArrayOfByte);
        }
        if (0L == (paramArrayOfByte.jdField_a_of_type_Long & m))
        {
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.position(i);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.put(localTransPttResp.bytes_text.get().toByteArray());
          long l = paramArrayOfByte.b;
          paramArrayOfByte.b = (j + l);
          paramArrayOfByte.jdField_a_of_type_Long |= m;
          if (paramArrayOfByte.b >= k)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
            paramArrayOfByte = new String(paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.array());
            continue;
          }
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForPtt.uniseq)));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    MessageForPtt localMessageForPtt = null;
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("unknown msg: " + paramMessage.what);
    case 2: 
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessage.obj);
      }
    case 1: 
    case 4: 
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessage.obj);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + paramMessage.obj + ", " + localMessageForPtt);
      }
      if ((localMessageForPtt != null) && (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(false, localMessageForPtt);
      }
      return true;
    }
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {}
    for (localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));; localMessageForPtt = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + l + ", " + localMessageForPtt);
      }
      if (localMessageForPtt == null) {
        break;
      }
      localMessageForPtt.sttAbility = 2;
      localMessageForPtt.sttText = ((String)paramMessage.obj);
      localMessageForPtt.isReadPtt = true;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "ptt convert to text success,seq is:" + localMessageForPtt.uniseq + ",sttAbility is:" + localMessageForPtt.sttAbility + ",sttText is:" + Utils.a(localMessageForPtt.sttText));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(true, localMessageForPtt);
      return true;
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
    }
    Long localLong1;
    do
    {
      do
      {
        return;
        localLong1 = Long.valueOf(paramBundle.getLong("k_session", 0L));
        Long localLong2 = Long.valueOf(paramBundle.getLong("k_time_out", 30000L));
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onReceive, session = " + localLong1 + ", timeout = " + localLong2);
        }
        paramBundle = null;
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          paramBundle = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.get(localLong1);
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBoolean)
        {
          paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localLong1);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, localLong2.longValue());
          return;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localLong1);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener == null);
      this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(false, paramBundle);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.stt", 2, "onReceive with no request on: " + localLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager
 * JD-Core Version:    0.7.0.1
 */