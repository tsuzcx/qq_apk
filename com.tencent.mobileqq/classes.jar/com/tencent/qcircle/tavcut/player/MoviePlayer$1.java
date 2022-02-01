package com.tencent.qcircle.tavcut.player;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.tav.player.Player;

class MoviePlayer$1
  implements TextureView.SurfaceTextureListener
{
  MoviePlayer$1(MoviePlayer paramMoviePlayer) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    MoviePlayer.access$002(this.this$0, paramInt1);
    MoviePlayer.access$102(this.this$0, paramInt2);
    MoviePlayer.access$202(this.this$0, new Surface(paramSurfaceTexture));
    if (!MoviePlayer.access$300(this.this$0))
    {
      paramSurfaceTexture = this.this$0;
      paramSurfaceTexture.updateComposition(MoviePlayer.access$400(paramSurfaceTexture), MoviePlayer.access$500(this.this$0), MoviePlayer.access$600(this.this$0));
    }
    MoviePlayer.access$702(this.this$0, true);
    MoviePlayer.access$800(this.this$0);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if ((MoviePlayer.access$900(this.this$0) != null) && (!MoviePlayer.access$900(this.this$0).isReleased()))
    {
      MoviePlayer localMoviePlayer = this.this$0;
      MoviePlayer.access$502(localMoviePlayer, MoviePlayer.access$900(localMoviePlayer).position());
      MoviePlayer.access$900(this.this$0).release();
    }
    paramSurfaceTexture.release();
    if (MoviePlayer.access$200(this.this$0) != null)
    {
      MoviePlayer.access$200(this.this$0).release();
      MoviePlayer.access$202(this.this$0, null);
    }
    MoviePlayer.access$702(this.this$0, false);
    MoviePlayer.access$1000(this.this$0);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (MoviePlayer.access$900(this.this$0) != null) {
      MoviePlayer.access$900(this.this$0).updateViewport(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    Log.d("lingeng_cover", "onSurfaceTextureUpdated: ");
    MoviePlayer.access$1100(this.this$0, paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.player.MoviePlayer.1
 * JD-Core Version:    0.7.0.1
 */