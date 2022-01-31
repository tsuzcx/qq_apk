import com.tencent.av.app.VideoAppInterface;

public class lje
  extends lhi
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ljg jdField_a_of_type_Ljg;
  private ljf[] jdField_a_of_type_ArrayOfLjf = new ljf[14];
  
  public lje(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Ljg = new ljg(paramVideoAppInterface);
  }
  
  private ljf a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLjf[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ljf localljf = this.jdField_a_of_type_ArrayOfLjf[paramInt];
      localObject1 = localljf;
      if (localljf == null)
      {
        localljf = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localljf;
        if (localljf != null)
        {
          this.jdField_a_of_type_ArrayOfLjf[paramInt] = localljf;
          localObject1 = localljf;
        }
      }
      return localObject1;
    }
  }
  
  private ljf a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Ljg;
    }
    for (;;)
    {
      if (localObject != null) {
        ((ljf)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lcl.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new ljj(paramVideoAppInterface);
      continue;
      localObject = new ljh(paramVideoAppInterface);
      continue;
      localObject = new lji(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    ljf localljf = a(paramInt);
    paramInt = i;
    if (localljf != null) {
      paramInt = localljf.a(paramString);
    }
    return paramInt;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 14)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        ljf localljf = a(i);
        if (localljf != null) {
          localljf.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lcl.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(255);
      return;
    }
    b();
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    ljf localljf = a(paramInt1);
    if (localljf != null) {
      return localljf.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    ljf localljf = a(paramInt);
    if (localljf != null) {
      bool = localljf.a(paramString);
    }
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public void b()
  {
    int i = 0;
    while (i < 14)
    {
      ljf localljf = a(i);
      if (localljf != null) {
        localljf.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lje
 * JD-Core Version:    0.7.0.1
 */