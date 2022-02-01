import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mkq
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkyb<meu> jdField_a_of_type_Bkyb;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lsf jdField_a_of_type_Lsf;
  private int jdField_b_of_type_Int = 1000;
  private bkyb<meu> jdField_b_of_type_Bkyb;
  private bkyb<meu> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mkq.class.getSimpleName();
  }
  
  public mkq(Context paramContext, VideoAppInterface paramVideoAppInterface, lsf paramlsf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lsf = paramlsf;
    this.jdField_a_of_type_Bkyb = new bkyb(15);
    this.jdField_b_of_type_Bkyb = new bkyb(15);
    this.c = new bkyb(15);
  }
  
  private boolean a(ArrayList<mmg> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mmg)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public meu a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (meu)this.jdField_a_of_type_Bkyb.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (meu)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (meu)this.c.a(i);
          this.jdField_a_of_type_Bkyb.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new meu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((meu)localObject2).b(2130842184, 2130842183);
          ((meu)localObject2).a(String.valueOf(paramLong), 0);
          ((meu)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((meu)localObject2).a(true);
          ((meu)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((meu)localObject2).c(i);
          ((meu)localObject2).a(mvk.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((meu)localObject2).j(12);
          ((meu)localObject2).k(-1);
          ((meu)localObject2).h(true);
          ((meu)localObject2).a(1);
          this.jdField_a_of_type_Bkyb.a(paramLong, localObject2);
          this.jdField_a_of_type_Lsf.a((lsc)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((meu)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mmg> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bkyb.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bkyb.a(i);
      meu localmeu = (meu)this.jdField_a_of_type_Bkyb.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bkyb.a(l, localmeu);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bkyb.a() < 15) {
          this.c.a(l, localmeu);
        } else {
          this.jdField_a_of_type_Lsf.a(localmeu);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bkyb;
    this.jdField_a_of_type_Bkyb = this.jdField_b_of_type_Bkyb;
    this.jdField_b_of_type_Bkyb = paramArrayList;
    this.jdField_b_of_type_Bkyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mkq
 * JD-Core Version:    0.7.0.1
 */