package com.tencent.mobileqq.businessCard.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class CardPicGalleryActivity
  extends BaseActivity
  implements View.OnClickListener
{
  View a;
  TextView b;
  Gallery c;
  ImageView d;
  boolean e;
  ArrayList<String> f;
  int g;
  Drawable h;
  int i = -1;
  ViewGroup j;
  int k;
  boolean l = false;
  protected int m = 1;
  long n;
  String o;
  String p;
  BaseAdapter q = new CardPicGalleryActivity.10(this);
  private boolean r = false;
  private SVIPObserver s = new CardPicGalleryActivity.11(this);
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new CardPicGalleryActivity.9(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void d(URLDrawable paramURLDrawable)
  {
    e(paramURLDrawable);
  }
  
  private void e(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new CardPicGalleryActivity.6(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      c(paramURLDrawable);
      return;
    }
    c(paramURLDrawable);
  }
  
  protected void a()
  {
    if ((this.m == 1) && (!this.e)) {
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null) {
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131430368)).getDrawable();
    if (localObject != null)
    {
      if (!(localObject instanceof URLDrawable)) {
        return;
      }
      localObject = (URLDrawable)localObject;
      if ((this.h == null) && (((URLDrawable)localObject).getStatus() != 1)) {
        return;
      }
      ActionSheet localActionSheet = ActionSheet.create(this);
      a(localActionSheet);
      localActionSheet.setOnButtonClickListener(new CardPicGalleryActivity.4(this, (URLDrawable)localObject, localActionSheet));
      localActionSheet.setOnBottomCancelListener(new CardPicGalleryActivity.5(this, localActionSheet));
      localActionSheet.show();
      if (2 == this.m)
      {
        if (this.app != null) {
          localObject = this.app.getCurrentAccountUin();
        } else {
          localObject = "";
        }
        VasWebviewUtil.a((String)localObject, "defaultcard", "click_more", "", 1, 0, 0, "", Integer.toString(this.k), "");
      }
    }
  }
  
  protected void a(int paramInt, URLDrawable paramURLDrawable)
  {
    int i1 = this.m;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      c(paramInt, paramURLDrawable);
      return;
    }
    b(paramInt, paramURLDrawable);
  }
  
  void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = b(paramURLDrawable);
    try
    {
      QfavBuilder.b(paramURLDrawable).a(this, this.app.getCurrentAccountUin());
      QfavReport.a(null, 40, 3);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "", paramURLDrawable);
      }
      QQToast.makeText(this, getString(2131889833), 0).show();
    }
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    String str = b(paramURLDrawable);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", paramString);
    localBundle.putString("forward_filepath", str);
    localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
    localBundle.putString("forward_extra", str);
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtras(localBundle);
    ForwardBaseOption.a(this, paramURLDrawable, 21);
  }
  
  protected void a(ActionSheet paramActionSheet)
  {
    int i1 = this.m;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      if ((this.k > 0) && (!this.l)) {
        paramActionSheet.addButton(2131890812);
      }
      paramActionSheet.addButton(2131890804);
      paramActionSheet.addButton(2131890810);
      paramActionSheet.addButton(2131890802);
      paramActionSheet.addCancelButton(2131887648);
      return;
    }
    paramActionSheet.addButton(2131896626);
    if (this.r) {
      paramActionSheet.addButton(2131896613, 3);
    }
    paramActionSheet.addCancelButton(2131887648);
  }
  
  String b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if (paramURLDrawable == null) {
      return null;
    }
    return paramURLDrawable.getAbsolutePath();
  }
  
  protected void b(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtra("delete_pic", true);
      setResult(-1, paramURLDrawable);
      finish();
      return;
    }
    d(paramURLDrawable);
  }
  
  protected void c(int paramInt, URLDrawable paramURLDrawable)
  {
    if ((this.k != 0) && (!this.l)) {
      break label24;
    }
    paramInt += 1;
    label24:
    Object localObject = "";
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            paramInt = 0;
          }
          else
          {
            a(paramURLDrawable);
            if (this.app != null) {
              localObject = this.app.getCurrentAccountUin();
            }
            VasWebviewUtil.a((String)localObject, "defaultcard", "collect", "", 1, 0, 0, "", Integer.toString(this.k), "");
            paramInt = 3;
          }
        }
        else
        {
          d(paramURLDrawable);
          if (this.app != null) {
            localObject = this.app.getCurrentAccountUin();
          }
          VasWebviewUtil.a((String)localObject, "defaultcard", "save", "", 1, 0, 0, "", Integer.toString(this.k), "");
          paramInt = 2;
        }
      }
      else
      {
        a(paramURLDrawable, (String)this.f.get(this.i));
        if (this.app != null) {
          localObject = this.app.getCurrentAccountUin();
        }
        VasWebviewUtil.a((String)localObject, "defaultcard", "send", "", 1, 0, 0, "", Integer.toString(this.k), "");
        paramInt = 1;
      }
    }
    else
    {
      if ((this.app != null) && (this.k > 0))
      {
        ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(this.k);
        if (this.app != null) {
          localObject = this.app.getCurrentAccountUin();
        }
        VasWebviewUtil.a((String)localObject, "defaultcard", "set_mydefaultcard", "", 1, 0, 0, "", Integer.toString(this.k), "");
      }
      paramInt = 5;
    }
    localObject = this.app;
    if (this.l) {
      paramURLDrawable = "1";
    } else {
      paramURLDrawable = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A88C", "0X800A88C", paramInt, 0, paramURLDrawable, "", "", "");
  }
  
  void c(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject).append(Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {}
    try
    {
      if (!localFile.createNewFile()) {
        break label177;
      }
      b(paramURLDrawable, localFile.getPath());
      return;
    }
    catch (IOException paramURLDrawable)
    {
      label92:
      break label92;
    }
    QQToast.makeText(this, getString(2131892637), 0).show();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131915885)).setMessage(getString(2131892633)).setPositiveButton(getString(2131915687), new CardPicGalleryActivity.8(this, paramURLDrawable, (String)localObject)).setNegativeButton(getString(2131892140), new CardPicGalleryActivity.7(this)).show();
    label177:
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {
      return;
    }
    if ((paramInt1 == 21) && (paramInt2 == -1))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627335);
    paramBundle = getIntent();
    this.f = paramBundle.getStringArrayListExtra("business_card_pics");
    this.e = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.m = paramBundle.getIntExtra("extra_mode", 1);
    this.g = paramBundle.getIntExtra("extra_default", 0);
    this.r = paramBundle.getBooleanExtra("is_from_profile", false);
    this.k = paramBundle.getIntExtra("default_card_id", 0);
    this.l = paramBundle.getBooleanExtra("is_from_mine_profile", false);
    this.a = findViewById(2131447587);
    UniformUtils.a(this, this.a);
    this.b = ((TextView)findViewById(2131429218));
    this.b.setOnClickListener(this);
    this.c = ((Gallery)findViewById(2131433934));
    this.d = ((ImageView)findViewById(2131433940));
    this.d.setOnClickListener(this);
    if ((this.m == 1) && (!this.e)) {
      this.d.setVisibility(8);
    }
    this.c.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.c.setAdapter(this.q);
    this.c.setOnItemSelectedListener(new CardPicGalleryActivity.1(this));
    this.j = ((ViewGroup)super.findViewById(2131430367));
    if (this.m == 2)
    {
      this.b.setVisibility(8);
      this.c.setOnItemClickListener(new CardPicGalleryActivity.2(this));
      this.c.setOnItemLongClickListener(new CardPicGalleryActivity.3(this));
      this.j.setOnClickListener(this);
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.n = ((SharedPreferences)localObject1).getLong("recommend_id", 0L);
      paramBundle = "";
      this.o = ((SharedPreferences)localObject1).getString("recommend_url", "");
      this.p = ((SharedPreferences)localObject1).getString("recommend_desc", "");
      Object localObject2 = (TextView)this.j.findViewById(2131447112);
      localObject1 = (ImageView)this.j.findViewById(2131435552);
      Drawable localDrawable = getResources().getDrawable(2130853415);
      if ((!TextUtils.isEmpty(this.o)) && (!TextUtils.isEmpty(this.p)))
      {
        ((TextView)localObject2).setText(this.p);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.dip2px(75.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.dip2px(80.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(this.o, (URLDrawable.URLDrawableOptions)localObject2));
      }
      else
      {
        ((TextView)localObject2).setText(HardCodeUtil.a(2131899691));
        ((ImageView)localObject1).setImageDrawable(localDrawable);
      }
      if (this.l) {
        this.j.setVisibility(8);
      }
      localObject1 = this.app;
      if (this.app != null) {
        paramBundle = this.app.getCurrentAccountUin();
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.n), "", "", "");
      paramBundle = this.app;
      int i1;
      if (this.l) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(paramBundle, "dc00898", "", "", "0X800A88B", "0X800A88B", i1, 0, "", "", "", "");
    }
    else
    {
      this.j.setVisibility(8);
    }
    addObserver(this.s);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (((MessageRoamManager)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).c(hashCode()))) {
      this.app.removeHandler(getClass());
    }
    removeObserver(this.s);
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772510);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d)
    {
      a();
    }
    else if (paramView == this.b)
    {
      onBackEvent();
    }
    else if (paramView == this.j)
    {
      Object localObject1 = this.app.getCurrentAccountUin();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recommendId=");
      ((StringBuilder)localObject2).append(this.n);
      ProfileCardUtil.a(this, (String)localObject1, "inside.friendCardBackground", 1, 1, 1, ((StringBuilder)localObject2).toString(), false);
      QQAppInterface localQQAppInterface = this.app;
      localObject1 = this.app;
      localObject2 = "";
      if (localObject1 != null) {
        localObject1 = this.app.getCurrentAccountUin();
      } else {
        localObject1 = "";
      }
      ReportController.b(localQQAppInterface, "CliOper", "", (String)localObject1, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.n), "", "", "");
      localObject1 = localObject2;
      if (this.app != null) {
        localObject1 = this.app.getCurrentAccountUin();
      }
      VasWebviewUtil.a((String)localObject1, "defaultcard", "click_card_others", "", 1, 0, 0, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity
 * JD-Core Version:    0.7.0.1
 */