public class suk
  implements ssi
{
  public String a;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof suk)) {
      this.a = ((suk)paramObject).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suk
 * JD-Core Version:    0.7.0.1
 */