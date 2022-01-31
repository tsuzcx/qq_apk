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

public class mua
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = mua.class.getSimpleName();
  
  public mua(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(mtw parammtw)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", oby.a(parammtw.jdField_a_of_type_Mtx.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(parammtw.jdField_a_of_type_Mtz.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(parammtw.jdField_a_of_type_Mtx.jdField_b_of_type_JavaLangString));
    if ((parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_Int == 2) || (parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", wmi.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", parammtw.jdField_a_of_type_Mtz.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(parammtw.jdField_a_of_type_Mtx.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", parammtw.jdField_a_of_type_Mtz.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", parammtw.jdField_a_of_type_Mtz.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", parammtw.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", oby.a(parammtw.jdField_a_of_type_Mtx.c));
    localBundle2.putString("brief_key", parammtw.jdField_a_of_type_JavaLangString);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)awuw.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", parammtw.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private String a()
  {
    int i = rtr.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private wmk a()
  {
    wmk localwmk = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localwmk = new wmk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localwmk;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new wmi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131690181);
    localDialog.setContentView(2131495138);
    ((TextView)localDialog.findViewById(2131299617)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131299606);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131299604);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131299610);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131625035);
    localTextView3.setText(2131626068);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new mub(this, localDialog));
    localTextView3.setOnClickListener(new muc(this, paramString));
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
    localIntent.putExtra("big_brother_source_key", rtr.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(mtw parammtw)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131630481, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + parammtw.jdField_a_of_type_Mtx.a + ",vid : " + parammtw.jdField_a_of_type_Mtz.jdField_c_of_type_JavaLangString);
    }
    parammtw = a(parammtw);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(parammtw);
    localActivity.overridePendingTransition(2130772036, 2130772038);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(nbu paramnbu)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramnbu.jdField_a_of_type_Int + ", event_id:" + paramnbu.jdField_c_of_type_Int);
    }
    if (paramnbu.jdField_a_of_type_Int == 1) {
      a(paramnbu.jdField_c_of_type_JavaLangString);
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
                } while (paramnbu.jdField_a_of_type_Int != 3);
                if (paramnbu.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramnbu.g)) || (TextUtils.isEmpty(paramnbu.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramnbu.g);
              ((Intent)localObject).putExtra("lon", paramnbu.f);
              if (!TextUtils.isEmpty(paramnbu.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramnbu.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramnbu.jdField_c_of_type_Int != 8) {
                break;
              }
              paramnbu = paramnbu.h;
            } while (TextUtils.isEmpty(paramnbu));
            paramnbu = paramnbu.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramnbu).matches());
          b(paramnbu);
          return;
          if (paramnbu.jdField_c_of_type_Int == 11)
          {
            paramnbu = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramnbu.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramnbu.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramnbu);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 2)
          {
            wmi.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new wmk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 17)
          {
            wmi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new wmk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 19)
          {
            wmi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new wmk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 18)
          {
            wmi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new wmk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 22)
          {
            a(paramnbu.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramnbu.jdField_b_of_type_JavaLangString));
        Object localObject = new mtw();
        ((mtw)localObject).a(paramnbu.jdField_b_of_type_JavaLangString);
        a((mtw)localObject);
        return;
        if ((paramnbu.jdField_c_of_type_Int != 1) && (paramnbu.jdField_c_of_type_Int != 3) && (paramnbu.jdField_c_of_type_Int != 9) && (paramnbu.jdField_c_of_type_Int != 10) && (paramnbu.jdField_c_of_type_Int != 12) && (paramnbu.jdField_c_of_type_Int != 13) && (paramnbu.jdField_c_of_type_Int != 14) && (paramnbu.jdField_c_of_type_Int != 15) && (paramnbu.jdField_c_of_type_Int != 16) && (paramnbu.jdField_c_of_type_Int != 21)) {
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
 * Qualified Name:     mua
 * JD-Core Version:    0.7.0.1
 */