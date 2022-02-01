package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.surfaceviewaction.Point;
import com.tencent.mobileqq.vpng.view.VPNGImageView;

public class VideoSprite
  extends Node
{
  protected VPNGImageView s;
  
  /* Error */
  public VideoSprite(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 13	com/tencent/mobileqq/surfaceviewaction/nv/Node:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 17	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:t	Lcom/tencent/mobileqq/surfaceviewaction/nv/SpriteNativeView;
    //   9: aload_0
    //   10: new 19	com/tencent/mobileqq/vpng/view/VPNGImageView
    //   13: dup
    //   14: aload_1
    //   15: invokevirtual 25	com/tencent/mobileqq/surfaceviewaction/nv/SpriteNativeView:getContext	()Landroid/content/Context;
    //   18: invokespecial 28	com/tencent/mobileqq/vpng/view/VPNGImageView:<init>	(Landroid/content/Context;)V
    //   21: putfield 30	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:s	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   24: new 32	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 33	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 37	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: bipush 18
    //   40: invokevirtual 41	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   43: astore_2
    //   44: aload_1
    //   45: bipush 19
    //   47: invokevirtual 41	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_0
    //   52: aload_2
    //   53: invokestatic 47	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   56: iconst_2
    //   57: idiv
    //   58: i2f
    //   59: putfield 51	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   62: aload_0
    //   63: aload_3
    //   64: invokestatic 47	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: i2f
    //   68: putfield 54	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:c	F
    //   71: new 56	android/widget/FrameLayout$LayoutParams
    //   74: dup
    //   75: aload_0
    //   76: getfield 51	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   79: f2i
    //   80: aload_0
    //   81: getfield 54	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:c	F
    //   84: f2i
    //   85: invokespecial 59	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 30	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:s	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   93: aload_2
    //   94: invokevirtual 63	com/tencent/mobileqq/vpng/view/VPNGImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   97: aload_0
    //   98: getfield 30	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:s	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   101: aload_0
    //   102: getfield 51	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   105: fconst_2
    //   106: fdiv
    //   107: invokevirtual 67	com/tencent/mobileqq/vpng/view/VPNGImageView:setPivotX	(F)V
    //   110: aload_0
    //   111: getfield 30	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:s	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   114: aload_0
    //   115: getfield 54	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:c	F
    //   118: fconst_2
    //   119: fdiv
    //   120: invokevirtual 70	com/tencent/mobileqq/vpng/view/VPNGImageView:setPivotY	(F)V
    //   123: goto +39 -> 162
    //   126: astore_2
    //   127: goto +40 -> 167
    //   130: astore_2
    //   131: new 72	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: ldc 75
    //   142: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: aload_2
    //   148: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 84
    //   154: iconst_2
    //   155: aload_3
    //   156: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_1
    //   163: invokevirtual 97	android/media/MediaMetadataRetriever:release	()V
    //   166: return
    //   167: aload_1
    //   168: invokevirtual 97	android/media/MediaMetadataRetriever:release	()V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	VideoSprite
    //   0	173	1	paramSpriteNativeView	SpriteNativeView
    //   0	173	2	paramString	String
    //   50	106	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	123	126	finally
    //   131	162	126	finally
    //   32	123	130	java/lang/Exception
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.s.setVideo(paramString, paramBoolean);
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    super.g();
    this.s.onPause();
  }
  
  public void h()
  {
    super.h();
    this.s.onResume();
  }
  
  public boolean k()
  {
    boolean bool = super.k();
    a(this.u);
    float f1 = this.u.a;
    float f2 = d();
    float f3 = this.b / 2.0F;
    float f4 = this.r;
    float f5 = this.u.b;
    float f6 = d();
    float f7 = this.c / 2.0F;
    this.s.setX(f1 * f2 - f3);
    this.s.setY(f4 - f5 * f6 - f7);
    this.s.setScaleX(this.f * d());
    this.s.setScaleY(this.f * d());
    this.s.setRotation(this.h);
    this.s.setAlpha(this.i * (e() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void l()
  {
    this.t.addView(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.VideoSprite
 * JD-Core Version:    0.7.0.1
 */