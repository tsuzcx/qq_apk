import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.util.FaceDrawable;

class osq
  extends Thread
{
  osq(osp paramosp, String paramString) {}
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Osp.a.app, 1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Osp.a.runOnUiThread(new osr(this, localFaceDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osq
 * JD-Core Version:    0.7.0.1
 */