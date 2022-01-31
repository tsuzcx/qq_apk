import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

public final class sce
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  public sce(QQProgressDialog paramQQProgressDialog, Map paramMap, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      label17:
      StoryReportor.a("group_video", "startGroupVideo", paramInt2, paramInt1, new String[] { (String)this.jdField_a_of_type_JavaUtilMap.get("from") });
      if (paramInt2 == 1000)
      {
        switch (paramInt1)
        {
        default: 
          return;
        case 0: 
          Monitor.b("3236165");
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, this.jdField_a_of_type_JavaUtilMap);
          return;
        case 1: 
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          localIntent.putExtra("url", paramRecord.jdField_a_of_type_JavaLangString);
          if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
            localIntent.addFlags(268435456);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return;
        case 2: 
          Monitor.b("3236166");
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, this.jdField_a_of_type_JavaUtilMap);
          return;
        case 3: 
          GVideoGrayConfig.a(this.jdField_a_of_type_AndroidContentContext, paramRecord.b, paramRecord.c, new scf(this));
          return;
        }
        GVideoGrayConfig.a(this.jdField_a_of_type_AndroidContentContext, paramRecord.b, paramRecord.c, new scg(this));
        return;
      }
      if (paramInt2 == 1002) {}
      for (paramRecord = "操作超时，请重试";; paramRecord = "操作失败，请重试")
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramRecord, 0).a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sce
 * JD-Core Version:    0.7.0.1
 */