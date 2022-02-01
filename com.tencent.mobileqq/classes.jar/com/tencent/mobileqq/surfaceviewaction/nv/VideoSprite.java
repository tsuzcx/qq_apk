package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.surfaceviewaction.Point;
import com.tencent.mobileqq.vpng.view.VPNGImageView;

public class VideoSprite
  extends Node
{
  protected VPNGImageView a;
  
  /* Error */
  public VideoSprite(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 13	com/tencent/mobileqq/surfaceviewaction/nv/Node:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 16	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView	Lcom/tencent/mobileqq/surfaceviewaction/nv/SpriteNativeView;
    //   9: aload_0
    //   10: new 18	com/tencent/mobileqq/vpng/view/VPNGImageView
    //   13: dup
    //   14: aload_1
    //   15: invokevirtual 24	com/tencent/mobileqq/surfaceviewaction/nv/SpriteNativeView:getContext	()Landroid/content/Context;
    //   18: invokespecial 27	com/tencent/mobileqq/vpng/view/VPNGImageView:<init>	(Landroid/content/Context;)V
    //   21: putfield 29	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   24: new 31	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 32	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 36	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: bipush 18
    //   40: invokevirtual 40	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   43: astore_2
    //   44: aload_1
    //   45: bipush 19
    //   47: invokevirtual 40	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_0
    //   52: aload_2
    //   53: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   56: iconst_2
    //   57: idiv
    //   58: i2f
    //   59: putfield 49	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_Float	F
    //   62: aload_0
    //   63: aload_3
    //   64: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: i2f
    //   68: putfield 52	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   71: new 54	android/widget/FrameLayout$LayoutParams
    //   74: dup
    //   75: aload_0
    //   76: getfield 49	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_Float	F
    //   79: f2i
    //   80: aload_0
    //   81: getfield 52	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   84: f2i
    //   85: invokespecial 57	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 29	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   93: aload_2
    //   94: invokevirtual 61	com/tencent/mobileqq/vpng/view/VPNGImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   97: aload_0
    //   98: getfield 29	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   101: aload_0
    //   102: getfield 49	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_Float	F
    //   105: fconst_2
    //   106: fdiv
    //   107: invokevirtual 65	com/tencent/mobileqq/vpng/view/VPNGImageView:setPivotX	(F)V
    //   110: aload_0
    //   111: getfield 29	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView	Lcom/tencent/mobileqq/vpng/view/VPNGImageView;
    //   114: aload_0
    //   115: getfield 52	com/tencent/mobileqq/surfaceviewaction/nv/VideoSprite:b	F
    //   118: fconst_2
    //   119: fdiv
    //   120: invokevirtual 68	com/tencent/mobileqq/vpng/view/VPNGImageView:setPivotY	(F)V
    //   123: goto +39 -> 162
    //   126: astore_2
    //   127: goto +40 -> 167
    //   130: astore_2
    //   131: new 70	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: ldc 73
    //   142: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: aload_2
    //   148: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 82
    //   154: iconst_2
    //   155: aload_3
    //   156: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_1
    //   163: invokevirtual 95	android/media/MediaMetadataRetriever:release	()V
    //   166: return
    //   167: aload_1
    //   168: invokevirtual 95	android/media/MediaMetadataRetriever:release	()V
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
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, paramBoolean);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionPoint);
    float f1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionPoint.jdField_a_of_type_Float;
    float f2 = b();
    float f3 = this.jdField_a_of_type_Float / 2.0F;
    float f4 = this.f;
    float f5 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionPoint.b;
    float f6 = b();
    float f7 = this.b / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setX(f1 * f2 - f3);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setY(f4 - f5 * f6 - f7);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleX(this.e * b());
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleY(this.e * b());
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setRotation(this.g);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setAlpha(this.jdField_a_of_type_Int * (b() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.addView(this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.VideoSprite
 * JD-Core Version:    0.7.0.1
 */