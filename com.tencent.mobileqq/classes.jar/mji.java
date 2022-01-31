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

public class mji
  extends BaseAdapter
{
  public mji(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  Bitmap a()
  {
    return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(this.a).getDrawable(2130840084)).getBitmap();
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
  
  public void a(lfu paramlfu, mjj parammjj)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (paramlfu == null) || (parammjj == null)) {
      return;
    }
    if (paramlfu.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      parammjj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1(this, parammjj, paramlfu));
      return;
    }
    parammjj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramlfu.jdField_a_of_type_AndroidGraphicsBitmap);
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
    lfu locallfu;
    String str;
    if (paramView == null) {
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559579, null);
        paramViewGroup = new mjj(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368511));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368524));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368576));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131368580));
        if (this.a.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368518));
        }
        paramView.setTag(paramViewGroup);
        locallfu = (lfu)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewGroup.jdField_a_of_type_Long = locallfu.jdField_a_of_type_Long;
        a(locallfu, paramViewGroup);
        locallfu.jdField_a_of_type_JavaLangString = a(String.valueOf(locallfu.jdField_a_of_type_Long));
        if (locallfu.jdField_a_of_type_JavaLangString != null) {
          break label366;
        }
        str = "";
        label178:
        locallfu.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(locallfu.jdField_a_of_type_JavaLangString);
        if ((locallfu.jdField_b_of_type_Int <= 0) && (!locallfu.jdField_b_of_type_Boolean) && (!locallfu.c)) {
          break label376;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label229:
        if (!locallfu.jdField_a_of_type_Boolean) {
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
        paramInt = locallfu.e;
        i = locallfu.f;
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
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559587, null);
        break label28;
        paramViewGroup = (mjj)paramView.getTag();
        break label117;
        label366:
        str = locallfu.jdField_a_of_type_JavaLangString;
        break label178;
        label376:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label229;
        label388:
        paramViewGroup.c.setVisibility(4);
      }
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.a(this.a).getColor(2131165933));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.b(this.a).getColor(2131165934));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.c(this.a).getColor(2131165935));
    return paramView;
    label462:
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mji
 * JD-Core Version:    0.7.0.1
 */