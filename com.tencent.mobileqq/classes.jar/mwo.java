import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class mwo
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  mwq jdField_a_of_type_Mwq;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mwo(Context paramContext, @NonNull mwq parammwq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mwq = parammwq;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammwq.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mwq parammwq)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammwq.a();
    this.jdField_a_of_type_Mwq = parammwq;
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
        mwr localmwr = (mwr)getItem(i);
        if ((localmwr != null) && (localmwr.jdField_a_of_type_JavaLangString != null) && (localmwr.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mwq != null) {
      return this.jdField_a_of_type_Mwq.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mwq.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (mwr)getItem(paramInt);
    if (paramViewGroup != null) {
      if (paramView == null)
      {
        paramView = new mwp(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.b);
        paramViewGroup = (mwp)paramView;
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
      ((mwp)paramView).a(paramViewGroup.b);
      paramView.setContentDescription(paramViewGroup.b);
      ((mwp)paramView).a(paramViewGroup.jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwo
 * JD-Core Version:    0.7.0.1
 */