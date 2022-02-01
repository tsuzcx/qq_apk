public class lwf
{
  public int a;
  public long a;
  public int b;
  public int c;
  
  public lwf()
  {
    this.jdField_a_of_type_Long = 67L;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.b != 0) && (this.c != 0);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      this.jdField_a_of_type_Int = paramInt1;
      bool1 = true;
    }
    if (this.b != paramInt2)
    {
      this.b = paramInt2;
      bool1 = bool2;
    }
    for (;;)
    {
      if (this.c != paramInt3)
      {
        this.c = paramInt3;
        if (this.c == 0) {
          this.c = 15;
        }
        this.jdField_a_of_type_Long = (1000 / this.c);
      }
      return bool1;
    }
  }
  
  public boolean a(lwf paramlwf)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramlwf == null) || (!paramlwf.a()))
    {
      bool2 = false;
      return bool2;
    }
    if (this.jdField_a_of_type_Int != paramlwf.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramlwf.jdField_a_of_type_Int;
      bool1 = true;
    }
    if (this.b != paramlwf.b)
    {
      this.b = paramlwf.b;
      bool1 = bool2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.c == paramlwf.c) {
        break;
      }
      this.c = paramlwf.c;
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
      if (!(paramObject instanceof lwf)) {
        break;
      }
      paramObject = (lwf)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwf
 * JD-Core Version:    0.7.0.1
 */