import java.util.concurrent.atomic.AtomicBoolean;

public class tby
  implements tck
{
  protected AtomicBoolean c = new AtomicBoolean(false);
  
  public void a() {}
  
  public void b()
  {
    this.c.set(true);
  }
  
  public boolean b()
  {
    return this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tby
 * JD-Core Version:    0.7.0.1
 */