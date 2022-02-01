import androidx.annotation.NonNull;

public class pbn<V>
{
  private V a;
  
  public pbn(V paramV)
  {
    this.a = paramV;
  }
  
  public V a()
  {
    return this.a;
  }
  
  public void a(V paramV)
  {
    this.a = paramV;
  }
  
  @NonNull
  public String toString()
  {
    if (this.a != null) {
      return this.a.toString();
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbn
 * JD-Core Version:    0.7.0.1
 */