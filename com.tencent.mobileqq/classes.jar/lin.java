import com.tencent.av.app.VideoAppInterface;

public class lin
  extends lgp
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lip jdField_a_of_type_Lip;
  private lio[] jdField_a_of_type_ArrayOfLio = new lio[16];
  
  public lin(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lip = new lip(paramVideoAppInterface);
  }
  
  private lio a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLio[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lio locallio = this.jdField_a_of_type_ArrayOfLio[paramInt];
      localObject1 = locallio;
      if (locallio == null)
      {
        locallio = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallio;
        if (locallio != null)
        {
          this.jdField_a_of_type_ArrayOfLio[paramInt] = locallio;
          localObject1 = locallio;
        }
      }
      return localObject1;
    }
  }
  
  private lio a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Lip;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lio)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lbd.f("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new lis(paramVideoAppInterface);
      continue;
      localObject = new liq(paramVideoAppInterface);
      continue;
      localObject = new lir(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lio locallio = a(paramInt);
    paramInt = i;
    if (locallio != null) {
      paramInt = locallio.a(paramString);
    }
    return paramInt;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 16)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        lio locallio = a(i);
        if (locallio != null) {
          locallio.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lbd.f("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lio locallio = a(paramInt1);
    if (locallio != null) {
      return locallio.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lio locallio = a(paramInt);
    if (locallio != null) {
      bool = locallio.a(paramString);
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
    while (i < 16)
    {
      lio locallio = a(i);
      if (locallio != null) {
        locallio.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lin
 * JD-Core Version:    0.7.0.1
 */