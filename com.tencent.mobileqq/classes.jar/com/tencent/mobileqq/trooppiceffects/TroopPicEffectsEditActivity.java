package com.tencent.mobileqq.trooppiceffects;

import ajyc;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import aunj;
import aunt;
import auob;
import auoc;
import bagr;
import bahd;
import baks;
import bakt;
import balf;
import balg;
import batd;
import batg;
import bath;
import batk;
import batl;
import batp;
import bawz;
import bbbj;
import bbdj;
import bbdr;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;
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
import mxi;
import mxm;
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
  public SparseArray<balf> a;
  public Button a;
  protected FrameLayout a;
  public batk a;
  protected batl a;
  protected batp a;
  protected HorizontalListView a;
  public String a;
  public batk[] a;
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
    localIntent.setClass(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TroopPicEffectsEditActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("friendUin", paramString1);
    localIntent.putExtra("troopUin", paramString2);
    paramActivity.startActivity(localIntent);
    bbbj.a(paramActivity, false, true);
    batd.a("pic_select", "page_exp");
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.app == null)) {
      return paramString;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
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
      return paramString.replace("$GCODE$", this.b).replace("$CLIENTVER$", "android8.2.8").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
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
    this.jdField_a_of_type_ArrayOfBatk = new batk[] { new batk(40000, ajyc.a(2131715695), Color.parseColor("#F2575757"), true), new batk(40002, ajyc.a(2131715698), Color.parseColor("#F23FCCDF"), false), new batk(40001, ajyc.a(2131715711), Color.parseColor("#F2EF7AEE"), false), new batk(40003, ajyc.a(2131715705), Color.parseColor("#F2FFA02D"), false), new batk(40004, ajyc.a(2131715697), Color.parseColor("#F21CD28C"), false), new batk(40005, ajyc.a(2131715704), Color.parseColor("#F2FF6EA2"), false) };
    this.jdField_a_of_type_Batk = this.jdField_a_of_type_ArrayOfBatk[0];
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Batl);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    a(new batg(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_Batp != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_Batp.a());
      this.jdField_a_of_type_Batp.b();
    }
    boolean bool = balg.a(paramInt);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Batp = new NormalPicView(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Batp.a(), -1, -1);
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
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)bbdr.a((InputStream)localObject2, 720, 1080));
        ((BufferedInputStream)localObject2).close();
        paramString = bbdr.a(paramString, (BitmapFactory.Options)localObject1);
        localObject1 = new Matrix();
        ((Matrix)localObject1).reset();
        ((Matrix)localObject1).setRotate(paramInt);
        this.jdField_a_of_type_Batp.setBitmap(Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject1, true));
        if (bool) {
          this.jdField_a_of_type_Batp.a();
        }
        return;
        this.jdField_a_of_type_Batp = new PhantomPicView(this);
        continue;
        this.jdField_a_of_type_Batp = new ShakePicView(this);
        continue;
        int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
        this.jdField_a_of_type_Batp = new VideoPicView(this, paramInt, j, j * 1024 / 750);
        if (bool) {
          continue;
        }
        localObject1 = (bagr)this.app.getManager(223);
        ((bagr)localObject1).a(this);
        ((bagr)localObject1).a(paramInt, this.b, null);
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
  
  protected void a(aunt paramaunt)
  {
    ThreadManager.post(new TroopPicEffectsEditActivity.3(this, paramaunt.a), 8, null, true);
  }
  
  protected void a(baks parambaks)
  {
    ((bakt)this.app.getManager(113)).a("OidbSvc.0x6c3", 1731, 1, this.b, 1, 7, true, true, parambaks);
  }
  
  public void a(batk parambatk, im_msg_body.CustomFace paramCustomFace, mxm parammxm)
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
      localGoods.int32_product_id.set(parambatk.jdField_a_of_type_Int);
      localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(parambatk.jdField_a_of_type_JavaLangString.getBytes()));
      localGoods.int32_goods_price.set(9);
      localGoods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
      localGoods.msg_img.set(paramCustomFace);
      localReqBody.msg_user.set(localUser);
      localReqBody.msg_goods.set(localGoods);
      mxi.a(this.app, parammxm, localReqBody.toByteArray(), "OidbSvc.0x991_" + 0, 2449, 0, new Bundle(), 5000L);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!bbdj.b(paramString))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. path invalid,path:" + paramString);
      return;
    }
    aunt localaunt = aunj.a(2, 1007);
    Object localObject = new auoc();
    ((auoc)localObject).d(this.b);
    ((auoc)localObject).a(this.jdField_a_of_type_JavaLangString);
    ((auoc)localObject).e(1);
    ((auoc)localObject).e(this.c);
    ((auoc)localObject).d(1007);
    ((auoc)localObject).f(0);
    ((auoc)localObject).k(0);
    localObject = ((auoc)localObject).a();
    if (!localaunt.a((auob)localObject))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((auob)localObject).g = paramString;
    a(localaunt);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131755791);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559386);
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371557)).setText(ajyc.a(2131715703));
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562568);
    setTitle(ajyc.a(2131715702));
    this.leftView.setText(ajyc.a(2131715707));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131377877));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377878));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131377876));
    this.jdField_a_of_type_Batl = new batl(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bawz.a(this, 5.0F));
    paramBundle = getIntent();
    this.b = paramBundle.getStringExtra("friendUin");
    this.c = paramBundle.getStringExtra("troopUin");
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    a(40000, this.jdField_a_of_type_JavaLangString);
    a();
    batd.a("action_select", "page_exp");
    return true;
  }
  
  public void doOnDestroy()
  {
    c();
    if (this.jdField_a_of_type_Batp != null) {
      this.jdField_a_of_type_Batp.b();
    }
    this.jdField_a_of_type_ArrayOfBatk = new batk[0];
    ((bagr)this.app.getManager(223)).b(this);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    batd.a("action_select", "clk_back");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      a(new bath(this));
      b();
      batd.a("send_pic", "clk_send");
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    a(this.jdField_a_of_type_ArrayOfBatk[paramInt].jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Batk = this.jdField_a_of_type_ArrayOfBatk[paramInt];
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBatk[paramInt].jdField_a_of_type_Int;
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBatk.length)
    {
      paramAdapterView = this.jdField_a_of_type_ArrayOfBatk[i];
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        paramAdapterView.jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_Batl.notifyDataSetChanged();
    paramView = (balf)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      paramAdapterView = paramView.jdField_a_of_type_JavaLangString;
      if (paramView == null) {
        break label205;
      }
      paramView = paramView.b;
      label134:
      if (TextUtils.isEmpty(paramView)) {
        break label210;
      }
      paramInt = paramAdapterView.indexOf(paramView);
    }
    for (i = paramInt + paramView.length();; i = j)
    {
      paramAdapterView = new SpannableString(paramAdapterView);
      paramAdapterView.setSpan(new StrikethroughSpan(), paramInt, i, 18);
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramAdapterView);
      batd.a("action_select", "clk_switch");
      return;
      paramAdapterView = "30金豆秀一下";
      break;
      label205:
      paramView = null;
      break label134;
      label210:
      paramInt = 0;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (bahd)paramObject;
    if ((paramObservable.jdField_a_of_type_Boolean) && (paramObservable.jdField_a_of_type_JavaLangString.equals("" + this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_Batp instanceof VideoPicView))) {
      ((VideoPicView)this.jdField_a_of_type_Batp).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */