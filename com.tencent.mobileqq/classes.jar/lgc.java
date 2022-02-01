import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lgc
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lgb[] jdField_a_of_type_ArrayOfLgb = new lgb[15];
  
  public lgc(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lgb a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLgb[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lgb locallgb = this.jdField_a_of_type_ArrayOfLgb[paramInt];
      localObject1 = locallgb;
      if (locallgb == null)
      {
        locallgb = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallgb;
        if (locallgb != null)
        {
          this.jdField_a_of_type_ArrayOfLgb[paramInt] = locallgb;
          localObject1 = locallgb;
        }
      }
      return localObject1;
    }
  }
  
  protected lgb a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lbc.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lbc.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new lip(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgn(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhp(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhw(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgp(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new moy(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lig(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lif(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgl(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhe(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhr(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (!lgb.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lgb.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
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
        if (this.jdField_a_of_type_ArrayOfLgb[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgc
 * JD-Core Version:    0.7.0.1
 */