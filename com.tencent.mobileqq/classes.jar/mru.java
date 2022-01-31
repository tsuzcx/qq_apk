import android.os.AsyncTask;

public class mru
  extends AsyncTask<Void, Void, String>
{
  String a;
  String b;
  String c;
  
  public mru(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  /* Error */
  protected String a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	mru:a	Ljava/lang/String;
    //   4: aload_0
    //   5: getfield 18	mru:b	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 20	mru:c	Ljava/lang/String;
    //   12: invokestatic 31	mrt:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +28 -> 47
    //   22: ldc 39
    //   24: iconst_2
    //   25: new 41	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   32: ldc 44
    //   34: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_1
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 59	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   65: aload_1
    //   66: areturn
    //   67: astore_2
    //   68: goto -7 -> 61
    //   71: astore_2
    //   72: goto -20 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	mru
    //   0	75	1	paramVarArgs	Void[]
    //   49	4	2	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   58	4	2	localException1	java.lang.Exception
    //   67	1	2	localException2	java.lang.Exception
    //   71	1	2	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    // Exception table:
    //   from	to	target	type
    //   0	16	49	org/apache/http/client/ClientProtocolException
    //   0	16	58	java/lang/Exception
    //   16	47	67	java/lang/Exception
    //   16	47	71	org/apache/http/client/ClientProtocolException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mru
 * JD-Core Version:    0.7.0.1
 */