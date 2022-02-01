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
public class nfe
  extends nfy
{
  private nka a = new nka(paramContext, this);
  
  public nfe(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      ncs localncs = (ncs)localIterator.next();
      if ((localncs.jdField_a_of_type_Long != paramLong) || (localncs.jdField_a_of_type_Boolean)) {
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
  
  public neh a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      return;
    }
    bcef.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.a.a(paramString);
  }
  
  public void a(List<ncs> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    synchronized (this.b)
    {
      this.b.clear();
      this.b.addAll(paramList);
      bija.d("AVGameBusinessVideoLayer", "onMemberVideoDisplayInfoUpdate infoList:=" + Arrays.toString(paramList.toArray()));
      nht.a().b().post(new AVGameBusinessVideoLayer.1(this));
      return;
    }
  }
  
  public void a(neg paramneg)
  {
    this.a.a(paramneg);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.c) {
      return;
    }
    this.a.b(paramString);
  }
  
  protected void f(lqb paramlqb)
  {
    if (this.a.a())
    {
      this.a.a(paramlqb);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramlqb.a(), paramlqb.b());
    super.f(paramlqb);
    this.a.g();
  }
  
  public void g(lqb paramlqb)
  {
    super.f(paramlqb);
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
 * Qualified Name:     nfe
 * JD-Core Version:    0.7.0.1
 */