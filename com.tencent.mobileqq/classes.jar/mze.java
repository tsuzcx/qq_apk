import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class mze
  extends mzh
{
  static
  {
    if (!mze.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public <VH extends mzg<?>> VH a(int paramInt, @NonNull ViewGroup paramViewGroup, @NonNull Class<VH> paramClass)
  {
    paramClass = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    paramViewGroup = null;
    switch (paramInt)
    {
    }
    while ((!a) && (paramViewGroup == null))
    {
      throw new AssertionError("ViewHolder null");
      paramViewGroup = new mza(paramClass);
      continue;
      paramViewGroup = new mzb(paramClass);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mze
 * JD-Core Version:    0.7.0.1
 */