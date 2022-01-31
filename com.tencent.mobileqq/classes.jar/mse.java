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

public class mse
  extends mta
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  public Bitmap a;
  public meu a;
  msj a;
  public Bitmap b;
  
  public mse(mrt parammrt)
  {
    super(parammrt);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      return;
    }
    paramVideoAppInterface = mww.a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide2_for_av_redbag", false);
    paramVideoAppInterface.commit();
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(14) == 1) {
      return true;
    }
    return mww.a(paramVideoAppInterface).getBoolean("qav_UserGuide2_for_av_redbag", true);
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131367378);
    if (localRelativeLayout != null) {
      paramAVActivity = localRelativeLayout;
    }
    for (;;)
    {
      return paramAVActivity;
      localRelativeLayout = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559623, (RelativeLayout)paramAVActivity.findViewById(2131372566)).findViewById(2131367378);
      a(localRelativeLayout);
      b();
      localRelativeLayout.findViewById(2131367379).setOnClickListener(new msf(this));
      Object localObject = localRelativeLayout.findViewById(2131367376);
      if (this.b == null) {
        this.b = msp.a("qav_redpacket_result_close.png", true);
      }
      if (this.b != null) {
        ((View)localObject).setBackgroundDrawable(mwj.a(paramAVActivity.getResources(), this.b, 2131165958));
      }
      ((View)localObject).setOnClickListener(new msg(this));
      String str = msp.b();
      if (bdhb.b(str))
      {
        localObject = (VideoView)localRelativeLayout.findViewById(2131367381);
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
    if (this.jdField_a_of_type_Meu != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Meu);
      this.jdField_a_of_type_Meu = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new msh(this));
  }
  
  public boolean a(msj parammsj)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    this.jdField_a_of_type_Msj = parammsj;
    a(localAVActivity).setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mso.j();
    return true;
  }
  
  boolean a(boolean paramBoolean, int paramInt)
  {
    a();
    Object localObject = a();
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)localObject).findViewById(2131367378);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localObject = (RelativeLayout)((Activity)localObject).findViewById(2131372566);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          VideoView localVideoView = (VideoView)localRelativeLayout.findViewById(2131367381);
          if (localVideoView != null) {
            localVideoView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
          }
        }
        ((RelativeLayout)localObject).post(new GuideTip2.5(this, (RelativeLayout)localObject, localRelativeLayout));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Msj != null)
      {
        this.jdField_a_of_type_Msj.a(paramBoolean);
        this.jdField_a_of_type_Msj = null;
      }
      QLog.w(this.i, 1, "closeUI, bSend[" + paramBoolean + "], closeType[" + paramInt + "]");
      mso.b(paramBoolean, paramInt);
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Meu != null) {
      return;
    }
    this.jdField_a_of_type_Meu = new msi(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
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
        paramMediaPlayer = (VideoView)paramMediaPlayer.findViewById(2131367381);
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
      localObject = (VideoView)((AVActivity)localObject).findViewById(2131367381);
      if (localObject != null)
      {
        ((VideoView)localObject).start();
        paramMediaPlayer.setLooping(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mse
 * JD-Core Version:    0.7.0.1
 */