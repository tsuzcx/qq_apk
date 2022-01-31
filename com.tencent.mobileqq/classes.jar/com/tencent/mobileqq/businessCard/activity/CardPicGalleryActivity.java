package com.tencent.mobileqq.businessCard.activity;

import aciy;
import ajed;
import ajjy;
import ajmp;
import ajrm;
import ajrp;
import akxi;
import alpo;
import alpp;
import alpq;
import alpr;
import alps;
import alpt;
import alpu;
import alpv;
import alpw;
import alpx;
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
import aphp;
import awqx;
import azyk;
import babr;
import bafb;
import bajq;
import bbmy;
import begr;
import bfhl;
import bfhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
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
  private ajrp jdField_a_of_type_Ajrp = new alpp(this);
  public Drawable a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new alpx(this);
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  String b;
  public boolean b;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  public int d = 1;
  
  public CardPicGalleryActivity()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new alpw(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  String a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if (paramURLDrawable == null) {
      return null;
    }
    return paramURLDrawable.getAbsolutePath();
  }
  
  public void a()
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
          localObject = ((ImageView)((View)localObject).findViewById(2131298386)).getDrawable();
        } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
        localObject = (URLDrawable)localObject;
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
      begr localbegr = begr.a(this);
      a(localbegr);
      localbegr.a(new alps(this, (URLDrawable)localObject, localbegr));
      localbegr.a(new alpt(this, localbegr));
      localbegr.show();
    } while (2 != this.d);
    if (this.app != null) {}
    for (Object localObject = this.app.getCurrentAccountUin();; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "defaultcard", "click_more", "", 1, 0, 0, "", Integer.toString(this.jdField_c_of_type_Int), "");
      return;
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
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
  
  protected void a(begr parambegr)
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      parambegr.b(2131632894);
      if (this.jdField_c_of_type_Boolean) {
        parambegr.a(2131632876, 3);
      }
      parambegr.c(2131625035);
      return;
    }
    if ((this.jdField_c_of_type_Int > 0) && (!this.jdField_b_of_type_Boolean)) {
      parambegr.b(2131627756);
    }
    parambegr.b(2131627742);
    parambegr.b(2131627752);
    parambegr.b(2131627740);
    parambegr.c(2131625035);
  }
  
  void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
    try
    {
      bfhl.b(paramURLDrawable).a(this, this.app.getCurrentAccountUin());
      bfhz.a(null, 40, 3);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "", paramURLDrawable);
      }
      bbmy.a(this, getString(2131627263), 0).a();
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
    aphp.a(this, paramURLDrawable, 21);
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
      new File(ajed.ba).mkdirs();
      str = ajed.ba + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          bbmy.a(this, getString(2131629508), 0).a();
          return;
        }
      }
    }
    babr.a(this, 230).setTitle(getString(2131653010)).setMessage(getString(2131629501)).setPositiveButton(getString(2131652888), new alpv(this, paramURLDrawable, str)).setNegativeButton(getString(2131628983), new alpu(this)).show();
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
        awqx.b(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", paramInt, 0, paramURLDrawable, "", "", "");
        return;
        if ((this.app == null) || (this.jdField_c_of_type_Int <= 0)) {
          break label370;
        }
        ((ajrm)this.app.a(13)).g(this.jdField_c_of_type_Int);
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
        b(paramURLDrawable);
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
      label370:
      paramInt = 5;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {}
    while ((paramInt1 != 21) || (paramInt2 != -1)) {
      return;
    }
    Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131495098);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("business_card_pics");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.d = paramBundle.getIntExtra("extra_mode", 1);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_default", 0);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_from_profile", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("default_card_id", 0);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_from_mine_profile", false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131311631);
    akxi.a(this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297449));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131301286));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301291));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.d == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131165934));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new alpo(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131298385));
    Object localObject2;
    Object localObject1;
    label536:
    int i;
    if (this.d == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new alpq(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new alpr(this));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.jdField_a_of_type_Long = paramBundle.getLong("recommend_id", 0L);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("recommend_url", "");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("recommend_desc", "");
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311254);
      paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302334);
      localObject1 = getResources().getDrawable(2130849385);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bajq.a(75.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bajq.a(80.0F);
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
        awqx.b((QQAppInterface)localObject1, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        paramBundle = this.app;
        if (!this.jdField_b_of_type_Boolean) {
          break label643;
        }
        i = 1;
        label581:
        awqx.b(paramBundle, "dc00898", "", "", "0X800A88B", "0X800A88B", i, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_Ajrp);
      return true;
      ((TextView)localObject2).setText(ajjy.a(2131635661));
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
    if ((this.app != null) && (((ajmp)this.app.getManager(92)).a(hashCode()))) {
      this.app.removeHandler(getClass());
    }
    removeObserver(this.jdField_a_of_type_Ajrp);
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772327);
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
    azyk.a(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.jdField_a_of_type_Long, false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.app != null)
    {
      paramView = this.app.getCurrentAccountUin();
      awqx.b(localQQAppInterface, "CliOper", "", paramView, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
      if (this.app == null) {
        break label169;
      }
    }
    label169:
    for (paramView = this.app.getCurrentAccountUin();; paramView = "")
    {
      VasWebviewUtil.reportCommercialDrainage(paramView, "defaultcard", "click_card_others", "", 1, 0, 0, "", "", "");
      return;
      paramView = "";
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity
 * JD-Core Version:    0.7.0.1
 */