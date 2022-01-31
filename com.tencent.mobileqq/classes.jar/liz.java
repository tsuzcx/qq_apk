import com.tencent.av.app.VideoAppInterface;

public class liz
  extends lhd
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ljb jdField_a_of_type_Ljb;
  private lja[] jdField_a_of_type_ArrayOfLja = new lja[14];
  
  public liz(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Ljb = new ljb(paramVideoAppInterface);
  }
  
  private lja a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLja[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lja locallja = this.jdField_a_of_type_ArrayOfLja[paramInt];
      localObject1 = locallja;
      if (locallja == null)
      {
        locallja = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallja;
        if (locallja != null)
        {
          this.jdField_a_of_type_ArrayOfLja[paramInt] = locallja;
          localObject1 = locallja;
        }
      }
      return localObject1;
    }
  }
  
  private lja a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Ljb;
    }
    for (;;)
    {
      if (localObject != null) {
        ((lja)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      lcg.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new lje(paramVideoAppInterface);
      continue;
      localObject = new ljc(paramVideoAppInterface);
      continue;
      localObject = new ljd(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    lja locallja = a(paramInt);
    paramInt = i;
    if (locallja != null) {
      paramInt = locallja.a(paramString);
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
        lja locallja = a(i);
        if (locallja != null) {
          locallja.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    lcg.c("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
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
    lja locallja = a(paramInt1);
    if (locallja != null) {
      return locallja.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    lja locallja = a(paramInt);
    if (locallja != null) {
      bool = locallja.a(paramString);
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
      lja locallja = a(i);
      if (locallja != null) {
        locallja.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     liz
 * JD-Core Version:    0.7.0.1
 */