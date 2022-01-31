import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1;
import java.util.ArrayList;

public class mgv
  extends BaseAdapter
{
  public mgv(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  Bitmap a()
  {
    return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(this.a).getDrawable(2130839736)).getBitmap();
  }
  
  public Bitmap a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return null;
    }
    int i = -1;
    if (this.a.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, paramString, String.valueOf(this.a.jdField_a_of_type_Long), true, false);
      if (this.a.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  String a(String paramString)
  {
    int i = -1;
    if (this.a.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, paramString, String.valueOf(this.a.jdField_a_of_type_Long));
      if (this.a.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  public void a(ldw paramldw, mgw parammgw)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (paramldw == null) || (parammgw == null)) {
      return;
    }
    if (paramldw.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      parammgw.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1(this, parammgw, paramldw));
      return;
    }
    parammgw.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramldw.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label28:
    label117:
    ldw localldw;
    String str;
    if (paramView == null) {
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559527, null);
        paramViewGroup = new mgw(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368339));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368352));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368393));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131368397));
        if (this.a.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368346));
        }
        paramView.setTag(paramViewGroup);
        localldw = (ldw)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewGroup.jdField_a_of_type_Long = localldw.jdField_a_of_type_Long;
        a(localldw, paramViewGroup);
        localldw.jdField_a_of_type_JavaLangString = a(String.valueOf(localldw.jdField_a_of_type_Long));
        if (localldw.jdField_a_of_type_JavaLangString != null) {
          break label366;
        }
        str = "";
        label178:
        localldw.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localldw.jdField_a_of_type_JavaLangString);
        if ((localldw.jdField_a_of_type_Int <= 0) && (!localldw.b) && (!localldw.c)) {
          break label376;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label229:
        if (!localldw.jdField_a_of_type_Boolean) {
          break label388;
        }
        paramViewGroup.c.setVisibility(0);
      }
    }
    for (;;)
    {
      int i;
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramInt = localldw.d;
        i = localldw.e;
        if (paramInt < 0) {
          break label462;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("Lv." + paramInt);
      }
      switch (i)
      {
      default: 
        return paramView;
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559535, null);
        break label28;
        paramViewGroup = (mgw)paramView.getTag();
        break label117;
        label366:
        str = localldw.jdField_a_of_type_JavaLangString;
        break label178;
        label376:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label229;
        label388:
        paramViewGroup.c.setVisibility(4);
      }
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.a(this.a).getColor(2131165894));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.b(this.a).getColor(2131165895));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.c(this.a).getColor(2131165896));
    return paramView;
    label462:
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgv
 * JD-Core Version:    0.7.0.1
 */