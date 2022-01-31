import com.tencent.av.app.VideoAppInterface;

public class kyo
  extends kwt
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private kyq jdField_a_of_type_Kyq;
  private kyp[] jdField_a_of_type_ArrayOfKyp = new kyp[13];
  
  public kyo(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Kyq = new kyq(paramVideoAppInterface);
  }
  
  private kyp a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfKyp[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      kyp localkyp = this.jdField_a_of_type_ArrayOfKyp[paramInt];
      localObject1 = localkyp;
      if (localkyp == null)
      {
        localkyp = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localkyp;
        if (localkyp != null)
        {
          this.jdField_a_of_type_ArrayOfKyp[paramInt] = localkyp;
          localObject1 = localkyp;
        }
      }
      return localObject1;
    }
  }
  
  private kyp a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Kyq;
    }
    for (;;)
    {
      if (localObject != null) {
        ((kyp)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      krx.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new kyt(paramVideoAppInterface);
      continue;
      localObject = new kyr(paramVideoAppInterface);
      continue;
      localObject = new kys(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    kyp localkyp = a(paramInt);
    paramInt = i;
    if (localkyp != null) {
      paramInt = localkyp.a(paramString);
    }
    return paramInt;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 13)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        kyp localkyp = a(i);
        if (localkyp != null) {
          localkyp.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    krx.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    kyp localkyp = a(paramInt1);
    if (localkyp != null) {
      return localkyp.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    kyp localkyp = a(paramInt);
    if (localkyp != null) {
      bool = localkyp.a(paramString);
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
    while (i < 13)
    {
      kyp localkyp = a(i);
      if (localkyp != null) {
        localkyp.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyo
 * JD-Core Version:    0.7.0.1
 */