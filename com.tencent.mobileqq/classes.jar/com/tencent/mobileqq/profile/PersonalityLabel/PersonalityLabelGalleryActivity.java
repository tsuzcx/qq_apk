package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PersonalityLabelGalleryActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, PLUploadManager.UploadListener
{
  private View A;
  private TextView B;
  private TextView C;
  private View D;
  private ViewStub E;
  private View F;
  private Button G;
  private Button H;
  private TextView I;
  private PersonalityLabelGalleryActivity.ListViewAdapter J;
  private ProfilePersonalityLabelInfo K;
  private ConcurrentHashMap<Long, PersonalityLabelInfo> L = new ConcurrentHashMap();
  private long M;
  private List<String> N = new ArrayList();
  private int O;
  private int P = 0;
  private AllInOne Q;
  private boolean R = false;
  private boolean S = false;
  private ConcurrentHashMap<Long, byte[]> T = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Integer> U = new ConcurrentHashMap();
  private PersonalityLabelObserver V = new PersonalityLabelGalleryActivity.6(this);
  QQProgressDialog a;
  HashSet<Long> b = new HashSet();
  boolean c = false;
  Drawable d;
  QQToast e;
  QQToast f;
  Handler g = new Handler(ThreadManager.getFileThreadLooper(), this);
  Handler h = new Handler(Looper.getMainLooper(), this);
  boolean i = false;
  int j = 0;
  TextPaint k;
  boolean l = false;
  boolean m = false;
  volatile boolean n = true;
  FriendListHandler o;
  protected TopGestureLayout p;
  PLUploadManager q;
  ActionSheet r;
  BroadcastReceiver s = new PersonalityLabelGalleryActivity.5(this);
  FriendListObserver t = new PersonalityLabelGalleryActivity.12(this);
  QQProgressDialog.Callback u = new PersonalityLabelGalleryActivity.13(this);
  private float v;
  private String w;
  private String x;
  private boolean y;
  private XListView z;
  
  public static int a(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).getInt();
  }
  
  private void a(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.z.getChildCount())
    {
      PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.z.getChildAt(i1).getTag();
      if ((localLabelItemViewHolder != null) && (localLabelItemViewHolder.a == paramLong))
      {
        localLabelItemViewHolder.i.getAdapter().notifyDataSetChanged();
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    int i1 = 0;
    while (i1 < this.z.getChildCount())
    {
      PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.z.getChildAt(i1).getTag();
      if ((localLabelItemViewHolder != null) && (localLabelItemViewHolder.a == paramLong))
      {
        i1 = paramPersonalityLabelInfo.getSize();
        int i2 = 1;
        if (i1 > 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (localLabelItemViewHolder.i.getVisibility() != 0) {
          i2 = 0;
        }
        if (i2 != i1)
        {
          localGlowCountRecyclerView = localLabelItemViewHolder.i;
          if (i1 != 0) {
            i1 = 0;
          } else {
            i1 = 8;
          }
          localGlowCountRecyclerView.setVisibility(i1);
        }
        GlowCountRecyclerView localGlowCountRecyclerView = localLabelItemViewHolder.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramPersonalityLabelInfo.photoCount);
        localStringBuilder.append("张");
        localGlowCountRecyclerView.setText(localStringBuilder.toString());
        localLabelItemViewHolder.i.getAdapter().notifyDataSetChanged();
        localLabelItemViewHolder.i.smoothScrollToPosition(0);
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.P = paramIntent.getIntExtra("fromType", this.P);
      this.Q = ((AllInOne)paramIntent.getParcelableExtra("personality_label_allinone"));
      this.w = paramIntent.getStringExtra("uin");
      this.x = paramIntent.getStringExtra("nickname");
      if (TextUtils.isEmpty(this.w))
      {
        QQToast.makeText(this, "打开标签失败，请重试", 0);
        finish();
        return;
      }
      if ((TextUtils.isEmpty(this.x)) && (!this.w.equals(this.app.getCurrentAccountUin())))
      {
        this.x = ContactUtils.a(this.app, this.w);
        if ((TextUtils.isEmpty(this.x)) || (TextUtils.equals(this.x, this.w)))
        {
          this.o = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
          this.o.getFriendInfo(this.w);
        }
      }
      if (this.P == 3) {
        this.c = true;
      }
    }
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.getSize() > 0)) {
      return;
    }
    if (this.D == null) {}
    try
    {
      this.D = this.E.inflate();
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label33:
      break label33;
    }
    System.gc();
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "setEmptyText inflate empty view outOfMemoryError");
    }
    try
    {
      this.D = this.E.inflate();
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label66:
      View localView1;
      TextView localTextView1;
      TextView localTextView2;
      View localView2;
      break label66;
    }
    localView1 = this.D;
    if (localView1 == null) {
      return;
    }
    localView1 = localView1.findViewById(2131432530);
    localTextView1 = (TextView)this.D.findViewById(2131432527);
    localTextView2 = (TextView)this.D.findViewById(2131432534);
    localView2 = this.D.findViewById(2131432494);
    if (this.y)
    {
      localTextView1.setText(2131897147);
      localTextView2.setText(getString(2131897143));
      localView2.setOnClickListener(this);
      return;
    }
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.isCloseByUser == 1))
    {
      localTextView1.setText(2131897142);
      localView2.setVisibility(8);
      localTextView2.setVisibility(8);
      if (localView1.getPaddingBottom() <= 0) {
        localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), localView1.getPaddingBottom() + AIOUtils.b(73.0F, getResources()));
      }
    }
    else
    {
      localTextView1.setText(2131897147);
      localView2.setVisibility(8);
      localTextView2.setText(getString(2131897146));
      if (localView1.getPaddingBottom() <= 0) {
        localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), localView1.getPaddingBottom() + AIOUtils.b(73.0F, getResources()));
      }
    }
  }
  
  private void a(String paramString)
  {
    QQToast.makeText(BaseApplication.getContext(), paramString, 0).show(getTitleBarHeight());
  }
  
  private void a(String paramString, QQProgressDialog.Callback paramCallback)
  {
    if (isFinishing()) {
      return;
    }
    if (this.a == null) {
      this.a = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.a.a(paramCallback);
    this.a.a(paramString);
    if (isFinishing()) {
      return;
    }
    this.a.show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.i)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        a(getResources().getString(2131892102));
        return;
      }
      if (isTitleProgressShowing())
      {
        a("请等待数据加载完毕");
        return;
      }
    }
    this.i ^= true;
    b();
    View localView = this.F;
    int i1;
    if ((this.y) && (!this.i) && (c())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (this.h.hasMessages(2)) {
      this.h.removeMessages(2);
    }
    this.h.sendEmptyMessage(2);
    if ((this.i) && (this.m))
    {
      this.l = false;
      g();
    }
    if (this.K.unreadCount > 0) {
      b(0);
    }
    e();
  }
  
  public static byte[] a(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt(paramInt);
    return localByteBuffer.array();
  }
  
  private void b(int paramInt)
  {
    int i1 = paramInt;
    if (this.i)
    {
      i1 = paramInt;
      if (paramInt == 0) {
        i1 = 8;
      }
    }
    if (this.C.getVisibility() != i1) {
      this.C.setVisibility(i1);
    }
  }
  
  private void b(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    this.L.clear();
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.personalityLabelInfos != null) && (paramProfilePersonalityLabelInfo.personalityLabelInfos.size() > 0))
    {
      paramProfilePersonalityLabelInfo = paramProfilePersonalityLabelInfo.personalityLabelInfos.iterator();
      while (paramProfilePersonalityLabelInfo.hasNext())
      {
        PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramProfilePersonalityLabelInfo.next();
        this.L.put(Long.valueOf(localPersonalityLabelInfo.id), localPersonalityLabelInfo);
      }
    }
  }
  
  private void f()
  {
    if (!this.y)
    {
      TextView localTextView = (TextView)this.A.findViewById(2131448814);
      int i1 = (int)(getResources().getDisplayMetrics().widthPixels - (this.v * 57.0F + 0.5F));
      if (this.k == null) {
        this.k = new TextPaint();
      }
      this.k.setTextSize(this.v * 28.0F);
      int i2 = (int)(this.k.measureText("的标签") + 0.5F);
      String str = this.x;
      if (str == null)
      {
        localTextView.setText("ta的标签");
        return;
      }
      str = TextUtils.ellipsize(str, this.k, i1 - i2, TextUtils.TruncateAt.END).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("的标签");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("personality_label");
    localStringBuilder.append(this.w);
    getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("tips_displayed", true).commit();
  }
  
  private void h()
  {
    Object localObject = this.K;
    if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).personalityLabelInfos != null))
    {
      localObject = (IExpandManager)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject != null)
      {
        boolean bool;
        if (this.K.personalityLabelInfos.size() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setHasPersonalLabelSP： ");
          localStringBuilder.append(bool);
          QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
        }
        ((IExpandManager)localObject).d(bool);
      }
    }
  }
  
  private void i()
  {
    a("正在处理...", this.u);
    ThreadManager.postImmediately(new PersonalityLabelGalleryActivity.4(this), null, true);
  }
  
  private void j()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.a.dismiss();
    }
  }
  
  private void k()
  {
    ((PersonalityLabelHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.w, 1);
  }
  
  void a()
  {
    setLeftViewName(2131887440);
    if (!this.y) {
      this.rightViewText.setVisibility(8);
    }
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
  }
  
  void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.I == null) {
      this.I = ((TextView)findViewById(2131437622));
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.I.getText()))) {
      this.I.setText(paramString);
    }
    if (paramInt != this.I.getVisibility()) {
      this.I.setVisibility(paramInt);
    }
    if (paramBoolean)
    {
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    else if (isTitleProgressShowing()) {
      stopTitleProgress();
    }
  }
  
  public void a(long paramLong, PLUploadManager.UploadItem paramUploadItem)
  {
    PersonalityLabelPhoto localPersonalityLabelPhoto = paramUploadItem.c;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("personality_label onUpdateState:");
      ((StringBuilder)localObject1).append(localPersonalityLabelPhoto.uniseq);
      ((StringBuilder)localObject1).append(" state:");
      ((StringBuilder)localObject1).append(paramUploadItem.e);
      ((StringBuilder)localObject1).append(" progress:");
      ((StringBuilder)localObject1).append(paramUploadItem.f);
      QLog.i("PersonalityLabelGalleryActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramUploadItem.e == 4) {
      a(paramLong, true);
    }
    int i1 = 0;
    while (i1 < this.z.getChildCount())
    {
      localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.z.getChildAt(i1).getTag();
      if ((localObject1 != null) && (((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).a == paramLong)) {
        break label167;
      }
      i1 += 1;
    }
    Object localObject1 = null;
    label167:
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find holder");
    }
    i1 = 0;
    while (i1 < ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).i.getChildCount())
    {
      Object localObject2 = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).i.getChildAt(i1);
      PersonalityLabelGalleryActivity.RecyclerViewHolder localRecyclerViewHolder = (PersonalityLabelGalleryActivity.RecyclerViewHolder)((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).i.getChildViewHolder((View)localObject2);
      if (localRecyclerViewHolder == null) {
        localObject2 = null;
      } else {
        localObject2 = localRecyclerViewHolder.a.getTag(2131440148);
      }
      if ((localObject2 != null) && ((localObject2 instanceof PLUploadManager.UploadItem)) && (((PLUploadManager.UploadItem)localObject2).c.uniseq == localPersonalityLabelPhoto.uniseq))
      {
        localObject1 = localRecyclerViewHolder;
        break label308;
      }
      i1 += 1;
    }
    localObject1 = null;
    label308:
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find childHolder");
    }
    a(paramUploadItem, localPersonalityLabelPhoto, (PersonalityLabelGalleryActivity.RecyclerViewHolder)localObject1);
    if (paramUploadItem.e == 4)
    {
      this.R = true;
      ((PersonalityLabelGalleryActivity.RecyclerViewHolder)localObject1).a.setTag(2131440148, null);
      if (this.g.hasMessages(0)) {
        this.g.removeMessages(0);
      }
      paramUploadItem = this.g.obtainMessage(0, this.K);
      this.g.sendMessageDelayed(paramUploadItem, 200L);
      return;
    }
    if (paramUploadItem.e == 3) {
      QQToast.makeText(this, 0, "上传图片失败", 0).show();
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (this.T.get(Long.valueOf(paramLong)) != null)
    {
      Object localObject = this.U.get(Long.valueOf(paramLong));
      int i1 = 1;
      boolean bool;
      if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateCookieIndex labelId:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" add:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" completed:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("PersonalityLabelGalleryActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (byte[])this.T.get(Long.valueOf(paramLong));
      if (!bool)
      {
        if (localObject.length <= 0) {
          return;
        }
        int i2 = a((byte[])localObject);
        if (!paramBoolean) {
          i1 = -1;
        }
        i2 += i1;
        i1 = i2;
        if (i2 < 0) {
          i1 = 0;
        }
        localObject = a(i1);
        this.T.put(Long.valueOf(paramLong), localObject);
      }
    }
  }
  
  void a(View paramView, long paramLong)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramView.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new PersonalityLabelGalleryActivity.9(this, localValueAnimator, paramView));
    localValueAnimator.addListener(new PersonalityLabelGalleryActivity.10(this, paramLong));
    localValueAnimator.start();
  }
  
  void a(PLUploadManager.UploadItem paramUploadItem, PersonalityLabelPhoto paramPersonalityLabelPhoto, PersonalityLabelGalleryActivity.RecyclerViewHolder paramRecyclerViewHolder)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("personality_label bindProgressState id:");
      ((StringBuilder)localObject).append(paramPersonalityLabelPhoto.fileId);
      ((StringBuilder)localObject).append(" key:");
      ((StringBuilder)localObject).append(paramPersonalityLabelPhoto.uniseq);
      ((StringBuilder)localObject).append(" item:");
      ((StringBuilder)localObject).append(paramUploadItem);
      QLog.i("PersonalityLabelGalleryActivity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = paramPersonalityLabelPhoto.local;
    int i3 = 8;
    if (!bool)
    {
      if (paramRecyclerViewHolder.d != null)
      {
        paramRecyclerViewHolder.a.removeView(paramRecyclerViewHolder.d);
        paramRecyclerViewHolder.d = null;
      }
      if (paramRecyclerViewHolder.c.getVisibility() != 8) {
        paramRecyclerViewHolder.c.setVisibility(8);
      }
      return;
    }
    paramPersonalityLabelPhoto = Long.toString(paramPersonalityLabelPhoto.uniseq);
    if (paramUploadItem == null)
    {
      if (paramRecyclerViewHolder.d != null)
      {
        paramRecyclerViewHolder.d.a(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.d.b(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.a.removeView(paramRecyclerViewHolder.d);
        paramRecyclerViewHolder.d = null;
      }
      if (paramRecyclerViewHolder.c.getVisibility() != 8) {
        paramRecyclerViewHolder.c.setVisibility(8);
      }
    }
    else
    {
      int i1 = paramUploadItem.e;
      int i2 = 1;
      if ((i1 != 0) && (i1 != 1) && (i1 != 2))
      {
        if ((i1 != 3) && (i1 != 4)) {
          return;
        }
        if (paramRecyclerViewHolder.d != null)
        {
          paramRecyclerViewHolder.d.a(paramPersonalityLabelPhoto);
          if ((paramUploadItem.e != 3) && (paramRecyclerViewHolder.d.c(paramPersonalityLabelPhoto)))
          {
            if (paramUploadItem.e == 4)
            {
              paramRecyclerViewHolder.d.setDrawStatus(1);
              paramRecyclerViewHolder.d.setAnimProgress(100, paramPersonalityLabelPhoto);
            }
          }
          else
          {
            paramRecyclerViewHolder.d.b(paramPersonalityLabelPhoto);
            paramRecyclerViewHolder.a.removeView(paramRecyclerViewHolder.d);
            paramRecyclerViewHolder.d = null;
          }
        }
        if (paramUploadItem.e == 3) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (paramRecyclerViewHolder.c.getVisibility() != 0) {
          i2 = 0;
        }
        if (i1 != i2)
        {
          paramUploadItem = paramRecyclerViewHolder.c;
          i2 = i3;
          if (i1 != 0) {
            i2 = 0;
          }
          paramUploadItem.setVisibility(i2);
        }
      }
      else
      {
        if (paramRecyclerViewHolder.d == null)
        {
          localObject = new MessageProgressView(this);
          ((MessageProgressView)localObject).setRadius(this.v * 2.0F, false);
          ((MessageProgressView)localObject).setCustomSize(1);
          ((MessageProgressView)localObject).setShowCorner(false);
          ((MessageProgressView)localObject).setProgressBackgroudColor(2130706432);
          float f1 = this.v;
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(f1 * 120.0F), (int)(f1 * 120.0F));
          paramRecyclerViewHolder.a.addView((View)localObject, localLayoutParams);
          paramRecyclerViewHolder.d = ((MessageProgressView)localObject);
        }
        paramRecyclerViewHolder.d.a(paramPersonalityLabelPhoto);
        if (paramUploadItem.e != 2)
        {
          paramRecyclerViewHolder.d.setDrawStatus(1);
          paramRecyclerViewHolder.d.setAnimProgress(0, paramPersonalityLabelPhoto);
        }
        else
        {
          paramRecyclerViewHolder.d.setDrawStatus(1);
          paramRecyclerViewHolder.d.setAnimProgress(paramUploadItem.f, paramPersonalityLabelPhoto);
        }
        if (paramRecyclerViewHolder.c.getVisibility() != 8) {
          paramRecyclerViewHolder.c.setVisibility(8);
        }
      }
    }
  }
  
  void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(List<PersonalityLabelPhoto> paramList, long paramLong)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)this.L.get(Long.valueOf(paramLong));
    if (localPersonalityLabelInfo == null) {
      return;
    }
    localPersonalityLabelInfo.personalityLabelPhotos.addAll(0, paramList);
    localPersonalityLabelInfo.photoCount += paramList.size();
    a(paramLong, localPersonalityLabelInfo);
    if (this.g.hasMessages(0)) {
      this.g.removeMessages(0);
    }
    paramList = this.g.obtainMessage(0, this.K);
    this.g.sendMessageDelayed(paramList, 200L);
  }
  
  boolean a(int paramInt, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    return (this.y) && (!this.i) && (this.l) && (paramInt == 0);
  }
  
  void b()
  {
    int i1;
    if (this.y)
    {
      boolean bool = this.i;
      i1 = 0;
      if (!bool)
      {
        setRightButton(2131888824, this);
        this.leftView.setVisibility(0);
      }
      else
      {
        setRightButton(2131889474, this);
        this.leftView.setVisibility(8);
      }
      localTextView = this.rightViewText;
      if (!c()) {
        i1 = 8;
      }
      localTextView.setVisibility(i1);
    }
    if (this.i)
    {
      this.B.setText(2131897144);
      return;
    }
    TextView localTextView = this.B;
    if (this.y) {
      i1 = 2131897143;
    } else {
      i1 = 2131897145;
    }
    localTextView.setText(i1);
  }
  
  boolean c()
  {
    ProfilePersonalityLabelInfo localProfilePersonalityLabelInfo = this.K;
    return (localProfilePersonalityLabelInfo != null) && (localProfilePersonalityLabelInfo.getSize() > 0);
  }
  
  void d()
  {
    this.z.setSelection(0);
    int i4 = (int)(this.v * 87.0F);
    int i1 = this.z.getChildCount() - 1;
    int i3;
    for (int i2 = 0; i1 >= 0; i2 = i3)
    {
      Object localObject1 = this.z.getChildAt(i1).getTag();
      i3 = i2;
      if (localObject1 != null)
      {
        i3 = i2;
        if ((localObject1 instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder))
        {
          localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1;
          View localView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).l;
          Object localObject2 = localView.getTag();
          boolean bool;
          if (localObject2 == null) {
            bool = false;
          } else {
            bool = ((Boolean)localObject2).booleanValue();
          }
          if (!bool)
          {
            i3 = i2;
          }
          else
          {
            localObject2 = ValueAnimator.ofInt(new int[] { 0, i4 });
            ((ValueAnimator)localObject2).setInterpolator(new DecelerateInterpolator(1.0F));
            ((ValueAnimator)localObject2).addUpdateListener(new PersonalityLabelGalleryActivity.7(this, (ValueAnimator)localObject2, localView));
            ((ValueAnimator)localObject2).addListener(new PersonalityLabelGalleryActivity.8(this, (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1, localView));
            ((ValueAnimator)localObject2).setDuration(200L);
            ((ValueAnimator)localObject2).setStartDelay(i2);
            ((ValueAnimator)localObject2).start();
            this.b.remove(Long.valueOf(((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).a));
            i3 = i2 + 150;
          }
        }
      }
      i1 -= 1;
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pick photo from qzone size:");
          localStringBuilder.append(paramIntent.size());
          QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
        }
        if (this.M > 0L)
        {
          this.N.clear();
          this.N.addAll(paramIntent);
          this.O = 0;
          if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
          {
            this.n = false;
            i();
            return;
          }
          QQToast.makeText(getApplicationContext(), 0, 2131892102, 0).show();
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627627);
    a(getIntent());
    this.y = this.app.getCurrentAccountUin().equals(this.w);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.card.modify_personality_label");
    paramBundle.setPriority(2147483647);
    registerReceiver(this.s, paramBundle);
    this.v = getResources().getDisplayMetrics().density;
    this.z = ((XListView)findViewById(2131437317));
    this.A = getLayoutInflater().inflate(2131627628, this.z, false);
    this.z.addHeaderView(this.A);
    this.E = ((ViewStub)findViewById(2131432537));
    this.J = new PersonalityLabelGalleryActivity.ListViewAdapter(this, null);
    this.z.setAdapter(this.J);
    this.F = findViewById(2131429638);
    this.H = ((Button)findViewById(2131445770));
    this.G = ((Button)findViewById(2131427809));
    this.H.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.app.addObserver(this.t);
    addObserver(this.V);
    f();
    this.B = ((TextView)this.A.findViewById(2131448375));
    this.C = ((TextView)this.A.findViewById(2131448847));
    if (this.y)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("personality_label");
      paramBundle.append(this.w);
      this.l = (getSharedPreferences(paramBundle.toString(), 0).getBoolean("tips_displayed", false) ^ true);
    }
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.p = new TopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.p);
    }
    this.q = ((PLUploadManager)this.app.getManager(QQManagerFactory.PERSONALITY_LABELS_UPLOAD_MGR));
    if (this.y) {
      this.q.a(this);
    }
    a(0, "正在加载...", true);
    this.g.sendEmptyMessage(1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MessageProgressController.a().b();
    this.q.a(null);
    this.g.removeCallbacksAndMessages(null);
    this.h.removeCallbacksAndMessages(null);
    removeObserver(this.V);
    unregisterReceiver(this.s);
    removeObserver(this.t);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("select photos from phone album : size = ");
        localStringBuilder.append(localArrayList.size());
        QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
      }
      this.M = paramIntent.getLongExtra("label_id", 0L);
      if (this.M > 0L)
      {
        this.N.clear();
        this.N.addAll(localArrayList);
        this.O = 0;
        if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
        {
          this.n = false;
          i();
          return;
        }
        QQToast.makeText(getApplicationContext(), 0, 2131892102, 0).show();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    h();
    if (this.m)
    {
      this.l = false;
      g();
      if (this.h.hasMessages(2)) {
        this.h.removeMessages(2);
      }
      this.h.sendEmptyMessage(2);
    }
  }
  
  void e()
  {
    int i1 = 0;
    while (i1 < this.z.getChildCount())
    {
      View localView = this.z.getChildAt(i1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder)))
      {
        ImageView localImageView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject).f;
        if (localImageView == null) {
          return;
        }
        ObjectAnimator localObjectAnimator = (ObjectAnimator)localView.getTag(2131427814);
        localObject = localObjectAnimator;
        if (localObjectAnimator == null)
        {
          localObject = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 45.0F });
          ((ObjectAnimator)localObject).setDuration(100L);
          ((ObjectAnimator)localObject).addListener(new PersonalityLabelGalleryActivity.11(this, (ObjectAnimator)localObject));
          localView.setTag(2131427814, localObject);
        }
        ((ObjectAnimator)localObject).start();
      }
      i1 += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    Object localObject;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        this.J.notifyDataSetChanged();
        if (paramMessage.arg1 == 1)
        {
          this.z.setSelection(0);
          return false;
        }
      }
      else
      {
        paramMessage = null;
        if (this.P != 3)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("profile_personality_v1.2_");
          paramMessage.append(this.w);
          localObject = (ProfilePersonalityLabelInfo)FileUtils.readObject(paramMessage.toString());
          paramMessage = (Message)localObject;
          if (localObject != null)
          {
            paramMessage = (Message)localObject;
            if (((ProfilePersonalityLabelInfo)localObject).unreadCount > 0)
            {
              ((ProfilePersonalityLabelInfo)localObject).praiseCount += ((ProfilePersonalityLabelInfo)localObject).unreadCount;
              ((ProfilePersonalityLabelInfo)localObject).unreadCount = 0;
              paramMessage = (Message)localObject;
            }
          }
        }
        if ((paramMessage != null) && (paramMessage.getSize() > 0))
        {
          i1 = 0;
          while (i1 < paramMessage.personalityLabelInfos.size())
          {
            localObject = (PersonalityLabelInfo)paramMessage.personalityLabelInfos.get(i1);
            this.q.a(((PersonalityLabelInfo)localObject).id, (PersonalityLabelInfo)localObject, false);
            i1 += 1;
          }
        }
        runOnUiThread(new PersonalityLabelGalleryActivity.1(this, paramMessage));
        return false;
      }
    }
    else
    {
      localObject = (ProfilePersonalityLabelInfo)paramMessage.obj;
      if (this.y) {
        paramMessage = this.app.getCurrentAccountUin();
      } else {
        paramMessage = this.w;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("profile_personality_v1.2_");
      localStringBuilder.append(paramMessage);
      FileUtils.writeObject(localStringBuilder.toString(), localObject);
    }
    return false;
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.i)
    {
      a(true);
      return true;
    }
    Object localObject;
    Bundle localBundle;
    if (this.R) {
      if (this.P == 3)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.card.modify_personality_label");
        localBundle = new Bundle();
        localBundle.putBoolean("onTagChanged", true);
        ((Intent)localObject).putExtra("key_bundle_data", localBundle);
        sendBroadcast((Intent)localObject);
      }
      else
      {
        setResult(-1);
      }
    }
    if (this.P == 4)
    {
      localObject = this.w;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new AllInOne(this.w, 0);
        localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (AllInOne)localObject, localBundle);
        overridePendingTransition(2130772005, 2130772006);
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.H)
    {
      localObject = this.K;
      if (localObject != null)
      {
        if (localObject == null) {
          break label241;
        }
        localObject = new Intent(this, PersonalityLabelShareActivity.class);
        ((Intent)localObject).putExtra("data", this.K);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "dc00898", "", "", "0X8007FD4", "0X8007FD4", 0, 0, "0", "0", "", "");
        break label241;
      }
    }
    if ((paramView != this.G) && (2131432494 != paramView.getId()))
    {
      if (paramView == this.rightViewText) {
        a(true);
      }
    }
    else
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007FD3", "0X8007FD3", 0, 0, "0", "0", "", "");
      localObject = this.K;
      if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).remainCount <= 0))
      {
        if (this.f == null) {
          this.f = QQToast.makeText(this, "最多只能添加10个标签。", 0);
        }
        if (!this.f.isShowing()) {
          this.f.show(getTitleBarHeight());
        }
      }
      else
      {
        ProfileCardUtil.a(this.app.getCurrentAccountUin(), this.app, this, false);
      }
    }
    label241:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity
 * JD-Core Version:    0.7.0.1
 */