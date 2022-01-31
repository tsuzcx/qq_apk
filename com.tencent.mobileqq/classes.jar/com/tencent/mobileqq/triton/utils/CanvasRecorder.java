package com.tencent.mobileqq.triton.utils;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.TTNativeModule;

@TTNativeModule(name="CanvasRecorder")
public class CanvasRecorder
{
  public static final String TAG = "CanvasRecorder";
  private TTEngine mTritonEngine;
  
  public CanvasRecorder(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  /* Error */
  @com.tencent.mobileqq.triton.jni.TTNativeCall
  public String canvasToTempFilePathSync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +175 -> 176
    //   4: iload_2
    //   5: iload_3
    //   6: getstatic 33	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 39	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 8
    //   14: aload 8
    //   16: aload_1
    //   17: invokestatic 45	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   20: invokevirtual 49	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   23: iload 4
    //   25: ifle +129 -> 154
    //   28: iload 5
    //   30: ifle +124 -> 154
    //   33: aload 8
    //   35: iload 4
    //   37: iload 5
    //   39: iconst_0
    //   40: invokestatic 53	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   43: astore_1
    //   44: aload 8
    //   46: invokevirtual 56	android/graphics/Bitmap:recycle	()V
    //   49: aload_1
    //   50: ifnull +195 -> 245
    //   53: aload_0
    //   54: getfield 19	com/tencent/mobileqq/triton/utils/CanvasRecorder:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   57: invokevirtual 62	com/tencent/mobileqq/triton/engine/TTEngine:getQQEnv	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   60: aload_0
    //   61: getfield 19	com/tencent/mobileqq/triton/utils/CanvasRecorder:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   64: invokevirtual 66	com/tencent/mobileqq/triton/engine/TTEngine:getMiniGameInfo	()Lcom/tencent/mobileqq/triton/sdk/game/MiniGameInfo;
    //   67: aload 6
    //   69: invokeinterface 72 3 0
    //   74: astore 8
    //   76: ldc 74
    //   78: aload 6
    //   80: invokevirtual 80	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   83: ifeq +132 -> 215
    //   86: getstatic 86	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   89: astore 6
    //   91: aload_1
    //   92: aload 6
    //   94: iload 7
    //   96: new 88	java/io/FileOutputStream
    //   99: dup
    //   100: aload 8
    //   102: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 95	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   108: ifeq +115 -> 223
    //   111: ldc 10
    //   113: new 97	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   120: ldc 100
    //   122: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 8
    //   127: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 114	com/tencent/mobileqq/triton/engine/TTLog:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   136: pop
    //   137: aload_0
    //   138: getfield 19	com/tencent/mobileqq/triton/utils/CanvasRecorder:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   141: invokevirtual 62	com/tencent/mobileqq/triton/engine/TTEngine:getQQEnv	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   144: aload 8
    //   146: invokeinterface 118 2 0
    //   151: astore_1
    //   152: aload_1
    //   153: areturn
    //   154: aload 8
    //   156: astore_1
    //   157: goto -108 -> 49
    //   160: astore_1
    //   161: ldc 10
    //   163: ldc 120
    //   165: aload_1
    //   166: invokestatic 124	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   169: pop
    //   170: aload 8
    //   172: astore_1
    //   173: goto -124 -> 49
    //   176: ldc 10
    //   178: new 97	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   185: ldc 126
    //   187: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_2
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 131
    //   196: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_3
    //   200: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 133	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -163 -> 49
    //   215: getstatic 136	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   218: astore 6
    //   220: goto -129 -> 91
    //   223: ldc 10
    //   225: ldc 138
    //   227: invokestatic 133	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: aconst_null
    //   232: areturn
    //   233: astore_1
    //   234: ldc 10
    //   236: ldc 120
    //   238: aload_1
    //   239: invokestatic 124	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   242: pop
    //   243: aconst_null
    //   244: areturn
    //   245: aconst_null
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	CanvasRecorder
    //   0	247	1	paramArrayOfByte	byte[]
    //   0	247	2	paramInt1	int
    //   0	247	3	paramInt2	int
    //   0	247	4	paramInt3	int
    //   0	247	5	paramInt4	int
    //   0	247	6	paramString	String
    //   0	247	7	paramInt5	int
    //   12	159	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	49	160	java/lang/IllegalArgumentException
    //   76	91	233	java/io/FileNotFoundException
    //   91	152	233	java/io/FileNotFoundException
    //   215	220	233	java/io/FileNotFoundException
    //   223	231	233	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.CanvasRecorder
 * JD-Core Version:    0.7.0.1
 */