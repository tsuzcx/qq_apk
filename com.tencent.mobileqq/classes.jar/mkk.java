import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mkk
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private blgz<mep> jdField_a_of_type_Blgz;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lsk jdField_a_of_type_Lsk;
  private int jdField_b_of_type_Int = 1000;
  private blgz<mep> jdField_b_of_type_Blgz;
  private blgz<mep> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mkk.class.getSimpleName();
  }
  
  public mkk(Context paramContext, VideoAppInterface paramVideoAppInterface, lsk paramlsk)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lsk = paramlsk;
    this.jdField_a_of_type_Blgz = new blgz(15);
    this.jdField_b_of_type_Blgz = new blgz(15);
    this.c = new blgz(15);
  }
  
  private boolean a(ArrayList<mma> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mma)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public mep a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mep)this.jdField_a_of_type_Blgz.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mep)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mep)this.c.a(i);
          this.jdField_a_of_type_Blgz.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mep(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mep)localObject2).a(2130842128, 2130842127);
          ((mep)localObject2).a(String.valueOf(paramLong), 0);
          ((mep)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mep)localObject2).a(true);
          ((mep)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mep)localObject2).c(i);
          ((mep)localObject2).a(mvd.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mep)localObject2).j(12);
          ((mep)localObject2).k(-1);
          ((mep)localObject2).g(true);
          ((mep)localObject2).a(1);
          this.jdField_a_of_type_Blgz.a(paramLong, localObject2);
          this.jdField_a_of_type_Lsk.a((lsh)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mep)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mma> paramArrayList)
  {
    int j = this.jdField_a_of_type_Blgz.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Blgz.a(i);
      mep localmep = (mep)this.jdField_a_of_type_Blgz.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Blgz.a(l, localmep);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Blgz.a() < 15) {
          this.c.a(l, localmep);
        } else {
          this.jdField_a_of_type_Lsk.a(localmep);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Blgz;
    this.jdField_a_of_type_Blgz = this.jdField_b_of_type_Blgz;
    this.jdField_b_of_type_Blgz = paramArrayList;
    this.jdField_b_of_type_Blgz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkk
 * JD-Core Version:    0.7.0.1
 */