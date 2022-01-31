class nuv
  extends Thread
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = true;
  
  nuv(nuu paramnuu)
  {
    super("AudioPlayback");
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	nuv:isInterrupted	()Z
    //   4: ifne +102 -> 106
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 26	nuv:jdField_a_of_type_Boolean	Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: invokevirtual 41	java/lang/Object:wait	()V
    //   20: goto -11 -> 9
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 44	nuv:interrupt	()V
    //   33: goto -33 -> 0
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: getfield 24	nuv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   42: astore_1
    //   43: aload_1
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 12	nuv:jdField_a_of_type_Nuu	Lnuu;
    //   49: getfield 49	nuu:a	Lnuw;
    //   52: invokevirtual 54	nuw:a	()Lnux;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnonnull +18 -> 75
    //   60: aload_0
    //   61: getfield 24	nuv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   64: invokevirtual 41	java/lang/Object:wait	()V
    //   67: goto -22 -> 45
    //   70: astore_2
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_0
    //   78: getfield 12	nuv:jdField_a_of_type_Nuu	Lnuu;
    //   81: aload_2
    //   82: getfield 59	nux:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   85: aload_2
    //   86: getfield 62	nux:jdField_a_of_type_Long	J
    //   89: invokevirtual 66	nuu:b	(Ljava/nio/ByteBuffer;J)V
    //   92: aload_0
    //   93: getfield 12	nuv:jdField_a_of_type_Nuu	Lnuu;
    //   96: getfield 49	nuu:a	Lnuw;
    //   99: aload_2
    //   100: invokevirtual 69	nuw:a	(Lnux;)V
    //   103: goto -103 -> 0
    //   106: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	nuv
    //   23	4	1	localObject1	Object
    //   28	1	1	localInterruptedException	java.lang.InterruptedException
    //   55	2	2	localnux1	nux
    //   70	30	2	localnux2	nux
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	26	23	finally
    //   36	38	23	finally
    //   7	9	28	java/lang/InterruptedException
    //   26	28	28	java/lang/InterruptedException
    //   38	45	28	java/lang/InterruptedException
    //   73	75	28	java/lang/InterruptedException
    //   77	103	28	java/lang/InterruptedException
    //   45	56	70	finally
    //   60	67	70	finally
    //   71	73	70	finally
    //   75	77	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuv
 * JD-Core Version:    0.7.0.1
 */