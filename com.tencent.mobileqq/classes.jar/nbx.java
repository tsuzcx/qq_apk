import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class nbx
  implements ncg
{
  protected nbp a;
  protected nch a;
  
  public nbx(nch paramnch)
  {
    this.jdField_a_of_type_Nch = paramnch;
  }
  
  public int a()
  {
    return myk.a().a().jdField_a_of_type_Int;
  }
  
  public List<mzj> a()
  {
    return myk.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    mze localmze = myk.a().a();
    myk.a().a(localmze.a(), myk.a().a().getAccount(), 0, 3);
  }
  
  public void a(mze parammze)
  {
    this.jdField_a_of_type_Nch.a(parammze);
  }
  
  public void a(mzj parammzj, int paramInt)
  {
    if (parammzj != null)
    {
      myk.a().b(parammzj.jdField_a_of_type_Int);
      bdll.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", parammzj.jdField_a_of_type_Int, 0, "", "" + myk.a().a().a().players.size(), "", "");
    }
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nbp = paramnbp;
  }
  
  public boolean a()
  {
    return myk.a().a();
  }
  
  public void b()
  {
    mze localmze = myk.a().a();
    myk.a().a(localmze.a(), myk.a().a().getAccount(), 1, 3);
  }
  
  public void b(mzj parammzj, int paramInt)
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_Nbp.c();
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
        if ((i != 0) || (parammzj == null)) {
          break;
        }
        Object localObject2 = myk.a().a();
        localObject1 = ((mze)localObject2).a(parammzj.jdField_a_of_type_Int);
        String str = ((mze)localObject2).jdField_a_of_type_JavaLangString;
        localObject2 = ((mze)localObject2).b;
        if ((localObject1 == null) || (((mzk)localObject1).a == null) || (((mzk)localObject1).a.size() <= 0) || (str == null) || (localObject2 == null)) {
          break label206;
        }
        ngq.a(this.jdField_a_of_type_Nch.a(), parammzj.jdField_a_of_type_Int, ((mzk)localObject1).a, str, (String)localObject2);
        return;
      }
      paramInt += 1;
    }
    label206:
    myk.a().a(parammzj.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbx
 * JD-Core Version:    0.7.0.1
 */