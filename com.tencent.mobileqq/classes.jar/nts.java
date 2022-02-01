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

public class nts
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = nts.class.getSimpleName();
  
  public nts(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(nto paramnto)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", pax.a(paramnto.jdField_a_of_type_Ntp.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramnto.jdField_a_of_type_Ntr.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramnto.jdField_a_of_type_Ntp.jdField_b_of_type_JavaLangString));
    if ((paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_Int == 2) || (paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", zsf.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramnto.jdField_a_of_type_Ntr.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramnto.jdField_a_of_type_Ntp.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramnto.jdField_a_of_type_Ntr.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramnto.jdField_a_of_type_Ntr.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramnto.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", pax.a(paramnto.jdField_a_of_type_Ntp.c));
    localBundle2.putString("brief_key", paramnto.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bchh.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramnto.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = ugf.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private zsh a()
  {
    zsh localzsh = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localzsh = new zsh(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localzsh;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new zsf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
    localReportDialog.setContentView(2131561021);
    ((TextView)localReportDialog.findViewById(2131365589)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365577);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365575);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365581);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690620);
    localTextView3.setText(2131691480);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ntt(this, localReportDialog));
    localTextView3.setOnClickListener(new ntu(this, paramString));
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
    localIntent.putExtra("big_brother_source_key", ugf.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nto paramnto)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695417, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramnto.jdField_a_of_type_Ntp.a + ",vid : " + paramnto.jdField_a_of_type_Ntr.jdField_c_of_type_JavaLangString);
    }
    paramnto = a(paramnto);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramnto);
    localActivity.overridePendingTransition(2130772039, 2130772041);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(obr paramobr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramobr.jdField_a_of_type_Int + ", event_id:" + paramobr.jdField_c_of_type_Int);
    }
    if (paramobr.jdField_a_of_type_Int == 1) {
      a(paramobr.jdField_c_of_type_JavaLangString);
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
                } while (paramobr.jdField_a_of_type_Int != 3);
                if (paramobr.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramobr.g)) || (TextUtils.isEmpty(paramobr.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramobr.g);
              ((Intent)localObject).putExtra("lon", paramobr.f);
              if (!TextUtils.isEmpty(paramobr.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramobr.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramobr.jdField_c_of_type_Int != 8) {
                break;
              }
              paramobr = paramobr.h;
            } while (TextUtils.isEmpty(paramobr));
            paramobr = paramobr.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramobr).matches());
          b(paramobr);
          return;
          if (paramobr.jdField_c_of_type_Int == 11)
          {
            paramobr = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramobr.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramobr.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramobr);
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 2)
          {
            zsf.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new zsh(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 17)
          {
            zsf.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new zsh(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 19)
          {
            zsf.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new zsh(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 18)
          {
            zsf.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new zsh(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 22)
          {
            a(paramobr.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramobr.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramobr.jdField_b_of_type_JavaLangString));
        Object localObject = new nto();
        ((nto)localObject).a(paramobr.jdField_b_of_type_JavaLangString);
        a((nto)localObject);
        return;
        if ((paramobr.jdField_c_of_type_Int != 1) && (paramobr.jdField_c_of_type_Int != 3) && (paramobr.jdField_c_of_type_Int != 9) && (paramobr.jdField_c_of_type_Int != 10) && (paramobr.jdField_c_of_type_Int != 12) && (paramobr.jdField_c_of_type_Int != 13) && (paramobr.jdField_c_of_type_Int != 14) && (paramobr.jdField_c_of_type_Int != 15) && (paramobr.jdField_c_of_type_Int != 16) && (paramobr.jdField_c_of_type_Int != 21)) {
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
 * Qualified Name:     nts
 * JD-Core Version:    0.7.0.1
 */