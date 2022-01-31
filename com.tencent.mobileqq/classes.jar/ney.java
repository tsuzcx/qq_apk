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

public class ney
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = ney.class.getSimpleName();
  
  public ney(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(neu paramneu)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramneu.jdField_a_of_type_Nex.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", ong.a(paramneu.jdField_a_of_type_Nev.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramneu.jdField_a_of_type_Nex.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramneu.jdField_a_of_type_Nex.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramneu.jdField_a_of_type_Nex.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramneu.jdField_a_of_type_Nex.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramneu.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramneu.jdField_a_of_type_Nev.jdField_b_of_type_JavaLangString));
    if ((paramneu.jdField_a_of_type_Nex.jdField_a_of_type_Int == 2) || (paramneu.jdField_a_of_type_Nex.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", xbi.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramneu.jdField_a_of_type_Nex.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramneu.jdField_a_of_type_Nex.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramneu.jdField_a_of_type_Nex.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramneu.jdField_a_of_type_Nex.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramneu.jdField_a_of_type_Nex.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramneu.jdField_a_of_type_Nex.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramneu.jdField_a_of_type_Nex.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramneu.jdField_a_of_type_Nex.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramneu.jdField_a_of_type_Nex.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramneu.jdField_a_of_type_Nev.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramneu.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramneu.jdField_a_of_type_Nex.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramneu.jdField_a_of_type_Nex.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramneu.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", ong.a(paramneu.jdField_a_of_type_Nev.c));
    localBundle2.putString("brief_key", paramneu.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)axva.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramneu.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private xbk a()
  {
    xbk localxbk = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localxbk = new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localxbk;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new xbi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755791);
    localDialog.setContentView(2131560712);
    ((TextView)localDialog.findViewById(2131365184)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365173);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365171);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365177);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690596);
    localTextView3.setText(2131691644);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nez(this, localDialog));
    localTextView3.setOnClickListener(new nfa(this, paramString));
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
    localIntent.putExtra("big_brother_source_key", sgg.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(neu paramneu)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131696182, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramneu.jdField_a_of_type_Nev.a + ",vid : " + paramneu.jdField_a_of_type_Nex.jdField_c_of_type_JavaLangString);
    }
    paramneu = a(paramneu);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramneu);
    localActivity.overridePendingTransition(2130772036, 2130772038);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nms paramnms)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramnms.jdField_a_of_type_Int + ", event_id:" + paramnms.jdField_c_of_type_Int);
    }
    if (paramnms.jdField_a_of_type_Int == 1) {
      a(paramnms.jdField_c_of_type_JavaLangString);
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
                } while (paramnms.jdField_a_of_type_Int != 3);
                if (paramnms.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramnms.g)) || (TextUtils.isEmpty(paramnms.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramnms.g);
              ((Intent)localObject).putExtra("lon", paramnms.f);
              if (!TextUtils.isEmpty(paramnms.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramnms.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramnms.jdField_c_of_type_Int != 8) {
                break;
              }
              paramnms = paramnms.h;
            } while (TextUtils.isEmpty(paramnms));
            paramnms = paramnms.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramnms).matches());
          b(paramnms);
          return;
          if (paramnms.jdField_c_of_type_Int == 11)
          {
            paramnms = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramnms.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramnms.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramnms);
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 2)
          {
            xbi.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 17)
          {
            xbi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 19)
          {
            xbi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 18)
          {
            xbi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 22)
          {
            a(paramnms.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramnms.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramnms.jdField_b_of_type_JavaLangString));
        Object localObject = new neu();
        ((neu)localObject).a(paramnms.jdField_b_of_type_JavaLangString);
        a((neu)localObject);
        return;
        if ((paramnms.jdField_c_of_type_Int != 1) && (paramnms.jdField_c_of_type_Int != 3) && (paramnms.jdField_c_of_type_Int != 9) && (paramnms.jdField_c_of_type_Int != 10) && (paramnms.jdField_c_of_type_Int != 12) && (paramnms.jdField_c_of_type_Int != 13) && (paramnms.jdField_c_of_type_Int != 14) && (paramnms.jdField_c_of_type_Int != 15) && (paramnms.jdField_c_of_type_Int != 16) && (paramnms.jdField_c_of_type_Int != 21)) {
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
 * Qualified Name:     ney
 * JD-Core Version:    0.7.0.1
 */