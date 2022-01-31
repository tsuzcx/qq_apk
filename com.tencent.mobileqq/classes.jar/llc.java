import com.tencent.av.app.VideoAppInterface;

public class llc
  extends ljg
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lle jdField_a_of_type_Lle;
  private lld[] jdField_a_of_type_ArrayOfLld = new lld[14];
  
  public llc(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lle = new lle(paramVideoAppInterface);
  }
  
  private lld a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLld[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lld locallld = this.jdField_a_of_type_ArrayOfLld[paramInt];
      localObject1 = locallld;
      if (locallld == null)
      {
        locallld = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallld;
        if (locallld != null)
        {
          this.jdField_a_of_type_ArrayOfLld[paramInt] = locallld;
          localObject1 = locallld;
        }
      }
      return localObject1;
    }
  }
  
  private lld a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Lle;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lld)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lek.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new llh(paramVideoAppInterface);
      continue;
      localObject = new llf(paramVideoAppInterface);
      continue;
      localObject = new llg(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lld locallld = a(paramInt);
    paramInt = i;
    if (locallld != null) {
      paramInt = locallld.a(paramString);
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
        lld locallld = a(i);
        if (locallld != null) {
          locallld.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lek.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lld locallld = a(paramInt1);
    if (locallld != null) {
      return locallld.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lld locallld = a(paramInt);
    if (locallld != null) {
      bool = locallld.a(paramString);
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
      lld locallld = a(i);
      if (locallld != null) {
        locallld.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     llc
 * JD-Core Version:    0.7.0.1
 */