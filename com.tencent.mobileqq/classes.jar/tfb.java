public class tfb
{
  public final String a;
  public final String b;
  public final String c;
  
  public tfb(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("both downloadUrl and downloadLocalPath should not be null");
    }
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        paramObject = (tfb)paramObject;
        bool1 = bool3;
      } while (!this.a.equals(paramObject.a));
      bool1 = bool3;
    } while (!this.b.equals(paramObject.b));
    if (this.c != null)
    {
      bool1 = bool2;
      if (this.c.equals(paramObject.c)) {}
    }
    for (boolean bool1 = false;; bool1 = bool2)
    {
      return bool1;
      if (paramObject.c != null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    if (this.c != null) {}
    for (int i = this.c.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
  
  public String toString()
  {
    return "Input{downloadUrl='" + this.a + '\'' + ", downloadLocalPath='" + this.b + '\'' + ", downloadFileMd5='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfb
 * JD-Core Version:    0.7.0.1
 */