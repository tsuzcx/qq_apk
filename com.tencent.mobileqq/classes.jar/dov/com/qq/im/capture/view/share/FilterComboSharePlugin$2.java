package dov.com.qq.im.capture.view.share;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import bjmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FilterComboSharePlugin$2
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina path:" + this.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.b);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
    }
    FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getContext(), localIntent);
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.this$0.startActivityForResult(localIntent, (byte)110);
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina start weibo!");
    }
    this.this$0.a(true, 3);
    this.this$0.a();
    bjmj.a(this.this$0, this.this$0.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.share.FilterComboSharePlugin.2
 * JD-Core Version:    0.7.0.1
 */