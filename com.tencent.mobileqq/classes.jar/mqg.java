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

public class mqg
  extends mrc
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  public Bitmap a;
  public mct a;
  mql a;
  public Bitmap b;
  
  public mqg(mpv parammpv)
  {
    super(parammpv);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      return;
    }
    paramVideoAppInterface = mvd.a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide2_for_av_redbag", false);
    paramVideoAppInterface.commit();
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(14) == 1) {
      return true;
    }
    return mvd.a(paramVideoAppInterface).getBoolean("qav_UserGuide2_for_av_redbag", true);
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131367754);
    if (localRelativeLayout != null) {
      paramAVActivity = localRelativeLayout;
    }
    for (;;)
    {
      return paramAVActivity;
      localRelativeLayout = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559766, (RelativeLayout)paramAVActivity.findViewById(2131373305)).findViewById(2131367754);
      a(localRelativeLayout);
      b();
      localRelativeLayout.findViewById(2131367755).setOnClickListener(new mqh(this));
      Object localObject = localRelativeLayout.findViewById(2131367752);
      if (this.b == null) {
        this.b = mqr.a("qav_redpacket_result_close.png", true);
      }
      if (this.b != null) {
        ((View)localObject).setBackgroundDrawable(muq.a(paramAVActivity.getResources(), this.b, 2131166014));
      }
      ((View)localObject).setOnClickListener(new mqi(this));
      String str = mqr.b();
      if (bhmi.b(str))
      {
        localObject = (VideoView)localRelativeLayout.findViewById(2131367757);
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
    if (this.jdField_a_of_type_Mct != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mct);
      this.jdField_a_of_type_Mct = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new mqj(this));
  }
  
  public boolean a(mql parammql)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    this.jdField_a_of_type_Mql = parammql;
    a(localAVActivity).setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mqq.j();
    return true;
  }
  
  boolean a(boolean paramBoolean, int paramInt)
  {
    a();
    Object localObject = a();
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)localObject).findViewById(2131367754);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localObject = (RelativeLayout)((Activity)localObject).findViewById(2131373305);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          VideoView localVideoView = (VideoView)localRelativeLayout.findViewById(2131367757);
          if (localVideoView != null) {
            localVideoView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
          }
        }
        ((RelativeLayout)localObject).post(new GuideTip2.5(this, (RelativeLayout)localObject, localRelativeLayout));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Mql != null)
      {
        this.jdField_a_of_type_Mql.a(paramBoolean);
        this.jdField_a_of_type_Mql = null;
      }
      QLog.w(this.i, 1, "closeUI, bSend[" + paramBoolean + "], closeType[" + paramInt + "]");
      mqq.b(paramBoolean, paramInt);
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Mct != null) {
      return;
    }
    this.jdField_a_of_type_Mct = new mqk(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mct);
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
        paramMediaPlayer = (VideoView)paramMediaPlayer.findViewById(2131367757);
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
      localObject = (VideoView)((AVActivity)localObject).findViewById(2131367757);
      if (localObject != null)
      {
        ((VideoView)localObject).start();
        paramMediaPlayer.setLooping(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqg
 * JD-Core Version:    0.7.0.1
 */