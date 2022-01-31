import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mjr
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfnj<mdz> jdField_a_of_type_Bfnj;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lsf jdField_a_of_type_Lsf;
  private int jdField_b_of_type_Int = 1000;
  private bfnj<mdz> jdField_b_of_type_Bfnj;
  private bfnj<mdz> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mjr.class.getSimpleName();
  }
  
  public mjr(Context paramContext, VideoAppInterface paramVideoAppInterface, lsf paramlsf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lsf = paramlsf;
    this.jdField_a_of_type_Bfnj = new bfnj(15);
    this.jdField_b_of_type_Bfnj = new bfnj(15);
    this.c = new bfnj(15);
  }
  
  private boolean a(ArrayList<mlg> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mlg)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public mdz a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mdz)this.jdField_a_of_type_Bfnj.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mdz)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mdz)this.c.a(i);
          this.jdField_a_of_type_Bfnj.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mdz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mdz)localObject2).h(2130841651);
          ((mdz)localObject2).a(String.valueOf(paramLong), 0);
          ((mdz)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mdz)localObject2).a(true);
          ((mdz)localObject2).e(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mdz)localObject2).c(i);
          ((mdz)localObject2).a(muc.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mdz)localObject2).j(12);
          ((mdz)localObject2).k(-1);
          ((mdz)localObject2).h(true);
          ((mdz)localObject2).a(1);
          this.jdField_a_of_type_Bfnj.a(paramLong, localObject2);
          this.jdField_a_of_type_Lsf.a((lsc)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mdz)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mlg> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bfnj.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bfnj.a(i);
      mdz localmdz = (mdz)this.jdField_a_of_type_Bfnj.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bfnj.a(l, localmdz);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bfnj.a() < 15) {
          this.c.a(l, localmdz);
        } else {
          this.jdField_a_of_type_Lsf.a(localmdz);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bfnj;
    this.jdField_a_of_type_Bfnj = this.jdField_b_of_type_Bfnj;
    this.jdField_b_of_type_Bfnj = paramArrayList;
    this.jdField_b_of_type_Bfnj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjr
 * JD-Core Version:    0.7.0.1
 */