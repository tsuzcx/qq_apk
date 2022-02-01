import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ncy
  implements ndl
{
  protected ncq a;
  protected ndm a;
  
  public ncy(ndm paramndm)
  {
    this.jdField_a_of_type_Ndm = paramndm;
  }
  
  public int a()
  {
    return mzl.a().a().jdField_a_of_type_Int;
  }
  
  public List<nak> a()
  {
    return mzl.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    naf localnaf = mzl.a().a();
    mzl.a().a(localnaf.a(), mzl.a().a().getAccount(), 0, 3);
  }
  
  public void a(naf paramnaf)
  {
    this.jdField_a_of_type_Ndm.a(paramnaf);
  }
  
  public void a(nak paramnak, int paramInt)
  {
    if (paramnak != null)
    {
      mzl.a().b(paramnak.jdField_a_of_type_Int);
      bcef.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", paramnak.jdField_a_of_type_Int, 0, "", "" + mzl.a().a().a().players.size(), "", "");
    }
  }
  
  public void a(ncq paramncq)
  {
    this.jdField_a_of_type_Ncq = paramncq;
  }
  
  public boolean a()
  {
    return mzl.a().a();
  }
  
  public void b()
  {
    naf localnaf = mzl.a().a();
    mzl.a().a(localnaf.a(), mzl.a().a().getAccount(), 1, 3);
  }
  
  public void b(nak paramnak, int paramInt)
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_Ncq.c();
    QLog.i("GameListPresenterImp", 1, "clickBeginGame players:" + localObject1);
    if (((List)localObject1).size() <= 1) {
      return;
    }
    paramInt = 0;
    for (;;)
    {
      int i = j;
      if (paramInt < ((List)localObject1).size())
      {
        if ((((List)localObject1).get(paramInt) != null) && (((Player)((List)localObject1).get(paramInt)).status == 0)) {
          i = 1;
        }
      }
      else
      {
        if ((i != 0) || (paramnak == null)) {
          break;
        }
        Object localObject2 = mzl.a().a();
        localObject1 = ((naf)localObject2).a(paramnak.jdField_a_of_type_Int);
        String str = ((naf)localObject2).jdField_a_of_type_JavaLangString;
        localObject2 = ((naf)localObject2).b;
        if ((localObject1 == null) || (((nal)localObject1).a == null) || (((nal)localObject1).a.size() <= 0) || (str == null) || (localObject2 == null)) {
          break label206;
        }
        nhx.a(this.jdField_a_of_type_Ndm.a(), paramnak.jdField_a_of_type_Int, ((nal)localObject1).a, str, (String)localObject2);
        return;
      }
      paramInt += 1;
    }
    label206:
    mzl.a().a(paramnak.jdField_a_of_type_Int, null);
  }
  
  public void c()
  {
    mzl.a().e();
  }
  
  public void d()
  {
    mzl.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncy
 * JD-Core Version:    0.7.0.1
 */