import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class lqp
  extends lqw
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<lqp, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<lqt> jdField_a_of_type_JavaUtilVector;
  private lqr jdField_a_of_type_Lqr;
  private boolean jdField_a_of_type_Boolean;
  
  public lqp(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(lqt paramlqt, int paramInt, long paramLong)
  {
    if (a(paramlqt, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(lqt paramlqt, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramlqt);
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
  protected abstract Frame a(List<lqt> paramList, long paramLong);
  
  public lqp a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public lqp a(lqp paramlqp, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlqp);
    if (paramInt >= paramlqp.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramlqp, Integer.valueOf(paramInt)));
    paramlqp.a(this.jdField_a_of_type_Lqv);
    return this;
  }
  
  protected abstract void a();
  
  public void a(List<lqt> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    lqt locallqt = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((lqt)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        locallqt = (lqt)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((lqt)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_Lqv.a.a != null) {
        this.jdField_a_of_type_Lqv.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (locallqt != null)
      {
        locallqt.a();
        return;
        if (locallqt == null)
        {
          locallqt = lqt.a((Frame)localObject);
          locallqt.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((lqt)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((lqt)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          locallqt.a(this.jdField_a_of_type_JavaUtilList.size());
          locallqt.a();
        }
        locallqt.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((lqp)((Pair)localObject).first).a(locallqt, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void a(lqv paramlqv)
  {
    super.a(paramlqv);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_Lqr != null)
      {
        this.jdField_a_of_type_Lqr.a();
        this.jdField_a_of_type_Lqr = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lqp)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_Lqv);
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
      ((lqp)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqp
 * JD-Core Version:    0.7.0.1
 */