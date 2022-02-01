import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class mue
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  mug jdField_a_of_type_Mug;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mue(Context paramContext, @NonNull mug parammug)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mug = parammug;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammug.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mug parammug)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammug.a();
    this.jdField_a_of_type_Mug = parammug;
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
        muh localmuh = (muh)getItem(i);
        if ((localmuh != null) && (localmuh.jdField_a_of_type_JavaLangString != null) && (localmuh.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mug != null) {
      return this.jdField_a_of_type_Mug.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mug.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (muh)getItem(paramInt);
    if (localObject != null) {
      if (paramView == null)
      {
        paramView = new muf((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((muh)localObject).jdField_a_of_type_Int, ((muh)localObject).b);
        localObject = (muf)paramView;
        if (paramInt != this.jdField_a_of_type_Int) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      ((muf)localObject).a(bool);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((muf)paramView).a(((muh)localObject).b);
      paramView.setContentDescription(((muh)localObject).b);
      ((muf)paramView).a(((muh)localObject).jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mue
 * JD-Core Version:    0.7.0.1
 */