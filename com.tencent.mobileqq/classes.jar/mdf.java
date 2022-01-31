public abstract class mdf
{
  protected int a;
  protected String a;
  protected int b = 0;
  protected int c = 3;
  protected int d;
  protected int e = 1;
  
  protected mdf(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.c = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a(mdf parammdf1, mdf parammdf2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (parammdf2 == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (parammdf1 == null);
          i = parammdf2.e();
          j = parammdf1.e();
          lli.a("CheckAvTipsItemLevelCanShow, lvNew[" + i + "], lvOld[" + j + "], idNew[" + parammdf2.b() + "], idOld[" + parammdf1.b() + "]");
          bool1 = bool2;
        } while (i < j);
        if (i > j) {
          return false;
        }
        bool1 = bool2;
      } while (parammdf1.a());
      if (parammdf2.a()) {
        return false;
      }
      bool1 = bool2;
    } while (parammdf2.c() <= parammdf1.c());
    return false;
  }
  
  public abstract int a();
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return this.c == 0;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof mdf))) {}
    do
    {
      return false;
      paramObject = (mdf)paramObject;
    } while (b() != paramObject.b());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */