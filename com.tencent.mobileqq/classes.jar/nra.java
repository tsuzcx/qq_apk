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
public class nra
  implements nkz
{
  private int jdField_a_of_type_Int;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private nky jdField_a_of_type_Nky;
  private nlw jdField_a_of_type_Nlw;
  private nrc jdField_a_of_type_Nrc;
  private nrf jdField_a_of_type_Nrf;
  private nrh jdField_a_of_type_Nrh;
  private nrk jdField_a_of_type_Nrk;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  
  public nra(Context paramContext, nlw paramnlw)
  {
    this.jdField_a_of_type_Nlw = paramnlw;
    int i = nqm.a();
    bjuc.d("GameVideoRecordPresenterWrapper", "machineLevel " + i);
    if ((i == 1) || (i == 0))
    {
      bjuc.d("GameVideoRecordPresenterWrapper", "machineLevel low, don't init ctrl");
      return;
    }
    if (nfc.a().f())
    {
      bjuc.d("GameVideoRecordPresenterWrapper", "survival not record");
      return;
    }
    this.jdField_a_of_type_Nrk = new nrk(paramContext, paramnlw);
    this.jdField_a_of_type_Nrc = new nrc(paramContext);
    this.jdField_a_of_type_Nrh = new nrh(paramContext, paramnlw);
    this.jdField_a_of_type_Nrf = new nrf(paramContext, paramnlw);
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
  
  protected nkz a()
  {
    int i = nfc.a().a().c();
    if (i == 1) {
      return this.jdField_a_of_type_Nrk;
    }
    if (i == 2) {
      return this.jdField_a_of_type_Nrc;
    }
    if (i == 3) {
      return this.jdField_a_of_type_Nrh;
    }
    if (i == 4) {
      return this.jdField_a_of_type_Nrf;
    }
    return null;
  }
  
  public nrc a()
  {
    return this.jdField_a_of_type_Nrc;
  }
  
  public void a()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.a();
    }
  }
  
  public void a(View paramView)
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Nrh != null) && (nfc.a().a().c() == 3)) {
      this.jdField_a_of_type_Nrh.b(paramString);
    }
  }
  
  public void a(lqo paramlqo)
  {
    int i = nfc.a().a().c();
    if (i == 1) {
      c(paramlqo);
    }
    do
    {
      return;
      if (i == 3)
      {
        d(paramlqo);
        return;
      }
    } while (i != 4);
    b(paramlqo);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nky = paramnky;
    if (this.jdField_a_of_type_Nrk != null) {
      this.jdField_a_of_type_Nrk.a(paramnky);
    }
    if (this.jdField_a_of_type_Nrh != null) {
      this.jdField_a_of_type_Nrh.a(paramnky);
    }
  }
  
  public boolean a()
  {
    int i = nfc.a().a().c();
    if (i == 1) {
      if ((this.jdField_a_of_type_Nrk == null) || ((!this.jdField_a_of_type_Nrk.d()) && (!this.jdField_a_of_type_Nrk.g()))) {}
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
      } while ((this.jdField_a_of_type_Nrh != null) && ((this.jdField_a_of_type_Nrh.d()) || (this.jdField_a_of_type_Nrh.f())));
      return false;
      if (i != 4) {
        break;
      }
    } while ((this.jdField_a_of_type_Nrf != null) && (this.jdField_a_of_type_Nrf.d()));
    return false;
    return false;
  }
  
  public void b()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.b();
    }
  }
  
  public void b(View paramView)
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.b(paramView);
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_Nrh != null) && (nfc.a().a().c() == 3)) {
      this.jdField_a_of_type_Nrh.c(paramString);
    }
  }
  
  protected void b(lqo paramlqo)
  {
    GLES20.glViewport(0, 0, paramlqo.a(), paramlqo.b());
    this.jdField_a_of_type_Nlw.g(paramlqo);
    this.jdField_a_of_type_Nrf.p();
  }
  
  public void c()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.c();
    }
  }
  
  public void c(View paramView)
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.c(paramView);
    }
  }
  
  protected void c(lqo paramlqo)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nky != null))
    {
      Object localObject = this.jdField_a_of_type_Nky.a();
      if (localObject == null)
      {
        bjuc.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bjuc.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init:" + paramlqo.a() + " " + paramlqo.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqo.a(), paramlqo.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqo.a(), paramlqo.b());
      localObject = this.jdField_a_of_type_Nrk.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nlw.g(paramlqo);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nrk.n();
      this.jdField_a_of_type_Nrk.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nrk.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nlw.g(paramlqo);
  }
  
  public void d()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.d();
    }
  }
  
  protected void d(lqo paramlqo)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nky != null))
    {
      Object localObject = this.jdField_a_of_type_Nky.a();
      if (localObject == null)
      {
        bjuc.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bjuc.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init:" + paramlqo.a() + " " + paramlqo.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqo.a(), paramlqo.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqo.a(), paramlqo.b());
      localObject = this.jdField_a_of_type_Nrh.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nlw.g(paramlqo);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nrh.n();
      this.jdField_a_of_type_Nrh.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nrh.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nlw.g(paramlqo);
  }
  
  public void e()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.e();
    }
  }
  
  public void f()
  {
    nkz localnkz = a();
    if (localnkz != null) {
      localnkz.f();
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
      i = nfc.a().a().c();
      if (i != 1) {
        break label108;
      }
      this.jdField_a_of_type_Nrk.p();
    }
    for (;;)
    {
      if ((nfc.a().a().c() == 4) && (this.jdField_a_of_type_Nrf != null)) {
        this.jdField_a_of_type_Nrf.q();
      }
      return;
      label108:
      if (i == 3) {
        this.jdField_a_of_type_Nrh.p();
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Nrk != null) {
      this.jdField_a_of_type_Nrk.l();
    }
    if (this.jdField_a_of_type_Nrc != null) {
      this.jdField_a_of_type_Nrc.l();
    }
    if (this.jdField_a_of_type_Nrh != null) {
      this.jdField_a_of_type_Nrh.l();
    }
    if (this.jdField_a_of_type_Nrf != null) {
      this.jdField_a_of_type_Nrf.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nra
 * JD-Core Version:    0.7.0.1
 */