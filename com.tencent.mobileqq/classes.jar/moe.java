import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.ui.VoiceChangeItemView1;

public class moe
  extends BaseAdapter
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  moj jdField_a_of_type_Moj;
  private moh[] jdField_a_of_type_ArrayOfMoh;
  private int jdField_b_of_type_Int;
  private VoiceChangeItemView1 jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeAdapter";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(moh[] paramArrayOfmoh)
  {
    this.jdField_a_of_type_ArrayOfMoh = paramArrayOfmoh;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfMoh == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfMoh.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfMoh == null) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfMoh[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    lek.a(jdField_a_of_type_JavaLangString, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      paramViewGroup = (moh)getItem(paramInt);
      VoiceChangeItemView1 localVoiceChangeItemView1;
      if (paramViewGroup != null)
      {
        if ((this.d == 0) && (paramInt == 1) && (this.jdField_b_of_type_Int == 0)) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
        }
        localVoiceChangeItemView1 = (VoiceChangeItemView1)paramView;
        if (this.c != paramViewGroup.jdField_a_of_type_Int) {
          break label168;
        }
      }
      for (;;)
      {
        localVoiceChangeItemView1.a(paramInt, paramViewGroup, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_Moj);
        if (this.c == paramViewGroup.jdField_a_of_type_Int)
        {
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = localVoiceChangeItemView1;
          }
          this.d = paramInt;
        }
        this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)paramView);
        this.jdField_b_of_type_Int = paramInt;
        return paramView;
        label168:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     moe
 * JD-Core Version:    0.7.0.1
 */