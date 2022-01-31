import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class ltj
  extends ltq
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<ltj, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<ltn> jdField_a_of_type_JavaUtilVector;
  private ltl jdField_a_of_type_Ltl;
  private boolean jdField_a_of_type_Boolean;
  
  public ltj(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(ltn paramltn, int paramInt, long paramLong)
  {
    if (a(paramltn, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(ltn paramltn, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramltn);
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
  protected abstract Frame a(List<ltn> paramList, long paramLong);
  
  public ltj a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public ltj a(ltj paramltj, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramltj);
    if (paramInt >= paramltj.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramltj, Integer.valueOf(paramInt)));
    paramltj.a(this.jdField_a_of_type_Ltp);
    return this;
  }
  
  protected abstract void a();
  
  public void a(List<ltn> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    ltn localltn = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((ltn)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        localltn = (ltn)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ltn)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_Ltp.a.a != null) {
        this.jdField_a_of_type_Ltp.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (localltn != null)
      {
        localltn.a();
        return;
        if (localltn == null)
        {
          localltn = ltn.a((Frame)localObject);
          localltn.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((ltn)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((ltn)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          localltn.a(this.jdField_a_of_type_JavaUtilList.size());
          localltn.a();
        }
        localltn.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((ltj)((Pair)localObject).first).a(localltn, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void a(ltp paramltp)
  {
    super.a(paramltp);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_Ltl != null)
      {
        this.jdField_a_of_type_Ltl.a();
        this.jdField_a_of_type_Ltl = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ltj)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_Ltp);
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
      ((ltj)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ltj
 * JD-Core Version:    0.7.0.1
 */