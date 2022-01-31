import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class swb
  implements Runnable
{
  public swb(JumpActivity paramJumpActivity, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TITLE");
    this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.SUBJECT");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
    this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getType();
    if ("cn.wps.moffice_eng".equals(this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app, "CliOper", "", "", "0X8008810", "0X8008810", 0, 0, "", "", "", "");
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getCurrentAccountUin(), "dl_share_frd");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "forward form JumpActivity doShare type=" + (String)localObject1);
    }
    if ((((String)localObject1).startsWith("text")) && (!this.jdField_a_of_type_AndroidOsBundle.containsKey("android.intent.extra.STREAM")))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject1);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getScheme();
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals("geo"))) {
        break label941;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("forward_type", -2);
      ((Intent)localObject1).setData(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getData());
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, (Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      if (!((String)localObject1).startsWith("message")) {
        break;
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.TEXT"));
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
    }
    if (((String)localObject1).startsWith("image"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("forward_type", 1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getAction().equals("android.intent.action.SEND"))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        if (localObject2 != null) {
          if ((localObject2 instanceof Uri))
          {
            ((Intent)localObject1).setData((Uri)localObject2);
            label592:
            ((Intent)localObject1).putExtra("sendMultiple", false);
          }
        }
      }
      for (;;)
      {
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject1);
        break;
        if ((localObject2 instanceof String))
        {
          ((Intent)localObject1).setData(Uri.parse((String)localObject2));
          break label592;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
        return;
        ((Intent)localObject1).putExtra("sendMultiple", true);
        ((Intent)localObject1).putExtra("forward_text", this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getString(2131436144));
      }
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getAction();
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("isFromShare", true);
    ((Intent)localObject2).putExtra("forward_from_jump", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    if (((String)localObject3).equals("android.intent.action.SEND"))
    {
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject3 != null) {
        if ((localObject3 instanceof Uri))
        {
          Uri localUri = (Uri)localObject3;
          if (("text/x-vcard".equals(localObject1)) && ("content".equals(localUri.getScheme())))
          {
            ((Intent)localObject2).putExtra("sendMultiple", false);
            ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
            new swf(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, (Intent)localObject2).execute(new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getApplicationContext(), localUri });
            return;
          }
          ((Intent)localObject2).setData((Uri)localObject3);
          label848:
          ((Intent)localObject2).putExtra("sendMultiple", false);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, (Intent)localObject2);
      break;
      if ((localObject3 instanceof String))
      {
        ((Intent)localObject2).setData(Uri.parse((String)localObject3));
        break label848;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      ((Intent)localObject2).putExtra("sendMultiple", true);
      ((Intent)localObject2).putExtra("forward_text", this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getString(2131436144));
    }
    label941:
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     swb
 * JD-Core Version:    0.7.0.1
 */