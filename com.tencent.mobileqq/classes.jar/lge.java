import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lge
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lgd[] jdField_a_of_type_ArrayOfLgd = new lgd[15];
  
  public lge(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lgd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLgd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lgd locallgd = this.jdField_a_of_type_ArrayOfLgd[paramInt];
      localObject1 = locallgd;
      if (locallgd == null)
      {
        locallgd = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallgd;
        if (locallgd != null)
        {
          this.jdField_a_of_type_ArrayOfLgd[paramInt] = locallgd;
          localObject1 = locallgd;
        }
      }
      return localObject1;
    }
  }
  
  protected lgd a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lba.f("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lba.f("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new lir(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgp(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhr(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhy(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lib(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgr(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mpe(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lii(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lih(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgn(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhg(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lht(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (!lgd.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lgd.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 15)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfLgd[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lge
 * JD-Core Version:    0.7.0.1
 */