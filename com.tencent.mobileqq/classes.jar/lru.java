import android.os.Handler;
import android.os.Looper;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.ui.ControlUIObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class lru
  implements Observer
{
  Handler a = null;
  
  public static <T extends lrv> T a(Object[] paramArrayOfObject)
  {
    return (lrv)paramArrayOfObject[1];
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(int paramInt, long paramLong) {}
  
  public void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, ArrayList<leb> paramArrayList) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString) {}
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  protected void a(baem parambaem) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage) {}
  
  protected void a(String paramString, Boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2) {}
  
  protected void a(ArrayList<leb> paramArrayList) {}
  
  protected void a(lrw paramlrw) {}
  
  protected void a(lrx paramlrx) {}
  
  public void a(lry paramlry) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  protected void b(int paramInt, long paramLong) {}
  
  protected void b(long paramLong) {}
  
  public void b(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("qav.ControlUIObserver", 2, "OnUpdate，msgType = " + i);
    }
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 101: 
      a(min.a(paramObject, 1));
      return;
    case 102: 
      a();
      return;
    case 103: 
      localObject = (ArrayList)paramObject[1];
      a(min.a(paramObject, 2), (ArrayList)localObject);
      return;
    case 104: 
      a((ArrayList)paramObject[1]);
      return;
    case 105: 
      a(((Boolean)paramObject[1]).booleanValue(), min.a(paramObject, 2));
      return;
    case 106: 
      b(min.a(paramObject, 1));
      return;
    case 107: 
      c(min.a(paramObject, 1));
      return;
    case 108: 
      f();
      return;
    case 109: 
      g();
      return;
    case 110: 
      e(min.a(paramObject, 1));
      return;
    case 8001: 
      b((String)paramObject[1]);
      return;
    case 119: 
      c(((Integer)paramObject[1]).intValue());
      return;
    case 111: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 113: 
      b();
      return;
    case 114: 
      e();
      return;
    case 115: 
      a((String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    case 172: 
      a(((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 117: 
      i = -1;
      if (paramObject.length > 1) {
        i = ((Integer)paramObject[1]).intValue();
      }
      a(i);
      return;
    case 8002: 
      h();
      return;
    case 123: 
      if (paramObject.length <= 1) {
        break;
      }
    }
    for (i = ((Integer)paramObject[1]).intValue();; i = 0)
    {
      a(min.a(paramObject, 2), i);
      return;
      b(((Integer)paramObject[1]).intValue());
      return;
      a((lry)paramObject[1]);
      return;
      localObject = (String)paramObject[1];
      paramObject = (String)paramObject[2];
      kyy.a((String)localObject, paramObject);
      b((String)localObject, paramObject);
      return;
      if (paramObject.length < 4) {
        break;
      }
      boolean bool1 = ((Boolean)paramObject[1]).booleanValue();
      boolean bool2 = ((Boolean)paramObject[2]).booleanValue();
      long l = ((Long)paramObject[3]).longValue();
      a(min.a(paramObject, 4), bool1, bool2, l);
      return;
      i();
      return;
      a(paramObject[1]);
      return;
      d(min.a(paramObject, 1));
      return;
      bool1 = ((Boolean)paramObject[1]).booleanValue();
      i = ((Integer)paramObject[2]).intValue();
      a(min.a(paramObject, 3), bool1, i);
      return;
      f(min.a(paramObject, 1));
      return;
      a((String)paramObject[1]);
      return;
      l();
      return;
      j();
      return;
      m();
      return;
      n();
      return;
      o();
      return;
      p();
      return;
      f(((Integer)paramObject[1]).intValue());
      return;
      c();
      return;
      a(((Integer)paramObject[1]).intValue(), min.a(paramObject, 2));
      return;
      k();
      return;
      d((String)paramObject[1]);
      return;
      a((String)paramObject[1], (Boolean)paramObject[2]);
      return;
      e((String)paramObject[1]);
      return;
      b((String)paramObject[1], (Boolean)paramObject[2]);
      return;
      b((lry)paramObject[1]);
      return;
      a((lrw)paramObject[1]);
      return;
      a((lrx)paramObject[1]);
      return;
      c((lry)paramObject[1]);
      return;
      d((lry)paramObject[1]);
      return;
      e((lry)paramObject[1]);
      return;
      f((lry)paramObject[1]);
      return;
      a((baem)paramObject[1]);
      return;
      a((String)paramObject[1], (String)paramObject[2]);
      return;
      d();
      return;
      d(((Integer)paramObject[1]).intValue());
      return;
      c((String)paramObject[2]);
      return;
      e(((Integer)paramObject[1]).intValue());
      return;
      b(((Boolean)paramObject[1]).booleanValue());
      return;
      a(min.a(paramObject, 1), ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3]);
      return;
      a((String)paramObject[1], (AVFunChat.AVFunChatMessage)paramObject[2]);
      return;
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    }
  }
  
  protected void b(String paramString) {}
  
  protected void b(String paramString, Boolean paramBoolean) {}
  
  public void b(String paramString1, String paramString2) {}
  
  protected void b(lry paramlry) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c() {}
  
  protected void c(int paramInt) {}
  
  protected void c(long paramLong) {}
  
  public void c(String paramString) {}
  
  protected void c(lry paramlry) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  protected void d(long paramLong) {}
  
  protected void d(String paramString) {}
  
  protected void d(lry paramlry) {}
  
  protected void e() {}
  
  protected void e(int paramInt) {}
  
  protected void e(long paramLong) {}
  
  protected void e(String paramString) {}
  
  protected void e(lry paramlry) {}
  
  protected void f() {}
  
  protected void f(int paramInt) {}
  
  protected void f(long paramLong) {}
  
  protected void f(lry paramlry) {}
  
  protected void g() {}
  
  public void h() {}
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o() {}
  
  protected void p() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new ControlUIObserver.1(this, paramObject));
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lru
 * JD-Core Version:    0.7.0.1
 */