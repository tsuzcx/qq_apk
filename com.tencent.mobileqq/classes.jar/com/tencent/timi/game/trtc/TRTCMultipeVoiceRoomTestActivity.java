package com.tencent.timi.game.trtc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;

public class TRTCMultipeVoiceRoomTestActivity
  extends TimiGameBaseActivity
{
  private TRTCMultipeVoiceRoomManager a;
  private EditText b;
  private EditText c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private TextView h;
  private TextView i;
  
  private void c()
  {
    this.a.a.observeForever(new TRTCMultipeVoiceRoomTestActivity.5(this));
    this.a.b.observeForever(new TRTCMultipeVoiceRoomTestActivity.6(this));
  }
  
  private void d()
  {
    TimiGameQQTrtcUtil.a(new TRTCMultipeVoiceRoomTestActivity.7(this));
  }
  
  private String e()
  {
    return this.b.getText().toString();
  }
  
  private String f()
  {
    return this.c.getText().toString();
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
    d();
    setContentView(2131629460);
    this.a = TRTCMultipeVoiceRoomManager.a();
    this.b = ((EditText)findViewById(2131445124));
    this.c = ((EditText)findViewById(2131449227));
    this.d = ((Button)findViewById(2131432559));
    this.e = ((Button)findViewById(2131432652));
    this.f = ((Button)findViewById(2131438165));
    this.g = ((Button)findViewById(2131446205));
    this.h = ((TextView)findViewById(2131437903));
    this.i = ((TextView)findViewById(2131445125));
    c();
    this.d.setOnClickListener(new TRTCMultipeVoiceRoomTestActivity.1(this));
    this.e.setOnClickListener(new TRTCMultipeVoiceRoomTestActivity.2(this));
    this.f.setOnClickListener(new TRTCMultipeVoiceRoomTestActivity.3(this));
    this.g.setOnClickListener(new TRTCMultipeVoiceRoomTestActivity.4(this));
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    TimiGameQQTrtcUtil.a();
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity
 * JD-Core Version:    0.7.0.1
 */