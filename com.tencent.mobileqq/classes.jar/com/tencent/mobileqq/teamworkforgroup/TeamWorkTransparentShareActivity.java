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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.IShareUtils;
import com.tencent.mobileqq.teamwork.IShareUtils.SharePanelListener;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
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
  implements Handler.Callback, IShareUtils.SharePanelListener
{
  public String a;
  public int b;
  public int c;
  Map<String, TeamWorkAuthorizeUinListAdapter.ItemData> d = new HashMap();
  public long e;
  public int f;
  public String g;
  public String h;
  public String i;
  protected String j = null;
  protected String k = null;
  protected String l = null;
  WXShareHelper.WXShareListener m;
  MqqHandler n;
  private int o;
  private ArrayList<TeamWorkAuthorizeUinListAdapter.ItemData> p;
  private IShareUtils q;
  private ITeamWorkHandler r;
  private String s;
  private boolean t = false;
  private String u;
  private int v = -1;
  private SharePolicyInfo w;
  private final MqqHandler x = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private ResultReceiver y;
  
  private void b()
  {
    this.n = new MqqHandler();
    this.app.setHandler(getClass(), this.x);
    if (this.q == null) {
      this.q = ((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getShareUtils(this, this.app);
    }
    if (!TextUtils.isEmpty(this.a))
    {
      if (TextUtils.isEmpty(this.j))
      {
        this.j = getString(2131917130);
        if (this.c == 2) {
          this.j = getString(2131917131);
        }
      }
      String str;
      if (TextUtils.isEmpty(this.k))
      {
        this.k = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
        str = TeamWorkManager.b();
        if (!TextUtils.isEmpty(str)) {
          this.k = str;
        }
        if (this.c == 2)
        {
          this.k = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
          str = TeamWorkManager.c();
          if (!TextUtils.isEmpty(str)) {
            this.k = str;
          }
        }
      }
      if (TextUtils.isEmpty(this.l))
      {
        this.l = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
        str = TeamWorkManager.d();
        if (!TextUtils.isEmpty(str)) {
          this.l = str;
        }
        if (this.c == 2)
        {
          this.l = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
          str = TeamWorkManager.e();
          if (!TextUtils.isEmpty(str)) {
            this.l = str;
          }
        }
      }
      this.q.a(this.a, this.s, this.j, "", this.c);
      if (this.t) {
        this.q.a(false);
      } else {
        this.q.a(true);
      }
      this.q.a(this);
      this.q.b();
      return;
    }
    finish();
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.s = localIntent.getStringExtra(TeamWorkConstants.a);
    this.j = localIntent.getStringExtra(TeamWorkConstants.b);
    this.k = localIntent.getStringExtra(TeamWorkConstants.c);
    this.l = localIntent.getStringExtra(TeamWorkConstants.d);
    this.a = localIntent.getStringExtra("team_work_pad_url");
    this.b = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.c = localIntent.getIntExtra("team_work_pad_type", -1);
    this.o = localIntent.getIntExtra("team_policy", -1);
    this.e = localIntent.getLongExtra("key_group_team_work_doc_group_uin", 0L);
    this.f = localIntent.getIntExtra("key_group_team_work_doc_domain_id", 0);
    this.g = localIntent.getStringExtra("key_group_team_work_doc_pad_id");
    this.h = localIntent.getStringExtra("key_team_work_title");
    this.i = localIntent.getStringExtra("troop_name");
    this.p = new ArrayList();
    this.t = localIntent.getBooleanExtra("team_is_my_document", false);
    this.u = localIntent.getStringExtra("from_activity");
    this.v = localIntent.getIntExtra("select_type", -1);
    this.w = ((SharePolicyInfo)getIntent().getParcelableExtra("team_work_auth_info"));
    if ((this.o == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo policy cannot be -1");
    }
    if ((this.b == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mPadListType cannot be -1");
    }
    this.y = ((ResultReceiver)getIntent().getParcelableExtra("key_result_receiver"));
  }
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt)
  {
    String str1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(this.a);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4;
    String str2;
    if (paramInt == 2)
    {
      localObject4 = getString(2131917132);
      if (TextUtils.isEmpty(this.k)) {
        localObject2 = localObject3;
      } else {
        localObject2 = this.k;
      }
      str2 = this.s;
      if (TextUtils.isEmpty(this.j)) {
        localObject3 = str1;
      } else {
        localObject3 = this.j;
      }
      ShareMsgHelper.a(this, 1001, 95, "web_share", "", (String)localObject2, str2, (String)localObject3, getString(2131894173, new Object[] { this.s }), str1, "web", null, null, null, "web", null, null, null, "https://docs.qq.com/desktop/favicon.ico", (String)localObject4, "", null, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
      finish();
      return;
    }
    if ((paramInt != 9) && (paramInt != 10))
    {
      if (paramInt == 12)
      {
        localObject3 = this.s;
        localObject2 = this.k;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(" (分享自#腾讯文档#) ");
          try
          {
            localObject3 = URLEncoder.encode(((StringBuilder)localObject4).toString(), "UTF-8");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("https://service.weibo.com/share/share.php?");
            ((StringBuilder)localObject4).append("title=");
            ((StringBuilder)localObject4).append((String)localObject3);
            localObject3 = ((StringBuilder)localObject4).toString();
            str1 = URLEncoder.encode(str1, "UTF-8");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("&url=");
            ((StringBuilder)localObject4).append(str1);
            str1 = ((StringBuilder)localObject4).toString();
            localObject2 = URLEncoder.encode((String)localObject2, "UTF-8");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(str1);
            ((StringBuilder)localObject3).append("&pic=");
            ((StringBuilder)localObject3).append((String)localObject2);
            str1 = ((StringBuilder)localObject3).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append("&_wv=0");
            str1 = ((StringBuilder)localObject2).toString();
            localObject2 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", str1);
            startActivity((Intent)localObject2);
          }
          catch (Exception localException)
          {
            QQToast.makeText(getApplicationContext(), 1, 2131916404, 0).show(getResources().getDimensionPixelSize(2131299920));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(" ==== share to weibo exp: ");
            ((StringBuilder)localObject2).append(localException.toString());
            QLog.e("TeamWorkTransparentShareActivity", 1, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          QQToast.makeText(getApplicationContext(), 1, 2131916404, 0).show(getResources().getDimensionPixelSize(2131299920));
        }
        finish();
        return;
      }
      if (paramInt == 11) {
        localObject3 = this.app.getCurrentAccountUin();
      }
    }
    try
    {
      localObject1 = URLEncoder.encode(this.a, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject1;
      label591:
      int i1;
      Bitmap localBitmap;
      break label591;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("TeamWorkTransparentShareActivity", 2, "encode shareUrl failed, because UTF-8 is unknown");
      localObject1 = localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&qq=");
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append("&_wv=7");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    startActivity((Intent)localObject2);
    finish();
    return;
    if (paramInt == 1)
    {
      localObject2 = (ClipboardManager)getSystemService("clipboard");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("我分享了腾讯文档 “");
      ((StringBuilder)localObject3).append(this.s);
      ((StringBuilder)localObject3).append("”，点击查看：\n");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" ");
      ((ClipboardManager)localObject2).setText((CharSequence)localObject3);
      QRUtils.a(2, 2131888247);
      finish();
      return;
    }
    if (paramInt == 26)
    {
      localObject2 = new Intent(this, DirectForwardActivity.class);
      ((Intent)localObject2).putExtra("isFromShare", true);
      ((Intent)localObject2).putExtra("isFromTeamWork", true);
      ((Intent)localObject2).putExtra("toUin", AppConstants.DATALINE_PC_UIN);
      ((Intent)localObject2).putExtra("uinType", 6000);
      ((Intent)localObject2).putExtra("forward_type", -1);
      ((Intent)localObject2).putExtra("forward_text", (String)localObject1);
      ((Intent)localObject2).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      startActivity((Intent)localObject2);
      finish();
      return;
      if (!WXShareHelper.a().b()) {
        i1 = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        i1 = 2131918155;
      } else {
        i1 = -1;
      }
      if (i1 != -1)
      {
        QRUtils.a(0, i1);
      }
      else
      {
        localObject3 = String.valueOf(System.currentTimeMillis());
        if (this.m == null) {
          this.m = new TeamWorkTransparentShareActivity.1(this, (String)localObject3);
        }
        if (paramInt == 9)
        {
          WXShareHelper.a().a(this.m);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pages/detail/detail?url=");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isBase64ImgFormatData(this.l))
          {
            localObject3 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getShareBitMapBase64(this.l);
            if (localObject3 != null) {
              WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", (Bitmap)localObject3, this.s, this.j, (String)localObject1);
            } else {
              WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.c), this.s, this.j, (String)localObject1);
            }
          }
          else
          {
            WXShareHelper.a().a((String)localObject2, "gh_252c5f06840b", ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.c), this.s, this.j, (String)localObject1);
          }
        }
        else if (paramInt == 10)
        {
          WXShareHelper.a().a(this.m);
          localObject4 = WXShareHelper.a();
          str2 = this.s;
          localBitmap = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.c);
          if (TextUtils.isEmpty(this.j)) {
            localObject2 = localObject1;
          } else {
            localObject2 = this.j;
          }
          if (paramInt == 9) {
            paramInt = 0;
          } else {
            paramInt = 1;
          }
          ((WXShareHelper)localObject4).a((String)localObject3, str2, localBitmap, (String)localObject2, (String)localObject1, paramInt);
        }
      }
      finish();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131629384);
    c();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.q.c();
    if (this.m != null)
    {
      WXShareHelper.a().b(this.m);
      this.m = null;
    }
    MqqHandler localMqqHandler = this.n;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void doOnStart()
  {
    Object localObject = this.w;
    if ((localObject != null) && (((SharePolicyInfo)localObject).d))
    {
      this.r = ((ITeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
      return;
    }
    localObject = this.q;
    if (localObject != null) {
      ((IShareUtils)localObject).a();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity
 * JD-Core Version:    0.7.0.1
 */