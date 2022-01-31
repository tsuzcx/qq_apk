import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class ouc
  implements Runnable
{
  ouc(oub paramoub, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Oub.a.sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_Oub.a.getString(2131430001, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_Oub.a.getTitleBarHeight());
      return;
    }
    QRUtils.a(1, 2131430002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */