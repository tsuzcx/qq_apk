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
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new PersonalityLabelGalleryActivity.5(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected TopGestureLayout a;
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PersonalityLabelGalleryActivity.12(this);
  PLUploadManager jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager;
  private PersonalityLabelGalleryActivity.ListViewAdapter jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter;
  private PersonalityLabelObserver jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver = new PersonalityLabelGalleryActivity.6(this);
  private ProfilePersonalityLabelInfo jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
  private AllInOne jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
  QQProgressDialog.Callback jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback = new PersonalityLabelGalleryActivity.13(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<Long, PersonalityLabelInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap<Long, byte[]> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ConcurrentHashMap<Long, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  volatile boolean e = true;
  private boolean f;
  private boolean g = false;
  private boolean h = false;
  
  public static int a(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).getInt();
  }
  
  private void a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = 8;
      }
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != i) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(i);
    }
  }
  
  private void a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
    {
      PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localLabelItemViewHolder != null) && (localLabelItemViewHolder.jdField_a_of_type_Long == paramLong))
      {
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getAdapter().notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  private void a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
    {
      PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localLabelItemViewHolder != null) && (localLabelItemViewHolder.jdField_a_of_type_Long == paramLong))
      {
        i = paramPersonalityLabelInfo.getSize();
        int j = 1;
        if (i > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getVisibility() != 0) {
          j = 0;
        }
        if (j != i)
        {
          localGlowCountRecyclerView = localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView;
          if (i != 0) {
            i = 0;
          } else {
            i = 8;
          }
          localGlowCountRecyclerView.setVisibility(i);
        }
        GlowCountRecyclerView localGlowCountRecyclerView = localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramPersonalityLabelInfo.photoCount);
        localStringBuilder.append("张");
        localGlowCountRecyclerView.setText(localStringBuilder.toString());
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getAdapter().notifyDataSetChanged();
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.smoothScrollToPosition(0);
        return;
      }
      i += 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("fromType", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne = ((AllInOne)paramIntent.getParcelableExtra("personality_label_allinone"));
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QQToast.a(this, "打开标签失败，请重试", 0);
        finish();
        return;
      }
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))
      {
        this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_c_of_type_Int == 3) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.getSize() > 0)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    try
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
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
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
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
    localView1 = this.jdField_b_of_type_AndroidViewView;
    if (localView1 == null) {
      return;
    }
    localView1 = localView1.findViewById(2131366238);
    localTextView1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366235);
    localTextView2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366242);
    localView2 = this.jdField_b_of_type_AndroidViewView.findViewById(2131366206);
    if (this.f)
    {
      localTextView1.setText(2131699131);
      localTextView2.setText(getString(2131699127));
      localView2.setOnClickListener(this);
      return;
    }
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.isCloseByUser == 1))
    {
      localTextView1.setText(2131699126);
      localView2.setVisibility(8);
      localTextView2.setVisibility(8);
      if (localView1.getPaddingBottom() <= 0) {
        localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), localView1.getPaddingBottom() + AIOUtils.b(73.0F, getResources()));
      }
    }
    else
    {
      localTextView1.setText(2131699131);
      localView2.setVisibility(8);
      localTextView2.setText(getString(2131699130));
      if (localView1.getPaddingBottom() <= 0) {
        localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), localView1.getPaddingBottom() + AIOUtils.b(73.0F, getResources()));
      }
    }
  }
  
  private void a(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(String paramString, QQProgressDialog.Callback paramCallback)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramCallback);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        a(getResources().getString(2131694422));
        return;
      }
      if (isTitleProgressShowing())
      {
        a("请等待数据加载完毕");
        return;
      }
    }
    this.jdField_b_of_type_Boolean ^= true;
    b();
    View localView = this.jdField_c_of_type_AndroidViewView;
    int i;
    if ((this.f) && (!this.jdField_b_of_type_Boolean) && (a())) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
    if ((this.jdField_b_of_type_Boolean) && (this.d))
    {
      this.jdField_c_of_type_Boolean = false;
      f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.unreadCount > 0) {
      a(0);
    }
    d();
  }
  
  public static byte[] a(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt(paramInt);
    return localByteBuffer.array();
  }
  
  private void b(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.personalityLabelInfos != null) && (paramProfilePersonalityLabelInfo.personalityLabelInfos.size() > 0))
    {
      paramProfilePersonalityLabelInfo = paramProfilePersonalityLabelInfo.personalityLabelInfos.iterator();
      while (paramProfilePersonalityLabelInfo.hasNext())
      {
        PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramProfilePersonalityLabelInfo.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localPersonalityLabelInfo.id), localPersonalityLabelInfo);
      }
    }
  }
  
  private void e()
  {
    if (!this.f)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379930);
      int i = (int)(getResources().getDisplayMetrics().widthPixels - (this.jdField_a_of_type_Float * 57.0F + 0.5F));
      if (this.jdField_a_of_type_AndroidTextTextPaint == null) {
        this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float * 28.0F);
      int j = (int)(this.jdField_a_of_type_AndroidTextTextPaint.measureText("的标签") + 0.5F);
      String str = this.jdField_b_of_type_JavaLangString;
      if (str == null)
      {
        localTextView.setText("ta的标签");
        return;
      }
      str = TextUtils.ellipsize(str, this.jdField_a_of_type_AndroidTextTextPaint, i - j, TextUtils.TruncateAt.END).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("的标签");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("personality_label");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("tips_displayed", true).commit();
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
    if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).personalityLabelInfos != null))
    {
      localObject = (IExpandManager)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject != null)
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.personalityLabelInfos.size() > 0) {
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
        ((IExpandManager)localObject).c(bool);
      }
    }
  }
  
  private void h()
  {
    a("正在处理...", this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback);
    ThreadManager.postImmediately(new PersonalityLabelGalleryActivity.4(this), null, true);
  }
  
  private void i()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void j()
  {
    ((PersonalityLabelHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.jdField_a_of_type_JavaLangString, 1);
  }
  
  void a()
  {
    setLeftViewName(2131690529);
    if (!this.f) {
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
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370360));
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_c_of_type_AndroidWidgetTextView.getText()))) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramInt != this.jdField_c_of_type_AndroidWidgetTextView.getVisibility()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
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
    PersonalityLabelPhoto localPersonalityLabelPhoto = paramUploadItem.a;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("personality_label onUpdateState:");
      ((StringBuilder)localObject1).append(localPersonalityLabelPhoto.uniseq);
      ((StringBuilder)localObject1).append(" state:");
      ((StringBuilder)localObject1).append(paramUploadItem.jdField_b_of_type_Int);
      ((StringBuilder)localObject1).append(" progress:");
      ((StringBuilder)localObject1).append(paramUploadItem.jdField_c_of_type_Int);
      QLog.i("PersonalityLabelGalleryActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramUploadItem.jdField_b_of_type_Int == 4) {
      a(paramLong, true);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
    {
      localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject1 != null) && (((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_Long == paramLong)) {
        break label167;
      }
      i += 1;
    }
    Object localObject1 = null;
    label167:
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find holder");
    }
    i = 0;
    while (i < ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildCount())
    {
      Object localObject2 = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildAt(i);
      PersonalityLabelGalleryActivity.RecyclerViewHolder localRecyclerViewHolder = (PersonalityLabelGalleryActivity.RecyclerViewHolder)((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildViewHolder((View)localObject2);
      if (localRecyclerViewHolder == null) {
        localObject2 = null;
      } else {
        localObject2 = localRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag(2131372608);
      }
      if ((localObject2 != null) && ((localObject2 instanceof PLUploadManager.UploadItem)) && (((PLUploadManager.UploadItem)localObject2).a.uniseq == localPersonalityLabelPhoto.uniseq))
      {
        localObject1 = localRecyclerViewHolder;
        break label308;
      }
      i += 1;
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
    if (paramUploadItem.jdField_b_of_type_Int == 4)
    {
      this.g = true;
      ((PersonalityLabelGalleryActivity.RecyclerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131372608, null);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      paramUploadItem = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramUploadItem, 200L);
      return;
    }
    if (paramUploadItem.jdField_b_of_type_Int == 3) {
      QQToast.a(this, 0, "上传图片失败", 0).a();
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null)
    {
      Object localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      int i = 1;
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
      localObject = (byte[])this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (!bool)
      {
        if (localObject.length <= 0) {
          return;
        }
        int j = a((byte[])localObject);
        if (!paramBoolean) {
          i = -1;
        }
        j += i;
        i = j;
        if (j < 0) {
          i = 0;
        }
        localObject = a(i);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
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
    int k = 8;
    if (!bool)
    {
      if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
      {
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      }
      if (paramRecyclerViewHolder.b.getVisibility() != 8) {
        paramRecyclerViewHolder.b.setVisibility(8);
      }
      return;
    }
    paramPersonalityLabelPhoto = Long.toString(paramPersonalityLabelPhoto.uniseq);
    if (paramUploadItem == null)
    {
      if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
      {
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      }
      if (paramRecyclerViewHolder.b.getVisibility() != 8) {
        paramRecyclerViewHolder.b.setVisibility(8);
      }
    }
    else
    {
      int i = paramUploadItem.jdField_b_of_type_Int;
      int j = 1;
      if ((i != 0) && (i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4)) {
          return;
        }
        if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
        {
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
          if ((paramUploadItem.jdField_b_of_type_Int != 3) && (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto)))
          {
            if (paramUploadItem.jdField_b_of_type_Int == 4)
            {
              paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
              paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramPersonalityLabelPhoto);
            }
          }
          else
          {
            paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramPersonalityLabelPhoto);
            paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
            paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
          }
        }
        if (paramUploadItem.jdField_b_of_type_Int == 3) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramRecyclerViewHolder.b.getVisibility() != 0) {
          j = 0;
        }
        if (i != j)
        {
          paramUploadItem = paramRecyclerViewHolder.b;
          j = k;
          if (i != 0) {
            j = 0;
          }
          paramUploadItem.setVisibility(j);
        }
      }
      else
      {
        if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView == null)
        {
          localObject = new MessageProgressView(this);
          ((MessageProgressView)localObject).setRadius(this.jdField_a_of_type_Float * 2.0F, false);
          ((MessageProgressView)localObject).setCustomSize(1);
          ((MessageProgressView)localObject).setShowCorner(false);
          ((MessageProgressView)localObject).setProgressBackgroudColor(2130706432);
          float f1 = this.jdField_a_of_type_Float;
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(f1 * 120.0F), (int)(f1 * 120.0F));
          paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)localObject);
        }
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
        if (paramUploadItem.jdField_b_of_type_Int != 2)
        {
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(0, paramPersonalityLabelPhoto);
        }
        else
        {
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramUploadItem.jdField_c_of_type_Int, paramPersonalityLabelPhoto);
        }
        if (paramRecyclerViewHolder.b.getVisibility() != 8) {
          paramRecyclerViewHolder.b.setVisibility(8);
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
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localPersonalityLabelInfo == null) {
      return;
    }
    localPersonalityLabelInfo.personalityLabelPhotos.addAll(0, paramList);
    localPersonalityLabelInfo.photoCount += paramList.size();
    a(paramLong, localPersonalityLabelInfo);
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramList, 200L);
  }
  
  boolean a()
  {
    ProfilePersonalityLabelInfo localProfilePersonalityLabelInfo = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
    return (localProfilePersonalityLabelInfo != null) && (localProfilePersonalityLabelInfo.getSize() > 0);
  }
  
  boolean a(int paramInt, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    return (this.f) && (!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (paramInt == 0);
  }
  
  void b()
  {
    int i;
    if (this.f)
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      i = 0;
      if (!bool)
      {
        setRightButton(2131691859, this);
        this.leftView.setVisibility(0);
      }
      else
      {
        setRightButton(2131692486, this);
        this.leftView.setVisibility(8);
      }
      localTextView = this.rightViewText;
      if (!a()) {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699128);
      return;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.f) {
      i = 2131699127;
    } else {
      i = 2131699129;
    }
    localTextView.setText(i);
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    int m = (int)(this.jdField_a_of_type_Float * 87.0F);
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      k = j;
      if (localObject1 != null)
      {
        k = j;
        if ((localObject1 instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder))
        {
          localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1;
          View localView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).d;
          Object localObject2 = localView.getTag();
          boolean bool;
          if (localObject2 == null) {
            bool = false;
          } else {
            bool = ((Boolean)localObject2).booleanValue();
          }
          if (!bool)
          {
            k = j;
          }
          else
          {
            localObject2 = ValueAnimator.ofInt(new int[] { 0, m });
            ((ValueAnimator)localObject2).setInterpolator(new DecelerateInterpolator(1.0F));
            ((ValueAnimator)localObject2).addUpdateListener(new PersonalityLabelGalleryActivity.7(this, (ValueAnimator)localObject2, localView));
            ((ValueAnimator)localObject2).addListener(new PersonalityLabelGalleryActivity.8(this, (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1, localView));
            ((ValueAnimator)localObject2).setDuration(200L);
            ((ValueAnimator)localObject2).setStartDelay(j);
            ((ValueAnimator)localObject2).start();
            this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_Long));
            k = j + 150;
          }
        }
      }
      i -= 1;
    }
  }
  
  void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder)))
      {
        ImageView localImageView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject).b;
        if (localImageView == null) {
          return;
        }
        ObjectAnimator localObjectAnimator = (ObjectAnimator)localView.getTag(2131362233);
        localObject = localObjectAnimator;
        if (localObjectAnimator == null)
        {
          localObject = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 45.0F });
          ((ObjectAnimator)localObject).setDuration(100L);
          ((ObjectAnimator)localObject).addListener(new PersonalityLabelGalleryActivity.11(this, (ObjectAnimator)localObject));
          localView.setTag(2131362233, localObject);
        }
        ((ObjectAnimator)localObject).start();
      }
      i += 1;
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
        if (this.jdField_a_of_type_Long > 0L)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramIntent);
          this.jdField_b_of_type_Int = 0;
          if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
          {
            this.e = false;
            h();
            return;
          }
          QQToast.a(getApplicationContext(), 0, 2131694422, 0).a();
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
    setContentView(2131561271);
    a(getIntent());
    this.f = this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.card.modify_personality_label");
    paramBundle.setPriority(2147483647);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370153));
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131561272, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131366245));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter = new PersonalityLabelGalleryActivity.ListViewAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131363715);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131377375));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362228));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver);
    e();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379611));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379959));
    if (this.f)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("personality_label");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = (getSharedPreferences(paramBundle.toString(), 0).getBoolean("tips_displayed", false) ^ true);
    }
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager = ((PLUploadManager)this.app.getManager(QQManagerFactory.PERSONALITY_LABELS_UPLOAD_MGR));
    if (this.f) {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(this);
    }
    a(0, "正在加载...", true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MessageProgressController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("label_id", 0L);
      if (this.jdField_a_of_type_Long > 0L)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        this.jdField_b_of_type_Int = 0;
        if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
        {
          this.e = false;
          h();
          return;
        }
        QQToast.a(getApplicationContext(), 0, 2131694422, 0).a();
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
    g();
    if (this.d)
    {
      this.jdField_c_of_type_Boolean = false;
      f();
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.notifyDataSetChanged();
        if (paramMessage.arg1 == 1)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
          return false;
        }
      }
      else
      {
        paramMessage = null;
        if (this.jdField_c_of_type_Int != 3)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("profile_personality_v1.2_");
          paramMessage.append(this.jdField_a_of_type_JavaLangString);
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
          i = 0;
          while (i < paramMessage.personalityLabelInfos.size())
          {
            localObject = (PersonalityLabelInfo)paramMessage.personalityLabelInfos.get(i);
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(((PersonalityLabelInfo)localObject).id, (PersonalityLabelInfo)localObject, false);
            i += 1;
          }
        }
        runOnUiThread(new PersonalityLabelGalleryActivity.1(this, paramMessage));
        return false;
      }
    }
    else
    {
      localObject = (ProfilePersonalityLabelInfo)paramMessage.obj;
      if (this.f) {
        paramMessage = this.app.getCurrentAccountUin();
      } else {
        paramMessage = this.jdField_a_of_type_JavaLangString;
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
    if (this.jdField_b_of_type_Boolean)
    {
      a(true);
      return true;
    }
    Object localObject;
    Bundle localBundle;
    if (this.g) {
      if (this.jdField_c_of_type_Int == 3)
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
    if (this.jdField_c_of_type_Int == 4)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new AllInOne(this.jdField_a_of_type_JavaLangString, 0);
        localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (AllInOne)localObject, localBundle);
        overridePendingTransition(2130772002, 2130772003);
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
      if (localObject != null)
      {
        if (localObject == null) {
          break label241;
        }
        localObject = new Intent(this, PersonalityLabelShareActivity.class);
        ((Intent)localObject).putExtra("data", this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "dc00898", "", "", "0X8007FD4", "0X8007FD4", 0, 0, "0", "0", "", "");
        break label241;
      }
    }
    if ((paramView != this.jdField_a_of_type_AndroidWidgetButton) && (2131366206 != paramView.getId()))
    {
      if (paramView == this.rightViewText) {
        a(true);
      }
    }
    else
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007FD3", "0X8007FD3", 0, 0, "0", "0", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
      if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).remainCount <= 0))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast == null) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(this, "最多只能添加10个标签。", 0);
        }
        if (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast.d()) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast.b(getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity
 * JD-Core Version:    0.7.0.1
 */