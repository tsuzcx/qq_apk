import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class slr
  implements Runnable
{
  slr(sln paramsln, CardHandler paramCardHandler, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_Sln.a, 230, "上传失败", "部分照片上传失败，是否重试上传？", new sls(this), new slt(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slr
 * JD-Core Version:    0.7.0.1
 */