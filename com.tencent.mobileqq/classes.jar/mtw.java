import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mtw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  mty jdField_a_of_type_Mty;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mtw(Context paramContext, @NonNull mty parammty)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mty = parammty;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammty.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mty parammty)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammty.a();
    this.jdField_a_of_type_Mty = parammty;
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
        mtz localmtz = (mtz)getItem(i);
        if ((localmtz != null) && (localmtz.jdField_a_of_type_JavaLangString != null) && (localmtz.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mty != null) {
      return this.jdField_a_of_type_Mty.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mty.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (mtz)getItem(paramInt);
    if (localObject != null) {
      if (paramView == null)
      {
        paramView = new mtx(this.jdField_a_of_type_AndroidContentContext, ((mtz)localObject).jdField_a_of_type_Int, ((mtz)localObject).b);
        localObject = (mtx)paramView;
        if (paramInt != this.jdField_a_of_type_Int) {
          break label117;
        }
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      ((mtx)localObject).a(bool);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((mtx)paramView).a(((mtz)localObject).b);
      paramView.setContentDescription(((mtz)localObject).b);
      ((mtx)paramView).a(((mtz)localObject).jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtw
 * JD-Core Version:    0.7.0.1
 */