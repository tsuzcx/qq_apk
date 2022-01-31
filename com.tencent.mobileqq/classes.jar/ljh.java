import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class ljh
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ljg[] jdField_a_of_type_ArrayOfLjg = new ljg[14];
  
  public ljh(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public ljg a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLjg[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ljg localljg = this.jdField_a_of_type_ArrayOfLjg[paramInt];
      localObject1 = localljg;
      if (localljg == null)
      {
        localljg = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localljg;
        if (localljg != null)
        {
          this.jdField_a_of_type_ArrayOfLjg[paramInt] = localljg;
          localObject1 = localljg;
        }
      }
      return localObject1;
    }
  }
  
  protected ljg a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lek.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lek.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new lls(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljs(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lkt(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lkz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new llc(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lju(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mrt(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new llj(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lli(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljq(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lkj(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 14) && (!ljg.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      ljg.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 14)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfLjg[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljh
 * JD-Core Version:    0.7.0.1
 */