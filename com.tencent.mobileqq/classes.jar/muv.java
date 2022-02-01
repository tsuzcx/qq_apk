import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class muv
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  mux jdField_a_of_type_Mux;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  muv(Context paramContext, @NonNull mux parammux)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mux = parammux;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammux.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull mux parammux)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = parammux.a();
    this.jdField_a_of_type_Mux = parammux;
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
        muy localmuy = (muy)getItem(i);
        if ((localmuy != null) && (localmuy.jdField_a_of_type_JavaLangString != null) && (localmuy.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_Mux != null) {
      return this.jdField_a_of_type_Mux.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Mux.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (muy)getItem(paramInt);
    if (localObject != null) {
      if (paramView == null)
      {
        paramView = new muw((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((muy)localObject).jdField_a_of_type_Int, ((muy)localObject).b);
        localObject = (muw)paramView;
        if (paramInt != this.jdField_a_of_type_Int) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      ((muw)localObject).a(bool);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((muw)paramView).a(((muy)localObject).b);
      paramView.setContentDescription(((muy)localObject).b);
      ((muw)paramView).a(((muy)localObject).jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     muv
 * JD-Core Version:    0.7.0.1
 */