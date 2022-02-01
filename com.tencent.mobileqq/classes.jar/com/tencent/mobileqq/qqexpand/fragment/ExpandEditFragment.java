package com.tencent.mobileqq.qqexpand.fragment;

import QC.SuixintieCheckItem;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.widget.QzoneEmotionUtils;

public class ExpandEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener
{
  public int a = 0;
  public AudioInfo b;
  BounceScrollView c;
  TextView d;
  LinearLayout e;
  ExpandProfileEditFragment f;
  ExtendFriendInfo g;
  private FrameLayout h;
  private boolean i = true;
  private int j = 0;
  private final SuixintieCheckItem k = new SuixintieCheckItem();
  private final SuixintieCheckItem l = new SuixintieCheckItem();
  private String m;
  private boolean n = false;
  private QBaseActivity o;
  private QQAppInterface p;
  private FragmentManager q;
  private QQProgressDialog r;
  private GestureDetector s;
  private final GestureDetector.OnGestureListener t = new ExpandEditFragment.1(this);
  private final TransProcessorHandler u = new ExpandEditFragment.2(this);
  
  private void a(View paramView)
  {
    ((TextView)paramView.findViewById(2131436180)).setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131436211));
    this.d.setOnClickListener(this);
    if (ThemeUtil.isInNightMode(this.p)) {
      this.d.setTextColor(-16777216);
    }
    this.r = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
    this.r.c(true);
    this.c = ((BounceScrollView)paramView.findViewById(2131431349));
    this.s = new GestureDetector(getQBaseActivity(), this.t);
  }
  
  private void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((ExpandProfileEditFragment)localObject).f();
    }
    localObject = this.b;
    if ((localObject != null) && (!TextUtils.isEmpty(((AudioInfo)localObject).path)))
    {
      this.r.show();
      a(this.b.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void a(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 23;
    ((ITransFileController)this.p.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void b()
  {
    this.f = new ExpandProfileEditFragment();
    this.f.a(this);
    this.q.beginTransaction().add(2131431349, this.f).commit();
    this.g = ((ExtendFriendInfo)this.o.getIntent().getParcelableExtra("key_extend_friend_info"));
    ExtendFriendInfo localExtendFriendInfo = this.g;
    if (localExtendFriendInfo != null) {
      this.f.a(localExtendFriendInfo);
    }
  }
  
  private void b(ExtendFriendInfo paramExtendFriendInfo)
  {
    Intent localIntent = this.o.getIntent();
    localIntent.putExtra("key_extend_friend_info", paramExtendFriendInfo);
    this.o.setResult(5003, localIntent);
    this.o.finish();
  }
  
  public void a()
  {
    String str;
    if (this.f.b.getText() == null) {
      str = "";
    } else {
      str = this.f.b.getText().toString();
    }
    this.f.c.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(str), 3, 24));
    this.f.b.setVisibility(8);
    this.f.c.setVisibility(0);
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt1 != 1003) {
      return;
    }
    this.b = ((AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    this.f.a(this.b);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult audio_back path: ");
      paramIntent.append(this.b.path);
      QLog.i("ExtendFriendProfileEdit", 2, paramIntent.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.o != null)
    {
      Object localObject = this.f;
      if ((localObject != null) && (((ExpandProfileEditFragment)localObject).c()))
      {
        localObject = DialogUtil.a(this.o, 0, null, HardCodeUtil.a(2131902267), HardCodeUtil.a(2131902287), HardCodeUtil.a(2131902282), new ExpandEditFragment.3(this), new ExpandEditFragment.4(this));
        this.f.f();
        ((QQCustomDialog)localObject).show();
        return true;
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if (i1 != 2131436211) {
        return;
      }
      paramView = this.f;
      if (paramView == null) {
        return;
      }
      paramView = paramView.b();
      if ((!TextUtils.isEmpty(paramView.a)) && (paramView.a.length() < 10))
      {
        QQToast.makeText(getQBaseActivity(), "请小主至少填满10个字", 0).show();
        this.f.b.requestFocus();
        return;
      }
      if ((!TextUtils.isEmpty(paramView.a)) && (!this.f.a(paramView.a)))
      {
        paramView = DialogUtil.a(this.o, 0, null, HardCodeUtil.a(2131889078), HardCodeUtil.a(2131889077), HardCodeUtil.a(2131889076), new ExpandEditFragment.7(this), new ExpandEditFragment.8(this, paramView));
        this.f.f();
        paramView.show();
        return;
      }
      a(paramView);
      return;
    }
    if (this.o != null)
    {
      ReportController.b(this.p, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
      paramView = this.f;
      if ((paramView != null) && (paramView.c()))
      {
        paramView = DialogUtil.a(this.o, 0, null, HardCodeUtil.a(2131902291), HardCodeUtil.a(2131902271), HardCodeUtil.a(2131902305), new ExpandEditFragment.5(this), new ExpandEditFragment.6(this));
        this.f.f();
        paramView.show();
        return;
      }
      this.o.doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = getQBaseActivity();
    this.p = ((QQAppInterface)this.o.getAppRuntime());
    this.q = getChildFragmentManager();
    paramBundle = this.o.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setSoftInputMode(16);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627423, null);
    a(paramLayoutInflater);
    b();
    this.u.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.p.getRuntimeService(ITransFileController.class)).addHandle(this.u);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((ITransFileController)this.p.getRuntimeService(ITransFileController.class)).removeHandle(this.u);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131432625)
    {
      paramView = this.f;
      if ((paramView != null) && (paramView.e()))
      {
        this.c.requestDisallowInterceptTouchEvent(true);
        if (paramMotionEvent.getAction() == 1) {
          this.c.requestDisallowInterceptTouchEvent(false);
        }
        return false;
      }
    }
    this.s.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandEditFragment
 * JD-Core Version:    0.7.0.1
 */