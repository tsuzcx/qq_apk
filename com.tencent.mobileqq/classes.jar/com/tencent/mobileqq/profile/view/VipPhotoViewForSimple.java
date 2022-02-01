package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.GridView;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VipPhotoViewForSimple
  extends LinearLayout
  implements Handler.Callback
{
  public static float o = 1.43F;
  private View.OnClickListener A = new VipPhotoViewForSimple.2(this);
  QQAppInterface a;
  View b;
  public List<QzonePhotoView.PhotoInfo> c;
  CoverCacheData d;
  public int e;
  public int f;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public float n = 1.5F;
  public GridView p;
  public HorizontalScrollView q;
  private Activity r;
  private ProfileCardInfo s;
  private Handler t;
  private String u;
  private int v;
  private boolean w = false;
  private ImageView x;
  private View y;
  private ITemplateUtils z;
  
  public VipPhotoViewForSimple(Context paramContext)
  {
    super(paramContext);
  }
  
  public VipPhotoViewForSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<QzonePhotoView.PhotoInfo> a(String paramString, List<Map<Integer, String>> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update");
      ((StringBuilder)localObject).append("|type = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|vecUrls = ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d == null) {
      this.d = new CoverCacheData();
    }
    Object localObject = this.d;
    ((CoverCacheData)localObject).type = paramString;
    ((CoverCacheData)localObject).photoWall = ((ArrayList)paramList);
    ((CoverCacheData)localObject).uin = Long.parseLong(this.u);
    int i2 = 0;
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    } else {
      i1 = 0;
    }
    while ((i2 < i1) && (i2 < 16))
    {
      paramString = (Map)paramList.get(i2);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(i2, 100, paramString);
        paramString.e = localLinkedList.size();
        paramString.d = i2;
        localLinkedList.add(paramString);
      }
      i2 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateCoverData photoInfo size=");
      paramString.append(localLinkedList.size());
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, paramString.toString());
    }
    return localLinkedList;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://ti.qq.com/photowall/index.html?_wv=1027");
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(this.u);
      localObject = ((StringBuilder)localObject).toString();
    }
    Intent localIntent = new Intent(this.r, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", (String)localObject);
    if (!paramBoolean)
    {
      this.r.startActivity(localIntent);
      return;
    }
    this.r.startActivityForResult(localIntent, 100);
  }
  
  @TargetApi(9)
  public void a(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.a = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.r = paramQBaseActivity;
    this.s = paramProfileCardInfo;
    this.t = new Handler(this);
    this.u = paramProfileCardInfo.allInOne.uin;
    this.b = LayoutInflater.from(this.a.getApplication()).inflate(2131628453, this, true);
    this.p = ((GridView)this.b.findViewById(2131440206));
    this.q = ((HorizontalScrollView)this.b.findViewById(2131440207));
    this.x = ((ImageView)this.b.findViewById(2131440723));
    this.y = this.b.findViewById(2131443117);
    paramQBaseActivity = getResources().getDisplayMetrics();
    this.e = paramQBaseActivity.widthPixels;
    this.f = paramQBaseActivity.heightPixels;
    int i1 = (int)(this.e / this.n);
    this.g = i1;
    this.j = i1;
    this.h = ((int)(this.j / o));
    this.l = getResources().getDimensionPixelSize(2131299339);
    this.m = getResources().getDimensionPixelSize(2131299338);
    this.k = (this.h + this.l + this.m);
    this.i = getResources().getDimensionPixelSize(2131299340);
    boolean bool;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.w = bool;
    if (VersionUtils.c()) {
      this.q.setOverScrollMode(2);
    }
    paramQBaseActivity = this.u;
    ThreadManager.post(new VipPhotoViewForSimple.1(this), 8, null, true);
    paramQBaseActivity = Message.obtain();
    paramQBaseActivity.what = 100;
    this.t.sendMessage(paramQBaseActivity);
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    Object localObject;
    if ((QLog.isColorLevel()) && (paramList != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePhotoView photoInfo size=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    this.c = paramList;
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    } else {
      i1 = 0;
    }
    if (i1 > 0)
    {
      this.p.setPadding(0, this.l, 0, this.m);
      this.p.setColumnWidth(this.g);
      this.p.setStretchMode(0);
      this.p.setHorizontalSpacing(this.i);
      localObject = new VipPhotoViewForSimple.PhotoAdapter(this, this.r);
      ((VipPhotoViewForSimple.PhotoAdapter)localObject).a(paramList);
      i1 = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.g + this.i) * i1, this.k);
      this.p.setLayoutParams(paramList);
      this.p.setNumColumns(i1);
      this.p.setAdapter((ListAdapter)localObject);
      this.x.setVisibility(8);
      this.y.setVisibility(8);
      this.p.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.w)
    {
      this.z.updateViewAttr(this.x, "src", this.s.currentTemplate, "simpleAddSrc");
      this.x.setTag(new DataTag(25, null));
      this.x.setOnClickListener(this.A);
      this.x.setVisibility(0);
      this.y.setVisibility(0);
      this.p.setVisibility(8);
      setVisibility(0);
      return;
    }
    this.x.setVisibility(8);
    this.y.setVisibility(8);
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetQZoneCover|isSuc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",mUin=");
      ((StringBuilder)localObject).append(this.u);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    if (!Utils.a(paramString, this.u)) {
      return;
    }
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString = new ArrayList();
      boolean bool = false;
      int i1 = 0;
      while (i1 < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
      {
        paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i1)).photoUrls);
        i1 += 1;
      }
      localObject = a("", paramString);
      paramString = null;
      parammobile_sub_get_photo_wall_rsp = paramString;
      i1 = 0;
      for (;;)
      {
        paramBoolean = bool;
        if (i1 >= 16) {
          break;
        }
        paramString = this.c;
        if ((paramString != null) && (paramString.size() > i1)) {
          paramString = (QzonePhotoView.PhotoInfo)this.c.get(i1);
        } else {
          paramString = null;
        }
        if ((localObject != null) && (((List)localObject).size() > i1)) {
          parammobile_sub_get_photo_wall_rsp = (QzonePhotoView.PhotoInfo)((List)localObject).get(i1);
        } else {
          parammobile_sub_get_photo_wall_rsp = null;
        }
        if (!Utils.a(paramString, parammobile_sub_get_photo_wall_rsp))
        {
          paramBoolean = true;
          break;
        }
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetQZoneCover  isNewPhoto=");
        localStringBuilder.append(String.valueOf(paramBoolean));
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
      }
      if ((paramBoolean) || ((paramString == null) && (parammobile_sub_get_photo_wall_rsp == null))) {
        a((List)localObject);
      }
    }
    else if ((NetworkUtil.isWifiEnabled(BaseApplication.getContext())) && (this.v < 3))
    {
      paramString = Message.obtain();
      paramString.what = 100;
      this.t.sendMessage(paramString);
    }
  }
  
  public CoverCacheData getCoverCacheData()
  {
    return this.d;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 100)
    {
      if (i1 != 200)
      {
        if (i1 == 201)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          ((PhotoWallHandler)this.a.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.u, "");
          this.t.removeMessages(201);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
        }
        if ((paramMessage.obj instanceof LinkedList)) {
          a((List)paramMessage.obj);
        }
        this.t.sendEmptyMessage(201);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramMessage != null)
      {
        paramMessage.b(this.u, 2);
        this.v += 1;
      }
      this.t.removeMessages(100);
    }
    return false;
  }
  
  public void setTemplateUtils(ITemplateUtils paramITemplateUtils)
  {
    this.z = paramITemplateUtils;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple
 * JD-Core Version:    0.7.0.1
 */