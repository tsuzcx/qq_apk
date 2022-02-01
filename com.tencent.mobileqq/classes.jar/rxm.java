import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2;
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

public class rxm
  implements ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, rxl
{
  private SparseArray<rxj> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ISuperPlayer.OnSeekCompleteListener jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Set<rxg> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private SparseArray<rxh> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private boolean jdField_b_of_type_Boolean;
  
  public rxm()
  {
    d();
  }
  
  public static void d()
  {
    if (!bapt.a()) {
      bapt.a(BaseApplication.getContext(), new rxn());
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
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
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    ISPlayerVideoView localISPlayerVideoView2;
    if (paramViewGroup != null)
    {
      localISPlayerVideoView2 = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
      localISPlayerVideoView1 = localISPlayerVideoView2;
      if ((localISPlayerVideoView2 instanceof View)) {
        paramViewGroup.addView((View)localISPlayerVideoView2);
      }
    }
    for (ISPlayerVideoView localISPlayerVideoView1 = localISPlayerVideoView2;; localISPlayerVideoView1 = null)
    {
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
      return;
    }
  }
  
  public void a(rxg paramrxg)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramrxg);
  }
  
  public void a(rxh paramrxh, rxj paramrxj)
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.captureImageInTime(paramrxh.c, paramrxh.d, paramrxh.e, 0, 0, 300);
      paramrxh.a = i;
      this.jdField_b_of_type_AndroidUtilSparseArray.put(i, paramrxh);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramrxj);
      if (QLog.isColorLevel()) {
        QLog.d("PlayerCaptureProxy", 2, "PlayerCaptureProxy try capture captureTask:" + paramrxh);
      }
      return;
    }
    catch (IllegalAccessException paramrxj)
    {
      for (;;)
      {
        paramrxj.printStackTrace();
      }
    }
    finally {}
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      a((int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), null);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("PlayerCaptureProxy", 1, "onCaptureImageFailed id:" + paramInt1 + " errCode:" + paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt2) == paramInt1)
        {
          paramISuperPlayer = (rxj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
          if (paramISuperPlayer != null) {
            paramISuperPlayer.a();
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        }
      }
      else {
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayerCaptureProxy", 2, "onCaptureImageSucceed id:" + paramInt1 + " bitmap:" + paramBitmap + " callbackSparseArray:" + this.jdField_a_of_type_AndroidUtilSparseArray);
    }
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt2) == paramInt1)
        {
          paramISuperPlayer = (rxj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
          rxh localrxh = (rxh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
          this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt1);
          if (paramISuperPlayer != null) {
            paramISuperPlayer.a(paramBitmap, localrxh);
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        }
      }
      else {
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("PlayerCaptureProxy", 1, "PlayerCaptureProxy onError: module = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", extraInfo = " + paramString);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener.onSeekComplete(paramISuperPlayer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    bjum.c(new PlayerCaptureProxy.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxm
 * JD-Core Version:    0.7.0.1
 */