package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashSet;
import java.util.Set;

public class PlayerCaptureProxy
  implements ICaptureProxy, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private SparseArray<CaptureTask.OnCaptureCallback> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ISuperPlayer.OnSeekCompleteListener jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Set<CapturePreparedListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  private SparseArray<CaptureTask> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private boolean jdField_b_of_type_Boolean = false;
  
  public PlayerCaptureProxy()
  {
    d();
  }
  
  public static void d()
  {
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplication.getContext(), new PlayerCaptureProxy.1());
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
  }
  
  public void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(paramInt, 3);
    }
  }
  
  public void a(CapturePreparedListener paramCapturePreparedListener)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramCapturePreparedListener);
  }
  
  /* Error */
  public void a(CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/PlayerCaptureProxy:jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer	Lcom/tencent/superplayer/api/ISuperPlayer;
    //   6: aload_1
    //   7: getfield 110	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/CaptureTask:c	I
    //   10: i2l
    //   11: aload_1
    //   12: getfield 112	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/CaptureTask:d	I
    //   15: aload_1
    //   16: getfield 115	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/CaptureTask:e	I
    //   19: iconst_0
    //   20: iconst_0
    //   21: sipush 300
    //   24: invokeinterface 119 8 0
    //   29: istore_3
    //   30: aload_1
    //   31: iload_3
    //   32: putfield 121	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/CaptureTask:a	I
    //   35: aload_0
    //   36: getfield 41	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/PlayerCaptureProxy:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   39: iload_3
    //   40: aload_1
    //   41: invokevirtual 125	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 39	com/tencent/mobileqq/kandian/biz/ugc/coverselect/capture/PlayerCaptureProxy:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   48: iload_3
    //   49: aload_2
    //   50: invokevirtual 125	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   53: goto +12 -> 65
    //   56: astore_1
    //   57: goto +48 -> 105
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 128	java/lang/IllegalAccessException:printStackTrace	()V
    //   65: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +34 -> 102
    //   71: new 135	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: ldc 138
    //   82: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: aload_1
    //   88: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 147
    //   94: iconst_2
    //   95: aload_2
    //   96: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	PlayerCaptureProxy
    //   0	109	1	paramCaptureTask	CaptureTask
    //   0	109	2	paramOnCaptureCallback	CaptureTask.OnCaptureCallback
    //   29	20	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	53	56	finally
    //   61	65	56	finally
    //   65	102	56	finally
    //   2	53	60	java/lang/IllegalAccessException
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    ISPlayerVideoView localISPlayerVideoView1;
    if (paramViewGroup != null)
    {
      ISPlayerVideoView localISPlayerVideoView2 = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
      localISPlayerVideoView1 = localISPlayerVideoView2;
      if ((localISPlayerVideoView2 instanceof View))
      {
        paramViewGroup.addView((View)localISPlayerVideoView2);
        localISPlayerVideoView1 = localISPlayerVideoView2;
      }
    }
    else
    {
      localISPlayerVideoView1 = null;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 104, localISPlayerVideoView1);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(true);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(true);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, null);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplication.getContext(), paramString, 0L);
  }
  
  public void b()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if ((localISuperPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      a((int)localISuperPlayer.getCurrentPositionMs(), null);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCaptureImageFailed id:");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(" errCode:");
    paramISuperPlayer.append(paramInt2);
    QLog.e("PlayerCaptureProxy", 1, paramISuperPlayer.toString());
    paramInt2 = 0;
    while (paramInt2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt2) == paramInt1)
      {
        paramISuperPlayer = (CaptureTask.OnCaptureCallback)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
        if (paramISuperPlayer != null) {
          paramISuperPlayer.a();
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      paramISuperPlayer = new StringBuilder();
      paramISuperPlayer.append("onCaptureImageSucceed id:");
      paramISuperPlayer.append(paramInt1);
      paramISuperPlayer.append(" bitmap:");
      paramISuperPlayer.append(paramBitmap);
      paramISuperPlayer.append(" callbackSparseArray:");
      paramISuperPlayer.append(this.jdField_a_of_type_AndroidUtilSparseArray);
      QLog.d("PlayerCaptureProxy", 2, paramISuperPlayer.toString());
    }
    paramInt2 = 0;
    while (paramInt2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt2) == paramInt1)
      {
        paramISuperPlayer = (CaptureTask.OnCaptureCallback)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
        CaptureTask localCaptureTask = (CaptureTask)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt1);
        if (paramISuperPlayer != null) {
          paramISuperPlayer.a(paramBitmap, localCaptureTask);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("PlayerCaptureProxy onError: module = ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(", errorType = ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(", errorCode = ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(", extraInfo = ");
    paramISuperPlayer.append(paramString);
    QLog.e("PlayerCaptureProxy", 1, paramISuperPlayer.toString());
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    ISuperPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener;
    if (localOnSeekCompleteListener != null) {
      localOnSeekCompleteListener.onSeekComplete(paramISuperPlayer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    ThreadManager.c(new PlayerCaptureProxy.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PlayerCaptureProxy
 * JD-Core Version:    0.7.0.1
 */