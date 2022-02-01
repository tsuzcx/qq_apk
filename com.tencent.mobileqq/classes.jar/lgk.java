import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lgk
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lgj[] jdField_a_of_type_ArrayOfLgj = new lgj[15];
  
  public lgk(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public lgj a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfLgj[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      lgj locallgj = this.jdField_a_of_type_ArrayOfLgj[paramInt];
      localObject1 = locallgj;
      if (locallgj == null)
      {
        locallgj = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = locallgj;
        if (locallgj != null)
        {
          this.jdField_a_of_type_ArrayOfLgj[paramInt] = locallgj;
          localObject1 = locallgj;
        }
      }
      return localObject1;
    }
  }
  
  protected lgj a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      lbj.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      lbj.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new lix(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgv(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhx(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lie(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lih(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgx(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mpv(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lio(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lin(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgt(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhm(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lhz(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (!lgj.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      lgj.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
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
        if (this.jdField_a_of_type_ArrayOfLgj[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgk
 * JD-Core Version:    0.7.0.1
 */