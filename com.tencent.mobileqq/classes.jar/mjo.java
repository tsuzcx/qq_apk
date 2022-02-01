import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mjo
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkfu<mdt> jdField_a_of_type_Bkfu;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lro jdField_a_of_type_Lro;
  private int jdField_b_of_type_Int = 1000;
  private bkfu<mdt> jdField_b_of_type_Bkfu;
  private bkfu<mdt> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mjo.class.getSimpleName();
  }
  
  public mjo(Context paramContext, VideoAppInterface paramVideoAppInterface, lro paramlro)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lro = paramlro;
    this.jdField_a_of_type_Bkfu = new bkfu(15);
    this.jdField_b_of_type_Bkfu = new bkfu(15);
    this.c = new bkfu(15);
  }
  
  private boolean a(ArrayList<mld> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((mld)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public mdt a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mdt)this.jdField_a_of_type_Bkfu.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mdt)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mdt)this.c.a(i);
          this.jdField_a_of_type_Bkfu.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mdt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mdt)localObject2).a(2130842116, 2130842115);
          ((mdt)localObject2).a(String.valueOf(paramLong), 0);
          ((mdt)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mdt)localObject2).a(true);
          ((mdt)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mdt)localObject2).c(i);
          ((mdt)localObject2).a(mue.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mdt)localObject2).j(12);
          ((mdt)localObject2).k(-1);
          ((mdt)localObject2).g(true);
          ((mdt)localObject2).a(1);
          this.jdField_a_of_type_Bkfu.a(paramLong, localObject2);
          this.jdField_a_of_type_Lro.a((lrl)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mdt)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mld> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bkfu.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bkfu.a(i);
      mdt localmdt = (mdt)this.jdField_a_of_type_Bkfu.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bkfu.a(l, localmdt);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bkfu.a() < 15) {
          this.c.a(l, localmdt);
        } else {
          this.jdField_a_of_type_Lro.a(localmdt);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bkfu;
    this.jdField_a_of_type_Bkfu = this.jdField_b_of_type_Bkfu;
    this.jdField_b_of_type_Bkfu = paramArrayList;
    this.jdField_b_of_type_Bkfu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjo
 * JD-Core Version:    0.7.0.1
 */