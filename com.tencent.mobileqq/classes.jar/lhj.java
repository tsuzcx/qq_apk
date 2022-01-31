import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lhj
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lhi[] jdField_a_of_type_ArrayOfLhi = new lhi[14];
  
  public lhj(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lhi a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLhi[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lhi locallhi = this.jdField_a_of_type_ArrayOfLhi[paramInt];
      localObject1 = locallhi;
      if (locallhi == null)
      {
        locallhi = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallhi;
        if (locallhi != null)
        {
          this.jdField_a_of_type_ArrayOfLhi[paramInt] = locallhi;
          localObject1 = locallhi;
        }
      }
      return localObject1;
    }
  }
  
  protected lhi a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lcl.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lcl.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new lju(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhu(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new liv(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljb(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lje(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhw(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mpc(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljl(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljk(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhs(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lil(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 14) && (!lhi.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lhi.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
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
        if (this.jdField_a_of_type_ArrayOfLhi[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhj
 * JD-Core Version:    0.7.0.1
 */