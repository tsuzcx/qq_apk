import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class niw
  implements njj
{
  protected nio a;
  protected njk a;
  
  public niw(njk paramnjk)
  {
    this.jdField_a_of_type_Njk = paramnjk;
  }
  
  public int a()
  {
    return nfc.a().a().jdField_a_of_type_Int;
  }
  
  public List<nga> a()
  {
    return nfc.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    nfv localnfv = nfc.a().a();
    nfc.a().a(localnfv.a(), nfc.a().a().getAccount(), 0, 3);
  }
  
  public void a(nfv paramnfv)
  {
    this.jdField_a_of_type_Njk.a(paramnfv);
  }
  
  public void a(nga paramnga, int paramInt)
  {
    if (paramnga != null)
    {
      nfc.a().b(paramnga.jdField_a_of_type_Int);
      bdla.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", paramnga.jdField_a_of_type_Int, 0, "", "" + nfc.a().a().a().players.size(), "", "");
    }
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nio = paramnio;
  }
  
  public boolean a()
  {
    return nfc.a().a();
  }
  
  public void b()
  {
    nfv localnfv = nfc.a().a();
    nfc.a().a(localnfv.a(), nfc.a().a().getAccount(), 1, 3);
  }
  
  public void b(nga paramnga, int paramInt)
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_Nio.c();
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
        if ((i != 0) || (paramnga == null)) {
          break;
        }
        Object localObject2 = nfc.a().a();
        localObject1 = ((nfv)localObject2).a(paramnga.jdField_a_of_type_Int);
        String str = ((nfv)localObject2).jdField_a_of_type_JavaLangString;
        localObject2 = ((nfv)localObject2).b;
        if ((localObject1 == null) || (((ngb)localObject1).a == null) || (((ngb)localObject1).a.size() <= 0) || (str == null) || (localObject2 == null)) {
          break label206;
        }
        noq.a(this.jdField_a_of_type_Njk.a(), paramnga.jdField_a_of_type_Int, ((ngb)localObject1).a, str, (String)localObject2);
        return;
      }
      paramInt += 1;
    }
    label206:
    nfc.a().a(paramnga.jdField_a_of_type_Int, null);
  }
  
  public void c()
  {
    nfc.a().e();
  }
  
  public void d()
  {
    nfc.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */