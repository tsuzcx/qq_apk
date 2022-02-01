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
public class nka
  implements neh
{
  private int jdField_a_of_type_Int;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private neg jdField_a_of_type_Neg;
  private nfe jdField_a_of_type_Nfe;
  private nkc jdField_a_of_type_Nkc;
  private nkf jdField_a_of_type_Nkf;
  private nkh jdField_a_of_type_Nkh;
  private nkk jdField_a_of_type_Nkk;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  
  public nka(Context paramContext, nfe paramnfe)
  {
    this.jdField_a_of_type_Nfe = paramnfe;
    int i = njo.a();
    bija.d("GameVideoRecordPresenterWrapper", "machineLevel " + i);
    if ((i == 1) || (i == 0))
    {
      bija.d("GameVideoRecordPresenterWrapper", "machineLevel low, don't init ctrl");
      return;
    }
    this.jdField_a_of_type_Nkk = new nkk(paramContext, paramnfe);
    this.jdField_a_of_type_Nkc = new nkc(paramContext);
    this.jdField_a_of_type_Nkh = new nkh(paramContext, paramnfe);
    this.jdField_a_of_type_Nkf = new nkf(paramContext, paramnfe);
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
  
  protected neh a()
  {
    int i = mzl.a().a().c();
    if (i == 1) {
      return this.jdField_a_of_type_Nkk;
    }
    if (i == 2) {
      return this.jdField_a_of_type_Nkc;
    }
    if (i == 3) {
      return this.jdField_a_of_type_Nkh;
    }
    if (i == 4) {
      return this.jdField_a_of_type_Nkf;
    }
    return null;
  }
  
  public nkc a()
  {
    return this.jdField_a_of_type_Nkc;
  }
  
  public void a()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.a();
    }
  }
  
  public void a(View paramView)
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Nkh != null) && (mzl.a().a().c() == 3)) {
      this.jdField_a_of_type_Nkh.b(paramString);
    }
  }
  
  public void a(lqb paramlqb)
  {
    int i = mzl.a().a().c();
    if (i == 1) {
      c(paramlqb);
    }
    do
    {
      return;
      if (i == 3)
      {
        d(paramlqb);
        return;
      }
    } while (i != 4);
    b(paramlqb);
  }
  
  public void a(neg paramneg)
  {
    this.jdField_a_of_type_Neg = paramneg;
    if (this.jdField_a_of_type_Nkk != null) {
      this.jdField_a_of_type_Nkk.a(paramneg);
    }
    if (this.jdField_a_of_type_Nkh != null) {
      this.jdField_a_of_type_Nkh.a(paramneg);
    }
  }
  
  public boolean a()
  {
    int i = mzl.a().a().c();
    if (i == 1) {
      if ((this.jdField_a_of_type_Nkk == null) || ((!this.jdField_a_of_type_Nkk.d()) && (!this.jdField_a_of_type_Nkk.g()))) {}
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
      } while ((this.jdField_a_of_type_Nkh != null) && ((this.jdField_a_of_type_Nkh.d()) || (this.jdField_a_of_type_Nkh.f())));
      return false;
      if (i != 4) {
        break;
      }
    } while ((this.jdField_a_of_type_Nkf != null) && (this.jdField_a_of_type_Nkf.d()));
    return false;
    return false;
  }
  
  public void b()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.b();
    }
  }
  
  public void b(View paramView)
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.b(paramView);
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_Nkh != null) && (mzl.a().a().c() == 3)) {
      this.jdField_a_of_type_Nkh.c(paramString);
    }
  }
  
  protected void b(lqb paramlqb)
  {
    GLES20.glViewport(0, 0, paramlqb.a(), paramlqb.b());
    this.jdField_a_of_type_Nfe.g(paramlqb);
    this.jdField_a_of_type_Nkf.p();
  }
  
  public void c()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.c();
    }
  }
  
  public void c(View paramView)
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.c(paramView);
    }
  }
  
  protected void c(lqb paramlqb)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Neg != null))
    {
      Object localObject = this.jdField_a_of_type_Neg.a();
      if (localObject == null)
      {
        bija.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bija.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init:" + paramlqb.a() + " " + paramlqb.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqb.a(), paramlqb.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqb.a(), paramlqb.b());
      localObject = this.jdField_a_of_type_Nkk.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nfe.g(paramlqb);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nkk.n();
      this.jdField_a_of_type_Nkk.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nkk.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nfe.g(paramlqb);
  }
  
  public void d()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.d();
    }
  }
  
  protected void d(lqb paramlqb)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Neg != null))
    {
      Object localObject = this.jdField_a_of_type_Neg.a();
      if (localObject == null)
      {
        bija.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
      int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
      bija.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init:" + paramlqb.a() + " " + paramlqb.b() + " " + localObject);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqb.a(), paramlqb.b(), 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      a((RectF)localObject, paramlqb.a(), paramlqb.b());
      localObject = this.jdField_a_of_type_Nkh.a(i, j);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_b_of_type_Int = localObject[1];
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Nfe.g(paramlqb);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Nkh.n();
      this.jdField_a_of_type_Nkh.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_Nkh.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_Nfe.g(paramlqb);
  }
  
  public void e()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.e();
    }
  }
  
  public void f()
  {
    neh localneh = a();
    if (localneh != null) {
      localneh.f();
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
      i = mzl.a().a().c();
      if (i != 1) {
        break label108;
      }
      this.jdField_a_of_type_Nkk.p();
    }
    for (;;)
    {
      if ((mzl.a().a().c() == 4) && (this.jdField_a_of_type_Nkf != null)) {
        this.jdField_a_of_type_Nkf.q();
      }
      return;
      label108:
      if (i == 3) {
        this.jdField_a_of_type_Nkh.p();
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Nkk != null) {
      this.jdField_a_of_type_Nkk.l();
    }
    if (this.jdField_a_of_type_Nkc != null) {
      this.jdField_a_of_type_Nkc.l();
    }
    if (this.jdField_a_of_type_Nkh != null) {
      this.jdField_a_of_type_Nkh.l();
    }
    if (this.jdField_a_of_type_Nkf != null) {
      this.jdField_a_of_type_Nkf.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nka
 * JD-Core Version:    0.7.0.1
 */