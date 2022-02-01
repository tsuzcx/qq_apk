package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;

class ChannelCenter$1
  implements SSOCallback
{
  ChannelCenter$1(ChannelCenter paramChannelCenter, int paramInt, IChannelListener paramIChannelListener) {}
  
  public void a(int paramInt, String paramString)
  {
    Log.d("ChannelCenter", "WebServiceSSO--onFail errCode=" + this.jdField_a_of_type_Int + ", errMsg=" + paramString);
    if (ChannelCenter.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoIChannelListener.a(paramInt, paramString);
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 25
    //   2: new 27	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   9: ldc 67
    //   11: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 16	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1:jdField_a_of_type_Int	I
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 70	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   27: pop
    //   28: aload_0
    //   29: getfield 14	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1:jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter	Lcom/tencent/mobileqq/now/netchannel/websso/ChannelCenter;
    //   32: invokestatic 54	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter:a	(Lcom/tencent/mobileqq/now/netchannel/websso/ChannelCenter;)Z
    //   35: ifeq +12 -> 47
    //   38: ldc 25
    //   40: ldc 56
    //   42: invokestatic 49	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: return
    //   47: new 72	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp
    //   50: dup
    //   51: invokespecial 73	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp:<init>	()V
    //   54: astore 4
    //   56: aload 4
    //   58: aload_1
    //   59: invokevirtual 77	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: pop
    //   63: aload 4
    //   65: getfield 81	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp:busi_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   68: invokevirtual 87	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 93	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   74: astore_3
    //   75: aload_3
    //   76: astore_1
    //   77: aload 4
    //   79: getfield 97	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp:stream_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +24 -> 109
    //   88: aload 4
    //   90: getfield 97	com/tencent/mobileqq/now/wnsilivehead/WnsHeadProto$ForwardRsp:stream_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 106	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: istore_2
    //   97: aload_3
    //   98: astore_1
    //   99: iload_2
    //   100: iconst_1
    //   101: if_icmpne +8 -> 109
    //   104: aload_3
    //   105: invokestatic 111	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	([B)[B
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -64 -> 46
    //   113: aload_0
    //   114: getfield 14	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1:jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter	Lcom/tencent/mobileqq/now/netchannel/websso/ChannelCenter;
    //   117: invokestatic 114	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter:a	(Lcom/tencent/mobileqq/now/netchannel/websso/ChannelCenter;)Landroid/os/Handler;
    //   120: new 116	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1$1
    //   123: dup
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial 119	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1$1:<init>	(Lcom/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1;[B)V
    //   129: invokevirtual 125	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   132: pop
    //   133: return
    //   134: astore_1
    //   135: aload_0
    //   136: getfield 18	com/tencent/mobileqq/now/netchannel/websso/ChannelCenter$1:jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoIChannelListener	Lcom/tencent/mobileqq/now/netchannel/websso/IChannelListener;
    //   139: ldc 126
    //   141: ldc 128
    //   143: invokeinterface 60 3 0
    //   148: return
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -47 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	1
    //   0	159	1	paramArrayOfByte	byte[]
    //   96	6	2	i	int
    //   74	31	3	arrayOfByte	byte[]
    //   54	35	4	localForwardRsp	com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardRsp
    // Exception table:
    //   from	to	target	type
    //   56	75	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   77	97	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   104	109	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	133	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	154	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   104	109	149	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1
 * JD-Core Version:    0.7.0.1
 */