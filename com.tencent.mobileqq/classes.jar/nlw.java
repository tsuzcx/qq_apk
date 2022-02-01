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
public class nlw
  extends nmq
{
  private nra a = new nra(paramContext, this);
  
  public nlw(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      niq localniq = (niq)localIterator.next();
      if ((localniq.jdField_a_of_type_Long != paramLong) || (localniq.jdField_a_of_type_Boolean)) {
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
  
  public nkz a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.a.a(paramString);
  }
  
  public void a(List<niq> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    synchronized (this.b)
    {
      this.b.clear();
      this.b.addAll(paramList);
      bjuc.d("AVGameBusinessVideoLayer", "onMemberVideoDisplayInfoUpdate infoList:=" + Arrays.toString(paramList.toArray()));
      nom.a().b().post(new AVGameBusinessVideoLayer.1(this));
      return;
    }
  }
  
  public void a(nky paramnky)
  {
    this.a.a(paramnky);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.c) {
      return;
    }
    this.a.b(paramString);
  }
  
  protected void f(lqo paramlqo)
  {
    if (this.a.a())
    {
      this.a.a(paramlqo);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramlqo.a(), paramlqo.b());
    super.f(paramlqo);
    this.a.g();
  }
  
  public void g(lqo paramlqo)
  {
    super.f(paramlqo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlw
 * JD-Core Version:    0.7.0.1
 */