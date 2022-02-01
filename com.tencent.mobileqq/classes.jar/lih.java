import com.tencent.av.app.VideoAppInterface;

public class lih
  extends lgj
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lij jdField_a_of_type_Lij;
  private lii[] jdField_a_of_type_ArrayOfLii = new lii[15];
  
  public lih(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lij = new lij(paramVideoAppInterface);
  }
  
  private lii a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLii[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lii locallii = this.jdField_a_of_type_ArrayOfLii[paramInt];
      localObject1 = locallii;
      if (locallii == null)
      {
        locallii = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallii;
        if (locallii != null)
        {
          this.jdField_a_of_type_ArrayOfLii[paramInt] = locallii;
          localObject1 = locallii;
        }
      }
      return localObject1;
    }
  }
  
  private lii a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Lij;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lii)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lbj.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new lim(paramVideoAppInterface);
      continue;
      localObject = new lik(paramVideoAppInterface);
      continue;
      localObject = new lil(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lii locallii = a(paramInt);
    paramInt = i;
    if (locallii != null) {
      paramInt = locallii.a(paramString);
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
        lii locallii = a(i);
        if (locallii != null) {
          locallii.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lbj.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lii locallii = a(paramInt1);
    if (locallii != null) {
      return locallii.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lii locallii = a(paramInt);
    if (locallii != null) {
      bool = locallii.a(paramString);
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
      lii locallii = a(i);
      if (locallii != null) {
        locallii.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lih
 * JD-Core Version:    0.7.0.1
 */