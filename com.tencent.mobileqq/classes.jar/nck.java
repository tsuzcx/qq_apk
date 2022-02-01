import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer.1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class nck
  extends ncz
{
  private ngq a = new ngq(paramContext, this);
  
  public nck(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      nan localnan = (nan)localIterator.next();
      if ((localnan.jdField_a_of_type_Long != paramLong) || (localnan.jdField_a_of_type_Boolean)) {
        break label60;
      }
      bool = true;
    }
    label60:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public nbo a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      return;
    }
    bcst.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.a.a(paramString);
  }
  
  public void a(List<nan> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    synchronized (this.b)
    {
      this.b.clear();
      this.b.addAll(paramList);
      bjcq.d("AVGameBusinessVideoLayer", "onMemberVideoDisplayInfoUpdate infoList:=" + Arrays.toString(paramList.toArray()));
      neq.a().b().post(new AVGameBusinessVideoLayer.1(this));
      return;
    }
  }
  
  public void a(nbn paramnbn)
  {
    this.a.a(paramnbn);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.c) {
      return;
    }
    this.a.b(paramString);
  }
  
  protected void f(lpx paramlpx)
  {
    if (this.a.a())
    {
      this.a.a(paramlpx);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramlpx.a(), paramlpx.b());
    super.f(paramlpx);
    this.a.g();
  }
  
  public void g(lpx paramlpx)
  {
    super.f(paramlpx);
  }
  
  public void l()
  {
    super.l();
  }
  
  public void m()
  {
    super.m();
    this.a.c();
  }
  
  public void n()
  {
    super.n();
    this.a.d();
  }
  
  public void o()
  {
    super.o();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nck
 * JD-Core Version:    0.7.0.1
 */