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
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nfb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = nfb.class.getSimpleName();
  
  public nfb(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(nex paramnex)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", onj.a(paramnex.jdField_a_of_type_Ney.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramnex.jdField_a_of_type_Nfa.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramnex.jdField_a_of_type_Ney.jdField_b_of_type_JavaLangString));
    if ((paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_Int == 2) || (paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", xbl.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramnex.jdField_a_of_type_Nfa.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramnex.jdField_a_of_type_Ney.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramnex.jdField_a_of_type_Nfa.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramnex.jdField_a_of_type_Nfa.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramnex.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", onj.a(paramnex.jdField_a_of_type_Ney.c));
    localBundle2.putString("brief_key", paramnex.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)axuy.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramnex.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = sgj.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private xbn a()
  {
    xbn localxbn = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localxbn = new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localxbn;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new xbl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755791);
    localDialog.setContentView(2131560713);
    ((TextView)localDialog.findViewById(2131365185)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365174);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365172);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365178);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690596);
    localTextView3.setText(2131691644);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nfc(this, localDialog));
    localTextView3.setOnClickListener(new nfd(this, paramString));
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
    localIntent.putExtra("big_brother_source_key", sgj.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nex paramnex)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131696181, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramnex.jdField_a_of_type_Ney.a + ",vid : " + paramnex.jdField_a_of_type_Nfa.jdField_c_of_type_JavaLangString);
    }
    paramnex = a(paramnex);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramnex);
    localActivity.overridePendingTransition(2130772036, 2130772038);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nmv paramnmv)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramnmv.jdField_a_of_type_Int + ", event_id:" + paramnmv.jdField_c_of_type_Int);
    }
    if (paramnmv.jdField_a_of_type_Int == 1) {
      a(paramnmv.jdField_c_of_type_JavaLangString);
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
                } while (paramnmv.jdField_a_of_type_Int != 3);
                if (paramnmv.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramnmv.g)) || (TextUtils.isEmpty(paramnmv.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramnmv.g);
              ((Intent)localObject).putExtra("lon", paramnmv.f);
              if (!TextUtils.isEmpty(paramnmv.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramnmv.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramnmv.jdField_c_of_type_Int != 8) {
                break;
              }
              paramnmv = paramnmv.h;
            } while (TextUtils.isEmpty(paramnmv));
            paramnmv = paramnmv.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramnmv).matches());
          b(paramnmv);
          return;
          if (paramnmv.jdField_c_of_type_Int == 11)
          {
            paramnmv = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramnmv.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramnmv.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramnmv);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 2)
          {
            xbl.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 17)
          {
            xbl.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 19)
          {
            xbl.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 18)
          {
            xbl.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 22)
          {
            a(paramnmv.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramnmv.jdField_b_of_type_JavaLangString));
        Object localObject = new nex();
        ((nex)localObject).a(paramnmv.jdField_b_of_type_JavaLangString);
        a((nex)localObject);
        return;
        if ((paramnmv.jdField_c_of_type_Int != 1) && (paramnmv.jdField_c_of_type_Int != 3) && (paramnmv.jdField_c_of_type_Int != 9) && (paramnmv.jdField_c_of_type_Int != 10) && (paramnmv.jdField_c_of_type_Int != 12) && (paramnmv.jdField_c_of_type_Int != 13) && (paramnmv.jdField_c_of_type_Int != 14) && (paramnmv.jdField_c_of_type_Int != 15) && (paramnmv.jdField_c_of_type_Int != 16) && (paramnmv.jdField_c_of_type_Int != 21)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event forbidden or not supported!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event unhandled!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfb
 * JD-Core Version:    0.7.0.1
 */