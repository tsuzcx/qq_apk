import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager;
import java.lang.ref.WeakReference;

public class kda
  extends Handler
{
  WeakReference a;
  
  public kda(EffectFilterTextPager paramEffectFilterTextPager)
  {
    this.a = new WeakReference(paramEffectFilterTextPager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    EffectFilterTextPager localEffectFilterTextPager = (EffectFilterTextPager)this.a.get();
    if (localEffectFilterTextPager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      localEffectFilterTextPager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kda
 * JD-Core Version:    0.7.0.1
 */