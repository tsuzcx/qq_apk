import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.GuideTip2.5;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mpk
  extends mqg
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  public Bitmap a;
  public mcf a;
  mpp a;
  public Bitmap b;
  
  public mpk(moz parammoz)
  {
    super(parammoz);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      return;
    }
    paramVideoAppInterface = muc.a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide2_for_av_redbag", false);
    paramVideoAppInterface.commit();
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(14) == 1) {
      return true;
    }
    return muc.a(paramVideoAppInterface).getBoolean("qav_UserGuide2_for_av_redbag", true);
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131367238);
    if (localRelativeLayout != null) {
      paramAVActivity = localRelativeLayout;
    }
    for (;;)
    {
      return paramAVActivity;
      localRelativeLayout = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559572, (RelativeLayout)paramAVActivity.findViewById(2131372187)).findViewById(2131367238);
      a(localRelativeLayout);
      b();
      localRelativeLayout.findViewById(2131367239).setOnClickListener(new mpl(this));
      Object localObject = localRelativeLayout.findViewById(2131367236);
      if (this.b == null) {
        this.b = mpv.a("qav_redpacket_result_close.png", true);
      }
      if (this.b != null) {
        ((View)localObject).setBackgroundDrawable(mtp.a(paramAVActivity.getResources(), this.b, 2131165919));
      }
      ((View)localObject).setOnClickListener(new mpm(this));
      String str = mpv.b();
      if (bbdx.b(str))
      {
        localObject = (VideoView)localRelativeLayout.findViewById(2131367241);
        ((VideoView)localObject).setVideoPath(str);
        ((VideoView)localObject).setZOrderOnTop(true);
        ((VideoView)localObject).setOnPreparedListener(this);
        ((VideoView)localObject).setOnErrorListener(this);
        ((VideoView)localObject).setZOrderMediaOverlay(true);
        if (Build.VERSION.SDK_INT >= 17) {
          ((VideoView)localObject).setOnInfoListener(this);
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          paramAVActivity = new MediaMetadataRetriever();
        }
        try
        {
          paramAVActivity.setDataSource(str);
          this.jdField_a_of_type_AndroidGraphicsBitmap = paramAVActivity.getFrameAtTime(0L);
          paramAVActivity.release();
          paramAVActivity = localRelativeLayout;
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
            return localRelativeLayout;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(this.i, 1, "initDialog, Exception", localException);
          }
        }
      }
    }
    QLog.w(this.i, 1, "initDialog, no exist, path[" + localException + "]");
    return localRelativeLayout;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mcf != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mcf);
      this.jdField_a_of_type_Mcf = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new mpn(this));
  }
  
  public boolean a(mpp parammpp)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    this.jdField_a_of_type_Mpp = parammpp;
    a(localAVActivity).setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mpu.j();
    return true;
  }
  
  boolean a(boolean paramBoolean, int paramInt)
  {
    a();
    Object localObject = a();
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)localObject).findViewById(2131367238);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localObject = (RelativeLayout)((Activity)localObject).findViewById(2131372187);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          VideoView localVideoView = (VideoView)localRelativeLayout.findViewById(2131367241);
          if (localVideoView != null) {
            localVideoView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
          }
        }
        ((RelativeLayout)localObject).post(new GuideTip2.5(this, (RelativeLayout)localObject, localRelativeLayout));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Mpp != null)
      {
        this.jdField_a_of_type_Mpp.a(paramBoolean);
        this.jdField_a_of_type_Mpp = null;
      }
      QLog.w(this.i, 1, "closeUI, bSend[" + paramBoolean + "], closeType[" + paramInt + "]");
      mpu.b(paramBoolean, paramInt);
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Mcf != null) {
      return;
    }
    this.jdField_a_of_type_Mcf = new mpo(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mcf);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.w(this.i, 1, "WL_DEBUG onError what = " + paramInt1 + ", extra = " + paramInt2);
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      paramMediaPlayer = a();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer = (VideoView)paramMediaPlayer.findViewById(2131367241);
        if (paramMediaPlayer != null) {
          paramMediaPlayer.setBackgroundDrawable(null);
        }
      }
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.w(this.i, 1, "WL_DEBUG onPrepared");
    Object localObject = a();
    if (localObject != null)
    {
      localObject = (VideoView)((AVActivity)localObject).findViewById(2131367241);
      if (localObject != null)
      {
        ((VideoView)localObject).start();
        paramMediaPlayer.setLooping(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpk
 * JD-Core Version:    0.7.0.1
 */