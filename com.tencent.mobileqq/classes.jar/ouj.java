import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class ouj
  extends aoav
{
  public ouj(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onSetPublicAccountSubscribeStatus(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramLong != 2171946401L) {
      return;
    }
    Object localObject = this.a;
    ((ReadInJoySettingActivity)localObject).jdField_a_of_type_Int -= 1;
    if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    boolean bool;
    if (paramInt == this.a.b)
    {
      bool = ReadInJoySettingActivity.a(this.a);
      if (!paramBoolean) {
        break label202;
      }
      localObject = ReadInJoySettingActivity.a(this.a);
      if (bool) {
        break label168;
      }
      paramBoolean = true;
      ((Switch)localObject).setChecked(paramBoolean);
      if (!bool) {
        break label173;
      }
      olh.a(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", pqf.a(), false);
      label147:
      ReadInJoySettingActivity.a(this.a).a(bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      label168:
      paramBoolean = false;
      break;
      label173:
      olh.a(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", pqf.a(), false);
      break label147;
      label202:
      QQToast.a(this.a.getApplicationContext(), 2131699157, 0).a();
      this.a.c = true;
      ReadInJoySettingActivity.a(this.a).setChecked(bool);
      QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouj
 * JD-Core Version:    0.7.0.1
 */