import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class nas
  implements nat
{
  protected nal a;
  protected nau a;
  
  public nas(nau paramnau)
  {
    this.jdField_a_of_type_Nau = paramnau;
  }
  
  public int a()
  {
    return mxl.a().a().jdField_a_of_type_Int;
  }
  
  public List<myg> a()
  {
    return mxl.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    myc localmyc = mxl.a().a();
    mxl.a().a(localmyc.a(), mxl.a().a().getAccount(), 0, 3);
  }
  
  public void a(myc parammyc)
  {
    this.jdField_a_of_type_Nau.a(parammyc);
  }
  
  public void a(myg parammyg, int paramInt)
  {
    if (parammyg != null)
    {
      mxl.a().b(parammyg.jdField_a_of_type_Int);
      bcst.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", parammyg.jdField_a_of_type_Int, 0, "", "" + mxl.a().a().a().players.size(), "", "");
    }
  }
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_Nal = paramnal;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Nau.a(paramArrayOfInt);
  }
  
  public boolean a()
  {
    return mxl.a().a();
  }
  
  public void b()
  {
    myc localmyc = mxl.a().a();
    mxl.a().a(localmyc.a(), mxl.a().a().getAccount(), 1, 3);
  }
  
  public void b(myg parammyg, int paramInt)
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_Nal.c();
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
        if ((i != 0) || (parammyg == null)) {
          break;
        }
        Object localObject2 = mxl.a().a();
        localObject1 = ((myc)localObject2).a(parammyg.jdField_a_of_type_Int);
        String str = ((myc)localObject2).jdField_a_of_type_JavaLangString;
        localObject2 = ((myc)localObject2).b;
        if ((localObject1 == null) || (((myh)localObject1).a == null) || (((myh)localObject1).a.size() <= 0) || (str == null) || (localObject2 == null)) {
          break label206;
        }
        new.a(this.jdField_a_of_type_Nau.a(), parammyg.jdField_a_of_type_Int, ((myh)localObject1).a, str, (String)localObject2);
        return;
      }
      paramInt += 1;
    }
    label206:
    mxl.a().a(parammyg.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nas
 * JD-Core Version:    0.7.0.1
 */