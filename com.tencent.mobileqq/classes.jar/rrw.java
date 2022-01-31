import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class rrw
  implements qoh
{
  public rrw(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle, float paramFloat)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "");
    if (this.a.jdField_a_of_type_JavaUtilMap.get(str) != null) {
      ((KandianProgressView)this.a.jdField_a_of_type_JavaUtilMap.get(str)).a((int)paramFloat);
    }
  }
  
  public void a(Bundle paramBundle, int paramInt, float paramFloat)
  {
    QLog.d("KandianVideoUpload", 1, paramBundle.getString("mTaskID") + "service中的状态:" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 200: 
      this.a.jdField_a_of_type_Qoh.a(paramBundle, (int)paramFloat);
      return;
    case 202: 
      ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
      return;
    }
    qod.b(paramBundle);
  }
  
  public void a(Bundle paramBundle, String paramString)
  {
    paramString = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
    if (this.a.jdField_a_of_type_JavaUtilMap.get(paramString) != null) {
      ((KandianProgressView)this.a.jdField_a_of_type_JavaUtilMap.get(paramString)).a();
    }
  }
  
  public void a(String paramString)
  {
    this.a.a();
    owy.a().b(true);
    ReadInJoyBaseListViewGroup.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rrw
 * JD-Core Version:    0.7.0.1
 */