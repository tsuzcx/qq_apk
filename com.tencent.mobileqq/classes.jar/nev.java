import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class nev
  extends RecyclerView.Adapter<new<? extends nel>>
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private List<new> jdField_a_of_type_JavaUtilList = new ArrayList();
  private nem jdField_a_of_type_Nem;
  private nex jdField_a_of_type_Nex;
  private nfa jdField_a_of_type_Nfa;
  private HashMap<Integer, ney> jdField_b_of_type_JavaUtilHashMap;
  private boolean jdField_b_of_type_Boolean;
  private HashMap<Integer, Class<? extends new<? extends nel>>> c;
  private HashMap<Integer, nez<?>> d;
  
  static
  {
    if (!nev.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public nev()
  {
    this(false);
  }
  
  public nev(nfa paramnfa)
  {
    this(paramnfa, false);
  }
  
  public nev(nfa paramnfa, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Nfa = paramnfa;
    this.jdField_a_of_type_Nex = new nex();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.c = new HashMap();
    this.d = new HashMap();
  }
  
  public nev(boolean paramBoolean)
  {
    this(null, false);
  }
  
  @NonNull
  public new<? extends nel> a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = (Class)this.c.get(Integer.valueOf(paramInt));
      if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
        throw new AssertionError("ViewHolder未被注册");
      }
      paramViewGroup = this.jdField_a_of_type_Nex.a(paramInt, paramViewGroup, (Class)localObject);
    }
    for (;;)
    {
      paramViewGroup.a((ney)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
      this.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
      return paramViewGroup;
      localObject = (nez)this.d.get(Integer.valueOf(paramInt));
      if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
        throw new AssertionError("ViewHolderFactory未注册");
      }
      paramViewGroup = ((nez)localObject).a(this.jdField_a_of_type_Nfa, paramInt, paramViewGroup);
      if ((!jdField_a_of_type_Boolean) && (paramViewGroup == null)) {
        throw new AssertionError();
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((new)localIterator.next()).a();
    }
    if (this.jdField_a_of_type_Nfa != null) {
      this.jdField_a_of_type_Nfa.a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, ney paramney)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramney);
  }
  
  public void a(@NonNull String paramString, int paramInt, @NonNull nez<?> paramnez)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
    this.d.put(Integer.valueOf(paramInt), paramnez);
  }
  
  public void a(nem paramnem)
  {
    this.jdField_a_of_type_Nem = paramnem;
  }
  
  public void a(@NonNull new<? extends nel> paramnew, int paramInt)
  {
    if (this.jdField_a_of_type_Nem != null) {
      paramnew.b(this.jdField_a_of_type_Nfa, this.jdField_a_of_type_Nem.b(paramInt), paramInt);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Nem != null) {
      return this.jdField_a_of_type_Nem.a();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Nem != null)
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Nem.a(paramInt));
      if (localInteger != null) {
        return localInteger.intValue();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nev
 * JD-Core Version:    0.7.0.1
 */