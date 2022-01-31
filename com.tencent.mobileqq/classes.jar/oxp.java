import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class oxp
  extends QRDisplayActivity.GetNicknameObserver
{
  public oxp(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
  }
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "onGetNicknameList: " + paramBoolean);
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.a.jdField_b_of_type_JavaUtilList == null) {
          this.a.jdField_b_of_type_JavaUtilList = new ArrayList();
        }
        this.a.jdField_b_of_type_JavaUtilList.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.a.a((String)paramList2.get(i)) == null) {
            this.a.a((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.a.jdField_b_of_type_JavaUtilList, new oyu(this.a));
      }
    }
    this.a.jdField_a_of_type_JavaLangString = this.a.a(this.a.jdField_b_of_type_JavaUtilList);
    if (this.a.jdField_a_of_type_JavaLangString != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.a.jdField_a_of_type_JavaLangString + "," + this.a.jdField_b_of_type_JavaLangString);
      this.a.c.post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxp
 * JD-Core Version:    0.7.0.1
 */