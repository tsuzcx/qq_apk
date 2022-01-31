import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lln
  implements Observer
{
  private WeakReference<llm> a;
  
  public lln(llm paramllm)
  {
    this.a = new WeakReference(paramllm);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    llm localllm = (llm)this.a.get();
    if (localllm == null) {
      return;
    }
    llm.a(localllm, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lln
 * JD-Core Version:    0.7.0.1
 */