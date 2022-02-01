package com.tencent.mobileqq.nearby.profilecard;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class NearbyProfileEditPanel
  extends NearbyProfileEditBasePanel
  implements View.OnClickListener
{
  public static final String W = PhotoListCustomizationNearby.a;
  public static final int d = (WebViewUtil.a("nearby") << 8) + 101;
  static final int[] e = { 2131445251, 2131445247, 2131445246, 2131445252, 2131445249, 2131445250, 2131445248 };
  FormSwitchItem A;
  TextView B;
  BounceScrollView C;
  ImmersiveTitleBar2 D;
  LinearLayout E;
  NearbyPeopleProfileActivity F;
  NearbyPeopleCard G;
  LinkedList<PicInfo> H = new LinkedList();
  int I;
  final ArrayList<PicInfo> J = new ArrayList(13);
  final ArrayList<PicInfo> K = new ArrayList(13);
  String L = "";
  int M = 2015;
  int N;
  int O;
  int P;
  int Q;
  int R;
  int S;
  final InterestTag[] T;
  LabelEditCtrl U;
  protected final View.OnClickListener V = new NearbyProfileEditPanel.16(this);
  private RelativeLayout X;
  private HorizontalScrollView Y;
  private int Z;
  private boolean aa = false;
  private NearbyProfileEditPanel.OnPicDragListener ab;
  private IphonePickerView.PickerViewAdapter ac = new NearbyProfileEditPanel.17(this);
  private IphonePickerView.PickerViewAdapter ad = new NearbyProfileEditPanel.18(this);
  private TransProcessorHandler ae = new NearbyProfileEditPanel.21(this);
  private PicInfo af;
  private RelativeLayout ag = null;
  private View.OnLongClickListener ah = new NearbyProfileEditPanel.24(this);
  private IphonePickerView.PickerViewAdapter ai = new NearbyProfileEditPanel.25(this);
  TextView f;
  TextView g;
  View h;
  LinearLayout i;
  LinearLayout j;
  TextView k;
  TextView l;
  Button m;
  EditText n;
  EditText o;
  EditText p;
  TextView q;
  EditText r;
  LinearLayout s;
  EditText t;
  LinearLayout u;
  TextView v;
  TextView w;
  EditText x;
  EditText y;
  EditText z;
  
  public NearbyProfileEditPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.F = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.ab = new NearbyProfileEditPanel.OnPicDragListener(this, this.F.imageWidth);
    }
    this.S = UIUtils.a(this.F, 2.0F);
    int i2 = LabelEditCtrl.e.length - 1;
    this.T = new InterestTag[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      this.T[i1] = new InterestTag(LabelEditCtrl.e[i1]);
      i1 += 1;
    }
    this.ae.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.F.app.getRuntimeService(ITransFileController.class)).addHandle(this.ae);
  }
  
  @TargetApi(11)
  private void A()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.J.size() == 0) {
      return;
    }
    if ((this.G.oldPhotoCount > 0) && (this.G.age >= 14) && (this.G.age <= 24) && (this.J.size() <= 1)) {
      ReportController.b(this.F.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    l();
    m();
  }
  
  private void B()
  {
    ReportController.b(this.F.app, "dc00899", "grp_lbs", "", "data_card", "del_pho", 0, 0, "", "", "", "");
  }
  
  private void C()
  {
    ReportController.b(this.F.app, "dc00899", "grp_lbs", "", "data_card", "up_gif", 0, 0, "", "", "", "");
  }
  
  private void D()
  {
    Object localObject = this.G;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).godFlag))
    {
      localObject = this.F.getString(2131892095, new Object[] { this.L });
      localObject = DialogUtil.a(this.F, (String)localObject, 0, 0, null, null);
      ((QQCustomDialog)localObject).setPositiveButton(this.F.getString(2131892407), new NearbyProfileEditPanel.8(this, (QQCustomDialog)localObject));
      ((QQCustomDialog)localObject).show();
    }
    else
    {
      this.F.showUploadPhotoActionSheet();
    }
    if ((this.G == null) && (QLog.isColorLevel())) {
      QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
    }
  }
  
  private boolean E()
  {
    String str = this.n.getText().toString();
    if (!StringUtil.isEmpty(str))
    {
      if (StringUtil.trim(str).length() == 0)
      {
        this.F.showToast(HardCodeUtil.a(2131905131));
        return false;
      }
      return true;
    }
    this.F.showToast(HardCodeUtil.a(2131905144));
    return false;
  }
  
  private void F()
  {
    if (this.H.size() > 0)
    {
      Object localObject = new StringBuilder(HardCodeUtil.a(2131905140));
      ((StringBuilder)localObject).append(this.I - this.H.size() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.I);
      ((StringBuilder)localObject).append(")...");
      this.F.showWaitingDialog(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditPanel.22(this);
      this.F.app.execute((Runnable)localObject);
      return;
    }
    u();
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.F);
    localRelativeLayout.setBackgroundResource(2130846492);
    Object localObject = new LinearLayout.LayoutParams(this.F.imageWidth, this.F.imageWidth);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.S, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.F);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a((CustomImgView)localObject, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.ah);
      localRelativeLayout.setOnDragListener(this.ab);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(z());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditPanel.26(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject2 = null;
      Object localObject1;
      try
      {
        localObject1 = RichStatus.parseStatus(paramArrayOfByte);
      }
      catch (RuntimeException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RichStatus parseStatus error: ");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.e("NearbyProfileEditPanel", 1, ((StringBuilder)localObject1).toString());
        localObject1 = null;
      }
      paramArrayOfByte = (byte[])localObject2;
      if (localObject1 != null) {
        paramArrayOfByte = ((RichStatus)localObject1).toSpannableString(null, -8947849, this.F.getResources().getColor(2131165564));
      }
      localObject2 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject2 = new SpannableString("");
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((RichStatus)localObject1).actionText)))
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
        if (this.F.mStatusManager != null) {
          paramArrayOfByte = this.F.mStatusManager.a(((RichStatus)localObject1).actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.F.getResources(), 2130851609);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.F.getResources(), paramArrayOfByte, false, false);
        int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, i1, i1);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(paramArrayOfByte, 0, 3, 17);
        paramTextView.setText((CharSequence)localObject2);
        return;
      }
      paramTextView.setText((CharSequence)localObject2);
    }
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if ((QLog.isColorLevel()) && (this.i != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDrawable, pos:");
      ((StringBuilder)localObject).append(this.i.indexOfChild(paramCustomImgView));
      ((StringBuilder)localObject).append(",picInfo:");
      ((StringBuilder)localObject).append(paramPicInfo);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.F.getResources().getDrawable(2130847338);
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.F.imageWidth;
      localURLDrawableOptions.mRequestHeight = this.F.imageWidth;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      if ((paramPicInfo.d != null) && (paramPicInfo.d.length() > 0))
      {
        paramPicInfo = new File(paramPicInfo.d).toURL();
        URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions));
        return;
      }
      paramDrawable = null;
      if (!TextUtils.isEmpty(paramPicInfo.c)) {
        paramDrawable = paramPicInfo.c;
      } else if (!TextUtils.isEmpty(paramPicInfo.b)) {
        paramDrawable = paramPicInfo.b;
      }
      if (!TextUtils.isEmpty(paramDrawable))
      {
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramDrawable), localURLDrawableOptions));
        return;
      }
    }
    catch (MalformedURLException paramCustomImgView)
    {
      if (QLog.isColorLevel())
      {
        paramPicInfo = new StringBuilder();
        paramPicInfo.append("GridAdapter.getView() new URL(). ");
        paramPicInfo.append(paramCustomImgView.getMessage());
        QLog.d("Q.nearby_people_card.", 2, paramPicInfo.toString(), paramCustomImgView);
      }
    }
  }
  
  private View.OnClickListener b(int paramInt)
  {
    return new NearbyProfileEditPanel.7(this, paramInt);
  }
  
  private void x()
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this.F);
    Object localObject = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.F).inflate(2131627482, null);
    ((IphonePickerView)localObject).a(this.ad);
    if (this.z.getTag() != null)
    {
      int i2 = (byte)(((Byte)this.z.getTag()).byteValue() - 1);
      int i1;
      if (i2 >= 0)
      {
        i1 = i2;
        if (i2 <= 3) {}
      }
      else
      {
        i1 = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, i1);
      ((IphonePickerView)localObject).setPickListener(new NearbyProfileEditPanel.5(this, i1, localActionSheet));
      localActionSheet.setOnDismissListener(new NearbyProfileEditPanel.6(this));
      localActionSheet.setActionContentView((View)localObject, null);
      if (this.F.isFinishing()) {
        return;
      }
      localActionSheet.show();
      a(this.E, localActionSheet.getActionContentView());
      a(this.z, true);
    }
  }
  
  private boolean y()
  {
    if (this.H.size() > 0) {
      return true;
    }
    int i2 = this.J.size();
    if (i2 != this.K.size()) {
      return true;
    }
    int i1 = 0;
    while (i1 < i2)
    {
      if (((PicInfo)this.J.get(i1)).a != ((PicInfo)this.K.get(i1)).a) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private View z()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.F);
    localRelativeLayout.setBackgroundResource(2130842256);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.F, 35.0F), UIUtils.a(this.F, 16.0F));
    int i1 = UIUtils.a(this.F, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(i1, 0, 0, i1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.F);
    ((TextView)localObject).setText(HardCodeUtil.a(2131905205));
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setSingleLine(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.setMargins(i1, 0, i1, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.setVisibility(8);
    return localRelativeLayout;
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.F, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.F.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append("nearby_people_photo/");
    paramString = paramString.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localIntent.putExtra("PhotoConst.TARGET_PATH", localStringBuilder.toString());
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", HardCodeUtil.a(2131901576));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void a(int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.F, "/base/album/photolist");
    int i1 = NearbyProfileCardConstants.a;
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i1 - paramInt);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.F.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("nearby_people_photo/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("enter_from", 30);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationNearby.a);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.F, false, true);
    ReportController.b(this.F.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.M;
    int i2 = paramInt1 + 1896;
    i1 -= i2;
    Object localObject1 = Calendar.getInstance();
    int i3 = paramInt2 + 1;
    paramInt3 += 1;
    ((Calendar)localObject1).set(1, i3, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.N, this.O);
    paramInt1 = i1;
    if (((Calendar)localObject1).after(localObject2)) {
      paramInt1 = i1 - 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    localObject1 = Utils.b(i3, paramInt3);
    paramInt1 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(i3);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(" (");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("岁 ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    localObject1 = ((StringBuilder)localObject2).toString();
    this.p.setText((CharSequence)localObject1);
    this.p.setTag(new Object[] { Integer.valueOf(i2 << 16 | i3 << 8 | paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    int i1;
    Object localObject2;
    if (paramInt1 != 1)
    {
      localObject1 = "";
      i1 = 0;
      if (paramInt1 != 11) {
        if (paramInt1 != 14) {
          if (paramInt1 != 11000) {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 4)
              {
                if (paramInt1 != 5) {
                  return;
                }
                if ((paramInt2 != -1) || (paramIntent == null)) {
                  break label642;
                }
                localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.F.mAlbumId = paramIntent.getStringExtra("key_album_id");
                if ((StringUtil.isEmpty((String)localObject1)) || (this.F.mMode != 1) || (this.J.size() >= NearbyProfileCardConstants.a)) {
                  break label642;
                }
                paramIntent = a((String)localObject1);
                this.F.startActivity(paramIntent);
                return;
              }
              if (paramInt2 != -1) {
                break label642;
              }
              localObject2 = paramIntent.getStringArrayExtra("param_location");
              paramIntent = null;
            }
          }
        }
      }
    }
    try
    {
      localObject1 = this.F.mConditionSearchManager.d((String[])localObject2);
      paramIntent = (Intent)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label642:
        continue;
        paramInt1 += 1;
      }
    }
    if (paramIntent != null)
    {
      localObject1 = paramIntent;
      if (!paramIntent.equals("不限")) {}
    }
    else
    {
      localObject1 = "";
    }
    paramIntent = this.x;
    if (paramIntent != null)
    {
      paramIntent.setText((CharSequence)localObject1);
      this.x.setTag(localObject2);
      return;
      if ((paramInt2 == -1) && (this.r != null))
      {
        localObject1 = paramIntent.getStringExtra("param_name");
        paramInt1 = paramIntent.getIntExtra("param_id", -1);
        localObject2 = paramIntent.getStringExtra("param_tag");
        paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
        if (this.q != null) {
          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
          {
            this.q.setText((CharSequence)localObject2);
            this.q.setBackgroundResource(paramInt2);
            this.q.setVisibility(0);
          }
          else
          {
            this.q.setVisibility(8);
          }
        }
        this.r.setText((CharSequence)localObject1);
        this.r.setTag(Integer.valueOf(paramInt1));
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getExtras();
          paramIntent.getString("video_id");
          paramIntent.getInt("head_id");
          return;
          if (paramInt2 == -1)
          {
            paramIntent = paramIntent.getParcelableArrayListExtra("intent_param_pic_infos");
            if (paramIntent != null)
            {
              if (paramIntent.size() == 0) {
                return;
              }
              l();
              m();
              return;
            }
            return;
            if ((paramInt2 == -1) && (paramIntent != null))
            {
              try
              {
                localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                paramInt2 = paramIntent.getIntExtra("interest_tag_type", -1);
                paramInt1 = i1;
                if (paramInt1 < this.T.length)
                {
                  if (this.T[paramInt1].a != paramInt2) {
                    break label648;
                  }
                  paramIntent = this.T[paramInt1];
                  paramIntent.b.clear();
                  if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                    paramIntent.b.addAll((Collection)localObject2);
                  }
                }
                this.U.a(this.T);
                if (!QLog.isDevelopLevel()) {
                  break label642;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("doOnActivity result code :11 ");
                if (localObject2 == null) {
                  paramIntent = (Intent)localObject1;
                } else {
                  paramIntent = localObject2.toString();
                }
                localStringBuilder.append(paramIntent);
                localStringBuilder.append(" ");
                localStringBuilder.append(paramInt2);
                QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
                return;
              }
              catch (Exception paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label642;
                }
              }
              QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                localObject1 = this.y;
                if (localObject1 != null)
                {
                  a((TextView)localObject1, paramIntent);
                  this.y.setTag(paramIntent);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    boolean bool1 = true;
    paramBundle.putBoolean("key_is_nearby_people_card", true);
    paramBundle.putShort("key_new_profile_modified_flag", (short)1);
    if (this.G != null)
    {
      byte[] arrayOfByte = (byte[])this.y.getTag();
      Object localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[0];
      }
      paramBundle.putByteArray("key_xuan_yan", (byte[])localObject);
      if (!Arrays.equals(this.G.xuanYan, (byte[])this.y.getTag()))
      {
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject).app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject = this.n.getText().toString();
      if (!((String)localObject).equals(this.G.nickname))
      {
        paramBundle.putString("key_new_nickname", (String)localObject);
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject).app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      if ((this.z.getTag() != null) && (((Byte)this.z.getTag()).byteValue() != this.G.maritalStatus))
      {
        paramBundle.putByte("key_marital_status", ((Byte)this.z.getTag()).byteValue());
        ReportController.b(this.F.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
      }
      byte b = ((Byte)this.o.getTag()).byteValue();
      if (b != this.G.gender)
      {
        paramBundle.putByte("sex", b);
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject).app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject = (Object[])this.p.getTag();
      int i1 = ((Integer)localObject[0]).intValue();
      if (i1 != this.G.birthday)
      {
        paramBundle.putInt("birthday", i1);
        paramBundle.putInt("age", ((Integer)localObject[1]).intValue());
        paramBundle.putInt("key_constellation", ((Integer)localObject[2]).intValue());
        ReportController.b(this.F.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
      i1 = ((Integer)this.r.getTag()).intValue();
      if (i1 != this.G.job)
      {
        paramBundle.putInt("profession", i1);
        ReportController.b(this.F.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
      }
      localObject = this.t.getText().toString();
      if (!((String)localObject).equals(this.G.company))
      {
        paramBundle.putString("company", (String)localObject);
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject).app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
      }
      localObject = this.v.getText().toString();
      if (!((String)localObject).equals(this.G.college))
      {
        paramBundle.putString("college", (String)localObject);
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject).app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
      }
      localObject = (String[])this.x.getTag();
      if (!Arrays.equals((Object[])localObject, new String[] { this.G.hometownCountry, this.G.hometownProvice, this.G.hometownCity, this.G.hometownDistrict }))
      {
        paramBundle.putStringArray("hometown", (String[])localObject);
        ReportController.b(this.F.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
      }
      boolean bool2 = this.A.a();
      if (this.G.switchGiftVisible != 0L) {
        bool1 = false;
      }
      if (bool2 != bool1)
      {
        paramBundle.putShort("key_flower_visible_switch", (short)(bool2 ^ true));
        if (bool2) {
          ReportController.b(this.F.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.F.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Q.nearby_people_card..saveNearbyProfileCard, modified_data = ");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.d("Q.nearby_people_card.update_profile", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.h = paramView;
    paramView.findViewById(2131447534).setVisibility(0);
    this.f = ((TextView)paramView.findViewById(2131447581));
    this.g = ((TextView)paramView.findViewById(2131447497));
    paramView.findViewById(2131436227).setVisibility(4);
    b(paramView);
    this.E = ((LinearLayout)paramView.findViewById(2131446332));
    this.n = ((EditText)paramView.findViewById(2131439320));
    this.o = ((EditText)paramView.findViewById(2131434143));
    this.p = ((EditText)paramView.findViewById(2131427893));
    this.q = ((TextView)paramView.findViewById(2131430382));
    this.r = ((EditText)paramView.findViewById(2131436676));
    this.s = ((LinearLayout)paramView.findViewById(2131436677));
    this.t = ((EditText)paramView.findViewById(2131431173));
    this.u = ((LinearLayout)paramView.findViewById(2131430932));
    this.v = ((TextView)paramView.findViewById(2131430931));
    this.w = ((TextView)paramView.findViewById(2131430405));
    this.x = ((EditText)paramView.findViewById(2131435090));
    this.y = ((EditText)paramView.findViewById(2131450351));
    this.z = ((EditText)paramView.findViewById(2131446326));
    this.A = ((FormSwitchItem)paramView.findViewById(2131433490));
    this.A.setVisibility(8);
    this.B = ((TextView)paramView.findViewById(2131445245));
    this.D = ((ImmersiveTitleBar2)paramView.findViewById(2131447582));
    this.C = ((BounceScrollView)this.h.findViewById(2131432350));
    this.C.mScrollFlag = 1;
    paramView = (LinearLayout)this.h.findViewById(2131436826);
    this.U = i();
    this.U.a(this.F, paramView);
    r();
  }
  
  protected void a(View paramView, PicInfo paramPicInfo)
  {
    this.i.removeView(paramView);
  }
  
  protected void a(TextView paramTextView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2131167987;
    } else {
      i1 = 2131167993;
    }
    paramTextView.setTextColor(this.F.getResources().getColorStateList(i1));
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EditPanel bindData, isEditing = ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mActivity.mPicInfo.size = ");
      ((StringBuilder)localObject).append(this.F.mPicInfo);
      if (((StringBuilder)localObject).toString() == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(this.F.mPicInfo.size());
      }
      QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
    }
    int i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.F.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject = this.F.app;
    String str = NearbyUtils.b(this.F.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, str, localStringBuilder.toString(), "", "");
    this.G = paramNearbyPeopleCard;
    paramNearbyPeopleCard.getTagInfos(this.T);
    if (!this.c)
    {
      this.J.clear();
      this.J.addAll(this.F.mPicInfo);
      this.K.clear();
      this.K.addAll(this.J);
    }
    if (!this.F.mHasNewPhoto)
    {
      this.F.mPicInfo.clear();
      this.J.clear();
      this.K.clear();
    }
    if (this.G.gender == 0) {
      this.L = HardCodeUtil.a(2131905141);
    } else if (this.G.gender == 1) {
      this.L = HardCodeUtil.a(2131905191);
    }
    q();
    A();
    this.n.setText(this.G.nickname);
    this.o.setText(NearbyProfileUtil.c(this.G.gender));
    this.o.setTag(Byte.valueOf(this.G.gender));
    i1 = this.G.age;
    int i2 = this.G.birthday;
    int i3 = this.G.constellation;
    int i4 = (0xFF00 & i2) >> 8;
    int i5 = i2 & 0xFF;
    paramNearbyPeopleCard = Utils.b(i4, i5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i2 >> 16);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(i4);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(i5);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("岁");
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramNearbyPeopleCard);
    ((StringBuilder)localObject).append(")");
    this.p.setText(((StringBuilder)localObject).toString());
    this.p.setTag(new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i3) });
    i1 = this.G.job;
    paramNearbyPeopleCard = this.q;
    if (paramNearbyPeopleCard != null)
    {
      paramNearbyPeopleCard.setText(NearbyProfileUtil.f(i1));
      if (StringUtil.isEmpty(NearbyProfileUtil.f(i1)))
      {
        this.q.setVisibility(8);
      }
      else
      {
        this.q.setBackgroundResource(NearbyProfileUtil.g(i1));
        this.q.setVisibility(0);
      }
    }
    this.r.setText(NearbyProfileUtil.h(i1));
    this.r.setTag(Integer.valueOf(i1));
    this.t.setText(this.G.company);
    this.t.clearFocus();
    paramNearbyPeopleCard = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.F.app.getCurrentAccountUin(), "school_name", "");
    if (!this.aa)
    {
      this.v.setText(this.G.college);
      if (TextUtils.equals(paramNearbyPeopleCard, this.G.college))
      {
        this.Z = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.F.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(0))).intValue();
        if (this.Z == 2) {
          this.w.setVisibility(0);
        } else {
          this.w.setVisibility(8);
        }
      }
      else
      {
        if (this.G.collegeId == 0L)
        {
          if (TextUtils.isEmpty(this.G.college))
          {
            this.w.setVisibility(8);
            this.Z = 1;
          }
          else
          {
            this.w.setVisibility(0);
            this.Z = 2;
          }
        }
        else
        {
          this.w.setVisibility(8);
          this.Z = 1;
        }
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.F.app.getCurrentAccountUin(), "school_name", this.G.college);
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.F.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.Z));
      }
    }
    this.u.setOnClickListener(this);
    g();
    a(this.y, this.G.xuanYan);
    this.y.setTag(this.G.xuanYan);
    this.z.setText(NearbyProfileUtil.b(this.G.maritalStatus - 1));
    this.z.setTag(Byte.valueOf(this.G.maritalStatus));
    if (NearbyProfileUtil.a(this.G.vGiftInfo) != 0)
    {
      this.A.setVisibility(0);
      boolean bool;
      if (this.G.switchGiftVisible == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      this.A.setChecked(bool);
    }
    else
    {
      this.A.setVisibility(8);
    }
    if (this.G.godFlag)
    {
      paramNearbyPeopleCard = this.F.getString(2131892096, new Object[] { this.L });
      paramNearbyPeopleCard = DialogUtil.a(this.F, paramNearbyPeopleCard, 0, 0, null, null);
      paramNearbyPeopleCard.setPositiveButton(this.F.getString(2131892407), new NearbyProfileEditPanel.10(this, paramNearbyPeopleCard));
      paramNearbyPeopleCard.show();
    }
    this.U.a(this.T);
    if ((this.F.mIsFromInterestTest) && (this.F.mEnterEidtTimes == 1)) {
      this.F.mHandler.postDelayed(new NearbyProfileEditPanel.11(this), 300L);
    }
    this.h.findViewById(2131450352).setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.h.findViewById(2131446332).setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.h.findViewById(2131434146).setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.h.findViewById(2131427895).setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.h.findViewById(2131436677).setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.h.findViewById(2131435091).setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.n.addTextChangedListener(new NearbyProfileEditPanel.12(this));
    this.y.addTextChangedListener(new NearbyProfileEditPanel.13(this));
    this.t.addTextChangedListener(new NearbyProfileEditPanel.14(this));
    this.n.getViewTreeObserver().addOnGlobalLayoutListener(new NearbyProfileEditPanel.15(this));
  }
  
  void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.J.size() > 1)
    {
      this.J.remove(paramPicInfo);
      this.F.mPicInfo.remove(paramPicInfo);
      a(paramView, paramPicInfo);
      m();
      B();
      return;
    }
    paramPicInfo = DialogUtil.a(this.F, HardCodeUtil.a(2131905188), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131892267, new NearbyProfileEditPanel.9(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    int i2 = 1;
    int i1 = 1;
    this.aa = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.Z = 1;
      this.v.setText("");
      paramInt = 0;
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.v.getText().toString(), paramString)) {
          if (this.Z == 2)
          {
            paramInt = i2;
            break label103;
          }
        }
        for (;;)
        {
          paramInt = 0;
          break;
          this.Z = paramInt;
        }
      }
      else
      {
        if (paramInt != 2) {
          i1 = 0;
        }
        this.Z = paramInt;
        paramInt = i1;
      }
      label103:
      this.v.setText(paramString);
    }
    if (paramInt != 0)
    {
      this.w.setVisibility(0);
      ReportController.b(this.F.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      return;
    }
    this.w.setVisibility(8);
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    this.i.addView(a(paramPicInfo, null), this.i.getChildCount());
    m();
    return true;
  }
  
  protected int b()
  {
    return 2131627566;
  }
  
  protected void b(View paramView)
  {
    this.X = ((RelativeLayout)paramView.findViewById(2131432344));
    this.X.setBackgroundColor(this.F.getResources().getColor(2131168094));
    this.Y = ((HorizontalScrollView)paramView.findViewById(2131432345));
    this.i = ((LinearLayout)paramView.findViewById(2131432325));
    this.i.getLayoutParams().height = this.F.imageWidth;
    LinearLayout localLinearLayout = this.i;
    localLinearLayout.setLayoutParams(localLinearLayout.getLayoutParams());
    this.k = ((TextView)paramView.findViewById(2131440116));
    this.l = ((TextView)paramView.findViewById(2131446536));
    this.m = ((Button)paramView.findViewById(2131432342));
    this.j = ((LinearLayout)paramView.findViewById(2131432343));
  }
  
  public void c()
  {
    ((ITransFileController)this.F.app.getRuntimeService(ITransFileController.class)).removeHandle(this.ae);
  }
  
  public boolean d()
  {
    if (this.F.mNeedClearPhotoWallWhenCancel) {
      return true;
    }
    if (y()) {
      return true;
    }
    Object localObject1 = this.G;
    int i1 = 0;
    if (localObject1 != null)
    {
      if (!Arrays.equals(((NearbyPeopleCard)localObject1).xuanYan, (byte[])this.y.getTag())) {
        return true;
      }
      if (!Utils.a(this.n.getText().toString(), this.G.nickname)) {
        return true;
      }
      if ((this.z.getTag() != null) && (((Byte)this.z.getTag()).byteValue() != this.G.maritalStatus)) {
        return true;
      }
      if (((Byte)this.o.getTag()).byteValue() != this.G.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.p.getTag())[0]).intValue() != this.G.birthday) {
        return true;
      }
      if (((Integer)this.r.getTag()).intValue() != this.G.job) {
        return true;
      }
      if (!StringUtil.trim(this.t.getText().toString()).equals(this.G.company)) {
        return true;
      }
      if (!StringUtil.trim(this.v.getText().toString()).equals(this.G.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.x.getTag(), new String[] { this.G.hometownCountry, this.G.hometownProvice, this.G.hometownCity, this.G.hometownDistrict })) {
        return true;
      }
      boolean bool2 = this.A.a();
      if (this.G.switchGiftVisible == 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 != bool1) {
        return true;
      }
      Object localObject2 = this.T;
      int i2 = localObject2.length;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i1 >= i2) {
          break;
        }
        localObject1 = localObject2[i1];
        if (localObject1 == null)
        {
          bool2 = bool1;
        }
        else
        {
          InterestTag localInterestTag = this.G.getTagInfos(((InterestTag)localObject1).a);
          if ((localInterestTag == null) && (((InterestTag)localObject1).b.size() == 0))
          {
            bool2 = bool1;
          }
          else
          {
            bool1 = ((InterestTag)localObject1).equals(localInterestTag) ^ true;
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (!QLog.isDevelopLevel()) {
                break;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tagChanged \n");
              ((StringBuilder)localObject2).append("item: ");
              ((StringBuilder)localObject2).append(((InterestTag)localObject1).toString());
              ((StringBuilder)localObject2).append("\n");
              ((StringBuilder)localObject2).append("tag: ");
              if (localInterestTag == null) {
                localObject1 = "null";
              } else {
                localObject1 = localInterestTag.toString();
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("\n");
              QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
              return bool1;
            }
          }
        }
        i1 += 1;
      }
      return bool2;
    }
    return false;
  }
  
  public void e()
  {
    this.Y.fullScroll(66);
  }
  
  public void f()
  {
    Intent localIntent = new Intent(this.F, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.F.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    int i1 = localConditionSearchManager.d();
    Object localObject;
    if (i1 != 0)
    {
      i1 = localConditionSearchManager.a(i1, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLocationSelectActivity | update result = ");
        ((StringBuilder)localObject).append(i1);
        QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
      }
      if (i1 == 2)
      {
        QQToast.makeText(this.F, 2131892104, 0).show(this.F.getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        localObject = this.F;
        ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131888006));
        localConditionSearchManager.c(this.F.mConfigListener);
        return;
      }
      localObject = this.F;
      ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131888006));
      this.F.mHandler.sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    String[] arrayOfString = (String[])this.x.getTag();
    if (arrayOfString != null)
    {
      localObject = arrayOfString;
      if (arrayOfString.length == 4) {}
    }
    else
    {
      localObject = new String[4];
      localObject[0] = "0";
      localObject[1] = "0";
      localObject[2] = "0";
      localObject[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.e((String[])localObject));
    this.F.startActivityForResult(localIntent, 4);
  }
  
  public void g()
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ((NearbyPeopleCard)localObject).hometownCountry;
    arrayOfString[1] = this.G.hometownProvice;
    arrayOfString[2] = this.G.hometownCity;
    arrayOfString[3] = this.G.hometownDistrict;
    localObject = this.F.mConditionSearchManager.d(arrayOfString);
    if (this.x != null)
    {
      if (!"不限".equals(localObject)) {
        this.x.setText((CharSequence)localObject);
      }
      this.x.setTag(arrayOfString);
    }
  }
  
  protected LabelEditCtrl i()
  {
    return new LabelEditCtrl();
  }
  
  boolean j()
  {
    int i1 = this.J.size();
    int i2 = this.K.size();
    if ((i2 <= 0) && (i1 >= 1)) {
      return true;
    }
    if ((i2 >= 1) && (i1 <= 0)) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i2 >= 1)
    {
      bool1 = bool2;
      if (((PicInfo)this.J.get(0)).a != ((PicInfo)this.K.get(0)).a) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean k()
  {
    if (this.F.mNeedClearPhotoWallWhenCancel) {
      return true;
    }
    if (y()) {
      return true;
    }
    NearbyPeopleCard localNearbyPeopleCard = this.G;
    if (localNearbyPeopleCard != null)
    {
      if (!Arrays.equals(localNearbyPeopleCard.xuanYan, (byte[])this.y.getTag())) {
        return true;
      }
      return Utils.a(this.n.getText().toString(), this.G.nickname) ^ true;
    }
    return false;
  }
  
  protected void l()
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    if (i2 >= 11)
    {
      LayoutTransition localLayoutTransition = new LayoutTransition();
      localLayoutTransition.setAnimator(2, null);
      if (Build.VERSION.SDK_INT <= 15)
      {
        localLayoutTransition.setAnimator(0, null);
        localLayoutTransition.setAnimator(1, null);
        localLayoutTransition.setAnimator(3, null);
      }
      this.i.setLayoutTransition(localLayoutTransition);
    }
    this.i.removeAllViews();
    while (i1 < this.J.size())
    {
      this.i.addView(a((PicInfo)this.J.get(i1), null));
      i1 += 1;
    }
  }
  
  void m()
  {
    o();
    n();
  }
  
  protected void n()
  {
    int i1 = 0;
    while (i1 < this.i.getChildCount())
    {
      if ((this.i.getChildAt(i1) instanceof RelativeLayout))
      {
        localObject = (RelativeLayout)this.i.getChildAt(i1);
        ((RelativeLayout)localObject).setOnClickListener(b(i1));
        if (((RelativeLayout)localObject).getChildCount() == 2)
        {
          if (i1 == 0) {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(0);
          } else {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(8);
          }
          if (this.i.getChildAt(i1) != null)
          {
            localObject = this.i.getChildAt(i1);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131905122));
            localStringBuilder.append(i1 + 1);
            ((View)localObject).setContentDescription(localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, headItem's child count is not 2");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, the child of mEditLayout is not a instance of RelativeLayout");
      }
      i1 += 1;
    }
    if (this.J.size() <= 0) {
      this.j.setVisibility(8);
    } else {
      this.j.setVisibility(0);
    }
    Object localObject = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.J.size());
    localStringBuilder.append("/");
    localStringBuilder.append(NearbyProfileCardConstants.a);
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  void o()
  {
    this.J.clear();
    this.J.addAll(p());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reorganizePicInfo:");
      localStringBuilder.append(this.J);
      QLog.d("Q.nearby_people_card.", 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    if ((paramView.getId() != 2131434146) && (paramView != this.o))
    {
      if ((paramView.getId() != 2131436677) && (paramView != this.r))
      {
        if (paramView == this.u)
        {
          paramView = this.v.getText().toString();
          paramView = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.Z));
          localObject1 = new Intent(this.F, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.F.startActivity((Intent)localObject1);
          return;
        }
        if ((paramView.getId() != 2131435091) && (paramView != this.x))
        {
          if ((paramView.getId() != 2131450352) && (paramView != this.y))
          {
            if ((paramView.getId() != 2131446332) && (paramView != this.z))
            {
              if ((paramView.getId() == 2131427895) || (paramView == this.p))
              {
                localObject1 = ActionSheet.createMenuSheet(this.F);
                localObject2 = Calendar.getInstance();
                this.M = ((Calendar)localObject2).get(1);
                Object localObject3 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131427560);
                ((DispatchActionMoveScrollView)localObject3).a = true;
                ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
                localObject3 = (IphonePickerView)LayoutInflater.from(this.F).inflate(2131627482, null);
                ((IphonePickerView)localObject3).a(this.ac);
                if (this.p.getTag() != null)
                {
                  i1 = ((Integer)((Object[])(Object[])this.p.getTag())[0]).intValue();
                  int i3;
                  if (i1 == 0)
                  {
                    i1 = 94;
                    i2 = 0;
                    i3 = 0;
                  }
                  else
                  {
                    i3 = ((0xFF00 & i1) >>> 8) - 1;
                    i2 = (i1 & 0xFF) - 1;
                    i1 = (i1 >>> 16) - 1896;
                  }
                  ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
                  this.M = ((Calendar)localObject2).get(1);
                  this.N = (((Calendar)localObject2).get(2) + 1);
                  this.O = ((Calendar)localObject2).get(5);
                  ((IphonePickerView)localObject3).setPickListener(new NearbyProfileEditPanel.3(this, (IphonePickerView)localObject3, (ActionSheet)localObject1));
                  ((IphonePickerView)localObject3).setSelection(0, i1);
                  ((IphonePickerView)localObject3).setSelection(1, i3);
                  ((IphonePickerView)localObject3).setSelection(2, i2);
                  ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditPanel.4(this));
                  ((ActionSheet)localObject1).setActionContentView((View)localObject3, null);
                  ((ActionSheet)localObject1).show();
                  a(paramView, ((ActionSheet)localObject1).getActionContentView());
                  a(this.p, true);
                }
              }
            }
            else {
              x();
            }
          }
          else {
            w();
          }
        }
        else {
          f();
        }
      }
      else
      {
        v();
      }
    }
    else
    {
      localObject1 = ActionSheet.createMenuSheet(this.F);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject2).a = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.F).inflate(2131627482, null);
      ((IphonePickerView)localObject2).a(this.ai);
      if (this.o.getTag() != null)
      {
        i2 = ((Byte)this.o.getTag()).byteValue();
        if (i2 >= 0)
        {
          i1 = i2;
          if (i2 <= 1) {}
        }
        else
        {
          i1 = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, i1);
        ((IphonePickerView)localObject2).setPickListener(new NearbyProfileEditPanel.1(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditPanel.2(this));
        ((ActionSheet)localObject1).setActionContentView((View)localObject2, null);
        ((ActionSheet)localObject1).show();
        a(paramView, ((ActionSheet)localObject1).getActionContentView());
        a(this.o, true);
      }
    }
  }
  
  protected List<PicInfo> p()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.i.getChildCount())
    {
      localArrayList.add((PicInfo)this.i.getChildAt(i1).getTag());
      i1 += 1;
    }
    return localArrayList;
  }
  
  protected void q()
  {
    if (this.G.godFlag) {
      this.l.setText(this.F.getString(2131892086));
    } else if (this.J.size() > 12) {
      this.l.setText(this.F.getString(2131892087, new Object[] { this.L }));
    }
    this.m.setContentDescription(HardCodeUtil.a(2131905106));
    this.m.setOnClickListener(this.V);
  }
  
  protected void r()
  {
    this.f.setText(HardCodeUtil.a(2131905149));
    this.f.setVisibility(0);
    this.g.setText(HardCodeUtil.a(2131905112));
    this.g.setTextSize(2, 10.0F);
    this.g.setVisibility(0);
    this.f.setOnClickListener(null);
    this.g.setOnClickListener(null);
    this.g.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.h.findViewById(2131436180).setVisibility(8);
    TextView localTextView = (TextView)this.h.findViewById(2131436182);
    localTextView.setVisibility(0);
    localTextView.setText(2131887648);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.19(this));
    localTextView = (TextView)this.h.findViewById(2131436211);
    localTextView.setVisibility(0);
    localTextView.setText(2131889474);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.20(this));
    this.h.findViewById(2131444897).setOnClickListener(this);
  }
  
  void s()
  {
    ReportController.b(this.F.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOldSaveAction, picInfo size|");
      localStringBuilder.append(this.J.size());
      QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
    }
    F();
  }
  
  int t()
  {
    this.H.clear();
    int i1 = 0;
    while (i1 < this.J.size())
    {
      PicInfo localPicInfo = (PicInfo)this.J.get(i1);
      if (localPicInfo.a == -1) {
        this.H.add(localPicInfo);
      }
      i1 += 1;
    }
    this.I = this.H.size();
    return this.I;
  }
  
  void u()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.F.showWaitingDialog(HardCodeUtil.a(2131905183));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.J);
    if (y())
    {
      ReportController.b(this.F.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      i1 = 3;
      if (this.F.mMode == 1) {
        i1 = 1;
      }
      localObject1 = this.G;
      if ((localObject1 != null) && (((NearbyPeopleCard)localObject1).gender == 0)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject1, "", String.valueOf(i1));
    }
    int i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.F.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject1 = this.F.app;
    Object localObject2 = NearbyUtils.b(this.F.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
    localObject1 = new Bundle();
    a((Bundle)localObject1);
    localObject2 = this.F.mCardHandler;
    if (localObject2 != null)
    {
      this.F.app.execute(new NearbyProfileEditPanel.23(this, (INearbyCardHandler)localObject2, (Bundle)localObject1, localArrayList));
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
    }
  }
  
  public void v()
  {
    Intent localIntent = new Intent(this.F, JobSelectionActivity.class);
    EditText localEditText = this.r;
    if ((localEditText != null) && (localEditText.getTag() != null) && ((this.r.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.r.getTag());
    }
    this.F.startActivityForResult(localIntent, 3);
  }
  
  public void w()
  {
    Intent localIntent = new Intent(this.F, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.y.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.F.startActivityForResult(localIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel
 * JD-Core Version:    0.7.0.1
 */