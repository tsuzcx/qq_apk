package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NumRedMsgHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgRspBody;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class NumRedMsgManager
  implements Manager
{
  protected NumRedMsgHandler a;
  protected QQAppInterface a;
  protected NumRedMsg.NumMsgRspBody a;
  protected ConcurrentHashMap<Integer, NumRedGetMsgCallback> a;
  private boolean a;
  
  public NumRedMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppNumRedMsgHandler = ((NumRedMsgHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NUMREDMSG_HANDLER));
  }
  
  private void a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbNumRedMsg$NumMsgRspBody = paramNumMsgRspBody;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NumRedMsgManager", 2, paramString);
    }
  }
  
  private void a(long[] paramArrayOfLong, NumRedGetMsgCallback paramNumRedGetMsgCallback, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new NumRedMsgManager.2(this, paramArrayOfLong, paramNumRedGetMsgCallback, paramBoolean, paramString), 5, null, false);
  }
  
  private boolean a()
  {
    File localFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NumRedMsgFileName_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return new File(localFile, localStringBuilder.toString()).exists();
  }
  
  private boolean a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    File localFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NumRedMsgFileName_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool = FileUtils.pushData2File(new File(localFile, localStringBuilder.toString()).getAbsolutePath(), paramNumMsgRspBody.toByteArray(), false);
    if (bool) {
      a(paramNumMsgRspBody);
    }
    return bool;
  }
  
  private void b(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    if (paramNumMsgRspBody == null) {
      return;
    }
    NumRedMsg.NumMsgRspBody localNumMsgRspBody = a();
    if (localNumMsgRspBody == null)
    {
      a(paramNumMsgRspBody);
      return;
    }
    List localList = localNumMsgRspBody.rpt_num_red.get();
    if (localList == null)
    {
      a(paramNumMsgRspBody);
      return;
    }
    paramNumMsgRspBody = paramNumMsgRspBody.rpt_num_red.get();
    if (paramNumMsgRspBody == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramNumMsgRspBody.size())
    {
      int j = 0;
      int k = 0;
      while (j < localList.size())
      {
        if (((NumRedMsg.NumMsgBusi)localList.get(j)).ui64_msgid.get() == ((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui64_msgid.get())
        {
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_content.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_content.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_ext.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_ext.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_missionid.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_missionid.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_path.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_path.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_url.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_url.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).ui_appid.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui_appid.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).ui_expire_time.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui_expire_time.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_ret.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_ret.get());
          k = 1;
        }
        j += 1;
      }
      if (k == 0) {
        localArrayList.add(paramNumMsgRspBody.get(i));
      }
      i += 1;
    }
    localList.addAll(localArrayList);
    a(localNumMsgRspBody);
  }
  
  /* Error */
  public NumRedMsg.NumMsgRspBody a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/redtouch/NumRedMsgManager:jdField_a_of_type_ComTencentMobileqqTianshuPbNumRedMsg$NumMsgRspBody	Lcom/tencent/mobileqq/tianshu/pb/NumRedMsg$NumMsgRspBody;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: new 113	com/tencent/mobileqq/tianshu/pb/NumRedMsg$NumMsgRspBody
    //   14: dup
    //   15: invokespecial 217	com/tencent/mobileqq/tianshu/pb/NumRedMsg$NumMsgRspBody:<init>	()V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 27	com/tencent/mobileqq/redtouch/NumRedMsgManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 76	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   26: invokevirtual 82	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   29: astore_2
    //   30: new 84	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 87
    //   41: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 27	com/tencent/mobileqq/redtouch/NumRedMsgManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: new 97	java/io/File
    //   60: dup
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 106	java/io/File:exists	()Z
    //   74: ifne +22 -> 96
    //   77: aload_0
    //   78: ldc 219
    //   80: invokespecial 221	com/tencent/mobileqq/redtouch/NumRedMsgManager:a	(Ljava/lang/String;)V
    //   83: aload_2
    //   84: invokevirtual 224	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: goto +8 -> 96
    //   91: astore_3
    //   92: aload_3
    //   93: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   96: aload_0
    //   97: monitorenter
    //   98: aload_2
    //   99: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: ifnonnull +11 -> 117
    //   109: aload_0
    //   110: ldc 233
    //   112: invokespecial 221	com/tencent/mobileqq/redtouch/NumRedMsgManager:a	(Ljava/lang/String;)V
    //   115: aconst_null
    //   116: areturn
    //   117: aload_1
    //   118: aload_2
    //   119: invokevirtual 237	com/tencent/mobileqq/tianshu/pb/NumRedMsg$NumMsgRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: pop
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial 125	com/tencent/mobileqq/redtouch/NumRedMsgManager:a	(Lcom/tencent/mobileqq/tianshu/pb/NumRedMsg$NumMsgRspBody;)V
    //   128: aload_1
    //   129: areturn
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   135: aload_0
    //   136: ldc 240
    //   138: invokespecial 221	com/tencent/mobileqq/redtouch/NumRedMsgManager:a	(Ljava/lang/String;)V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	NumRedMsgManager
    //   4	125	1	localNumMsgRspBody	NumRedMsg.NumMsgRspBody
    //   130	2	1	localException	java.lang.Exception
    //   143	4	1	localObject1	Object
    //   29	90	2	localObject2	Object
    //   37	26	3	localStringBuilder	StringBuilder
    //   91	2	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   83	88	91	java/io/IOException
    //   117	123	130	java/lang/Exception
    //   98	105	143	finally
    //   144	146	143	finally
  }
  
  public void a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody, ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i = paramToServiceMsg.extraData.getInt("NumMsgListenerKey");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("NumMsgIDList");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("NumMsgListenerCmd");
    if (paramBoolean)
    {
      if (paramNumMsgRspBody == null) {
        return;
      }
      if (!a()) {
        a(paramNumMsgRspBody);
      } else {
        b(paramNumMsgRspBody);
      }
    }
    paramNumMsgRspBody = (NumRedGetMsgCallback)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (paramNumMsgRspBody != null) {
      a(arrayOfLong, paramNumMsgRspBody, paramToServiceMsg, true);
    }
  }
  
  public void a(List<Submsgtype0x89.NumRedBusiInfo> paramList, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback)
  {
    ThreadManager.post(new NumRedMsgManager.1(this, paramList, paramNumRedGetMsgCallback, paramString), 5, null, false);
  }
  
  public void a(long[] paramArrayOfLong, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback)
  {
    a(paramArrayOfLong, paramNumRedGetMsgCallback, paramString, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager
 * JD-Core Version:    0.7.0.1
 */