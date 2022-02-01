import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lgq
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lgp[] jdField_a_of_type_ArrayOfLgp = new lgp[16];
  
  public lgq(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lgp a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLgp[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lgp locallgp = this.jdField_a_of_type_ArrayOfLgp[paramInt];
      localObject1 = locallgp;
      if (locallgp == null)
      {
        locallgp = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallgp;
        if (locallgp != null)
        {
          this.jdField_a_of_type_ArrayOfLgp[paramInt] = locallgp;
          localObject1 = locallgp;
        }
      }
      return localObject1;
    }
  }
  
  protected lgp a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lbd.f("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lbd.f("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new ljd(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhb(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lid(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lik(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lin(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhd(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mqb(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new liu(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lit(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhs(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lif(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mxd(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 16) && (!lgp.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lgp.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 16)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfLgp[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgq
 * JD-Core Version:    0.7.0.1
 */