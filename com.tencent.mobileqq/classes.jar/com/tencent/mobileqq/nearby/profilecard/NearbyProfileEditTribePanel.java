package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
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
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class NearbyProfileEditTribePanel
  extends NearbyProfileEditBasePanel
  implements View.OnClickListener
{
  static final String[] d = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  NearbyPeopleProfileActivity A;
  NearbyPeopleCard B;
  LinkedList<PicInfo> C = new LinkedList();
  int D;
  final ArrayList<PicInfo> E = new ArrayList(13);
  final ArrayList<PicInfo> F = new ArrayList(13);
  String G = "";
  int H = 2015;
  int I;
  int J;
  int K;
  int L;
  int M;
  int N;
  private int O;
  private boolean P = false;
  private NearbyProfileEditTribePanel.OnPicDragListener Q;
  private IphonePickerView.PickerViewAdapter R = new NearbyProfileEditTribePanel.12(this);
  private TransProcessorHandler S = new NearbyProfileEditTribePanel.15(this);
  private PicInfo T;
  private RelativeLayout U = null;
  private View.OnLongClickListener V = new NearbyProfileEditTribePanel.18(this);
  private IphonePickerView.PickerViewAdapter W = new NearbyProfileEditTribePanel.19(this);
  TextView e;
  TextView f;
  View g;
  LinearLayout h;
  URLImageView i;
  ImageView j;
  TextView k;
  TextView l;
  TextView m;
  EditText n;
  EditText o;
  EditText p;
  TextView q;
  EditText r;
  LinearLayout s;
  TextView t;
  TextView u;
  EditText v;
  URLImageView w;
  EditText x;
  TextView y;
  BounceScrollView z;
  
  public NearbyProfileEditTribePanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.A = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.Q = new NearbyProfileEditTribePanel.OnPicDragListener(this, this.A.imageWidth);
    }
    this.N = UIUtils.a(this.A, 2.0F);
    this.S.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.A.app.getRuntimeService(ITransFileController.class)).addHandle(this.S);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.A);
    localRelativeLayout.setBackgroundResource(2130846492);
    Object localObject = new LinearLayout.LayoutParams(this.A.imageWidth, this.A.imageWidth);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.N, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.A);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a(this.w, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.V);
      localRelativeLayout.setOnDragListener(this.Q);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(q());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditTribePanel.20(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2131167987;
    } else {
      i1 = 2131167993;
    }
    paramTextView.setTextColor(this.A.getResources().getColorStateList(i1));
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = null;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.A.getResources().getColor(2131165564));
      }
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.A.mStatusManager != null) {
          paramArrayOfByte = this.A.mStatusManager.a(localRichStatus.actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.A.getResources(), 2130851609);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.A.getResources(), paramArrayOfByte, false, false);
        int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, i1, i1);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, 3, 17);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      paramTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(URLImageView paramURLImageView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDrawable ,picInfo:");
      ((StringBuilder)localObject).append(paramPicInfo);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
    }
    paramURLImageView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(this.b, 15.0F));
      ((GradientDrawable)localObject).setColor(-1579033);
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.A.imageWidth;
      localURLDrawableOptions.mRequestHeight = this.A.imageWidth;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      if ((paramPicInfo.d != null) && (paramPicInfo.d.length() > 0))
      {
        paramPicInfo = new File(paramPicInfo.d).toURL();
        URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramURLImageView.setImageDrawable(paramPicInfo);
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
        paramPicInfo = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramDrawable), localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramURLImageView.setImageDrawable(paramPicInfo);
        return;
      }
    }
    catch (MalformedURLException paramURLImageView)
    {
      if (QLog.isColorLevel())
      {
        paramPicInfo = new StringBuilder();
        paramPicInfo.append("GridAdapter.getView() new URL(). ");
        paramPicInfo.append(paramURLImageView.getMessage());
        QLog.d("Q.nearby_people_card.", 2, paramPicInfo.toString(), paramURLImageView);
      }
    }
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.E.size() > 1)
    {
      this.E.remove(paramPicInfo);
      r();
      return;
    }
    paramPicInfo = DialogUtil.a(this.A, HardCodeUtil.a(2131905123), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131892267, new NearbyProfileEditTribePanel.7(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private boolean o()
  {
    if (this.C.size() > 0) {
      return true;
    }
    int i2 = this.E.size();
    if (i2 != this.F.size()) {
      return true;
    }
    int i1 = 0;
    while ((i1 < i2) && (this.F.size() > 0))
    {
      if (((PicInfo)this.E.get(i1)).a != ((PicInfo)this.F.get(i1)).a) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean p()
  {
    if (this.C.size() > 0) {
      return true;
    }
    int i1 = 0;
    while ((i1 < this.E.size()) && (this.F.size() > 0))
    {
      if (((PicInfo)this.E.get(i1)).a != ((PicInfo)this.F.get(i1)).a) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private View q()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.A);
    localRelativeLayout.setBackgroundResource(2130842256);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.A, 35.0F), UIUtils.a(this.A, 16.0F));
    int i1 = UIUtils.a(this.A, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(i1, 0, 0, i1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.A);
    ((TextView)localObject).setText(HardCodeUtil.a(2131905155));
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
  
  private void r()
  {
    s();
  }
  
  private void s()
  {
    this.E.clear();
    this.E.add((PicInfo)this.w.getTag());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reorganizePicInfo:");
      localStringBuilder.append(this.E);
      QLog.d("Q.nearby_people_card.", 2, localStringBuilder.toString());
    }
  }
  
  private void t()
  {
    this.e.setText(HardCodeUtil.a(2131905207));
    this.e.setVisibility(0);
    this.f.setText(HardCodeUtil.a(2131905178));
    this.f.setTextSize(2, 10.0F);
    this.f.setVisibility(0);
    this.e.setOnClickListener(null);
    this.f.setOnClickListener(null);
    this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.g.findViewById(2131436180).setVisibility(8);
    TextView localTextView = (TextView)this.g.findViewById(2131436182);
    localTextView.setVisibility(0);
    localTextView.setText(2131887648);
    localTextView.setOnClickListener(new NearbyProfileEditTribePanel.13(this));
    localTextView = (TextView)this.g.findViewById(2131436211);
    localTextView.setVisibility(0);
    localTextView.setText(2131889474);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new NearbyProfileEditTribePanel.14(this));
    this.g.findViewById(2131444897).setOnClickListener(this);
  }
  
  private String u()
  {
    ArrayList localArrayList = new ArrayList(5);
    if (p()) {
      localArrayList.add(Integer.valueOf(1));
    }
    Object localObject = this.B;
    int i1 = 0;
    if (localObject != null)
    {
      if (!Utils.a(this.n.getText().toString(), this.B.nickname)) {
        localArrayList.add(Integer.valueOf(2));
      }
      if (((Byte)this.o.getTag()).byteValue() != this.B.gender) {
        localArrayList.add(Integer.valueOf(3));
      }
      if (((Integer)((Object[])(Object[])this.p.getTag())[0]).intValue() != this.B.birthday) {
        localArrayList.add(Integer.valueOf(4));
      }
      if (!Arrays.equals(this.B.xuanYan, (byte[])this.x.getTag())) {
        localArrayList.add(Integer.valueOf(5));
      }
    }
    localObject = new StringBuilder();
    if (localArrayList.size() > 0) {
      while (i1 < localArrayList.size())
      {
        if (i1 != localArrayList.size() - 1)
        {
          ((StringBuilder)localObject).append(localArrayList.get(i1));
          ((StringBuilder)localObject).append("::");
        }
        else
        {
          ((StringBuilder)localObject).append(localArrayList.get(i1));
        }
        i1 += 1;
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private boolean v()
  {
    String str = this.n.getText().toString();
    if (!StringUtil.isEmpty(str))
    {
      if (StringUtil.trim(str).length() == 0)
      {
        this.A.showToast(HardCodeUtil.a(2131905187));
        return false;
      }
      return true;
    }
    this.A.showToast(HardCodeUtil.a(2131905116));
    return false;
  }
  
  private void w()
  {
    if (this.C.size() > 0)
    {
      localObject = new StringBuilder(HardCodeUtil.a(2131905202));
      ((StringBuilder)localObject).append(this.D - this.C.size() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.D);
      ((StringBuilder)localObject).append(")...");
      this.A.showWaitingDialog(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditTribePanel.16(this);
      this.A.app.execute((Runnable)localObject);
      return;
    }
    l();
    Object localObject = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.A, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.A.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append(this.A.app.getCurrentAccountUin());
    paramString.append("/");
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
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.A, "/base/album/photolist");
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.A.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(this.A.app.getCurrentAccountUin());
    ((StringBuilder)localObject).append("/");
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
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.A, false, true);
    ReportController.b(this.A.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.H;
    int i2 = paramInt1 + 1896;
    i1 -= i2;
    Object localObject1 = Calendar.getInstance();
    int i3 = paramInt2 + 1;
    paramInt3 += 1;
    ((Calendar)localObject1).set(1, i3, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.I, this.J);
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
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("岁");
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    this.p.setText(((StringBuilder)localObject2).toString());
    this.p.setTag(new Object[] { Integer.valueOf(i2 << 16 | i3 << 8 | paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1;
    Object localObject1;
    Object localObject2;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 11) {
        break label467;
      }
      i1 = 0;
      localObject1 = null;
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
                break label467;
              }
              localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
              this.A.mAlbumId = paramIntent.getStringExtra("key_album_id");
              if ((StringUtil.isEmpty((String)localObject1)) || (this.A.mMode != 1) || (this.E.size() >= NearbyProfileCardConstants.a)) {
                break label467;
              }
              paramIntent = a((String)localObject1);
              this.A.startActivity(paramIntent);
              return;
            }
            if (paramInt2 != -1) {
              break label467;
            }
            localObject2 = paramIntent.getStringArrayExtra("param_location");
          }
        }
      }
    }
    try
    {
      paramIntent = this.A.mConditionSearchManager.d((String[])localObject2);
      if (paramIntent != null)
      {
        localObject1 = paramIntent;
        if (!paramIntent.equals("不限")) {}
      }
      else
      {
        localObject1 = "";
      }
      paramIntent = this.v;
      if (paramIntent != null)
      {
        paramIntent.setText((CharSequence)localObject1);
        this.v.setTag(localObject2);
        return;
        if ((paramInt2 == -1) && (this.r != null))
        {
          localObject1 = paramIntent.getStringExtra("param_name");
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          localObject2 = paramIntent.getStringExtra("param_tag");
          paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
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
                this.h.removeAllViews();
                paramInt1 = i1;
                while (paramInt1 < paramIntent.size())
                {
                  this.h.addView(a((PicInfo)paramIntent.get(paramInt1), null));
                  paramInt1 += 1;
                }
                r();
                return;
              }
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                localObject1 = this.x;
                if (localObject1 != null)
                {
                  a((TextView)localObject1, paramIntent);
                  this.x.setTag(paramIntent);
                }
              }
            }
          }
        }
      }
      label467:
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent = (Intent)localObject1;
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.g = paramView;
    paramView.findViewById(2131447534).setVisibility(0);
    this.e = ((TextView)paramView.findViewById(2131447581));
    this.f = ((TextView)paramView.findViewById(2131447497));
    paramView.findViewById(2131436227).setVisibility(4);
    this.j = ((ImageView)paramView.findViewById(2131449607));
    this.k = ((TextView)paramView.findViewById(2131440606));
    this.l = ((TextView)paramView.findViewById(2131440116));
    this.m = ((TextView)paramView.findViewById(2131446536));
    this.n = ((EditText)paramView.findViewById(2131439320));
    this.o = ((EditText)paramView.findViewById(2131434143));
    this.p = ((EditText)paramView.findViewById(2131427893));
    this.w = ((URLImageView)paramView.findViewById(2131428988));
    this.x = ((EditText)paramView.findViewById(2131450351));
    this.z = ((BounceScrollView)this.g.findViewById(2131432350));
    this.z.mScrollFlag = 1;
    t();
    TroopBarUtils.b("profile_edit", "exp", "", "", "", "");
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EditPanel bindData, isEditing = ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mActivity.mPicInfo.size = ");
      ((StringBuilder)localObject).append(this.A.mPicInfo);
      if (((StringBuilder)localObject).toString() == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(this.A.mPicInfo.size());
      }
      QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
    }
    int i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.A.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject = this.A.app;
    String str = NearbyUtils.b(this.A.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, str, localStringBuilder.toString(), "", "");
    this.B = paramNearbyPeopleCard;
    if ((this.B.picList != null) && (this.B.picList.size() > 0))
    {
      a(this.w, (PicInfo)this.B.picList.get(0), null);
    }
    else
    {
      paramNearbyPeopleCard = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramNearbyPeopleCard = FaceDrawable.getFaceDrawable(paramNearbyPeopleCard, 1, paramNearbyPeopleCard.getCurrentAccountUin());
      this.w.setImageDrawable(paramNearbyPeopleCard);
    }
    if (!this.c)
    {
      this.E.clear();
      this.E.addAll(this.A.mPicInfo);
      this.F.clear();
      this.F.addAll(this.E);
    }
    if (!this.A.mHasNewPhoto)
    {
      this.A.mPicInfo.clear();
      this.E.clear();
      this.F.clear();
    }
    if (this.B.gender == 0) {
      this.G = HardCodeUtil.a(2131905197);
    } else if (this.B.gender == 1) {
      this.G = HardCodeUtil.a(2131905151);
    }
    if (this.B.godFlag) {
      this.m.setText(this.A.getString(2131892086));
    } else if (this.E.size() > 12) {
      this.m.setText(this.A.getString(2131892087, new Object[] { this.G }));
    }
    this.n.setText(this.B.nickname);
    this.o.setText(NearbyProfileUtil.c(this.B.gender));
    this.o.setTag(Byte.valueOf(this.B.gender));
    i1 = this.B.age;
    int i2 = this.B.birthday;
    int i3 = this.B.constellation;
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
    i1 = this.B.job;
    a(this.x, this.B.xuanYan);
    this.x.setTag(this.B.xuanYan);
    if ((this.A.mIsFromInterestTest) && (this.A.mEnterEidtTimes == 1)) {
      this.A.mHandler.postDelayed(new NearbyProfileEditTribePanel.8(this), 300L);
    }
    this.g.findViewById(2131450352).setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.g.findViewById(2131434146).setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.g.findViewById(2131427895).setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.g.findViewById(2131429016).setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.n.addTextChangedListener(new NearbyProfileEditTribePanel.9(this));
    this.x.addTextChangedListener(new NearbyProfileEditTribePanel.10(this));
    this.n.getViewTreeObserver().addOnGlobalLayoutListener(new NearbyProfileEditTribePanel.11(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    int i2 = 1;
    int i1 = 1;
    this.P = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.O = 1;
      this.t.setText("");
      paramInt = 0;
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.t.getText().toString(), paramString)) {
          if (this.O == 2)
          {
            paramInt = i2;
            break label103;
          }
        }
        for (;;)
        {
          paramInt = 0;
          break;
          this.O = paramInt;
        }
      }
      else
      {
        if (paramInt != 2) {
          i1 = 0;
        }
        this.O = paramInt;
        paramInt = i1;
      }
      label103:
      this.t.setText(paramString);
    }
    if (paramInt != 0)
    {
      this.u.setVisibility(0);
      ReportController.b(this.A.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      return;
    }
    this.u.setVisibility(8);
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    a(this.w, paramPicInfo, null);
    r();
    return true;
  }
  
  protected int b()
  {
    return 2131627567;
  }
  
  public void c()
  {
    ((ITransFileController)this.A.app.getRuntimeService(ITransFileController.class)).removeHandle(this.S);
  }
  
  public boolean d()
  {
    if (this.A.mNeedClearPhotoWallWhenCancel) {
      return true;
    }
    if (p()) {
      return true;
    }
    NearbyPeopleCard localNearbyPeopleCard = this.B;
    if (localNearbyPeopleCard != null)
    {
      if (!Arrays.equals(localNearbyPeopleCard.xuanYan, (byte[])this.x.getTag())) {
        return true;
      }
      if (!Utils.a(this.n.getText().toString(), this.B.nickname)) {
        return true;
      }
      if (((Byte)this.o.getTag()).byteValue() != this.B.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.p.getTag())[0]).intValue() != this.B.birthday) {
        return true;
      }
    }
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    Intent localIntent = new Intent(this.A, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.A.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
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
        QQToast.makeText(this.A, 2131892104, 0).show(this.A.getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        localObject = this.A;
        ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131888006));
        localConditionSearchManager.c(this.A.mConfigListener);
        return;
      }
      localObject = this.A;
      ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131888006));
      this.A.mHandler.sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    String[] arrayOfString = (String[])this.v.getTag();
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
    this.A.startActivityForResult(localIntent, 4);
  }
  
  public void g()
  {
    Object localObject = this.B;
    if (localObject == null) {
      return;
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ((NearbyPeopleCard)localObject).hometownCountry;
    arrayOfString[1] = this.B.hometownProvice;
    arrayOfString[2] = this.B.hometownCity;
    arrayOfString[3] = this.B.hometownDistrict;
    localObject = this.A.mConditionSearchManager.d(arrayOfString);
    if (this.v != null)
    {
      if (!"不限".equals(localObject)) {
        this.v.setText((CharSequence)localObject);
      }
      this.v.setTag(arrayOfString);
    }
  }
  
  boolean i()
  {
    int i1 = this.E.size();
    int i2 = this.F.size();
    if ((i2 <= 0) && (i1 >= 1)) {
      return true;
    }
    if ((i2 >= 1) && (i1 <= 0)) {
      return true;
    }
    return (i2 >= 1) && (i1 >= 1) && (((PicInfo)this.E.get(0)).a != ((PicInfo)this.F.get(0)).a);
  }
  
  void j()
  {
    ReportController.b(this.A.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    TroopBarUtils.b("profile_edit", "suc_edit", u(), "", "", "");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOldSaveAction, picInfo size|");
      localStringBuilder.append(this.E.size());
      QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
    }
    w();
  }
  
  int k()
  {
    this.C.clear();
    int i1 = 0;
    while (i1 < this.E.size())
    {
      PicInfo localPicInfo = (PicInfo)this.E.get(i1);
      if (localPicInfo.a == -1) {
        this.C.add(localPicInfo);
      }
      i1 += 1;
    }
    this.D = this.C.size();
    return this.D;
  }
  
  void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.A.showWaitingDialog(HardCodeUtil.a(2131905189));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.E);
    if (o())
    {
      ReportController.b(this.A.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      i1 = 3;
      if (this.A.mMode == 1) {
        i1 = 1;
      }
      localObject1 = this.B;
      if ((localObject1 != null) && (((NearbyPeopleCard)localObject1).gender == 0)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject1, "", String.valueOf(i1));
    }
    int i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.A.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject1 = this.A.app;
    Object localObject2 = NearbyUtils.b(this.A.from);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("");
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
    localObject3 = new Bundle();
    ((Bundle)localObject3).putBoolean("key_is_nearby_people_card", true);
    ((Bundle)localObject3).putShort("key_new_profile_modified_flag", (short)1);
    if (this.B != null)
    {
      localObject2 = (byte[])this.x.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      ((Bundle)localObject3).putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.B.xuanYan, (byte[])this.x.getTag()))
      {
        localObject1 = this.A;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject1 = this.n.getText().toString();
      if (!((String)localObject1).equals(this.B.nickname))
      {
        ((Bundle)localObject3).putString("key_new_nickname", (String)localObject1);
        localObject1 = this.A;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      byte b = ((Byte)this.o.getTag()).byteValue();
      if (b != this.B.gender)
      {
        ((Bundle)localObject3).putByte("sex", b);
        localObject1 = this.A;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.p.getTag();
      i1 = ((Integer)localObject1[0]).intValue();
      if (i1 != this.B.birthday)
      {
        ((Bundle)localObject3).putInt("birthday", i1);
        ((Bundle)localObject3).putInt("age", ((Integer)localObject1[1]).intValue());
        ((Bundle)localObject3).putInt("key_constellation", ((Integer)localObject1[2]).intValue());
        ReportController.b(this.A.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
    }
    localObject1 = this.A.mCardHandler;
    if (localObject1 != null)
    {
      this.A.app.execute(new NearbyProfileEditTribePanel.17(this, (INearbyCardHandler)localObject1, (Bundle)localObject3, localArrayList));
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
    }
  }
  
  public void m()
  {
    Intent localIntent = new Intent(this.A, JobSelectionActivity.class);
    EditText localEditText = this.r;
    if ((localEditText != null) && (localEditText.getTag() != null) && ((this.r.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.r.getTag());
    }
    this.A.startActivityForResult(localIntent, 3);
  }
  
  public void n()
  {
    Intent localIntent = new Intent(this.A, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.x.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.A.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i1;
    Object localObject2;
    int i2;
    if ((paramView.getId() != 2131434146) && (paramView != this.o))
    {
      if ((paramView.getId() != 2131436677) && (paramView != this.r))
      {
        if (paramView == this.s)
        {
          paramView = this.t.getText().toString();
          paramView = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.O));
          localObject1 = new Intent(this.A, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.A.startActivity((Intent)localObject1);
          return;
        }
        if ((paramView.getId() != 2131435091) && (paramView != this.v))
        {
          if ((paramView.getId() != 2131450352) && (paramView != this.x))
          {
            if ((paramView.getId() != 2131427895) && (paramView != this.p))
            {
              if (paramView == this.i)
              {
                paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                localObject1 = this.A;
                if (!paramView.showTakeAuthVideoGuideDialog((Activity)localObject1, ((NearbyPeopleProfileActivity)localObject1).app))
                {
                  if ((this.B.videoInfo != null) && (!TextUtils.isEmpty(this.B.videoInfo.b)))
                  {
                    ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).startPlayerActivity(this.A, null, this.B.videoInfo.e, this.B.videoInfo.b, this.B.uin, this.A.mMode, true);
                    i1 = 1;
                  }
                  else
                  {
                    paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                    localObject1 = this.A;
                    paramView.showPtvPanel((Activity)localObject1, ((NearbyPeopleProfileActivity)localObject1).app, 2);
                  }
                }
                else {
                  i1 = 2;
                }
                paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(i1);
                paramView.report("clk_video_entry", new String[] { ((StringBuilder)localObject1).toString(), this.B.uin, "1" });
                return;
              }
              if ((paramView.getId() == 2131429016) || (paramView == this.w))
              {
                paramView = this.E;
                if (paramView != null) {
                  a(paramView.size());
                }
              }
            }
            else
            {
              localObject1 = ActionSheet.createMenuSheet(this.A);
              localObject2 = Calendar.getInstance();
              this.H = ((Calendar)localObject2).get(1);
              Object localObject3 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131427560);
              ((DispatchActionMoveScrollView)localObject3).a = true;
              ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
              localObject3 = (IphonePickerView)LayoutInflater.from(this.A).inflate(2131627482, null);
              ((IphonePickerView)localObject3).a(this.R);
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
                this.H = ((Calendar)localObject2).get(1);
                this.I = (((Calendar)localObject2).get(2) + 1);
                this.J = ((Calendar)localObject2).get(5);
                ((IphonePickerView)localObject3).setPickListener(new NearbyProfileEditTribePanel.3(this, (IphonePickerView)localObject3, (ActionSheet)localObject1));
                ((IphonePickerView)localObject3).setSelection(0, i1);
                ((IphonePickerView)localObject3).setSelection(1, i3);
                ((IphonePickerView)localObject3).setSelection(2, i2);
                ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditTribePanel.4(this));
                ((ActionSheet)localObject1).setActionContentView((View)localObject3, null);
                ((ActionSheet)localObject1).show();
                a(paramView, ((ActionSheet)localObject1).getActionContentView());
                a(this.p, false);
              }
            }
          }
          else {
            n();
          }
        }
        else {
          f();
        }
      }
      else
      {
        m();
      }
    }
    else
    {
      localObject1 = ActionSheet.createMenuSheet(this.A);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject2).a = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.A).inflate(2131627482, null);
      ((IphonePickerView)localObject2).a(this.W);
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
        ((IphonePickerView)localObject2).setPickListener(new NearbyProfileEditTribePanel.1(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditTribePanel.2(this));
        ((ActionSheet)localObject1).setActionContentView((View)localObject2, null);
        ((ActionSheet)localObject1).show();
        a(paramView, ((ActionSheet)localObject1).getActionContentView());
        a(this.o, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel
 * JD-Core Version:    0.7.0.1
 */