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
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
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
  protected AccountDetailTopGestureLayout a;
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PersonalityLabelGalleryActivity.12(this);
  PLUploadManager jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager;
  private PersonalityLabelGalleryActivity.ListViewAdapter jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter;
  private PersonalityLabelObserver jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver = new PersonalityLabelGalleryActivity.6(this);
  private ProfilePersonalityLabelInfo jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
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
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
      {
        PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localLabelItemViewHolder != null) && (localLabelItemViewHolder.jdField_a_of_type_Long == paramLong)) {
          localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getAdapter().notifyDataSetChanged();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    int j = 1;
    int i = 0;
    for (;;)
    {
      PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder;
      label71:
      GlowCountRecyclerView localGlowCountRecyclerView;
      if (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
      {
        localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localLabelItemViewHolder == null) || (localLabelItemViewHolder.jdField_a_of_type_Long != paramLong)) {
          break label170;
        }
        if (paramPersonalityLabelInfo.getSize() <= 0) {
          break label151;
        }
        i = 1;
        if (localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getVisibility() != 0) {
          break label157;
        }
        if (j != i)
        {
          localGlowCountRecyclerView = localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView;
          if (i == 0) {
            break label163;
          }
        }
      }
      label151:
      label157:
      label163:
      for (i = 0;; i = 8)
      {
        localGlowCountRecyclerView.setVisibility(i);
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setText(paramPersonalityLabelInfo.photoCount + "张");
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getAdapter().notifyDataSetChanged();
        localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.smoothScrollToPosition(0);
        return;
        i = 0;
        break;
        j = 0;
        break label71;
      }
      label170:
      i += 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("fromType", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramIntent.getParcelableExtra("personality_label_allinone"));
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label78;
      }
      QQToast.a(this, "打开标签失败，请重试", 0);
      finish();
    }
    label78:
    do
    {
      return;
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))
      {
        this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.jdField_a_of_type_JavaLangString);
        }
      }
    } while (this.jdField_c_of_type_Int != 3);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.getSize() > 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_b_of_type_AndroidViewView == null) {}
        try
        {
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          if (this.jdField_b_of_type_AndroidViewView != null)
          {
            View localView1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131366350);
            localTextView1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366347);
            localTextView2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366356);
            localView2 = this.jdField_b_of_type_AndroidViewView.findViewById(2131366318);
            if (this.f)
            {
              localTextView1.setText(2131699027);
              localTextView2.setText(getString(2131699023));
              localView2.setOnClickListener(this);
              return;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          TextView localTextView1;
          TextView localTextView2;
          View localView2;
          for (;;)
          {
            System.gc();
            if (QLog.isColorLevel()) {
              QLog.i("PersonalityLabelGalleryActivity", 2, "setEmptyText inflate empty view outOfMemoryError");
            }
            try
            {
              this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
            }
            catch (OutOfMemoryError localOutOfMemoryError2) {}
          }
          if ((paramProfilePersonalityLabelInfo != null) && (paramProfilePersonalityLabelInfo.isCloseByUser == 1))
          {
            localTextView1.setText(2131699022);
            localView2.setVisibility(8);
            localTextView2.setVisibility(8);
            if (localOutOfMemoryError2.getPaddingBottom() <= 0) {
              localOutOfMemoryError2.setPadding(localOutOfMemoryError2.getPaddingLeft(), localOutOfMemoryError2.getPaddingTop(), localOutOfMemoryError2.getPaddingRight(), localOutOfMemoryError2.getPaddingBottom() + AIOUtils.a(73.0F, getResources()));
            }
          }
          else
          {
            localTextView1.setText(2131699027);
            localView2.setVisibility(8);
            localTextView2.setText(getString(2131699026));
          }
        }
      }
    } while (localOutOfMemoryError2.getPaddingBottom() > 0);
    localOutOfMemoryError2.setPadding(localOutOfMemoryError2.getPaddingLeft(), localOutOfMemoryError2.getPaddingTop(), localOutOfMemoryError2.getPaddingRight(), localOutOfMemoryError2.getPaddingBottom() + AIOUtils.a(73.0F, getResources()));
  }
  
  private void a(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(String paramString, QQProgressDialog.Callback paramCallback)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramCallback);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!NetworkUtil.d(this))
      {
        a(getResources().getString(2131694457));
        return;
      }
      if (isTitleProgressShowing())
      {
        a("请等待数据加载完毕");
        return;
      }
    }
    View localView;
    if (!this.jdField_b_of_type_Boolean)
    {
      paramBoolean = true;
      this.jdField_b_of_type_Boolean = paramBoolean;
      b();
      localView = this.jdField_c_of_type_AndroidViewView;
      if ((!this.f) || (this.jdField_b_of_type_Boolean) || (!a())) {
        break label171;
      }
    }
    label171:
    for (int i = 0;; i = 8)
    {
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
      return;
      paramBoolean = false;
      break;
    }
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
    TextView localTextView;
    int i;
    int j;
    if (!this.f)
    {
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380651);
      i = (int)(getResources().getDisplayMetrics().widthPixels - (this.jdField_a_of_type_Float * 57.0F + 0.5F));
      if (this.jdField_a_of_type_AndroidTextTextPaint == null) {
        this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float * 28.0F);
      j = (int)(this.jdField_a_of_type_AndroidTextTextPaint.measureText("的标签") + 0.5F);
      str = this.jdField_b_of_type_JavaLangString;
      if (str == null) {
        localTextView.setText("ta的标签");
      }
    }
    else
    {
      return;
    }
    String str = TextUtils.ellipsize(str, this.jdField_a_of_type_AndroidTextTextPaint, i - j, TextUtils.TruncateAt.END).toString();
    localTextView.setText(str + "的标签");
  }
  
  private void f()
  {
    getSharedPreferences("personality_label" + this.jdField_a_of_type_JavaLangString, 0).edit().putBoolean("tips_displayed", true).commit();
  }
  
  private void g()
  {
    ExtendFriendManager localExtendFriendManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.personalityLabelInfos != null))
    {
      localExtendFriendManager = (ExtendFriendManager)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localExtendFriendManager != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.personalityLabelInfos.size() <= 0) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "setHasPersonalLabelSP： " + bool);
      }
      localExtendFriendManager.d(bool);
      return;
    }
  }
  
  private void h()
  {
    a("正在处理...", this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback);
    ThreadManager.postImmediately(new PersonalityLabelGalleryActivity.4(this), null, true);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void j()
  {
    ((PersonalityLabelHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.jdField_a_of_type_JavaLangString, 1);
  }
  
  void a()
  {
    setLeftViewName(2131690601);
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
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370723));
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_c_of_type_AndroidWidgetTextView.getText()))) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramInt != this.jdField_c_of_type_AndroidWidgetTextView.getVisibility()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
    if (paramBoolean) {
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    while (!isTitleProgressShowing()) {
      return;
    }
    stopTitleProgress();
  }
  
  public void a(long paramLong, PLUploadManager.UploadItem paramUploadItem)
  {
    PersonalityLabelPhoto localPersonalityLabelPhoto = paramUploadItem.a;
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState:" + localPersonalityLabelPhoto.uniseq + " state:" + paramUploadItem.jdField_b_of_type_Int + " progress:" + paramUploadItem.jdField_c_of_type_Int);
    }
    if (paramUploadItem.jdField_b_of_type_Int == 4) {
      a(paramLong, true);
    }
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
    {
      localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject1 == null) || (((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_Long != paramLong)) {}
    }
    for (;;)
    {
      if (localObject1 == null) {}
      label400:
      for (;;)
      {
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find holder");
        }
        i = 0;
        label164:
        Object localObject2;
        PersonalityLabelGalleryActivity.RecyclerViewHolder localRecyclerViewHolder;
        if (i < ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildCount())
        {
          localObject2 = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildAt(i);
          localRecyclerViewHolder = (PersonalityLabelGalleryActivity.RecyclerViewHolder)((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.getChildViewHolder((View)localObject2);
          if (localRecyclerViewHolder == null)
          {
            localObject2 = null;
            label212:
            if ((localObject2 == null) || (!(localObject2 instanceof PLUploadManager.UploadItem)) || (((PLUploadManager.UploadItem)localObject2).a.uniseq != localPersonalityLabelPhoto.uniseq)) {
              break label365;
            }
          }
        }
        for (localObject1 = localRecyclerViewHolder;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label400;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find childHolder");
          }
          a(paramUploadItem, localPersonalityLabelPhoto, (PersonalityLabelGalleryActivity.RecyclerViewHolder)localObject1);
          if (paramUploadItem.jdField_b_of_type_Int == 4)
          {
            this.g = true;
            ((PersonalityLabelGalleryActivity.RecyclerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131373023, null);
            if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
            }
            paramUploadItem = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramUploadItem, 200L);
            return;
            localObject2 = localRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag(2131373023);
            break label212;
            label365:
            i += 1;
            break label164;
          }
          if (paramUploadItem.jdField_b_of_type_Int != 3) {
            break;
          }
          QQToast.a(this, 0, "上传图片失败", 0).a();
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    Object localObject;
    boolean bool;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null)
    {
      localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label199;
      }
      if (((Integer)localObject).intValue() != 1) {
        break label135;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "updateCookieIndex labelId:" + paramLong + " add:" + paramBoolean + " completed:" + bool);
      }
      localObject = (byte[])this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((bool) || (localObject.length <= 0))
      {
        return;
        label135:
        bool = false;
      }
      else
      {
        int k = a((byte[])localObject);
        if (paramBoolean)
        {
          i = k + i;
          if (i >= 0) {
            break label196;
          }
          i = j;
        }
        label196:
        for (;;)
        {
          localObject = a(i);
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
          return;
          i = -1;
          break;
        }
        label199:
        bool = false;
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
    int j = 1;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label bindProgressState id:" + paramPersonalityLabelPhoto.fileId + " key:" + paramPersonalityLabelPhoto.uniseq + " item:" + paramUploadItem);
    }
    if (!paramPersonalityLabelPhoto.local)
    {
      if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
      {
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      }
      if (paramRecyclerViewHolder.b.getVisibility() != 8) {
        paramRecyclerViewHolder.b.setVisibility(8);
      }
    }
    do
    {
      return;
      paramPersonalityLabelPhoto = Long.toString(paramPersonalityLabelPhoto.uniseq);
      if (paramUploadItem != null) {
        break;
      }
      if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
      {
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      }
    } while (paramRecyclerViewHolder.b.getVisibility() == 8);
    paramRecyclerViewHolder.b.setVisibility(8);
    return;
    switch (paramUploadItem.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
      if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView == null)
      {
        MessageProgressView localMessageProgressView = new MessageProgressView(this);
        localMessageProgressView.setRadius(this.jdField_a_of_type_Float * 2.0F, false);
        localMessageProgressView.setCustomSize(1);
        localMessageProgressView.setShowCorner(false);
        localMessageProgressView.setProgressBackgroudColor(2130706432);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 120.0F), (int)(this.jdField_a_of_type_Float * 120.0F));
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressView, localLayoutParams);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
      if (paramUploadItem.jdField_b_of_type_Int != 2)
      {
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(0, paramPersonalityLabelPhoto);
      }
      while (paramRecyclerViewHolder.b.getVisibility() != 8)
      {
        paramRecyclerViewHolder.b.setVisibility(8);
        return;
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramUploadItem.jdField_c_of_type_Int, paramPersonalityLabelPhoto);
      }
    }
    if (paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
    {
      paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto);
      if ((paramUploadItem.jdField_b_of_type_Int == 3) || (!paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramPersonalityLabelPhoto)))
      {
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramPersonalityLabelPhoto);
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView);
        paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      }
    }
    else
    {
      label458:
      if (paramUploadItem.jdField_b_of_type_Int != 3) {
        break label536;
      }
      i = 1;
      label469:
      if (paramRecyclerViewHolder.b.getVisibility() != 0) {
        break label542;
      }
      label479:
      if (i == j) {
        break label546;
      }
      paramUploadItem = paramRecyclerViewHolder.b;
      if (i == 0) {
        break label548;
      }
    }
    label536:
    label542:
    label546:
    label548:
    for (int i = k;; i = 8)
    {
      paramUploadItem.setVisibility(i);
      return;
      if (paramUploadItem.jdField_b_of_type_Int != 4) {
        break label458;
      }
      paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramRecyclerViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramPersonalityLabelPhoto);
      break label458;
      i = 0;
      break label469;
      j = 0;
      break label479;
      break;
    }
  }
  
  void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI " + paramBoolean + " label:" + paramProfilePersonalityLabelInfo);
    }
    if (paramProfilePersonalityLabelInfo == null) {}
    Object localObject;
    int i;
    label161:
    do
    {
      return;
      if ((!this.f) && (paramProfilePersonalityLabelInfo.isCloseByUser == 1))
      {
        paramProfilePersonalityLabelInfo.personalityLabelInfos.clear();
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI guest isCloseByUser=true");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo = paramProfilePersonalityLabelInfo;
      b(paramProfilePersonalityLabelInfo);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.notifyDataSetChanged();
      a(paramProfilePersonalityLabelInfo);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
      }
      b();
      localObject = this.jdField_c_of_type_AndroidViewView;
      if ((!this.f) || (this.jdField_b_of_type_Boolean) || (!a())) {
        break;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
    } while (!paramBoolean);
    a(8, "", false);
    label235:
    label237:
    ConcurrentHashMap localConcurrentHashMap;
    long l;
    if (paramProfilePersonalityLabelInfo.unreadCount > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(Constants.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(paramProfilePersonalityLabelInfo.unreadCount) }));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new PersonalityLabelGalleryActivity.2(this));
      a(0);
      i = 0;
      if (i < this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.getSize())
      {
        localObject = (PersonalityLabelInfo)paramProfilePersonalityLabelInfo.personalityLabelInfos.get(i);
        localConcurrentHashMap = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        l = ((PersonalityLabelInfo)localObject).id;
        if (!((PersonalityLabelInfo)localObject).isComplete()) {
          break label325;
        }
      }
    }
    label325:
    for (int j = 1;; j = 0)
    {
      localConcurrentHashMap.put(Long.valueOf(l), Integer.valueOf(j));
      i += 1;
      break label237;
      break;
      i = 8;
      break label161;
      a(8);
      break label235;
    }
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
    return (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.getSize() > 0);
  }
  
  boolean a(int paramInt, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    return (this.f) && (!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (paramInt == 0);
  }
  
  void b()
  {
    int i = 0;
    if (this.f)
    {
      if (this.jdField_b_of_type_Boolean) {
        break label67;
      }
      setRightButton(2131691933, this);
      this.leftView.setVisibility(0);
      localTextView = this.rightViewText;
      if (!a()) {
        break label87;
      }
    }
    for (;;)
    {
      localTextView.setVisibility(i);
      if (!this.jdField_b_of_type_Boolean) {
        break label93;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699024);
      return;
      label67:
      setRightButton(2131692534, this);
      this.leftView.setVisibility(8);
      break;
      label87:
      i = 8;
    }
    label93:
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.f) {}
    for (i = 2131699023;; i = 2131699025)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    int k = (int)(87.0F * this.jdField_a_of_type_Float);
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount() - 1;
    int i = 0;
    Object localObject1;
    View localView;
    Object localObject2;
    boolean bool;
    if (j >= 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(j).getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder))) {
        break label224;
      }
      localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1;
      localView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).d;
      localObject2 = localView.getTag();
      if (localObject2 == null)
      {
        bool = false;
        label89:
        if (bool) {
          break label114;
        }
      }
    }
    label224:
    for (;;)
    {
      j -= 1;
      break;
      bool = ((Boolean)localObject2).booleanValue();
      break label89;
      label114:
      localObject2 = ValueAnimator.ofInt(new int[] { 0, k });
      ((ValueAnimator)localObject2).setInterpolator(new DecelerateInterpolator(1.0F));
      ((ValueAnimator)localObject2).addUpdateListener(new PersonalityLabelGalleryActivity.7(this, (ValueAnimator)localObject2, localView));
      ((ValueAnimator)localObject2).addListener(new PersonalityLabelGalleryActivity.8(this, (PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1, localView));
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).setStartDelay(i);
      ((ValueAnimator)localObject2).start();
      this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject1).jdField_a_of_type_Long));
      i += 150;
      continue;
      return;
    }
  }
  
  void d()
  {
    int i = 0;
    for (;;)
    {
      View localView;
      ImageView localImageView;
      if (i < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
      {
        localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        localObject = localView.getTag();
        if ((localObject == null) || (!(localObject instanceof PersonalityLabelGalleryActivity.LabelItemViewHolder))) {
          break label129;
        }
        localImageView = ((PersonalityLabelGalleryActivity.LabelItemViewHolder)localObject).b;
        if (localImageView != null) {}
      }
      else
      {
        return;
      }
      ObjectAnimator localObjectAnimator = (ObjectAnimator)localView.getTag(2131362208);
      Object localObject = localObjectAnimator;
      if (localObjectAnimator == null)
      {
        localObject = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 45.0F });
        ((ObjectAnimator)localObject).setDuration(100L);
        ((ObjectAnimator)localObject).addListener(new PersonalityLabelGalleryActivity.11(this, (ObjectAnimator)localObject));
        localView.setTag(2131362208, localObject);
      }
      ((ObjectAnimator)localObject).start();
      label129:
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
      } while ((paramIntent == null) || (paramIntent.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "pick photo from qzone size:" + paramIntent.size());
      }
    } while (this.jdField_a_of_type_Long <= 0L);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramIntent);
    this.jdField_b_of_type_Int = 0;
    if (NetworkUtil.g(getApplicationContext()))
    {
      this.e = false;
      h();
      return;
    }
    QQToast.a(getApplicationContext(), 0, 2131694457, 0).a();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561431);
    a(getIntent());
    this.f = this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.card.modify_personality_label");
    paramBundle.setPriority(2147483647);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370493));
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131561432, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131366359));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter = new PersonalityLabelGalleryActivity.ListViewAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131363785);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131377952));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362202));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver);
    e();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380300));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380685));
    if (this.f) {
      if (getSharedPreferences("personality_label" + this.jdField_a_of_type_JavaLangString, 0).getBoolean("tips_displayed", false)) {
        break label428;
      }
    }
    label428:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
        ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager = ((PLUploadManager)this.app.getManager(QQManagerFactory.PERSONALITY_LABELS_UPLOAD_MGR));
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(this);
      }
      a(0, "正在加载...", true);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return true;
    }
  }
  
  public void doOnDestroy()
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
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "select photos from phone album : size = " + localArrayList.size());
      }
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("label_id", 0L);
      if (this.jdField_a_of_type_Long > 0L)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        this.jdField_b_of_type_Int = 0;
        if (!NetworkUtil.g(getApplicationContext())) {
          break label126;
        }
        this.e = false;
        h();
      }
    }
    return;
    label126:
    QQToast.a(getApplicationContext(), 0, 2131694457, 0).a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public void doOnStop()
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = (ProfilePersonalityLabelInfo)paramMessage.obj;
      if (this.f) {}
      for (paramMessage = this.app.getCurrentAccountUin();; paramMessage = this.jdField_a_of_type_JavaLangString)
      {
        FileUtils.a("profile_personality_v1.2_" + paramMessage, localObject);
        return false;
      }
      if (this.jdField_c_of_type_Int == 3) {
        paramMessage = null;
      }
      while ((paramMessage != null) && (paramMessage.getSize() > 0))
      {
        int i = 0;
        while (i < paramMessage.personalityLabelInfos.size())
        {
          localObject = (PersonalityLabelInfo)paramMessage.personalityLabelInfos.get(i);
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(((PersonalityLabelInfo)localObject).id, (PersonalityLabelInfo)localObject, false);
          i += 1;
        }
        paramMessage = (ProfilePersonalityLabelInfo)FileUtils.a("profile_personality_v1.2_" + this.jdField_a_of_type_JavaLangString);
        if ((paramMessage != null) && (paramMessage.unreadCount > 0))
        {
          paramMessage.praiseCount += paramMessage.unreadCount;
          paramMessage.unreadCount = 0;
        }
      }
      runOnUiThread(new PersonalityLabelGalleryActivity.1(this, paramMessage));
      return false;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.notifyDataSetChanged();
    } while (paramMessage.arg1 != 1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a(true);
      return true;
    }
    Object localObject;
    Bundle localBundle;
    if (this.g)
    {
      if (this.jdField_c_of_type_Int != 3) {
        break label160;
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("com.tencent.mobileqq.card.modify_personality_label");
      localBundle = new Bundle();
      localBundle.putBoolean("onTagChanged", true);
      ((Intent)localObject).putExtra("key_bundle_data", localBundle);
      sendBroadcast((Intent)localObject);
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Int == 4) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 0);
        localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (ProfileActivity.AllInOne)localObject, localBundle);
        overridePendingTransition(2130771990, 2130771991);
      }
      return super.onBackEvent();
      label160:
      setResult(-1);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_b_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, PersonalityLabelShareActivity.class);
      localIntent.putExtra("data", this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo);
      startActivity(localIntent);
      ReportController.b(this.app, "dc00898", "", "", "0X8007FD4", "0X8007FD4", 0, 0, "0", "0", "", "");
      continue;
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) || (2131366318 == paramView.getId()))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8007FD3", "0X8007FD3", 0, 0, "0", "0", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.remainCount <= 0))
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
      else if (paramView == this.rightViewText)
      {
        a(true);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity
 * JD-Core Version:    0.7.0.1
 */