package com.tencent.mobileqq.teamworkforgroup;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class TeamWorkTransparentShareActivity
  extends BaseActivity
  implements Handler.Callback, ShareUtils.SharePanelListener
{
  public int a;
  public long a;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  private TeamWorkHandler jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler;
  private ShareUtils jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public String a;
  private ArrayList<TeamWorkAuthorizeUinListAdapter.ItemData> jdField_a_of_type_JavaUtilArrayList;
  Map<String, TeamWorkAuthorizeUinListAdapter.ItemData> jdField_a_of_type_JavaUtilMap = new HashMap();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  public String b;
  private final MqqHandler b;
  public int c;
  public String c;
  private int d;
  public String d;
  private int e;
  protected String e;
  protected String f = null;
  protected String g = null;
  private String h;
  private String i;
  
  public TeamWorkTransparentShareActivity()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils == null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils = new ShareUtils(this, this.app);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_e_of_type_JavaLangString = getString(2131719842);
        if (this.jdField_b_of_type_Int == 2) {
          this.jdField_e_of_type_JavaLangString = getString(2131719843);
        }
      }
      String str;
      if (TextUtils.isEmpty(this.f))
      {
        this.f = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
        str = TeamWorkManager.a();
        if (!TextUtils.isEmpty(str)) {
          this.f = str;
        }
        if (this.jdField_b_of_type_Int == 2)
        {
          this.f = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
          str = TeamWorkManager.b();
          if (!TextUtils.isEmpty(str)) {
            this.f = str;
          }
        }
      }
      if (TextUtils.isEmpty(this.g))
      {
        this.g = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
        str = TeamWorkManager.c();
        if (!TextUtils.isEmpty(str)) {
          this.g = str;
        }
        if (this.jdField_b_of_type_Int == 2)
        {
          this.g = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
          str = TeamWorkManager.d();
          if (!TextUtils.isEmpty(str)) {
            this.g = str;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.a(this.jdField_a_of_type_JavaLangString, this.h, this.jdField_e_of_type_JavaLangString, "", this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.a(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.a(this);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.a(true);
      }
    }
    finish();
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.h = localIntent.getStringExtra(TeamWorkConstants.jdField_a_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra(TeamWorkConstants.jdField_b_of_type_JavaLangString);
    this.f = localIntent.getStringExtra(TeamWorkConstants.jdField_c_of_type_JavaLangString);
    this.g = localIntent.getStringExtra(TeamWorkConstants.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("team_work_pad_url");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("team_work_pad_type", -1);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("team_policy", -1);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("key_group_team_work_doc_group_uin", 0L);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("key_group_team_work_doc_domain_id", 0);
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key_group_team_work_doc_pad_id");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("key_team_work_title");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("troop_name");
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("team_is_my_document", false);
    this.i = localIntent.getStringExtra("from_activity");
    this.jdField_e_of_type_Int = localIntent.getIntExtra("select_type", -1);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = ((SharePolicyInfo)getIntent().getParcelableExtra("team_work_auth_info"));
    if ((this.jdField_d_of_type_Int == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo policy cannot be -1");
    }
    if ((this.jdField_a_of_type_Int == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mPadListType cannot be -1");
    }
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)getIntent().getParcelableExtra("key_result_receiver"));
  }
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt)
  {
    String str1 = TeamWorkUtils.c(this.jdField_a_of_type_JavaLangString);
    Object localObject4;
    String str3;
    Object localObject5;
    Object localObject3;
    if (paramInt == 2)
    {
      localObject4 = TeamWorkUtils.jdField_d_of_type_JavaLangString;
      str3 = getString(2131719844);
      if (TextUtils.isEmpty(this.f))
      {
        localObject2 = null;
        localObject5 = this.h;
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label139;
        }
        localObject3 = str1;
        label59:
        ShareMsgHelper.a(this, 1001, 95, "web_share", "", (String)localObject2, (String)localObject5, (String)localObject3, getString(2131696382, new Object[] { this.h }), str1, "web", null, null, null, "web", null, null, null, (String)localObject4, str3, "", null, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        finish();
      }
    }
    label139:
    label206:
    label382:
    Object localObject1;
    label431:
    label466:
    do
    {
      return;
      localObject2 = this.f;
      break;
      localObject3 = this.jdField_e_of_type_JavaLangString;
      break label59;
      if ((paramInt == 9) || (paramInt == 10))
      {
        int j = -1;
        if (!WXShareHelper.a().a())
        {
          j = 2131720753;
          if (j == -1) {
            break label206;
          }
          QRUtils.a(0, j);
        }
        do
        {
          for (;;)
          {
            finish();
            return;
            if (WXShareHelper.a().b()) {
              break;
            }
            j = 2131720754;
            break;
            localObject3 = String.valueOf(System.currentTimeMillis());
            if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null) {
              this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new TeamWorkTransparentShareActivity.1(this, (String)localObject3);
            }
            if (paramInt != 9) {
              break label382;
            }
            WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
            localObject2 = "pages/detail/detail?url=" + str1;
            if (TeamWorkUtils.d(this.g))
            {
              localObject3 = TeamWorkUtils.a(this.g);
              if (localObject3 != null) {
                WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", (Bitmap)localObject3, this.h, this.jdField_e_of_type_JavaLangString, str1);
              } else {
                WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", TeamWorkUtils.a(this.jdField_b_of_type_Int), this.h, this.jdField_e_of_type_JavaLangString, str1);
              }
            }
            else
            {
              WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", TeamWorkUtils.a(this.jdField_b_of_type_Int), this.h, this.jdField_e_of_type_JavaLangString, str1);
            }
          }
        } while (paramInt != 10);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
        localObject4 = WXShareHelper.a();
        str3 = this.h;
        localObject5 = TeamWorkUtils.a(this.jdField_b_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          localObject2 = str1;
          if (paramInt != 9) {
            break label466;
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          ((WXShareHelper)localObject4).b((String)localObject3, str3, (Bitmap)localObject5, (String)localObject2, str1, paramInt);
          break;
          localObject2 = this.jdField_e_of_type_JavaLangString;
          break label431;
        }
      }
      if (paramInt == 12)
      {
        localObject3 = this.h;
        localObject2 = this.f;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3).append(" (分享自#腾讯文档#) ");
        }
        for (;;)
        {
          try
          {
            localObject3 = URLEncoder.encode(((StringBuilder)localObject4).toString(), "UTF-8");
            localObject3 = "https://service.weibo.com/share/share.php?" + "title=" + (String)localObject3;
            str1 = URLEncoder.encode(str1, "UTF-8");
            str1 = (String)localObject3 + "&url=" + str1;
            localObject2 = URLEncoder.encode((String)localObject2, "UTF-8");
            str1 = str1 + "&pic=" + (String)localObject2;
            str1 = str1 + "&_wv=0";
            localObject2 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", str1);
            startActivity((Intent)localObject2);
            finish();
            return;
          }
          catch (Exception localException)
          {
            QQToast.a(getApplicationContext(), 1, 2131719153, 0).b(getResources().getDimensionPixelSize(2131299166));
            QLog.e("TeamWorkTransparentShareActivity", 1, " ==== share to weibo exp: " + localException.toString());
            continue;
          }
          QQToast.a(getApplicationContext(), 1, 2131719153, 0).b(getResources().getDimensionPixelSize(2131299166));
        }
      }
      if (paramInt == 11)
      {
        localObject3 = this.app.getCurrentAccountUin();
        localObject2 = null;
        try
        {
          String str2 = URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "UTF-8");
          str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str2 + "&qq=" + (String)localObject3 + "&_wv=7";
          localObject2 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", str2);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          startActivity((Intent)localObject2);
          finish();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("TeamWorkTransparentShareActivity", 2, "encode shareUrl failed, because UTF-8 is unknown");
              localObject1 = localObject2;
            }
          }
        }
      }
      if (paramInt == 1)
      {
        localObject2 = (ClipboardManager)getSystemService("clipboard");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("我分享了腾讯文档 “").append(this.h).append("”，点击查看：\n").append(localObject1).append(" ");
        ((ClipboardManager)localObject2).setText((CharSequence)localObject3);
        QRUtils.a(2, 2131691374);
        finish();
        return;
      }
    } while (paramInt != 26);
    Object localObject2 = new Intent(this, DirectForwardActivity.class);
    ((Intent)localObject2).putExtra("isFromShare", true);
    ((Intent)localObject2).putExtra("isFromTeamWork", true);
    ((Intent)localObject2).putExtra("toUin", AppConstants.DATALINE_PC_UIN);
    ((Intent)localObject2).putExtra("uinType", 6000);
    ((Intent)localObject2).putExtra("forward_type", -1);
    ((Intent)localObject2).putExtra("forward_text", localObject1);
    ((Intent)localObject2).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    startActivity((Intent)localObject2);
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563098);
    c();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.c();
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void doOnStart()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler = ((TeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils.b();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity
 * JD-Core Version:    0.7.0.1
 */