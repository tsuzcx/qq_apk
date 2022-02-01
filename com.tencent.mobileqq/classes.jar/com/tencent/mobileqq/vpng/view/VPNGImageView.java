package com.tencent.mobileqq.vpng.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vpng.glrenderer.Renderable;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRendererManager;
import com.tencent.mobileqq.vpng.util.VPNGUtil;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;

public class VPNGImageView
  extends FrameLayout
  implements TextureView.SurfaceTextureListener, Renderable
{
  protected int mAlign = 1;
  protected LiveRoomGiftCallback mCallback;
  protected int mHeight;
  protected boolean mIsLoop;
  protected ImageView mPreImageView;
  protected TextureView mTextureView;
  protected VPNGRenderer mVPNGRenderer;
  protected String mVideoPath;
  protected int mWidth;
  protected boolean playOnSubThread = false;
  
  public VPNGImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VPNGImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mTextureView = new TextureView(getContext());
    this.mPreImageView = new ImageView(getContext());
    addView(this.mTextureView, -1, -1);
    addView(this.mPreImageView, -1, -1);
  }
  
  public int getRenderHeight()
  {
    return this.mHeight;
  }
  
  public int getRenderWidth()
  {
    return this.mWidth;
  }
  
  public VPNGRenderer getVPNGRenderer()
  {
    return this.mVPNGRenderer;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mVPNGRenderer != null)
    {
      VPNGRendererManager.a().a(this.mVPNGRenderer);
      this.mVPNGRenderer = null;
    }
  }
  
  public void onDrawBegin()
  {
    post(new VPNGImageView.2(this));
  }
  
  public void onPause()
  {
    VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
    if (localVPNGRenderer != null) {
      localVPNGRenderer.i();
    }
  }
  
  public void onRelease()
  {
    VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
    if (localVPNGRenderer != null) {
      localVPNGRenderer.c();
    }
  }
  
  public void onResume()
  {
    VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
    if (localVPNGRenderer != null) {
      localVPNGRenderer.j();
    }
  }
  
  public void onSetRenderer(VPNGRenderer paramVPNGRenderer)
  {
    this.mVPNGRenderer = paramVPNGRenderer;
    if ((isActivated()) && (getVisibility() == 0))
    {
      this.mVPNGRenderer.a();
      playRender();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mVPNGRenderer == null)
    {
      this.mVPNGRenderer = VPNGRendererManager.a().a(this, this.mWidth, this.mHeight);
      localVPNGRenderer = this.mVPNGRenderer;
      if (localVPNGRenderer != null)
      {
        localVPNGRenderer.a(this.mVideoPath, this.mAlign, this.mCallback);
        this.mVPNGRenderer.b(this.mIsLoop);
      }
    }
    VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
    if (localVPNGRenderer != null)
    {
      localVPNGRenderer.a(paramInt1, paramInt2);
      this.mVPNGRenderer.a(paramSurfaceTexture);
      playRender();
    }
    this.mTextureView.setAlpha(0.0F);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.mVPNGRenderer;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
    paramSurfaceTexture = this.mCallback;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.onCall(9, "");
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = this.mVPNGRenderer;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  protected void playRender()
  {
    if (!this.playOnSubThread)
    {
      VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
      if (localVPNGRenderer != null) {
        localVPNGRenderer.h();
      }
    }
    else
    {
      ThreadManager.excute(new VPNGImageView.1(this), 128, null, true);
    }
  }
  
  public void setImage(String paramString, BitmapFactory.Options paramOptions)
  {
    paramOptions = BitmapFactory.decodeFile(paramString, paramOptions).copy(Bitmap.Config.ARGB_8888, true);
    this.mWidth = paramOptions.getWidth();
    this.mHeight = paramOptions.getHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".vpng");
    localObject = ((StringBuilder)localObject).toString();
    if ((!new File((String)localObject).exists()) && (VPNGUtil.a(paramString, (String)localObject))) {
      setVideo((String)localObject, true);
    }
    this.mPreImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mPreImageView.setImageBitmap(paramOptions);
    this.mPreImageView.setVisibility(0);
  }
  
  public void setPlayOnSubThread(boolean paramBoolean)
  {
    this.playOnSubThread = paramBoolean;
  }
  
  public void setVideo(String paramString, boolean paramBoolean)
  {
    setVideo(paramString, paramBoolean, 0, null);
  }
  
  public void setVideo(String paramString, boolean paramBoolean, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    int i;
    if (this.mVPNGRenderer != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mVPNGRenderer == null) {
      this.mVPNGRenderer = VPNGRendererManager.a().a(this, this.mWidth, this.mHeight);
    }
    VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
    if (localVPNGRenderer != null)
    {
      localVPNGRenderer.a(paramString, paramInt, paramLiveRoomGiftCallback);
      this.mVPNGRenderer.b(paramBoolean);
      if (i != 0)
      {
        this.mVPNGRenderer.a(true);
        playRender();
      }
    }
    this.mVideoPath = paramString;
    this.mIsLoop = paramBoolean;
    this.mAlign = paramInt;
    this.mCallback = paramLiveRoomGiftCallback;
    this.mTextureView.setOpaque(false);
    this.mTextureView.setSurfaceTextureListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.view.VPNGImageView
 * JD-Core Version:    0.7.0.1
 */