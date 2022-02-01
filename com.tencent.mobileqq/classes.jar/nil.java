import android.content.Context;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

@RequiresApi(api=18)
public class nil
  implements ndb
{
  private int jdField_a_of_type_Int;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private nda jdField_a_of_type_Nda;
  private ndx jdField_a_of_type_Ndx;
  private nin jdField_a_of_type_Nin;
  private niq jdField_a_of_type_Niq;
  private nis jdField_a_of_type_Nis;
  private niv jdField_a_of_type_Niv;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  
  public nil(Context paramContext, ndx paramndx)
  {
    this.jdField_a_of_type_Ndx = paramndx;
    int i = nhz.a();
    bkdp.d("GameVideoRecordPresenterWrapper", "machineLevel " + i);
    if ((i == 1) || (i == 0))
    {
      bkdp.d("GameVideoRecordPresenterWrapper", "machineLevel low, don't init ctrl");
      return;
    }
    this.jdField_a_of_type_Niv = new niv(paramContext, paramndx);
    this.jdField_a_of_type_Nin = new nin(paramContext);
    this.jdField_a_of_type_Nis = new nis(paramContext, paramndx);
    this.jdField_a_of_type_Niq = new niq(paramContext, paramndx);
  }
  
  private void a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    float f3 = paramRectF.right;
    float f4 = paramRectF.left;
    float f1 = paramRectF.bottom;
    float f2 = paramRectF.top;
    paramFloat1 = (f3 - f4) * (paramFloat2 / paramFloat1);
    paramFloat2 = (f1 - f2) / paramFloat1;
    paramFloat1 = paramRectF.top / paramFloat1;
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 1.0F - paramFloat2 - paramFloat1, 0.0F);
    Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, paramFloat2, 1.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  protected ndb a()
  {
    int i = myk.a().a().c();
    if (i == 1) {
      return this.jdField_a_of_type_Niv;
    }
    if (i == 2) {
      return this.jdField_a_of_type_Nin;
    }
    if (i == 3) {
      return this.jdField_a_of_type_Nis;
    }
    if (i == 4) {
      return this.jdField_a_of_type_Niq;
    }
    return null;
  }
  
  public nin a()
  {
    return this.jdField_a_of_type_Nin;
  }
  
  public void a()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.a();
    }
  }
  
  public void a(View paramView)
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Nis != null) && (myk.a().a().c() == 3)) {
      this.jdField_a_of_type_Nis.b(paramString);
    }
  }
  
  public void a(lqt paramlqt)
  {
    int i = myk.a().a().c();
    if (i == 1) {
      c(paramlqt);
    }
    do
    {
      return;
      if (i == 3)
      {
        d(paramlqt);
        return;
      }
    } while (i != 4);
    b(paramlqt);
  }
  
  public void a(nda paramnda)
  {
    this.jdField_a_of_type_Nda = paramnda;
    if (this.jdField_a_of_type_Niv != null) {
      this.jdField_a_of_type_Niv.a(paramnda);
    }
    if (this.jdField_a_of_type_Nis != null) {
      this.jdField_a_of_type_Nis.a(paramnda);
    }
  }
  
  public boolean a()
  {
    int i = myk.a().a().c();
    if (i == 1) {
      if ((this.jdField_a_of_type_Niv == null) || ((!this.jdField_a_of_type_Niv.d()) && (!this.jdField_a_of_type_Niv.g()))) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (i != 3) {
          break;
        }
      } while ((this.jdField_a_of_type_Nis != null) && ((this.jdField_a_of_type_Nis.d()) || (this.jdField_a_of_type_Nis.f())));
      return false;
      if (i != 4) {
        break;
      }
    } while ((this.jdField_a_of_type_Niq != null) && (this.jdField_a_of_type_Niq.d()));
    return false;
    return false;
  }
  
  public void b()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.b();
    }
  }
  
  public void b(View paramView)
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.b(paramView);
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_Nis != null) && (myk.a().a().c() == 3)) {
      this.jdField_a_of_type_Nis.c(paramString);
    }
  }
  
  protected void b(lqt paramlqt)
  {
    GLES20.glViewport(0, 0, paramlqt.a(), paramlqt.b());
    this.jdField_a_of_type_Ndx.g(paramlqt);
    this.jdField_a_of_type_Niq.p();
  }
  
  public void c()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.c();
    }
  }
  
  public void c(View paramView)
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.c(paramView);
    }
  }
  
  protected void c(lqt paramlqt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nda != null))
    {
      Object localObject = this.jdField_a_of_type_Nda.a();
      if (localObject == null)
      {
        bkdp.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bkdp.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init:" + paramlqt.a() + " " + paramlqt.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqt.a(), paramlqt.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqt.a(), paramlqt.b());
      localObject = this.jdField_a_of_type_Niv.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Ndx.g(paramlqt);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Niv.n();
      this.jdField_a_of_type_Niv.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Niv.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Ndx.g(paramlqt);
  }
  
  public void d()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.d();
    }
  }
  
  protected void d(lqt paramlqt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nda != null))
    {
      Object localObject = this.jdField_a_of_type_Nda.a();
      if (localObject == null)
      {
        bkdp.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bkdp.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init:" + paramlqt.a() + " " + paramlqt.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqt.a(), paramlqt.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqt.a(), paramlqt.b());
      localObject = this.jdField_a_of_type_Nis.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Ndx.g(paramlqt);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nis.n();
      this.jdField_a_of_type_Nis.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nis.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Ndx.g(paramlqt);
  }
  
  public void e()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.e();
    }
  }
  
  public void f()
  {
    ndb localndb = a();
    if (localndb != null) {
      localndb.f();
    }
  }
  
  public void g()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      i = myk.a().a().c();
      if (i != 1) {
        break label108;
      }
      this.jdField_a_of_type_Niv.p();
    }
    for (;;)
    {
      if ((myk.a().a().c() == 4) && (this.jdField_a_of_type_Niq != null)) {
        this.jdField_a_of_type_Niq.q();
      }
      return;
      label108:
      if (i == 3) {
        this.jdField_a_of_type_Nis.p();
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Niv != null) {
      this.jdField_a_of_type_Niv.l();
    }
    if (this.jdField_a_of_type_Nin != null) {
      this.jdField_a_of_type_Nin.l();
    }
    if (this.jdField_a_of_type_Nis != null) {
      this.jdField_a_of_type_Nis.l();
    }
    if (this.jdField_a_of_type_Niq != null) {
      this.jdField_a_of_type_Niq.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nil
 * JD-Core Version:    0.7.0.1
 */