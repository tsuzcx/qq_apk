import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class kwu
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private kwt[] jdField_a_of_type_ArrayOfKwt = new kwt[13];
  
  public kwu(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public kwt a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfKwt[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      kwt localkwt = this.jdField_a_of_type_ArrayOfKwt[paramInt];
      localObject1 = localkwt;
      if (localkwt == null)
      {
        localkwt = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localkwt;
        if (localkwt != null)
        {
          this.jdField_a_of_type_ArrayOfKwt[paramInt] = localkwt;
          localObject1 = localkwt;
        }
      }
      return localObject1;
    }
  }
  
  protected kwt a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      krx.c("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      krx.c("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new kze(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kxf(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kyd(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kyl(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kyo(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kxi(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new med(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kyv(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kyu(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new kxd(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 13) && (!kwt.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      kwt.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 13)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfKwt[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kwu
 * JD-Core Version:    0.7.0.1
 */