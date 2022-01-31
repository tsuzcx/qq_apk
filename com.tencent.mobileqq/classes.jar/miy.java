import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class miy
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  mja jdField_a_of_type_Mja;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  miy(Context paramContext, @NonNull mja parammja)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mja = parammja;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammja.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mja parammja)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammja.a();
    this.jdField_a_of_type_Mja = parammja;
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
        mjb localmjb = (mjb)getItem(i);
        if ((localmjb != null) && (localmjb.jdField_a_of_type_JavaLangString != null) && (localmjb.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mja != null) {
      return this.jdField_a_of_type_Mja.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mja.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (mjb)getItem(paramInt);
    if (paramViewGroup != null) {
      if (paramView == null)
      {
        paramView = new miz(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.b);
        paramViewGroup = (miz)paramView;
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
      ((miz)paramView).a(paramViewGroup.b);
      paramView.setContentDescription(paramViewGroup.b);
      ((miz)paramView).a(paramViewGroup.jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     miy
 * JD-Core Version:    0.7.0.1
 */