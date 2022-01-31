import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mju
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfms<mee> jdField_a_of_type_Bfms;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lsk jdField_a_of_type_Lsk;
  private int jdField_b_of_type_Int = 1000;
  private bfms<mee> jdField_b_of_type_Bfms;
  private bfms<mee> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mju.class.getSimpleName();
  }
  
  public mju(Context paramContext, VideoAppInterface paramVideoAppInterface, lsk paramlsk)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lsk = paramlsk;
    this.jdField_a_of_type_Bfms = new bfms(15);
    this.jdField_b_of_type_Bfms = new bfms(15);
    this.c = new bfms(15);
  }
  
  private boolean a(ArrayList<mlj> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mlj)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public mee a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mee)this.jdField_a_of_type_Bfms.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mee)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mee)this.c.a(i);
          this.jdField_a_of_type_Bfms.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mee(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mee)localObject2).h(2130841651);
          ((mee)localObject2).a(String.valueOf(paramLong), 0);
          ((mee)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mee)localObject2).a(true);
          ((mee)localObject2).e(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mee)localObject2).c(i);
          ((mee)localObject2).a(muf.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mee)localObject2).j(12);
          ((mee)localObject2).k(-1);
          ((mee)localObject2).h(true);
          ((mee)localObject2).a(1);
          this.jdField_a_of_type_Bfms.a(paramLong, localObject2);
          this.jdField_a_of_type_Lsk.a((lsh)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mee)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mlj> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bfms.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bfms.a(i);
      mee localmee = (mee)this.jdField_a_of_type_Bfms.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bfms.a(l, localmee);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bfms.a() < 15) {
          this.c.a(l, localmee);
        } else {
          this.jdField_a_of_type_Lsk.a(localmee);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bfms;
    this.jdField_a_of_type_Bfms = this.jdField_b_of_type_Bfms;
    this.jdField_b_of_type_Bfms = paramArrayList;
    this.jdField_b_of_type_Bfms.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */