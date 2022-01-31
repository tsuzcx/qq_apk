import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mml
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhsk<mgp> jdField_a_of_type_Bhsk;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lum jdField_a_of_type_Lum;
  private int jdField_b_of_type_Int = 1000;
  private bhsk<mgp> jdField_b_of_type_Bhsk;
  private bhsk<mgp> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mml.class.getSimpleName();
  }
  
  public mml(Context paramContext, VideoAppInterface paramVideoAppInterface, lum paramlum)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lum = paramlum;
    this.jdField_a_of_type_Bhsk = new bhsk(15);
    this.jdField_b_of_type_Bhsk = new bhsk(15);
    this.c = new bhsk(15);
  }
  
  private boolean a(ArrayList<moa> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((moa)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public mgp a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mgp)this.jdField_a_of_type_Bhsk.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mgp)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mgp)this.c.a(i);
          this.jdField_a_of_type_Bhsk.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mgp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mgp)localObject2).a(2130841809, 2130841808);
          ((mgp)localObject2).a(String.valueOf(paramLong), 0);
          ((mgp)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mgp)localObject2).a(true);
          ((mgp)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mgp)localObject2).c(i);
          ((mgp)localObject2).a(mww.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mgp)localObject2).j(12);
          ((mgp)localObject2).k(-1);
          ((mgp)localObject2).g(true);
          ((mgp)localObject2).a(1);
          this.jdField_a_of_type_Bhsk.a(paramLong, localObject2);
          this.jdField_a_of_type_Lum.a((luj)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mgp)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<moa> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bhsk.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bhsk.a(i);
      mgp localmgp = (mgp)this.jdField_a_of_type_Bhsk.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bhsk.a(l, localmgp);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bhsk.a() < 15) {
          this.c.a(l, localmgp);
        } else {
          this.jdField_a_of_type_Lum.a(localmgp);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bhsk;
    this.jdField_a_of_type_Bhsk = this.jdField_b_of_type_Bhsk;
    this.jdField_b_of_type_Bhsk = paramArrayList;
    this.jdField_b_of_type_Bhsk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mml
 * JD-Core Version:    0.7.0.1
 */