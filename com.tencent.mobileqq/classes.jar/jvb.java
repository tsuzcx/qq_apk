import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.InviteStartAudioDialog;
import com.tencent.av.ui.InviteStartAudioDialog.ViewHolder;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class jvb
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private jvb(InviteStartAudioDialog paramInviteStartAudioDialog) {}
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    InviteBaseData localInviteBaseData1 = new InviteBaseData();
    localInviteBaseData1.jdField_a_of_type_Int = 0;
    localInviteBaseData1.jdField_a_of_type_JavaLangString = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).c();
    localInviteBaseData1.jdField_b_of_type_JavaLangString = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).getCurrentNickname();
    InviteBaseData localInviteBaseData2 = new InviteBaseData();
    localInviteBaseData2.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList.add(localInviteBaseData1);
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaUtilList.add(localInviteBaseData2);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog)).inflate(2130969312, null);
      paramViewGroup = new InviteStartAudioDialog.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366112));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363462));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131366113));
      paramView.setTag(paramViewGroup);
    }
    InviteBaseData localInviteBaseData;
    for (;;)
    {
      localInviteBaseData = (InviteBaseData)getItem(paramInt);
      if (localInviteBaseData.jdField_b_of_type_Int != 1) {
        break;
      }
      paramViewGroup.b.setText(2131438369);
      paramViewGroup.b.setTextColor(InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).getResources().getColor(2131493322));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840071);
      return paramView;
      paramViewGroup = (InviteStartAudioDialog.ViewHolder)paramView.getTag();
      InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog, paramViewGroup);
    }
    paramViewGroup.b.setText(localInviteBaseData.jdField_b_of_type_JavaLangString);
    Bitmap localBitmap = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog, localInviteBaseData);
    if (localBitmap != null)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.c(localInviteBaseData.jdField_b_of_type_JavaLangString));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvb
 * JD-Core Version:    0.7.0.1
 */