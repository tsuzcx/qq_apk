import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class lew
  implements ServiceConnection
{
  lew(leu paramleu) {}
  
  /* Error */
  public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 24
    //   2: iconst_1
    //   3: new 26	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   10: ldc 29
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 38
    //   21: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 48	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: getfield 12	lew:a	Lleu;
    //   34: iconst_0
    //   35: putfield 53	leu:jdField_a_of_type_Boolean	Z
    //   38: aload_0
    //   39: getfield 12	lew:a	Lleu;
    //   42: aload_2
    //   43: invokestatic 58	lwm:a	(Landroid/os/IBinder;)Llwl;
    //   46: putfield 61	leu:jdField_a_of_type_Lwl	Llwl;
    //   49: aload_0
    //   50: getfield 12	lew:a	Lleu;
    //   53: getfield 61	leu:jdField_a_of_type_Lwl	Llwl;
    //   56: aload_0
    //   57: getfield 12	lew:a	Lleu;
    //   60: getfield 64	leu:jdField_a_of_type_Lwj	Llwj;
    //   63: ldc 66
    //   65: invokeinterface 71 3 0
    //   70: aload_0
    //   71: getfield 12	lew:a	Lleu;
    //   74: getfield 74	leu:b	Z
    //   77: ifeq +10 -> 87
    //   80: aload_0
    //   81: getfield 12	lew:a	Lleu;
    //   84: invokevirtual 77	leu:e	()V
    //   87: aload_0
    //   88: getfield 12	lew:a	Lleu;
    //   91: getfield 80	leu:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: bipush 10
    //   102: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokevirtual 91	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 12	lew:a	Lleu;
    //   113: getfield 61	leu:jdField_a_of_type_Lwl	Llwl;
    //   116: invokeinterface 95 1 0
    //   121: new 97	lex
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 100	lex:<init>	(Llew;)V
    //   129: iconst_0
    //   130: invokeinterface 106 3 0
    //   135: aload_0
    //   136: getfield 12	lew:a	Lleu;
    //   139: getfield 80	leu:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   142: ifnull +29 -> 171
    //   145: aload_0
    //   146: getfield 12	lew:a	Lleu;
    //   149: getfield 80	leu:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   152: getfield 109	com/tencent/av/app/VideoAppInterface:a	Lcom/tencent/av/VideoController;
    //   155: ifnull +16 -> 171
    //   158: aload_0
    //   159: getfield 12	lew:a	Lleu;
    //   162: getfield 80	leu:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   165: invokevirtual 112	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   168: invokevirtual 117	com/tencent/av/VideoController:H	()V
    //   171: return
    //   172: astore_1
    //   173: ldc 24
    //   175: new 26	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   182: ldc 119
    //   184: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 122	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 128	lba:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -91 -> 109
    //   203: astore_1
    //   204: ldc 24
    //   206: new 26	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   213: ldc 119
    //   215: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   222: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 128	lba:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -96 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	lew
    //   0	234	1	paramComponentName	ComponentName
    //   0	234	2	paramIBinder	android.os.IBinder
    // Exception table:
    //   from	to	target	type
    //   49	87	172	android/os/RemoteException
    //   87	109	172	android/os/RemoteException
    //   109	135	203	java/lang/Exception
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
    }
    try
    {
      if (this.a.jdField_a_of_type_Lwl != null) {
        this.a.jdField_a_of_type_Lwl.a(this.a.jdField_a_of_type_Lwj);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(11) });
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", paramComponentName);
      }
    }
    this.a.jdField_a_of_type_Lwl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lew
 * JD-Core Version:    0.7.0.1
 */