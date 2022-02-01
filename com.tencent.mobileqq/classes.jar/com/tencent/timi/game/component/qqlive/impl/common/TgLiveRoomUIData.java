package com.tencent.timi.game.component.qqlive.impl.common;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.livedata.NoRepeatValueLiveData;

public class TgLiveRoomUIData
{
  private static final TgLiveRoomUIData a = new TgLiveRoomUIData();
  private final NoRepeatValueLiveData<Boolean> b;
  private final NoRepeatValueLiveData<Boolean> c;
  private final NoRepeatValueLiveData<View> d;
  private final NoRepeatValueLiveData<Boolean> e;
  private final NoRepeatValueLiveData<Integer> f;
  private final NoRepeatValueLiveData<View> g;
  private Drawable h;
  
  public TgLiveRoomUIData()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    this.b = new NoRepeatValueLiveData(localBoolean);
    this.c = new NoRepeatValueLiveData(localBoolean);
    this.d = new NoRepeatValueLiveData(null);
    this.e = new NoRepeatValueLiveData(Boolean.valueOf(true));
    this.f = new NoRepeatValueLiveData(Integer.valueOf(0));
    this.g = new NoRepeatValueLiveData(null);
  }
  
  public static TgLiveRoomUIData a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    this.f.setValue(Integer.valueOf(paramInt));
  }
  
  public void a(View paramView)
  {
    this.d.setValue(paramView);
  }
  
  public void a(GiftMessage paramGiftMessage) {}
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoIsLand isLand:");
    localStringBuilder.append(paramBoolean);
    QLog.i("TgLiveTag_TgLiveRoomUIData", 1, localStringBuilder.toString());
    this.e.setValue(paramBoolean);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateRoomLogo roomLog:");
    localStringBuilder.append(paramString);
    QLog.i("TgLiveTag_TgLiveRoomUIData", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      this.h = URLDrawable.getDrawable(paramString, null);
    }
  }
  
  public LiveData<Boolean> b()
  {
    return this.b;
  }
  
  public void b(Boolean paramBoolean)
  {
    this.c.setValue(paramBoolean);
  }
  
  public LiveData<Boolean> c()
  {
    return this.c;
  }
  
  public void c(Boolean paramBoolean)
  {
    this.b.setValue(paramBoolean);
  }
  
  public void d()
  {
    TgLiveRoomUIData localTgLiveRoomUIData = a();
    Boolean localBoolean = Boolean.valueOf(false);
    localTgLiveRoomUIData.b(localBoolean);
    localTgLiveRoomUIData.a(0);
    localTgLiveRoomUIData.a(null);
    localTgLiveRoomUIData.a(Boolean.valueOf(true));
    localTgLiveRoomUIData.c(localBoolean);
    localTgLiveRoomUIData.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData
 * JD-Core Version:    0.7.0.1
 */