import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mvj
  extends ajjh
{
  mvj(mut parammut) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidViewViewGroup == null) {}
    label134:
    for (;;)
    {
      return;
      int j = this.a.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label134;
        }
        View localView = this.a.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
        if (((localView.getTag() instanceof String)) && ((localView instanceof ImageView)) && (((String)localView.getTag()).equals(paramString)))
        {
          ((ImageView)localView).setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onUpdateTroopHead:" + paramString);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvj
 * JD-Core Version:    0.7.0.1
 */