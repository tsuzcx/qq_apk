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
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.DownloadGftData;
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
  protected FrameLayout a;
  protected HorizontalListView b;
  protected TroopPicEffectsEditActivity.ItemListAdapter c;
  protected IPicView d;
  protected Button e;
  protected String f;
  protected String g;
  protected String h;
  protected ProgressDialog i;
  protected TroopPicEffectsEditActivity.ItemData[] j = null;
  protected TroopPicEffectsEditActivity.ItemData k;
  protected int l = 40000;
  protected SparseArray<TroopGiftManager.ShowPicPrice> m = new SparseArray(10);
  
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
        localObject2 = ((TroopManager)localObject2).g(this.g);
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
      localObject1 = paramString.replace("$GCODE$", this.g).replace("$CLIENTVER$", "android8.8.17").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject1);
    }
    return localObject1;
  }
  
  protected void a()
  {
    this.j = new TroopPicEffectsEditActivity.ItemData[] { new TroopPicEffectsEditActivity.ItemData(40000, HardCodeUtil.a(2131912951), Color.parseColor("#F2575757"), true), new TroopPicEffectsEditActivity.ItemData(40002, HardCodeUtil.a(2131912954), Color.parseColor("#F23FCCDF"), false), new TroopPicEffectsEditActivity.ItemData(40001, HardCodeUtil.a(2131912967), Color.parseColor("#F2EF7AEE"), false), new TroopPicEffectsEditActivity.ItemData(40003, HardCodeUtil.a(2131912961), Color.parseColor("#F2FFA02D"), false), new TroopPicEffectsEditActivity.ItemData(40004, HardCodeUtil.a(2131912953), Color.parseColor("#F21CD28C"), false), new TroopPicEffectsEditActivity.ItemData(40005, HardCodeUtil.a(2131912960), Color.parseColor("#F2FF6EA2"), false) };
    this.k = this.j[0];
    this.b.setAdapter(this.c);
    this.b.setOnItemClickListener(this);
    a(new TroopPicEffectsEditActivity.1(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      this.a.removeView(((IPicView)localObject1).getView());
      this.d.b();
    }
    boolean bool = TroopGiftUtil.c(paramInt);
    switch (paramInt)
    {
    default: 
      this.d = new NormalPicView(this);
      break;
    case 40003: 
    case 40004: 
    case 40005: 
      int n = this.a.getWidth();
      this.d = new VideoPicView(this, paramInt, n, n * 1024 / 750);
      if (!bool)
      {
        localObject1 = (AIOAnimationControlManager)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        ((AIOAnimationControlManager)localObject1).a(this);
        ((AIOAnimationControlManager)localObject1).a(paramInt, this.g, null);
      }
      break;
    case 40002: 
      this.d = new ShakePicView(this);
      break;
    case 40001: 
      this.d = new PhantomPicView(this);
    }
    this.a.addView(this.d.getView(), -1, -1);
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
      this.d.setBitmap(Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject1, true));
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
      this.d.a();
    }
  }
  
  protected void a(PicReq paramPicReq)
  {
    ThreadManager.post(new TroopPicEffectsEditActivity.3(this, paramPicReq.g), 8, null, true);
  }
  
  protected void a(TroopGiftCallback paramTroopGiftCallback)
  {
    ((TroopGiftManager)this.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a("OidbSvc.0x6c3", 1731, 1, this.g, 1, 7, true, true, paramTroopGiftCallback);
  }
  
  protected void a(TroopPicEffectsEditActivity.ItemData paramItemData, im_msg_body.CustomFace paramCustomFace, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x991.ReqBody localReqBody = new oidb_cmd0x991.ReqBody();
    oidb_cmd0x991.User localUser = new oidb_cmd0x991.User();
    oidb_cmd0x991.Goods localGoods = new oidb_cmd0x991.Goods();
    long l1 = Long.parseLong(this.g);
    localUser.uint64_group.set(l1);
    localUser.uint32_client.set(1);
    localUser.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.b().getBytes()), true);
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
    localUser.uint32_instance_id.set(AppSetting.d());
    localGoods.int32_product_id.set(paramItemData.a);
    localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(paramItemData.b.getBytes()));
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
  
  protected void b()
  {
    ProgressDialog localProgressDialog = this.i;
    if (localProgressDialog == null)
    {
      this.i = new ReportProgressDialog(this, 2131953338);
      this.i.setCancelable(true);
      this.i.show();
      this.i.setContentView(2131625585);
      ((TextView)this.i.findViewById(2131440191)).setText(HardCodeUtil.a(2131912959));
      return;
    }
    localProgressDialog.show();
  }
  
  protected void b(String paramString)
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
    ((PicUploadInfo.Builder)localObject2).d(this.g);
    ((PicUploadInfo.Builder)localObject2).a(this.f);
    ((PicUploadInfo.Builder)localObject2).e(1);
    ((PicUploadInfo.Builder)localObject2).e(this.h);
    ((PicUploadInfo.Builder)localObject2).d(1007);
    ((PicUploadInfo.Builder)localObject2).f(0);
    ((PicUploadInfo.Builder)localObject2).k(0);
    localObject2 = ((PicUploadInfo.Builder)localObject2).k();
    if (!((PicReq)localObject1).a((PicUploadInfo)localObject2))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((PicUploadInfo)localObject2).n = paramString;
    a((PicReq)localObject1);
  }
  
  protected void c()
  {
    ProgressDialog localProgressDialog = this.i;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.i.dismiss();
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
    setContentView(2131629602);
    setTitle(HardCodeUtil.a(2131912958));
    this.leftView.setText(HardCodeUtil.a(2131912963));
    this.a = ((FrameLayout)findViewById(2131448077));
    this.e = ((Button)findViewById(2131448078));
    this.b = ((HorizontalListView)findViewById(2131448076));
    this.c = new TroopPicEffectsEditActivity.ItemListAdapter(this);
    this.e.setOnClickListener(this);
    this.b.setDividerWidth(DisplayUtil.a(this, 5.0F));
    paramBundle = getIntent();
    this.g = paramBundle.getStringExtra("friendUin");
    this.h = paramBundle.getStringExtra("troopUin");
    this.f = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    a(40000, this.f);
    a();
    TroopPicEffectsController.a("action_select", "page_exp");
    return true;
  }
  
  protected void doOnDestroy()
  {
    c();
    IPicView localIPicView = this.d;
    if (localIPicView != null) {
      localIPicView.b();
    }
    this.j = new TroopPicEffectsEditActivity.ItemData[0];
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
    if (paramView == this.e)
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
    a(this.j[paramInt].a, this.f);
    Object localObject1 = this.j;
    this.k = localObject1[paramInt];
    this.l = localObject1[paramInt].a;
    int i2 = 0;
    int n = 0;
    for (;;)
    {
      localObject1 = this.j;
      if (n >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[n];
      boolean bool;
      if (n == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((TroopPicEffectsEditActivity.ItemData)localObject1).e = bool;
      n += 1;
    }
    this.c.notifyDataSetChanged();
    Object localObject2 = (TroopGiftManager.ShowPicPrice)this.m.get(this.l);
    if (localObject2 != null) {
      localObject1 = ((TroopGiftManager.ShowPicPrice)localObject2).b;
    } else {
      localObject1 = "30金豆秀一下";
    }
    if (localObject2 != null) {
      localObject2 = ((TroopGiftManager.ShowPicPrice)localObject2).c;
    } else {
      localObject2 = null;
    }
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      n = ((String)localObject1).indexOf((String)localObject2);
      i1 = ((String)localObject2).length() + n;
    }
    else
    {
      i1 = 0;
      n = i2;
    }
    localObject1 = new SpannableString((CharSequence)localObject1);
    ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), n, i1, 18);
    this.e.setText((CharSequence)localObject1);
    TroopPicEffectsController.a("action_select", "clk_switch");
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (AIOAnimationControlManager.DownloadGftData)paramObject;
    if (paramObservable.b)
    {
      paramObservable = paramObservable.a;
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(this.l);
      if (paramObservable.equals(paramObject.toString()))
      {
        paramObservable = this.d;
        if ((paramObservable instanceof VideoPicView)) {
          ((VideoPicView)paramObservable).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */