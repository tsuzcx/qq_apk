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
public class ndx
  extends ner
{
  private nil a = new nil(paramContext, this);
  
  public ndx(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      nbr localnbr = (nbr)localIterator.next();
      if ((localnbr.jdField_a_of_type_Long != paramLong) || (localnbr.jdField_a_of_type_Boolean)) {
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
  
  public ndb a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      return;
    }
    bdll.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.a.a(paramString);
  }
  
  public void a(List<nbr> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    synchronized (this.b)
    {
      this.b.clear();
      this.b.addAll(paramList);
      bkdp.d("AVGameBusinessVideoLayer", "onMemberVideoDisplayInfoUpdate infoList:=" + Arrays.toString(paramList.toArray()));
      ngk.a().b().post(new AVGameBusinessVideoLayer.1(this));
      return;
    }
  }
  
  public void a(nda paramnda)
  {
    this.a.a(paramnda);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.c) {
      return;
    }
    this.a.b(paramString);
  }
  
  protected void f(lqt paramlqt)
  {
    if (this.a.a())
    {
      this.a.a(paramlqt);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramlqt.a(), paramlqt.b());
    super.f(paramlqt);
    this.a.g();
  }
  
  public void g(lqt paramlqt)
  {
    super.f(paramlqt);
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
 * Qualified Name:     ndx
 * JD-Core Version:    0.7.0.1
 */