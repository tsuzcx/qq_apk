import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.ui.VoiceChangeItemView1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mmk
  extends BaseAdapter
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  mmp jdField_a_of_type_Mmp;
  private mmn[] jdField_a_of_type_ArrayOfMmn;
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
  
  public void a(mmn[] paramArrayOfmmn)
  {
    this.jdField_a_of_type_ArrayOfMmn = paramArrayOfmmn;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfMmn == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfMmn.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfMmn == null) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfMmn[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    lbd.d(jdField_a_of_type_JavaLangString, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      mmn localmmn = (mmn)getItem(paramInt);
      VoiceChangeItemView1 localVoiceChangeItemView1;
      if (localmmn != null)
      {
        if ((this.d == 0) && (paramInt == 1) && (this.jdField_b_of_type_Int == 0)) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
        }
        localVoiceChangeItemView1 = (VoiceChangeItemView1)paramView;
        if (this.c != localmmn.jdField_a_of_type_Int) {
          break label187;
        }
      }
      for (;;)
      {
        localVoiceChangeItemView1.a(paramInt, localmmn, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_Mmp);
        if (this.c == localmmn.jdField_a_of_type_Int)
        {
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = localVoiceChangeItemView1;
          }
          this.d = paramInt;
        }
        this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)paramView);
        this.jdField_b_of_type_Int = paramInt;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label187:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */