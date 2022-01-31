import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class mtx
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  mtz jdField_a_of_type_Mtz;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mtx(Context paramContext, @NonNull mtz parammtz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mtz = parammtz;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammtz.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mtz parammtz)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammtz.a();
    this.jdField_a_of_type_Mtz = parammtz;
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
        mua localmua = (mua)getItem(i);
        if ((localmua != null) && (localmua.jdField_a_of_type_JavaLangString != null) && (localmua.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mtz != null) {
      return this.jdField_a_of_type_Mtz.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mtz.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (mua)getItem(paramInt);
    if (paramViewGroup != null) {
      if (paramView == null)
      {
        paramView = new mty(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.b);
        paramViewGroup = (mty)paramView;
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
      ((mty)paramView).a(paramViewGroup.b);
      paramView.setContentDescription(paramViewGroup.b);
      ((mty)paramView).a(paramViewGroup.jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtx
 * JD-Core Version:    0.7.0.1
 */