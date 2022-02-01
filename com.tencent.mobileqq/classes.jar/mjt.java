import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class mjt
{
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private bjmo<mdy> jdField_a_of_type_Bjmo;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lrs jdField_a_of_type_Lrs;
  private int jdField_b_of_type_Int = 1000;
  private bjmo<mdy> jdField_b_of_type_Bjmo;
  private bjmo<mdy> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = mjt.class.getSimpleName();
  }
  
  public mjt(Context paramContext, VideoAppInterface paramVideoAppInterface, lrs paramlrs)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lrs = paramlrs;
    this.jdField_a_of_type_Bjmo = new bjmo(15);
    this.jdField_b_of_type_Bjmo = new bjmo(15);
    this.c = new bjmo(15);
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
  
  public mdy a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (mdy)this.jdField_a_of_type_Bjmo.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (mdy)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (mdy)this.c.a(i);
          this.jdField_a_of_type_Bjmo.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new mdy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((mdy)localObject2).a(2130842170, 2130842169);
          ((mdy)localObject2).a(String.valueOf(paramLong), 0);
          ((mdy)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((mdy)localObject2).a(true);
          ((mdy)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((mdy)localObject2).c(i);
          ((mdy)localObject2).a(mum.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mdy)localObject2).j(12);
          ((mdy)localObject2).k(-1);
          ((mdy)localObject2).g(true);
          ((mdy)localObject2).a(1);
          this.jdField_a_of_type_Bjmo.a(paramLong, localObject2);
          this.jdField_a_of_type_Lrs.a((lrp)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((mdy)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<mlj> paramArrayList)
  {
    int j = this.jdField_a_of_type_Bjmo.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_Bjmo.a(i);
      mdy localmdy = (mdy)this.jdField_a_of_type_Bjmo.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_Bjmo.a(l, localmdy);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_Bjmo.a() < 15) {
          this.c.a(l, localmdy);
        } else {
          this.jdField_a_of_type_Lrs.a(localmdy);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_Bjmo;
    this.jdField_a_of_type_Bjmo = this.jdField_b_of_type_Bjmo;
    this.jdField_b_of_type_Bjmo = paramArrayList;
    this.jdField_b_of_type_Bjmo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjt
 * JD-Core Version:    0.7.0.1
 */