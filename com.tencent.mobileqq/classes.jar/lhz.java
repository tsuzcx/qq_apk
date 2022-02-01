import com.tencent.av.app.VideoAppInterface;

public class lhz
  extends lgb
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lib jdField_a_of_type_Lib;
  private lia[] jdField_a_of_type_ArrayOfLia = new lia[15];
  
  public lhz(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lib = new lib(paramVideoAppInterface);
  }
  
  private lia a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLia[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lia locallia = this.jdField_a_of_type_ArrayOfLia[paramInt];
      localObject1 = locallia;
      if (locallia == null)
      {
        locallia = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallia;
        if (locallia != null)
        {
          this.jdField_a_of_type_ArrayOfLia[paramInt] = locallia;
          localObject1 = locallia;
        }
      }
      return localObject1;
    }
  }
  
  private lia a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Lib;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lia)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lbc.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new lie(paramVideoAppInterface);
      continue;
      localObject = new lic(paramVideoAppInterface);
      continue;
      localObject = new lid(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lia locallia = a(paramInt);
    paramInt = i;
    if (locallia != null) {
      paramInt = locallia.a(paramString);
    }
    return paramInt;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 15)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        lia locallia = a(i);
        if (locallia != null) {
          locallia.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lbc.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lia locallia = a(paramInt1);
    if (locallia != null) {
      return locallia.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lia locallia = a(paramInt);
    if (locallia != null) {
      bool = locallia.a(paramString);
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
    while (i < 15)
    {
      lia locallia = a(i);
      if (locallia != null) {
        locallia.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhz
 * JD-Core Version:    0.7.0.1
 */