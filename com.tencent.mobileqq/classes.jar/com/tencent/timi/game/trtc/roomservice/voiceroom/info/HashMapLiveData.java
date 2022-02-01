package com.tencent.timi.game.trtc.roomservice.voiceroom.info;

import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;

public class HashMapLiveData<T extends HashMap>
  extends MutableLiveData
{
  private HashMap a = new HashMap();
  private boolean b = true;
  
  public void a()
  {
    this.a.clear();
    if (this.b) {
      setValue(this.a);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.a.put(paramObject1, paramObject2);
    if (this.b) {
      setValue(this.a);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (this.b) {
      setValue(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashMapLiveData
 * JD-Core Version:    0.7.0.1
 */