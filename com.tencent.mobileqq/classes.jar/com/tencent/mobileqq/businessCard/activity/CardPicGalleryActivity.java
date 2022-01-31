package com.tencent.mobileqq.businessCard.activity;

import abut;
import abuu;
import abuv;
import abuw;
import abux;
import abuy;
import abuz;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CardPicGalleryActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  long jdField_a_of_type_Long;
  public Drawable a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new abuz(this);
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public boolean a;
  public int b;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public int c = 1;
  
  public CardPicGalleryActivity()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new abuy(this, paramURLDrawable, paramString).execute(new Void[0]);
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
    if ((this.c == 1) && (!this.jdField_a_of_type_Boolean)) {}
    label15:
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label15;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentWidgetGallery == null);
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
        } while (localObject == null);
        localObject = ((ImageView)((View)localObject).findViewById(2131369879)).getDrawable();
      } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
      localObject = (URLDrawable)localObject;
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
    ActionSheet localActionSheet = ActionSheet.a(this);
    a(localActionSheet);
    localActionSheet.a(new abuv(this, (URLDrawable)localObject, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (this.c)
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
      QQToast.a(this, getString(2131434515), 0).a();
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
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      paramActionSheet.b(2131437125);
      paramActionSheet.b(2131437120);
      paramActionSheet.b(2131437101);
      if (this.jdField_b_of_type_Boolean) {
        paramActionSheet.a(2131437118, 3);
      }
      paramActionSheet.c(2131433029);
      return;
    }
    paramActionSheet.b(2131435887);
    paramActionSheet.b(2131435893);
    paramActionSheet.b(2131435891);
    paramActionSheet.c(2131433029);
  }
  
  protected void b(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramURLDrawable);
      return;
    case 1: 
      paramURLDrawable = new Intent(getActivity(), FlowCameraPhotoActivity.class);
      paramURLDrawable.putExtra("extra_return_result", true);
      startActivityForResult(paramURLDrawable, 10);
      return;
    case 2: 
      BusinessCardUtils.a(this.app, this);
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
      new File(AppConstants.aQ).mkdirs();
      str = AppConstants.aQ + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131434599), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131434602)).setMessage(getString(2131434604)).setPositiveButton(getString(2131434603), new abux(this, paramURLDrawable, str)).setNegativeButton(getString(2131433026), new abuw(this)).show();
  }
  
  protected void c(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramURLDrawable, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int));
      return;
    case 1: 
      b(paramURLDrawable);
      return;
    }
    a(paramURLDrawable);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {
      if ((paramIntent != null) && ((CardOCRInfo)paramIntent.getParcelableExtra("extra_return_ocr_info") != null))
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while ((paramInt1 != 21) || (paramInt2 != -1)) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970271);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("business_card_pics");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.c = paramBundle.getIntExtra("extra_mode", 1);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_default", 0);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_from_profile", false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368104));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131364823));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369119));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.c == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131558524));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new abut(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131369877));
    if (this.c == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new abuu(this));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.jdField_a_of_type_Long = paramBundle.getLong("recommend_id", 0L);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("recommend_url", "");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("recommend_desc", "");
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369878);
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364688);
      Drawable localDrawable = getResources().getDrawable(2130839147);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        paramBundle.setText(this.jdField_b_of_type_JavaLangString);
        ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localDrawable, localDrawable));
        localObject = this.app;
        if (this.app == null) {
          break label464;
        }
      }
      label464:
      for (paramBundle = this.app.getCurrentAccountUin();; paramBundle = "")
      {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        return true;
        paramBundle.setText("去设置个性名片");
        ((ImageView)localObject).setImageDrawable(localDrawable);
        break;
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (((MessageRoamManager)this.app.getManager(91)).a(hashCode()))) {
      this.app.removeHandler(getClass());
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Intent localIntent = new Intent(this, FlowCameraPhotoActivity.class);
      localIntent.putExtra("is_upload_photo", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramIntent);
      localIntent.putExtra("extra_return_result", true);
      startActivityForResult(localIntent, 10);
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2131034423);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      a();
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        onBackEvent();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidViewViewGroup);
    ProfileCardUtil.a(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.jdField_a_of_type_Long, false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.app != null) {}
    for (paramView = this.app.getCurrentAccountUin();; paramView = "")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", paramView, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity
 * JD-Core Version:    0.7.0.1
 */