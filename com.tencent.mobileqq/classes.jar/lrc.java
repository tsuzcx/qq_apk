import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class lrc
  extends lrj
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<lrc, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<lrg> jdField_a_of_type_JavaUtilVector;
  private lre jdField_a_of_type_Lre;
  private boolean jdField_a_of_type_Boolean;
  
  public lrc(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(lrg paramlrg, int paramInt, long paramLong)
  {
    if (a(paramlrg, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(lrg paramlrg, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramlrg);
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
  protected abstract Frame a(List<lrg> paramList, long paramLong);
  
  public lrc a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public lrc a(lrc paramlrc, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlrc);
    if (paramInt >= paramlrc.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramlrc, Integer.valueOf(paramInt)));
    paramlrc.a(this.jdField_a_of_type_Lri);
    return this;
  }
  
  protected abstract void a();
  
  public void a(List<lrg> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    lrg locallrg = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((lrg)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        locallrg = (lrg)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((lrg)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_Lri.a.a != null) {
        this.jdField_a_of_type_Lri.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (locallrg != null)
      {
        locallrg.a();
        return;
        if (locallrg == null)
        {
          locallrg = lrg.a((Frame)localObject);
          locallrg.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((lrg)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((lrg)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          locallrg.a(this.jdField_a_of_type_JavaUtilList.size());
          locallrg.a();
        }
        locallrg.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((lrc)((Pair)localObject).first).a(locallrg, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  public void a(lri paramlri)
  {
    super.a(paramlri);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_Lre != null)
      {
        this.jdField_a_of_type_Lre.a();
        this.jdField_a_of_type_Lre = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lrc)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_Lri);
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
      ((lrc)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lrc
 * JD-Core Version:    0.7.0.1
 */