public class qld
  implements Runnable
{
  private String a;
  protected boolean a;
  
  public qld(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_3
    //   7: new 24	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: getfield 16	qld:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokespecial 26	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 30	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 32	java/net/HttpURLConnection
    //   24: astore_2
    //   25: aload_2
    //   26: ldc 34
    //   28: ldc 36
    //   30: invokevirtual 40	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_2
    //   34: invokevirtual 43	java/net/HttpURLConnection:connect	()V
    //   37: aload_2
    //   38: invokevirtual 47	java/net/HttpURLConnection:getResponseCode	()I
    //   41: sipush 200
    //   44: if_icmpne +8 -> 52
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 49	qld:jdField_a_of_type_Boolean	Z
    //   52: aload_2
    //   53: ifnull +7 -> 60
    //   56: aload_2
    //   57: invokevirtual 52	java/net/HttpURLConnection:disconnect	()V
    //   60: return
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload_1
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 55	java/net/MalformedURLException:printStackTrace	()V
    //   72: aload_2
    //   73: ifnull -13 -> 60
    //   76: aload_2
    //   77: invokevirtual 52	java/net/HttpURLConnection:disconnect	()V
    //   80: return
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   91: aload_2
    //   92: ifnull -32 -> 60
    //   95: aload_2
    //   96: invokevirtual 52	java/net/HttpURLConnection:disconnect	()V
    //   99: return
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 52	java/net/HttpURLConnection:disconnect	()V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -11 -> 105
    //   119: astore_3
    //   120: goto -35 -> 85
    //   123: astore_3
    //   124: goto -58 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	qld
    //   4	1	1	localObject1	Object
    //   61	4	1	localMalformedURLException1	java.net.MalformedURLException
    //   67	47	1	localObject2	Object
    //   115	1	1	localObject3	Object
    //   24	86	2	localObject4	Object
    //   6	63	3	localMalformedURLException2	java.net.MalformedURLException
    //   81	7	3	localIOException1	java.io.IOException
    //   100	4	3	localObject5	Object
    //   119	1	3	localIOException2	java.io.IOException
    //   123	1	3	localMalformedURLException3	java.net.MalformedURLException
    //   1	82	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	25	61	java/net/MalformedURLException
    //   7	25	81	java/io/IOException
    //   7	25	100	finally
    //   68	72	100	finally
    //   87	91	100	finally
    //   25	52	115	finally
    //   25	52	119	java/io/IOException
    //   25	52	123	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qld
 * JD-Core Version:    0.7.0.1
 */