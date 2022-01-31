import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class mtu
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  mtw jdField_a_of_type_Mtw;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mtu(Context paramContext, @NonNull mtw parammtw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mtw = parammtw;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammtw.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mtw parammtw)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammtw.a();
    this.jdField_a_of_type_Mtw = parammtw;
    notifyDataSetInvalidated();
  }
  
  public void a(String paramString)
  {
    int j = getCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        mtx localmtx = (mtx)getItem(i);
        if ((localmtx != null) && (localmtx.jdField_a_of_type_JavaLangString != null) && (localmtx.jdField_a_of_type_JavaLangString.equals(paramString))) {
          a(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Mtw != null) {
      return this.jdField_a_of_type_Mtw.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mtw.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (mtx)getItem(paramInt);
    if (paramViewGroup != null) {
      if (paramView == null)
      {
        paramView = new mtv(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.b);
        paramViewGroup = (mtv)paramView;
        if (paramInt != this.jdField_a_of_type_Int) {
          break label94;
        }
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.a(bool);
      return paramView;
      ((mtv)paramView).a(paramViewGroup.b);
      paramView.setContentDescription(paramViewGroup.b);
      ((mtv)paramView).a(paramViewGroup.jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtu
 * JD-Core Version:    0.7.0.1
 */