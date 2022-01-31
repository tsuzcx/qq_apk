import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.ui.VoiceChangeItemView1;

public class maw
  extends BaseAdapter
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  mbb jdField_a_of_type_Mbb;
  private maz[] jdField_a_of_type_ArrayOfMaz;
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
  
  public void a(maz[] paramArrayOfmaz)
  {
    this.jdField_a_of_type_ArrayOfMaz = paramArrayOfmaz;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfMaz == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfMaz.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfMaz == null) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfMaz[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    krx.a(jdField_a_of_type_JavaLangString, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      paramViewGroup = (maz)getItem(paramInt);
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
        localVoiceChangeItemView1.a(paramInt, paramViewGroup, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_Mbb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     maw
 * JD-Core Version:    0.7.0.1
 */