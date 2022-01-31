import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class lzd
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private beey<ltl> jdField_a_of_type_Beey;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lht jdField_a_of_type_Lht;
  private int jdField_b_of_type_Int = 1000;
  private beey<ltl> jdField_b_of_type_Beey;
  private beey<ltl> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = lzd.class.getSimpleName();
  }
  
  public lzd(Context paramContext, VideoAppInterface paramVideoAppInterface, lht paramlht)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lht = paramlht;
    this.jdField_a_of_type_Beey = new beey(15);
    this.jdField_b_of_type_Beey = new beey(15);
    this.c = new beey(15);
  }
  
  private boolean a(ArrayList<mas> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mas)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public ltl a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (ltl)this.jdField_a_of_type_Beey.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (ltl)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (ltl)this.c.a(i);
          this.jdField_a_of_type_Beey.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new ltl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0, false);
          ((ltl)localObject2).h(2130841559);
          ((ltl)localObject2).a(String.valueOf(paramLong), 0);
          ((ltl)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((ltl)localObject2).a(true);
          ((ltl)localObject2).e(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((ltl)localObject2).c(i);
          ((ltl)localObject2).a(mjg.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((ltl)localObject2).j(12);
          ((ltl)localObject2).k(-1);
          ((ltl)localObject2).h(true);
          ((ltl)localObject2).a(1);
          this.jdField_a_of_type_Beey.a(paramLong, localObject2);
          this.jdField_a_of_type_Lht.a((lhq)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((ltl)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mas> paramArrayList)
  {
    int j = this.jdField_a_of_type_Beey.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Beey.a(i);
      ltl localltl = (ltl)this.jdField_a_of_type_Beey.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Beey.a(l, localltl);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Beey.a() < 15) {
          this.c.a(l, localltl);
        } else {
          this.jdField_a_of_type_Lht.a(localltl);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Beey;
    this.jdField_a_of_type_Beey = this.jdField_b_of_type_Beey;
    this.jdField_b_of_type_Beey = paramArrayList;
    this.jdField_b_of_type_Beey.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzd
 * JD-Core Version:    0.7.0.1
 */