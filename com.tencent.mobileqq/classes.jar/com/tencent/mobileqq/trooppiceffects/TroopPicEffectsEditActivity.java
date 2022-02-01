package com.tencent.mobileqq.trooppiceffects;

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
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
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
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.Goods;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.LoginSig;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.ReqBody;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.User;

public class TroopPicEffectsEditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  protected int a;
  protected ProgressDialog a;
  protected SparseArray<TroopGiftManager.ShowPicPrice> a;
  protected Button a;
  protected FrameLayout a;
  protected TroopPicEffectsEditActivity.ItemData a;
  protected TroopPicEffectsEditActivity.ItemListAdapter a;
  protected IPicView a;
  protected HorizontalListView a;
  protected String a;
  protected TroopPicEffectsEditActivity.ItemData[] a;
  protected String b;
  protected String c;
  
  public TroopPicEffectsEditActivity()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = null;
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
    TroopPicEffectsController.a("pic_select", "page_exp");
  }
  
  protected String a(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString != null)
    {
      if (this.app == null) {
        return paramString;
      }
      Object localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      String str = "2";
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).c(this.b);
        localObject1 = str;
        if (localObject2 != null)
        {
          if (((TroopInfo)localObject2).isTroopOwner(this.app.getCurrentAccountUin())) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            break;
            localObject1 = str;
            if (!((TroopInfo)localObject2).isAdmin()) {
              break;
            }
          }
        }
      }
      localObject1 = paramString.replace("$GCODE$", this.b).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject1);
    }
    return localObject1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = new TroopPicEffectsEditActivity.ItemData[] { new TroopPicEffectsEditActivity.ItemData(40000, HardCodeUtil.a(2131715476), Color.parseColor("#F2575757"), true), new TroopPicEffectsEditActivity.ItemData(40002, HardCodeUtil.a(2131715479), Color.parseColor("#F23FCCDF"), false), new TroopPicEffectsEditActivity.ItemData(40001, HardCodeUtil.a(2131715492), Color.parseColor("#F2EF7AEE"), false), new TroopPicEffectsEditActivity.ItemData(40003, HardCodeUtil.a(2131715486), Color.parseColor("#F2FFA02D"), false), new TroopPicEffectsEditActivity.ItemData(40004, HardCodeUtil.a(2131715478), Color.parseColor("#F21CD28C"), false), new TroopPicEffectsEditActivity.ItemData(40005, HardCodeUtil.a(2131715485), Color.parseColor("#F2FF6EA2"), false) };
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[0];
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemListAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    a(new TroopPicEffectsEditActivity.1(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(((IPicView)localObject1).a());
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.b();
    }
    boolean bool = TroopGiftUtil.a(paramInt);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new NormalPicView(this);
      break;
    case 40003: 
    case 40004: 
    case 40005: 
      int i = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new VideoPicView(this, paramInt, i, i * 1024 / 750);
      if (!bool)
      {
        localObject1 = (AIOAnimationControlManager)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        ((AIOAnimationControlManager)localObject1).a(this);
        ((AIOAnimationControlManager)localObject1).a(paramInt, this.b, null);
      }
      break;
    case 40002: 
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new ShakePicView(this);
      break;
    case 40001: 
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new PhantomPicView(this);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a(), -1, -1);
    paramInt = JpegExifReader.readOrientation(paramString);
    if (paramInt != 3)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8) {
          paramInt = 0;
        } else {
          paramInt = 270;
        }
      }
      else {
        paramInt = 90;
      }
    }
    else {
      paramInt = 180;
    }
    localObject1 = new BitmapFactory.Options();
    Object localObject2 = new File(paramString);
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
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a();
    }
  }
  
  protected void a(PicReq paramPicReq)
  {
    ThreadManager.post(new TroopPicEffectsEditActivity.3(this, paramPicReq.a), 8, null, true);
  }
  
  protected void a(TroopGiftCallback paramTroopGiftCallback)
  {
    ((TroopGiftManager)this.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a("OidbSvc.0x6c3", 1731, 1, this.b, 1, 7, true, true, paramTroopGiftCallback);
  }
  
  protected void a(TroopPicEffectsEditActivity.ItemData paramItemData, im_msg_body.CustomFace paramCustomFace, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
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
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(this.app.getCurrentAccountUin());
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    localUser.msg_login_sig.set(localLoginSig);
    localUser.uint32_instance_id.set(AppSetting.a());
    localGoods.int32_product_id.set(paramItemData.jdField_a_of_type_Int);
    localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(paramItemData.jdField_a_of_type_JavaLangString.getBytes()));
    localGoods.int32_goods_price.set(9);
    localGoods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
    localGoods.msg_img.set(paramCustomFace);
    localReqBody.msg_user.set(localUser);
    localReqBody.msg_goods.set(localGoods);
    paramItemData = this.app;
    paramCustomFace = localReqBody.toByteArray();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OidbSvc.0x991_");
    ((StringBuilder)localObject).append(0);
    ProtoUtils.a(paramItemData, paramTroopProtocolObserver, paramCustomFace, ((StringBuilder)localObject).toString(), 2449, 0, new Bundle(), 5000L);
  }
  
  protected void a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPhotoTask. path invalid,path:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("TroopPicEffectsEditActivity", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1007);
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(this.b);
    ((PicUploadInfo.Builder)localObject2).a(this.jdField_a_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject2).e(1);
    ((PicUploadInfo.Builder)localObject2).e(this.c);
    ((PicUploadInfo.Builder)localObject2).d(1007);
    ((PicUploadInfo.Builder)localObject2).f(0);
    ((PicUploadInfo.Builder)localObject2).k(0);
    localObject2 = ((PicUploadInfo.Builder)localObject2).a();
    if (!((PicReq)localObject1).a((PicUploadInfo)localObject2))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((PicUploadInfo)localObject2).g = paramString;
    a((PicReq)localObject1);
  }
  
  protected void b()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if (localProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131756189);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText(HardCodeUtil.a(2131715484));
      return;
    }
    localProgressDialog.show();
  }
  
  protected void c()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562994);
    setTitle(HardCodeUtil.a(2131715483));
    this.leftView.setText(HardCodeUtil.a(2131715488));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379340));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379341));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131379339));
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
    IPicView localIPicView = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView;
    if (localIPicView != null) {
      localIPicView.b();
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = new TroopPicEffectsEditActivity.ItemData[0];
    ((AIOAnimationControlManager)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).b(this);
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
      a(new TroopPicEffectsEditActivity.2(this));
      b();
      TroopPicEffectsController.a("send_pic", "clk_send");
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
    a(this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData[paramInt].jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData;
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData = localObject1[paramInt];
    this.jdField_a_of_type_Int = localObject1[paramInt].jdField_a_of_type_Int;
    int k = 0;
    int i = 0;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemData;
      if (i >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[i];
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((TroopPicEffectsEditActivity.ItemData)localObject1).jdField_a_of_type_Boolean = bool;
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$ItemListAdapter.notifyDataSetChanged();
    Object localObject2 = (TroopGiftManager.ShowPicPrice)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localObject2 != null) {
      localObject1 = ((TroopGiftManager.ShowPicPrice)localObject2).jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = "30金豆秀一下";
    }
    if (localObject2 != null) {
      localObject2 = ((TroopGiftManager.ShowPicPrice)localObject2).b;
    } else {
      localObject2 = null;
    }
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      i = ((String)localObject1).indexOf((String)localObject2);
      j = ((String)localObject2).length() + i;
    }
    else
    {
      j = 0;
      i = k;
    }
    localObject1 = new SpannableString((CharSequence)localObject1);
    ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), i, j, 18);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
    TroopPicEffectsController.a("action_select", "clk_switch");
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (AIOAnimationControlManager.DownloadGftData)paramObject;
    if (paramObservable.jdField_a_of_type_Boolean)
    {
      paramObservable = paramObservable.jdField_a_of_type_JavaLangString;
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(this.jdField_a_of_type_Int);
      if (paramObservable.equals(paramObject.toString()))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView;
        if ((paramObservable instanceof VideoPicView)) {
          ((VideoPicView)paramObservable).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */