public class shr
  implements sfp
{
  public String a;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof shr)) {
      this.a = ((shr)paramObject).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shr
 * JD-Core Version:    0.7.0.1
 */