import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lhe
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lhd[] jdField_a_of_type_ArrayOfLhd = new lhd[14];
  
  public lhe(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lhd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLhd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lhd locallhd = this.jdField_a_of_type_ArrayOfLhd[paramInt];
      localObject1 = locallhd;
      if (locallhd == null)
      {
        locallhd = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallhd;
        if (locallhd != null)
        {
          this.jdField_a_of_type_ArrayOfLhd[paramInt] = locallhd;
          localObject1 = locallhd;
        }
      }
      return localObject1;
    }
  }
  
  protected lhd a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lcg.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lcg.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new ljp(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhp(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new liq(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new liw(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new liz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhr(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new moz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljg(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ljf(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhn(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lig(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 14) && (!lhd.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lhd.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
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
        if (this.jdField_a_of_type_ArrayOfLhd[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhe
 * JD-Core Version:    0.7.0.1
 */