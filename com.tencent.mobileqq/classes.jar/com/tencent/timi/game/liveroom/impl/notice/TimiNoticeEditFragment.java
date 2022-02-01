package com.tencent.timi.game.liveroom.impl.notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import org.jetbrains.annotations.NotNull;

public class TimiNoticeEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private View a;
  private ImageView b;
  private TextView c;
  private EditText d;
  private String e;
  private long f;
  private long g;
  
  private void a()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getIntent();
    if (localObject == null) {
      return;
    }
    this.e = ((Intent)localObject).getStringExtra("key_notice_content");
    this.f = ((Intent)localObject).getLongExtra("key_room_id", 0L);
    this.g = ((Intent)localObject).getLongExtra("key_anchor_id", 0L);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent(paramContext, TimiNoticeEditFragment.class);
    localIntent.putExtra("key_notice_content", paramString);
    localIntent.putExtra("key_room_id", paramLong1);
    localIntent.putExtra("key_anchor_id", paramLong2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivityForTool.class, TimiNoticeEditFragment.class);
  }
  
  private void a(String paramString)
  {
    this.c.setEnabled(b(paramString));
  }
  
  private void b()
  {
    this.b = ((ImageView)this.a.findViewById(2131439436));
    this.c = ((TextView)this.a.findViewById(2131439437));
    this.d = ((EditText)this.a.findViewById(2131439438));
    InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(100);
    this.d.setFilters(new InputFilter[] { localLengthFilter });
    this.b.setColorFilter(-1);
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return TextUtils.isEmpty(paramString.replace("\r\n", "").replace("\n", "").replace(" ", "")) ^ true;
  }
  
  private void c()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.addTextChangedListener(new TimiNoticeEditFragment.1(this));
  }
  
  private void d()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      this.d.setText(this.e);
      this.d.setSelection(this.e.length());
    }
    this.d.postDelayed(new TimiNoticeEditFragment.2(this), 400L);
    a(this.e);
  }
  
  private void e()
  {
    g();
  }
  
  private void f()
  {
    String str = this.d.getText().toString();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    ILiveRoomOperation localILiveRoomOperation = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(this.f);
    if (localILiveRoomOperation != null) {
      localILiveRoomOperation.setRoomAnnounce(this.f, this.g, str, new TimiNoticeEditFragment.3(this));
    }
  }
  
  private void g()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131439436) {
      e();
    } else if (paramView.getId() == 2131439437) {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(@NonNull @NotNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131629452, paramViewGroup, false);
    a();
    b();
    c();
    d();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeEditFragment
 * JD-Core Version:    0.7.0.1
 */