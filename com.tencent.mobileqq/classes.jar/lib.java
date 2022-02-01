import com.tencent.av.app.VideoAppInterface;

public class lib
  extends lgd
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lid jdField_a_of_type_Lid;
  private lic[] jdField_a_of_type_ArrayOfLic = new lic[15];
  
  public lib(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lid = new lid(paramVideoAppInterface);
  }
  
  private lic a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLic[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lic locallic = this.jdField_a_of_type_ArrayOfLic[paramInt];
      localObject1 = locallic;
      if (locallic == null)
      {
        locallic = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallic;
        if (locallic != null)
        {
          this.jdField_a_of_type_ArrayOfLic[paramInt] = locallic;
          localObject1 = locallic;
        }
      }
      return localObject1;
    }
  }
  
  private lic a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Lid;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lic)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lba.f("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new lig(paramVideoAppInterface);
      continue;
      localObject = new lie(paramVideoAppInterface);
      continue;
      localObject = new lif(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lic locallic = a(paramInt);
    paramInt = i;
    if (locallic != null) {
      paramInt = locallic.a(paramString);
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
        lic locallic = a(i);
        if (locallic != null) {
          locallic.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lba.f("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lic locallic = a(paramInt1);
    if (locallic != null) {
      return locallic.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lic locallic = a(paramInt);
    if (locallic != null) {
      bool = locallic.a(paramString);
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
      lic locallic = a(i);
      if (locallic != null) {
        locallic.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lib
 * JD-Core Version:    0.7.0.1
 */