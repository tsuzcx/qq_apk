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
import bhkx;
import bhky;
import bhla;
import bhlb;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;

public class VPNGImageView
  extends FrameLayout
  implements TextureView.SurfaceTextureListener, bhkx
{
  protected int mAlign = 1;
  protected LiveRoomGiftCallback mCallback;
  protected int mHeight;
  protected boolean mIsLoop;
  protected ImageView mPreImageView;
  protected TextureView mTextureView;
  protected bhky mVPNGRenderer;
  protected String mVideoPath;
  protected int mWidth;
  
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
  
  public bhky getVPNGRenderer()
  {
    return this.mVPNGRenderer;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mVPNGRenderer != null)
    {
      bhla.a().a(this.mVPNGRenderer);
      this.mVPNGRenderer = null;
    }
  }
  
  public void onDrawBegin()
  {
    post(new VPNGImageView.1(this));
  }
  
  public void onPause()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.i();
    }
  }
  
  public void onRelease()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.c();
    }
  }
  
  public void onResume()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.j();
    }
  }
  
  public void onSetRenderer(bhky parambhky)
  {
    this.mVPNGRenderer = parambhky;
    if ((isActivated()) && (getVisibility() == 0))
    {
      this.mVPNGRenderer.a();
      this.mVPNGRenderer.h();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mVPNGRenderer == null)
    {
      this.mVPNGRenderer = bhla.a().a(this, this.mWidth, this.mHeight);
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(this.mVideoPath, this.mAlign, this.mCallback);
        this.mVPNGRenderer.b(this.mIsLoop);
      }
    }
    if (this.mVPNGRenderer != null)
    {
      this.mVPNGRenderer.a(paramInt1, paramInt2);
      this.mVPNGRenderer.a(paramSurfaceTexture);
      this.mVPNGRenderer.h();
    }
    this.mTextureView.setAlpha(0.0F);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mVPNGRenderer.b();
    if (this.mCallback != null) {
      this.mCallback.onCall(9, "");
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mVPNGRenderer.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setImage(String paramString, BitmapFactory.Options paramOptions)
  {
    paramOptions = BitmapFactory.decodeFile(paramString, paramOptions).copy(Bitmap.Config.ARGB_8888, true);
    this.mWidth = paramOptions.getWidth();
    this.mHeight = paramOptions.getHeight();
    String str = paramString + ".vpng";
    if ((!new File(str).exists()) && (bhlb.a(paramString, str))) {
      setVideo(str, true);
    }
    this.mPreImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mPreImageView.setImageBitmap(paramOptions);
    this.mPreImageView.setVisibility(0);
  }
  
  public void setVideo(String paramString, boolean paramBoolean)
  {
    setVideo(paramString, paramBoolean, 0, null);
  }
  
  public void setVideo(String paramString, boolean paramBoolean, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    if (this.mVPNGRenderer != null) {}
    for (int i = 1;; i = 0)
    {
      if (this.mVPNGRenderer == null) {
        this.mVPNGRenderer = bhla.a().a(this, this.mWidth, this.mHeight);
      }
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(paramString, paramInt, paramLiveRoomGiftCallback);
        this.mVPNGRenderer.b(paramBoolean);
        if (i != 0)
        {
          this.mVPNGRenderer.a(true);
          this.mVPNGRenderer.h();
        }
      }
      this.mVideoPath = paramString;
      this.mIsLoop = paramBoolean;
      this.mAlign = paramInt;
      this.mCallback = paramLiveRoomGiftCallback;
      this.mTextureView.setOpaque(false);
      this.mTextureView.setSurfaceTextureListener(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.view.VPNGImageView
 * JD-Core Version:    0.7.0.1
 */