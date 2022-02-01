package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TroopFileManager$FileManagerStatus
{
  public int a;
  public int b;
  public boolean c;
  public int d;
  public boolean e;
  public ByteStringMicro f;
  public List<TroopFileInfo> g;
  public Map<String, TroopFileInfo> h;
  public int i;
  public long j;
  
  public TroopFileManager$FileManagerStatus(TroopFileManager paramTroopFileManager, long paramLong)
  {
    int m = 0;
    this.a = 0;
    this.c = false;
    this.e = false;
    this.b = 0;
    this.i = 0;
    this.j = 0L;
    this.f = ByteStringMicro.copyFromUtf8("");
    this.g = new ArrayList();
    this.h = new HashMap();
    if (paramLong == 0L) {
      this.d = 0;
    } else {
      m = 3;
    }
    this.d = m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus
 * JD-Core Version:    0.7.0.1
 */