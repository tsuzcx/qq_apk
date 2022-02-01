package com.tencent.timi.game.trtc.roomservice.voiceroom.info;

import androidx.lifecycle.MutableLiveData;
import java.util.HashSet;

public class HashSetLiveData<T extends HashSet>
  extends MutableLiveData
{
  private HashSet a = new HashSet();
  
  public void a(Object paramObject)
  {
    this.a.add(paramObject);
    setValue(this.a);
  }
  
  public void b(Object paramObject)
  {
    this.a.remove(paramObject);
    setValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashSetLiveData
 * JD-Core Version:    0.7.0.1
 */