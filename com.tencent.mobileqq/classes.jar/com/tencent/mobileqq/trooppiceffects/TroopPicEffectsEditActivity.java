package com.tencent.mobileqq.trooppiceffects;

import Override;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import anvx;
import azjv;
import azke;
import azkn;
import azko;
import bggl;
import bggx;
import bgkn;
import bgko;
import bgla;
import bglb;
import bgtj;
import bgtm;
import bgtn;
import bgtq;
import bgtr;
import bgtv;
import bheg;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.HorizontalListView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.TicketManager;
import ntb;
import ntf;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.Goods;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.LoginSig;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.ReqBody;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.User;

public class TroopPicEffectsEditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  public int a;
  protected ProgressDialog a;
  public SparseArray<bgla> a;
  public Button a;
  protected FrameLayout a;
  public bgtq a;
  protected bgtr a;
  protected bgtv a;
  protected HorizontalListView a;
  public String a;
  public bgtq[] a;
  public String b;
  protected String c;
  
  public TroopPicEffectsEditActivity()
  {
    this.jdField_a_of_type_Int = 40000;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(10);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TroopPicEffectsEditActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("friendUin", paramString1);
    localIntent.putExtra("troopUin", paramString2);
    paramActivity.startActivity(localIntent);
    AlbumUtil.anim(paramActivity, false, true);
    bgtj.a("pic_select", "page_exp");
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.app == null)) {
      return paramString;
    }
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).c(this.b);
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", this.b).replace("$CLIENTVER$", "android8.4.10").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ArrayOfBgtq = new bgtq[] { new bgtq(40000, anvx.a(2131715060), Color.parseColor("#F2575757"), true), new bgtq(40002, anvx.a(2131715063), Color.parseColor("#F23FCCDF"), false), new bgtq(40001, anvx.a(2131715076), Color.parseColor("#F2EF7AEE"), false), new bgtq(40003, anvx.a(2131715070), Color.parseColor("#F2FFA02D"), false), new bgtq(40004, anvx.a(2131715062), Color.parseColor("#F21CD28C"), false), new bgtq(40005, anvx.a(2131715069), Color.parseColor("#F2FF6EA2"), false) };
    this.jdField_a_of_type_Bgtq = this.jdField_a_of_type_ArrayOfBgtq[0];
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bgtr);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    a(new bgtm(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_Bgtv != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_Bgtv.a());
      this.jdField_a_of_type_Bgtv.b();
    }
    boolean bool = bglb.a(paramInt);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bgtv = new NormalPicView(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Bgtv.a(), -1, -1);
      paramInt = i;
      label154:
      Object localObject1;
      Object localObject2;
      switch (JpegExifReader.readOrientation(paramString))
      {
      default: 
        paramInt = i;
      case 4: 
      case 5: 
      case 7: 
        localObject1 = new BitmapFactory.Options();
        localObject2 = new File(paramString);
      }
      try
      {
        localObject2 = new BufferedInputStream(new FileInputStream((File)localObject2), 2048);
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)bheg.a((InputStream)localObject2, 720, 1080));
        ((BufferedInputStream)localObject2).close();
        paramString = bheg.a(paramString, (BitmapFactory.Options)localObject1);
        localObject1 = new Matrix();
        ((Matrix)localObject1).reset();
        ((Matrix)localObject1).setRotate(paramInt);
        this.jdField_a_of_type_Bgtv.setBitmap(Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject1, true));
        if (bool) {
          this.jdField_a_of_type_Bgtv.a();
        }
        return;
        this.jdField_a_of_type_Bgtv = new PhantomPicView(this);
        continue;
        this.jdField_a_of_type_Bgtv = new ShakePicView(this);
        continue;
        int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
        this.jdField_a_of_type_Bgtv = new VideoPicView(this, paramInt, j, j * 1024 / 750);
        if (bool) {
          continue;
        }
        localObject1 = (bggl)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        ((bggl)localObject1).a(this);
        ((bggl)localObject1).a(paramInt, this.b, null);
        continue;
        paramInt = 90;
        break label154;
        paramInt = 180;
        break label154;
        paramInt = 270;
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  protected void a(azke paramazke)
  {
    ThreadManager.post(new TroopPicEffectsEditActivity.3(this, paramazke.a), 8, null, true);
  }
  
  protected void a(bgkn parambgkn)
  {
    ((bgko)this.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a("OidbSvc.0x6c3", 1731, 1, this.b, 1, 7, true, true, parambgkn);
  }
  
  public void a(bgtq parambgtq, im_msg_body.CustomFace paramCustomFace, ntf paramntf)
  {
    oidb_cmd0x991.ReqBody localReqBody = new oidb_cmd0x991.ReqBody();
    oidb_cmd0x991.User localUser = new oidb_cmd0x991.User();
    oidb_cmd0x991.Goods localGoods = new oidb_cmd0x991.Goods();
    long l = Long.parseLong(this.b);
    localUser.uint64_group.set(l);
    localUser.uint32_client.set(1);
    localUser.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.a().getBytes()), true);
    localUser.uint32_portal.set(600);
    oidb_cmd0x991.LoginSig localLoginSig = new oidb_cmd0x991.LoginSig();
    localLoginSig.uint32_type.set(1);
    localLoginSig.uint32_appid.set(0);
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.app.getCurrentAccountUin());; localObject = "")
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
      localUser.msg_login_sig.set(localLoginSig);
      localUser.uint32_instance_id.set(AppSetting.a());
      localGoods.int32_product_id.set(parambgtq.jdField_a_of_type_Int);
      localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(parambgtq.jdField_a_of_type_JavaLangString.getBytes()));
      localGoods.int32_goods_price.set(9);
      localGoods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
      localGoods.msg_img.set(paramCustomFace);
      localReqBody.msg_user.set(localUser);
      localReqBody.msg_goods.set(localGoods);
      ntb.a(this.app, paramntf, localReqBody.toByteArray(), "OidbSvc.0x991_" + 0, 2449, 0, new Bundle(), 5000L);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. path invalid,path:" + paramString);
      return;
    }
    azke localazke = azjv.a(2, 1007);
    Object localObject = new azko();
    ((azko)localObject).d(this.b);
    ((azko)localObject).a(this.jdField_a_of_type_JavaLangString);
    ((azko)localObject).e(1);
    ((azko)localObject).e(this.c);
    ((azko)localObject).d(1007);
    ((azko)localObject).f(0);
    ((azko)localObject).k(0);
    localObject = ((azko)localObject).a();
    if (!localazke.a((azkn)localObject))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((azkn)localObject).g = paramString;
    a(localazke);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131755829);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559607);
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372740)).setText(anvx.a(2131715068));
      return;
    }
    this.jdField_a_of_type_AndroidAppProgressDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563016);
    setTitle(anvx.a(2131715067));
    this.leftView.setText(anvx.a(2131715072));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379588));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379589));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131379587));
    this.jdField_a_of_type_Bgtr = new bgtr(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.dip2px(this, 5.0F));
    paramBundle = getIntent();
    this.b = paramBundle.getStringExtra("friendUin");
    this.c = paramBundle.getStringExtra("troopUin");
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    a(40000, this.jdField_a_of_type_JavaLangString);
    a();
    bgtj.a("action_select", "page_exp");
    return true;
  }
  
  public void doOnDestroy()
  {
    c();
    if (this.jdField_a_of_type_Bgtv != null) {
      this.jdField_a_of_type_Bgtv.b();
    }
    this.jdField_a_of_type_ArrayOfBgtq = new bgtq[0];
    ((bggl)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).b(this);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    bgtj.a("action_select", "clk_back");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      a(new bgtn(this));
      b();
      bgtj.a("send_pic", "clk_send");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    a(this.jdField_a_of_type_ArrayOfBgtq[paramInt].jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bgtq = this.jdField_a_of_type_ArrayOfBgtq[paramInt];
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBgtq[paramInt].jdField_a_of_type_Int;
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_ArrayOfBgtq.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfBgtq[i];
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        ((bgtq)localObject1).jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_Bgtr.notifyDataSetChanged();
    Object localObject2 = (bgla)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localObject2 != null)
    {
      localObject1 = ((bgla)localObject2).jdField_a_of_type_JavaLangString;
      if (localObject2 == null) {
        break label237;
      }
      localObject2 = ((bgla)localObject2).b;
      label143:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label243;
      }
      i = ((String)localObject1).indexOf((String)localObject2);
      j = i + ((String)localObject2).length();
    }
    for (;;)
    {
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), i, j, 18);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      bgtj.a("action_select", "clk_switch");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = "30金豆秀一下";
      break;
      label237:
      localObject2 = null;
      break label143;
      label243:
      i = 0;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (bggx)paramObject;
    if ((paramObservable.jdField_a_of_type_Boolean) && (paramObservable.jdField_a_of_type_JavaLangString.equals("" + this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_Bgtv instanceof VideoPicView))) {
      ((VideoPicView)this.jdField_a_of_type_Bgtv).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */