package com.tencent.mobileqq.intervideo.singtogether;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.aio.video.aio_video.ReqGetOpenIdByUin;

public class FetchOpenIdServlet
  extends MSFServlet
{
  public static NewIntent a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    int i = Utils.a(paramLong2);
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), FetchOpenIdServlet.class);
    localNewIntent.putExtra("appId", i);
    localNewIntent.putExtra("sso_command", "QQAIOMediaSvc.get_openid_by_uin");
    localNewIntent.putExtra("req_type", 1);
    localNewIntent.putExtra("uin", paramLong1);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  /* Error */
  private void a(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 62	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4: invokestatic 68	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   7: astore 9
    //   9: aload_3
    //   10: invokevirtual 72	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +14 -> 27
    //   16: aload 9
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 5
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 5
    //   30: new 74	android/os/Bundle
    //   33: dup
    //   34: invokespecial 75	android/os/Bundle:<init>	()V
    //   37: astore 8
    //   39: aload_2
    //   40: ldc 29
    //   42: iconst_0
    //   43: invokevirtual 81	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   46: istore 4
    //   48: aload_2
    //   49: ldc 44
    //   51: lconst_0
    //   52: invokevirtual 85	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   55: lstore 6
    //   57: aload 8
    //   59: ldc 29
    //   61: iload 4
    //   63: invokevirtual 89	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   66: aload 8
    //   68: ldc 44
    //   70: lload 6
    //   72: invokevirtual 93	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   75: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +89 -> 167
    //   81: new 100	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   88: astore 10
    //   90: aload 10
    //   92: ldc 103
    //   94: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 10
    //   100: iload 5
    //   102: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 10
    //   108: ldc 112
    //   110: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 10
    //   116: aload_3
    //   117: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   120: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 10
    //   126: ldc 121
    //   128: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 10
    //   134: iload 4
    //   136: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 10
    //   142: ldc 123
    //   144: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 10
    //   150: lload 6
    //   152: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 128
    //   158: iconst_2
    //   159: aload 10
    //   161: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iload 5
    //   169: ifeq +227 -> 396
    //   172: new 138	tencent/aio/video/aio_video$RspGetOpenIdByUin
    //   175: dup
    //   176: invokespecial 139	tencent/aio/video/aio_video$RspGetOpenIdByUin:<init>	()V
    //   179: astore_3
    //   180: aload_3
    //   181: aload 9
    //   183: invokevirtual 143	tencent/aio/video/aio_video$RspGetOpenIdByUin:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   186: pop
    //   187: aload_3
    //   188: getfield 147	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   191: getfield 153	tencent/aio/video/aio_video$ErrInfo:err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   194: invokevirtual 158	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   197: istore 4
    //   199: iload 4
    //   201: ifne +69 -> 270
    //   204: aload_3
    //   205: getfield 162	tencent/aio/video/aio_video$RspGetOpenIdByUin:open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   208: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   211: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   214: astore_3
    //   215: aload 8
    //   217: ldc 174
    //   219: aload_3
    //   220: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: new 100	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   230: astore 9
    //   232: aload 9
    //   234: ldc 180
    //   236: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 9
    //   242: aload_3
    //   243: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 128
    //   249: iconst_2
    //   250: aload 9
    //   252: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_0
    //   259: aload_2
    //   260: iload_1
    //   261: iconst_1
    //   262: aload 8
    //   264: ldc 182
    //   266: invokevirtual 186	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   269: return
    //   270: aload_3
    //   271: getfield 147	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   274: getfield 189	tencent/aio/video/aio_video$ErrInfo:err_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   277: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   280: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   283: astore_3
    //   284: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +54 -> 341
    //   290: new 100	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   297: astore 9
    //   299: aload 9
    //   301: ldc 191
    //   303: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 9
    //   309: iload 4
    //   311: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 9
    //   317: ldc 193
    //   319: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 9
    //   325: aload_3
    //   326: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc 128
    //   332: iconst_2
    //   333: aload 9
    //   335: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 8
    //   343: ldc 198
    //   345: aload_3
    //   346: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: goto +47 -> 396
    //   352: astore_2
    //   353: goto +41 -> 394
    //   356: astore_3
    //   357: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +36 -> 396
    //   363: ldc 128
    //   365: iconst_2
    //   366: ldc 200
    //   368: aload_3
    //   369: invokestatic 203	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto +24 -> 396
    //   375: astore_3
    //   376: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +17 -> 396
    //   382: ldc 128
    //   384: iconst_2
    //   385: ldc 205
    //   387: aload_3
    //   388: invokestatic 203	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: goto +5 -> 396
    //   394: aload_2
    //   395: athrow
    //   396: aload_0
    //   397: aload_2
    //   398: iload_1
    //   399: iconst_0
    //   400: aload 8
    //   402: ldc 182
    //   404: invokevirtual 186	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   407: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	FetchOpenIdServlet
    //   0	408	1	paramInt	int
    //   0	408	2	paramIntent	Intent
    //   0	408	3	paramFromServiceMsg	FromServiceMsg
    //   46	264	4	i	int
    //   22	146	5	bool	boolean
    //   55	96	6	l	long
    //   37	364	8	localBundle	android.os.Bundle
    //   7	327	9	localObject	Object
    //   88	72	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	199	352	finally
    //   204	269	352	finally
    //   270	341	352	finally
    //   341	349	352	finally
    //   357	372	352	finally
    //   376	391	352	finally
    //   172	199	356	java/lang/Exception
    //   204	269	356	java/lang/Exception
    //   270	341	356	java/lang/Exception
    //   341	349	356	java/lang/Exception
    //   172	199	375	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	269	375	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   270	341	375	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   341	349	375	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("uin", 0L);
    int i = paramIntent.getIntExtra("appId", 0);
    paramIntent = paramIntent.getStringExtra("sso_command");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPacket uin=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" appId=");
      ((StringBuilder)localObject).append(i);
      QLog.d("FetchOpenIdServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new aio_video.ReqGetOpenIdByUin();
    ((aio_video.ReqGetOpenIdByUin)localObject).app_id.set(i);
    ((aio_video.ReqGetOpenIdByUin)localObject).target_uin.set(l);
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(WupUtil.a(((aio_video.ReqGetOpenIdByUin)localObject).toByteArray()));
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive cmd:");
      localStringBuilder.append(i);
      QLog.d("FetchOpenIdServlet", 2, localStringBuilder.toString());
    }
    a(i, paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "onSend");
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdServlet
 * JD-Core Version:    0.7.0.1
 */