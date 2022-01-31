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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nhu
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = nhu.class.getSimpleName();
  
  public nhu(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(nhq paramnhq)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", orr.a(paramnhq.jdField_a_of_type_Nhr.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramnhq.jdField_a_of_type_Nht.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramnhq.jdField_a_of_type_Nhr.jdField_b_of_type_JavaLangString));
    if ((paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_Int == 2) || (paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", yqb.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramnhq.jdField_a_of_type_Nht.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramnhq.jdField_a_of_type_Nhr.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramnhq.jdField_a_of_type_Nht.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramnhq.jdField_a_of_type_Nht.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramnhq.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", orr.a(paramnhq.jdField_a_of_type_Nhr.c));
    localBundle2.putString("brief_key", paramnhq.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)azqu.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramnhq.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = syb.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private yqd a()
  {
    yqd localyqd = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localyqd = new yqd(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localyqd;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new yqb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755801);
    localDialog.setContentView(2131560888);
    ((TextView)localDialog.findViewById(2131365269)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365258);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365256);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365262);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690648);
    localTextView3.setText(2131691699);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nhv(this, localDialog));
    localTextView3.setOnClickListener(new nhw(this, paramString));
    try
    {
      localDialog.show();
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
    localIntent.putExtra("big_brother_source_key", syb.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nhq paramnhq)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696351, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramnhq.jdField_a_of_type_Nhr.a + ",vid : " + paramnhq.jdField_a_of_type_Nht.jdField_c_of_type_JavaLangString);
    }
    paramnhq = a(paramnhq);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramnhq);
    localActivity.overridePendingTransition(2130772036, 2130772038);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(npo paramnpo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramnpo.jdField_a_of_type_Int + ", event_id:" + paramnpo.jdField_c_of_type_Int);
    }
    if (paramnpo.jdField_a_of_type_Int == 1) {
      a(paramnpo.jdField_c_of_type_JavaLangString);
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
                } while (paramnpo.jdField_a_of_type_Int != 3);
                if (paramnpo.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramnpo.g)) || (TextUtils.isEmpty(paramnpo.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramnpo.g);
              ((Intent)localObject).putExtra("lon", paramnpo.f);
              if (!TextUtils.isEmpty(paramnpo.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramnpo.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramnpo.jdField_c_of_type_Int != 8) {
                break;
              }
              paramnpo = paramnpo.h;
            } while (TextUtils.isEmpty(paramnpo));
            paramnpo = paramnpo.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramnpo).matches());
          b(paramnpo);
          return;
          if (paramnpo.jdField_c_of_type_Int == 11)
          {
            paramnpo = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramnpo.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramnpo.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramnpo);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 2)
          {
            yqb.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new yqd(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 17)
          {
            yqb.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new yqd(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 19)
          {
            yqb.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new yqd(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 18)
          {
            yqb.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new yqd(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 22)
          {
            a(paramnpo.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramnpo.jdField_b_of_type_JavaLangString));
        Object localObject = new nhq();
        ((nhq)localObject).a(paramnpo.jdField_b_of_type_JavaLangString);
        a((nhq)localObject);
        return;
        if ((paramnpo.jdField_c_of_type_Int != 1) && (paramnpo.jdField_c_of_type_Int != 3) && (paramnpo.jdField_c_of_type_Int != 9) && (paramnpo.jdField_c_of_type_Int != 10) && (paramnpo.jdField_c_of_type_Int != 12) && (paramnpo.jdField_c_of_type_Int != 13) && (paramnpo.jdField_c_of_type_Int != 14) && (paramnpo.jdField_c_of_type_Int != 15) && (paramnpo.jdField_c_of_type_Int != 16) && (paramnpo.jdField_c_of_type_Int != 21)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event forbidden or not supported!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event unhandled!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nhu
 * JD-Core Version:    0.7.0.1
 */