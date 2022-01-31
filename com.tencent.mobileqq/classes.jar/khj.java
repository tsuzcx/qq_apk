import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.utils.TraeHelper.SoundOutputRes;
import com.tencent.av.utils.TraeHelper.SoundOutputRes.IconAndName;

public class khj
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  TraeHelper.SoundOutputRes jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public khj(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes = paramSoundOutputRes;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramSoundOutputRes.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramSoundOutputRes.a();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes = paramSoundOutputRes;
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
        TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)getItem(i);
        if ((localIconAndName != null) && (localIconAndName.jdField_a_of_type_JavaLangString != null) && (localIconAndName.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes != null) {
      return this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TraeHelper.SoundOutputRes.IconAndName)getItem(paramInt);
    if (paramViewGroup != null) {
      if (paramView == null)
      {
        paramView = new khk(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.b);
        paramViewGroup = (khk)paramView;
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
      ((khk)paramView).a(paramViewGroup.b);
      paramView.setContentDescription(paramViewGroup.b);
      ((khk)paramView).a(paramViewGroup.jdField_a_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khj
 * JD-Core Version:    0.7.0.1
 */