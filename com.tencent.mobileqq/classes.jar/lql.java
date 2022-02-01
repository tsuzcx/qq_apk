import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class lql
  extends lqs
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<lql, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<lqp> jdField_a_of_type_JavaUtilVector;
  private lqn jdField_a_of_type_Lqn;
  private boolean jdField_a_of_type_Boolean;
  
  public lql(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(lqp paramlqp, int paramInt, long paramLong)
  {
    if (a(paramlqp, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(lqp paramlqp, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramlqp);
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if (this.jdField_a_of_type_JavaUtilVector.get(paramInt) == null) {
        return false;
      }
      paramInt += 1;
    }
    return true;
  }
  
  @NotNull
  protected abstract Frame a(List<lqp> paramList, long paramLong);
  
  public lql a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public lql a(lql paramlql, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlql);
    if (paramInt >= paramlql.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramlql, Integer.valueOf(paramInt)));
    paramlql.a(this.jdField_a_of_type_Lqr);
    return this;
  }
  
  protected abstract void a();
  
  public void a(List<lqp> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    lqp locallqp = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((lqp)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        locallqp = (lqp)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((lqp)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_Lqr.a.a != null) {
        this.jdField_a_of_type_Lqr.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (locallqp != null)
      {
        locallqp.a();
        return;
        if (locallqp == null)
        {
          locallqp = lqp.a((Frame)localObject);
          locallqp.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((lqp)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((lqp)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          locallqp.a(this.jdField_a_of_type_JavaUtilList.size());
          locallqp.a();
        }
        locallqp.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((lql)((Pair)localObject).first).a(locallqp, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void a(lqr paramlqr)
  {
    super.a(paramlqr);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_Lqn != null)
      {
        this.jdField_a_of_type_Lqn.a();
        this.jdField_a_of_type_Lqn = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lql)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_Lqr);
      i += 1;
    }
  }
  
  protected abstract void b();
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "destroy: ");
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((lql)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lql
 * JD-Core Version:    0.7.0.1
 */