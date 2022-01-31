public class lua
{
  private final int a;
  private int b;
  private int c;
  
  public lua(int paramInt)
  {
    this.a = paramInt;
    this.b = 1;
    this.c = 1;
  }
  
  public void a(lsv paramlsv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramlsv.a(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lua
 * JD-Core Version:    0.7.0.1
 */