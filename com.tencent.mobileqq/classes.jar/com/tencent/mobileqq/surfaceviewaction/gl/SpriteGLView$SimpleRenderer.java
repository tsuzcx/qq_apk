package com.tencent.mobileqq.surfaceviewaction.gl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class SpriteGLView$SimpleRenderer
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int d;
  private int e;
  private int f = 0;
  
  private SpriteGLView$SimpleRenderer(SpriteGLView paramSpriteGLView) {}
  
  /* Error */
  @android.annotation.SuppressLint({"DefaultLocale"})
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   4: invokestatic 46	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   17: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   20: invokeinterface 55 1 0
    //   25: if_icmpge +31 -> 56
    //   28: aload_0
    //   29: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   32: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   35: iload_2
    //   36: invokeinterface 59 2 0
    //   41: checkcast 61	java/lang/Runnable
    //   44: invokeinterface 64 1 0
    //   49: iload_2
    //   50: iconst_1
    //   51: iadd
    //   52: istore_2
    //   53: goto -41 -> 12
    //   56: aload_0
    //   57: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   60: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   63: invokeinterface 67 1 0
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   74: invokestatic 69	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: iconst_0
    //   81: istore_2
    //   82: iload_2
    //   83: aload_0
    //   84: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   87: invokestatic 71	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   90: invokeinterface 55 1 0
    //   95: if_icmpge +38 -> 133
    //   98: aload_0
    //   99: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   102: invokestatic 71	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   105: iload_2
    //   106: invokeinterface 59 2 0
    //   111: checkcast 61	java/lang/Runnable
    //   114: invokeinterface 64 1 0
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: istore_2
    //   123: goto -41 -> 82
    //   126: astore 4
    //   128: aload_1
    //   129: monitorexit
    //   130: aload 4
    //   132: athrow
    //   133: aload_1
    //   134: monitorexit
    //   135: sipush 16640
    //   138: invokestatic 77	android/opengl/GLES20:glClear	(I)V
    //   141: aload_0
    //   142: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   145: invokestatic 79	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   148: invokeinterface 83 1 0
    //   153: astore_1
    //   154: aload_1
    //   155: arraylength
    //   156: istore_3
    //   157: iconst_0
    //   158: istore_2
    //   159: iload_2
    //   160: iload_3
    //   161: if_icmpge +99 -> 260
    //   164: aload_1
    //   165: iload_2
    //   166: aaload
    //   167: astore 4
    //   169: aload 4
    //   171: instanceof 85
    //   174: ifeq +72 -> 246
    //   177: sipush 3042
    //   180: invokestatic 88	android/opengl/GLES20:glEnable	(I)V
    //   183: iconst_1
    //   184: sipush 771
    //   187: invokestatic 92	android/opengl/GLES20:glBlendFunc	(II)V
    //   190: aload_0
    //   191: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   194: getfield 94	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:jdField_c_of_type_Int	I
    //   197: invokestatic 97	android/opengl/GLES20:glUseProgram	(I)V
    //   200: aload 4
    //   202: checkcast 85	com/tencent/mobileqq/surfaceviewaction/gl/Node
    //   205: aload_0
    //   206: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   209: invokevirtual 100	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
    //   212: aload_0
    //   213: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   216: invokevirtual 103	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
    //   219: aload_0
    //   220: getfield 105	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_Int	I
    //   223: aload_0
    //   224: getfield 106	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_c_of_type_Int	I
    //   227: aload_0
    //   228: getfield 108	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_b_of_type_Int	I
    //   231: aload_0
    //   232: getfield 110	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:d	I
    //   235: aload_0
    //   236: getfield 112	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:e	I
    //   239: aload_0
    //   240: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_c_of_type_ArrayOfFloat	[F
    //   243: invokevirtual 115	com/tencent/mobileqq/surfaceviewaction/gl/Node:c	(IIIIIII[F)V
    //   246: iload_2
    //   247: iconst_1
    //   248: iadd
    //   249: istore_2
    //   250: goto -91 -> 159
    //   253: astore 4
    //   255: aload_1
    //   256: monitorexit
    //   257: aload 4
    //   259: athrow
    //   260: aload_0
    //   261: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   264: getfield 118	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	Z
    //   267: ifeq +137 -> 404
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 32	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:f	I
    //   275: iconst_1
    //   276: iadd
    //   277: putfield 32	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:f	I
    //   280: aload_0
    //   281: getfield 32	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:f	I
    //   284: iconst_5
    //   285: if_icmplt +64 -> 349
    //   288: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   291: aload_0
    //   292: getfield 126	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_Long	J
    //   295: lsub
    //   296: l2i
    //   297: istore_2
    //   298: ldc 128
    //   300: iconst_1
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: aload_0
    //   307: getfield 32	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:f	I
    //   310: i2f
    //   311: ldc 129
    //   313: fmul
    //   314: iload_2
    //   315: i2f
    //   316: fdiv
    //   317: invokestatic 135	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   320: aastore
    //   321: invokestatic 141	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   324: astore_1
    //   325: aload_0
    //   326: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   329: putfield 126	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_Long	J
    //   332: aload_0
    //   333: iconst_0
    //   334: putfield 32	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:f	I
    //   337: aload_0
    //   338: getfield 143	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel	Lcom/tencent/mobileqq/surfaceviewaction/gl/Label;
    //   341: aload_0
    //   342: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   345: aload_1
    //   346: invokevirtual 148	com/tencent/mobileqq/surfaceviewaction/gl/Label:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;Ljava/lang/String;)V
    //   349: aload_0
    //   350: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   353: getfield 94	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:jdField_c_of_type_Int	I
    //   356: invokestatic 97	android/opengl/GLES20:glUseProgram	(I)V
    //   359: aload_0
    //   360: getfield 143	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel	Lcom/tencent/mobileqq/surfaceviewaction/gl/Label;
    //   363: aload_0
    //   364: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   367: invokevirtual 100	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
    //   370: aload_0
    //   371: getfield 21	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   374: invokevirtual 103	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
    //   377: aload_0
    //   378: getfield 105	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_a_of_type_Int	I
    //   381: aload_0
    //   382: getfield 106	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_c_of_type_Int	I
    //   385: aload_0
    //   386: getfield 108	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_b_of_type_Int	I
    //   389: aload_0
    //   390: getfield 110	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:d	I
    //   393: aload_0
    //   394: getfield 112	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:e	I
    //   397: aload_0
    //   398: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$SimpleRenderer:jdField_c_of_type_ArrayOfFloat	[F
    //   401: invokevirtual 149	com/tencent/mobileqq/surfaceviewaction/gl/Label:c	(IIIIIII[F)V
    //   404: invokestatic 152	android/opengl/GLES20:glFlush	()V
    //   407: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	SimpleRenderer
    //   0	408	1	paramGL10	GL10
    //   11	304	2	i	int
    //   156	6	3	j	int
    //   126	5	4	localObject1	Object
    //   167	34	4	localObject2	Object
    //   253	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	49	126	finally
    //   56	70	126	finally
    //   128	130	126	finally
    //   82	119	253	finally
    //   133	135	253	finally
    //   255	257	253	finally
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / paramInt2;
    Matrix.frustumM(this.jdField_a_of_type_ArrayOfFloat, 0, -f1, f1, -1.0F, 1.0F, 3.0F, 7.0F);
    Matrix.setLookAtM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.c = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 50.0F) - paramInt1 / 2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.d = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 10.0F) - paramInt2 / 2);
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.o();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int = GLUtil.a(GLUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShader.glsl"), GLUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShader.glsl"));
      GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int);
      this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "vPosition");
      this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "a_texCoord");
      this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "uMVPMatrix");
      this.d = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "s_texture");
      this.e = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "v_alpha");
      QLog.i("SpriteGLView", 1, "program = " + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int + ",mPositionHandle =" + this.jdField_a_of_type_Int + ",mTexCoordHandle =" + this.jdField_c_of_type_Int + ",mMatrixHandle= " + this.jdField_b_of_type_Int + ",mTexSamplerHandle =" + this.d + ",mAlphaHandle = " + this.e);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel = new Label(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "fps:", -1, 40);
      SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, System.currentTimeMillis());
      return;
    }
    catch (Exception paramGL10)
    {
      for (;;)
      {
        QLog.e("SpriteGLView", 2, QLog.getStackTraceString(paramGL10));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.SimpleRenderer
 * JD-Core Version:    0.7.0.1
 */