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
public class ngq
  implements nbo
{
  private int jdField_a_of_type_Int;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private nbn jdField_a_of_type_Nbn;
  private nck jdField_a_of_type_Nck;
  private ngs jdField_a_of_type_Ngs;
  private ngv jdField_a_of_type_Ngv;
  private ngx jdField_a_of_type_Ngx;
  private nha jdField_a_of_type_Nha;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  
  public ngq(Context paramContext, nck paramnck)
  {
    this.jdField_a_of_type_Nck = paramnck;
    int i = nge.a();
    bjcq.d("GameVideoRecordPresenterWrapper", "machineLevel " + i);
    if ((i == 1) || (i == 0))
    {
      bjcq.d("GameVideoRecordPresenterWrapper", "machineLevel low, don't init ctrl");
      return;
    }
    this.jdField_a_of_type_Nha = new nha(paramContext, paramnck);
    this.jdField_a_of_type_Ngs = new ngs(paramContext);
    this.jdField_a_of_type_Ngx = new ngx(paramContext, paramnck);
    this.jdField_a_of_type_Ngv = new ngv(paramContext, paramnck);
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
  
  protected nbo a()
  {
    int i = mxl.a().a().c();
    if (i == 1) {
      return this.jdField_a_of_type_Nha;
    }
    if (i == 2) {
      return this.jdField_a_of_type_Ngs;
    }
    if (i == 3) {
      return this.jdField_a_of_type_Ngx;
    }
    if (i == 4) {
      return this.jdField_a_of_type_Ngv;
    }
    return null;
  }
  
  public ngs a()
  {
    return this.jdField_a_of_type_Ngs;
  }
  
  public void a()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.a();
    }
  }
  
  public void a(View paramView)
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Ngx != null) && (mxl.a().a().c() == 3)) {
      this.jdField_a_of_type_Ngx.b(paramString);
    }
  }
  
  public void a(lpx paramlpx)
  {
    int i = mxl.a().a().c();
    if (i == 1) {
      c(paramlpx);
    }
    do
    {
      return;
      if (i == 3)
      {
        d(paramlpx);
        return;
      }
    } while (i != 4);
    b(paramlpx);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbn = paramnbn;
    if (this.jdField_a_of_type_Nha != null) {
      this.jdField_a_of_type_Nha.a(paramnbn);
    }
    if (this.jdField_a_of_type_Ngx != null) {
      this.jdField_a_of_type_Ngx.a(paramnbn);
    }
  }
  
  public boolean a()
  {
    int i = mxl.a().a().c();
    if (i == 1) {
      if ((this.jdField_a_of_type_Nha == null) || ((!this.jdField_a_of_type_Nha.d()) && (!this.jdField_a_of_type_Nha.g()))) {}
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
      } while ((this.jdField_a_of_type_Ngx != null) && ((this.jdField_a_of_type_Ngx.d()) || (this.jdField_a_of_type_Ngx.f())));
      return false;
      if (i != 4) {
        break;
      }
    } while ((this.jdField_a_of_type_Ngv != null) && (this.jdField_a_of_type_Ngv.d()));
    return false;
    return false;
  }
  
  public void b()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.b();
    }
  }
  
  public void b(View paramView)
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.b(paramView);
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_Ngx != null) && (mxl.a().a().c() == 3)) {
      this.jdField_a_of_type_Ngx.c(paramString);
    }
  }
  
  protected void b(lpx paramlpx)
  {
    GLES20.glViewport(0, 0, paramlpx.a(), paramlpx.b());
    this.jdField_a_of_type_Nck.g(paramlpx);
    this.jdField_a_of_type_Ngv.p();
  }
  
  public void c()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.c();
    }
  }
  
  public void c(View paramView)
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.c(paramView);
    }
  }
  
  protected void c(lpx paramlpx)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nbn != null))
    {
      Object localObject = this.jdField_a_of_type_Nbn.a();
      if (localObject == null)
      {
        bjcq.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bjcq.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init:" + paramlpx.a() + " " + paramlpx.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlpx.a(), paramlpx.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlpx.a(), paramlpx.b());
      localObject = this.jdField_a_of_type_Nha.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nck.g(paramlpx);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nha.n();
      this.jdField_a_of_type_Nha.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nha.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nck.g(paramlpx);
  }
  
  public void d()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.d();
    }
  }
  
  protected void d(lpx paramlpx)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nbn != null))
    {
      Object localObject = this.jdField_a_of_type_Nbn.a();
      if (localObject == null)
      {
        bjcq.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bjcq.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init:" + paramlpx.a() + " " + paramlpx.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlpx.a(), paramlpx.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlpx.a(), paramlpx.b());
      localObject = this.jdField_a_of_type_Ngx.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nck.g(paramlpx);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Ngx.n();
      this.jdField_a_of_type_Ngx.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Ngx.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nck.g(paramlpx);
  }
  
  public void e()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.e();
    }
  }
  
  public void f()
  {
    nbo localnbo = a();
    if (localnbo != null) {
      localnbo.f();
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
      i = mxl.a().a().c();
      if (i != 1) {
        break label108;
      }
      this.jdField_a_of_type_Nha.p();
    }
    for (;;)
    {
      if ((mxl.a().a().c() == 4) && (this.jdField_a_of_type_Ngv != null)) {
        this.jdField_a_of_type_Ngv.q();
      }
      return;
      label108:
      if (i == 3) {
        this.jdField_a_of_type_Ngx.p();
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Nha != null) {
      this.jdField_a_of_type_Nha.l();
    }
    if (this.jdField_a_of_type_Ngs != null) {
      this.jdField_a_of_type_Ngs.l();
    }
    if (this.jdField_a_of_type_Ngx != null) {
      this.jdField_a_of_type_Ngx.l();
    }
    if (this.jdField_a_of_type_Ngv != null) {
      this.jdField_a_of_type_Ngv.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngq
 * JD-Core Version:    0.7.0.1
 */