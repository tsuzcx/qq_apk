import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.lang.ref.WeakReference;

class pbh
  implements Runnable
{
  pbh(pbg parampbg, Bitmap paramBitmap) {}
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = (WebUiBaseInterface)this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).b()) && (!this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      Share.a(this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare, this.jdField_a_of_type_Pbg.jdField_a_of_type_Int, this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.d, this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.e, this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.b, this.jdField_a_of_type_Pbg.jdField_a_of_type_ComTencentBizWebviewpluginShare.f, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbh
 * JD-Core Version:    0.7.0.1
 */