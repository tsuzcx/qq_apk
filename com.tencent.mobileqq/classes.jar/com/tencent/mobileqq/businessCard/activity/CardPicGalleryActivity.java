package com.tencent.mobileqq.businessCard.activity;

import aekt;
import aljq;
import alpo;
import alsl;
import alxl;
import alxo;
import ancj;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import anvc;
import anvd;
import anve;
import anvf;
import anvg;
import anvh;
import anvi;
import anvj;
import anvk;
import anvl;
import anvm;
import arum;
import azmj;
import bcyw;
import bdcd;
import bdfq;
import bdkf;
import bhpy;
import biqt;
import birh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
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
  private alxo jdField_a_of_type_Alxo = new anve(this);
  public Drawable a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new anvd(this);
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
    new anvm(this, paramURLDrawable, paramString).execute(new Void[0]);
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
        requestPermissions(new anvj(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
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
          localObject = ((ImageView)((View)localObject).findViewById(2131363999)).getDrawable();
        } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
        localObject = (URLDrawable)localObject;
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
      bhpy localbhpy = bhpy.a(this);
      a(localbhpy);
      localbhpy.a(new anvh(this, (URLDrawable)localObject, localbhpy));
      localbhpy.a(new anvi(this, localbhpy));
      localbhpy.show();
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
  
  protected void a(bhpy parambhpy)
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      parambhpy.b(2131698937);
      if (this.jdField_c_of_type_Boolean) {
        parambhpy.a(2131698919, 3);
      }
      parambhpy.c(2131690648);
      return;
    }
    if ((this.jdField_c_of_type_Int > 0) && (!this.jdField_b_of_type_Boolean)) {
      parambhpy.b(2131693499);
    }
    parambhpy.b(2131693485);
    parambhpy.b(2131693495);
    parambhpy.b(2131693483);
    parambhpy.c(2131690648);
  }
  
  void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
    try
    {
      biqt.b(paramURLDrawable).a(this, this.app.getCurrentAccountUin());
      birh.a(null, 40, 3);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "", paramURLDrawable);
      }
      QQToast.a(this, getString(2131692986), 0).a();
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
    arum.a(this, paramURLDrawable, 21);
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
  
  public void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(aljq.bd).mkdirs();
      str = aljq.bd + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131695348), 0).a();
          return;
        }
      }
    }
    bdcd.a(this, 230).setTitle(getString(2131719323)).setMessage(getString(2131695341)).setPositiveButton(getString(2131719197), new anvl(this, paramURLDrawable, str)).setNegativeButton(getString(2131694804), new anvk(this)).show();
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
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", paramInt, 0, paramURLDrawable, "", "", "");
        return;
        if ((this.app == null) || (this.jdField_c_of_type_Int <= 0)) {
          break label370;
        }
        ((alxl)this.app.a(13)).g(this.jdField_c_of_type_Int);
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
    Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131560848);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("business_card_pics");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.d = paramBundle.getIntExtra("extra_mode", 1);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_default", 0);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_from_profile", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("default_card_id", 0);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_from_mine_profile", false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377981);
    ancj.a(this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363024));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367010));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367016));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.d == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297026));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new anvc(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131363998));
    Object localObject2;
    Object localObject1;
    label536:
    int i;
    if (this.d == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new anvf(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new anvg(this));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.jdField_a_of_type_Long = paramBundle.getLong("recommend_id", 0L);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("recommend_url", "");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("recommend_desc", "");
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377588);
      paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368090);
      localObject1 = getResources().getDrawable(2130850064);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bdkf.a(75.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bdkf.a(80.0F);
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
        azmj.b((QQAppInterface)localObject1, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        paramBundle = this.app;
        if (!this.jdField_b_of_type_Boolean) {
          break label643;
        }
        i = 1;
        label581:
        azmj.b(paramBundle, "dc00898", "", "", "0X800A88B", "0X800A88B", i, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_Alxo);
      return true;
      ((TextView)localObject2).setText(alpo.a(2131701829));
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
    if ((this.app != null) && (((alsl)this.app.getManager(92)).a(hashCode()))) {
      this.app.removeHandler(getClass());
    }
    removeObserver(this.jdField_a_of_type_Alxo);
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772344);
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
    bcyw.a(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.jdField_a_of_type_Long, false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.app != null)
    {
      paramView = this.app.getCurrentAccountUin();
      azmj.b(localQQAppInterface, "CliOper", "", paramView, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity
 * JD-Core Version:    0.7.0.1
 */