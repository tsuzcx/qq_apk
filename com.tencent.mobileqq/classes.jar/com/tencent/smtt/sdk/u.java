package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class u
  extends FrameLayout
  implements MediaPlayer.OnErrorListener
{
  private Object a;
  private w b;
  private VideoView c;
  private Context d = null;
  private String e;
  
  public u(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.d = paramContext;
  }
  
  private void b(Bundle paramBundle, Object paramObject)
  {
    a();
    boolean bool;
    if (b())
    {
      paramBundle.putInt("callMode", paramBundle.getInt("callMode"));
      bool = this.b.a(this.a, paramBundle, this, paramObject);
    }
    else
    {
      bool = false;
    }
    if (!bool)
    {
      paramObject = this.c;
      if (paramObject != null) {
        paramObject.stopPlayback();
      }
      if (this.c == null) {
        this.c = new VideoView(getContext());
      }
      this.e = paramBundle.getString("videoUrl");
      this.c.setVideoURI(Uri.parse(this.e));
      this.c.setOnErrorListener(this);
      paramBundle = new Intent("com.tencent.smtt.tbs.video.PLAY");
      paramBundle.addFlags(268435456);
      paramObject = getContext().getApplicationContext();
      paramBundle.setPackage(paramObject.getPackageName());
      paramObject.startActivity(paramBundle);
    }
  }
  
  void a()
  {
    setBackgroundColor(-16777216);
    if (this.b == null)
    {
      Object localObject2 = f.a(true);
      Context localContext = getContext().getApplicationContext();
      localObject1 = null;
      ((f)localObject2).a(localContext, false, false, null);
      localObject2 = f.a(true).a();
      if (localObject2 != null) {
        localObject1 = ((v)localObject2).b();
      }
      if ((localObject1 != null) && (QbSdk.canLoadVideo(getContext()))) {
        this.b = new w((DexLoader)localObject1);
      }
    }
    Object localObject1 = this.b;
    if ((localObject1 != null) && (this.a == null)) {
      this.a = ((w)localObject1).a(getContext().getApplicationContext());
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (b()) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((VideoView)localObject).getParent() == null)
      {
        Window localWindow = paramActivity.getWindow();
        localObject = (FrameLayout)localWindow.getDecorView();
        localWindow.addFlags(1024);
        localWindow.addFlags(128);
        ((FrameLayout)localObject).setBackgroundColor(-16777216);
        paramActivity = new MediaController(paramActivity);
        paramActivity.setMediaPlayer(this.c);
        this.c.setMediaController(paramActivity);
        paramActivity = new FrameLayout.LayoutParams(-1, -1);
        paramActivity.gravity = 17;
        ((FrameLayout)localObject).addView(this.c, paramActivity);
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.c.start();
      }
    }
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    VideoView localVideoView;
    if ((paramInt == 3) && (!b()))
    {
      localVideoView = this.c;
      if (localVideoView != null) {
        localVideoView.pause();
      }
    }
    if (paramInt == 4)
    {
      this.d = null;
      if (!b())
      {
        localVideoView = this.c;
        if (localVideoView != null)
        {
          localVideoView.stopPlayback();
          this.c = null;
        }
      }
    }
    if ((paramInt == 2) && (!b()))
    {
      this.d = paramActivity;
      a(paramActivity);
    }
    if (b()) {
      this.b.a(this.a, paramActivity, paramInt);
    }
  }
  
  void a(Bundle paramBundle, Object paramObject)
  {
    b(paramBundle, paramObject);
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.a != null);
  }
  
  public void c()
  {
    if (b()) {
      this.b.a(this.a);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.d instanceof Activity))
      {
        paramMediaPlayer = (Activity)this.d;
        if (!paramMediaPlayer.isFinishing()) {
          paramMediaPlayer.finish();
        }
      }
      paramMediaPlayer = getContext();
      if (paramMediaPlayer != null)
      {
        Toast.makeText(paramMediaPlayer, "播放失败，请选择其它播放器播放", 1).show();
        paramMediaPlayer = paramMediaPlayer.getApplicationContext();
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.parse(this.e), "video/*");
        paramMediaPlayer.startActivity(localIntent);
      }
      return true;
    }
    catch (Throwable paramMediaPlayer)
    {
      label95:
      break label95;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.u
 * JD-Core Version:    0.7.0.1
 */