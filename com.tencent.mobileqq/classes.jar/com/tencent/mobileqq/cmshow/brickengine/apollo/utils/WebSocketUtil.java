package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.apollo.model.ApolloNioSocketInfo;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class WebSocketUtil
{
  public static Map<Long, BufferedOutputStream> a = Collections.synchronizedMap(new HashMap());
  public static Map<Long, BufferedInputStream> b = Collections.synchronizedMap(new HashMap());
  public static Map<Long, SSLSocket> c = Collections.synchronizedMap(new HashMap());
  
  public static int a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    Object localObject = (SSLSocket)c.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return 0;
    }
    BufferedInputStream localBufferedInputStream = (BufferedInputStream)b.get(Long.valueOf(paramLong));
    BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)a.get(Long.valueOf(paramLong));
    if (((SSLSocket)localObject).isClosed())
    {
      c.remove(Long.valueOf(paramLong));
      b.remove(Long.valueOf(paramLong));
      a.remove(Long.valueOf(paramLong));
      return 0;
    }
    try
    {
      localBufferedInputStream.close();
      localBufferedOutputStream.close();
      ((SSLSocket)localObject).close();
      c.remove(Long.valueOf(paramLong));
      b.remove(Long.valueOf(paramLong));
      a.remove(Long.valueOf(paramLong));
      int i = 0;
      while (i < localApolloRender.mNioList.size())
      {
        if (((ApolloNioSocketInfo)localApolloRender.mNioList.get(i)).mSocketStr == paramLong)
        {
          localApolloRender.mNioList.remove(i);
          return 0;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("websocket ssl close Error:");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("[cmshow]WebSocketUtil", 1, ((StringBuilder)localObject).toString());
      return 0;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]WebSocketUtil", 1, localOutOfMemoryError.getMessage());
    }
  }
  
  /* Error */
  public static int a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 43	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getCurrentRender	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;
    //   3: astore 11
    //   5: getstatic 30	com/tencent/mobileqq/cmshow/brickengine/apollo/utils/WebSocketUtil:c	Ljava/util/Map;
    //   8: lload_0
    //   9: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   12: invokeinterface 55 2 0
    //   17: checkcast 57	javax/net/ssl/SSLSocket
    //   20: astore 8
    //   22: invokestatic 128	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getCurrentRenderView	()Landroid/view/View;
    //   25: ifnonnull +13 -> 38
    //   28: ldc 109
    //   30: ldc 130
    //   32: invokestatic 136	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload 8
    //   40: ifnull +13 -> 53
    //   43: ldc 109
    //   45: iconst_1
    //   46: ldc 138
    //   48: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 142	java/net/InetSocketAddress
    //   56: dup
    //   57: aload_2
    //   58: iload_3
    //   59: invokespecial 145	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   62: astore 12
    //   64: aconst_null
    //   65: astore 10
    //   67: aconst_null
    //   68: astore 9
    //   70: invokestatic 151	java/nio/channels/SocketChannel:open	()Ljava/nio/channels/SocketChannel;
    //   73: astore 8
    //   75: aload 8
    //   77: iconst_0
    //   78: invokevirtual 155	java/nio/channels/SocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   81: pop
    //   82: aload 8
    //   84: aload 12
    //   86: invokevirtual 159	java/nio/channels/SocketChannel:connect	(Ljava/net/SocketAddress;)Z
    //   89: pop
    //   90: aload 8
    //   92: astore 9
    //   94: new 88	com/tencent/mobileqq/apollo/model/ApolloNioSocketInfo
    //   97: dup
    //   98: lload_0
    //   99: aload_2
    //   100: iload_3
    //   101: iload 4
    //   103: aload 6
    //   105: aload 7
    //   107: aload 8
    //   109: invokespecial 162	com/tencent/mobileqq/apollo/model/ApolloNioSocketInfo:<init>	(JLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/nio/channels/SocketChannel;)V
    //   112: astore_2
    //   113: aload 11
    //   115: getfield 77	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mNioList	Ljava/util/List;
    //   118: aload_2
    //   119: invokeinterface 166 2 0
    //   124: pop
    //   125: aload 9
    //   127: ifnull +33 -> 160
    //   130: aload 9
    //   132: invokevirtual 167	java/nio/channels/SocketChannel:close	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_2
    //   138: ldc 109
    //   140: iconst_1
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 169
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: invokevirtual 170	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: goto +8 -> 171
    //   166: astore_2
    //   167: goto +8 -> 175
    //   170: astore_2
    //   171: goto +87 -> 258
    //   174: astore_2
    //   175: aload_2
    //   176: astore 6
    //   178: aload 8
    //   180: astore_2
    //   181: goto +16 -> 197
    //   184: astore_2
    //   185: aload 9
    //   187: astore 8
    //   189: goto +69 -> 258
    //   192: astore 6
    //   194: aload 10
    //   196: astore_2
    //   197: aload_2
    //   198: astore 9
    //   200: ldc 109
    //   202: iconst_1
    //   203: iconst_2
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: ldc 175
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload 6
    //   216: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   223: aload_2
    //   224: ifnull +32 -> 256
    //   227: aload_2
    //   228: invokevirtual 167	java/nio/channels/SocketChannel:close	()V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_2
    //   234: ldc 109
    //   236: iconst_1
    //   237: iconst_2
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: ldc 169
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload_2
    //   249: invokevirtual 170	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: aload 8
    //   260: ifnull +36 -> 296
    //   263: aload 8
    //   265: invokevirtual 167	java/nio/channels/SocketChannel:close	()V
    //   268: goto +28 -> 296
    //   271: astore 6
    //   273: ldc 109
    //   275: iconst_1
    //   276: iconst_2
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: ldc 169
    //   284: aastore
    //   285: dup
    //   286: iconst_1
    //   287: aload 6
    //   289: invokevirtual 170	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   292: aastore
    //   293: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   296: aload_2
    //   297: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramLong	long
    //   0	298	2	paramString1	String
    //   0	298	3	paramInt1	int
    //   0	298	4	paramInt2	int
    //   0	298	5	paramInt3	int
    //   0	298	6	paramString2	String
    //   0	298	7	paramString3	String
    //   20	244	8	localObject1	Object
    //   68	131	9	localObject2	Object
    //   65	130	10	localObject3	Object
    //   3	111	11	localApolloRender	ApolloRender
    //   62	23	12	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   130	135	137	java/lang/Throwable
    //   94	125	162	finally
    //   94	125	166	java/io/IOException
    //   75	90	170	finally
    //   75	90	174	java/io/IOException
    //   70	75	184	finally
    //   200	223	184	finally
    //   70	75	192	java/io/IOException
    //   227	231	233	java/lang/Throwable
    //   263	268	271	java/lang/Throwable
  }
  
  public static int a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, Socket paramSocket)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null)
    {
      Log.d("[cmshow]WebSocketUtil", "websocketShakeHand: view is null");
      return 0;
    }
    if (paramInt2 <= 0) {
      return 0;
    }
    try
    {
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().webSocketSetState(paramLong, 4);
      if ((paramString2 != null) && (!paramString2.equals(""))) {
        paramString2 = SSLContext.getInstance(paramString2);
      } else {
        paramString2 = SSLContext.getInstance("SSL");
      }
      paramString2.init(null, null, null);
      paramString1 = (SSLSocket)paramString2.getSocketFactory().createSocket(paramSocket, paramString1, paramInt1, true);
      if (!paramString1.isConnected())
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().webSocketSetState(paramLong, 6);
        QLog.e("[cmshow]WebSocketUtil", 2, "ssl handshake failed: sslsocket is not connected");
        paramString1.close();
        return 0;
      }
      paramString1.setUseClientMode(true);
      paramString1.setKeepAlive(true);
      if ((paramString3 != null) && (!paramString3.equals(""))) {
        paramString1.setEnabledProtocols(new String[] { paramString3 });
      }
      paramString1.addHandshakeCompletedListener(new WebSocketUtil.1(localView, paramLong));
      paramString1.startHandshake();
      paramInt1 = a(paramSocket);
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().webSocketSetSocket(paramLong, paramInt1);
      c.put(Long.valueOf(paramLong), paramString1);
      paramString2 = new BufferedInputStream(paramString1.getInputStream());
      b.put(Long.valueOf(paramLong), paramString2);
      paramString1 = new BufferedOutputStream(paramString1.getOutputStream());
      a.put(Long.valueOf(paramLong), paramString1);
      return 0;
    }
    catch (Exception paramString1)
    {
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().webSocketSetState(paramLong, 6);
      paramString2 = new StringBuilder();
      paramString2.append("handshake Error:");
      paramString2.append(paramString1.getMessage());
      QLog.e("[cmshow]WebSocketUtil", 1, paramString2.toString());
      return 0;
    }
    catch (OutOfMemoryError paramString1)
    {
      QLog.e("[cmshow]WebSocketUtil", 1, paramString1.getMessage());
    }
    return 0;
  }
  
  public static int a(long paramLong, byte[] paramArrayOfByte)
  {
    new String(paramArrayOfByte);
    if ((SSLSocket)c.get(Long.valueOf(paramLong)) == null) {
      return 0;
    }
    Object localObject = (BufferedOutputStream)a.get(Long.valueOf(paramLong));
    BufferedInputStream localBufferedInputStream = (BufferedInputStream)b.get(Long.valueOf(paramLong));
    if (localObject != null) {
      try
      {
        ((BufferedOutputStream)localObject).write(paramArrayOfByte);
        ((BufferedOutputStream)localObject).flush();
        int i = paramArrayOfByte.length;
        return i;
      }
      catch (Exception paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("websocket ssl send Error:");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        QLog.e("[cmshow]WebSocketUtil", 1, ((StringBuilder)localObject).toString());
        return 0;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        QLog.d("[cmshow]WebSocketUtil", 1, paramArrayOfByte.getMessage());
      }
    }
    return 0;
  }
  
  private static int a(Socket paramSocket)
  {
    Object localObject;
    label191:
    do
    {
      for (;;)
      {
        try
        {
          localField1 = Socket.class.getDeclaredField("impl");
          localField1.setAccessible(true);
          localField2 = SocketImpl.class.getDeclaredField("fd");
          localField2.setAccessible(true);
          Field[] arrayOfField = FileDescriptor.class.getDeclaredFields();
          localObject = null;
          i = 0;
          if (i >= arrayOfField.length) {
            break;
          }
          if ("descriptor".equals(arrayOfField[i].getName())) {
            localObject = FileDescriptor.class.getDeclaredField("descriptor");
          }
          if (!"fd".equals(arrayOfField[i].getName())) {
            break label191;
          }
          localObject = FileDescriptor.class.getDeclaredField("fd");
        }
        catch (Exception paramSocket)
        {
          Field localField1;
          Field localField2;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("socket exception e=");
          ((StringBuilder)localObject).append(paramSocket.toString());
          QLog.e("[cmshow]WebSocketUtil", 2, ((StringBuilder)localObject).toString());
          return 0;
        }
        catch (OutOfMemoryError paramSocket)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("[cmshow]WebSocketUtil", 2, paramSocket.getMessage());
          return 0;
        }
        ((Field)localObject).setAccessible(true);
        int i = ((Field)localObject).getInt((FileDescriptor)localField2.get((SocketImpl)localField1.get(paramSocket)));
        return i;
        i += 1;
      }
    } while (localObject != null);
    return 0;
  }
  
  @TargetApi(14)
  public static byte[] a(long paramLong, int paramInt)
  {
    if ((SSLSocket)c.get(Long.valueOf(paramLong)) == null) {
      return null;
    }
    Object localObject1 = (BufferedInputStream)b.get(Long.valueOf(paramLong));
    if ((localObject1 != null) && (paramInt > 0)) {
      try
      {
        localObject2 = new byte[paramInt];
        paramInt = ((BufferedInputStream)localObject1).read((byte[])localObject2, 0, paramInt);
        if (paramInt > 0)
        {
          localObject1 = Arrays.copyOf((byte[])localObject2, paramInt);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("websocket ssl recv Error:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("[cmshow]WebSocketUtil", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]WebSocketUtil", 1, localOutOfMemoryError.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.WebSocketUtil
 * JD-Core Version:    0.7.0.1
 */