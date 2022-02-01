import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public abstract class nez<VH extends new<? extends nel>>
{
  public VH a(nfa paramnfa, int paramInt, @NonNull ViewGroup paramViewGroup)
  {
    return a(paramnfa, LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public VH a(nfa paramnfa, View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nez
 * JD-Core Version:    0.7.0.1
 */