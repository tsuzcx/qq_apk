import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class stk
  implements Runnable
{
  stk(stg paramstg, CardHandler paramCardHandler, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_Stg.a, 230, "上传失败", "部分照片上传失败，是否重试上传？", new stl(this), new stm(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stk
 * JD-Core Version:    0.7.0.1
 */