public class lyh
{
  public int a;
  public long a;
  public int b;
  public int c;
  
  public lyh()
  {
    this.jdField_a_of_type_Long = 67L;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.b != 0) && (this.c != 0);
  }
  
  public boolean a(lyh paramlyh)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramlyh == null) || (!paramlyh.a()))
    {
      bool2 = false;
      return bool2;
    }
    if (this.jdField_a_of_type_Int != paramlyh.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramlyh.jdField_a_of_type_Int;
      bool1 = true;
    }
    if (this.b != paramlyh.b)
    {
      this.b = paramlyh.b;
      bool1 = bool2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.c == paramlyh.c) {
        break;
      }
      this.c = paramlyh.c;
      if (this.c == 0) {
        this.c = 15;
      }
      this.jdField_a_of_type_Long = (1000 / this.c);
      return bool1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label71:
    label74:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof lyh)) {
        break;
      }
      paramObject = (lyh)paramObject;
      if (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int)
      {
        i = 1;
        if ((i == 0) || (this.b != paramObject.b)) {
          break label71;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (this.c == paramObject.c)) {
          break label74;
        }
        return false;
        i = 0;
        break;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParam{").append("width: ").append(this.jdField_a_of_type_Int).append(", height: ").append(this.b).append(", fps: ").append(this.c).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyh
 * JD-Core Version:    0.7.0.1
 */