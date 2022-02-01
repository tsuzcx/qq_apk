package dov.com.qq.im.cropvideo;

import Override;
import amtj;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bnab;
import bnac;
import bnad;
import bnae;
import bnaf;
import bnah;
import bnak;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.IOException;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import lpy;

public class CropVideoActivity
  extends BaseActivity
  implements SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, GLSurfaceView.Renderer, View.OnClickListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  public Handler a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private bnak jdField_a_of_type_Bnak;
  private RegionView jdField_a_of_type_DovComQqImCropvideoRegionView;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString;
  private lpy jdField_a_of_type_Lpy;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public CropVideoActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new bnaf(this);
    this.jdField_a_of_type_JavaLangRunnable = new CropVideoActivity.6(this);
  }
  
  private int a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    label762:
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        str1 = localMediaMetadataRetriever.extractMetadata(18);
        str2 = localMediaMetadataRetriever.extractMetadata(19);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        localMediaMetadataRetriever.release();
        if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString))) {
          break label762;
        }
        paramString = "0";
        if ((str1 == null) || (str2 == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "extractMetadata width: " + str1 + ", height: " + str2);
          }
          return -2;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CropVideoActivity", 2, "getCropRegion setDataSource", paramString);
        }
        return -1;
      }
      for (;;)
      {
        int k;
        int m;
        int i2;
        int n;
        int i1;
        int i3;
        int i4;
        try
        {
          k = Integer.parseInt(str1);
          m = Integer.parseInt(str2);
          i2 = Integer.parseInt(paramString);
          paramString = this.jdField_a_of_type_Bnak.a();
          n = this.jdField_a_of_type_Bnak.a();
          i1 = this.jdField_a_of_type_Bnak.b();
          i3 = this.jdField_a_of_type_DovComQqImCropvideoRegionView.c();
          i4 = this.jdField_a_of_type_DovComQqImCropvideoRegionView.d();
          if (Build.VERSION.SDK_INT >= 21)
          {
            this.jdField_c_of_type_Int = paramString.left;
            this.d = paramString.top;
            this.e = n;
            this.f = i1;
            this.g = i3;
            this.h = i4;
            if (i2 != 90)
            {
              i1 = m;
              n = k;
              if (i2 != 270) {}
            }
            else
            {
              n = m;
              i1 = k;
            }
            this.i = i2;
            if (QLog.isColorLevel()) {
              QLog.d("CropVideoActivity", 2, "startCropVideo width: " + n + ", height: " + i1 + ", crop_x: " + this.jdField_c_of_type_Int + ", crop_y: " + this.d + ", crop_width: " + this.e + ", crop_height: " + this.f + ", target_width: " + this.g + ", target_height: " + this.h);
            }
            if ((this.jdField_c_of_type_Int >= 0) && (this.jdField_c_of_type_Int <= n) && (this.d >= 0) && (this.d <= i1) && (this.e > 0) && (this.e <= n) && (this.f > 0) && (this.f <= i1) && (this.jdField_c_of_type_Int + this.e <= n) && (this.d + this.f <= i1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("CropVideoActivity", 2, "startCropVideo crop region illegal");
            }
            return -4;
          }
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "getCropRegion parseInt", paramString);
          }
          return -3;
        }
        switch (i2)
        {
        default: 
          this.jdField_c_of_type_Int = paramString.left;
          this.d = paramString.top;
          this.e = n;
          this.f = i1;
          this.g = i3;
          this.h = i4;
          i1 = m;
          n = k;
          break;
        case 90: 
          this.jdField_c_of_type_Int = paramString.top;
          this.d = paramString.right;
          this.e = i1;
          this.f = n;
          this.g = i4;
          this.h = i3;
          i1 = m;
          n = k;
          break;
        case 180: 
          this.jdField_c_of_type_Int = paramString.right;
          this.d = paramString.bottom;
          this.e = n;
          this.f = i1;
          this.g = i3;
          this.h = i4;
          i1 = m;
          n = k;
          break;
        case 270: 
          this.jdField_c_of_type_Int = paramString.bottom;
          this.d = paramString.left;
          this.e = i1;
          this.f = n;
          this.g = i4;
          this.h = i3;
          i1 = m;
          n = k;
        }
      }
      return 0;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    FFmpeg localFFmpeg = FFmpeg.getInstance(getApplicationContext());
    if (localFFmpeg.isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "ffmpeg is running!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vf");
    localArrayList.add("crop=" + paramInt3 + ":" + paramInt4 + ":" + paramInt1 + ":" + paramInt2);
    localArrayList.add("-preset");
    localArrayList.add("ultrafast");
    localArrayList.add("-tune");
    localArrayList.add("zerolatency");
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-acodec");
    localArrayList.add("aac");
    localArrayList.add(paramString2);
    try
    {
      localFFmpeg.execute((String[])localArrayList.toArray(new String[0]), new bnah(this));
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "ffmpeg Exception", paramString1);
      }
      paramString1.printStackTrace();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131755826);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559574);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372546)).setText(amtj.a(2131701767));
    if ((!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CropVideoActivity", 2, "cancelProgressDialog", localException);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.setContentView(2131560839);
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("CropVideoActivity", 2, "doOnCreate");
    }
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusDrawable(null);
      k = ImmersiveUtils.getStatusBarHeight(this);
      paramBundle = findViewById(2131364085);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      localLayoutParams.topMargin = (k + localLayoutParams.topMargin);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle = getIntent();
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("video_start_time", 0L);
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("video_end_time", 9223372036854775807L);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("video_local_path");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("PhotoConst.TARGET_PATH");
    int k = paramBundle.getIntExtra("PhotoConst.CLIP_WIDTH", 750);
    int m = paramBundle.getIntExtra("PhotoConst.CLIP_HEIGHT", 520);
    int n = paramBundle.getIntExtra("PhotoConst.TARGET_WIDTH", 750);
    int i1 = paramBundle.getIntExtra("PhotoConst.TARGET_HEIGHT", 520);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = ((GLSurfaceView)findViewById(2131367622));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setEGLContextClientVersion(2);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderer(this);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderMode(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373010));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView = ((RegionView)findViewById(2131376222));
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setMaskColor(-2147483648);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setUsedARGB(true);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setMaskShapeType(1);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setTargetWidth(n);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setTargetHeight(i1);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setClipWidth(k);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setClipHeight(m);
    findViewById(2131364175).setOnClickListener(this);
    findViewById(2131365235).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new bnab(this));
    this.jdField_a_of_type_Lpy = new lpy(this, new bnac(this));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this, new bnad(this));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setOnTouchListener(new bnae(this));
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, Uri.parse(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      return true;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("CropVideoActivity", 2, "setDataSource", paramBundle);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    b();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771990, 2130772001);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      continue;
      finish();
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onCompletion");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_Bnak.a(this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Bnak.a(this.jdField_a_of_type_Int);
      return;
    }
    finally {}
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onSurfaceChanged width: " + paramInt1 + ", height: " + paramInt2);
    }
    this.jdField_a_of_type_Bnak.b(paramInt1, paramInt2);
    int n = this.jdField_a_of_type_DovComQqImCropvideoRegionView.a();
    int m = this.jdField_a_of_type_DovComQqImCropvideoRegionView.b();
    int k = (paramInt1 - n) / 2;
    paramInt1 = (n + paramInt1) / 2;
    n = (paramInt2 - m) / 2;
    paramInt2 = (m + paramInt2) / 2;
    this.jdField_a_of_type_Bnak.a(k, n, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onSurfaceCreated");
    }
    if (this.jdField_a_of_type_Bnak == null)
    {
      this.jdField_a_of_type_Bnak = new bnak();
      this.jdField_a_of_type_Bnak.a();
      this.jdField_a_of_type_Bnak.b(4.0F);
      this.jdField_a_of_type_Bnak.a(1.0F);
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      paramGL10 = new int[1];
      GLES20.glGenTextures(1, paramGL10, 0);
      GLES20.glBindTexture(36197, paramGL10[0]);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      this.jdField_a_of_type_Int = paramGL10[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      paramGL10 = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(paramGL10);
      paramGL10.release();
      if (this.jdField_b_of_type_Boolean) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      if (isResume())
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    catch (IOException paramGL10)
    {
      for (;;)
      {
        paramGL10.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("CropVideoActivity", 2, "media player prepare failed", paramGL10);
        }
      }
    }
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onVideoSizeChanged: " + paramInt1 + " " + paramInt2);
    }
    this.jdField_a_of_type_Bnak.a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity
 * JD-Core Version:    0.7.0.1
 */