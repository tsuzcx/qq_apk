import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class lrh
  extends lro
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<lrh, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<lrl> jdField_a_of_type_JavaUtilVector;
  private lrj jdField_a_of_type_Lrj;
  private boolean jdField_a_of_type_Boolean;
  
  public lrh(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(lrl paramlrl, int paramInt, long paramLong)
  {
    if (a(paramlrl, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(lrl paramlrl, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramlrl);
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
  protected abstract Frame a(List<lrl> paramList, long paramLong);
  
  public lrh a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public lrh a(lrh paramlrh, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlrh);
    if (paramInt >= paramlrh.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramlrh, Integer.valueOf(paramInt)));
    paramlrh.a(this.jdField_a_of_type_Lrn);
    return this;
  }
  
  protected abstract void a();
  
  public void a(List<lrl> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    lrl locallrl = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((lrl)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        locallrl = (lrl)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((lrl)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_Lrn.a.a != null) {
        this.jdField_a_of_type_Lrn.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (locallrl != null)
      {
        locallrl.a();
        return;
        if (locallrl == null)
        {
          locallrl = lrl.a((Frame)localObject);
          locallrl.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((lrl)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((lrl)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          locallrl.a(this.jdField_a_of_type_JavaUtilList.size());
          locallrl.a();
        }
        locallrl.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((lrh)((Pair)localObject).first).a(locallrl, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void a(lrn paramlrn)
  {
    super.a(paramlrn);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_Lrj != null)
      {
        this.jdField_a_of_type_Lrj.a();
        this.jdField_a_of_type_Lrj = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lrh)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_Lrn);
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
      ((lrh)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrh
 * JD-Core Version:    0.7.0.1
 */