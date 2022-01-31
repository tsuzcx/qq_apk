package com.tencent.mobileqq.trooppiceffects;

import ajwx;
import ajwy;
import ajxb;
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
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
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
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.ShowPicPrice;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.trooppiceffects.view.IPicView;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
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
  public SparseArray a;
  public Button a;
  protected FrameLayout a;
  protected TroopPicEffectsEditActivity.ItemData a;
  protected TroopPicEffectsEditActivity.ItemListAdapter a;
  protected IPicView a;
  protected HorizontalListView a;
  public String a;
  protected TroopPicEffectsEditActivity.ItemData[] a;
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
    AlbumUtil.a(paramActivity, false, true);
    TroopPicEffectsController.a("pic_select", "page_exp");
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.app == null)) {
      return paramString;
    }
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.b);
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", this.b).replace("$CLIENTVER$", "android7.6.3").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
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
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = new TroopPicEffectsEditActivity.ItemData[] { new TroopPicEffectsEditActivity.ItemData(40000, "秀图", Color.parseColor("#F2575757"), true), new TroopPicEffectsEditActivity.ItemData(40002, "抖动", Color.parseColor("#F23FCCDF"), false), new TroopPicEffectsEditActivity.ItemData(40001, "幻影", Color.parseColor("#F2EF7AEE"), false), new TroopPicEffectsEditActivity.ItemData(40003, "生日", Color.parseColor("#F2FFA02D"), false), new TroopPicEffectsEditActivity.ItemData(40004, "爱你", Color.parseColor("#F21CD28C"), false), new TroopPicEffectsEditActivity.ItemData(40005, "征友", Color.parseColor("#F2FF6EA2"), false) };
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[0];
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemListAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    a(new ajwx(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a());
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.b();
    }
    boolean bool = TroopGiftUtil.a(paramInt);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new NormalPicView(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a(), -1, -1);
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
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, 720, 1080));
        ((BufferedInputStream)localObject2).close();
        paramString = ImageUtil.a(paramString, (BitmapFactory.Options)localObject1);
        localObject1 = new Matrix();
        ((Matrix)localObject1).reset();
        ((Matrix)localObject1).setRotate(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.setBitmap(Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject1, true));
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a();
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new PhantomPicView(this);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new ShakePicView(this);
        continue;
        int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new VideoPicView(this, paramInt, j, j * 1024 / 750);
        if (bool) {
          continue;
        }
        localObject1 = (AIOAnimationControlManager)this.app.getManager(222);
        ((AIOAnimationControlManager)localObject1).a(this);
        ((AIOAnimationControlManager)localObject1).a(paramInt, this.b, null);
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
  
  protected void a(PicReq paramPicReq)
  {
    ThreadManager.post(new ajxb(this, paramPicReq.a), 8, null, true);
  }
  
  protected void a(TroopGiftCallback paramTroopGiftCallback)
  {
    ((TroopGiftManager)this.app.getManager(112)).a("OidbSvc.0x6c3", 1731, 1, this.b, 1, 7, true, true, paramTroopGiftCallback);
  }
  
  protected void a(TroopPicEffectsEditActivity.ItemData paramItemData, im_msg_body.CustomFace paramCustomFace, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x991.ReqBody localReqBody = new oidb_cmd0x991.ReqBody();
    oidb_cmd0x991.User localUser = new oidb_cmd0x991.User();
    oidb_cmd0x991.Goods localGoods = new oidb_cmd0x991.Goods();
    long l = Long.parseLong(this.b);
    localUser.uint64_group.set(l);
    localUser.uint32_client.set(1);
    localUser.bytes_version.set(ByteStringMicro.copyFrom("V 7.6.3.3560".getBytes()), true);
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
      localUser.uint32_instance_id.set(AppSetting.jdField_a_of_type_Int);
      localGoods.int32_product_id.set(paramItemData.jdField_a_of_type_Int);
      localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(paramItemData.jdField_a_of_type_JavaLangString.getBytes()));
      localGoods.int32_goods_price.set(9);
      localGoods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
      localGoods.msg_img.set(paramCustomFace);
      localReqBody.msg_user.set(localUser);
      localReqBody.msg_goods.set(localGoods);
      ProtoUtils.a(this.app, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x991_" + 0, 2449, 0, new Bundle(), 5000L);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!FileUtils.b(paramString))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. path invalid,path:" + paramString);
      return;
    }
    PicReq localPicReq = PicBusiManager.a(2, 1007);
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).d(this.b);
    ((PicUploadInfo.Builder)localObject).a(this.jdField_a_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).e(1);
    ((PicUploadInfo.Builder)localObject).e(this.c);
    ((PicUploadInfo.Builder)localObject).d(1007);
    ((PicUploadInfo.Builder)localObject).f(0);
    ((PicUploadInfo.Builder)localObject).k(0);
    localObject = ((PicUploadInfo.Builder)localObject).a();
    if (!localPicReq.a((PicUploadInfo)localObject))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((PicUploadInfo)localObject).g = paramString;
    a(localPicReq);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText("正在发送");
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130971687);
    setTitle("秀图");
    this.leftView.setText("相册");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131375357));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375359));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131375358));
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemListAdapter = new TroopPicEffectsEditActivity.ItemListAdapter(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.a(this, 5.0F));
    paramBundle = getIntent();
    this.b = paramBundle.getStringExtra("friendUin");
    this.c = paramBundle.getStringExtra("troopUin");
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    a(40000, this.jdField_a_of_type_JavaLangString);
    a();
    TroopPicEffectsController.a("action_select", "page_exp");
    return true;
  }
  
  protected void doOnDestroy()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.b();
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = new TroopPicEffectsEditActivity.ItemData[0];
    ((AIOAnimationControlManager)this.app.getManager(222)).b(this);
    super.doOnDestroy();
  }
  
  protected boolean onBackEvent()
  {
    TroopPicEffectsController.a("action_select", "clk_back");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      a(new ajwy(this));
      b();
      TroopPicEffectsController.a("send_pic", "clk_send");
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    a(this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[paramInt].jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[paramInt];
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[paramInt].jdField_a_of_type_Int;
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData.length)
    {
      paramAdapterView = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[i];
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        paramAdapterView.jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemListAdapter.notifyDataSetChanged();
    paramView = (TroopGiftManager.ShowPicPrice)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
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
      TroopPicEffectsController.a("action_select", "clk_switch");
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
    paramObservable = (AIOAnimationControlManager.DownloadGftData)paramObject;
    if ((paramObservable.jdField_a_of_type_Boolean) && (paramObservable.jdField_a_of_type_JavaLangString.equals("" + this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView instanceof VideoPicView))) {
      ((VideoPicView)this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */