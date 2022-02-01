import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class mvc
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  mve jdField_a_of_type_Mve;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  mvc(Context paramContext, @NonNull mve parammve)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mve = parammve;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammve.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mve parammve)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammve.a();
    this.jdField_a_of_type_Mve = parammve;
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
        mvf localmvf = (mvf)getItem(i);
        if ((localmvf != null) && (localmvf.jdField_a_of_type_JavaLangString != null) && (localmvf.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mve != null) {
      return this.jdField_a_of_type_Mve.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mve.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (mvf)getItem(paramInt);
    if (localObject != null) {
      if (paramView == null)
      {
        paramView = new mvd((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((mvf)localObject).jdField_a_of_type_Int, ((mvf)localObject).b);
        localObject = (mvd)paramView;
        if (paramInt != this.jdField_a_of_type_Int) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      ((mvd)localObject).a(bool);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((mvd)paramView).a(((mvf)localObject).b);
      paramView.setContentDescription(((mvf)localObject).b);
      ((mvd)paramView).a(((mvf)localObject).jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mvc
 * JD-Core Version:    0.7.0.1
 */