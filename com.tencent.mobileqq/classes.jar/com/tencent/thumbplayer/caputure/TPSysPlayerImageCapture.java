package com.tencent.thumbplayer.caputure;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;

public class TPSysPlayerImageCapture
{
  private static final int EV_CAP_IMAGE = 1;
  private static final int EV_STOP_CAP_IMAGE = 2;
  private static final String TAG = "TPSysPlayerImageCapture";
  private static TPSysPlayerImageCapture gInstance;
  private int mBaseID = 0;
  private TPSysPlayerImageCapture.EventHandler mCapHandler = null;
  private HandlerThread mHandlerThread = null;
  private MediaMetadataRetriever mRetriever = null;
  
  private TPSysPlayerImageCapture()
  {
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.mCapHandler = new TPSysPlayerImageCapture.EventHandler(this, this.mHandlerThread.getLooper());
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPSysPlayerImageCapture", localThrowable);
      this.mCapHandler = new TPSysPlayerImageCapture.EventHandler(this, Looper.getMainLooper());
    }
  }
  
  public static TPSysPlayerImageCapture GetImageCaptureInstance()
  {
    try
    {
      if (gInstance == null) {
        gInstance = new TPSysPlayerImageCapture();
      }
      TPSysPlayerImageCapture localTPSysPlayerImageCapture = gInstance;
      return localTPSysPlayerImageCapture;
    }
    finally {}
  }
  
  /* Error */
  private void doRealCaptureImage(TPSysPlayerImageCapture.CaptureMsg paramCaptureMsg)
  {
    // Byte code:
    //   0: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmplt +173 -> 178
    //   8: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   11: lstore_2
    //   12: aload_0
    //   13: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   23: invokevirtual 101	android/media/MediaMetadataRetriever:release	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   31: aload_0
    //   32: new 98	android/media/MediaMetadataRetriever
    //   35: dup
    //   36: invokespecial 102	android/media/MediaMetadataRetriever:<init>	()V
    //   39: putfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   42: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 14
    //   47: if_icmplt +42 -> 89
    //   50: aload_1
    //   51: invokestatic 108	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$200	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)Ljava/io/FileDescriptor;
    //   54: ifnull +17 -> 71
    //   57: aload_0
    //   58: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   61: aload_1
    //   62: invokestatic 108	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$200	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)Ljava/io/FileDescriptor;
    //   65: invokevirtual 112	android/media/MediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   68: goto +21 -> 89
    //   71: aload_0
    //   72: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   75: aload_1
    //   76: invokestatic 116	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$300	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)Ljava/lang/String;
    //   79: new 118	java/util/HashMap
    //   82: dup
    //   83: invokespecial 119	java/util/HashMap:<init>	()V
    //   86: invokevirtual 122	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   89: aload_0
    //   90: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   93: aload_1
    //   94: invokestatic 126	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$400	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)J
    //   97: ldc2_w 127
    //   100: lmul
    //   101: iconst_2
    //   102: invokevirtual 132	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   105: astore 6
    //   107: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   110: lstore 4
    //   112: aload 6
    //   114: ifnull +37 -> 151
    //   117: aload_1
    //   118: getfield 136	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:lis	Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMediaImageListener;
    //   121: aload_1
    //   122: invokestatic 140	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$100	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)I
    //   125: aload_1
    //   126: invokestatic 126	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$400	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)J
    //   129: aload_1
    //   130: invokestatic 143	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$500	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)I
    //   133: aload_1
    //   134: invokestatic 146	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$600	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)I
    //   137: aload 6
    //   139: lload 4
    //   141: lload_2
    //   142: lsub
    //   143: invokeinterface 152 9 0
    //   148: goto +18 -> 166
    //   151: aload_1
    //   152: getfield 136	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:lis	Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMediaImageListener;
    //   155: aload_1
    //   156: invokestatic 140	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$100	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)I
    //   159: ldc 153
    //   161: invokeinterface 157 3 0
    //   166: aload_0
    //   167: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +100 -> 272
    //   175: goto +88 -> 263
    //   178: new 85	java/lang/Exception
    //   181: dup
    //   182: ldc 159
    //   184: invokespecial 160	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore_1
    //   189: goto +84 -> 273
    //   192: astore 6
    //   194: ldc 13
    //   196: aload 6
    //   198: invokestatic 63	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: new 162	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   208: astore 7
    //   210: aload 7
    //   212: ldc 165
    //   214: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 7
    //   220: aload 6
    //   222: invokevirtual 173	java/lang/Exception:toString	()Ljava/lang/String;
    //   225: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 13
    //   231: aload 7
    //   233: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 177	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_1
    //   240: getfield 136	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:lis	Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMediaImageListener;
    //   243: aload_1
    //   244: invokestatic 140	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg:access$100	(Lcom/tencent/thumbplayer/caputure/TPSysPlayerImageCapture$CaptureMsg;)I
    //   247: ldc 153
    //   249: invokeinterface 157 3 0
    //   254: aload_0
    //   255: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   258: astore_1
    //   259: aload_1
    //   260: ifnull +12 -> 272
    //   263: aload_1
    //   264: invokevirtual 101	android/media/MediaMetadataRetriever:release	()V
    //   267: aload_0
    //   268: aconst_null
    //   269: putfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   272: return
    //   273: aload_0
    //   274: getfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   277: astore 6
    //   279: aload 6
    //   281: ifnull +13 -> 294
    //   284: aload 6
    //   286: invokevirtual 101	android/media/MediaMetadataRetriever:release	()V
    //   289: aload_0
    //   290: aconst_null
    //   291: putfield 36	com/tencent/thumbplayer/caputure/TPSysPlayerImageCapture:mRetriever	Landroid/media/MediaMetadataRetriever;
    //   294: aload_1
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	TPSysPlayerImageCapture
    //   0	296	1	paramCaptureMsg	TPSysPlayerImageCapture.CaptureMsg
    //   11	131	2	l1	long
    //   110	30	4	l2	long
    //   105	33	6	localBitmap	android.graphics.Bitmap
    //   192	29	6	localException	java.lang.Exception
    //   277	8	6	localMediaMetadataRetriever	MediaMetadataRetriever
    //   208	24	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	31	188	finally
    //   31	68	188	finally
    //   71	89	188	finally
    //   89	112	188	finally
    //   117	148	188	finally
    //   151	166	188	finally
    //   178	188	188	finally
    //   194	254	188	finally
    //   0	31	192	java/lang/Exception
    //   31	68	192	java/lang/Exception
    //   71	89	192	java/lang/Exception
    //   89	112	192	java/lang/Exception
    //   117	148	192	java/lang/Exception
    //   151	166	192	java/lang/Exception
    //   178	188	192	java/lang/Exception
  }
  
  public int captureImageWithPosition(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, TPSysPlayerImageCapture.CaptureMediaImageListener paramCaptureMediaImageListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("captureImageWithPosition, position: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", width: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", height: ");
    ((StringBuilder)localObject).append(paramInt2);
    TPLogUtil.i("TPSysPlayerImageCapture", ((StringBuilder)localObject).toString());
    this.mBaseID += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      return -1;
    }
    localObject = new TPSysPlayerImageCapture.CaptureMsg(null);
    TPSysPlayerImageCapture.CaptureMsg.access$102((TPSysPlayerImageCapture.CaptureMsg)localObject, this.mBaseID);
    TPSysPlayerImageCapture.CaptureMsg.access$202((TPSysPlayerImageCapture.CaptureMsg)localObject, paramFileDescriptor);
    TPSysPlayerImageCapture.CaptureMsg.access$302((TPSysPlayerImageCapture.CaptureMsg)localObject, paramString);
    TPSysPlayerImageCapture.CaptureMsg.access$402((TPSysPlayerImageCapture.CaptureMsg)localObject, paramLong);
    TPSysPlayerImageCapture.CaptureMsg.access$502((TPSysPlayerImageCapture.CaptureMsg)localObject, paramInt1);
    TPSysPlayerImageCapture.CaptureMsg.access$602((TPSysPlayerImageCapture.CaptureMsg)localObject, paramInt2);
    ((TPSysPlayerImageCapture.CaptureMsg)localObject).lis = paramCaptureMediaImageListener;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localObject;
    if (!this.mCapHandler.sendMessage(paramString)) {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    return this.mBaseID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSysPlayerImageCapture
 * JD-Core Version:    0.7.0.1
 */