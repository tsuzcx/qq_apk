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
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new CardPicGalleryActivity.10(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new CardPicGalleryActivity.11(this);
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  protected int d = 1;
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new CardPicGalleryActivity.9(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c(URLDrawable paramURLDrawable)
  {
    d(paramURLDrawable);
  }
  
  private void d(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new CardPicGalleryActivity.6(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramURLDrawable);
      return;
    }
    b(paramURLDrawable);
  }
  
  String a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if (paramURLDrawable == null) {
      return null;
    }
    return paramURLDrawable.getAbsolutePath();
  }
  
  protected void a()
  {
    if ((this.d == 1) && (!this.jdField_a_of_type_Boolean)) {}
    label15:
    do
    {
      do
      {
        do
        {
          do
          {
            break label15;
            break label15;
            do
            {
              return;
            } while (this.jdField_a_of_type_ComTencentWidgetGallery == null);
            localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
          } while (localObject == null);
          localObject = ((ImageView)((View)localObject).findViewById(2131364450)).getDrawable();
        } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
        localObject = (URLDrawable)localObject;
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
      ActionSheet localActionSheet = ActionSheet.create(this);
      a(localActionSheet);
      localActionSheet.setOnButtonClickListener(new CardPicGalleryActivity.4(this, (URLDrawable)localObject, localActionSheet));
      localActionSheet.setOnBottomCancelListener(new CardPicGalleryActivity.5(this, localActionSheet));
      localActionSheet.show();
    } while (2 != this.d);
    if (this.app != null) {}
    for (Object localObject = this.app.getCurrentAccountUin();; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "defaultcard", "click_more", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
      return;
    }
  }
  
  protected void a(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      b(paramInt, paramURLDrawable);
      return;
    }
    c(paramInt, paramURLDrawable);
  }
  
  void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
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
      QQToast.a(this, getString(2131692807), 0).a();
    }
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    String str = a(paramURLDrawable);
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
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      paramActionSheet.addButton(2131698611);
      if (this.jdField_c_of_type_Boolean) {
        paramActionSheet.addButton(2131698598, 3);
      }
      paramActionSheet.addCancelButton(2131690800);
      return;
    }
    if ((this.jdField_c_of_type_Int > 0) && (!this.jdField_b_of_type_Boolean)) {
      paramActionSheet.addButton(2131693310);
    }
    paramActionSheet.addButton(2131693302);
    paramActionSheet.addButton(2131693308);
    paramActionSheet.addButton(2131693300);
    paramActionSheet.addCancelButton(2131690800);
  }
  
  protected void b(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      c(paramURLDrawable);
      return;
    }
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtra("delete_pic", true);
    setResult(-1, paramURLDrawable);
    finish();
  }
  
  void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
      str = AppConstants.SDCARD_IMG_SAVE + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131694921), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131718675)).setMessage(getString(2131694917)).setPositiveButton(getString(2131718540), new CardPicGalleryActivity.8(this, paramURLDrawable, str)).setNegativeButton(getString(2131694495), new CardPicGalleryActivity.7(this)).show();
  }
  
  protected void c(int paramInt, URLDrawable paramURLDrawable)
  {
    int i;
    if (this.jdField_c_of_type_Int != 0)
    {
      i = paramInt;
      if (!this.jdField_b_of_type_Boolean) {}
    }
    else
    {
      i = paramInt + 1;
    }
    paramInt = 0;
    switch (i)
    {
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramURLDrawable = "1";; paramURLDrawable = "2")
      {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", paramInt, 0, paramURLDrawable, "", "", "");
        return;
        if ((this.app == null) || (this.jdField_c_of_type_Int <= 0)) {
          break label371;
        }
        ((SVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(this.jdField_c_of_type_Int);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "set_mydefaultcard", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
          paramInt = 5;
          break;
        }
        a(paramURLDrawable, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int));
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "send", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
          paramInt = 1;
          break;
        }
        c(paramURLDrawable);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "save", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
          paramInt = 2;
          break;
        }
        a(paramURLDrawable);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "collect", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
          paramInt = 3;
          break;
        }
      }
      label371:
      paramInt = 5;
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {}
    while ((paramInt1 != 21) || (paramInt2 != -1)) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561130);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("business_card_pics");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.d = paramBundle.getIntExtra("extra_mode", 1);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_default", 0);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_from_profile", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("default_card_id", 0);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_from_mine_profile", false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379538);
    UniformUtils.a(this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363408));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367677));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367683));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.d == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297168));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new CardPicGalleryActivity.1(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131364449));
    Object localObject2;
    Object localObject1;
    label536:
    int i;
    if (this.d == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new CardPicGalleryActivity.2(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new CardPicGalleryActivity.3(this));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.jdField_a_of_type_Long = paramBundle.getLong("recommend_id", 0L);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("recommend_url", "");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("recommend_desc", "");
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379127);
      paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368914);
      localObject1 = getResources().getDrawable(2130851250);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.a(75.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.a(80.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        paramBundle.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        }
        localObject1 = this.app;
        if (this.app == null) {
          break label637;
        }
        paramBundle = this.app.getCurrentAccountUin();
        ReportController.b((AppRuntime)localObject1, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        paramBundle = this.app;
        if (!this.jdField_b_of_type_Boolean) {
          break label643;
        }
        i = 1;
        label581:
        ReportController.b(paramBundle, "dc00898", "", "", "0X800A88B", "0X800A88B", i, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      return true;
      ((TextView)localObject2).setText(HardCodeUtil.a(2131701529));
      paramBundle.setImageDrawable((Drawable)localObject1);
      break;
      label637:
      paramBundle = "";
      break label536;
      label643:
      i = 2;
      break label581;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (((MessageRoamManager)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(hashCode()))) {
      this.app.removeHandler(getClass());
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772375);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      a();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetTextView) {
          break;
        }
        onBackEvent();
      }
    } while (paramView != this.jdField_a_of_type_AndroidViewViewGroup);
    ProfileCardUtil.a(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.jdField_a_of_type_Long, false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.app != null)
    {
      str = this.app.getCurrentAccountUin();
      label105:
      ReportController.b(localQQAppInterface, "CliOper", "", str, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
      if (this.app == null) {
        break label180;
      }
    }
    label180:
    for (String str = this.app.getCurrentAccountUin();; str = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "defaultcard", "click_card_others", "", 1, 0, 0, "", "", "");
      break;
      str = "";
      break label105;
    }
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