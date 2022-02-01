import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nsj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = nsj.class.getSimpleName();
  
  public nsj(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private aavu a()
  {
    aavu localaavu = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localaavu = new aavu(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localaavu;
  }
  
  private Bundle a(nsf paramnsf)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", ozr.a(paramnsf.jdField_a_of_type_Nsg.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramnsf.jdField_a_of_type_Nsi.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramnsf.jdField_a_of_type_Nsg.jdField_b_of_type_JavaLangString));
    if ((paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_Int == 2) || (paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", aavs.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramnsf.jdField_a_of_type_Nsi.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramnsf.jdField_a_of_type_Nsg.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramnsf.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramnsf.jdField_a_of_type_Nsi.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramnsf.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", ozr.a(paramnsf.jdField_a_of_type_Nsg.c));
    localBundle2.putString("brief_key", paramnsf.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdow.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramnsf.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = tzq.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new aavs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755824);
    localReportDialog.setContentView(2131561147);
    ((TextView)localReportDialog.findViewById(2131365556)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365544);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365542);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365548);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690580);
    localTextView3.setText(2131691440);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nsk(this, localReportDialog));
    localTextView3.setOnClickListener(new nsl(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)));
    paramString = paramString.replace("${puin}", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "jumpWebView->url:" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localIntent.putExtra("big_brother_source_key", tzq.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nsf paramnsf)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695278, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramnsf.jdField_a_of_type_Nsg.a + ",vid : " + paramnsf.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString);
    }
    paramnsf = a(paramnsf);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramnsf);
    localActivity.overridePendingTransition(2130772037, 2130772039);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(oag paramoag)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramoag.jdField_a_of_type_Int + ", event_id:" + paramoag.jdField_c_of_type_Int);
    }
    if (paramoag.jdField_a_of_type_Int == 1) {
      a(paramoag.jdField_c_of_type_JavaLangString);
    }
    label66:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label66;
                break label66;
                break label66;
                break label66;
                do
                {
                  return;
                } while (paramoag.jdField_a_of_type_Int != 3);
                if (paramoag.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramoag.g)) || (TextUtils.isEmpty(paramoag.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramoag.g);
              ((Intent)localObject).putExtra("lon", paramoag.f);
              if (!TextUtils.isEmpty(paramoag.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramoag.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramoag.jdField_c_of_type_Int != 8) {
                break;
              }
              paramoag = paramoag.h;
            } while (TextUtils.isEmpty(paramoag));
            paramoag = paramoag.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramoag).matches());
          b(paramoag);
          return;
          if (paramoag.jdField_c_of_type_Int == 11)
          {
            paramoag = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramoag.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramoag.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramoag);
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 2)
          {
            aavs.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aavu(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 17)
          {
            aavs.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aavu(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 19)
          {
            aavs.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aavu(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 18)
          {
            aavs.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aavu(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 22)
          {
            a(paramoag.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramoag.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramoag.jdField_b_of_type_JavaLangString));
        Object localObject = new nsf();
        ((nsf)localObject).a(paramoag.jdField_b_of_type_JavaLangString);
        a((nsf)localObject);
        return;
        if ((paramoag.jdField_c_of_type_Int != 1) && (paramoag.jdField_c_of_type_Int != 3) && (paramoag.jdField_c_of_type_Int != 9) && (paramoag.jdField_c_of_type_Int != 10) && (paramoag.jdField_c_of_type_Int != 12) && (paramoag.jdField_c_of_type_Int != 13) && (paramoag.jdField_c_of_type_Int != 14) && (paramoag.jdField_c_of_type_Int != 15) && (paramoag.jdField_c_of_type_Int != 16) && (paramoag.jdField_c_of_type_Int != 21)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event forbidden or not supported!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event unhandled!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsj
 * JD-Core Version:    0.7.0.1
 */