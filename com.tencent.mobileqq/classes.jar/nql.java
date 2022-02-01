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

public class nql
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = nql.class.getSimpleName();
  
  public nql(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private aarr a()
  {
    aarr localaarr = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localaarr = new aarr(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localaarr;
  }
  
  private Bundle a(nqh paramnqh)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", pgz.a(paramnqh.jdField_a_of_type_Nqi.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramnqh.jdField_a_of_type_Nqk.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramnqh.jdField_a_of_type_Nqi.jdField_b_of_type_JavaLangString));
    if ((paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int == 2) || (paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", aarp.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramnqh.jdField_a_of_type_Nqk.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramnqh.jdField_a_of_type_Nqi.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramnqh.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramnqh.jdField_a_of_type_Nqk.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramnqh.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", pgz.a(paramnqh.jdField_a_of_type_Nqi.c));
    localBundle2.putString("brief_key", paramnqh.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bcwd.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramnqh.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = tzo.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
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
    new aarp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
    localReportDialog.setContentView(2131561111);
    ((TextView)localReportDialog.findViewById(2131365514)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365502);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365500);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365506);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690582);
    localTextView3.setText(2131691437);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nqm(this, localReportDialog));
    localTextView3.setOnClickListener(new nqn(this, paramString));
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
    localIntent.putExtra("big_brother_source_key", tzo.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nqh paramnqh)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695235, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramnqh.jdField_a_of_type_Nqi.a + ",vid : " + paramnqh.jdField_a_of_type_Nqk.jdField_c_of_type_JavaLangString);
    }
    paramnqh = a(paramnqh);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramnqh);
    localActivity.overridePendingTransition(2130772037, 2130772039);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nyl paramnyl)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramnyl.jdField_a_of_type_Int + ", event_id:" + paramnyl.jdField_c_of_type_Int);
    }
    if (paramnyl.jdField_a_of_type_Int == 1) {
      a(paramnyl.jdField_c_of_type_JavaLangString);
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
                } while (paramnyl.jdField_a_of_type_Int != 3);
                if (paramnyl.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramnyl.g)) || (TextUtils.isEmpty(paramnyl.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramnyl.g);
              ((Intent)localObject).putExtra("lon", paramnyl.f);
              if (!TextUtils.isEmpty(paramnyl.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramnyl.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramnyl.jdField_c_of_type_Int != 8) {
                break;
              }
              paramnyl = paramnyl.h;
            } while (TextUtils.isEmpty(paramnyl));
            paramnyl = paramnyl.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramnyl).matches());
          b(paramnyl);
          return;
          if (paramnyl.jdField_c_of_type_Int == 11)
          {
            paramnyl = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramnyl.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramnyl.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramnyl);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 2)
          {
            aarp.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aarr(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 17)
          {
            aarp.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aarr(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 19)
          {
            aarp.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aarr(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 18)
          {
            aarp.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new aarr(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 22)
          {
            a(paramnyl.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramnyl.jdField_b_of_type_JavaLangString));
        Object localObject = new nqh();
        ((nqh)localObject).a(paramnyl.jdField_b_of_type_JavaLangString);
        a((nqh)localObject);
        return;
        if ((paramnyl.jdField_c_of_type_Int != 1) && (paramnyl.jdField_c_of_type_Int != 3) && (paramnyl.jdField_c_of_type_Int != 9) && (paramnyl.jdField_c_of_type_Int != 10) && (paramnyl.jdField_c_of_type_Int != 12) && (paramnyl.jdField_c_of_type_Int != 13) && (paramnyl.jdField_c_of_type_Int != 14) && (paramnyl.jdField_c_of_type_Int != 15) && (paramnyl.jdField_c_of_type_Int != 16) && (paramnyl.jdField_c_of_type_Int != 21)) {
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
 * Qualified Name:     nql
 * JD-Core Version:    0.7.0.1
 */