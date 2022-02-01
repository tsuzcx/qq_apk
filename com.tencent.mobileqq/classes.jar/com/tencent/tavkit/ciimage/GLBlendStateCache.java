package com.tencent.tavkit.ciimage;

class GLBlendStateCache
{
  private static final String TAG = "GLBlendStateCache";
  private boolean isEnabled;
  private final int[] pNames = { 32777, 32777, 34877, 32969, 32968, 32971, 32970 };
  private final int[] params = new int[7];
  
  /* Error */
  void cache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: sipush 3042
    //   6: invokestatic 35	android/opengl/GLES20:glIsEnabled	(I)Z
    //   9: putfield 37	com/tencent/tavkit/ciimage/GLBlendStateCache:isEnabled	Z
    //   12: aload_0
    //   13: getfield 37	com/tencent/tavkit/ciimage/GLBlendStateCache:isEnabled	Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: aload_0
    //   28: getfield 25	com/tencent/tavkit/ciimage/GLBlendStateCache:pNames	[I
    //   31: arraylength
    //   32: if_icmpge -11 -> 21
    //   35: aload_0
    //   36: getfield 25	com/tencent/tavkit/ciimage/GLBlendStateCache:pNames	[I
    //   39: iload_1
    //   40: iaload
    //   41: aload_0
    //   42: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   45: iload_1
    //   46: invokestatic 41	android/opengl/GLES20:glGetIntegerv	(I[II)V
    //   49: iload_1
    //   50: iconst_1
    //   51: iadd
    //   52: istore_1
    //   53: goto -27 -> 26
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	GLBlendStateCache
    //   25	28	1	i	int
    //   16	2	2	bool	boolean
    //   56	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	56	finally
    //   26	49	56	finally
  }
  
  /* Error */
  void restore()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: new 44	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   11: ldc 47
    //   13: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   20: invokestatic 57	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 66	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 37	com/tencent/tavkit/ciimage/GLBlendStateCache:isEnabled	Z
    //   36: ifeq +64 -> 100
    //   39: sipush 3042
    //   42: invokestatic 70	android/opengl/GLES20:glEnable	(I)V
    //   45: aload_0
    //   46: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   49: iconst_0
    //   50: iaload
    //   51: invokestatic 73	android/opengl/GLES20:glBlendEquation	(I)V
    //   54: aload_0
    //   55: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   58: iconst_1
    //   59: iaload
    //   60: aload_0
    //   61: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   64: iconst_2
    //   65: iaload
    //   66: invokestatic 77	android/opengl/GLES20:glBlendEquationSeparate	(II)V
    //   69: aload_0
    //   70: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   73: iconst_3
    //   74: iaload
    //   75: aload_0
    //   76: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   79: iconst_4
    //   80: iaload
    //   81: aload_0
    //   82: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   85: iconst_5
    //   86: iaload
    //   87: aload_0
    //   88: getfield 27	com/tencent/tavkit/ciimage/GLBlendStateCache:params	[I
    //   91: bipush 6
    //   93: iaload
    //   94: invokestatic 81	android/opengl/GLES20:glBlendFuncSeparate	(IIII)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: sipush 3042
    //   103: invokestatic 84	android/opengl/GLES20:glDisable	(I)V
    //   106: goto -9 -> 97
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	GLBlendStateCache
    //   109	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	97	109	finally
    //   100	106	109	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.GLBlendStateCache
 * JD-Core Version:    0.7.0.1
 */