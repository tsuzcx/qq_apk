import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.HashMap;

public class mzf
  extends RecyclerView.Adapter<mzg<? extends myy>>
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private myz jdField_a_of_type_Myz;
  private mzh jdField_a_of_type_Mzh;
  private mzj jdField_a_of_type_Mzj;
  private HashMap<Integer, mzi> b;
  private HashMap<Integer, Class<? extends mzg<? extends myy>>> c;
  
  static
  {
    if (!mzf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public mzf()
  {
    this(null);
  }
  
  public mzf(mzj parammzj)
  {
    this.jdField_a_of_type_Mzj = parammzj;
    this.jdField_a_of_type_Mzh = new mzh();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
  }
  
  @NonNull
  public mzg<? extends myy> a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    Class localClass = (Class)this.c.get(Integer.valueOf(paramInt));
    if ((!jdField_a_of_type_Boolean) && (localClass == null)) {
      throw new AssertionError("ViewHolder未被注册");
    }
    paramViewGroup = this.jdField_a_of_type_Mzh.a(paramInt, paramViewGroup, localClass);
    paramViewGroup.a((mzi)this.b.get(Integer.valueOf(paramInt)));
    return paramViewGroup;
  }
  
  public void a(int paramInt, mzi parammzi)
  {
    this.b.put(Integer.valueOf(paramInt), parammzi);
  }
  
  public void a(@NonNull String paramString, int paramInt, @NonNull Class<? extends mzg<? extends myy>> paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
    this.c.put(Integer.valueOf(paramInt), paramClass);
  }
  
  public void a(myz parammyz)
  {
    this.jdField_a_of_type_Myz = parammyz;
  }
  
  public void a(@NonNull mzg<? extends myy> parammzg, int paramInt)
  {
    if (this.jdField_a_of_type_Myz != null) {
      parammzg.b(this.jdField_a_of_type_Mzj, this.jdField_a_of_type_Myz.b(paramInt), paramInt);
    }
  }
  
  public void a(mzh parammzh)
  {
    if (parammzh != null) {
      this.jdField_a_of_type_Mzh = parammzh;
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Myz != null) {
      return this.jdField_a_of_type_Myz.a();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Myz != null)
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Myz.a(paramInt));
      if (localInteger != null) {
        return localInteger.intValue();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzf
 * JD-Core Version:    0.7.0.1
 */